package com.ushareit.listenit;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public abstract class fjh extends ag {
    private boolean aj = true;
    private boolean ak = true;
    private boolean al = true;

    public void mo168a(Bundle bundle) {
        super.mo168a(bundle);
        m1343a(1, 16973839);
    }

    public Dialog mo176c(Bundle bundle) {
        Dialog c = super.mo176c(bundle);
        Window window = c.getWindow();
        if (window != null) {
            window.setWindowAnimations(C0349R.style.widget_dialog_animstyle);
        }
        if (this.aj && c.getWindow() != null) {
            LayoutParams attributes = c.getWindow().getAttributes();
            if (attributes != null) {
                attributes.flags |= 1024;
                attributes.flags |= 128;
                c.getWindow().setAttributes(attributes);
            }
        }
        c.setCanceledOnTouchOutside(this.ak);
        c.setCancelable(this.al);
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
        } catch (Exception e) {
            exw.m18449b("BaseDialogFragment", "show dialog exception " + e);
        }
    }

    public void m19518a(ak akVar, String str) {
        try {
            super.mo1295a(akVar.m709f(), str);
        } catch (Exception e) {
            exw.m18449b("BaseDialogFragment", "show dialog exception " + e);
        }
    }
}
