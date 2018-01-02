package com.miui.player.plugin.onlinepay;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.plugin.onlinesync.TokenManager;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkManager;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.VipRecommendActivity;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.AccountUtils;
import com.miui.player.util.MusicAnalyticsUtils;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.StorageConfig;
import com.miui.player.util.ThreadManager;
import com.xiaomi.music.util.MusicLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import miui.accounts.ExtraAccountManager;
import miui.net.ExtendedAuthToken;
import miui.net.PaymentManager;
import miui.net.PaymentManager.PaymentListener;
import miui.net.SecureRequest;
import miui.net.SimpleRequest.MapContent;
import miui.net.SimpleRequest.StringContent;
import miui.net.exception.AccessDeniedException;
import miui.net.exception.AuthenticationFailureException;
import miui.net.exception.CipherException;
import miui.net.exception.InvalidResponseException;
import miui.util.EasyMap;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;

public class VipOrderHelper {
    private static final int CODE_SUCCESS = 200;
    private static final String CREATE_ORDER_URL = "https://order.music.xiaomi.com/createOrder/";
    public static final long DEFAULT_PRODUCT_ID = 1000000000000000L;
    private static final String HOST_URL = "https://order.music.xiaomi.com/";
    private static final String KEY_ACCESS_TOKEN = "accessToken";
    private static final String KEY_DATA = "data";
    private static final String KEY_ERROR_CODE = "errcode";
    private static final String KEY_PRODUCT_ID = "productId";
    private static final String KEY_SERVICE_TOKEN = "serviceToken";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_XIAOMI_ID = "xiaomiId";
    private static final String PAYMENT_ID = "110";
    private static final String SERVICE_ID = "miuimusic";
    private static final String TAG = "VipOrderHelper";
    private static final long TIME_OUT = 60000;
    private static final String USER_BOUGHT_URL = "https://order.music.xiaomi.com/user/bought?";
    private static long sLastPayment = -1;
    public static int sOrderResetTimer = 60000;

    public static class VipOrderCallback implements ValueCallback<Boolean> {
        private final Activity mActivity;
        private final Audio mAudio;
        private final ValueCallback<Boolean> mCallback;
        private final String mEntrance;

        public VipOrderCallback(Activity activity, String productId, ValueCallback<Boolean> callback, String entrance, Audio audio) {
            this.mActivity = activity;
            this.mCallback = callback;
            this.mEntrance = entrance;
            this.mAudio = audio;
        }

        public void execute(Boolean isVip) {
            if (!isVip.booleanValue()) {
                this.mActivity.startActivity(new Intent(this.mActivity, VipRecommendActivity.class));
                if (this.mEntrance != null) {
                    MusicAnalyticsUtils.trackEvent(MusicAnalyticsUtils.EVENT_PAYMENT_EXTRANCE, this.mEntrance);
                }
                if (this.mAudio != null) {
                    MusicAnalyticsUtils.trackPaymentEvent(this.mAudio);
                }
            } else if (this.mCallback != null) {
                this.mCallback.execute(isVip);
            }
        }
    }

    public static void createOrderAsync(final Activity activity, final String productId, final PaymentListener listener) {
        if (ExtraAccountManager.getXiaomiAccount(MusicApplication.getApplication()) == null) {
            loginAlert(activity);
        } else {
            ThreadManager.postNetworkRequest(new Runnable() {
                public void run() {
                    VipOrderHelper.doCreateOrder(activity, productId, listener);
                }
            });
        }
    }

    private static void doCreateOrder(Activity activity, String productId, final PaymentListener listener) {
        if (orderValid()) {
            MapContent result = null;
            boolean success = false;
            if (BaiduSdkManager.initSdkEnvironment()) {
                sLastPayment = SystemClock.elapsedRealtime();
                List<NameValuePair> nameValuePairs = new ArrayList();
                nameValuePairs.add(new BasicNameValuePair(KEY_XIAOMI_ID, ExtraAccountManager.getXiaomiAccount(activity).name));
                nameValuePairs.add(new BasicNameValuePair(KEY_ACCESS_TOKEN, TokenManager.getAccessToken()));
                nameValuePairs.add(new BasicNameValuePair(KEY_PRODUCT_ID, productId));
                result = doPostByPassport(activity, CREATE_ORDER_URL, nameValuePairs);
            }
            if (result != null) {
                MusicLog.m395d(TAG, "order info = " + result.toString());
                if (200 == ((Integer) result.getFromBody(KEY_ERROR_CODE)).intValue()) {
                    success = true;
                    String order = (String) result.getFromBody("data");
                    if (order != null) {
                        PaymentManager.get(activity).payForOrder(activity, PAYMENT_ID, order, null, new PaymentListener() {
                            public void onSuccess(String paymentId, Bundle result) {
                                UIHelper.toastSafe(C0329R.string.payment_success, new Object[0]);
                                VipOrderHelper.sLastPayment = SystemClock.elapsedRealtime();
                                VipOrderHelper.upgradeUserChoice(StorageConfig.BIT_RATE_UHD);
                                AccountPermissionHelper.refreshVipPermission(true, null, AccountPermissionHelper.DELAY_TIME);
                                if (listener != null) {
                                    listener.onSuccess(paymentId, result);
                                }
                                MusicAnalyticsUtils.trackEvent(MusicAnalyticsUtils.EVENT_PAYMENT, "成功");
                            }

                            public void onFailed(String paymentId, int code, String message, Bundle result) {
                                VipOrderHelper.sLastPayment = -1;
                                if (code != 4) {
                                    UIHelper.toastSafe(C0329R.string.payment_fail, new Object[0]);
                                }
                                if (listener != null) {
                                    listener.onFailed(paymentId, code, message, result);
                                }
                                MusicAnalyticsUtils.trackEvent(MusicAnalyticsUtils.EVENT_PAYMENT, "失败");
                            }
                        });
                    }
                }
            }
            if (!success) {
                sLastPayment = -1;
                UIHelper.toastSafe(C0329R.string.request_fail, new Object[0]);
                return;
            }
            return;
        }
        UIHelper.toastSafe(C0329R.string.requesting, new Object[0]);
    }

