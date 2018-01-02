package com.ushareit.listenit;

class cwe extends cwc {
    private final int f9255b;

    cwe(String str, int i) {
        super(str);
        this.f9255b = i;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return super.m13143a((cwc) obj);
    }

    protected boolean mo1648f() {
        return true;
    }

    protected int mo1649g() {
        return this.f9255b;
    }

    public String toString() {
        String b = this.f9254b;
        return new StringBuilder(String.valueOf(b).length() + 20).append("IntegerChildName(\"").append(b).append("\")").toString();
    }
}
