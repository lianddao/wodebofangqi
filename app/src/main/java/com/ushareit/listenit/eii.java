package com.ushareit.listenit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.DataKeys;

public abstract class eii extends Activity {
    public AdReport f2365a;
    private CloseableLayout f2366b;
    private Long f2367c;

    public abstract View getAdView();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f2367c = m2864a(intent);
        this.f2365a = m2865b(intent);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        View adView = getAdView();
        this.f2366b = new CloseableLayout(this);
        this.f2366b.setOnCloseListener(new eij(this));
        this.f2366b.addView(adView, new LayoutParams(-1, -1));
        setContentView(this.f2366b);
    }

    public void onDestroy() {
        this.f2366b.removeAllViews();
        super.onDestroy();
    }

    public Long m2866a() {
        return this.f2367c;
    }

    protected void m2867b() {
        this.f2366b.setCloseVisible(true);
    }

    protected void m2868c() {
        this.f2366b.setCloseVisible(false);
    }

    protected static Long m2864a(Intent intent) {
        if (intent.hasExtra(DataKeys.BROADCAST_IDENTIFIER_KEY)) {
            return Long.valueOf(intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1));
        }
        return null;
    }

    protected static AdReport m2865b(Intent intent) {
        try {
            return (AdReport) intent.getSerializableExtra(DataKeys.AD_REPORT_KEY);
        } catch (ClassCastException e) {
            return null;
        }
    }
}
