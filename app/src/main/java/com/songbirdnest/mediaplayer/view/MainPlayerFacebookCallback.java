package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
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

public class MainPlayerFacebookCallback implements FacebookAPICallback {
    protected Activity mActivity;
    protected String mArtistName;
    private String mRequestType;
    protected int mTrackID;
    protected String mTrackName;
    private View mView;

    public MainPlayerFacebookCallback(View aView, String aRequestType) {
        this.mView = aView;
        this.mRequestType = aRequestType;
    }

    public MainPlayerFacebookCallback(View aView, String aRequestType, String pArtistName, String pTrackName, int pTrackID, Activity pActivity) {
        this.mView = aView;
        this.mRequestType = aRequestType;
        this.mArtistName = pArtistName;
        this.mTrackName = pTrackName;
        this.mTrackID = pTrackID;
        this.mActivity = pActivity;
    }

    private void resetFacebookButton() {
        ((ImageView) this.mView.findViewById(C0116R.id.main_player_fb_like_button)).setImageDrawable(this.mView.getResources().getDrawable(C0116R.drawable.button_fb_default));
    }

    private void doToast(int aLayoutId) {
        Context context = this.mView.getContext();
        View view = LayoutInflater.from(context).inflate(aLayoutId, null);
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(0);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    private void doError() {
        resetFacebookButton();
        doToast(C0116R.layout.facebook_toast_error);
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
        int layoutId = 0;
        if (this.mRequestType == FacebookAPI.sRequestTypeLikeMedia) {
            layoutId = C0116R.layout.facebook_toast_like;
            Map<String, String> properties = new HashMap();
            properties.put("artist", this.mArtistName);
            properties.put(Analytics.TRACK_KEY, this.mTrackName);
            properties.put(Analytics.GENRE_KEY, MediaUtils.getGenreForTrackId(this.mActivity, this.mTrackID));
            Analytics.getAnalytics().trackEvent(Analytics.EVENT_FACEBOOK_LIKE_SUCCESS, null, properties);
        } else if (this.mRequestType == FacebookAPI.sRequestTypeUnlikeMedia) {
            layoutId = C0116R.layout.facebook_toast_unlike;
            resetFacebookButton();
        }
        doToast(layoutId);
    }

    public void onRequestCanceled() {
        resetFacebookButton();
    }

    public void onRequestError(String aResponse) {
        doError();
    }
}
