package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.XmlResourceParser;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class eeu {
    public static final byte[] f10909a = new byte[0];
    private static eeu f10910b;
    private czd f10911c;
    private czd f10912d;
    private czd f10913e;
    private czf f10914f;
    private final Context f10915g;
    private final ReadWriteLock f10916h;

    eeu(Context context) {
        this(context, null, null, null, null);
    }

    private eeu(Context context, czd com_ushareit_listenit_czd, czd com_ushareit_listenit_czd2, czd com_ushareit_listenit_czd3, czf com_ushareit_listenit_czf) {
        this.f10916h = new ReentrantReadWriteLock(true);
        this.f10915g = context;
        if (com_ushareit_listenit_czf != null) {
            this.f10914f = com_ushareit_listenit_czf;
        } else {
            this.f10914f = new czf();
        }
        this.f10914f.m13460a(m16902b(this.f10915g));
        if (com_ushareit_listenit_czd != null) {
            this.f10911c = com_ushareit_listenit_czd;
        }
        if (com_ushareit_listenit_czd2 != null) {
            this.f10912d = com_ushareit_listenit_czd2;
        }
        if (com_ushareit_listenit_czd3 != null) {
            this.f10913e = com_ushareit_listenit_czd3;
        }
    }

    private static long m16894a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    private static czd m16895a(czh com_ushareit_listenit_czh) {
        if (com_ushareit_listenit_czh == null) {
            return null;
        }
        Map hashMap = new HashMap();
        for (czk com_ushareit_listenit_czk : com_ushareit_listenit_czh.f9407a) {
            String str = com_ushareit_listenit_czk.f9415a;
            Map hashMap2 = new HashMap();
            for (czi com_ushareit_listenit_czi : com_ushareit_listenit_czk.f9416b) {
                hashMap2.put(com_ushareit_listenit_czi.f9410a, com_ushareit_listenit_czi.f9411b);
            }
            hashMap.put(str, hashMap2);
        }
        return new czd(hashMap, com_ushareit_listenit_czh.f9408b);
    }

    private static czf m16896a(czj com_ushareit_listenit_czj) {
        if (com_ushareit_listenit_czj == null) {
            return null;
        }
        czf com_ushareit_listenit_czf = new czf();
        com_ushareit_listenit_czf.m13459a(com_ushareit_listenit_czj.f9412a);
        com_ushareit_listenit_czf.m13464a(com_ushareit_listenit_czj.f9413b);
        return com_ushareit_listenit_czf;
    }

    public static eeu m16897a() {
        if (f10910b != null) {
            return f10910b;
        }
        eah d = eah.m16613d();
        if (d != null) {
            return m16898a(d.m16618a());
        }
        throw new IllegalStateException("FirebaseApp has not been initialized.");
    }

    public static eeu m16898a(Context context) {
        if (f10910b == null) {
            czl c = m16903c(context);
            if (c == null) {
                if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                    Log.d("FirebaseRemoteConfig", "No persisted config was found. Initializing from scratch.");
                }
                f10910b = new eeu(context);
            } else {
                if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                    Log.d("FirebaseRemoteConfig", "Initializing from persisted config.");
                }
                czd a = m16895a(c.f9417a);
                czd a2 = m16895a(c.f9418b);
                czd a3 = m16895a(c.f9419c);
                czf a4 = m16896a(c.f9420d);
                if (a4 != null) {
                    a4.m13463a(m16899a(c.f9421e));
                }
                f10910b = new eeu(context, a, a2, a3, a4);
            }
        }
        return f10910b;
    }

    private static Map<String, czb> m16899a(czm[] com_ushareit_listenit_czmArr) {
        Map hashMap = new HashMap();
        if (com_ushareit_listenit_czmArr != null) {
            for (czm com_ushareit_listenit_czm : com_ushareit_listenit_czmArr) {
                hashMap.put(com_ushareit_listenit_czm.f9425c, new czb(com_ushareit_listenit_czm.f9423a, com_ushareit_listenit_czm.f9424b));
            }
        }
        return hashMap;
    }

    private void m16900a(Map<String, Object> map, String str, boolean z) {
        if (str != null) {
            Object obj = (map == null || map.isEmpty()) ? 1 : null;
            Map hashMap = new HashMap();
            if (obj == null) {
                for (String str2 : map.keySet()) {
                    Object obj2 = map.get(str2);
                    if (obj2 instanceof String) {
                        hashMap.put(str2, ((String) obj2).getBytes(cze.f9398a));
                    } else if (obj2 instanceof Long) {
                        hashMap.put(str2, ((Long) obj2).toString().getBytes(cze.f9398a));
                    } else if (obj2 instanceof Integer) {
                        hashMap.put(str2, ((Integer) obj2).toString().getBytes(cze.f9398a));
                    } else if (obj2 instanceof Double) {
                        hashMap.put(str2, ((Double) obj2).toString().getBytes(cze.f9398a));
                    } else if (obj2 instanceof Float) {
                        hashMap.put(str2, ((Float) obj2).toString().getBytes(cze.f9398a));
                    } else if (obj2 instanceof byte[]) {
                        hashMap.put(str2, (byte[]) obj2);
                    } else if (obj2 instanceof Boolean) {
                        hashMap.put(str2, ((Boolean) obj2).toString().getBytes(cze.f9398a));
                    } else {
                        throw new IllegalArgumentException("The type of a default value needs to beone of String, Long, Double, Boolean, or byte[].");
                    }
                }
            }
            this.f10916h.writeLock().lock();
            if (obj != null) {
                try {
                    if (this.f10913e == null || !this.f10913e.m13453a(str)) {
                        this.f10916h.writeLock().unlock();
                        return;
                    } else {
                        this.f10913e.m13452a(null, str);
                        this.f10913e.m13451a(System.currentTimeMillis());
                    }
                } catch (Throwable th) {
                    this.f10916h.writeLock().unlock();
                }
            } else {
                if (this.f10913e == null) {
                    this.f10913e = new czd(new HashMap(), System.currentTimeMillis());
                }
                this.f10913e.m13452a(hashMap, str);
                this.f10913e.m13451a(System.currentTimeMillis());
            }
            if (z) {
                this.f10914f.m13461a(str);
            }
            m16904d();
            this.f10916h.writeLock().unlock();
        }
    }

    private static byte[] m16901a(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m16894a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private long m16902b(Context context) {
        long j = 0;
        try {
            return this.f10915g.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(context.getPackageName());
            Log.e("FirebaseRemoteConfig", new StringBuilder(String.valueOf(valueOf).length() + 25).append("Package [").append(valueOf).append("] was not found!").toString());
            return j;
        }
    }

    private static czl m16903c(Context context) {
        FileInputStream openFileInput;
        Throwable e;
        FileInputStream fileInputStream;
        if (context == null) {
            return null;
        }
        try {
            openFileInput = context.openFileInput("persisted_config");
            try {
                dfz a = dfz.m14123a(m16901a((InputStream) openFileInput));
                czl com_ushareit_listenit_czl = new czl();
                czl com_ushareit_listenit_czl2 = (czl) com_ushareit_listenit_czl.mo1670b(a);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (Throwable e2) {
                        Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e2);
                    }
                }
                return com_ushareit_listenit_czl;
            } catch (FileNotFoundException e3) {
                e2 = e3;
                fileInputStream = openFileInput;
                try {
                    if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                        Log.d("FirebaseRemoteConfig", "Persisted config file was not found.", e2);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22) {
                            Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e22);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e22 = th;
                    openFileInput = fileInputStream;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (Throwable e4) {
                            Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e4);
                        }
                    }
                    throw e22;
                }
            } catch (IOException e5) {
                e22 = e5;
                try {
                    Log.e("FirebaseRemoteConfig", "Cannot initialize from persisted config.", e22);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (Throwable e222) {
                            Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e222);
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    e222 = th2;
                    if (openFileInput != null) {
                        openFileInput.close();
                    }
                    throw e222;
                }
            }
        } catch (FileNotFoundException e6) {
            e222 = e6;
            fileInputStream = null;
            if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                Log.d("FirebaseRemoteConfig", "Persisted config file was not found.", e222);
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (IOException e7) {
            e222 = e7;
            openFileInput = null;
            Log.e("FirebaseRemoteConfig", "Cannot initialize from persisted config.", e222);
            if (openFileInput != null) {
                openFileInput.close();
            }
            return null;
        } catch (Throwable th3) {
            e222 = th3;
            openFileInput = null;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw e222;
        }
    }

    private void m16904d() {
        this.f10916h.readLock().lock();
        try {
            Runnable com_ushareit_listenit_czc = new czc(this.f10915g, this.f10911c, this.f10912d, this.f10913e, this.f10914f);
            if (VERSION.SDK_INT >= 11) {
                AsyncTask.SERIAL_EXECUTOR.execute(com_ushareit_listenit_czc);
            } else {
                new eew().execute(com_ushareit_listenit_czc);
            }
            this.f10916h.readLock().unlock();
        } catch (Throwable th) {
            this.f10916h.readLock().unlock();
        }
    }

    public long m16905a(String str) {
        return m16906a(str, "configns:firebase");
    }

    public long m16906a(String str, String str2) {
        long j = 0;
        if (str2 != null) {
            this.f10916h.readLock().lock();
            try {
                if (this.f10912d != null && this.f10912d.m13454a(str, str2)) {
                    try {
                        j = Long.valueOf(new String(this.f10912d.m13456b(str, str2), cze.f9398a)).longValue();
                    } catch (NumberFormatException e) {
                    }
                }
                if (this.f10913e != null && this.f10913e.m13454a(str, str2)) {
                    try {
                        j = Long.valueOf(new String(this.f10913e.m13456b(str, str2), cze.f9398a)).longValue();
                        this.f10916h.readLock().unlock();
                    } catch (NumberFormatException e2) {
                    }
                }
                this.f10916h.readLock().unlock();
            } finally {
                this.f10916h.readLock().unlock();
            }
        }
        return j;
    }

    public dzo<Void> m16907a(long j) {
        dzp com_ushareit_listenit_dzp = new dzp();
        this.f10916h.readLock().lock();
        try {
            dqi com_ushareit_listenit_dqi = new dqi();
            com_ushareit_listenit_dqi.m15278a(j);
            if (this.f10914f.m13465b()) {
                com_ushareit_listenit_dqi.m15279a("_rcn_developer", "true");
            }
            com_ushareit_listenit_dqi.m15277a(m16914c());
            new cju(this.f10915g).m11478a(com_ushareit_listenit_dqi.m15276a()).mo1272a(new eev(this, com_ushareit_listenit_dzp));
            return com_ushareit_listenit_dzp.m16566a();
        } finally {
            this.f10916h.readLock().unlock();
        }
    }

    public void m16908a(int i) {
        m16909a(i, "configns:firebase");
    }

    public void m16909a(int i, String str) {
        if (str != null) {
            this.f10916h.readLock().lock();
            try {
                if (!(this.f10914f == null || this.f10914f.m13466c() == null || this.f10914f.m13466c().get(str) == null)) {
                    czb com_ushareit_listenit_czb = (czb) this.f10914f.m13466c().get(str);
                    if (i == com_ushareit_listenit_czb.m13447a() && this.f10914f.m13467d() == com_ushareit_listenit_czb.m13448b()) {
                        if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                            Log.d("FirebaseRemoteConfig", "Skipped setting defaults from resource file as this resource file was already applied.");
                        }
                        this.f10916h.readLock().unlock();
                        return;
                    }
                }
                this.f10916h.readLock().unlock();
                Map hashMap = new HashMap();
                try {
                    XmlResourceParser xml = this.f10915g.getResources().getXml(i);
                    Object obj = null;
                    Object obj2 = null;
                    Object obj3 = null;
                    for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                        if (eventType == 2) {
                            obj2 = xml.getName();
                        } else if (eventType == 3) {
                            if (!(!"entry".equals(xml.getName()) || obj == null || obj3 == null)) {
                                hashMap.put(obj, obj3);
                                obj3 = null;
                                obj = null;
                            }
                            obj2 = null;
                        } else if (eventType == 4) {
                            if ("key".equals(obj2)) {
                                obj = xml.getText();
                            } else if ("value".equals(obj2)) {
                                obj3 = xml.getText();
                            }
                        }
                    }
                    this.f10914f.m13462a(str, new czb(i, this.f10914f.m13467d()));
                    m16900a(hashMap, str, false);
                } catch (Throwable e) {
                    Log.e("FirebaseRemoteConfig", "Caught exception while parsing XML resource. Skipping setDefaults.", e);
                }
            } catch (Throwable th) {
                this.f10916h.readLock().unlock();
            }
        } else if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
            Log.d("FirebaseRemoteConfig", "namespace cannot be null for setDefaults.");
        }
    }

    void m16910a(dzp<Void> com_ushareit_listenit_dzp_java_lang_Void, dqj com_ushareit_listenit_dqj) {
        if (com_ushareit_listenit_dqj == null || com_ushareit_listenit_dqj.mo260b() == null) {
            this.f10914f.m13459a(1);
            com_ushareit_listenit_dzp_java_lang_Void.m16567a(new eey());
            m16904d();
            return;
        }
        int h = com_ushareit_listenit_dqj.mo260b().m2259h();
        this.f10916h.writeLock().lock();
        Map c;
        Map hashMap;
        Map hashMap2;
        switch (h) {
            case -6508:
            case -6506:
                this.f10914f.m13459a(-1);
                if (!(this.f10911c == null || this.f10911c.m13455b())) {
                    c = com_ushareit_listenit_dqj.mo1385c();
                    hashMap = new HashMap();
                    for (String str : c.keySet()) {
                        hashMap2 = new HashMap();
                        for (String str2 : (Set) c.get(str)) {
                            hashMap2.put(str2, com_ushareit_listenit_dqj.mo1384a(str2, null, str));
                        }
                        hashMap.put(str, hashMap2);
                    }
                    this.f10911c = new czd(hashMap, this.f10911c.m13457c());
                }
                com_ushareit_listenit_dzp_java_lang_Void.m16568a(null);
                m16904d();
                break;
            case -6505:
                c = com_ushareit_listenit_dqj.mo1385c();
                hashMap = new HashMap();
                for (String str3 : c.keySet()) {
                    hashMap2 = new HashMap();
                    for (String str22 : (Set) c.get(str3)) {
                        hashMap2.put(str22, com_ushareit_listenit_dqj.mo1384a(str22, null, str3));
                    }
                    hashMap.put(str3, hashMap2);
                }
                this.f10911c = new czd(hashMap, System.currentTimeMillis());
                this.f10914f.m13459a(-1);
                com_ushareit_listenit_dzp_java_lang_Void.m16568a(null);
                m16904d();
                break;
            case 6500:
            case 6501:
            case 6503:
            case 6504:
                this.f10914f.m13459a(1);
                com_ushareit_listenit_dzp_java_lang_Void.m16567a(new eey());
                m16904d();
                break;
            case 6502:
            case 6507:
                this.f10914f.m13459a(2);
                com_ushareit_listenit_dzp_java_lang_Void.m16567a(new eez(com_ushareit_listenit_dqj.mo1383a()));
                m16904d();
                break;
            default:
                try {
                    if (com_ushareit_listenit_dqj.mo260b().m2257f()) {
                        Log.w("FirebaseRemoteConfig", "Unknown (successful) status code: " + h);
                    }
                    this.f10914f.m13459a(1);
                    com_ushareit_listenit_dzp_java_lang_Void.m16567a(new eey());
                    m16904d();
                    break;
                } catch (Throwable th) {
                    this.f10916h.writeLock().unlock();
                }
        }
        this.f10916h.writeLock().unlock();
    }

    public String m16911b(String str) {
        return m16912b(str, "configns:firebase");
    }

    public String m16912b(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        this.f10916h.readLock().lock();
        String str3;
        if (this.f10912d == null || !this.f10912d.m13454a(str, str2)) {
            try {
                if (this.f10913e == null || !this.f10913e.m13454a(str, str2)) {
                    str3 = "";
                    this.f10916h.readLock().unlock();
                    return str3;
                }
                str3 = new String(this.f10913e.m13456b(str, str2), cze.f9398a);
                this.f10916h.readLock().unlock();
                return str3;
            } finally {
                this.f10916h.readLock().unlock();
            }
        } else {
            str3 = new String(this.f10912d.m13456b(str, str2), cze.f9398a);
            return str3;
        }
    }

    public boolean m16913b() {
        this.f10916h.writeLock().lock();
        try {
            if (this.f10911c == null) {
                return false;
            }
            if (this.f10912d == null || this.f10912d.m13457c() < this.f10911c.m13457c()) {
                long c = this.f10911c.m13457c();
                this.f10912d = this.f10911c;
                this.f10912d.m13451a(System.currentTimeMillis());
                this.f10911c = new czd(null, c);
                m16904d();
                this.f10916h.writeLock().unlock();
                return true;
            }
            this.f10916h.writeLock().unlock();
            return false;
        } finally {
            this.f10916h.writeLock().unlock();
        }
    }

    int m16914c() {
        return 10200;
    }

    public boolean m16915c(String str) {
        return m16916c(str, "configns:firebase");
    }

    public boolean m16916c(String str, String str2) {
        Lock lock = true;
        if (str2 == null) {
            return false;
        }
        this.f10916h.readLock().lock();
        try {
            CharSequence str3;
            if (this.f10912d != null && this.f10912d.m13454a(str, str2)) {
                str3 = new String(this.f10912d.m13456b(str, str2), cze.f9398a);
                if (cze.f9399b.matcher(str3).matches()) {
                    return lock;
                }
                if (cze.f9400c.matcher(str3).matches()) {
                    this.f10916h.readLock().unlock();
                    return false;
                }
            }
            if (this.f10913e != null && this.f10913e.m13454a(str, str2)) {
                str3 = new String(this.f10913e.m13456b(str, str2), cze.f9398a);
                if (cze.f9399b.matcher(str3).matches()) {
                    this.f10916h.readLock().unlock();
                    return true;
                } else if (cze.f9400c.matcher(str3).matches()) {
                    this.f10916h.readLock().unlock();
                    return false;
                }
            }
            this.f10916h.readLock().unlock();
            return false;
        } finally {
            lock = this.f10916h.readLock();
            lock.unlock();
        }
    }
}
