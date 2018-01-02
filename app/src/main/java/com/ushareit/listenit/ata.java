package com.ushareit.listenit;

class ata extends apo<avr> {
    final /* synthetic */ asq f5398a;

    ata(asq com_ushareit_listenit_asq) {
        this.f5398a = com_ushareit_listenit_asq;
    }

    public Class<avr> mo708a() {
        return avr.class;
    }

    public void m7112a(avr com_ushareit_listenit_avr) {
        int currentPosition = this.f5398a.f5353m.getCurrentPosition();
        if (this.f5398a.f5341a > 0 && currentPosition == this.f5398a.f5353m.getDuration() && this.f5398a.f5353m.getDuration() > this.f5398a.f5341a) {
            return;
        }
        if (!(currentPosition == 0 && this.f5398a.f5353m.mo146b()) && this.f5398a.f5353m.getDuration() >= currentPosition + 500) {
            this.f5398a.m6998b(currentPosition);
        } else {
            this.f5398a.m6998b(this.f5398a.f5353m.getDuration());
        }
    }
}
