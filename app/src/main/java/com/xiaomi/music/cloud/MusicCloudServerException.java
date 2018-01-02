package com.xiaomi.music.cloud;

import java.io.PrintStream;

public class MusicCloudServerException extends Exception {
    private static final long serialVersionUID = 1;
    private final int mStatusCode;
    private final Exception mWrapped;

    public MusicCloudServerException(Exception wrapped, int code) {
        this.mWrapped = wrapped;
        this.mStatusCode = code;
    }

    public Exception getWrapped() {
        return this.mWrapped;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void printStackTrace(PrintStream err) {
        err.println("Cause = " + this.mWrapped);
        super.printStackTrace(err);
    }
}
