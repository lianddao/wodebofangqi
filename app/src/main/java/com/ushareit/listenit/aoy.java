package com.ushareit.listenit;

import android.os.AsyncTask;

class aoy extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ aox f5123a;

    aoy(aox com_ushareit_listenit_aox) {
        this.f5123a = com_ushareit_listenit_aox;
    }

    protected Void m6520a(Void... voidArr) {
        aow.m6512b(this.f5123a.f5122a);
        if (this.f5123a.f5122a.f5121m > 0) {
            try {
                Thread.sleep(this.f5123a.f5122a.f5121m);
            } catch (InterruptedException e) {
            }
        }
        this.f5123a.f5122a.m6515d();
        return null;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m6520a((Void[]) objArr);
    }
}
