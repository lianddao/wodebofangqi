package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.ads.C0017i;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class auv {
    private static String f5538a = null;
    private static final Set<String> f5539b = new HashSet(1);
    private static final Set<String> f5540c = new HashSet(2);

    static {
        f5539b.add("1ww8E0AYsR2oX5lndk2hwp2Uosk=\n");
        f5540c.add("toZ2GRnRjC9P5VVUdCpOrFH8lfQ=\n");
        f5540c.add("3lKvjNsfmrn+WmfDhvr2iVh/yRs=\n");
        f5540c.add("B08QtE4yLCdli4rptyqAEczXOeA=\n");
        f5540c.add("XZXI6anZbdKf+taURdnyUH5ipgM=\n");
    }

    public static aps m7226a(Context context) {
        return m7227a(context, null);
    }

    public static aps m7227a(Context context, ano com_ushareit_listenit_ano) {
        aps com_ushareit_listenit_aps = new aps();
        m7229a(context, com_ushareit_listenit_aps, com_ushareit_listenit_ano);
        return com_ushareit_listenit_aps;
    }

    private static String m7228a(Context context, String str, String str2) {
        Class cls = Class.forName(str);
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class, Class.forName(str2)});
        declaredConstructor.setAccessible(true);
        try {
            String str3 = (String) cls.getMethod("getUserAgentString", new Class[0]).invoke(declaredConstructor.newInstance(new Object[]{context, null}), new Object[0]);
            return str3;
        } finally {
            declaredConstructor.setAccessible(false);
        }
    }

    private static void m7229a(Context context, aps com_ushareit_listenit_aps, ano com_ushareit_listenit_ano) {
        com_ushareit_listenit_aps.m6736c(30000);
        com_ushareit_listenit_aps.m6734b(3);
        com_ushareit_listenit_aps.m6719a("user-agent", m7235c(context, com_ushareit_listenit_ano) + " [FBAN/AudienceNetworkForAndroid;FBSN/" + "Android" + ";FBSV/" + aor.f5086a + ";FBAB/" + aor.f5089d + ";FBAV/" + aor.f5091f + ";FBBV/" + aor.f5092g + ";FBVS/" + "4.23.0" + ";FBLC/" + Locale.getDefault().toString() + "]");
    }

    public static boolean m7230a() {
        Object a = C0017i.m960a();
        return !TextUtils.isEmpty(a) && a.endsWith(".sb");
    }

    public static aps m7231b() {
        return m7226a(null);
    }

    public static aps m7232b(Context context) {
        return m7233b(context, null);
    }

    public static aps m7233b(Context context, ano com_ushareit_listenit_ano) {
        aps com_ushareit_listenit_aps = new aps();
        m7229a(context, com_ushareit_listenit_aps, com_ushareit_listenit_ano);
        if (!m7230a()) {
            com_ushareit_listenit_aps.m6735b(f5540c);
            com_ushareit_listenit_aps.m6728a(f5539b);
        }
        return com_ushareit_listenit_aps;
    }

    public static auw m7234c(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return auw.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return auw.NONE;
        }
        if (activeNetworkInfo.getType() != 0) {
            return auw.MOBILE_INTERNET;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return auw.MOBILE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
                return auw.MOBILE_3G;
            case 13:
                return auw.MOBILE_4G;
            default:
                return auw.UNKNOWN;
        }
    }

    private static String m7235c(Context context, ano com_ushareit_listenit_ano) {
        if (context == null) {
            return "Unknown";
        }
        if (com_ushareit_listenit_ano == ano.NATIVE_250 || com_ushareit_listenit_ano == ano.NATIVE_UNKNOWN || com_ushareit_listenit_ano == null) {
            return System.getProperty("http.agent");
        }
        if (f5538a != null) {
            return f5538a;
        }
        synchronized (auv.class) {
            if (f5538a != null) {
                String str = f5538a;
                return str;
            }
            if (VERSION.SDK_INT >= 17) {
                try {
                    f5538a = m7236d(context);
                    str = f5538a;
                    return str;
                } catch (Exception e) {
                }
            }
            try {
                f5538a = m7228a(context, "android.webkit.WebSettings", "android.webkit.WebView");
            } catch (Exception e2) {
                try {
                    f5538a = m7228a(context, "android.webkit.WebSettingsClassic", "android.webkit.WebViewClassic");
                } catch (Exception e3) {
                    WebView webView = new WebView(context.getApplicationContext());
                    f5538a = webView.getSettings().getUserAgentString();
                    webView.destroy();
                }
            }
            return f5538a;
        }
    }

    @TargetApi(17)
    private static String m7236d(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
