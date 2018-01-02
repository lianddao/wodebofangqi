package com.miui.player.ui.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore.Audio.Media;
import android.util.Pool;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.ImageDownloader.ImageRequest;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.ui.fragment.AlbumListFragment;
import com.miui.player.util.CachePolicy;
import com.miui.player.util.SectionCursor;
import com.miui.player.util.SectionCursor.CursorConverter;
import com.miui.player.util.SectionCursor.ElementConverter;
import com.miui.player.util.SqlUtils;
import java.util.HashMap;
import java.util.Map;
import miui.cache.RequestManager;
import miui.widget.AlphabetFastIndexer;

public class AlbumListAdapter extends SectionCursorAdapter {
    public static final String[] ALBUM_COLUMNS = new String[]{"_id", "artist", "album", "album_art"};
    private static int sAlbumHeight;
    private static int sAlbumWidth;
    public static RequestManager<String, Bitmap, Integer> sDrawableProvider;
    static Pool<ImageRequest> sPool = ImageRequest.createPool();
    private final Activity mActivity;
    private int mAlbumArtIdx;
    private final Map<Long, Integer> mAlbumIdToTrackNum = new HashMap();
    private int mAlbumIdx;
    private final long mArtistId;
    private int mArtistIdx;
    private final AlbumListFragment mFragment;
    private int mIdIdx;
    private final MultiChoiceController<Long> mMultiChoiceController;

    static class AlbumtElementConverter implements ElementConverter {
        AlbumtElementConverter() {
        }

        public boolean parse(Cursor cursor, Object[] colVals) {
            colVals[0] = Integer.valueOf(cursor.getInt(0));
            colVals[1] = cursor.getString(1);
            colVals[2] = cursor.getString(2);
            colVals[3] = cursor.getString(3);
            return true;
        }
    }

    static class ViewHolder {
        ImageView album;
        ImageView albumMask;
        TextView artistName;
        ImageView enterIndicator;
        ImageView listTextSeparator;
        ImageView playIndicator;
        TextView primary;
        TextView trackCount;

        ViewHolder() {
        }
    }

    public static CursorConverter createCursorConverter() {
        return SectionCursor.createCursorConverter(new AlbumtElementConverter(), 2);
    }

    public AlbumListAdapter(Context context, AlbumListFragment currentFragment, int layout, Cursor cursor, long artistId, AlphabetFastIndexer fastIndexer, MultiChoiceController<Long> multiChoice) {
        super(context, layout, cursor, fastIndexer, "album");
        this.mFragment = currentFragment;
        this.mActivity = this.mFragment.getActivity();
        this.mArtistId = artistId;
        this.mMultiChoiceController = multiChoice;
        Resources r = context.getResources();
        if (sDrawableProvider == null) {
            Bitmap b = BitmapFactory.decodeResource(r, C0329R.drawable.album_item_default);
            sAlbumWidth = b.getWidth();
            sAlbumHeight = b.getHeight();
            sDrawableProvider = RequestManager.create(CachePolicy.getLocalAlbumCacheSize(), b);
        }
        getColumnIndices(cursor);
    }

