package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

public class aok {
    private List<aog> f5045a = new ArrayList();
    private int f5046b = 0;
    private aol f5047c;
    private String f5048d;

    public aok(aol com_ushareit_listenit_aol, String str) {
        this.f5047c = com_ushareit_listenit_aol;
        this.f5048d = str;
    }

    public aol m6458a() {
        return this.f5047c;
    }

    public void m6459a(aog com_ushareit_listenit_aog) {
        this.f5045a.add(com_ushareit_listenit_aog);
    }

    public String m6460b() {
        return this.f5048d;
    }

    public aog m6461c() {
        if (this.f5046b >= this.f5045a.size()) {
            return null;
        }
        this.f5046b++;
        return (aog) this.f5045a.get(this.f5046b - 1);
    }
}
