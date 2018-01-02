package com.ushareit.listenit;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class fbp {
    public static String m18800a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String m18798a(String str, double d) {
        return new DecimalFormat(str, new DecimalFormatSymbols(Locale.US)).format(d);
    }

    public static String m18799a(String str, Date date) {
        return new SimpleDateFormat(str, Locale.US).format(date);
    }

    public static String m18797a(String str) {
        return str.toLowerCase(Locale.US);
    }

    public static String m18801b(String str) {
        return str.toUpperCase(Locale.US);
    }
}
