package com.ushareit.listenit;

import android.os.AsyncTask;
import com.mopub.common.CacheService;
import com.mopub.common.CacheService.DiskLruCacheGetListener;

public class egg extends AsyncTask<Void, Void, byte[]> {
    private final DiskLruCacheGetListener f11031a;
    private final String f11032b;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m17056a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m17055a((byte[]) obj);
    }

    public egg(String str, DiskLruCacheGetListener diskLruCacheGetListener) {
        this.f11031a = diskLruCacheGetListener;
        this.f11032b = str;
    }

    protected byte[] m17056a(Void... voidArr) {
        return CacheService.getFromDiskCache(this.f11032b);
    }

    protected void m17055a(byte[] bArr) {
        if (isCancelled()) {
            onCancelled();
        } else if (this.f11031a != null) {
            this.f11031a.onComplete(this.f11032b, bArr);
        }
    }

    protected void onCancelled() {
        if (this.f11031a != null) {
            this.f11031a.onComplete(this.f11032b, null);
        }
    }
}
