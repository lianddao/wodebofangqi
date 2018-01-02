package com.ushareit.listenit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;

public class exz {
    private final Context f11884a;
    private final String f11885b;

    public exz(Context context, String str) {
        this.f11884a = context;
        this.f11885b = str;
    }

    public exz(Context context) {
        this.f11884a = context;
        this.f11885b = "Settings";
    }

    public boolean m17991a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f11884a.getSharedPreferences(this.f11885b, 0);
        if (sharedPreferences == null) {
            exw.m18457e("Settings", this.f11885b + "'s SharedPreferences is null!");
            return false;
        }
        String string = sharedPreferences.getString(str, "");
        if (sharedPreferences.contains(str) && string.equals(str2)) {
            return true;
        }
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    public void m17990a(String str) {
        SharedPreferences sharedPreferences = this.f11884a.getSharedPreferences(this.f11885b, 0);
        if (sharedPreferences == null) {
            exw.m18457e("Settings", this.f11885b + "'s SharedPreferences is null!");
            return;
        }
        Editor edit = sharedPreferences.edit();
        edit.remove(str);
        edit.commit();
    }

    public String m17993b(String str) {
        return m17994b(str, "");
    }

    public String m17994b(String str, String str2) {
        SharedPreferences sharedPreferences = this.f11884a.getSharedPreferences(this.f11885b, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, str2);
        }
        exw.m18457e("Settings", this.f11885b + "'s SharedPreferences is null!");
        return str2;
    }

    public boolean m17998c(String str) {
        return m17992a(str, false);
    }

    public boolean m17992a(String str, boolean z) {
        String b = m17994b(str, null);
        if (b != null) {
            try {
                z = Boolean.valueOf(b).booleanValue();
            } catch (Exception e) {
            }
        }
        return z;
    }

    public boolean m17997b(String str, boolean z) {
        return m17991a(str, Boolean.toString(z));
    }

    public int m17999d(String str) {
        return m17988a(str, 0);
    }

    public int m17988a(String str, int i) {
        String b = m17994b(str, null);
        if (b != null) {
            try {
                i = Integer.valueOf(b).intValue();
            } catch (Exception e) {
            }
        }
        return i;
    }

    public boolean m17995b(String str, int i) {
        return m17991a(str, Integer.toString(i));
    }

    public long m17989a(String str, long j) {
        try {
            j = Long.parseLong(m17993b(str));
        } catch (NumberFormatException e) {
        }
        return j;
    }

    public boolean m17996b(String str, long j) {
        return m17991a(str, Long.toString(j));
    }

    public boolean m18000e(String str) {
        SharedPreferences sharedPreferences = this.f11884a.getSharedPreferences(this.f11885b, 0);
        if (sharedPreferences == null || !sharedPreferences.contains(str)) {
            return false;
        }
        return true;
    }

    public Map<String, ?> m18001g() {
        SharedPreferences sharedPreferences = this.f11884a.getSharedPreferences(this.f11885b, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        exw.m18457e("Settings", this.f11885b + "'s SharedPreferences is null!");
        return new HashMap();
    }
}
