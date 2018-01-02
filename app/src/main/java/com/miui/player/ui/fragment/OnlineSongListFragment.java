package com.miui.player.ui.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.Out;
import com.miui.player.meta.Audio;
import com.miui.player.network.MP3Downloader;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.network.OnlineMusicProxy.CacheListener;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.plugin.onlinemusic2.AudioSearchResult;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.OnlinePlaylistActivity;
import com.miui.player.ui.SongGroupActivity;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.ui.controller.MultiChoiceController.ModeChangedListener;
import com.miui.player.ui.menu.BaseMenuManager;
import com.miui.player.ui.menu.BaseTrackBrowserMenu.ContextInfo;
import com.miui.player.ui.menu.OnlineSongMenu;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.ui.model.OnlineSongAdapter;
import com.miui.player.ui.model.OnlineSongAdapter.HeadViewController;
import com.miui.player.util.Actions;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.model.MetaList;
import com.xiaomi.music.online.model.SongGroup;
import java.lang.ref.WeakReference;
import java.util.List;
import miui.cache.RequestManager;
import miui.cache.RequestManager.Request;
import miui.v5.widget.Views;

public class OnlineSongListFragment extends ListFragmentWithLoading<Audio, AudioList> implements ModeChangedListener, BaseMenuId, HeadViewController {
    private static final int HEADER_ID_SHUFFLE_ALL = 1;
    private final Runnable mAdapterUpdateRunnable = new C05044();
    private String mChannelIntro;
    private final BroadcastReceiver mDownloadReceiver = new C05022();
    private ImageView mHeadIcon;
    private boolean mIsBill;
    private boolean mIsChannel;
    private String mKey;
    protected BaseMenuManager<String> mMenuManager;
    protected MultiChoiceController<String> mMultiChoiceController;
    private int mPlaylistId = -1;
    private int mPlaylistType = -1;
    private TextView mSearchResult;
    private BroadcastReceiver mServiceListener = new C05055();
    private View mShuffleAll;
    private String mSongGroupId;
    private String mSongGroupName;
    private int mType;

    class C05011 implements OnClickListener {
        C05011() {
        }

        public void onClick(View v) {
            OnlineSongListFragment.this.toggleCollect();
        }
    }

    class C05022 extends BroadcastReceiver {
        C05022() {
        }

        public void onReceive(Context context, Intent intent) {
            if (Actions.ACTION_ONLINE_DOWNLOAD_COMPLETE.equals(intent.getAction())) {
                OnlineSongListFragment.this.updateDownloadStatus();
            }
        }
    }

    class C05033 implements Runnable {
        C05033() {
        }

        public void run() {
            OnlineSongListFragment.this.update();
        }
    }

    class C05044 implements Runnable {
        C05044() {
        }

        public void run() {
            OnlineSongListFragment.this.updateDownloadStatus();
        }
    }

    class C05055 extends BroadcastReceiver {
        C05055() {
        }

        public void onReceive(Context context, Intent intent) {
            OnlineSongListFragment.this.update();
        }
    }

    static class CacheForAudioListOfBill implements CacheListener<List<AudioList>> {
        private OnlineSongListFragment mFragment;

        public CacheForAudioListOfBill(OnlineSongListFragment f) {
            this.mFragment = f;
        }

        public void onCacheLoaded(List<AudioList> data) {
            if (data != null && !data.isEmpty()) {
                this.mFragment.onCacheLoaded((MetaList) data.get(0));
            }
        }
    }

    static class CacheForAudioQuery implements CacheListener<AudioSearchResult> {
        private OnlineSongListFragment mFragment;

        public CacheForAudioQuery(OnlineSongListFragment f) {
            this.mFragment = f;
        }

        public void onCacheLoaded(AudioSearchResult data) {
            if (data != null) {
                this.mFragment.onCacheLoaded(data.mAudioList);
            }
        }
    }

    public static class SongGroupRequest implements Request<String, AudioList, String> {
        private final Context mContext;
        private final WeakReference<ProgressDialog> mDialogRef;
        private final String mGroupId;
        private final String mName;

        public SongGroupRequest(Activity activity, String groupId, String name, ProgressDialog dialog) {
            this.mContext = activity.getApplication();
            this.mGroupId = groupId;
            this.mName = name;
            this.mDialogRef = new WeakReference(dialog);
        }

        public AudioList computAsync() {
            Result<SongGroup> result = MusicEngine.get(this.mContext).getOnlineEngine().getSongGroup(this.mContext, this.mGroupId);
            if (result.mErrorCode != 1 || result.mData == null) {
                return null;
            }
            return OnlineMusicProxy.requestAudioListOfChannel(this.mContext, this.mGroupId, 1, Math.min(result.mData.mCount, 50), null, 2);
        }

