package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;
import android.view.animation.Interpolator;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.volley.DefaultRetryPolicy;

public class su implements Runnable {
    final /* synthetic */ RecyclerView f16542a;
    private int f16543b;
    private int f16544c;
    private pb f16545d;
    private Interpolator f16546e = RecyclerView.ao;
    private boolean f16547f = false;
    private boolean f16548g = false;

    public su(RecyclerView recyclerView) {
        this.f16542a = recyclerView;
        this.f16545d = pb.m25418a(recyclerView.getContext(), RecyclerView.ao);
    }

    public void run() {
        m26209c();
        this.f16542a.m503t();
        pb pbVar = this.f16545d;
        sq sqVar = this.f16542a.f362q.f296s;
        if (pbVar.m25430g()) {
            int e;
            int i;
            int f;
            int i2;
            Object obj;
            Object obj2;
            int b = pbVar.m25425b();
            int c = pbVar.m25426c();
            int i3 = b - this.f16543b;
            int i4 = c - this.f16544c;
            int i5 = 0;
            int i6 = 0;
            this.f16543b = b;
            this.f16544c = c;
            int i7 = 0;
            int i8 = 0;
            if (this.f16542a.f361p != null) {
                this.f16542a.m525b();
                this.f16542a.m511z();
                fj.m19509a("RV Scroll");
                if (i3 != 0) {
                    i5 = this.f16542a.f362q.mo24a(i3, this.f16542a.f348a, this.f16542a.f353f);
                    i7 = i3 - i5;
                }
                if (i4 != 0) {
                    i6 = this.f16542a.f362q.mo32b(i4, this.f16542a.f348a, this.f16542a.f353f);
                    i8 = i4 - i6;
                }
                fj.m19508a();
                this.f16542a.m440F();
                this.f16542a.m435A();
                this.f16542a.m522a(false);
                if (!(sqVar == null || sqVar.m7381g() || !sqVar.m7382h())) {
                    e = this.f16542a.f353f.m26205e();
                    if (e == 0) {
                        sqVar.m7380f();
                        i = i7;
                        i7 = i6;
                        i6 = i;
                    } else if (sqVar.m7383i() >= e) {
                        sqVar.m7377d(e - 1);
                        sqVar.m7367a(i3 - i7, i4 - i8);
                        i = i7;
                        i7 = i6;
                        i6 = i;
                    } else {
                        sqVar.m7367a(i3 - i7, i4 - i8);
                    }
                    if (!this.f16542a.f364s.isEmpty()) {
                        this.f16542a.invalidate();
                    }
                    if (ja.m24133a(this.f16542a) != 2) {
                        this.f16542a.m483h(i3, i4);
                    }
                    if (!(i6 == 0 && i8 == 0)) {
                        f = (int) pbVar.m25429f();
                        if (i6 == b) {
                            e = i6 >= 0 ? -f : i6 <= 0 ? f : 0;
                            i2 = e;
                        } else {
                            i2 = 0;
                        }
                        if (i8 != c) {
                            f = 0;
                        } else if (i8 < 0) {
                            f = -f;
                        } else if (i8 <= 0) {
                            f = 0;
                        }
                        if (ja.m24133a(this.f16542a) != 2) {
                            this.f16542a.m531c(i2, f);
                        }
                        if ((i2 != 0 || i6 == b || pbVar.m25427d() == 0) && (f != 0 || i8 == c || pbVar.m25428e() == 0)) {
                            pbVar.m25431h();
                        }
                    }
                    if (!(i5 == 0 && i7 == 0)) {
                        this.f16542a.m546g(i5, i7);
                    }
                    if (!this.f16542a.awakenScrollBars()) {
                        this.f16542a.invalidate();
                    }
                    obj = (i4 == 0 && this.f16542a.f362q.mo43e() && i7 == i4) ? 1 : null;
                    obj2 = (i3 == 0 && this.f16542a.f362q.mo41d() && i5 == i3) ? 1 : null;
                    obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                    if (!pbVar.m25423a() || obj2 == null) {
                        this.f16542a.setScrollState(0);
                    } else {
                        m26211a();
                    }
                }
            }
            i = i7;
            i7 = i6;
            i6 = i;
            if (this.f16542a.f364s.isEmpty()) {
                this.f16542a.invalidate();
            }
            if (ja.m24133a(this.f16542a) != 2) {
                this.f16542a.m483h(i3, i4);
            }
            f = (int) pbVar.m25429f();
            if (i6 == b) {
                i2 = 0;
            } else {
                if (i6 >= 0) {
                    if (i6 <= 0) {
                    }
                }
                i2 = e;
            }
            if (i8 != c) {
                f = 0;
            } else if (i8 < 0) {
                f = -f;
            } else if (i8 <= 0) {
                f = 0;
            }
            if (ja.m24133a(this.f16542a) != 2) {
                this.f16542a.m531c(i2, f);
            }
            pbVar.m25431h();
            this.f16542a.m546g(i5, i7);
            if (this.f16542a.awakenScrollBars()) {
                this.f16542a.invalidate();
            }
            if (i4 == 0) {
            }
            if (i3 == 0) {
            }
            if (i3 == 0) {
            }
            if (pbVar.m25423a()) {
            }
            this.f16542a.setScrollState(0);
        }
        if (sqVar != null) {
            if (sqVar.m7381g()) {
                sqVar.m7367a(0, 0);
            }
            if (!this.f16548g) {
                sqVar.m7380f();
            }
        }
        m26210d();
    }

