package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.util.HashMap;
import java.util.Map;

public final class fcv {
    private static Map<String, Bitmap> f12447a = new HashMap();

    public static Bitmap m18866a(eyh com_ushareit_listenit_eyh) {
        Options options = new Options();
        options.inPreferredConfig = Config.RGB_565;
        return BitmapFactory.decodeFile(com_ushareit_listenit_eyh.mo2336k().getAbsolutePath(), options);
    }
}