        public String getKey() {
            return OnlineMusicProxy.getUrlForChannel(this.mContext, this.mGroupId, 1, 50);
        }

        public String getRemoveKey() {
            return null;
        }

        public boolean isRemovable() {
            return false;
        }

        public boolean needCache() {
            return true;
        }

        public void onCompleted(AudioList value, boolean finalValue) {
            if (finalValue) {
                ProgressDialog dialog = (ProgressDialog) this.mDialogRef.get();
                if (dialog == null) {
                    return;
                }
                if (dialog.isShowing() || !dialog.isIndeterminate()) {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    if (value == null || !value.isValid()) {
                        Toast.makeText(this.mContext, C0329R.string.load_audio_failed, 0).show();
                        return;
                    }
                    ServiceHelper.playAll(this.mContext, value.getContent(), OnlineMusicProxy.getProviderName(this.mContext), -1, false, false, this.mName);
                }
            }
        }

        public void onRemoved() {
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = true;
        super.onCreate(savedInstanceState);
        Bundle data = savedInstanceState != null ? savedInstanceState : getActivity().getIntent().getExtras();
        if (data != null) {
            boolean z2;
            SongGroup songGroup = (SongGroup) data.getSerializable(Actions.KEY_AUDIO_LIST_SONG_GROUP);
            if (songGroup != null) {
                this.mSongGroupId = songGroup.mId;
                this.mSongGroupName = songGroup.mName;
                this.mChannelIntro = songGroup.mIntro;
            } else {
                this.mSongGroupId = data.getString(Actions.KEY_PLAYLIST_ONLINE_ID);
                this.mSongGroupName = data.getString("playlist_name");
            }
            this.mPlaylistType = data.getInt(Actions.KEY_PLAYLIST_TYPE, -1);
            if (this.mPlaylistType == 102) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mIsBill = z2;
            if (this.mPlaylistType == 101) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mIsChannel = z2;
        }
        if (this.mIsChannel) {
            z = false;
        }
        setHasOptionsMenu(z);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
        return inflater.inflate(C0329R.layout.online_song_list_fragment, container, false);
    }

    public void initializeAdapter(View v) {
        Activity a = getActivity();
        ListView lv = this.mList;
        lv.setOnItemClickListener(this);
        if (this.mType == 5) {
            this.mSearchResult = (TextView) Views.inflate(a, C0329R.layout.search_result_header, lv, false);
            lv.addHeaderView(this.mSearchResult);
        } else {
            boolean showCollection;
            if ((a instanceof SongGroupActivity) || (a instanceof OnlinePlaylistActivity)) {
                showCollection = true;
            } else {
                showCollection = false;
            }
            int collectIconId = 0;
            if (showCollection) {
                TypedValue outValue = new TypedValue();
                a.getTheme().resolveAttribute(C0329R.attr.listCollect, outValue, true);
                collectIconId = outValue.resourceId;
            }
            if (!showCollection) {
                collectIconId = 0;
            }
            this.mShuffleAll = UIHelper.makeSpecialView(lv, 1, collectIconId, C0329R.string.click_to_play_all);
            lv.addHeaderView(this.mShuffleAll);
            if (showCollection) {
                this.mHeadIcon = UIHelper.getSpecialViewIconView(this.mShuffleAll);
                this.mHeadIcon.setOnClickListener(new C05011());
            }
            if (this.mIsChannel && !TextUtils.isEmpty(this.mChannelIntro)) {
                Resources res = getResources();
                int paddingHorizon = res.getDimensionPixelSize(101318693);
                int textSize = res.getDimensionPixelSize(101318726);
                TextView textView = new TextView(getActivity());
                textView.setText(this.mChannelIntro);
                textView.setTextColor(res.getColor(C0329R.color.black_60_transparent));
                textView.setTextSize(0, (float) textSize);
                textView.setPadding(paddingHorizon, textSize, paddingHorizon, 0);
                lv.addHeaderView(textView);
            }
        }
        this.mMenuManager = new OnlineSongMenu(this, C0329R.plurals.Nitems_batch_selection);
        this.mMultiChoiceController = new MultiChoiceController(lv, this.mMenuManager);
        this.mMultiChoiceController.setItemViewBinder(UIHelper.createBinderForList(C0329R.id.batch_selection_check));
        this.mMultiChoiceController.setOnModeChangedListener(this);
        this.mAdapter = new OnlineSongAdapter(a, this.mMultiChoiceController, this, this.mIsBill);
        this.mMenuManager.setAdapter(this.mAdapter);
    }

