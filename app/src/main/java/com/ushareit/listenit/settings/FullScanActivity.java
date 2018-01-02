package com.ushareit.listenit.settings;

import android.os.Bundle;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fjf;
import com.ushareit.listenit.fragments.ScanFragment;
import com.ushareit.listenit.guz;

public class FullScanActivity extends fjf {
    private ScanFragment f16455n;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.scan_activity);
        this.f16455n = (ScanFragment) m709f().mo795a((int) C0349R.id.scan_view);
        this.f16455n.m20572a(new guz(this));
    }

    public void mo541k() {
    }

    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
