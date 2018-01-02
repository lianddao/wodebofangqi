package com.ushareit.listenit;

public enum ahu {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(false),
    TEST_USER(true),
    CLIENT_TOKEN(true);
    
    private final boolean f4395h;

    private ahu(boolean z) {
        this.f4395h = z;
    }

    boolean m5672a() {
        return this.f4395h;
    }
}
