package com.ushareit.listenit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.mopub.nativeads.MoPubAdAdapter;

public class emn implements OnItemLongClickListener {
    final /* synthetic */ OnItemLongClickListener f11264a;
    final /* synthetic */ MoPubAdAdapter f11265b;

    public emn(MoPubAdAdapter moPubAdAdapter, OnItemLongClickListener onItemLongClickListener) {
        this.f11265b = moPubAdAdapter;
        this.f11264a = onItemLongClickListener;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.f11265b.isAd(i)) {
            if (!this.f11264a.onItemLongClick(adapterView, view, this.f11265b.f2640c.getOriginalPosition(i), j)) {
                return false;
            }
        }
        return true;
    }
}
