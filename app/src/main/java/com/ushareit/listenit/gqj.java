package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.EditID3TagPopupView;
import com.ushareit.listenit.popupview.NormalPlayerMenu;

public class gqj implements OnClickListener {
    final /* synthetic */ NormalPlayerMenu f14557a;

    public gqj(NormalPlayerMenu normalPlayerMenu) {
        this.f14557a = normalPlayerMenu;
    }

    public void onClick(View view) {
        BasePopupView editID3TagPopupView = new EditID3TagPopupView(this.f14557a.getContext(), -1);
        editID3TagPopupView.setItem(gyp.m23301o());
        if (this.f14557a.f16246l != null) {
            editID3TagPopupView.setOnID3TagListener(this.f14557a.f16246l);
        }
        gyn.m23197a((ak) this.f14557a.getContext(), new fyi(editID3TagPopupView));
        fit.m19433b(this.f14557a.getContext(), "editID3Tag");
        this.f14557a.m25608a();
    }
}
