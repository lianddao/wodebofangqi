package com.ushareit.listenit;

import android.graphics.Rect;
import android.view.InputDevice;
import android.view.InputDevice.MotionRange;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.HashMap;
import java.util.Map;

public class atf {
    private static final String f5406a = atf.class.getSimpleName();
    private boolean f5407b;
    private int f5408c = -1;
    private int f5409d = -1;
    private int f5410e = -1;
    private int f5411f = -1;
    private long f5412g = -1;
    private int f5413h = -1;
    private long f5414i = -1;
    private long f5415j = -1;
    private int f5416k = -1;
    private int f5417l = -1;
    private int f5418m = -1;
    private int f5419n = -1;
    private float f5420o = -1.0f;
    private float f5421p = -1.0f;
    private float f5422q = -1.0f;

    public void m7119a() {
        this.f5412g = System.currentTimeMillis();
    }

    public void m7120a(MotionEvent motionEvent, View view, View view2) {
        if (!this.f5407b) {
            this.f5407b = true;
            InputDevice device = motionEvent.getDevice();
            if (device != null) {
                MotionRange motionRange = device.getMotionRange(0);
                MotionRange motionRange2 = device.getMotionRange(1);
                if (!(motionRange == null || motionRange2 == null)) {
                    this.f5422q = Math.min(motionRange.getRange(), motionRange2.getRange());
                }
            }
            if (this.f5422q <= 0.0f) {
                this.f5422q = (float) Math.min(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationInWindow(iArr2);
        switch (motionEvent.getAction()) {
            case 0:
                this.f5408c = iArr[0];
                this.f5409d = iArr[1];
                this.f5410e = view.getWidth();
                this.f5411f = view.getHeight();
                this.f5413h = 1;
                this.f5414i = System.currentTimeMillis();
                this.f5416k = (((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0];
                this.f5417l = (iArr2[1] + ((int) (motionEvent.getY() + 0.5f))) - iArr[1];
                this.f5420o = motionEvent.getPressure();
                this.f5421p = motionEvent.getSize();
                return;
            case 1:
            case 3:
                this.f5415j = System.currentTimeMillis();
                this.f5418m = (((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0];
                this.f5419n = (iArr2[1] + ((int) (motionEvent.getY() + 0.5f))) - iArr[1];
                return;
            case 2:
                this.f5420o -= this.f5420o / ((float) this.f5413h);
                this.f5420o += motionEvent.getPressure() / ((float) this.f5413h);
                this.f5421p -= this.f5421p / ((float) this.f5413h);
                this.f5421p += motionEvent.getSize() / ((float) this.f5413h);
                this.f5413h++;
                return;
            default:
                return;
        }
    }

    public boolean m7121a(int i) {
        if (!m7124d() || this.f5418m == -1 || this.f5419n == -1 || this.f5410e == -1 || this.f5411f == -1) {
            return false;
        }
        int i2 = (this.f5411f * i) / 100;
        int i3 = (this.f5410e * i) / 100;
        return !new Rect(i3, i2, this.f5410e - i3, this.f5411f - i2).contains(this.f5418m, this.f5419n);
    }

    public boolean m7122b() {
        return this.f5412g != -1;
    }

    public long m7123c() {
        return m7122b() ? System.currentTimeMillis() - this.f5412g : -1;
    }

    public boolean m7124d() {
        return this.f5407b;
    }

    public Map<String, String> m7125e() {
        if (!this.f5407b) {
            return null;
        }
        String valueOf = String.valueOf((this.f5421p * this.f5422q) / 2.0f);
        long j = (this.f5412g <= 0 || this.f5415j <= this.f5412g) ? -1 : this.f5415j - this.f5412g;
        Map<String, String> hashMap = new HashMap();
        hashMap.put("adPositionX", String.valueOf(this.f5408c));
        hashMap.put("adPositionY", String.valueOf(this.f5409d));
        hashMap.put(VastIconXmlManager.WIDTH, String.valueOf(this.f5410e));
        hashMap.put(VastIconXmlManager.HEIGHT, String.valueOf(this.f5411f));
        hashMap.put("clickDelayTime", String.valueOf(j));
        hashMap.put("startTime", String.valueOf(this.f5414i));
        hashMap.put("endTime", String.valueOf(this.f5415j));
        hashMap.put("startX", String.valueOf(this.f5416k));
        hashMap.put("startY", String.valueOf(this.f5417l));
        hashMap.put("clickX", String.valueOf(this.f5418m));
        hashMap.put("clickY", String.valueOf(this.f5419n));
        hashMap.put("endX", String.valueOf(this.f5418m));
        hashMap.put("endY", String.valueOf(this.f5419n));
        hashMap.put("force", String.valueOf(this.f5420o));
        hashMap.put("radiusX", valueOf);
        hashMap.put("radiusY", valueOf);
        return hashMap;
    }
}
