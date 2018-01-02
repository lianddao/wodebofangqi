package com.ushareit.listenit;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.Map;

@VisibleForTesting
public class els extends AsyncTask<String, Void, Boolean> {
    private final Context f11222a;
    private final elt f11223b;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m17160a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m17161a((Boolean) obj);
    }

    public els(Context context, elt com_ushareit_listenit_elt) {
        this.f11222a = context.getApplicationContext();
        this.f11223b = com_ushareit_listenit_elt;
    }

    protected Boolean m17160a(String[] strArr) {
        Closeable bufferedInputStream;
        Closeable fileOutputStream;
        Boolean valueOf;
        Throwable th;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return Boolean.valueOf(false);
        }
        File a = m17157a();
        a.mkdirs();
        String str = strArr[0];
        URI create = URI.create(str);
        try {
            File file;
            HttpURLConnection httpUrlConnection = MoPubHttpUrlConnection.getHttpUrlConnection(str);
            bufferedInputStream = new BufferedInputStream(httpUrlConnection.getInputStream());
            try {
                Object headerField = httpUrlConnection.getHeaderField(ResponseHeader.LOCATION.getKey());
                if (!TextUtils.isEmpty(headerField)) {
                    create = URI.create(headerField);
                }
                file = new File(a, m17158a(create, httpUrlConnection.getHeaderFields()));
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                fileOutputStream = null;
                try {
                    valueOf = Boolean.valueOf(false);
                    Streams.closeStream(bufferedInputStream);
                    Streams.closeStream(fileOutputStream);
                    return valueOf;
                } catch (Throwable th2) {
                    th = th2;
                    Streams.closeStream(bufferedInputStream);
                    Streams.closeStream(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileOutputStream = null;
                th = th4;
                Streams.closeStream(bufferedInputStream);
                Streams.closeStream(fileOutputStream);
                throw th;
            }
            try {
                Streams.copyContent(bufferedInputStream, fileOutputStream);
                m17159a(file.toString());
                valueOf = Boolean.valueOf(true);
                Streams.closeStream(bufferedInputStream);
                Streams.closeStream(fileOutputStream);
                return valueOf;
            } catch (Exception e2) {
                valueOf = Boolean.valueOf(false);
                Streams.closeStream(bufferedInputStream);
                Streams.closeStream(fileOutputStream);
                return valueOf;
            }
        } catch (Exception e3) {
            fileOutputStream = null;
            bufferedInputStream = null;
            valueOf = Boolean.valueOf(false);
            Streams.closeStream(bufferedInputStream);
            Streams.closeStream(fileOutputStream);
            return valueOf;
        } catch (Throwable th32) {
            bufferedInputStream = null;
            th = th32;
            fileOutputStream = null;
            Streams.closeStream(bufferedInputStream);
            Streams.closeStream(fileOutputStream);
            throw th;
        }
    }

    protected void m17161a(Boolean bool) {
        if (bool == null || !bool.booleanValue()) {
            this.f11223b.onFailure();
        } else {
            this.f11223b.onSuccess();
        }
    }

    private String m17158a(URI uri, Map<String, List<String>> map) {
        Preconditions.checkNotNull(uri);
        String path = uri.getPath();
        if (path == null || map == null) {
            return null;
        }
        String name = new File(path).getName();
        List list = (List) map.get("Content-Type");
        if (list == null || list.isEmpty() || list.get(0) == null) {
            return name;
        }
        for (String str : ((String) list.get(0)).split(";")) {
            if (str.contains("image/")) {
                path = "." + str.split("/")[1];
                if (!name.endsWith(path)) {
                    return name + path;
                }
                return name;
            }
        }
        return name;
    }

    private File m17157a() {
        return new File(Environment.getExternalStorageDirectory(), "Pictures");
    }

    private void m17159a(String str) {
        Object com_ushareit_listenit_elu = new elu(str, null);
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(this.f11222a, com_ushareit_listenit_elu);
        com_ushareit_listenit_elu.m17162a(mediaScannerConnection);
        mediaScannerConnection.connect();
    }
}
