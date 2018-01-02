package com.ushareit.listenit;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import java.util.LinkedHashMap;

public class hjd extends ag {
    private boolean aj = true;
    protected etf an = null;

    public void mo168a(Bundle bundle) {
        super.mo168a(bundle);
        exw.m18443a("BaseDialogFragment", getClass().getSimpleName() + ".onCreate()");
        m18390W();
    }

    public void mo201x() {
        super.mo201x();
        exw.m18443a("BaseDialogFragment", getClass().getSimpleName() + ".onResume()");
        mo2309U();
    }

    public void mo202y() {
        super.mo202y();
        exw.m18443a("BaseDialogFragment", getClass().getSimpleName() + ".onPause()");
        mo2310V();
    }

    public void mo203z() {
        exw.m18443a("BaseDialogFragment", getClass().getSimpleName() + ".onDestroy()");
        mo2311X();
        super.mo203z();
    }

    public Dialog mo176c(Bundle bundle) {
        Dialog c = super.mo176c(bundle);
        Window window = c.getWindow();
        if (window != null) {
            window.setWindowAnimations(C0349R.style.widget_dialog_animstyle);
        }
        return c;
    }

    public void mo170d(Bundle bundle) {
        Dialog c = m1352c();
        if (c == null) {
            m1351b(false);
        } else if (this.aj) {
            gzc.m23343a(c.getWindow(), 0);
        }
        super.mo170d(bundle);
    }

    public void mo1295a(ar arVar, String str) {
        try {
            super.mo1295a(arVar, str);
        } catch (IllegalStateException e) {
            exw.m18449b("BaseDialogFragment", "show dialog exception " + e);
        }
    }

    protected void m18390W() {
        if (this.an != null) {
            String j = m1322j();
            if (TextUtils.isEmpty(j)) {
                j = getClass().getSimpleName();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("portal", fid.m19227a().toString());
            this.an.m17874a(j, linkedHashMap);
        }
    }

    private void mo2309U() {
        if (this.an != null) {
            this.an.m17872a();
        }
    }

    private void mo2310V() {
        if (this.an != null) {
            this.an.m17876b();
        }
    }

    protected void mo2311X() {
        if (this.an != null) {
            new LinkedHashMap().put("portal", fid.m19227a().toString());
            this.an.m17877c();
        }
    }
}
