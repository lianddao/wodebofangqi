package com.ushareit.listenit;

final class dfi extends dbq<Number> {
    dfi() {
    }

    public Number m14073a(dfu com_ushareit_listenit_dfu) {
        dfw f = com_ushareit_listenit_dfu.mo1718f();
        switch (dfe.f9729a[f.ordinal()]) {
            case 1:
                return new dcr(com_ushareit_listenit_dfu.mo1720h());
            case 4:
                com_ushareit_listenit_dfu.mo1722j();
                return null;
            default:
                String valueOf = String.valueOf(f);
                throw new dbj(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Expecting number, got: ").append(valueOf).toString());
        }
    }

    public void m14074a(dfx com_ushareit_listenit_dfx, Number number) {
        com_ushareit_listenit_dfx.mo1731a(number);
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14073a(com_ushareit_listenit_dfu);
    }
}
