package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class acl implements ux<InputStream, abx> {
    private static final acn f4115a = new acn();
    private static final acm f4116b = new acm();
    private final Context f4117c;
    private final acn f4118d;
    private final ws f4119e;
    private final acm f4120f;
    private final abw f4121g;

    public acl(Context context, ws wsVar) {
        this(context, wsVar, f4115a, f4116b);
    }

    acl(Context context, ws wsVar, acn com_ushareit_listenit_acn, acm com_ushareit_listenit_acm) {
        this.f4117c = context;
        this.f4119e = wsVar;
        this.f4120f = com_ushareit_listenit_acm;
        this.f4121g = new abw(wsVar);
        this.f4118d = com_ushareit_listenit_acn;
    }

    public aca m5211a(InputStream inputStream, int i, int i2) {
        byte[] a = m5210a(inputStream);
        up a2 = this.f4118d.m5216a(a);
        ul a3 = this.f4120f.m5214a(this.f4121g);
        try {
            aca a4 = m5209a(a, i, i2, a2, a3);
            return a4;
        } finally {
            this.f4118d.m5217a(a2);
            this.f4120f.m5215a(a3);
        }
    }

    private aca m5209a(byte[] bArr, int i, int i2, up upVar, ul ulVar) {
        uo b = upVar.m26582b();
        if (b.m26564a() <= 0 || b.m26565b() != 0) {
            return null;
        }
        Bitmap a = m5208a(ulVar, b, bArr);
        if (a == null) {
            return null;
        }
        return new aca(new abx(this.f4117c, this.f4121g, this.f4119e, aam.m4999b(), i, i2, b, bArr, a));
    }

    private Bitmap m5208a(ul ulVar, uo uoVar, byte[] bArr) {
        ulVar.m26557a(uoVar, bArr);
        ulVar.m26556a();
        return ulVar.m26562f();
    }

    public String mo566a() {
        return "";
    }

    private static byte[] m5210a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (Throwable e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
