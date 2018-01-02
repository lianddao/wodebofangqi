package com.ushareit.listenit;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ud implements Closeable {
    final ThreadPoolExecutor f16858a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File f16859b;
    private final File f16860c;
    private final File f16861d;
    private final File f16862e;
    private final int f16863f;
    private long f16864g;
    private final int f16865h;
    private long f16866i = 0;
    private Writer f16867j;
    private final LinkedHashMap<String, ug> f16868k = new LinkedHashMap(0, 0.75f, true);
    private int f16869l;
    private long f16870m = 0;
    private final Callable<Void> f16871n = new ue(this);

    private ud(File file, int i, int i2, long j) {
        this.f16859b = file;
        this.f16863f = i;
        this.f16860c = new File(file, "journal");
        this.f16861d = new File(file, "journal.tmp");
        this.f16862e = new File(file, "journal.bkp");
        this.f16865h = i2;
        this.f16864g = j;
    }

    public static ud m26498a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m26504a(file2, file3, false);
                }
            }
            ud udVar = new ud(file, i, i2, j);
            if (udVar.f16860c.exists()) {
                try {
                    udVar.m26505b();
                    udVar.m26507c();
                    return udVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    udVar.m26518a();
                }
            }
            file.mkdirs();
            udVar = new ud(file, i, i2, j);
            udVar.m26509d();
            return udVar;
        }
    }

    private void m26505b() {
        Closeable uiVar = new ui(new FileInputStream(this.f16860c), uk.f16896a);
        int i;
        try {
            String a = uiVar.m26545a();
            String a2 = uiVar.m26545a();
            String a3 = uiVar.m26545a();
            String a4 = uiVar.m26545a();
            String a5 = uiVar.m26545a();
            if ("libcore.io.DiskLruCache".equals(a) && "1".equals(a2) && Integer.toString(this.f16863f).equals(a3) && Integer.toString(this.f16865h).equals(a4) && "".equals(a5)) {
                i = 0;
                while (true) {
                    m26511d(uiVar.m26545a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.f16869l = i - this.f16868k.size();
            if (uiVar.m26546b()) {
                m26509d();
            } else {
                this.f16867j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16860c, true), uk.f16896a));
            }
            uk.m26547a(uiVar);
        } catch (Throwable th) {
            uk.m26547a(uiVar);
        }
    }

    private void m26511d(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f16868k.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        ug ugVar = (ug) this.f16868k.get(str2);
        if (ugVar == null) {
            ugVar = new ug(this, str2);
            this.f16868k.put(str2, ugVar);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            ugVar.f16882f = true;
            ugVar.f16883g = null;
            ugVar.m26532a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            ugVar.f16883g = new uf(this, ugVar);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void m26507c() {
        m26503a(this.f16861d);
        Iterator it = this.f16868k.values().iterator();
        while (it.hasNext()) {
            ug ugVar = (ug) it.next();
            int i;
            if (ugVar.f16883g == null) {
                for (i = 0; i < this.f16865h; i++) {
                    this.f16866i += ugVar.f16881e[i];
                }
            } else {
                ugVar.f16883g = null;
                for (i = 0; i < this.f16865h; i++) {
                    m26503a(ugVar.m26539a(i));
                    m26503a(ugVar.m26541b(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void m26509d() {
        if (this.f16867j != null) {
            this.f16867j.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16861d), uk.f16896a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f16863f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f16865h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (ug ugVar : this.f16868k.values()) {
                if (ugVar.f16883g != null) {
                    bufferedWriter.write("DIRTY " + ugVar.f16880d + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + ugVar.f16880d + ugVar.m26540a() + '\n');
                }
            }
            if (this.f16860c.exists()) {
                m26504a(this.f16860c, this.f16862e, true);
            }
            m26504a(this.f16861d, this.f16860c, false);
            this.f16862e.delete();
            this.f16867j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16860c, true), uk.f16896a));
        } finally {
            bufferedWriter.close();
        }
    }

    private static void m26503a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void m26504a(File file, File file2, boolean z) {
        if (z) {
            m26503a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized uh m26517a(String str) {
        uh uhVar = null;
        synchronized (this) {
            m26515f();
            ug ugVar = (ug) this.f16868k.get(str);
            if (ugVar != null) {
                if (ugVar.f16882f) {
                    for (File exists : ugVar.f16877a) {
                        if (!exists.exists()) {
                            break;
                        }
                    }
                    this.f16869l++;
                    this.f16867j.append("READ");
                    this.f16867j.append(' ');
                    this.f16867j.append(str);
                    this.f16867j.append('\n');
                    if (m26513e()) {
                        this.f16858a.submit(this.f16871n);
                    }
                    uhVar = new uh(this, str, ugVar.f16884h, ugVar.f16877a, ugVar.f16881e);
                }
            }
        }
        return uhVar;
    }

    public uf m26519b(String str) {
        return m26499a(str, -1);
    }

    private synchronized uf m26499a(String str, long j) {
        uf ufVar;
        m26515f();
        ug ugVar = (ug) this.f16868k.get(str);
        if (j == -1 || (ugVar != null && ugVar.f16884h == j)) {
            ug ugVar2;
            if (ugVar == null) {
                ugVar = new ug(this, str);
                this.f16868k.put(str, ugVar);
                ugVar2 = ugVar;
            } else if (ugVar.f16883g != null) {
                ufVar = null;
            } else {
                ugVar2 = ugVar;
            }
            ufVar = new uf(this, ugVar2);
            ugVar2.f16883g = ufVar;
            this.f16867j.append("DIRTY");
            this.f16867j.append(' ');
            this.f16867j.append(str);
            this.f16867j.append('\n');
            this.f16867j.flush();
        } else {
            ufVar = null;
        }
        return ufVar;
    }

    private synchronized void m26502a(uf ufVar, boolean z) {
        int i = 0;
        synchronized (this) {
            ug a = ufVar.f16874b;
            if (a.f16883g != ufVar) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f16882f) {
                    int i2 = 0;
                    while (i2 < this.f16865h) {
                        if (!ufVar.f16875c[i2]) {
                            ufVar.m26526b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.m26541b(i2).exists()) {
                            ufVar.m26526b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.f16865h) {
                File b = a.m26541b(i);
                if (!z) {
                    m26503a(b);
                } else if (b.exists()) {
                    File a2 = a.m26539a(i);
                    b.renameTo(a2);
                    long j = a.f16881e[i];
                    long length = a2.length();
                    a.f16881e[i] = length;
                    this.f16866i = (this.f16866i - j) + length;
                }
                i++;
            }
            this.f16869l++;
            a.f16883g = null;
            if ((a.f16882f | z) != 0) {
                a.f16882f = true;
                this.f16867j.append("CLEAN");
                this.f16867j.append(' ');
                this.f16867j.append(a.f16880d);
                this.f16867j.append(a.m26540a());
                this.f16867j.append('\n');
                if (z) {
                    long j2 = this.f16870m;
                    this.f16870m = 1 + j2;
                    a.f16884h = j2;
                }
            } else {
                this.f16868k.remove(a.f16880d);
                this.f16867j.append("REMOVE");
                this.f16867j.append(' ');
                this.f16867j.append(a.f16880d);
                this.f16867j.append('\n');
            }
            this.f16867j.flush();
            if (this.f16866i > this.f16864g || m26513e()) {
                this.f16858a.submit(this.f16871n);
            }
        }
    }

    private boolean m26513e() {
        return this.f16869l >= 2000 && this.f16869l >= this.f16868k.size();
    }

    public synchronized boolean m26520c(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            m26515f();
            ug ugVar = (ug) this.f16868k.get(str);
            if (ugVar == null || ugVar.f16883g != null) {
                z = false;
            } else {
                while (i < this.f16865h) {
                    File a = ugVar.m26539a(i);
                    if (!a.exists() || a.delete()) {
                        this.f16866i -= ugVar.f16881e[i];
                        ugVar.f16881e[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f16869l++;
                this.f16867j.append("REMOVE");
                this.f16867j.append(' ');
                this.f16867j.append(str);
                this.f16867j.append('\n');
                this.f16868k.remove(str);
                if (m26513e()) {
                    this.f16858a.submit(this.f16871n);
                }
                z = true;
            }
        }
        return z;
    }

    private void m26515f() {
        if (this.f16867j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void close() {
        if (this.f16867j != null) {
            Iterator it = new ArrayList(this.f16868k.values()).iterator();
            while (it.hasNext()) {
                ug ugVar = (ug) it.next();
                if (ugVar.f16883g != null) {
                    ugVar.f16883g.m26526b();
                }
            }
            m26516g();
            this.f16867j.close();
            this.f16867j = null;
        }
    }

    private void m26516g() {
        while (this.f16866i > this.f16864g) {
            m26520c((String) ((Entry) this.f16868k.entrySet().iterator().next()).getKey());
        }
    }

    public void m26518a() {
        close();
        uk.m26548a(this.f16859b);
    }
}
