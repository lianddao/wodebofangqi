package com.songbirdnest.mediaplayer;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Handler;
import android.provider.MediaStore.Audio.Playlists;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.dialogs.CreatePlaylistDialog;
import com.songbirdnest.util.MediaUtils;

public final class ContextMenuUtils {
    public static Cursor getPlaylistsCursor(Context aContext) {
        return MediaUtils.getMediaStoreMergeCursorForPlaylist(aContext, new String[]{"_id", CookieTable.NAME}, null, null, "name ASC");
    }

    public static String getPlaylistName(Context aContext, Long mPlaylistId, String aPlaylistVolume) {
        String[] proj = new String[]{CookieTable.NAME};
        Cursor playlistCursor = aContext.getContentResolver().query(Playlists.getContentUri(aPlaylistVolume), proj, "_id = ?", new String[]{Long.toString(mPlaylistId.longValue())}, null);
        if (playlistCursor.moveToFirst()) {
            return playlistCursor.getString(playlistCursor.getColumnIndex(proj[0]));
        }
        return null;
    }

    public static void addPlaylistSubMenuClickHandler(Context aContext, MenuItem aMenuItem, int aItemId, String aItemVolume, String aItemTitle, Long mPlaylistId, String aPlaylistVolume, String aPlaylistName, Runnable aPostAddRunnable) {
        final Context context = aContext;
        final int i = aItemId;
        final String str = aItemVolume;
        final Long l = mPlaylistId;
        final String str2 = aPlaylistVolume;
        final String str3 = aItemTitle;
        final String str4 = aPlaylistName;
        final Runnable runnable = aPostAddRunnable;
        aMenuItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                if (MediaUtils.addToMediaStorePlaylist(context, i, str, l, str2)) {
                    Utils.showShortToast(context, context.getString(C0116R.string.playlist_added_item_message, new Object[]{str3, str4}));
                    ContextMenuUtils.setMostRecentlyEditedPlaylist(context, l, str2);
                    if (runnable != null) {
                        new Handler().post(runnable);
                    }
                } else {
                    Utils.showLongToast(context, context.getString(C0116R.string.playlist_add_failed_message, new Object[]{str3, str4}));
                }
                return true;
            }
        });
    }

    public static void addPlaylistSubMenuClickHandler(Context aContext, MenuItem aMenuItem, Cursor aCursor, String aTitle, Long mPlaylistId, String aPlaylistVolume, String aPlaylistName) {
        final Context context = aContext;
        final Cursor cursor = aCursor;
        final Long l = mPlaylistId;
        final String str = aPlaylistVolume;
        final String str2 = aTitle;
        final String str3 = aPlaylistName;
        aMenuItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                if (MediaUtils.addToMediaStorePlaylist(context, cursor, l, str) > 0) {
                    Utils.showShortToast(context, context.getString(C0116R.string.playlist_added_item_message, new Object[]{str2, str3}));
                    ContextMenuUtils.setMostRecentlyEditedPlaylist(context, l, str);
                } else {
                    Utils.showLongToast(context, context.getString(C0116R.string.playlist_add_failed_message, new Object[]{str2, str3}));
                }
                return true;
            }
        });
    }

    public static void addPlaylistSubMenu(Context aContext, Menu aMenu, int aItemId, String aItemVolume, String aItemTitle, boolean aPinLastEditedToTop) {
        addPlaylistSubMenu(aContext, aMenu, aItemId, aItemVolume, aItemTitle, null, true);
    }

    public static void addPlaylistSubMenu(Context aContext, Menu aMenu, Cursor aCursor, String aTitle, boolean aPinLastEditedToTop) {
        SubMenu subMenu = aMenu.addSubMenu(C0116R.string.playlist_listing_menu_add_item);
        subMenu.setHeaderTitle(C0116R.string.playlist_listing_select_playlist);
        final Context context = aContext;
        final Cursor cursor = aCursor;
        subMenu.add(C0116R.string.playlist_listing_menu_new).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                CreatePlaylistDialog dialog = new CreatePlaylistDialog(context);
                dialog.setItemsToAdd(cursor);
                dialog.show();
                return true;
            }
        });
        Playlist recentPlaylist = new Playlist();
        if (aPinLastEditedToTop && getMostRecentlyEditedPlaylist(aContext, recentPlaylist)) {
            String recentPlaylistName = getPlaylistName(aContext, recentPlaylist.mPlaylistId, recentPlaylist.mPlaylistVolume);
            if (recentPlaylistName != null) {
                addPlaylistSubMenuClickHandler(aContext, subMenu.add(recentPlaylistName), aCursor, aTitle, recentPlaylist.mPlaylistId, recentPlaylist.mPlaylistVolume, recentPlaylistName);
            }
        }
        Cursor playlistCursor = getPlaylistsCursor(aContext);
        while (playlistCursor.moveToNext()) {
            long playlistId = playlistCursor.getLong(playlistCursor.getColumnIndex("_id"));
            String playlistVolume = Utils.getVolumeFromCursor(playlistCursor);
            if (!aPinLastEditedToTop || playlistId != recentPlaylist.mPlaylistId.longValue() || !playlistVolume.equals(recentPlaylist.mPlaylistVolume)) {
                String playlistName = playlistCursor.getString(playlistCursor.getColumnIndex(CookieTable.NAME));
                addPlaylistSubMenuClickHandler(aContext, subMenu.add(playlistName), aCursor, aTitle, Long.valueOf(playlistId), playlistVolume, playlistName);
            }
        }
    }

    public static void addPlaylistSubMenu(Context aContext, Menu aMenu, int aItemId, String aItemVolume, String aItemTitle, Runnable aPostAddRunnable, boolean aPinLastEditedToTop) {
        SubMenu subMenu = aMenu.addSubMenu(C0116R.string.playlist_listing_menu_add_item);
        subMenu.setHeaderTitle(C0116R.string.playlist_listing_select_playlist);
        final Context context = aContext;
        final int i = aItemId;
        final String str = aItemVolume;
        subMenu.add(C0116R.string.playlist_listing_menu_new).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem aItem) {
                CreatePlaylistDialog dialog = new CreatePlaylistDialog(context);
                dialog.setItemToAdd(i, str);
                dialog.show();
                return true;
            }
        });
        Playlist recentPlaylist = new Playlist();
        if (aPinLastEditedToTop && getMostRecentlyEditedPlaylist(aContext, recentPlaylist)) {
            String recentPlaylistName = getPlaylistName(aContext, recentPlaylist.mPlaylistId, recentPlaylist.mPlaylistVolume);
            if (recentPlaylistName != null) {
                addPlaylistSubMenuClickHandler(aContext, subMenu.add(recentPlaylistName), aItemId, aItemVolume, aItemTitle, recentPlaylist.mPlaylistId, recentPlaylist.mPlaylistVolume, recentPlaylistName, null);
            }
        }
        Cursor playlistCursor = getPlaylistsCursor(aContext);
        while (playlistCursor.moveToNext()) {
            long playlistId = playlistCursor.getLong(playlistCursor.getColumnIndex("_id"));
            String playlistVolume = Utils.getVolumeFromCursor(playlistCursor);
            if (aPinLastEditedToTop && playlistId == recentPlaylist.mPlaylistId.longValue()) {
                if (playlistVolume.equals(recentPlaylist.mPlaylistVolume)) {
                }
            }
            String playlistName = playlistCursor.getString(playlistCursor.getColumnIndex(CookieTable.NAME));
            addPlaylistSubMenuClickHandler(aContext, subMenu.add(playlistName), aItemId, aItemVolume, aItemTitle, Long.valueOf(playlistId), playlistVolume, playlistName, aPostAddRunnable);
        }
    }

    public static boolean getMostRecentlyEditedPlaylist(Context aContext, Playlist aPlaylist) {
        String recentPlaylist = aContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).getString(PrefKeys.PLAYLIST_MOST_RECENTLY_EDITED_LIST, null);
        if (recentPlaylist == null) {
            return false;
        }
        String[] playlistInfo = recentPlaylist.split(":");
        if (playlistInfo.length != 2) {
            return false;
        }
        aPlaylist.mPlaylistId = Long.valueOf(Long.parseLong(playlistInfo[0]));
        aPlaylist.mPlaylistVolume = playlistInfo[1];
        return true;
    }

    public static boolean setMostRecentlyEditedPlaylist(Context aContext, Long mPlaylistId, String aPlaylistVolume) {
        Editor editor = aContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
        editor.putString(PrefKeys.PLAYLIST_MOST_RECENTLY_EDITED_LIST, mPlaylistId + ":" + aPlaylistVolume);
        return editor.commit();
    }
}
