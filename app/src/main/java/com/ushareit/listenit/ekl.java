package com.ushareit.listenit;

import android.os.AsyncTask;
import com.mopub.common.CacheService;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Streams;
import com.mopub.mobileads.VideoDownloader;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;

@VisibleForTesting
public class ekl extends AsyncTask<String, Void, Boolean> {
    private final ekk f11180a;
    private final WeakReference<ekl> f11181b = new WeakReference(this);

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m17142a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m17143a((Boolean) obj);
    }

    @VisibleForTesting
    public ekl(ekk com_ushareit_listenit_ekk) {
        this.f11180a = com_ushareit_listenit_ekk;
        VideoDownloader.f2523a.add(this.f11181b);
    }

    protected Boolean m17142a(String... strArr) {
        HttpURLConnection httpUrlConnection;
        Closeable bufferedInputStream;
        Throwable e;
        HttpURLConnection httpURLConnection = null;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            MoPubLog.m2753d("VideoDownloader task tried to execute null or empty url.");
            return Boolean.valueOf(false);
        }
        String str = strArr[0];
        Boolean valueOf;
        try {
            httpUrlConnection = MoPubHttpUrlConnection.getHttpUrlConnection(str);
            try {
                bufferedInputStream = new BufferedInputStream(httpUrlConnection.getInputStream());
                try {
                    int responseCode = httpUrlConnection.getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        MoPubLog.m2753d("VideoDownloader encountered unexpected statusCode: " + responseCode);
                        valueOf = Boolean.valueOf(false);
                        Streams.closeStream(bufferedInputStream);
                        if (httpUrlConnection == null) {
                            return valueOf;
                        }
                        httpUrlConnection.disconnect();
                        return valueOf;
                    }
                    if (httpUrlConnection.getContentLength() > 26214400) {
                        MoPubLog.m2753d(String.format("VideoDownloader encountered video larger than disk cap. (%d bytes / %d maximum).", new Object[]{Integer.valueOf(httpUrlConnection.getContentLength()), Integer.valueOf(26214400)}));
                        valueOf = Boolean.valueOf(false);
                        Streams.closeStream(bufferedInputStream);
                        if (httpUrlConnection == null) {
                            return valueOf;
                        }
                        httpUrlConnection.disconnect();
                        return valueOf;
                    }
                    valueOf = Boolean.valueOf(CacheService.putToDiskCache(str, (InputStream) bufferedInputStream));
                    Streams.closeStream(bufferedInputStream);
                    if (httpUrlConnection == null) {
                        return valueOf;
                    }
                    httpUrlConnection.disconnect();
                    return valueOf;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpUrlConnection;
                    try {
                        MoPubLog.m2754d("VideoDownloader task threw an internal exception.", e);
                        valueOf = Boolean.valueOf(false);
                        Streams.closeStream(bufferedInputStream);
                        if (httpURLConnection != null) {
                            return valueOf;
                        }
                        httpURLConnection.disconnect();
                        return valueOf;
                    } catch (Throwable th) {
                        e = th;
                        httpUrlConnection = httpURLConnection;
                        Streams.closeStream(bufferedInputStream);
                        if (httpUrlConnection != null) {
                            httpUrlConnection.disconnect();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    Streams.closeStream(bufferedInputStream);
                    if (httpUrlConnection != null) {
                        httpUrlConnection.disconnect();
                    }
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
                httpURLConnection = httpUrlConnection;
                MoPubLog.m2754d("VideoDownloader task threw an internal exception.", e);
                valueOf = Boolean.valueOf(false);
                Streams.closeStream(bufferedInputStream);
                if (httpURLConnection != null) {
                    return valueOf;
                }
                httpURLConnection.disconnect();
                return valueOf;
            } catch (Throwable th3) {
                e = th3;
                bufferedInputStream = null;
                Streams.closeStream(bufferedInputStream);
                if (httpUrlConnection != null) {
                    httpUrlConnection.disconnect();
                }
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedInputStream = null;
            MoPubLog.m2754d("VideoDownloader task threw an internal exception.", e);
            valueOf = Boolean.valueOf(false);
            Streams.closeStream(bufferedInputStream);
            if (httpURLConnection != null) {
                return valueOf;
            }
            httpURLConnection.disconnect();
            return valueOf;
        } catch (Throwable th4) {
            e = th4;
            bufferedInputStream = null;
            httpUrlConnection = null;
            Streams.closeStream(bufferedInputStream);
            if (httpUrlConnection != null) {
                httpUrlConnection.disconnect();
            }
            throw e;
        }
    }

    protected void m17143a(Boolean bool) {
        if (isCancelled()) {
            onCancelled();
            return;
        }
        VideoDownloader.f2523a.remove(this.f11181b);
        if (bool == null) {
            this.f11180a.onComplete(false);
        } else {
            this.f11180a.onComplete(bool.booleanValue());
        }
    }

    protected void onCancelled() {
        MoPubLog.m2753d("VideoDownloader task was cancelled.");
        VideoDownloader.f2523a.remove(this.f11181b);
        this.f11180a.onComplete(false);
    }
}
