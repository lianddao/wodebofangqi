package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import java.io.OutputStream;

public class aao implements uy<Bitmap> {
    private CompressFormat f3996a;
    private int f3997b;

    public aao() {
        this(null, 90);
    }

    public aao(CompressFormat compressFormat, int i) {
        this.f3996a = compressFormat;
        this.f3997b = i;
    }

    public boolean m5005a(wk<Bitmap> wkVar, OutputStream outputStream) {
        Bitmap bitmap = (Bitmap) wkVar.mo553b();
        long a = afq.m5477a();
        CompressFormat a2 = m5003a(bitmap);
        bitmap.compress(a2, this.f3997b, outputStream);
        if (Log.isLoggable("BitmapEncoder", 2)) {
            Log.v("BitmapEncoder", "Compressed with type: " + a2 + " of size " + afu.m5492a(bitmap) + " in " + afq.m5476a(a));
        }
        return true;
    }

    public String mo551a() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    private CompressFormat m5003a(Bitmap bitmap) {
        if (this.f3996a != null) {
            return this.f3996a;
        }
        if (bitmap.hasAlpha()) {
            return CompressFormat.PNG;
        }
        return CompressFormat.JPEG;
    }
}
