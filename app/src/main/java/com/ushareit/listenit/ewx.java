package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class ewx {
    public static Bitmap m18062a(int i) {
        try {
            Options options = new Options();
            options.inPreferredConfig = Config.RGB_565;
            return BitmapFactory.decodeResource(eys.m18562a().getResources(), i, options);
        } catch (Exception e) {
            throw new fci(101, "load local resource failed.");
        }
    }

    protected static Bitmap m18063a(String str, eyh com_ushareit_listenit_eyh) {
        if (com_ushareit_listenit_eyh == null) {
            throw new fci(101, "Get thumbnail path failed.");
        }
        if (!com_ushareit_listenit_eyh.mo2328c()) {
            m18066b(str, com_ushareit_listenit_eyh);
        }
        return fcv.m18866a(com_ushareit_listenit_eyh);
    }

    protected static void m18066b(String str, eyh com_ushareit_listenit_eyh) {
        fcx.m18875a(str, com_ushareit_listenit_eyh);
        if (!com_ushareit_listenit_eyh.mo2328c()) {
            throw new fci(102, "ThumbnailNotDownloaded.");
        }
    }

    protected static eyh m18065a(String str, String str2) {
        return eyh.m18488a(m18064a(), str2 + "_" + str.hashCode());
    }

    public static eyh m18064a() {
        eyh d = eyd.m18473d();
        if (!(d.mo2328c() || d.mo2333h())) {
            exw.m18456d("CloudCommonThumbLoader", "getThumbnailDir(): Create directory failed:" + d);
        }
        return d;
    }
}
