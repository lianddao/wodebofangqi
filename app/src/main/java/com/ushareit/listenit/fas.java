package com.ushareit.listenit;

final class fas implements Runnable {
    final /* synthetic */ eyo f12341a;
    final /* synthetic */ fau f12342b;
    final /* synthetic */ long f12343c;

    fas(eyo com_ushareit_listenit_eyo, fau com_ushareit_listenit_fau, long j) {
        this.f12341a = com_ushareit_listenit_eyo;
        this.f12342b = com_ushareit_listenit_fau;
        this.f12343c = j;
    }

    public void run() {
        fay com_ushareit_listenit_fay = (fay) this.f12341a.m18560a();
        if (fau.f12349a) {
            this.f12342b.m18742a(com_ushareit_listenit_fay.f11676b);
        }
        if (!com_ushareit_listenit_fay.m17707b()) {
            try {
                com_ushareit_listenit_fay.mo2280a();
            } catch (Throwable e) {
                com_ushareit_listenit_fay.f11680f = e;
                exw.m18444a("TaskHelper", e.toString(), e);
                if (exw.f12142a) {
                    e.printStackTrace();
                }
            } catch (Throwable e2) {
                com_ushareit_listenit_fay.f11680f = new RuntimeException(e2);
                esr.m17813a(eys.m18562a(), e2);
                exw.m18452b("TaskHelper", e2);
            }
            if (!com_ushareit_listenit_fay.m17707b()) {
                faq.f12329a.sendMessageDelayed(faq.f12329a.obtainMessage(1, this.f12341a), this.f12343c);
            }
        }
    }
}
