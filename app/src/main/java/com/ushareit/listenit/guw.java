package com.ushareit.listenit;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class guw {
    public static guw f14770a = new guw();
    private boolean f14771b = false;
    private guy f14772c = null;

    private guw() {
    }

    public static guw m22831a() {
        if (f14770a == null) {
            f14770a = new guw();
        }
        return f14770a;
    }

    public void m22845a(Context context, gum com_ushareit_listenit_gum, boolean z) {
        if (com_ushareit_listenit_gum != null && !this.f14771b) {
            this.f14771b = true;
            hhx.m23867a(new gux(this, com_ushareit_listenit_gum, z, context));
        }
    }

    private void m22835a(gum com_ushareit_listenit_gum) {
        List<glg> q = com_ushareit_listenit_gum.mo2460q();
        List a = frg.m20687a();
        exw.m18457e("dsfd", "removeUnusedStreamSongs, invalid=" + a.size() + ", curr=" + q.size());
        for (glg com_ushareit_listenit_glg : q) {
            Long valueOf = Long.valueOf(com_ushareit_listenit_glg.f14334b);
            if (a.contains(valueOf)) {
                a.remove(valueOf);
            }
        }
        frg.m20691a(a);
    }

    public void m22844a(Context context, gum com_ushareit_listenit_gum) {
        if (com_ushareit_listenit_gum != null) {
            gvj.m22897a(context, m22838b(com_ushareit_listenit_gum));
        }
    }

    private String m22838b(gum com_ushareit_listenit_gum) {
        int i;
        int i2 = 0;
        int k = com_ushareit_listenit_gum.mo2454k();
        long u = com_ushareit_listenit_gum.mo2464u();
        int t = com_ushareit_listenit_gum.mo2463t();
        List q = com_ushareit_listenit_gum.mo2460q();
        List r = com_ushareit_listenit_gum.mo2461r();
        int size = q.size();
        boolean j = com_ushareit_listenit_gum.mo2453j();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(2).append(fno.KEY_VERSION);
        stringBuffer.append(k).append(",");
        stringBuffer.append(u).append(",");
        stringBuffer.append(t).append(",");
        if (j) {
            k = 1;
        } else {
            k = 0;
        }
        stringBuffer.append(k).append(",");
        stringBuffer.append(size).append(",");
        for (i = 0; i < size; i++) {
            stringBuffer.append(((glg) q.get(i)).f14334b + ",");
        }
        if (r.size() != size) {
            return stringBuffer.toString();
        }
        i = size - 1;
        while (i2 < i) {
            stringBuffer.append(((glg) r.get(i2)).f14334b + ",");
            i2++;
        }
        if (size > 0) {
            stringBuffer.append(((glg) q.get(i)).f14334b);
        }
        exw.m18443a("UserPlayState", "generatePlayState:  playQueueSize=" + q.size() + ", originQueue.size=" + r.size());
        return stringBuffer.toString();
    }

    public void m22846b() {
        if (this.f14772c == null) {
            this.f14772c = m22832a(eys.m18562a());
        }
    }

    public boolean m22848c() {
        return this.f14772c != null;
    }

    public void m22847b(Context context, gum com_ushareit_listenit_gum) {
        if (com_ushareit_listenit_gum != null) {
            if (this.f14772c == null) {
                this.f14772c = m22832a(context);
            }
            if (this.f14772c == null) {
                this.f14772c = m22842d();
            }
            if (this.f14772c != null) {
                com_ushareit_listenit_gum.mo2423a(this.f14772c.f14785i, this.f14772c.f14784h, this.f14772c.f14786j, this.f14772c.f14777a, this.f14772c.f14779c, this.f14772c.f14780d);
            }
        }
    }

    private guy m22832a(Context context) {
        String h = gvj.m22962h(context);
        if (!m22843d(h)) {
            return m22842d();
        }
        guy a;
        h = h.trim();
        int indexOf = h.indexOf(fno.KEY_VERSION);
        int parseInt = indexOf > 0 ? Integer.parseInt(h.substring(0, indexOf)) : 0;
        if (indexOf > 0) {
            h = h.substring(indexOf + 1, h.length());
        }
        if (parseInt == 0) {
            a = m22833a(h);
        } else if (parseInt == 1) {
            a = m22837b(h);
        } else if (parseInt == 2) {
            a = m22841c(h);
        } else {
            a = null;
        }
        if (a == null) {
            this.f14772c = m22842d();
            return null;
        }
        List a2;
        List a3;
        List a4 = a.f14782f != null ? fqs.m20454a(a.f14782f) : null;
        if (a.f14783g != null) {
            a2 = fqs.m20454a(a.f14783g);
        } else {
            a2 = null;
        }
        if (a4 == null || a4.size() == 0) {
            a3 = fqs.m20451a(context);
        } else {
            a3 = a4;
        }
        if (a2 == null || a2.size() != a3.size()) {
            a2 = a3;
        }
        if (a3 == null || a3.size() == 0) {
            return null;
        }
        glg a5 = fqs.m20447a(a.f14778b);
        if (a5 == null) {
            a5 = (glg) a3.get(0);
        }
        a.f14784h = a3;
        a.f14785i = a2;
        a.f14786j = a5;
        return a;
    }

    private guy m22833a(String str) {
        guy com_ushareit_listenit_guy = new guy(this);
        String[] split = str.split(",");
        com_ushareit_listenit_guy.f14777a = m22830a(Integer.parseInt(split[0]));
        com_ushareit_listenit_guy.f14778b = Long.parseLong(split[1]);
        com_ushareit_listenit_guy.f14780d = m22840b(com_ushareit_listenit_guy.f14777a);
        List arrayList = new ArrayList(split.length);
        for (int i = 2; i < split.length; i++) {
            arrayList.add(Long.valueOf(Long.parseLong(split[i])));
        }
        com_ushareit_listenit_guy.f14781e = arrayList.size();
        com_ushareit_listenit_guy.f14782f = arrayList;
        com_ushareit_listenit_guy.f14783g = arrayList;
        return com_ushareit_listenit_guy;
    }

    private guy m22837b(String str) {
        guy com_ushareit_listenit_guy = new guy(this);
        String[] split = str.split(",");
        com_ushareit_listenit_guy.f14777a = m22830a(Integer.parseInt(split[0]));
        com_ushareit_listenit_guy.f14778b = (long) Integer.parseInt(split[1]);
        com_ushareit_listenit_guy.f14779c = Integer.parseInt(split[2]);
        com_ushareit_listenit_guy.f14780d = m22840b(com_ushareit_listenit_guy.f14777a);
        List arrayList = new ArrayList(split.length);
        for (int i = 3; i < split.length; i++) {
            arrayList.add(Long.valueOf(Long.parseLong(split[i])));
        }
        com_ushareit_listenit_guy.f14781e = arrayList.size();
        com_ushareit_listenit_guy.f14782f = arrayList;
        com_ushareit_listenit_guy.f14783g = arrayList;
        return com_ushareit_listenit_guy;
    }

    private guy m22841c(String str) {
        boolean z = true;
        guy com_ushareit_listenit_guy = new guy(this);
        String[] split = str.split(",");
        com_ushareit_listenit_guy.f14777a = Integer.parseInt(split[0]);
        com_ushareit_listenit_guy.f14778b = (long) Integer.parseInt(split[1]);
        com_ushareit_listenit_guy.f14779c = Integer.parseInt(split[2]);
        if (Integer.parseInt(split[3]) != 1) {
            z = false;
        }
        com_ushareit_listenit_guy.f14780d = z;
        com_ushareit_listenit_guy.f14781e = Integer.parseInt(split[4]);
        int i = com_ushareit_listenit_guy.f14781e;
        exw.m18443a("UserPlayState", "playQueueSize=" + i + ", len=" + split.length);
        if (split.length != (i + i) + 5) {
            return com_ushareit_listenit_guy;
        }
        int i2;
        List arrayList = new ArrayList(i);
        for (i2 = 5; i2 < i + 5; i2++) {
            arrayList.add(Long.valueOf(Long.parseLong(split[i2])));
        }
        com_ushareit_listenit_guy.f14782f = arrayList;
        List arrayList2 = new ArrayList(i);
        for (i2 = i + 5; i2 < split.length; i2++) {
            arrayList2.add(Long.valueOf(Long.parseLong(split[i2])));
        }
        com_ushareit_listenit_guy.f14783g = arrayList2;
        exw.m18443a("UserPlayState", "parsePlayStateV2: playQueueSize=" + arrayList.size() + ", originQueueSize=" + arrayList2.size());
        return com_ushareit_listenit_guy;
    }

    private int m22830a(int i) {
        switch (i) {
            case 1:
                return 2;
            case 3:
                return 3;
            default:
                return 1;
        }
    }

    private boolean m22840b(int i) {
        return i == 2;
    }

    private boolean m22843d(String str) {
        return !fbb.m18763c(str) && str.length() > 5;
    }

    private guy m22842d() {
        List a = fqs.m20451a(eys.m18562a());
        if (a == null || a.size() == 0) {
            return null;
        }
        guy com_ushareit_listenit_guy = new guy(this);
        com_ushareit_listenit_guy.f14785i = a;
        com_ushareit_listenit_guy.f14784h = a;
        com_ushareit_listenit_guy.f14786j = (glg) a.get(0);
        com_ushareit_listenit_guy.f14780d = false;
        com_ushareit_listenit_guy.f14777a = 1;
        com_ushareit_listenit_guy.f14779c = 0;
        exw.m18457e("UserPlayState", "getDefaultPlayState");
        return com_ushareit_listenit_guy;
    }
}
