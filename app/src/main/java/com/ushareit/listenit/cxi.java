package com.ushareit.listenit;

public class cxi extends cwv<cxi> {
    private final String f9308a;

    public cxi(String str, cxa com_ushareit_listenit_cxa) {
        super(com_ushareit_listenit_cxa);
        this.f9308a = str;
    }

    protected int m13294a(cxi com_ushareit_listenit_cxi) {
        return this.f9308a.compareTo(com_ushareit_listenit_cxi.f9308a);
    }

    public cxi m13295a(cxa com_ushareit_listenit_cxa) {
        return new cxi(this.f9308a, com_ushareit_listenit_cxa);
    }

    public Object mo1643a() {
        return this.f9308a;
    }

    public String mo1644a(cxc com_ushareit_listenit_cxc) {
        String valueOf;
        String str;
        switch (cxj.f9309a[com_ushareit_listenit_cxc.ordinal()]) {
            case 1:
                valueOf = String.valueOf(m13123b(com_ushareit_listenit_cxc));
                str = this.f9308a;
                return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(str).length()).append(valueOf).append("string:").append(str).toString();
            case 2:
                valueOf = String.valueOf(m13123b(com_ushareit_listenit_cxc));
                str = String.valueOf(cyr.m13390c(this.f9308a));
                return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(str).length()).append(valueOf).append("string:").append(str).toString();
            default:
                str = String.valueOf(com_ushareit_listenit_cxc);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 38).append("Invalid hash version for string node: ").append(str).toString());
        }
    }

    public /* synthetic */ cxa mo1645b(cxa com_ushareit_listenit_cxa) {
        return m13295a(com_ushareit_listenit_cxa);
    }

    protected cwx c_() {
        return cwx.String;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cxi)) {
            return false;
        }
        cxi com_ushareit_listenit_cxi = (cxi) obj;
        return this.f9308a.equals(com_ushareit_listenit_cxi.f9308a) && this.b.equals(com_ushareit_listenit_cxi.b);
    }

    public int hashCode() {
        return this.f9308a.hashCode() + this.b.hashCode();
    }
}
