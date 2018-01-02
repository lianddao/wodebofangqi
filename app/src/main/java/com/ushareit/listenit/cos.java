package com.ushareit.listenit;

class cos implements Runnable {
    final /* synthetic */ boolean f8595a;
    final /* synthetic */ cor f8596b;

    cos(cor com_ushareit_listenit_cor, boolean z) {
        this.f8596b = com_ushareit_listenit_cor;
        this.f8595a = z;
    }

    public void run() {
        this.f8596b.f8590v.m13093a("Trying to fetch auth token", new Object[0]);
        com.m12035a(this.f8596b.f8578j == cpb.Disconnected, "Not in disconnected state: %s", this.f8596b.f8578j);
        this.f8596b.f8578j = cpb.GettingToken;
        this.f8596b.f8593y = 1 + this.f8596b.f8593y;
        this.f8596b.f8588t.mo1547a(this.f8595a, new cot(this, this.f8596b.f8593y));
    }
}
