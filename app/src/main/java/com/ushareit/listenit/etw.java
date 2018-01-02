package com.ushareit.listenit;

class etw implements Runnable {
    final /* synthetic */ ets f11850a;

    etw(ets com_ushareit_listenit_ets) {
        this.f11850a = com_ushareit_listenit_ets;
    }

    public void run() {
        boolean a;
        boolean b;
        Throwable th;
        boolean z;
        try {
            etr.m17942b(this.f11850a.f11838c);
            if (this.f11850a.f11841f.m17961c() > 0) {
                Thread.sleep(this.f11850a.f11841f.m17961c());
            }
            String c = this.f11850a.f11839d == null ? null : this.f11850a.f11839d.m17922c();
            eub com_ushareit_listenit_eub = new eub(this.f11850a.f11838c);
            a = com_ushareit_listenit_eub.m17966a(this.f11850a.f11836a, this.f11850a.f11841f.m17960b(), c);
            try {
                b = com_ushareit_listenit_eub.m17967b();
            } catch (InterruptedException e) {
                b = false;
                this.f11850a.f11841f.m17958a(a, b, null);
                this.f11850a.f11842g = false;
                this.f11850a.m17951c(eua.CONTINUE_UPLOAD);
                euc.m17971a(this.f11850a.f11836a, a, null);
            } catch (Throwable th2) {
                th = th2;
                z = a;
                a = false;
                this.f11850a.f11841f.m17958a(z, a, null);
                this.f11850a.f11842g = false;
                this.f11850a.m17951c(eua.CONTINUE_UPLOAD);
                euc.m17971a(this.f11850a.f11836a, z, null);
                throw th;
            }
            try {
                Exception a2 = com_ushareit_listenit_eub.m17965a();
                this.f11850a.f11841f.m17958a(a, b, a2);
                this.f11850a.f11842g = false;
                this.f11850a.m17951c(eua.CONTINUE_UPLOAD);
                euc.m17971a(this.f11850a.f11836a, a, a2);
            } catch (InterruptedException e2) {
                this.f11850a.f11841f.m17958a(a, b, null);
                this.f11850a.f11842g = false;
                this.f11850a.m17951c(eua.CONTINUE_UPLOAD);
                euc.m17971a(this.f11850a.f11836a, a, null);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                z = a;
                a = b;
                th = th4;
                this.f11850a.f11841f.m17958a(z, a, null);
                this.f11850a.f11842g = false;
                this.f11850a.m17951c(eua.CONTINUE_UPLOAD);
                euc.m17971a(this.f11850a.f11836a, z, null);
                throw th;
            }
        } catch (InterruptedException e3) {
            b = false;
            a = false;
            this.f11850a.f11841f.m17958a(a, b, null);
            this.f11850a.f11842g = false;
            this.f11850a.m17951c(eua.CONTINUE_UPLOAD);
            euc.m17971a(this.f11850a.f11836a, a, null);
        } catch (Throwable th5) {
            th = th5;
            a = false;
            z = false;
            this.f11850a.f11841f.m17958a(z, a, null);
            this.f11850a.f11842g = false;
            this.f11850a.m17951c(eua.CONTINUE_UPLOAD);
            euc.m17971a(this.f11850a.f11836a, z, null);
            throw th;
        }
    }
}
