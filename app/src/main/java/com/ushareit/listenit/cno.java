package com.ushareit.listenit;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class cno<T> implements Iterable<T> {
    private final cnj<T, Void> f8518a;

    private cno(cnj<T, Void> com_ushareit_listenit_cnj_T__java_lang_Void) {
        this.f8518a = com_ushareit_listenit_cnj_T__java_lang_Void;
    }

    public cno(List<T> list, Comparator<T> comparator) {
        this.f8518a = cnk.m11906a(list, Collections.emptyMap(), cnk.m11908a(), comparator);
    }

    public cno<T> m11912a(T t) {
        cnj c = this.f8518a.mo1492c(t);
        return c == this.f8518a ? this : new cno(c);
    }

    public T m11913a() {
        return this.f8518a.mo1486a();
    }

    public cno<T> m11914b(T t) {
        return new cno(this.f8518a.mo1485a(t, null));
    }

    public T m11915b() {
        return this.f8518a.mo1489b();
    }

    public T m11916c(T t) {
        return this.f8518a.mo1493d(t);
    }

    public Iterator<T> m11917c() {
        return new cnp(this.f8518a.mo1495e());
    }

    public Iterator<T> iterator() {
        return new cnp(this.f8518a.iterator());
    }
}
