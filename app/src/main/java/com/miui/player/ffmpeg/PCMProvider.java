package com.miui.player.ffmpeg;

import java.io.IOException;

public interface PCMProvider {
    void close();

    int getBaseFramePosition();

    int getChannels();

    int getDuration();

    int getMinSampleBufferSize();

    int getSampleRate();

    boolean isClosed();

    int open();

    int read(byte[] bArr) throws IOException;

    void release();

    int seek(int i);
}
