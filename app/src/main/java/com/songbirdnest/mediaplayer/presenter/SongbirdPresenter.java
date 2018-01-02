package com.songbirdnest.mediaplayer.presenter;

import android.content.res.Resources;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.viewInterface.Listener;
import com.songbirdnest.mediaplayer.viewInterface.SongbirdView;
import java.util.HashMap;
import java.util.Map;

public class SongbirdPresenter {
    Resources mResources;
    SongbirdView mSongbirdView;

    class SongbirdPresenterAlbumChange implements Listener {
        SongbirdPresenterAlbumChange() {
        }

        public void onAction() {
            SongbirdPresenter.this.mSongbirdView.changeToAlbum();
        }
    }

    class SongbirdPresenterArtistChange implements Listener {
        SongbirdPresenterArtistChange() {
        }

        public void onAction() {
            SongbirdPresenter.this.mSongbirdView.changeToArtists();
        }
    }

    class SongbirdPresenterGenreChange implements Listener {
        SongbirdPresenterGenreChange() {
        }

        public void onAction() {
            SongbirdPresenter.this.mSongbirdView.changeToGenre();
        }
    }

    class SongbirdPresenterMoasicChange implements Listener {
        SongbirdPresenterMoasicChange() {
        }

        public void onAction() {
            Map<String, String> properties = new HashMap();
            properties.put(Analytics.FROM_KEY, Analytics.HOME_VALUE);
            Analytics.get().trackEvent(Analytics.EVENT_SONGBIRD_ME_ENTRY, null, properties);
            SongbirdPresenter.this.mSongbirdView.changeToDiscover();
        }
    }

    class SongbirdPresenterPlaylistChange implements Listener {
        SongbirdPresenterPlaylistChange() {
        }

        public void onAction() {
            SongbirdPresenter.this.mSongbirdView.changeToPlaylist();
        }
    }

    class SongbirdPresenterPodcastChange implements Listener {
        SongbirdPresenterPodcastChange() {
        }

        public void onAction() {
            SongbirdPresenter.this.mSongbirdView.changeToPodcast();
        }
    }

    class SongbirdPresenterSongChange implements Listener {
        SongbirdPresenterSongChange() {
        }

        public void onAction() {
            SongbirdPresenter.this.mSongbirdView.changeToSong();
        }
    }

    class SongbirdPresenterVideoChange implements Listener {
        SongbirdPresenterVideoChange() {
        }

        public void onAction() {
            SongbirdPresenter.this.mSongbirdView.changeToVideo();
        }
    }

    public SongbirdPresenter(SongbirdView aView, Resources aResources) {
        this.mResources = aResources;
        this.mSongbirdView = aView;
        this.mSongbirdView.setAlbumsButtonClick(new SongbirdPresenterAlbumChange());
        this.mSongbirdView.setArtistButtonClick(new SongbirdPresenterArtistChange());
        this.mSongbirdView.setGenreButtonClick(new SongbirdPresenterGenreChange());
        this.mSongbirdView.setPlaylistsButtonClick(new SongbirdPresenterPlaylistChange());
        this.mSongbirdView.setSongButtonClick(new SongbirdPresenterSongChange());
        this.mSongbirdView.setPodcastButtonClick(new SongbirdPresenterPodcastChange());
        this.mSongbirdView.setVideoButtonClick(new SongbirdPresenterVideoChange());
        this.mSongbirdView.setDiscoverButtonClick(new SongbirdPresenterMoasicChange());
    }

    public void update() {
        this.mSongbirdView.setSongButtonText(this.mResources.getString(C0116R.string.songs_header), Integer.toString(this.mSongbirdView.getSongTotal()));
        this.mSongbirdView.setAlbumsButtonText(this.mResources.getString(C0116R.string.album_header), Integer.toString(this.mSongbirdView.getAlbumTotal()));
        this.mSongbirdView.setArtistButtonText(this.mResources.getString(C0116R.string.artist_header), Integer.toString(this.mSongbirdView.getArtistTotal()));
        this.mSongbirdView.setGenreButtonText(this.mResources.getString(C0116R.string.genre_header), Integer.toString(this.mSongbirdView.getGenreTotal()));
        this.mSongbirdView.setPodcastButtonText(this.mResources.getString(C0116R.string.podcast_header), Integer.toString(this.mSongbirdView.getPodcastTotal()));
        this.mSongbirdView.setPlaylistsButtonText(this.mResources.getString(C0116R.string.playlist_header), Integer.toString(this.mSongbirdView.getPlaylistTotal()));
        this.mSongbirdView.setVideoText(this.mResources.getString(C0116R.string.video_header), Integer.toString(this.mSongbirdView.getVideoTotal()));
        this.mSongbirdView.setDiscoverButtonText(this.mResources.getString(C0116R.string.discover_header), this.mResources.getString(C0116R.string.discover_secondary));
    }
}
