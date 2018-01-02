package com.miui.player.util;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.os.Bundle;
import com.miui.player.ui.base.MusicApplication;
import miui.accounts.ExtraAccountManager;

public class AccountUtils {
    public static void loginXiaomiAccount(Activity a, AccountManagerCallback<Bundle> callback) {
        AccountManager.get(a).addAccount("com.xiaomi", null, null, null, a, callback, null);
    }

    public static boolean hasLoginXiaomiAccount() {
        return ExtraAccountManager.getXiaomiAccount(MusicApplication.getApplication()) != null;
    }
}
