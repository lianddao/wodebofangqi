package com.miui.player.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import miui.util.ImageUtils;
import miui.util.InputStreamLoader;

public class BitmapHelper {
    public static Bitmap clipRoundCornerBitmap(Bitmap bitmap, float radius, int borderColor) {
        if (bitmap == null) {
            return null;
        }
        int h = bitmap.getHeight();
        int w = bitmap.getWidth();
        Bitmap output = Bitmap.createBitmap(w, h, bitmap.getConfig());
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, w, h);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(borderColor);
        canvas.drawRoundRect(rectF, radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public static void recycleImageView(ImageView view, Drawable exclude) {
        if (view != null) {
            Bitmap bm;
            if (exclude instanceof BitmapDrawable) {
                bm = ((BitmapDrawable) exclude).getBitmap();
            } else {
                bm = null;
            }
            Drawable d = view.getDrawable();
            view.setImageDrawable(null);
            if (d instanceof BitmapDrawable) {
                Bitmap recycleBitmap = ((BitmapDrawable) d).getBitmap();
                if (recycleBitmap != null && recycleBitmap != bm) {
                    recycleBitmap.recycle();
                }
            }
        }
    }

    public static Bitmap transferMode(Bitmap src, Bitmap mask, Xfermode xfermode) {
        int width = mask.getWidth();
        int height = mask.getHeight();
        Bitmap dst = Bitmap.createBitmap(width, height, src.getConfig());
        Canvas canvas = new Canvas(dst);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(src, new Rect(0, 0, src.getWidth(), src.getHeight()), new Rect(0, 0, width, height), paint);
        if (xfermode != null) {
            paint.setXfermode(xfermode);
            canvas.drawBitmap(mask, 0.0f, 0.0f, paint);
        }
        return dst;
    }

    public static Bitmap decode(InputStreamLoader loader, int suggestWidth, int suggestHeight, boolean force) {
        if (force) {
            return ImageUtils.getBitmap(loader, suggestWidth, suggestHeight);
        }
        int w;
        int h;
        Options opt = ImageUtils.getBitmapSize(loader);
        if (suggestWidth >= opt.outWidth || suggestHeight >= opt.outHeight) {
            w = opt.outWidth;
            h = opt.outHeight;
            float fw = ((float) w) / ((float) suggestWidth);
            float fh = ((float) h) / ((float) suggestHeight);
            if (fw < fh) {
                h = Math.round(((float) suggestHeight) * fw);
            } else {
                w = Math.round(((float) suggestWidth) * fh);
            }
        } else {
            w = suggestWidth;
            h = suggestHeight;
        }
        return ImageUtils.getBitmap(loader, w, h);
    }
}
