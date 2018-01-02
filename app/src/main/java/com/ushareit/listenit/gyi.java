package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class gyi {
    public static void m23141a(eyh com_ushareit_listenit_eyh, Bitmap bitmap) {
        exw.m18443a("ImageUtils", "bitmapToJPEGFile width=" + bitmap.getWidth() + ", height=" + bitmap.getHeight());
        try {
            OutputStream fileOutputStream = new FileOutputStream(com_ushareit_listenit_eyh.mo2336k(), false);
            bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            exw.m18457e("ImageUtils", "bitmapToJPEGFile error");
        }
    }

    public static Bitmap m23140a(Bitmap bitmap, int i, int i2) {
        float width = ((float) i) / ((float) bitmap.getWidth());
        float height = ((float) i2) / ((float) bitmap.getHeight());
        if (width < height) {
            width = height;
        }
        if (width >= 0.99f) {
            return bitmap;
        }
        exw.m18443a("ImageUtils", "scaleBitmap scale=" + width);
        Matrix matrix = new Matrix();
        matrix.postScale(width, width);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
