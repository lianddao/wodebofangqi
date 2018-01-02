package com.songbirdnest.mediaplayer;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.provider.MediaStore.Audio.Albums;
import android.provider.MediaStore.Audio.Genres;
import android.provider.MediaStore.Audio.Genres.Members;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Audio.Playlists;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;
import com.songbirdnest.util.PodcastScanTask;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.cmc.music.myid3.id3v2.MyID3v2Constants;

public class Utils {
    public static final String ANDROID_DOWNLOAD_FOLDER = "download";
    private static final FilenameFilter imageFilter1 = new C01261();
    private static final FilenameFilter imageFilter2 = new C01272();
    public static final String sCursorIsExternalStorage = "cursor.isExternalStorage";
    public static final String sCursorIsInternalStorage = "cursor.isInternalStorage";
    public static final String sCursorIsPhoneStorage = "cursor.isPhoneStorage";
    public static final Uri sExternalMediaStorageUri = Media.EXTERNAL_CONTENT_URI;
    public static final String sExternalStorageVolumeName = "external";
    public static final Uri sInternalMediaStorageUri = Media.INTERNAL_CONTENT_URI;
    public static final String sInternalStorageVolumeName = "internal";
    public static final String sMountRoot = "/mnt";
    public static final Uri sPhoneMediaStorageUri = Media.getContentUri(sPhoneStorageVolumeName);
    public static final String sPhoneStorageVolumeName = "phoneStorage";

    static class C01261 implements FilenameFilter {
        C01261() {
        }

        public boolean accept(File dir, String name) {
            if (name.toLowerCase().endsWith("large.png") || name.toLowerCase().endsWith("large.jpg")) {
                return true;
            }
            return false;
        }
    }

    static class C01272 implements FilenameFilter {
        C01272() {
        }

        public boolean accept(File dir, String name) {
            if (name.toLowerCase().equals("cover.png") || name.toLowerCase().equals("cover.jpg") || name.toLowerCase().equals("album.png") || name.toLowerCase().equals("album.jpg") || name.toLowerCase().equals("folder.png") || name.toLowerCase().equals("folder.jpg") || name.toLowerCase().equals("albumart.png") || name.toLowerCase().equals("albumart.jpg")) {
                return true;
            }
            return false;
        }
    }

