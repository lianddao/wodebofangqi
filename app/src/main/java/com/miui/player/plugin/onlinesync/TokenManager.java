package com.miui.player.plugin.onlinesync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import com.miui.player.ui.base.MusicApplication;
import com.xiaomi.music.cloud.AccountUtils;
import com.xiaomi.music.util.NetworkUtil;
import com.xiaomi.music.util.StreamHelper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import miui.accounts.ExtraAccountManager;
import miui.net.ExtendedAuthToken;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenManager {
    private static volatile String ACCESS_TOKEN = null;
    private static final String APP_ID = "299409";
    private static final long DAY_OF_MILLISECONDS = 86400000;
    private static final long EXPIRATION_TIME = 864000000;
    private static volatile long EXPIRES_IN = 0;
    private static final String HOST = "https://open.account.xiaomi.com/baidu/token?";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_ACCOUNT_LAST = "last_account";
    private static final String KEY_DATA = "data";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_EXPIRES_IN = "expires_in";
    private static final String KEY_LAST_TIME_GET_TOKENS = "last_time_get_tokens";
    private static final String KEY_REFRESH_TOKEN = "refresh_token";
    private static final String KEY_RESULT = "result";
    private static final String KEY_RESULT_CODE = "code";
    private static final String KEY_TOKEN_SETTINGS = "token_settings";
    private static volatile long LAST_TIME_GET_TOKENS = 0;
    private static volatile String REFRESH_TOKEN = null;
    private static final String SID = "miuimusic";
    private static final String TAG = "TokenManager";
    private static final String THIRD_ID = "2882303761517117440";

    private static String getUrl(String userId) {
        return String.format("%sappId=%s&thirdId=%s&userId=%s&sid=%s&devId=%s", new Object[]{HOST, "299409", THIRD_ID, userId, SID, getDeviceId()});
    }

    public static boolean requestTokensFromServer() {
        IOException e;
        String str;
        String str2;
        if (isRequestTokensSucceed()) {
            Log.d(TAG, "tokens already available.");
            return true;
        }
        Account account = AccountUtils.getAccount(MusicApplication.getApplication());
        if (account == null) {
            Log.e(TAG, "account is null.");
            return false;
        } else if (requestTokensFromStorage(account)) {
            Log.d(TAG, "get tokens from storage.");
            return true;
        } else {
            ExtendedAuthToken extToken = getExtToken();
            if (extToken == null) {
                Log.e(TAG, "extToken is null.");
                return false;
            }
            InputStream is = null;
            try {
                is = NetworkUtil.doHttpGet(getUrl(account.name), getCookie(account, extToken));
                if (is == null) {
                    Log.e(TAG, "InputStream is null.");
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e2) {
                            Log.e(TAG, "IOException when close InputStream", e2);
                        }
                    }
                    return false;
                }
                JSONObject json = StreamHelper.toJSONObject(is);
                if (json == null) {
                    Log.e(TAG, "JSON is null.");
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e22) {
                            Log.e(TAG, "IOException when close InputStream", e22);
                        }
                    }
                    return false;
                }
                String result = json.optString(KEY_RESULT);
                String description = json.optString("description");
                int code = json.optInt("code");
                if (result == null || TextUtils.equals("error", result)) {
                    Log.e(TAG, "result is incorrect, description:" + description + " code:" + code);
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e222) {
                            Log.e(TAG, "IOException when close InputStream", e222);
                        }
                    }
                    return false;
                }
                JSONObject data = json.optJSONObject("data");
                if (data == null) {
                    Log.e(TAG, "data is null.");
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e2222) {
                            Log.e(TAG, "IOException when close InputStream", e2222);
                        }
                    }
                    return false;
                }
                REFRESH_TOKEN = data.optString(KEY_REFRESH_TOKEN);
                ACCESS_TOKEN = data.optString("access_token");
                EXPIRES_IN = data.optLong(KEY_EXPIRES_IN) * 1000;
                LAST_TIME_GET_TOKENS = System.currentTimeMillis();
                putString(KEY_ACCOUNT_LAST, account.name);
                putString("access_token", ACCESS_TOKEN);
                putString(KEY_REFRESH_TOKEN, REFRESH_TOKEN);
                putLong(KEY_EXPIRES_IN, EXPIRES_IN);
                putLong(KEY_LAST_TIME_GET_TOKENS, LAST_TIME_GET_TOKENS);
                Log.d(TAG, "access_token:" + ACCESS_TOKEN + "\nrefresh_token:" + REFRESH_TOKEN + "\nexpires_in:" + EXPIRES_IN + "\nlast time get tokens:" + LAST_TIME_GET_TOKENS);
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e3) {
                        e2222 = e3;
                        str = TAG;
                        str2 = "IOException when close InputStream";
                        Log.e(str, str2, e2222);
                        return isRequestTokensSucceed();
                    }
                }
                return isRequestTokensSucceed();
            } catch (IOException e22222) {
                Log.e(TAG, "IOException when request token", e22222);
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e4) {
                        e22222 = e4;
                        str = TAG;
                        str2 = "IOException when close InputStream";
                        Log.e(str, str2, e22222);
                        return isRequestTokensSucceed();
                    }
                }
            } catch (JSONException e5) {
                Log.e(TAG, "JSONException when request token", e5);
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e6) {
                        e22222 = e6;
                        str = TAG;
                        str2 = "IOException when close InputStream";
                        Log.e(str, str2, e22222);
                        return isRequestTokensSucceed();
                    }
                }
            } catch (URISyntaxException e7) {
                Log.e(TAG, "URISyntaxException when request token", e7);
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e8) {
                        e22222 = e8;
                        str = TAG;
                        str2 = "IOException when close InputStream";
                        Log.e(str, str2, e22222);
                        return isRequestTokensSucceed();
                    }
                }
            } catch (Throwable th) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e222222) {
                        Log.e(TAG, "IOException when close InputStream", e222222);
                    }
                }
            }
        }
    }

    private static Header getCookie(Account account, ExtendedAuthToken extToken) {
        StringBuilder builder = new StringBuilder();
        builder.append("serviceToken=");
        builder.append(extToken.authToken);
        Log.d(TAG, "serviceToken:" + extToken.authToken);
        builder.append("; userId=");
        builder.append(account.name);
        return new BasicHeader("Cookie", builder.toString());
    }

    private static ExtendedAuthToken getExtToken() {
        Context context = MusicApplication.getApplication();
        Account account = ExtraAccountManager.getXiaomiAccount(context);
        if (account == null) {
            Log.d(TAG, "account is null.");
            return null;
        }
        try {
            String serviceToken = ((Bundle) AccountManager.get(context).getAuthToken(account, SID, null, true, null, null).getResult()).getString("authtoken");
            if (serviceToken == null) {
                Log.e(TAG, "serviceToken is null.");
            }
            return ExtendedAuthToken.parse(serviceToken);
        } catch (Exception e) {
            Log.e(TAG, "get extToken error: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    private static String getDeviceId() {
        return Secure.getString(MusicApplication.getApplication().getContentResolver(), "android_id");
    }

    private static boolean isRequestTokensSucceed() {
        return (TextUtils.isEmpty(REFRESH_TOKEN) || TextUtils.isEmpty(ACCESS_TOKEN)) ? false : true;
    }

    private static boolean requestTokensFromStorage(Account account) {
        if (LAST_TIME_GET_TOKENS == 0) {
            LAST_TIME_GET_TOKENS = getLong(KEY_LAST_TIME_GET_TOKENS, 0);
        }
        long currTime = System.currentTimeMillis();
        if (currTime - LAST_TIME_GET_TOKENS >= EXPIRATION_TIME || currTime < LAST_TIME_GET_TOKENS) {
            Log.e(TAG, "tokens exceed 10 days.");
            return false;
        }
        if (TextUtils.equals(account.name, getString(KEY_ACCOUNT_LAST, null))) {
            String accessToken = getString("access_token", null);
            String refreshToken = getString(KEY_REFRESH_TOKEN, null);
            long expiresIn = getLong(KEY_EXPIRES_IN, 0);
            if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(refreshToken) || expiresIn < EXPIRATION_TIME) {
                Log.d(TAG, "accessToken:" + accessToken);
                Log.d(TAG, "refreshToken:" + refreshToken);
                Log.d(TAG, "expiresIn:" + expiresIn);
                Log.e(TAG, "tokens not available.");
                return false;
            }
            ACCESS_TOKEN = accessToken;
            REFRESH_TOKEN = refreshToken;
            EXPIRES_IN = expiresIn;
            return true;
        }
        clearTokens();
        Log.i(TAG, "Account changed, clear all cache");
        return false;
    }

    public static String getAccessToken() {
        return ACCESS_TOKEN;
    }

    public static String getRefreshToken() {
        return REFRESH_TOKEN;
    }

    public static long getExpiresIn() {
        return EXPIRES_IN;
    }

    public static void clearTokens() {
        ACCESS_TOKEN = null;
        REFRESH_TOKEN = null;
        EXPIRES_IN = 0;
        LAST_TIME_GET_TOKENS = 0;
        putString("access_token", null);
        putString(KEY_REFRESH_TOKEN, null);
        putLong(KEY_EXPIRES_IN, 0);
        putLong(KEY_LAST_TIME_GET_TOKENS, 0);
        Log.d(TAG, "tokens are cleared.");
    }

    private static synchronized void putString(String key, String value) {
        synchronized (TokenManager.class) {
            Editor editor = MusicApplication.getApplication().getSharedPreferences(KEY_TOKEN_SETTINGS, 0).edit();
            if (value == null) {
                editor.remove(key);
            } else {
                editor.putString(key, value);
            }
            editor.commit();
        }
    }

    private static synchronized String getString(String key, String defValue) {
        String string;
        synchronized (TokenManager.class) {
            string = MusicApplication.getApplication().getSharedPreferences(KEY_TOKEN_SETTINGS, 0).getString(key, defValue);
        }
        return string;
    }

    private static synchronized void putLong(String key, long value) {
        synchronized (TokenManager.class) {
            Editor editor = MusicApplication.getApplication().getSharedPreferences(KEY_TOKEN_SETTINGS, 0).edit();
            if (value == 0) {
                editor.remove(key);
            } else {
                editor.putLong(key, value);
            }
            editor.commit();
        }
    }

    private static synchronized long getLong(String key, long defValue) {
        long j;
        synchronized (TokenManager.class) {
            j = MusicApplication.getApplication().getSharedPreferences(KEY_TOKEN_SETTINGS, 0).getLong(key, defValue);
        }
        return j;
    }
}
