package com.miui.player.ui;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.miui.player.C0329R;
import com.miui.player.cloud.MusicSyncAdapter;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.AccountUtils;
import com.miui.player.util.Utils;
import miui.accounts.ExtraAccountManager;

public class SyncAlertHelper {
    private static final int DIALOG_MODE_CONFIRM = 1;
    private static final int DIALOG_MODE_LOGIN_AND_CONFIRM = 0;
    private static final String EXTRA_DIALOG_MODE = "dialog_mode";
    public static final String PREF_FIRST_ALERT_SYNC = "first_alert_sync";

    private static class KeepLocalListener implements OnClickListener {
        private KeepLocalListener() {
        }

        public void onClick(DialogInterface dialog, int which) {
            SyncAlertHelper.setFirst(MusicApplication.getApplication(), false);
            UIHelper.toastSafe(C0329R.string.sync_disable_toast, new Object[0]);
        }
    }

    private static void showLoginDialog(final Activity activty) {
        Builder builder = new Builder(activty);
        builder.setTitle(C0329R.string.sync_alert_title);
        builder.setMessage(C0329R.string.sync_alert_message);
        builder.setNegativeButton(C0329R.string.not_now, new KeepLocalListener());
        builder.setPositiveButton(C0329R.string.login_and_enable, new OnClickListener() {

            class C04621 implements AccountManagerCallback<Bundle> {
                C04621() {
                }

                public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                    if (AccountUtils.hasLoginXiaomiAccount()) {
                        MusicSyncAdapter.setCloudSyncable(activty, true);
                        UIHelper.toastSafe(C0329R.string.sync_enable_toast, new Object[0]);
                        return;
                    }
                    UIHelper.toastSafe(C0329R.string.sync_disable_toast, new Object[0]);
                }
            }

            public void onClick(DialogInterface dialog, int which) {
                SyncAlertHelper.setFirst(activty, false);
                AccountUtils.loginXiaomiAccount(activty, new C04621());
            }
        });
        builder.create().show();
    }

    private static void showConfirmDialog(final Context context) {
        Builder builder = new Builder(context);
        builder.setTitle(C0329R.string.sync_alert_title);
        builder.setMessage(C0329R.string.sync_alert_message);
        builder.setNegativeButton(C0329R.string.not_now, new KeepLocalListener());
        builder.setPositiveButton(C0329R.string.enabled, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                SyncAlertHelper.setFirst(context, false);
                MusicSyncAdapter.setCloudSyncable(MusicApplication.getApplication(), true);
                UIHelper.toastSafe(C0329R.string.sync_enable_toast, new Object[0]);
            }
        });
        builder.create().show();
    }

    private static void setFirst(Context context, boolean isFirst) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(PREF_FIRST_ALERT_SYNC, false).commit();
    }

    private static boolean isFirst(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_FIRST_ALERT_SYNC, true);
    }

    public static void showDialogIfNeed(Activity activity) {
        if ((Utils.isCloudSyncEnable() & isFirst(activity)) != 0) {
            int mode;
            if (ExtraAccountManager.getXiaomiAccount(activity) == null) {
                mode = 0;
            } else if (!MusicSyncAdapter.isCloudSyncable(activity)) {
                mode = 1;
            } else {
                return;
            }
            if (mode == 0) {
                showLoginDialog(activity);
            } else if (mode == 1) {
                showConfirmDialog(activity);
            }
        }
    }
}
