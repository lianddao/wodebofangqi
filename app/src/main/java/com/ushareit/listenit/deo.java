package com.ushareit.listenit;

import java.util.BitSet;

final class deo extends dbq<BitSet> {
    deo() {
    }

    public BitSet m14017a(dfu com_ushareit_listenit_dfu) {
        String valueOf;
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        BitSet bitSet = new BitSet();
        com_ushareit_listenit_dfu.mo1712a();
        dfw f = com_ushareit_listenit_dfu.mo1718f();
        int i = 0;
        while (f != dfw.END_ARRAY) {
            boolean z;
            switch (dfe.f9729a[f.ordinal()]) {
                case 1:
                    if (com_ushareit_listenit_dfu.mo1725m() == 0) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 2:
                    z = com_ushareit_listenit_dfu.mo1721i();
                    break;
                case 3:
                    Object h = com_ushareit_listenit_dfu.mo1720h();
                    try {
                        if (Integer.parseInt(h) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    } catch (NumberFormatException e) {
                        String str = "Error: Expecting: bitset number value (1, 0), Found: ";
                        valueOf = String.valueOf(h);
                        throw new dbj(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    }
                default:
                    valueOf = String.valueOf(f);
                    throw new dbj(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Invalid bitset value type: ").append(valueOf).toString());
            }
            if (z) {
                bitSet.set(i);
            }
            i++;
            f = com_ushareit_listenit_dfu.mo1718f();
        }
        com_ushareit_listenit_dfu.mo1713b();
        return bitSet;
    }

    public void m14019a(dfx com_ushareit_listenit_dfx, BitSet bitSet) {
        if (bitSet == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        com_ushareit_listenit_dfx.mo1734b();
        for (int i = 0; i < bitSet.length(); i++) {
            com_ushareit_listenit_dfx.mo1730a((long) (bitSet.get(i) ? 1 : 0));
        }
        com_ushareit_listenit_dfx.mo1736c();
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14017a(com_ushareit_listenit_dfu);
    }
}
