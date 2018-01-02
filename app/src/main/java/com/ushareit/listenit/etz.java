package com.ushareit.listenit;

class etz {
    boolean f11860a;
    boolean f11861b;
    Exception f11862c;
    int f11863d = 0;
    final /* synthetic */ ety f11864e;

    etz(ety com_ushareit_listenit_ety, boolean z, boolean z2, Exception exception) {
        this.f11864e = com_ushareit_listenit_ety;
        this.f11860a = z;
        this.f11861b = z2;
        this.f11862c = exception;
    }

    public String toString() {
        return "LastResult [succeed=" + this.f11860a + ", error=" + this.f11862c + ", retryCount=" + this.f11863d + ", hasEvents=" + this.f11861b + "]";
    }
}