    private static MapContent doPostByPassport(Activity activity, String url, List<NameValuePair> nameValuePairs) {
        try {
            Context context = MusicApplication.getApplication();
            AccountManager accountManager = AccountManager.get(context);
            Account account = ExtraAccountManager.getXiaomiAccount(context);
            if (!(account == null || accountManager == null)) {
                ExtendedAuthToken serviceToken = ExtendedAuthToken.parse(((Bundle) accountManager.getAuthToken(account, SERVICE_ID, null, true, null, null).getResult()).getString("authtoken"));
                if (serviceToken != null) {
                    return SecureRequest.postAsMap(url, parseToMap(nameValuePairs), new EasyMap().easyPut("userId", account.name).easyPut(KEY_SERVICE_TOKEN, serviceToken.authToken), true, serviceToken.security);
                }
            }
        } catch (OperationCanceledException e) {
            e.printStackTrace();
        } catch (AuthenticatorException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (AccessDeniedException e4) {
            e4.printStackTrace();
        } catch (InvalidResponseException e5) {
            e5.printStackTrace();
        } catch (CipherException e6) {
            e6.printStackTrace();
        } catch (AuthenticationFailureException e7) {
            e7.printStackTrace();
        } catch (NullPointerException e8) {
            e8.printStackTrace();
        }
        return null;
    }

    private static Map<String, String> parseToMap(List<NameValuePair> nameValuePairs) {
        Map<String, String> map = new HashMap();
        for (NameValuePair pair : nameValuePairs) {
            map.put(pair.getName(), pair.getValue());
        }
        return map;
    }

    private static void loginAlert(final Activity activity) {
        new Builder(activity).setTitle(C0329R.string.login_first).setPositiveButton(C0329R.string.login, new OnClickListener() {

            class C03741 implements AccountManagerCallback<Bundle> {
                C03741() {
                }

                public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                    MusicAnalyticsUtils.trackLoginResult();
                }
            }

            public void onClick(DialogInterface dialog, int which) {
                AccountUtils.loginXiaomiAccount(activity, new C03741());
            }
        }).setNegativeButton(C0329R.string.cancel, null).show();
    }

    public static void upgradeUserChoice(int bitRate) {
        PreferenceCache.setPrefAsInteger(MusicApplication.getApplication(), PreferenceCache.PREF_TRACK_BIT_RATE, bitRate);
    }

    private static boolean orderValid() {
        return sLastPayment == -1 || SystemClock.elapsedRealtime() - sLastPayment >= 60000;
    }

    public static boolean doRefreshBoughtVip() {
        try {
            Context context = MusicApplication.getApplication();
            AccountManager accountManager = AccountManager.get(context);
            Account account = ExtraAccountManager.getXiaomiAccount(context);
            if (!(account == null || accountManager == null)) {
                Bundle bundle = (Bundle) accountManager.getAuthToken(account, SERVICE_ID, null, true, null, null).getResult();
                ExtendedAuthToken serviceToken = null;
                if (bundle != null) {
                    serviceToken = ExtendedAuthToken.parse(bundle.getString("authtoken"));
                }
                StringContent content = null;
                if (serviceToken != null) {
                    List<NameValuePair> nameValuePairs = new ArrayList();
                    nameValuePairs.add(new BasicNameValuePair(KEY_XIAOMI_ID, account.name));
                    nameValuePairs.add(new BasicNameValuePair(KEY_ACCESS_TOKEN, TokenManager.getAccessToken()));
                    content = SecureRequest.getAsString(USER_BOUGHT_URL, parseToMap(nameValuePairs), new EasyMap().easyPut("userId", account.name).easyPut(KEY_SERVICE_TOKEN, serviceToken.authToken), true, serviceToken.security);
                }
                if (content != null) {
                    return Boolean.parseBoolean(content.getBody());
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (OperationCanceledException e3) {
            e3.printStackTrace();
        } catch (AuthenticatorException e4) {
            e4.printStackTrace();
        } catch (CipherException e5) {
            e5.printStackTrace();
        } catch (AccessDeniedException e6) {
            e6.printStackTrace();
        } catch (InvalidResponseException e7) {
            e7.printStackTrace();
        } catch (AuthenticationFailureException e8) {
            e8.printStackTrace();
        } catch (NumberFormatException e9) {
            e9.printStackTrace();
        }
        return false;
    }
}
