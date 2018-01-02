package com.ushareit.listenit;

import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;

public class gyl {
    private MediaMetadataRetriever f14921a;
    private gym f14922b;

    private boolean m23156c() {
        return VERSION.SDK_INT >= 10;
    }

    public gyl() {
        if (m23156c()) {
            this.f14921a = new MediaMetadataRetriever();
        } else {
            this.f14922b = new gym();
        }
    }

    public boolean m23160a(String str) {
        try {
            if (m23156c()) {
                this.f14921a.setDataSource(str);
            } else {
                this.f14922b.m23164a(str);
            }
            return true;
        } catch (Exception e) {
            exw.m18457e("MediaMetadataRetrieverCompat", "MediaMetadataRetrieverCompat: setDataSource error: path=" + str);
            return false;
        }
    }

    public byte[] m23161a() {
        try {
            if (m23156c()) {
                return this.f14921a.getEmbeddedPicture();
            }
            return this.f14922b.m23165a();
        } catch (Throwable th) {
            exw.m18457e("MediaMetadataRetrieverCompat", "getEmbeddedPicture error");
            return null;
        }
    }

    public int m23157a(int i, int i2) {
        try {
            String extractMetadata;
            if (m23156c()) {
                extractMetadata = this.f14921a.extractMetadata(i);
            } else {
                extractMetadata = this.f14922b.m23163a(i);
            }
            Integer valueOf = Integer.valueOf(Integer.parseInt(extractMetadata));
            if (valueOf != null) {
                i2 = valueOf.intValue();
            }
        } catch (Exception e) {
        }
        return i2;
    }

    public long m23158a(int i, long j) {
        try {
            String extractMetadata;
            if (m23156c()) {
                extractMetadata = this.f14921a.extractMetadata(i);
            } else {
                extractMetadata = this.f14922b.m23163a(i);
            }
            Long valueOf = Long.valueOf(Long.parseLong(extractMetadata));
            if (valueOf != null) {
                j = valueOf.longValue();
            }
        } catch (Exception e) {
        }
        return j;
    }

    public String m23159a(int i, String str) {
        try {
            CharSequence extractMetadata;
            if (m23156c()) {
                extractMetadata = this.f14921a.extractMetadata(i);
            } else {
                extractMetadata = this.f14922b.m23163a(i);
            }
            if (TextUtils.isEmpty(extractMetadata)) {
                return str;
            }
            return extractMetadata;
        } catch (Exception e) {
            return str;
        }
    }

    public void m23162b() {
        try {
            if (m23156c()) {
                this.f14921a.release();
            } else {
                this.f14922b.m23166b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
