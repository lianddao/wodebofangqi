package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

public class qk implements qm {
    final RectF f16333a = new RectF();

    public void mo3003a() {
        sz.f16560c = new ql(this);
    }

    public void mo3005a(qj qjVar, Context context, int i, float f, float f2, float f3) {
        Drawable a = m25771a(context, i, f, f2, f3);
        a.m26240a(qjVar.getPreventCornerOverlap());
        qjVar.setBackgroundDrawable(a);
        mo3012f(qjVar);
    }

    sz m25771a(Context context, int i, float f, float f2, float f3) {
        return new sz(context.getResources(), i, f, f2, f3);
    }

    public void mo3012f(qj qjVar) {
        Rect rect = new Rect();
        m25769i(qjVar).m26239a(rect);
        ((View) qjVar).setMinimumHeight((int) Math.ceil((double) mo3008c(qjVar)));
        ((View) qjVar).setMinimumWidth((int) Math.ceil((double) mo3006b(qjVar)));
        qjVar.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void mo3013g(qj qjVar) {
    }

    public void mo3014h(qj qjVar) {
        m25769i(qjVar).m26240a(qjVar.getPreventCornerOverlap());
        mo3012f(qjVar);
    }

    public void mo3004a(qj qjVar, float f) {
        m25769i(qjVar).m26237a(f);
        mo3012f(qjVar);
    }

    public float mo3010d(qj qjVar) {
        return m25769i(qjVar).m26236a();
    }

    public void mo3009c(qj qjVar, float f) {
        m25769i(qjVar).m26242b(f);
    }

    public float mo3011e(qj qjVar) {
        return m25769i(qjVar).m26241b();
    }

    public void mo3007b(qj qjVar, float f) {
        m25769i(qjVar).m26244c(f);
        mo3012f(qjVar);
    }

    public float mo3002a(qj qjVar) {
        return m25769i(qjVar).m26243c();
    }

    public float mo3006b(qj qjVar) {
        return m25769i(qjVar).m26245d();
    }

    public float mo3008c(qj qjVar) {
        return m25769i(qjVar).m26246e();
    }

    private sz m25769i(qj qjVar) {
        return (sz) qjVar.getBackground();
    }
}
