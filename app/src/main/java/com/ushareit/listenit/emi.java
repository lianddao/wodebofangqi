package com.ushareit.listenit;

import android.view.View;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.ImpressionInterface;
import com.mopub.nativeads.ImpressionTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

@VisibleForTesting
public class emi implements Runnable {
    final /* synthetic */ ImpressionTracker f11257a;
    private final ArrayList<View> f11258b = new ArrayList();

    public emi(ImpressionTracker impressionTracker) {
        this.f11257a = impressionTracker;
    }

    public void run() {
        for (Entry entry : this.f11257a.f2631c.entrySet()) {
            View view = (View) entry.getKey();
            eoa com_ushareit_listenit_eoa = (eoa) entry.getValue();
            if (this.f11257a.f2634f.m17257a(com_ushareit_listenit_eoa.f11356b, ((ImpressionInterface) com_ushareit_listenit_eoa.f11355a).getImpressionMinTimeViewed())) {
                ((ImpressionInterface) com_ushareit_listenit_eoa.f11355a).recordImpression(view);
                ((ImpressionInterface) com_ushareit_listenit_eoa.f11355a).setImpressionRecorded();
                this.f11258b.add(view);
            }
        }
        Iterator it = this.f11258b.iterator();
        while (it.hasNext()) {
            this.f11257a.removeView((View) it.next());
        }
        this.f11258b.clear();
        if (!this.f11257a.f2631c.isEmpty()) {
            this.f11257a.m3177a();
        }
    }
}
