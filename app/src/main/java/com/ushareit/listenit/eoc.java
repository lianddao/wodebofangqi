package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class eoc {
    @VisibleForTesting
    final OnPreDrawListener f11357a;
    @VisibleForTesting
    WeakReference<ViewTreeObserver> f11358b;
    private final ArrayList<View> f11359c;
    private long f11360d;
    private final Map<View, eoe> f11361e;
    private final eof f11362f;
    private eoh f11363g;
    private final eog f11364h;
    private final Handler f11365i;
    private boolean f11366j;

    public eoc(Context context) {
        this(context, new WeakHashMap(10), new eof(), new Handler());
    }

    @VisibleForTesting
    eoc(Context context, Map<View, eoe> map, eof com_ushareit_listenit_eof, Handler handler) {
        this.f11360d = 0;
        this.f11361e = map;
        this.f11362f = com_ushareit_listenit_eof;
        this.f11365i = handler;
        this.f11364h = new eog(this);
        this.f11359c = new ArrayList(50);
        this.f11357a = new eod(this);
        this.f11358b = new WeakReference(null);
        m17247b(context, null);
    }

    private void m17247b(Context context, View view) {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f11358b.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            View a = m17242a(context, view);
            if (a == null) {
                MoPubLog.m2753d("Unable to set Visibility Tracker due to no available root view.");
                return;
            }
            viewTreeObserver = a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                this.f11358b = new WeakReference(viewTreeObserver);
                viewTreeObserver.addOnPreDrawListener(this.f11357a);
                return;
            }
            MoPubLog.m2761w("Visibility Tracker was unable to track views because the root view tree observer was not alive");
        }
    }

    @VisibleForTesting
    static View m17242a(Context context, View view) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView();
        }
        if (view != null) {
            View rootView = view.getRootView();
            if (rootView != null) {
                View findViewById = rootView.findViewById(16908290);
                if (findViewById == null) {
                    return rootView;
                }
                return findViewById;
            }
        }
        return null;
    }

    public void m17254a(eoh com_ushareit_listenit_eoh) {
        this.f11363g = com_ushareit_listenit_eoh;
    }

    public void m17251a(View view, int i) {
        m17252a(view, view, i);
    }

    void m17252a(View view, View view2, int i) {
        m17253a(view, view2, i, i);
    }

    void m17253a(View view, View view2, int i, int i2) {
        m17247b(view2.getContext(), view2);
        eoe com_ushareit_listenit_eoe = (eoe) this.f11361e.get(view2);
        if (com_ushareit_listenit_eoe == null) {
            com_ushareit_listenit_eoe = new eoe();
            this.f11361e.put(view2, com_ushareit_listenit_eoe);
            m17256c();
        }
        int min = Math.min(i2, i);
        com_ushareit_listenit_eoe.f11371d = view;
        com_ushareit_listenit_eoe.f11368a = i;
        com_ushareit_listenit_eoe.f11369b = min;
        com_ushareit_listenit_eoe.f11370c = this.f11360d;
        this.f11360d++;
        if (this.f11360d % 50 == 0) {
            m17244a(this.f11360d - 50);
        }
    }

    private void m17244a(long j) {
        for (Entry entry : this.f11361e.entrySet()) {
            if (((eoe) entry.getValue()).f11370c < j) {
                this.f11359c.add(entry.getKey());
            }
        }
        Iterator it = this.f11359c.iterator();
        while (it.hasNext()) {
            m17250a((View) it.next());
        }
        this.f11359c.clear();
    }

    public void m17250a(View view) {
        this.f11361e.remove(view);
    }

    public void m17249a() {
        this.f11361e.clear();
        this.f11365i.removeMessages(0);
        this.f11366j = false;
    }

    public void m17255b() {
        m17249a();
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f11358b.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f11357a);
        }
        this.f11358b.clear();
        this.f11363g = null;
    }

    void m17256c() {
        if (!this.f11366j) {
            this.f11366j = true;
            this.f11365i.postDelayed(this.f11364h, 100);
        }
    }
}
