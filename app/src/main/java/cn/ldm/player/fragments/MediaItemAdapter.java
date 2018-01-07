package cn.ldm.player.fragments;

import android.media.browse.MediaBrowser.MediaItem;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.ldm.player.R;


public class MediaItemAdapter extends RecyclerView.Adapter<MediaItemAdapter.ViewHolder> {

    private final List<MediaItem> mValues;
    private final OnMediaItemClickListener mListener;

    public MediaItemAdapter(List<MediaItem> items, OnMediaItemClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    public MediaItemAdapter(List<MediaItem> items) {
        mValues = items;
        mListener = null;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_media_browser_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mMediaItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getMediaId());
        holder.mContentView.setText(mValues.get(position).getDescription().getTitle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onClick(holder.mMediaItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public MediaItem mMediaItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

    public interface OnMediaItemClickListener {
        void onClick(MediaItem mediaItem);
    }
}
