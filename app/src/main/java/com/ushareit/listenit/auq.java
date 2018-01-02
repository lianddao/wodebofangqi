package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

public class auq {
    public static Bitmap m7219a(Context context, auo com_ushareit_listenit_auo) {
        byte[] decode = Base64.decode(com_ushareit_listenit_auo.m7213a(context.getResources().getDisplayMetrics().density), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Drawable m7220b(Context context, auo com_ushareit_listenit_auo) {
        return new BitmapDrawable(context.getResources(), m7219a(context, com_ushareit_listenit_auo));
    }
}
