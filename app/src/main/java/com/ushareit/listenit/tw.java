package com.ushareit.listenit;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class tw implements adn {
    private final Context f16840a;
    private final adm f16841b;
    private final adt f16842c;
    private final adu f16843d;
    private final tt f16844e;
    private final ub f16845f;
    private ty f16846g;

    public tw(Context context, adm com_ushareit_listenit_adm, adt com_ushareit_listenit_adt) {
        this(context, com_ushareit_listenit_adm, com_ushareit_listenit_adt, new adu(), new adi());
    }

    tw(Context context, adm com_ushareit_listenit_adm, adt com_ushareit_listenit_adt, adu com_ushareit_listenit_adu, adi com_ushareit_listenit_adi) {
        this.f16840a = context.getApplicationContext();
        this.f16841b = com_ushareit_listenit_adm;
        this.f16842c = com_ushareit_listenit_adt;
        this.f16843d = com_ushareit_listenit_adu;
        this.f16844e = tt.m26449a(context);
        this.f16845f = new ub(this);
        adn a = com_ushareit_listenit_adi.m5274a(context, new uc(com_ushareit_listenit_adu));
        if (afu.m5501c()) {
            new Handler(Looper.getMainLooper()).post(new tx(this, com_ushareit_listenit_adm));
        } else {
            com_ushareit_listenit_adm.mo590a(this);
        }
        com_ushareit_listenit_adm.mo590a(a);
    }

    public void m26483a(int i) {
        this.f16844e.m26459a(i);
    }

    public void m26482a() {
        this.f16844e.m26468h();
    }

    public void m26484b() {
        afu.m5497a();
        this.f16843d.m5304a();
    }

    public void m26485c() {
        afu.m5497a();
        this.f16843d.m5306b();
    }

    public void mo578d() {
        m26485c();
    }

    public void mo579e() {
        m26484b();
    }

    public void mo580f() {
        this.f16843d.m5308c();
    }

    public <A, T> tz<A, T> m26481a(ze<A, T> zeVar, Class<T> cls) {
        return new tz(this, zeVar, cls);
    }

    public <T> tp<T> m26480a(T t) {
        return (tp) m26472a(m26476c((Object) t)).m26422a((Object) t);
    }

    private <T> tp<T> m26472a(Class<T> cls) {
        ze a = tt.m26450a((Class) cls, this.f16840a);
        ze b = tt.m26454b((Class) cls, this.f16840a);
        if (cls != null && a == null && b == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for" + " which there is a registered ModelLoader, if you are using a custom model, you must first call" + " Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return (tp) this.f16845f.m26495a(new tp(cls, a, b, this.f16840a, this.f16844e, this.f16843d, this.f16841b, this.f16845f));
    }

    private static <T> Class<T> m26476c(T t) {
        return t != null ? t.getClass() : null;
    }
}
