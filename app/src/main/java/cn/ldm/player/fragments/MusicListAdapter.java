package cn.ldm.player.fragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaController;
import android.media.session.MediaSession;
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

import cn.ldm.player.MainActivity;
import cn.ldm.player.R;
import cn.ldm.player.dialog.FireMissilesDialogFragment;
import cn.ldm.player.services.MyMediaBrowserService;


public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private static final String TAG = MusicListAdapter.class.getSimpleName();
    private final List<MediaItem> mValues;
    private Activity _activity;
    private ViewGroup _viewGroup;
    private int index = -1;

    public MusicListAdapter(Activity activity, List<MediaItem> items) {
        _activity = activity;
        mValues = items;
        MediaController controller = _activity.getMediaController();
        if (controller == null) {
            Log.e(TAG, "MusicListAdapter: ");
        }

        _activity.getMediaController().registerCallback(new MediaController.Callback() {
            @Override
            public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                View oldSelectedView = _viewGroup.findViewWithTag("SELECTED");
                if (oldSelectedView != null) {
                    oldSelectedView.setVisibility(View.INVISIBLE);
                    oldSelectedView.setTag(null);
                }

                View newSelectedView = _viewGroup.findViewWithTag(metadata.getDescription().getMediaId());
                if (newSelectedView != null) {
                    View tagView = newSelectedView.findViewById(R.id.imgCurrentTag);
                    tagView.setVisibility(View.VISIBLE);
                    tagView.setTag("SELECTED");
                    index = _viewGroup.indexOfChild(newSelectedView);
                }
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

            @Override
            public void onQueueChanged(@Nullable List<MediaSession.QueueItem> queue) {
                super.onQueueChanged(queue);
            }
        });
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        _viewGroup = parent;
        return new ViewHolder(LayoutInflater.from(_activity).inflate(R.layout.fragment_media_browser_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final MediaItem item = mValues.get(position);
        holder.mMediaItem = item;
        if (item.isPlayable()) {
            holder._view.setTag(MyMediaBrowserService.filterMediaId(item));
        }
        holder._txtTitle.setText(item.getDescription().getTitle().toString());
        holder._imgAlbum.setVisibility(View.INVISIBLE);

        //region holder._view.setOnClickListener
        holder._view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.mMediaItem.isPlayable()) {
                    //                    if (index > -1) {
                    //                        View oldSelectedView = _viewGroup.findViewWithTag("SELECTED");
                    //                        if (oldSelectedView != null) {
                    //                            oldSelectedView.setVisibility(View.INVISIBLE);
                    //                            oldSelectedView.setTag(null);
                    //                        } else {
                    //                            Log.i(TAG, "onClick: 旧视图已在屏幕之外");
                    //                        }
                    //                    }
                    //                    index = position;
                    //                    holder._imgAlbum.setVisibility(View.VISIBLE);
                    //                    holder._imgAlbum.setTag("SELECTED");
                    index = position;
                    String mediaId = MyMediaBrowserService.filterMediaId(holder.mMediaItem.getMediaId());
                    _activity.getMediaController().getTransportControls().playFromMediaId(mediaId, null);
                } else {
                    FragmentTransaction transaction = _activity.getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, MusicListFragment.newInstance(holder.mMediaItem));
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        //endregion

        //region holder._view.setOnLongClickListener
        if (item.isPlayable()) {
            holder._view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Log.i(TAG, "onLongClick: ");
                    Activity activity = (Activity) holder._view.getContext();
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
        MediaMetadata metadata = _activity.getMediaController().getMetadata();
        if (metadata!=null && metadata.getDescription().getMediaId().equals(holder._view.getTag())){
            holder._imgAlbum.setVisibility(View.VISIBLE);
            holder._imgAlbum.setTag("SELECTED");
        }
        //endregion
    }

    @DrawableRes
    private static final int RES_PLAYING = android.R.drawable.ic_media_play;


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    // MusicList's Adapter
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View _view;
        public final TextView _txtTitle;
        public final ImageView _imgAlbum;
        public MediaItem mMediaItem;

        public ViewHolder(View view) {
            super(view);
            _view = view;
            _txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            _imgAlbum = (ImageView) view.findViewById(R.id.imgCurrentTag);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + _txtTitle.getText() + "'";
        }
    }

}
