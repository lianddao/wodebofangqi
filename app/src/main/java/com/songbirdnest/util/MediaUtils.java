package com.songbirdnest.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Audio.Albums;
import android.provider.MediaStore.Audio.Artists;
import android.provider.MediaStore.Audio.Genres;
import android.provider.MediaStore.Audio.Genres.Members;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Audio.Playlists;
import android.provider.MediaStore.Video;
import com.songbirdnest.database.CursorWrapper;
import com.songbirdnest.database.MergeCursor;
import com.songbirdnest.database.Model.Song;
import com.songbirdnest.database.SortCursor;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.PlaylistExporter;
import com.songbirdnest.mediaplayer.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MediaUtils {
    public static boolean createMediaStorePlaylist(Context aContext, String aName) {
        ContentResolver contentResolver = aContext.getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CookieTable.NAME, aName);
        values.put("_data", Environment.getExternalStorageDirectory().getPath() + PlaylistExporter.DEFAULT_EXPORT_LOCATION + aName + "." + PlaylistExporter.TYPE_M3U8_FILE_EXT);
        Uri newRowUri = contentResolver.insert(Playlists.EXTERNAL_CONTENT_URI, values);
        Cursor aCursor = contentResolver.query(newRowUri, null, null, null, null);
        if (aCursor.moveToFirst()) {
            try {
                PlaylistExporter.exportPlaylistToFileAsync(aContext, aCursor.getInt(aCursor.getColumnIndex("_id")), 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newRowUri != null;
    }

    public static int createMediaStorePlaylist(Context aContext, String aName, Cursor aItemsToAdd) {
        if (!Utils.getVolumeFromCursor(aItemsToAdd).equals(Utils.sExternalStorageVolumeName)) {
            return 0;
        }
        ContentResolver contentResolver = aContext.getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CookieTable.NAME, aName);
        values.put("_data", Environment.getExternalStorageDirectory().getPath() + PlaylistExporter.DEFAULT_EXPORT_LOCATION + aName + "." + PlaylistExporter.TYPE_M3U8_FILE_EXT);
        Cursor cursor = contentResolver.query(contentResolver.insert(Playlists.EXTERNAL_CONTENT_URI, values), new String[]{"_id"}, null, null, null);
        if (cursor.moveToFirst()) {
            return addToMediaStorePlaylist(aContext, aItemsToAdd, Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))), Utils.sExternalStorageVolumeName);
        }
        return 0;
    }

    public static boolean createMediaStorePlaylist(Context aContext, String aName, int aItemId, String aItemVolume) {
        if (!aItemVolume.equals(Utils.sExternalStorageVolumeName)) {
            return false;
        }
        ContentResolver contentResolver = aContext.getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CookieTable.NAME, aName);
        values.put("_data", Environment.getExternalStorageDirectory().getPath() + PlaylistExporter.DEFAULT_EXPORT_LOCATION + aName + "." + PlaylistExporter.TYPE_M3U8_FILE_EXT);
        Cursor cursor = contentResolver.query(contentResolver.insert(Playlists.EXTERNAL_CONTENT_URI, values), new String[]{"_id"}, null, null, null);
        if (cursor.moveToFirst()) {
            return addToMediaStorePlaylist(aContext, aItemId, aItemVolume, Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))), Utils.sExternalStorageVolumeName);
        }
        return false;
    }

    public static Cursor getMediaStoreMergeCursor(Activity aActivity, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder, boolean aManageCursor) {
        Cursor cursor;
        ContentResolver contentResolver = aActivity.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Media.EXTERNAL_CONTENT_URI, aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = contentResolver.query(Utils.sPhoneMediaStorageUri, aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            cursor = new MergeCursor(cursors);
        } else {
            cursor = new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
        }
        if (aManageCursor) {
            aActivity.startManagingCursor(cursor);
        }
        return cursor;
    }

    public static Cursor getMediaStoreMergeCursor(Context aContext, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder) {
        ContentResolver resolver = aContext.getContentResolver();
        Cursor externalStorageCursor = resolver.query(Media.EXTERNAL_CONTENT_URI, aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = resolver.query(Utils.sPhoneMediaStorageUri, aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            return new MergeCursor(cursors);
        }
        return new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
    }

    public static Cursor getMediaStoreMergeCursorForAlbum(Activity aActivity, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder, boolean aManageCursor) {
        Cursor cursor;
        ContentResolver contentResolver = aActivity.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Albums.EXTERNAL_CONTENT_URI, aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = contentResolver.query(Albums.getContentUri(Utils.sPhoneStorageVolumeName), aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            cursor = new MergeCursor(cursors);
        } else {
            cursor = new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
        }
        if (aManageCursor) {
            aActivity.startManagingCursor(cursor);
        }
        return cursor;
    }

    public static Cursor getMediaStoreMergeCursorForAlbum(Context aContext, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder) {
        ContentResolver resolver = aContext.getContentResolver();
        Cursor externalStorageCursor = resolver.query(Albums.EXTERNAL_CONTENT_URI, aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = resolver.query(Albums.getContentUri(Utils.sPhoneStorageVolumeName), aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            return new MergeCursor(cursors);
        }
        return new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
    }

    public static Cursor getMediaStoreMergeCursorForArtist(Activity aActivity, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder, boolean aManageCursor) {
        Cursor cursor;
        ContentResolver contentResolver = aActivity.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Artists.EXTERNAL_CONTENT_URI, aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = contentResolver.query(Artists.getContentUri(Utils.sPhoneStorageVolumeName), aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            cursor = new MergeCursor(cursors);
        } else {
            cursor = new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
        }
        if (aManageCursor) {
            aActivity.startManagingCursor(cursor);
        }
        return cursor;
    }

    public static Cursor getMediaStoreMergeCursorForArtistAlbum(Activity aActivity, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder, String aArtistKey, boolean aManageCursor) {
        Cursor cursor;
        ContentResolver contentResolver = aActivity.getContentResolver();
        Cursor externalArtistIdCursor = contentResolver.query(Artists.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "artist_key = ?", new String[]{aArtistKey}, null);
        long externalArtistId = -1;
        if (externalArtistIdCursor != null) {
            if (externalArtistIdCursor.moveToNext()) {
                externalArtistId = externalArtistIdCursor.getLong(0);
            }
            externalArtistIdCursor.close();
        }
        Cursor externalStorageCursor = null;
        if (externalArtistId != -1) {
            externalStorageCursor = contentResolver.query(Artists.Albums.getContentUri(Utils.sExternalStorageVolumeName, externalArtistId), aProjection, aSelection, aSelectionArgs, aSortOrder);
        }
        if (externalStorageCursor == null) {
            Cursor zeroCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper cursorWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        ContentResolver contentResolver2 = contentResolver;
        Cursor phoneStorageArtistIdCursor = contentResolver2.query(Artists.getContentUri(Utils.sPhoneStorageVolumeName), new String[]{"_id"}, "artist_key = ?", new String[]{aArtistKey}, null);
        long phoneStorageArtistId = -1;
        if (phoneStorageArtistIdCursor != null) {
            if (phoneStorageArtistIdCursor.moveToNext()) {
                phoneStorageArtistId = phoneStorageArtistIdCursor.getLong(0);
            }
            phoneStorageArtistIdCursor.close();
        }
        Cursor phoneStorageCursor = null;
        if (phoneStorageArtistId != -1) {
            phoneStorageCursor = contentResolver.query(Artists.Albums.getContentUri(Utils.sPhoneStorageVolumeName, phoneStorageArtistId), aProjection, aSelection, aSelectionArgs, aSortOrder);
        }
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            cursorWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{cursorWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            cursor = new MergeCursor(cursors);
        } else {
            cursor = new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
        }
        if (aManageCursor) {
            aActivity.startManagingCursor(cursor);
        }
        return cursor;
    }

    public static Cursor getMediaStoreMergeCursorForGenre(Activity aActivity, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder, boolean aManageCursor) {
        Cursor cursor;
        ContentResolver contentResolver = aActivity.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Genres.EXTERNAL_CONTENT_URI, aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = contentResolver.query(Genres.getContentUri(Utils.sPhoneStorageVolumeName), aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            cursor = new MergeCursor(cursors);
        } else {
            cursor = new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
        }
        if (aManageCursor) {
            aActivity.startManagingCursor(cursor);
        }
        return cursor;
    }

    public static Cursor getMediaStoreMergeCursorForGenre(Context aContext, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder) {
        ContentResolver contentResolver = aContext.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Genres.EXTERNAL_CONTENT_URI, aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = contentResolver.query(Genres.getContentUri(Utils.sPhoneStorageVolumeName), aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            return new MergeCursor(cursors);
        }
        return new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
    }

    public static Cursor getMediaStoreMergeCursorForGenre(Context aContext, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder, String aGenreName) {
        ContentResolver contentResolver = aContext.getContentResolver();
        Cursor externalGenreIdCursor = contentResolver.query(Genres.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "name = ?", new String[]{aGenreName}, null);
        long externalGenreId = -1;
        if (externalGenreIdCursor != null) {
            if (externalGenreIdCursor.moveToFirst()) {
                externalGenreId = externalGenreIdCursor.getLong(0);
            }
            externalGenreIdCursor.close();
        }
        Cursor externalStorageCursor = null;
        if (externalGenreId != -1) {
            externalStorageCursor = contentResolver.query(Members.getContentUri(Utils.sExternalStorageVolumeName, externalGenreId), aProjection, aSelection, aSelectionArgs, aSortOrder);
        }
        if (externalStorageCursor == null) {
            Cursor zeroCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper cursorWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        ContentResolver contentResolver2 = contentResolver;
        Cursor phoneStorageGenreIdCursor = contentResolver2.query(Genres.getContentUri(Utils.sPhoneStorageVolumeName), new String[]{"_id"}, "name = ?", new String[]{aGenreName}, null);
        long phoneStorageGenreId = -1;
        if (phoneStorageGenreIdCursor != null) {
            if (phoneStorageGenreIdCursor.moveToFirst()) {
                phoneStorageGenreId = phoneStorageGenreIdCursor.getLong(0);
            }
            phoneStorageGenreIdCursor.close();
        }
        Cursor phoneStorageCursor = null;
        if (phoneStorageGenreId != -1) {
            phoneStorageCursor = contentResolver.query(Members.getContentUri(Utils.sPhoneStorageVolumeName, phoneStorageGenreId), aProjection, aSelection, aSelectionArgs, aSortOrder);
        }
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            cursorWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{cursorWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            return new MergeCursor(cursors);
        }
        return new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
    }

    public static Cursor getMediaStoreMergeCursorForPlaylist(Context aContext, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder) {
        ContentResolver contentResolver = aContext.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Playlists.EXTERNAL_CONTENT_URI, aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = contentResolver.query(Playlists.getContentUri(Utils.sPhoneStorageVolumeName), aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            return new MergeCursor(cursors);
        }
        return new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
    }

    public static Cursor getMediaStoreMergeCursorForPlaylist(Activity aActivity, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder, boolean aManageCursor) {
        Cursor cursor;
        ContentResolver contentResolver = aActivity.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Playlists.EXTERNAL_CONTENT_URI, aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = contentResolver.query(Playlists.getContentUri(Utils.sPhoneStorageVolumeName), aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            cursor = new MergeCursor(cursors);
        } else {
            cursor = new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
        }
        if (aManageCursor) {
            aActivity.startManagingCursor(cursor);
        }
        return cursor;
    }

    public static Cursor getMediaStoreMergeCursorForPlaylist(Activity aActivity, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder, long aPlaylistId, boolean aManageCursor) {
        Cursor cursor;
        ContentResolver contentResolver = aActivity.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Playlists.Members.getContentUri(Utils.sExternalStorageVolumeName, aPlaylistId), aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = contentResolver.query(Playlists.Members.getContentUri(Utils.sPhoneStorageVolumeName, aPlaylistId), aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            CursorWrapper cursorWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            cursor = new MergeCursor(cursors);
        } else {
            cursor = new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
        }
        if (aManageCursor) {
            aActivity.startManagingCursor(cursor);
        }
        return cursor;
    }

    public static Cursor getMediaStoreMergeCursorForPlaylist(Context aContext, String[] aProjection, String aSelection, String[] aSelectionArgs, String aSortOrder, long aPlaylistId) {
        ContentResolver contentResolver = aContext.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Playlists.Members.getContentUri(Utils.sExternalStorageVolumeName, aPlaylistId), aProjection, aSelection, aSelectionArgs, aSortOrder);
        if (externalStorageCursor == null) {
            externalStorageCursor = new ZeroCursor(aProjection);
        }
        Bundle externalBundle = new Bundle();
        externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
        CursorWrapper externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        Cursor phoneStorageCursor = contentResolver.query(Playlists.Members.getContentUri(Utils.sPhoneStorageVolumeName, aPlaylistId), aProjection, aSelection, aSelectionArgs, aSortOrder);
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            CursorWrapper cursorWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || aSortOrder == null || phoneStorageCursor.getCount() <= 0) {
            return new MergeCursor(cursors);
        }
        return new SortCursor(cursors, Utils.getSortColumn(aSortOrder), 0, Utils.getIsAscendingSort(aSortOrder));
    }

    public static boolean addToMediaStorePlaylist(Context aContext, int aItemId, String aItemVolume, Long mPlaylistId, String aPlaylistVolume) {
        if (!aItemVolume.equals(aPlaylistVolume)) {
            return false;
        }
        ContentResolver contentResolver = aContext.getContentResolver();
        Uri membersUri = Playlists.Members.getContentUri(aPlaylistVolume, mPlaylistId.longValue());
        Cursor playOrderCursor = contentResolver.query(membersUri, new String[]{"COUNT(*)"}, null, null, null);
        playOrderCursor.moveToNext();
        long playOrderPosition = playOrderCursor.getLong(0);
        ContentValues values = new ContentValues();
        values.put("audio_id", Integer.valueOf(aItemId));
        values.put("play_order", Long.valueOf(playOrderPosition));
        Uri newRowUri = contentResolver.insert(membersUri, values);
        try {
            PlaylistExporter.exportPlaylistToFileAsync(aContext, mPlaylistId.intValue(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newRowUri != null;
    }

    public static int addToMediaStorePlaylist(Context aContext, Cursor aCursor, Long mPlaylistId, String aPlaylistVolume) {
        if (!aCursor.isBeforeFirst() && !aCursor.moveToPosition(-1)) {
            return 0;
        }
        if (!Utils.getVolumeFromCursor(aCursor).equals(aPlaylistVolume)) {
            return 0;
        }
        ContentResolver contentResolver = aContext.getContentResolver();
        Uri membersUri = Playlists.Members.getContentUri(aPlaylistVolume, mPlaylistId.longValue());
        Cursor playOrderCursor = contentResolver.query(membersUri, new String[]{"COUNT(*)"}, null, null, null);
        playOrderCursor.moveToNext();
        ArrayList<ContentValues> contentValues = new ArrayList(aCursor.getCount());
        long playOrderPosition = playOrderCursor.getLong(0);
        while (aCursor.moveToNext()) {
            int itemId = aCursor.getInt(aCursor.getColumnIndex("_id"));
            ContentValues values = new ContentValues();
            values.put("audio_id", Integer.valueOf(itemId));
            values.put("play_order", Long.valueOf(playOrderPosition));
            contentValues.add(values);
            playOrderPosition++;
        }
        ContentValues[] contentValuesArray = new ContentValues[contentValues.size()];
        contentValues.toArray(contentValuesArray);
        int addedCount = contentResolver.bulkInsert(membersUri, contentValuesArray);
        try {
            PlaylistExporter.exportPlaylistToFileAsync(aContext, mPlaylistId.intValue(), 1);
            return addedCount;
        } catch (Exception e) {
            e.printStackTrace();
            return addedCount;
        }
    }

    public static Cursor getMediaStoreMergeCursorForVideo(Activity aActivity, String[] aProjection, boolean aManageCursor) {
        Cursor cursor;
        ContentResolver contentResolver = aActivity.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Video.Media.EXTERNAL_CONTENT_URI, aProjection, null, null, "title ASC");
        CursorWrapper externalWrapper = null;
        if (externalStorageCursor != null) {
            Bundle externalBundle = new Bundle();
            externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
            externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        }
        Cursor phoneStorageCursor = contentResolver.query(Video.Media.getContentUri(Utils.sPhoneStorageVolumeName), aProjection, null, null, "title ASC");
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || phoneStorageCursor.getCount() <= 0) {
            cursor = new MergeCursor(cursors);
        } else {
            cursor = new SortCursor(cursors, Utils.getSortColumn("title ASC"), 0, Utils.getIsAscendingSort("title ASC"));
        }
        if (aManageCursor) {
            aActivity.startManagingCursor(cursor);
        }
        return cursor;
    }

    public static Cursor getMediaStoreMergeCursorForVideo(Activity aActivity, String[] aProjection, String selection, String[] selectionArgs, boolean aManageCursor) {
        Cursor cursor;
        ContentResolver contentResolver = aActivity.getContentResolver();
        Cursor externalStorageCursor = contentResolver.query(Video.Media.EXTERNAL_CONTENT_URI, aProjection, selection, selectionArgs, "title ASC");
        CursorWrapper externalWrapper = null;
        if (externalStorageCursor != null) {
            Bundle externalBundle = new Bundle();
            externalBundle.putBoolean(Utils.sCursorIsExternalStorage, true);
            externalWrapper = new CursorWrapper(externalStorageCursor, externalBundle);
        }
        Cursor phoneStorageCursor = contentResolver.query(Utils.sPhoneMediaStorageUri, aProjection, selection, selectionArgs, "title ASC");
        CursorWrapper phoneWrapper = null;
        if (phoneStorageCursor != null) {
            Bundle phoneStorageBundle = new Bundle();
            phoneStorageBundle.putBoolean(Utils.sCursorIsPhoneStorage, true);
            phoneWrapper = new CursorWrapper(phoneStorageCursor, phoneStorageBundle);
        }
        Cursor[] cursors = new Cursor[]{externalWrapper, phoneWrapper};
        if (phoneStorageCursor == null || phoneStorageCursor.getCount() <= 0) {
            cursor = new MergeCursor(cursors);
        } else {
            cursor = new SortCursor(cursors, Utils.getSortColumn("title ASC"), 0, Utils.getIsAscendingSort("title ASC"));
        }
        if (aManageCursor) {
            aActivity.startManagingCursor(cursor);
        }
        return cursor;
    }

    public static String getGenreForTrackId(Activity aActivity, int trackId) {
        try {
            Activity activity = aActivity;
            Cursor genreCursor = getMediaStoreMergeCursorForGenre(activity, new String[]{"_id", CookieTable.NAME}, null, null, "name ASC", false);
            Map<Long, String> genreMap = new HashMap();
            genreCursor.moveToFirst();
            while (!genreCursor.isAfterLast()) {
                long genreId = genreCursor.getLong(0);
                genreMap.put(Long.valueOf(genreId), genreCursor.getString(1));
                genreCursor.moveToNext();
            }
            genreCursor.close();
            ContentResolver contentResolver = aActivity.getContentResolver();
            for (Long genreId2 : genreMap.keySet()) {
                Cursor cursor = contentResolver.query(Members.getContentUri(Utils.sExternalStorageVolumeName, genreId2.longValue()), null, "_id = " + trackId, null, null);
                if (cursor == null || !cursor.moveToFirst()) {
                    cursor.close();
                } else {
                    cursor.close();
                    return (String) genreMap.get(genreId2);
                }
            }
        } catch (Throwable e) {
            Logger.error((Object) MediaUtils.class, e);
        }
        return null;
    }

    public static int getAlbumTotal(Context context) {
        int count = 0;
        try {
            Cursor cursor = getMediaStoreMergeCursorForAlbum(context, new String[]{"COUNT(_id)"}, null, null, null);
            while (cursor.moveToNext()) {
                count += cursor.getInt(0);
            }
            cursor.close();
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getArtistTotal(Activity context) {
        int count = 0;
        try {
            Cursor cursor = getMediaStoreMergeCursorForArtist(context, new String[]{"COUNT(_id)"}, null, null, null, false);
            while (cursor.moveToNext()) {
                count += cursor.getInt(0);
            }
            cursor.close();
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getGenreTotal(Activity context) {
        int count = 0;
        try {
            Cursor cursor = getMediaStoreMergeCursorForGenre(context, new String[]{"COUNT(_id)"}, null, null, null, false);
            while (cursor.moveToNext()) {
                count += cursor.getInt(0);
            }
            cursor.close();
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getPlaylistTotal(Context context) {
        int count = 0;
        try {
            Cursor cursor = getMediaStoreMergeCursorForPlaylist(context, new String[]{"COUNT(name)"}, null, null, null);
            while (cursor.moveToNext()) {
                count += cursor.getInt(0);
            }
            cursor.close();
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getSongTotal(Activity context) {
        int count = 0;
        try {
            Cursor cursor = getMediaStoreMergeCursor(context, new String[]{"COUNT(_id)"}, Song.getFilterSelection(), Song.getFilterArgs(), null);
            while (cursor.moveToNext()) {
                count += cursor.getInt(0);
            }
            cursor.close();
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getVideoTotal(Activity context) {
        int count = 0;
        try {
            Cursor cursor = getMediaStoreMergeCursorForVideo(context, new String[]{"COUNT(_id)"}, null, null, false);
            while (cursor.moveToNext()) {
                count += cursor.getInt(0);
            }
            cursor.close();
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getPodcastTotal(Context context) {
        int count = 0;
        try {
            Cursor cursor = getMediaStoreMergeCursor(context, new String[]{"COUNT(_id)"}, "is_podcast = ? ", new String[]{"1"}, null);
            while (cursor.moveToNext()) {
                count += cursor.getInt(0);
            }
            cursor.close();
            return count;
        } catch (Exception e) {
            return 0;
        }
    }
}
