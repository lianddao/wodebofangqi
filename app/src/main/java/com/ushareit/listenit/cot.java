package com.ushareit.listenit;

class cot implements cok {
    final /* synthetic */ long f8597a;
    final /* synthetic */ cos f8598b;

    cot(cos com_ushareit_listenit_cos, long j) {
        this.f8598b = com_ushareit_listenit_cos;
        this.f8597a = j;
    }

    public void mo1537a(String str) {
        if (this.f8597a != this.f8598b.f8596b.f8593y) {
            this.f8598b.f8596b.f8590v.m13093a("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
        } else if (this.f8598b.f8596b.f8578j == cpb.GettingToken) {
            this.f8598b.f8596b.f8590v.m13093a("Successfully fetched token, opening connection", new Object[0]);
            this.f8598b.f8596b.m12142g(str);
        } else {
            com.m12035a(this.f8598b.f8596b.f8578j == cpb.Disconnected, "Expected connection state disconnected, but was %s", this.f8598b.f8596b.f8578j);
            this.f8598b.f8596b.f8590v.m13093a("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
        }
    }

    public void mo1538b(String str) {
        if (this.f8597a == this.f8598b.f8596b.f8593y) {
            this.f8598b.f8596b.f8578j = cpb.Disconnected;
            cvy a = this.f8598b.f8596b.f8590v;
            String str2 = "Error fetching token: ";
            String valueOf = String.valueOf(str);
            a.m13093a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
            this.f8598b.f8596b.m12099h();
            return;
        }
        this.f8598b.f8596b.f8590v.m13093a("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
    }
}
