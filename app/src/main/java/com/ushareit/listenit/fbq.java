package com.ushareit.listenit;

import android.content.Context;
import java.io.File;
import java.util.List;

public class fbq {
    private static fbq f12392a = null;
    private String f12393b = "";
    private boolean f12394c = false;

    public static synchronized fbq m18802a() {
        fbq com_ushareit_listenit_fbq;
        synchronized (fbq.class) {
            if (f12392a == null) {
                f12392a = new fbq();
            }
            com_ushareit_listenit_fbq = f12392a;
        }
        return com_ushareit_listenit_fbq;
    }

    public void m18806a(Context context) {
        m18805b(context);
    }

    private void m18805b(Context context) {
        String str = "busybox";
        this.f12393b = context.getFilesDir().toString() + "/" + "busybox";
        if (new File(this.f12393b).exists()) {
            this.f12394c = m18803a(this.f12393b);
            return;
        }
        faf.m18696a(context, "busybox", this.f12393b);
        fbr.m18813b(context, "chmod 755 " + this.f12393b + "\n");
        this.f12394c = m18803a(this.f12393b);
    }

    private boolean m18803a(String str) {
        fbu a = fbr.m18809a(str);
        if (!m18804a(a.f12404b, "Permission denied") && a.f12405c) {
            return true;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
            exw.m18449b("BusyboxUtils", "checkBinaryPermission" + a.f12404b);
        }
        return false;
    }

    private boolean m18804a(List<String> list, String str) {
        if (list.size() == 0) {
            return false;
        }
        for (String contains : list) {
            if (contains.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
