package com.ushareit.listenit;

public final class bpl extends bon {
    private final bss f7325a = new bss();

    public bpl() {
        super("Tx3gDecoder");
    }

    protected bop mo1077a(byte[] bArr, int i) {
        this.f7325a.m9702a(bArr, i);
        int h = this.f7325a.m9714h();
        if (h == 0) {
            return bpm.f7326a;
        }
        return new bpm(new bom(this.f7325a.m9711e(h)));
    }
}
