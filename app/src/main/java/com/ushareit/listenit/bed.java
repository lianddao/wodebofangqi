package com.ushareit.listenit;

public enum bed {
    INVALID_REQUEST("Invalid Ad request."),
    NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
    NETWORK_ERROR("A network error occurred."),
    INTERNAL_ERROR("There was an internal error.");
    
    private final String f5984e;

    private bed(String str) {
        this.f5984e = str;
    }

    public String toString() {
        return this.f5984e;
    }
}
