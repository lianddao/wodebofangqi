package com.ushareit.listenit;

class cpe {
    private final cph f8624a;
    private final cpc f8625b;
    private final coo f8626c;
    private final Long f8627d;

    private cpe(cph com_ushareit_listenit_cph, cpc com_ushareit_listenit_cpc, Long l, coo com_ushareit_listenit_coo) {
        this.f8624a = com_ushareit_listenit_cph;
        this.f8625b = com_ushareit_listenit_cpc;
        this.f8626c = com_ushareit_listenit_coo;
        this.f8627d = l;
    }

    public cpc m12160a() {
        return this.f8625b;
    }

    public Long m12161b() {
        return this.f8627d;
    }

    public coo m12162c() {
        return this.f8626c;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f8625b.toString());
        String valueOf2 = String.valueOf(this.f8627d);
        return new StringBuilder((String.valueOf(valueOf).length() + 8) + String.valueOf(valueOf2).length()).append(valueOf).append(" (Tag: ").append(valueOf2).append(")").toString();
    }
}
