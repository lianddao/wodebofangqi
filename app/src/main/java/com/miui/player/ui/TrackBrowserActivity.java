package com.miui.player.ui;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.miui.player.C0329R;
import com.miui.player.meta.MetaManager;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.KtvPlaylistCache;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.fragment.TrackListFragment;
import com.miui.player.util.FolderProvider;
import com.miui.player.util.FolderProvider.FolderItem;

public class TrackBrowserActivity extends MusicBaseActivity {
    private ActionBar mActionBar;
    private TrackListFragment mTrackListFragment;

    public void onCreateContent(Bundle icicle) {
        setContentView(C0329R.layout.track_picker_activity);
        this.mActionBar = getActionBar();
        UIHelper.attachGotoNowplayingIcon(this);
        this.mTrackListFragment = (TrackListFragment) getFragmentManager().findFragmentById(C0329R.id.track_list_fragment);
        this.mTrackListFragment.setHasOptionsMenu(true);
        setTitleBar();
    }

    protected boolean saveData(Bundle outcicle) {
        super.saveData(outcicle);
        if (this.mTrackListFragment != null) {
            this.mTrackListFragment.saveData(outcicle);
        }
        return true;
    }

    public void setTitleBar() {
        TrackListFragment list = this.mTrackListFragment;
        if (list.getFolderPath() != null) {
            FolderItem item = FolderProvider.instance(this).queryFolderItem(this, list.getFolderPath());
            if (item != null) {
                this.mActionBar.setTitle(item.getFolderName());
            }
        } else if (list.getAlbumId() >= 0) {
            CharSequence artist = list.getArtistName();
            CharSequence album = list.getAlbumName();
            cursor = list.getCursor();
            if ((TextUtils.isEmpty(artist) || TextUtils.isEmpty(album)) && cursor != null && cursor.moveToFirst()) {
                if (album == null) {
                    album = cursor.getString(cursor.getColumnIndexOrThrow("album"));
                }
                if (artist == null) {
                    artist = cursor.getString(cursor.getColumnIndexOrThrow("album"));
                }
            }
            this.mActionBar.setTitle(MetaManager.getLocaleArtistName(this, artist) + " " + MetaManager.getLocaleAlbumName(this, album));
        } else if (list.getArtistId() >= 0) {
            String artist2;
            cursor = list.getCursor();
            if (cursor == null || !cursor.moveToFirst()) {
                artist2 = list.getArtistName();
            } else {
                artist2 = cursor.getString(cursor.getColumnIndexOrThrow("artist"));
            }
            if (artist2 != null) {
                this.mActionBar.setTitle(MetaManager.getLocaleArtistName(this, artist2));
            }
        } else if (list.getPlaylistName() != null) {
            String playlistName = list.getPlaylistName();
            CharSequence displayName = null;
            if (playlistName.equals(PlaylistHelper.PLAYLSIT_FREQUENTLY_PLAYED)) {
                displayName = getText(C0329R.string.frequentlyplayed_title);
            } else if (playlistName.equals(PlaylistHelper.PLAYLIST_RECENTLY_ADDED)) {
                displayName = getText(C0329R.string.recentlyadded_title);
            } else if (playlistName.equals(PlaylistHelper.PLAYLIST_RECENTLY_PLAYED)) {
                displayName = getText(C0329R.string.recentlyplayed_title);
            } else {
                long plid = list.getPlaylistId();
                if (plid == FavoriteCache.getFavoritePlaylistId(this)) {
                    displayName = getText(C0329R.string.playlist_favorite);
                } else if (plid == KtvPlaylistCache.getPlaylistId(this)) {
                    displayName = getText(C0329R.string.playlist_my_ktv);
                } else if (plid >= 0) {
                    displayName = PlaylistHelper.queryPlaylistName(this, plid);
                }
            }
            this.mActionBar.setTitle(displayName);
        } else {
            this.mActionBar.setTitle(getText(C0329R.string.tracks_title));
        }
    }

    protected void handleServiceConnected(IMediaPlaybackService service) throws RemoteException {
        setTitleBar();
    }
}
