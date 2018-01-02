package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.google.android.exoplayer2.ui.PlaybackControlView;

public final class bqu implements OnClickListener, OnSeekBarChangeListener, bfk {
    final /* synthetic */ PlaybackControlView f7445a;

    private bqu(PlaybackControlView playbackControlView) {
        this.f7445a = playbackControlView;
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f7445a.removeCallbacks(this.f7445a.f1482u);
        this.f7445a.f1476o = true;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.f7445a.f1467f.setText(this.f7445a.m2087a(this.f7445a.m2085a(i)));
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f7445a.f1476o = false;
        this.f7445a.f1474m.mo890a(this.f7445a.m2085a(seekBar.getProgress()));
        this.f7445a.m2095d();
    }

    public void mo114a(boolean z, int i) {
        this.f7445a.m2098f();
        this.f7445a.m2103h();
    }

    public void mo119e() {
        this.f7445a.m2100g();
        this.f7445a.m2103h();
    }

    public void mo112a(bgd com_ushareit_listenit_bgd, Object obj) {
        this.f7445a.m2100g();
        this.f7445a.m2103h();
    }

    public void mo116b(boolean z) {
    }

    public void mo111a(bfi com_ushareit_listenit_bfi) {
    }

    public void onClick(View view) {
        bgd f = this.f7445a.f1474m.mo901f();
        if (this.f7445a.f1464c == view) {
            this.f7445a.m2107j();
        } else if (this.f7445a.f1463b == view) {
            this.f7445a.m2104i();
        } else if (this.f7445a.f1469h == view) {
            this.f7445a.m2111l();
        } else if (this.f7445a.f1470i == view && f != null) {
            this.f7445a.m2108k();
        } else if (this.f7445a.f1465d == view) {
            this.f7445a.f1474m.mo893a(!this.f7445a.f1474m.mo897b());
        }
        this.f7445a.m2095d();
    }
}
