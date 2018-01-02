package com.miui.player.ffmpeg;

public interface FFMPEGStatus {
    public static final int BAD_ARGS = -5;
    public static final int BAD_FILE_NAME = -2;
    public static final int BAD_FRAME = -8;
    public static final int BAD_HEAD = -4;
    public static final int BAD_STATE = -3;
    public static final int NO_ERROR = 0;
    public static final int READ_EOF = -1;
    public static final int READ_FAILED = -6;
    public static final int SEEK_FAILED = -7;
}
