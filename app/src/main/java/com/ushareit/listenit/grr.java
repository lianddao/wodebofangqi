package com.ushareit.listenit;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class grr {
    public static grr f14600a = null;
    private static final int[][] f14601b = new int[][]{new int[]{51, 97, 100, 102, 109, 111, 114, 116, 119}, new int[]{49, 50, 52, 97, 99, 103, 107, 108, 109, 111, 112, 116, 118}, new int[]{50, 51, 97, 99, 100, 101, 103, 107, 112, 114, 115, 118}, new int[]{99, 112}};
    private static final int[] f14602c = new int[]{54, 164, 200, 321, 420, 516, 532, 548, 612, 627, 648, 676, 817, 932, 1172, 1441, 1621, 1847, 2433, 2738, 2872, 6224};
    private grp f14603d = new grp();
    private final AtomicInteger f14604e = new AtomicInteger(0);
    private gro f14605f;
    private boolean f14606g = false;
    private boolean f14607h = false;
    private boolean f14608i = false;
    private gxy f14609j = new grx(this);

    private grr() {
    }

    public static grr m22621a() {
        if (f14600a == null) {
            f14600a = new grr();
        }
        return f14600a;
    }

    public void m22645b() {
    }

    public void m22643a(gro com_ushareit_listenit_gro) {
        if (this.f14603d.m22612a()) {
            this.f14605f = com_ushareit_listenit_gro;
        }
    }

    public void m22644a(gry com_ushareit_listenit_gry) {
        this.f14603d.m22610a(com_ushareit_listenit_gry);
    }

    public void m22646b(gry com_ushareit_listenit_gry) {
        this.f14603d.m22613b(com_ushareit_listenit_gry);
    }

    public void m22647c() {
        this.f14606g = true;
    }

    public boolean m22648d() {
        return this.f14603d.m22612a();
    }

    public void m22642a(Context context, boolean z) {
        boolean z2 = false;
        if (!this.f14603d.m22614b()) {
            this.f14606g = false;
            if (!z) {
                z2 = true;
            }
            this.f14607h = z2;
            this.f14608i = z;
            this.f14603d.m22615c();
            hhx.m23867a(new grs(this, z, context));
        }
    }

    public boolean m22649e() {
        return this.f14607h;
    }

    public boolean m22650f() {
        return this.f14608i;
    }

    public void m22651g() {
        hhx.m23867a(new grt(this));
    }

    private void m22622a(Context context) {
        this.f14604e.incrementAndGet();
        hhx.m23867a(new gru(this, context));
    }

    private void m22629b(Context context) {
        this.f14604e.incrementAndGet();
        hhx.m23867a(new grv(this, context));
    }

    private void m22634c(Context context) {
        Cursor cursor = null;
        try {
            cursor = grz.m22656a().m22661a(context);
            if (gyn.m23200a(cursor)) {
                glf com_ushareit_listenit_glf = new glf();
                for (int i = 0; i < cursor.getCount(); i++) {
                    cursor.moveToPosition(i);
                    String string = cursor.getString(cursor.getColumnIndex("_data"));
                    File file = new File(string);
                    if (file.exists() && (this.f14605f == null || !this.f14605f.m22605a(file.length()))) {
                        com_ushareit_listenit_glf.mo2560a(cursor);
                        if (com_ushareit_listenit_glf.f14311f <= 0) {
                            com_ushareit_listenit_glf.f14311f = m22627b(file);
                        }
                        if (com_ushareit_listenit_glf.f14311f > 0 && (this.f14605f == null || !this.f14605f.m22604a(com_ushareit_listenit_glf.f14311f))) {
                            this.f14603d.m22611a(string, (i * 100) / cursor.getCount());
                            this.f14603d.m22609a(com_ushareit_listenit_glf);
                            if (this.f14606g) {
                                break;
                            }
                        }
                    }
                }
                synchronized (this.f14604e) {
                    if (this.f14604e.decrementAndGet() == 0) {
                        this.f14603d.m22616d();
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            }
            synchronized (this.f14604e) {
                if (this.f14604e.decrementAndGet() == 0) {
                    this.f14603d.m22616d();
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            exw.m18457e("GlobalScanHelper", "error: " + exw.m18438a(e));
            synchronized (this.f14604e) {
                if (this.f14604e.decrementAndGet() == 0) {
                    this.f14603d.m22616d();
                }
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th) {
            synchronized (this.f14604e) {
                if (this.f14604e.decrementAndGet() == 0) {
                    this.f14603d.m22616d();
                }
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    private void m22637d(Context context) {
        Cursor cursor = null;
        try {
            cursor = grz.m22656a().m22661a(context);
            if (gyn.m23200a(cursor)) {
                glf com_ushareit_listenit_glf = new glf();
                for (int i = 0; i < cursor.getCount(); i++) {
                    cursor.moveToPosition(i);
                    String string = cursor.getString(cursor.getColumnIndex("_data"));
                    File file = new File(string);
                    if (file.exists() && (this.f14605f == null || !this.f14605f.m22605a(file.length()))) {
                        this.f14603d.m22611a(string, (i * 100) / cursor.getCount());
                        if (frf.m20669c(string)) {
                            continue;
                        } else {
                            com_ushareit_listenit_glf.mo2560a(cursor);
                            if (com_ushareit_listenit_glf.f14311f <= 0) {
                                com_ushareit_listenit_glf.f14311f = m22627b(file);
                            }
                            if (com_ushareit_listenit_glf.f14311f > 0 && (this.f14605f == null || !this.f14605f.m22604a(com_ushareit_listenit_glf.f14311f))) {
                                this.f14603d.m22609a(com_ushareit_listenit_glf);
                                if (this.f14606g) {
                                    break;
                                }
                            }
                        }
                    }
                }
                synchronized (this.f14604e) {
                    if (this.f14604e.decrementAndGet() == 0) {
                        this.f14603d.m22616d();
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            }
            synchronized (this.f14604e) {
                if (this.f14604e.decrementAndGet() == 0) {
                    this.f14603d.m22616d();
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            exw.m18457e("GlobalScanHelper", "error: " + exw.m18438a(e));
            synchronized (this.f14604e) {
                if (this.f14604e.decrementAndGet() == 0) {
                    this.f14603d.m22616d();
                }
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th) {
            synchronized (this.f14604e) {
                if (this.f14604e.decrementAndGet() == 0) {
                    this.f14603d.m22616d();
                }
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    private void m22639e(Context context) {
        int i = 0;
        List<eyk> b = eyj.m18514b(context);
        List<gxx> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (eyk com_ushareit_listenit_eyk : b) {
            File[] listFiles = new File(com_ushareit_listenit_eyk.f12178d).listFiles(this.f14609j);
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList3.add(file);
                } else {
                    arrayList2.add(file);
                }
            }
        }
        int max = Math.max(3, Runtime.getRuntime().availableProcessors()) - 1;
        int size = arrayList3.size();
        if (size >= max) {
            size /= max;
            while (i < max) {
                arrayList.add(new gxx(arrayList3.subList(size * i, i == max + -1 ? arrayList3.size() : (i + 1) * size), this.f14609j));
                i++;
            }
        } else {
            while (i < size) {
                arrayList.add(new gxx((File) arrayList3.get(i), this.f14609j));
                i++;
            }
        }
        if (arrayList2.size() > 0) {
            arrayList.add(new gxx(arrayList2, this.f14609j));
        }
        this.f14604e.addAndGet(arrayList.size());
        for (gxx com_ushareit_listenit_grw : arrayList) {
            hhx.m23867a(new grw(this, context, com_ushareit_listenit_grw));
        }
    }

    private void m22623a(Context context, gxx com_ushareit_listenit_gxx) {
        while (com_ushareit_listenit_gxx.hasNext()) {
            try {
                File a = com_ushareit_listenit_gxx.m23115a();
                this.f14603d.m22611a(a.getAbsolutePath(), 0);
                if (!a.isDirectory()) {
                    String absolutePath = a.getAbsolutePath();
                    String d = m22636d(absolutePath);
                    if (d != null && m22631b(d) && a.exists()) {
                        if (this.f14605f == null || !this.f14605f.m22605a(a.length())) {
                            if (!grz.m22656a().m22668b(context, absolutePath)) {
                                glf a2 = m22619a(a);
                                if (a2 != null && (this.f14605f == null || !this.f14605f.m22604a(a2.f14311f))) {
                                    this.f14603d.m22609a(a2);
                                }
                                gyn.m23187a(eys.m18562a(), a);
                            }
                            if (this.f14606g) {
                                return;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    public glg m22641a(String str) {
        if (fbb.m18763c(str) || !m22631b(m22636d(str))) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        if (this.f14605f != null && this.f14605f.m22605a(file.length())) {
            return null;
        }
        glf c = grz.m22656a().m22669c(eys.m18562a(), str);
        if (c != null && c.f14311f <= 0) {
            c.f14311f = m22627b(file);
        }
        if (c == null) {
            c = m22619a(file);
        }
        if (c == null) {
            return null;
        }
        if (this.f14605f != null && this.f14605f.m22604a(c.f14311f)) {
            return null;
        }
        frf.m20642a(c);
        glg a = fqs.m20448a(str);
        gyy.m23326a().m23329a(a);
        return a;
    }

    private synchronized glf m22619a(File file) {
        glf com_ushareit_listenit_glf;
        if (file != null) {
            if (file.exists()) {
                gyl com_ushareit_listenit_gyl = new gyl();
                if (com_ushareit_listenit_gyl.m23160a(file.getAbsolutePath())) {
                    String absolutePath = file.getAbsolutePath();
                    int length = (int) file.length();
                    int a = com_ushareit_listenit_gyl.m23157a(9, 0);
                    int a2 = com_ushareit_listenit_gyl.m23157a(8, 0);
                    long a3 = com_ushareit_listenit_gyl.m23158a(5, 0);
                    String a4 = com_ushareit_listenit_gyl.m23159a(7, "");
                    String a5 = com_ushareit_listenit_gyl.m23159a(2, "");
                    String a6 = com_ushareit_listenit_gyl.m23159a(1, "");
                    String a7 = com_ushareit_listenit_gyl.m23159a(13, "");
                    String str = "";
                    String b = gyn.m23209b(file.getAbsolutePath());
                    String c = gyn.m23220c(file.getAbsolutePath());
                    String str2 = "0";
                    String a8 = com_ushareit_listenit_gyl.m23159a(6, "");
                    String e = gyn.m23235e(absolutePath);
                    int a9 = com_ushareit_listenit_gyl.m23157a(0, 0);
                    com_ushareit_listenit_gyl.m23162b();
                    if (a <= 0) {
                        a = m22627b(file);
                    }
                    com_ushareit_listenit_glf = new glf(0, 0, absolutePath, length, a, 0, a2, a3, a3, a4, a5, 0, a6, 0, a7, str, 0, 0, b, c, 0, 0, str2, 0, a8, e, 0, 0, 0, (long) 0, true, a9, 0);
                    exw.m18443a("GlobalScanHelper", "extractAudioDataFromFile: audioFile=" + absolutePath);
                } else {
                    com_ushareit_listenit_gyl.m23162b();
                    com_ushareit_listenit_glf = null;
                }
            }
        }
        com_ushareit_listenit_glf = null;
        return com_ushareit_listenit_glf;
    }

    private synchronized int m22627b(File file) {
        int i = 0;
        synchronized (this) {
            if (file != null) {
                if (file.exists()) {
                    System.currentTimeMillis();
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(file.getAbsolutePath());
                        mediaPlayer.prepare();
                        i = mediaPlayer.getDuration();
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    } catch (Throwable th) {
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    }
                }
            }
        }
        return i;
    }

    private boolean m22631b(String str) {
        int c = m22632c(str);
        if (c != 0 && gyn.m23171a(f14602c, f14602c.length, c) >= 0) {
            return true;
        }
        return false;
    }

    private int m22632c(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int a = gyn.m23171a(f14601b[i], f14601b[i].length, str.charAt(i));
            if (a < 0) {
                return 0;
            }
            a = (a << (i << 2)) + i2;
            i++;
            i2 = a;
        }
        return i2;
    }

    private String m22636d(String str) {
        try {
            String substring;
            int length = str.length();
            int i = length - 4;
            if (str.charAt(length - 4) == '.') {
                substring = str.substring(i + 1, length);
            } else {
                substring = null;
            }
            int i2 = length - 5;
            if (substring == null && str.charAt(i2) == '.') {
                return str.substring(i2 + 1, length);
            }
            return substring;
        } catch (Exception e) {
            return null;
        }
    }
}
