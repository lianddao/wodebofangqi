package com.ushareit.listenit;

import java.util.Map;

public final class ded<T> extends dbq<T> {
    private final dda<T> f9662a;
    private final Map<String, dee> f9663b;

    private ded(dda<T> com_ushareit_listenit_dda_T, Map<String, dee> map) {
        this.f9662a = com_ushareit_listenit_dda_T;
        this.f9663b = map;
    }

    public void mo1400a(dfx com_ushareit_listenit_dfx, T t) {
        if (t == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        com_ushareit_listenit_dfx.mo1738d();
        try {
            for (dee com_ushareit_listenit_dee : this.f9663b.values()) {
                if (com_ushareit_listenit_dee.mo1744a(t)) {
                    com_ushareit_listenit_dfx.mo1732a(com_ushareit_listenit_dee.f9653g);
                    com_ushareit_listenit_dee.mo1743a(com_ushareit_listenit_dfx, (Object) t);
                }
            }
            com_ushareit_listenit_dfx.mo1739e();
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        }
    }

    public T mo1401b(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        T a = this.f9662a.mo1710a();
        try {
            com_ushareit_listenit_dfu.mo1714c();
            while (com_ushareit_listenit_dfu.mo1717e()) {
                dee com_ushareit_listenit_dee = (dee) this.f9663b.get(com_ushareit_listenit_dfu.mo1719g());
                if (com_ushareit_listenit_dee == null || !com_ushareit_listenit_dee.f9655i) {
                    com_ushareit_listenit_dfu.mo1726n();
                } else {
                    com_ushareit_listenit_dee.mo1742a(com_ushareit_listenit_dfu, (Object) a);
                }
            }
            com_ushareit_listenit_dfu.mo1716d();
            return a;
        } catch (Throwable e) {
            throw new dbj(e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }
}
