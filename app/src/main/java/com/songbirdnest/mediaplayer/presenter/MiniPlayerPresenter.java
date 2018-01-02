package com.songbirdnest.mediaplayer.presenter;

import android.util.Log;
import com.songbirdnest.mediaplayer.viewInterface.Listener;
import com.songbirdnest.mediaplayer.viewInterface.MiniPlayerView;

public class MiniPlayerPresenter {
    String artistName = "";
    MiniPlayerView myView;
    String songName = "";
    int totalDuration = 0;

    class C01841 implements Listener {
        C01841() {
        }

        public void onAction() {
            Log.i("PResenter", "Retreived name " + MiniPlayerPresenter.this.myView.getCurrentSongArtist());
            if (MiniPlayerPresenter.this.myView.getCurrentSongArtist() != MiniPlayerPresenter.this.artistName) {
                MiniPlayerPresenter.this.artistName = MiniPlayerPresenter.this.myView.getCurrentSongArtist();
                Log.i("PResenter", "Retreived name " + MiniPlayerPresenter.this.artistName);
                MiniPlayerPresenter.this.myView.setSongArtistText(MiniPlayerPresenter.this.artistName + " - " + MiniPlayerPresenter.this.songName);
            }
            if (MiniPlayerPresenter.this.myView.getCurrentSongName() != MiniPlayerPresenter.this.songName) {
                MiniPlayerPresenter.this.songName = MiniPlayerPresenter.this.myView.getCurrentSongName();
                MiniPlayerPresenter.this.myView.setSongArtistText(MiniPlayerPresenter.this.artistName + " - " + MiniPlayerPresenter.this.songName);
            }
            if (MiniPlayerPresenter.this.totalDuration != MiniPlayerPresenter.this.myView.getDuration() && MiniPlayerPresenter.this.myView.isPlaying()) {
                MiniPlayerPresenter.this.totalDuration = MiniPlayerPresenter.this.myView.getDuration();
                MiniPlayerPresenter.this.myView.setProgressMax(MiniPlayerPresenter.this.totalDuration);
            }
            MiniPlayerPresenter.this.myView.setProgressBar(MiniPlayerPresenter.this.myView.getCurrentPosition());
        }
    }

    class C01852 implements Listener {
        C01852() {
        }

        public void onAction() {
            MiniPlayerPresenter.this.myView.nextSong();
            MiniPlayerPresenter.this.artistName = MiniPlayerPresenter.this.myView.getCurrentSongArtist();
            MiniPlayerPresenter.this.songName = MiniPlayerPresenter.this.myView.getCurrentSongName();
            MiniPlayerPresenter.this.myView.setSongArtistText(MiniPlayerPresenter.this.artistName + " - " + MiniPlayerPresenter.this.songName);
            MiniPlayerPresenter.this.clearProgress();
        }
    }

    class C01863 implements Listener {
        C01863() {
        }

        public void onAction() {
            MiniPlayerPresenter.this.myView.previousSong();
            MiniPlayerPresenter.this.artistName = MiniPlayerPresenter.this.myView.getCurrentSongArtist();
            MiniPlayerPresenter.this.songName = MiniPlayerPresenter.this.myView.getCurrentSongName();
            MiniPlayerPresenter.this.myView.setSongArtistText(MiniPlayerPresenter.this.artistName + " - " + MiniPlayerPresenter.this.songName);
            MiniPlayerPresenter.this.clearProgress();
        }
    }

    class C01874 implements Listener {
        C01874() {
        }

        public void onAction() {
            if (MiniPlayerPresenter.this.myView.isPlaying()) {
                MiniPlayerPresenter.this.myView.pause();
            } else {
                MiniPlayerPresenter.this.myView.play();
            }
        }
    }

    public MiniPlayerPresenter(MiniPlayerView inView) {
        this.myView = inView;
        this.myView.setUpdateTimer(new C01841());
        this.myView.setFastForward(new C01852());
        this.myView.setRewind(new C01863());
        this.myView.setPause(new C01874());
    }

    private void clearProgress() {
        this.myView.setProgressBar(0);
    }
}
