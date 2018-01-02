package com.songbirdnest.facebook.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import com.songbirdnest.util.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FacebookUtils {
    public static final String PHOTOS_CACHE = "photos/cache";

    static class C01041 extends AbstractStreamHandler<Bitmap> {
        C01041() {
        }

        public Bitmap processInputStream(InputStream stream, long contentLength) throws StreamException {
            if (stream != null) {
                return BitmapFactory.decodeStream(stream);
            }
            return null;
        }
    }

    public static File getFacebookCacheFile(Context context, String facebookId) {
        File cacheDir_ = new File(context.getFilesDir(), "photos/cache");
        File cacheFile = new File(cacheDir_, facebookId + ".face");
        if (cacheDir_.exists() || cacheDir_.mkdirs() || cacheDir_.exists()) {
            return cacheFile;
        }
        Logger.error((Object) FacebookUtils.class, "Problems Creating cache directory " + cacheDir_.getPath());
        return null;
    }

    public static Bitmap downloadBitmap(Context context, String facebookId, int targetSize) {
        String facebookURL = context.getString(C0116R.string.facebook_photo_url, new Object[]{facebookId});
        try {
            Bitmap aBitmap = (Bitmap) new StreamProcessor(facebookURL, new C01041()).processInputStream();
            if (aBitmap != null) {
                return centerCropSquare(aBitmap, targetSize);
            }
            return aBitmap;
        } catch (StreamException e) {
            Logger.error(FacebookUtils.class, "Problems Downloading Facebook Image " + facebookURL, e);
            return null;
        }
    }

    public static void saveFacebookFile(File cacheFile, Bitmap aBitmap) throws FileNotFoundException {
        if (aBitmap == null) {
            Logger.error((Object) FacebookUtils.class, "saveFacebookFile: Bitmap is null ");
            return;
        }
        if (cacheFile.exists()) {
            cacheFile.delete();
        }
        aBitmap.compress(CompressFormat.JPEG, 100, new FileOutputStream(cacheFile));
    }

    public static void saveFacebookFile(Context context, String facebookId, Bitmap aBitmap) {
        if (aBitmap == null) {
            Logger.error((Object) FacebookUtils.class, "saveFacebookFile: Bitmap is null ");
            return;
        }
        File cacheFile = getFacebookCacheFile(context, facebookId);
        if (cacheFile != null) {
            try {
                saveFacebookFile(cacheFile, aBitmap);
            } catch (FileNotFoundException e) {
                Logger.error(FacebookUtils.class, "Problems saving Facebook Image " + cacheFile.getAbsolutePath(), e);
            }
        }
    }

    public static Bitmap centerCropSquare(Bitmap pBitmap, int pSize) {
        int aHalfSize = pSize / 2;
        int aSrcHeight = pBitmap.getHeight();
        int aSrcWidth = pBitmap.getWidth();
        Bitmap aTmp;
        Bitmap aRet;
        if (aSrcHeight < pSize && aSrcWidth >= pSize) {
            aTmp = Bitmap.createBitmap(pBitmap, (aSrcWidth / 2) - (aSrcHeight / 2), 0, aSrcHeight, aSrcHeight);
            aRet = Bitmap.createScaledBitmap(aTmp, pSize, pSize, false);
            aTmp.recycle();
            return aRet;
        } else if (aSrcHeight >= pSize && aSrcWidth < pSize) {
            aTmp = Bitmap.createBitmap(pBitmap, 0, (aSrcHeight / 2) - (aSrcWidth / 2), aSrcWidth, aSrcWidth);
            aRet = Bitmap.createScaledBitmap(aTmp, pSize, pSize, false);
            aTmp.recycle();
            return aRet;
        } else if (aSrcHeight >= pSize || aSrcWidth >= pSize) {
            return Bitmap.createBitmap(pBitmap, (aSrcWidth / 2) - aHalfSize, (aSrcHeight / 2) - aHalfSize, pSize, pSize);
        } else {
            if (aSrcHeight > aSrcWidth) {
                aTmp = Bitmap.createBitmap(pBitmap, 0, (aSrcHeight / 2) - (aSrcWidth / 2), aSrcWidth, aSrcWidth);
            } else {
                aTmp = Bitmap.createBitmap(pBitmap, (aSrcWidth / 2) - (aSrcHeight / 2), 0, aSrcHeight, aSrcHeight);
            }
            aRet = Bitmap.createScaledBitmap(aTmp, pSize, pSize, false);
            aTmp.recycle();
            return aRet;
        }
    }
}
