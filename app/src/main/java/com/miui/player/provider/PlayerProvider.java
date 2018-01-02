package com.miui.player.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.music.log.LogHelper;
import com.miui.player.provider.PlayerStore.MemberColomns;
import com.miui.player.provider.PlayerStore.MiuiAudioPlaylistView;
import com.miui.player.provider.PlayerStore.MiuiEqualizer;
import com.miui.player.provider.PlayerStore.MiuiNowPlayingAudio;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Columns;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Members;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.provider.PlayerStore.OnlineAudioDetail;
import com.miui.player.provider.PlayerStore.OnlineDownloading;
import com.miui.player.provider.PlayerStore.Statistics;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import java.util.ArrayList;
import java.util.List;

public class PlayerProvider extends ContentProvider {
    public static int INVALID_PLAYLIST_ID = -1;
    private static final int MIUI_AUDIO_PLAYLIST_VIEW = 121;
    private static final int MIUI_AUDIO_PLAYLIST_VIEW_ID = 122;
    private static final int MIUI_DOWNLOADING = 119;
    private static final int MIUI_DOWNLOADING_ID = 120;
    private static final int MIUI_EQUALIZER = 112;
    private static final int MIUI_EQUALIZER_ID = 113;
    private static final int MIUI_ONLINE_DETAIL = 117;
    private static final int MIUI_ONLINE_DETAIL_ID = 118;
    private static final int MIUI_PLAYLIST = 104;
    private static final int MIUI_PLAYLIST_AUDIO_MAP = 106;
    private static final int MIUI_PLAYLIST_AUDIO_MAP_ID = 107;
    private static final int MIUI_PLAYLIST_ID = 105;
    private static final int MIUI_PLAYLIST_MEMBER = 108;
    private static final int MIUI_PLAYLIST_MEMBER_ID = 109;
    private static final int MIUI_PLAYLIST_NOWPLAYING = 110;
    private static final int MIUI_PLAYLIST_NOWPLAYING_ID = 111;
    private static final int MIUI_SEARCH = 116;
    private static final int MIUI_STATISTICS = 114;
    private static final int MIUI_STATISTICS_ID = 115;
    static final String STATISTIC_TYPE_ID3_EDIT = "id3_edit";
    static final String STATISTIC_TYPE_KEY = "statistic_type";
    static final String STATISTIC_TYPE_PLAY_COUNT = "play_count";
    private static final UriMatcher URI_MATCHER = new UriMatcher(-1);
    static final GetTableAndWhereOutParameter sGetTableAndWhereParam = new GetTableAndWhereOutParameter();
    private PlayerDBHelper mDatabaseHelper;

    static final class GetTableAndWhereOutParameter {
        public String table;
        public String where;

        GetTableAndWhereOutParameter() {
        }
    }

    public boolean onCreate() {
        this.mDatabaseHelper = new PlayerDBHelper(getContext(), PlayerDBHelper.DATABASE_NAME, true);
        return true;
    }

