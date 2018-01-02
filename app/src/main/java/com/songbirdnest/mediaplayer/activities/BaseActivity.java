package com.songbirdnest.mediaplayer.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.broadcast.ControllerMap;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.DownloadHandler;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.SongbirdApplication;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.service.IMediaServiceBinder;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;
import com.songbirdnest.mediaplayer.view.MiniPlayerAndroidImpl;
import com.songbirdnest.mediaplayer.viewInterface.Listener;
import com.songbirdnest.util.Logger;
import java.io.FileNotFoundException;

public class BaseActivity extends Activity implements IMediaServiceBinder {
    protected static final int BACKDROP_FADE_DURATION = 66;
    public static final String TAG = "BaseActivity";
    private boolean mBackdropOn = false;
    protected IntentFilter mDownloadFilter = null;
    private BroadcastReceiver mDownloadReceiver;
    protected View mDrawerBackdrop = null;
    protected IntentFilter mFacebookFilter = null;
    protected BroadcastReceiver mFacebookReceiver = new C01301();
    protected ActivityOrientationHelper mOrientationHelper;
    protected IntentFilter mSDCardMountedFilter = null;
    protected SongbirdMediaService mService = null;
    protected boolean mServiceConnected = false;
    protected MiniPlayerAndroidImpl miniPlayer;

    class C01301 extends BroadcastReceiver {
        C01301() {
        }

        public void onReceive(Context aContext, Intent aIntent) {
            BaseActivity.this.handleFacebookReceiverEvent(aIntent);
        }
    }

    class C01312 implements Runnable {
        C01312() {
        }

        public void run() {
            BaseActivity.this.miniPlayer.setDrawerOpen(true);
        }
    }

    class C01323 implements OnClickListener {
        C01323() {
        }

        public void onClick(View v) {
            BaseActivity.this.miniPlayer.setDrawerOpen(false);
        }
    }

    class C01344 implements Listener {

        class C01331 implements AnimationListener {
            C01331() {
            }

            public void onAnimationEnd(Animation animation) {
                BaseActivity.this.mDrawerBackdrop.setVisibility(4);
                BaseActivity.this.mBackdropOn = false;
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        }

        C01344() {
        }

        public void onAction() {
            if (BaseActivity.this.mDrawerBackdrop != null) {
                AlphaAnimation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setAnimationListener(new C01331());
                animation.setDuration(66);
                BaseActivity.this.mDrawerBackdrop.startAnimation(animation);
                BaseActivity.this.mDrawerBackdrop.setClickable(false);
            }
        }
    }

    class C01365 implements Listener {

        class C01351 implements AnimationListener {
            C01351() {
            }

            public void onAnimationEnd(Animation animation) {
                BaseActivity.this.mDrawerBackdrop.setVisibility(0);
                BaseActivity.this.mBackdropOn = true;
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        }

        C01365() {
        }

        public void onAction() {
            if (BaseActivity.this.mDrawerBackdrop != null) {
                AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setAnimationListener(new C01351());
                animation.setDuration(66);
                BaseActivity.this.mDrawerBackdrop.startAnimation(animation);
                BaseActivity.this.mDrawerBackdrop.setClickable(true);
            }
        }
    }

    private void initService() {
        if (!this.mServiceConnected) {
            ((SongbirdApplication) getApplicationContext()).getMediaService(this);
        }
    }

    private void checkIntentForAction(Intent aIntent) {
        if (aIntent.getAction() == null) {
            String action = new String();
        }
        if (aIntent.getBooleanExtra(Constants.EXTRA_DRAWER_SHOULD_OPEN, false)) {
            aIntent.removeExtra(Constants.EXTRA_DRAWER_SHOULD_OPEN);
            runOnUiThread(new C01312());
        }
    }

