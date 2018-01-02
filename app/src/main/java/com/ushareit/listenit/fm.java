package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

class fm {
    public static boolean m19857a(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static String m19858b(Context context, Uri uri) {
        return m19855a(context, uri, "_display_name", null);
    }

    private static String m19864h(Context context, Uri uri) {
        return m19855a(context, uri, "mime_type", null);
    }

    public static long m19859c(Context context, Uri uri) {
        return m19854a(context, uri, "_size", 0);
    }

    public static boolean m19860d(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(m19864h(context, uri))) {
            return true;
        }
        return false;
    }

    public static boolean m19861e(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        CharSequence h = m19864h(context, uri);
        int a = m19853a(context, uri, "flags", 0);
        if (TextUtils.isEmpty(h)) {
            return false;
        }
        if ((a & 4) != 0) {
            return true;
        }
        if ("vnd.android.document/directory".equals(h) && (a & 8) != 0) {
            return true;
        }
        if (TextUtils.isEmpty(h) || (a & 2) == 0) {
            return false;
        }
        return true;
    }

    public static boolean m19862f(Context context, Uri uri) {
        return DocumentsContract.deleteDocument(context.getContentResolver(), uri);
    }

    public static boolean m19863g(Context context, Uri uri) {
        Object e;
        Throwable th;
        AutoCloseable query;
        try {
            query = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
            try {
                boolean z = query.getCount() > 0;
                m19856a(query);
                return z;
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.w("DocumentFile", "Failed query: " + e);
                    m19856a(query);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    m19856a(query);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.w("DocumentFile", "Failed query: " + e);
            m19856a(query);
            return false;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            m19856a(query);
            throw th;
        }
    }

    private static String m19855a(Context context, Uri uri, String str, String str2) {
        AutoCloseable query;
        Object e;
        Throwable th;
        try {
            query = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            try {
                if (!query.moveToFirst() || query.isNull(0)) {
                    m19856a(query);
                    return str2;
                }
                str2 = query.getString(0);
                m19856a(query);
                return str2;
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.w("DocumentFile", "Failed query: " + e);
                    m19856a(query);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    m19856a(query);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.w("DocumentFile", "Failed query: " + e);
            m19856a(query);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            m19856a(query);
            throw th;
        }
    }

    private static int m19853a(Context context, Uri uri, String str, int i) {
        return (int) m19854a(context, uri, str, (long) i);
    }

    private static long m19854a(Context context, Uri uri, String str, long j) {
        Object e;
        Throwable th;
        AutoCloseable query;
        try {
            query = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            try {
                if (!query.moveToFirst() || query.isNull(0)) {
                    m19856a(query);
                    return j;
                }
                j = query.getLong(0);
                m19856a(query);
                return j;
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.w("DocumentFile", "Failed query: " + e);
                    m19856a(query);
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    m19856a(query);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.w("DocumentFile", "Failed query: " + e);
            m19856a(query);
            return j;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            m19856a(query);
            throw th;
        }
    }

    private static void m19856a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }
}
