package com.ushareit.listenit;

public enum eik {
    WEB_VIEW_DID_APPEAR("webviewDidAppear();"),
    WEB_VIEW_DID_CLOSE("webviewDidClose();");
    
    private String f11085a;

    private eik(String str) {
        this.f11085a = str;
    }

    protected String m17083a() {
        return this.f11085a;
    }

    public String m17084b() {
        return "javascript:" + this.f11085a;
    }
}
