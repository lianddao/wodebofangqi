package com.ushareit.listenit;

public class aif extends RuntimeException {
    public aif(String str) {
        super(str);
    }

    public aif(String str, Object... objArr) {
        this(String.format(str, objArr));
    }

    public aif(String str, Throwable th) {
        super(str, th);
    }

    public aif(Throwable th) {
        super(th);
    }

    public String toString() {
        return getMessage();
    }
}
