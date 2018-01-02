package com.ushareit.listenit.widget.dragsortlistview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.heh;
import com.ushareit.listenit.hej;
import com.ushareit.listenit.hek;
import com.ushareit.listenit.hel;
import com.ushareit.listenit.hen;
import com.ushareit.listenit.heo;
import com.ushareit.listenit.hep;
import com.ushareit.listenit.heq;
import com.ushareit.listenit.her;
import com.ushareit.listenit.hes;
import com.ushareit.listenit.het;
import com.ushareit.listenit.heu;
import com.ushareit.listenit.hev;
import com.ushareit.listenit.hew;
import com.ushareit.listenit.hex;
import com.ushareit.listenit.hey;

public class DragSortListView extends ListView {
    private View[] f17424A = new View[1];
    private hep f17425B;
    private float f17426C = 0.33333334f;
    private float f17427D = 0.33333334f;
    private int f17428E;
    private int f17429F;
    private float f17430G;
    private float f17431H;
    private float f17432I;
    private float f17433J;
    private float f17434K = 0.5f;
    private heo f17435L = new hej(this);
    private int f17436M;
    private int f17437N;
    private int f17438O;
    private int f17439P;
    private int f17440Q;
    private int f17441R = 0;
    private boolean f17442S = false;
    private boolean f17443T = false;
    private heu f17444U = null;
    private MotionEvent f17445V;
    private int f17446W = 0;
    private View f17447a;
    private float aa = 0.25f;
    private float ab = 0.0f;
    private hel ac;
    private boolean ad = false;
    private her ae;
    private boolean af = false;
    private boolean ag = false;
    private hev ah = new hev(this, 3);
    private hex ai;
    private hew aj;
    private hes ak;
    private boolean al;
    private float am = 0.0f;
    private boolean an = false;
    private boolean ao = false;
    private Point f17448b = new Point();
    private Point f17449c = new Point();
    private int f17450d;
    private boolean f17451e = false;
    private DataSetObserver f17452f;
    private float f17453g = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f17454h = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private int f17455i;
    private int f17456j;
    private int f17457k;
    private boolean f17458l = false;
    private int f17459m;
    private int f17460n;
    private int f17461o;
    private int f17462p;
    private int f17463q;
    private hen f17464r;
    private het f17465s;
    private hey f17466t;
    private boolean f17467u = true;
    private int f17468v = 0;
    private int f17469w = 1;
    private int f17470x;
    private int f17471y;
    private int f17472z = 0;

