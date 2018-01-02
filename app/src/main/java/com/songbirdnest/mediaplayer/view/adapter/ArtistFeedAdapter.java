package com.songbirdnest.mediaplayer.view.adapter;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter.AccessDelegate;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter.SystemDelegate;
import com.songbirdnest.mediaplayer.view.adapter.FriendAdapter.ViewWrapper;
import com.songbirdnest.mediaplayer.widgets.AnimationImage;

public class ArtistFeedAdapter extends FeedAdapter {
    public ArtistFeedAdapter(LayoutInflater pInflator, Resources pResources, SystemDelegate pSystem, AccessDelegate pDelegate) {
        super(pInflator, pResources, pSystem, pDelegate);
    }

    protected View getEmptyView(View convertView, ViewGroup parent) {
        return this.mInflator.inflate(C0116R.layout.artist_no_feed, parent, false);
    }

    protected View getLoadingView(View convertView, ViewGroup parent) {
        convertView = this.mInflator.inflate(C0116R.layout.face_item, parent, false);
        ViewWrapper aWrapper = new ViewWrapper(convertView);
        LayoutParams layoutParams = aWrapper.mImage.getLayoutParams();
        layoutParams.width = 60;
        layoutParams.height = 60;
        aWrapper.mImage.setPadding(0, (int) (10.0f * this.mResource.getDisplayMetrics().density), 0, 0);
        AnimationDrawable aAnimation = (AnimationDrawable) this.mResource.getDrawable(C0116R.drawable.spinner);
        aWrapper.mImage.setImageDrawable(aAnimation);
        aWrapper.mImage.setBackgroundDrawable(null);
        aWrapper.mText.setText(C0116R.string.artist_feed_loading);
        ((AnimationImage) aWrapper.mImage).setAnimation(aAnimation);
        return convertView;
    }
}
