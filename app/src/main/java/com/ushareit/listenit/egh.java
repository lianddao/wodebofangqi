package com.ushareit.listenit;

import android.os.AsyncTask;
import com.mopub.common.CacheService;

public class egh extends AsyncTask<Void, Void, Void> {
    private final String f11033a;
    private final byte[] f11034b;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m17057a((Void[]) objArr);
    }

    public egh(String str, byte[] bArr) {
        this.f11033a = str;
        this.f11034b = bArr;
    }

    protected Void m17057a(Void... voidArr) {
        CacheService.putToDiskCache(this.f11033a, this.f11034b);
        return null;
    }
}
