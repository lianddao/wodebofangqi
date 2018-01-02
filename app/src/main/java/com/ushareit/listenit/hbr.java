package com.ushareit.listenit;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.ushareit.listenit.widget.IndexableListView;

public class hbr extends SimpleOnGestureListener {
    final /* synthetic */ IndexableListView f15158a;

    public hbr(IndexableListView indexableListView) {
        this.f15158a = indexableListView;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f15158a.f17225b != null) {
            this.f15158a.f17225b.m23539b();
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }
}
