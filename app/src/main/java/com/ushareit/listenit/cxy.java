package com.ushareit.listenit;

public class cxy extends RuntimeException {
    public cxy(String str) {
        super(str);
    }

    public cxy(String str, Throwable th) {
        super(str, th);
    }
}
