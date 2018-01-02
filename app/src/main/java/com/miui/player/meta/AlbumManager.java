package com.miui.player.meta;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import com.miui.player.C0329R;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.util.BitmapHelper;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.StorageCache;
import com.miui.player.util.ThreadManager;
import com.miui.player.util.ThreadManager.AsyncRequestCallback;
import com.xiaomi.music.util.NetworkUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import miui.util.ImageUtils;
import miui.util.InputStreamLoader;

public class AlbumManager {
    private static final Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");

    public interface BitmapDecoder {
        Bitmap decode(int i, int i2, Options options);
    }

    private static class FastBitmapDrawable extends Drawable {
        private final Bitmap mBitmap;
        private final MyConstantState mConstantState;

        private static class MyConstantState extends ConstantState {
            private final Bitmap mBitmap;

            public MyConstantState(Bitmap bm) {
                this.mBitmap = bm;
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return this.mBitmap == null ? null : new FastBitmapDrawable(this.mBitmap);
            }
        }

        public FastBitmapDrawable(Bitmap b) {
            this.mBitmap = b;
            this.mConstantState = new MyConstantState(b);
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public ConstantState getConstantState() {
            return this.mConstantState;
        }

        public void draw(Canvas canvas) {
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, null);
        }

        public int getOpacity() {
            return -1;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }

        public int getIntrinsicWidth() {
            return this.mBitmap != null ? this.mBitmap.getWidth() : -1;
        }

        public int getIntrinsicHeight() {
            return this.mBitmap != null ? this.mBitmap.getHeight() : -1;
        }
    }

    public static Bitmap getBitmapFromDrawable(Drawable d) {
        if (d == null) {
            return null;
        }
        if (d instanceof FastBitmapDrawable) {
            return ((FastBitmapDrawable) d).getBitmap();
        }
        if (d instanceof BitmapDrawable) {
            return ((BitmapDrawable) d).getBitmap();
        }
        return null;
    }

    public static Drawable createFastDrawable(Bitmap bm) {
        return bm != null ? new FastBitmapDrawable(bm) : null;
    }

    public static Bitmap getBitmapFromFile(String path, int w, int h) {
        if (path == null) {
            return null;
        }
        return ImageUtils.getBitmap(new InputStreamLoader(path), w, h);
    }

    public static Bitmap getBitmapFromUri(Context context, Uri uri, int w, int h) {
        if (uri == null) {
            return null;
        }
        return ImageUtils.getBitmap(new InputStreamLoader(context, uri), w, h);
    }

    public static Uri getAlbumUriForDB(Context context, long songId, long albumid) {
        ContentResolver res = context.getContentResolver();
        Uri uri;
        if (albumid >= 0) {
            uri = ContentUris.withAppendedId(sArtworkUri, albumid);
            return isValidUri(res, uri) ? uri : null;
        } else if (songId < 0) {
            return null;
        } else {
            uri = Uri.parse("content://media/external/audio/media/" + songId + "/albumart");
            if (isValidUri(res, uri)) {
                return uri;
            }
            return null;
        }
    }

    private static void initSizeDecodeOpt(Options opt) {
        opt.inJustDecodeBounds = true;
        opt.outHeight = 0;
        opt.outWidth = 0;
    }

