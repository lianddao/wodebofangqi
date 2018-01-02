package com.ushareit.listenit;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;

public class heh extends hfa implements OnGestureListener, OnTouchListener {
    private int f15252a = 0;
    private boolean f15253b = true;
    private int f15254c;
    private boolean f15255d = false;
    private boolean f15256e = false;
    private GestureDetector f15257f;
    private GestureDetector f15258g;
    private int f15259h;
    private int f15260i = -1;
    private int f15261j = -1;
    private int f15262k = -1;
    private int[] f15263l = new int[2];
    private int f15264m;
    private int f15265n;
    private int f15266o;
    private int f15267p;
    private boolean f15268q = false;
    private float f15269r = 500.0f;
    private int f15270s;
    private int f15271t;
    private int f15272u;
    private boolean f15273v;
    private DragSortListView f15274w;
    private int f15275x;
    private OnGestureListener f15276y = new hei(this);

    public heh(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        this.f15274w = dragSortListView;
        this.f15257f = new GestureDetector(dragSortListView.getContext(), this);
        this.f15258g = new GestureDetector(dragSortListView.getContext(), this.f15276y);
        this.f15258g.setIsLongpressEnabled(false);
        this.f15259h = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.f15270s = i;
        this.f15271t = i4;
        this.f15272u = i5;
        m23621b(i3);
        m23616a(i2);
    }

    public void m23616a(int i) {
        this.f15252a = i;
    }

    public void m23618a(boolean z) {
        this.f15253b = z;
    }

    public void m23621b(int i) {
        this.f15254c = i;
    }

    public void m23622b(boolean z) {
        this.f15255d = z;
    }

    public boolean m23619a(int i, int i2, int i3) {
        int i4 = 0;
        if (this.f15253b && !this.f15256e) {
            i4 = 12;
        }
        if (this.f15255d && this.f15256e) {
            i4 = (i4 | 1) | 2;
        }
        this.f15268q = this.f15274w.m27088a(i - this.f15274w.getHeaderViewsCount(), i4, i2, i3);
        return this.f15268q;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f15274w.m27095c() && !this.f15274w.m27093b()) {
            this.f15257f.onTouchEvent(motionEvent);
            if (this.f15255d && this.f15268q && this.f15254c == 1) {
                this.f15258g.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.f15266o = (int) motionEvent.getX();
                    this.f15267p = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.f15255d && this.f15256e) {
                        int i;
                        if (this.f15275x >= 0) {
                            i = this.f15275x;
                        } else {
                            i = -this.f15275x;
                        }
                        if (i > this.f15274w.getWidth() / 2) {
                            this.f15274w.m27092a(true, 0.0f);
                            break;
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            this.f15256e = false;
            this.f15268q = false;
        }
        return false;
    }

    public void mo2756a(View view, Point point, Point point2) {
        if (this.f15255d && this.f15256e) {
            this.f15275x = point.x;
        }
    }

    public int m23614a(MotionEvent motionEvent) {
        return m23623c(motionEvent);
    }

    public int m23620b(MotionEvent motionEvent) {
        return this.f15254c == 1 ? m23624d(motionEvent) : -1;
    }

    public int m23623c(MotionEvent motionEvent) {
        return m23615a(motionEvent, this.f15270s);
    }

    public int m23624d(MotionEvent motionEvent) {
        return m23615a(motionEvent, this.f15272u);
    }

    public int m23615a(MotionEvent motionEvent, int i) {
        int pointToPosition = this.f15274w.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.f15274w.getHeaderViewsCount();
        int footerViewsCount = this.f15274w.getFooterViewsCount();
        int count = this.f15274w.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.f15274w.getChildAt(pointToPosition - this.f15274w.getFirstVisiblePosition());
            count = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.f15263l);
                if (count > this.f15263l[0] && rawY > this.f15263l[1] && count < this.f15263l[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.f15263l[1]) {
                        this.f15264m = childAt.getLeft();
                        this.f15265n = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (this.f15255d && this.f15254c == 0) {
            this.f15262k = m23615a(motionEvent, this.f15271t);
        }
        this.f15260i = m23614a(motionEvent);
        if (this.f15260i != -1 && this.f15252a == 0) {
            m23619a(this.f15260i, ((int) motionEvent.getX()) - this.f15264m, ((int) motionEvent.getY()) - this.f15265n);
        }
        this.f15256e = false;
        this.f15273v = true;
        this.f15275x = 0;
        this.f15261j = m23620b(motionEvent);
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!(motionEvent == null || motionEvent2 == null)) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.f15264m;
            int i2 = y2 - this.f15265n;
            if (!(!this.f15273v || this.f15268q || (this.f15260i == -1 && this.f15261j == -1))) {
                if (this.f15260i != -1) {
                    if (this.f15252a == 1 && Math.abs(y2 - y) > this.f15259h && this.f15253b) {
                        m23619a(this.f15260i, i, i2);
                    } else if (this.f15252a != 0 && Math.abs(x2 - x) > this.f15259h && this.f15255d) {
                        this.f15256e = true;
                        m23619a(this.f15261j, i, i2);
                    }
                } else if (this.f15261j != -1) {
                    if (Math.abs(x2 - x) > this.f15259h && this.f15255d) {
                        this.f15256e = true;
                        m23619a(this.f15261j, i, i2);
                    } else if (Math.abs(y2 - y) > this.f15259h) {
                        this.f15273v = false;
                    }
                }
            }
        }
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.f15260i != -1 && this.f15252a == 2) {
            this.f15274w.performHapticFeedback(0);
            m23619a(this.f15260i, this.f15266o - this.f15264m, this.f15267p - this.f15265n);
        }
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f15255d && this.f15254c == 0 && this.f15262k != -1) {
            this.f15274w.m27086a(this.f15262k - this.f15274w.getHeaderViewsCount());
        }
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }
}
