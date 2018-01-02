package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

public final class bhr implements bib {
    private static List<Class<? extends bhy>> f6354a;

    public bhr() {
        synchronized (bhr.class) {
            if (f6354a == null) {
                List arrayList = new ArrayList();
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.biv").asSubclass(bhy.class));
                } catch (ClassNotFoundException e) {
                }
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.bjw").asSubclass(bhy.class));
                } catch (ClassNotFoundException e2) {
                }
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.bjz").asSubclass(bhy.class));
                } catch (ClassNotFoundException e3) {
                }
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.bjd").asSubclass(bhy.class));
                } catch (ClassNotFoundException e4) {
                }
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.blj").asSubclass(bhy.class));
                } catch (ClassNotFoundException e5) {
                }
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.blg").asSubclass(bhy.class));
                } catch (ClassNotFoundException e6) {
                }
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.bmh").asSubclass(bhy.class));
                } catch (ClassNotFoundException e7) {
                }
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.bik").asSubclass(bhy.class));
                } catch (ClassNotFoundException e8) {
                }
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.bko").asSubclass(bhy.class));
                } catch (ClassNotFoundException e9) {
                }
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.bmd").asSubclass(bhy.class));
                } catch (ClassNotFoundException e10) {
                }
                try {
                    arrayList.add(Class.forName("com.ushareit.listenit.bmn").asSubclass(bhy.class));
                } catch (ClassNotFoundException e11) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(bhy.class));
                } catch (ClassNotFoundException e12) {
                }
                f6354a = arrayList;
            }
        }
    }

    public bhy[] mo972a() {
        bhy[] com_ushareit_listenit_bhyArr = new bhy[f6354a.size()];
        int i = 0;
        while (i < com_ushareit_listenit_bhyArr.length) {
            try {
                com_ushareit_listenit_bhyArr[i] = (bhy) ((Class) f6354a.get(i)).getConstructor(new Class[0]).newInstance(new Object[0]);
                i++;
            } catch (Throwable e) {
                throw new IllegalStateException("Unexpected error creating default extractor", e);
            }
        }
        return com_ushareit_listenit_bhyArr;
    }
}
