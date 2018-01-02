package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.widget.ImageView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.facebook.FacebookAPICallback;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.util.MediaUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class MiniPlayerFacebookCallback implements FacebookAPICallback {
    private static final int STATE_LIKED = 1;
    private static final int STATE_NOT_LIKED = 0;
    private Activity mActivity;
    protected String mArtistName;
    private String mRequestType;
    protected int mTrackID;
    protected String mTrackName;

    public MiniPlayerFacebookCallback(Activity aActivity, String aRequestType) {
        this.mActivity = aActivity;
        this.mRequestType = aRequestType;
    }

    public MiniPlayerFacebookCallback(Activity aActivity, String aRequestType, String pArtistName, String pTrackName, int pTrackID) {
        this.mActivity = aActivity;
        this.mRequestType = aRequestType;
        this.mArtistName = pArtistName;
        this.mTrackID = pTrackID;
        this.mTrackName = pTrackName;
    }

    private void setFacebookButtonState(int aState) {
        ImageView facebookLikeButton = (ImageView) this.mActivity.findViewById(C0116R.id.mini_player_fb_like_button);
        if (aState == 1) {
            facebookLikeButton.setImageDrawable(this.mActivity.getResources().getDrawable(C0116R.drawable.button_fb_default));
        } else {
            facebookLikeButton.setImageDrawable(this.mActivity.getResources().getDrawable(C0116R.drawable.button_fb_default));
        }
    }

    private void doError() {
        setFacebookButtonState(0);
        FacebookAPI.get().showErrorToast();
    }

    public void onFileNotFoundException(FileNotFoundException aException) {
        doError();
    }

    public void onIOException(IOException aIOException) {
        doError();
    }

    public void onMalformedURLException(MalformedURLException aMalformedException) {
        doError();
    }

    public void onRequestCompleted(String aResponse) {
        if (this.mRequestType == FacebookAPI.sRequestTypeLikeMedia) {
            FacebookAPI.get().showLikeToast();
            Map<String, String> properties = new HashMap();
            properties.put("artist", this.mArtistName);
            properties.put(Analytics.TRACK_KEY, this.mTrackName);
            properties.put(Analytics.GENRE_KEY, MediaUtils.getGenreForTrackId(this.mActivity, this.mTrackID));
            Analytics.getAnalytics().trackEvent(Analytics.EVENT_FACEBOOK_LIKE_SUCCESS, null, properties);
            setFacebookButtonState(1);
        } else if (this.mRequestType == FacebookAPI.sRequestTypeUnlikeMedia) {
            FacebookAPI.get().showUnlikeToast();
            setFacebookButtonState(0);
        }
    }

    public void onRequestCanceled() {
        setFacebookButtonState(0);
    }

    public void onRequestError(String aResponse) {
        doError();
    }
}
