package com.miui.player.ui.model;

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
import com.miui.player.provider.PlayerStore.OnlineAudioDetail.Columns;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.ui.fragment.ArtistListFragment;
import com.miui.player.util.CachePolicy;
import com.miui.player.util.SectionCursor;
import com.miui.player.util.SectionCursor.CursorConverter;
import com.miui.player.util.SectionCursor.ElementConverter;
import com.miui.player.util.SqlUtils;
import java.util.HashMap;
import java.util.Map;
import miui.cache.RequestManager;
import miui.widget.AlphabetFastIndexer;

public class ArtistListAdapter extends SectionCursorAdapter {
    public static String[] ARTIST_COLUMNS = new String[]{"_id", "artist"};
    private static int sAvatarHeight;
    private static int sAvatarWidth;
    public static RequestManager<String, Bitmap, Integer> sDrawableProvider;
    static Pool<ImageRequest> sPool = ImageRequest.createPool();
    private int mArtistIdIdx;
    private final HashMap<Long, Integer> mArtistIdToAlbumNum = new HashMap();
    private final HashMap<Long, Integer> mArtistIdToTrackNum = new HashMap();
    private int mArtistIdx;
    private final ArtistListFragment mFragment;
    private final MultiChoiceController<Long> mMultiChoiceController;

    static class ArtistElementConverter implements ElementConverter {
        ArtistElementConverter() {
        }

        public boolean parse(Cursor cursor, Object[] colVals) {
            colVals[0] = Integer.valueOf(cursor.getInt(0));
            colVals[1] = cursor.getString(1);
            return true;
        }
    }

    static class ViewHolder {
        TextView albumsCount;
        ImageView avatar;
        ImageView avatarMask;
        ImageView enterIndicator;
        ImageView icon;
        ImageView listTextSeparator;
        TextView title;
        TextView tracksCount;

        ViewHolder() {
        }
    }

    public static CursorConverter createCursorConverter() {
        return SectionCursor.createCursorConverter(new ArtistElementConverter(), 1);
    }

    public ArtistListAdapter(Context context, ArtistListFragment currentFragment, Cursor cursor, int layout, AlphabetFastIndexer fastIndexer, MultiChoiceController<Long> controller) {
        super(context, layout, cursor, fastIndexer, "artist");
        this.mFragment = currentFragment;
        this.mMultiChoiceController = controller;
        getColumnIndices(cursor);
        Resources r = context.getResources();
        if (sDrawableProvider == null) {
            Bitmap b = BitmapFactory.decodeResource(r, C0329R.drawable.avatar_item_default);
            sAvatarWidth = b.getWidth();
            sAvatarHeight = b.getHeight();
            sDrawableProvider = RequestManager.create(CachePolicy.getLocalAvatarCacheSize(), b);
        }
    }

