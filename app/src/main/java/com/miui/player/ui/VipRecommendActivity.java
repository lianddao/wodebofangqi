package com.miui.player.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.miui.player.C0329R;
import com.miui.player.meta.MetaManager;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper.AccountPermissionListener;
import com.miui.player.plugin.onlinepay.VipOrderHelper;
import com.miui.player.util.PreferenceCache;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.util.MusicLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import miui.net.PaymentManager.PaymentListener;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class VipRecommendActivity extends Activity implements AccountPermissionListener {
    private static final String CALL_BACK_JS_FORMAT = "javascript:(function() { try { %s } catch(e) { MM.log(e.message); } }())";
    public static final String JS_HIDE_LOADING = "app.loading('hide')";
    private static final String JS_NAMESPACE = "MM";
    public static final String JS_SHOW_LOADING = "app.loading('show')";
    private static final String PID_LIST = "1000000000000000,3,4";
    public static final String TIMEOUT = "timeout";
    private static final String UTF8 = "utf-8";
    private static final String VIP_WEBVIEW_URL = "http://fm.duokanbox.com/product/";
    public static String sWebViewConfig = MetaManager.UNKNOWN_STRING;
    private volatile boolean mIsOrderProcess = false;
    private boolean mPeriodState = false;
    private boolean mPermissionState = false;
    public WebView mWebView;

    public class MusicJSBridge {
        private static final String TAG = "MusicJSBridge";

        @JavascriptInterface
        public void log(String message) {
            MusicLog.m395d(TAG, message);
        }

        @JavascriptInterface
        public void toast(String message) {
            UIHelper.toastSafe(message);
        }

        @JavascriptInterface
        public void createOrder(String productId) {
            MusicLog.m395d(TAG, productId);
            VipRecommendActivity.runAsyncOrder(productId, VipRecommendActivity.this);
        }

        @JavascriptInterface
        public void closeRemind(String PREF_TYPE) {
            if (TextUtils.equals(PREF_TYPE, VipRecommendActivity.TIMEOUT)) {
                PreferenceCache.setPrefAsBoolean(VipRecommendActivity.this, PreferenceCache.PREF_VIP_TIME_OUT, true);
            } else {
                PreferenceCache.setPrefAsBoolean(VipRecommendActivity.this, PreferenceCache.PREF_VIP_REMINDED, true);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AccountPermissionHelper.refreshVipPermission();
        AccountPermissionHelper.addListener(this);
        setContentView(C0329R.layout.vip_webview);
        ActionBar bar = getActionBar();
        if (bar != null) {
            bar.setTitle(C0329R.string.vip_recommend_title);
            bar.setHomeButtonEnabled(true);
        }
        this.mWebView = (WebView) findViewById(C0329R.id.vip_webview);
        this.mWebView.addJavascriptInterface(new MusicJSBridge(), JS_NAMESPACE);
        this.mWebView.setLongClickable(false);
        WebSettings webSettings = this.mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportMultipleWindows(false);
        webSettings.setLoadWithOverviewMode(true);
        this.mWebView.loadUrl(createWebViewUrl());
    }

    protected void onDestroy() {
        AccountPermissionHelper.removeListener(this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (!getOrderProcess()) {
            updateWebView();
        }
    }

    private void UpdateWebviewAfterPermissionReady() {
        if (this.mPeriodState && this.mPermissionState) {
            setOrderProcess(false);
            updateWebView();
        }
    }

    public void onPermissionChanged(int allowQuality) {
        this.mPermissionState = true;
        UpdateWebviewAfterPermissionReady();
    }

    public void onPeriodChanged(String startTime, String endTime) {
        this.mPeriodState = true;
        UpdateWebviewAfterPermissionReady();
    }

    public static String appendUrl(String origin, String path, List<NameValuePair> nameValuePairs) {
        if (origin == null) {
            throw new NullPointerException("origin is not allowed null");
        }
        StringBuilder urlBuilder = new StringBuilder(origin);
        urlBuilder.append(path);
        if (nameValuePairs != null) {
            String paramPart = URLEncodedUtils.format(nameValuePairs, UTF8);
            if (paramPart != null && paramPart.length() > 0) {
                if (origin.contains("?")) {
                    urlBuilder.append("&");
                } else {
                    urlBuilder.append("?");
                }
                urlBuilder.append(paramPart);
            }
        }
        return urlBuilder.toString();
    }

    public static void runAsyncOrder(String productId, VipRecommendActivity activity) {
        Activity vipRecommendActivity = activity;
        final WeakReference<VipRecommendActivity> k = new WeakReference(activity);
        VipOrderHelper.createOrderAsync(vipRecommendActivity, productId, new PaymentListener() {
            public void onSuccess(String paymentId, Bundle result) {
                final VipRecommendActivity v = (VipRecommendActivity) k.get();
                if (v != null) {
                    v.setOrderProcess(true);
                    v.updateWebView();
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            v.setOrderProcess(false);
                            v.updateWebView();
                        }
                    }, (long) VipOrderHelper.sOrderResetTimer);
                }
            }

            public void onFailed(String paymentId, int code, String message, Bundle result) {
                VipRecommendActivity v = (VipRecommendActivity) k.get();
                if (v != null) {
                    v.setOrderProcess(false);
                    v.updateWebView();
                }
            }
        });
    }

    public void setOrderProcess(boolean state) {
        this.mIsOrderProcess = state;
    }

    public boolean getOrderProcess() {
        return this.mIsOrderProcess;
    }

    public int getExpiredDay() {
        int remainDays = AccountPermissionHelper.getVipRemainDays();
        if (!PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_VIP_REMINDED) && remainDays != -1) {
            return remainDays;
        }
        if (!AccountPermissionHelper.isVipTimeOut() || PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_VIP_TIME_OUT)) {
            return 0;
        }
        return -1;
    }

    public String getLocale() {
        return this.mWebView.getResources().getConfiguration().locale.toString();
    }

    public JSONObject createJsonConfig() {
        try {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("is_bought", AccountPermissionHelper.allowUHDMusic());
            jsonObj.put("is_order_process", getOrderProcess());
            jsonObj.put("expired", getExpiredDay());
            jsonObj.put("start", AccountPermissionHelper.getVipStartDate());
            jsonObj.put("end", AccountPermissionHelper.getVipEndDate());
            jsonObj.put("lang", getLocale());
            return jsonObj;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getJsonConfigString() {
        JSONObject jsonObj = createJsonConfig();
        if (jsonObj != null) {
            String configString = jsonObj.toString();
            if (!TextUtils.equals(configString, sWebViewConfig)) {
                sWebViewConfig = configString;
                return configString;
            }
        }
        return null;
    }

    public String createWebViewUrl() {
        List<NameValuePair> nameValuePairs = new ArrayList();
        for (Entry<String, String> p : MusicEngine.get(this).getStatEngine().getVersionParams(this).entrySet()) {
            String value = (String) p.getValue();
            if (!TextUtils.isEmpty(value)) {
                nameValuePairs.add(new BasicNameValuePair((String) p.getKey(), value));
            }
        }
        JSONObject jsonConfig = createJsonConfig();
        MusicLog.m395d("MusicJSBridge", jsonConfig.toString());
        if (jsonConfig != null) {
            Iterator<String> keys = jsonConfig.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                try {
                    nameValuePairs.add(new BasicNameValuePair(key, jsonConfig.get(key).toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return appendUrl(VIP_WEBVIEW_URL, PID_LIST, nameValuePairs);
    }

    public void updateWebView(String JSFunc) {
        if (!isFinishing()) {
            this.mWebView.loadUrl(String.format(CALL_BACK_JS_FORMAT, new Object[]{JSFunc}));
        }
    }

    public void updateWebView() {
        if (!isFinishing() && getJsonConfigString() != null) {
            this.mWebView.loadUrl(String.format(CALL_BACK_JS_FORMAT, new Object[]{"app.init(" + config + ")"}));
        }
    }
}
