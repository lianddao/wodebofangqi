package com.ushareit.listenit;

public class bor extends Exception {
    public bor(String str) {
        super(str);
    }

    public bor(String str, Throwable th) {
        super(str, th);
    }
}
