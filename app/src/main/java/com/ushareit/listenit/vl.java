package com.ushareit.listenit;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

public class vl extends vj<InputStream> {
    protected /* synthetic */ Object mo3106b(Uri uri, ContentResolver contentResolver) {
        return m26707a(uri, contentResolver);
    }

    public vl(Context context, Uri uri) {
        super(context, uri);
    }

    protected InputStream m26707a(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openInputStream(uri);
    }

    protected void m26708a(InputStream inputStream) {
        inputStream.close();
    }
}
