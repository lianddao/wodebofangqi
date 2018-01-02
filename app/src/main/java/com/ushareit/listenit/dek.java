package com.ushareit.listenit;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

public final class dek {
    public static final dbq<StringBuffer> f9671A = new dfr();
    public static final dbr f9672B = m14001a(StringBuffer.class, f9671A);
    public static final dbq<URL> f9673C = new dem();
    public static final dbr f9674D = m14001a(URL.class, f9673C);
    public static final dbq<URI> f9675E = new den();
    public static final dbr f9676F = m14001a(URI.class, f9675E);
    public static final dbq<InetAddress> f9677G = new dep();
    public static final dbr f9678H = m14003b(InetAddress.class, f9677G);
    public static final dbq<UUID> f9679I = new deq();
    public static final dbr f9680J = m14001a(UUID.class, f9679I);
    public static final dbr f9681K = new der();
    public static final dbq<Calendar> f9682L = new det();
    public static final dbr f9683M = m14004b(Calendar.class, GregorianCalendar.class, f9682L);
    public static final dbq<Locale> f9684N = new deu();
    public static final dbr f9685O = m14001a(Locale.class, f9684N);
    public static final dbq<dba> f9686P = new dev();
    public static final dbr f9687Q = m14003b(dba.class, f9686P);
    public static final dbr f9688R = new dew();
    public static final dbq<Class> f9689a = new del();
    public static final dbr f9690b = m14001a(Class.class, f9689a);
    public static final dbq<BitSet> f9691c = new deo();
    public static final dbr f9692d = m14001a(BitSet.class, f9691c);
    public static final dbq<Boolean> f9693e = new dfb();
    public static final dbq<Boolean> f9694f = new dff();
    public static final dbr f9695g = m14002a(Boolean.TYPE, Boolean.class, f9693e);
    public static final dbq<Number> f9696h = new dfg();
    public static final dbr f9697i = m14002a(Byte.TYPE, Byte.class, f9696h);
    public static final dbq<Number> f9698j = new dfh();
    public static final dbr f9699k = m14002a(Short.TYPE, Short.class, f9698j);
    public static final dbq<Number> f9700l = new dfj();
    public static final dbr f9701m = m14002a(Integer.TYPE, Integer.class, f9700l);
    public static final dbq<Number> f9702n = new dfk();
    public static final dbq<Number> f9703o = new dfl();
    public static final dbq<Number> f9704p = new dex();
    public static final dbq<Number> f9705q = new dfi();
    public static final dbr f9706r = m14001a(Number.class, f9705q);
    public static final dbq<Character> f9707s = new dfm();
    public static final dbr f9708t = m14002a(Character.TYPE, Character.class, f9707s);
    public static final dbq<String> f9709u = new dfn();
    public static final dbq<BigDecimal> f9710v = new dfo();
    public static final dbq<BigInteger> f9711w = new dfp();
    public static final dbr f9712x = m14001a(String.class, f9709u);
    public static final dbq<StringBuilder> f9713y = new dfq();
    public static final dbr f9714z = m14001a(StringBuilder.class, f9713y);

    public static <TT> dbr m14000a(dft<TT> com_ushareit_listenit_dft_TT, dbq<TT> com_ushareit_listenit_dbq_TT) {
        return new dey(com_ushareit_listenit_dft_TT, com_ushareit_listenit_dbq_TT);
    }

    public static <TT> dbr m14001a(Class<TT> cls, dbq<TT> com_ushareit_listenit_dbq_TT) {
        return new dez(cls, com_ushareit_listenit_dbq_TT);
    }

    public static <TT> dbr m14002a(Class<TT> cls, Class<TT> cls2, dbq<? super TT> com_ushareit_listenit_dbq__super_TT) {
        return new dfa(cls, cls2, com_ushareit_listenit_dbq__super_TT);
    }

    public static <TT> dbr m14003b(Class<TT> cls, dbq<TT> com_ushareit_listenit_dbq_TT) {
        return new dfd(cls, com_ushareit_listenit_dbq_TT);
    }

    public static <TT> dbr m14004b(Class<TT> cls, Class<? extends TT> cls2, dbq<? super TT> com_ushareit_listenit_dbq__super_TT) {
        return new dfc(cls, cls2, com_ushareit_listenit_dbq__super_TT);
    }
}
