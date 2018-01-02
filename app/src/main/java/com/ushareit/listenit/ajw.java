package com.ushareit.listenit;

public enum ajw {
    UNKNOWN_ERROR(-1, "unknown error", false),
    NETWORK_ERROR(1000, "Network Error", true),
    NO_FILL(1001, "No Fill", true),
    LOAD_TOO_FREQUENTLY(1002, "Ad was re-loaded too frequently", true),
    DISABLED_APP(1005, "App is disabled from making ad requests", true),
    SERVER_ERROR(2000, "Server Error", true),
    INTERNAL_ERROR(2001, "Internal Error", true),
    START_BEFORE_INIT(2004, "initAd must be called before startAd", true),
    AD_REQUEST_FAILED(1111, "Facebook Ads SDK request for ads failed", false),
    AD_REQUEST_TIMEOUT(1112, "Facebook Ads SDK request for ads timed out", false),
    PARSER_FAILURE(1201, "Failed to parse Facebook Ads SDK delivery response", false),
    UNKNOWN_RESPONSE(1202, "Unknown Facebook Ads SDK delivery response type", false),
    ERROR_MESSAGE(1203, "Facebook Ads SDK delivery response Error message", true),
    NO_AD_PLACEMENT(1302, "Facebook Ads SDK returned no ad placements", false);
    
    private final int f4540o;
    private final String f4541p;
    private final boolean f4542q;

    private ajw(int i, String str, boolean z) {
        this.f4540o = i;
        this.f4541p = str;
        this.f4542q = z;
    }

    public static ajw m5819a(int i) {
        return m5820a(i, UNKNOWN_ERROR);
    }

    public static ajw m5820a(int i, ajw com_ushareit_listenit_ajw) {
        for (ajw com_ushareit_listenit_ajw2 : values()) {
            if (com_ushareit_listenit_ajw2.m5821a() == i) {
                return com_ushareit_listenit_ajw2;
            }
        }
        return com_ushareit_listenit_ajw;
    }

    public int m5821a() {
        return this.f4540o;
    }

    public amu m5822a(String str) {
        return new amu(this, str);
    }

    public String m5823b() {
        return this.f4541p;
    }

    boolean m5824c() {
        return this.f4542q;
    }
}
