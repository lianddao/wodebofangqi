package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
import com.facebook.internal.bk;
import com.facebook.internal.cb;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajc implements aiz {
    private final OutputStream f4458a;
    private final bk f4459b;
    private boolean f4460c = true;
    private boolean f4461d = false;

    public ajc(OutputStream outputStream, bk bkVar, boolean z) {
        this.f4458a = outputStream;
        this.f4459b = bkVar;
        this.f4461d = z;
    }

    public void m5742a(String str, Object obj, GraphRequest graphRequest) {
        if (this.f4458a instanceof ajs) {
            ((ajs) this.f4458a).mo639a(graphRequest);
        }
        if (GraphRequest.m753e(obj)) {
            mo638a(str, GraphRequest.m755f(obj));
        } else if (obj instanceof Bitmap) {
            m5739a(str, (Bitmap) obj);
        } else if (obj instanceof byte[]) {
            m5746a(str, (byte[]) obj);
        } else if (obj instanceof Uri) {
            m5740a(str, (Uri) obj, null);
        } else if (obj instanceof ParcelFileDescriptor) {
            m5741a(str, (ParcelFileDescriptor) obj, null);
        } else if (obj instanceof ParcelableResourceWithMimeType) {
            ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
            Parcelable b = parcelableResourceWithMimeType.m723b();
            String a = parcelableResourceWithMimeType.m722a();
            if (b instanceof ParcelFileDescriptor) {
                m5741a(str, (ParcelFileDescriptor) b, a);
            } else if (b instanceof Uri) {
                m5740a(str, (Uri) b, a);
            } else {
                throw m5737b();
            }
        } else {
            throw m5737b();
        }
    }

    private RuntimeException m5737b() {
        return new IllegalArgumentException("value is not a supported type.");
    }

    public void m5745a(String str, JSONArray jSONArray, Collection<GraphRequest> collection) {
        if (this.f4458a instanceof ajs) {
            ajs com_ushareit_listenit_ajs = (ajs) this.f4458a;
            m5744a(str, null, null);
            m5747a("[", new Object[0]);
            int i = 0;
            for (GraphRequest graphRequest : collection) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                com_ushareit_listenit_ajs.mo639a(graphRequest);
                if (i > 0) {
                    m5747a(",%s", jSONObject.toString());
                } else {
                    m5747a("%s", jSONObject.toString());
                }
                i++;
            }
            m5747a("]", new Object[0]);
            if (this.f4459b != null) {
                this.f4459b.m1471a("    " + str, jSONArray.toString());
                return;
            }
            return;
        }
        mo638a(str, jSONArray.toString());
    }

    public void mo638a(String str, String str2) {
        m5744a(str, null, null);
        m5748b("%s", str2);
        m5738a();
        if (this.f4459b != null) {
            this.f4459b.m1471a("    " + str, (Object) str2);
        }
    }

    public void m5739a(String str, Bitmap bitmap) {
        m5744a(str, str, "image/png");
        bitmap.compress(CompressFormat.PNG, 100, this.f4458a);
        m5748b("", new Object[0]);
        m5738a();
        if (this.f4459b != null) {
            this.f4459b.m1471a("    " + str, (Object) "<Image>");
        }
    }

    public void m5746a(String str, byte[] bArr) {
        m5744a(str, str, "content/unknown");
        this.f4458a.write(bArr);
        m5748b("", new Object[0]);
        m5738a();
        if (this.f4459b != null) {
            this.f4459b.m1471a("    " + str, String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(bArr.length)}));
        }
    }

    public void m5740a(String str, Uri uri, String str2) {
        int i;
        if (str2 == null) {
            str2 = "content/unknown";
        }
        m5744a(str, str, str2);
        InputStream openInputStream = ail.m5715f().getContentResolver().openInputStream(uri);
        if (this.f4458a instanceof ajp) {
            ((ajp) this.f4458a).m5801a(cb.m1613e(uri));
            i = 0;
        } else {
            i = cb.m1552a(openInputStream, this.f4458a) + 0;
        }
        m5748b("", new Object[0]);
        m5738a();
        if (this.f4459b != null) {
            this.f4459b.m1471a("    " + str, String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
        }
    }

    public void m5741a(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
        int i;
        if (str2 == null) {
            str2 = "content/unknown";
        }
        m5744a(str, str, str2);
        if (this.f4458a instanceof ajp) {
            ((ajp) this.f4458a).m5801a(parcelFileDescriptor.getStatSize());
            i = 0;
        } else {
            i = cb.m1552a(new AutoCloseInputStream(parcelFileDescriptor), this.f4458a) + 0;
        }
        m5748b("", new Object[0]);
        m5738a();
        if (this.f4459b != null) {
            this.f4459b.m1471a("    " + str, String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
        }
    }

    public void m5738a() {
        if (this.f4461d) {
            this.f4458a.write("&".getBytes());
            return;
        }
        m5748b("--%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
    }

    public void m5744a(String str, String str2, String str3) {
        if (this.f4461d) {
            this.f4458a.write(String.format("%s=", new Object[]{str}).getBytes());
            return;
        }
        m5747a("Content-Disposition: form-data; name=\"%s\"", str);
        if (str2 != null) {
            m5747a("; filename=\"%s\"", str2);
        }
        m5748b("", new Object[0]);
        if (str3 != null) {
            m5748b("%s: %s", "Content-Type", str3);
        }
        m5748b("", new Object[0]);
    }

    public void m5747a(String str, Object... objArr) {
        if (this.f4461d) {
            this.f4458a.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
            return;
        }
        if (this.f4460c) {
            this.f4458a.write("--".getBytes());
            this.f4458a.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
            this.f4458a.write("\r\n".getBytes());
            this.f4460c = false;
        }
        this.f4458a.write(String.format(str, objArr).getBytes());
    }

    public void m5748b(String str, Object... objArr) {
        m5747a(str, objArr);
        if (!this.f4461d) {
            m5747a("\r\n", new Object[0]);
        }
    }
}
