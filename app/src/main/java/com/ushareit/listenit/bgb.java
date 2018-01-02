package com.ushareit.listenit;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.Format;
import java.util.List;

final class bgb implements Callback, SurfaceTextureListener, bgi, bnh<List<bnm>>, box, bqq<Object>, btl {
    final /* synthetic */ bfz f6155a;

    private bgb(bfz com_ushareit_listenit_bfz) {
        this.f6155a = com_ushareit_listenit_bfz;
    }

    public /* synthetic */ void mo918a(Object obj) {
        m8207b((List) obj);
    }

    public void mo916a(bhe com_ushareit_listenit_bhe) {
        this.f6155a.f6147s = com_ushareit_listenit_bhe;
        if (this.f6155a.f6146r != null) {
            this.f6155a.f6146r.mo916a(com_ushareit_listenit_bhe);
        }
    }

    public void mo919a(String str, long j, long j2) {
        if (this.f6155a.f6146r != null) {
            this.f6155a.f6146r.mo919a(str, j, j2);
        }
    }

    public void mo915a(Format format) {
        this.f6155a.f6136h = format;
        if (this.f6155a.f6146r != null) {
            this.f6155a.f6146r.mo915a(format);
        }
    }

    public void mo912a(int i, long j) {
        if (this.f6155a.f6146r != null) {
            this.f6155a.f6146r.mo912a(i, j);
        }
    }

    public void mo911a(int i, int i2, int i3, float f) {
        if (this.f6155a.f6144p != null) {
            this.f6155a.f6144p.mo110a(i, i2, i3, f);
        }
        if (this.f6155a.f6146r != null) {
            this.f6155a.f6146r.mo911a(i, i2, i3, f);
        }
    }

    public void mo914a(Surface surface) {
        if (this.f6155a.f6144p != null && this.f6155a.f6138j == surface) {
            this.f6155a.f6144p.mo109a();
        }
        if (this.f6155a.f6146r != null) {
            this.f6155a.f6146r.mo914a(surface);
        }
    }

    public void mo921b(bhe com_ushareit_listenit_bhe) {
        if (this.f6155a.f6146r != null) {
            this.f6155a.f6146r.mo921b(com_ushareit_listenit_bhe);
        }
        this.f6155a.f6136h = null;
        this.f6155a.f6147s = null;
    }

    public void mo923c(bhe com_ushareit_listenit_bhe) {
        this.f6155a.f6148t = com_ushareit_listenit_bhe;
        if (this.f6155a.f6145q != null) {
            this.f6155a.f6145q.mo923c(com_ushareit_listenit_bhe);
        }
    }

    public void mo910a(int i) {
        this.f6155a.f6149u = i;
        if (this.f6155a.f6145q != null) {
            this.f6155a.f6145q.mo910a(i);
        }
    }

    public void mo922b(String str, long j, long j2) {
        if (this.f6155a.f6145q != null) {
            this.f6155a.f6145q.mo922b(str, j, j2);
        }
    }

    public void mo920b(Format format) {
        this.f6155a.f6137i = format;
        if (this.f6155a.f6145q != null) {
            this.f6155a.f6145q.mo920b(format);
        }
    }

    public void mo913a(int i, long j, long j2) {
        if (this.f6155a.f6145q != null) {
            this.f6155a.f6145q.mo913a(i, j, j2);
        }
    }

    public void mo924d(bhe com_ushareit_listenit_bhe) {
        if (this.f6155a.f6145q != null) {
            this.f6155a.f6145q.mo924d(com_ushareit_listenit_bhe);
        }
        this.f6155a.f6137i = null;
        this.f6155a.f6148t = null;
        this.f6155a.f6149u = 0;
    }

    public void mo243a(List<bom> list) {
        if (this.f6155a.f6142n != null) {
            this.f6155a.f6142n.mo243a(list);
        }
    }

    public void m8207b(List<bnm> list) {
        if (this.f6155a.f6143o != null) {
            this.f6155a.f6143o.mo918a(list);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f6155a.m8132a(surfaceHolder.getSurface(), false);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f6155a.m8132a(null, false);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f6155a.m8132a(new Surface(surfaceTexture), true);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f6155a.m8132a(null, true);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void mo917a(bqn<?> com_ushareit_listenit_bqn_) {
        boolean z = false;
        int i = 0;
        while (i < this.f6155a.f6130b.length) {
            if (this.f6155a.f6130b[i].mo864a() == 2 && com_ushareit_listenit_bqn_.m9530a(i) != null) {
                z = true;
                break;
            }
            i++;
        }
        if (!(this.f6155a.f6144p == null || !this.f6155a.f6135g || z)) {
            this.f6155a.f6144p.mo115b();
        }
        this.f6155a.f6135g = z;
    }
}
