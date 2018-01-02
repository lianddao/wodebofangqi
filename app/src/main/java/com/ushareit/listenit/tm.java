package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;
import java.io.InputStream;

public class tm<ModelType, TranscodeType> extends tq<ModelType, yv, Bitmap, TranscodeType> {
    private final ws f16794g;
    private aas f16795h = aas.f4001a;
    private ut f16796i;
    private ux<InputStream, Bitmap> f16797j;
    private ux<ParcelFileDescriptor, Bitmap> f16798k;

    public /* synthetic */ tq mo3072b(int i) {
        return m26379a(i);
    }

    public /* synthetic */ tq mo3073b(int i, int i2) {
        return m26380a(i, i2);
    }

    public /* synthetic */ tq mo3074b(tv tvVar) {
        return m26382a(tvVar);
    }

    public /* synthetic */ tq mo3075b(uu uuVar) {
        return m26383a(uuVar);
    }

    public /* synthetic */ tq mo3076b(uv uvVar) {
        return m26384a(uvVar);
    }

    public /* synthetic */ tq mo3077b(ux uxVar) {
        return m26385a(uxVar);
    }

    public /* synthetic */ tq mo3078b(vq vqVar) {
        return m26386a(vqVar);
    }

    public /* synthetic */ tq mo3079b(Object obj) {
        return m26387a(obj);
    }

    public /* synthetic */ tq mo3080b(boolean z) {
        return m26388a(z);
    }

    public /* synthetic */ tq mo3081b(uz[] uzVarArr) {
        return m26390a(uzVarArr);
    }

    public /* synthetic */ tq mo3082c(Drawable drawable) {
        return m26392b(drawable);
    }

    public /* synthetic */ Object clone() {
        return m26405d();
    }

    public /* synthetic */ tq mo3084d(Drawable drawable) {
        return m26381a(drawable);
    }

    public /* synthetic */ tq mo3087g() {
        return m26405d();
    }

    public /* synthetic */ tq mo3088h() {
        return m26403c();
    }

    tm(aef<ModelType, yv, Bitmap, TranscodeType> com_ushareit_listenit_aef_ModelType__com_ushareit_listenit_yv__android_graphics_Bitmap__TranscodeType, Class<TranscodeType> cls, tq<ModelType, ?, ?, ?> tqVar) {
        super(com_ushareit_listenit_aef_ModelType__com_ushareit_listenit_yv__android_graphics_Bitmap__TranscodeType, cls, tqVar);
        this.f16794g = tqVar.f16770c.m26458a();
        this.f16796i = tqVar.f16770c.m26467g();
        this.f16797j = new abj(this.f16794g, this.f16796i);
        this.f16798k = new aax(this.f16794g, this.f16796i);
    }

    public tm<ModelType, TranscodeType> m26385a(ux<yv, Bitmap> uxVar) {
        super.mo3077b((ux) uxVar);
        return this;
    }

    public tm<ModelType, TranscodeType> m26382a(tv tvVar) {
        super.mo3074b(tvVar);
        return this;
    }

    public tm<ModelType, TranscodeType> m26389a(aaq... com_ushareit_listenit_aaqArr) {
        super.mo3081b((uz[]) com_ushareit_listenit_aaqArr);
        return this;
    }

    public tm<ModelType, TranscodeType> mo3071a() {
        return m26389a(this.c.m26463c());
    }

    public tm<ModelType, TranscodeType> m26391b() {
        return m26389a(this.c.m26464d());
    }

    public tm<ModelType, TranscodeType> m26390a(uz<Bitmap>... uzVarArr) {
        super.mo3081b((uz[]) uzVarArr);
        return this;
    }

    public tm<ModelType, TranscodeType> m26403c() {
        super.mo3088h();
        return this;
    }

    public tm<ModelType, TranscodeType> m26379a(int i) {
        super.mo3072b(i);
        return this;
    }

    public tm<ModelType, TranscodeType> m26381a(Drawable drawable) {
        super.mo3084d(drawable);
        return this;
    }

    public tm<ModelType, TranscodeType> m26392b(Drawable drawable) {
        super.mo3082c(drawable);
        return this;
    }

    public tm<ModelType, TranscodeType> m26388a(boolean z) {
        super.mo3080b(z);
        return this;
    }

    public tm<ModelType, TranscodeType> m26386a(vq vqVar) {
        super.mo3078b(vqVar);
        return this;
    }

    public tm<ModelType, TranscodeType> m26380a(int i, int i2) {
        super.mo3073b(i, i2);
        return this;
    }

    public tm<ModelType, TranscodeType> m26383a(uu<yv> uuVar) {
        super.mo3075b((uu) uuVar);
        return this;
    }

    public tm<ModelType, TranscodeType> m26384a(uv uvVar) {
        super.mo3076b(uvVar);
        return this;
    }

    public tm<ModelType, TranscodeType> m26387a(ModelType modelType) {
        super.mo3079b((Object) modelType);
        return this;
    }

    public tm<ModelType, TranscodeType> m26405d() {
        return (tm) super.mo3087g();
    }

    public afi<TranscodeType> mo3070a(ImageView imageView) {
        return super.mo3070a(imageView);
    }

    void mo3085e() {
        m26391b();
    }

    void mo3086f() {
        mo3071a();
    }
}