    private static boolean isValidUri(ContentResolver res, Uri uri) {
        boolean z = false;
        if (uri != null) {
            Options opt = new Options();
            InputStream in = null;
            try {
                initSizeDecodeOpt(opt);
                in = res.openInputStream(uri);
                BitmapFactory.decodeStream(in, null, opt);
                if (opt.outWidth > 0 && opt.outHeight > 0) {
                    z = true;
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                        }
                    }
                } else if (in != null) {
                    in.close();
                }
            } catch (FileNotFoundException e2) {
                if (in != null) {
                    in.close();
                }
            } catch (IllegalStateException e3) {
                if (in != null) {
                    in.close();
                }
            } catch (Throwable th) {
                z = th;
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }
        return z;
    }

    public static boolean isAlbumExistInDB(Context context, long albumId) {
        return getAlbumUriForDB(context, -1, albumId) != null;
    }

    private static Bitmap getAlbumFromFile(String album, String artist, int w, int h, boolean force) {
        if (MetaManager.isUnknowName(album) && MetaManager.isUnknowName(artist)) {
            return null;
        }
        String path = MetaManager.getSavedFilePath(album, artist, "album");
        if (path != null) {
            return BitmapHelper.decode(new InputStreamLoader(path), w, h, force);
        }
        return null;
    }

    private static Bitmap getAlbumFromDB(Context context, long albumId, int w, int h, boolean force) {
        if (albumId < 0) {
            return null;
        }
        Uri uri = ContentUris.withAppendedId(sArtworkUri, albumId);
        if (uri != null) {
            return BitmapHelper.decode(new InputStreamLoader(context, uri), w, h, force);
        }
        return null;
    }

    public static InputStream getAlbumStreamFromDB(Context context, long songId, long albumId) {
        InputStream ret = null;
        if (albumId < 0) {
            return ret;
        }
        Uri uri = getAlbumUriForDB(context, songId, albumId);
        if (uri != null) {
            try {
                ret = context.getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e) {
            }
        }
        return ret;
    }

    public static Bitmap getDisplayedAlbum(Context context, long albumId, String album, String artist, boolean fromDB, int w, int h, boolean force) {
        Bitmap b = null;
        if (fromDB && PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_ANDROID_ALBUM)) {
            b = getAlbumFromDB(context, albumId, w, h, force);
        }
        if (b == null) {
            return getAlbumFromFile(album, artist, w, h, force);
        }
        return b;
    }

    public static Bitmap getDisplayedAlbum(Context context, long albumId, String album, String artist, boolean fromDB, int w, int h) {
        return getDisplayedAlbum(context, albumId, album, artist, fromDB, w, h, true);
    }

    public static Bitmap clipRoundCorner(Context context, Bitmap bm) {
        if (bm == null) {
            return bm;
        }
        Resources res = context.getResources();
        Bitmap cliped = BitmapHelper.clipRoundCornerBitmap(bm, (float) res.getDimensionPixelSize(C0329R.dimen.album_corner_radius), res.getColor(C0329R.color.album_border));
        bm.recycle();
        return cliped;
    }

    public static Bitmap getDisplayedAvatar(Context context, String artist, int w, int h) {
        if (MetaManager.isUnknowName(artist)) {
            return null;
        }
        return getBitmapFromFile(MetaManager.getSavedAvatarFilePath(artist), w, h);
    }

    public static void requestOnlineImageAsync(Context context, String url, int w, int h, AsyncRequestCallback<Bitmap> cbk) {
        final Context ctx = context.getApplicationContext();
        final String str = url;
        final int i = w;
        final int i2 = h;
        final AsyncRequestCallback<Bitmap> asyncRequestCallback = cbk;
        ThreadManager.postNetworkRequest(new Runnable() {
            public void run() {
                Bitmap bm = null;
                try {
                    bm = AlbumManager.requestOnlineImage(ctx, str, i, i2);
                } finally {
                    asyncRequestCallback.setResult(bm);
                    asyncRequestCallback.run();
                }
            }
        });
    }

    public static Bitmap requestOnlineImage(Context context, String url, int w, int h) {
        String key = NetworkUtil.encode(url);
        File f = StorageCache.peekFile(key, null);
        if (f == null) {
            InputStream is = OnlineMusicProxy.requestStream(context, url);
            if (is != null) {
                f = StorageCache.saveInputStream(key, null, is);
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        if (f != null) {
            return ImageUtils.getBitmap(new InputStreamLoader(f.getAbsolutePath()), w, h);
        }
        return null;
    }
}
