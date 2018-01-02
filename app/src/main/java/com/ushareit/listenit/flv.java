package com.ushareit.listenit;

class flv implements ecy {
    final /* synthetic */ String f12946a;
    final /* synthetic */ fni f12947b;
    final /* synthetic */ flr f12948c;

    flv(flr com_ushareit_listenit_flr, String str, fni com_ushareit_listenit_fni) {
        this.f12948c = com_ushareit_listenit_flr;
        this.f12946a = str;
        this.f12947b = com_ushareit_listenit_fni;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        Integer num = (Integer) com_ushareit_listenit_ecb.m16701a(Integer.class);
        if (num == null) {
            fjy.m19574b().m16736a(this.f12946a).m16733a(this.f12947b.toMap());
        } else if (num.intValue() != this.f12947b.getSgN()) {
            fjy.m19574b().m16736a(this.f12946a).m16736a(fni.KEY_PLAYLIST_NUMBER).m16733a(Integer.valueOf(this.f12947b.getPlN()));
            fjy.m19574b().m16736a(this.f12946a).m16736a("sgN").m16733a(Integer.valueOf(this.f12947b.getSgN()));
            if (!fbb.m18763c(this.f12947b.getAd())) {
                fjy.m19574b().m16736a(this.f12946a).m16736a(fni.KEY_ADDRESS).m16733a(this.f12947b.getAd());
            }
            exw.m18457e("ShareListSync", "syncNearby: upload change, playlistNumber=" + this.f12947b.getPlN() + ", songNumber=" + this.f12947b.getSgN() + ", ");
        }
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
    }
}
