package com.songbirdnest.database;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.songbirdnest.util.MediaUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Model {
    public static final String GENRE_NAME_PODCAST = "Podcast";
    public static final String OS_FOLDER_PODCAST = "podcasts";

    public static class Media {
        private static String[] filterArgs = new String[]{"1", "1"};
        private static String[] filterProjection = new String[]{"_id"};
        private static final String filterSelection = (Song.getFilterSelection() + " OR " + Podcast.getFilterSelection());

        public static String getFilterSelection() {
            return filterSelection;
        }

        public static String[] getFilterArgs() {
            return filterArgs;
        }

        private static String[] getFilterProjection() {
            return filterProjection;
        }

        public static Cursor getCursor(Context context) {
            return MediaUtils.getMediaStoreMergeCursor(context, getFilterProjection(), getFilterSelection(), getFilterArgs(), null);
        }
    }

    public static class Podcast {
        private static String[] filterArgs = new String[]{"1"};
        private static String[] filterProjection = new String[]{"_id", "title", "duration", "artist", "album", "album_key", "bookmark"};
        private static final String filterSelection = "is_podcast = ? ";
        private static HashMap<String, Boolean> isPodcastCache = new HashMap();
        private static final String searchSelection = "is_podcast = ? AND (title LIKE ? OR album LIKE ? ) ";

        public static String getFilterSelection() {
            return filterSelection;
        }

        public static String[] getFilterArgs() {
            return filterArgs;
        }

        private static String[] getFilterProjection() {
            return filterProjection;
        }

        public static int getCount(Context context) {
            int count = 0;
            try {
                Cursor cursor = MediaUtils.getMediaStoreMergeCursor(context, new String[]{"COUNT(_id)"}, getFilterSelection(), getFilterArgs(), null);
                while (cursor.moveToNext()) {
                    count += cursor.getInt(0);
                }
                cursor.close();
                return count;
            } catch (Exception e) {
                return 0;
            }
        }

        public static String getSearchSelection() {
            return searchSelection;
        }

        public static String[] getSearchArgs(String term) {
            return new String[]{"1", "%" + term + "%", "%" + term + "%"};
        }

        public static boolean isPodcast(Context context, int id) {
            Boolean isPodcast = (Boolean) isPodcastCache.get("" + id);
            if (isPodcast == null) {
                isPodcast = new Boolean(get(context, id) != null);
                isPodcastCache.put("" + id, isPodcast);
            }
            return isPodcast.booleanValue();
        }

        public static long getBookmark(Context context, int id) {
            Cursor cursor = get(context, id);
            if (cursor == null) {
                return 0;
            }
            return cursor.getLong(cursor.getColumnIndex("bookmark"));
        }

        private static Cursor get(Context context, int id) {
            Cursor cursor = MediaUtils.getMediaStoreMergeCursor(context, getFilterProjection(), getFilterSelection() + " AND " + "_id" + " = ? ", new String[]{"1", "" + id}, null);
            if (cursor.getCount() != 1) {
                return null;
            }
            cursor.moveToFirst();
            return cursor;
        }

        public static void setBookmark(Context context, int id, Uri contentUri, int position) {
            ContentValues values = new ContentValues();
            values.put("bookmark", Integer.valueOf(position));
            if (context.getContentResolver().update(ContentUris.withAppendedId(contentUri, (long) id), values, null, null) == 1) {
            }
        }

        public static String getSdFolder() {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + Model.OS_FOLDER_PODCAST;
        }
    }

    public static class Song {
        private static final String[] filterArgs = new String[]{"1"};
        private static String[] filterProjection = new String[]{"_id", "title", "_data"};
        private static final String filterSelection = "is_music = ? ";
        private static final String searchSelection = "is_music = ? AND title LIKE ? ";

        public static String getFilterSelection() {
            return filterSelection;
        }

        public static String[] getFilterArgs() {
            return filterArgs;
        }

        public static String[] getFilterArgs(String string) {
            return new String[]{"1", string};
        }

        private static String[] getFilterProjection() {
            return filterProjection;
        }

        private static Cursor getGenre(Context aContext, String aGenreName) {
            return MediaUtils.getMediaStoreMergeCursorForGenre(aContext, getFilterProjection(), null, null, "title_key ASC", aGenreName);
        }

        public static ArrayList<String> getMisplacedPodcasts(Context aContext) {
            ArrayList<String> list = new ArrayList();
            try {
                Cursor cursor = getGenre(aContext, Model.GENRE_NAME_PODCAST);
                int column = cursor.getColumnIndex("_data");
                if (cursor.getCount() == 0) {
                    return null;
                }
                cursor.moveToFirst();
                do {
                    String uriString = cursor.getString(column);
                    if (!Pattern.compile(Pattern.quote(Model.OS_FOLDER_PODCAST), 2).matcher(uriString).find()) {
                        list.add(uriString);
                    }
                } while (cursor.moveToNext());
                return list;
            } catch (Throwable th) {
                return list;
            }
        }

        public static int getCount(Context context) {
            int count = 0;
            try {
                Cursor cursor = MediaUtils.getMediaStoreMergeCursor(context, new String[]{"COUNT(_id)"}, getFilterSelection(), getFilterArgs(), null);
                while (cursor.moveToNext()) {
                    count += cursor.getInt(0);
                }
                cursor.close();
                return count;
            } catch (Exception e) {
                return 0;
            }
        }

        public static String getSearchSelection() {
            return searchSelection;
        }

        public static String[] getSearchArgs(String term) {
            return new String[]{"1", "%" + term + "%"};
        }
    }

    class hack {

        class MediaStore {

            class Audio {

                class AudioColumns {
                    public static final String IS_PODCAST = "is_podcast";

                    AudioColumns() {
                    }
                }

                Audio() {
                }
            }

            MediaStore() {
            }
        }

        hack() {
        }
    }
}
