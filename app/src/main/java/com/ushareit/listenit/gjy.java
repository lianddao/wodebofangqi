package com.ushareit.listenit;

import android.app.Activity;
import android.util.Pair;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class gjy extends gkf {
    private Activity f14210a;
    private glg f14211b;

    public gjy(Activity activity, glg com_ushareit_listenit_glg) {
        super(0);
        this.f14211b = com_ushareit_listenit_glg;
        this.f14210a = activity;
    }

    public void mo2569a() {
        m20848t().setShowDownload();
        m20848t().setShowDisappear();
    }

    public void mo2698o() {
        Pair a = eyw.m18568a(eys.m18562a());
        boolean booleanValue = ((Boolean) a.first).booleanValue();
        boolean booleanValue2 = ((Boolean) a.second).booleanValue();
        if (!(booleanValue || booleanValue2)) {
            heb.m23596a((int) C0349R.string.sync_net_offline, 0).show();
        }
        if (booleanValue && !booleanValue2) {
            m22107A();
        } else if (booleanValue2) {
            flw.m19819a().m19832a(this.f14211b, false);
        }
        m20853y();
    }

    private void m22107A() {
        BasePopupView confirmPopupView = new ConfirmPopupView(m20847s());
        confirmPopupView.m25554a().setTitle((int) C0349R.string.sync_download_one_song_title);
        confirmPopupView.m25556d().setContent(String.format(eys.m18562a().getResources().getString(C0349R.string.sync_download_one_song_content), new Object[]{this.f14211b.mo2562c()}));
        confirmPopupView.setConfirmListener(new gjz(this));
        gyn.m23197a((ak) this.f14210a, new fyi(confirmPopupView));
    }

    public void mo2699p() {
        exw.m18454c("HttpUtils", "disappear()");
        gyp.m23287c(this.f14211b);
        frf.m20681g(this.f14211b);
        m20853y();
    }
}