    public Cursor query(Uri uri, String[] projectionIn, String selection, String[] selectionArgs, String sort) {
        int table = URI_MATCHER.match(uri);
        PlayerDBHelper database = this.mDatabaseHelper;
        if (database == null) {
            return null;
        }
        SQLiteDatabase db = database.getWritableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String limit = uri.getQueryParameter(CloudJsonTag.TAG_LIMIT);
        Cursor cursor = null;
        switch (table) {
            case 104:
                qb.setTables("playlists");
                break;
            case 105:
                qb.setTables("playlists");
                qb.appendWhere("_id = " + ((String) uri.getPathSegments().get(1)));
                break;
            case 106:
                qb.setTables(MiuiPlaylistsAudioMap.TABLE_NAME);
                break;
            case 107:
                qb.setTables(MiuiPlaylistsAudioMap.TABLE_NAME);
                qb.appendWhere("_id = " + ((String) uri.getPathSegments().get(1)));
                break;
            case MIUI_PLAYLIST_MEMBER /*108*/:
                qb.setTables(MiuiPlaylistsAudioMap.TABLE_NAME);
                qb.appendWhere("playlist_id = " + ((String) uri.getPathSegments().get(1)));
                break;
            case MIUI_PLAYLIST_MEMBER_ID /*109*/:
                qb.setTables(MiuiPlaylistsAudioMap.TABLE_NAME);
                qb.appendWhere("playlist_id = " + ((String) uri.getPathSegments().get(1)));
                qb.appendWhere("_id = " + ((String) uri.getPathSegments().get(3)));
                break;
            case 110:
                qb.setTables(MiuiNowPlayingAudio.TABLE_NAME);
                break;
            case 111:
                qb.setTables(MiuiNowPlayingAudio.TABLE_NAME);
                qb.appendWhere("_id = " + ((String) uri.getPathSegments().get(1)));
                break;
            case 112:
                qb.setTables(MiuiEqualizer.TABLE_NAME);
                break;
            case MIUI_EQUALIZER_ID /*113*/:
                qb.setTables(MiuiEqualizer.TABLE_NAME);
                qb.appendWhere("_id = " + ((String) uri.getPathSegments().get(1)));
                break;
            case MIUI_STATISTICS /*114*/:
                qb.setTables(Statistics.TABLE_NAME);
                break;
            case MIUI_STATISTICS_ID /*115*/:
                qb.setTables(Statistics.TABLE_NAME);
                qb.appendWhere("_id = " + ((String) uri.getPathSegments().get(1)));
                break;
            case MIUI_SEARCH /*116*/:
                cursor = MusicSearch.query(getContext(), uri, projectionIn, selection, selectionArgs, null);
                break;
            case MIUI_ONLINE_DETAIL /*117*/:
                qb.setTables(OnlineAudioDetail.TABLE_NAME);
                break;
            case MIUI_ONLINE_DETAIL_ID /*118*/:
                qb.setTables(OnlineAudioDetail.TABLE_NAME);
                qb.appendWhere("_id = " + ((String) uri.getPathSegments().get(1)));
                break;
            case MIUI_DOWNLOADING /*119*/:
                qb.setTables(OnlineDownloading.TABLE_NAME);
                break;
            case MIUI_DOWNLOADING_ID /*120*/:
                qb.setTables(OnlineDownloading.TABLE_NAME);
                qb.appendWhere("_id = " + ((String) uri.getPathSegments().get(1)));
                break;
            case MIUI_AUDIO_PLAYLIST_VIEW /*121*/:
                qb.setTables(MiuiAudioPlaylistView.TABLE_NAME);
                break;
            case 122:
                qb.setTables(MiuiAudioPlaylistView.TABLE_NAME);
                qb.appendWhere("_id = " + ((String) uri.getPathSegments().get(1)));
                break;
            default:
                throw new IllegalStateException("Unknown URL: " + uri.toString());
        }
        if (table == MIUI_SEARCH) {
            return cursor;
        }
        cursor = qb.query(db, projectionIn, selection, selectionArgs, null, null, sort, limit);
        if (cursor == null) {
            return cursor;
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    public String getType(Uri url) {
        switch (URI_MATCHER.match(url)) {
            case 104:
            case 106:
            case MIUI_PLAYLIST_MEMBER /*108*/:
            case 110:
            case 112:
            case MIUI_STATISTICS /*114*/:
            case MIUI_ONLINE_DETAIL /*117*/:
            case MIUI_DOWNLOADING /*119*/:
                return PlayerStore.CONTENT_TYPE;
            case 105:
            case 107:
            case MIUI_PLAYLIST_MEMBER_ID /*109*/:
            case 111:
            case MIUI_EQUALIZER_ID /*113*/:
            case MIUI_STATISTICS_ID /*115*/:
            case MIUI_ONLINE_DETAIL_ID /*118*/:
            case MIUI_DOWNLOADING_ID /*120*/:
                return PlayerStore.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URL");
        }
    }

    public int bulkInsert(Uri uri, ContentValues[] values) {
        PlayerDBHelper database = this.mDatabaseHelper;
        if (database == null) {
            throw new UnsupportedOperationException("Unknown URI: " + uri);
        }
        SQLiteDatabase db = database.getWritableDatabase();
        db.beginTransaction();
        int numInserted = 0;
        try {
            insertInternal(uri, values);
            numInserted = values.length;
            db.setTransactionSuccessful();
            getContext().getContentResolver().notifyChange(uri, null, false);
            return numInserted;
        } finally {
            db.endTransaction();
        }
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        SQLiteDatabase db = this.mDatabaseHelper.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentProviderResult[] results = super.applyBatch(operations);
            db.setTransactionSuccessful();
            return results;
        } finally {
            db.endTransaction();
        }
    }

    public Uri insert(Uri uri, ContentValues initialValues) {
        Uri newUri = insertInternal(uri, new ContentValues[]{initialValues});
        if (newUri != null) {
            getContext().getContentResolver().notifyChange(uri, null, false);
        }
        return newUri;
    }

    private int queryNextOnlineMemberId(SQLiteDatabase db) {
        String MAX_AUDIO_ID = "max(audio_id)";
        Cursor c = db.query(MiuiPlaylistsAudioMap.TABLE_NAME, new String[]{"max(audio_id)"}, null, null, null, null, null);
        int base = 0;
        if (c != null) {
            c.moveToFirst();
            base = c.getInt(0) + 1;
            c.close();
        }
        if (base < PlayerStore.ONLINE_AUDIO_ID_BASE) {
            return PlayerStore.ONLINE_AUDIO_ID_BASE;
        }
        return base;
    }

    private Uri insertInternal(Uri uri, ContentValues[] valueArr) {
        int match = URI_MATCHER.match(uri);
        Uri newUri = null;
        PlayerDBHelper database = this.mDatabaseHelper;
        if (database == null) {
            throw new UnsupportedOperationException("Unknown URI: " + uri);
        }
        SQLiteDatabase db = database.getWritableDatabase();
        int i$;
        int len$;
        ContentValues cv;
        ContentValues contentValues;
        long rowId;
        int startId;
        ContentValues[] arr$;
        int startId2;
        long current;
        switch (match) {
            case 104:
                for (ContentValues cv2 : valueArr) {
                    if (cv2 != null) {
                        contentValues = new ContentValues(cv2);
                        long currentTime = System.currentTimeMillis() / 1000;
                        contentValues.put("date_added", Long.valueOf(currentTime));
                        contentValues.put(Columns.DATE_MODIFIED, Long.valueOf(currentTime));
                        rowId = db.insert("playlists", "name", contentValues);
                        if (rowId > 0) {
                            newUri = ContentUris.withAppendedId(uri, rowId);
                        }
                    }
                }
                break;
            case 106:
                startId = queryNextOnlineMemberId(db);
                arr$ = valueArr;
                len$ = arr$.length;
                i$ = 0;
                startId2 = startId;
                while (i$ < len$) {
                    cv2 = arr$[i$];
                    if (cv2 != null) {
                        contentValues = new ContentValues(cv2);
                        if (contentValues.containsKey("audio_id")) {
                            startId = startId2;
                        } else {
                            startId = startId2 + 1;
                            contentValues.put("audio_id", Integer.valueOf(startId2));
                        }
                        if (!contentValues.containsKey("date_added")) {
                            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
                        }
                        rowId = db.insert(MiuiPlaylistsAudioMap.TABLE_NAME, "play_order", contentValues);
                        if (rowId > 0) {
                            newUri = ContentUris.withAppendedId(uri, rowId);
                        }
                    } else {
                        startId = startId2;
                    }
                    i$++;
                    startId2 = startId;
                }
                startId = startId2;
                break;
            case MIUI_PLAYLIST_MEMBER /*108*/:
                startId = queryNextOnlineMemberId(db);
                arr$ = valueArr;
                len$ = arr$.length;
                i$ = 0;
                startId2 = startId;
                while (i$ < len$) {
                    cv2 = arr$[i$];
                    if (cv2 != null) {
                        contentValues = new ContentValues(cv2);
                        if (contentValues.containsKey("audio_id")) {
                            startId = startId2;
                        } else {
                            startId = startId2 + 1;
                            contentValues.put("audio_id", Integer.valueOf(startId2));
                        }
                        if (!contentValues.containsKey("date_added")) {
                            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
                        }
                        contentValues.put(MemberColomns.PLAYLIST_ID, (String) uri.getPathSegments().get(1));
                        rowId = db.insert(MiuiPlaylistsAudioMap.TABLE_NAME, "play_order", contentValues);
                        if (rowId > 0) {
                            newUri = ContentUris.withAppendedId(MiuiPlaylistsAudioMap.EXTERNAL_URI, rowId);
                        }
                    } else {
                        startId = startId2;
                    }
                    i$++;
                    startId2 = startId;
                }
                startId = startId2;
                break;
            case 110:
                startId = queryNextOnlineMemberId(db);
                arr$ = valueArr;
                len$ = arr$.length;
                i$ = 0;
                startId2 = startId;
                while (i$ < len$) {
                    cv2 = arr$[i$];
                    if (cv2 != null) {
                        contentValues = new ContentValues(cv2);
                        if (contentValues.containsKey("audio_id")) {
                            startId = startId2;
                        } else {
                            startId = startId2 + 1;
                            contentValues.put("audio_id", Integer.valueOf(startId2));
                        }
                        if (!contentValues.containsKey("date_added")) {
                            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
                        }
                        contentValues.put(MemberColomns.PLAYLIST_ID, Integer.valueOf(0));
                        rowId = db.insert(MiuiPlaylistsAudioMap.TABLE_NAME, "play_order", contentValues);
                        if (rowId > 0) {
                            newUri = ContentUris.withAppendedId(MiuiPlaylistsAudioMap.EXTERNAL_URI, rowId);
                        }
                    } else {
                        startId = startId2;
                    }
                    i$++;
                    startId2 = startId;
                }
                startId = startId2;
                break;
            case 112:
                for (ContentValues cv22 : valueArr) {
                    if (cv22 != null) {
                        contentValues = new ContentValues(cv22);
                        contentValues.put("data_added", Long.valueOf(System.currentTimeMillis()));
                        rowId = db.insert(MiuiEqualizer.TABLE_NAME, MiuiEqualizer.DATA_DEFAULT_STR, contentValues);
                        if (rowId > 0) {
                            newUri = ContentUris.withAppendedId(uri, rowId);
                        }
                    }
                }
                break;
            case MIUI_ONLINE_DETAIL /*117*/:
                current = System.currentTimeMillis();
                for (ContentValues cv222 : valueArr) {
                    contentValues = new ContentValues(cv222);
                    contentValues.put("time_last_modified", Long.valueOf(current));
                    rowId = db.insert(OnlineAudioDetail.TABLE_NAME, "time_last_modified", contentValues);
                    if (rowId > 0) {
                        newUri = ContentUris.withAppendedId(uri, rowId);
                    }
                }
                break;
            case MIUI_DOWNLOADING /*119*/:
                current = System.currentTimeMillis();
                for (ContentValues cv2222 : valueArr) {
                    contentValues = new ContentValues(cv2222);
                    contentValues.put("time_last_modified", Long.valueOf(current));
                    rowId = db.insert(OnlineDownloading.TABLE_NAME, "time_last_modified", contentValues);
                    if (rowId > 0) {
                        newUri = ContentUris.withAppendedId(uri, rowId);
                    }
                }
                break;
            default:
                throw new UnsupportedOperationException("Invalid URI " + uri);
        }
        return newUri;
    }

    static {
        URI_MATCHER.addURI("com.miui.player", "playlists", 104);
        URI_MATCHER.addURI("com.miui.player", "playlists/#", 105);
        URI_MATCHER.addURI("com.miui.player", MiuiPlaylistsAudioMap.TABLE_NAME, 106);
        URI_MATCHER.addURI("com.miui.player", "playlists_audio_map/#", 107);
        URI_MATCHER.addURI("com.miui.player", "playlists_audio_map/#/members", MIUI_PLAYLIST_MEMBER);
        URI_MATCHER.addURI("com.miui.player", "playlists_audio_map/#/members/#", MIUI_PLAYLIST_MEMBER_ID);
        URI_MATCHER.addURI("com.miui.player", MiuiNowPlayingAudio.TABLE_NAME, 110);
        URI_MATCHER.addURI("com.miui.player", "nowplaying_audio_view/#", 111);
        URI_MATCHER.addURI("com.miui.player", MiuiEqualizer.TABLE_NAME, 112);
        URI_MATCHER.addURI("com.miui.player", "equalizer/#", MIUI_EQUALIZER_ID);
        URI_MATCHER.addURI("com.miui.player", Statistics.TABLE_NAME, MIUI_STATISTICS);
        URI_MATCHER.addURI("com.miui.player", "statistics/#", MIUI_STATISTICS_ID);
        URI_MATCHER.addURI("com.miui.player", "search", MIUI_SEARCH);
        URI_MATCHER.addURI("com.miui.player", OnlineAudioDetail.TABLE_NAME, MIUI_ONLINE_DETAIL);
        URI_MATCHER.addURI("com.miui.player", "online_audio_detail/#", MIUI_ONLINE_DETAIL_ID);
        URI_MATCHER.addURI("com.miui.player", OnlineDownloading.TABLE_NAME, MIUI_DOWNLOADING);
        URI_MATCHER.addURI("com.miui.player", "online_downloading/#", MIUI_DOWNLOADING_ID);
        URI_MATCHER.addURI("com.miui.player", MiuiAudioPlaylistView.TABLE_NAME, MIUI_AUDIO_PLAYLIST_VIEW);
        URI_MATCHER.addURI("com.miui.player", "audio_playlist_view/#", 122);
    }

    private void getTableAndWhere(Uri uri, int match, String userWhere, GetTableAndWhereOutParameter out) {
        String where = null;
        switch (match) {
            case 104:
                out.table = "playlists";
                break;
            case 105:
                out.table = "playlists";
                where = "_id = " + ((String) uri.getPathSegments().get(1));
                break;
            case 106:
                out.table = MiuiPlaylistsAudioMap.TABLE_NAME;
                break;
            case 107:
                out.table = MiuiPlaylistsAudioMap.TABLE_NAME;
                where = "_id = " + ((String) uri.getPathSegments().get(1));
                break;
            case MIUI_PLAYLIST_MEMBER /*108*/:
                out.table = MiuiPlaylistsAudioMap.TABLE_NAME;
                where = "playlist_id = " + ((String) uri.getPathSegments().get(1));
                break;
            case MIUI_PLAYLIST_MEMBER_ID /*109*/:
                out.table = MiuiPlaylistsAudioMap.TABLE_NAME;
                where = (("playlist_id = " + ((String) uri.getPathSegments().get(1))) + " AND ") + "_id = " + ((String) uri.getPathSegments().get(3));
                break;
            case 110:
                out.table = MiuiNowPlayingAudio.TABLE_NAME;
                break;
            case 112:
                out.table = MiuiEqualizer.TABLE_NAME;
                break;
            case MIUI_EQUALIZER_ID /*113*/:
                out.table = MiuiEqualizer.TABLE_NAME;
                where = "_id = " + ((String) uri.getPathSegments().get(1));
                break;
            case MIUI_STATISTICS /*114*/:
                out.table = Statistics.TABLE_NAME;
                break;
            case MIUI_STATISTICS_ID /*115*/:
                out.table = Statistics.TABLE_NAME;
                where = "_id = " + ((String) uri.getPathSegments().get(1));
                break;
            case MIUI_ONLINE_DETAIL /*117*/:
                out.table = OnlineAudioDetail.TABLE_NAME;
                break;
            case MIUI_ONLINE_DETAIL_ID /*118*/:
                out.table = OnlineAudioDetail.TABLE_NAME;
                where = "_id = " + ((String) uri.getPathSegments().get(1));
                break;
            case MIUI_DOWNLOADING /*119*/:
                out.table = OnlineDownloading.TABLE_NAME;
                break;
            case MIUI_DOWNLOADING_ID /*120*/:
                out.table = OnlineDownloading.TABLE_NAME;
                where = "_id = " + ((String) uri.getPathSegments().get(1));
                break;
            default:
                throw new UnsupportedOperationException("Unknown or unsupported URL: " + uri.toString());
        }
        if (TextUtils.isEmpty(userWhere)) {
            out.where = where;
        } else if (TextUtils.isEmpty(where)) {
            out.where = userWhere;
        } else {
            out.where = where + " AND (" + userWhere + ")";
        }
    }

    public int delete(Uri uri, String userWhere, String[] whereArgs) {
        int match = URI_MATCHER.match(uri);
        PlayerDBHelper database = this.mDatabaseHelper;
        if (database == null) {
            throw new UnsupportedOperationException("Unknown URI: " + uri);
        }
        int count;
        SQLiteDatabase db = database.getWritableDatabase();
        synchronized (sGetTableAndWhereParam) {
            getTableAndWhere(uri, match, userWhere, sGetTableAndWhereParam);
            count = db.delete(sGetTableAndWhereParam.table, sGetTableAndWhereParam.where, whereArgs);
            getContext().getContentResolver().notifyChange(uri, null, false);
        }
        return count;
    }

    public int update(Uri uri, ContentValues initialValues, String userWhere, String[] whereArgs) {
        int count = 0;
        int match = URI_MATCHER.match(uri);
        PlayerDBHelper database = this.mDatabaseHelper;
        if (database == null) {
            throw new UnsupportedOperationException("Unknown URI: " + uri);
        }
        SQLiteDatabase db = database.getWritableDatabase();
        synchronized (sGetTableAndWhereParam) {
            boolean handled = false;
            if (match == MIUI_PLAYLIST_MEMBER_ID) {
                if (uri.getQueryParameter("move") != null) {
                    handled = true;
                    String key = "play_order";
                    if (initialValues.containsKey(key)) {
                        int newpos = initialValues.getAsInteger(key).intValue();
                        List<String> segments = uri.getPathSegments();
                        count = movePlaylistEntry(db, Long.valueOf((String) segments.get(1)).longValue(), Integer.valueOf((String) segments.get(3)).intValue(), newpos);
                    }
                }
            } else if (match == MIUI_STATISTICS) {
                String type = uri.getQueryParameter(STATISTIC_TYPE_KEY);
                if (STATISTIC_TYPE_PLAY_COUNT.equals(type)) {
                    handled = true;
                    statisticPlayCount(db, initialValues);
                } else if (STATISTIC_TYPE_ID3_EDIT.equals(type)) {
                    handled = true;
                    statisticId3Corrected(db, initialValues);
                }
            }
            if (!handled) {
                getTableAndWhere(uri, match, userWhere, sGetTableAndWhereParam);
                count = db.update(sGetTableAndWhereParam.table, initialValues, sGetTableAndWhereParam.where, whereArgs);
            }
        }
        if (count > 0) {
            getContext().getContentResolver().notifyChange(uri, null, false);
        }
        return count;
    }

    public static boolean isOnlineAudio(long audioId) {
        return audioId >= 536870911;
    }

    public static boolean moveItem(ContentResolver res, long playlistId, int from, int to) {
        Uri uri = Members.getMembersUri(playlistId).buildUpon().appendEncodedPath(String.valueOf(from)).appendQueryParameter("move", "true").build();
        ContentValues values = new ContentValues();
        values.put("play_order", Integer.valueOf(to));
        return res.update(uri, values, null, null) != 0;
    }

    private int movePlaylistEntry(SQLiteDatabase db, long playlistId, int from, int to) {
        if (from == to) {
            return 0;
        }
        db.beginTransaction();
        int numlines = 0;
        try {
            String table = MiuiPlaylistsAudioMap.TABLE_NAME;
            String playOrder = "play_order";
            String playlist = MemberColomns.PLAYLIST_ID;
            db.execSQL("UPDATE playlists_audio_map SET play_order=-1 WHERE play_order=" + from + " AND " + MemberColomns.PLAYLIST_ID + LogHelper.SEPARATE_DOT + playlistId);
            if (from < to) {
                db.execSQL("UPDATE playlists_audio_map SET play_order=(play_order-1) WHERE play_order<=" + to + " AND " + "play_order" + ">" + from + " AND " + MemberColomns.PLAYLIST_ID + LogHelper.SEPARATE_DOT + playlistId);
                numlines = (to - from) + 1;
            } else {
                db.execSQL("UPDATE playlists_audio_map SET play_order=(play_order+1) WHERE play_order>=" + to + " AND " + "play_order" + "<" + from + " AND " + MemberColomns.PLAYLIST_ID + LogHelper.SEPARATE_DOT + playlistId);
                numlines = (from - to) + 1;
            }
            db.execSQL("UPDATE playlists_audio_map SET play_order=" + to + " WHERE " + "play_order" + "=-1 " + " AND " + MemberColomns.PLAYLIST_ID + LogHelper.SEPARATE_DOT + playlistId);
            db.setTransactionSuccessful();
            return numlines;
        } finally {
            db.endTransaction();
        }
    }

    public static boolean accumulatePlayCount(ContentResolver res, long audioId, String data) {
        Uri uri = Statistics.EXTERNAL_URI.buildUpon().appendQueryParameter(STATISTIC_TYPE_KEY, STATISTIC_TYPE_PLAY_COUNT).build();
        ContentValues cv = new ContentValues();
        cv.put("audio_id", Long.valueOf(audioId));
        cv.put("_data", data);
        return res.update(uri, cv, null, null) > 0;
    }

    private boolean statisticPlayCount(SQLiteDatabase db, ContentValues values) {
        long audioId = values.getAsLong("audio_id").longValue();
        SQLiteDatabase sQLiteDatabase = db;
        Cursor cursor = sQLiteDatabase.query(Statistics.TABLE_NAME, new String[]{"_id", Statistics.Columns.PLAYED_COUNT}, "audio_id=?", new String[]{String.valueOf(audioId)}, null, null, "audio_id");
        if (cursor == null) {
            return false;
        }
        long id;
        int lastPlayCount;
        long rowId;
        if (cursor.moveToFirst()) {
            id = cursor.getLong(0);
            lastPlayCount = cursor.getInt(1);
        } else {
            id = -1;
            lastPlayCount = 0;
        }
        cursor.close();
        if (id >= 0) {
            if (!values.containsKey(Statistics.Columns.DATE_LAST_MODIFIED)) {
                values.put(Statistics.Columns.DATE_LAST_MODIFIED, Long.valueOf(System.currentTimeMillis()));
            }
            if (!values.containsKey(Statistics.Columns.PLAYED_COUNT)) {
                values.put(Statistics.Columns.PLAYED_COUNT, Integer.valueOf(lastPlayCount + 1));
            }
            SQLiteDatabase sQLiteDatabase2 = db;
            ContentValues contentValues = values;
            rowId = (long) sQLiteDatabase2.update(Statistics.TABLE_NAME, contentValues, "_id=?", new String[]{String.valueOf(id)});
        } else {
            if (!values.containsKey(Statistics.Columns.PLAYED_COUNT)) {
                values.put(Statistics.Columns.PLAYED_COUNT, Integer.valueOf(1));
            }
            if (!values.containsKey("data_added")) {
                values.put("data_added", Long.valueOf(System.currentTimeMillis()));
            }
            if (!values.containsKey(Statistics.Columns.DATE_LAST_MODIFIED)) {
                values.put(Statistics.Columns.DATE_LAST_MODIFIED, Long.valueOf(System.currentTimeMillis()));
            }
            rowId = db.insert(Statistics.TABLE_NAME, null, values);
        }
        if (rowId >= 0) {
            return true;
        }
        return false;
    }

    public static boolean markID3Corrected(ContentResolver res, long audioId, String data) {
        Uri uri = Statistics.EXTERNAL_URI.buildUpon().appendQueryParameter(STATISTIC_TYPE_KEY, STATISTIC_TYPE_ID3_EDIT).build();
        ContentValues cv = new ContentValues();
        cv.put("audio_id", Long.valueOf(audioId));
        cv.put("_data", data);
        return res.update(uri, cv, null, null) > 0;
    }

    private boolean statisticId3Corrected(SQLiteDatabase db, ContentValues values) {
        boolean z = true;
        long audioId = values.getAsLong("audio_id").longValue();
        SQLiteDatabase sQLiteDatabase = db;
        Cursor cursor = sQLiteDatabase.query(Statistics.TABLE_NAME, new String[]{"_id", Statistics.Columns.ID3_CORRECTED}, "audio_id=?", new String[]{String.valueOf(audioId)}, null, null, "audio_id");
        if (cursor == null) {
            return false;
        }
        try {
            if (!cursor.moveToFirst()) {
                if (!values.containsKey(Statistics.Columns.ID3_CORRECTED)) {
                    values.put(Statistics.Columns.ID3_CORRECTED, Integer.valueOf(1));
                }
                if (!values.containsKey("data_added")) {
                    values.put("data_added", Long.valueOf(System.currentTimeMillis()));
                }
                if (db.insert(Statistics.TABLE_NAME, null, values) < 0) {
                    z = false;
                }
            } else if (cursor.getInt(1) != 1) {
                boolean z2;
                if (!values.containsKey(Statistics.Columns.ID3_CORRECTED)) {
                    values.put(Statistics.Columns.ID3_CORRECTED, Integer.valueOf(1));
                }
                if (db.update(Statistics.TABLE_NAME, values, "audio_id=?", new String[]{String.valueOf(audioId)}) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                cursor.close();
                return z2;
            }
            cursor.close();
            return z;
        } catch (Throwable th) {
            cursor.close();
        }
    }
}