    private void getColumnIndices(Cursor cursor) {
        if (cursor != null) {
            this.mArtistIdIdx = cursor.getColumnIndexOrThrow("_id");
            this.mArtistIdx = cursor.getColumnIndexOrThrow("artist");
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = super.newView(context, cursor, parent);
        ViewHolder vh = new ViewHolder();
        vh.title = (TextView) v.findViewById(C0329R.id.primary_text);
        vh.albumsCount = (TextView) v.findViewById(C0329R.id.secondary_first_text);
        vh.listTextSeparator = (ImageView) v.findViewById(C0329R.id.list_text_separator);
        vh.tracksCount = (TextView) v.findViewById(C0329R.id.secondary_second_text);
        vh.icon = (ImageView) v.findViewById(C0329R.id.icon);
        vh.enterIndicator = (ImageView) v.findViewById(C0329R.id.enter_indicator);
        vh.avatar = (ImageView) v.findViewById(C0329R.id.avatar);
        vh.avatarMask = (ImageView) v.findViewById(C0329R.id.avatar_mask);
        v.setTag(vh);
        return v;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        ViewHolder vh = (ViewHolder) view.getTag();
        String artist = cursor.getString(this.mArtistIdx);
        vh.title.setText(MetaManager.getLocaleArtistName(this.mFragment.getActivity(), artist));
        long artistid = cursor.getLong(this.mArtistIdIdx);
        Integer numalbums = (Integer) this.mArtistIdToAlbumNum.get(Long.valueOf(artistid));
        if (numalbums == null) {
            numalbums = Integer.valueOf(0);
        }
        Integer numsongs = (Integer) this.mArtistIdToTrackNum.get(Long.valueOf(artistid));
        if (numsongs == null) {
            numsongs = Integer.valueOf(0);
        }
        Resources r = context.getResources();
        String albumCount = UIHelper.format(r.getQuantityText(C0329R.plurals.Nalbums_format, numalbums.intValue()).toString(), numalbums);
        String trackCount = UIHelper.format(r.getQuantityText(C0329R.plurals.Ntracks_format, numsongs.intValue()).toString(), numsongs);
        vh.albumsCount.setText(albumCount);
        vh.listTextSeparator.setVisibility(0);
        vh.tracksCount.setText(trackCount);
        if (this.mMultiChoiceController != null) {
            this.mMultiChoiceController.bindItemView(view, cursor.getPosition());
            this.mMultiChoiceController.setVisibilityAuto(vh.enterIndicator, 8);
        }
        ImageView iv = vh.avatar;
        ImageRequest request = (ImageRequest) sPool.acquire();
        request.init(sAvatarWidth, sAvatarHeight, new ImageSearchInfo(artist), iv, sPool);
        iv.setTag(request.getKey());
        if (sDrawableProvider.isStarted()) {
            sDrawableProvider.request(request);
        }
    }

    public void changeCursor(Cursor cursor) {
        if (!(this.mFragment.isActivityWorking() || cursor == null)) {
            cursor.close();
            cursor = null;
        }
        if (this.mFragment.swapCursor(cursor)) {
            getColumnIndices(cursor);
            if (cursor != null) {
                collectArtistInfo(this.mContext, this.mArtistIdToTrackNum, this.mArtistIdToAlbumNum);
            }
        }
        super.changeCursor(cursor);
    }

    public static void startCache() {
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
    }

    public static boolean removeCacheAvatar(ImageSearchInfo info) {
        if (sDrawableProvider == null || sDrawableProvider.remove(ImageRequest.asKey(info)) == null) {
            return false;
        }
        return true;
    }

    private static void collectArtistInfo(Context context, Map<Long, Integer> artistToTrack, Map<Long, Integer> artistToAlbum) {
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, Media.EXTERNAL_CONTENT_URI, new String[]{Columns.ARTIST_ID, "album_id"}, SqlUtils.wrapWithBlacklist(context), null, "artist_id,album_id");
        if (cursor != null) {
            try {
                artistToTrack.clear();
                artistToAlbum.clear();
                long lastArtistId = -1;
                int numAlbum = 0;
                long lastAlbum = -1;
                int numTrack = 0;
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    long artistId = cursor.getLong(0);
                    if (artistId != lastArtistId) {
                        artistToTrack.put(Long.valueOf(lastArtistId), Integer.valueOf(numTrack));
                        numTrack = 1;
                        artistToAlbum.put(Long.valueOf(lastArtistId), Integer.valueOf(numAlbum));
                        lastArtistId = artistId;
                        numAlbum = 1;
                        lastAlbum = cursor.getLong(1);
                    } else {
                        long albumId = cursor.getLong(1);
                        if (lastAlbum != albumId) {
                            lastAlbum = albumId;
                            numAlbum++;
                        }
                        numTrack++;
                    }
                    cursor.moveToNext();
                }
                if (lastArtistId != -1) {
                    artistToTrack.put(Long.valueOf(lastArtistId), Integer.valueOf(numTrack));
                    artistToAlbum.put(Long.valueOf(lastArtistId), Integer.valueOf(numAlbum));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
    }
}
