package com.ushareit.listenit;

public enum guk {
    ANALYTICS,
    COLLECTEVN,
    CLOUD,
    ALL;

    public String toString() {
        switch (this) {
            case ANALYTICS:
                return "Analytics";
            case COLLECTEVN:
                return "EnvCollect";
            case CLOUD:
                return "Cloud";
            case ALL:
                return "All";
            default:
                return "";
        }
    }
}
