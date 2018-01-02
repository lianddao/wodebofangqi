package com.songbirdnest.stream;

public class StreamException extends Exception {
    public static final int CLIENT_PROTOCOL_EXCEPTION_TYPE = 8;
    public static final int EXCEPTION_TYPE = 6;
    public static final int FILE_NOT_FOUND_TYPE = 3;
    public static final int IO_EXCEPTION_TYPE = 1;
    public static final int MALFORMED_URL_TYPE = 2;
    public static final int SOCKET_EXCEPTION_TYPE = 4;
    public static final int SOCKET_TIMEOUT_EXCEPTION_TYPE = 7;
    public static final int STREAM_EXCEPTION_TYPE = 0;
    public static final int UNKNOWN_HOST_EXCEPTION_TYPE = 5;
    protected int exceptionType;
    protected int responseCode;
    protected String responseMessage;

    public StreamException(String message) {
        super(message);
    }

    public StreamException(String message, Throwable cause) {
        super(message, cause);
    }

    public StreamException(Throwable cause) {
        super(cause);
    }

    public int getExceptionType() {
        return this.exceptionType;
    }

    public void setExceptionType(int exceptionType) {
        this.exceptionType = exceptionType;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
