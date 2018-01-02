package com.ushareit.listenit;

import android.content.Context;
import android.util.Pair;

public class glb {
    public static int m22327a(Context context) {
        Pair a = eyw.m18568a(context);
        boolean booleanValue = ((Boolean) a.first).booleanValue();
        if (((Boolean) a.second).booleanValue()) {
            return 2;
        }
        if (booleanValue) {
            return 1;
        }
        return 0;
    }

    public static int m22329b(Context context) {
        return gvj.m22882U(context);
    }

    public static void m22328a(Context context, int i) {
        gvj.m22997l(context, i);
    }

    public static int m22330c(Context context) {
        int i = 1;
        int b = m22329b(context);
        int a = m22327a(context);
        exw.m18457e("TAG", "lastNetWork=" + b + ", currNetWork=" + a);
        if (b == a) {
            return 0;
        }
        switch (b) {
            case 0:
                if (a != 1) {
                    i = 2;
                    break;
                }
                break;
            case 1:
                if (a != 0) {
                    i = 4;
                    break;
                }
                i = 3;
                break;
            case 2:
                if (a != 1) {
                    i = 5;
                    break;
                }
                i = 6;
                break;
            default:
                i = 0;
                break;
        }
        exw.m18457e("TAG", "stateChanged=" + i);
        return i;
    }
}
