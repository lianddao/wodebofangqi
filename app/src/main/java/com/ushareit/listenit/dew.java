package com.ushareit.listenit;

final class dew implements dbr {
    dew() {
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        Class a = com_ushareit_listenit_dft_T.m14120a();
        if (!Enum.class.isAssignableFrom(a) || a == Enum.class) {
            return null;
        }
        if (!a.isEnum()) {
            a = a.getSuperclass();
        }
        return new dfs(a);
    }
}
