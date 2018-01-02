package com.ushareit.listenit;

public class ti {
    final fq<sv, tj> f16759a = new fq();
    final fv<sv> f16760b = new fv();

    public void m26339a() {
        this.f16759a.clear();
        this.f16760b.m21059c();
    }

    public void m26341a(sv svVar, se seVar) {
        tj tjVar = (tj) this.f16759a.get(svVar);
        if (tjVar == null) {
            tjVar = tj.m26350a();
            this.f16759a.put(svVar, tjVar);
        }
        tjVar.f16763b = seVar;
        tjVar.f16762a |= 4;
    }

    public se m26337a(sv svVar) {
        int a = this.f16759a.m20338a((Object) svVar);
        if (a < 0) {
            return null;
        }
        tj tjVar = (tj) this.f16759a.m20345c(a);
        if (tjVar == null || (tjVar.f16762a & 4) == 0) {
            return null;
        }
        tjVar.f16762a &= -5;
        se seVar = tjVar.f16763b;
        if (tjVar.f16762a == 0) {
            this.f16759a.m20346d(a);
            tj.m26351a(tjVar);
        }
        return seVar;
    }

    public void m26340a(long j, sv svVar) {
        this.f16760b.m21057b(j, svVar);
    }

    public void m26344b(sv svVar, se seVar) {
        tj tjVar = (tj) this.f16759a.get(svVar);
        if (tjVar == null) {
            tjVar = tj.m26350a();
            this.f16759a.put(svVar, tjVar);
        }
        tjVar.f16762a |= 2;
        tjVar.f16763b = seVar;
    }

    public boolean m26345b(sv svVar) {
        tj tjVar = (tj) this.f16759a.get(svVar);
        return (tjVar == null || (tjVar.f16762a & 4) == 0) ? false : true;
    }

    public sv m26338a(long j) {
        return (sv) this.f16760b.m21052a(j);
    }

    public void m26347c(sv svVar, se seVar) {
        tj tjVar = (tj) this.f16759a.get(svVar);
        if (tjVar == null) {
            tjVar = tj.m26350a();
            this.f16759a.put(svVar, tjVar);
        }
        tjVar.f16764c = seVar;
        tjVar.f16762a |= 8;
    }

    void m26346c(sv svVar) {
        tj tjVar = (tj) this.f16759a.get(svVar);
        if (tjVar == null) {
            tjVar = tj.m26350a();
            this.f16759a.put(svVar, tjVar);
        }
        r0.f16762a |= 1;
    }

    void m26348d(sv svVar) {
        tj tjVar = (tj) this.f16759a.get(svVar);
        if (tjVar != null) {
            tjVar.f16762a &= -2;
        }
    }

    public void m26342a(tk tkVar) {
        for (int size = this.f16759a.size() - 1; size >= 0; size--) {
            sv svVar = (sv) this.f16759a.m20344b(size);
            tj tjVar = (tj) this.f16759a.m20346d(size);
            if ((tjVar.f16762a & 3) == 3) {
                tkVar.mo3039a(svVar);
            } else if ((tjVar.f16762a & 1) != 0) {
                tkVar.mo3040a(svVar, tjVar.f16763b, tjVar.f16764c);
            } else if ((tjVar.f16762a & 14) == 14) {
                tkVar.mo3041b(svVar, tjVar.f16763b, tjVar.f16764c);
            } else if ((tjVar.f16762a & 12) == 12) {
                tkVar.mo3042c(svVar, tjVar.f16763b, tjVar.f16764c);
            } else if ((tjVar.f16762a & 4) != 0) {
                tkVar.mo3040a(svVar, tjVar.f16763b, null);
            } else if ((tjVar.f16762a & 8) != 0) {
                tkVar.mo3041b(svVar, tjVar.f16763b, tjVar.f16764c);
            } else if ((tjVar.f16762a & 2) != 0) {
            }
            tj.m26351a(tjVar);
        }
    }

    void m26349e(sv svVar) {
        for (int b = this.f16760b.m21055b() - 1; b >= 0; b--) {
            if (svVar == this.f16760b.m21058c(b)) {
                this.f16760b.m21054a(b);
                break;
            }
        }
        tj tjVar = (tj) this.f16759a.remove(svVar);
        if (tjVar != null) {
            tj.m26351a(tjVar);
        }
    }

    public void m26343b() {
        tj.m26352b();
    }
}
