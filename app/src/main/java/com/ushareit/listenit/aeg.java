package com.ushareit.listenit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.Queue;

public final class aeg<A, T, Z, R> implements aei, ael, aff {
    private static final Queue<aeg<?, ?, ?, ?>> f4197a = afu.m5496a(0);
    private wk<?> f4198A;
    private vu f4199B;
    private long f4200C;
    private aeh f4201D;
    private final String f4202b = String.valueOf(hashCode());
    private uv f4203c;
    private Drawable f4204d;
    private int f4205e;
    private int f4206f;
    private int f4207g;
    private Context f4208h;
    private uz<Z> f4209i;
    private aef<A, T, Z, R> f4210j;
    private aej f4211k;
    private A f4212l;
    private Class<R> f4213m;
    private boolean f4214n;
    private tv f4215o;
    private afi<R> f4216p;
    private aek<? super A, R> f4217q;
    private float f4218r;
    private vr f4219s;
    private aes<R> f4220t;
    private int f4221u;
    private int f4222v;
    private vq f4223w;
    private Drawable f4224x;
    private Drawable f4225y;
    private boolean f4226z;

    public static <A, T, Z, R> aeg<A, T, Z, R> m5360a(aef<A, T, Z, R> com_ushareit_listenit_aef_A__T__Z__R, A a, uv uvVar, Context context, tv tvVar, afi<R> com_ushareit_listenit_afi_R, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, aek<? super A, R> com_ushareit_listenit_aek__super_A__R, aej com_ushareit_listenit_aej, vr vrVar, uz<Z> uzVar, Class<R> cls, boolean z, aes<R> com_ushareit_listenit_aes_R, int i4, int i5, vq vqVar) {
        aeg<A, T, Z, R> com_ushareit_listenit_aeg_A__T__Z__R = (aeg) f4197a.poll();
        if (com_ushareit_listenit_aeg_A__T__Z__R == null) {
            com_ushareit_listenit_aeg_A__T__Z__R = new aeg();
        }
        com_ushareit_listenit_aeg_A__T__Z__R.m5364b(com_ushareit_listenit_aef_A__T__Z__R, a, uvVar, context, tvVar, com_ushareit_listenit_afi_R, f, drawable, i, drawable2, i2, drawable3, i3, com_ushareit_listenit_aek__super_A__R, com_ushareit_listenit_aej, vrVar, uzVar, cls, z, com_ushareit_listenit_aes_R, i4, i5, vqVar);
        return com_ushareit_listenit_aeg_A__T__Z__R;
    }

    private aeg() {
    }

    public void mo595a() {
        this.f4210j = null;
        this.f4212l = null;
        this.f4208h = null;
        this.f4216p = null;
        this.f4224x = null;
        this.f4225y = null;
        this.f4204d = null;
        this.f4217q = null;
        this.f4211k = null;
        this.f4209i = null;
        this.f4220t = null;
        this.f4226z = false;
        this.f4199B = null;
        f4197a.offer(this);
    }

