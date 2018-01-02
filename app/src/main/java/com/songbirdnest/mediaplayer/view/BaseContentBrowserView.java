package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.SongbirdApplication;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.About;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.activities.Preferences;
import com.songbirdnest.mediaplayer.service.IMediaEventCallback.Stub;
import com.songbirdnest.mediaplayer.service.IMediaServiceBinder;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;
import com.songbirdnest.mediaplayer.widgets.Header;
import java.util.HashMap;

public class BaseContentBrowserView implements IMediaServiceBinder {
    protected static final int SHUFFLE_ALL_POS = 0;
    boolean isScanning = false;
    protected Activity mActivity = null;
    private HashMap<Cursor, ContentObserver> mCoCache = new HashMap();
    protected View mContextMenuView = null;
    protected Handler mHandler = new Handler();
    protected Header mHeaderView = null;
    protected String mHeaderViewText = null;
    protected boolean mIsViewDestroyed = false;
    protected boolean mIsViewPaused = false;
    protected boolean mIsViewStopped = false;
    protected Stub mMediaEventListener = new C02362();
    protected MenuInflater mMenuInflater = null;
    Runnable mOnScanComplete = new C02341();
    private int mScrollState = 0;
    protected SongbirdMediaService mService = null;
    protected boolean mServiceConnected = false;
    protected View mView = null;
    protected String mViewAnalyticsUri = null;
    protected String mViewCategory = null;
    protected String mViewKey = null;
    protected int mViewLayoutId = -1;

    class C02341 implements Runnable {
        C02341() {
        }

        public void run() {
            BaseContentBrowserView.this.isScanning = false;
        }
    }

    class C02362 extends Stub {
        C02362() {
        }

        public void onMediaMessage(int aEvent) {
            final int event = aEvent;
            BaseContentBrowserView.this.mHandler.post(new Runnable() {
                public void run() {
                    BaseContentBrowserView.this.onMediaServiceEvent(event);
                }
            });
        }
    }

    protected boolean isScrollIdle() {
        return this.mScrollState == 0;
    }

    protected void setScrollState(int aScrollState) {
        this.mScrollState = aScrollState;
    }

