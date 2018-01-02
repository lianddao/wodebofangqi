package com.ushareit.listenit;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class dlu<R extends ceg, A extends cdq> extends dma<R> implements dlv<R> {
    private final cdr<A> f8120a;
    private final cdj<?> f8121b;

    protected dlu(cdj<?> com_ushareit_listenit_cdj_, cdz com_ushareit_listenit_cdz) {
        super((cdz) cfi.m11081a((Object) com_ushareit_listenit_cdz, (Object) "GoogleApiClient must not be null"));
        this.f8120a = com_ushareit_listenit_cdj_.m10911d();
        this.f8121b = com_ushareit_listenit_cdj_;
    }

    private void m10803a(RemoteException remoteException) {
        m10810c(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    protected abstract void mo1277a(A a);

    protected void mo1273a(R r) {
    }

    public /* synthetic */ void mo1274a(Object obj) {
        super.m10793b((ceg) obj);
    }

    public final cdr<A> mo1275b() {
        return this.f8120a;
    }

    public final void m10808b(A a) {
        try {
            mo1277a((cdq) a);
        } catch (RemoteException e) {
            m10803a(e);
            throw e;
        } catch (RemoteException e2) {
            m10803a(e2);
        }
    }

    public final cdj<?> mo1276c() {
        return this.f8121b;
    }

    public final void m10810c(Status status) {
        cfi.m11090b(!status.m2257f(), "Failed result must not be success");
        ceg b = mo1278b(status);
        m10793b(b);
        mo1273a(b);
    }
}
