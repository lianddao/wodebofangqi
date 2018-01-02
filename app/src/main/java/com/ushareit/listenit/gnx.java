package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.ActivePlaylistPopupView;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import java.util.List;

public class gnx implements OnClickListener {
    final /* synthetic */ ActivePlaylistPopupView f14486a;

    public gnx(ActivePlaylistPopupView activePlaylistPopupView) {
        this.f14486a = activePlaylistPopupView;
    }

    public void onClick(View view) {
        this.f14486a.f16124j = new AddToPlaylistPopupView(this.f14486a.getContext(), 0, "nowplay");
        List j = gyp.m23296j();
        if (j != null && j.size() > 0) {
            this.f14486a.f16124j.setItems(j);
            this.f14486a.m12832a(this.f14486a.f16124j);
        }
    }
}
