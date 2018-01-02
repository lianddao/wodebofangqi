package com.ushareit.listenit;

class ddf implements CharSequence {
    char[] f9584a;

    ddf() {
    }

    public char charAt(int i) {
        return this.f9584a[i];
    }

    public int length() {
        return this.f9584a.length;
    }

    public CharSequence subSequence(int i, int i2) {
        return new String(this.f9584a, i, i2 - i);
    }
}
