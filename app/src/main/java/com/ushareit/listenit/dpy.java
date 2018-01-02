package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.util.Log;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public class dpy {
    private final String f10140a;
    private final String f10141b;
    private final chl f10142c;
    private final int f10143d;

    private dpy(String str, String str2) {
        this.f10141b = str2;
        this.f10140a = str;
        this.f10142c = new chl(str);
        this.f10143d = m15256a();
    }

    public dpy(String str, String... strArr) {
        this(str, m15257a(strArr));
    }

    private int m15256a() {
        int i;
        if (VERSION.SDK_INT == 23) {
            String str = "log.tag.";
            String valueOf = String.valueOf(this.f10140a);
            str = System.getProperty(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            if (str != null) {
                Object obj = -1;
                switch (str.hashCode()) {
                    case -880503115:
                        if (str.equals("SUPPRESS")) {
                            i = 6;
                            break;
                        }
                        break;
                    case 2251950:
                        if (str.equals("INFO")) {
                            i = 2;
                            break;
                        }
                        break;
                    case 2656902:
                        if (str.equals("WARN")) {
                            i = 3;
                            break;
                        }
                        break;
                    case 64921139:
                        if (str.equals("DEBUG")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case 66247144:
                        if (str.equals("ERROR")) {
                            i = 4;
                            break;
                        }
                        break;
                    case 1069090146:
                        if (str.equals("VERBOSE")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 1940088646:
                        if (str.equals("ASSERT")) {
                            i = 5;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        return 2;
                    case 1:
                        return 3;
                    case 2:
                        return 4;
                    case 3:
                        return 5;
                    case 4:
                        return 6;
                    case 5:
                        return 7;
                    case 6:
                        return MoPubClientPositioning.NO_REPEAT;
                    default:
                        return 4;
                }
            }
        }
        i = 2;
        while (7 >= i && !Log.isLoggable(this.f10140a, i)) {
            i++;
        }
        return i;
    }

    private static String m15257a(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (String str : strArr) {
            if (stringBuilder.length() > 1) {
                stringBuilder.append(",");
            }
            stringBuilder.append(str);
        }
        stringBuilder.append(']').append(' ');
        return stringBuilder.toString();
    }

    public void m15258a(String str, Object... objArr) {
        if (m15259a(2)) {
            Log.v(this.f10140a, m15260b(str, objArr));
        }
    }

    public boolean m15259a(int i) {
        return this.f10143d <= i;
    }

    protected String m15260b(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.f10141b.concat(str);
    }
}
