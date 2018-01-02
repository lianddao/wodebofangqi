package com.ushareit.listenit;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class ql implements ta {
    final /* synthetic */ qk f16334a;

    ql(qk qkVar) {
        this.f16334a = qkVar;
    }

    public void mo3015a(Canvas canvas, RectF rectF, float f, Paint paint) {
        float f2 = f * 2.0f;
        float width = rectF.width() - f2;
        float height = rectF.height() - f2;
        this.f16334a.f16333a.set(rectF.left, rectF.top, rectF.left + (f * 2.0f), rectF.top + (2.0f * f));
        canvas.drawArc(this.f16334a.f16333a, 180.0f, 90.0f, true, paint);
        this.f16334a.f16333a.offset(width, 0.0f);
        canvas.drawArc(this.f16334a.f16333a, 270.0f, 90.0f, true, paint);
        this.f16334a.f16333a.offset(0.0f, height);
        canvas.drawArc(this.f16334a.f16333a, 0.0f, 90.0f, true, paint);
        this.f16334a.f16333a.offset(-width, 0.0f);
        canvas.drawArc(this.f16334a.f16333a, 90.0f, 90.0f, true, paint);
        canvas.drawRect(rectF.left + f, rectF.top, rectF.right - f, rectF.top + f, paint);
        canvas.drawRect(rectF.left + f, rectF.bottom - f, rectF.right - f, rectF.bottom, paint);
        canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
    }
}
