package com.ushareit.listenit;

public enum etp {
    Custom(0),
    PageIn(1),
    PageOut(2),
    UnhandledException(3);
    
    private int f11805e;

    private etp(int i) {
        this.f11805e = i;
    }

    public int m17918a() {
        return this.f11805e;
    }

    public static etp m17917a(int i) {
        for (etp com_ushareit_listenit_etp : values()) {
            if (com_ushareit_listenit_etp.f11805e == i) {
                return com_ushareit_listenit_etp;
            }
        }
        return Custom;
    }
}
