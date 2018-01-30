package cn.ldm.player.fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.ldm.player.R;
import cn.ldm.player.dialog.FireMissilesDialogFragment;
import cn.ldm.player.menu.CreateNewPlaylist;


public class MediaItemAdapter extends RecyclerView.Adapter<MediaItemAdapter.ViewHolder> {

    private static final String TAG = MediaItemAdapter.class.getSimpleName();
    private final List<MediaItem> mValues;
    private final OnMediaItemClickListener mListener;

    public MediaItemAdapter(List<MediaItem> items, OnMediaItemClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_media_browser_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final MediaItem item = mValues.get(position);
        holder.mMediaItem = item;
        holder.mContentView.setText(item.getDescription().getTitle().toString());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onClick(holder.mMediaItem);//单击播放
                }
            }
        });

        if (item.isPlayable()) {
            //region 长按加入播放列表
            holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Log.i(TAG, "onLongClick: ");
                    Activity activity = (Activity) holder.mView.getContext();
                    FireMissilesDialogFragment fireMissilesDialogFragment=new FireMissilesDialogFragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("MUSIC-ID",item.getMediaId());
                    fireMissilesDialogFragment.setArguments(bundle);
                    fireMissilesDialogFragment.show(activity.getFragmentManager(),"XXX");
                    return true;
                }
            });
            //endregion
        }
    }



    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public MediaItem mMediaItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
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
