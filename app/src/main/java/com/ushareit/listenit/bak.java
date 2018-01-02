package com.ushareit.listenit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.appevents.C0075a;
import com.facebook.internal.C0102j;
import com.facebook.internal.C0111s;
import com.facebook.internal.C0113u;
import com.facebook.internal.aj;
import com.facebook.internal.as;
import com.facebook.internal.cb;
import com.facebook.internal.cr;
import com.facebook.share.internal.LikeContent;
import com.umeng.analytics.pro.C0321x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class bak {
    private static final String f5779a = bak.class.getSimpleName();
    private static aj f5780b;
    private static final ConcurrentHashMap<String, bak> f5781c = new ConcurrentHashMap();
    private static cr f5782d = new cr(1);
    private static cr f5783e = new cr(1);
    private static Handler f5784f;
    private static String f5785g;
    private static boolean f5786h;
    private static volatile int f5787i;
    private static ahv f5788j;
    private String f5789k;
    private bdm f5790l;
    private boolean f5791m;
    private String f5792n;
    private String f5793o;
    private String f5794p;
    private String f5795q;
    private String f5796r;
    private String f5797s;
    private boolean f5798t;
    private boolean f5799u;
    private boolean f5800v;
    private Bundle f5801w;
    private C0075a f5802x;

    private static void m7526b(java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = 0;
        r0 = f5780b;	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r1 = r0.m1410b(r4);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r0 = r5.getBytes();	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r1.write(r0);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        if (r1 == 0) goto L_0x0013;
    L_0x0010:
        com.facebook.internal.cb.m1581a(r1);
    L_0x0013:
        return;
    L_0x0014:
        r0 = move-exception;
        r2 = f5779a;	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r3 = "Unable to serialize controller to disk";	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        if (r1 == 0) goto L_0x0013;
    L_0x001e:
        com.facebook.internal.cb.m1581a(r1);
        goto L_0x0013;
    L_0x0022:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        com.facebook.internal.cb.m1581a(r1);
    L_0x0028:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.bak.b(java.lang.String, java.lang.String):void");
    }

    public static boolean m7514a(int i, int i2, Intent intent) {
        if (cb.m1591a(f5785g)) {
            f5785g = ail.m5715f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
        }
        if (cb.m1591a(f5785g)) {
            return false;
        }
        m7510a(f5785g, bdm.UNKNOWN, new bal(i, i2, intent));
        return true;
    }

    public static void m7510a(String str, bdm com_ushareit_listenit_bdm, bbb com_ushareit_listenit_bbb) {
        if (!f5786h) {
            m7552j();
        }
        bak a = m7495a(str);
        if (a != null) {
            m7500a(a, com_ushareit_listenit_bdm, com_ushareit_listenit_bbb);
        } else {
            f5783e.m1666a(new bba(str, com_ushareit_listenit_bdm, com_ushareit_listenit_bbb));
        }
    }

    private static void m7500a(bak com_ushareit_listenit_bak, bdm com_ushareit_listenit_bdm, bbb com_ushareit_listenit_bbb) {
        aif com_ushareit_listenit_aif;
        bak com_ushareit_listenit_bak2 = null;
        bdm a = bcj.m7730a(com_ushareit_listenit_bdm, com_ushareit_listenit_bak.f5790l);
        if (a == null) {
            com_ushareit_listenit_aif = new aif("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", com_ushareit_listenit_bak.f5789k, com_ushareit_listenit_bak.f5790l.toString(), com_ushareit_listenit_bdm.toString());
        } else {
            com_ushareit_listenit_bak.f5790l = a;
            com_ushareit_listenit_aif = null;
            com_ushareit_listenit_bak2 = com_ushareit_listenit_bak;
        }
        m7505a(com_ushareit_listenit_bbb, com_ushareit_listenit_bak2, com_ushareit_listenit_aif);
    }

    private static void m7533c(String str, bdm com_ushareit_listenit_bdm, bbb com_ushareit_listenit_bbb) {
        bak a = m7495a(str);
        if (a != null) {
            m7500a(a, com_ushareit_listenit_bdm, com_ushareit_listenit_bbb);
            return;
        }
        a = m7517b(str);
        if (a == null) {
            a = new bak(str, com_ushareit_listenit_bdm);
            m7556l(a);
        }
        m7509a(str, a);
        f5784f.post(new bao(a));
        m7505a(com_ushareit_listenit_bbb, a, null);
    }

    private static synchronized void m7552j() {
        synchronized (bak.class) {
            if (!f5786h) {
                f5784f = new Handler(Looper.getMainLooper());
                f5787i = ail.m5715f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
                f5780b = new aj(f5779a, new as());
                m7553k();
                C0111s.m1712a(C0113u.Like.m1717a(), new bap());
                f5786h = true;
            }
        }
    }

    private static void m7505a(bbb com_ushareit_listenit_bbb, bak com_ushareit_listenit_bak, aif com_ushareit_listenit_aif) {
        if (com_ushareit_listenit_bbb != null) {
            f5784f.post(new baq(com_ushareit_listenit_bbb, com_ushareit_listenit_bak, com_ushareit_listenit_aif));
        }
    }

    private static void m7553k() {
        f5788j = new bar();
    }

    private static void m7509a(String str, bak com_ushareit_listenit_bak) {
        String d = m7536d(str);
        f5782d.m1666a(new bbg(d, true));
        f5781c.put(d, com_ushareit_listenit_bak);
    }

    private static bak m7495a(String str) {
        String d = m7536d(str);
        bak com_ushareit_listenit_bak = (bak) f5781c.get(d);
        if (com_ushareit_listenit_bak != null) {
            f5782d.m1666a(new bbg(d, false));
        }
        return com_ushareit_listenit_bak;
    }

    private static void m7556l(bak com_ushareit_listenit_bak) {
        String m = m7557m(com_ushareit_listenit_bak);
        String d = m7536d(com_ushareit_listenit_bak.f5789k);
        if (!cb.m1591a(m) && !cb.m1591a(d)) {
            f5783e.m1666a(new bbk(d, m));
        }
    }

    private static bak m7517b(String str) {
        Throwable e;
        Throwable th;
        bak com_ushareit_listenit_bak = null;
        Closeable a;
        try {
            a = f5780b.m1406a(m7536d(str));
            if (a != null) {
                try {
                    String a2 = cb.m1562a((InputStream) a);
                    if (!cb.m1591a(a2)) {
                        com_ushareit_listenit_bak = m7528c(a2);
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        Log.e(f5779a, "Unable to deserialize controller from disk", e);
                        if (a != null) {
                            cb.m1581a(a);
                        }
                        return com_ushareit_listenit_bak;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            cb.m1581a(a);
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                cb.m1581a(a);
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
            Log.e(f5779a, "Unable to deserialize controller from disk", e);
            if (a != null) {
                cb.m1581a(a);
            }
            return com_ushareit_listenit_bak;
        } catch (Throwable e4) {
            a = null;
            th = e4;
            if (a != null) {
                cb.m1581a(a);
            }
            throw th;
        }
        return com_ushareit_listenit_bak;
    }

    private static bak m7528c(String str) {
        bak com_ushareit_listenit_bak;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
                return null;
            }
            com_ushareit_listenit_bak = new bak(jSONObject.getString("object_id"), bdm.m7831a(jSONObject.optInt("object_type", bdm.UNKNOWN.m7832a())));
            com_ushareit_listenit_bak.f5792n = jSONObject.optString("like_count_string_with_like", null);
            com_ushareit_listenit_bak.f5793o = jSONObject.optString("like_count_string_without_like", null);
            com_ushareit_listenit_bak.f5794p = jSONObject.optString("social_sentence_with_like", null);
            com_ushareit_listenit_bak.f5795q = jSONObject.optString("social_sentence_without_like", null);
            com_ushareit_listenit_bak.f5791m = jSONObject.optBoolean("is_object_liked");
            com_ushareit_listenit_bak.f5796r = jSONObject.optString("unlike_token", null);
            jSONObject = jSONObject.optJSONObject("facebook_dialog_analytics_bundle");
            if (jSONObject != null) {
                com_ushareit_listenit_bak.f5801w = C0102j.m1692a(jSONObject);
            }
            return com_ushareit_listenit_bak;
        } catch (Throwable e) {
            Log.e(f5779a, "Unable to deserialize controller from JSON", e);
            com_ushareit_listenit_bak = null;
        }
    }

    private static String m7557m(bak com_ushareit_listenit_bak) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("com.facebook.share.internal.LikeActionController.version", 3);
            jSONObject.put("object_id", com_ushareit_listenit_bak.f5789k);
            jSONObject.put("object_type", com_ushareit_listenit_bak.f5790l.m7832a());
            jSONObject.put("like_count_string_with_like", com_ushareit_listenit_bak.f5792n);
            jSONObject.put("like_count_string_without_like", com_ushareit_listenit_bak.f5793o);
            jSONObject.put("social_sentence_with_like", com_ushareit_listenit_bak.f5794p);
            jSONObject.put("social_sentence_without_like", com_ushareit_listenit_bak.f5795q);
            jSONObject.put("is_object_liked", com_ushareit_listenit_bak.f5791m);
            jSONObject.put("unlike_token", com_ushareit_listenit_bak.f5796r);
            if (com_ushareit_listenit_bak.f5801w != null) {
                JSONObject a = C0102j.m1693a(com_ushareit_listenit_bak.f5801w);
                if (a != null) {
                    jSONObject.put("facebook_dialog_analytics_bundle", a);
                }
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            Log.e(f5779a, "Unable to serialize controller to JSON", e);
            return null;
        }
    }

    private static String m7536d(String str) {
        String str2 = null;
        AccessToken a = AccessToken.m671a();
        if (a != null) {
            str2 = a.m678b();
        }
        if (str2 != null) {
            str2 = cb.m1595b(str2);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", new Object[]{str, cb.m1563a(str2, ""), Integer.valueOf(f5787i)});
    }

    private static void m7538d(bak com_ushareit_listenit_bak, String str) {
        m7532c(com_ushareit_listenit_bak, str, null);
    }

    private static void m7532c(bak com_ushareit_listenit_bak, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (com_ushareit_listenit_bak != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", com_ushareit_listenit_bak.m7562a());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        ec.m16689a(ail.m5715f()).m16694a(intent);
    }

    private bak(String str, bdm com_ushareit_listenit_bdm) {
        this.f5789k = str;
        this.f5790l = com_ushareit_listenit_bdm;
    }

    public String m7562a() {
        return this.f5789k;
    }

    public String m7564b() {
        return this.f5791m ? this.f5792n : this.f5793o;
    }

    public String m7565c() {
        return this.f5791m ? this.f5794p : this.f5795q;
    }

    public boolean m7566d() {
        return this.f5791m;
    }

    public boolean m7567e() {
        if (bbp.m7612e() || bbp.m7613f()) {
            return true;
        }
        if (this.f5798t || this.f5790l == bdm.PAGE) {
            return false;
        }
        AccessToken a = AccessToken.m671a();
        if (a == null || a.m680d() == null || !a.m680d().contains("publish_actions")) {
            return false;
        }
        return true;
    }

    public void m7563a(Activity activity, ah ahVar, Bundle bundle) {
        boolean z = true;
        m7555l().m1207a("fb_like_control_did_tap", null, bundle);
        boolean z2 = !this.f5791m;
        if (m7559n()) {
            m7527b(z2);
            if (this.f5800v) {
                m7555l().m1207a("fb_like_control_did_undo_quickly", null, bundle);
                return;
            } else if (!m7516a(z2, bundle)) {
                if (z2) {
                    z = false;
                }
                m7527b(z);
                m7521b(activity, ahVar, bundle);
                return;
            } else {
                return;
            }
        }
        m7521b(activity, ahVar, bundle);
    }

    private C0075a m7555l() {
        if (this.f5802x == null) {
            this.f5802x = C0075a.m1174a(ail.m5715f());
        }
        return this.f5802x;
    }

    private boolean m7516a(boolean z, Bundle bundle) {
        if (m7559n()) {
            if (z) {
                m7531c(bundle);
                return true;
            } else if (!cb.m1591a(this.f5796r)) {
                m7537d(bundle);
                return true;
            }
        }
        return false;
    }

    private void m7512a(boolean z) {
        m7527b(z);
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
        m7532c(this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle);
    }

    private void m7527b(boolean z) {
        m7513a(z, this.f5792n, this.f5793o, this.f5794p, this.f5795q, this.f5796r);
    }

    private void m7513a(boolean z, String str, String str2, String str3, String str4, String str5) {
        Object obj;
        Object a = cb.m1563a(str, null);
        Object a2 = cb.m1563a(str2, null);
        Object a3 = cb.m1563a(str3, null);
        Object a4 = cb.m1563a(str4, null);
        Object a5 = cb.m1563a(str5, null);
        if (z == this.f5791m && cb.m1590a(a, this.f5792n) && cb.m1590a(a2, this.f5793o) && cb.m1590a(a3, this.f5794p) && cb.m1590a(a4, this.f5795q) && cb.m1590a(a5, this.f5796r)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f5791m = z;
            this.f5792n = a;
            this.f5793o = a2;
            this.f5794p = a3;
            this.f5795q = a4;
            this.f5796r = a5;
            m7556l(this);
            m7538d(this, "com.facebook.sdk.LikeActionController.UPDATED");
        }
    }

    private void m7521b(Activity activity, ah ahVar, Bundle bundle) {
        String str;
        if (bbp.m7612e()) {
            str = "fb_like_control_did_present_dialog";
        } else if (bbp.m7613f()) {
            str = "fb_like_control_did_present_fallback_dialog";
        } else {
            m7507a("present_dialog", bundle);
            cb.m1601b(f5779a, "Cannot show the Like Dialog on this device.");
            m7538d(null, "com.facebook.sdk.LikeActionController.UPDATED");
            str = null;
        }
        if (str != null) {
            if (this.f5790l != null) {
                str = this.f5790l.toString();
            } else {
                str = bdm.UNKNOWN.toString();
            }
            LikeContent a = new bbo().m7608a(this.f5789k).m7609b(str).m7607a();
            if (ahVar != null) {
                new bbp(ahVar).m1738a(a);
            } else {
                new bbp(activity).m1738a(a);
            }
            m7522b(bundle);
            m7555l().m1207a("fb_like_control_did_present_dialog", null, bundle);
        }
    }

    private void m7520b(int i, int i2, Intent intent) {
        bcj.m7742a(i, i2, intent, m7496a(this.f5801w));
        m7558m();
    }

    private bcc m7496a(Bundle bundle) {
        return new bas(this, null, bundle);
    }

    private void m7522b(Bundle bundle) {
        m7542e(this.f5789k);
        this.f5801w = bundle;
        m7556l(this);
    }

    private void m7558m() {
        this.f5801w = null;
        m7542e(null);
    }

    private static void m7542e(String str) {
        f5785g = str;
        ail.m5715f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", f5785g).apply();
    }

    private boolean m7559n() {
        AccessToken a = AccessToken.m671a();
        return (this.f5798t || this.f5797s == null || a == null || a.m680d() == null || !a.m680d().contains("publish_actions")) ? false : true;
    }

    private void m7531c(Bundle bundle) {
        this.f5800v = true;
        m7506a(new bat(this, bundle));
    }

    private void m7537d(Bundle bundle) {
        this.f5800v = true;
        aje com_ushareit_listenit_aje = new aje();
        bbi com_ushareit_listenit_bbi = new bbi(this, this.f5796r);
        com_ushareit_listenit_bbi.m7588a(com_ushareit_listenit_aje);
        com_ushareit_listenit_aje.m5756a(new bav(this, com_ushareit_listenit_bbi, bundle));
        com_ushareit_listenit_aje.m5766h();
    }

    private void m7560o() {
        if (AccessToken.m671a() == null) {
            m7561p();
        } else {
            m7506a(new baw(this));
        }
    }

    private void m7561p() {
        bbv com_ushareit_listenit_bbv = new bbv(ail.m5715f(), ail.m5717h(), this.f5789k);
        if (com_ushareit_listenit_bbv.m1539a()) {
            com_ushareit_listenit_bbv.m1538a(new bam(this));
        }
    }

    private void m7541e(Bundle bundle) {
        if (this.f5791m != this.f5799u && !m7516a(this.f5791m, bundle)) {
            m7512a(!this.f5791m);
        }
    }

    private void m7506a(bbj com_ushareit_listenit_bbj) {
        if (cb.m1591a(this.f5797s)) {
            bbd com_ushareit_listenit_bbd = new bbd(this, this.f5789k, this.f5790l);
            bbf com_ushareit_listenit_bbf = new bbf(this, this.f5789k, this.f5790l);
            aje com_ushareit_listenit_aje = new aje();
            com_ushareit_listenit_bbd.m7588a(com_ushareit_listenit_aje);
            com_ushareit_listenit_bbf.m7588a(com_ushareit_listenit_aje);
            com_ushareit_listenit_aje.m5756a(new ban(this, com_ushareit_listenit_bbd, com_ushareit_listenit_bbf, com_ushareit_listenit_bbj));
            com_ushareit_listenit_aje.m5766h();
        } else if (com_ushareit_listenit_bbj != null) {
            com_ushareit_listenit_bbj.mo827a();
        }
    }

    private void m7507a(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.f5789k);
        bundle2.putString("object_type", this.f5790l.toString());
        bundle2.putString("current_action", str);
        m7555l().m1207a("fb_like_control_error", null, bundle2);
    }

    private void m7508a(String str, aih com_ushareit_listenit_aih) {
        Bundle bundle = new Bundle();
        if (com_ushareit_listenit_aih != null) {
            JSONObject e = com_ushareit_listenit_aih.m5696e();
            if (e != null) {
                bundle.putString(C0321x.aF, e.toString());
            }
        }
        m7507a(str, bundle);
    }
}
