package com.ushareit.listenit;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

class eze extends ezq {
    final /* synthetic */ ezc f12233a;

    eze(ezc com_ushareit_listenit_ezc) {
        this.f12233a = com_ushareit_listenit_ezc;
        this.b = new HashMap();
        this.b.put("Content-Type", com_ushareit_listenit_ezc.f12227c.getContentType());
        CharSequence headerField = com_ushareit_listenit_ezc.f12227c.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
            this.b.put("Content-Range", headerField);
        }
    }

    public long mo2342a() {
        return (long) this.f12233a.f12227c.getContentLength();
    }

    public InputStream mo2343b() {
        return this.f12233a.f12227c.getInputStream();
    }

    public int mo2344c() {
        try {
            return this.f12233a.f12227c.getResponseCode();
        } catch (IOException e) {
            return -1;
        }
    }
}
