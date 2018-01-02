package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

final class bot implements bos {
    bot() {
    }

    public boolean mo1068a(Format format) {
        return m9268a(format.f1431e) != null;
    }

    public boq mo1069b(Format format) {
        try {
            Class a = m9268a(format.f1431e);
            if (a != null) {
                return (boq) a.asSubclass(boq.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
        } catch (Throwable e) {
            throw new IllegalStateException("Unexpected error instantiating decoder", e);
        }
    }

    private Class<?> m9268a(String str) {
        Object obj = -1;
        try {
            switch (str.hashCode()) {
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        obj = null;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1490991545:
                    if (str.equals("application/x-mp4vtt")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1566015601:
                    if (str.equals("application/cea-608")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    return Class.forName("com.ushareit.listenit.bpx");
                case 1:
                    return Class.forName("com.ushareit.listenit.bpe");
                case 2:
                    return Class.forName("com.ushareit.listenit.bpo");
                case 3:
                    return Class.forName("com.ushareit.listenit.bpc");
                case 4:
                    return Class.forName("com.ushareit.listenit.bpl");
                case 5:
                    return Class.forName("com.ushareit.listenit.boy");
                default:
                    return null;
            }
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
