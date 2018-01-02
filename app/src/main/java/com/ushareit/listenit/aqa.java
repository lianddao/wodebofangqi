package com.ushareit.listenit;

import android.os.AsyncTask;

public class aqa extends AsyncTask<aqe, Void, aqg> implements apv {
    private aps f5168a;
    private apu f5169b;
    private Exception f5170c;

    public aqa(aps com_ushareit_listenit_aps, apu com_ushareit_listenit_apu) {
        this.f5168a = com_ushareit_listenit_aps;
        this.f5169b = com_ushareit_listenit_apu;
    }

    protected aqg m6765a(aqe... com_ushareit_listenit_aqeArr) {
        if (com_ushareit_listenit_aqeArr != null) {
            try {
                if (com_ushareit_listenit_aqeArr.length > 0) {
                    return this.f5168a.m6720a(com_ushareit_listenit_aqeArr[0]);
                }
            } catch (Exception e) {
                this.f5170c = e;
                cancel(true);
                return null;
            }
        }
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    public void mo776a(aqe com_ushareit_listenit_aqe) {
        super.execute(new aqe[]{com_ushareit_listenit_aqe});
    }

    protected void m6767a(aqg com_ushareit_listenit_aqg) {
        this.f5169b.mo792a(com_ushareit_listenit_aqg);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m6765a((aqe[]) objArr);
    }

    protected void onCancelled() {
        this.f5169b.mo793a(this.f5170c);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m6767a((aqg) obj);
    }
}
