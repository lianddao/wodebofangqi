package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ath implements atd<Bundle> {
    private final String f5332a;
    private boolean f5333b;
    private final Context f5334c;
    private final apa f5335d;
    private final atk f5336e;
    private final amv f5337f;
    private int f5338g;
    private int f5339h;
    private final asp f5340i;

    public ath(Context context, apa com_ushareit_listenit_apa, atk com_ushareit_listenit_atk, String str) {
        this(context, com_ushareit_listenit_apa, com_ushareit_listenit_atk, str, null);
    }

    public ath(Context context, apa com_ushareit_listenit_apa, atk com_ushareit_listenit_atk, String str, Bundle bundle) {
        this.f5333b = true;
        this.f5338g = 0;
        this.f5339h = 0;
        this.f5334c = context;
        this.f5335d = com_ushareit_listenit_apa;
        this.f5336e = com_ushareit_listenit_atk;
        this.f5332a = str;
        List arrayList = new ArrayList();
        arrayList.add(new ati(this, 0.5d, -1.0d, 2.0d, true, com_ushareit_listenit_apa, str));
        arrayList.add(new atj(this, 1.0E-7d, -1.0d, 0.001d, false, com_ushareit_listenit_apa, str));
        if (bundle != null) {
            this.f5337f = new amv(context, (View) com_ushareit_listenit_atk, arrayList, bundle.getBundle("adQualityManager"));
            this.f5338g = bundle.getInt("lastProgressTimeMS");
            this.f5339h = bundle.getInt("lastBoundaryTimeMS");
        } else {
            this.f5337f = new amv(context, (View) com_ushareit_listenit_atk, arrayList);
        }
        this.f5340i = new asp(new Handler(), this);
    }

    private Map<String, String> m6987a(atl com_ushareit_listenit_atl) {
        return m6988a(com_ushareit_listenit_atl, this.f5336e.getCurrentPosition());
    }

    private Map<String, String> m6988a(atl com_ushareit_listenit_atl, int i) {
        Map<String, String> c = m6993c(i);
        c.put("action", String.valueOf(com_ushareit_listenit_atl.f5439j));
        return c;
    }

    private void m6989a(int i, boolean z) {
        if (((double) i) > 0.0d && i >= this.f5338g) {
            if (i > this.f5338g) {
                this.f5337f.m6336a((double) (((float) (i - this.f5338g)) / 1000.0f), (double) m7000d());
                this.f5338g = i;
                if (i - this.f5339h >= 5000) {
                    this.f5335d.mo746c(this.f5332a, m6988a(atl.TIME, i));
                    this.f5339h = this.f5338g;
                    this.f5337f.m6335a();
                    return;
                }
            }
            if (z) {
                this.f5335d.mo746c(this.f5332a, m6988a(atl.TIME, i));
            }
        }
    }

    private void m6990a(Map<String, String> map) {
        map.put("exoplayer", String.valueOf(this.f5336e.mo146b()));
        map.put("prep", Long.toString(this.f5336e.getInitialBufferTime()));
    }

    private void m6991a(Map<String, String> map, int i) {
        map.put("ptime", String.valueOf(((float) this.f5339h) / 1000.0f));
        map.put("time", String.valueOf(((float) i) / 1000.0f));
    }

    private void m6992b(Map<String, String> map) {
        amx b = this.f5337f.m6337b();
        amy b2 = b.m6341b();
        map.put("vwa", String.valueOf(b2.m6347c()));
        map.put("vwm", String.valueOf(b2.m6346b()));
        map.put("vwmax", String.valueOf(b2.m6348d()));
        map.put("vtime_ms", String.valueOf(b2.m6350f() * 1000.0d));
        map.put("mcvt_ms", String.valueOf(b2.m6351g() * 1000.0d));
        amy c = b.m6343c();
        map.put("vla", String.valueOf(c.m6347c()));
        map.put("vlm", String.valueOf(c.m6346b()));
        map.put("vlmax", String.valueOf(c.m6348d()));
        map.put("atime_ms", String.valueOf(c.m6350f() * 1000.0d));
        map.put("mcat_ms", String.valueOf(c.m6351g() * 1000.0d));
    }

    private Map<String, String> m6993c(int i) {
        Map hashMap = new HashMap();
        atn.m7130a(hashMap, this.f5336e.mo145a(), !this.f5336e.mo147c());
        m6990a(hashMap);
        m6992b(hashMap);
        m6991a(hashMap, i);
        m6994c(hashMap);
        return hashMap;
    }

    private void m6994c(Map<String, String> map) {
        Rect rect = new Rect();
        this.f5336e.getGlobalVisibleRect(rect);
        map.put("pt", String.valueOf(rect.top));
        map.put(fnh.KEY_PLAYLIST, String.valueOf(rect.left));
        map.put("ph", String.valueOf(this.f5336e.getMeasuredHeight()));
        map.put("pw", String.valueOf(this.f5336e.getMeasuredWidth()));
        WindowManager windowManager = (WindowManager) this.f5334c.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        map.put("vph", String.valueOf(displayMetrics.heightPixels));
        map.put("vpw", String.valueOf(displayMetrics.widthPixels));
    }

    public void m6995a(int i) {
        m6989a(i, false);
    }

    public void m6996a(int i, int i2) {
        m6989a(i, true);
        this.f5339h = i2;
        this.f5338g = i2;
        this.f5337f.m6335a();
    }

    public void m6997b() {
        this.f5334c.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.f5340i);
    }

    public void m6998b(int i) {
        m6989a(i, true);
        this.f5339h = 0;
        this.f5338g = 0;
        this.f5337f.m6335a();
    }

    public void m6999c() {
        this.f5334c.getContentResolver().unregisterContentObserver(this.f5340i);
    }

    protected float m7000d() {
        return atn.m7129a(this.f5334c) * this.f5336e.getVolume();
    }

    public void m7001e() {
        if (((double) m7000d()) < 0.05d) {
            if (this.f5333b) {
                m7002f();
                this.f5333b = false;
            }
        } else if (!this.f5333b) {
            m7003g();
            this.f5333b = true;
        }
    }

    public void m7002f() {
        this.f5335d.mo746c(this.f5332a, m6987a(atl.MUTE));
    }

    public void m7003g() {
        this.f5335d.mo746c(this.f5332a, m6987a(atl.UNMUTE));
    }

    public Bundle getSaveInstanceState() {
        m6996a(m7007k(), m7007k());
        Bundle bundle = new Bundle();
        bundle.putInt("lastProgressTimeMS", this.f5338g);
        bundle.putInt("lastBoundaryTimeMS", this.f5339h);
        bundle.putBundle("adQualityManager", this.f5337f.getSaveInstanceState());
        return bundle;
    }

    public void m7004h() {
        this.f5335d.mo746c(this.f5332a, m6987a(atl.SKIP));
    }

    public void m7005i() {
        this.f5335d.mo746c(this.f5332a, m6987a(atl.PAUSE));
    }

    public void m7006j() {
        this.f5335d.mo746c(this.f5332a, m6987a(atl.RESUME));
    }

    public int m7007k() {
        return this.f5338g;
    }
}
