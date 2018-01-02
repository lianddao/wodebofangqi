package com.miui.player.ui;

import android.accounts.Account;
import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.TwoStatePreference;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.cloud.MusicSyncAdapter;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper.AccountPermissionListener;
import com.miui.player.receiver.PriorityStorageBroadcastReceiver;
import com.miui.player.ui.model.AlbumListAdapter;
import com.miui.player.util.AccountUtils;
import com.miui.player.util.FolderProvider;
import com.miui.player.util.MusicAnalyticsUtils;
import com.miui.player.util.PlaylistRecoverer;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.ServiceActions.In;
import com.miui.player.util.StorageUtils;
import com.miui.player.util.Utils;
import com.xiaomi.music.util.NetworkUtil;
import miui.accounts.ExtraAccountManager;

public class MusicSettings extends PreferenceActivity implements OnPreferenceChangeListener, OnPreferenceClickListener, AccountPermissionListener {
    private static final String KEY_PRIORITY_STORAGE = "priority_storage";
    private PreferenceCategory mAccountSetting;
    private OptionPreference mBaiduAccountPreference;
    Preference mFilterCategoryPref;
    private OptionPreference mHigherMusicQualityPreference;
    private BroadcastReceiver mMountReceiver = new C04531();
    Preference mPlayAndDownload;
    private CheckBoxPreference mPriorityStoragePreference;
    private CheckBoxPreference mSynchronizePlaylistPreference;
    private OptionPreference mXiaomiAccountPreference;

    class C04531 extends BroadcastReceiver {
        C04531() {
        }

