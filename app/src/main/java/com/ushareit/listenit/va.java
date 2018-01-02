package com.ushareit.listenit;

import android.content.res.AssetManager;
import android.util.Log;

public abstract class va<T> implements vc<T> {
    private final String f17025a;
    private final AssetManager f17026b;
    private T f17027c;

    protected abstract T mo3103a(AssetManager assetManager, String str);

    protected abstract void mo3104a(T t);

    public va(AssetManager assetManager, String str) {
        this.f17026b = assetManager;
        this.f17025a = str;
    }

    public T mo584a(tv tvVar) {
        this.f17027c = mo3103a(this.f17026b, this.f17025a);
        return this.f17027c;
    }

    public void mo585a() {
        if (this.f17027c != null) {
            try {
                mo3104a(this.f17027c);
            } catch (Throwable e) {
                if (Log.isLoggable("AssetUriFetcher", 2)) {
                    Log.v("AssetUriFetcher", "Failed to close data", e);
                }
            }
        }
    }

    public String mo586b() {
        return this.f17025a;
    }

    public void mo587c() {
    }
}
