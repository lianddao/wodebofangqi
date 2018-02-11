package cn.ldm.player.core.maicong;


import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class KuGou {

    private static final String TAG = KuGou.class.getSimpleName();
    private Callback _callback;

    public KuGou(){}

    public KuGou(Callback callback) {
        _callback = callback;
        KuGouAsyncTask asyncTask = new KuGouAsyncTask();
        asyncTask.execute();
    }

    public void getSongById(String id, final Callback callback) {
        final String hash = id;
        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://m.kugou.com/app/i/getSongInfo.php?cmd=playInfo&hash=" + hash)
                        .addHeader("referer", "http://m.kugou.com/play/info/" + hash)
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
            protected void onPostExecute(Object o) {
                callback.onPostExecute(o);
            }
        };
        asyncTask.execute();
    }

    public interface Callback {
        void onPostExecute(Object result);
    }

    private class KuGouAsyncTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url("http://www.kugou.com/yy/html/rank.html").build();
                Response response = okHttpClient.newCall(request).execute();
                Elements scripts = Jsoup.parse(response.body().string()).getElementsByTag("script");
                org.jsoup.nodes.Element script = scripts.get(scripts.size() - 1);
                return RegexMatches.kuGouMain(script.toString());
            } catch (Exception ex) {
                return ex.toString();
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
                    builder.setMediaId(json.getString("Hash"))
                            .setTitle(json.getString("FileName"));
                    MediaBrowser.MediaItem item = new MediaBrowser.MediaItem(builder.build(), MediaBrowser.MediaItem.FLAG_PLAYABLE);
                    result.add(item);
                }
            } catch (Exception ex) {
            }
            _callback.onPostExecute(result);
        }
    }

    private class SongInfoAsyncTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... s) {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://m.kugou.com/app/i/getSongInfo.php?cmd=playInfo&hash=" + s)
                    .addHeader("referer", "http://m.kugou.com/play/info/" + s)
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
            super.onPostExecute(s);
        }
    }
}
