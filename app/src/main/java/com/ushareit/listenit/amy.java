package com.ushareit.listenit;

import java.io.Serializable;

public class amy implements Serializable {
    private double f4890a;
    private double f4891b;
    private double f4892c;
    private double f4893d;
    private double f4894e;
    private double f4895f;
    private double f4896g;
    private int f4897h;
    private double f4898i;
    private double f4899j;
    private double f4900k;

    public amy(double d) {
        this.f4894e = d;
    }

    public void m6344a() {
        this.f4890a = 0.0d;
        this.f4892c = 0.0d;
        this.f4893d = 0.0d;
        this.f4895f = 0.0d;
        this.f4897h = 0;
        this.f4898i = 0.0d;
        this.f4899j = 1.0d;
        this.f4900k = 0.0d;
    }

    public void m6345a(double d, double d2) {
        this.f4897h++;
        this.f4898i += d;
        this.f4892c = d2;
        this.f4900k += d2 * d;
        this.f4890a = this.f4900k / this.f4898i;
        this.f4899j = Math.min(this.f4899j, d2);
        this.f4895f = Math.max(this.f4895f, d2);
        if (d2 >= this.f4894e) {
            this.f4893d += d;
            this.f4891b += d;
            this.f4896g = Math.max(this.f4896g, this.f4891b);
            return;
        }
        this.f4891b = 0.0d;
    }

    public double m6346b() {
        return this.f4897h == 0 ? 0.0d : this.f4899j;
    }

    public double m6347c() {
        return this.f4890a;
    }

    public double m6348d() {
        return this.f4895f;
    }

    public double m6349e() {
        return this.f4898i;
    }

    public double m6350f() {
        return this.f4893d;
    }

    public double m6351g() {
        return this.f4896g;
    }
}
