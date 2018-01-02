package com.ushareit.listenit;

import java.util.List;
import java.util.Map;

class cpc {
    private final List<String> f8618a;
    private final Map<String, Object> f8619b;

    public cpc(List<String> list, Map<String, Object> map) {
        this.f8618a = list;
        this.f8619b = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cpc)) {
            return false;
        }
        cpc com_ushareit_listenit_cpc = (cpc) obj;
        return this.f8618a.equals(com_ushareit_listenit_cpc.f8618a) ? this.f8619b.equals(com_ushareit_listenit_cpc.f8619b) : false;
    }

    public int hashCode() {
        return (this.f8618a.hashCode() * 31) + this.f8619b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(com.m12032a(this.f8618a));
        String valueOf2 = String.valueOf(this.f8619b);
        return new StringBuilder((String.valueOf(valueOf).length() + 11) + String.valueOf(valueOf2).length()).append(valueOf).append(" (params: ").append(valueOf2).append(")").toString();
    }
}
