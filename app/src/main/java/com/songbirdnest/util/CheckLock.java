package com.songbirdnest.util;

public interface CheckLock {
    void lock();

    boolean needsLock();

    void unlock();
}
