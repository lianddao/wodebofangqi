package com.ushareit.listenit;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dao {
    final day f9463a;
    final dbh f9464b;
    private final ThreadLocal<Map<dft<?>, dau<?>>> f9465c;
    private final Map<dft<?>, dbq<?>> f9466d;
    private final List<dbr> f9467e;
    private final dcb f9468f;
    private final boolean f9469g;
    private final boolean f9470h;
    private final boolean f9471i;
    private final boolean f9472j;

    public dao() {
        this(dco.f9537a, dah.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, dbk.DEFAULT, Collections.emptyList());
    }

    dao(dco com_ushareit_listenit_dco, dan com_ushareit_listenit_dan, Map<Type, daw<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, dbk com_ushareit_listenit_dbk, List<dbr> list) {
        this.f9465c = new ThreadLocal();
        this.f9466d = Collections.synchronizedMap(new HashMap());
        this.f9463a = new dap(this);
        this.f9464b = new daq(this);
        this.f9468f = new dcb(map);
        this.f9469g = z;
        this.f9471i = z3;
        this.f9470h = z4;
        this.f9472j = z5;
        List arrayList = new ArrayList();
        arrayList.add(dek.f9687Q);
        arrayList.add(ddy.f9642a);
        arrayList.add(com_ushareit_listenit_dco);
        arrayList.addAll(list);
        arrayList.add(dek.f9712x);
        arrayList.add(dek.f9701m);
        arrayList.add(dek.f9695g);
        arrayList.add(dek.f9697i);
        arrayList.add(dek.f9699k);
        arrayList.add(dek.m14002a(Long.TYPE, Long.class, m13644a(com_ushareit_listenit_dbk)));
        arrayList.add(dek.m14002a(Double.TYPE, Double.class, m13645a(z6)));
        arrayList.add(dek.m14002a(Float.TYPE, Float.class, m13649b(z6)));
        arrayList.add(dek.f9706r);
        arrayList.add(dek.f9708t);
        arrayList.add(dek.f9714z);
        arrayList.add(dek.f9672B);
        arrayList.add(dek.m14001a(BigDecimal.class, dek.f9710v));
        arrayList.add(dek.m14001a(BigInteger.class, dek.f9711w));
        arrayList.add(dek.f9674D);
        arrayList.add(dek.f9676F);
        arrayList.add(dek.f9680J);
        arrayList.add(dek.f9685O);
        arrayList.add(dek.f9678H);
        arrayList.add(dek.f9692d);
        arrayList.add(ddp.f9596a);
        arrayList.add(dek.f9683M);
        arrayList.add(deh.f9666a);
        arrayList.add(def.f9664a);
        arrayList.add(dek.f9681K);
        arrayList.add(ddl.f9590a);
        arrayList.add(dek.f9690b);
        arrayList.add(new ddn(this.f9468f));
        arrayList.add(new ddw(this.f9468f, z2));
        arrayList.add(new ddr(this.f9468f));
        arrayList.add(dek.f9688R);
        arrayList.add(new deb(this.f9468f, com_ushareit_listenit_dan, com_ushareit_listenit_dco));
        this.f9467e = Collections.unmodifiableList(arrayList);
    }

    private dbq<Number> m13644a(dbk com_ushareit_listenit_dbk) {
        return com_ushareit_listenit_dbk == dbk.DEFAULT ? dek.f9702n : new dat(this);
    }

    private dbq<Number> m13645a(boolean z) {
        return z ? dek.f9704p : new dar(this);
    }

    private void m13646a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void m13648a(Object obj, dfu com_ushareit_listenit_dfu) {
        if (obj != null) {
            try {
                if (com_ushareit_listenit_dfu.mo1718f() != dfw.END_DOCUMENT) {
                    throw new dbb("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new dbj(e);
            } catch (Throwable e2) {
                throw new dbb(e2);
            }
        }
    }

    private dbq<Number> m13649b(boolean z) {
        return z ? dek.f9703o : new das(this);
    }

    public <T> dbq<T> m13650a(dbr com_ushareit_listenit_dbr, dft<T> com_ushareit_listenit_dft_T) {
        Object obj = null;
        if (!this.f9467e.contains(com_ushareit_listenit_dbr)) {
            obj = 1;
        }
        Object obj2 = obj;
        for (dbr com_ushareit_listenit_dbr2 : this.f9467e) {
            if (obj2 != null) {
                dbq<T> a = com_ushareit_listenit_dbr2.mo1709a(this, com_ushareit_listenit_dft_T);
                if (a != null) {
                    return a;
                }
            } else if (com_ushareit_listenit_dbr2 == com_ushareit_listenit_dbr) {
                obj2 = 1;
            }
        }
        String valueOf = String.valueOf(com_ushareit_listenit_dft_T);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("GSON cannot serialize ").append(valueOf).toString());
    }

    public <T> dbq<T> m13651a(dft<T> com_ushareit_listenit_dft_T) {
        Map map;
        dbq<T> com_ushareit_listenit_dbq_T = (dbq) this.f9466d.get(com_ushareit_listenit_dft_T);
        if (com_ushareit_listenit_dbq_T == null) {
            Map map2 = (Map) this.f9465c.get();
            Object obj = null;
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.f9465c.set(hashMap);
                map = hashMap;
                obj = 1;
            } else {
                map = map2;
            }
            dau com_ushareit_listenit_dau = (dau) map.get(com_ushareit_listenit_dft_T);
            if (com_ushareit_listenit_dau == null) {
                try {
                    dau com_ushareit_listenit_dau2 = new dau();
                    map.put(com_ushareit_listenit_dft_T, com_ushareit_listenit_dau2);
                    for (dbr a : this.f9467e) {
                        com_ushareit_listenit_dbq_T = a.mo1709a(this, com_ushareit_listenit_dft_T);
                        if (com_ushareit_listenit_dbq_T != null) {
                            com_ushareit_listenit_dau2.m13679a(com_ushareit_listenit_dbq_T);
                            this.f9466d.put(com_ushareit_listenit_dft_T, com_ushareit_listenit_dbq_T);
                            map.remove(com_ushareit_listenit_dft_T);
                            if (obj != null) {
                                this.f9465c.remove();
                            }
                        }
                    }
                    String valueOf = String.valueOf(com_ushareit_listenit_dft_T);
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("GSON cannot handle ").append(valueOf).toString());
                } catch (Throwable th) {
                    map.remove(com_ushareit_listenit_dft_T);
                    if (obj != null) {
                        this.f9465c.remove();
                    }
                }
            }
        }
        return com_ushareit_listenit_dbq_T;
    }

    public <T> dbq<T> m13652a(Class<T> cls) {
        return m13651a(dft.m14119b(cls));
    }

    public dfx m13653a(Writer writer) {
        if (this.f9471i) {
            writer.write(")]}'\n");
        }
        dfx com_ushareit_listenit_dfx = new dfx(writer);
        if (this.f9472j) {
            com_ushareit_listenit_dfx.m13934c("  ");
        }
        com_ushareit_listenit_dfx.m13937d(this.f9469g);
        return com_ushareit_listenit_dfx;
    }

    public <T> T m13654a(dba com_ushareit_listenit_dba, Class<T> cls) {
        return ddb.m13828a((Class) cls).cast(m13655a(com_ushareit_listenit_dba, (Type) cls));
    }

    public <T> T m13655a(dba com_ushareit_listenit_dba, Type type) {
        return com_ushareit_listenit_dba == null ? null : m13656a(new dds(com_ushareit_listenit_dba), type);
    }

    public <T> T m13656a(dfu com_ushareit_listenit_dfu, Type type) {
        boolean z = true;
        boolean p = com_ushareit_listenit_dfu.m13896p();
        com_ushareit_listenit_dfu.m13882a(true);
        try {
            com_ushareit_listenit_dfu.mo1718f();
            z = false;
            T b = m13651a(dft.m14117a(type)).mo1401b(com_ushareit_listenit_dfu);
            com_ushareit_listenit_dfu.m13882a(p);
            return b;
        } catch (Throwable e) {
            if (z) {
                com_ushareit_listenit_dfu.m13882a(p);
                return null;
            }
            throw new dbj(e);
        } catch (Throwable e2) {
            throw new dbj(e2);
        } catch (Throwable e22) {
            throw new dbj(e22);
        } catch (Throwable th) {
            com_ushareit_listenit_dfu.m13882a(p);
        }
    }

    public <T> T m13657a(Reader reader, Type type) {
        dfu com_ushareit_listenit_dfu = new dfu(reader);
        Object a = m13656a(com_ushareit_listenit_dfu, type);
        m13648a(a, com_ushareit_listenit_dfu);
        return a;
    }

    public <T> T m13658a(String str, Class<T> cls) {
        return ddb.m13828a((Class) cls).cast(m13659a(str, (Type) cls));
    }

    public <T> T m13659a(String str, Type type) {
        return str == null ? null : m13657a(new StringReader(str), type);
    }

    public String m13660a(dba com_ushareit_listenit_dba) {
        Appendable stringWriter = new StringWriter();
        m13664a(com_ushareit_listenit_dba, stringWriter);
        return stringWriter.toString();
    }

    public String m13661a(Object obj) {
        return obj == null ? m13660a(dbc.f9489a) : m13662a(obj, obj.getClass());
    }

    public String m13662a(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        m13666a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void m13663a(dba com_ushareit_listenit_dba, dfx com_ushareit_listenit_dfx) {
        boolean g = com_ushareit_listenit_dfx.m13940g();
        com_ushareit_listenit_dfx.m13932b(true);
        boolean h = com_ushareit_listenit_dfx.m13941h();
        com_ushareit_listenit_dfx.m13935c(this.f9470h);
        boolean i = com_ushareit_listenit_dfx.m13942i();
        com_ushareit_listenit_dfx.m13937d(this.f9469g);
        try {
            ddc.m13833a(com_ushareit_listenit_dba, com_ushareit_listenit_dfx);
            com_ushareit_listenit_dfx.m13932b(g);
            com_ushareit_listenit_dfx.m13935c(h);
            com_ushareit_listenit_dfx.m13937d(i);
        } catch (Throwable e) {
            throw new dbb(e);
        } catch (Throwable th) {
            com_ushareit_listenit_dfx.m13932b(g);
            com_ushareit_listenit_dfx.m13935c(h);
            com_ushareit_listenit_dfx.m13937d(i);
        }
    }

    public void m13664a(dba com_ushareit_listenit_dba, Appendable appendable) {
        try {
            m13663a(com_ushareit_listenit_dba, m13653a(ddc.m13832a(appendable)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void m13665a(Object obj, Type type, dfx com_ushareit_listenit_dfx) {
        dbq a = m13651a(dft.m14117a(type));
        boolean g = com_ushareit_listenit_dfx.m13940g();
        com_ushareit_listenit_dfx.m13932b(true);
        boolean h = com_ushareit_listenit_dfx.m13941h();
        com_ushareit_listenit_dfx.m13935c(this.f9470h);
        boolean i = com_ushareit_listenit_dfx.m13942i();
        com_ushareit_listenit_dfx.m13937d(this.f9469g);
        try {
            a.mo1400a(com_ushareit_listenit_dfx, obj);
            com_ushareit_listenit_dfx.m13932b(g);
            com_ushareit_listenit_dfx.m13935c(h);
            com_ushareit_listenit_dfx.m13937d(i);
        } catch (Throwable e) {
            throw new dbb(e);
        } catch (Throwable th) {
            com_ushareit_listenit_dfx.m13932b(g);
            com_ushareit_listenit_dfx.m13935c(h);
            com_ushareit_listenit_dfx.m13937d(i);
        }
    }

    public void m13666a(Object obj, Type type, Appendable appendable) {
        try {
            m13665a(obj, type, m13653a(ddc.m13832a(appendable)));
        } catch (Throwable e) {
            throw new dbb(e);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f9469g + "factories:" + this.f9467e + ",instanceCreators:" + this.f9468f + "}";
    }
}