    private void getColumnIndices(Cursor cursor) {
        if (cursor != null) {
            this.mIdIdx = cursor.getColumnIndex("_id");
            this.mAlbumIdx = cursor.getColumnIndexOrThrow("album");
            this.mArtistIdx = cursor.getColumnIndexOrThrow("artist");
            this.mAlbumArtIdx = cursor.getColumnIndexOrThrow("album_art");
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = super.newView(context, cursor, parent);
        ViewHolder vh = new ViewHolder();
        vh.primary = (TextView) v.findViewById(C0329R.id.primary_text);
        vh.trackCount = (TextView) v.findViewById(C0329R.id.secondary_first_text);
        vh.listTextSeparator = (ImageView) v.findViewById(C0329R.id.list_text_separator);
        vh.artistName = (TextView) v.findViewById(C0329R.id.secondary_second_text);
        vh.album = (ImageView) v.findViewById(C0329R.id.album);
        vh.albumMask = (ImageView) v.findViewById(C0329R.id.album_mask);
        vh.enterIndicator = (ImageView) v.findViewById(C0329R.id.enter_indicator);
        v.setTag(vh);
        return v;
    }

    private void makeSpecialView(View view, ViewHolder vh, long aid) {
        boolean enabled = true;
        if (aid == -1) {
            vh.album.setImageResource(C0329R.drawable.album_item_all_tracks);
            vh.album.setTag(null);
            vh.primary.setText(C0329R.string.all_tracks);
            int count = this.mFragment.getSongNumForArtist();
            vh.trackCount.setText(this.mActivity.getResources().getQuantityString(C0329R.plurals.Ntracks_format, count, new Object[]{Integer.valueOf(count)}));
            if (this.mMultiChoiceController.isEnabled()) {
                enabled = false;
            }
            view.setEnabled(enabled);
            vh.primary.setEnabled(enabled);
            vh.trackCount.setEnabled(enabled);
            vh.listTextSeparator.setVisibility(8);
        }
    }

    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        ViewHolder vh = (ViewHolder) view.getTag();
        long aid = cursor.getLong(0);
        ImageView mask = vh.albumMask;
        if (aid < 0) {
            mask.setVisibility(8);
            makeSpecialView(view, vh, aid);
            return;
        }
        mask.setVisibility(0);
        String albumName = cursor.getString(this.mAlbumIdx);
        vh.primary.setText(MetaManager.getLocaleAlbumName(this.mActivity, albumName));
        String artistName = cursor.getString(this.mArtistIdx);
        if (this.mArtistId < 0) {
            vh.artistName.setText(MetaManager.getLocaleArtistName(this.mActivity, artistName));
            vh.artistName.setVisibility(0);
            vh.listTextSeparator.setVisibility(0);
        } else {
            vh.artistName.setVisibility(8);
            vh.listTextSeparator.setVisibility(8);
        }
        Integer count = (Integer) this.mAlbumIdToTrackNum.get(Long.valueOf(cursor.getLong(this.mIdIdx)));
        if (count == null) {
            count = Integer.valueOf(0);
        }
        vh.trackCount.setText(context.getResources().getQuantityString(C0329R.plurals.Ntracks_format, count.intValue(), new Object[]{count}));
        ImageView iv = vh.album;
        ImageRequest request = (ImageRequest) sPool.acquire();
        request.init(sAlbumWidth, sAlbumHeight, new ImageSearchInfo(aid, cursor.getString(this.mAlbumArtIdx), albumName, artistName), iv, sPool);
        iv.setTag(request.getKey());
        if (sDrawableProvider.isStarted()) {
            sDrawableProvider.request(request);
        }
        this.mMultiChoiceController.bindItemView(view, cursor.getPosition());
        this.mMultiChoiceController.setVisibilityAuto(vh.enterIndicator, 8);
    }

    public void changeCursor(Cursor cursor) {
        if (this.mActivity.isFinishing() && cursor != null) {
            cursor.close();
            cursor = null;
        }
        if (this.mFragment.swapCursor(cursor)) {
            getColumnIndices(cursor);
            if (cursor != null) {
                collectAlbumInfo(this.mContext, this.mArtistId, this.mAlbumIdToTrackNum);
            }
            super.changeCursor(cursor);
        }
    }

    public static void startCache(Context context) {
        if (sDrawableProvider != null) {
            sDrawableProvider.setup(true);
        }
    }

    public static void quitCache() {
        if (sDrawableProvider != null) {
            sDrawableProvider.quit(null);
        }
    }

    public static void removeCache() {
        if (sDrawableProvider != null) {
            sDrawableProvider.removeAll();
        }
        LandAlbumAdapter.removeCache();
    }

    public static boolean removeCacheAlbum(ImageSearchInfo info) {
        if (sDrawableProvider != null) {
            return sDrawableProvider.remove(ImageRequest.asKey(info)) != null;
        } else {
            return LandAlbumAdapter.removeCacheAlbum(info);
        }
    }

    private static void collectAlbumInfo(Context context, long artistId, Map<Long, Integer> albumToTrackNum) {
        String[] cols = new String[]{"album_id"};
        String where = null;
        if (artistId >= 0) {
            where = "artist_id=" + artistId;
        }
        Cursor cursor = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, cols, SqlUtils.wrapWithBlacklist(context, where), null, "album_id");
        if (cursor != null) {
            try {
                albumToTrackNum.clear();
                long lastAlbumId = -1;
                int numTrack = 0;
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    long albumId = cursor.getLong(0);
                    if (albumId != lastAlbumId) {
                        albumToTrackNum.put(Long.valueOf(lastAlbumId), Integer.valueOf(numTrack));
                        numTrack = 1;
                        lastAlbumId = albumId;
                    } else {
                        numTrack++;
                    }
                    cursor.moveToNext();
                }
                if (lastAlbumId != -1) {
                    albumToTrackNum.put(Long.valueOf(lastAlbumId), Integer.valueOf(numTrack));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
    }
}
