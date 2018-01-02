package com.ushareit.listenit;

import android.text.TextUtils;
import com.facebook.ads.internal.view.p000a.C0023d;

public class auh {
    private final C0023d f5499a;
    private boolean f5500b = true;

    public auh(C0023d c0023d) {
        this.f5499a = c0023d;
    }

    private static long m7193a(String str, String str2) {
        long j = -1;
        Object substring = str.substring(str2.length());
        if (!TextUtils.isEmpty(substring)) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(substring));
                if (valueOf.longValue() >= 0) {
                    j = valueOf.longValue();
                }
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public void m7194a() {
        if (!this.f5500b) {
            return;
        }
        if (this.f5499a.canGoBack() || this.f5499a.canGoForward()) {
            this.f5500b = false;
        } else {
            this.f5499a.m990b("void((function() {try {  if (!window.performance || !window.performance.timing || !document ||       !document.body || document.body.scrollHeight <= 0 ||       !document.body.children || document.body.children.length < 1) {    return;  }  var nvtiming__an_t = window.performance.timing;  if (nvtiming__an_t.responseEnd > 0) {    console.log('ANNavResponseEnd:'+nvtiming__an_t.responseEnd);  }  if (nvtiming__an_t.domContentLoadedEventStart > 0) {    console.log('ANNavDomContentLoaded:' + nvtiming__an_t.domContentLoadedEventStart);  }  if (nvtiming__an_t.loadEventEnd > 0) {    console.log('ANNavLoadEventEnd:' + nvtiming__an_t.loadEventEnd);  }} catch(err) {  console.log('an_navigation_timing_error:' + err.message);}})());");
        }
    }

    public void m7195a(String str) {
        if (!this.f5500b) {
            return;
        }
        if (str.startsWith("ANNavResponseEnd:")) {
            this.f5499a.m987a(m7193a(str, "ANNavResponseEnd:"));
        } else if (str.startsWith("ANNavDomContentLoaded:")) {
            this.f5499a.m989b(m7193a(str, "ANNavDomContentLoaded:"));
        } else if (str.startsWith("ANNavLoadEventEnd:")) {
            this.f5499a.m991c(m7193a(str, "ANNavLoadEventEnd:"));
        }
    }

    public void m7196a(boolean z) {
        this.f5500b = z;
    }
}
