package com.miui.player.download;

import android.content.ContentUris;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Downloads.Impl;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.ui.base.ApplicationHelper;
import java.util.HashMap;
import java.util.List;

public class DownloadProviderProxy {
    private static final HashMap<Integer, String> ERROR_LIST = new HashMap();

    public static Uri queryRunning(Context r12, String r13) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r11 = 0;
        if (r12 != 0) goto L_0x0005;
    L_0x0003:
        r0 = r11;
    L_0x0004:
        return r0;
    L_0x0005:
        r0 = android.text.TextUtils.isEmpty(r13);
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        r0 = r11;
        goto L_0x0004;
    L_0x000d:
        r0 = com.miui.player.ui.base.ApplicationHelper.instance();
        r0 = r0.getDownloadInfoManager();
        r8 = r0.getDownloadId(r12, r13);
        r0 = 0;
        r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0021;
    L_0x001f:
        r0 = r11;
        goto L_0x0004;
    L_0x0021:
        r6 = "(status >= '100') AND (status <= '199')";
        r10 = "(status >= '100') AND (status <= '199') AND _id= ?";
        r0 = 1;
        r4 = new java.lang.String[r0];
        r0 = 0;
        r1 = java.lang.String.valueOf(r8);
        r4[r0] = r1;
        r7 = 0;
        r0 = r12.getContentResolver();	 Catch:{ all -> 0x0059 }
        r1 = android.provider.Downloads.Impl.CONTENT_URI;	 Catch:{ all -> 0x0059 }
        r2 = 0;	 Catch:{ all -> 0x0059 }
        r3 = "(status >= '100') AND (status <= '199') AND _id= ?";	 Catch:{ all -> 0x0059 }
        r5 = 0;	 Catch:{ all -> 0x0059 }
        r7 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0059 }
        if (r7 == 0) goto L_0x0052;	 Catch:{ all -> 0x0059 }
    L_0x0040:
        r0 = r7.moveToFirst();	 Catch:{ all -> 0x0059 }
        if (r0 == 0) goto L_0x0052;	 Catch:{ all -> 0x0059 }
    L_0x0046:
        r0 = android.provider.Downloads.Impl.CONTENT_URI;	 Catch:{ all -> 0x0059 }
        r0 = android.content.ContentUris.withAppendedId(r0, r8);	 Catch:{ all -> 0x0059 }
        if (r7 == 0) goto L_0x0004;
    L_0x004e:
        r7.close();
        goto L_0x0004;
    L_0x0052:
        if (r7 == 0) goto L_0x0057;
    L_0x0054:
        r7.close();
    L_0x0057:
        r0 = r11;
        goto L_0x0004;
    L_0x0059:
        r0 = move-exception;
        if (r7 == 0) goto L_0x005f;
    L_0x005c:
        r7.close();
    L_0x005f:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.download.DownloadProviderProxy.queryRunning(android.content.Context, java.lang.String):android.net.Uri");
    }

    public static Uri start(Context context, AudioLink link, String onlineId, String details, String appointName, String sunDirectory, List<AudioLink> candidates) {
        return start(context, link, onlineId, details, appointName, sunDirectory, candidates, true, 0);
    }

    public static Uri start(Context context, AudioLink link, String onlineId, String details, String appointName, String subDirectory, List<AudioLink> candidates, boolean visible, long timeOut) {
        return ApplicationHelper.instance().getDownloader().start(context, link, onlineId, details, appointName, subDirectory, candidates, visible, timeOut);
    }

    public static int deleteByUri(Context context, Uri uri) {
        return ApplicationHelper.instance().getDownloader().markRowDeleted(context, ContentUris.parseId(uri));
    }

    public static int deleteByAppointName(Context context, String appointName) {
        long[] ids = queryByAppointName(context, appointName);
        if (ids == null || ids.length == 0) {
            return 0;
        }
        return ApplicationHelper.instance().getDownloader().markRowDeleted(context, ids);
    }

    public static long[] queryByAppointName(Context context, String appointName) {
        return ApplicationHelper.instance().getDownloader().queryByAppointName(context, appointName);
    }

    public static boolean registerDownloadObserver(Context context, Uri uri, boolean notifyForDescendents, ContentObserver observer) {
        if (context == null || uri == null) {
            return false;
        }
        context.getContentResolver().registerContentObserver(uri, notifyForDescendents, observer);
        observer.onChange(true);
        return true;
    }

    public static void unregisterDownloadObserver(Context context, ContentObserver observer) {
        context.getContentResolver().unregisterContentObserver(observer);
    }

    public static String wrapPlayingTag(String src, int id) {
        return String.format("%s[playing %d]", new Object[]{src, Integer.valueOf(id)});
    }

    public static String unwrapPlayingTag(String tag) {
        if (tag == null) {
            return null;
        }
        int i = tag.indexOf("[");
        return i >= 0 ? tag.substring(0, i) : tag;
    }

    public static boolean isStatusSuccess(int status) {
        return status == 8;
    }

    public static boolean isStatusError(int status) {
        return status == 16;
    }

    public static boolean isRawStatusSuccess(int status) {
        return Impl.isStatusSuccess(status);
    }

    public static boolean isRawStatusError(int status) {
        return Impl.isStatusError(status);
    }

    public static String getDownloadErrorMessage(int errorCode) {
        String errorMessage = (String) ERROR_LIST.get(Integer.valueOf(errorCode));
        if (errorMessage != null) {
            return Integer.toString(errorCode) + " " + errorMessage;
        }
        return Integer.toString(errorCode);
    }

    static {
        ERROR_LIST.put(Integer.valueOf(1000), "ERROR_UNKNOWN");
        ERROR_LIST.put(Integer.valueOf(1001), "ERROR_FILE_ERROR");
        ERROR_LIST.put(Integer.valueOf(1002), "ERROR_UNHANDLED_HTTP_CODE");
        ERROR_LIST.put(Integer.valueOf(1004), "ERROR_HTTP_DATA_ERROR");
        ERROR_LIST.put(Integer.valueOf(1005), "ERROR_TOO_MANY_REDIRECTS");
        ERROR_LIST.put(Integer.valueOf(1006), "ERROR_INSUFFICIENT_SPACE");
        ERROR_LIST.put(Integer.valueOf(1007), "ERROR_DEVICE_NOT_FOUND");
        ERROR_LIST.put(Integer.valueOf(1008), "ERROR_CANNOT_RESUME");
        ERROR_LIST.put(Integer.valueOf(1009), "ERROR_FILE_ALREADY_EXISTS");
    }
}
