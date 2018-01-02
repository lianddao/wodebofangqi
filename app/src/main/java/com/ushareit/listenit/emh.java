package com.ushareit.listenit;

import android.view.View;
import com.mopub.nativeads.ImpressionInterface;
import com.mopub.nativeads.ImpressionTracker;
import java.util.List;

public class emh implements eoh {
    final /* synthetic */ ImpressionTracker f11256a;

    public emh(ImpressionTracker impressionTracker) {
        this.f11256a = impressionTracker;
    }

    public void onVisibilityChanged(List<View> list, List<View> list2) {
        for (View view : list) {
            ImpressionInterface impressionInterface = (ImpressionInterface) this.f11256a.f2630b.get(view);
            if (impressionInterface == null) {
                this.f11256a.removeView(view);
            } else {
                eoa com_ushareit_listenit_eoa = (eoa) this.f11256a.f2631c.get(view);
                if (com_ushareit_listenit_eoa == null || !impressionInterface.equals(com_ushareit_listenit_eoa.f11355a)) {
                    this.f11256a.f2631c.put(view, new eoa(impressionInterface));
                }
            }
        }
        for (View view2 : list2) {
            this.f11256a.f2631c.remove(view2);
        }
        this.f11256a.m3177a();
    }
}