    public void onDestroyView() {
        this.mMenuManager.setAdapter(null);
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        Activity a = getActivity();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Out.STATUS_QUEUE_CHANGED);
        filter.addAction(Out.STATUS_META_CHANGED);
        filter.addAction(Out.STATUS_PLAYSTATE_CHANGED);
        filter.addAction(Out.STATUS_PLAYBACK_COMPLETE);
        a.registerReceiver(this.mServiceListener, filter);
        a.registerReceiver(this.mDownloadReceiver, new IntentFilter(Actions.ACTION_ONLINE_DOWNLOAD_COMPLETE));
        updateDownloadStatus();
        refreshChoiceMode();
        refreshCollection();
    }

    public void onPause() {
        Activity a = getActivity();
        a.unregisterReceiver(this.mDownloadReceiver);
        a.unregisterReceiver(this.mServiceListener);
        super.onPause();
    }

    void updateDownloadStatus() {
        if (this.mAdapter != null) {
            ((OnlineSongAdapter) this.mAdapter).updateDownloadStatus();
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (this.mMenuManager.onContextItemSelected(item)) {
            return true;
        }
        return super.onContextItemSelected(item);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (this.mMultiChoiceController == null || !this.mMultiChoiceController.isEnabled()) {
            menu.add(0, 27, 0, C0329R.string.download_all_track);
            this.mMenuManager.onCreateOptionsMenu(menu);
            super.onCreateOptionsMenu(menu, inflater);
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        this.mMenuManager.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case BaseMenuId.DOWNLOAD_ALL_TRACK /*27*/:
                Runnable runnable = new C05033();
                MP3Downloader.startOnUIThread(getActivity(), getContextInfo().mSongList, runnable);
                return true;
            default:
                if (this.mMenuManager.onOptionsItemSelected(item)) {
                    return true;
                }
                return super.onOptionsItemSelected(item);
        }
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        if (!this.mIsChannel || position != 0 || this.mSongGroupId == null || this.mSongGroupName == null) {
            AudioList audioList = (AudioList) this.mAdapter.getData();
            if (audioList != null) {
                IMediaPlaybackService service = ServiceHelper.sService;
                if (service != null) {
                    try {
                        service.setRepeatMode(0);
                        if (position == 0) {
                            service.setShuffleMode(0);
                        }
                    } catch (RemoteException e) {
                    }
                }
                Activity a = getActivity();
                ServiceHelper.playAll(a, audioList.getContent(), OnlineMusicProxy.getProviderName(a), Math.max(0, position - UIHelper.getListViewHeaderCount(l)), false, false);
                return;
            }
            return;
        }
        UIHelper.playChannel(getActivity(), this.mSongGroupId, this.mSongGroupName);
    }

    public ContextInfo<String> getContextInfo() {
        ContextInfo<String> ctx = new ContextInfo();
        ctx.mSongList = (AudioList) this.mAdapter.getData();
        ctx.mRefreshRunnable = this.mAdapterUpdateRunnable;
        ctx.mListView = this.mList;
        ctx.mMultiChoiceController = this.mMultiChoiceController;
        return ctx;
    }

    public void onModeChanged(boolean enabled, AbsListView lv) {
        if (this.mShuffleAll != null) {
            UIHelper.setChildEnabled((ViewGroup) this.mShuffleAll, !enabled);
        }
    }

    public boolean leaveMultiChoiceMode() {
        if (this.mMultiChoiceController == null) {
            return false;
        }
        return this.mMultiChoiceController.leave();
    }

    public void requestAudioList(int type, String key, boolean forceLaunch) {
        if (!(TextUtils.equals(this.mKey, key) || this.mList == null)) {
            this.mList.setSelection(0);
        }
        this.mType = type;
        this.mKey = key;
        if (forceLaunch) {
            launch();
        }
    }

    public void launch() {
        Activity activity = getActivity();
        if ((activity instanceof SongGroupActivity) && ((SongGroupActivity) activity).needLaunch()) {
            ((SongGroupActivity) activity).launch();
        } else if (this.mType != 0 && !this.mIsChannel) {
            super.launch();
        }
    }

    protected int getLoadFailedId() {
        return C0329R.string.load_audio_failed;
    }

    protected int getLoadInProcessId() {
        return C0329R.string.load_audio_in_process;
    }

    protected RequestManager<String, AudioList, String> getRequestManager() {
        return OnlineMusicProxy.getAudioListRequestManager(getActivity());
    }

    public boolean needCache() {
        return this.mType != 5;
    }

    public AudioList doComput(int opt) {
        Context context = getActivity();
        if (context == null) {
            return null;
        }
        switch (this.mType) {
            case 5:
                return OnlineMusicProxy.queryAudio(context, this.mKey, 1, this.mLoadingCount, null, 2);
            case 6:
                Result<SongGroup> result = MusicEngine.get(context).getOnlineEngine().getSongGroup(context, this.mKey);
                if (result.mErrorCode != 1 || result.mData == null) {
                    return null;
                }
                return OnlineMusicProxy.requestAudioListOfGroup(context, this.mKey, 1, result.mData.mCount, null, 2);
            default:
                throw new UnsupportedOperationException("bad type: type=" + this.mType + " key=" + this.mKey);
        }
    }

    public String getKey() {
        Context context = MusicApplication.getApplication();
        switch (this.mType) {
            case 5:
                return OnlineMusicProxy.getUrlForSearch(context, this.mKey, 1, 50);
            case 6:
                return "songgroup#" + this.mKey;
            default:
                throw new UnsupportedOperationException("bad type: type=" + this.mType + " key=" + this.mKey);
        }
    }

    public void onCompleted(AudioList data, boolean isFinal) {
        boolean z = true;
        super.onCompleted((MetaList) data, isFinal);
        if (this.mAdapter != null) {
            int count = this.mAdapter.getCount();
            if (this.mShuffleAll != null) {
                View findViewById = this.mShuffleAll.findViewById(C0329R.id.icon);
                if (count <= 0) {
                    z = false;
                }
                findViewById.setEnabled(z);
            } else if (this.mSearchResult != null) {
                this.mSearchResult.setText(getResources().getQuantityString(C0329R.plurals.Ntracks_search_result_format, count, new Object[]{Integer.valueOf(count)}));
            }
        }
    }

    public void updateHeadView(int count) {
        if (this.mShuffleAll != null) {
            int plurals = C0329R.plurals.Ntracks_total;
            if (this.mType == 2) {
                plurals = C0329R.plurals.Nhot_tracks_total;
            }
            String text = getResources().getQuantityString(plurals, count, new Object[]{Integer.valueOf(count)});
            TextView tv = (TextView) this.mShuffleAll.findViewById(C0329R.id.num);
            tv.setVisibility(0);
            tv.setText(text);
        }
    }

    public void update() {
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    protected String[] getObservedServiceActions() {
        return new String[]{Actions.ACTION_KTV_SONG_VOD_STATE_CHANGED, Actions.ACTION_KTV_CONNECT_CHANGED};
    }

    protected void handleServiceNotification(Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (Actions.ACTION_KTV_CONNECT_CHANGED.equals(action)) {
            refreshChoiceMode();
        } else if (Actions.ACTION_KTV_SONG_VOD_STATE_CHANGED.equals(action)) {
            update();
        }
    }

    private void refreshCollection() {
        boolean z = false;
        if (this.mHeadIcon != null) {
            if (this.mSongGroupName == null || this.mPlaylistType == -1) {
                this.mHeadIcon.setVisibility(8);
                return;
            }
            this.mPlaylistId = PlaylistHelper.queryPlaylistId(getActivity(), this.mSongGroupName, this.mPlaylistType);
            this.mHeadIcon.setVisibility(0);
            ImageView imageView = this.mHeadIcon;
            if (this.mPlaylistId != -1) {
                z = true;
            }
            imageView.setSelected(z);
        }
    }

    private void toggleCollect() {
        int toastStringRes = 0;
        if (this.mPlaylistId == -1) {
            PlaylistHelper.createPlaylist(getActivity(), this.mSongGroupId, this.mSongGroupName, this.mPlaylistType);
            switch (this.mPlaylistType) {
                case 101:
                    toastStringRes = C0329R.string.collect_fm_success;
                    break;
                case 102:
                    toastStringRes = C0329R.string.collect_bill_success;
                    break;
                case 103:
                    toastStringRes = C0329R.string.collect_topic_success;
                    break;
                default:
                    break;
            }
        }
        PlaylistHelper.deletePlaylist(getActivity(), (long) this.mPlaylistId);
        toastStringRes = C0329R.string.uncollect_success;
        if (toastStringRes > 0) {
            UIHelper.toastSafe(toastStringRes, new Object[0]);
        }
        refreshCollection();
    }

    public boolean isDataReady() {
        return super.isDataReady() || this.mIsChannel;
    }

    public void updateSongGroup(SongGroup songGroup) {
        this.mSongGroupId = songGroup.mId;
        this.mSongGroupName = songGroup.mName;
        this.mPlaylistType = 103;
        refreshCollection();
    }
}
