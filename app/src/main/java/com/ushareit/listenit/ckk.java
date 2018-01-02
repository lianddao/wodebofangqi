package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;

public abstract class ckk<T> {
    private final String f7865a;
    private T f7866b;

    protected ckk(String str) {
        this.f7865a = str;
    }

    protected final T m10057b(Context context) {
        if (this.f7866b == null) {
            cfi.m11080a((Object) context);
            Context remoteContext = cjj.getRemoteContext(context);
            if (remoteContext == null) {
                throw new ckl("Could not get remote context.");
            }
            try {
                this.f7866b = mo1119b((IBinder) remoteContext.getClassLoader().loadClass(this.f7865a).newInstance());
            } catch (Throwable e) {
                throw new ckl("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new ckl("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new ckl("Could not access creator.", e22);
            }
        }
        return this.f7866b;
    }

    protected abstract T mo1119b(IBinder iBinder);
}
