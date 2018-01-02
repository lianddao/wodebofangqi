package com.songbirdnest.mediaplayer;

import android.app.AlertDialog.Builder;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.Model.Media;
import com.songbirdnest.mediaplayer.activities.BaseActivity;
import com.songbirdnest.mediaplayer.activities.Welcome;
import com.songbirdnest.mediaplayer.appwidget.SmallPlayerWidget;
import com.songbirdnest.soundboard.SoundboardServer;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Songbird extends BaseActivity {
    private static Handler mHandler = new Handler();
    public static final int sNumWeeksValid = 8;
    private HomeAdapter adapter;
    List<ContentViewWrapper> containerValues = new ArrayList();
    boolean isScanning = false;
    Runnable mOnComplete = new C01203();
    private View mRootView = null;
    private Cursor mediaCursor;
    private ContentObserver mediaCursorObserver = new ContentObserver(null) {

        class C01171 implements Runnable {
            C01171() {
            }

            public void run() {
                if (Songbird.this.mediaCursor != null) {
                    Log.e("ContentObserver", "Songbird: requery " + Songbird.this.mediaCursor.getCount());
                    Songbird.this.mediaCursor.requery();
                    Songbird.this.adapter.notifyDataSetChanged();
                    Log.e("ContentObserver", "Songbird: done " + Songbird.this.mediaCursor.getCount());
                    if (!Songbird.this.isScanning) {
                        Songbird.this.isScanning = true;
                        Utils.podcastScanTaskExecute(Songbird.this.getApplicationContext(), Songbird.this.mOnComplete);
                    }
                }
            }
        }

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            Songbird.getHandler().postDelayed(new C01171(), 500);
        }
    };

    class C01192 implements OnClickListener {
        C01192() {
        }

        public void onClick(DialogInterface dialog, int which) {
            Songbird.this.finish();
        }
    }

    class C01203 implements Runnable {
        C01203() {
        }

        public void run() {
            Songbird.this.isScanning = false;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        try {
            this.mRootView = getLayoutInflater().inflate(C0116R.layout.songbird_main, null);
            setContentView(this.mRootView);
            setupContainerValues();
            super.onCreate(savedInstanceState);
            checkIfExpired();
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

    private void setupContainerValues() {
        GridView gridView = (GridView) findViewById(C0116R.id.main_list);
        if (getResources().getConfiguration().orientation == 2) {
            gridView.setNumColumns(2);
        } else {
            gridView.setNumColumns(1);
        }
        this.containerValues.clear();
        for (HOME_ITEMS aItem : HOME_ITEMS.values()) {
            if (aItem.isVisible) {
                ContentViewWrapper contentViewWrapper = new ContentViewWrapper(this);
                contentViewWrapper.setHomeItem(aItem);
                this.containerValues.add(contentViewWrapper);
            }
        }
        this.adapter = new HomeAdapter(this.containerValues);
        gridView.setAdapter(this.adapter);
    }

    private void refreshHomeScreen() {
        for (ContentViewWrapper containerValue : this.containerValues) {
            containerValue.setText();
        }
    }

    public static Handler getHandler() {
        return mHandler;
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.mediaCursor == null) {
                this.mediaCursor = Media.getCursor(this);
            }
            this.mediaCursor.registerContentObserver(this.mediaCursorObserver);
        } catch (Exception e) {
        }
        refreshHomeScreen();
        Analytics.getAnalytics().track(Analytics.EVENT_HOME);
        if (!this.isScanning) {
            this.isScanning = true;
            Utils.podcastScanTaskExecute(getApplicationContext(), this.mOnComplete);
        }
        checkIntentForAction(getIntent());
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        ComponentName widgetProvider = new ComponentName("com.songbirdnest.mediaplayer", "com.songbirdnest.mediaplayer.appwidget.SmallPlayerWidget");
        for (AppWidgetProviderInfo installedProvider : manager.getInstalledProviders()) {
            int[] appWidgetIds = manager.getAppWidgetIds(installedProvider.provider);
            if (widgetProvider.equals(installedProvider.provider)) {
                new SmallPlayerWidget().onUpdate(this, manager, appWidgetIds);
                return;
            }
        }
    }

    protected void onPause() {
        super.onPause();
        this.mediaCursor.unregisterContentObserver(this.mediaCursorObserver);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mediaCursor != null) {
            this.mediaCursor.close();
        }
    }

    public void onConfigurationChanged(Configuration aConfig) {
        boolean isDrawerOpen = this.miniPlayer.isDrawerOpen();
        this.mOrientationHelper.resetOrientation();
        GridView gridView = (GridView) findViewById(C0116R.id.main_list);
        if (getResources().getConfiguration().orientation == 2) {
            gridView.setNumColumns(2);
        } else {
            gridView.setNumColumns(1);
        }
        this.miniPlayer.unbindMiniPlayer();
        this.miniPlayer.bindMiniPlayerToActivity(this);
        this.miniPlayer.setDrawerOpen(isDrawerOpen);
        super.onConfigurationChanged(aConfig);
    }

    public void onBackPressed() {
        if (this.miniPlayer == null || !this.miniPlayer.onBackPressed()) {
            super.onBackPressed();
        }
    }

    private void checkIfExpired() {
        if (Utils.isPreRelease(this)) {
            GregorianCalendar expirationDate = null;
            try {
                expirationDate = Utils.getBuildDate(this);
            } catch (Exception e) {
                Utils.showLongToast(this, "Error in application version code");
                finish();
            }
            expirationDate.add(4, 8);
            if (new GregorianCalendar().after(expirationDate)) {
                Builder dialogBuilder = new Builder(this);
                dialogBuilder.setMessage("This build of Songbird has expired.\n\nSongbird will now exit.");
                dialogBuilder.setCancelable(false);
                dialogBuilder.setPositiveButton("Oh no! Sad Panda!", new C01192());
                dialogBuilder.create().show();
            }
        }
    }

    private void checkIntentForAction(Intent aIntent) {
        String action = aIntent.getAction();
        Uri data = aIntent.getData();
        if ("android.intent.action.VIEW".equals(action) && data != null) {
            aIntent.setData(null);
            setIntent(aIntent);
            aIntent.setData(null);
            setIntent(aIntent);
            PlayableItem item = null;
            ArrayList<PlayableItem> list = new ArrayList(1);
            String scheme = data.getScheme();
            if (scheme.equals("content")) {
                item = Utils.createPlayableItemFromContentUri(getApplicationContext(), data);
                if (item == null) {
                    try {
                        Utils.createPlayableItemFromStream(getApplicationContext(), data, this.mService);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            } else if (scheme.equals("file")) {
                item = Utils.createPlayableItemFromFileUri(getApplicationContext(), data);
            } else if (scheme.equals("http")) {
                DownloadHandler.requestEnqueue(this, data);
            } else {
                return;
            }
            if (item != null) {
                list.add(item);
                try {
                    this.mService.setPlayableList(list, 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void showWelcome() {
        startActivity(new Intent(this, Welcome.class));
    }
}
