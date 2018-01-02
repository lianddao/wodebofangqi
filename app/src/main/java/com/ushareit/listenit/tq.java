package com.ushareit.listenit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.mopub.volley.DefaultRetryPolicy;

public class tq<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private boolean f16765A;
    private Drawable f16766B;
    private int f16767C;
    protected final Class<ModelType> f16768a;
    protected final Context f16769b;
    protected final tt f16770c;
    protected final Class<TranscodeType> f16771d;
    protected final adu f16772e;
    protected final adm f16773f;
    private aea<ModelType, DataType, ResourceType, TranscodeType> f16774g;
    private ModelType f16775h;
    private uv f16776i;
    private boolean f16777j;
    private int f16778k;
    private int f16779l;
    private aek<? super ModelType, TranscodeType> f16780m;
    private Float f16781n;
    private tq<?, ?, ?, TranscodeType> f16782o;
    private Float f16783p;
    private Drawable f16784q;
    private Drawable f16785r;
    private tv f16786s;
    private boolean f16787t;
    private aes<TranscodeType> f16788u;
    private int f16789v;
    private int f16790w;
    private vq f16791x;
    private uz<ResourceType> f16792y;
    private boolean f16793z;

    public /* synthetic */ Object clone() {
        return mo3087g();
    }

    tq(aef<ModelType, DataType, ResourceType, TranscodeType> com_ushareit_listenit_aef_ModelType__DataType__ResourceType__TranscodeType, Class<TranscodeType> cls, tq<ModelType, ?, ?, ?> tqVar) {
        this(tqVar.f16769b, tqVar.f16768a, com_ushareit_listenit_aef_ModelType__DataType__ResourceType__TranscodeType, cls, tqVar.f16770c, tqVar.f16772e, tqVar.f16773f);
        this.f16775h = tqVar.f16775h;
        this.f16777j = tqVar.f16777j;
        this.f16776i = tqVar.f16776i;
        this.f16791x = tqVar.f16791x;
        this.f16787t = tqVar.f16787t;
    }

    tq(Context context, Class<ModelType> cls, aef<ModelType, DataType, ResourceType, TranscodeType> com_ushareit_listenit_aef_ModelType__DataType__ResourceType__TranscodeType, Class<TranscodeType> cls2, tt ttVar, adu com_ushareit_listenit_adu, adm com_ushareit_listenit_adm) {
        aea com_ushareit_listenit_aea = null;
        this.f16776i = afm.m5465a();
        this.f16783p = Float.valueOf(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f16786s = null;
        this.f16787t = true;
        this.f16788u = aet.m5421a();
        this.f16789v = -1;
        this.f16790w = -1;
        this.f16791x = vq.RESULT;
        this.f16792y = aam.m4999b();
        this.f16769b = context;
        this.f16768a = cls;
        this.f16771d = cls2;
        this.f16770c = ttVar;
        this.f16772e = com_ushareit_listenit_adu;
        this.f16773f = com_ushareit_listenit_adm;
        if (com_ushareit_listenit_aef_ModelType__DataType__ResourceType__TranscodeType != null) {
            com_ushareit_listenit_aea = new aea(com_ushareit_listenit_aef_ModelType__DataType__ResourceType__TranscodeType);
        }
        this.f16774g = com_ushareit_listenit_aea;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        } else if (cls != null && com_ushareit_listenit_aef_ModelType__DataType__ResourceType__TranscodeType == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3077b(ux<DataType, ResourceType> uxVar) {
        if (this.f16774g != null) {
            this.f16774g.m5329a((ux) uxVar);
        }
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3075b(uu<DataType> uuVar) {
        if (this.f16774g != null) {
            this.f16774g.m5328a((uu) uuVar);
        }
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3078b(vq vqVar) {
        this.f16791x = vqVar;
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3074b(tv tvVar) {
        this.f16786s = tvVar;
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3081b(uz<ResourceType>... uzVarArr) {
        this.f16793z = true;
        if (uzVarArr.length == 1) {
            this.f16792y = uzVarArr[0];
        } else {
            this.f16792y = new uw(uzVarArr);
        }
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3088h() {
        return m26360a(aet.m5421a());
    }

    tq<ModelType, DataType, ResourceType, TranscodeType> m26360a(aes<TranscodeType> com_ushareit_listenit_aes_TranscodeType) {
        if (com_ushareit_listenit_aes_TranscodeType == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.f16788u = com_ushareit_listenit_aes_TranscodeType;
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3072b(int i) {
        this.f16778k = i;
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3084d(Drawable drawable) {
        this.f16784q = drawable;
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3082c(Drawable drawable) {
        this.f16785r = drawable;
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3080b(boolean z) {
        this.f16787t = !z;
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3073b(int i, int i2) {
        if (afu.m5498a(i, i2)) {
            this.f16790w = i;
            this.f16789v = i2;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3076b(uv uvVar) {
        if (uvVar == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.f16776i = uvVar;
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3079b(ModelType modelType) {
        this.f16775h = modelType;
        this.f16777j = true;
        return this;
    }

    public tq<ModelType, DataType, ResourceType, TranscodeType> mo3087g() {
        try {
            tq<ModelType, DataType, ResourceType, TranscodeType> tqVar = (tq) super.clone();
            tqVar.f16774g = this.f16774g != null ? this.f16774g.m5335g() : null;
            return tqVar;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public <Y extends afi<TranscodeType>> Y m26359a(Y y) {
        afu.m5497a();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        } else if (this.f16777j) {
            aei c = y.mo576c();
            if (c != null) {
                c.mo600d();
                this.f16772e.m5307b(c);
                c.mo595a();
            }
            c = m26357b((afi) y);
            y.mo573a(c);
            this.f16773f.mo590a(y);
            this.f16772e.m5305a(c);
            return y;
        } else {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
    }

    public afi<TranscodeType> mo3070a(ImageView imageView) {
        afu.m5497a();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!(this.f16793z || imageView.getScaleType() == null)) {
            switch (tr.f16806a[imageView.getScaleType().ordinal()]) {
                case 1:
                    mo3086f();
                    break;
                case 2:
                case 3:
                case 4:
                    mo3085e();
                    break;
            }
        }
        return m26359a(this.f16770c.m26457a(imageView, this.f16771d));
    }

    void mo3086f() {
    }

    void mo3085e() {
    }

    private tv mo3071a() {
        if (this.f16786s == tv.LOW) {
            return tv.NORMAL;
        }
        if (this.f16786s == tv.NORMAL) {
            return tv.HIGH;
        }
        return tv.IMMEDIATE;
    }

    private aei m26357b(afi<TranscodeType> com_ushareit_listenit_afi_TranscodeType) {
        if (this.f16786s == null) {
            this.f16786s = tv.NORMAL;
        }
        return m26355a(com_ushareit_listenit_afi_TranscodeType, null);
    }

    private aei m26355a(afi<TranscodeType> com_ushareit_listenit_afi_TranscodeType, aem com_ushareit_listenit_aem) {
        aei com_ushareit_listenit_aem2;
        if (this.f16782o != null) {
            if (this.f16765A) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (this.f16782o.f16788u.equals(aet.m5421a())) {
                this.f16782o.f16788u = this.f16788u;
            }
            if (this.f16782o.f16786s == null) {
                this.f16782o.f16786s = mo3071a();
            }
            if (afu.m5498a(this.f16790w, this.f16789v) && !afu.m5498a(this.f16782o.f16790w, this.f16782o.f16789v)) {
                this.f16782o.mo3073b(this.f16790w, this.f16789v);
            }
            com_ushareit_listenit_aem2 = new aem(com_ushareit_listenit_aem);
            aei a = m26354a(com_ushareit_listenit_afi_TranscodeType, this.f16783p.floatValue(), this.f16786s, com_ushareit_listenit_aem2);
            this.f16765A = true;
            aei a2 = this.f16782o.m26355a(com_ushareit_listenit_afi_TranscodeType, com_ushareit_listenit_aem2);
            this.f16765A = false;
            com_ushareit_listenit_aem2.m5397a(a, a2);
            return com_ushareit_listenit_aem2;
        } else if (this.f16781n == null) {
            return m26354a(com_ushareit_listenit_afi_TranscodeType, this.f16783p.floatValue(), this.f16786s, com_ushareit_listenit_aem);
        } else {
            com_ushareit_listenit_aem2 = new aem(com_ushareit_listenit_aem);
            com_ushareit_listenit_aem2.m5397a(m26354a(com_ushareit_listenit_afi_TranscodeType, this.f16783p.floatValue(), this.f16786s, com_ushareit_listenit_aem2), m26354a(com_ushareit_listenit_afi_TranscodeType, this.f16781n.floatValue(), mo3071a(), com_ushareit_listenit_aem2));
            return com_ushareit_listenit_aem2;
        }
    }

    private aei m26354a(afi<TranscodeType> com_ushareit_listenit_afi_TranscodeType, float f, tv tvVar, aej com_ushareit_listenit_aej) {
        return aeg.m5360a(this.f16774g, this.f16775h, this.f16776i, this.f16769b, tvVar, com_ushareit_listenit_afi_TranscodeType, f, this.f16784q, this.f16778k, this.f16785r, this.f16779l, this.f16766B, this.f16767C, this.f16780m, com_ushareit_listenit_aej, this.f16770c.m26462b(), this.f16792y, this.f16771d, this.f16787t, this.f16788u, this.f16790w, this.f16789v, this.f16791x);
    }
}
