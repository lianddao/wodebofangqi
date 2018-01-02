package com.ushareit.listenit.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.ushareit.listenit.hbp;
import com.ushareit.listenit.hbr;

public class IndexableListView extends ListView {
    private boolean f17224a = false;
    private hbp f17225b = null;
    private GestureDetector f17226c = null;

    public IndexableListView(Context context) {
        super(context);
    }

    public IndexableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IndexableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean isFastScrollEnabled() {
        return this.f17224a;
    }

    public void setFastScrollEnabled(boolean z) {
        this.f17224a = z;
        if (this.f17224a) {
            if (this.f17225b == null) {
                this.f17225b = new hbp(getContext(), this);
            }
        } else if (this.f17225b != null) {
            this.f17225b.m23540c();
            this.f17225b = null;
        }
    }

    public void m26827a(boolean z) {
        this.f17224a = z;
        if (this.f17225b == null) {
            this.f17225b = new hbp(getContext(), this);
        }
        if (this.f17224a) {
            this.f17225b.m23542e();
        } else if (this.f17225b != null) {
            this.f17225b.m23540c();
            this.f17225b.m23541d();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f17225b != null && this.f17225b.m23543f()) {
            this.f17225b.m23534a(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f17225b != null && this.f17225b.m23538a(motionEvent)) {
            return true;
        }
        if (this.f17226c == null) {
            this.f17226c = new GestureDetector(getContext(), new hbr(this));
        }
        this.f17226c.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f17225b != null && this.f17225b.m23537a(motionEvent.getX(), motionEvent.getY()) && this.f17225b.m23536a()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (this.f17225b != null) {
            this.f17225b.m23535a((Adapter) listAdapter);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f17225b != null) {
            this.f17225b.m23533a(i, i2, i3, i4);
        }
    }

    protected void onDetachedFromWindow() {
        if (this.f17225b != null) {
            this.f17225b.m23544g();
        }
        super.onDetachedFromWindow();
    }
}
