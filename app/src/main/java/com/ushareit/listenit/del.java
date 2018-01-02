package com.ushareit.listenit;

final class del extends dbq<Class> {
    del() {
    }

    public Class m14005a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }

    public void m14006a(dfx com_ushareit_listenit_dfx, Class cls) {
        if (cls == null) {
            com_ushareit_listenit_dfx.mo1740f();
        } else {
            String valueOf = String.valueOf(cls.getName());
            throw new UnsupportedOperationException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Attempted to serialize java.lang.Class: ").append(valueOf).append(". Forgot to register a type adapter?").toString());
        }
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14005a(com_ushareit_listenit_dfu);
    }
}
