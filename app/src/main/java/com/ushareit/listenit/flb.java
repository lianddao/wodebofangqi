package com.ushareit.listenit;

import java.util.Map;

class flb implements ecy {
    final /* synthetic */ fjz f12891a;
    final /* synthetic */ Map f12892b;
    final /* synthetic */ String f12893c;
    final /* synthetic */ fkv f12894d;

    flb(fkv com_ushareit_listenit_fkv, fjz com_ushareit_listenit_fjz, Map map, String str) {
        this.f12894d = com_ushareit_listenit_fkv;
        this.f12891a = com_ushareit_listenit_fjz;
        this.f12892b = map;
        this.f12893c = str;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        fnn com_ushareit_listenit_fnn = new fnn(com_ushareit_listenit_ecb);
        if (com_ushareit_listenit_fnn != null) {
            ((fnm) this.f12892b.get(this.f12893c)).setSt(com_ushareit_listenit_fnn.getSt());
            hhx.m23867a(new flc(this, com_ushareit_listenit_fnn));
        } else if (this.f12891a != null) {
            this.f12891a.m19587c();
        }
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        if (this.f12891a != null) {
            this.f12891a.m19588d();
        }
    }
}
