package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.umeng.analytics.C0154a;
import com.ushareit.listenit.main.MainActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class gyn {
    public static final int[] f14929a = new int[]{C0349R.drawable.ablumart_pic1, C0349R.drawable.ablumart_pic2, C0349R.drawable.ablumart_pic3, C0349R.drawable.ablumart_pic4, C0349R.drawable.ablumart_pic5, C0349R.drawable.ablumart_pic6, C0349R.drawable.ablumart_pic7, C0349R.drawable.ablumart_pic8, C0349R.drawable.ablumart_pic9, C0349R.drawable.ablumart_pic10, C0349R.drawable.ablumart_pic11, C0349R.drawable.ablumart_pic12, C0349R.drawable.ablumart_pic13, C0349R.drawable.ablumart_pic14, C0349R.drawable.ablumart_pic15, C0349R.drawable.ablumart_pic16, C0349R.drawable.ablumart_pic17, C0349R.drawable.ablumart_pic18};

    public static String m23182a(long j) {
        String str = "00:00";
        if (j == 0) {
            return str;
        }
        int i = ((int) (j / 1000)) % 60;
        int i2 = (int) ((j / 60000) % 60);
        if (((int) ((j / C0154a.f2954j) % 24)) == 0) {
            return String.format(Locale.US, "%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        }
        return String.format(Locale.US, "%d:%02d:%02d", new Object[]{Integer.valueOf((int) ((j / C0154a.f2954j) % 24)), Integer.valueOf(i2), Integer.valueOf(i)});
    }

    public static String m23208b(long j) {
        String str = "00:00.00";
        if (j == 0) {
            return str;
        }
        int i = (int) ((j % 1000) / 10);
        int i2 = ((int) (j / 1000)) % 60;
        int i3 = (int) ((j / 60000) % 60);
        if (((int) ((j / C0154a.f2954j) % 24)) == 0) {
            return String.format(Locale.US, "%02d:%02d.%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)});
        }
        return String.format(Locale.US, "%d:%02d:%02d.%02d", new Object[]{Integer.valueOf((int) ((j / C0154a.f2954j) % 24)), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)});
    }

    public static String m23180a(float f) {
        int i = (int) (f % 60.0f);
        return String.format("%d:%02d", new Object[]{Integer.valueOf((int) (f / 60.0f)), Integer.valueOf(i)});
    }

    public static String m23179a() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date(System.currentTimeMillis()));
    }

    public static boolean m23202a(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String m23209b(String str) {
        int i = 2;
        if (fbb.m18763c(str)) {
            return "";
        }
        int length = str.length();
        int i2;
        if (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') {
            i2 = 2;
        } else {
            i2 = 0;
        }
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf != -1 || r0 <= 0) {
            i = lastIndexOf;
        }
        if (i == -1 || str.charAt(length - 1) == File.separatorChar) {
            return null;
        }
        if (str.indexOf(File.separatorChar) == i && str.charAt(r0) == File.separatorChar) {
            return str.substring(0, i + 1);
        }
        return str.substring(0, i);
    }

    public static String m23220c(String str) {
        if (fbb.m18763c(str)) {
            return "";
        }
        String[] split = str.split(File.separator);
        return split.length > 1 ? split[split.length - 2] : str;
    }

    public static String m23229d(String str) {
        if (fbb.m18763c(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int lastIndexOf2 = str.lastIndexOf(46);
        lastIndexOf = lastIndexOf < 0 ? 0 : lastIndexOf + 1;
        if (lastIndexOf2 < 0) {
            lastIndexOf2 = str.length();
        }
        return str.substring(lastIndexOf, lastIndexOf2);
    }

    public static String m23235e(String str) {
        if (fbb.m18763c(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > 0 ? str.substring(lastIndexOf + 1, str.length()) : "";
    }

    public static int m23170a(File file) {
        int length;
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.startsWith(File.separator)) {
            length = File.separator.length();
        } else {
            length = 0;
        }
        String[] split = absolutePath.substring(length, absolutePath.endsWith(File.separator) ? absolutePath.length() - File.separator.length() : absolutePath.length()).split(File.separator);
        if (split == null) {
            return 0;
        }
        return split.length;
    }

    public static boolean m23240f(String str) {
        if (fbb.m18763c(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean m23201a(glg com_ushareit_listenit_glg) {
        if (com_ushareit_listenit_glg == null || fbb.m18763c(com_ushareit_listenit_glg.f14342j)) {
            return false;
        }
        if (m23260p(com_ushareit_listenit_glg.f14342j) && (m23256m() || hgg.m23704a(com_ushareit_listenit_glg.f14342j))) {
            return true;
        }
        File file = new File(com_ushareit_listenit_glg.f14342j);
        if (file.exists() && file.length() == ((long) com_ushareit_listenit_glg.f14344l)) {
            return true;
        }
        return false;
    }

    public static int m23241g(String str) {
        if (fbb.m18763c(str)) {
            return 0;
        }
        eyh a = eyh.m18491a(str);
        if (a.mo2328c()) {
            return (int) a.mo2332g();
        }
        return 0;
    }

    public static void m23216b(glg com_ushareit_listenit_glg) {
        File file = new File(com_ushareit_listenit_glg.f14342j);
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
                exw.m18457e("MusicUtils", "deleteFile error(path=" + com_ushareit_listenit_glg.f14342j + ")");
            }
        }
    }

    public static void m23246h(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
                exw.m18457e("MusicUtils", "deleteFile error(path=" + str + ")");
            }
        }
    }

    public static void m23198a(List<glg> list) {
        for (glg b : list) {
            m23216b(b);
        }
    }

    public static void m23186a(Context context, fji com_ushareit_listenit_fji) {
        if (context != null && com_ushareit_listenit_fji != null) {
            ((MainActivity) context).m24827a(com_ushareit_listenit_fji);
        }
    }

    public static void m23211b(Context context, fji com_ushareit_listenit_fji) {
        if (context != null && com_ushareit_listenit_fji != null) {
            ((MainActivity) context).m24829b(com_ushareit_listenit_fji);
        }
    }

    public static void m23223c(Context context, fji com_ushareit_listenit_fji) {
        if (context != null && com_ushareit_listenit_fji != null) {
            ((MainActivity) context).m24830c(com_ushareit_listenit_fji);
        }
    }

    public static void m23197a(ak akVar, fyi com_ushareit_listenit_fyi) {
        if (akVar != null && com_ushareit_listenit_fyi != null) {
            try {
                bh a = akVar.m709f().mo797a();
                a.mo3096b(C0349R.id.popup, com_ushareit_listenit_fyi);
                a.mo3098c();
                ((fjt) akVar).m5099a(com_ushareit_listenit_fyi);
            } catch (Exception e) {
            }
        }
    }

    public static void m23196a(ak akVar, fji com_ushareit_listenit_fji) {
        if (akVar != null && com_ushareit_listenit_fji != null) {
            try {
                bh a = akVar.m709f().mo797a();
                a.mo3092a((ah) com_ushareit_listenit_fji);
                a.mo3098c();
                ((fjt) akVar).m5099a(null);
            } catch (Exception e) {
            }
        }
    }

    public static void m23195a(ak akVar, int i, fji com_ushareit_listenit_fji) {
        if (akVar != null && com_ushareit_listenit_fji != null) {
            bh a = akVar.m709f().mo797a();
            a.mo3090a(i, (ah) com_ushareit_listenit_fji);
            a.mo3095b();
        }
    }

    public static void m23215b(ak akVar, fji com_ushareit_listenit_fji) {
        if (akVar != null && com_ushareit_listenit_fji != null) {
            try {
                bh a = akVar.m709f().mo797a();
                a.mo3092a((ah) com_ushareit_listenit_fji);
                a.mo3098c();
            } catch (Exception e) {
            }
        }
    }

    public static void m23225c(ak akVar, fji com_ushareit_listenit_fji) {
        bh a = akVar.m709f().mo797a();
        a.mo3099c(com_ushareit_listenit_fji);
        a.mo3095b();
    }

    public static void m23232d(ak akVar, fji com_ushareit_listenit_fji) {
        bh a = akVar.m709f().mo797a();
        a.mo3097b(com_ushareit_listenit_fji);
        a.mo3095b();
    }

    public static void m23194a(ak akVar) {
        if (akVar != null) {
            fji q = ((MainActivity) akVar).m24836q();
            if (q != null && q.m1338w() != null) {
                q.m1338w().bringToFront();
                q.m1338w().requestLayout();
                q.mo201x();
            }
        }
    }

    public static void m23214b(ak akVar) {
        if (akVar != null) {
            MainActivity mainActivity = (MainActivity) akVar;
            if (mainActivity.m24836q() != null && mainActivity.m24837r() != null) {
                mainActivity.m24837r().bringToFront();
                mainActivity.m24837r().requestLayout();
            }
        }
    }

    public static void m23192a(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static void m23193a(View view, int i, int i2) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public static void m23213b(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    public static void m23224c(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static void m23231d(View view, int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public static void m23237e(View view, int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public static void m23239f(View view, int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.rightMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public static void m23243g(View view, int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.bottomMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public static void m23245h(View view, int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.gravity = i;
        view.setLayoutParams(layoutParams);
    }

    @TargetApi(11)
    public static void m23191a(View view) {
        if (VERSION.SDK_INT >= 11) {
            view.setLayerType(2, null);
            exw.m18443a("MusicUtils", "isHardwareAccelerated=" + view.isHardwareAccelerated() + ", version=" + VERSION.SDK_INT);
        }
    }

    public static boolean m23199a(Context context) {
        for (FeatureInfo featureInfo : context.getPackageManager().getSystemAvailableFeatures()) {
            if ("android.hardware.bluetooth".equals(featureInfo.name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m23217b() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean m23226c() {
        return VERSION.SDK_INT >= 9;
    }

    public static boolean m23233d() {
        return VERSION.SDK_INT >= 11;
    }

    public static int m23206b(Context context) {
        int dimension = (int) context.getResources().getDimension(C0349R.dimen.common_dimens_50dp);
        if (m23217b()) {
            return dimension + fbb.m18766e(context);
        }
        return dimension;
    }

    public static void m23222c(Context context) {
        if (gvk.m23050b() && context != null) {
            m23230d(context);
        }
    }

    public static void m23230d(Context context) {
        ((MainActivity) context).m24836q().m20550U();
    }

    public static void m23236e(Context context) {
        ((MainActivity) context).m24836q().m20551V();
    }

    public static void m23190a(ViewPager viewPager) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("m");
            declaredField.setAccessible(true);
            gya com_ushareit_listenit_gya = new gya(viewPager.getContext(), null);
            com_ushareit_listenit_gya.m23122a(400);
            declaredField.set(viewPager, com_ushareit_listenit_gya);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m23212b(ViewPager viewPager) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("m");
            declaredField.setAccessible(true);
            gya com_ushareit_listenit_gya = new gya(viewPager.getContext(), null);
            com_ushareit_listenit_gya.m23122a(100);
            declaredField.set(viewPager, com_ushareit_listenit_gya);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean m23200a(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        if (cursor.moveToFirst() && cursor.getCount() != 0) {
            return true;
        }
        cursor.close();
        return false;
    }

    public static int m23234e() {
        return new Random(System.currentTimeMillis()).nextInt(18);
    }

    public static Bitmap m23173a(int i, int i2, int i3) {
        if (i < 0) {
            return m23172a(i2, i3);
        }
        return m23174a(eys.m18562a(), f14929a[i], i2, i3);
    }

    public static int m23169a(gla com_ushareit_listenit_gla) {
        int i = 5;
        if (com_ushareit_listenit_gla == null || fbb.m18763c(com_ushareit_listenit_gla.mo2562c())) {
            return f14929a[5];
        }
        String b = gyk.m23155b(com_ushareit_listenit_gla.mo2562c());
        if (!fbb.m18763c(b)) {
            i = b.charAt(0) % f14929a.length;
        }
        return f14929a[i];
    }

    public static Bitmap m23172a(int i, int i2) {
        return m23174a(eys.m18562a(), (int) C0349R.drawable.default_albumart_gray, i, i2);
    }

    public static Bitmap m23174a(Context context, int i, int i2, int i3) {
        if (i2 * i3 > 230400) {
            if (i2 == i3) {
                i3 = 480;
                i2 = 480;
            } else {
                int b = m23205b(i2, i3);
                i3 >>= b;
                i2 >>= b;
            }
        } else if (i2 == 0 || i3 == 0) {
            i3 = 480;
            i2 = 480;
        }
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), i, options);
            options.inSampleSize = fag.m18697a(options, Math.min(i2, i3), i2 * i3);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Config.RGB_565;
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i, options);
            if (i2 == 0 || i3 == 0) {
                return decodeResource;
            }
            if (decodeResource == null) {
                return null;
            }
            float f = ((float) i2) / ((float) options.outWidth);
            float f2 = ((float) i3) / ((float) options.outHeight);
            if (f < f2) {
                f = f2;
            }
            if (f >= 0.99f) {
                return decodeResource;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            Bitmap createBitmap = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
            decodeResource.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e) {
            exw.m18457e("MusicUtils", "loadThumbnailFromRes error=" + Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public static boolean m23248i(String str) {
        boolean z = true;
        if (str == null || str.length() < 4) {
            return false;
        }
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options == null || options.outWidth <= 0 || options.outHeight <= 0) {
                z = false;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m23250j(String str) {
        if (fbb.m18763c(str) || str.length() > 2) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 0 || parseInt >= 18) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Bitmap m23175a(eyh com_ushareit_listenit_eyh, int i, int i2) {
        if (i * i2 > 230400) {
            if (i == i2) {
                i2 = 480;
                i = 480;
            } else {
                int b = m23205b(i, i2);
                i2 >>= b;
                i >>= b;
            }
        } else if (i == 0 || i2 == 0) {
            i2 = 480;
            i = 480;
        }
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(com_ushareit_listenit_eyh.mo2336k().getAbsolutePath(), options);
            options.inSampleSize = fag.m18697a(options, Math.min(i, i2), i * i2);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Config.RGB_565;
            Bitmap decodeFile = BitmapFactory.decodeFile(com_ushareit_listenit_eyh.mo2336k().getAbsolutePath(), options);
            if (i == 0 || i2 == 0) {
                return decodeFile;
            }
            if (decodeFile == null) {
                return null;
            }
            float f = ((float) i) / ((float) options.outWidth);
            float f2 = ((float) i2) / ((float) options.outHeight);
            if (f < f2) {
                f = f2;
            }
            if (f >= 0.99f) {
                return decodeFile;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
            decodeFile.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e) {
            exw.m18457e("MusicUtils", "loadThumbnailFromFile error=" + Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    private static int m23205b(int i, int i2) {
        int i3 = 0;
        int i4 = i * i2;
        while (i4 > 230400) {
            i4 >>= 2;
            i3++;
        }
        return i3;
    }

    public static synchronized Bitmap m23176a(String str, int i, int i2) {
        Bitmap bitmap = null;
        synchronized (gyn.class) {
            gyl com_ushareit_listenit_gyl = new gyl();
            try {
                if (com_ushareit_listenit_gyl.m23160a(str)) {
                    byte[] a = com_ushareit_listenit_gyl.m23161a();
                    if (a != null) {
                        bitmap = m23177a(a, i, i2);
                    }
                    if (com_ushareit_listenit_gyl != null) {
                        com_ushareit_listenit_gyl.m23162b();
                    }
                } else {
                    if (com_ushareit_listenit_gyl != null) {
                        com_ushareit_listenit_gyl.m23162b();
                    }
                }
            } catch (Throwable e) {
                exw.m18457e("MusicUtils", "error=" + exw.m18438a(e));
                if (com_ushareit_listenit_gyl != null) {
                    com_ushareit_listenit_gyl.m23162b();
                }
            } catch (Throwable th) {
                if (com_ushareit_listenit_gyl != null) {
                    com_ushareit_listenit_gyl.m23162b();
                }
            }
        }
        return bitmap;
    }

    public static Bitmap m23177a(byte[] bArr, int i, int i2) {
        if (i * i2 > 230400) {
            if (i == i2) {
                i2 = 480;
                i = 480;
            } else {
                int b = m23205b(i, i2);
                i2 >>= b;
                i >>= b;
            }
        } else if (i == 0 || i2 == 0) {
            i2 = 480;
            i = 480;
        }
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = fag.m18697a(options, Math.min(i, i2), i * i2);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Config.RGB_565;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (i == 0 || i2 == 0 || decodeByteArray == null) {
                return decodeByteArray;
            }
            float f = ((float) i) / ((float) options.outWidth);
            float f2 = ((float) i2) / ((float) options.outHeight);
            if (f < f2) {
                f = f2;
            }
            if (f >= 0.99f) {
                return decodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            decodeByteArray.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e) {
            exw.m18457e("MusicUtils", "loadThumbnailFromBytes error=" + Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public static Drawable m23207b(int i, int i2, int i3) {
        Bitmap c = m23218c(i, i2, i3);
        return c != null ? new BitmapDrawable(c) : null;
    }

    public static Bitmap m23218c(int i, int i2, int i3) {
        Bitmap decodeResource;
        Throwable th;
        Config config = Config.ARGB_8888;
        if (m23258n()) {
            config = Config.RGB_565;
            int[] c = m23227c(i2, i3);
            i2 = c[0];
            i3 = c[1];
        }
        try {
            Options options = new Options();
            options.inSampleSize = m23168a(options, i, i2, i3);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = config;
            decodeResource = BitmapFactory.decodeResource(eys.m18562a().getResources(), i, options);
            if (decodeResource != null) {
                try {
                    float f = ((float) i2) / ((float) options.outWidth);
                    float f2 = ((float) i3) / ((float) options.outHeight);
                    if (f < f2) {
                        f = f2;
                    }
                    int width = decodeResource.getWidth();
                    int height = decodeResource.getHeight();
                    if (((double) f) < 0.95d && width > 0 && height > 0) {
                        Matrix matrix = new Matrix();
                        matrix.postScale(f, f);
                        decodeResource = Bitmap.createBitmap(decodeResource, 0, 0, width, height, matrix, true);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    exw.m18450b("MusicUtils", "loadBitmapFromResource has an error.", th);
                    return decodeResource;
                }
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            decodeResource = null;
            th = th4;
            exw.m18450b("MusicUtils", "loadBitmapFromResource has an error.", th);
            return decodeResource;
        }
        return decodeResource;
    }

    public static Options m23178a(InputStream inputStream) {
        Options options = new Options();
        if (inputStream != null) {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
        }
        return options;
    }

    private static int m23168a(Options options, int i, int i2, int i3) {
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(eys.m18562a().getResources(), i, options);
        return fag.m18697a(options, Math.min(i2, i3), i2 * i3);
    }

    private static int[] m23227c(int i, int i2) {
        int i3 = 480;
        if (i * i2 > 230400) {
            if (i == i2) {
                i2 = 480;
            } else {
                int b = m23205b(i, i2);
                i3 = i >> b;
                i2 >>= b;
            }
        } else if (i == 0 || i2 == 0) {
            i2 = 480;
        } else {
            i3 = i;
        }
        return new int[]{i3, i2};
    }

    private static boolean m23258n() {
        ActivityManager activityManager = (ActivityManager) eys.m18562a().getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    public static int m23204b(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent));
    }

    public static int m23171a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i3 - i4 > 1) {
            int i5 = (i3 + i4) / 2;
            int i6 = iArr[i5];
            if (i6 == i2) {
                return i5;
            }
            if (i6 < i2) {
                i4 = i5;
            } else if (i6 > i2) {
                i3 = i5;
            }
        }
        if (iArr[i3] != i2) {
            return iArr[i4] == i2 ? i4 : -1;
        } else {
            return i3;
        }
    }

    public static boolean m23203a(String str, String str2) {
        if (fbb.m18763c(str) || fbb.m18763c(str2)) {
            return false;
        }
        return str.toLowerCase(Locale.US).contains(str2.toLowerCase(Locale.US));
    }

    public static void m23187a(Context context, File file) {
        m23188a(context, file, null);
    }

    public static void m23188a(Context context, File file, OnScanCompletedListener onScanCompletedListener) {
        if (file != null && file.exists()) {
            try {
                MediaScannerConnection.scanFile(context, new String[]{file.getAbsolutePath()}, null, onScanCompletedListener);
            } catch (Exception e) {
                exw.m18449b("MusicUtils", e.toString());
            }
        }
    }

    public static String m23181a(int i) {
        String str = "unknown";
        switch (i) {
            case -10001:
                return "normalplayer";
            case 0:
                return "all";
            case 1:
                return "artist";
            case 2:
                return "album";
            case 3:
                return "folder";
            case 4:
                return "playlist";
            case 5:
                return "artist_song";
            case 6:
                return "album_song";
            case 7:
                return "folder_song";
            case 8:
                return "playlist_song";
            case 9:
                return "most_play";
            case 10:
                return "lasted_play";
            case 11:
                return "favorite";
            case 12:
                return "search_song";
            case 13:
                return "recent_add";
            case 14:
                return "clips";
            case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
                return "recommend_song";
            case 16:
                return "collected_song";
            case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
                return "stream_song";
            case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                return "stream_song_list";
            case Encoder.LINE_GROUPS /*19*/:
                return "online_search_stream_song";
            default:
                return str;
        }
    }

    public static int m23251k(String str) {
        int i = 0;
        if (!fbb.m18763c(str)) {
            File file = new File(str);
            if (file != null && file.exists()) {
                gyl com_ushareit_listenit_gyl = new gyl();
                try {
                    if (com_ushareit_listenit_gyl.m23160a(file.getAbsolutePath())) {
                        i = com_ushareit_listenit_gyl.m23157a(20, 0);
                        if (com_ushareit_listenit_gyl != null) {
                            com_ushareit_listenit_gyl.m23162b();
                        }
                    } else if (com_ushareit_listenit_gyl != null) {
                        com_ushareit_listenit_gyl.m23162b();
                    }
                } catch (Throwable th) {
                    if (com_ushareit_listenit_gyl != null) {
                        com_ushareit_listenit_gyl.m23162b();
                    }
                }
            }
        }
        return i;
    }

    public static void m23189a(Bitmap bitmap) {
        gyi.m23141a(eyh.m18491a(m23238f()), gyi.m23140a(bitmap, 100, 100));
    }

    public static String m23185a(InputStream inputStream, int i, String str) {
        OutputStream fileOutputStream;
        Throwable e;
        Throwable th;
        if (inputStream == null || i <= 0 || fbb.m18763c(str)) {
            return null;
        }
        String m = m23255m(str);
        File file = new File(m);
        if (file.exists()) {
            if (file.length() == ((long) i)) {
                return m;
            }
            file.delete();
        }
        zh zhVar = new zh();
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                if (zhVar.m27283a(inputStream, fileOutputStream)) {
                    exw.m18457e("MusicUtils", "saveAlbumArt albumName=" + str + ",filesize=" + file.length() + ", streamSize=" + i);
                } else if (file.exists()) {
                    file.delete();
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
                inputStream.close();
            } catch (Exception e3) {
                e = e3;
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    exw.m18457e("MusicUtils", "saveAlbumArt albumName=" + str + ", error: " + exw.m18438a(e));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    inputStream.close();
                    if (file.exists()) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            throw th;
                        }
                    }
                    inputStream.close();
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            if (file.exists()) {
                file.delete();
            }
            exw.m18457e("MusicUtils", "saveAlbumArt albumName=" + str + ", error: " + exw.m18438a(e));
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            inputStream.close();
            if (file.exists()) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            inputStream.close();
            throw th;
        }
        if (file.exists() || file.length() <= 0) {
            return null;
        }
        return m;
    }

    public static String m23183a(Bitmap bitmap, String str) {
        OutputStream fileOutputStream;
        Throwable th;
        if (bitmap == null || fbb.m18763c(str)) {
            return null;
        }
        String m = m23255m(str);
        File file = new File(m);
        if (file.exists()) {
            file.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file, false);
            try {
                if (bitmap.compress(CompressFormat.PNG, 100, fileOutputStream)) {
                    exw.m18457e("MusicUtils", "saveAlbumArt albumName=" + str + ",filesize=" + file.length());
                } else if (file.exists()) {
                    file.delete();
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    exw.m18457e("MusicUtils", "saveAlbumArt error, albumName=" + str);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (file.exists()) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            if (file.exists()) {
                file.delete();
            }
            exw.m18457e("MusicUtils", "saveAlbumArt error, albumName=" + str);
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            if (file.exists()) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            throw th;
        }
        if (file.exists() || file.length() <= 0) {
            return null;
        }
        return m;
    }

    public static String m23238f() {
        return fqm.m20393a().m20398d().mo2330e() + File.separator + gef.m21805a().m21837g() + ".jpg";
    }

    public static String m23253l(String str) {
        return fqm.m20393a().m20398d().mo2330e() + File.separator + str + ".jpg";
    }

    public static String m23242g() {
        return fqm.m20393a().m20398d().mo2330e() + File.separator + gef.m21805a().m21837g() + "_temp" + ".jpg";
    }

    public static String m23244h() {
        return fqm.m20393a().m20398d().mo2330e() + File.separator + gef.m21805a().m21837g() + "_camera" + ".jpg";
    }

    public static String m23255m(String str) {
        if (fbb.m18763c(str)) {
            return null;
        }
        return fqm.m20393a().m20397c().mo2330e() + File.separator + UUID.nameUUIDFromBytes(str.getBytes()).toString();
    }

    public static String m23257n(String str) {
        if (fbb.m18763c(str)) {
            return null;
        }
        return fqm.m20393a().m20397c().mo2330e() + File.separator + UUID.nameUUIDFromBytes((str + "_temp").getBytes()).toString();
    }

    public static Bitmap m23247i() {
        String f = m23238f();
        if (TextUtils.isEmpty(f) || !new File(f).exists()) {
            return null;
        }
        return BitmapFactory.decodeFile(f);
    }

    public static String m23219c(glg com_ushareit_listenit_glg) {
        exw.m18443a("MusicUtils", "createDownloadSongPath: song=" + com_ushareit_listenit_glg);
        return m23259o(fqm.m20393a().m20396b().mo2330e() + File.separator + m23263s(com_ushareit_listenit_glg.f14338f) + "." + (!fbb.m18763c(com_ushareit_listenit_glg.f14347o) ? com_ushareit_listenit_glg.f14347o : m23235e(com_ushareit_listenit_glg.f14342j)));
    }

    public static String m23184a(fnn com_ushareit_listenit_fnn) {
        exw.m18443a("MusicUtils", "createDownloadSongPath: song=" + com_ushareit_listenit_fnn.toMap());
        return m23259o(fqm.m20393a().m20396b().mo2330e() + File.separator + m23263s(com_ushareit_listenit_fnn.getNa()) + "." + com_ushareit_listenit_fnn.getMt());
    }

    public static String m23259o(String str) {
        eyh a = eyh.m18491a(str);
        int i = 1;
        while (a.mo2328c()) {
            i++;
            a = eyh.m18491a(str.substring(0, str.lastIndexOf(".")) + " ( " + i + " )" + str.substring(str.lastIndexOf("."), str.length()));
        }
        exw.m18443a("fsdf", "getTargetFile: filePath=" + a.mo2330e());
        return a.mo2330e();
    }

    private static String m23263s(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '/':
                    stringBuilder.append(" ");
                    break;
                default:
                    stringBuilder.append(c);
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public static int m23249j() {
        int i = 0;
        try {
            return eys.m18562a().getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (Exception e) {
            return i;
        }
    }

    public static String m23252k() {
        String a = fbb.m18751a(eys.m18562a());
        if (TextUtils.isEmpty(a)) {
            a = eys.m18562a().getResources().getConfiguration().locale.getCountry();
        }
        if (fbb.m18763c(a)) {
            a = "ID";
        }
        return a.toLowerCase(Locale.US);
    }

    public static boolean m23254l() {
        Pair a = eyw.m18568a(eys.m18562a());
        return ((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue();
    }

    public static boolean m23260p(String str) {
        return !fbb.m18763c(str) && (str.startsWith("https://") || str.startsWith("http://"));
    }

    public static String m23228d(glg com_ushareit_listenit_glg) {
        return !m23260p(com_ushareit_listenit_glg.f14342j) ? m23229d(com_ushareit_listenit_glg.f14342j) : com_ushareit_listenit_glg.f14339g + " - " + com_ushareit_listenit_glg.f14338f;
    }

    public static List<glg> m23210b(List<fse> list) {
        List<glg> arrayList = new ArrayList();
        for (fse com_ushareit_listenit_glg : list) {
            arrayList.add(new glg(com_ushareit_listenit_glg));
        }
        return arrayList;
    }

    public static String m23261q(String str) {
        String trim = str.trim();
        if (!trim.startsWith("https://api.soundcloud.com/")) {
            return trim;
        }
        String d = fqo.m20422d();
        return trim + (trim.endsWith("/") ? "?client_id=" + d : "/?client_id=" + d);
    }

    public static String m23262r(String str) {
        if (!str.startsWith("https://api.soundcloud.com/")) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf > 0) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static List<glg> m23221c(List<? extends gla> list) {
        List<glg> arrayList = new ArrayList(list.size());
        for (gla com_ushareit_listenit_gla : list) {
            arrayList.add(new glg((fse) com_ushareit_listenit_gla));
        }
        return arrayList;
    }

    public static boolean m23256m() {
        Pair a = eyw.m18568a(eys.m18562a());
        return ((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue();
    }

    public static int m23167a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
