package com.ushareit.listenit;

public class dbe extends RuntimeException {
    public dbe(String str) {
        super(str);
    }

    public dbe(String str, Throwable th) {
        super(str, th);
    }

    public dbe(Throwable th) {
        super(th);
    }
}
