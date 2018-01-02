package com.miui.player.ui.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import com.miui.player.C0329R;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.IMediaPlaybackService.Stub;
import com.miui.player.service.ServiceHelper;
import com.miui.player.service.ServiceHelper.ServiceToken;
import com.miui.player.service.SleepModeManager;
import com.miui.player.ui.MusicLandActivity;
import com.miui.player.ui.MusicSettings;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.VipRecommendActivity;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.util.Actions;
import com.miui.player.util.MusicAnalyticsUtils;
import com.miui.player.util.ServiceActions.Out;
import com.miui.player.util.Utils;
import com.miui.player.vod.ThunderStoneKtvNetwork;
import miui.analytics.XiaomiAnalytics;

public abstract class MusicBaseActivity extends Activity implements BaseMenuId, ServiceConnection {
    protected static final String KEY_ACTION = "old_activity_action";
    protected static final String KEY_CLASS = "old_activity_class";
    protected static final String KEY_DATA = "old_activity_data";
    protected static final String KEY_SAVE_INFO = "old_activity_save_info";
    protected static final String KEY_TYPE = "old_activity_type";
    static final int MSG_IS_NOT_PLAYING = 0;
    static final int MSG_IS_PLAYING = 1;
    private static final String TAG = MusicBaseActivity.class.getName();
    private boolean mCreateContentCalled = false;
    private final BroadcastReceiver mKillProcessReceiver = new C04731();
    private int mLastOrientation = 0;
    private boolean mPaused = true;
    private final ServiceStatusListener mServiceStatusListener = new ServiceStatusListener();
    private ServiceToken mToken;
    Handler mVolumeHandler = new C04742();

