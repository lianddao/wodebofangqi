package com.ushareit.listenit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ghp {
    private static String f14130a = "LyricLoader";
    private static glg f14131b = null;
    private static final String[] f14132c = new String[]{"dcim", "thumbnails", "thumb", "pictures", "pic", "image", "logs", "micromsg", "listenit/lyrics"};

    public static void m22017a(glg com_ushareit_listenit_glg, boolean z, ghs com_ushareit_listenit_ghs) {
        f14131b = com_ushareit_listenit_glg;
        if (com_ushareit_listenit_glg != null || com_ushareit_listenit_ghs == null) {
            hhx.m23869a(new ghq("loadLyric", com_ushareit_listenit_glg, z, com_ushareit_listenit_ghs), 0, z ? 0 : 300);
        } else {
            com_ushareit_listenit_ghs.mo2679a(null);
        }
    }

    private static String m22023d(glg com_ushareit_listenit_glg) {
        if (m22025f(com_ushareit_listenit_glg)) {
            return null;
        }
        boolean p = gyn.m23260p(com_ushareit_listenit_glg.f14342j);
        String str = "";
        String d = gyn.m23228d(com_ushareit_listenit_glg);
        str = m22015a(fqm.m20393a().m20399e().mo2330e(), d);
        if (gyn.m23240f(str)) {
            return str;
        }
        if (p) {
            return null;
        }
        str = m22015a(com_ushareit_listenit_glg.f14341i, d);
        if (gyn.m23240f(str)) {
            fin.m19353b(eys.m18562a(), gyn.m23209b(str));
            return str;
        }
        str = gyn.m23209b(com_ushareit_listenit_glg.f14341i);
        if (str != null) {
            File[] listFiles = new File(str).listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    String a = m22015a(listFiles[i].getAbsolutePath(), d);
                    if (gyn.m23240f(a)) {
                        return m22014a(new File(a));
                    }
                }
            }
        }
        return null;
    }

    private static String m22024e(glg com_ushareit_listenit_glg) {
        if (m22025f(com_ushareit_listenit_glg)) {
            return null;
        }
        List<eyk> b = eyj.m18514b(eys.m18562a());
        gxy com_ushareit_listenit_ghr = new ghr();
        List<gxx> arrayList = new ArrayList();
        for (eyk com_ushareit_listenit_eyk : b) {
            File[] listFiles = new File(com_ushareit_listenit_eyk.f12178d).listFiles(com_ushareit_listenit_ghr);
            List arrayList2 = new ArrayList();
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(new gxx(file, com_ushareit_listenit_ghr));
                } else {
                    arrayList2.add(file);
                }
            }
            if (arrayList2.size() > 0) {
                arrayList.add(new gxx(arrayList2, com_ushareit_listenit_ghr));
            }
        }
        String d = gyn.m23228d(com_ushareit_listenit_glg);
        for (gxx com_ushareit_listenit_gxx : arrayList) {
            while (com_ushareit_listenit_gxx.hasNext()) {
                if (m22025f(com_ushareit_listenit_glg)) {
                    return null;
                }
                File a = com_ushareit_listenit_gxx.m23115a();
                if (!a.isDirectory()) {
                    exw.m18457e(f14130a, "loadLyricInSdCards, path=" + a.getAbsolutePath());
                    String d2 = gyn.m23229d(a.getAbsolutePath());
                    if (!fbb.m18763c(d2) && d2.equals(d)) {
                        return m22014a(a);
                    }
                }
            }
        }
        return null;
    }

    private static boolean m22025f(glg com_ushareit_listenit_glg) {
        return f14131b == null || !f14131b.equals(com_ushareit_listenit_glg);
    }

    public static void m22016a() {
        List<eyk> b = eyj.m18514b(eys.m18562a());
        gxy com_ushareit_listenit_ghr = new ghr();
        List<gxx> arrayList = new ArrayList();
        for (eyk com_ushareit_listenit_eyk : b) {
            File[] listFiles = new File(com_ushareit_listenit_eyk.f12178d).listFiles(com_ushareit_listenit_ghr);
            List arrayList2 = new ArrayList();
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(new gxx(file, com_ushareit_listenit_ghr));
                } else {
                    arrayList2.add(file);
                }
            }
            if (arrayList2.size() > 0) {
                arrayList.add(new gxx(arrayList2, com_ushareit_listenit_ghr));
            }
        }
        for (gxx com_ushareit_listenit_gxx : arrayList) {
            while (com_ushareit_listenit_gxx.hasNext()) {
                File a = com_ushareit_listenit_gxx.m23115a();
                if (!a.isDirectory()) {
                    String d = gyn.m23229d(a.getAbsolutePath());
                    if (!(fbb.m18763c(d) || m22018a(d))) {
                        m22014a(a);
                    }
                }
            }
        }
    }

    private static boolean m22018a(String str) {
        return new File(m22015a(fqm.m20393a().m20399e().mo2330e(), str)).exists();
    }

    private static String m22014a(File file) {
        try {
            String str = fqm.m20393a().m20399e().mo2330e() + File.separator + file.getName();
            eye.m18481b(eyh.m18490a(file), eyh.m18491a(str));
            fin.m19353b(eys.m18562a(), gyn.m23209b(file.getAbsolutePath()));
            return str;
        } catch (Exception e) {
            exw.m18457e(f14130a, "copyLyricFileToLISTENit error, path=" + file.getAbsolutePath());
            return file.getAbsolutePath();
        }
    }

    private static String m22015a(String str, String str2) {
        return str + File.separator + str2 + ".lrc";
    }
}
