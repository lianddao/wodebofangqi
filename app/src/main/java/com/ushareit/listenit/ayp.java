package com.ushareit.listenit;

class ayp implements avh {
    final /* synthetic */ aym f5671a;

    ayp(aym com_ushareit_listenit_aym) {
        this.f5671a = com_ushareit_listenit_aym;
    }

    public void mo806a(int i) {
        if (this.f5671a.f5665j) {
            this.f5671a.f5660e.setProgress(i);
        }
    }

    public void mo807a(String str) {
        this.f5671a.f5665j = true;
        this.f5671a.f5658c.setUrl(str);
    }

    public void mo808b(String str) {
        this.f5671a.f5658c.setTitle(str);
    }

    public void mo809c(String str) {
        this.f5671a.f5660e.setProgress(100);
        this.f5671a.f5665j = false;
    }
}
