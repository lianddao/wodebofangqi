package com.ushareit.listenit;

import android.graphics.Rect;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class oa extends gk {
    final /* synthetic */ DrawerLayout f16054b;
    private final Rect f16055c = new Rect();

    public oa(DrawerLayout drawerLayout) {
        this.f16054b = drawerLayout;
    }

    public void mo2862a(View view, mh mhVar) {
        if (DrawerLayout.f147c) {
            super.mo2862a(view, mhVar);
        } else {
            mh a = mh.m24879a(mhVar);
            super.mo2862a(view, a);
            mhVar.m24886a(view);
            ViewParent i = ja.m24163i(view);
            if (i instanceof View) {
                mhVar.m24899c((View) i);
            }
            m25269a(mhVar, a);
            a.m24926t();
            m25268a(mhVar, (ViewGroup) view);
        }
        mhVar.m24894b(DrawerLayout.class.getName());
        mhVar.m24888a(false);
        mhVar.m24896b(false);
        mhVar.m24889a(mi.f15945a);
        mhVar.m24889a(mi.f15946b);
    }

    public void mo2864d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo2864d(view, accessibilityEvent);
        accessibilityEvent.setClassName(DrawerLayout.class.getName());
    }

    public boolean mo2961b(View view, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.mo2961b(view, accessibilityEvent);
        }
        List text = accessibilityEvent.getText();
        View a = this.f16054b.m82k();
        if (a != null) {
            CharSequence b = this.f16054b.m95b(this.f16054b.m105e(a));
            if (b != null) {
                text.add(b);
            }
        }
        return true;
    }

    public boolean mo2960a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (DrawerLayout.f147c || DrawerLayout.m85n(view)) {
            return super.mo2960a(viewGroup, view, accessibilityEvent);
        }
        return false;
    }

    private void m25268a(mh mhVar, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (DrawerLayout.m85n(childAt)) {
                mhVar.m24893b(childAt);
            }
        }
    }

    private void m25269a(mh mhVar, mh mhVar2) {
        Rect rect = this.f16055c;
        mhVar2.m24885a(rect);
        mhVar.m24892b(rect);
        mhVar2.m24898c(rect);
        mhVar.m24903d(rect);
        mhVar.m24902c(mhVar2.m24913h());
        mhVar.m24887a(mhVar2.m24922p());
        mhVar.m24894b(mhVar2.m24923q());
        mhVar.m24900c(mhVar2.m24925s());
        mhVar.m24912h(mhVar2.m24919m());
        mhVar.m24908f(mhVar2.m24917k());
        mhVar.m24888a(mhVar2.m24909f());
        mhVar.m24896b(mhVar2.m24911g());
        mhVar.m24904d(mhVar2.m24915i());
        mhVar.m24906e(mhVar2.m24916j());
        mhVar.m24910g(mhVar2.m24918l());
        mhVar.m24884a(mhVar2.m24890b());
    }
}
