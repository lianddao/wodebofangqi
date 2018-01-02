package com.ushareit.listenit;

import java.util.List;
import java.util.Map;

public final class brz extends brx {
    public final int f7571c;
    public final Map<String, List<String>> f7572d;

    public brz(int i, Map<String, List<String>> map, brk com_ushareit_listenit_brk) {
        super("Response code: " + i, com_ushareit_listenit_brk, 1);
        this.f7571c = i;
        this.f7572d = map;
    }
}
