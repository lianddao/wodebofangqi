package com.ushareit.listenit;

public class aie extends aif {
    private int f4403a;
    private String f4404b;

    public aie(String str, int i, String str2) {
        super(str);
        this.f4403a = i;
        this.f4404b = str2;
    }

    public int m5688a() {
        return this.f4403a;
    }

    public String m5689b() {
        return this.f4404b;
    }

    public final String toString() {
        return "{FacebookDialogException: " + "errorCode: " + m5688a() + ", message: " + getMessage() + ", url: " + m5689b() + "}";
    }
}
