package com.ushareit.listenit;

class gxz<T> {
    final /* synthetic */ gxx f14892a;
    private T[] f14893b = new Object[10];
    private int f14894c = 0;
    private int f14895d = 10;

    public gxz(gxx com_ushareit_listenit_gxx) {
        this.f14892a = com_ushareit_listenit_gxx;
    }

    public int m23117a() {
        return this.f14894c;
    }

    public T m23120b() {
        if (this.f14894c > 0) {
            this.f14894c--;
        }
        return this.f14893b[this.f14894c];
    }

    public void m23118a(T t) {
        if (this.f14894c >= this.f14895d) {
            m23116a(this.f14895d * 2);
        }
        Object[] objArr = this.f14893b;
        int i = this.f14894c;
        this.f14894c = i + 1;
        objArr[i] = t;
    }

    public void m23119a(T[] tArr) {
        if (tArr != null && tArr.length != 0) {
            if (this.f14894c + tArr.length >= this.f14895d) {
                m23116a(this.f14895d + tArr.length);
            }
            System.arraycopy(tArr, 0, this.f14893b, this.f14894c, tArr.length);
            this.f14894c += tArr.length;
        }
    }

    private void m23116a(int i) {
        Object[] objArr = new Object[i];
        System.arraycopy(this.f14893b, 0, objArr, 0, this.f14894c);
        this.f14893b = objArr;
        this.f14895d = i;
    }
}
