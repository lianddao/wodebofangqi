package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

@TargetApi(19)
public class xc implements xa {
    private static final Config[] f17518a = new Config[]{Config.ARGB_8888, null};
    private static final Config[] f17519b = new Config[]{Config.RGB_565};
    private static final Config[] f17520c = new Config[]{Config.ARGB_4444};
    private static final Config[] f17521d = new Config[]{Config.ALPHA_8};
    private final xf f17522e = new xf();
    private final wu<xe, Bitmap> f17523f = new wu();
    private final Map<Config, NavigableMap<Integer, Integer>> f17524g = new HashMap();

    public void mo3122a(Bitmap bitmap) {
        xe a = this.f17522e.m27192a(afu.m5492a(bitmap), bitmap.getConfig());
        this.f17523f.m27156a(a, bitmap);
        NavigableMap a2 = m27178a(bitmap.getConfig());
        Integer num = (Integer) a2.get(Integer.valueOf(a.f17527b));
        a2.put(Integer.valueOf(a.f17527b), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    public Bitmap mo3121a(int i, int i2, Config config) {
        int a = afu.m5490a(i, i2, config);
        Bitmap bitmap = (Bitmap) this.f17523f.m27155a(m27176a(this.f17522e.m27192a(a, config), a, config));
        if (bitmap != null) {
            m27179a(Integer.valueOf(afu.m5492a(bitmap)), bitmap.getConfig());
            bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        }
        return bitmap;
    }

    private xe m27176a(xe xeVar, int i, Config config) {
        Config[] b = m27181b(config);
        int length = b.length;
        int i2 = 0;
        while (i2 < length) {
            Config config2 = b[i2];
            Integer num = (Integer) m27178a(config2).ceilingKey(Integer.valueOf(i));
            if (num == null || num.intValue() > i * 8) {
                i2++;
            } else {
                if (num.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return xeVar;
                        }
                    } else if (config2.equals(config)) {
                        return xeVar;
                    }
                }
                this.f17522e.m27134a(xeVar);
                return this.f17522e.m27192a(num.intValue(), config2);
            }
        }
        return xeVar;
    }

    public Bitmap mo3120a() {
        Bitmap bitmap = (Bitmap) this.f17523f.m27154a();
        if (bitmap != null) {
            m27179a(Integer.valueOf(afu.m5492a(bitmap)), bitmap.getConfig());
        }
        return bitmap;
    }

    private void m27179a(Integer num, Config config) {
        NavigableMap a = m27178a(config);
        Integer num2 = (Integer) a.get(num);
        if (num2.intValue() == 1) {
            a.remove(num);
        } else {
            a.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> m27178a(Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f17524g.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        NavigableMap treeMap = new TreeMap();
        this.f17524g.put(config, treeMap);
        return treeMap;
    }

    public String mo3124b(Bitmap bitmap) {
        return m27180b(afu.m5492a(bitmap), bitmap.getConfig());
    }

    public String mo3123b(int i, int i2, Config config) {
        return m27180b(afu.m5490a(i, i2, config), config);
    }

    public int mo3125c(Bitmap bitmap) {
        return afu.m5492a(bitmap);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.f17523f).append(", sortedSizes=(");
        for (Entry entry : this.f17524g.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.f17524g.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        return append.append(")}").toString();
    }

    private static String m27180b(int i, Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Config[] m27181b(Config config) {
        switch (xd.f17525a[config.ordinal()]) {
            case 1:
                return f17518a;
            case 2:
                return f17519b;
            case 3:
                return f17520c;
            case 4:
                return f17521d;
            default:
                return new Config[]{config};
        }
    }
}
