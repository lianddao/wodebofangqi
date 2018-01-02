package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.Format;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public final class bfz implements bfj {
    private final bfj f6129a;
    private final bfx[] f6130b;
    private final bgb f6131c = new bgb();
    private final Handler f6132d = new Handler();
    private final int f6133e;
    private final int f6134f;
    private boolean f6135g;
    private Format f6136h;
    private Format f6137i;
    private Surface f6138j;
    private boolean f6139k;
    private SurfaceHolder f6140l;
    private TextureView f6141m;
    private box f6142n;
    private bnh<List<bnm>> f6143o;
    private bgc f6144p;
    private bgi f6145q;
    private btl f6146r;
    private bhe f6147s;
    private bhe f6148t;
    private int f6149u;
    private float f6150v;

    bfz(Context context, bqo<?> com_ushareit_listenit_bqo_, bfv com_ushareit_listenit_bfv, bhm<bho> com_ushareit_listenit_bhm_com_ushareit_listenit_bho, boolean z, long j) {
        com_ushareit_listenit_bqo_.m9506a(this.f6131c);
        ArrayList arrayList = new ArrayList();
        if (z) {
            m8134a(arrayList, j);
            m8131a(context, com_ushareit_listenit_bhm_com_ushareit_listenit_bho, arrayList, j);
        } else {
            m8131a(context, com_ushareit_listenit_bhm_com_ushareit_listenit_bho, arrayList, j);
            m8134a(arrayList, j);
        }
        this.f6130b = (bfx[]) arrayList.toArray(new bfx[arrayList.size()]);
        int i = 0;
        int i2 = 0;
        for (bfx a : this.f6130b) {
            switch (a.mo864a()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
                default:
                    break;
            }
        }
        this.f6133e = i2;
        this.f6134f = i;
        this.f6149u = 0;
        this.f6150v = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f6129a = new bfo(this.f6130b, com_ushareit_listenit_bqo_, com_ushareit_listenit_bfv);
    }

    public void m8150a(Surface surface) {
        m8145m();
        m8132a(surface, false);
    }

    public void m8151a(SurfaceHolder surfaceHolder) {
        m8145m();
        this.f6140l = surfaceHolder;
        if (surfaceHolder == null) {
            m8132a(null, false);
            return;
        }
        m8132a(surfaceHolder.getSurface(), false);
        surfaceHolder.addCallback(this.f6131c);
    }

    public void m8152a(SurfaceView surfaceView) {
        m8151a(surfaceView.getHolder());
    }

    public void m8153a(TextureView textureView) {
        Surface surface = null;
        m8145m();
        this.f6141m = textureView;
        if (textureView == null) {
            m8132a(null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
        if (surfaceTexture != null) {
            surface = new Surface(surfaceTexture);
        }
        m8132a(surface, true);
        textureView.setSurfaceTextureListener(this.f6131c);
    }

    public void m8147a(float f) {
        this.f6150v = f;
        bfm[] com_ushareit_listenit_bfmArr = new bfm[this.f6134f];
        bfx[] com_ushareit_listenit_bfxArr = this.f6130b;
        int length = com_ushareit_listenit_bfxArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            bfl com_ushareit_listenit_bfl = com_ushareit_listenit_bfxArr[i];
            if (com_ushareit_listenit_bfl.mo864a() == 1) {
                i3 = i2 + 1;
                com_ushareit_listenit_bfmArr[i2] = new bfm(com_ushareit_listenit_bfl, 2, Float.valueOf(f));
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        this.f6129a.mo894a(com_ushareit_listenit_bfmArr);
    }

    public int m8172l() {
        return this.f6149u;
    }

    public void m8155a(bgc com_ushareit_listenit_bgc) {
        this.f6144p = com_ushareit_listenit_bgc;
    }

    public void m8157a(box com_ushareit_listenit_box) {
        this.f6142n = com_ushareit_listenit_box;
    }

    public void mo891a(bfk com_ushareit_listenit_bfk) {
        this.f6129a.mo891a(com_ushareit_listenit_bfk);
    }

    public void mo895b(bfk com_ushareit_listenit_bfk) {
        this.f6129a.mo895b(com_ushareit_listenit_bfk);
    }

    public int mo888a() {
        return this.f6129a.mo888a();
    }

    public void mo892a(bod com_ushareit_listenit_bod) {
        this.f6129a.mo892a(com_ushareit_listenit_bod);
    }

    public void mo893a(boolean z) {
        this.f6129a.mo893a(z);
    }

    public boolean mo897b() {
        return this.f6129a.mo897b();
    }

    public void mo898c() {
        this.f6129a.mo898c();
    }

    public void mo889a(int i) {
        this.f6129a.mo889a(i);
    }

    public void mo890a(long j) {
        this.f6129a.mo890a(j);
    }

    public void mo899d() {
        this.f6129a.mo899d();
    }

    public void mo900e() {
        this.f6129a.mo900e();
        m8145m();
        if (this.f6138j != null) {
            if (this.f6139k) {
                this.f6138j.release();
            }
            this.f6138j = null;
        }
    }

    public void mo894a(bfm... com_ushareit_listenit_bfmArr) {
        this.f6129a.mo894a(com_ushareit_listenit_bfmArr);
    }

    public void mo896b(bfm... com_ushareit_listenit_bfmArr) {
        this.f6129a.mo896b(com_ushareit_listenit_bfmArr);
    }

    public int mo902g() {
        return this.f6129a.mo902g();
    }

    public long mo903h() {
        return this.f6129a.mo903h();
    }

    public long mo904i() {
        return this.f6129a.mo904i();
    }

    public long mo905j() {
        return this.f6129a.mo905j();
    }

    public int mo906k() {
        return this.f6129a.mo906k();
    }

    public bgd mo901f() {
        return this.f6129a.mo901f();
    }

    private void m8131a(Context context, bhm<bho> com_ushareit_listenit_bhm_com_ushareit_listenit_bho, ArrayList<bfx> arrayList, long j) {
        arrayList.add(new bth(context, bmv.f7117a, 1, j, com_ushareit_listenit_bhm_com_ushareit_listenit_bho, false, this.f6132d, this.f6131c, 50));
        arrayList.add(new bha(bmv.f7117a, com_ushareit_listenit_bhm_com_ushareit_listenit_bho, true, this.f6132d, this.f6131c, bgh.m8236a(context), 3));
        arrayList.add(new bow(this.f6131c, this.f6132d.getLooper()));
        arrayList.add(new bng(this.f6131c, this.f6132d.getLooper(), new bnl()));
    }

    private void m8134a(ArrayList<bfx> arrayList, long j) {
        try {
            arrayList.add((bfx) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, btl.class, Integer.TYPE}).newInstance(new Object[]{Boolean.valueOf(true), Long.valueOf(j), this.f6132d, this.f6131c, Integer.valueOf(50)}));
            Log.i("SimpleExoPlayer", "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException e) {
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
        try {
            arrayList.add((bfx) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(new Class[]{Handler.class, bgi.class}).newInstance(new Object[]{this.f6132d, this.f6131c}));
            Log.i("SimpleExoPlayer", "Loaded LibopusAudioRenderer.");
        } catch (ClassNotFoundException e3) {
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        }
        try {
            arrayList.add((bfx) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(new Class[]{Handler.class, bgi.class}).newInstance(new Object[]{this.f6132d, this.f6131c}));
            Log.i("SimpleExoPlayer", "Loaded LibflacAudioRenderer.");
        } catch (ClassNotFoundException e4) {
        } catch (Throwable e222) {
            throw new RuntimeException(e222);
        }
        try {
            arrayList.add((bfx) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, bgi.class}).newInstance(new Object[]{this.f6132d, this.f6131c}));
            Log.i("SimpleExoPlayer", "Loaded FfmpegAudioRenderer.");
        } catch (ClassNotFoundException e5) {
        } catch (Throwable e2222) {
            throw new RuntimeException(e2222);
        }
    }

    private void m8145m() {
        if (this.f6141m != null) {
            if (this.f6141m.getSurfaceTextureListener() != this.f6131c) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f6141m.setSurfaceTextureListener(null);
            }
            this.f6141m = null;
        }
        if (this.f6140l != null) {
            this.f6140l.removeCallback(this.f6131c);
            this.f6140l = null;
        }
    }

    private void m8132a(Surface surface, boolean z) {
        bfm[] com_ushareit_listenit_bfmArr = new bfm[this.f6133e];
        bfx[] com_ushareit_listenit_bfxArr = this.f6130b;
        int length = com_ushareit_listenit_bfxArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            bfl com_ushareit_listenit_bfl = com_ushareit_listenit_bfxArr[i];
            if (com_ushareit_listenit_bfl.mo864a() == 2) {
                i3 = i2 + 1;
                com_ushareit_listenit_bfmArr[i2] = new bfm(com_ushareit_listenit_bfl, 1, surface);
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (this.f6138j == null || this.f6138j == surface) {
            this.f6129a.mo894a(com_ushareit_listenit_bfmArr);
        } else {
            if (this.f6139k) {
                this.f6138j.release();
            }
            this.f6129a.mo896b(com_ushareit_listenit_bfmArr);
        }
        this.f6138j = surface;
        this.f6139k = z;
    }
}
