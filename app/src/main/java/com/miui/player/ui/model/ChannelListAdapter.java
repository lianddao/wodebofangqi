package com.miui.player.ui.model;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.plugin.onlinemusic2.Channel;
import com.miui.player.plugin.onlinemusic2.ChannelList;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.fragment.AsyncFragment.DataAdapter;

public class ChannelListAdapter extends DataAdapter<Channel, ChannelList> {
    private final LayoutInflater mInflater;

    static class ViewHolder {
        public final ImageView mImageViewIndicator;
        public final TextView mTextViewTitle;

        public ViewHolder(View v) {
            this.mTextViewTitle = (TextView) v.findViewById(C0329R.id.title);
            this.mImageViewIndicator = (ImageView) v.findViewById(C0329R.id.play_indicator);
        }
    }

    public ChannelListAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = this.mInflater.inflate(C0329R.layout.channel_item, null);
            view.setTag(new ViewHolder(view));
        }
        String title = ((Channel) ((ChannelList) this.mData).get(position)).mOutline.mTitle;
        ViewHolder vh = (ViewHolder) view.getTag();
        vh.mTextViewTitle.setText(title);
        ImageView iv = vh.mImageViewIndicator;
        if (TextUtils.equals(ServiceHelper.getChannelName(), title)) {
            iv.setSelected(ServiceHelper.isPlaying());
        } else {
            iv.setImageDrawable(null);
        }
        return view;
    }
}
