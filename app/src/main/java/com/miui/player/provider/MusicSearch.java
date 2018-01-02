package com.miui.player.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.util.Log;
import com.miui.player.meta.Audio;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import miui.provider.MusicSearchProvider;
import miui.provider.MusicSearchProvider.MusicMeta;
import miui.provider.MusicSearchProvider.MusicMeta.Builder;
import miui.provider.MusicSearchProvider.MusicSearchResult;

public class MusicSearch {
    static final String TAG = MusicSearch.class.getName();

    static final class CursorWithExtras implements Cursor {
        private Bundle mData;

        CursorWithExtras() {
        }

        public void setExtras(Bundle extras) {
            if (extras == null) {
                extras = Bundle.EMPTY;
            }
            this.mData = extras;
        }

        public Bundle getExtras() {
            return this.mData;
        }

        public void close() {
        }

        public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        }

        public void deactivate() {
        }

        public byte[] getBlob(int columnIndex) {
            return null;
        }

        public int getColumnCount() {
            return 0;
        }

        public int getColumnIndex(String columnName) {
            return 0;
        }

        public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
            return 0;
        }

        public String getColumnName(int columnIndex) {
            return null;
        }

        public String[] getColumnNames() {
            return new String[0];
        }

        public int getCount() {
            return 0;
        }

        public double getDouble(int columnIndex) {
            return 0.0d;
        }

        public float getFloat(int columnIndex) {
            return 0.0f;
        }

        public int getInt(int columnIndex) {
            return 0;
        }

        public long getLong(int columnIndex) {
            return 0;
        }

        public int getPosition() {
            return 0;
        }

        public short getShort(int columnIndex) {
            return (short) 0;
        }

        public String getString(int columnIndex) {
            return null;
        }

        public int getType(int columnIndex) {
            return 0;
        }

        public boolean getWantsAllOnMoveCalls() {
            return false;
        }

        public boolean isAfterLast() {
            return true;
        }

        public boolean isBeforeFirst() {
            return true;
        }

        public boolean isClosed() {
            return false;
        }

        public boolean isFirst() {
            return false;
        }

        public boolean isLast() {
            return false;
        }

        public boolean isNull(int columnIndex) {
            return true;
        }

        public boolean move(int offset) {
            return false;
        }

        public boolean moveToFirst() {
            return false;
        }

        public boolean moveToLast() {
            return false;
        }

        public boolean moveToNext() {
            return false;
        }

        public boolean moveToPosition(int position) {
            return false;
        }

        public boolean moveToPrevious() {
            return false;
        }

        public boolean requery() {
            return false;
        }

        public Bundle respond(Bundle extras) {
            return Bundle.EMPTY;
        }

        public void setNotificationUri(ContentResolver cr, Uri uri) {
        }

        public void registerContentObserver(ContentObserver observer) {
        }

        public void registerDataSetObserver(DataSetObserver observer) {
        }

        public void unregisterContentObserver(ContentObserver observer) {
        }

        public void unregisterDataSetObserver(DataSetObserver observer) {
        }

        public Uri getNotificationUri() {
            return null;
        }
    }

    static class SearchKey {
        public final String mSelection;
        public final String[] mSelectionArgs;

        public SearchKey(String selection, String[] selectionArgs) {
            this.mSelection = selection;
            this.mSelectionArgs = selectionArgs;
        }

        public boolean isValid() {
            return !TextUtils.isEmpty(this.mSelection);
        }
    }

    public static Cursor query(Context context, Uri uri, String[] projectionIn, String selection, String[] selectionArgs, String sort) {
        Cursor cursor = null;
        if (uri != null) {
            try {
                cursor = query(context, MusicSearchProvider.parseTypeFromUri(uri), selection, selectionArgs, MusicSearchProvider.parseLimitFromUri(uri));
            } catch (NumberFormatException e) {
                Log.e(TAG, MetaManager.UNKNOWN_STRING, e);
            }
        }
        return cursor;
    }

    public static Cursor query(Context context, int type, String selection, String[] selectionArgs, int limit) {
        if (!MusicSearchProvider.isValidType(type) || selectionArgs == null || selectionArgs.length == 0) {
            return null;
        }
        Bundle data = new Bundle();
        data.putParcelable("result_key", doQuery(context, type, selectionArgs, limit));
        Cursor cursor = new CursorWithExtras();
        cursor.setExtras(data);
        return cursor;
    }

    private static boolean contains(int value, int type) {
        return (value & type) == type;
    }

    private static MusicSearchResult doQuery(Context context, int type, String[] selectionArgs, int limit) {
        MusicMeta[] local = null;
        MusicMeta[] online = null;
        if (contains(type, 1)) {
            local = localQuery(context, selectionArgs, limit);
        }
        int localCount = local != null ? local.length : 0;
        if (localCount < limit && contains(type, 2) && Utils.isOnlineVaild()) {
            online = onlineQuery(context, selectionArgs, limit - localCount);
        }
        return new MusicSearchResult(local, online, selectionArgs, type);
    }

    private static MusicMeta[] localQuery(Context context, String[] selectionArgs, int limit) {
        String where;
        String[] args;
        SearchKey key = toLocalSearchKey(selectionArgs);
        if (key == null || !key.isValid()) {
            where = null;
            args = null;
        } else {
            where = key.mSelection;
            args = key.mSelectionArgs;
        }
        Cursor cursor = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "title", "_data", "artist", "album", "duration"}, where, args, null, limit);
        if (cursor == null) {
            return null;
        }
        try {
            long[] validIds = MediaProviderHelper.queryValidTrackIdArr(context);
            MusicMeta[] musicMetaArr = new MusicMeta[cursor.getCount()];
            int i = 0;
            while (cursor.moveToNext()) {
                long id = cursor.getLong(0);
                int flag = 0;
                if (!PlayerProvider.isOnlineAudio(id) && Arrays.binarySearch(validIds, id) < 0) {
                    flag = 0 | 1;
                }
                Builder builder = new Builder();
                builder.setLocalId(cursor.getLong(0)).setTitle(cursor.getString(1)).setData(cursor.getString(2)).setArtistName(cursor.getString(3)).setAlbumName(cursor.getString(4)).setDuration((cursor.getLong(5) + 500) / 1000).setFlag(flag);
                int i2 = i + 1;
                musicMetaArr[i] = builder.create();
                i = i2;
            }
            return musicMetaArr;
        } finally {
            cursor.close();
        }
    }

    public static MusicMeta[] onlineQuery(Context context, String[] selectionArgs, int limit) {
        String key = toOnlineSearchKey(selectionArgs);
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        AudioList asr = OnlineMusicProxy.queryAudio(context, key, 1, limit, null, 2);
        if (asr == null) {
            return null;
        }
        List<Audio> items = asr.getContent();
        int total = limit < items.size() ? limit : items.size();
        MusicMeta[] data = new MusicMeta[total];
        int i = 0;
        for (Audio item : items) {
            if (i >= total) {
                return data;
            }
            Builder builder = new Builder();
            builder.setOnlineId(item.getId()).setTitle(item.getTitle()).setArtistName(item.getArtistName()).setAlbumName(item.getAlbumName()).setDuration(item.getDurationInSec());
            int i2 = i + 1;
            data[i] = builder.create();
            i = i2;
        }
        return data;
    }

    private static String toOnlineSearchKey(String[] selectionArgs) {
        StringBuilder sb = new StringBuilder();
        for (String arg : selectionArgs) {
            if (arg != null) {
                sb.append(arg);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static SearchKey toLocalSearchKey(String[] args) {
        ArrayList<String> selectionArgList = new ArrayList(3);
        StringBuilder selection = new StringBuilder();
        for (int i = 0; i < MusicSearchProvider.SEARCH_COLS.length; i++) {
            String key = args[i];
            if (!TextUtils.isEmpty(key)) {
                if (selectionArgList.size() > 0) {
                    selection.append(" AND ");
                }
                selection.append("(");
                selection.append(MusicSearchProvider.SEARCH_COLS[i]);
                selection.append(" like ?");
                selection.append(")");
                selectionArgList.add("%%" + key + "%%");
            }
        }
        String[] selectionArgs = new String[selectionArgList.size()];
        selectionArgList.toArray(selectionArgs);
        return new SearchKey(selection.toString(), selectionArgs);
    }
}
