package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;

@TargetApi(11)
public class cdc extends DialogFragment {
    private Dialog f8143a = null;
    private OnCancelListener f8144b = null;

    public static cdc m10874a(Dialog dialog, OnCancelListener onCancelListener) {
        cdc com_ushareit_listenit_cdc = new cdc();
        Dialog dialog2 = (Dialog) cfi.m11081a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        com_ushareit_listenit_cdc.f8143a = dialog2;
        if (onCancelListener != null) {
            com_ushareit_listenit_cdc.f8144b = onCancelListener;
        }
        return com_ushareit_listenit_cdc;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f8144b != null) {
            this.f8144b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f8143a == null) {
            setShowsDialog(false);
        }
        return this.f8143a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
