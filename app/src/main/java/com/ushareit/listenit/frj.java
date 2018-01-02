package com.ushareit.listenit;

import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class frj {
    private static final List<String> f13291a = new ArrayList();
    private static String f13292b;

    static {
        f13292b = "ww";
        f13291a.add("id");
        f13291a.add("in");
        f13292b = m20713b();
    }

    public static void m20711a(boolean z, frt com_ushareit_listenit_frt) {
        if (com_ushareit_listenit_frt != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long q = gvj.m23024q();
            if (m20719d()) {
                long b = fqo.m20420b();
                exw.m18443a("DiscoveryDataFetcher", "fetch, newtimestamp=" + b + ", old=" + q + ", cc=" + f13292b);
                if (b > q || (q > 0 && !m20721e(q))) {
                    File c = m20716c(b);
                    fqn.m20402a(b, c.getName()).m17007a(c).m16927b(new frl(c, b, com_ushareit_listenit_frt, currentTimeMillis)).m16924a(new frk(com_ushareit_listenit_frt, b, c));
                } else if (q <= 0 || z) {
                    com_ushareit_listenit_frt.mo2551a();
                } else {
                    m20715b(m20718d(q), false, new frn(com_ushareit_listenit_frt));
                }
            } else if (q <= 0 || z) {
                com_ushareit_listenit_frt.mo2551a();
            } else {
                m20715b(m20718d(q), false, new fro(com_ushareit_listenit_frt));
            }
        }
    }

    public static void m20708a() {
        if (gvj.m23024q() <= 0) {
            long b = fqo.m20420b();
            if (b > 0) {
                File c = m20716c(b);
                fqn.m20402a(b, c.getName()).m17007a(c).m16927b(new frq(c, b, System.currentTimeMillis())).m16924a(new frp(b, c));
            }
        }
    }

    private static boolean m20719d() {
        Pair a = eyw.m18568a(eys.m18562a());
        return ((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue();
    }

    private static File m20712b(long j) {
        return new File(fqm.m20393a().m20401g().mo2330e(), "" + j + "-" + f13292b);
    }

    private static File m20716c(long j) {
        return new File(fqm.m20393a().m20401g().mo2330e(), "" + j + "-" + f13292b + ".zip");
    }

    private static String m20720e() {
        return fqm.m20393a().m20401g().mo2330e();
    }

    private static File m20718d(long j) {
        String e = fqm.m20393a().m20401g().mo2330e();
        File file = new File(e, "" + j + "-" + f13292b);
        if (file.exists()) {
            return file;
        }
        File file2 = new File("" + j + "-" + f13292b + ".zip");
        if (file2.exists()) {
            m20710a(file2.getAbsolutePath(), e);
        }
        return !file.exists() ? null : file;
    }

    private static boolean m20721e(long j) {
        String e = fqm.m20393a().m20401g().mo2330e();
        String str = f13292b;
        return new File(e, new StringBuilder().append("").append(j).append("-").append(str).toString()).exists() || new File("" + j + "-" + str + ".zip").exists();
    }

    private static void m20715b(File file, boolean z, frt com_ushareit_listenit_frt) {
        hhx.m23867a(new frs(file, z, com_ushareit_listenit_frt));
    }

    private static List<fsc> m20714b(File file, boolean z) {
        List<fsc> arrayList = new ArrayList();
        try {
            synchronized (fra.m20531a().m20533b()) {
                JSONArray jSONArray = new JSONObject(fbb.m18753a(new FileInputStream(file), true)).getJSONArray("content");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    int i2 = jSONObject.getInt("kind");
                    int i3 = jSONObject.getInt("layer");
                    switch (i2) {
                        case 0:
                            if (i3 != 0) {
                                arrayList.add(new fsf(jSONObject, z));
                                break;
                            }
                            arrayList.add(new fsd(jSONObject, z));
                            break;
                        case 1:
                            if (i3 != 0) {
                                break;
                            }
                            arrayList.add(new fsh(jSONObject, z));
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (Throwable e) {
            fij.m19326a(e.toString());
            exw.m18450b("DiscoveryDataFetcher", "An Exception happened in process of parse discover json.", e);
        }
        return arrayList;
    }

    public static void m20710a(String str, String str2) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
            String str3 = "";
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (nextEntry.isDirectory()) {
                        new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                    } else {
                        File file = new File(str2 + File.separator + name);
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        }
                        fileOutputStream.close();
                    }
                } else {
                    zipInputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            fij.m19326a(e.toString());
        }
    }

    public static String m20713b() {
        String str = "";
        String t = gvj.m23032t();
        if (fbb.m18763c(t)) {
            t = str;
        }
        if (fbb.m18763c(t)) {
            t = fbb.m18751a(eys.m18562a());
        }
        if (fbb.m18763c(t)) {
            t = eys.m18562a().getResources().getConfiguration().locale.getCountry();
        }
        if (fbb.m18763c(t)) {
            t = "ww";
        }
        t = t.toLowerCase(Locale.US);
        if (!f13291a.contains(t)) {
            t = "ww";
        }
        return t.toLowerCase(Locale.US);
    }
}
