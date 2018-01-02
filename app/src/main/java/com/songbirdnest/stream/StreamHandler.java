package com.songbirdnest.stream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;

public interface StreamHandler<Result> {
    StreamType getType();

    Result processInputStream(InputStream inputStream, long j) throws StreamException;

    void setGZipEncoding(boolean z);

    void setStreamProcessor(StreamProcessor<Result> streamProcessor);

    void setupConnection(URLConnection uRLConnection);

    void writeOutputStream(OutputStream outputStream) throws StreamException;
}
