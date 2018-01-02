package com.ushareit.listenit;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.volley.DefaultRetryPolicy;

public abstract class ik {
    private final DataSetObservable f5885a = new DataSetObservable();
    private DataSetObserver f5886b;

    public abstract boolean mo841a(View view, Object obj);

    public abstract int mo2352b();

    public void mo839a(ViewGroup viewGroup) {
        m7651a((View) viewGroup);
    }

    public Object mo837a(ViewGroup viewGroup, int i) {
        return m7647a((View) viewGroup, i);
    }

    public void mo840a(ViewGroup viewGroup, int i, Object obj) {
        m7652a((View) viewGroup, i, obj);
    }

    public void mo843b(ViewGroup viewGroup, int i, Object obj) {
        m7659b((View) viewGroup, i, obj);
    }

    public void mo842b(ViewGroup viewGroup) {
        m7658b((View) viewGroup);
    }

    @Deprecated
    public void m7651a(View view) {
    }

    @Deprecated
    public Object m7647a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void m7652a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    @Deprecated
    public void m7659b(View view, int i, Object obj) {
    }

    @Deprecated
    public void m7658b(View view) {
    }

    public Parcelable mo836a() {
        return null;
    }

    public void mo838a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int mo2350a(Object obj) {
        return -1;
    }

    public void m7663c() {
        synchronized (this) {
            if (this.f5886b != null) {
                this.f5886b.onChanged();
            }
        }
        this.f5885a.notifyChanged();
    }

    public void m7649a(DataSetObserver dataSetObserver) {
        this.f5885a.registerObserver(dataSetObserver);
    }

    public void m7657b(DataSetObserver dataSetObserver) {
        this.f5885a.unregisterObserver(dataSetObserver);
    }

    public void m7664c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f5886b = dataSetObserver;
        }
    }

    public CharSequence m7662c(int i) {
        return null;
    }

    public float m7665d(int i) {
        return DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    }
}
