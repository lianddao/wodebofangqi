package com.ushareit.listenit;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

public class hdp extends AlertDialog {
    protected hdp(Context context) {
        super(context);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(true);
        setContentView(C0349R.layout.orange_progress_dialog);
    }

    public static hdp m23585a(Context context) {
        hdp com_ushareit_listenit_hdp = new hdp(context);
        com_ushareit_listenit_hdp.show();
        return com_ushareit_listenit_hdp;
    }
}