    public BaseContentBrowserView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        this.mActivity = aActivity;
        this.mView = this.mActivity.getLayoutInflater().inflate(aLayoutId, aViewRoot, false);
        this.mMenuInflater = this.mActivity.getMenuInflater();
    }

    public String getViewAnalyticsUri() {
        return this.mViewAnalyticsUri;
    }

    protected void setViewAnalyticsUri(String aViewAnalyticsUri) {
        this.mViewAnalyticsUri = aViewAnalyticsUri;
    }

    public boolean isViewPaused() {
        return this.mIsViewPaused;
    }

    public boolean isViewStopped() {
        return this.mIsViewStopped;
    }

    public boolean isViewDestroyed() {
        return this.mIsViewDestroyed;
    }

    public void onResume() {
        Log.i(getClass().getSimpleName(), "onResume");
        startService();
        this.mHeaderView = (Header) this.mActivity.findViewById(C0116R.id.content_header);
        this.mIsViewPaused = false;
        this.mIsViewStopped = false;
    }

    public void onPause() {
        Log.i(getClass().getSimpleName(), "onPause " + this.mIsViewPaused);
        stopService();
        this.mIsViewPaused = true;
    }

    public void onStop() {
        Log.i(getClass().getSimpleName(), "onStop");
        this.mIsViewStopped = true;
    }

    public void onDestroy() {
        Log.i(getClass().getSimpleName(), "onDestroy");
        this.mIsViewDestroyed = true;
    }

    public String getViewKey() {
        return this.mViewKey;
    }

    protected void setViewKey(String aViewKey) {
        this.mViewKey = aViewKey;
    }

    public String getViewCategory() {
        return this.mViewCategory;
    }

    protected void setViewCategory(String aViewCategory) {
        this.mViewCategory = aViewCategory;
    }

    public String getHeaderViewText() {
        return this.mHeaderViewText;
    }

    protected void setHeaderViewText(String aHeaderViewText) {
        this.mHeaderViewText = aHeaderViewText;
    }

    protected void updateHeaderViewText(String aHeaderViewText) {
        this.mHeaderViewText = aHeaderViewText;
        this.mHeaderView.setText(this.mHeaderViewText);
    }

    public Header getHeaderView() {
        return this.mHeaderView;
    }

    public void setHeaderView(Header aHeaderView) {
        this.mHeaderView = aHeaderView;
    }

    public View getContentView() {
        return this.mView;
    }

    public View getContextMenuView() {
        return this.mContextMenuView;
    }

    protected void setContextMenuView(View aContextMenuView) {
        this.mContextMenuView = aContextMenuView;
    }

    protected int getScreenOrientation() {
        return this.mActivity.getResources().getConfiguration().orientation;
    }

    public boolean recreateViewOnOrientationChange() {
        return false;
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
    }

    public boolean onCreateOptionsMenu(Menu aMenu) {
        this.mMenuInflater.inflate(C0116R.menu.default_menu, aMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem aItem) {
        switch (aItem.getItemId()) {
            case C0116R.id.menu_about:
                this.mActivity.startActivity(new Intent(this.mActivity, About.class));
                break;
            case C0116R.id.menu_preferences:
                this.mActivity.startActivity(new Intent(this.mActivity, Preferences.class));
                break;
            default:
                return false;
        }
        return true;
    }

    public void handleFacebookReceiverEvent(Intent aIntent) {
    }

    public void onMediaServiceConnected(SongbirdMediaService aMediaService) {
        this.mService = aMediaService;
        this.mServiceConnected = true;
        try {
            this.mService.registerCallback(this.mMediaEventListener);
            this.mService.setLastActivity(this.mActivity.getIntent());
        } catch (Exception e) {
        }
        onMediaServiceConnected();
    }

    public void onMediaServiceConnected() {
    }

    public void onMediaServiceEvent(int aEvent) {
    }

    private void startService() {
        ((SongbirdApplication) this.mActivity.getApplicationContext()).getMediaService(this);
    }

    private void stopService() {
        if (this.mActivity != null && this.mServiceConnected) {
            try {
                this.mService.unregisterCallback(this.mMediaEventListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.mServiceConnected = false;
        }
    }

    protected void registerContentObserver(Cursor aCursor, BaseAdapter aAdapter, ListView aListView, String aClassName, long delay) {
        final String logname = aClassName.substring(aClassName.lastIndexOf(46) + 1);
        Log.i("ContentObserver", logname + ": register");
        final Cursor cursor = aCursor;
        final BaseAdapter baseAdapter = aAdapter;
        final ListView listView = aListView;
        final long j = delay;
        ContentObserver zContentObserver = new ContentObserver(null) {

            class C02371 implements Runnable {
                C02371() {
                }

                public void run() {
                    Log.i("ContentObserver", logname + ": requery " + cursor.getCount());
                    cursor.requery();
                    Log.i("ContentObserver", logname + ": done " + cursor.getCount());
                    baseAdapter.notifyDataSetChanged();
                    listView.invalidateViews();
                    if (!BaseContentBrowserView.this.isScanning) {
                        BaseContentBrowserView.this.isScanning = true;
                        Utils.podcastScanTaskExecute(BaseContentBrowserView.this.mActivity.getApplicationContext(), BaseContentBrowserView.this.mOnScanComplete);
                    }
                }
            }

            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                Log.i("ContentObserver", logname + ": onChange");
                ContentBrowser.getHandler().postDelayed(new C02371(), j);
            }
        };
        aCursor.registerContentObserver(zContentObserver);
        this.mCoCache.put(aCursor, zContentObserver);
    }

    protected void unregisterContentObserver(Cursor aCursor, String aClassName) {
        String logname = aClassName.substring(aClassName.lastIndexOf(46) + 1);
        Log.i("ContentObserver", logname + ": unregister");
        if (aCursor == null) {
            Log.i("ContentObserver", logname + ": null cursor");
            return;
        }
        ContentObserver zContentObserver = (ContentObserver) this.mCoCache.get(aCursor);
        if (zContentObserver == null) {
            Log.i("ContentObserver", logname + ": no observer found for cursor");
            return;
        }
        try {
            aCursor.unregisterContentObserver(zContentObserver);
        } catch (Throwable e) {
            Log.i("ContentObserver", logname + ":" + e.getMessage());
        }
        this.mCoCache.remove(aCursor);
    }

    protected void log(String aValue) {
        Log.e("Songbird", getClass().getSimpleName() + ": " + aValue);
    }
}
