package com.miui.player.asyncplayer;

import android.media.MediaPlayer.OnCompletionListener;

public interface PlayerStub {

    public interface AsyncPrepareListener {
        void onPrepareFailed(String str, Object obj, Exception exception);

        void onPrepareSuccess(String str, Object obj);

        void onSeeked(int i);
    }

    public static class PrepareInfo {
        public final String mAlbumName;
        public final String mArtistName;
        public final long mDuration;
        public final boolean mFirst;
        public final String mNextAudioId;
        public final long mStartPosition;
        public final String mTrackName;

        public PrepareInfo(boolean isFirst, String nextAudioId, long position, long duration, String tr, String al, String ar) {
            this.mFirst = isFirst;
            this.mNextAudioId = nextAudioId;
            this.mStartPosition = position;
            this.mDuration = duration;
            this.mTrackName = tr;
            this.mAlbumName = al;
            this.mArtistName = ar;
        }

        public String toString() {
            return super.toString() + "{" + " mFirst=" + this.mFirst + " mNextAudioId=" + this.mNextAudioId + " mStartPosition=" + this.mStartPosition + " mDuration=" + this.mDuration + " mTrackName=" + this.mTrackName + " mAlbumName=" + this.mAlbumName + " mArtistName=" + this.mArtistName + "}";
        }
    }

    boolean adjustVolume(boolean z);

    void changeMode(int i, int i2);

    long duration();

    int getAudioSessionId();

    float getBufferedPercent();

    String getPath();

    boolean isBlocking();

    boolean isInitialized();

    boolean isPrepared();

    void pause();

    long position();

    void prepare(String str, PrepareInfo prepareInfo);

    void release();

    void seek(long j);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void start();

    void stop(boolean z, boolean z2);
}
