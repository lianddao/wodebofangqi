package com.ushareit.listenit;

import android.net.Uri;

final class ym {
    private static final int f17571a = "file:///android_asset/".length();

    public static boolean m27241a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public static String m27242b(Uri uri) {
        return uri.toString().substring(f17571a);
    }
}
