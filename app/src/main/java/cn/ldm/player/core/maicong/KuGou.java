package cn.ldm.player.core.maicong;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import cn.ldm.player.MediaMetadataWrapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class KuGou {

    private static final String TAG = KuGou.class.getSimpleName();
    private static final String MEDIA_URL = "http://m.kugou.com/app/i/getSongInfo.php?cmd=playInfo&hash=";

    public KuGou() {}

    public static void main(Callback callback) {
        KuGouAsyncTask asyncTask = new KuGouAsyncTask(callback);
        asyncTask.execute();
    }

    public static MediaMetadataWrapper resolve(Context context, final String json) {
        Future<MediaMetadataWrapper> future = Executors.newCachedThreadPool().submit(new Callable<MediaMetadataWrapper>() {
            @Override
            public MediaMetadataWrapper call() throws Exception {
                JSONObject jo = new JSONObject(json);
                try {
                    String hash = jo.getString("hash");
                    long mediaId = hash.hashCode();
                    String title = jo.getString("songName");
                    String artist = jo.getString("singerName");
                    String album = jo.getString("albumid");
                    String data = jo.getString("url");
                    String albumArt = jo.getString("album_img").replace("{size}", "150");

                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request request = new Request.Builder().url(albumArt).build();
                    Response response = okHttpClient.newCall(request).execute();
                    Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());

                    MediaMetadata metadata = new MediaMetadata.Builder()
                            .putString("HASH", hash)
                            .putString("URL", data)
                            .putString(MediaMetadata.METADATA_KEY_MEDIA_ID, String.valueOf(mediaId))
                            .putString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE, title)
                            .putString(MediaMetadata.METADATA_KEY_DISPLAY_SUBTITLE, artist)
                            .putString(MediaMetadata.METADATA_KEY_ALBUM, album)
                            .putString(MediaMetadata.METADATA_KEY_ARTIST, artist)
                            .putString(MediaMetadata.METADATA_KEY_ART_URI, data)
                            .putLong(MediaMetadata.METADATA_KEY_DURATION, -1)
                            .putBitmap(MediaMetadata.METADATA_KEY_ART, bitmap)
                            .build();
                    return MediaMetadataWrapper.make(metadata, MediaMetadataWrapper.Type.WEB);
                } catch (JSONException ex) {
                    return null;
                }
            }
        });

        try {
            MediaMetadataWrapper result = future.get();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }


    public void getSongById(MediaBrowser.MediaItem mediaItem, final Callback callback) {
        GetSongInfoAsyncTask asyncTask = new GetSongInfoAsyncTask(mediaItem.getDescription().getDescription().toString(), callback);
        asyncTask.execute(mediaItem.getDescription().getMediaUri());
    }

    public void getSongById(MediaSession.QueueItem queueItem, Callback callback) {
        GetSongInfoAsyncTask asyncTask = new GetSongInfoAsyncTask(queueItem.getDescription().getDescription().toString(), callback);
        asyncTask.execute(queueItem.getDescription().getMediaUri());
    }

    public interface Callback {
        void onPostExecute(Object result);
    }

    private static class KuGouAsyncTask extends AsyncTask<String, Integer, String> {

        private Callback _callback;

        public KuGouAsyncTask(Callback callback) {
            _callback = callback;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url("http://www.kugou.com/yy/html/rank.html").build();
                Response response = okHttpClient.newCall(request).execute();
                Elements scripts = Jsoup.parse(response.body().string()).getElementsByTag("script");
                org.jsoup.nodes.Element script = scripts.get(scripts.size() - 1);
                return RegexMatches.kuGouMain(script.toString());
            } catch (IOException ex) {
                throw new RuntimeException(ex.toString() + " , " + "获取酷狗排行榜时发生错误");
            }
        }

        @Override
        protected void onPostExecute(String s) {
            List<MediaBrowser.MediaItem> result = null;
            try {
                JSONArray dataArray = new JSONArray(s);
                result = new ArrayList<>(dataArray.length());
                MediaDescription.Builder builder = new MediaDescription.Builder();
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject json = dataArray.getJSONObject(i);
                    String hash = json.getString("Hash");
                    builder.setMediaId(String.valueOf(hash.hashCode()))
                            .setMediaUri(Uri.parse(MEDIA_URL + hash))
                            .setTitle(json.getString("FileName"))
                            .setDescription(hash);
                    MediaBrowser.MediaItem item = new MediaBrowser.MediaItem(builder.build(), MediaBrowser.MediaItem.FLAG_PLAYABLE);
                    result.add(item);
                }
            } catch (JSONException ex) {
                throw new RuntimeException(ex.toString());
            }
            _callback.onPostExecute(result);
        }
    }

    public static MediaMetadata getSongInfo(Context context, MediaSession.QueueItem queueItem) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(queueItem.getDescription().getMediaUri().toString())
                .addHeader("referer", "http://m.kugou.com/play/info/" + queueItem.getDescription().getDescription())
                .addHeader("proxy", "false")
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            String json = response.body().string();
            MediaMetadata metadata = KuGou.resolve(context, json).getMediaMetadata();
            return metadata;
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    private class GetSongInfoAsyncTask extends AsyncTask<Uri, Integer, String> {
        private String _hash;
        private Callback _callback;

        private GetSongInfoAsyncTask(String hash, Callback callback) {
            _hash = hash;
            _callback = callback;
        }

        @Override
        protected String doInBackground(Uri... uris) {
            final Uri uri = uris[0];
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(uri.toString())
                    .addHeader("referer", "http://m.kugou.com/play/info/" + _hash)
                    .addHeader("proxy", "false")
                    .build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (Exception ex) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            _callback.onPostExecute(s);
        }
    }
}
