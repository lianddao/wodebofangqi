package com.songbirdnest.stream;

import android.os.Build.VERSION;
import com.songbirdnest.soundboard.SoundboardRunnable;
import com.songbirdnest.util.Logger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class StreamProcessor<Result> {
    protected static int DEFAULT_BUFFER_LENGTH = 64000;
    public static final int TEN_SECONDS = 10000;
    protected static int defaultBufferSize = 8192;
    protected final int CONNECTION_TIMEOUT = 20000;
    protected final int READ_TIMEOUT = 30000;
    protected int bufferLength = DEFAULT_BUFFER_LENGTH;
    protected HttpURLConnection connection;
    protected int connectionTimeout = 20000;
    protected long contentLength = 0;
    protected CookieStore cookieStore;
    protected DefaultHttpClient httpClient;
    protected int readTimeout = 30000;
    protected Map<String, String> requestHeaders = new HashMap();
    protected StreamHandler<Result> streamHandler;
    protected URL url;
    protected String urlString;

    static {
        if (VERSION.SDK_INT <= 7) {
            SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
        }
    }

    public StreamProcessor(String url, StreamHandler<Result> streamHandler) {
        this.urlString = url;
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            Logger.error(this, "Problems with url " + url, e);
        }
        this.streamHandler = streamHandler;
    }

    public StreamProcessor(URL url, StreamHandler<Result> streamHandler) {
        this.url = url;
        this.urlString = url.toString();
        this.streamHandler = streamHandler;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public void setUrl(URL url) {
        this.url = url;
        this.urlString = url.toString();
    }

    public void setRequestHeaders(Map<String, String> headers) {
        this.requestHeaders = headers;
    }

    public void addRequestHeader(String name, String value) {
        this.requestHeaders.put(name, value);
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public Result processInputStream() throws StreamException {
        return processInputStream(this.url.toString(), null);
    }

    public Result processInputStream(HttpEntity data) throws StreamException {
        return processInputStream(this.url.toString(), data);
    }

    public Result processInputStream(URL url, HttpEntity data) throws StreamException {
        return processInputStream(url.toString(), data);
    }

    public Result processInputStream(String url, HttpEntity data) throws StreamException {
        StreamException exception;
        Throwable e;
        StreamException exception2;
        Throwable th;
        StreamException e2;
        this.httpClient = new DefaultHttpClient(createHttpParams());
        setClientCookieStore();
        HttpResponse response = null;
        try {
            switch (this.streamHandler.getType()) {
                case GET_TYPE:
                    HttpGet request = new HttpGet(url);
                    addRequestHeaders(request);
                    response = this.httpClient.execute(request);
                    break;
                case PUT_TYPE:
                    HttpPut httpPut = new HttpPut(url);
                    if (data != null) {
                        httpPut.setEntity(data);
                    }
                    addRequestHeaders(httpPut);
                    response = this.httpClient.execute(httpPut);
                    break;
                case POST_TYPE:
                    HttpPost httpPost = new HttpPost(url);
                    if (data != null) {
                        httpPost.setEntity(data);
                    }
                    addRequestHeaders(httpPost);
                    response = this.httpClient.execute(httpPost);
                    break;
                case DELETE_TYPE:
                    HttpDelete httpDelete = new HttpDelete(url);
                    addRequestHeaders(httpDelete);
                    response = this.httpClient.execute(httpDelete);
                    break;
                default:
                    throw new StreamException("StreamProcessor.processInputStream. Invalid type");
            }
            if (response != null) {
                Header[] aHeaders = response.getHeaders("Content-Encoding");
                if (aHeaders.length > 0 && aHeaders[0].getValue().equals(SoundboardRunnable.ENC_TYPE)) {
                    this.streamHandler.setGZipEncoding(true);
                }
                HttpEntity entity;
                InputStream content;
                if (isValidResponseCode(response.getStatusLine().getStatusCode())) {
                    entity = response.getEntity();
                    if (entity != null) {
                        this.contentLength = entity.getContentLength();
                        content = entity.getContent();
                        if (content != null) {
                            Result processInputStream = this.streamHandler.processInputStream(new BufferedInputStream(content, defaultBufferSize), this.contentLength);
                            if (this.httpClient == null) {
                                return processInputStream;
                            }
                            this.httpClient.getConnectionManager().shutdown();
                            return processInputStream;
                        }
                    }
                }
                Logger.error((Object) this, "StreamProcessor.processInputStream. Problems with " + url + " Response: " + response.getStatusLine().getStatusCode());
                exception = new StreamException("StreamProcessor.processInputStream. Response: " + response.getStatusLine().getStatusCode());
                try {
                    exception.setResponseCode(getResponseCode(response));
                    exception.setResponseMessage(getResponseMessage(response));
                    entity = response.getEntity();
                    if (entity != null) {
                        this.contentLength = entity.getContentLength();
                        content = entity.getContent();
                        if (content != null) {
                            String errorResponse = parseResponse(new BufferedInputStream(content, defaultBufferSize));
                            Logger.error((Object) this, "StreamProcessor.processInputStream. Found Error Response: " + errorResponse);
                            exception.setResponseMessage(errorResponse);
                        }
                    }
                    exception.setExceptionType(0);
                    throw exception;
                } catch (MalformedURLException e3) {
                    e = e3;
                    try {
                        exception2 = new StreamException(e);
                        exception2.setExceptionType(2);
                        exception2.setResponseCode(getResponseCode(response));
                        exception2.setResponseMessage(getResponseMessage(response));
                        throw exception2;
                    } catch (Throwable th2) {
                        th = th2;
                        exception2 = exception;
                        if (this.httpClient != null) {
                            this.httpClient.getConnectionManager().shutdown();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    exception2 = new StreamException(e);
                    exception2.setExceptionType(3);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (SocketException e5) {
                    e = e5;
                    exception2 = new StreamException(e);
                    exception2.setExceptionType(4);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (SocketTimeoutException e6) {
                    e = e6;
                    exception2 = new StreamException(e);
                    exception2.setExceptionType(7);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (UnknownHostException e7) {
                    e = e7;
                    exception2 = new StreamException(e);
                    exception2.setExceptionType(5);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (IOException e8) {
                    e = e8;
                    exception2 = new StreamException(e);
                    exception2.setExceptionType(1);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (StreamException e9) {
                    e2 = e9;
                    exception2 = exception;
                    throw e2;
                } catch (Exception e10) {
                    e = e10;
                    exception2 = new StreamException(e);
                    exception2.setExceptionType(6);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                }
            }
            if (this.httpClient != null) {
                this.httpClient.getConnectionManager().shutdown();
            }
            return null;
        } catch (MalformedURLException e11) {
            e = e11;
            exception = null;
            exception2 = new StreamException(e);
            exception2.setExceptionType(2);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (FileNotFoundException e12) {
            e = e12;
            exception = null;
            exception2 = new StreamException(e);
            exception2.setExceptionType(3);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (SocketException e13) {
            e = e13;
            exception = null;
            exception2 = new StreamException(e);
            exception2.setExceptionType(4);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (SocketTimeoutException e14) {
            e = e14;
            exception = null;
            exception2 = new StreamException(e);
            exception2.setExceptionType(7);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (UnknownHostException e15) {
            e = e15;
            exception = null;
            exception2 = new StreamException(e);
            exception2.setExceptionType(5);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (IOException e16) {
            e = e16;
            exception = null;
            exception2 = new StreamException(e);
            exception2.setExceptionType(1);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (StreamException e17) {
            e2 = e17;
            throw e2;
        } catch (Exception e18) {
            e = e18;
            exception = null;
            exception2 = new StreamException(e);
            exception2.setExceptionType(6);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (Throwable th3) {
            th = th3;
            if (this.httpClient != null) {
                this.httpClient.getConnectionManager().shutdown();
            }
            throw th;
        }
    }

    private HttpParams createHttpParams() {
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(params, false);
        HttpConnectionParams.setConnectionTimeout(params, 20000);
        HttpConnectionParams.setSoTimeout(params, 30000);
        HttpConnectionParams.setSocketBufferSize(params, this.bufferLength);
        HttpClientParams.setRedirecting(params, true);
        return params;
    }

    public CookieStore getCookieStore() {
        if (this.httpClient == null) {
            return null;
        }
        return this.httpClient.getCookieStore();
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }

    protected void setClientCookieStore() {
        if (this.cookieStore != null && this.httpClient != null) {
            this.httpClient.setCookieStore(this.cookieStore);
        }
    }

    public void copyStream(OutputStream stream) throws StreamException {
        MalformedURLException e;
        StreamException exception;
        StreamException exception2;
        Throwable th;
        FileNotFoundException e2;
        SocketException e3;
        SocketTimeoutException e4;
        UnknownHostException e5;
        ClientProtocolException e6;
        IOException e7;
        StreamException e8;
        Exception e9;
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        this.streamHandler.setStreamProcessor(this);
        HttpResponse response = null;
        try {
            this.httpClient = new DefaultHttpClient(createHttpParams());
            setClientCookieStore();
            HttpGet request = new HttpGet(this.urlString);
            addRequestHeaders(request);
            response = this.httpClient.execute(request);
            if (response != null) {
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        this.contentLength = entity.getContentLength();
                        InputStream content = entity.getContent();
                        if (content != null) {
                            BufferedInputStream inputStream2 = new BufferedInputStream(content, this.bufferLength);
                            try {
                                BufferedOutputStream outputStream2 = new BufferedOutputStream(stream, this.bufferLength);
                                try {
                                    byte[] buffer = new byte[this.bufferLength];
                                    for (int read = inputStream2.read(buffer); read > 0; read = inputStream2.read(buffer)) {
                                        outputStream2.write(buffer, 0, read);
                                    }
                                    outputStream2.flush();
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                } catch (MalformedURLException e10) {
                                    e = e10;
                                    exception = null;
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                    try {
                                        exception2 = new StreamException(e.getMessage(), e);
                                        exception2.setExceptionType(2);
                                        exception2.setResponseCode(getResponseCode(response));
                                        exception2.setResponseMessage(getResponseMessage(response));
                                        throw exception2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        exception2 = exception;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Throwable e11) {
                                                Logger.error((Object) "StreamProcessor.startStream. Could not close input stream", e11);
                                            }
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Throwable e112) {
                                                Logger.error((Object) "StreamProcessor.startStream. Could not close output stream", e112);
                                            }
                                        }
                                        if (this.httpClient != null) {
                                            this.httpClient.getConnectionManager().shutdown();
                                        }
                                        throw th;
                                    }
                                } catch (FileNotFoundException e12) {
                                    e2 = e12;
                                    exception = null;
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                    exception2 = new StreamException(e2.getMessage(), e2);
                                    exception2.setExceptionType(3);
                                    exception2.setResponseCode(getResponseCode(response));
                                    exception2.setResponseMessage(getResponseMessage(response));
                                    throw exception2;
                                } catch (SocketException e13) {
                                    e3 = e13;
                                    exception = null;
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                    exception2 = new StreamException(e3.getMessage(), e3);
                                    exception2.setExceptionType(4);
                                    exception2.setResponseCode(getResponseCode(response));
                                    exception2.setResponseMessage(getResponseMessage(response));
                                    throw exception2;
                                } catch (SocketTimeoutException e14) {
                                    e4 = e14;
                                    exception = null;
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                    exception2 = new StreamException(e4.getMessage(), e4);
                                    exception2.setExceptionType(7);
                                    exception2.setResponseCode(getResponseCode(response));
                                    exception2.setResponseMessage(getResponseMessage(response));
                                    throw exception2;
                                } catch (UnknownHostException e15) {
                                    e5 = e15;
                                    exception = null;
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                    exception2 = new StreamException(e5.getMessage(), e5);
                                    exception2.setExceptionType(5);
                                    exception2.setResponseCode(getResponseCode(response));
                                    exception2.setResponseMessage(getResponseMessage(response));
                                    throw exception2;
                                } catch (ClientProtocolException e16) {
                                    e6 = e16;
                                    exception = null;
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                    exception2 = new StreamException(e6.getMessage(), e6);
                                    exception2.setExceptionType(8);
                                    exception2.setResponseCode(getResponseCode(response));
                                    exception2.setResponseMessage(getResponseMessage(response));
                                    throw exception2;
                                } catch (IOException e17) {
                                    e7 = e17;
                                    exception = null;
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                    exception2 = new StreamException(e7.getMessage(), e7);
                                    exception2.setExceptionType(1);
                                    exception2.setResponseCode(getResponseCode(response));
                                    exception2.setResponseMessage(getResponseMessage(response));
                                    throw exception2;
                                } catch (StreamException e18) {
                                    e8 = e18;
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                    throw e8;
                                } catch (Exception e19) {
                                    e9 = e19;
                                    exception = null;
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                    exception2 = new StreamException(e9.getMessage(), e9);
                                    exception2.setExceptionType(6);
                                    exception2.setResponseCode(getResponseCode(response));
                                    exception2.setResponseMessage(getResponseMessage(response));
                                    throw exception2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    outputStream = outputStream2;
                                    inputStream = inputStream2;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    if (this.httpClient != null) {
                                        this.httpClient.getConnectionManager().shutdown();
                                    }
                                    throw th;
                                }
                            } catch (MalformedURLException e20) {
                                e = e20;
                                exception = null;
                                inputStream = inputStream2;
                                exception2 = new StreamException(e.getMessage(), e);
                                exception2.setExceptionType(2);
                                exception2.setResponseCode(getResponseCode(response));
                                exception2.setResponseMessage(getResponseMessage(response));
                                throw exception2;
                            } catch (FileNotFoundException e21) {
                                e2 = e21;
                                exception = null;
                                inputStream = inputStream2;
                                exception2 = new StreamException(e2.getMessage(), e2);
                                exception2.setExceptionType(3);
                                exception2.setResponseCode(getResponseCode(response));
                                exception2.setResponseMessage(getResponseMessage(response));
                                throw exception2;
                            } catch (SocketException e22) {
                                e3 = e22;
                                exception = null;
                                inputStream = inputStream2;
                                exception2 = new StreamException(e3.getMessage(), e3);
                                exception2.setExceptionType(4);
                                exception2.setResponseCode(getResponseCode(response));
                                exception2.setResponseMessage(getResponseMessage(response));
                                throw exception2;
                            } catch (SocketTimeoutException e23) {
                                e4 = e23;
                                exception = null;
                                inputStream = inputStream2;
                                exception2 = new StreamException(e4.getMessage(), e4);
                                exception2.setExceptionType(7);
                                exception2.setResponseCode(getResponseCode(response));
                                exception2.setResponseMessage(getResponseMessage(response));
                                throw exception2;
                            } catch (UnknownHostException e24) {
                                e5 = e24;
                                exception = null;
                                inputStream = inputStream2;
                                exception2 = new StreamException(e5.getMessage(), e5);
                                exception2.setExceptionType(5);
                                exception2.setResponseCode(getResponseCode(response));
                                exception2.setResponseMessage(getResponseMessage(response));
                                throw exception2;
                            } catch (ClientProtocolException e25) {
                                e6 = e25;
                                exception = null;
                                inputStream = inputStream2;
                                exception2 = new StreamException(e6.getMessage(), e6);
                                exception2.setExceptionType(8);
                                exception2.setResponseCode(getResponseCode(response));
                                exception2.setResponseMessage(getResponseMessage(response));
                                throw exception2;
                            } catch (IOException e26) {
                                e7 = e26;
                                exception = null;
                                inputStream = inputStream2;
                                exception2 = new StreamException(e7.getMessage(), e7);
                                exception2.setExceptionType(1);
                                exception2.setResponseCode(getResponseCode(response));
                                exception2.setResponseMessage(getResponseMessage(response));
                                throw exception2;
                            } catch (StreamException e27) {
                                e8 = e27;
                                inputStream = inputStream2;
                                throw e8;
                            } catch (Exception e28) {
                                e9 = e28;
                                exception = null;
                                inputStream = inputStream2;
                                exception2 = new StreamException(e9.getMessage(), e9);
                                exception2.setExceptionType(6);
                                exception2.setResponseCode(getResponseCode(response));
                                exception2.setResponseMessage(getResponseMessage(response));
                                throw exception2;
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (this.httpClient != null) {
                                    this.httpClient.getConnectionManager().shutdown();
                                }
                                throw th;
                            }
                        }
                    }
                }
                Logger.error((Object) this, "StreamProcessor.processInputStream. Response: " + response.getStatusLine().getStatusCode());
                exception = new StreamException("StreamProcessor.processInputStream. Response: " + response.getStatusLine().getStatusCode());
                try {
                    exception.setResponseCode(getResponseCode(response));
                    exception.setResponseMessage(getResponseMessage(response));
                    exception.setExceptionType(0);
                    throw exception;
                } catch (MalformedURLException e29) {
                    e = e29;
                    exception2 = new StreamException(e.getMessage(), e);
                    exception2.setExceptionType(2);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (FileNotFoundException e30) {
                    e2 = e30;
                    exception2 = new StreamException(e2.getMessage(), e2);
                    exception2.setExceptionType(3);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (SocketException e31) {
                    e3 = e31;
                    exception2 = new StreamException(e3.getMessage(), e3);
                    exception2.setExceptionType(4);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (SocketTimeoutException e32) {
                    e4 = e32;
                    exception2 = new StreamException(e4.getMessage(), e4);
                    exception2.setExceptionType(7);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (UnknownHostException e33) {
                    e5 = e33;
                    exception2 = new StreamException(e5.getMessage(), e5);
                    exception2.setExceptionType(5);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (ClientProtocolException e34) {
                    e6 = e34;
                    exception2 = new StreamException(e6.getMessage(), e6);
                    exception2.setExceptionType(8);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (IOException e35) {
                    e7 = e35;
                    exception2 = new StreamException(e7.getMessage(), e7);
                    exception2.setExceptionType(1);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                } catch (StreamException e36) {
                    e8 = e36;
                    exception2 = exception;
                    throw e8;
                } catch (Exception e37) {
                    e9 = e37;
                    exception2 = new StreamException(e9.getMessage(), e9);
                    exception2.setExceptionType(6);
                    exception2.setResponseCode(getResponseCode(response));
                    exception2.setResponseMessage(getResponseMessage(response));
                    throw exception2;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e1122) {
                    Logger.error((Object) "StreamProcessor.startStream. Could not close input stream", e1122);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e11222) {
                    Logger.error((Object) "StreamProcessor.startStream. Could not close output stream", e11222);
                }
            }
            if (this.httpClient != null) {
                this.httpClient.getConnectionManager().shutdown();
            }
        } catch (MalformedURLException e38) {
            e = e38;
            exception = null;
            exception2 = new StreamException(e.getMessage(), e);
            exception2.setExceptionType(2);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (FileNotFoundException e39) {
            e2 = e39;
            exception = null;
            exception2 = new StreamException(e2.getMessage(), e2);
            exception2.setExceptionType(3);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (SocketException e40) {
            e3 = e40;
            exception = null;
            exception2 = new StreamException(e3.getMessage(), e3);
            exception2.setExceptionType(4);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (SocketTimeoutException e41) {
            e4 = e41;
            exception = null;
            exception2 = new StreamException(e4.getMessage(), e4);
            exception2.setExceptionType(7);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (UnknownHostException e42) {
            e5 = e42;
            exception = null;
            exception2 = new StreamException(e5.getMessage(), e5);
            exception2.setExceptionType(5);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (ClientProtocolException e43) {
            e6 = e43;
            exception = null;
            exception2 = new StreamException(e6.getMessage(), e6);
            exception2.setExceptionType(8);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (IOException e44) {
            e7 = e44;
            exception = null;
            exception2 = new StreamException(e7.getMessage(), e7);
            exception2.setExceptionType(1);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (StreamException e45) {
            e8 = e45;
            throw e8;
        } catch (Exception e46) {
            e9 = e46;
            exception = null;
            exception2 = new StreamException(e9.getMessage(), e9);
            exception2.setExceptionType(6);
            exception2.setResponseCode(getResponseCode(response));
            exception2.setResponseMessage(getResponseMessage(response));
            throw exception2;
        } catch (Throwable th5) {
            th = th5;
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (this.httpClient != null) {
                this.httpClient.getConnectionManager().shutdown();
            }
            throw th;
        }
    }

    protected void addRequestHeaders(AbstractHttpMessage message) {
        for (String name : this.requestHeaders.keySet()) {
            message.addHeader(name, (String) this.requestHeaders.get(name));
        }
    }

    public long getContentLength() {
        if (this.connection != null) {
            return (long) this.connection.getContentLength();
        }
        if (this.httpClient != null) {
            return this.contentLength;
        }
        return 0;
    }

    public void setBufferLength(int bufferLength) {
        this.bufferLength = bufferLength;
    }

    public InputStream getErrorStream() {
        return this.connection.getErrorStream();
    }

    public int getResponseCode() throws StreamException {
        if (this.connection == null) {
            return -1;
        }
        try {
            return this.connection.getResponseCode();
        } catch (IOException e) {
            throw new StreamException("StreamProcessor.getResponseCode.", e);
        }
    }

    public String getResponseMessage() throws StreamException {
        if (this.connection == null) {
            return null;
        }
        try {
            return this.connection.getResponseMessage();
        } catch (IOException e) {
            throw new StreamException("StreamProcessor.getResponseMessage.", e);
        }
    }

    public String getResponseMessage(HttpResponse response) throws StreamException {
        if (response == null) {
            return null;
        }
        StatusLine statusLine = response.getStatusLine();
        if (statusLine != null) {
            return statusLine.getReasonPhrase();
        }
        return null;
    }

    public int getResponseCode(HttpResponse response) {
        if (response == null) {
            return -1;
        }
        StatusLine statusLine = response.getStatusLine();
        if (statusLine != null) {
            return statusLine.getStatusCode();
        }
        return -1;
    }

    public boolean isValidResponseCode(int code) {
        if (code < 200 || code >= 300) {
            return false;
        }
        return true;
    }

    private void setupConnection(HttpURLConnection connection) throws StreamException {
        try {
            switch (this.streamHandler.getType()) {
                case GET_TYPE:
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.setDoOutput(false);
                    break;
                case PUT_TYPE:
                    connection.setRequestMethod("PUT");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    break;
                case POST_TYPE:
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    break;
                case DELETE_TYPE:
                    connection.setRequestMethod("DELETE");
                    connection.setDoInput(true);
                    connection.setDoOutput(false);
                    break;
                default:
                    throw new StreamException("StreamProcessor.setupConnection. Invalid type");
            }
            this.streamHandler.setupConnection(connection);
        } catch (ProtocolException e) {
            throw new StreamException("StreamProcessor.setupConnection", e);
        }
    }

    public static String parseResponse(InputStream is) {
        if (is == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        try {
            byte[] aBuffer = new byte[defaultBufferSize];
            while (true) {
                int aCount = is.read(aBuffer, 0, defaultBufferSize);
                if (aCount == -1) {
                    return builder.toString();
                }
                builder.append(new String(aBuffer, 0, aCount));
            }
        } catch (Exception e) {
            Logger.error(StreamProcessor.class, "Problems reading response", e);
            return "";
        }
    }
}
