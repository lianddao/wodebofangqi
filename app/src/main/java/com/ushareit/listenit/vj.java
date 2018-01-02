package com.ushareit.listenit;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

public abstract class vj<T> implements vc<T> {
    private final Uri f17030a;
    private final Context f17031b;
    private T f17032c;

    protected abstract void mo3105a(T t);

    protected abstract T mo3106b(Uri uri, ContentResolver contentResolver);

    public vj(Context context, Uri uri) {
        this.f17031b = context.getApplicationContext();
        this.f17030a = uri;
    }

    public final T mo584a(tv tvVar) {
        this.f17032c = mo3106b(this.f17030a, this.f17031b.getContentResolver());
        return this.f17032c;
    }

    public void mo585a() {
        if (this.f17032c != null) {
            try {
                mo3105a(this.f17032c);
            } catch (Throwable e) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e);
                }
            }
        }
    }

    public void mo587c() {
    }

    public String mo586b() {
        return this.f17030a.toString();
    }
}
