package com.ushareit.listenit;

public class ecf extends RuntimeException {
    public ecf(String str) {
        super(str);
    }

    public ecf(String str, Throwable th) {
        super(str, th);
    }
}
