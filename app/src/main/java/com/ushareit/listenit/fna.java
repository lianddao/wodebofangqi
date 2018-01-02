package com.ushareit.listenit;

class fna extends gwx {
    eyh f13018a = null;
    final /* synthetic */ String f13019b;
    final /* synthetic */ String f13020c;
    final /* synthetic */ get f13021d;
    final /* synthetic */ fmp f13022e;

    fna(fmp com_ushareit_listenit_fmp, String str, String str2, String str3, get com_ushareit_listenit_get) {
        this.f13022e = com_ushareit_listenit_fmp;
        this.f13019b = str2;
        this.f13020c = str3;
        this.f13021d = com_ushareit_listenit_get;
        super(str);
    }

    public void execute() {
        this.f13018a = gnf.m22470a(this.f13019b, this.f13020c);
    }

    public void callback() {
        if (this.f13021d == null) {
            return;
        }
        if (this.f13018a != null) {
            this.f13021d.mo2405a();
        } else {
            this.f13021d.mo2406a("task failure");
        }
    }
}