    public void onMediaServiceConnected(SongbirdMediaService aMediaService) {
        this.mService = aMediaService;
        this.mServiceConnected = true;
        try {
            this.mService.setLastActivity(getIntent());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    protected void onCreate(Bundle aBundle) {
        Log.i(TAG, "onCreate - " + getClass().getName());
        super.onCreate(aBundle);
        this.miniPlayer = MiniPlayerAndroidImpl.getMiniPlayer(this);
        if (this.mFacebookFilter == null) {
            this.mFacebookFilter = new IntentFilter();
            this.mFacebookFilter.addAction(FacebookAPI.ACTION_FB_LIKED_MEDIA);
            this.mFacebookFilter.addAction(FacebookAPI.ACTION_FB_UNLIKED_MEDIA);
            this.mFacebookFilter.addAction(FacebookAPI.ACTION_FB_CLEARED_ALL_DATA);
            this.mFacebookFilter.addAction(FacebookAPI.ACTION_FB_LOGGED_IN);
        }
        this.mDrawerBackdrop = findViewById(C0116R.id.backdrop);
        this.mDrawerBackdrop.setOnClickListener(new C01323());
        this.mOrientationHelper = new ActivityOrientationHelper(this);
    }

    protected void onNewIntent(Intent aNewIntent) {
        Log.i(TAG, "onNewIntent - " + getClass().getName());
        super.onNewIntent(aNewIntent);
        setIntent(aNewIntent);
    }

    protected void onStart() {
        Log.i(TAG, "onStart - " + getClass().getName());
        super.onStart();
        this.miniPlayer.onStart(this);
        registerReceiver(this.mFacebookReceiver, this.mFacebookFilter);
        if (DownloadHandler.isSupported()) {
            this.mDownloadReceiver = DownloadHandler.getBroadcastReceiver();
            this.mDownloadFilter = DownloadHandler.getIntentFilter();
            registerReceiver(this.mDownloadReceiver, this.mDownloadFilter);
        }
    }

    protected void onResume() {
        Log.i(TAG, "onResume - " + getClass().getName());
        ((SongbirdApplication) getApplication()).pegActivity();
        this.mOrientationHelper.onResume();
        super.onResume();
        initService();
        this.miniPlayer.onResume(this);
        this.miniPlayer.setCloseListener(new C01344());
        this.miniPlayer.setOpenListener(new C01365());
        if (this.mBackdropOn) {
            this.mDrawerBackdrop.setVisibility(0);
            this.mDrawerBackdrop.setClickable(true);
        } else {
            this.mDrawerBackdrop.setVisibility(4);
            this.mDrawerBackdrop.setClickable(false);
        }
        try {
            this.miniPlayer.updateFacebookLikedState(false);
            this.miniPlayer.getPlayer().updateFacebookLikedState(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkIntentForAction(getIntent());
        if (!Utils.checkIfStorageMounted(this)) {
            Log.i(TAG, "onResume. Calling MountedSDCard");
            ((SongbirdApplication) getApplicationContext()).setSDCardMountedActivityShowing(true);
            Intent i = new Intent(this, MountedSDCard.class);
            i.addFlags(268435456);
            startActivity(i);
        }
    }

    protected void onPause() {
        Log.d(TAG, "onPause - " + getClass().getName());
        ((SongbirdApplication) getApplication()).dePegActivity();
        this.mOrientationHelper.onPause();
        super.onPause();
        this.miniPlayer.onPause();
    }

    protected void onStop() {
        Log.i(TAG, "onStop - " + getClass().getName());
        super.onStop();
        this.miniPlayer.onStop();
        this.mServiceConnected = false;
        unregisterReceiver(this.mFacebookReceiver);
        if (DownloadHandler.isSupported()) {
            unregisterReceiver(this.mDownloadReceiver);
        }
    }

    protected void onDestroy() {
        Log.i(TAG, "onDestroy - " + getClass().getName());
        super.onDestroy();
        this.miniPlayer.onDestroy();
        Analytics.getAnalytics().flush();
    }

    protected void handleFacebookReceiverEvent(Intent aIntent) {
        String action = aIntent.getAction();
        Logger.debug(this, "handleFacebookReceiverEvent. Action = " + action);
        if (action.equals(FacebookAPI.ACTION_FB_LIKED_MEDIA) || action.equals(FacebookAPI.ACTION_FB_UNLIKED_MEDIA) || action.equals(FacebookAPI.ACTION_FB_CLEARED_ALL_DATA)) {
            this.miniPlayer.updateFacebookLikedState(false);
            this.miniPlayer.getPlayer().updateFacebookLikedState(false);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FacebookAPI.FACEBOOK_AUTHORIZE_RESULT_CODE) {
            FacebookAPI.get().authorizeCallback(requestCode, resultCode, data);
        }
    }

    public boolean onKeyDown(int aKeyCode, KeyEvent aEvent) {
        if (aKeyCode != 84) {
            return super.onKeyDown(aKeyCode, aEvent);
        }
        this.miniPlayer.setDrawerOpen(false);
        Intent i = new Intent(this, ContentBrowser.class);
        i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, "Search");
        startActivity(i);
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0116R.menu.default_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public static boolean externalPrefExists(String[] fileList) {
        for (String name : fileList) {
            if (name.equals(PrefKeys.PREFS_EXTERNAL)) {
                return true;
            }
        }
        return false;
    }

    protected boolean populateFromExternal(Menu aMenu) {
        if (externalPrefExists(fileList())) {
            try {
                Log.i(TAG, "Reading the file");
                new ControllerMap(openFileInput(PrefKeys.PREFS_EXTERNAL)).addMenuItems(aMenu, getApplicationContext());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem aItem) {
        switch (aItem.getItemId()) {
            case C0116R.id.menu_about:
                startActivity(new Intent(this, About.class));
                break;
            case C0116R.id.menu_preferences:
                startActivity(new Intent(this, Preferences.class));
                break;
            default:
                return false;
        }
        return true;
    }
}
