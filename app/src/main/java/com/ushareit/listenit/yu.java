package com.ushareit.listenit;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;

class yu implements vc<yv> {
    private final vc<InputStream> f17586a;
    private final vc<ParcelFileDescriptor> f17587b;

    public /* synthetic */ Object mo584a(tv tvVar) {
        return m27262b(tvVar);
    }

    public yu(vc<InputStream> vcVar, vc<ParcelFileDescriptor> vcVar2) {
        this.f17586a = vcVar;
        this.f17587b = vcVar2;
    }

    public yv m27262b(tv tvVar) {
        InputStream inputStream;
        ParcelFileDescriptor parcelFileDescriptor = null;
        if (this.f17586a != null) {
            try {
                inputStream = (InputStream) this.f17586a.mo584a(tvVar);
            } catch (Throwable e) {
                if (Log.isLoggable("IVML", 2)) {
                    Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", e);
                }
                if (this.f17587b == null) {
                    throw e;
                }
            }
            if (this.f17587b != null) {
                try {
                    parcelFileDescriptor = (ParcelFileDescriptor) this.f17587b.mo584a(tvVar);
                } catch (Throwable e2) {
                    if (Log.isLoggable("IVML", 2)) {
                        Log.v("IVML", "Exception fetching ParcelFileDescriptor", e2);
                    }
                    if (inputStream == null) {
                        throw e2;
                    }
                }
            }
            return new yv(inputStream, parcelFileDescriptor);
        }
        inputStream = null;
        if (this.f17587b != null) {
            parcelFileDescriptor = (ParcelFileDescriptor) this.f17587b.mo584a(tvVar);
        }
        return new yv(inputStream, parcelFileDescriptor);
    }

    public void mo585a() {
        if (this.f17586a != null) {
            this.f17586a.mo585a();
        }
        if (this.f17587b != null) {
            this.f17587b.mo585a();
        }
    }

    public String mo586b() {
        if (this.f17586a != null) {
            return this.f17586a.mo586b();
        }
        return this.f17587b.mo586b();
    }

    public void mo587c() {
        if (this.f17586a != null) {
            this.f17586a.mo587c();
        }
        if (this.f17587b != null) {
            this.f17587b.mo587c();
        }
    }
}
