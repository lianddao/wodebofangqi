package com.songbirdnest.mediaplayer.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.view.AlbumDetailView;
import com.songbirdnest.mediaplayer.view.AlbumListingView;
import com.songbirdnest.mediaplayer.view.ArtistAlbumDetailView;
import com.songbirdnest.mediaplayer.view.ArtistDetailView;
import com.songbirdnest.mediaplayer.view.ArtistListingView;
import com.songbirdnest.mediaplayer.view.BaseContentBrowserView;
import com.songbirdnest.mediaplayer.view.GenreAlbumDetailView;
import com.songbirdnest.mediaplayer.view.GenreDetailsView;
import com.songbirdnest.mediaplayer.view.GenreListingView;
import com.songbirdnest.mediaplayer.view.GenreSongListingView;
import com.songbirdnest.mediaplayer.view.MosaicArtistFeed;
import com.songbirdnest.mediaplayer.view.MosaicCollection;
import com.songbirdnest.mediaplayer.view.MosaicFriendView;
import com.songbirdnest.mediaplayer.view.PlaylistDetailsView;
import com.songbirdnest.mediaplayer.view.PlaylistListingView;
import com.songbirdnest.mediaplayer.view.PodcastDetailView;
import com.songbirdnest.mediaplayer.view.PodcastListingView;
import com.songbirdnest.mediaplayer.view.SearchView;
import com.songbirdnest.mediaplayer.view.SongListingView;
import com.songbirdnest.mediaplayer.view.TopMenu;
import com.songbirdnest.mediaplayer.view.TopMenu.HomeButtonClickListener;
import com.songbirdnest.mediaplayer.view.VideoListingView;
import com.songbirdnest.mediaplayer.widgets.Header;
import com.songbirdnest.mediaplayer.widgets.MarqueeTextView;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.util.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class ContentBrowser extends BaseActivity {
    private static final String LOG_TAG = "SongbirdContentBrowser";
    private static final int VIEW_CACHE_MIN_SIZE = 6;
    private static Handler mHandler = new Handler();
    private static int sLastDisplayOrientation = 0;
    private RelativeLayout mContentArea = null;
    private Header mContentAreaHeader = null;
    private Intent mCurrentIntent = null;
    private BaseContentBrowserView mCurrentView = null;
    private HomeButtonClickListener mHomeButtonListener = new C01371();
    private Stack<Intent> mIntentStack = new Stack();
    private View mRootView = null;
    private TopMenu mTopMenu = null;
    private View mTopMenuView = null;
    private Map<String, BaseContentBrowserView> mViewCache = new HashMap(6);
    private Stack<BaseContentBrowserView> mViewStack = new Stack();

    class C01371 implements HomeButtonClickListener {
        C01371() {
        }

        public void onHomeButtonClicked() {
            ContentBrowser.this.finish();
        }
    }

    public static Handler getHandler() {
        return mHandler;
    }

    protected void onCreate(Bundle aBundle) {
        try {
            this.mRootView = getLayoutInflater().inflate(C0116R.layout.content_browser, null);
            setContentView(this.mRootView);
            super.onCreate(aBundle);
            this.mContentAreaHeader = (Header) findViewById(C0116R.id.content_header);
            this.mContentArea = (RelativeLayout) findViewById(C0116R.id.content_area);
            this.mTopMenuView = findViewById(C0116R.id.top_layout);
            this.mTopMenu = new TopMenu(this);
            this.mTopMenu.setHomeButtonClickListener(this.mHomeButtonListener);
            setScreenOrientation(getScreenOrientation());
            SharedPreferences prefs = getSharedPreferences(PrefKeys.sMediaPlayerPrefs, 0);
            boolean firstRun = prefs.getBoolean(PrefKeys.sFirstRun, true);
            String core_version = getString(C0116R.string.core_version);
            String version = prefs.getString(PrefKeys.sVersion, null);
            if (firstRun || version == null || !version.equalsIgnoreCase(core_version)) {
                showWelcome();
            }
            SoundboardServer.get().init(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showWelcome() {
        startActivity(new Intent(this, Welcome.class));
    }

    public void onConfigurationChanged(Configuration aConfig) {
        int visibility = 0;
        Logger.debug(this, "onConfigurationChanged");
        this.mOrientationHelper.resetOrientation();
        this.mRootView.setDrawingCacheQuality(1048576);
        this.mRootView.setDrawingCacheEnabled(true);
        this.mRootView.buildDrawingCache(true);
        final int orientation = getScreenOrientation();
        getOrientationChangeMenuAnimation(orientation).setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                ContentBrowser.this.mTopMenuView.setVisibility(orientation == 2 ? 8 : 0);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        MarqueeTextView headerText = (MarqueeTextView) findViewById(C0116R.id.header_header_text);
        Button homeButton = (Button) findViewById(C0116R.id.top_menu_songbird_logo_transp);
        if (orientation == 2) {
            homeButton.setVisibility(0);
            headerText.setPadding(80, 6, 80, 3);
        } else {
            headerText.setPadding(3, 5, 3, 3);
            homeButton.setVisibility(4);
        }
        if (!this.mCurrentView.isViewPaused()) {
            this.mCurrentView.onPause();
        }
        boolean isDrawerOpen = this.miniPlayer.isDrawerOpen();
        this.mContentArea.removeView(this.mCurrentView.getContentView());
        onCreate(null);
        if (this.mCurrentView.recreateViewOnOrientationChange()) {
            this.mCurrentView = createBrowserView(this.mCurrentView.getViewKey());
        }
        this.mContentArea.addView(this.mCurrentView.getContentView());
        this.mCurrentView.onResume();
        this.miniPlayer.unbindMiniPlayer();
        this.miniPlayer.bindMiniPlayerToActivity(this);
        this.miniPlayer.setDrawerOpen(isDrawerOpen);
        this.mContentAreaHeader.setText(this.mCurrentView.getHeaderViewText());
        if (orientation == 2) {
            visibility = 8;
        }
        this.mTopMenuView.setVisibility(visibility);
        super.onConfigurationChanged(aConfig);
    }

    protected void handleFacebookReceiverEvent(Intent aIntent) {
        super.handleFacebookReceiverEvent(aIntent);
        this.mCurrentView.handleFacebookReceiverEvent(aIntent);
    }

    private int getScreenOrientation() {
        return getResources().getConfiguration().orientation;
    }

    private void setScreenOrientation(int orientation) {
        LinearLayout topLayout = (LinearLayout) findViewById(C0116R.id.top_layout);
        Button homeButton = (Button) findViewById(C0116R.id.top_menu_songbird_logo_transp);
        MarqueeTextView headerText = (MarqueeTextView) findViewById(C0116R.id.header_header_text);
        if (orientation == 2) {
            topLayout.setVisibility(8);
            homeButton.setVisibility(0);
            headerText.setPadding(80, 6, 80, 3);
        } else if (orientation == 1) {
            topLayout.setVisibility(0);
            homeButton.setVisibility(4);
            headerText.setPadding(3, 5, 3, 3);
        }
    }

    protected void onStart() {
        Logger.debug(this, "onStart");
        super.onStart();
    }

    protected void onResume() {
        Logger.debug(this, "onResume");
        super.onResume();
        try {
            setMainContentArea();
        } catch (Exception e) {
            Log.e(LOG_TAG, e.toString(), e);
        }
    }

    protected void onPause() {
        Logger.debug(this, "onPause");
        super.onPause();
        this.mContentArea.clearDisappearingChildren();
        try {
            if (this.mCurrentView != null && !this.mCurrentView.isViewPaused()) {
                this.mCurrentView.onPause();
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, e.toString(), e);
        }
    }

    protected void onStop() {
        Logger.debug(this, "onStop");
        super.onStop();
        this.mTopMenu.setHomeButtonClickListener(null);
        try {
            if (this.mCurrentView != null && !this.mCurrentView.isViewStopped()) {
                this.mCurrentView.onStop();
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, e.toString(), e);
        }
    }

    protected void onDestroy() {
        Logger.debug(this, "onPause");
        super.onDestroy();
        try {
            deleteAllViewsFromStack();
            deleteAllViewsFromCache();
        } catch (Exception e) {
            Log.e(LOG_TAG, e.toString(), e);
        }
    }

    protected void onNewIntent(Intent aNewIntent) {
        super.onNewIntent(aNewIntent);
        setIntent(aNewIntent);
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        super.onCreateContextMenu(aMenu, aView, aMenuInfo);
        if (this.mCurrentView != null) {
            this.mCurrentView.onCreateContextMenu(aMenu, aView, aMenuInfo);
        }
    }

    public boolean onPrepareOptionsMenu(Menu aMenu) {
        aMenu.clear();
        if (this.mCurrentView == null) {
            return false;
        }
        boolean showMenu = this.mCurrentView.onCreateOptionsMenu(aMenu);
        try {
            populateFromExternal(aMenu);
            return showMenu;
        } catch (Exception e) {
            e.printStackTrace();
            return showMenu;
        }
    }

    public boolean onOptionsItemSelected(MenuItem aItem) {
        if (this.mCurrentView == null || !this.mCurrentView.onOptionsItemSelected(aItem)) {
            return false;
        }
        return true;
    }

    public void onBackPressed() {
        boolean hasHandledBackKey = false;
        try {
            if (this.miniPlayer != null) {
                this.miniPlayer.setDrawerOpen(false);
                hasHandledBackKey = this.miniPlayer.onBackPressed();
            }
            if (!hasHandledBackKey) {
                hasHandledBackKey = popToPreviousBrowserView();
            }
            if (!hasHandledBackKey) {
                super.onBackPressed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setMainContentArea() {
        Intent intent = getIntent();
        Bundle extras = null;
        if (intent != null) {
            extras = intent.getExtras();
        }
        if (extras == null) {
            Log.e(LOG_TAG, "setMainContentArea called without Activity extras!");
            return;
        }
        String viewKey = extras.getString(Constants.CONTENT_AREA_VIEW_KEY);
        if (this.mCurrentView == null || !this.mCurrentView.getViewKey().equals(viewKey)) {
            BaseContentBrowserView browserView = getViewFromCache(viewKey);
            if (browserView == null) {
                browserView = createBrowserView(viewKey);
            }
            if (browserView == null) {
                Log.w(LOG_TAG, "Attempted to create content browser view that is not registered!");
                Log.w(LOG_TAG, "Content browser view key -- " + viewKey);
                return;
            }
            pushToNewBrowserView(browserView);
            return;
        }
        this.mCurrentView.onResume();
    }

    private BaseContentBrowserView createBrowserView(String aViewKey) {
        BaseContentBrowserView browserView = null;
        if (aViewKey.equals(Constants.CONTENT_VIEW_ALBUM_DETAILS)) {
            browserView = new AlbumDetailView(this, C0116R.layout.album_details, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_ALBUM_LIST)) {
            browserView = new AlbumListingView(this, C0116R.layout.album_listing, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_ARTIST_ALBUM_DETAILS)) {
            browserView = new ArtistAlbumDetailView(this, C0116R.layout.album_details, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_ARTIST_DETAILS)) {
            browserView = new ArtistDetailView(this, C0116R.layout.artist_details, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_ARTIST_LIST)) {
            browserView = new ArtistListingView(this, C0116R.layout.artist_listing, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_GENRE_ALBUM_DETAILS)) {
            browserView = new GenreAlbumDetailView(this, C0116R.layout.album_details, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_GENRE_DETAILS)) {
            browserView = new GenreDetailsView(this, C0116R.layout.genre_details, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_GENRE_LIST)) {
            browserView = new GenreListingView(this, C0116R.layout.genre_listing, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_GENRE_SONG_LIST)) {
            browserView = new GenreSongListingView(this, C0116R.layout.song_listing, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_PLAYLIST_DETAILS)) {
            browserView = new PlaylistDetailsView(this, C0116R.layout.playlist_details, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_PLAYLIST_LIST)) {
            browserView = new PlaylistListingView(this, C0116R.layout.playlist_listing, this.mContentArea);
        } else if (aViewKey.equals("Search")) {
            browserView = new SearchView(this, C0116R.layout.search, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_SONG_LIST)) {
            browserView = new SongListingView(this, C0116R.layout.song_listing, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_PODCAST_LIST)) {
            browserView = new PodcastListingView(this, C0116R.layout.song_listing, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_PODCAST_DETAILS)) {
            browserView = new PodcastDetailView(this, C0116R.layout.song_listing, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_VIDEO_LIST)) {
            browserView = new VideoListingView(this, C0116R.layout.video_listing, this.mContentArea);
        } else if (aViewKey.equals("Friends")) {
            browserView = new MosaicFriendView(this, C0116R.layout.mosaic_landing, this.mContentArea);
        } else if (aViewKey.equals("Following")) {
            browserView = new MosaicCollection(this, C0116R.layout.clean_list, this.mContentArea);
        } else if (aViewKey.equals(Constants.CONTENT_VIEW_ARTIST_PAGE)) {
            browserView = new MosaicArtistFeed(this, C0116R.layout.mosaic_feed, this.mContentArea);
        }
        browserView.setHeaderView(this.mContentAreaHeader);
        cacheView(browserView);
        return browserView;
    }

    private void pushToNewBrowserView(final BaseContentBrowserView aBrowserView) {
        View contextMenuView;
        Animation inAnimation = getInAnimationForTransition(this.mCurrentView, aBrowserView, false);
        inAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                aBrowserView.getContentView().setVisibility(0);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        aBrowserView.onResume();
        aBrowserView.getContentView().startAnimation(inAnimation);
        this.mContentAreaHeader.setTextWithAnimation(aBrowserView.getHeaderViewText(), areViewsRelated(this.mCurrentView, aBrowserView), false);
        if (this.mCurrentView != null) {
            final BaseContentBrowserView previousView = this.mCurrentView;
            Animation outAnimation = getOutAnimationForTransition(previousView, aBrowserView, false);
            outAnimation.setAnimationListener(new AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    previousView.getContentView().setVisibility(4);
                    previousView.onStop();
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            previousView.getContentView().startAnimation(outAnimation);
            if (!previousView.isViewPaused()) {
                previousView.onPause();
            }
            this.mContentArea.removeView(previousView.getContentView());
            contextMenuView = previousView.getContextMenuView();
            if (contextMenuView != null) {
                unregisterForContextMenu(contextMenuView);
            }
            pushViewToStack(previousView, this.mCurrentIntent);
        }
        this.mCurrentView = aBrowserView;
        this.mCurrentIntent = getIntent();
        String viewAnalyticsUri = this.mCurrentView.getViewAnalyticsUri();
        if (viewAnalyticsUri != null) {
            Analytics.getAnalytics().track(viewAnalyticsUri);
        }
        this.mContentArea.addView(this.mCurrentView.getContentView());
        contextMenuView = this.mCurrentView.getContextMenuView();
        if (contextMenuView != null) {
            registerForContextMenu(contextMenuView);
        }
    }

    private boolean popToPreviousBrowserView() {
        final BaseContentBrowserView browserView = popViewFromStack();
        if (browserView == null) {
            return false;
        }
        View contextMenuView;
        Animation inAnimation = getInAnimationForTransition(this.mCurrentView, browserView, true);
        inAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                browserView.getContentView().setVisibility(0);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        browserView.onResume();
        browserView.getContentView().startAnimation(inAnimation);
        this.mContentAreaHeader.setTextWithAnimation(browserView.getHeaderViewText(), areViewsRelated(this.mCurrentView, browserView), true);
        if (this.mCurrentView != null) {
            final BaseContentBrowserView previousView = this.mCurrentView;
            Animation outAnimation = getOutAnimationForTransition(previousView, browserView, true);
            outAnimation.setAnimationListener(new AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    previousView.getContentView().setVisibility(4);
                    previousView.onStop();
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            previousView.getContentView().startAnimation(outAnimation);
            if (!previousView.isViewPaused()) {
                previousView.onPause();
            }
            this.mContentArea.removeView(previousView.getContentView());
            contextMenuView = previousView.getContextMenuView();
            if (contextMenuView != null) {
                unregisterForContextMenu(contextMenuView);
            }
        }
        this.mCurrentView = browserView;
        String viewAnalyticsUri = this.mCurrentView.getViewAnalyticsUri();
        if (viewAnalyticsUri != null) {
            Analytics.getAnalytics().track(viewAnalyticsUri);
        }
        this.mContentArea.addView(this.mCurrentView.getContentView());
        contextMenuView = this.mCurrentView.getContextMenuView();
        if (contextMenuView == null) {
            return true;
        }
        registerForContextMenu(contextMenuView);
        return true;
    }

    private boolean isViewCached(String aViewKey) {
        return this.mViewCache.containsKey(aViewKey);
    }

    private BaseContentBrowserView getViewFromCache(String aViewKey) {
        if (isViewCached(aViewKey)) {
            return (BaseContentBrowserView) this.mViewCache.get(aViewKey);
        }
        return null;
    }

    private void cacheView(BaseContentBrowserView aBaseView) {
        cacheView(aBaseView, false);
    }

    private void cacheView(BaseContentBrowserView aBaseView, boolean aReplaceIfInCache) {
        String viewKey = aBaseView.getViewKey();
        if (aReplaceIfInCache) {
            deleteViewFromCache(viewKey);
            this.mViewCache.put(viewKey, aBaseView);
        } else if (!isViewCached(viewKey)) {
            this.mViewCache.put(viewKey, aBaseView);
        }
    }

    private void deleteViewFromCache(String aViewKey) {
        if (isViewCached(aViewKey)) {
            BaseContentBrowserView view = (BaseContentBrowserView) this.mViewCache.get(aViewKey);
            if (!view.isViewPaused()) {
                view.onPause();
            }
            if (!view.isViewStopped()) {
                view.onStop();
            }
            if (!view.isViewDestroyed()) {
                view.onDestroy();
            }
            this.mViewCache.remove(aViewKey);
        }
    }

    private void deleteAllViewsFromCache() {
        String[] viewKeys = new String[this.mViewCache.size()];
        this.mViewCache.keySet().toArray(viewKeys);
        for (String viewKey : viewKeys) {
            deleteViewFromCache(viewKey);
        }
    }

    private void pushViewToStack(BaseContentBrowserView aView, Intent aIntent) {
        if (!isViewOnStackTop(aView)) {
            this.mViewStack.push(aView);
            this.mIntentStack.push(aIntent);
        }
    }

    private BaseContentBrowserView popViewFromStack() {
        if (this.mViewStack.size() != this.mIntentStack.size()) {
            Log.w(LOG_TAG, "View Stack and Intent Stack are NOT the same size!");
            this.mViewStack.clear();
            this.mIntentStack.clear();
            return null;
        } else if (this.mViewStack.empty() || this.mIntentStack.empty()) {
            return null;
        } else {
            Intent i = (Intent) this.mIntentStack.pop();
            this.mCurrentIntent = i;
            setIntent(i);
            return (BaseContentBrowserView) this.mViewStack.pop();
        }
    }

    private boolean isViewOnStackTop(BaseContentBrowserView aView) {
        if (this.mViewStack.empty() || !((BaseContentBrowserView) this.mViewStack.peek()).getViewKey().equals(aView.getViewKey())) {
            return false;
        }
        return true;
    }

    private void deleteAllViewsFromStack() {
        Iterator i$ = this.mViewStack.iterator();
        while (i$.hasNext()) {
            BaseContentBrowserView view = (BaseContentBrowserView) i$.next();
            if (!view.isViewPaused()) {
                view.onPause();
            }
            if (!view.isViewStopped()) {
                view.onStop();
            }
            if (!view.isViewDestroyed()) {
                view.onDestroy();
            }
        }
        this.mViewStack.clear();
        this.mIntentStack.clear();
    }

    private Animation getInAnimationForTransition(BaseContentBrowserView aFromView, BaseContentBrowserView aToView, boolean aPoppingFromStack) {
        float xDeltaStart = 1.0f;
        if (areViewsRelated(aFromView, aToView)) {
            if (aPoppingFromStack) {
                xDeltaStart = -1.0f;
            }
            Animation animation = new TranslateAnimation(1, xDeltaStart, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            animation.setInterpolator(new AccelerateInterpolator());
            animation.setDuration(333);
            return animation;
        }
        animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setDuration(333);
        return animation;
    }

    private Animation getOutAnimationForTransition(BaseContentBrowserView aFromView, BaseContentBrowserView aToView, boolean aPoppingFromStack) {
        float xDeltaEnd = 1.0f;
        if (areViewsRelated(aFromView, aToView)) {
            if (!aPoppingFromStack) {
                xDeltaEnd = -1.0f;
            }
            Animation animation = new TranslateAnimation(1, 0.0f, 1, xDeltaEnd, 1, 0.0f, 1, 0.0f);
            animation.setInterpolator(new AccelerateInterpolator());
            animation.setDuration(333);
            return animation;
        }
        animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setDuration(333);
        return animation;
    }

    private boolean areViewsRelated(BaseContentBrowserView aFromView, BaseContentBrowserView aToView) {
        if (aFromView == null || aToView == null) {
            return false;
        }
        String fromViewCategory = aFromView.getViewCategory();
        String toViewCategory = aToView.getViewCategory();
        if (fromViewCategory == null || toViewCategory == null) {
            return false;
        }
        return fromViewCategory.equals(toViewCategory);
    }

    private Animation getOrientationChangeMenuAnimation(int aOrientation) {
        float fromY = 0.0f;
        float toY = 0.0f;
        if (aOrientation == 2) {
            toY = -1.0f;
        } else {
            fromY = -1.0f;
        }
        Animation animation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, fromY, 1, toY);
        animation.setDuration(100);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        return animation;
    }

    private Animation getOrientationChangeAnimation() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        float[] degrees = getAnimationDegrees();
        RotateAnimation rotate = new RotateAnimation(degrees[0], degrees[1], 1, 0.5f, 1, 0.5f);
        rotate.setDuration(500);
        animationSet.addAnimation(rotate);
        return animationSet;
    }

    private float[] getAnimationDegrees() {
        float fromDegrees = 0.0f;
        float toDegrees = 0.0f;
        int displayOrientation = getWindowManager().getDefaultDisplay().getOrientation();
        switch (displayOrientation) {
            case 0:
                if (sLastDisplayOrientation != 3) {
                    fromDegrees = 90.0f;
                    toDegrees = 0.0f;
                    break;
                }
                fromDegrees = -90.0f;
                toDegrees = 0.0f;
                break;
            case 1:
                fromDegrees = -90.0f;
                toDegrees = 0.0f;
                break;
            case 3:
                fromDegrees = 90.0f;
                toDegrees = 0.0f;
                break;
        }
        sLastDisplayOrientation = displayOrientation;
        return new float[]{fromDegrees, toDegrees};
    }
}
