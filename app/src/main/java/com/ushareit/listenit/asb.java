package com.ushareit.listenit;

class asb implements Runnable {
    final /* synthetic */ aom f5310a;
    final /* synthetic */ asa f5311b;

    asb(asa com_ushareit_listenit_asa, aom com_ushareit_listenit_aom) {
        this.f5311b = com_ushareit_listenit_asa;
        this.f5310a = com_ushareit_listenit_aom;
    }

    public void run() {
        aor.m6487b(this.f5311b.f5303b);
        this.f5311b.f5302a = this.f5310a.m6482e();
        try {
            this.f5311b.f5308g = auv.m7233b(this.f5311b.f5303b, this.f5310a.f5070e);
            this.f5311b.f5308g.m6726a(this.f5311b.f5309h, this.f5311b.f5308g.m6733b().m6783a(this.f5311b.f5302a), this.f5311b.m6952b());
        } catch (Exception e) {
            this.f5311b.m6947a(ajw.AD_REQUEST_FAILED.m5822a(e.getMessage()));
        }
    }
}
