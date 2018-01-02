package com.miui.player.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.miui.player.C0329R;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper;
import com.miui.player.provider.MediaProviderHelper;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MediaCursorLoader.CursorDecorator;
import com.miui.player.ui.base.MediaCursorLoader.MediaLoaderInfo;
import com.miui.player.ui.base.MediaCursorLoader.QueryArgs;
import com.miui.player.ui.controller.MultiChoiceController.ModeChangedListener;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.util.FolderProvider;
import com.miui.player.util.LoopChecker;
import com.miui.player.util.LoopChecker.CheckAction;
import com.miui.player.util.PlaylistRecoverer;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.SectionCursor;
import com.miui.player.util.SectionCursor.CursorConverter;
import com.miui.player.util.Utils;
import com.miui.player.vod.ThunderStoneKtvNetwork;
import miui.v5.widget.Views;

public abstract class MusicBaseFragment extends Fragment implements BaseMenuId, OnItemClickListener, ModeChangedListener {
    protected static final long DELAY_LOADER_QUERY = 500;
    private static final long DELAY_RESCAN = 1000;
    protected static final int ID_LOADER_QUERY = 1;
    private static final int MSG_RESCAN = 1;
    private static final int RECOVER_RETRY_COUNT = 10;
    private static final int RECOVER_RETRY_DELAY = 2000;
    private final CheckAction mDatabaseChecker = new C04773();
    protected int mFolderUpdateVersion;
    private AbsListView mListView;
    private LoopChecker mLoopChecker;
    private final BroadcastReceiver mMountReceiver = new C04762();
    private boolean mPaused = true;
    protected int mRecoverVersion;
    final Handler mRescanHandler = new C04751();
    protected IMediaPlaybackService mService;
    private final ServiceStatusListener mServiceStatusListener = new ServiceStatusListener();
    private View mSuspendFootBar = null;

    class C04751 extends Handler {
        C04751() {
        }

        public void handleMessage(Message msg) {
            MusicBaseFragment.this.launchLoader(true);
        }
    }

    class C04762 extends BroadcastReceiver {
        C04762() {
        }

        public void onReceive(Context context, Intent intent) {
            MusicBaseFragment.this.mRescanHandler.removeMessages(1);
            MusicBaseFragment.this.mRescanHandler.sendEmptyMessageDelayed(1, 1000);
        }
    }

    class C04773 implements CheckAction {
        C04773() {
        }

        public boolean handle() {
            int status = MediaProviderHelper.getStatus(MusicBaseFragment.this.getActivity());
            if (status == 1) {
                return true;
            }
            if (status == 2) {
                return false;
            }
            boolean needLaunch = MusicBaseFragment.this.updateFolder();
            if (MusicBaseFragment.this.recoverPlayList() || needLaunch) {
                needLaunch = true;
            } else {
                needLaunch = false;
            }
            if (!needLaunch) {
                return true;
            }
            MusicBaseFragment.this.launchLoader(true);
            return true;
        }
    }

    protected abstract class TemplateLoaderCallback implements LoaderCallbacks<Cursor> {
        protected TemplateLoaderCallback() {
        }

        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            Utils.debugLog(MusicBaseFragment.this.getTag(), "loader finished " + loader.getId());
            MusicBaseFragment.this.handleLoadFinished(loader.getId(), data);
            if (MusicBaseFragment.this.isActivityWorking()) {
                MusicBaseFragment.this.mRescanHandler.removeMessages(1);
                if (data == null) {
                    UIHelper.displayDatabaseError(MusicBaseFragment.this.getActivity());
                    if (Utils.isExternalStorageMounted()) {
                        MusicBaseFragment.this.mRescanHandler.sendEmptyMessageDelayed(1, 1000);
                        return;
                    }
                    return;
                }
                UIHelper.hideDatabaseError(MusicBaseFragment.this.getActivity());
            }
        }

