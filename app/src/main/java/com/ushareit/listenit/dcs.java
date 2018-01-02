package com.ushareit.listenit;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;

public final class dcs<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f9551f = (!dcs.class.desiredAssertionStatus());
    private static final Comparator<Comparable> f9552g = new dct();
    Comparator<? super K> f9553a;
    dcz<K, V> f9554b;
    int f9555c;
    int f9556d;
    final dcz<K, V> f9557e;
    private dcu f9558h;
    private dcw f9559i;

    public dcs() {
        this(f9552g);
    }

    public dcs(Comparator<? super K> comparator) {
        Comparator comparator2;
        this.f9555c = 0;
        this.f9556d = 0;
        this.f9557e = new dcz();
        if (comparator == null) {
            comparator2 = f9552g;
        }
        this.f9553a = comparator2;
    }

    private void m13807a(dcz<K, V> com_ushareit_listenit_dcz_K__V) {
        int i = 0;
        dcz com_ushareit_listenit_dcz = com_ushareit_listenit_dcz_K__V.f9569b;
        dcz com_ushareit_listenit_dcz2 = com_ushareit_listenit_dcz_K__V.f9570c;
        dcz com_ushareit_listenit_dcz3 = com_ushareit_listenit_dcz2.f9569b;
        dcz com_ushareit_listenit_dcz4 = com_ushareit_listenit_dcz2.f9570c;
        com_ushareit_listenit_dcz_K__V.f9570c = com_ushareit_listenit_dcz3;
        if (com_ushareit_listenit_dcz3 != null) {
            com_ushareit_listenit_dcz3.f9568a = com_ushareit_listenit_dcz_K__V;
        }
        m13808a((dcz) com_ushareit_listenit_dcz_K__V, com_ushareit_listenit_dcz2);
        com_ushareit_listenit_dcz2.f9569b = com_ushareit_listenit_dcz_K__V;
        com_ushareit_listenit_dcz_K__V.f9568a = com_ushareit_listenit_dcz2;
        com_ushareit_listenit_dcz_K__V.f9575h = Math.max(com_ushareit_listenit_dcz != null ? com_ushareit_listenit_dcz.f9575h : 0, com_ushareit_listenit_dcz3 != null ? com_ushareit_listenit_dcz3.f9575h : 0) + 1;
        int i2 = com_ushareit_listenit_dcz_K__V.f9575h;
        if (com_ushareit_listenit_dcz4 != null) {
            i = com_ushareit_listenit_dcz4.f9575h;
        }
        com_ushareit_listenit_dcz2.f9575h = Math.max(i2, i) + 1;
    }

    private void m13808a(dcz<K, V> com_ushareit_listenit_dcz_K__V, dcz<K, V> com_ushareit_listenit_dcz_K__V2) {
        dcz com_ushareit_listenit_dcz = com_ushareit_listenit_dcz_K__V.f9568a;
        com_ushareit_listenit_dcz_K__V.f9568a = null;
        if (com_ushareit_listenit_dcz_K__V2 != null) {
            com_ushareit_listenit_dcz_K__V2.f9568a = com_ushareit_listenit_dcz;
        }
        if (com_ushareit_listenit_dcz == null) {
            this.f9554b = com_ushareit_listenit_dcz_K__V2;
        } else if (com_ushareit_listenit_dcz.f9569b == com_ushareit_listenit_dcz_K__V) {
            com_ushareit_listenit_dcz.f9569b = com_ushareit_listenit_dcz_K__V2;
        } else if (f9551f || com_ushareit_listenit_dcz.f9570c == com_ushareit_listenit_dcz_K__V) {
            com_ushareit_listenit_dcz.f9570c = com_ushareit_listenit_dcz_K__V2;
        } else {
            throw new AssertionError();
        }
    }

    private boolean m13809a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void m13810b(dcz<K, V> com_ushareit_listenit_dcz_K__V) {
        int i = 0;
        dcz com_ushareit_listenit_dcz = com_ushareit_listenit_dcz_K__V.f9569b;
        dcz com_ushareit_listenit_dcz2 = com_ushareit_listenit_dcz_K__V.f9570c;
        dcz com_ushareit_listenit_dcz3 = com_ushareit_listenit_dcz.f9569b;
        dcz com_ushareit_listenit_dcz4 = com_ushareit_listenit_dcz.f9570c;
        com_ushareit_listenit_dcz_K__V.f9569b = com_ushareit_listenit_dcz4;
        if (com_ushareit_listenit_dcz4 != null) {
            com_ushareit_listenit_dcz4.f9568a = com_ushareit_listenit_dcz_K__V;
        }
        m13808a((dcz) com_ushareit_listenit_dcz_K__V, com_ushareit_listenit_dcz);
        com_ushareit_listenit_dcz.f9570c = com_ushareit_listenit_dcz_K__V;
        com_ushareit_listenit_dcz_K__V.f9568a = com_ushareit_listenit_dcz;
        com_ushareit_listenit_dcz_K__V.f9575h = Math.max(com_ushareit_listenit_dcz2 != null ? com_ushareit_listenit_dcz2.f9575h : 0, com_ushareit_listenit_dcz4 != null ? com_ushareit_listenit_dcz4.f9575h : 0) + 1;
        int i2 = com_ushareit_listenit_dcz_K__V.f9575h;
        if (com_ushareit_listenit_dcz3 != null) {
            i = com_ushareit_listenit_dcz3.f9575h;
        }
        com_ushareit_listenit_dcz.f9575h = Math.max(i2, i) + 1;
    }

    private void m13811b(dcz<K, V> com_ushareit_listenit_dcz_K__V, boolean z) {
        dcz com_ushareit_listenit_dcz;
        while (com_ushareit_listenit_dcz != null) {
            dcz com_ushareit_listenit_dcz2 = com_ushareit_listenit_dcz.f9569b;
            dcz com_ushareit_listenit_dcz3 = com_ushareit_listenit_dcz.f9570c;
            int i = com_ushareit_listenit_dcz2 != null ? com_ushareit_listenit_dcz2.f9575h : 0;
            int i2 = com_ushareit_listenit_dcz3 != null ? com_ushareit_listenit_dcz3.f9575h : 0;
            int i3 = i - i2;
            dcz com_ushareit_listenit_dcz4;
            if (i3 == -2) {
                com_ushareit_listenit_dcz2 = com_ushareit_listenit_dcz3.f9569b;
                com_ushareit_listenit_dcz4 = com_ushareit_listenit_dcz3.f9570c;
                i2 = (com_ushareit_listenit_dcz2 != null ? com_ushareit_listenit_dcz2.f9575h : 0) - (com_ushareit_listenit_dcz4 != null ? com_ushareit_listenit_dcz4.f9575h : 0);
                if (i2 == -1 || (i2 == 0 && !z)) {
                    m13807a(com_ushareit_listenit_dcz);
                } else if (f9551f || i2 == 1) {
                    m13810b(com_ushareit_listenit_dcz3);
                    m13807a(com_ushareit_listenit_dcz);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                com_ushareit_listenit_dcz3 = com_ushareit_listenit_dcz2.f9569b;
                com_ushareit_listenit_dcz4 = com_ushareit_listenit_dcz2.f9570c;
                i2 = (com_ushareit_listenit_dcz3 != null ? com_ushareit_listenit_dcz3.f9575h : 0) - (com_ushareit_listenit_dcz4 != null ? com_ushareit_listenit_dcz4.f9575h : 0);
                if (i2 == 1 || (i2 == 0 && !z)) {
                    m13810b(com_ushareit_listenit_dcz);
                } else if (f9551f || i2 == -1) {
                    m13807a(com_ushareit_listenit_dcz2);
                    m13810b(com_ushareit_listenit_dcz);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                com_ushareit_listenit_dcz.f9575h = i + 1;
                if (z) {
                    return;
                }
            } else if (f9551f || i3 == -1 || i3 == 1) {
                com_ushareit_listenit_dcz.f9575h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            com_ushareit_listenit_dcz = com_ushareit_listenit_dcz.f9568a;
        }
    }

    dcz<K, V> m13812a(Object obj) {
        dcz<K, V> com_ushareit_listenit_dcz_K__V = null;
        if (obj != null) {
            try {
                com_ushareit_listenit_dcz_K__V = m13813a(obj, false);
            } catch (ClassCastException e) {
            }
        }
        return com_ushareit_listenit_dcz_K__V;
    }

    dcz<K, V> m13813a(K k, boolean z) {
        int i;
        Comparator comparator = this.f9553a;
        dcz<K, V> com_ushareit_listenit_dcz_K__V = this.f9554b;
        if (com_ushareit_listenit_dcz_K__V != null) {
            int compareTo;
            Comparable comparable = comparator == f9552g ? (Comparable) k : null;
            while (true) {
                compareTo = comparable != null ? comparable.compareTo(com_ushareit_listenit_dcz_K__V.f9573f) : comparator.compare(k, com_ushareit_listenit_dcz_K__V.f9573f);
                if (compareTo == 0) {
                    return com_ushareit_listenit_dcz_K__V;
                }
                dcz<K, V> com_ushareit_listenit_dcz_K__V2 = compareTo < 0 ? com_ushareit_listenit_dcz_K__V.f9569b : com_ushareit_listenit_dcz_K__V.f9570c;
                if (com_ushareit_listenit_dcz_K__V2 == null) {
                    break;
                }
                com_ushareit_listenit_dcz_K__V = com_ushareit_listenit_dcz_K__V2;
            }
            int i2 = compareTo;
            dcz com_ushareit_listenit_dcz = com_ushareit_listenit_dcz_K__V;
            i = i2;
        } else {
            dcz<K, V> com_ushareit_listenit_dcz_K__V3 = com_ushareit_listenit_dcz_K__V;
            i = 0;
        }
        if (!z) {
            return null;
        }
        dcz<K, V> com_ushareit_listenit_dcz2;
        dcz com_ushareit_listenit_dcz3 = this.f9557e;
        if (com_ushareit_listenit_dcz != null) {
            com_ushareit_listenit_dcz2 = new dcz(com_ushareit_listenit_dcz, k, com_ushareit_listenit_dcz3, com_ushareit_listenit_dcz3.f9572e);
            if (i < 0) {
                com_ushareit_listenit_dcz.f9569b = com_ushareit_listenit_dcz2;
            } else {
                com_ushareit_listenit_dcz.f9570c = com_ushareit_listenit_dcz2;
            }
            m13811b(com_ushareit_listenit_dcz, true);
        } else if (comparator != f9552g || (k instanceof Comparable)) {
            com_ushareit_listenit_dcz2 = new dcz(com_ushareit_listenit_dcz, k, com_ushareit_listenit_dcz3, com_ushareit_listenit_dcz3.f9572e);
            this.f9554b = com_ushareit_listenit_dcz2;
        } else {
            throw new ClassCastException(String.valueOf(k.getClass().getName()).concat(" is not Comparable"));
        }
        this.f9555c++;
        this.f9556d++;
        return com_ushareit_listenit_dcz2;
    }

    dcz<K, V> m13814a(Entry<?, ?> entry) {
        dcz<K, V> a = m13812a(entry.getKey());
        Object obj = (a == null || !m13809a(a.f9574g, entry.getValue())) ? null : 1;
        return obj != null ? a : null;
    }

    void m13815a(dcz<K, V> com_ushareit_listenit_dcz_K__V, boolean z) {
        int i = 0;
        if (z) {
            com_ushareit_listenit_dcz_K__V.f9572e.f9571d = com_ushareit_listenit_dcz_K__V.f9571d;
            com_ushareit_listenit_dcz_K__V.f9571d.f9572e = com_ushareit_listenit_dcz_K__V.f9572e;
        }
        dcz com_ushareit_listenit_dcz = com_ushareit_listenit_dcz_K__V.f9569b;
        dcz com_ushareit_listenit_dcz2 = com_ushareit_listenit_dcz_K__V.f9570c;
        dcz com_ushareit_listenit_dcz3 = com_ushareit_listenit_dcz_K__V.f9568a;
        if (com_ushareit_listenit_dcz == null || com_ushareit_listenit_dcz2 == null) {
            if (com_ushareit_listenit_dcz != null) {
                m13808a((dcz) com_ushareit_listenit_dcz_K__V, com_ushareit_listenit_dcz);
                com_ushareit_listenit_dcz_K__V.f9569b = null;
            } else if (com_ushareit_listenit_dcz2 != null) {
                m13808a((dcz) com_ushareit_listenit_dcz_K__V, com_ushareit_listenit_dcz2);
                com_ushareit_listenit_dcz_K__V.f9570c = null;
            } else {
                m13808a((dcz) com_ushareit_listenit_dcz_K__V, null);
            }
            m13811b(com_ushareit_listenit_dcz3, false);
            this.f9555c--;
            this.f9556d++;
            return;
        }
        int i2;
        com_ushareit_listenit_dcz = com_ushareit_listenit_dcz.f9575h > com_ushareit_listenit_dcz2.f9575h ? com_ushareit_listenit_dcz.m13821b() : com_ushareit_listenit_dcz2.m13820a();
        m13815a(com_ushareit_listenit_dcz, false);
        com_ushareit_listenit_dcz3 = com_ushareit_listenit_dcz_K__V.f9569b;
        if (com_ushareit_listenit_dcz3 != null) {
            i2 = com_ushareit_listenit_dcz3.f9575h;
            com_ushareit_listenit_dcz.f9569b = com_ushareit_listenit_dcz3;
            com_ushareit_listenit_dcz3.f9568a = com_ushareit_listenit_dcz;
            com_ushareit_listenit_dcz_K__V.f9569b = null;
        } else {
            i2 = 0;
        }
        com_ushareit_listenit_dcz3 = com_ushareit_listenit_dcz_K__V.f9570c;
        if (com_ushareit_listenit_dcz3 != null) {
            i = com_ushareit_listenit_dcz3.f9575h;
            com_ushareit_listenit_dcz.f9570c = com_ushareit_listenit_dcz3;
            com_ushareit_listenit_dcz3.f9568a = com_ushareit_listenit_dcz;
            com_ushareit_listenit_dcz_K__V.f9570c = null;
        }
        com_ushareit_listenit_dcz.f9575h = Math.max(i2, i) + 1;
        m13808a((dcz) com_ushareit_listenit_dcz_K__V, com_ushareit_listenit_dcz);
    }

    dcz<K, V> m13816b(Object obj) {
        dcz a = m13812a(obj);
        if (a != null) {
            m13815a(a, true);
        }
        return a;
    }

    public void clear() {
        this.f9554b = null;
        this.f9555c = 0;
        this.f9556d++;
        dcz com_ushareit_listenit_dcz = this.f9557e;
        com_ushareit_listenit_dcz.f9572e = com_ushareit_listenit_dcz;
        com_ushareit_listenit_dcz.f9571d = com_ushareit_listenit_dcz;
    }

    public boolean containsKey(Object obj) {
        return m13812a(obj) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set set = this.f9558h;
        if (set != null) {
            return set;
        }
        set = new dcu(this);
        this.f9558h = set;
        return set;
    }

    public V get(Object obj) {
        dcz a = m13812a(obj);
        return a != null ? a.f9574g : null;
    }

    public Set<K> keySet() {
        Set set = this.f9559i;
        if (set != null) {
            return set;
        }
        set = new dcw(this);
        this.f9559i = set;
        return set;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        dcz a = m13813a((Object) k, true);
        V v2 = a.f9574g;
        a.f9574g = v;
        return v2;
    }

    public V remove(Object obj) {
        dcz b = m13816b(obj);
        return b != null ? b.f9574g : null;
    }

    public int size() {
        return this.f9555c;
    }
}
