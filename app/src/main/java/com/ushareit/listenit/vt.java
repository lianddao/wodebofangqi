package com.ushareit.listenit;

class vt implements vn {
    private final xh f17073a;
    private volatile xg f17074b;

    public vt(xh xhVar) {
        this.f17073a = xhVar;
    }

    public xg mo3113a() {
        if (this.f17074b == null) {
            synchronized (this) {
                if (this.f17074b == null) {
                    this.f17074b = this.f17073a.mo3138a();
                }
                if (this.f17074b == null) {
                    this.f17074b = new xj();
                }
            }
        }
        return this.f17074b;
    }
}
