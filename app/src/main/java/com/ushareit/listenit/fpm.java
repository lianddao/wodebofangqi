package com.ushareit.listenit;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class fpm {
    private static final char[] f13139a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    static fpn[] f13140c = new fpn[]{fpf.m20264a(), fpi.m20287a(), fpk.m20303a(), fpp.m20315a()};
    public static ArrayList<String> f13141d = new ArrayList();
    static HashMap<String, fpn> f13142e = new HashMap();
    protected fpo f13143f = null;
    protected File f13144g = null;

    static {
        for (fpn com_ushareit_listenit_fpn : f13140c) {
            for (Object obj : com_ushareit_listenit_fpn.mo2522b()) {
                f13141d.add(obj);
                f13142e.put(obj, com_ushareit_listenit_fpn);
            }
        }
    }

    public static fpm m20254a(String str, fpo com_ushareit_listenit_fpo) {
        File file = new File(str);
        if (file.exists()) {
            fpn com_ushareit_listenit_fpn = (fpn) f13142e.get(gyn.m23235e(file.getName().toLowerCase()));
            if (com_ushareit_listenit_fpn == null) {
                Log.e("cutter", "not support file extension name");
                return null;
            }
            fpm a = com_ushareit_listenit_fpn.mo2521a();
            a.m20255a(com_ushareit_listenit_fpo);
            try {
                a.mo2513a(file);
            } catch (Throwable th) {
                th.printStackTrace();
                a = null;
            }
            return a;
        }
        Log.e("cutter", str + "can not find.");
        return null;
    }

    protected fpm() {
    }

    public void mo2513a(File file) {
        this.f13144g = file;
    }

    public void m20255a(fpo com_ushareit_listenit_fpo) {
        this.f13143f = com_ushareit_listenit_fpo;
    }

    public int mo2515b() {
        return 0;
    }

    public int mo2516c() {
        return 0;
    }

    public int[] mo2517d() {
        return null;
    }

    public int mo2518e() {
        return 0;
    }

    public int mo2519f() {
        return 0;
    }

    public String mo2520g() {
        return "Unknown";
    }

    public void mo2514a(File file, int i, int i2) {
    }
}
