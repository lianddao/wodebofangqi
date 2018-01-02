package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.view.ViewGroup;
import com.songbirdnest.mediaplayer.Constants;

public class ArtistAlbumDetailView extends AlbumDetailView {
    protected static final String VIEW_CATEGORY = "music:artists";

    public ArtistAlbumDetailView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_ARTIST_ALBUM_DETAILS);
        setViewCategory(VIEW_CATEGORY);
    }
}
