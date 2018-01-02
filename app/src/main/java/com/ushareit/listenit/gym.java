package com.ushareit.listenit;

import java.lang.reflect.Method;

public class gym {
    private Class<?> f14923a;
    private Object f14924b;
    private Method f14925c;
    private Method f14926d;
    private Method f14927e;
    private Method f14928f;

    public gym() {
        try {
            this.f14923a = Class.forName("android.media.MediaMetadataRetriever");
            this.f14924b = this.f14923a.newInstance();
        } catch (Exception e) {
            exw.m18457e("MediaMetadataRetrieverGingerbread", "MediaMetadataRetrieverGingerbread : contruct error");
            this.f14924b = null;
        }
    }

    public void m23164a(String str) {
        try {
            if (this.f14925c == null) {
                this.f14925c = this.f14923a.getDeclaredMethod("setDataSource", new Class[]{String.class});
            }
            this.f14925c.invoke(this.f14924b, new Object[]{str});
        } catch (Exception e) {
            exw.m18457e("MediaMetadataRetrieverGingerbread", "setDataSource error: path=" + str);
        }
    }

    public byte[] m23165a() {
        try {
            if (this.f14927e == null) {
                this.f14927e = this.f14923a.getDeclaredMethod("getEmbeddedPicture", new Class[0]);
            }
            return (byte[]) this.f14927e.invoke(this.f14924b, new Object[0]);
        } catch (Exception e) {
            exw.m18457e("MediaMetadataRetrieverGingerbread", "getEmbeddedPicture error");
            return null;
        }
    }

    public String m23163a(int i) {
        try {
            if (this.f14926d == null) {
                this.f14926d = this.f14923a.getDeclaredMethod("extractMetadata", new Class[]{Integer.TYPE});
            }
            return (String) this.f14926d.invoke(this.f14924b, new Object[]{Integer.valueOf(i)});
        } catch (Exception e) {
            exw.m18457e("MediaMetadataRetrieverGingerbread", "extractMetadata error");
            return null;
        }
    }

    public void m23166b() {
        try {
            if (this.f14928f != null) {
                this.f14928f = this.f14923a.getDeclaredMethod("release", new Class[0]);
                this.f14928f.invoke(this.f14924b, new Object[0]);
            }
        } catch (Exception e) {
            exw.m18457e("MediaMetadataRetrieverGingerbread", "release error");
        }
    }
}
