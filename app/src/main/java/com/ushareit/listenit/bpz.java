package com.ushareit.listenit;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class bpz implements bop {
    private final List<bpr> f7383a;
    private final int f7384b;
    private final long[] f7385c = new long[(this.f7384b * 2)];
    private final long[] f7386d;

    public bpz(List<bpr> list) {
        this.f7383a = list;
        this.f7384b = list.size();
        for (int i = 0; i < this.f7384b; i++) {
            bpr com_ushareit_listenit_bpr = (bpr) list.get(i);
            int i2 = i * 2;
            this.f7385c[i2] = com_ushareit_listenit_bpr.f7353i;
            this.f7385c[i2 + 1] = com_ushareit_listenit_bpr.f7354j;
        }
        this.f7386d = Arrays.copyOf(this.f7385c, this.f7385c.length);
        Arrays.sort(this.f7386d);
    }

    public int mo1063a(long j) {
        int b = btc.m9773b(this.f7386d, j, false, false);
        return b < this.f7386d.length ? b : -1;
    }

    public int mo1065b() {
        return this.f7386d.length;
    }

    public long mo1064a(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        bsg.m9656a(z);
        if (i >= this.f7386d.length) {
            z2 = false;
        }
        bsg.m9656a(z2);
        return this.f7386d[i];
    }

    public List<bom> mo1066b(long j) {
        CharSequence charSequence = null;
        int i = 0;
        bpr com_ushareit_listenit_bpr = null;
        ArrayList arrayList = null;
        while (i < this.f7384b) {
            CharSequence charSequence2;
            bpr com_ushareit_listenit_bpr2;
            ArrayList arrayList2;
            CharSequence charSequence3;
            if (this.f7385c[i * 2] > j || j >= this.f7385c[(i * 2) + 1]) {
                charSequence2 = charSequence;
                com_ushareit_listenit_bpr2 = com_ushareit_listenit_bpr;
                arrayList2 = arrayList;
                charSequence3 = charSequence2;
            } else {
                ArrayList arrayList3;
                if (arrayList == null) {
                    arrayList3 = new ArrayList();
                } else {
                    arrayList3 = arrayList;
                }
                bpr com_ushareit_listenit_bpr3 = (bpr) this.f7383a.get(i);
                if (!com_ushareit_listenit_bpr3.m9442a()) {
                    arrayList3.add(com_ushareit_listenit_bpr3);
                    charSequence3 = charSequence;
                    com_ushareit_listenit_bpr2 = com_ushareit_listenit_bpr;
                    arrayList2 = arrayList3;
                } else if (com_ushareit_listenit_bpr == null) {
                    arrayList2 = arrayList3;
                    bpr com_ushareit_listenit_bpr4 = com_ushareit_listenit_bpr3;
                    charSequence3 = charSequence;
                    com_ushareit_listenit_bpr2 = com_ushareit_listenit_bpr4;
                } else if (charSequence == null) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(com_ushareit_listenit_bpr.a).append("\n").append(com_ushareit_listenit_bpr3.a);
                    Object obj = spannableStringBuilder;
                    com_ushareit_listenit_bpr2 = com_ushareit_listenit_bpr;
                    arrayList2 = arrayList3;
                } else {
                    charSequence.append("\n").append(com_ushareit_listenit_bpr3.a);
                    charSequence3 = charSequence;
                    com_ushareit_listenit_bpr2 = com_ushareit_listenit_bpr;
                    arrayList2 = arrayList3;
                }
            }
            i++;
            charSequence2 = charSequence3;
            arrayList = arrayList2;
            com_ushareit_listenit_bpr = com_ushareit_listenit_bpr2;
            charSequence = charSequence2;
        }
        if (charSequence != null) {
            arrayList.add(new bpr(charSequence));
        } else if (com_ushareit_listenit_bpr != null) {
            arrayList.add(com_ushareit_listenit_bpr);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
