package com.songbirdnest.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.Facebook.ServiceListener;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.SongbirdApplication;
import com.songbirdnest.soundboard.SoundBoardPrefs;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.util.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.cmc.music.myid3.id3v2.MyID3v2Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAPI {
    public static final String ACTION_FB_CLEARED_ALL_DATA = "com.songbirdnest.facebook.ACTION_FB_CLEARED_ALL_DATA";
    public static final String ACTION_FB_LIKED_MEDIA = "com.songbirdnest.facebook.ACTION_FB_LIKED_MEDIA";
    public static final String ACTION_FB_LOGGED_IN = "com.songbirdnest.facebook.ACTION_FB_LOGGED_IN";
    public static final String ACTION_FB_UNLIKED_MEDIA = "com.songbirdnest.facebook.ACTION_FB_UNLIKED_MEDIA";
    public static final String EXTRA_FB_PLAYABLE_ITEM = "com.songbirdnest.facebook.EXTRA_FB_PLAYABLE_ITEM";
    public static final String EXTRA_FB_POST_ID = "com.songbirdnest.facebook.EXTRA_FB_POST_ID";
    public static final int FACEBOOK_AUTHORIZE_RESULT_CODE = 2000;
    private static final int FACEBOOK_REQUEST_COMPLETE = 256;
    private static final int FACEBOOK_REQUEST_EXCEPTION = 515;
    private static final int FACEBOOK_REQUEST_FNFE = 512;
    private static final int FACEBOOK_REQUEST_IOE = 514;
    private static final int FACEBOOK_REQUEST_MUE = 513;
    private static Facebook sFacebook = null;
    private static final FacebookAPI sFacebookAPI = new FacebookAPI();
    private static final String sFacebookAppPackageName = "com.facebook.katana";
    public static final int sFacebookErrorToast = 2130903060;
    public static final int sFacebookLikeToast = 2130903061;
    public static final int sFacebookUnlikeToast = 2130903063;
    private static String[] sPermissions = new String[]{"publish_stream"};
    public static final String sRequestTypeLikeMedia = "likeMedia";
    public static final String sRequestTypeUnlikeMedia = "unlikeMedia";
    private boolean accessTokensCleared = false;
    private Context mContext = null;
    private DB mDB = null;
    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    private Handler mHandler = null;
    private SoundBoardPrefs soundBoardPrefs;

    class C00971 implements Runnable {
        C00971() {
        }

        public void run() {
            try {
                FacebookAPI.sFacebook.logout(FacebookAPI.this.mContext);
            } catch (MalformedURLException e) {
                Log.w(getClass().getName(), e.getMessage());
            } catch (IOException e2) {
                Log.w(getClass().getName(), e2.getMessage());
            }
        }
    }

    public class DB {
        private static final String sDBFile = "facebook@db.songbirdnest.com";
        private static final String sDBLikeMediaId = "media_id";
        private static final String sDBLikeMediaStorageUri = "storage_uri";
        private static final String sDBLikePostId = "post_id";
        private static final String sDBLikeStatus = "status";
        public static final int sDBLikeStatusLike = 257;
        public static final int sDBLikeStatusPendingLike = 256;
        public static final int sDBLikeStatusPendingUnlike = 2048;
        public static final int sDBLikeStatusUnlike = 2049;
        private static final String sDBPrimaryTable = "liked_media";
        private Context mContext;
        private SQLiteDatabase mDB;
        private SQLiteStatement mDBDeleteLikeStatus;
        private SQLiteStatement mDBGetLikePostId;
        private SQLiteStatement mDBGetLikeStatus;
        private SQLiteStatement mDBInsertLikeStatus;

        private DB(Context aContext) {
            this.mContext = null;
            this.mDB = null;
            this.mDBGetLikeStatus = null;
            this.mDBInsertLikeStatus = null;
            this.mDBDeleteLikeStatus = null;
            this.mDBGetLikePostId = null;
            if (this.mContext == null) {
                this.mContext = aContext;
            }
        }

        protected void finalize() {
            if (this.mDBGetLikeStatus != null) {
                this.mDBGetLikeStatus.close();
            }
            if (this.mDBInsertLikeStatus != null) {
                this.mDBInsertLikeStatus.close();
            }
            if (this.mDBDeleteLikeStatus != null) {
                this.mDBDeleteLikeStatus.close();
            }
            if (this.mDBGetLikePostId != null) {
                this.mDBGetLikePostId.close();
            }
            if (this.mDB != null) {
                this.mDB.close();
            }
        }

        private boolean createLikeMediaDB() {
            if (this.mDB != null && this.mDB.isOpen() && this.mDBGetLikeStatus != null && this.mDBInsertLikeStatus != null) {
                return true;
            }
            try {
                this.mDB = this.mContext.openOrCreateDatabase(sDBFile, 0, null);
                this.mDB.setVersion(0);
                this.mDB.execSQL("CREATE TABLE IF NOT EXISTS liked_media (storage_uri TEXT,media_id INTEGER, post_id TEXT, status INTEGER DEFAULT 1, PRIMARY KEY(storage_uri, media_id))");
                this.mDBGetLikeStatus = this.mDB.compileStatement("SELECT status FROM liked_media WHERE storage_uri = ?  AND media_id = ?");
                this.mDBInsertLikeStatus = this.mDB.compileStatement("INSERT INTO liked_media(storage_uri, media_id, post_id, status) VALUES(?, ?, ?, ?)");
                this.mDBDeleteLikeStatus = this.mDB.compileStatement("DELETE FROM liked_media WHERE storage_uri = ?  AND media_id = ?");
                this.mDBGetLikePostId = this.mDB.compileStatement("SELECT post_id FROM liked_media WHERE storage_uri = ?  AND media_id = ?");
                return true;
            } catch (SQLiteException e) {
                Log.w(getClass().getName(), e.getMessage());
                if (this.mDB != null) {
                    this.mDB.close();
                }
                if (this.mDBGetLikeStatus != null) {
                    this.mDBGetLikeStatus.close();
                }
                if (this.mDBInsertLikeStatus != null) {
                    this.mDBInsertLikeStatus.close();
                }
                if (this.mDBDeleteLikeStatus != null) {
                    this.mDBDeleteLikeStatus.close();
                }
                if (this.mDBGetLikePostId != null) {
                    this.mDBGetLikePostId.close();
                }
                this.mDB = null;
                this.mDBGetLikeStatus = null;
                this.mDBInsertLikeStatus = null;
                return false;
            }
        }

        public boolean isMediaLiked(PlayableItem aItem) {
            if (aItem == null) {
                return false;
            }
            if (!createLikeMediaDB()) {
                return false;
            }
            this.mDBGetLikeStatus.clearBindings();
            this.mDBGetLikeStatus.bindString(1, aItem.mStorageUri != null ? aItem.mStorageUri.toString() : "");
            this.mDBGetLikeStatus.bindLong(2, (long) aItem.mID);
            try {
                long likeStatus = this.mDBGetLikeStatus.simpleQueryForLong();
                if (likeStatus == 256 || likeStatus == 257) {
                    return true;
                }
                return false;
            } catch (SQLiteDoneException e) {
                return false;
            }
        }

        public boolean addLikeMedia(PlayableItem aItem, String aPostId, int aStatus) {
            if (!createLikeMediaDB()) {
                return false;
            }
            this.mDBInsertLikeStatus.clearBindings();
            this.mDBInsertLikeStatus.bindString(1, aItem.mStorageUri != null ? aItem.mStorageUri.toString() : "");
            this.mDBInsertLikeStatus.bindLong(2, (long) aItem.mID);
            this.mDBInsertLikeStatus.bindString(3, aPostId);
            this.mDBInsertLikeStatus.bindLong(4, (long) aStatus);
            try {
                this.mDBInsertLikeStatus.executeInsert();
                return true;
            } catch (SQLiteException e) {
                Log.w(getClass().getName(), e.getMessage());
                return false;
            }
        }

        public boolean removeLikeMedia(PlayableItem aItem) {
            if (!createLikeMediaDB()) {
                return false;
            }
            this.mDBDeleteLikeStatus.clearBindings();
            this.mDBDeleteLikeStatus.bindString(1, aItem.mStorageUri != null ? aItem.mStorageUri.toString() : "");
            this.mDBDeleteLikeStatus.bindLong(2, (long) aItem.mID);
            try {
                this.mDBDeleteLikeStatus.execute();
                return true;
            } catch (SQLiteException e) {
                Log.w(getClass().getName(), e.getMessage());
                return false;
            }
        }

        public int getLikeMediaStatus(PlayableItem aItem) {
            if (!createLikeMediaDB()) {
                return sDBLikeStatusUnlike;
            }
            long likeStatus;
            this.mDBGetLikeStatus.clearBindings();
            this.mDBGetLikeStatus.bindString(1, aItem.mStorageUri != null ? aItem.mStorageUri.toString() : "");
            this.mDBGetLikeStatus.bindLong(2, (long) aItem.mID);
            try {
                likeStatus = this.mDBGetLikeStatus.simpleQueryForLong();
            } catch (SQLiteDoneException e) {
                Log.w(getClass().getName(), e.getMessage());
                likeStatus = 2049;
            }
            return (int) likeStatus;
        }

        public boolean setLikeMediaStatus(PlayableItem aItem, int aStatus) {
            if (createLikeMediaDB()) {
                return true;
            }
            return false;
        }

        public String getLikeMediaPostId(PlayableItem aItem) {
            if (!createLikeMediaDB()) {
                return null;
            }
            this.mDBGetLikePostId.clearBindings();
            this.mDBGetLikePostId.bindString(1, aItem.mStorageUri != null ? aItem.mStorageUri.toString() : "");
            this.mDBGetLikePostId.bindLong(2, (long) aItem.mID);
            try {
                return this.mDBGetLikePostId.simpleQueryForString();
            } catch (SQLiteException e) {
                Log.w(getClass().getName(), e.getMessage());
                return null;
            }
        }

        public void clearLikedMedia() {
            if (createLikeMediaDB()) {
                try {
                    this.mDB.execSQL("DELETE FROM liked_media");
                } catch (SQLiteException e) {
                    Log.w(getClass().getName(), e.getMessage());
                }
            }
        }

        private void getAllDataForClearSession(Bundle aBundle) {
            if (createLikeMediaDB()) {
                Cursor cursor = this.mDB.query(sDBPrimaryTable, new String[]{sDBLikePostId}, null, null, null, null, null);
                String jsonArray = "[";
                while (cursor.moveToNext()) {
                    jsonArray = jsonArray + ("{ \"method\": \"DELETE\", \"relative_url\" : \"" + cursor.getString(0) + "\" }");
                    if (!cursor.isLast()) {
                        jsonArray = jsonArray + ", ";
                    }
                }
                aBundle.putString("batch", jsonArray + "]");
                cursor.close();
            }
        }
    }

    public class FacebookAPIRequest {
        protected Activity mActivity;
        protected FacebookAPICallback mCallback;
        protected Exception mException;
        protected final Facebook mFacebook = FacebookAPI.sFacebook;
        protected FacebookError mFacebookError;
        protected FileNotFoundException mFileNotFoundException;
        protected String mGraphPath;
        protected IOException mIOException;
        protected MalformedURLException mMalformedURLException;
        protected String mMethod;
        protected Bundle mParams;
        protected PlayableItem mPlayableItem = new PlayableItem("<UNKNOWN>", null, -1, -1);
        protected String mResponse;
        protected String mType;

        public FacebookAPIRequest(String aGraphPath, Bundle aParams, String aMethod, FacebookAPICallback aCallback) {
            this.mGraphPath = aGraphPath;
            this.mParams = aParams;
            this.mMethod = aMethod;
            this.mCallback = aCallback;
        }

        public FacebookAPIRequest(Activity aActivity, String aGraphPath, Bundle aParams, String aMethod, FacebookAPICallback aCallback) {
            this.mActivity = aActivity;
            this.mGraphPath = aGraphPath;
            this.mParams = aParams;
            this.mMethod = aMethod;
            this.mCallback = aCallback;
        }

        protected void clear() {
            this.mResponse = null;
            this.mFacebookError = null;
            this.mFileNotFoundException = null;
            this.mMalformedURLException = null;
            this.mIOException = null;
        }
    }

    private class FacebookAPIRequestWrapper extends FacebookAPIRequest implements Runnable {
        private Handler mHandler = null;

        public FacebookAPIRequestWrapper(String aGraphPath, Bundle aParams, String aMethod, FacebookAPICallback aCallback, Handler aHandler) {
            super(aGraphPath, aParams, aMethod, aCallback);
            this.mHandler = aHandler;
        }

        public FacebookAPIRequestWrapper(Activity aActivity, String aGraphPath, Bundle aParams, String aMethod, FacebookAPICallback aCallback, Handler aHandler) {
            super(aActivity, aGraphPath, aParams, aMethod, aCallback);
            this.mHandler = aHandler;
        }

        public FacebookAPIRequestWrapper(FacebookAPIRequest aRequest, Handler aHandler) {
            super(aRequest.mActivity, aRequest.mGraphPath, aRequest.mParams, aRequest.mMethod, aRequest.mCallback);
            this.mHandler = aHandler;
            this.mType = aRequest.mType;
            this.mPlayableItem = aRequest.mPlayableItem;
        }

        public void run() {
            Message msg = this.mHandler.obtainMessage();
            msg.obj = this;
            try {
                this.mResponse = this.mFacebook.request(this.mGraphPath, this.mParams, this.mMethod);
                msg.what = 256;
            } catch (FileNotFoundException e) {
                msg.what = FacebookAPI.FACEBOOK_REQUEST_FNFE;
                this.mFileNotFoundException = e;
            } catch (MalformedURLException e2) {
                msg.what = FacebookAPI.FACEBOOK_REQUEST_MUE;
                this.mMalformedURLException = e2;
            } catch (IOException e3) {
                msg.what = FacebookAPI.FACEBOOK_REQUEST_IOE;
                this.mIOException = e3;
            } catch (Exception e4) {
                msg.what = FacebookAPI.FACEBOOK_REQUEST_EXCEPTION;
                this.mException = e4;
            }
            this.mHandler.sendMessage(msg);
        }
    }

    private final class FacebookHandler extends Handler {
        private FacebookHandler() {
        }

        public void handleMessage(Message aMessage) {
            FacebookAPIRequestWrapper wrapper = aMessage.obj;
            switch (aMessage.what) {
                case 256:
                    boolean hasError = false;
                    Bundle bundle;
                    if (wrapper.mType != null && wrapper.mType.equalsIgnoreCase(FacebookAPI.sRequestTypeLikeMedia)) {
                        JSONObject obj = null;
                        try {
                            obj = Util.parseJson(wrapper.mResponse);
                        } catch (JSONException e) {
                            hasError = true;
                            Log.w(getClass().getName(), e.getMessage());
                        } catch (FacebookError e2) {
                            hasError = true;
                            Log.w(getClass().getName(), e2.getMessage());
                            wrapper.mFacebookError = e2;
                            if (FacebookAPI.this.processFacebookError(wrapper, false)) {
                                return;
                            }
                        }
                        String postId = "";
                        if (!hasError) {
                            try {
                                postId = obj.getString("id");
                            } catch (JSONException e3) {
                                Log.w(getClass().getName(), e3.getMessage());
                                hasError = true;
                            }
                        }
                        if (!hasError) {
                            if (!FacebookAPI.this.mDB.addLikeMedia(wrapper.mPlayableItem, postId, DB.sDBLikeStatusLike)) {
                                Log.w(getClass().getName(), "Failed to add entry to liked media.");
                            }
                            bundle = new Bundle();
                            bundle.putParcelable(FacebookAPI.EXTRA_FB_PLAYABLE_ITEM, wrapper.mPlayableItem);
                            bundle.putString(FacebookAPI.EXTRA_FB_POST_ID, postId);
                            FacebookAPI.this.broadcastIntent(FacebookAPI.ACTION_FB_LIKED_MEDIA, bundle);
                        }
                    } else if (wrapper.mType == null || !wrapper.mType.equalsIgnoreCase(FacebookAPI.sRequestTypeUnlikeMedia)) {
                        try {
                            Util.parseJson(wrapper.mResponse);
                        } catch (JSONException e32) {
                            hasError = true;
                            Log.e(getClass().getName(), e32.getMessage());
                        } catch (FacebookError e22) {
                            hasError = true;
                            Log.e(getClass().getName(), e22.getMessage());
                            wrapper.mFacebookError = e22;
                            if (FacebookAPI.this.processFacebookError(wrapper, false)) {
                                return;
                            }
                        }
                    } else {
                        if (!FacebookAPI.this.mDB.removeLikeMedia(wrapper.mPlayableItem)) {
                            Log.w(getClass().getName(), "failed to remove entry from liked media.");
                        }
                        bundle = new Bundle();
                        bundle.putParcelable(FacebookAPI.EXTRA_FB_PLAYABLE_ITEM, wrapper.mPlayableItem);
                        FacebookAPI.this.broadcastIntent(FacebookAPI.ACTION_FB_UNLIKED_MEDIA, bundle);
                    }
                    if (hasError) {
                        wrapper.mCallback.onRequestError(wrapper.mResponse);
                        return;
                    } else {
                        wrapper.mCallback.onRequestCompleted(wrapper.mResponse);
                        return;
                    }
                case FacebookAPI.FACEBOOK_REQUEST_FNFE /*512*/:
                    Log.e(getClass().getName(), "Facebook File Not Found", wrapper.mFileNotFoundException);
                    wrapper.mCallback.onFileNotFoundException(wrapper.mFileNotFoundException);
                    return;
                case FacebookAPI.FACEBOOK_REQUEST_MUE /*513*/:
                    Log.e(getClass().getName(), "Facebook MalFormed URL", wrapper.mMalformedURLException);
                    wrapper.mCallback.onMalformedURLException(wrapper.mMalformedURLException);
                    return;
                case FacebookAPI.FACEBOOK_REQUEST_IOE /*514*/:
                    Log.e(getClass().getName(), "Facebook IO Exception", wrapper.mIOException);
                    wrapper.mCallback.onIOException(wrapper.mIOException);
                    return;
                case FacebookAPI.FACEBOOK_REQUEST_EXCEPTION /*515*/:
                    Log.e(getClass().getName(), "Facebook Exception", wrapper.mException);
                    wrapper.mCallback.onRequestError(wrapper.mException.getMessage());
                    return;
                default:
                    return;
            }
        }
    }

    private FacebookAPI() {
    }

    public String getAccess() {
        return sFacebook.getAccessToken();
    }

    public long getAccessExpires() {
        return sFacebook.getAccessExpires();
    }

    public static final FacebookAPI getFacebookAPI() {
        return sFacebookAPI;
    }

    public static final FacebookAPI get() {
        return sFacebookAPI;
    }

    public final DB getFacebookDB() {
        return sFacebookAPI.mDB;
    }

    public static final DB getDB() {
        return sFacebookAPI.mDB;
    }

    public static String buildFQL(String pQuery) {
        String aUrl = "";
        try {
            aUrl = String.format("%s?query=%s&access_token=%s", new Object[]{"https://api.facebook.com/method/fql.query", URLEncoder.encode(pQuery, MyID3v2Constants.CHAR_ENCODING_UTF_8), sFacebook.getAccessToken()});
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return aUrl;
    }

    private void broadcastIntent(String aAction, Bundle aExtras) {
        Intent i = new Intent(aAction);
        if (aExtras != null) {
            i.putExtras(aExtras);
        }
        this.mContext.sendBroadcast(i);
    }

    public void init(Context aContext) {
        if (this.mContext == null) {
            this.mContext = aContext.getApplicationContext();
        }
        this.soundBoardPrefs = ((SongbirdApplication) this.mContext).getSoundBoardPrefs();
        if (sFacebook == null) {
            if (this.soundBoardPrefs.getSoundBoardAppKey() != null) {
                sFacebook = new Facebook(this.soundBoardPrefs.getSoundBoardAppKey());
            } else {
                sFacebook = new Facebook(this.mContext.getString(C0116R.string.facebook_application_id));
            }
        }
        if (this.mHandler == null) {
            this.mHandler = new FacebookHandler();
        }
        if (this.mDB == null) {
            this.mDB = new DB(this.mContext);
            this.mDB.createLikeMediaDB();
        }
        if (this.soundBoardPrefs.getAccessToken() != null && this.soundBoardPrefs.getExpiration() != -1) {
            sFacebook.setAccessToken(this.soundBoardPrefs.getAccessToken());
            sFacebook.setAccessExpires(this.soundBoardPrefs.getExpiration());
        }
    }

    public void setApplicationKey(String key) {
        String accessToken = sFacebook.getAccessToken();
        long accessExpires = sFacebook.getAccessExpires();
        sFacebook = new Facebook(key);
        if (accessToken != null) {
            sFacebook.setAccessToken(accessToken);
        }
        sFacebook.setAccessExpires(accessExpires);
    }

    public static String[] getsPermissions() {
        return sPermissions;
    }

    public static void setPermissions(String permissions) {
        sPermissions = permissions.split(",");
    }

    public boolean isFacebookInstalled() {
        try {
            return this.mContext.getPackageManager().getApplicationInfo(sFacebookAppPackageName, 0).packageName.equals(sFacebookAppPackageName);
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public FacebookAPIRequest newRequest(String aGraphPath, Bundle aParams, String aMethod, FacebookAPICallback aCallback) {
        return new FacebookAPIRequest(aGraphPath, aParams, aMethod, aCallback);
    }

    public FacebookAPIRequest newRequest(Activity aActivity, String aGraphPath, Bundle aParams, String aMethod, FacebookAPICallback aCallback) {
        return new FacebookAPIRequest(aActivity, aGraphPath, aParams, aMethod, aCallback);
    }

    public boolean request(String aGraphPath, Bundle aParams, String aMethod, FacebookAPICallback aCallback) {
        return request(new FacebookAPIRequest(aGraphPath, aParams, aMethod, aCallback));
    }

    public boolean request(FacebookAPIRequest aRequest) {
        return submitToExecutor(new FacebookAPIRequestWrapper(aRequest, this.mHandler));
    }

    public boolean logout() {
        return submitToExecutor(new C00971());
    }

    private synchronized boolean submitToExecutor(Runnable aRunnable) {
        boolean z = false;
        synchronized (this) {
            if (!(this.mExecutor.isShutdown() || this.mExecutor.isTerminated())) {
                try {
                    this.mExecutor.execute(aRunnable);
                    z = true;
                } catch (Exception e) {
                }
            }
        }
        return z;
    }

    public void appRequest(Context pContext, String pMessage, String pTarget, DialogListener pListener) {
        Bundle aBundle = new Bundle();
        aBundle.putString("message", pMessage);
        aBundle.putString("to", pTarget);
        sFacebook.dialog(pContext, "apprequests", aBundle, pListener);
    }

    public void showDialog(Context mContext, DialogListener mListener) {
        sFacebook.dialog(mContext, "feed", mListener);
    }

    public void showDialog(Context pContext, DialogListener pListener, Bundle pBundle) {
        sFacebook.dialog(pContext, "feed", pBundle, pListener);
    }

    public void showDialog(Context mContext, DialogListener mListener, String mTargetUser) {
        Bundle aBundle = new Bundle();
        aBundle.putString("to", mTargetUser);
        sFacebook.dialog(mContext, "feed", aBundle, mListener);
    }

    public boolean request(Activity aActivity, String aGraphPath, Bundle aParams, String aMethod, FacebookAPICallback aCallback) {
        return request(aActivity, newRequest(aGraphPath, aParams, aMethod, aCallback));
    }

    public boolean request(Activity aActivity, FacebookAPIRequest aRequest) {
        return authorize(aActivity, aRequest);
    }

    public boolean authorize(Activity aActivity) {
        return authorize(aActivity, null);
    }

    public boolean authorize(Activity aActivity, FacebookAPIRequest aRequest) {
        return authorize(aActivity, sPermissions, aRequest);
    }

    public boolean authorize(Activity aActivity, String[] aPermissions, FacebookAPIRequest aRequest) {
        if (aRequest != null) {
            aRequest.mActivity = aActivity;
        }
        if (sFacebook.isSessionValid()) {
            if (aRequest != null) {
                return request(aRequest);
            }
            return true;
        } else if (this.soundBoardPrefs.getAccessToken() == null || this.soundBoardPrefs.getExpiration() == -1) {
            Log.d(getClass().getName(), "authorize: Access Token not Found. Starting Login");
            try {
                sFacebook.authorize(aActivity, aPermissions, FACEBOOK_AUTHORIZE_RESULT_CODE, new FacebookAuthorizeListener(aActivity, aPermissions, aRequest));
                return true;
            } catch (Exception e) {
                Logger.error(this, "Problems authorizing Facebook", e);
                return false;
            }
        } else {
            sFacebook.setAccessToken(this.soundBoardPrefs.getAccessToken());
            sFacebook.setAccessExpires(this.soundBoardPrefs.getExpiration());
            Log.d(getClass().getName(), "authorize: Found Access Token");
            if (aRequest != null) {
                return request(aRequest);
            }
            return true;
        }
    }

    public void authorize(FacebookAuthorizeListener aListener) {
        sFacebook.authorize(aListener.mActivity, aListener.mPermissions, FACEBOOK_AUTHORIZE_RESULT_CODE, aListener);
    }

    public void authorizeCallback(int aRequestCode, int aResultCode, Intent aData) {
        this.accessTokensCleared = false;
        sFacebook.authorizeCallback(aRequestCode, aResultCode, aData);
        saveAuthorization();
        broadcastIntent(ACTION_FB_LOGGED_IN, null);
    }

    public void updateAccessToken(final ServiceListener aListener) {
        sFacebook.extendAccessToken(this.mContext, new ServiceListener() {
            public void onComplete(Bundle values) {
                FacebookAPI.this.onAuthorizeComplete(null, values);
                if (aListener != null) {
                    aListener.onComplete(values);
                }
            }

            public void onFacebookError(FacebookError e) {
                Logger.error(FacebookAPI.this, "updateAccessToken.onFacebookError. " + e.getMessage() + " ErrorType: " + e.getErrorType() + " Code: " + e.getErrorCode());
                if (aListener != null) {
                    aListener.onFacebookError(e);
                }
            }

            public void onError(Error e) {
                Logger.error(FacebookAPI.this, "updateAccessToken.onError. " + e.getMessage());
                if (aListener != null) {
                    aListener.onError(e);
                }
            }
        });
    }

    public void onAuthorizeComplete(FacebookAuthorizeListener aListener, Bundle aValues) {
        Log.d(getClass().getName(), "onAuthorizeComplete");
        if (this.mContext != null) {
            saveAuthorization();
            Logger.debug(this, "onAuthorizeComplete. Sending Logged in event");
            broadcastIntent(ACTION_FB_LOGGED_IN, null);
        }
    }

    private void saveAuthorization() {
        this.accessTokensCleared = false;
        this.soundBoardPrefs.setAccessToken(sFacebook.getAccessToken());
        this.soundBoardPrefs.setExpiration(sFacebook.getAccessExpires());
        this.soundBoardPrefs.writePrefs();
    }

    public boolean likeMediaRequest(final Activity aActivity, PlayableItem aItem, Bundle aParams, FacebookAPICallback aCallback) {
        final FacebookAPIRequest request = newRequest("me/feed", aParams, "POST", aCallback);
        request.mType = sRequestTypeLikeMedia;
        request.mPlayableItem = aItem;
        SoundboardServer.get().forceAppDetails(new Runnable() {

            class C00991 implements Runnable {
                C00991() {
                }

                public void run() {
                    FacebookAPI.get().request(aActivity, request);
                }
            }

            public void run() {
                aActivity.runOnUiThread(new C00991());
            }
        });
        return true;
    }

    public boolean unlikeMediaRequest(final Activity aActivity, PlayableItem aItem, FacebookAPICallback aCallback) {
        final FacebookAPIRequest request = newRequest(this.mDB.getLikeMediaPostId(aItem), new Bundle(), "DELETE", aCallback);
        request.mType = sRequestTypeUnlikeMedia;
        request.mPlayableItem = aItem;
        SoundboardServer.get().forceAppDetails(new Runnable() {

            class C01011 implements Runnable {
                C01011() {
                }

                public void run() {
                    FacebookAPI.get().request(aActivity, request);
                }
            }

            public void run() {
                aActivity.runOnUiThread(new C01011());
            }
        });
        return true;
    }

    public boolean isSessionValid() {
        return sFacebook.isSessionValid();
    }

    public void getUserFullNameForSession(FacebookAPICallback aCallback) {
        if (this.soundBoardPrefs.getUserName() == null || !isSessionValid()) {
            Bundle params = new Bundle();
            params.putString("fields", CookieTable.NAME);
            if (!request(Analytics.ME_VALUE, params, "GET", aCallback)) {
                Log.w(getClass().getName(), "Failed to submit request to get user full name.");
                return;
            }
            return;
        }
        aCallback.onRequestCompleted("{ name: \"" + this.soundBoardPrefs.getUserName() + "\" }");
    }

    public void clearSessionData() {
        this.mDB.getAllDataForClearSession(new Bundle());
        clearFacebookData();
        this.mDB.clearLikedMedia();
        if (!logout()) {
            Log.w(getClass().getName(), "Failed to logout of Facebook.");
        }
        Logger.debug(this, "clearSessionData. Sending Logged out event");
        broadcastIntent(ACTION_FB_CLEARED_ALL_DATA, null);
    }

    public void clearFacebookData() {
        if (!this.accessTokensCleared) {
            this.accessTokensCleared = true;
            clearAccessToken();
            sFacebook.setAccessExpires(0);
            sFacebook.setAccessToken(null);
            broadcastIntent(ACTION_FB_CLEARED_ALL_DATA, null);
        }
    }

    public void showLikeToast() {
        getToastForLayout(C0116R.layout.facebook_toast_like).show();
    }

    public void showUnlikeToast() {
        getToastForLayout(C0116R.layout.facebook_toast_unlike).show();
    }

    public void showErrorToast() {
        getToastForLayout(C0116R.layout.facebook_toast_error).show();
    }

    private Toast getToastForLayout(int aLayoutId) {
        View view = LayoutInflater.from(this.mContext).inflate(aLayoutId, null);
        Toast toast = new Toast(this.mContext);
        toast.setView(view);
        toast.setDuration(0);
        toast.setGravity(17, 0, 0);
        return toast;
    }

    private boolean processFacebookError(FacebookAPIRequestWrapper aWrapper, boolean aRetry) {
        String errorType = aWrapper.mFacebookError.getErrorType();
        String message = aWrapper.mFacebookError.getMessage();
        Logger.error((Object) this, "processFacebookError. ErrorType: " + errorType + " Message: " + message);
        if (errorType.equals("OAuthException") && (message == null || !(message.contains("limit") || message.contains("feed")))) {
            int errorCode = aWrapper.mFacebookError.getErrorCode();
            switch (errorCode) {
                case 0:
                    clearFacebookData();
                    if (aWrapper.mActivity != null && aRetry) {
                        return request(aWrapper.mActivity, aWrapper);
                    }
                default:
                    Log.w(getClass().getName(), "Unable to processFacebookError. Error " + errorCode + " is unknown.");
                    break;
            }
        }
        return false;
    }

    private void clearAccessToken() {
        this.soundBoardPrefs.setAccessToken(null);
        this.soundBoardPrefs.setExpiration(-1);
        this.soundBoardPrefs.writePrefs();
    }
}
