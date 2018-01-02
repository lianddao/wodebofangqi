package com.ushareit.listenit;

import android.view.View;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qs extends tc {
    private ArrayList<sv> f16348b = new ArrayList();
    private ArrayList<sv> f16349c = new ArrayList();
    private ArrayList<rc> f16350d = new ArrayList();
    private ArrayList<rb> f16351e = new ArrayList();
    private ArrayList<ArrayList<sv>> f16352f = new ArrayList();
    private ArrayList<ArrayList<rc>> f16353g = new ArrayList();
    private ArrayList<ArrayList<rb>> f16354h = new ArrayList();
    private ArrayList<sv> f16355i = new ArrayList();
    private ArrayList<sv> f16356j = new ArrayList();
    private ArrayList<sv> f16357k = new ArrayList();
    private ArrayList<sv> f16358l = new ArrayList();

    public void mo3021a() {
        int i;
        int i2;
        int i3;
        int i4 = !this.f16348b.isEmpty() ? 1 : 0;
        if (this.f16350d.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.f16351e.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.f16349c.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            ArrayList arrayList;
            Runnable qtVar;
            Iterator it = this.f16348b.iterator();
            while (it.hasNext()) {
                m25890t((sv) it.next());
            }
            this.f16348b.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f16350d);
                this.f16353g.add(arrayList);
                this.f16350d.clear();
                qtVar = new qt(this, arrayList);
                if (i4 != 0) {
                    ja.m24142a(((rc) arrayList.get(0)).f16391a.itemView, qtVar, m25842f());
                } else {
                    qtVar.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f16351e);
                this.f16354h.add(arrayList);
                this.f16351e.clear();
                qtVar = new qu(this, arrayList);
                if (i4 != 0) {
                    ja.m24142a(((rb) arrayList.get(0)).f16385a.itemView, qtVar, m25842f());
                } else {
                    qtVar.run();
                }
            }
            if (i3 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f16349c);
                this.f16352f.add(arrayList2);
                this.f16349c.clear();
                Runnable qvVar = new qv(this, arrayList2);
                if (i4 == 0 && i == 0 && i2 == 0) {
                    qvVar.run();
                    return;
                }
                long d;
                long g;
                long f = i4 != 0 ? m25842f() : 0;
                if (i != 0) {
                    d = m25839d();
                } else {
                    d = 0;
                }
                if (i2 != 0) {
                    g = m25844g();
                } else {
                    g = 0;
                }
                ja.m24142a(((sv) arrayList2.get(0)).itemView, qvVar, f + Math.max(d, g));
            }
        }
    }

    public boolean mo3022a(sv svVar) {
        m25892v(svVar);
        this.f16348b.add(svVar);
        return true;
    }

    private void m25890t(sv svVar) {
        lj p = ja.m24170p(svVar.itemView);
        this.f16357k.add(svVar);
        p.m24448a(m25842f()).m24447a(0.0f).m24449a(new qw(this, svVar, p)).m24452b();
    }

    public boolean mo3026b(sv svVar) {
        m25892v(svVar);
        ja.m24150c(svVar.itemView, 0.0f);
        this.f16349c.add(svVar);
        return true;
    }

    private void m25891u(sv svVar) {
        lj p = ja.m24170p(svVar.itemView);
        this.f16355i.add(svVar);
        p.m24447a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT).m24448a(m25840e()).m24449a(new qx(this, svVar, p)).m24452b();
    }

    public boolean mo3023a(sv svVar, int i, int i2, int i3, int i4) {
        View view = svVar.itemView;
        int l = (int) (((float) i) + ja.m24166l(svVar.itemView));
        int m = (int) (((float) i2) + ja.m24167m(svVar.itemView));
        m25892v(svVar);
        int i5 = i3 - l;
        int i6 = i4 - m;
        if (i5 == 0 && i6 == 0) {
            m25862i(svVar);
            return false;
        }
        if (i5 != 0) {
            ja.m24135a(view, (float) (-i5));
        }
        if (i6 != 0) {
            ja.m24147b(view, (float) (-i6));
        }
        this.f16350d.add(new rc(svVar, l, m, i3, i4));
        return true;
    }

    private void m25882b(sv svVar, int i, int i2, int i3, int i4) {
        View view = svVar.itemView;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            ja.m24170p(view).m24451b(0.0f);
        }
        if (i6 != 0) {
            ja.m24170p(view).m24453c(0.0f);
        }
        lj p = ja.m24170p(view);
        this.f16356j.add(svVar);
        p.m24448a(m25839d()).m24449a(new qy(this, svVar, i5, i6, p)).m24452b();
    }

    public boolean mo3024a(sv svVar, sv svVar2, int i, int i2, int i3, int i4) {
        if (svVar == svVar2) {
            return mo3023a(svVar, i, i2, i3, i4);
        }
        float l = ja.m24166l(svVar.itemView);
        float m = ja.m24167m(svVar.itemView);
        float f = ja.m24159f(svVar.itemView);
        m25892v(svVar);
        int i5 = (int) (((float) (i3 - i)) - l);
        int i6 = (int) (((float) (i4 - i2)) - m);
        ja.m24135a(svVar.itemView, l);
        ja.m24147b(svVar.itemView, m);
        ja.m24150c(svVar.itemView, f);
        if (svVar2 != null) {
            m25892v(svVar2);
            ja.m24135a(svVar2.itemView, (float) (-i5));
            ja.m24147b(svVar2.itemView, (float) (-i6));
            ja.m24150c(svVar2.itemView, 0.0f);
        }
        this.f16351e.add(new rb(svVar, svVar2, i, i2, i3, i4));
        return true;
    }

    private void m25877a(rb rbVar) {
        View view = null;
        sv svVar = rbVar.f16385a;
        View view2 = svVar == null ? null : svVar.itemView;
        sv svVar2 = rbVar.f16386b;
        if (svVar2 != null) {
            view = svVar2.itemView;
        }
        if (view2 != null) {
            lj a = ja.m24170p(view2).m24448a(m25844g());
            this.f16358l.add(rbVar.f16385a);
            a.m24451b((float) (rbVar.f16389e - rbVar.f16387c));
            a.m24453c((float) (rbVar.f16390f - rbVar.f16388d));
            a.m24447a(0.0f).m24449a(new qz(this, rbVar, a)).m24452b();
        }
        if (view != null) {
            a = ja.m24170p(view);
            this.f16358l.add(rbVar.f16386b);
            a.m24451b(0.0f).m24453c(0.0f).m24448a(m25844g()).m24447a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT).m24449a(new ra(this, rbVar, a, view)).m24452b();
        }
    }

    private void m25878a(List<rb> list, sv svVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            rb rbVar = (rb) list.get(size);
            if (m25879a(rbVar, svVar) && rbVar.f16385a == null && rbVar.f16386b == null) {
                list.remove(rbVar);
            }
        }
    }

    private void m25881b(rb rbVar) {
        if (rbVar.f16385a != null) {
            m25879a(rbVar, rbVar.f16385a);
        }
        if (rbVar.f16386b != null) {
            m25879a(rbVar, rbVar.f16386b);
        }
    }

    private boolean m25879a(rb rbVar, sv svVar) {
        boolean z = false;
        if (rbVar.f16386b == svVar) {
            rbVar.f16386b = null;
        } else if (rbVar.f16385a != svVar) {
            return false;
        } else {
            rbVar.f16385a = null;
            z = true;
        }
        ja.m24150c(svVar.itemView, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        ja.m24135a(svVar.itemView, 0.0f);
        ja.m24147b(svVar.itemView, 0.0f);
        m25848a(svVar, z);
        return true;
    }

    public void mo3028c(sv svVar) {
        int size;
        View view = svVar.itemView;
        ja.m24170p(view).m24450a();
        for (size = this.f16350d.size() - 1; size >= 0; size--) {
            if (((rc) this.f16350d.get(size)).f16391a == svVar) {
                ja.m24147b(view, 0.0f);
                ja.m24135a(view, 0.0f);
                m25862i(svVar);
                this.f16350d.remove(size);
            }
        }
        m25878a(this.f16351e, svVar);
        if (this.f16348b.remove(svVar)) {
            ja.m24150c(view, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            m25861h(svVar);
        }
        if (this.f16349c.remove(svVar)) {
            ja.m24150c(view, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            m25863j(svVar);
        }
        for (size = this.f16354h.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f16354h.get(size);
            m25878a(list, svVar);
            if (list.isEmpty()) {
                this.f16354h.remove(size);
            }
        }
        for (int size2 = this.f16353g.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f16353g.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((rc) arrayList.get(size3)).f16391a == svVar) {
                    ja.m24147b(view, 0.0f);
                    ja.m24135a(view, 0.0f);
                    m25862i(svVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f16353g.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f16352f.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f16352f.get(size);
            if (arrayList.remove(svVar)) {
                ja.m24150c(view, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                m25863j(svVar);
                if (arrayList.isEmpty()) {
                    this.f16352f.remove(size);
                }
            }
        }
        if (this.f16357k.remove(svVar)) {
        }
        if (this.f16355i.remove(svVar)) {
        }
        if (this.f16358l.remove(svVar)) {
        }
        if (this.f16356j.remove(svVar)) {
            m25889j();
        } else {
            m25889j();
        }
    }

    private void m25892v(sv svVar) {
        C0360j.m24131a(svVar.itemView);
        mo3028c(svVar);
    }

    public boolean mo3025b() {
        return (this.f16349c.isEmpty() && this.f16351e.isEmpty() && this.f16350d.isEmpty() && this.f16348b.isEmpty() && this.f16356j.isEmpty() && this.f16357k.isEmpty() && this.f16355i.isEmpty() && this.f16358l.isEmpty() && this.f16353g.isEmpty() && this.f16352f.isEmpty() && this.f16354h.isEmpty()) ? false : true;
    }

    private void m25889j() {
        if (!mo3025b()) {
            m25846h();
        }
    }

    public void mo3027c() {
        int size;
        for (size = this.f16350d.size() - 1; size >= 0; size--) {
            rc rcVar = (rc) this.f16350d.get(size);
            View view = rcVar.f16391a.itemView;
            ja.m24147b(view, 0.0f);
            ja.m24135a(view, 0.0f);
            m25862i(rcVar.f16391a);
            this.f16350d.remove(size);
        }
        for (size = this.f16348b.size() - 1; size >= 0; size--) {
            m25861h((sv) this.f16348b.get(size));
            this.f16348b.remove(size);
        }
        for (size = this.f16349c.size() - 1; size >= 0; size--) {
            sv svVar = (sv) this.f16349c.get(size);
            ja.m24150c(svVar.itemView, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            m25863j(svVar);
            this.f16349c.remove(size);
        }
        for (size = this.f16351e.size() - 1; size >= 0; size--) {
            m25881b((rb) this.f16351e.get(size));
        }
        this.f16351e.clear();
        if (mo3025b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.f16353g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f16353g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    rc rcVar2 = (rc) arrayList.get(size3);
                    View view2 = rcVar2.f16391a.itemView;
                    ja.m24147b(view2, 0.0f);
                    ja.m24135a(view2, 0.0f);
                    m25862i(rcVar2.f16391a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f16353g.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f16352f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f16352f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    sv svVar2 = (sv) arrayList.get(size3);
                    ja.m24150c(svVar2.itemView, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                    m25863j(svVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f16352f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f16354h.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f16354h.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m25881b((rb) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.f16354h.remove(arrayList);
                    }
                }
            }
            m25894a(this.f16357k);
            m25894a(this.f16356j);
            m25894a(this.f16355i);
            m25894a(this.f16358l);
            m25846h();
        }
    }

    void m25894a(List<sv> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ja.m24170p(((sv) list.get(size)).itemView).m24450a();
        }
    }
}
