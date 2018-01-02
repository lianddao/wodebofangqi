package com.ushareit.listenit;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

class gyd extends hhw {
    List<glg> f14904a = new ArrayList();
    final /* synthetic */ gla f14905b;
    final /* synthetic */ hac f14906c;
    final /* synthetic */ String f14907d;
    final /* synthetic */ gye f14908e;
    final /* synthetic */ gyb f14909f;
    private Bitmap f14910g = null;
    private boolean f14911h;

    gyd(gyb com_ushareit_listenit_gyb, gla com_ushareit_listenit_gla, hac com_ushareit_listenit_hac, String str, gye com_ushareit_listenit_gye) {
        this.f14909f = com_ushareit_listenit_gyb;
        this.f14905b = com_ushareit_listenit_gla;
        this.f14906c = com_ushareit_listenit_hac;
        this.f14907d = str;
        this.f14908e = com_ushareit_listenit_gye;
    }

    public void execute() {
        if (this.f14905b instanceof glg) {
            this.f14904a.add((glg) this.f14905b);
        } else {
            this.f14904a.addAll(fqs.m20453a(this.f14905b));
        }
        if (this.f14904a.size() == 0) {
            this.f14910g = gyn.m23172a(this.f14906c.m23434b(), this.f14906c.m23435c());
            this.f14911h = true;
            return;
        }
        System.currentTimeMillis();
        int i = 20;
        int i2 = -1;
        for (glg com_ushareit_listenit_glg : this.f14904a) {
            if (i != 0 && !m23135c()) {
                i--;
                if (!gyn.m23250j(com_ushareit_listenit_glg.f14343k)) {
                    this.f14910g = gyn.m23175a(eyh.m18491a(com_ushareit_listenit_glg.f14343k), this.f14906c.m23434b(), this.f14906c.m23435c());
                } else if (i2 == -1) {
                    i2 = Integer.parseInt(com_ushareit_listenit_glg.f14343k);
                }
                if (this.f14910g == null && !m23135c()) {
                    this.f14910g = gyn.m23176a(com_ushareit_listenit_glg.f14342j, this.f14906c.m23434b(), this.f14906c.m23435c());
                }
                if (this.f14910g != null) {
                    break;
                }
            }
            break;
        }
        if (this.f14910g == null && !m23135c()) {
            this.f14910g = gyn.m23173a(i2, this.f14906c.m23434b(), this.f14906c.m23435c());
        }
    }

    public void callback() {
        if (!m23135c()) {
            if (!(this.f14911h || this.f14910g == null)) {
                this.f14909f.f14900c.put(this.f14907d, this.f14910g);
            }
            if (!m23135c()) {
                this.f14908e.mo2630a(this.f14910g);
            }
        }
    }

    private boolean m23135c() {
        return !this.f14906c.f15034d.getTag(C0349R.id.glide_view_tag_id).equals(this.f14906c.m23433a());
    }
}
