package com.ushareit.listenit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ece {
    private static final Map<Integer, String> f10814a = new HashMap();
    private static final Map<String, Integer> f10815b = new HashMap();
    private final int f10816c;
    private final String f10817d;
    private final String f10818e;

    static {
        f10814a.put(Integer.valueOf(-1), "The transaction needs to be run again with current data");
        f10814a.put(Integer.valueOf(-2), "The server indicated that this operation failed");
        f10814a.put(Integer.valueOf(-3), "This client does not have permission to perform this operation");
        f10814a.put(Integer.valueOf(-4), "The operation had to be aborted due to a network disconnect");
        f10814a.put(Integer.valueOf(-6), "The supplied auth token has expired");
        f10814a.put(Integer.valueOf(-7), "The supplied auth token was invalid");
        f10814a.put(Integer.valueOf(-8), "The transaction had too many retries");
        f10814a.put(Integer.valueOf(-9), "The transaction was overridden by a subsequent set");
        f10814a.put(Integer.valueOf(-10), "The service is unavailable");
        f10814a.put(Integer.valueOf(-11), "User code called from the Firebase Database runloop threw an exception:\n");
        f10814a.put(Integer.valueOf(-24), "The operation could not be performed due to a network error");
        f10814a.put(Integer.valueOf(-25), "The write was canceled by the user.");
        f10814a.put(Integer.valueOf(-999), "An unknown error occurred");
        f10815b.put("datastale", Integer.valueOf(-1));
        f10815b.put("failure", Integer.valueOf(-2));
        f10815b.put("permission_denied", Integer.valueOf(-3));
        f10815b.put("disconnected", Integer.valueOf(-4));
        f10815b.put("expired_token", Integer.valueOf(-6));
        f10815b.put("invalid_token", Integer.valueOf(-7));
        f10815b.put("maxretries", Integer.valueOf(-8));
        f10815b.put("overriddenbyset", Integer.valueOf(-9));
        f10815b.put("unavailable", Integer.valueOf(-10));
        f10815b.put("network_error", Integer.valueOf(-24));
        f10815b.put("write_canceled", Integer.valueOf(-25));
    }

    private ece(int i, String str) {
        this(i, str, null);
    }

    private ece(int i, String str, String str2) {
        this.f10816c = i;
        this.f10817d = str;
        if (str2 == null) {
            str2 = "";
        }
        this.f10818e = str2;
    }

    public static ece m16709a(int i) {
        if (f10814a.containsKey(Integer.valueOf(i))) {
            return new ece(i, (String) f10814a.get(Integer.valueOf(i)), null);
        }
        throw new IllegalArgumentException("Invalid Firebase Database error code: " + i);
    }

    public static ece m16710a(String str) {
        return m16711a(str, null);
    }

    public static ece m16711a(String str, String str2) {
        return m16712a(str, str2, null);
    }

    public static ece m16712a(String str, String str2, String str3) {
        Integer num = (Integer) f10815b.get(str.toLowerCase());
        Integer valueOf = num == null ? Integer.valueOf(-999) : num;
        return new ece(valueOf.intValue(), str2 == null ? (String) f10814a.get(valueOf) : str2, str3);
    }

    public static ece m16713a(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String valueOf = String.valueOf((String) f10814a.get(Integer.valueOf(-11)));
        String valueOf2 = String.valueOf(stringWriter.toString());
        return new ece(-11, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    public int m16714a() {
        return this.f10816c;
    }

    public String m16715b() {
        return this.f10817d;
    }

    public ecf m16716c() {
        String str = "Firebase Database error: ";
        String valueOf = String.valueOf(this.f10817d);
        return new ecf(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public String toString() {
        String str = "DatabaseError: ";
        String valueOf = String.valueOf(this.f10817d);
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
