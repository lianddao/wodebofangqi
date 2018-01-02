package com.ushareit.listenit;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

public class ve extends vj<ParcelFileDescriptor> {
    protected /* synthetic */ Object mo3106b(Uri uri, ContentResolver contentResolver) {
        return m26690a(uri, contentResolver);
    }

    public ve(Context context, Uri uri) {
        super(context, uri);
    }

    protected ParcelFileDescriptor m26690a(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }

    protected void m26691a(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }
}
