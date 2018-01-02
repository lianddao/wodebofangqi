package com.ushareit.listenit.cutter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fqe;
import com.ushareit.listenit.fqf;
import com.ushareit.listenit.fqg;
import com.ushareit.listenit.gum;

public class WavePlayerView extends RelativeLayout {
    private ImageView f9112a;
    private TouchWaveformView f9113b;
    private int f9114c;
    private int f9115d;
    private gum f9116e;
    private View f9117f;
    private View f9118g;
    private OnClickListener f9119h = new fqe(this);
    private OnClickListener f9120i = new fqf(this);
    private OnClickListener f9121j = new fqg(this);

    public WavePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, C0349R.layout.wave_player_view, this);
        m12912c();
    }

    private void m12912c() {
        this.f9112a = (ImageView) findViewById(C0349R.id.play);
        this.f9117f = findViewById(C0349R.id.rew);
        this.f9118g = findViewById(C0349R.id.ffwd);
        this.f9112a.setOnClickListener(this.f9119h);
        this.f9117f.setOnClickListener(this.f9120i);
        this.f9118g.setOnClickListener(this.f9121j);
    }

    public void m12914a(TouchWaveformView touchWaveformView) {
        this.f9113b = touchWaveformView;
    }

    public void setPlayService(gum com_ushareit_listenit_gum) {
        this.f9116e = com_ushareit_listenit_gum;
    }

    public synchronized void m12913a(int i) {
        if (this.f9116e != null) {
            try {
                this.f9114c = this.f9113b.m12900a(i);
                this.f9115d = this.f9113b.m12905b(i);
                this.f9116e.mo2411a(this.f9114c);
                this.f9116e.mo2438c();
                this.f9113b.m12906b();
            } catch (Exception e) {
                exw.m18457e("WavePlayerView", "play error");
            }
        }
    }

    public int getNowPosition() {
        return this.f9116e == null ? 0 : this.f9116e.mo2463t();
    }

    public void setButtonsEnable(boolean z) {
        this.f9112a.setEnabled(z);
        this.f9117f.setEnabled(z);
        this.f9118g.setEnabled(z);
    }

    public boolean m12916a() {
        return this.f9116e != null && this.f9116e.mo2425a();
    }

    public synchronized void m12917b() {
        if (this.f9116e != null) {
            this.f9116e.mo2447f();
            if (this.f9113b != null) {
                this.f9113b.setPlayback(-1);
            }
        }
    }

    public int getPlayEndMillisecond() {
        return this.f9115d;
    }

    public void m12915a(boolean z) {
        if (z) {
            this.f9112a.setImageResource(C0349R.drawable.cutter_button_pause_selector);
        } else {
            this.f9112a.setImageResource(C0349R.drawable.cutter_button_play_selector);
        }
    }
}
