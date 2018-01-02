package com.songbirdnest.billing;

public enum ResponseCode {
    RESULT_OK,
    RESULT_USER_CANCELED,
    RESULT_SERVICE_UNAVAILABLE,
    RESULT_BILLING_UNAVAILABLE,
    RESULT_ITEM_UNAVAILABLE,
    RESULT_DEVELOPER_ERROR,
    RESULT_ERROR;

    public static ResponseCode valueOf(int index) {
        ResponseCode[] values = values();
        if (index < 0 || index >= values.length) {
            return RESULT_ERROR;
        }
        return values[index];
    }
}
