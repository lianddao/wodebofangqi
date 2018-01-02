package com.ushareit.listenit;

public class ags extends Exception {
    public ags(String str) {
        super(str + ". Version: 2.7.0");
    }

    public ags(String str, Throwable th) {
        super(str + ". Version: 2.7.0", th);
    }
}
