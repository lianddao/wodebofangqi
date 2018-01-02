package com.ushareit.listenit;

import android.util.Log;

class hkc extends hju {
    hkc(String str) {
        this.b = str;
    }

    public void mo2789a(String str) {
        m24027a(3, str, null);
    }

    public void mo2793b(String str) {
        m24027a(4, str, null);
    }

    public void mo2794c(String str) {
        m24027a(5, str, null);
    }

    public void mo2790a(String str, Object obj) {
        m24028a(5, str, obj);
    }

    public void mo2791a(String str, Object obj, Object obj2) {
        m24028a(5, str, obj, obj2);
    }

    public void mo2795d(String str) {
        m24027a(6, str, null);
    }

    public void mo2792a(String str, Throwable th) {
        m24027a(6, str, th);
    }

    private void m24028a(int i, String str, Object... objArr) {
        if (m24029a(i)) {
            hjt a = hjv.m23976a(str, objArr);
            m24030b(i, a.m23972a(), a.m23973b());
        }
    }

    private void m24027a(int i, String str, Throwable th) {
        if (m24029a(i)) {
            m24030b(i, str, th);
        }
    }

    private boolean m24029a(int i) {
        return Log.isLoggable(this.b, i);
    }

    private void m24030b(int i, String str, Throwable th) {
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        Log.println(i, this.b, str);
    }
}