    public DragSortListView(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        int i2 = CtaButton.WIDTH_DIPS;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0349R.styleable.DragSortListView, 0, 0);
            this.f17469w = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(0, 1));
            this.ad = obtainStyledAttributes.getBoolean(6, false);
            if (this.ad) {
                this.ae = new her(this);
            }
            this.f17453g = obtainStyledAttributes.getFloat(7, this.f17453g);
            this.f17454h = this.f17453g;
            this.f17467u = obtainStyledAttributes.getBoolean(11, this.f17467u);
            this.aa = Math.max(0.0f, Math.min(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - obtainStyledAttributes.getFloat(8, 0.75f)));
            this.f17458l = this.aa > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(1, this.f17426C));
            this.f17434K = obtainStyledAttributes.getFloat(2, this.f17434K);
            int i3 = obtainStyledAttributes.getInt(9, CtaButton.WIDTH_DIPS);
            int i4 = obtainStyledAttributes.getInt(10, CtaButton.WIDTH_DIPS);
            if (obtainStyledAttributes.getBoolean(18, true)) {
                boolean z = obtainStyledAttributes.getBoolean(13, false);
                int i5 = obtainStyledAttributes.getInt(5, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(12, true);
                int i6 = obtainStyledAttributes.getInt(14, 0);
                int resourceId = obtainStyledAttributes.getResourceId(15, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(16, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(17, 0);
                int color = obtainStyledAttributes.getColor(3, CtaButton.BACKGROUND_COLOR);
                int color2 = obtainStyledAttributes.getColor(4, CtaButton.BACKGROUND_COLOR);
                Object com_ushareit_listenit_heh = new heh(this, resourceId, i6, i5, resourceId3, resourceId2);
                com_ushareit_listenit_heh.m23622b(z);
                com_ushareit_listenit_heh.m23618a(z2);
                com_ushareit_listenit_heh.m23607d(((ListenItApp) context.getApplicationContext()).m4934b() == 1 ? color2 : color);
                this.f17444U = com_ushareit_listenit_heh;
                setOnTouchListener(com_ushareit_listenit_heh);
            }
            obtainStyledAttributes.recycle();
            i = i4;
            i2 = i3;
        } else {
            i = CtaButton.WIDTH_DIPS;
        }
        this.f17425B = new hep(this);
        if (i2 > 0) {
            this.ai = new hex(this, 0.5f, i2);
        }
        if (i > 0) {
            this.ak = new hes(this, 0.5f, i);
        }
        this.f17445V = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.f17452f = new hek(this);
    }

    public void setFloatAlpha(float f) {
        this.f17454h = f;
    }

    public float getFloatAlpha() {
        return this.f17454h;
    }

    public void setMaxScrollSpeed(float f) {
        this.f17434K = f;
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.ac = new hel(this, listAdapter);
            listAdapter.registerDataSetObserver(this.f17452f);
            if (listAdapter instanceof het) {
                setDropListener((het) listAdapter);
            }
            if (listAdapter instanceof hen) {
                setDragListener((hen) listAdapter);
            }
            if (listAdapter instanceof hey) {
                setRemoveListener((hey) listAdapter);
            }
        } else {
            this.ac = null;
        }
        super.setAdapter(this.ac);
    }

    public ListAdapter getInputAdapter() {
        if (this.ac == null) {
            return null;
        }
        return this.ac.m23628a();
    }

    private void m27030a(int i, Canvas canvas) {
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider != null && dividerHeight != 0) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i - getFirstVisiblePosition());
            if (viewGroup != null) {
                int i2;
                int paddingLeft = getPaddingLeft();
                int width = getWidth() - getPaddingRight();
                int height = viewGroup.getChildAt(0).getHeight();
                if (i > this.f17459m) {
                    height += viewGroup.getTop();
                    i2 = height + dividerHeight;
                } else {
                    i2 = viewGroup.getBottom() - height;
                    height = i2 - dividerHeight;
                }
                canvas.save();
                canvas.clipRect(paddingLeft, height, width, i2);
                divider.setBounds(paddingLeft, height, width, i2);
                divider.draw(canvas);
                canvas.restore();
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f17468v != 0) {
            if (this.f17456j != this.f17459m) {
                m27030a(this.f17456j, canvas);
            }
            if (!(this.f17457k == this.f17456j || this.f17457k == this.f17459m)) {
                m27030a(this.f17457k, canvas);
            }
        }
        if (this.f17447a != null) {
            float f;
            int width = this.f17447a.getWidth();
            int height = this.f17447a.getHeight();
            int i = this.f17448b.x;
            int width2 = getWidth();
            if (i < 0) {
                i = -i;
            }
            if (i < width2) {
                f = ((float) (width2 - i)) / ((float) width2);
                f *= f;
            } else {
                f = 0.0f;
            }
            int i2 = (int) (f * (255.0f * this.f17454h));
            canvas.save();
            canvas.translate((float) this.f17448b.x, (float) this.f17448b.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) width, (float) height, i2, 31);
            this.f17447a.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    private int m27035b(int i) {
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return m27044c(i, m27050d(i));
    }

    private int m27026a(int i, int i2) {
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i <= headerViewsCount || i >= getCount() - footerViewsCount) {
            return i2;
        }
        headerViewsCount = getDividerHeight();
        footerViewsCount = this.f17470x - this.f17469w;
        int d = m27050d(i);
        int b = m27035b(i);
        if (this.f17457k <= this.f17459m) {
            if (i != this.f17457k || this.f17456j == this.f17457k) {
                if (i > this.f17457k && i <= this.f17459m) {
                    i2 -= footerViewsCount;
                }
            } else if (i == this.f17459m) {
                i2 = (i2 + b) - this.f17470x;
            } else {
                i2 = ((b - d) + i2) - footerViewsCount;
            }
        } else if (i > this.f17459m && i <= this.f17456j) {
            i2 += footerViewsCount;
        } else if (i == this.f17457k && this.f17456j != this.f17457k) {
            i2 += b - d;
        }
        if (i <= this.f17459m) {
            return (((this.f17470x - headerViewsCount) - m27050d(i - 1)) / 2) + i2;
        }
        return (((d - headerViewsCount) - this.f17470x) / 2) + i2;
    }

    private boolean m27054d() {
        int count;
        boolean z;
        int firstVisiblePosition = getFirstVisiblePosition();
        int i = this.f17456j;
        View childAt = getChildAt(i - firstVisiblePosition);
        if (childAt == null) {
            i = firstVisiblePosition + (getChildCount() / 2);
            childAt = getChildAt(i - firstVisiblePosition);
        }
        firstVisiblePosition = childAt.getTop();
        int height = childAt.getHeight();
        int a = m27026a(i, firstVisiblePosition);
        int dividerHeight = getDividerHeight();
        if (this.f17450d >= a) {
            count = getCount();
            int i2 = height;
            height = firstVisiblePosition;
            firstVisiblePosition = a;
            int i3 = a;
            a = i;
            i = i3;
            while (a < count) {
                if (a != count - 1) {
                    height += dividerHeight + i2;
                    i2 = m27035b(a + 1);
                    firstVisiblePosition = m27026a(a + 1, height);
                    if (this.f17450d < firstVisiblePosition) {
                        break;
                    }
                    a++;
                    i = firstVisiblePosition;
                } else {
                    firstVisiblePosition = (height + dividerHeight) + i2;
                    break;
                }
            }
        }
        height = firstVisiblePosition;
        firstVisiblePosition = a;
        i3 = a;
        a = i;
        i = i3;
        while (a >= 0) {
            a--;
            firstVisiblePosition = m27035b(a);
            if (a != 0) {
                height -= firstVisiblePosition + dividerHeight;
                firstVisiblePosition = m27026a(a, height);
                if (this.f17450d >= firstVisiblePosition) {
                    break;
                }
                i = firstVisiblePosition;
            } else {
                firstVisiblePosition = (height - dividerHeight) - firstVisiblePosition;
                break;
            }
        }
        height = getHeaderViewsCount();
        dividerHeight = getFooterViewsCount();
        count = this.f17456j;
        int i4 = this.f17457k;
        float f = this.ab;
        if (this.f17458l) {
            int abs = Math.abs(firstVisiblePosition - i);
            if (this.f17450d >= firstVisiblePosition) {
                i3 = i;
                i = firstVisiblePosition;
                firstVisiblePosition = i3;
            }
            abs = (int) (((float) abs) * (this.aa * 0.5f));
            float f2 = (float) abs;
            i += abs;
            abs = firstVisiblePosition - abs;
            if (this.f17450d < i) {
                this.f17456j = a - 1;
                this.f17457k = a;
                this.ab = (((float) (i - this.f17450d)) * 0.5f) / f2;
            } else if (this.f17450d < abs) {
                this.f17456j = a;
                this.f17457k = a;
            } else {
                this.f17456j = a;
                this.f17457k = a + 1;
                this.ab = (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT + (((float) (firstVisiblePosition - this.f17450d)) / f2)) * 0.5f;
            }
        } else {
            this.f17456j = a;
            this.f17457k = a;
        }
        if (this.f17456j < height) {
            this.f17456j = height;
            this.f17457k = height;
            a = height;
        } else if (this.f17457k >= getCount() - dividerHeight) {
            a = (getCount() - dividerHeight) - 1;
            this.f17456j = a;
            this.f17457k = a;
        }
        if (this.f17456j == count && this.f17457k == i4 && this.ab == f) {
            z = false;
        } else {
            z = true;
        }
        if (a == this.f17455i) {
            return z;
        }
        if (this.f17464r != null) {
            this.f17464r.m23629a(this.f17455i - height, a - height);
        }
        this.f17455i = a;
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ad) {
            this.ae.m23636b();
        }
    }

    public void m27086a(int i) {
        this.al = false;
        m27087a(i, 0.0f);
    }

    public void m27087a(int i, float f) {
        if (this.f17468v == 0 || this.f17468v == 4) {
            if (this.f17468v == 0) {
                this.f17459m = getHeaderViewsCount() + i;
                this.f17456j = this.f17459m;
                this.f17457k = this.f17459m;
                this.f17455i = this.f17459m;
                View childAt = getChildAt(this.f17459m - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.f17468v = 1;
            this.am = f;
            if (this.f17443T) {
                switch (this.f17446W) {
                    case 1:
                        super.onTouchEvent(this.f17445V);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.f17445V);
                        break;
                }
            }
            if (this.ai != null) {
                this.ai.m23643c();
            } else {
                m27048c(i);
            }
        }
    }

    public void m27085a() {
        if (this.f17468v == 4) {
            this.f17425B.m23631a(true);
            m27073n();
            m27056e();
            m27067k();
            if (this.f17443T) {
                this.f17468v = 3;
            } else {
                this.f17468v = 0;
            }
        }
    }

    private void m27056e() {
        this.f17459m = -1;
        this.f17456j = -1;
        this.f17457k = -1;
        this.f17455i = -1;
    }

    private void m27058f() {
        this.f17468v = 2;
        if (this.f17465s != null && this.f17455i >= 0 && this.f17455i < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.f17465s.a_(this.f17459m - headerViewsCount, this.f17455i - headerViewsCount);
        }
        m27073n();
        m27062h();
        m27056e();
        m27067k();
        if (this.f17443T) {
            this.f17468v = 3;
        } else {
            this.f17468v = 0;
        }
    }

    private void m27060g() {
        m27048c(this.f17459m - getHeaderViewsCount());
    }

    private void m27048c(int i) {
        this.f17468v = 1;
        if (this.f17466t != null) {
            this.f17466t.m23634a(i);
        }
        m27073n();
        m27062h();
        m27056e();
        if (this.f17443T) {
            this.f17468v = 3;
        } else {
            this.f17468v = 0;
        }
    }

    private void m27062h() {
        int i = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.f17459m < firstVisiblePosition) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            setSelectionFromTop(firstVisiblePosition - 1, i - getPaddingTop());
        }
    }

    public boolean m27091a(boolean z) {
        this.al = false;
        return m27094b(z, 0.0f);
    }

    public boolean m27092a(boolean z, float f) {
        this.al = true;
        return m27094b(z, f);
    }

    public boolean m27094b(boolean z, float f) {
        if (this.f17447a == null) {
            return false;
        }
        this.f17425B.m23631a(true);
        if (z) {
            m27087a(this.f17459m - getHeaderViewsCount(), f);
        } else if (this.ak != null) {
            this.ak.m23643c();
        } else {
            m27058f();
        }
        if (!this.ad) {
            return true;
        }
        this.ae.m23638d();
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.ag) {
            this.ag = false;
            return false;
        } else if (!this.f17467u) {
            return super.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.f17442S;
            this.f17442S = false;
            if (!z2) {
                m27041b(motionEvent);
            }
            if (this.f17468v == 4) {
                m27090a(motionEvent);
                return true;
            }
            if (this.f17468v == 0 && super.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    m27064i();
                    return z;
                default:
                    if (!z) {
                        return z;
                    }
                    this.f17446W = 1;
                    return z;
            }
        }
    }

    private void m27064i() {
        this.f17446W = 0;
        this.f17443T = false;
        if (this.f17468v == 3) {
            this.f17468v = 0;
        }
        this.f17454h = this.f17453g;
        this.an = false;
        this.ah.m23650a();
    }

    private void m27041b(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.f17438O = this.f17436M;
            this.f17439P = this.f17437N;
        }
        this.f17436M = (int) motionEvent.getX();
        this.f17437N = (int) motionEvent.getY();
        if (action == 0) {
            this.f17438O = this.f17436M;
            this.f17439P = this.f17437N;
        }
        this.f17462p = ((int) motionEvent.getRawX()) - this.f17436M;
        this.f17463q = ((int) motionEvent.getRawY()) - this.f17437N;
    }

    public boolean m27093b() {
        return this.an;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f17467u) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean z;
        m27041b(motionEvent);
        this.f17442S = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.f17468v != 0) {
                this.ag = true;
                return true;
            }
            this.f17443T = true;
        }
        if (this.f17447a == null) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.an = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    m27064i();
                    break;
                default:
                    if (!z) {
                        this.f17446W = 2;
                        break;
                    }
                    this.f17446W = 1;
                    break;
            }
        }
        z = true;
        if (action == 1 || action == 3) {
            this.f17443T = false;
        }
        return z;
    }

    public void setDragScrollStart(float f) {
        setDragScrollStarts(f, f);
    }

    public void setDragScrollStarts(float f, float f2) {
        if (f2 > 0.5f) {
            this.f17427D = 0.5f;
        } else {
            this.f17427D = f2;
        }
        if (f > 0.5f) {
            this.f17426C = 0.5f;
        } else {
            this.f17426C = f;
        }
        if (getHeight() != 0) {
            m27066j();
        }
    }

    private void m27040b(int i, int i2) {
        this.f17448b.x = i - this.f17460n;
        this.f17448b.y = i2 - this.f17461o;
        m27042b(true);
        int min = Math.min(i2, this.f17450d + this.f17471y);
        int max = Math.max(i2, this.f17450d - this.f17471y);
        int b = this.f17425B.m23633b();
        if (min > this.f17439P && min > this.f17429F && b != 1) {
            if (b != -1) {
                this.f17425B.m23631a(true);
            }
            this.f17425B.m23630a(1);
        } else if (max < this.f17439P && max < this.f17428E && b != 0) {
            if (b != -1) {
                this.f17425B.m23631a(true);
            }
            this.f17425B.m23630a(0);
        } else if (max >= this.f17428E && min <= this.f17429F && this.f17425B.m23632a()) {
            this.f17425B.m23631a(true);
        }
    }

    private void m27066j() {
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        float f = (float) height;
        this.f17431H = ((float) paddingTop) + (this.f17426C * f);
        this.f17430G = (f * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f17427D)) + ((float) paddingTop);
        this.f17428E = (int) this.f17431H;
        this.f17429F = (int) this.f17430G;
        this.f17432I = this.f17431H - ((float) paddingTop);
        this.f17433J = ((float) (paddingTop + height)) - this.f17430G;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m27066j();
    }

    private void m27067k() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        lastVisiblePosition = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= lastVisiblePosition; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                m27031a(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    private void m27031a(int i, View view, boolean z) {
        int c;
        LayoutParams layoutParams = view.getLayoutParams();
        if (i == this.f17459m || i == this.f17456j || i == this.f17457k) {
            c = m27045c(i, view, z);
        } else {
            c = -2;
        }
        if (c != layoutParams.height) {
            layoutParams.height = c;
            view.setLayoutParams(layoutParams);
        }
        if (i == this.f17456j || i == this.f17457k) {
            if (i < this.f17459m) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i > this.f17459m) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        c = 0;
        if (i == this.f17459m && this.f17447a != null) {
            c = 4;
        }
        if (c != visibility) {
            view.setVisibility(c);
        }
    }

    private int m27050d(int i) {
        if (i == this.f17459m) {
            return 0;
        }
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return m27036b(i, childAt, false);
        }
        int a = this.ah.m23649a(i);
        if (a != -1) {
            return a;
        }
        View view;
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.f17424A.length) {
            this.f17424A = new View[viewTypeCount];
        }
        if (itemViewType < 0) {
            view = adapter.getView(i, null, this);
        } else if (this.f17424A[itemViewType] == null) {
            view = adapter.getView(i, null, this);
            this.f17424A[itemViewType] = view;
        } else {
            view = adapter.getView(i, this.f17424A[itemViewType], this);
        }
        a = m27036b(i, view, true);
        this.ah.m23651a(i, a);
        return a;
    }

    private int m27036b(int i, View view, boolean z) {
        if (i == this.f17459m) {
            return 0;
        }
        if (i >= getHeaderViewsCount() && i < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            return layoutParams.height;
        }
        int height = view.getHeight();
        if (height != 0 && !z) {
            return height;
        }
        m27032a(view);
        return view.getMeasuredHeight();
    }

    private int m27045c(int i, View view, boolean z) {
        return m27044c(i, m27036b(i, view, z));
    }

    private int m27044c(int i, int i2) {
        getDividerHeight();
        Object obj = (!this.f17458l || this.f17456j == this.f17457k) ? null : 1;
        int i3 = this.f17470x - this.f17469w;
        int i4 = (int) (this.ab * ((float) i3));
        if (i == this.f17459m) {
            if (this.f17459m == this.f17456j) {
                if (obj != null) {
                    return i4 + this.f17469w;
                }
                return this.f17470x;
            } else if (this.f17459m == this.f17457k) {
                return this.f17470x - i4;
            } else {
                return this.f17469w;
            }
        } else if (i == this.f17456j) {
            if (obj != null) {
                return i2 + i4;
            }
            return i2 + i3;
        } else if (i == this.f17457k) {
            return (i2 + i3) - i4;
        } else {
            return i2;
        }
    }

    public void requestLayout() {
        if (!this.af) {
            super.requestLayout();
        }
    }

    private int m27027a(int i, View view, int i2, int i3) {
        int i4;
        int d = m27050d(i);
        int height = view.getHeight();
        int c = m27044c(i, d);
        if (i != this.f17459m) {
            i4 = height - d;
            d = c - d;
        } else {
            d = c;
            i4 = height;
        }
        int i5 = this.f17470x;
        if (!(this.f17459m == this.f17456j || this.f17459m == this.f17457k)) {
            i5 -= this.f17469w;
        }
        if (i <= i2) {
            if (i > this.f17456j) {
                return (i5 - d) + 0;
            }
        } else if (i == i3) {
            if (i <= this.f17456j) {
                return (i4 - i5) + 0;
            }
            if (i == this.f17457k) {
                return (height - c) + 0;
            }
            return 0 + i4;
        } else if (i <= this.f17456j) {
            return 0 - i5;
        } else {
            if (i == this.f17457k) {
                return 0 - d;
            }
        }
        return 0;
    }

    private void m27032a(View view) {
        int makeMeasureSpec;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f17472z, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void m27070l() {
        if (this.f17447a != null) {
            m27032a(this.f17447a);
            this.f17470x = this.f17447a.getMeasuredHeight();
            this.f17471y = this.f17470x / 2;
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f17447a != null) {
            if (this.f17447a.isLayoutRequested()) {
                m27070l();
            }
            this.f17451e = true;
        }
        this.f17472z = i;
    }

    public void layoutChildren() {
        super.layoutChildren();
        if (this.f17447a != null) {
            if (this.f17447a.isLayoutRequested() && !this.f17451e) {
                m27070l();
            }
            this.f17447a.layout(0, 0, this.f17447a.getMeasuredWidth(), this.f17447a.getMeasuredHeight());
            this.f17451e = false;
        }
    }

    protected boolean m27090a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.f17468v == 4) {
                    m27091a(false);
                }
                m27064i();
                break;
            case 2:
                m27040b((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
            case 3:
                if (this.f17468v == 4) {
                    m27085a();
                }
                m27064i();
                break;
        }
        return true;
    }

    public boolean m27088a(int i, int i2, int i3, int i4) {
        if (!this.f17443T || this.f17444U == null) {
            return false;
        }
        View c = this.f17444U.mo2757c(i);
        if (c != null) {
            return m27089a(i, c, i2, i3, i4);
        }
        return false;
    }

    public boolean m27089a(int i, View view, int i2, int i3, int i4) {
        if (this.f17468v != 0 || !this.f17443T || this.f17447a != null || view == null || !this.f17467u) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = getHeaderViewsCount() + i;
        this.f17456j = headerViewsCount;
        this.f17457k = headerViewsCount;
        this.f17459m = headerViewsCount;
        this.f17455i = headerViewsCount;
        this.f17468v = 4;
        this.f17441R = 0;
        this.f17441R |= i2;
        this.f17447a = view;
        m27070l();
        this.f17460n = i3;
        this.f17461o = i4;
        this.f17440Q = this.f17437N;
        this.f17448b.x = this.f17436M - this.f17460n;
        this.f17448b.y = this.f17437N - this.f17461o;
        View childAt = getChildAt(this.f17459m - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.ad) {
            this.ae.m23635a();
        }
        switch (this.f17446W) {
            case 1:
                super.onTouchEvent(this.f17445V);
                break;
            case 2:
                super.onInterceptTouchEvent(this.f17445V);
                break;
        }
        requestLayout();
        if (this.aj == null) {
            return true;
        }
        this.aj.m23643c();
        return true;
    }

    private void m27042b(boolean z) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt != null) {
            m27053d(firstVisiblePosition, childAt, z);
        }
    }

    private void m27053d(int i, View view, boolean z) {
        this.af = true;
        m27072m();
        int i2 = this.f17456j;
        int i3 = this.f17457k;
        boolean d = m27054d();
        if (d) {
            m27067k();
            setSelectionFromTop(i, (m27027a(i, view, i2, i3) + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        if (d || z) {
            invalidate();
        }
        this.af = false;
    }

    private void m27072m() {
        if (this.f17444U != null) {
            this.f17449c.set(this.f17436M, this.f17437N);
            this.f17444U.mo2756a(this.f17447a, this.f17448b, this.f17449c);
        }
        int i = this.f17448b.x;
        int i2 = this.f17448b.y;
        int paddingLeft = getPaddingLeft();
        if ((this.f17441R & 1) == 0 && i > paddingLeft) {
            this.f17448b.x = paddingLeft;
        } else if ((this.f17441R & 2) == 0 && i < paddingLeft) {
            this.f17448b.x = paddingLeft;
        }
        paddingLeft = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        i = getPaddingTop();
        if (firstVisiblePosition < paddingLeft) {
            i = getChildAt((paddingLeft - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.f17441R & 8) == 0 && firstVisiblePosition <= this.f17459m) {
            i = Math.max(getChildAt(this.f17459m - firstVisiblePosition).getTop(), i);
        }
        paddingLeft = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            paddingLeft = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.f17441R & 4) == 0 && lastVisiblePosition >= this.f17459m) {
            paddingLeft = Math.min(getChildAt(this.f17459m - firstVisiblePosition).getBottom(), paddingLeft);
        }
        if (i2 < i) {
            this.f17448b.y = i;
        } else if (this.f17470x + i2 > paddingLeft) {
            this.f17448b.y = paddingLeft - this.f17470x;
        }
        this.f17450d = this.f17448b.y + this.f17471y;
    }

    private void m27073n() {
        if (this.f17447a != null) {
            this.f17447a.setVisibility(8);
            if (this.f17444U != null) {
                this.f17444U.mo2755a(this.f17447a);
            }
            this.f17447a = null;
            invalidate();
        }
    }

    public void setFloatViewManager(heu com_ushareit_listenit_heu) {
        this.f17444U = com_ushareit_listenit_heu;
    }

    public void setDragListener(hen com_ushareit_listenit_hen) {
        this.f17464r = com_ushareit_listenit_hen;
    }

    public void setDragEnabled(boolean z) {
        this.f17467u = z;
    }

    public boolean m27095c() {
        return this.f17467u;
    }

    public void setDropListener(het com_ushareit_listenit_het) {
        this.f17465s = com_ushareit_listenit_het;
    }

    public void setRemoveListener(hey com_ushareit_listenit_hey) {
        this.f17466t = com_ushareit_listenit_hey;
    }

    public void setDragSortListener(heq com_ushareit_listenit_heq) {
        setDropListener(com_ushareit_listenit_heq);
        setDragListener(com_ushareit_listenit_heq);
        setRemoveListener(com_ushareit_listenit_heq);
    }

    public void setDragScrollProfile(heo com_ushareit_listenit_heo) {
        if (com_ushareit_listenit_heo != null) {
            this.f17435L = com_ushareit_listenit_heo;
        }
    }
}
