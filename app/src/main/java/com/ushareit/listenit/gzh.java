package com.ushareit.listenit;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.text.TextUtils;

public class gzh {
    public static Uri m23374a(Context context, Uri uri) {
        if (VERSION.SDK_INT <= 19) {
            return uri;
        }
        Object b = m23377b(context, uri);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        return Uri.parse("file:///" + b);
    }

    public static String m23377b(Context context, Uri uri) {
        Uri uri2 = null;
        if (VERSION.SDK_INT > 19) {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (m23376a(uri)) {
                    String[] split = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(split[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + split[1];
                    }
                } else if (m23378b(uri)) {
                    return m23375a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                } else if (m23379c(uri)) {
                    Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
                    if ("image".equals(obj)) {
                        uri2 = Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(obj)) {
                        uri2 = Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(obj)) {
                        uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    String str = "_id=?";
                    return m23375a(context, uri2, "_id=?", new String[]{r1[1]});
                }
            } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (m23380d(uri)) {
                    return uri.getLastPathSegment();
                }
                return m23375a(context, uri, null, null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return uri.getPath();
    }

    public static String m23375a(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor = null;
        String str2 = "_data";
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str2 = query.getString(query.getColumnIndexOrThrow("_data"));
                        if (query == null) {
                            return str2;
                        }
                        query.close();
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean m23376a(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean m23378b(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean m23379c(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean m23380d(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
