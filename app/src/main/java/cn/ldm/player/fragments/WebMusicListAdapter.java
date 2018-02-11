package cn.ldm.player.fragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.ldm.player.R;
import cn.ldm.player.core.MusicScanner;
import cn.ldm.player.core.maicong.KuGou;
import cn.ldm.player.dialog.FireMissilesDialogFragment;
import cn.ldm.player.services.MyMediaBrowserService;

/**
 * Created by LDM on 2018.02.11.0011.
 */

public class WebMusicListAdapter extends RecyclerView.Adapter<WebMusicListAdapter.ViewHolder> {

    private static final String TAG = WebMusicListAdapter.class.getSimpleName();
    private final List<MediaBrowser.MediaItem> mValues;
    private Activity _activity;
    private ViewGroup _viewGroup;
    private int index = -1;


    public WebMusicListAdapter(Activity activity, List<MediaBrowser.MediaItem> items) {
        _activity = activity;
        mValues = items;
    }


    @Override
    public WebMusicListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        _viewGroup = parent;
        return new WebMusicListAdapter.ViewHolder(LayoutInflater.from(_activity).inflate(R.layout.fragment_media_browser_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final WebMusicListAdapter.ViewHolder holder, final int position) {
        final MediaBrowser.MediaItem item = mValues.get(position);
        holder.mMediaItem = item;
        if (item.isPlayable()) {
            //            holder._view.setTag(MyMediaBrowserService.filterMediaId(item));
            String id = mValues.get(position).getMediaId();
            Log.i(TAG, "onBindViewHolder: " + id);
        }
        holder._txtTitle.setText(item.getDescription().getTitle().toString());
        holder._imgAlbum.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        return mValues.size();
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
                    new KuGou().getSongById(mMediaItem.getMediaId(), new KuGou.Callback() {
                        @Override
                        public void onPostExecute(Object result) {
                            Log.i(TAG, result.toString());
                            // TODO: 2018.02.11.0011 解析
                            Uri uri = Uri.parse("http://fs.open.kugou" +
                                    ".com/dfd3ad17ac0d8861ffffbbceed71fe59/5a7fdde0/G118/M09/18/1F/tg0DAFobgyOAJ4ndADYgL0FdOx8580.mp3");
                            _activity.getMediaController().getTransportControls().playFromUri(uri, null);
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
