package com.ushareit.listenit.lyrics;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.ggm;
import com.ushareit.listenit.ghp;
import com.ushareit.listenit.ghu;
import com.ushareit.listenit.ghv;
import com.ushareit.listenit.ghw;
import com.ushareit.listenit.ghy;
import com.ushareit.listenit.ghz;
import com.ushareit.listenit.gia;
import com.ushareit.listenit.gib;
import com.ushareit.listenit.gic;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gyp;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LyricView extends RelativeLayout {
    private View f15865a;
    private ListView f15866b;
    private TextView f15867c;
    private View f15868d;
    private View f15869e;
    private View f15870f;
    private View f15871g;
    private TextView f15872h;
    private TextView f15873i;
    private ggm f15874j;
    private gic f15875k;
    private List<Integer> f15876l = new ArrayList();
    private List<Integer> f15877m = new ArrayList();
    private int f15878n;
    private int f15879o = -1;
    private boolean f15880p = false;
    private long f15881q = 0;
    private long f15882r = 0;
    private Runnable f15883s = new ghw(this);
    private OnScrollListener f15884t = new ghy(this);
    private Handler f15885u = new ghz(this);
    private OnClickListener f15886v = new gia(this);
    private OnClickListener f15887w = new gib(this);

    public LyricView(Context context) {
        super(context);
        m24754a(context);
    }

    public LyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24754a(context);
    }

    public LyricView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24754a(context);
    }

    private void m24754a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.lyric_view, this);
        this.f15865a = inflate.findViewById(C0349R.id.root_view);
        this.f15866b = (ListView) inflate.findViewById(C0349R.id.lyric_list);
        this.f15869e = inflate.findViewById(C0349R.id.lyric_loading);
        this.f15867c = (TextView) inflate.findViewById(C0349R.id.lyric_ruler_time);
        this.f15868d = inflate.findViewById(C0349R.id.ruler_area);
        this.f15870f = inflate.findViewById(C0349R.id.lyric_not_found_area);
        this.f15871g = inflate.findViewById(C0349R.id.add_lyrics);
        this.f15872h = (TextView) inflate.findViewById(C0349R.id.lyric_not_found);
        this.f15873i = (TextView) inflate.findViewById(C0349R.id.lyric_not_find_hint);
        this.f15875k = new gic(this);
        this.f15868d.setOnClickListener(this.f15886v);
        this.f15871g.setOnClickListener(this.f15887w);
    }

    protected void onDetachedFromWindow() {
        this.f15885u.removeMessages(0);
        this.f15866b.removeCallbacks(this.f15883s);
        super.onDetachedFromWindow();
    }

    public void setLyricClickListener(OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f15865a.setOnClickListener(onClickListener);
            this.f15866b.setOnItemClickListener(new ghu(this, onClickListener));
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            this.f15880p = true;
            this.f15885u.removeMessages(0);
            this.f15866b.removeCallbacks(this.f15883s);
        }
    }

    public void m24780a(boolean z) {
        glg o = gyp.m23301o();
        if (o != null) {
            if (this.f15874j == null || o.f14334b != this.f15881q || m24758a()) {
                this.f15881q = o.f14334b;
                m24759b();
                ghp.m22017a(o, z, new ghv(this, z, o));
                return;
            }
            m24779a(gyp.m23299m(), true);
        }
    }

    private boolean m24758a() {
        if (this.f15874j == null || fbb.m18763c(this.f15874j.m21944a()) || new File(this.f15874j.m21944a()).lastModified() == this.f15882r) {
            return false;
        }
        return true;
    }

    private void getLyricModifiedTime() {
        if (this.f15874j == null || fbb.m18763c(this.f15874j.m21944a())) {
            this.f15882r = 0;
        } else {
            this.f15882r = new File(this.f15874j.m21944a()).lastModified();
        }
    }

    private void m24759b() {
        this.f15869e.setVisibility(0);
        this.f15868d.setVisibility(8);
        this.f15870f.setVisibility(8);
        this.f15875k.m22046a(null);
        this.f15874j = null;
        this.f15880p = false;
        this.f15885u.removeMessages(0);
        this.f15879o = -1;
        this.f15866b.setVisibility(4);
        this.f15866b.setOnScrollListener(null);
    }

    private void m24764c() {
        this.f15866b.setVisibility(0);
        this.f15870f.setVisibility(8);
        this.f15869e.setVisibility(8);
        this.f15868d.setVisibility(8);
    }

    private void m24757a(boolean z, glg com_ushareit_listenit_glg) {
        String d = gyn.m23228d(com_ushareit_listenit_glg);
        this.f15873i.setText(getResources().getString(C0349R.string.lyric_not_found_hint, new Object[]{d}));
        this.f15870f.setVisibility(0);
        this.f15869e.setVisibility(8);
        this.f15868d.setVisibility(8);
        this.f15866b.setVisibility(4);
        this.f15866b.setOnScrollListener(null);
    }

    private void m24766d() {
        this.f15878n = this.f15866b.getHeight();
        int height = this.f15866b.getHeight() >> 1;
        this.f15866b.addHeaderView(m24751a(height));
        this.f15866b.addFooterView(m24751a(height));
    }

    private View m24751a(int i) {
        View view = new View(getContext());
        view.setLayoutParams(new LayoutParams(-1, i));
        view.setBackgroundColor(0);
        return view;
    }

    private void m24767e() {
        this.f15876l.clear();
        this.f15877m.clear();
        int height = this.f15866b.getHeight() >> 1;
        int height2 = this.f15866b.getHeight() >> 1;
        this.f15876l.add(Integer.valueOf(height));
        this.f15877m.add(Integer.valueOf(height));
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((this.f15866b.getWidth() - this.f15866b.getPaddingLeft()) - this.f15866b.getPaddingRight(), Integer.MIN_VALUE);
        for (int i = 0; i < this.f15874j.m21956d(); i++) {
            View view = this.f15875k.getView(i, null, this.f15866b);
            view.measure(makeMeasureSpec, 0);
            int measuredHeight = view.getMeasuredHeight();
            this.f15876l.add(Integer.valueOf(measuredHeight));
            this.f15877m.add(Integer.valueOf(((Integer) this.f15877m.get(this.f15877m.size() - 1)).intValue() + measuredHeight));
        }
        this.f15876l.add(Integer.valueOf(height2));
        this.f15877m.add(Integer.valueOf(((Integer) this.f15877m.get(this.f15877m.size() - 1)).intValue() + height2));
        exw.m18443a("Lyric", "itemHeight=" + this.f15876l + ", sumHeihgt=" + this.f15877m + ", listviewH=" + this.f15866b.getHeight() + ", width=" + this.f15866b.getWidth() + ", paddingLeft=" + this.f15866b.getPaddingLeft() + ", paddingRight=" + this.f15866b.getPaddingRight());
    }

    public void m24779a(int i, boolean z) {
        if (this.f15874j != null && this.f15874j.m21961e()) {
            if (!this.f15880p || z) {
                if (z) {
                    m24762b(true);
                }
                m24760b(this.f15874j.m21943a(i + 500));
            }
        }
    }

    private void m24760b(int i) {
        if (this.f15876l.size() != 0 && i < this.f15876l.size() - 2) {
            int abs = Math.abs(i - this.f15879o);
            this.f15879o = i;
            if (i == -1) {
                this.f15866b.smoothScrollToPosition(0);
                return;
            }
            int intValue = ((((Integer) this.f15876l.get(i + 1)).intValue() >> 1) + ((Integer) this.f15877m.get(i)).intValue()) - (getScrolledY() + (this.f15878n / 2));
            if (intValue != 0) {
                int i2 = abs * 20;
                if (i2 < 500) {
                    i2 = 500;
                } else if (i2 > 1200) {
                    i2 = 1200;
                }
                this.f15866b.smoothScrollBy(intValue, i2);
            }
        }
    }

    private int getScrolledY() {
        int i = 0;
        if (this.f15866b.getChildAt(0) == null) {
            return 0;
        }
        int firstVisiblePosition = this.f15866b.getFirstVisiblePosition();
        int i2 = -this.f15866b.getChildAt(0).getTop();
        if (firstVisiblePosition != 0) {
            i = ((Integer) this.f15877m.get(firstVisiblePosition - 1)).intValue();
        }
        return i + i2;
    }

    private int getCenterItemIndex() {
        int scrolledY = getScrolledY() + (this.f15878n >> 1);
        if (scrolledY < ((Integer) this.f15877m.get(0)).intValue()) {
            return 0;
        }
        if (scrolledY > ((Integer) this.f15877m.get(this.f15877m.size() - 2)).intValue()) {
            return this.f15877m.size() - 2;
        }
        int i = 0;
        int size = this.f15877m.size() - 2;
        while (size - i > 1) {
            int i2 = (size + i) / 2;
            int intValue = ((Integer) this.f15877m.get(i2)).intValue();
            if (intValue == scrolledY) {
                return i2 + 1;
            }
            if (intValue < scrolledY) {
                i = i2;
            } else if (intValue > scrolledY) {
                size = i2;
            }
        }
        return size;
    }

    private void m24769f() {
        this.f15885u.removeMessages(0);
        if (!this.f15880p) {
            this.f15880p = true;
            this.f15868d.setVisibility(0);
        }
    }

    private void m24762b(boolean z) {
        if (!this.f15880p) {
            return;
        }
        if (z) {
            this.f15880p = false;
            this.f15868d.setVisibility(8);
            this.f15885u.removeMessages(0);
            return;
        }
        this.f15885u.removeMessages(0);
        this.f15885u.sendEmptyMessageDelayed(0, 4000);
    }

    private void m24772g() {
        int centerItemIndex = getCenterItemIndex();
        int firstVisiblePosition = this.f15866b.getFirstVisiblePosition();
        int lastVisiblePosition = this.f15866b.getLastVisiblePosition();
        int i = firstVisiblePosition;
        while (i <= lastVisiblePosition) {
            View childAt = this.f15866b.getChildAt(i - firstVisiblePosition);
            if (i == this.f15879o + 1) {
                erj.m17570a(childAt, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            } else if (i == firstVisiblePosition || i == lastVisiblePosition) {
                int intValue = ((Integer) this.f15876l.get(i)).intValue();
                float top = (((float) ((i == firstVisiblePosition ? childAt.getTop() + intValue : this.f15878n - childAt.getTop()) - (intValue / 2))) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) (intValue / 2));
                if (top < 0.0f) {
                    top = 0.0f;
                } else if (top > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                    top = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                }
                erj.m17570a(childAt, top * 0.4f);
            } else if (i == centerItemIndex) {
                m24750a(childAt, 0.4f, 0.7f);
                if (this.f15880p) {
                    this.f15867c.setText(this.f15874j.m21957d(centerItemIndex - 1));
                }
            } else {
                m24750a(childAt, 0.7f, 0.4f);
            }
            i++;
        }
    }

    private float m24750a(View view, float f, float f2) {
        float a = erj.m17569a(view);
        if (a != f2) {
            if (a != f) {
                erj.m17570a(view, f2);
            } else {
                a = f < f2 ? DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((f2 - f) / f2) : DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                erj.m17570a(view, f2);
                Animation alphaAnimation = new AlphaAnimation(a, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                alphaAnimation.setDuration(200);
                alphaAnimation.setFillAfter(true);
                view.startAnimation(alphaAnimation);
            }
        }
        return f2;
    }
}
