package com.ushareit.listenit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;

public class cdh extends ag {
    private Dialog aj = null;
    private OnCancelListener ak = null;

    public static cdh m10905a(Dialog dialog, OnCancelListener onCancelListener) {
        cdh com_ushareit_listenit_cdh = new cdh();
        Dialog dialog2 = (Dialog) cfi.m11081a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        com_ushareit_listenit_cdh.aj = dialog2;
        if (onCancelListener != null) {
            com_ushareit_listenit_cdh.ak = onCancelListener;
        }
        return com_ushareit_listenit_cdh;
    }

    public void mo1295a(ar arVar, String str) {
        super.mo1295a(arVar, str);
    }

    public Dialog mo176c(Bundle bundle) {
        if (this.aj == null) {
            m1351b(false);
        }
        return this.aj;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.ak != null) {
            this.ak.onCancel(dialogInterface);
        }
    }
}
