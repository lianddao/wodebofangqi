package com.ushareit.browser;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.esr;
import com.ushareit.listenit.ewt;
import com.ushareit.listenit.ewz;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.fad;
import com.ushareit.listenit.fbj;
import com.ushareit.listenit.fql;
import com.ushareit.listenit.heb;
import com.ushareit.listenit.hhx;
import com.ushareit.listenit.hib;
import com.ushareit.listenit.hid;
import com.ushareit.listenit.him;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class WebClientActivity extends BrowserActivity {
    private FrameLayout f3960A;
    private View f3961B;
    private View f3962C;
    private View f3963D;
    private OnClickListener f3964E = new C03411(this);
    private int f3965y = -1;
    private Context f3966z;

    class C03411 implements OnClickListener {
        final /* synthetic */ WebClientActivity f3943a;

        C03411(WebClientActivity webClientActivity) {
            this.f3943a = webClientActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case C0349R.id.share_btn:
                    this.f3943a.m4888j();
                    return;
                case C0349R.id.download_btn:
                    this.f3943a.m4901q();
                    return;
                default:
                    return;
            }
        }
    }

    public final class WebClient {
        final /* synthetic */ WebClientActivity f3959a;

        class C03453 extends hib {
            final /* synthetic */ WebClient f3956a;

            C03453(WebClient webClient) {
                this.f3956a = webClient;
            }

            public void callback() {
                heb.m23597a(this.f3956a.f3959a.getResources().getString(C0349R.string.browser_app_run_failed), 1).show();
            }
        }

        public WebClient(WebClientActivity webClientActivity) {
            this.f3959a = webClientActivity;
        }

        @JavascriptInterface
        public String getDeviceInfo() {
            exw.m18449b("WebClientActivity", "getDeviceInfo() called!");
            return ewz.m18329a(this.f3959a.f3966z).toString();
        }

        @JavascriptInterface
        public void setContentType(String str) {
            this.f3959a.s = str;
        }

        @JavascriptInterface
        public void setOrientation(int i) {
            this.f3959a.f3965y = i;
            if (this.f3959a.f3965y == 1) {
                this.f3959a.setRequestedOrientation(1);
            } else if (this.f3959a.f3965y == 0) {
                this.f3959a.setRequestedOrientation(0);
            }
        }

        @JavascriptInterface
        public void showOptionBar() {
            this.f3959a.r = true;
            this.f3959a.p.setVisibility(0);
        }

        @JavascriptInterface
        public void setRightbarVisibility(final String str, final String str2) {
            hhx.m23867a(new hib(this) {
                final /* synthetic */ WebClient f3953c;

                public void callback() {
                    if (str.equalsIgnoreCase("share")) {
                        View d = this.f3953c.f3959a.f3961B;
                        int i = (str2.equalsIgnoreCase("true") && him.m23904a(this.f3953c.f3959a)) ? 0 : 8;
                        d.setVisibility(i);
                    }
                    if (str.equalsIgnoreCase("download")) {
                        View e = this.f3953c.f3959a.f3963D;
                        if (str2.equalsIgnoreCase("true")) {
                            e.setVisibility(0);
                        } else {
                            e.setVisibility(0);
                        }
                    }
                }
            });
        }

        @JavascriptInterface
        public void showShareDialog(String str) {
            Bundle bundle = new Bundle();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("title")) {
                    bundle.putString("title", jSONObject.getString("title"));
                }
                if (jSONObject.has("description")) {
                    bundle.putString("description", jSONObject.getString("description"));
                }
                if (jSONObject.has("msg")) {
                    bundle.putString("msg", jSONObject.getString("msg"));
                }
                if (jSONObject.has("webpage_path")) {
                    bundle.putString("webpage", jSONObject.getString("webpage_path"));
                }
                if (jSONObject.has("image_path")) {
                    bundle.putString("image", jSONObject.getString("image_path"));
                }
                hid com_ushareit_listenit_hid = new hid();
                com_ushareit_listenit_hid.m1317g(bundle);
                com_ushareit_listenit_hid.mo1295a(this.f3959a.m709f(), "share");
            } catch (JSONException e) {
            }
        }

        @JavascriptInterface
        public String getSupportShare() {
            return "";
        }

        @JavascriptInterface
        public void shareByWeixin(String str, int i, String str2) {
            exw.m18449b("WebClientActivity", "shareByWeixin() called!");
        }

        @JavascriptInterface
        public String getShareStatus(String str) {
            exw.m18449b("WebClientActivity", "getShareStatus() called!");
            return "";
        }

        @JavascriptInterface
        public String getAppStatus(String str, String str2, int i) {
            exw.m18449b("WebClientActivity", "getAppStatus() called!");
            if (!fbj.m18787b(this.f3959a, str2)) {
                return "download";
            }
            if (fbj.m18784a(this.f3959a, str2, i) == 1) {
                return "run";
            }
            return "update";
        }

        @JavascriptInterface
        public void run(String str) {
            exw.m18449b("WebClientActivity", "run() called!");
            if (!str.equalsIgnoreCase(this.f3959a.f3966z.getPackageName())) {
                final Intent launchIntentForPackage = this.f3959a.f3966z.getPackageManager().getLaunchIntentForPackage(str);
                launchIntentForPackage.addFlags(268435456);
                if (launchIntentForPackage != null) {
                    hhx.m23867a(new hib(this) {
                        final /* synthetic */ WebClient f3955b;

                        public void callback() {
                            this.f3955b.f3959a.f3966z.startActivity(launchIntentForPackage);
                        }
                    });
                } else {
                    hhx.m23867a(new C03453(this));
                }
            }
        }

        @JavascriptInterface
        public void startDownloadApp(final String str) {
            exw.m18449b("WebClientActivity", "startDownloadApp() called!");
            if (str != null) {
                hhx.m23867a(new hib(this) {
                    final /* synthetic */ WebClient f3958b;

                    public void callback() {
                        fad.m18688a(this.f3958b.f3959a.f3966z, str, fql.m20387a(), "web_client", true);
                    }
                });
            }
        }

        @JavascriptInterface
        public void startDownload(String str, String str2) {
        }

        @JavascriptInterface
        public void pauseDownload(String str, String str2) {
        }

        @JavascriptInterface
        public void continueDownload(String str, String str2) {
        }

        @JavascriptInterface
        public void install(String str) {
        }

        @JavascriptInterface
        public int getProgress(String str, String str2) {
            return 0;
        }

        @JavascriptInterface
        public void showInLevel(String str) {
            exw.m18449b("WebClientActivity", "showInLevel() called!");
            if (str.equalsIgnoreCase("1")) {
                this.f3959a.finish();
            } else if (str.equalsIgnoreCase("2")) {
                this.f3959a.n.goBack();
            }
        }

        @JavascriptInterface
        public void analyticsEvent(String str) {
            if (str != null) {
                esr.m17807a(this.f3959a.f3966z, str);
            }
        }

        @JavascriptInterface
        public void analyticsEvent(String str, String str2) {
            if (str != null && str2 != null) {
                esr.m17808a(this.f3959a.f3966z, str, str2);
            }
        }

        @JavascriptInterface
        public void analyticsEvent(String str, String[][] strArr) {
            if (str != null && strArr != null) {
                HashMap linkedHashMap = new LinkedHashMap();
                for (int i = 0; i < strArr.length; i++) {
                    if (strArr[i].length >= 2) {
                        linkedHashMap.put(strArr[i][0], strArr[i][1]);
                    }
                }
                esr.m17820b(this.f3959a.f3966z, str, linkedHashMap);
            }
        }

        @JavascriptInterface
        public void executeSystemEvent(int i, String str) {
            exw.m18449b("WebClientActivity", "executeSystemEvent()");
            ewt.m18319a(this.f3959a.f3966z, i, str);
        }

        @JavascriptInterface
        public void handleAction(String str, int i, String str2) {
            exw.m18449b("WebClientActivity", "handleAction()");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3960A = (FrameLayout) this.o.findViewById(C0349R.id.right_button_view);
        m4900p();
        this.n.addJavascriptInterface(new WebClient(this), "client");
        this.n.getSettings().setBuiltInZoomControls(false);
        this.f3966z = eys.m18562a();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f3965y == 1) {
            if (getResources().getConfiguration().orientation == 2) {
                setRequestedOrientation(1);
            }
        } else if (this.f3965y == 0 && getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(0);
        }
    }

    private void m4900p() {
        this.o.findViewById(C0349R.id.right_button).setVisibility(8);
        this.f3960A.setVisibility(0);
        this.f3960A.removeAllViews();
        this.f3960A.addView((LinearLayout) LayoutInflater.from(this).inflate(C0349R.layout.browser_web_client_right_button, null));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (VERSION.SDK_INT >= 14) {
            layoutParams.gravity = 8388613;
        } else {
            layoutParams.gravity = 5;
        }
        this.f3960A.setLayoutParams(layoutParams);
        this.f3961B = this.f3960A.findViewById(C0349R.id.share_btn);
        this.f3961B.setOnClickListener(this.f3964E);
        this.f3961B.setVisibility(8);
        this.f3963D = this.f3960A.findViewById(C0349R.id.download_view);
        this.f3960A.findViewById(C0349R.id.download_btn).setOnClickListener(this.f3964E);
        this.f3962C = this.f3960A.findViewById(C0349R.id.download_tip);
        this.f3963D.setVisibility(8);
    }

    @TargetApi(9)
    private void m4901q() {
        if (!this.q || VERSION.SDK_INT < 9) {
            try {
                Intent intent = new Intent("com.lenovo.anyshare.action.LANUCH_DOWNLOADS");
                intent.setPackage(getPackageName());
                this.f3966z.startActivity(intent);
            } catch (ActivityNotFoundException e) {
            }
            m4895b(false);
            return;
        }
        intent = new Intent("android.intent.action.VIEW_DOWNLOADS");
        intent.addFlags(268435456);
        this.f3966z.startActivity(intent);
    }

    private void m4895b(final boolean z) {
        hhx.m23867a(new hib(this) {
            final /* synthetic */ WebClientActivity f3950b;

            public void callback() {
                this.f3950b.f3962C.setVisibility(z ? 0 : 8);
            }
        });
    }
}
