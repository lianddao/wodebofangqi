package com.ushareit.listenit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class fka {
    public static void m19592a() {
        exw.m18443a("CloudCacheManager", "removeCloudCache");
        m19603h();
        m19605j();
        m19607l();
    }

    public static void m19595a(List<fnm> list, String str) {
        if (list != null && list.size() != 0) {
            String i = m19604i();
            boolean a = m19596a((Object) list, i);
            if (a) {
                gvj.m22910b(eys.m18562a(), gef.m21805a().m21837g(), gyk.m23153a(i));
            }
            exw.m18443a("CloudCacheManager", "writeLibrarySongCache: path=" + i + ", result=" + a + ", size=" + list.size());
            for (fnm com_ushareit_listenit_fnm : list) {
                if (com_ushareit_listenit_fnm != null) {
                    if (com_ushareit_listenit_fnm.getId() == null) {
                    }
                }
                fiw.m19477g(eys.m18562a(), "writeerror_" + str + "_" + (com_ushareit_listenit_fnm == null ? "song" : "id"));
                return;
            }
        }
    }

    public static List<fnm> m19597b() {
        List<fnm> list = null;
        Object a = m19591a(m19604i());
        if (a != null) {
            try {
                list = (List) a;
            } catch (Exception e) {
            }
            exw.m18443a("CloudCacheManager", "readLibrarySongCache: " + (list != null ? Integer.valueOf(list.size()) : Boolean.valueOf(false)));
            for (fnm com_ushareit_listenit_fnm : list) {
                if (com_ushareit_listenit_fnm != null) {
                    if (com_ushareit_listenit_fnm.getId() == null) {
                    }
                }
                fiw.m19477g(eys.m18562a(), "readerror_" + (com_ushareit_listenit_fnm == null ? "song" : "id"));
            }
        }
        return list;
    }

    public static boolean m19598c() {
        boolean z = false;
        String i = m19604i();
        if (new File(i).exists()) {
            String n = gvj.m23009n(eys.m18562a(), gef.m21805a().m21837g());
            if (!fbb.m18763c(n) && n.equals(gyk.m23153a(i))) {
                z = true;
            }
        }
        exw.m18443a("CloudCacheManager", "isLibrarySongCahceValid: " + z);
        return z;
    }

    private static void m19603h() {
        File file = new File(m19604i());
        if (file.exists()) {
            file.delete();
        }
    }

    private static String m19604i() {
        String n = m19609n();
        return n + File.separator + gef.m21805a().m21837g() + "_" + "librarySong";
    }

    public static void m19594a(List<fnj> list) {
        if (list != null && list.size() != 0) {
            String k = m19606k();
            boolean a = m19596a((Object) list, k);
            if (a) {
                gvj.m22923c(eys.m18562a(), gef.m21805a().m21837g(), gyk.m23153a(k));
            }
            exw.m18443a("CloudCacheManager", "writePlaylistCache: path=" + k + ", result=" + a + ", size=" + list.size());
        }
    }

    public static List<fnj> m19599d() {
        Object a = m19591a(m19606k());
        if (a == null) {
            return null;
        }
        List<fnj> list;
        try {
            list = (List) a;
        } catch (Exception e) {
            list = null;
        }
        exw.m18443a("CloudCacheManager", "readPlaylistCache: " + (list != null ? Integer.valueOf(list.size()) : Boolean.valueOf(false)));
        return list;
    }

    public static boolean m19600e() {
        boolean z = false;
        String k = m19606k();
        if (new File(k).exists()) {
            String o = gvj.m23014o(eys.m18562a(), gef.m21805a().m21837g());
            if (!fbb.m18763c(o) && o.equals(gyk.m23153a(k))) {
                z = true;
            }
        }
        exw.m18443a("CloudCacheManager", "isPlaylistCahceValid: " + z);
        return z;
    }

    private static void m19605j() {
        File file = new File(m19606k());
        if (file.exists()) {
            file.delete();
        }
    }

    private static String m19606k() {
        String n = m19609n();
        return n + File.separator + gef.m21805a().m21837g() + "_" + "playlist";
    }

    public static void m19593a(fnq com_ushareit_listenit_fnq) {
        if (com_ushareit_listenit_fnq != null) {
            String m = m19608m();
            boolean a = m19596a((Object) com_ushareit_listenit_fnq, m);
            if (a) {
                gvj.m22932d(eys.m18562a(), gef.m21805a().m21837g(), gyk.m23153a(m));
            }
            exw.m18443a("CloudCacheManager", "writeUserInfoCache: path=" + m + ", result=" + a);
        }
    }

    public static fnq m19601f() {
        Object a = m19591a(m19608m());
        if (a == null) {
            return null;
        }
        fnq com_ushareit_listenit_fnq;
        try {
            com_ushareit_listenit_fnq = (fnq) a;
        } catch (Exception e) {
            com_ushareit_listenit_fnq = null;
        }
        exw.m18443a("CloudCacheManager", "readUserInfoCache: " + (com_ushareit_listenit_fnq != null));
        return com_ushareit_listenit_fnq;
    }

    public static boolean m19602g() {
        boolean z = false;
        String m = m19608m();
        if (new File(m).exists()) {
            String p = gvj.m23020p(eys.m18562a(), gef.m21805a().m21837g());
            if (!fbb.m18763c(p) && p.equals(gyk.m23153a(m))) {
                z = true;
            }
        }
        exw.m18443a("CloudCacheManager", "isUserInfoCahceValid: " + z);
        return z;
    }

    private static void m19607l() {
        File file = new File(m19608m());
        if (file.exists()) {
            file.delete();
        }
    }

    private static String m19608m() {
        String n = m19609n();
        return n + File.separator + gef.m21805a().m21837g() + "_" + "userinfo";
    }

    private static String m19609n() {
        return eys.m18562a().getApplicationContext().getFilesDir().getAbsolutePath();
    }

    private static boolean m19596a(Object obj, String str) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(str));
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static Object m19591a(String str) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(str));
            Object readObject = objectInputStream.readObject();
            objectInputStream.close();
            return readObject;
        } catch (Exception e) {
            return null;
        }
    }
}
