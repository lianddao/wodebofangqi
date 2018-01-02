package com.ushareit.listenit;

import android.database.DataSetObserver;
import com.mopub.nativeads.MoPubAdAdapter;

public class emk extends DataSetObserver {
    final /* synthetic */ MoPubAdAdapter f11260a;

    public emk(MoPubAdAdapter moPubAdAdapter) {
        this.f11260a = moPubAdAdapter;
    }

    public void onChanged() {
        this.f11260a.f2640c.setItemCount(this.f11260a.f2639b.getCount());
        this.f11260a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f11260a.notifyDataSetInvalidated();
    }
}