    private void m26209c() {
        this.f16548g = false;
        this.f16547f = true;
    }

    private void m26210d() {
        this.f16547f = false;
        if (this.f16548g) {
            m26211a();
        }
    }

    void m26211a() {
        if (this.f16547f) {
            this.f16548g = true;
            return;
        }
        this.f16542a.removeCallbacks(this);
        ja.m24141a(this.f16542a, (Runnable) this);
    }

    public void m26212a(int i, int i2) {
        this.f16542a.setScrollState(2);
        this.f16544c = 0;
        this.f16543b = 0;
        this.f16545d.m25421a(0, 0, i, i2, Integer.MIN_VALUE, MoPubClientPositioning.NO_REPEAT, Integer.MIN_VALUE, MoPubClientPositioning.NO_REPEAT);
        m26211a();
    }

    public void m26217b(int i, int i2) {
        m26214a(i, i2, 0, 0);
    }

    public void m26214a(int i, int i2, int i3, int i4) {
        m26213a(i, i2, m26208b(i, i2, i3, i4));
    }

    private float m26207a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private int m26208b(int i, int i2, int i3, int i4) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.f16542a.getWidth() : this.f16542a.getHeight();
        int i5 = width / 2;
        float a = (m26207a(Math.min(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (((float) sqrt2) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) width))) * ((float) i5)) + ((float) i5);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
        } else {
            if (obj != null) {
                round = abs;
            } else {
                round = abs2;
            }
            round = (int) (((((float) round) / ((float) width)) + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) * 300.0f);
        }
        return Math.min(round, 2000);
    }

    public void m26213a(int i, int i2, int i3) {
        m26215a(i, i2, i3, RecyclerView.ao);
    }

    public void m26215a(int i, int i2, int i3, Interpolator interpolator) {
        if (this.f16546e != interpolator) {
            this.f16546e = interpolator;
            this.f16545d = pb.m25418a(this.f16542a.getContext(), interpolator);
        }
        this.f16542a.setScrollState(2);
        this.f16544c = 0;
        this.f16543b = 0;
        this.f16545d.m25420a(0, 0, i, i2, i3);
        m26211a();
    }

    public void m26216b() {
        this.f16542a.removeCallbacks(this);
        this.f16545d.m25431h();
    }
}
