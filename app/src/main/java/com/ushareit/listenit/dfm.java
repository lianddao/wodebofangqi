package com.ushareit.listenit;

final class dfm extends dbq<Character> {
    dfm() {
    }

    public Character m14089a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        String h = com_ushareit_listenit_dfu.mo1720h();
        if (h.length() == 1) {
            return Character.valueOf(h.charAt(0));
        }
        String str = "Expecting character, got: ";
        h = String.valueOf(h);
        throw new dbj(h.length() != 0 ? str.concat(h) : new String(str));
    }

    public void m14090a(dfx com_ushareit_listenit_dfx, Character ch) {
        com_ushareit_listenit_dfx.mo1735b(ch == null ? null : String.valueOf(ch));
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14089a(com_ushareit_listenit_dfu);
    }
}
