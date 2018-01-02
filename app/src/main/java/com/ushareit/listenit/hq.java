package com.ushareit.listenit;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

class hq {
    private static Field f15574a;
    private static boolean f15575b;

    static void m24049a(LayoutInflater layoutInflater, ht htVar) {
        Factory2 hrVar;
        if (htVar != null) {
            hrVar = new hr(htVar);
        } else {
            hrVar = null;
        }
        layoutInflater.setFactory2(hrVar);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            m24048a(layoutInflater, (Factory2) factory);
        } else {
            m24048a(layoutInflater, hrVar);
        }
    }

    static void m24048a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f15575b) {
            try {
                f15574a = LayoutInflater.class.getDeclaredField("mFactory2");
                f15574a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f15575b = true;
        }
        if (f15574a != null) {
            try {
                f15574a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
