package com.ushareit.listenit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.mopub.nativeads.MoPubAdAdapter;

public class emo implements OnItemSelectedListener {
    final /* synthetic */ OnItemSelectedListener f11266a;
    final /* synthetic */ MoPubAdAdapter f11267b;

    public emo(MoPubAdAdapter moPubAdAdapter, OnItemSelectedListener onItemSelectedListener) {
        this.f11267b = moPubAdAdapter;
        this.f11266a = onItemSelectedListener;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.f11267b.isAd(i)) {
            this.f11266a.onItemSelected(adapterView, view, this.f11267b.f2640c.getOriginalPosition(i), j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f11266a.onNothingSelected(adapterView);
    }
}
