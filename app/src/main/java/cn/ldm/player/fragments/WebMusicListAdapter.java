package cn.ldm.player.fragments;

import android.app.Activity;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.ldm.player.R;
import cn.ldm.player.core.maicong.KuGou;
import cn.ldm.player.services.MyMediaBrowserService;

public class WebMusicListAdapter extends RecyclerView.Adapter<WebMusicListAdapter.ViewHolder> {

    private static final String TAG = WebMusicListAdapter.class.getSimpleName();
    private final List<MediaBrowser.MediaItem> _mediaItems;
    private Activity _activity;

    public WebMusicListAdapter(Activity activity, List<MediaBrowser.MediaItem> items) {
        _activity = activity;
        _mediaItems = items;
    }

    @Override
    public WebMusicListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WebMusicListAdapter.ViewHolder(
                LayoutInflater.from(_activity).inflate(R.layout.fragment_media_browser_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final WebMusicListAdapter.ViewHolder holder, final int position) {
        final MediaBrowser.MediaItem item = _mediaItems.get(position);
        holder.mMediaItem = item;
        holder._txtTitle.setText(item.getDescription().getTitle().toString());
        holder._imgAlbum.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return _mediaItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View _view;
        public final TextView _txtTitle;
        public final ImageView _imgAlbum;
        public MediaBrowser.MediaItem mMediaItem;

        public ViewHolder(View view) {
            super(view);
            _view = view;
            _txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            _imgAlbum = (ImageView) view.findViewById(R.id.imgCurrentTag);
            _view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new KuGou().getSongById(mMediaItem, new KuGou.Callback() {
                        @Override
                        public void onPostExecute(Object result) {
                            String json = result.toString();
                            MediaMetadata metadata = KuGou.resolve(_activity, json).getMediaMetadata();
                            MyMediaBrowserService.getRunningInstance().setCurrentMediaMetadata(metadata, PlaybackState.STATE_BUFFERING);

                            //region 加入队列
                            MediaSession mediaSession = MyMediaBrowserService.getRunningInstance().getSession();
                            List<MediaSession.QueueItem> list = new ArrayList<>();
                            for (int i = 0; i < _mediaItems.size(); i++) {
                                MediaBrowser.MediaItem item = _mediaItems.get(i);
                                MediaSession.QueueItem queueItem = new MediaSession.QueueItem(
                                        item.getDescription(), Long.valueOf(item.getMediaId()));
                                list.add(queueItem);
                            }
                            mediaSession.setQueue(list);
                            //endregion

                            mediaSession.setMetadata(metadata);
                            mediaSession.setPlaybackState(new PlaybackState.Builder()
                                    .setState(PlaybackState.STATE_BUFFERING, -1, 1.0f)
                                    .setActiveQueueItemId(Long.valueOf(metadata.getDescription().getMediaId()))
                                    .build()
                            );

                            _activity.getMediaController().getTransportControls()
                                    .playFromUri(Uri.parse(metadata.getString(MediaMetadata.METADATA_KEY_ART_URI)), null);
                        }
                    });
                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + " '" + _txtTitle.getText() + "'";
        }
    }

}
