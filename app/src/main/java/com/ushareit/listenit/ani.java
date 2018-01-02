package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ani {
    private static final String f4928a = ani.class.getSimpleName();
    private static ani f4929b;
    private final Context f4930c;

    private ani(Context context) {
        this.f4930c = context;
    }

    public static ani m6378a(Context context) {
        if (f4929b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f4929b == null) {
                    f4929b = new ani(applicationContext);
                }
            }
        }
        return f4929b;
    }

    private static void m6379a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    private Bitmap m6380b(String str) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(str.substring("file://".length())), null, null);
            m6383a(str, decodeStream);
            return decodeStream;
        } catch (Throwable e) {
            Log.e(f4928a, "Failed to copy local image into cache (url=" + str + ").", e);
            return null;
        }
    }

    private Bitmap m6381c(String str) {
        Bitmap decodeStream;
        Throwable th;
        aqi com_ushareit_listenit_aqi = null;
        if (str.startsWith("asset:///")) {
            InputStream open;
            try {
                open = this.f4930c.getAssets().open(str.substring(9, str.length()));
                try {
                    decodeStream = BitmapFactory.decodeStream(open);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return decodeStream;
                } catch (Throwable th2) {
                    th = th2;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                open = com_ushareit_listenit_aqi;
                if (open != null) {
                    open.close();
                }
                return decodeStream;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                open = com_ushareit_listenit_aqi;
                th = th4;
                if (open != null) {
                    open.close();
                }
                throw th;
            }
        }
        byte[] d = auv.m7226a(this.f4930c).m6722a(str, com_ushareit_listenit_aqi).m6779d();
        decodeStream = BitmapFactory.decodeByteArray(d, 0, d.length);
        m6383a(str, decodeStream);
        return decodeStream;
    }

    public Bitmap m6382a(String str) {
        File file = new File(this.f4930c.getCacheDir(), str.hashCode() + ".png");
        return !file.exists() ? str.startsWith("file://") ? m6380b(str) : m6381c(str) : BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public void m6383a(String str, Bitmap bitmap) {
        Closeable byteArrayOutputStream;
        Closeable fileOutputStream;
        Throwable e;
        Closeable closeable = null;
        File file = new File(this.f4930c.getCacheDir(), str.hashCode() + ".png");
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                if (byteArrayOutputStream.size() >= 3145728) {
                    Log.d(f4928a, "Bitmap size exceeds max size for storage");
                    m6379a(byteArrayOutputStream);
                    m6379a(null);
                    return;
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    fileOutputStream.flush();
                    m6379a(byteArrayOutputStream);
                    m6379a(fileOutputStream);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    closeable = fileOutputStream;
                    fileOutputStream = byteArrayOutputStream;
                    try {
                        Log.e(f4928a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
                        m6379a(fileOutputStream);
                        m6379a(closeable);
                    } catch (Throwable th) {
                        e = th;
                        byteArrayOutputStream = fileOutputStream;
                        m6379a(byteArrayOutputStream);
                        m6379a(closeable);
                        throw e;
                    }
                } catch (IOException e3) {
                    e = e3;
                    closeable = fileOutputStream;
                    try {
                        Log.e(f4928a, "Unable to write bitmap to file (url=" + str + ").", e);
                        m6379a(byteArrayOutputStream);
                        m6379a(closeable);
                    } catch (Throwable th2) {
                        e = th2;
                        m6379a(byteArrayOutputStream);
                        m6379a(closeable);
                        throw e;
                    }
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    closeable = fileOutputStream;
                    Log.e(f4928a, "Unable to write bitmap to output stream", e);
                    m6379a(byteArrayOutputStream);
                    m6379a(closeable);
                } catch (Throwable th3) {
                    e = th3;
                    closeable = fileOutputStream;
                    m6379a(byteArrayOutputStream);
                    m6379a(closeable);
                    throw e;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = byteArrayOutputStream;
                Log.e(f4928a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
                m6379a(fileOutputStream);
                m6379a(closeable);
            } catch (IOException e6) {
                e = e6;
                Log.e(f4928a, "Unable to write bitmap to file (url=" + str + ").", e);
                m6379a(byteArrayOutputStream);
                m6379a(closeable);
            } catch (OutOfMemoryError e7) {
                e = e7;
                Log.e(f4928a, "Unable to write bitmap to output stream", e);
                m6379a(byteArrayOutputStream);
                m6379a(closeable);
            }
        } catch (FileNotFoundException e8) {
            e = e8;
            fileOutputStream = null;
            Log.e(f4928a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
            m6379a(fileOutputStream);
            m6379a(closeable);
        } catch (IOException e9) {
            e = e9;
            byteArrayOutputStream = null;
            Log.e(f4928a, "Unable to write bitmap to file (url=" + str + ").", e);
            m6379a(byteArrayOutputStream);
            m6379a(closeable);
        } catch (OutOfMemoryError e10) {
            e = e10;
            byteArrayOutputStream = null;
            Log.e(f4928a, "Unable to write bitmap to output stream", e);
            m6379a(byteArrayOutputStream);
            m6379a(closeable);
        } catch (Throwable th4) {
            e = th4;
            byteArrayOutputStream = null;
            m6379a(byteArrayOutputStream);
            m6379a(closeable);
            throw e;
        }
    }
}
