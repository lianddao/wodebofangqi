package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class ctt implements ctu {
    private boolean f8972a = false;

    private void m12668b() {
        cyr.m13388a(this.f8972a, "Transaction expected to already be in progress.");
    }

    public cut mo1594a(cvg com_ushareit_listenit_cvg) {
        return new cut(cwt.m13243a(cwr.m13215j(), com_ushareit_listenit_cvg.m13004c()), false, false);
    }

    public <T> T mo1595a(Callable<T> callable) {
        cyr.m13388a(!this.f8972a, "runInTransaction called when an existing transaction is already in progress.");
        this.f8972a = true;
        try {
            T call = callable.call();
            this.f8972a = false;
            return call;
        } catch (Throwable th) {
            this.f8972a = false;
        }
    }

    public List<csz> mo1596a() {
        return Collections.emptyList();
    }

    public void mo1597a(long j) {
        m12668b();
    }

    public void mo1598a(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz) {
        m12668b();
    }

    public void mo1599a(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz, long j) {
        m12668b();
    }

    public void mo1600a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        m12668b();
    }

    public void mo1601a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, long j) {
        m12668b();
    }

    public void mo1602a(cvg com_ushareit_listenit_cvg, cxa com_ushareit_listenit_cxa) {
        m12668b();
    }

    public void mo1603a(cvg com_ushareit_listenit_cvg, Set<cwc> set) {
        m12668b();
    }

    public void mo1604a(cvg com_ushareit_listenit_cvg, Set<cwc> set, Set<cwc> set2) {
        m12668b();
    }

    public void mo1605b(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz) {
        m12668b();
    }

    public void mo1606b(cvg com_ushareit_listenit_cvg) {
        m12668b();
    }

    public void mo1607c(cvg com_ushareit_listenit_cvg) {
        m12668b();
    }

    public void mo1608d(cvg com_ushareit_listenit_cvg) {
        m12668b();
    }
}
