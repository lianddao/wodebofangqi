package com.ushareit.listenit;

import android.net.Uri;
import android.os.Bundle;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.List;

public final class ce {
    private final CharSequence f8159a;
    private final long f8160b;
    private final CharSequence f8161c;
    private String f8162d;
    private Uri f8163e;

    public CharSequence m10945a() {
        return this.f8159a;
    }

    public long m10946b() {
        return this.f8160b;
    }

    public CharSequence m10947c() {
        return this.f8161c;
    }

    public String m10948d() {
        return this.f8162d;
    }

    public Uri m10949e() {
        return this.f8163e;
    }

    private Bundle m10944f() {
        Bundle bundle = new Bundle();
        if (this.f8159a != null) {
            bundle.putCharSequence("text", this.f8159a);
        }
        bundle.putLong("time", this.f8160b);
        if (this.f8161c != null) {
            bundle.putCharSequence("sender", this.f8161c);
        }
        if (this.f8162d != null) {
            bundle.putString(VastExtensionXmlManager.TYPE, this.f8162d);
        }
        if (this.f8163e != null) {
            bundle.putParcelable("uri", this.f8163e);
        }
        return bundle;
    }

    static Bundle[] m10943a(List<ce> list) {
        Bundle[] bundleArr = new Bundle[list.size()];
        int size = list.size();
        for (int i = 0; i < size; i++) {
            bundleArr[i] = ((ce) list.get(i)).m10944f();
        }
        return bundleArr;
    }
}
