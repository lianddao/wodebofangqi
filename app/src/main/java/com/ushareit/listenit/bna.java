package com.ushareit.listenit;

public class bna extends Exception {
    private bna(Throwable th) {
        super("Failed to query underlying media codecs", th);
    }
}
