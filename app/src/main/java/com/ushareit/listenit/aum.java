package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import com.facebook.ads.internal.view.C0049e;
import java.lang.ref.WeakReference;

public class aum extends AsyncTask<String, Void, Bitmap[]> {
    private static final String f5512a = aum.class.getSimpleName();
    private final WeakReference<Context> f5513b;
    private final WeakReference<ImageView> f5514c;
    private final WeakReference<C0049e> f5515d;
    private aun f5516e;

    public aum(ImageView imageView) {
        this.f5513b = new WeakReference(imageView.getContext());
        this.f5515d = null;
        this.f5514c = new WeakReference(imageView);
    }

    public aum(C0049e c0049e) {
        this.f5513b = new WeakReference(c0049e.getContext());
        this.f5515d = new WeakReference(c0049e);
        this.f5514c = null;
    }

    public aum m7209a(aun com_ushareit_listenit_aun) {
        this.f5516e = com_ushareit_listenit_aun;
        return this;
    }

    protected void m7210a(Bitmap[] bitmapArr) {
        if (this.f5514c != null) {
            ImageView imageView = (ImageView) this.f5514c.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmapArr[0]);
            }
        }
        if (this.f5515d != null) {
            C0049e c0049e = (C0049e) this.f5515d.get();
            if (c0049e != null) {
                c0049e.m1082a(bitmapArr[0], bitmapArr[1]);
            }
        }
        if (this.f5516e != null) {
            this.f5516e.mo704a();
        }
    }

    public void m7211a(String... strArr) {
        executeOnExecutor(THREAD_POOL_EXECUTOR, strArr);
    }

    protected Bitmap[] m7212b(String... strArr) {
        Bitmap a;
        Throwable th;
        String str = strArr[0];
        Context context = (Context) this.f5513b.get();
        if (context == null) {
            return new Bitmap[]{null, null};
        }
        Bitmap bitmap;
        Bitmap bitmap2;
        try {
            a = ani.m6378a(context).m6382a(str);
            try {
                if (this.f5515d == null || this.f5515d.get() == null || a == null) {
                    bitmap = null;
                } else {
                    try {
                        atc com_ushareit_listenit_atc = new atc(a);
                        com_ushareit_listenit_atc.m7117a(Math.round(((float) a.getWidth()) / 40.0f));
                        bitmap = com_ushareit_listenit_atc.m7116a();
                    } catch (Throwable th2) {
                        th = th2;
                        bitmap = a;
                        Log.e(f5512a, "Error downloading image: " + str, th);
                        att.m7141a(atq.m7138a(th, null));
                        bitmap2 = a;
                        return new Bitmap[]{bitmap2, bitmap};
                    }
                }
                bitmap2 = a;
            } catch (Throwable th22) {
                th = th22;
                bitmap = null;
                Log.e(f5512a, "Error downloading image: " + str, th);
                att.m7141a(atq.m7138a(th, null));
                bitmap2 = a;
                return new Bitmap[]{bitmap2, bitmap};
            }
        } catch (Throwable th222) {
            th = th222;
            a = null;
            bitmap = null;
            Log.e(f5512a, "Error downloading image: " + str, th);
            att.m7141a(atq.m7138a(th, null));
            bitmap2 = a;
            return new Bitmap[]{bitmap2, bitmap};
        }
        return new Bitmap[]{bitmap2, bitmap};
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m7212b((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m7210a((Bitmap[]) obj);
    }
}
