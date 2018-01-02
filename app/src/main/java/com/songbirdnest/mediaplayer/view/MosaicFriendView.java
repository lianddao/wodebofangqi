package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Audio.Artists;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.android.DialogError;
import com.facebook.android.FacebookError;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.MergeCursor;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.facebook.FacebookAPI.FacebookAPIRequest;
import com.songbirdnest.facebook.FacebookAuthorizeListener;
import com.songbirdnest.facebook.util.IdRequest;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.SongbirdApplication;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.view.adapter.AbstractSoundboardAdapter;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter.ItemDelegate;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter.SystemDelegate;
import com.songbirdnest.mediaplayer.view.adapter.FeedRetriever;
import com.songbirdnest.mediaplayer.view.adapter.FollowDialogWrapper;
import com.songbirdnest.mediaplayer.view.adapter.FollowDialogWrapper.DisplayItems;
import com.songbirdnest.mediaplayer.view.adapter.FriendAdapter;
import com.songbirdnest.mediaplayer.view.adapter.FriendAdapter.ViewWrapper;
import com.songbirdnest.mediaplayer.view.adapter.FriendRetriever;
import com.songbirdnest.mediaplayer.view.adapter.FriendRetrieverCallback;
import com.songbirdnest.mediaplayer.view.adapter.WriteImagesRunnable;
import com.songbirdnest.mediaplayer.widgets.AnimationImage;
import com.songbirdnest.network.NetworkManager;
import com.songbirdnest.notification.GCMManager;
import com.songbirdnest.soundboard.SoundBoardPrefs;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.Friend;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MosaicFriendView extends BaseContentBrowserView implements SystemDelegate {
    public static final int TOP_ARTISTS = 25;
    protected static final String VIEW_CATEGORY = "moasic:friend";
    private static boolean facebookInfoRunning = false;
    private static final String sFacebookConnectPrefs = "facebookConnectPrefs";
    private static final String sFirstRun = "facebookConnect.firstRun";
    Handler aHandler = new C03124();
    private Friend currentUser;
    private FeedRetriever feedRetriever;
    private FriendRetriever friendRetriever;
    private final LinearLayout loadingScreen;
    private AbstractSoundboardAdapter mAdapter;
    private int mAnchor = -1;
    protected ExecutorService mDownloadExecutor;
    protected int mFeedLastPosition = 0;
    protected TextView mFeedTab;
    protected int mFriendLastPosition = 0;
    protected TextView mFriendsTabs;
    protected String mFromTarget;
    protected long mLastFeedAction = 0;
    private ListView mList;
    protected boolean mShowFeed;
    protected View mSpacerView;
    protected boolean mStarted = false;
    private ExecutorService mWriteExecutator;
    private final View mosaic_tabs;
    private NetworkManager networkManager;
    private boolean topArtistsRunning = false;
    private View welcomeScreen;

    class C03081 implements OnClickListener {
        C03081() {
        }

        public void onClick(View v) {
            MosaicFriendView.this.changeToFeed();
        }
    }

    class C03092 implements OnClickListener {
        C03092() {
        }

        public void onClick(View v) {
            MosaicFriendView.this.changeToFriends();
        }
    }

    class C03113 implements Runnable {

        class C03101 implements Runnable {
            C03101() {
            }

            public void run() {
                if (MosaicFriendView.this.mAdapter != null) {
                    MosaicFriendView.this.mAdapter.notifyDataSetChanged();
                }
            }
        }

        C03113() {
        }

        public void run() {
            MosaicFriendView.this.mActivity.runOnUiThread(new C03101());
        }
    }

    class C03124 extends Handler {
        C03124() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                MosaicFriendView.this.currentUser = (Friend) msg.obj;
                MosaicFriendView.this.setSoundboardCurrentUser();
                MosaicFriendView.this.friendRetriever.setCurrentUser(MosaicFriendView.this.currentUser);
                MosaicFriendView.this.friendRetriever.setErrorOccured(false);
                new GCMManager(MosaicFriendView.this.mActivity).start();
                if (MosaicFriendView.this.mStarted) {
                    MosaicFriendView.this.executeResume();
                } else {
                    MosaicFriendView.this.executeStartup();
                }
                MosaicFriendView.facebookInfoRunning = false;
            } else if (msg.what == 2) {
                Logger.error((Object) this, "Problems Authenticating. Message: " + msg.obj);
                MosaicFriendView.this.friendRetriever.setErrorOccured(true);
                MosaicFriendView.this.mActivity.finish();
            }
        }
    }

    class C03165 extends AsyncTask<Void, Void, Void> {

        class C03151 implements SoundboardListener<List<String>> {

            class C03142 implements Runnable {
                C03142() {
                }

                public void run() {
                    Utils.showLongToast(MosaicFriendView.this.mActivity, "Failure");
                }
            }

            C03151() {
            }

            public void onSuccess(final List<String> strings) {
                Logger.debug(this, "Successfully followed top 25 artists");
                MosaicFriendView.this.mActivity.getSharedPreferences(PrefKeys.sMediaPlayerPrefs, 0).edit().putBoolean(PrefKeys.sFriendsFirstRun, false).commit();
                MosaicFriendView.this.uiPost(new Runnable() {
                    public void run() {
                        if (strings.size() > 0) {
                            MosaicFriendView.this.feedRetriever.refreshList();
                        }
                        MosaicFriendView.this.setupWhatNewScreen();
                    }
                });
            }

            public void onFailure(String message, StreamException exception) {
                Logger.debug(this, "Failed to follow top 25 artists");
                MosaicFriendView.this.mActivity.getSharedPreferences(PrefKeys.sMediaPlayerPrefs, 0).edit().putBoolean(PrefKeys.sFriendsFirstRun, false).commit();
                MosaicFriendView.this.uiPost(new C03142());
            }
        }

        C03165() {
        }

        protected Void doInBackground(Void... params) {
            TreeSet<ArtistMap> artists = MosaicFriendView.this.getTopArtists();
            Iterator<ArtistMap> iterator = artists.iterator();
            List<String> artistIds = new ArrayList();
            int size = artists.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                ArtistMap artistMap = (ArtistMap) iterator.next();
                if (count > size - 25) {
                    artistIds.add(artistMap.artist);
                }
                count++;
            }
            SoundboardServer.get().bulkFollowArtist(artistIds, new C03151());
            return null;
        }
    }

    class C03206 implements OnClickListener {
        C03206() {
        }

        public void onClick(View v) {
            if (MosaicFriendView.this.networkManager.hasActiveNetwork()) {
                final Button connectButton = (Button) MosaicFriendView.this.welcomeScreen.findViewById(C0116R.id.facebook_connect);
                connectButton.setText(C0116R.string.connecting);
                connectButton.setEnabled(false);
                Map<String, String> properties = new HashMap();
                properties.put(Analytics.FROM_KEY, Analytics.FBCONNECT_VALUE);
                Analytics.getAnalytics().trackEvent(Analytics.EVENT_WELCOME_CONTINUE, null, properties);
                SoundboardServer.get().forceAppDetails(new Runnable() {

                    class C03181 implements Runnable {
                        C03181() {
                        }

                        public void run() {
                            FacebookAPI.get().authorize(new FacebookAuthorizeListener(MosaicFriendView.this.mActivity, FacebookAPI.getsPermissions()) {
                                public void onCancel() {
                                    connectButton.setEnabled(true);
                                    connectButton.setText(C0116R.string.facebook_connect_button);
                                    Map<String, String> properties = new HashMap();
                                    properties.put(Analytics.FROM_KEY, Analytics.SONGBIRD_ME_VALUE);
                                    properties.put(Analytics.AUTH_KEY, Analytics.CANCEL_VALUE);
                                    Analytics.getAnalytics().trackEvent(Analytics.EVENT_SONGBIRD_ME_AUTH, null, properties);
                                    this.mActivity.finish();
                                }

                                public void onComplete(Bundle aValues) {
                                    connectButton.setEnabled(true);
                                    connectButton.setText(C0116R.string.facebook_connect_button);
                                    Map<String, String> properties = new HashMap();
                                    properties.put(Analytics.FROM_KEY, Analytics.SONGBIRD_ME_VALUE);
                                    properties.put(Analytics.AUTH_KEY, Analytics.COMPLETE_VALUE);
                                    Analytics.getAnalytics().trackEvent(Analytics.EVENT_SONGBIRD_ME_AUTH, null, properties);
                                    MosaicFriendView.this.setWelcomeScreenViewed();
                                    MosaicFriendView.this.removeWelcomeScreen();
                                    Analytics.getAnalytics().track(Analytics.EVENT_FRIEND_VIEW);
                                }

                                public void onError(DialogError e) {
                                    connectButton.setEnabled(true);
                                    connectButton.setText(C0116R.string.facebook_connect_button);
                                    Logger.error(MosaicFriendView.this, "onError", e);
                                    this.mActivity.finish();
                                }

                                public void onFacebookError(FacebookError e) {
                                    Logger.error(MosaicFriendView.this, "onFacebookError", e);
                                    this.mActivity.finish();
                                }
                            });
                        }
                    }

                    public void run() {
                        MosaicFriendView.this.mActivity.runOnUiThread(new C03181());
                    }
                });
                return;
            }
            FacebookAPI.get().showErrorToast();
            if (MosaicFriendView.this.mAdapter != null) {
                MosaicFriendView.this.mAdapter.setServerError(true);
            }
        }
    }

    class C03217 implements OnClickListener {
        C03217() {
        }

        public void onClick(View v) {
            Map<String, String> properties = new HashMap();
            properties.put(Analytics.FROM_KEY, Analytics.CONTINUE_VALUE);
            Analytics.getAnalytics().trackEvent(Analytics.EVENT_WELCOME_CONTINUE, null, properties);
            MosaicFriendView.this.setWelcomeScreenViewed();
            MosaicFriendView.this.removeWelcomeScreen();
        }
    }

    class ArtistMap implements Comparable<ArtistMap> {
        String artist;
        int numAlbums;
        int numTracks;

        ArtistMap(String artist, int numAlbums, int numTracks) {
            this.artist = artist;
            this.numAlbums = numAlbums;
            this.numTracks = numTracks;
        }

        public int compareTo(ArtistMap another) {
            if (this.numTracks == another.numTracks) {
                if (this.numAlbums == another.numAlbums) {
                    return this.artist.compareTo(another.artist);
                }
                if (this.numAlbums <= another.numAlbums) {
                    return -1;
                }
                return 1;
            } else if (this.numTracks <= another.numTracks) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    static class FacebookInfoRunnable implements Runnable {
        Activity mActivity;
        Handler mHandler;

        public FacebookInfoRunnable(Handler pHandler, Activity pActivity) {
            this.mHandler = pHandler;
            this.mActivity = pActivity;
        }

        public void run() {
            if (!MosaicFriendView.facebookInfoRunning) {
                MosaicFriendView.facebookInfoRunning = true;
                Bundle aBundle = new Bundle();
                aBundle.putString("fields", "id,name,email");
                final FacebookAPIRequest aRequest = FacebookAPI.get().newRequest(Analytics.ME_VALUE, aBundle, "GET", new IdRequest(this.mHandler));
                SoundboardServer.get().forceAppDetails(new Runnable() {

                    class C03241 implements Runnable {
                        C03241() {
                        }

                        public void run() {
                            FacebookAPI.get().authorize(FacebookInfoRunnable.this.mActivity, aRequest);
                        }
                    }

                    public void run() {
                        FacebookInfoRunnable.this.mActivity.runOnUiThread(new C03241());
                    }
                });
            }
        }
    }

    class FriendCallback implements FriendRetrieverCallback {
        FriendAdapter mAdapter;

        FriendCallback() {
        }

        void setAdapter(FriendAdapter pAdapter) {
            this.mAdapter = pAdapter;
        }

        public void setFriends(final List<Friend> friends) {
            MosaicFriendView.this.mActivity.runOnUiThread(new Runnable() {
                public void run() {
                    FriendCallback.this.mAdapter.setFriends(friends);
                }
            });
        }

        public void setFriendImage(final String facebookId, final Bitmap bitmap) {
            MosaicFriendView.this.mActivity.runOnUiThread(new Runnable() {
                public void run() {
                    FriendCallback.this.mAdapter.setFriendImage(facebookId, bitmap);
                    if (!MosaicFriendView.this.friendRetriever.facebookImageFileExists(facebookId) && MosaicFriendView.this.mWriteExecutator != null) {
                        MosaicFriendView.this.mWriteExecutator.execute(new WriteImagesRunnable(MosaicFriendView.this.mActivity, facebookId, bitmap));
                    }
                }
            });
        }

        public void onError(final String id, String error) {
            Logger.error((Object) this, "FriendCallback. Got error: " + error);
            MosaicFriendView.this.mActivity.runOnUiThread(new Runnable() {
                public void run() {
                    if (id == null) {
                        FriendCallback.this.mAdapter.setServerError(true);
                        FacebookAPI.get().showErrorToast();
                        return;
                    }
                    FriendCallback.this.mAdapter.setFriendImage(id, null);
                }
            });
        }
    }

    static class ListClick implements OnItemClickListener {
        AbstractSoundboardAdapter adapter;
        Activity mActivity;

        public ListClick(Activity pActivity, AbstractSoundboardAdapter pAdapter) {
            this.mActivity = pActivity;
            this.adapter = pAdapter;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            MosaicFriendView.startFollowingActivity(this.mActivity, (Friend) this.adapter.getItem(position));
        }
    }

    public MosaicFriendView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey("Friends");
        setViewCategory(VIEW_CATEGORY);
        this.networkManager = new NetworkManager(aActivity);
        this.mList = (ListView) this.mView.findViewById(C0116R.id.playlist_listing_list);
        this.mosaic_tabs = this.mView.findViewById(C0116R.id.mosaic_tabs);
        this.mFeedTab = (TextView) this.mView.findViewById(C0116R.id.mosaic_landing_feed);
        this.mFriendsTabs = (TextView) this.mView.findViewById(C0116R.id.mosaic_landing_friends);
        this.mSpacerView = this.mActivity.getLayoutInflater().inflate(C0116R.layout.spacer, null);
        boolean showFeed = this.mActivity.getIntent().getBooleanExtra(Constants.EXTRA_SONGBIRD_ME_SHOW_FEED, false);
        this.mShowFeed = this.mActivity.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).getBoolean(PrefKeys.SONGBIRD_ME_SHOW_FEED, true);
        if (showFeed && !this.mShowFeed) {
            this.mShowFeed = true;
        }
        this.mFeedTab.setOnClickListener(new C03081());
        this.mFriendsTabs.setOnClickListener(new C03092());
        if (this.mShowFeed) {
            this.mFeedTab.setSelected(true);
        } else {
            this.mFriendsTabs.setSelected(true);
        }
        if (this.mAnchor == -1) {
            this.mAnchor = (int) ((((double) BitmapFactory.decodeResource(this.mActivity.getResources(), C0116R.drawable.row_play_button).getHeight()) * 3.0d) / 4.0d);
        }
        this.friendRetriever = new FriendRetriever(aActivity, this.mAnchor, new FriendCallback());
        this.feedRetriever = new FeedRetriever(new C03113(), null);
        this.loadingScreen = (LinearLayout) this.mActivity.getLayoutInflater().inflate(C0116R.layout.mosaic_loading, null);
        View aLoading = this.mActivity.getLayoutInflater().inflate(C0116R.layout.face_item, null);
        float aScale = this.mActivity.getResources().getDisplayMetrics().density;
        aLoading.setPadding((int) (5.0f * aScale), (int) (10.0f * aScale), 5, 5);
        this.loadingScreen.addView(aLoading, new LayoutParams(-2, -2));
        ViewWrapper aWrapper = new ViewWrapper(aLoading);
        ViewGroup.LayoutParams layoutParams = aWrapper.mImage.getLayoutParams();
        layoutParams.width = 60;
        layoutParams.height = 60;
        AnimationDrawable aAnimation = (AnimationDrawable) this.mActivity.getResources().getDrawable(C0116R.drawable.spinner);
        aWrapper.mImage.setImageDrawable(aAnimation);
        aWrapper.mImage.setBackgroundDrawable(null);
        if (this.mShowFeed) {
            aWrapper.mText.setText(C0116R.string.mosaic_feed_loading);
        } else {
            aWrapper.mText.setText(C0116R.string.getting_friends);
        }
        ((AnimationImage) aWrapper.mImage).setAnimation(aAnimation);
        this.mList.setEmptyView(this.loadingScreen);
    }

    private void changeToFeed() {
        if (!this.mShowFeed) {
            this.mFromTarget = Analytics.TAB_CLICK_VALUE;
            this.mShowFeed = true;
            this.mFriendLastPosition = this.mList.getFirstVisiblePosition();
            executeStartup();
            this.mFeedTab.setSelected(true);
            this.mFriendsTabs.setSelected(false);
        }
    }

    public void onResume() {
        super.onResume();
        this.mFromTarget = Analytics.ENTRY_VALUE;
        this.mDownloadExecutor = Executors.newFixedThreadPool(2);
        updateHeaderViewText(this.mActivity.getString(C0116R.string.discover_header));
        SharedPreferences prefs = this.mActivity.getSharedPreferences(sFacebookConnectPrefs, 0);
        if (this.mAdapter != null) {
            this.mAdapter.setServerError(false);
        }
        if (prefs.getBoolean(sFirstRun, true)) {
            setupWelcomeScreen();
        } else if (!this.networkManager.hasActiveNetwork()) {
            FacebookAPI.get().showErrorToast();
            if (this.mAdapter != null) {
                this.mAdapter.setServerError(true);
            }
        } else if (FacebookAPI.get().isSessionValid() || !this.mStarted) {
            SoundBoardPrefs soundBoardPrefs = ((SongbirdApplication) this.mActivity.getApplication()).getSoundBoardPrefs();
            if (FacebookAPI.getFacebookAPI().isSessionValid() && soundBoardPrefs.hasUserInfo()) {
                setSoundboardCurrentUser();
                this.friendRetriever.setCurrentUser(this.currentUser);
                this.friendRetriever.setErrorOccured(false);
                if (this.mStarted) {
                    executeResume();
                } else {
                    executeStartup();
                }
            } else {
                this.mHandler.post(new FacebookInfoRunnable(this.aHandler, this.mActivity));
            }
        } else {
            Logger.debug(this, "onResume. FB Session isn't valid. Going back to home screen");
            this.mActivity.finish();
        }
        if (SoundboardServer.get().lastFeedAction() != this.mLastFeedAction) {
            this.mLastFeedAction = SoundboardServer.get().lastFeedAction();
            this.feedRetriever.refreshList();
        }
    }

    private void setSoundboardCurrentUser() {
        SoundBoardPrefs soundBoardPrefs = ((SongbirdApplication) this.mActivity.getApplication()).getSoundBoardPrefs();
        if (this.currentUser == null) {
            this.currentUser = new Friend();
        }
        if (soundBoardPrefs.hasUserInfo()) {
            this.currentUser.setFacebookId(soundBoardPrefs.getUserId());
            this.currentUser.setFullName(soundBoardPrefs.getUserName());
        }
        this.currentUser.setSoundBoardId(soundBoardPrefs.getCurrentUserSoundBoardId());
    }

    public void onPause() {
        super.onPause();
        this.mDownloadExecutor.shutdown();
        this.mActivity.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit().putBoolean(PrefKeys.SONGBIRD_ME_SHOW_FEED, this.mShowFeed).commit();
    }

    protected void executeResume() {
        if (this.mAdapter != null) {
            this.mAdapter.refreshDownload();
            this.mAdapter.notifyDataSetChanged();
        }
    }

    protected void executeStartup() {
        this.mList.setAdapter(null);
        this.mList.setFastScrollEnabled(false);
        ViewGroup.LayoutParams mLayoutParams = this.mList.getLayoutParams();
        ViewGroup aParent = (ViewGroup) this.mList.getParent();
        aParent.removeView(this.mList);
        this.mList = new ListView(this.mActivity);
        aParent.addView(this.mList, mLayoutParams);
        this.mList.setBackgroundColor(this.mActivity.getResources().getColor(C0116R.color.activity_list_background));
        this.mList.setCacheColorHint(this.mActivity.getResources().getColor(C0116R.color.activity_list_background));
        this.mAdapter = null;
        if (this.mShowFeed) {
            this.mList.setDivider(new ColorDrawable(this.mActivity.getResources().getColor(C0116R.color.transparent)));
            this.mList.setDividerHeight((int) (14.0f * this.mActivity.getResources().getDisplayMetrics().density));
            this.mAdapter = new FeedAdapter(this.mActivity.getLayoutInflater(), this.mActivity.getResources(), this, this.feedRetriever);
            this.mList.setAdapter(this.mAdapter);
            this.mList.setSelection(this.mFeedLastPosition);
            this.mList.setSelector(new ColorDrawable(this.mActivity.getResources().getColor(C0116R.color.transparent)));
            Map<String, String> properties = new HashMap();
            properties.put(Analytics.FROM_KEY, this.mFromTarget);
            Analytics.getAnalytics().trackEvent(Analytics.EVENT_WHATS_NEW, null, properties);
        } else {
            initFacesView();
            resumeExecutors();
            this.friendRetriever.startFriendRequest();
            this.mList.setSelection(this.mFriendLastPosition);
            Analytics.getAnalytics().track(Analytics.EVENT_FRIEND_VIEW);
        }
        if (!this.networkManager.hasActiveNetwork()) {
            FacebookAPI.get().showErrorToast();
            if (this.mAdapter != null) {
                this.mAdapter.setServerError(true);
            }
        }
        if (this.mActivity.getSharedPreferences(PrefKeys.sMediaPlayerPrefs, 0).getBoolean(PrefKeys.sFriendsFirstRun, true) && !this.topArtistsRunning) {
            this.topArtistsRunning = true;
            new C03165().execute(new Void[]{(Void) null});
        }
        this.mStarted = true;
    }

    public void onDestroy() {
        super.onDestroy();
        stopExecutors();
        if (this.mAdapter != null) {
            ((SongbirdApplication) this.mActivity.getApplication()).cleanupPhotoImages();
        }
    }

    private void stopExecutors() {
        this.friendRetriever.stop();
        if (!(this.mWriteExecutator == null || this.mWriteExecutator.isTerminated())) {
            this.mWriteExecutator.shutdownNow();
        }
        this.mWriteExecutator = null;
    }

    private void resumeExecutors() {
        if (this.mWriteExecutator == null) {
            this.mWriteExecutator = Executors.newFixedThreadPool(1);
        }
        this.friendRetriever.start();
    }

    public boolean recreateViewOnOrientationChange() {
        return this.welcomeScreen != null;
    }

    private void setupWelcomeScreen() {
        if (this.welcomeScreen == null) {
            this.mList.setVisibility(8);
            this.mosaic_tabs.setVisibility(8);
            this.welcomeScreen = this.mView.findViewById(C0116R.id.friend_welcome);
            this.welcomeScreen.setVisibility(0);
            Button connectButton = (Button) this.welcomeScreen.findViewById(C0116R.id.facebook_connect);
            connectButton.setEnabled(true);
            connectButton.setText(C0116R.string.facebook_connect_button);
            if (FacebookAPI.get().isSessionValid()) {
                this.welcomeScreen.findViewById(C0116R.id.connect_layout).setVisibility(8);
            }
            connectButton.setOnClickListener(new C03206());
            connectButton = (Button) this.welcomeScreen.findViewById(C0116R.id.facebook_continue);
            if (!FacebookAPI.get().isSessionValid()) {
                this.welcomeScreen.findViewById(C0116R.id.continue_layout).setVisibility(8);
            }
            connectButton.setOnClickListener(new C03217());
            Analytics.getAnalytics().trackEvent(Analytics.EVENT_WELCOME_VIEW);
        }
    }

    private void setWelcomeScreenViewed() {
        Editor editor = this.mActivity.getSharedPreferences(sFacebookConnectPrefs, 0).edit();
        editor.putBoolean(sFirstRun, false);
        editor.commit();
    }

    private void removeWelcomeScreen() {
        this.welcomeScreen.setVisibility(8);
        this.mList.setVisibility(0);
        this.mosaic_tabs.setVisibility(0);
        if (!this.networkManager.hasActiveNetwork()) {
            FacebookAPI.get().showErrorToast();
            if (this.mAdapter != null) {
                this.mAdapter.setServerError(true);
            }
        }
        this.welcomeScreen = null;
        this.mHandler.post(new FacebookInfoRunnable(this.aHandler, this.mActivity));
    }

    private void setupWhatNewScreen() {
        final View top_artist_notice = this.mView.findViewById(C0116R.id.top_artist_notice);
        if (top_artist_notice != null) {
            this.mView.findViewById(C0116R.id.top_artist_notice_close).setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    top_artist_notice.setVisibility(8);
                }
            });
            this.mView.findViewById(C0116R.id.following_text_link).setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    top_artist_notice.setVisibility(8);
                    if (MosaicFriendView.this.currentUser != null) {
                        MosaicFriendView.startFollowingActivity(MosaicFriendView.this.mActivity, MosaicFriendView.this.currentUser);
                    }
                }
            });
            top_artist_notice.setVisibility(0);
            top_artist_notice.getParent().bringChildToFront(top_artist_notice);
            Animation animation = AnimationUtils.loadAnimation(this.mActivity, C0116R.anim.fade_in);
            animation.setAnimationListener(new AnimationListener() {
                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }
            });
            top_artist_notice.startAnimation(animation);
        }
    }

    private void initFacesView() {
        this.mAdapter = new FriendAdapter(this.mList, this.mActivity, this.friendRetriever);
        FriendCallback mCallback = new FriendCallback();
        mCallback.setAdapter((FriendAdapter) this.mAdapter);
        this.friendRetriever.updateCallback(mCallback);
        this.mList.setOnItemClickListener(new ListClick(this.mActivity, this.mAdapter));
        this.mList.setFastScrollEnabled(true);
        this.mList.setAdapter(this.mAdapter);
    }

    private static void startFollowingActivity(Activity activity, Friend aFriend) {
        Intent i = new Intent(activity, ContentBrowser.class);
        i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, "Following");
        i.putExtra(Constants.EXTRA_FACEBOOK_ID, aFriend.getFacebookId());
        i.putExtra(Constants.EXTRA_FULL_NAME, aFriend.getFullName());
        i.putExtra(Constants.EXTRA_SOUNDBOARD_ID, aFriend.getSoundBoardId());
        activity.startActivity(i);
    }

    public void handleFacebookReceiverEvent(Intent aIntent) {
        if (aIntent.getAction().equals(FacebookAPI.ACTION_FB_CLEARED_ALL_DATA)) {
            SoundboardServer.get().clearSessionData();
            this.mActivity.onBackPressed();
        }
    }

    public Future<?> download(Runnable pRunnable) {
        if (this.mDownloadExecutor == null || this.mDownloadExecutor.isShutdown()) {
            return null;
        }
        return this.mDownloadExecutor.submit(pRunnable);
    }

    public void uiPost(Runnable pRunnable) {
        this.mHandler.post(pRunnable);
    }

    public void displayDialog(final ItemDelegate aItem) {
        final Dialog aDialog = new Dialog(this.mActivity);
        FollowDialogWrapper aWrapper = new FollowDialogWrapper(aDialog);
        aWrapper.hideOptions(DisplayItems.Comment, DisplayItems.FollowingState);
        aWrapper.mArtistInfo.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                aDialog.dismiss();
                Intent i = new Intent(MosaicFriendView.this.mActivity, ContentBrowser.class);
                i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_ARTIST_PAGE);
                i.putExtra(Constants.EXTRA_ARTIST_ID, aItem.getArtistID());
                i.putExtra(Constants.EXTRA_ARTIST_NAME, aItem.getTitle());
                i.putExtra(Constants.EXTRA_SOUNDBOARD_ID, SoundboardServer.get().getCurrentSoundBoardId());
                i.putExtra("Following", true);
                Map<String, String> properties = new HashMap();
                properties.put(Analytics.FROM_KEY, Analytics.USER_FEED_VALUE);
                Analytics.getAnalytics().trackEvent(Analytics.EVENT_SONGBIRD_ME_ARTIST_VIEW, null, properties);
                MosaicFriendView.this.mActivity.startActivity(i);
            }
        });
        aWrapper.setupLike(aItem, this.feedRetriever);
        aDialog.show();
    }

    public void launchIntent(Intent i) {
        this.mActivity.startActivity(i);
    }

    public void changeToFriends() {
        if (this.mShowFeed) {
            this.mShowFeed = false;
            this.mFeedLastPosition = this.mList.getFirstVisiblePosition();
            executeStartup();
            this.mFeedTab.setSelected(false);
            this.mFriendsTabs.setSelected(true);
        }
    }

    private TreeSet<ArtistMap> getTopArtists() {
        String[] proj = new String[]{"artist", "number_of_tracks", "number_of_albums"};
        ContentResolver contentResolver = this.mActivity.getContentResolver();
        Cursor externalCursor = contentResolver.query(Artists.EXTERNAL_CONTENT_URI, proj, null, null, null);
        Cursor internalCursor = contentResolver.query(Artists.INTERNAL_CONTENT_URI, proj, null, null, null);
        Cursor phoneCursor = contentResolver.query(Utils.sPhoneMediaStorageUri, proj, null, null, null);
        Cursor cursor = new MergeCursor(new Cursor[]{externalCursor, internalCursor, phoneCursor});
        TreeSet<ArtistMap> artists = new TreeSet();
        try {
            if (cursor.moveToFirst()) {
                while (true) {
                    String artist = cursor.getString(cursor.getColumnIndex("artist"));
                    if (!"<unknown>".equalsIgnoreCase(artist)) {
                        artists.add(new ArtistMap(artist, cursor.getInt(cursor.getColumnIndex("number_of_albums")), cursor.getInt(cursor.getColumnIndex("number_of_tracks"))));
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                }
                cursor.close();
            }
        } catch (Exception e) {
            Logger.error(this, "Problems getting top 25 artists", e);
        } finally {
            cursor.close();
        }
        return artists;
    }
}
