package com.songbirdnest.facebook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.facebook.FacebookAPI.FacebookAPIRequest;
import java.util.HashMap;
import java.util.Map;

public class FacebookAuthorizeListener implements DialogListener {
    public Activity mActivity;
    private FacebookAPI mFacebookAPI = FacebookAPI.get();
    public String[] mPermissions;
    private FacebookAPIRequest mRequest;
    private Runnable mRun;

    public FacebookAuthorizeListener(Activity aActivity, String[] aPermissions) {
        this.mActivity = aActivity;
        this.mPermissions = aPermissions;
    }

    public FacebookAuthorizeListener(Activity aActivity, String[] aPermissions, FacebookAPIRequest aRequest) {
        this.mActivity = aActivity;
        this.mPermissions = aPermissions;
        this.mRequest = aRequest;
    }

    public FacebookAuthorizeListener(Activity pActivity, String[] pPermissions, Runnable pRun) {
        this.mActivity = pActivity;
        this.mPermissions = pPermissions;
        this.mRun = pRun;
    }

    public void onCancel() {
        if (this.mRequest != null) {
            if (FacebookAPI.sRequestTypeLikeMedia.equalsIgnoreCase(this.mRequest.mType)) {
                Map<String, String> properties = new HashMap();
                properties.put(Analytics.FROM_KEY, Analytics.LIKE_VALUE);
                properties.put(Analytics.AUTH_KEY, Analytics.CANCEL_VALUE);
                Analytics.getAnalytics().trackEvent(Analytics.EVENT_LIKE_AUTH, null, properties);
            }
            this.mRequest.mCallback.onRequestCanceled();
        }
    }

    public void onComplete(Bundle aValues) {
        this.mFacebookAPI.onAuthorizeComplete(this, aValues);
        if (this.mRun != null) {
            this.mRun.run();
        }
        if (this.mRequest != null) {
            if (FacebookAPI.sRequestTypeLikeMedia.equalsIgnoreCase(this.mRequest.mType)) {
                Map<String, String> properties = new HashMap();
                properties.put(Analytics.FROM_KEY, Analytics.LIKE_VALUE);
                properties.put(Analytics.AUTH_KEY, Analytics.COMPLETE_VALUE);
                Analytics.getAnalytics().trackEvent(Analytics.EVENT_LIKE_AUTH, null, properties);
            }
            if (!this.mFacebookAPI.request(this.mRequest)) {
                Log.w(getClass().getName(), "Failed to submit request on completion of Facebook authorization");
            }
        }
    }

    public void onError(DialogError e) {
        if (this.mRequest != null) {
            this.mRequest.mCallback.onRequestError(null);
        }
    }

    public void onFacebookError(FacebookError e) {
        if (this.mRequest != null) {
            this.mRequest.mCallback.onRequestError(null);
        }
    }
}
