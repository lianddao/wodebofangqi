package com.songbirdnest.test;

import android.os.Debug;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MemInfo {
    private static final String COMMA = ", ";
    private static NumberFormat formatter = new DecimalFormat("###,##0.00");
    private static FileOutputStream fos = null;
    private static double[] mFirst = null;
    private static double[] mLast = new double[]{0.0d, 0.0d, 0.0d};

    public static void init(String aPrompt, String aClassName) throws IOException {
        System.gc();
        initOutputFile(aClassName);
        initVars();
        traceImpl(aPrompt);
    }

    public static void trace(String prompt) {
        try {
            System.gc();
            traceImpl(prompt);
        } catch (Throwable th) {
        }
    }

    public static void hprof(String prompt, String aClassName) {
        try {
            traceImpl(prompt);
            hprofImpl(prompt, aClassName);
        } catch (Throwable th) {
        }
    }

    private static void hprofImpl(String prompt, String aClassName) throws IOException {
        Debug.dumpHprofData(getFolderName() + extractFileName(aClassName) + "." + prompt + ".android.hprof");
    }

    private static void traceImpl(String prompt) throws IOException {
        if (fos == null) {
            init("MemInfo-" + System.currentTimeMillis(), prompt);
            return;
        }
        write(prompt, get(), new double[]{mCurrent[0] - mFirst[0], mCurrent[1] - mFirst[1], get()[2] - mFirst[2]}, new double[]{mCurrent[0] - mLast[0], mCurrent[1] - mLast[1], get()[2] - mLast[2]});
        mLast = get();
    }

    private static void write(String string) throws IOException {
        System.out.println(string);
        fos.write(string.getBytes());
        fos.flush();
    }

    private static void initVars() {
        mFirst = get();
        mLast = get();
    }

    private static void write(String prompt, double[] current, double[] dFirst, double[] dLast) throws IOException {
        write(prompt + COMMA + lf(current[0]) + COMMA + lf(current[1]) + COMMA + lf(current[2]) + COMMA + lf(dFirst[0]) + COMMA + lf(dFirst[1]) + COMMA + lf(dFirst[2]) + COMMA + lf(dLast[0]) + COMMA + lf(dLast[1]) + COMMA + lf(dLast[2]) + "\n");
    }

    private static String lf(double value) {
        return formatter.format(value / 1048576.0d);
    }

    private static void initOutputFile(String aClassName) throws IOException {
        initOutputFolder();
        fos = new FileOutputStream(new File(getFileName(aClassName)));
        write("Prompt, Allocated MB, Free, Heap, dF Allocated, dF Free, dF Heap, dL Allocated, dL Free, dL Heap \n");
    }

    public static String getFileName(String aClassName) {
        return getFolderName() + extractFileName(aClassName) + ".meminfo.csv";
    }

    private static String extractFileName(String aClassName) {
        return aClassName.substring(aClassName.lastIndexOf(".") + 1);
    }

    private static void initOutputFolder() throws IOException {
        int i;
        int i2 = 1;
        String folder = getFolderName();
        boolean exists = new File(folder).exists();
        boolean created = new File(folder).mkdirs();
        if (exists) {
            i = 0;
        } else {
            i = 1;
        }
        if (created) {
            i2 = 0;
        }
        if ((i2 & i) != 0) {
            throw new IOException("Failed to create " + folder);
        }
    }

    public static String getFolderName() {
        return "/mnt/sdcard/log/";
    }

    private static double[] get() {
        double nativeHeapAllocatedSize = (double) Debug.getNativeHeapAllocatedSize();
        double nativeHeapFreeSize = (double) Debug.getNativeHeapFreeSize();
        double nativeHeapSize = (double) Debug.getNativeHeapSize();
        return new double[]{nativeHeapAllocatedSize, nativeHeapFreeSize, nativeHeapSize};
    }
}