        public void onReceive(Context context, Intent intent) {
            boolean isExternalStoreageMounted = Utils.isExternalStorageMounted();
            MusicSettings.this.mFilterCategoryPref.setEnabled(isExternalStoreageMounted);
            MusicSettings.this.mPlayAndDownload.setEnabled(isExternalStoreageMounted);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(C0329R.xml.music_settings);
        findPreference(PreferenceCache.PREF_DOWNLOAD_ALBUM_OTHER).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_DOWNLOAD_LYRIC_OTHER).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_LISTEN_TO_MUSIC_OTHER).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_FILTER_BY_SIZE).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_FILTER_BY_DURATION).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_FOLDERS_UNSELECTED).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_ANDROID_ALBUM).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_PLAY_AND_DOWNLOAD).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_SCREEN_BRIGHT_WAKE).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_KEEP_QUIT_LOCATION).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_SHAKE).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_DISPLAY_LYRIC).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_DISPLAY_ALBUM).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_SHAKE_WHILE_SCREEN_ON).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_CORRECT_ID3_SETTINGS).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_AUTO_CORRECT_ID3).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_SYNCHRONIZE_PLAYLIST).setOnPreferenceChangeListener(this);
        findPreference(PreferenceCache.PREF_ENABLE_CONNECT_NETWORK_ALERT).setOnPreferenceChangeListener(this);
        TwoStatePreference fadePref = (TwoStatePreference) findPreference(PreferenceCache.PREF_FADE_EFFECT_ACTIVE);
        if (PreferenceCache.IS_LPA_DECODE) {
            fadePref.setChecked(false);
            fadePref.setEnabled(false);
        } else {
            fadePref.setOnPreferenceChangeListener(this);
        }
        this.mFilterCategoryPref = findPreference(PreferenceCache.PREF_CATEGORY_FILTER);
        this.mPlayAndDownload = findPreference(PreferenceCache.PREF_PLAY_AND_DOWNLOAD);
        ActionBar bar = getActionBar();
        if (bar != null) {
            bar.setTitle(C0329R.string.music_settings);
            bar.setHomeButtonEnabled(true);
        }
        if (Utils.isOnlineVaild()) {
            initializeMusicQualitySetting();
        } else {
            PreferenceGroup screen = getPreferenceScreen();
            UIHelper.removeChildPreference(screen, PreferenceCache.PREF_CATEGORY_MOBILE_CONNECT_SETTINGS);
            UIHelper.removeChildPreference(screen, PreferenceCache.PREF_PLAY_AND_DOWNLOAD);
            UIHelper.removeChildPreference(screen, PreferenceCache.PREF_AUTO_CORRECT_ID3);
            UIHelper.removeChildPreference(screen, PreferenceCache.PREF_MUSIC_QUALITY);
        }
        if (Utils.isOnlineVaild()) {
            initializeAccountSetting();
        } else {
            screen = getPreferenceScreen();
            UIHelper.removeChildPreference(screen, PreferenceCache.PREF_ACCOUNT_SETTING);
            UIHelper.removeChildPreference(screen, PreferenceCache.PREF_ENABLE_CONNECT_NETWORK_ALERT);
        }
        if (Utils.isSupportPriorityStorage() && StorageUtils.isExternalSdcardMounted()) {
            this.mPriorityStoragePreference = (CheckBoxPreference) findPreference(KEY_PRIORITY_STORAGE);
            this.mPriorityStoragePreference.setOnPreferenceChangeListener(this);
            return;
        }
        UIHelper.removeChildPreference(getPreferenceScreen(), KEY_PRIORITY_STORAGE);
    }

    private void initializeMusicQualitySetting() {
        this.mHigherMusicQualityPreference = (OptionPreference) findPreference(PreferenceCache.PREF_HIGHER_MUSIC_QUALITY);
        this.mHigherMusicQualityPreference.setOnPreferenceClickListener(this);
    }

    private void refreshMusicQuality() {
        if (Utils.isOnlineVaild()) {
            if (AccountPermissionHelper.allowUHDMusic()) {
                this.mHigherMusicQualityPreference.setMiuiLabel((int) C0329R.string.enabled);
            } else if (AccountPermissionHelper.hasInitialized() && AccountPermissionHelper.hasBoughtVip()) {
                this.mHigherMusicQualityPreference.setMiuiLabel((int) C0329R.string.expired);
            } else {
                this.mHigherMusicQualityPreference.setMiuiLabel(null);
            }
            String startDate = AccountPermissionHelper.getVipStartDate();
            String endDate = AccountPermissionHelper.getVipEndDate();
            int vipRemainDays = AccountPermissionHelper.getVipRemainDays();
            if (vipRemainDays >= 0) {
                this.mHigherMusicQualityPreference.setSummary(getResources().getQuantityString(C0329R.plurals.Nexpired_remind, vipRemainDays, new Object[]{Integer.valueOf(vipRemainDays)}));
            } else if (TextUtils.isEmpty(startDate) || TextUtils.isEmpty(endDate)) {
                this.mHigherMusicQualityPreference.setSummary(C0329R.string.higher_quality_music_summary);
            } else {
                this.mHigherMusicQualityPreference.setSummary(getString(C0329R.string.valid_period) + getString(C0329R.string.period_format, new Object[]{startDate, endDate}));
            }
        }
    }

    private void initializeAccountSetting() {
        this.mAccountSetting = (PreferenceCategory) findPreference(PreferenceCache.PREF_ACCOUNT_SETTING);
        this.mXiaomiAccountPreference = (OptionPreference) findPreference(PreferenceCache.PREF_XIAOMI_ACCOUNT_SETTING);
        this.mBaiduAccountPreference = (OptionPreference) findPreference(PreferenceCache.PREF_BAIDU_ACCOUNT_SETTING);
        this.mSynchronizePlaylistPreference = (CheckBoxPreference) findPreference(PreferenceCache.PREF_SYNCHRONIZE_PLAYLIST);
        this.mXiaomiAccountPreference.setOnPreferenceClickListener(this);
        this.mSynchronizePlaylistPreference.setOnPreferenceChangeListener(this);
        this.mAccountSetting.removePreference(this.mBaiduAccountPreference);
    }

    private void refreshXiaomiAccount() {
        if (Utils.isOnlineVaild()) {
            Account xiaomiAccount = ExtraAccountManager.getXiaomiAccount(this);
            if (xiaomiAccount != null) {
                this.mAccountSetting.addPreference(this.mSynchronizePlaylistPreference);
                this.mSynchronizePlaylistPreference.setChecked(MusicSyncAdapter.isCloudSyncable(this));
                this.mXiaomiAccountPreference.setMiuiLabel(xiaomiAccount.name);
                return;
            }
            this.mAccountSetting.removePreference(this.mSynchronizePlaylistPreference);
            this.mXiaomiAccountPreference.setMiuiLabel((int) C0329R.string.not_login);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }

    protected void onResume() {
        super.onResume();
        AccountPermissionHelper.addListener(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.MEDIA_MOUNTED");
        filter.addAction("android.intent.action.MEDIA_EJECT");
        filter.addDataScheme("file");
        registerReceiver(this.mMountReceiver, filter);
        this.mMountReceiver.onReceive(this, null);
        refreshXiaomiAccount();
        refreshMusicQuality();
        refreshPriorityStorage();
    }

    protected void onPause() {
        unregisterReceiver(this.mMountReceiver);
        AccountPermissionHelper.removeListener(this);
        super.onPause();
    }

    public boolean onPreferenceChange(Preference pref, Object objValue) {
        boolean z = false;
        String key = pref.getKey();
        PreferenceCache.put(this, key, objValue);
        Intent intent;
        if (key.equals(PreferenceCache.PREF_DISPLAY_ALBUM) || key.equals(PreferenceCache.PREF_ANDROID_ALBUM) || key.equals(PreferenceCache.PREF_DOWNLOAD_ALBUM_OTHER)) {
            intent = new Intent(In.UPDATE_META_ACTION);
            intent.putExtra(In.CMDNAME, "album");
            sendBroadcast(intent);
            if (key.equals(PreferenceCache.PREF_ANDROID_ALBUM)) {
                AlbumListAdapter.removeCache();
            }
        } else if (key.equals(PreferenceCache.PREF_DISPLAY_LYRIC)) {
            intent = new Intent(In.UPDATE_META_ACTION);
            intent.putExtra(In.CMDNAME, "lyric");
            sendBroadcast(intent);
        } else if (key.equals(PreferenceCache.PREF_SHAKE)) {
            sendBroadcast(new Intent(In.UPDATE_SHAKE));
        } else if (key.equals(PreferenceCache.PREF_FILTER_BY_SIZE) || key.equals(PreferenceCache.PREF_FILTER_BY_SIZE_PROGRESS) || key.equals(PreferenceCache.PREF_FILTER_BY_DURATION) || key.equals(PreferenceCache.PREF_FILTER_BY_DURATION_PROGRESS)) {
            PlaylistRecoverer.markForceRecover();
            FolderProvider.markForceUpdate();
        } else if (key.equals(PreferenceCache.PREF_SYNCHRONIZE_PLAYLIST)) {
            Log.d("SyncPlaylist", "from settings.");
            if (objValue instanceof Boolean) {
                MusicSyncAdapter.setCloudSyncable(this, ((Boolean) objValue).booleanValue());
                if (((Boolean) objValue).booleanValue()) {
                    MusicSyncAdapter.requestSync(this);
                }
            }
        } else if (key.equals(PreferenceCache.PREF_ENABLE_CONNECT_NETWORK_ALERT)) {
            Toast.makeText(this, C0329R.string.take_effect_afater_restart, 0).show();
            if (!((Boolean) objValue).booleanValue()) {
                z = true;
            }
            NetworkUtil.setNetworkAllow(z);
        } else if (KEY_PRIORITY_STORAGE.equals(key)) {
            PriorityStorageBroadcastReceiver.setPriorityStorage(this, ((Boolean) objValue).booleanValue());
        }
        return true;
    }

    public boolean onPreferenceClick(Preference preference) {
        if (preference == this.mHigherMusicQualityPreference) {
            MusicAnalyticsUtils.trackEvent(MusicAnalyticsUtils.EVENT_PAYMENT_EXTRANCE, "设置页");
            startActivity(new Intent(this, VipRecommendActivity.class));
            return true;
        } else if (preference != this.mXiaomiAccountPreference) {
            return false;
        } else {
            if (ExtraAccountManager.getXiaomiAccount(this) == null) {
                AccountUtils.loginXiaomiAccount(this, null);
                return true;
            }
            startActivity(new Intent("android.settings.XIAOMI_ACCOUNT_SYNC_SETTINGS"));
            return true;
        }
    }

    public void onPermissionChanged(int allowQuality) {
        if (isResumed()) {
            refreshMusicQuality();
        }
    }

    public void onPeriodChanged(String startTime, String endTime) {
        if (isResumed()) {
            refreshMusicQuality();
        }
    }

    private void refreshPriorityStorage() {
        if (this.mPriorityStoragePreference != null) {
            this.mPriorityStoragePreference.setChecked(PriorityStorageBroadcastReceiver.isPriorityStorage(this));
        }
    }
}
