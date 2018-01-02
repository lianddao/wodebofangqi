package com.ushareit.listenit;

import com.google.android.gms.phenotype.Flag;
import java.util.Comparator;

public class dyu implements Comparator<Flag> {
    public int m16496a(Flag flag, Flag flag2) {
        return flag.f1927i == flag2.f1927i ? flag.f1920b.compareTo(flag2.f1920b) : flag.f1927i - flag2.f1927i;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m16496a((Flag) obj, (Flag) obj2);
    }
}
