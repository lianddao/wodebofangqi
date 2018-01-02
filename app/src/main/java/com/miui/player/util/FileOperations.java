package com.miui.player.util;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.collect.Lists;
import com.xiaomi.music.util.StreamHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FileOperations {
    private static final String TAG = FileOperations.class.getCanonicalName();

    public static boolean copyFileSafe(Context r8, Uri r9, Uri r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0008 in list [B:10:0x0024]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r3 = 1;
        r4 = 0;
        r5 = r9.equals(r10);
        if (r5 == 0) goto L_0x0009;
    L_0x0008:
        return r3;
    L_0x0009:
        r1 = 0;
        r5 = "music_temp";	 Catch:{ IOException -> 0x002a, all -> 0x003b }
        r6 = 0;	 Catch:{ IOException -> 0x002a, all -> 0x003b }
        r7 = 0;	 Catch:{ IOException -> 0x002a, all -> 0x003b }
        r1 = java.io.File.createTempFile(r5, r6, r7);	 Catch:{ IOException -> 0x002a, all -> 0x003b }
        r2 = android.net.Uri.fromFile(r1);	 Catch:{ IOException -> 0x002a, all -> 0x003b }
        r5 = copyFile(r8, r9, r2);	 Catch:{ IOException -> 0x002a, all -> 0x003b }
        if (r5 == 0) goto L_0x0028;	 Catch:{ IOException -> 0x002a, all -> 0x003b }
    L_0x001c:
        r5 = copyFile(r8, r2, r10);	 Catch:{ IOException -> 0x002a, all -> 0x003b }
        if (r5 == 0) goto L_0x0028;
    L_0x0022:
        if (r1 == 0) goto L_0x0008;
    L_0x0024:
        r1.delete();
        goto L_0x0008;
    L_0x0028:
        r3 = r4;
        goto L_0x0022;
    L_0x002a:
        r0 = move-exception;
        r3 = TAG;	 Catch:{ IOException -> 0x002a, all -> 0x003b }
        r5 = r0.toString();	 Catch:{ IOException -> 0x002a, all -> 0x003b }
        android.util.Log.e(r3, r5);	 Catch:{ IOException -> 0x002a, all -> 0x003b }
        if (r1 == 0) goto L_0x0039;
    L_0x0036:
        r1.delete();
    L_0x0039:
        r3 = r4;
        goto L_0x0008;
    L_0x003b:
        r3 = move-exception;
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.delete();
    L_0x0041:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.util.FileOperations.copyFileSafe(android.content.Context, android.net.Uri, android.net.Uri):boolean");
    }

    public static boolean copyFile(Context context, Uri from, Uri to) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        boolean copyFile;
        try {
            inputStream = context.getContentResolver().openInputStream(from);
            outputStream = context.getContentResolver().openOutputStream(to);
            copyFile = copyFile(inputStream, outputStream);
            return copyFile;
        } catch (IOException e) {
            copyFile = e;
            return false;
        } finally {
            StreamHelper.closeSafe(inputStream);
            StreamHelper.closeSafe(outputStream);
        }
    }

    public static boolean copyFile(InputStream inputStream, OutputStream outputStream) {
        byte[] buffer = new byte[16384];
        while (true) {
            try {
                int byteread = inputStream.read(buffer);
                if (byteread != -1) {
                    outputStream.write(buffer, 0, byteread);
                } else {
                    outputStream.flush();
                    return true;
                }
            } catch (IOException e) {
                Log.e(TAG, e.toString());
                return false;
            }
        }
    }

    public static boolean copyFile(String oldPath, String newPath) {
        OutputStream outputStream;
        Exception e;
        Throwable th;
        InputStream inputStream = null;
        OutputStream outputStream2 = null;
        boolean ret = false;
        if (oldPath.equals(newPath)) {
            return 0;
        }
        try {
            File newFile = new File(newPath);
            File parent = newFile.getParentFile();
            if (parent != null && (parent.exists() || parent.mkdirs())) {
                File oldfile = new File(oldPath);
                if (oldfile.exists()) {
                    InputStream inputStream2 = new BufferedInputStream(new FileInputStream(oldfile));
                    try {
                        outputStream = new BufferedOutputStream(new FileOutputStream(newFile));
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = inputStream2;
                        try {
                            Log.e(TAG, e.toString());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    Log.e(TAG, e3.toString());
                                }
                            }
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            return ret;
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e32) {
                                    Log.e(TAG, e32.toString());
                                    throw th;
                                }
                            }
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        throw th;
                    }
                    try {
                        copyFile(inputStream2, outputStream);
                        ret = true;
                        outputStream2 = outputStream;
                        inputStream = inputStream2;
                    } catch (Exception e4) {
                        e = e4;
                        outputStream2 = outputStream;
                        inputStream = inputStream2;
                        Log.e(TAG, e.toString());
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        return ret;
                    } catch (Throwable th4) {
                        th = th4;
                        outputStream2 = outputStream;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        throw th;
                    }
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e322) {
                    Log.e(TAG, e322.toString());
                }
            }
            if (outputStream2 != null) {
                outputStream2.close();
            }
        } catch (Exception e5) {
            e = e5;
            Log.e(TAG, e.toString());
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream2 != null) {
                outputStream2.close();
            }
            return ret;
        }
        return ret;
    }

    public static String[] getSortedFileNameArr(String dirPath) {
        String[] names = new File(dirPath).list();
        if (names != null) {
            Arrays.sort(names);
        }
        return names;
    }

    public static String[] getSortedFilePathArr(ArrayList<String> dirPaths) {
        ArrayList<String> filePaths = Lists.newArrayList();
        Iterator it = dirPaths.iterator();
        while (it.hasNext()) {
            File dir = new File((String) it.next());
            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        filePaths.add(file.getAbsolutePath());
                    }
                }
            }
        }
        if (filePaths.isEmpty()) {
            return null;
        }
        String[] paths = new String[filePaths.size()];
        filePaths.toArray(paths);
        Arrays.sort(paths);
        return paths;
    }
}
