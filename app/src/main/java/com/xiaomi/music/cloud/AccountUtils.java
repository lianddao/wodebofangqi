package com.xiaomi.music.cloud;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.xiaomi.music.util.SecurityGruadian;

public class AccountUtils {
    public static final String AUTH_TOKEN_TYPE = "micloud";
    static String TAG = "AccountUtils";
    private static final String XIAOMI_ACCOUNT_TYPE = "com.xiaomi";

    private AccountUtils() {
    }

    public static Account getAccount(Context context) {
        return SecurityGruadian.getAccountByType(context, XIAOMI_ACCOUNT_TYPE);
    }

    public static String getAccountName(Context context) {
        Account account = getAccount(context);
        return account != null ? account.name : null;
    }

    public static MusicAuthToken getToken(Context context, Account account) {
        try {
            return MusicAuthToken.parse(((Bundle) AccountManager.get(context).getAuthToken(account, AUTH_TOKEN_TYPE, null, true, null, null).getResult()).getString("authtoken"));
        } catch (Exception e) {
            Log.e(TAG, "get extToken error: " + e.toString());
            return null;
        }
    }

    public static void invalidateToken(Context context, Account account, MusicAuthToken token) {
        AccountManager.get(context).invalidateAuthToken(account.type, token.getAuthToken());
    }
}
