package com.ushareit.listenit;

public class dqt extends Exception {
    private dqt(String str) {
        super(str);
    }

    private dqt(String str, Throwable th) {
        super(str, th);
    }
}