    private void m5364b(aef<A, T, Z, R> com_ushareit_listenit_aef_A__T__Z__R, A a, uv uvVar, Context context, tv tvVar, afi<R> com_ushareit_listenit_afi_R, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, aek<? super A, R> com_ushareit_listenit_aek__super_A__R, aej com_ushareit_listenit_aej, vr vrVar, uz<Z> uzVar, Class<R> cls, boolean z, aes<R> com_ushareit_listenit_aes_R, int i4, int i5, vq vqVar) {
        this.f4210j = com_ushareit_listenit_aef_A__T__Z__R;
        this.f4212l = a;
        this.f4203c = uvVar;
        this.f4204d = drawable3;
        this.f4205e = i3;
        this.f4208h = context.getApplicationContext();
        this.f4215o = tvVar;
        this.f4216p = com_ushareit_listenit_afi_R;
        this.f4218r = f;
        this.f4224x = drawable;
        this.f4206f = i;
        this.f4225y = drawable2;
        this.f4207g = i2;
        this.f4217q = com_ushareit_listenit_aek__super_A__R;
        this.f4211k = com_ushareit_listenit_aej;
        this.f4219s = vrVar;
        this.f4209i = uzVar;
        this.f4213m = cls;
        this.f4214n = z;
        this.f4220t = com_ushareit_listenit_aes_R;
        this.f4221u = i4;
        this.f4222v = i5;
        this.f4223w = vqVar;
        this.f4201D = aeh.PENDING;
        if (a != null) {
            m5363a("ModelLoader", com_ushareit_listenit_aef_A__T__Z__R.mo593e(), "try .using(ModelLoader)");
            m5363a("Transcoder", com_ushareit_listenit_aef_A__T__Z__R.mo594f(), "try .as*(Class).transcode(ResourceTranscoder)");
            m5363a("Transformation", uzVar, "try .transform(UnitTransformation.get())");
            if (vqVar.m26729a()) {
                m5363a("SourceEncoder", com_ushareit_listenit_aef_A__T__Z__R.mo563c(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                m5363a("SourceDecoder", com_ushareit_listenit_aef_A__T__Z__R.mo562b(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (vqVar.m26729a() || vqVar.m26730b()) {
                m5363a("CacheDecoder", com_ushareit_listenit_aef_A__T__Z__R.mo561a(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (vqVar.m26730b()) {
                m5363a("Encoder", com_ushareit_listenit_aef_A__T__Z__R.mo564d(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private static void m5363a(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append(" must not be null");
            if (str2 != null) {
                stringBuilder.append(", ");
                stringBuilder.append(str2);
            }
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    public void mo599b() {
        this.f4200C = afq.m5477a();
        if (this.f4212l == null) {
            mo598a(null);
            return;
        }
        this.f4201D = aeh.WAITING_FOR_SIZE;
        if (afu.m5498a(this.f4221u, this.f4222v)) {
            mo596a(this.f4221u, this.f4222v);
        } else {
            this.f4216p.mo581a((aff) this);
        }
        if (!(mo603g() || m5386j() || !m5371o())) {
            this.f4216p.mo577c(m5369m());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            m5362a("finished run method in " + afq.m5476a(this.f4200C));
        }
    }

    void m5379c() {
        this.f4201D = aeh.CANCELLED;
        if (this.f4199B != null) {
            this.f4199B.m26748a();
            this.f4199B = null;
        }
    }

    public void mo600d() {
        afu.m5497a();
        if (this.f4201D != aeh.CLEARED) {
            m5379c();
            if (this.f4198A != null) {
                m5365b(this.f4198A);
            }
            if (m5371o()) {
                this.f4216p.mo575b(m5369m());
            }
            this.f4201D = aeh.CLEARED;
        }
    }

    public void mo601e() {
        mo600d();
        this.f4201D = aeh.PAUSED;
    }

    private void m5365b(wk wkVar) {
        this.f4219s.m26743a(wkVar);
        this.f4198A = null;
    }

    public boolean mo602f() {
        return this.f4201D == aeh.RUNNING || this.f4201D == aeh.WAITING_FOR_SIZE;
    }

    public boolean mo603g() {
        return this.f4201D == aeh.COMPLETE;
    }

    public boolean mo604h() {
        return mo603g();
    }

    public boolean mo605i() {
        return this.f4201D == aeh.CANCELLED || this.f4201D == aeh.CLEARED;
    }

    public boolean m5386j() {
        return this.f4201D == aeh.FAILED;
    }

    private Drawable m5367k() {
        if (this.f4204d == null && this.f4205e > 0) {
            this.f4204d = this.f4208h.getResources().getDrawable(this.f4205e);
        }
        return this.f4204d;
    }

    private void m5366b(Exception exception) {
        if (m5371o()) {
            Drawable k = this.f4212l == null ? m5367k() : null;
            if (k == null) {
                k = m5368l();
            }
            if (k == null) {
                k = m5369m();
            }
            this.f4216p.mo574a(exception, k);
        }
    }

    private Drawable m5368l() {
        if (this.f4225y == null && this.f4207g > 0) {
            this.f4225y = this.f4208h.getResources().getDrawable(this.f4207g);
        }
        return this.f4225y;
    }

    private Drawable m5369m() {
        if (this.f4224x == null && this.f4206f > 0) {
            this.f4224x = this.f4208h.getResources().getDrawable(this.f4206f);
        }
        return this.f4224x;
    }

    public void mo596a(int i, int i2) {
        if (Log.isLoggable("GenericRequest", 2)) {
            m5362a("Got onSizeReady in " + afq.m5476a(this.f4200C));
        }
        if (this.f4201D == aeh.WAITING_FOR_SIZE) {
            this.f4201D = aeh.RUNNING;
            int round = Math.round(this.f4218r * ((float) i));
            int round2 = Math.round(this.f4218r * ((float) i2));
            vc a = this.f4210j.mo593e().mo546a(this.f4212l, round, round2);
            if (a == null) {
                mo598a(new Exception("Failed to load model: '" + this.f4212l + "'"));
                return;
            }
            adb f = this.f4210j.mo594f();
            if (Log.isLoggable("GenericRequest", 2)) {
                m5362a("finished setup for calling load in " + afq.m5476a(this.f4200C));
            }
            this.f4226z = true;
            this.f4199B = this.f4219s.m26740a(this.f4203c, round, round2, a, this.f4210j, this.f4209i, f, this.f4215o, this.f4214n, this.f4223w, this);
            this.f4226z = this.f4198A != null;
            if (Log.isLoggable("GenericRequest", 2)) {
                m5362a("finished onSizeReady in " + afq.m5476a(this.f4200C));
            }
        }
    }

    private boolean m5370n() {
        return this.f4211k == null || this.f4211k.mo606a(this);
    }

    private boolean m5371o() {
        return this.f4211k == null || this.f4211k.mo607b(this);
    }

    private boolean m5372p() {
        return this.f4211k == null || !this.f4211k.mo609c();
    }

    private void m5373q() {
        if (this.f4211k != null) {
            this.f4211k.mo608c(this);
        }
    }

    public void mo597a(wk<?> wkVar) {
        if (wkVar == null) {
            mo598a(new Exception("Expected to receive a Resource<R> with an object of " + this.f4213m + " inside, but instead got null."));
            return;
        }
        Object b = wkVar.mo553b();
        if (b == null || !this.f4213m.isAssignableFrom(b.getClass())) {
            m5365b((wk) wkVar);
            mo598a(new Exception("Expected to receive an object of " + this.f4213m + " but instead got " + (b != null ? b.getClass() : "") + "{" + b + "}" + " inside Resource{" + wkVar + "}." + (b != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
        } else if (m5370n()) {
            m5361a((wk) wkVar, b);
        } else {
            m5365b((wk) wkVar);
            this.f4201D = aeh.COMPLETE;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5361a(com.ushareit.listenit.wk<?> r7, R r8) {
        /*
        r6 = this;
        r5 = r6.m5372p();
        r0 = com.ushareit.listenit.aeh.COMPLETE;
        r6.f4201D = r0;
        r6.f4198A = r7;
        r0 = r6.f4217q;
        if (r0 == 0) goto L_0x001d;
    L_0x000e:
        r0 = r6.f4217q;
        r2 = r6.f4212l;
        r3 = r6.f4216p;
        r4 = r6.f4226z;
        r1 = r8;
        r0 = r0.m5392a(r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x002a;
    L_0x001d:
        r0 = r6.f4220t;
        r1 = r6.f4226z;
        r0 = r0.mo610a(r1, r5);
        r1 = r6.f4216p;
        r1.mo582a(r8, r0);
    L_0x002a:
        r6.m5373q();
        r0 = "GenericRequest";
        r1 = 2;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0070;
    L_0x0036:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Resource ready in ";
        r0 = r0.append(r1);
        r2 = r6.f4200C;
        r2 = com.ushareit.listenit.afq.m5476a(r2);
        r0 = r0.append(r2);
        r1 = " size: ";
        r0 = r0.append(r1);
        r1 = r7.mo554c();
        r2 = (double) r1;
        r4 = 4517110426252607488; // 0x3eb0000000000000 float:0.0 double:9.5367431640625E-7;
        r2 = r2 * r4;
        r0 = r0.append(r2);
        r1 = " fromCache: ";
        r0 = r0.append(r1);
        r1 = r6.f4226z;
        r0 = r0.append(r1);
        r0 = r0.toString();
        r6.m5362a(r0);
    L_0x0070:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.aeg.a(com.ushareit.listenit.wk, java.lang.Object):void");
    }

    public void mo598a(Exception exception) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exception);
        }
        this.f4201D = aeh.FAILED;
        if (this.f4217q == null || !this.f4217q.m5391a(exception, this.f4212l, this.f4216p, m5372p())) {
            m5366b(exception);
        }
    }

    private void m5362a(String str) {
        Log.v("GenericRequest", str + " this: " + this.f4202b);
    }
}
