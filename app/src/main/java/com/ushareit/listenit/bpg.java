package com.ushareit.listenit;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

final class bpg {
    public final String f7292a;
    public final String f7293b;
    public final boolean f7294c;
    public final long f7295d;
    public final long f7296e;
    public final bpj f7297f;
    public final String f7298g;
    private final String[] f7299h;
    private final HashMap<String, Integer> f7300i;
    private final HashMap<String, Integer> f7301j;
    private List<bpg> f7302k;

    public static bpg m9348a(String str) {
        return new bpg(null, bpi.m9361a(str), -9223372036854775807L, -9223372036854775807L, null, null, "");
    }

    public static bpg m9349a(String str, long j, long j2, bpj com_ushareit_listenit_bpj, String[] strArr, String str2) {
        return new bpg(str, null, j, j2, com_ushareit_listenit_bpj, strArr, str2);
    }

    private bpg(String str, String str2, long j, long j2, bpj com_ushareit_listenit_bpj, String[] strArr, String str3) {
        this.f7292a = str;
        this.f7293b = str2;
        this.f7297f = com_ushareit_listenit_bpj;
        this.f7299h = strArr;
        this.f7294c = str2 != null;
        this.f7295d = j;
        this.f7296e = j2;
        this.f7298g = (String) bsg.m9654a((Object) str3);
        this.f7300i = new HashMap();
        this.f7301j = new HashMap();
    }

    public boolean m9358a(long j) {
        return (this.f7295d == -9223372036854775807L && this.f7296e == -9223372036854775807L) || ((this.f7295d <= j && this.f7296e == -9223372036854775807L) || ((this.f7295d == -9223372036854775807L && j < this.f7296e) || (this.f7295d <= j && j < this.f7296e)));
    }

    public void m9357a(bpg com_ushareit_listenit_bpg) {
        if (this.f7302k == null) {
            this.f7302k = new ArrayList();
        }
        this.f7302k.add(com_ushareit_listenit_bpg);
    }

    public bpg m9355a(int i) {
        if (this.f7302k != null) {
            return (bpg) this.f7302k.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int m9354a() {
        return this.f7302k == null ? 0 : this.f7302k.size();
    }

    public long[] m9359b() {
        TreeSet treeSet = new TreeSet();
        m9353a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            jArr[i] = ((Long) it.next()).longValue();
            i = i2;
        }
        return jArr;
    }

    private void m9353a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f7292a);
        if (z || equals) {
            if (this.f7295d != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.f7295d));
            }
            if (this.f7296e != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.f7296e));
            }
        }
        if (this.f7302k != null) {
            for (int i = 0; i < this.f7302k.size(); i++) {
                boolean z2;
                bpg com_ushareit_listenit_bpg = (bpg) this.f7302k.get(i);
                if (z || equals) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com_ushareit_listenit_bpg.m9353a((TreeSet) treeSet, z2);
            }
        }
    }

    public List<bom> m9356a(long j, Map<String, bpj> map, Map<String, bph> map2) {
        Map treeMap = new TreeMap();
        m9350a(j, false, this.f7298g, treeMap);
        m9352a((Map) map, treeMap);
        List<bom> arrayList = new ArrayList();
        for (Entry entry : treeMap.entrySet()) {
            bph com_ushareit_listenit_bph = (bph) map2.get(entry.getKey());
            arrayList.add(new bom(m9346a((SpannableStringBuilder) entry.getValue()), null, com_ushareit_listenit_bph.f7304b, com_ushareit_listenit_bph.f7305c, Integer.MIN_VALUE, com_ushareit_listenit_bph.f7303a, Integer.MIN_VALUE, com_ushareit_listenit_bph.f7306d));
        }
        return arrayList;
    }

    private void m9350a(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.f7300i.clear();
        this.f7301j.clear();
        String str2 = this.f7298g;
        if ("".equals(str2)) {
            str2 = str;
        }
        if (this.f7294c && z) {
            m9347a(str2, (Map) map).append(this.f7293b);
        } else if (fnn.KEY_BITRATE.equals(this.f7292a) && z) {
            m9347a(str2, (Map) map).append('\n');
        } else if (!"metadata".equals(this.f7292a) && m9358a(j)) {
            boolean equals = "p".equals(this.f7292a);
            for (Entry entry : map.entrySet()) {
                this.f7300i.put(entry.getKey(), Integer.valueOf(((SpannableStringBuilder) entry.getValue()).length()));
            }
            for (int i = 0; i < m9354a(); i++) {
                boolean z2;
                bpg a = m9355a(i);
                if (z || equals) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                a.m9350a(j, z2, str2, (Map) map);
            }
            if (equals) {
                bpi.m9362a(m9347a(str2, (Map) map));
            }
            for (Entry entry2 : map.entrySet()) {
                this.f7301j.put(entry2.getKey(), Integer.valueOf(((SpannableStringBuilder) entry2.getValue()).length()));
            }
        }
    }

    private static SpannableStringBuilder m9347a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return (SpannableStringBuilder) map.get(str);
    }

    private void m9352a(Map<String, bpj> map, Map<String, SpannableStringBuilder> map2) {
        for (Entry entry : this.f7301j.entrySet()) {
            int intValue;
            String str = (String) entry.getKey();
            if (this.f7300i.containsKey(str)) {
                intValue = ((Integer) this.f7300i.get(str)).intValue();
            } else {
                intValue = 0;
            }
            m9351a((Map) map, (SpannableStringBuilder) map2.get(str), intValue, ((Integer) entry.getValue()).intValue());
            for (int i = 0; i < m9354a(); i++) {
                m9355a(i).m9352a((Map) map, (Map) map2);
            }
        }
    }

    private void m9351a(Map<String, bpj> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (i != i2) {
            bpj a = bpi.m9360a(this.f7297f, this.f7299h, map);
            if (a != null) {
                bpi.m9363a(spannableStringBuilder, i, i2, a);
            }
        }
    }

    private SpannableStringBuilder m9346a(SpannableStringBuilder spannableStringBuilder) {
        int i;
        int length = spannableStringBuilder.length();
        int i2 = 0;
        while (i2 < length) {
            if (spannableStringBuilder.charAt(i2) == ' ') {
                i = i2 + 1;
                while (i < spannableStringBuilder.length() && spannableStringBuilder.charAt(i) == ' ') {
                    i++;
                }
                i -= i2 + 1;
                if (i > 0) {
                    spannableStringBuilder.delete(i2, i2 + i);
                    i = length - i;
                    i2++;
                    length = i;
                }
            }
            i = length;
            i2++;
            length = i;
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        i = length;
        length = 0;
        while (length < i - 1) {
            if (spannableStringBuilder.charAt(length) == '\n' && spannableStringBuilder.charAt(length + 1) == ' ') {
                spannableStringBuilder.delete(length + 1, length + 2);
                i--;
            }
            length++;
        }
        if (i > 0 && spannableStringBuilder.charAt(i - 1) == ' ') {
            spannableStringBuilder.delete(i - 1, i);
            i--;
        }
        length = 0;
        while (length < i - 1) {
            if (spannableStringBuilder.charAt(length) == ' ' && spannableStringBuilder.charAt(length + 1) == '\n') {
                spannableStringBuilder.delete(length, length + 1);
                i--;
            }
            length++;
        }
        if (i > 0 && spannableStringBuilder.charAt(i - 1) == '\n') {
            spannableStringBuilder.delete(i - 1, i);
        }
        return spannableStringBuilder;
    }
}
