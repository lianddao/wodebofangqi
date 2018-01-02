package com.xiaomi.music;

public class Result<T> {
    public final T mData;
    public final int mErrorCode;
    private String mRawStr;
    public final boolean mRetriable;

    private Result(int error, T data, boolean retriable, String raw) {
        this.mErrorCode = error;
        this.mData = data;
        this.mRetriable = retriable;
        this.mRawStr = raw;
    }

    public String getRawData() {
        return this.mRawStr;
    }

    public void setRawData(String rawData) {
        this.mRawStr = rawData;
    }

    public static <T> Result<T> create(int error) {
        return new Result(error, null, false, null);
    }

    public static <T> Result<T> create(int error, T data) {
        return new Result(error, data, false, null);
    }

    public static <T> Result<T> create(int error, T data, boolean retriable) {
        return new Result(error, data, retriable, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Error=").append(this.mErrorCode).append(" Retriable=").append(this.mRetriable).append(" Data=").append(this.mData).append(" Raw=").append(this.mRawStr);
        return sb.toString();
    }
}
