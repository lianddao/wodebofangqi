package com.miui.player.ui.model;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.Pool;
import android.view.View;
import android.widget.ImageView;
import com.miui.player.C0329R;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.network.ImageDownloader.ImageRequest;
import com.miui.player.network.ImageDownloader.OnImageRequestCompeletedListener;
import com.miui.player.ui.model.LandAdapterBase.ViewHolder;
import miui.cache.RequestManager;
import miui.widget.AlphabetFastIndexer;

public class LandAlbumAdapter extends LandAdapterBase {
    private static final int ITEM_CACHE_COUNT = 20;
    protected static final String TAG = "LandAlbumAdapter";
    private static final RequestManager<String, Bitmap, Integer> sDrawableProvider = RequestManager.create(20, null);
    private static Pool<ImageRequest> sPool = ImageRequest.createPool();
    private int mIdxAlbumId;
    private int mIdxAlbumName;
    private int mIdxArtistName;
    private final OnImageRequestCompeletedListener mRequestListener = new C05161();

    class C05161 implements OnImageRequestCompeletedListener {
        C05161() {
        }

        public void onImageRequestCompeleted(ImageView v, Bitmap value, boolean finalValue, boolean hasSet) {
            if (v != null && hasSet) {
                ViewHolder vh = (ViewHolder) v.getTag(C0329R.id.album);
                if (value != null) {
                    vh.mViewAlbumInvert.setImageBitmap(value);
                    return;
                }
                vh.mViewAlbum.setImageResource(C0329R.drawable.music_land_default_album);
                vh.mViewAlbumInvert.setImageResource(C0329R.drawable.music_land_default_album);
            }
        }
    }

    public LandAlbumAdapter(Context context, int layout, Cursor c, AlphabetFastIndexer fastIndexer, String titleCol) {
        super(context, layout, c, fastIndexer, titleCol);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        Log.d(TAG, "bindView " + cursor.getPosition());
        super.bindView(view, context, cursor);
        ViewHolder vh = (ViewHolder) view.getTag();
        ImageSearchInfo info = new ImageSearchInfo(cursor.getLong(this.mIdxAlbumId), null, cursor.getString(this.mIdxAlbumName), cursor.getString(this.mIdxArtistName));
        ImageRequest request = (ImageRequest) sPool.acquire();
        ImageView iv = vh.mViewAlbum;
        request.init(sAlbumWidth, sAlbumHeight, info, iv, sPool, false, true, this.mRequestListener);
        iv.setTag(request.getKey());
        if (sDrawableProvider.isStarted()) {
            Log.d(TAG, "decode bitmap, isCached=" + sDrawableProvider.request(request) + ", position=" + cursor.getPosition());
        }
    }

    public void changeCursor(Cursor cursor) {
        super.changeCursor(cursor);
        getColumnIndices(cursor);
    }

    public static void startCache() {
        sDrawableProvider.setup(true);
    }

    public static void quitCache() {
        sDrawableProvider.quit(null);
    }

    public static void removeCache() {
        sDrawableProvider.removeAll();
    }

    public static boolean removeCacheAlbum(ImageSearchInfo info) {
        return sDrawableProvider.remove(ImageRequest.asKey(info)) != null;
    }

    private void getColumnIndices(Cursor cursor) {
        if (cursor != null) {
            this.mIdxAlbumId = cursor.getColumnIndex("album_id");
            this.mIdxAlbumName = cursor.getColumnIndex("album");
            this.mIdxArtistName = cursor.getColumnIndex("artist");
        }
    }
}
