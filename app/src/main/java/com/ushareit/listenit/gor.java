package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.EditID3TagPopupView;

public class gor implements OnClickListener {
    final /* synthetic */ EditID3TagPopupView f14513a;

    public gor(EditID3TagPopupView editID3TagPopupView) {
        this.f14513a = editID3TagPopupView;
    }

    public void onClick(View view) {
        if (gyn.m23260p(this.f14513a.f16177q.f14342j)) {
            this.f14513a.mo3063e();
        } else if (this.f14513a.f16177q == null) {
            this.f14513a.mo3063e();
        } else {
            this.f14513a.m25565a(this.f14513a.f16177q);
            if (this.f14513a.f16178r) {
                frf.m20675e(this.f14513a.f16177q);
                if (this.f14513a.f16175o != null) {
                    this.f14513a.f16175o.mo2751a();
                }
                fiq.m19372a(this.f14513a.getContext(), "UF_MenuEditId3Tag", this.f14513a.f16179s, "menu");
                if (this.f14513a.f16179s == 8) {
                    fis.m19422a(this.f14513a.getContext(), "UF_PlaylistEditSong", "editsong");
                }
                this.f14513a.mo3063e();
                return;
            }
            this.f14513a.mo3063e();
        }
    }
}