    public static Intent buildIntent(String aTargetActivity, String aTargetToken, boolean aBackToList, Context aFromContext) {
        Intent i;
        if (Constants.TOP_MENU_ARTISTS.equals(aTargetActivity)) {
            i = new Intent(aFromContext, ContentBrowser.class);
            i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_ARTIST_DETAILS);
            i.putExtra(Constants.EXTRA_ARTIST_KEY, aTargetToken);
        } else if (Constants.TOP_MENU_SONGS.equals(aTargetActivity)) {
            i = new Intent(aFromContext, ContentBrowser.class);
            i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_SONG_LIST);
            i.putExtra(Constants.EXTRA_SONG_POSITION, aTargetToken);
        } else if (Constants.TOP_MENU_PODCASTS.equals(aTargetActivity)) {
            i = new Intent(aFromContext, ContentBrowser.class);
            i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_PODCAST_DETAILS);
            i.putExtra(Constants.EXTRA_ALBUM_KEY, aTargetToken);
        } else if (Constants.TOP_MENU_ALBUMS.equals(aTargetActivity)) {
            i = new Intent(aFromContext, ContentBrowser.class);
            i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_ALBUM_DETAILS);
            i.putExtra(Constants.EXTRA_ALBUM_KEY, aTargetToken);
        } else if ("Genre".equals(aTargetActivity)) {
            i = new Intent(aFromContext, ContentBrowser.class);
            i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_GENRE_DETAILS);
            i.putExtra(Constants.EXTRA_GENRE_NAME, aTargetToken);
        } else if (Constants.TOP_MENU_PLAYLISTS.equals(aTargetActivity)) {
            String[] tokens = aTargetToken.split(":");
            if (doesMediaStorePlaylistExists(aFromContext, Integer.parseInt(tokens[0]), tokens[1])) {
                i = new Intent(aFromContext, ContentBrowser.class);
                i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_PLAYLIST_DETAILS);
                i.putExtra(Constants.EXTRA_PLAYLIST_ID, Integer.parseInt(tokens[0]));
                i.putExtra(Constants.EXTRA_PLAYLIST_VOLUME, tokens[1]);
            } else {
                i = new Intent(aFromContext, ContentBrowser.class);
                i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_SONG_LIST);
                i.putExtra(Constants.EXTRA_SONG_POSITION, aTargetToken);
                showShortToast(aFromContext, aFromContext.getString(C0116R.string.playlist_no_longer_exists_message));
            }
        } else {
            i = new Intent(aFromContext, Songbird.class);
        }
        if (aBackToList && i != null) {
            i.putExtra(Constants.EXTRA_BACK_TO_LIST, true);
        }
        return i;
    }

    public static String calculateTimeStamp(int time) {
        String formattedTime = Integer.toString(time);
        int minute = Integer.parseInt(formattedTime) / 60000;
        int seconds = (Integer.parseInt(formattedTime) / SongbirdMedia.PODCAST_BACKUP) - (minute * 60);
        formattedTime = Integer.toString(minute) + ":";
        if (seconds < 10) {
            formattedTime = formattedTime + "0";
        }
        return formattedTime + Integer.toString(seconds);
    }

    public static int calculateAlbumArt(int source) {
        return (source * 3) / 4;
    }

    public static int[] calcAspectRatio(int[] aImageSize, int[] aContainerSize) {
        if (aContainerSize[1] == 0 || aContainerSize[0] == 0) {
            return aImageSize;
        }
        float ratioWidth = ((float) aImageSize[0]) / ((float) aContainerSize[0]);
        float ratioHeight = ((float) aImageSize[1]) / ((float) aContainerSize[1]);
        int[] resizedImageSize = new int[]{0, 0};
        if (ratioWidth > ratioHeight) {
            resizedImageSize[0] = aContainerSize[0];
            resizedImageSize[1] = Math.round(((float) aImageSize[1]) / ratioWidth);
            return resizedImageSize;
        }
        resizedImageSize[1] = aContainerSize[1];
        resizedImageSize[0] = Math.round(((float) aImageSize[0]) / ratioHeight);
        return resizedImageSize;
    }

    public static void showShortToastWithLayout(Context aContext, int aLayoutId) {
        View view = LayoutInflater.from(aContext).inflate(aLayoutId, null);
        Toast toast = new Toast(aContext);
        toast.setView(view);
        toast.setDuration(0);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    public static void showShortToast(Context aContext, String aText) {
        Toast toast = Toast.makeText(aContext, aText, 0);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    public static void showLongToast(Context aContext, String aText) {
        Toast toast = Toast.makeText(aContext, aText, 1);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    public static PlayableItem createPlayableItemFromContentUri(Context aContext, Uri aContentUri) {
        PlayableItem item = new PlayableItem();
        ContentResolver contentResolver = aContext.getContentResolver();
        String storageVolume = (String) aContentUri.getPathSegments().get(0);
        Uri storageUri = getStorageUriFromVolume(storageVolume);
        if (storageVolume == null || storageUri == null) {
            return null;
        }
        Cursor cursor = contentResolver.query(aContentUri, new String[]{"_id"}, null, null, null);
        if (cursor.getCount() != 1) {
            cursor.close();
            return item;
        } else if (cursor.moveToFirst()) {
            item.mStorageVolume = storageVolume;
            item.mStorageUri = storageUri;
            item.mID = cursor.getInt(cursor.getColumnIndex("_id"));
            cursor.close();
            return item;
        } else {
            cursor.close();
            return item;
        }
    }

    public static void createPlayableItemFromStream(Context aContext, Uri aContentUri, SongbirdMediaService aService) throws IOException {
        scan(aContext, saveAsDownload(aContext.getContentResolver().openInputStream(aContentUri), aContentUri), aService);
    }

    private static void scan(Context aContext, String filename, SongbirdMediaService aService) {
        SingleMediaScanner singleMediaScanner = new SingleMediaScanner(aContext, filename, aService);
    }

    private static String saveAsDownload(InputStream is, Uri aContentUri) throws IOException {
        String filename = getDownloadFilename(aContentUri);
        write(is, filename);
        return filename;
    }

    private static String getDownloadFilename(Uri aContentUri) throws IOException {
        String downloadPath = getDownloadPath(Environment.getExternalStorageDirectory().getAbsolutePath());
        return downloadPath + "/" + getTempFilename(aContentUri, "mp3");
    }

    private static String getTempFilename(Uri aContentUri, String type) {
        return "sb" + aContentUri.getPath().replace("/", "_").replace(".", "_") + "." + type;
    }

    private static String getDownloadPath(String sdPath) throws IOException {
        String filename = sdPath + "/" + ANDROID_DOWNLOAD_FOLDER;
        File file = new File(filename);
        if (file.exists() && file.isDirectory()) {
            return file.getAbsolutePath();
        }
        if (file.mkdir()) {
            return file.getAbsolutePath();
        }
        throw new IOException("Failed to create directory " + filename);
    }

    private static void write(InputStream is, String filename) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filename)));
        byte[] buffer = new byte[4096];
        while (true) {
            int n = is.read(buffer);
            if (n >= 0) {
                bos.write(buffer, 0, n);
            } else {
                is.close();
                bos.close();
                return;
            }
        }
    }

    public static PlayableItem createPlayableItemFromFileUri(Context aContext, Uri aFileUri) {
        String itemPath = aFileUri.getPath();
        if (!itemPath.startsWith(sMountRoot)) {
            itemPath = sMountRoot + itemPath;
        }
        ContentResolver contentResolver = aContext.getContentResolver();
        Cursor cursor = contentResolver.query(sExternalMediaStorageUri, new String[]{"_id"}, "_data = ?", new String[]{itemPath}, null);
        if (cursor.getCount() == 1 && cursor.moveToFirst()) {
            Uri contentUri = Uri.withAppendedPath(sExternalMediaStorageUri, Integer.toString(cursor.getInt(0)));
            cursor.close();
            return createPlayableItemFromContentUri(aContext, contentUri);
        }
        cursor.close();
        cursor = contentResolver.query(sInternalMediaStorageUri, new String[]{"_id"}, "_data = ?", new String[]{itemPath}, null);
        if (cursor.getCount() == 1 && cursor.moveToFirst()) {
            contentUri = Uri.withAppendedPath(sInternalMediaStorageUri, Integer.toString(cursor.getInt(0)));
            cursor.close();
            return createPlayableItemFromContentUri(aContext, contentUri);
        }
        cursor.close();
        cursor = contentResolver.query(sPhoneMediaStorageUri, new String[]{"_id"}, "_data = ?", new String[]{itemPath}, null);
        if (cursor != null && cursor.getCount() == 1 && cursor.moveToFirst()) {
            contentUri = Uri.withAppendedPath(sPhoneMediaStorageUri, Integer.toString(cursor.getInt(0)));
            cursor.close();
            return createPlayableItemFromContentUri(aContext, contentUri);
        }
        if (cursor != null) {
            cursor.close();
        }
        return new PlayableItem();
    }

    public static PlayableItem createPlayableItemFromCursor(Cursor aCursor) {
        int idColumn = aCursor.getColumnIndex("_id");
        int audioIdColumn = aCursor.getColumnIndex("audio_id");
        if (idColumn == -1 && audioIdColumn == -1) {
            return new PlayableItem("<UNKNOWN>", null, -1, -1);
        }
        int id;
        String storageVolume;
        Uri storageUri;
        int playlistItemId = -1;
        if (audioIdColumn != -1) {
            id = aCursor.getInt(audioIdColumn);
            playlistItemId = aCursor.getInt(idColumn);
        } else {
            id = aCursor.getInt(idColumn);
        }
        Bundle extras = aCursor.getExtras();
        if (extras.getBoolean(sCursorIsExternalStorage, false)) {
            storageVolume = sExternalStorageVolumeName;
            storageUri = sExternalMediaStorageUri;
        } else if (extras.getBoolean(sCursorIsPhoneStorage, false)) {
            storageVolume = sPhoneStorageVolumeName;
            storageUri = sPhoneMediaStorageUri;
        } else if (extras.getBoolean(sCursorIsInternalStorage, false)) {
            storageVolume = sInternalStorageVolumeName;
            storageUri = sInternalMediaStorageUri;
        } else {
            storageVolume = sExternalStorageVolumeName;
            storageUri = sExternalMediaStorageUri;
        }
        return new PlayableItem(storageVolume, storageUri, id, playlistItemId);
    }

    public static List<PlayableItem> createPlayableListFromCursor(Cursor aCursor) {
        ArrayList<PlayableItem> playableList = new ArrayList(aCursor.getCount());
        aCursor.moveToPosition(-1);
        while (aCursor.moveToNext()) {
            playableList.add(createPlayableItemFromCursor(aCursor));
        }
        return playableList;
    }

    public static String getSortColumn(String aSortOrder) {
        String sortOrder = aSortOrder;
        return sortOrder.substring(0, sortOrder.indexOf(32));
    }

    public static boolean getIsAscendingSort(String aSortOrder) {
        return aSortOrder.toLowerCase().endsWith("asc");
    }

    public static Uri getStorageUriFromVolume(String aVolume) {
        if (aVolume == null) {
            return null;
        }
        if (aVolume.equals(sExternalStorageVolumeName)) {
            return sExternalMediaStorageUri;
        }
        if (aVolume.equals(sInternalStorageVolumeName)) {
            return sInternalMediaStorageUri;
        }
        if (aVolume.equals(sPhoneStorageVolumeName)) {
            return sPhoneMediaStorageUri;
        }
        return null;
    }

    public static String getVolumeFromCursor(Cursor aCursor) {
        Bundle extras = aCursor.getExtras();
        if (extras.getBoolean(sCursorIsExternalStorage, false)) {
            return sExternalStorageVolumeName;
        }
        if (extras.getBoolean(sCursorIsPhoneStorage, false)) {
            return sPhoneStorageVolumeName;
        }
        if (extras.getBoolean(sCursorIsInternalStorage, false)) {
            return sInternalStorageVolumeName;
        }
        return sExternalStorageVolumeName;
    }

    public static void pruneGenres(ContentResolver contentResolver) {
        int genreId;
        int songCount;
        String[] genreProj = new String[]{"_id"};
        String[] countProj = new String[]{"COUNT(album)"};
        Cursor externalStorageCursor = contentResolver.query(Genres.EXTERNAL_CONTENT_URI, genreProj, null, null, null);
        if (externalStorageCursor != null) {
            while (externalStorageCursor.moveToNext()) {
                try {
                    Cursor genreMembersCursor;
                    genreId = externalStorageCursor.getInt(0);
                    genreMembersCursor = contentResolver.query(Members.getContentUri(sExternalStorageVolumeName, (long) genreId), countProj, null, null, null);
                    songCount = 0;
                    while (genreMembersCursor.moveToNext()) {
                        songCount += genreMembersCursor.getInt(0);
                    }
                    genreMembersCursor.close();
                    if (songCount == 0) {
                        contentResolver.delete(Uri.withAppendedPath(Genres.EXTERNAL_CONTENT_URI, Integer.toString(genreId)), null, null);
                    }
                } catch (Exception e) {
                }
            }
            externalStorageCursor.close();
        }
        Uri phoneStorageUri = Genres.getContentUri(sPhoneStorageVolumeName);
        Cursor phoneStorageCursor = contentResolver.query(phoneStorageUri, genreProj, null, null, null);
        if (phoneStorageCursor != null) {
            while (phoneStorageCursor.moveToNext()) {
                try {
                    genreId = phoneStorageCursor.getInt(0);
                    genreMembersCursor = contentResolver.query(Members.getContentUri(sPhoneStorageVolumeName, (long) genreId), countProj, null, null, null);
                    songCount = 0;
                    while (genreMembersCursor.moveToNext()) {
                        songCount += genreMembersCursor.getInt(0);
                    }
                    genreMembersCursor.close();
                    if (songCount == 0) {
                        contentResolver.delete(Uri.withAppendedPath(phoneStorageUri, Integer.toString(genreId)), null, null);
                    }
                } catch (Exception e2) {
                }
            }
            phoneStorageCursor.close();
        }
    }

    public static void removeFromMediaStorePlaylist(Context aContext, int aItemId, String aItemVolume, int aItemPosition, int aPlaylistId, String aPlaylistVolume) {
        ContentResolver contentResolver = aContext.getContentResolver();
        Uri membersUri = Playlists.Members.getContentUri(aPlaylistVolume, (long) aPlaylistId);
        Cursor playlistCursor = contentResolver.query(membersUri, new String[]{"COUNT(*)"}, null, null, null);
        playlistCursor.moveToNext();
        long playlistItemCount = playlistCursor.getLong(0);
        playlistCursor.close();
        contentResolver.delete(ContentUris.withAppendedId(membersUri, (long) aItemId), null, null);
        if (((long) aItemPosition) < playlistItemCount) {
            for (long current = (long) aItemPosition; current < playlistItemCount; current++) {
                ContentValues values = new ContentValues();
                values.put("play_order", Long.valueOf(current));
                contentResolver.update(membersUri, values, "play_order = ?", new String[]{Long.toString(1 + current)});
            }
        }
    }

    public static void removeMediaStorePlaylist(Context aContext, int aPlaylistId, String aPlaylistVolume) {
        aContext.getContentResolver().delete(Playlists.getContentUri(aPlaylistVolume), "_id = ?", new String[]{Integer.toString(aPlaylistId)});
    }

    public static boolean setItemAsRingtone(Context aContext, int aItemId, String aItemVolume) {
        RingtoneManager.setActualDefaultRingtoneUri(aContext, 1, ContentUris.withAppendedId(Media.getContentUri(aItemVolume), (long) aItemId));
        return true;
    }

    public static boolean hasPhone(Context aContext) {
        if (((TelephonyManager) aContext.getSystemService("phone")).getLine1Number() == null) {
            return false;
        }
        return true;
    }

    public static boolean renameMediaStorePlaylist(Context aContext, int aPlaylistId, String aPlaylistVolume, String aPlaylistName) {
        ContentResolver contentResolver = aContext.getContentResolver();
        Uri playlistUri = Playlists.getContentUri(aPlaylistVolume);
        ContentValues values = new ContentValues();
        values.put(CookieTable.NAME, aPlaylistName);
        if (contentResolver.update(playlistUri, values, "_id = ?", new String[]{Integer.toString(aPlaylistId)}) != 0) {
            return true;
        }
        return false;
    }

    public static boolean moveMediaStorePlaylistItem(Context aContext, int aPlaylistId, String aPlaylistVolume, long aFrom, long aTo) {
        ContentResolver contentResolver = aContext.getContentResolver();
        Uri uri = Playlists.Members.getContentUri(aPlaylistVolume, (long) aPlaylistId).buildUpon().appendEncodedPath(String.valueOf(aFrom)).appendQueryParameter("move", "true").build();
        ContentValues values = new ContentValues();
        values.put("play_order", Long.valueOf(aTo));
        return contentResolver.update(uri, values, null, null) != 0;
    }

    public static boolean doesMediaStorePlaylistExists(Context aContext, int aPlaylistId, String aPlaylistVolume) {
        boolean playListExists = true;
        ContentResolver contentResolver = aContext.getContentResolver();
        if (aPlaylistVolume == null) {
            aPlaylistVolume = sExternalStorageVolumeName;
        }
        Cursor cursor = contentResolver.query(Playlists.getContentUri(aPlaylistVolume), new String[]{"COUNT(*)"}, "_id = ?", new String[]{Integer.toString(aPlaylistId)}, null);
        if (cursor == null) {
            return false;
        }
        if (cursor.getCount() == 0) {
            cursor.close();
            return false;
        }
        cursor.moveToNext();
        if (cursor.getInt(0) <= 0) {
            playListExists = false;
        }
        cursor.close();
        return playListExists;
    }

    public static Bitmap getAlbumArtFromFolder(String playablePath, String playableAlbumKey) {
        if (playableAlbumKey == null || playableAlbumKey.length() == 0 || playablePath == null || playablePath.length() == 0) {
            return null;
        }
        String albumartPath = getAlbumArtPath(playablePath, playableAlbumKey);
        if (albumartPath == null) {
            albumartPath = getEmbeddedPicture(playablePath, playableAlbumKey);
            if (albumartPath == null) {
                return null;
            }
        }
        return BitmapFactory.decodeFile(albumartPath);
    }

    public static String getAlbumArtPath(String playablePath, String playableAlbumKey) {
        int lastSlash = playablePath.lastIndexOf(47);
        if (lastSlash == -1) {
            return null;
        }
        String folder = playablePath.substring(0, lastSlash);
        File file = new File(folder);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        String keyName = folder + "/" + getKeyToFilename(playableAlbumKey);
        if (new File(keyName).exists()) {
            return keyName;
        }
        String[] list = file.list(imageFilter1);
        if (list != null && list.length > 0) {
            return folder + "/" + list[0];
        }
        list = file.list(imageFilter2);
        return (list == null || list.length <= 0) ? null : folder + "/" + list[0];
    }

    private static String getBuildType(Context pContext) {
        return ((SongbirdApplication) pContext.getApplicationContext()).getBuildType();
    }

    public static boolean isQABuild(Context pContext) {
        return getBuildType(pContext).equals(SongbirdApplication.QA_BUILD);
    }

    public static String dumpCursorColumns(Cursor cursor) {
        cursor.moveToFirst();
        String dump = "";
        for (String s : cursor.getColumnNames()) {
            dump = dump + s + ",";
        }
        cursor.close();
        return dump;
    }

    public static int getPodcastVisibility() {
        return isPodcastSupported() ? 0 : 8;
    }

    public static boolean isPodcastSupported() {
        return VERSION.SDK_INT >= 8;
    }

    public static boolean isMediaMetadataRetrieverSupported() {
        return VERSION.SDK_INT >= 10;
    }

    public static int getFriendsVisibility() {
        return isFriendsSupported() ? 0 : 8;
    }

    public static boolean isFriendsSupported() {
        return VERSION.SDK_INT > 7;
    }

    public static String getEmbeddedPicture(String playablePath, String playableAlbumKey) {
        String str = null;
        if (isMediaMetadataRetrieverSupported()) {
            try {
                str = getEmbeddedPictureFile(playablePath, playableAlbumKey, getMainPlayerArtWidth());
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
        return str;
    }

    private static int getMainPlayerArtWidth() {
        return 500;
    }

    private static String getKeyToFilename(String albumKey) {
        String filename = "";
        for (int i = 0; i < albumKey.length(); i++) {
            char c = albumKey.charAt(i);
            if (c >= 'A' && c <= 'z') {
                filename = filename + c;
            }
        }
        return filename + ".png";
    }

    private static String getEmbeddedPictureFile(String playablePath, String playableAlbumKey, int targetWidth) throws Exception {
        Bitmap bitmap = getEmbeddedPictureBitmap(playablePath, targetWidth);
        String folder = playablePath.substring(0, playablePath.lastIndexOf(47));
        String filename = folder + "/" + getKeyToFilename(playableAlbumKey);
        FileOutputStream fos = new FileOutputStream(filename);
        if (bitmap.compress(CompressFormat.PNG, 100, fos)) {
            fos.close();
            bitmap.recycle();
            return filename;
        }
        throw new IOException("BitmapFactory: failed to write to file " + filename);
    }

    private static Bitmap getEmbeddedPictureBitmap(String path, int targetWidth) throws Exception {
        if (new File(path).exists()) {
            byte[] data = getEmbeddedPictureData(path);
            Options bounds = new Options();
            bounds.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(data, 0, data.length, bounds);
            if (bounds.outWidth == -1) {
                throw new IOException("BitmapFactory: failed to obtain bounds " + path);
            } else if (bounds.outWidth < targetWidth) {
                throw new Exception("MediaMetadataRetriever: embedded image too small");
            } else {
                double sampleSize = ((double) bounds.outWidth) / ((double) targetWidth);
                Options options = new Options();
                options.inSampleSize = 1;
                if (sampleSize > 1.0d) {
                    options.inSampleSize = (int) (Math.floor(sampleSize) + 1.0d);
                }
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
                if (bitmap != null) {
                    return bitmap;
                }
                throw new IOException("BitmapFactory: failed to decode image " + path);
            }
        }
        throw new IOException("MediaMetadataRetriever: not found " + path);
    }

    private static byte[] getEmbeddedPictureData(String path) throws IOException {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(path);
        byte[] data = mmr.getEmbeddedPicture();
        if (data != null) {
            return data;
        }
        throw new IOException("MediaMetadataRetriever: failed to get data for " + path);
    }

    public static void scanFile(Context aContext, String aPath) {
        aContext.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + aPath)));
    }

    public static void scanSd(Context aContext) {
        scanFile(aContext, Environment.getExternalStorageDirectory().toString());
    }

    public static void move(List<String> list, String aTargetFolder) throws IOException {
        mkdir(aTargetFolder);
        for (String aTarget : list) {
            File aCurrentTarget = new File(aTarget);
            move(aCurrentTarget, new File(aTargetFolder + '/' + aCurrentTarget.getName()));
        }
    }

    private static void move(File pInFile, File pOutFile) throws IOException {
        copy(pInFile, pOutFile, true);
    }

    private static void copy(File pInFile, File pOutFile, boolean pDeleteOrig) throws IOException {
        FileChannel inChannel = new FileInputStream(pInFile).getChannel();
        FileChannel outChannel = new FileOutputStream(pOutFile).getChannel();
        boolean isSuccess = false;
        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
            isSuccess = true;
            if (isSuccess && pDeleteOrig) {
                pInFile.delete();
            }
        } finally {
            if (inChannel != null) {
                inChannel.close();
            }
            if (outChannel != null) {
                outChannel.close();
            }
        }
    }

    private static void mkdir(String aTargetFolder) throws IOException {
        File file = new File(aTargetFolder);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("Error creating " + aTargetFolder);
        }
    }

    public static boolean checkIfStorageMounted(Context aContext) {
        boolean mediaStoreAvailable;
        try {
            Cursor cursor = aContext.getContentResolver().query(Albums.EXTERNAL_CONTENT_URI, new String[]{"COUNT(album)"}, null, null, null);
            if (cursor != null) {
                cursor.close();
                mediaStoreAvailable = true;
            } else {
                mediaStoreAvailable = false;
            }
        } catch (Exception e) {
            mediaStoreAvailable = false;
            e.printStackTrace();
        }
        if (Environment.getExternalStorageState().equals("mounted") && mediaStoreAvailable) {
            return true;
        }
        return false;
    }

    public static GregorianCalendar getBuildDate(Context aContext) throws ParseException, NameNotFoundException {
        int versionCode = aContext.getPackageManager().getPackageInfo(aContext.getPackageName(), 0).versionCode;
        GregorianCalendar sBuildDate = new GregorianCalendar();
        sBuildDate.setTime(new SimpleDateFormat("yyyyMMdd").parse("" + versionCode));
        return sBuildDate;
    }

    public static boolean isPreRelease(Context aContext) {
        return Boolean.parseBoolean(aContext.getResources().getString(C0116R.string.pre_release));
    }

    public static void hideKeyboard(Context aContext, IBinder aWindowToken) {
        ((InputMethodManager) aContext.getSystemService("input_method")).hideSoftInputFromWindow(aWindowToken, 0);
    }

    public static void loseFocus(View aSacrifice) {
        aSacrifice.setFocusableInTouchMode(true);
        aSacrifice.requestFocus();
        aSacrifice.setFocusableInTouchMode(false);
    }

    public static void podcastScanTaskExecute(Context aContext) {
        new PodcastScanTask(null).execute(new Context[]{aContext});
    }

    public static void podcastScanTaskExecute(Context aContext, Runnable aOnComplete) {
        new PodcastScanTask(aOnComplete).execute(new Context[]{aContext});
    }

    public static void setForcedOrientation(Context aContext, boolean aValue) {
        Editor aEditor = aContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
        aEditor.putBoolean(PrefKeys.LOCK_PORTRAIT, aValue);
        aEditor.commit();
    }

    public static Intent getPhilipsIntent(boolean pIsVideo, int pMediaSessionId) {
        return getPhilipsIntent(pIsVideo, pMediaSessionId, true);
    }

    public static Intent getPhilipsIntent(boolean pIsVideo, int pMediaSessionId, boolean pShowUI) {
        int i = 1;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.philips.sound", "com.philips.sound.Setting"));
        intent.putExtra("VERSION", 1);
        intent.setAction("com.philips.sound.CONTENT_TYPE");
        if (pIsVideo) {
            intent.putExtra("APP_ID", "com.songbirdnest.mediaplayer.Songbird.video");
            intent.putExtra("PLAYER_TYPE", 2);
        } else {
            intent.putExtra("APP_ID", "com.songbirdnest.mediaplayer.Songbird");
            intent.putExtra("PLAYER_TYPE", 1);
        }
        intent.putExtra("SESSION_ID", pMediaSessionId);
        String str = "UI";
        if (!pShowUI) {
            i = 0;
        }
        intent.putExtra(str, i);
        return intent;
    }

    public static boolean containsGingerPackage(Intent pIntent, PackageManager pManager) {
        if (VERSION.SDK_INT < 9 || pManager.queryIntentActivities(pIntent, 65536).size() <= 0) {
            return false;
        }
        return true;
    }

    public static String encode(String s) {
        String str = null;
        if (s != null) {
            try {
                str = URLEncoder.encode(s, MyID3v2Constants.CHAR_ENCODING_UTF_8);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return str;
    }

    public static String decode(String s) {
        String str = null;
        if (s != null) {
            try {
                str = URLDecoder.decode(s, MyID3v2Constants.CHAR_ENCODING_UTF_8);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return str;
    }

    public static Object getField(Object mainClass, String fieldName) {
        Object obj = null;
        if (mainClass == null) {
            System.out.println("Object is null for field " + fieldName);
        } else {
            Class mainClassObject = mainClass.getClass();
            if (mainClassObject == null) {
                System.out.println("Class object is null for field " + fieldName);
            } else {
                while (!false) {
                    try {
                        Field fieldObject = mainClassObject.getDeclaredField(fieldName);
                        fieldObject.setAccessible(true);
                        obj = fieldObject.get(mainClass);
                        break;
                    } catch (NoSuchFieldException nsf) {
                        mainClassObject = mainClassObject.getSuperclass();
                        if (mainClassObject == null) {
                            System.out.println("No Such Field Exception: " + nsf.getMessage() + " for field " + fieldName);
                            break;
                        }
                    } catch (SecurityException security) {
                        System.out.println("Security Exception: " + security.getMessage() + " for class " + mainClassObject.getName() + " & field " + fieldName);
                    } catch (Exception e) {
                        System.out.println("Error in getting field " + fieldName + " for Class " + mainClassObject.getName());
                        e.printStackTrace();
                    }
                }
            }
        }
        return obj;
    }
}
