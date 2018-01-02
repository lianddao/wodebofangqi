package com.ushareit.listenit;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.C0017i;
import com.facebook.ads.C0060k;
import com.facebook.ads.C0071w;
import com.facebook.ads.ab;
import com.facebook.ads.internal.view.p000a.C0023d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class atz {
    private static final Uri f5470a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final String f5471b = atz.class.getSimpleName();
    private static final Map<C0060k, ano> f5472c = new HashMap();

    static {
        f5472c.put(C0060k.f876b, ano.WEBVIEW_INTERSTITIAL_UNKNOWN);
        f5472c.put(C0060k.f879e, ano.WEBVIEW_BANNER_250);
        f5472c.put(C0060k.f878d, ano.WEBVIEW_BANNER_90);
        f5472c.put(C0060k.f877c, ano.WEBVIEW_BANNER_50);
    }

    private static Intent m7153a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setComponent(null);
        if (VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        return intent;
    }

    public static final <P, PR, R> AsyncTask<P, PR, R> m7154a(AsyncTask<P, PR, R> asyncTask, P... pArr) {
        if (VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, pArr);
        } else {
            asyncTask.execute(pArr);
        }
        return asyncTask;
    }

    public static ano m7155a(C0060k c0060k) {
        ano com_ushareit_listenit_ano = (ano) f5472c.get(c0060k);
        return com_ushareit_listenit_ano == null ? ano.WEBVIEW_BANNER_LEGACY : com_ushareit_listenit_ano;
    }

    public static aua m7156a(ContentResolver contentResolver) {
        aua com_ushareit_listenit_aua;
        Throwable th;
        Cursor query;
        try {
            ContentResolver contentResolver2 = contentResolver;
            query = contentResolver2.query(f5470a, new String[]{"aid", "androidid", "limit_tracking"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        com_ushareit_listenit_aua = new aua(query.getString(query.getColumnIndex("aid")), query.getString(query.getColumnIndex("androidid")), Boolean.valueOf(query.getString(query.getColumnIndex("limit_tracking"))).booleanValue());
                        if (query != null) {
                            query.close();
                        }
                        return com_ushareit_listenit_aua;
                    }
                } catch (Exception e) {
                    try {
                        com_ushareit_listenit_aua = new aua(null, null, false);
                        if (query != null) {
                            query.close();
                        }
                        return com_ushareit_listenit_aua;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            com_ushareit_listenit_aua = new aua(null, null, false);
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            query = null;
            com_ushareit_listenit_aua = new aua(null, null, false);
            if (query != null) {
                query.close();
            }
            return com_ushareit_listenit_aua;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return com_ushareit_listenit_aua;
    }

    public static Object m7157a(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String m7158a(double d) {
        return String.format(Locale.US, "%.3f", new Object[]{Double.valueOf(d)});
    }

    public static String m7159a(long j) {
        return m7158a(((double) j) / 1000.0d);
    }

    public static String m7160a(InputStream inputStream) {
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[4096];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                stringWriter.write(cArr, 0, read);
            } else {
                String stringWriter2 = stringWriter.toString();
                stringWriter.close();
                inputStreamReader.close();
                return stringWriter2;
            }
        }
    }

    public static String m7161a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    public static String m7162a(JSONObject jSONObject, String str) {
        return m7163a(jSONObject, str, null);
    }

    public static String m7163a(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString(str, str2);
        return "null".equals(optString) ? null : optString;
    }

    public static String m7164a(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            InputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            String a = m7160a(gZIPInputStream);
            gZIPInputStream.close();
            byteArrayInputStream.close();
            return a;
        } catch (Throwable e) {
            att.m7141a(atq.m7138a(e, "Error decompressing data"));
            e.printStackTrace();
            return "";
        }
    }

    public static Method m7165a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method m7166a(String str, String str2, Class<?>... clsArr) {
        try {
            return m7165a(Class.forName(str), str2, (Class[]) clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static void m7167a(Context context, Uri uri) {
        Intent a = m7153a(uri);
        a.addCategory("android.intent.category.BROWSABLE");
        a.addFlags(268435456);
        a.putExtra("com.android.browser.application_id", context.getPackageName());
        a.putExtra("create_new_tab", false);
        context.startActivity(a);
    }

    public static void m7168a(Context context, Uri uri, String str) {
        if (C0023d.m980a(uri.getScheme()) && app.m6622d(context)) {
            m7174b(context, uri, str);
        } else {
            m7167a(context, uri);
        }
    }

    public static void m7169a(Context context, String str) {
        if (C0017i.m962a(context)) {
            Log.d("FBAudienceNetworkLog", str + " (displayed for test ads only)");
        }
    }

    public static void m7170a(DisplayMetrics displayMetrics, View view, C0060k c0060k) {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) >= c0060k.m1124a() ? displayMetrics.widthPixels : (int) Math.ceil((double) (((float) c0060k.m1124a()) * displayMetrics.density)), (int) Math.ceil((double) (((float) c0060k.m1125b()) * displayMetrics.density)));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }

    public static boolean m7171a(Context context) {
        try {
            RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(2).get(0);
            String str = runningTaskInfo.topActivity.getPackageName() + ".UnityPlayerActivity";
            boolean z = runningTaskInfo.topActivity.getClassName() == str || m7175b(str);
            Boolean valueOf = Boolean.valueOf(z);
            Log.d("IS_UNITY", Boolean.toString(valueOf.booleanValue()));
            return valueOf.booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean m7172a(String str, String str2) {
        try {
            Class.forName(str + "." + str2);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static byte[] m7173a(String str) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Throwable e) {
            att.m7141a(atq.m7138a(e, "Error compressing data"));
            e.printStackTrace();
            return new byte[0];
        }
    }

    private static void m7174b(Context context, Uri uri, String str) {
        Intent intent = new Intent(context, AudienceNetworkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("viewType", C0071w.BROWSER);
        intent.putExtra("browserURL", uri.toString());
        intent.putExtra("clientToken", str);
        intent.putExtra("handlerTime", System.currentTimeMillis());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setClass(context, ab.class);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                m7167a(context, uri);
            }
        }
    }

    public static boolean m7175b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
