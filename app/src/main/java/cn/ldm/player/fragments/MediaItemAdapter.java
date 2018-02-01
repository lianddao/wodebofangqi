package cn.ldm.player.fragments;

import android.app.Activity;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
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

import java.util.List;

import cn.ldm.player.R;
import cn.ldm.player.dialog.FireMissilesDialogFragment;
import cn.ldm.player.services.MyMediaBrowserService;


public class MediaItemAdapter extends RecyclerView.Adapter<MediaItemAdapter.ViewHolder> {

    private static final String TAG = MediaItemAdapter.class.getSimpleName();
    private final List<MediaItem> mValues;
    private final OnMediaItemClickListener mListener;
    private Context _context;
    private ViewGroup _viewGroup;

    public MediaItemAdapter(List<MediaItem> items, OnMediaItemClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        _context = parent.getContext();
        _viewGroup = parent;

        ((Activity) _context).getMediaController().registerCallback(new MediaController.Callback() {
            @Override
            public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                Log.i(TAG, "onMetadataChanged: ");
                //                View img = parent.findViewWithTag(currentPlayingIndex).findViewById(R.id.imgCurrentTag);
                //                if (currentPlayingIndex > 0) {
                //                    img.setVisibility(View.INVISIBLE);
                //                }
                //                for (MediaItem i : mValues) {
                //                    if (i.getMediaId().equals(metadata.getDescription().getMediaId())) {
                //                        currentPlayingIndex = mValues.indexOf(i);
                //                        img.setVisibility(View.VISIBLE);
                //                        img.setTag(currentPlayingIndex);
                //                    }
                //                }
            }

            @Override
            public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                //                if (currentPlayingIndex > 0) {
                //                    ImageView img = (ImageView) parent.findViewWithTag(currentPlayingIndex).findViewById(R.id.imgCurrentTag);
                //                    img.setVisibility(View.VISIBLE);
                //                    switch (state.getState()) {
                //                        case PlaybackState.STATE_PAUSED:
                //                            img.setImageResource(android.R.drawable.ic_media_play);
                //                            break;
                //                        case PlaybackState.STATE_PLAYING:
                //                            img.setImageResource(android.R.drawable.ic_media_pause);
                //                            break;
                //                        default:
                //                            break;
                //                    }
                //
                //                }
            }
        });

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_media_browser_item, parent, false);
        return new ViewHolder(view);
    }

    int index = -1;

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final MediaItem item = mValues.get(position);
        holder.mMediaItem = item;
        holder.mContentView.setText(item.getDescription().getTitle().toString());
        holder._imageView.setVisibility(View.INVISIBLE);

        //region holder.mView.setOnClickListener
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.mMediaItem.isPlayable()) {
                    Log.i(TAG, "onClick: 当前播放的位置 " + position);
                    if (index > -1) {
                        View oldSelectedView = _viewGroup.findViewWithTag("SELECTED");
                        if (oldSelectedView != null) {
                            oldSelectedView.setVisibility(View.INVISIBLE);
                            oldSelectedView.setTag(null);
                        } else {
                            Log.i(TAG, "onClick: 旧视图已在屏幕之外");
                        }
                    }
                    index = position;
                    holder._imageView.setVisibility(View.VISIBLE);
                    holder._imageView.setTag("SELECTED");
                    String mediaId = MyMediaBrowserService.filterMediaId(holder.mMediaItem.getMediaId());
                    ((Activity) _context).getMediaController().getTransportControls().playFromMediaId(mediaId, null);
                } else {
                    mListener.onClick(holder.mMediaItem);
                }
            }
        });
        //endregion

        //region holder.mView.setOnLongClickListener
        if (item.isPlayable()) {
            holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Log.i(TAG, "onLongClick: ");
                    Activity activity = (Activity) holder.mView.getContext();
                    FireMissilesDialogFragment fireMissilesDialogFragment = new FireMissilesDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("MUSIC-ID", item.getMediaId());
                    fireMissilesDialogFragment.setArguments(bundle);
                    fireMissilesDialogFragment.show(activity.getFragmentManager(), "XXX");
                    return true;
                }
            });
        }
        //endregion

        //region 加入当前播放指示
        Activity activity = (Activity) _context;
        //        if (activity != null && activity.getMediaController() != null) {
        if (activity != null && activity.getMediaController().getMetadata() != null) {
            if (index == position) {
                holder._imageView.setVisibility(View.VISIBLE);
            }
        }
        //endregion
    }

    @DrawableRes
    private static final int RES_PLAYING = android.R.drawable.ic_media_play;

    //    private ViewHolder currentViewHolder;


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public final ImageView _imageView;
        public MediaItem mMediaItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
            _imageView = (ImageView) view.findViewById(R.id.imgCurrentTag);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

    // 声明项单击事件接口,详情交由外者去实现
    public interface OnMediaItemClickListener {
        void onClick(MediaItem mediaItem);
    }
}
