package com.ushareit.listenit;

import com.mopub.volley.Cache.Entry;
import com.mopub.volley.VolleyLog;
import com.mopub.volley.toolbox.DiskBasedCache;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class epb {
    public String etag;
    public String key;
    public Map<String, String> responseHeaders;
    public long serverDate;
    public long size;
    public long softTtl;
    public long ttl;

    private epb() {
    }

    public epb(String str, Entry entry) {
        this.key = str;
        this.size = (long) entry.data.length;
        this.etag = entry.etag;
        this.serverDate = entry.serverDate;
        this.ttl = entry.ttl;
        this.softTtl = entry.softTtl;
        this.responseHeaders = entry.responseHeaders;
    }

    public static epb readHeader(InputStream inputStream) {
        epb com_ushareit_listenit_epb = new epb();
        if (DiskBasedCache.m3370a(inputStream) != 538183203) {
            throw new IOException();
        }
        com_ushareit_listenit_epb.key = DiskBasedCache.m3381c(inputStream);
        com_ushareit_listenit_epb.etag = DiskBasedCache.m3381c(inputStream);
        if (com_ushareit_listenit_epb.etag.equals("")) {
            com_ushareit_listenit_epb.etag = null;
        }
        com_ushareit_listenit_epb.serverDate = DiskBasedCache.m3379b(inputStream);
        com_ushareit_listenit_epb.ttl = DiskBasedCache.m3379b(inputStream);
        com_ushareit_listenit_epb.softTtl = DiskBasedCache.m3379b(inputStream);
        com_ushareit_listenit_epb.responseHeaders = DiskBasedCache.m3382d(inputStream);
        return com_ushareit_listenit_epb;
    }

    public Entry toCacheEntry(byte[] bArr) {
        Entry entry = new Entry();
        entry.data = bArr;
        entry.etag = this.etag;
        entry.serverDate = this.serverDate;
        entry.ttl = this.ttl;
        entry.softTtl = this.softTtl;
        entry.responseHeaders = this.responseHeaders;
        return entry;
    }

    public boolean writeHeader(OutputStream outputStream) {
        try {
            DiskBasedCache.m3373a(outputStream, 538183203);
            DiskBasedCache.m3375a(outputStream, this.key);
            DiskBasedCache.m3375a(outputStream, this.etag == null ? "" : this.etag);
            DiskBasedCache.m3374a(outputStream, this.serverDate);
            DiskBasedCache.m3374a(outputStream, this.ttl);
            DiskBasedCache.m3374a(outputStream, this.softTtl);
            DiskBasedCache.m3377a(this.responseHeaders, outputStream);
            outputStream.flush();
            return true;
        } catch (IOException e) {
            VolleyLog.m3359d("%s", e.toString());
            return false;
        }
    }
}