        public void onLoaderReset(Loader<Cursor> loader) {
            Utils.debugLog(MusicBaseFragment.this.getTag(), "loader reset " + loader.getId());
            MusicBaseFragment.this.handleLoaderReset(loader.getId());
        }
    }

    private class MediaCursorLoaderCallback extends TemplateLoaderCallback {
        private final long mDelay;
        private final MediaLoaderInfo mMediaStoreLoaderInfo;

        public MediaCursorLoaderCallback(MediaLoaderInfo info, long delay) {
            super();
            this.mMediaStoreLoaderInfo = info;
            this.mDelay = delay;
        }

        public MediaCursorLoader onCreateLoader(int id, Bundle args) {
            Utils.debugLog(MusicBaseFragment.this.getTag(), "loader create " + id);
            switch (id) {
                case 1:
                    MediaCursorLoader loader = new MediaCursorLoader(MusicBaseFragment.this.getActivity(), this.mMediaStoreLoaderInfo);
                    loader.setUpdateThrottle(this.mDelay);
                    return loader;
                default:
                    return null;
            }
        }
    }

    public static class SectionCursorDecorator implements CursorDecorator {
        private final CursorConverter mConveter;
        protected final int mHeaderCount;

        public SectionCursorDecorator(CursorConverter converter, int headerCount) {
            this.mConveter = converter;
            this.mHeaderCount = headerCount;
        }

        public Cursor decorate(Cursor cursor, QueryArgs args) {
            return SectionCursor.wrap(cursor, this.mConveter, this.mHeaderCount);
        }

        public boolean isRawCursorClosable() {
            return true;
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
                MusicBaseFragment.this.getActivity().registerReceiver(this, filter);
            }
        }

        public void unregister() {
            UIHelper.unregistBroadcastReceiverSafe(MusicBaseFragment.this.getActivity(), this);
        }

        public void onReceive(Context context, Intent intent) {
            MusicBaseFragment.this.handleServiceNotification(intent);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mFolderUpdateVersion = FolderProvider.updateFolderItemListIfNeeded(getActivity());
        this.mRecoverVersion = PlaylistRecoverer.recoverIfNeeded(getActivity());
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        launchLoader(false);
        this.mListView = (AbsListView) view.findViewById(16908298);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
        return inflater.inflate(C0329R.layout.template_list_fragment, container, false);
    }

    public void onResume() {
        super.onResume();
        this.mServiceStatusListener.register(getObservedServiceActions());
        this.mLoopChecker = LoopChecker.check(this.mDatabaseChecker, 10, 2000);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.MEDIA_MOUNTED");
        filter.addDataScheme("file");
        getActivity().registerReceiver(this.mMountReceiver, filter);
        this.mPaused = false;
    }

    public void onPause() {
        if (this.mLoopChecker != null) {
            this.mLoopChecker.reset();
            this.mLoopChecker = null;
        }
        UIHelper.unregistBroadcastReceiverSafe(getActivity(), this.mMountReceiver);
        this.mRescanHandler.removeMessages(1);
        this.mServiceStatusListener.unregister();
        this.mPaused = true;
        super.onPause();
    }

    public void onDestroy() {
        leaveMultiChoiceMode();
        super.onDestroy();
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public boolean isActivityWorking() {
        Activity a = getActivity();
        return (a == null || a.isFinishing()) ? false : true;
    }

    public AbsListView getListView() {
        return this.mListView;
    }

    protected MediaLoaderInfo getMediaLoaderInfo() {
        return null;
    }

    protected void handleLoadFinished(int loaderId, Cursor cursor) {
    }

    protected void handleLoaderReset(int loaderId) {
        CursorAdapter ca = getCursorAdapter();
        if (ca != null) {
            ca.changeCursor(null);
        }
    }

    protected boolean handleRecoverd() {
        return false;
    }

    protected boolean handleFolderProviderUpdated() {
        return false;
    }

    protected CursorAdapter getCursorAdapter() {
        return null;
    }

    public void launchLoader(boolean reset) {
        MediaLoaderInfo info = getMediaLoaderInfo();
        if (info != null) {
            Loader<Cursor> loader = getLoaderManager().getLoader(1);
            if (reset && loader != null) {
                getLoaderManager().destroyLoader(1);
            }
            getLoaderManager().initLoader(1, null, new MediaCursorLoaderCallback(info, 500));
        }
    }

    public boolean isBatchSelectionModeEnabled() {
        return false;
    }

    public boolean enterMultiChoiceMode() {
        AbsListView v = getListView();
        if (v instanceof ListView) {
            ListView lv = (ListView) v;
            if (lv.getCount() <= lv.getHeaderViewsCount()) {
                return false;
            }
            lv.setItemChecked(-1, true);
            return true;
        }
        v.setItemChecked(-1, true);
        return true;
    }

    public boolean leaveMultiChoiceMode() {
        return false;
    }

    public void setListAdapter(ListAdapter adapter) {
        AbsListView list = getListView();
        if (list != null) {
            list.setAdapter(adapter);
        }
    }

    public void onModeChanged(boolean enabled, AbsListView lv) {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
    }

    boolean updateFolder() {
        int folderVersion = FolderProvider.updateFolderItemListIfNeeded(getActivity());
        if (this.mFolderUpdateVersion < folderVersion) {
            this.mFolderUpdateVersion = folderVersion;
            if (!handleFolderProviderUpdated()) {
                return true;
            }
        }
        return false;
    }

    boolean recoverPlayList() {
        int recoverVersion = PlaylistRecoverer.instance(getActivity()).recover(getActivity());
        if (this.mRecoverVersion < recoverVersion) {
            this.mRecoverVersion = recoverVersion;
            if (!handleRecoverd()) {
                return true;
            }
        }
        return false;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 11:
                Utils.debugLog(getTag(), "scan finished!");
                launchLoader(true);
                return;
            default:
                return;
        }
    }

    protected String[] getObservedServiceActions() {
        return null;
    }

    protected void handleServiceNotification(Intent intent) {
    }

    public void setService(IMediaPlaybackService service) {
        this.mService = service;
    }

    protected void refreshChoiceMode() {
        if (getListView() instanceof ListView) {
            ListView listView = (ListView) getListView();
            if (ThunderStoneKtvNetwork.isBinded()) {
                listView.setChoiceMode(0);
            } else {
                listView.setChoiceMode(3);
            }
        }
    }

    protected void refreshFootView() {
        if (getListView() instanceof ListView) {
            ListView listView = (ListView) getListView();
            if (ThunderStoneKtvNetwork.isBinded() || ((AccountPermissionHelper.needRemind() && !PreferenceCache.getPrefAsBoolean(getActivity(), PreferenceCache.PREF_VIP_REMINDED)) || (AccountPermissionHelper.isVipTimeOut() && !PreferenceCache.getPrefAsBoolean(getActivity(), PreferenceCache.PREF_VIP_TIME_OUT)))) {
                if (this.mSuspendFootBar == null) {
                    this.mSuspendFootBar = Views.inflate(getActivity(), C0329R.layout.suspend_bar, null, false);
                    this.mSuspendFootBar.setVisibility(4);
                    listView.addFooterView(this.mSuspendFootBar);
                }
            } else if (this.mSuspendFootBar != null) {
                listView.removeFooterView(this.mSuspendFootBar);
                this.mSuspendFootBar = null;
            }
        }
    }
}
