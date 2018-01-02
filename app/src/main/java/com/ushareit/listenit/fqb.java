package com.ushareit.listenit;

import com.ushareit.listenit.cutter.view.MarkerView;
import com.ushareit.listenit.cutter.view.TouchWaveformView;

public class fqb implements fpr {
    final /* synthetic */ TouchWaveformView f13225a;
    private float f13226b;

    public fqb(TouchWaveformView touchWaveformView) {
        this.f13225a = touchWaveformView;
    }

    public void mo2525a(MarkerView markerView, float f) {
        this.f13225a.f9079C = true;
        this.f13225a.f9081E = f;
        this.f13225a.f9107v = this.f13225a.f9097l;
        this.f13225a.f9108w = this.f13225a.f9098m;
        if (markerView == this.f13225a.f9092g) {
            this.f13225a.f9090e.setVisibility(0);
        }
        if (markerView == this.f13225a.f9093h) {
            this.f13225a.f9091f.setVisibility(0);
        }
    }

    public void mo2529b(MarkerView markerView, float f) {
        if (this.f13225a.f9086a.m12937a()) {
            float i = f - this.f13225a.f9081E;
            if (markerView != this.f13225a.f9092g) {
                this.f13225a.f9098m = this.f13225a.m12861d((int) (i + ((float) this.f13225a.f9108w)));
                if (this.f13225a.f9098m < this.f13225a.f9097l) {
                    this.f13225a.f9098m = this.f13225a.f9097l;
                }
                this.f13225a.m12881j();
                this.f13225a.m12850a(this.f13225a.f9093h, this.f13225a.f9098m, (this.f13225a.f9086a.getMeasuredHeight() - this.f13225a.f9093h.getHeight()) - this.f13225a.f9104s);
                this.f13225a.m12849a(this.f13225a.f9091f, this.f13225a.f9098m);
            } else if (this.f13225a.f9097l < this.f13225a.f9098m) {
                this.f13225a.f9097l = this.f13225a.m12861d((int) (i + ((float) this.f13225a.f9107v)));
                this.f13225a.m12881j();
                this.f13225a.m12850a(this.f13225a.f9092g, this.f13225a.f9097l, this.f13225a.f9103r);
                this.f13225a.m12849a(this.f13225a.f9090e, this.f13225a.f9097l);
            } else {
                this.f13225a.f9097l = this.f13225a.m12861d((int) (((float) this.f13225a.f9107v) + i));
                if (this.f13226b <= f) {
                    this.f13225a.f9098m = this.f13225a.m12861d((int) (i + ((float) this.f13225a.f9107v)));
                    this.f13225a.m12850a(this.f13225a.f9093h, this.f13225a.f9098m, (this.f13225a.f9086a.getMeasuredHeight() - this.f13225a.f9093h.getHeight()) - this.f13225a.f9104s);
                    this.f13225a.m12849a(this.f13225a.f9091f, this.f13225a.f9098m);
                }
                this.f13225a.m12881j();
                this.f13225a.m12850a(this.f13225a.f9092g, this.f13225a.f9097l, this.f13225a.f9103r);
                this.f13225a.m12849a(this.f13225a.f9090e, this.f13225a.f9097l);
            }
            this.f13226b = f;
            this.f13225a.m12901a();
            this.f13225a.f9094i.mo2512a();
        }
    }

    public void mo2524a(MarkerView markerView) {
        this.f13225a.f9079C = false;
        this.f13225a.f9078B = false;
        if (markerView == this.f13225a.f9092g) {
            m20350c();
            if (this.f13225a.f9089d != null && this.f13225a.f9097l < this.f13225a.f9098m) {
                this.f13225a.f9089d.m12913a(this.f13225a.f9097l);
            }
            this.f13225a.f9090e.setVisibility(4);
            return;
        }
        m20351d();
        if (this.f13225a.f9097l < this.f13225a.f9098m) {
            int c = this.f13225a.f9086a.m12941c(this.f13225a.f9097l);
            int c2 = this.f13225a.f9086a.m12941c(this.f13225a.f9098m);
            if (c2 - c >= 5000) {
                c = c2 - 5000;
            }
            if (this.f13225a.f9089d != null) {
                this.f13225a.f9089d.m12913a(this.f13225a.f9086a.m12939b(c));
            }
            this.f13225a.f9091f.setVisibility(4);
        }
    }

    private void m20350c() {
        m20349a(this.f13225a.f9097l - (this.f13225a.f9100o / 2));
    }

    private void m20351d() {
        m20349a(this.f13225a.f9098m - (this.f13225a.f9100o / 2));
    }

    private void m20349a(int i) {
        this.f13225a.setOffsetGoalNoUpdate(i);
        this.f13225a.m12906b();
    }

    public void mo2528b(MarkerView markerView) {
        this.f13225a.m12902a(markerView);
    }

    public void mo2526a(MarkerView markerView, int i) {
        this.f13225a.f9080D = true;
        if (markerView == this.f13225a.f9092g) {
            int c = this.f13225a.f9097l;
            this.f13225a.f9097l = this.f13225a.m12861d(this.f13225a.f9097l - i);
            this.f13225a.f9098m = this.f13225a.m12861d(this.f13225a.f9098m - (c - this.f13225a.f9097l));
            m20350c();
        }
        if (markerView == this.f13225a.f9093h) {
            if (this.f13225a.f9098m == this.f13225a.f9097l) {
                this.f13225a.f9097l = this.f13225a.m12861d(this.f13225a.f9097l - i);
                this.f13225a.f9098m = this.f13225a.f9097l;
            } else {
                this.f13225a.f9098m = this.f13225a.m12861d(this.f13225a.f9098m - i);
            }
            m20351d();
        }
        this.f13225a.m12906b();
    }

    public void mo2530b(MarkerView markerView, int i) {
        this.f13225a.f9080D = true;
        if (markerView == this.f13225a.f9092g) {
            int c = this.f13225a.f9097l;
            this.f13225a.f9097l = this.f13225a.f9097l + i;
            if (this.f13225a.f9097l > this.f13225a.f9096k) {
                this.f13225a.f9097l = this.f13225a.f9096k;
            }
            this.f13225a.f9098m = (this.f13225a.f9097l - c) + this.f13225a.f9098m;
            if (this.f13225a.f9098m > this.f13225a.f9096k) {
                this.f13225a.f9098m = this.f13225a.f9096k;
            }
            m20350c();
        }
        if (markerView == this.f13225a.f9093h) {
            this.f13225a.f9098m = this.f13225a.f9098m + i;
            if (this.f13225a.f9098m > this.f13225a.f9096k) {
                this.f13225a.f9098m = this.f13225a.f9096k;
            }
            m20351d();
        }
        this.f13225a.m12906b();
    }

    public void mo2531c(MarkerView markerView) {
    }

    public void mo2523a() {
        this.f13225a.f9080D = false;
        this.f13225a.m12906b();
    }

    public void mo2527b() {
    }
}