    class C04731 extends BroadcastReceiver {
        C04731() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Out.KILL_PROCESS.equals(action)) {
                MusicBaseActivity.this.onKillProcess();
                MusicBaseActivity.this.finish();
            } else if (Actions.ACTION_FINISH_ALL_ACTIVITY.equals(action)) {
                MusicBaseActivity.this.finish();
            }
        }
    }

    class C04742 extends Handler {
        C04742() {
        }

        public void handleMessage(Message msg) {
            XiaomiAnalytics analytics = XiaomiAnalytics.getInstance();
            switch (msg.what) {
                case 0:
                    analytics.trackEvent(MusicAnalyticsUtils.EVENT_ADJUST_VOLUME_WHEN_NOT_PLAYING);
                    return;
                case 1:
                    analytics.trackEvent(MusicAnalyticsUtils.EVENT_ADJUST_VOLUME_WHEN_PLAYING);
                    return;
                default:
                    return;
            }
        }
    }

    class ServiceStatusListener extends BroadcastReceiver {
        ServiceStatusListener() {
        }

        public void register(String[] actions) {
            if (actions != null && actions.length > 0) {
                IntentFilter filter = new IntentFilter();
                for (String action : actions) {
                    filter.addAction(action);
                }
                MusicBaseActivity.this.registerReceiver(this, filter);
            }
        }

        public void unregister() {
            UIHelper.unregistBroadcastReceiverSafe(MusicBaseActivity.this, this);
        }

        public void onReceive(Context context, Intent intent) {
            MusicBaseActivity.this.handleServiceNotification(intent);
        }
    }

    protected final void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        if (isLandScape() || getResources().getConfiguration().orientation != 2) {
            getWindow().setFormat(1);
            setVolumeControlStream(3);
            onCreateContent(icicle);
            this.mCreateContentCalled = true;
            if (needBindToService()) {
                this.mToken = ServiceHelper.bindToService(this, this);
            }
            IntentFilter filter = new IntentFilter();
            filter.addAction(Out.KILL_PROCESS);
            filter.addAction(Actions.ACTION_FINISH_ALL_ACTIVITY);
            registerReceiver(this.mKillProcessReceiver, filter);
            return;
        }
        startLandActivity();
        finish();
    }

    protected void onDestroy() {
        if (this.mCreateContentCalled) {
            onDestroyContent();
        }
        if (this.mToken != null) {
            ServiceHelper.unbindFromService(this.mToken);
            this.mToken = null;
        }
        UIHelper.unregistBroadcastReceiverSafe(this, this.mKillProcessReceiver);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        this.mServiceStatusListener.register(getObservedServiceActions());
        this.mPaused = false;
        XiaomiAnalytics.getInstance().startSession(this);
    }

    protected void onPause() {
        this.mServiceStatusListener.unregister();
        XiaomiAnalytics.getInstance().endSession();
        this.mPaused = true;
        super.onPause();
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    protected boolean saveData(Bundle outcicle) {
        return false;
    }

    private void startLandActivity() {
        Intent myIntent = getIntent();
        Intent intent = new Intent(Actions.ACTION_LANDSCAPE_VIEW);
        intent.setClass(this, MusicLandActivity.class);
        intent.putExtra(KEY_ACTION, myIntent.getAction());
        intent.putExtra(KEY_TYPE, myIntent.getType());
        intent.putExtra(KEY_DATA, myIntent.getData());
        intent.putExtra(KEY_CLASS, getClass());
        Bundle outcicle = new Bundle();
        if (saveData(outcicle)) {
            intent.putExtra(KEY_SAVE_INFO, outcicle);
        }
        startActivity(intent);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation != this.mLastOrientation) {
            this.mLastOrientation = newConfig.orientation;
            if (newConfig.orientation == 2) {
                startLandActivity();
                finish();
            } else if (newConfig.orientation == 1) {
                Intent myIntent = getIntent();
                Class<?> clz = (Class) myIntent.getSerializableExtra(KEY_CLASS);
                if (clz != null) {
                    Intent intent = new Intent();
                    intent.setClass(this, clz);
                    intent.setAction(myIntent.getStringExtra(KEY_ACTION));
                    intent.setDataAndType((Uri) myIntent.getParcelableExtra(KEY_DATA), myIntent.getStringExtra(KEY_TYPE));
                    Bundle saveInfo = myIntent.getBundleExtra(KEY_SAVE_INFO);
                    if (saveInfo != null) {
                        intent.putExtras(saveInfo);
                    }
                    startActivity(intent);
                    finish();
                    return;
                }
                Log.e(TAG, "last orientation=" + this.mLastOrientation + ", new orientation=" + newConfig.orientation);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (Utils.isOnlineVaild()) {
            menu.add(0, 30, 96, C0329R.string.menu_higher_quality_music);
        }
        if (ThunderStoneKtvNetwork.isKtvValid()) {
            menu.add(0, 29, 97, C0329R.string.find_ktv);
        }
        menu.add(0, 15, 98, SleepModeManager.getMenuTitle());
        menu.add(0, 14, 99, C0329R.string.music_settings);
        menu.add(0, 18, 100, C0329R.string.quit_player);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(15);
        if (item != null) {
            item.setTitle(SleepModeManager.getMenuTitle());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 14:
                startActivity(new Intent(this, MusicSettings.class));
                return true;
            case 15:
                SleepModeManager.toggleSleepMode(this);
                return true;
            case BaseMenuId.QUIT /*18*/:
                ServiceHelper.quitMediaPlay(this);
                finish();
                return true;
            case BaseMenuId.FIND_KTV /*29*/:
                startActivity(new Intent(Actions.ACTION_FIND_KTV));
                return true;
            case 30:
                startActivity(new Intent(this, VipRecommendActivity.class));
                MusicAnalyticsUtils.trackEvent(MusicAnalyticsUtils.EVENT_PAYMENT_EXTRANCE, "菜单");
                return true;
            case 16908311:
                UIHelper.startPlaybackView(this);
                return true;
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected String getTag() {
        return getClass().getCanonicalName();
    }

    protected void onKillProcess() {
    }

    protected String[] getObservedServiceActions() {
        return null;
    }

    protected void handleServiceNotification(Intent intent) {
    }

    protected boolean needBindToService() {
        return true;
    }

    protected void handleServiceConnected(IMediaPlaybackService service) throws RemoteException {
    }

    protected void handleServiceDisconnected() {
    }

    public void onServiceConnected(ComponentName classname, IBinder obj) {
        IMediaPlaybackService serv = Stub.asInterface(obj);
        if (serv != null) {
            try {
                handleServiceConnected(serv);
                invalidateOptionsMenu();
                return;
            } catch (RemoteException e) {
            }
        }
        finish();
    }

    public void onServiceDisconnected(ComponentName classname) {
        handleServiceDisconnected();
        finish();
    }

    protected void onCreateContent(Bundle icicle) {
    }

    protected void onDestroyContent() {
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean z = false;
        if (keyCode == 25 || keyCode == 24) {
            int isPlaying;
            if (ServiceHelper.isPlaying()) {
                isPlaying = 1;
            } else {
                isPlaying = 0;
            }
            if (this.mVolumeHandler.hasMessages(isPlaying)) {
                this.mVolumeHandler.removeMessages(isPlaying);
            }
            this.mVolumeHandler.sendEmptyMessageDelayed(isPlaying, 2000);
        }
        boolean handled = false;
        if (keyCode == 25 || keyCode == 24) {
            IMediaPlaybackService service = ServiceHelper.sService;
            if (service != null) {
                if (keyCode == 24) {
                    z = true;
                }
                try {
                    handled = service.adjustVolume(z);
                } catch (RemoteException e) {
                }
            }
        }
        if (!handled) {
            return super.onKeyDown(keyCode, event);
        }
        Log.d(getTag(), "volume key is handled by service");
        return true;
    }

    protected boolean isLandScape() {
        return false;
    }
}
