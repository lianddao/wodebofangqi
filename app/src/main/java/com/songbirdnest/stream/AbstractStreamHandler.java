package com.songbirdnest.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

public class AbstractStreamHandler<Result> implements StreamHandler<Result> {
    protected int BUFFER_SIZE = 512;
    protected boolean mGZipped = false;
    protected StreamProcessor<Result> processor;

    public StreamType getType() {
        return StreamType.GET_TYPE;
    }

    public Result processInputStream(InputStream stream, long contentLength) throws StreamException {
        return null;
    }

    public void writeOutputStream(OutputStream stream) throws StreamException {
    }

    public void setupConnection(URLConnection connection) {
    }

    protected String readUncompressed(InputStream stream) throws IOException {
        StringBuilder builder = new StringBuilder();
        byte[] aBuffer = new byte[this.BUFFER_SIZE];
        while (true) {
            int aCount = stream.read(aBuffer, 0, this.BUFFER_SIZE);
            if (aCount == -1) {
                return builder.toString();
            }
            builder.append(new String(aBuffer, 0, aCount));
        }
    }

    protected String readCompressed(InputStream stream) throws IOException {
        GZIPInputStream gis = new GZIPInputStream(stream, 32);
        StringBuilder string = new StringBuilder();
        byte[] data = new byte[32];
        while (true) {
            int bytesRead = gis.read(data);
            if (bytesRead != -1) {
                string.append(new String(data, 0, bytesRead));
            } else {
                gis.close();
                stream.close();
                return string.toString();
            }
        }
    }

    public String readInputStream(InputStream stream) throws IOException {
        if (this.mGZipped) {
            return readCompressed(stream);
        }
        return readUncompressed(stream);
    }

    public void setStreamProcessor(StreamProcessor<Result> processor) {
        this.processor = processor;
    }

    public StreamProcessor<Result> getProcessor() {
        return this.processor;
    }

    public void setGZipEncoding(boolean pIsGZipEncoded) {
        this.mGZipped = pIsGZipEncoded;
    }
}
