package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import com.umeng.analytics.C0154a;
import com.ushareit.listenit.widget.ScanWidget;

public class hdv extends Thread {
    final /* synthetic */ ScanWidget f15234a;
    private final SurfaceHolder f15235b;
    private boolean f15236c = false;
    private int f15237d;
    private int f15238e;
    private int f15239f;
    private Rect f15240g = new Rect();

    public hdv(ScanWidget scanWidget, SurfaceHolder surfaceHolder) {
        this.f15234a = scanWidget;
        super("DrawThread");
        this.f15235b = surfaceHolder;
        this.f15237d = scanWidget.getWidth() / 2;
        this.f15238e = scanWidget.getHeight() / 2;
        this.f15239f = (int) (((float) scanWidget.getWidth()) * 0.33f);
        this.f15240g.set(0, 0, scanWidget.getWidth(), scanWidget.getHeight());
    }

    public void m23594a(boolean z) {
        this.f15236c = z;
    }

    public void run() {
        Throwable e;
        Canvas canvas = null;
        while (this.f15236c) {
            this.f15234a.f17352a = System.currentTimeMillis();
            this.f15234a.f17354c = this.f15234a.f17352a - this.f15234a.f17353b;
            if (this.f15234a.f17354c < 16) {
                try {
                    Thread.sleep(16 - this.f15234a.f17354c);
                } catch (Throwable e2) {
                    exw.m18450b("ScanWidget", "interrupt() was called for this Thread while it was sleeping.", e2);
                }
            }
            this.f15234a.f17353b = System.currentTimeMillis();
            Canvas lockCanvas;
            try {
                lockCanvas = this.f15235b.lockCanvas();
                if (lockCanvas != null) {
                    try {
                        lockCanvas.drawColor(this.f15234a.f17359h);
                        if (!this.f15234a.f17358g) {
                            this.f15234a.f17355d = (this.f15234a.f17355d + 10) % C0154a.f2960p;
                            lockCanvas.rotate((float) this.f15234a.f17355d, (float) this.f15237d, (float) this.f15238e);
                            lockCanvas.drawBitmap(m23592a(), null, this.f15240g, this.f15234a.f17363l);
                        } else if (this.f15234a.f17360i + this.f15234a.f17361j < this.f15239f) {
                            this.f15234a.f17355d = (this.f15234a.f17355d + 10) % C0154a.f2960p;
                            lockCanvas.rotate((float) this.f15234a.f17355d, (float) this.f15237d, (float) this.f15238e);
                            lockCanvas.drawBitmap(m23592a(), null, this.f15240g, this.f15234a.f17363l);
                            lockCanvas.drawCircle((float) this.f15237d, (float) this.f15238e, (float) (this.f15234a.f17360i + this.f15234a.f17361j), this.f15234a.f17363l);
                            this.f15234a.f17360i = this.f15234a.f17360i + this.f15234a.f17361j;
                        } else {
                            lockCanvas.drawColor(this.f15234a.f17359h);
                            lockCanvas.drawBitmap(m23593b(), null, this.f15240g, this.f15234a.f17363l);
                            this.f15236c = false;
                        }
                        if (lockCanvas != null) {
                            try {
                                this.f15235b.unlockCanvasAndPost(lockCanvas);
                            } catch (Throwable e22) {
                                exw.m18450b("ScanWidget", "a exception happened when unlockCanvasAndPost", e22);
                            }
                        }
                    } catch (Exception e3) {
                        if (lockCanvas != null) {
                            try {
                                this.f15235b.unlockCanvasAndPost(lockCanvas);
                            } catch (Throwable e222) {
                                exw.m18450b("ScanWidget", "a exception happened when unlockCanvasAndPost", e222);
                            }
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        canvas = lockCanvas;
                        e222 = th2;
                    }
                } else if (lockCanvas != null) {
                    try {
                        this.f15235b.unlockCanvasAndPost(lockCanvas);
                        return;
                    } catch (Throwable e2222) {
                        exw.m18450b("ScanWidget", "a exception happened when unlockCanvasAndPost", e2222);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Exception e4) {
                lockCanvas = null;
                if (lockCanvas != null) {
                    this.f15235b.unlockCanvasAndPost(lockCanvas);
                }
            } catch (Throwable th3) {
                e2222 = th3;
            }
        }
        return;
        if (canvas != null) {
            try {
                this.f15235b.unlockCanvasAndPost(canvas);
            } catch (Throwable th4) {
                exw.m18450b("ScanWidget", "a exception happened when unlockCanvasAndPost", th4);
            }
        }
        throw e2222;
        throw e2222;
    }

    private Bitmap m23592a() {
        if (this.f15234a.f17356e == null) {
            this.f15234a.f17356e = BitmapFactory.decodeResource(this.f15234a.getResources(), C0349R.drawable.scan_animation);
        }
        return this.f15234a.f17356e;
    }

    private Bitmap m23593b() {
        if (this.f15234a.f17357f == null) {
            this.f15234a.f17357f = BitmapFactory.decodeResource(this.f15234a.getResources(), C0349R.drawable.scan_result);
        }
        return this.f15234a.f17357f;
    }
}
