package com.ushareit.listenit;

import java.io.IOException;

public class brx extends IOException {
    public final int f7568a;
    public final brk f7569b;

    public brx(String str, brk com_ushareit_listenit_brk, int i) {
        super(str);
        this.f7569b = com_ushareit_listenit_brk;
        this.f7568a = i;
    }

    public brx(IOException iOException, brk com_ushareit_listenit_brk, int i) {
        super(iOException);
        this.f7569b = com_ushareit_listenit_brk;
        this.f7568a = i;
    }

    public brx(String str, IOException iOException, brk com_ushareit_listenit_brk, int i) {
        super(str, iOException);
        this.f7569b = com_ushareit_listenit_brk;
        this.f7568a = i;
    }
}
