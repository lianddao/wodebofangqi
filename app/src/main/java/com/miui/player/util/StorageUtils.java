package com.miui.player.util;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.google.android.collect.Lists;
import com.miui.player.receiver.PriorityStorageBroadcastReceiver;
import com.miui.player.ui.base.MusicApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import miui.os.Build;

public class StorageUtils {
    private static final String MIUI_DIR_NAME = "MIUI";
    private static final String MUSIC_DIR_NAME = "music";
    private static final String SDCARD_ONE_ROOT = "/storage/sdcard1";
    private static final String SDCARD_ZERO_ROOT = "/storage/sdcard0";
    static final String TAG = "StorageUtils";

    public static String getMainSdcardRoot() {
        Context context = MusicApplication.getApplication();
        if (Utils.isSupportPriorityStorage() && isExternalSdcardMounted() && PriorityStorageBroadcastReceiver.isPriorityStorage(context)) {
            return getExternalSdcardRoot();
        }
        return Environment.getExternalStorageDirectory().getPath();
    }

    public static String getInternalSdcardRoot() {
        if (!Build.IS_HONGMI_TWO || Build.IS_HONGMI_TWO_A || Build.IS_HONGMI_TWO_S) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return SDCARD_ONE_ROOT;
    }

    public static String getExternalSdcardRoot() {
        if (!Build.IS_HONGMI_TWO || Build.IS_HONGMI_TWO_A || Build.IS_HONGMI_TWO_S) {
            return System.getenv("SECONDARY_STORAGE");
        }
        return SDCARD_ZERO_ROOT;
    }

    public static String getMIUIRoot() {
        return getMainSdcardRoot() + File.separator + MIUI_DIR_NAME;
    }

    public static String getMusicRoot() {
        return getMIUIRoot() + File.separator + MUSIC_DIR_NAME;
    }

    public static boolean isExternalSdcardPath(String path) {
        String root = getExternalSdcardRoot();
        return root != null && path.startsWith(root);
    }

    public static boolean isInternalSdcardPath(String path) {
        String root = getInternalSdcardRoot();
        return root != null && path.startsWith(root);
    }

    public static boolean isExternalSdcardMounted() {
        String externalSdcard = getExternalSdcardRoot();
        if (TextUtils.isEmpty(externalSdcard)) {
            return false;
        }
        return "mounted".equals(((StorageManager) MusicApplication.getApplication().getSystemService("storage")).getVolumeState(externalSdcard));
    }

    public static ArrayList<String> getAllSdcardFilePath(String leafPath) {
        ArrayList<String> sdcardPaths = new ArrayList();
        if (Build.IS_HONGMI) {
            sdcardPaths.add(getExternalSdcardRoot() + leafPath);
            sdcardPaths.add(getInternalSdcardRoot() + leafPath);
        } else {
            sdcardPaths.add(getMainSdcardRoot() + leafPath);
        }
        return sdcardPaths;
    }

    public static ArrayList<File> getAllSdcardFile(String leafPath) {
        ArrayList<File> sdcardFiles = new ArrayList();
        if (Build.IS_HONGMI) {
            sdcardFiles.add(new File(getExternalSdcardRoot() + leafPath));
            sdcardFiles.add(new File(getInternalSdcardRoot() + leafPath));
        } else {
            sdcardFiles.add(new File(getMainSdcardRoot() + leafPath));
        }
        return sdcardFiles;
    }

    public static ArrayList<String> getAllExistFilePath(String leafPath) {
        ArrayList<String> existPaths = Lists.newArrayList();
        Iterator i$ = getAllSdcardFilePath(leafPath).iterator();
        while (i$.hasNext()) {
            String path = (String) i$.next();
            if (new File(path).exists()) {
                existPaths.add(path);
            }
        }
        return existPaths;
    }

    public static ArrayList<File> getAllExistFile(String leafPath) {
        ArrayList<File> existFiles = Lists.newArrayList();
        Iterator i$ = getAllSdcardFilePath(leafPath).iterator();
        while (i$.hasNext()) {
            File file = new File((String) i$.next());
            if (file.exists()) {
                existFiles.add(file);
            }
        }
        return existFiles;
    }

    public static File findExistFile(File leaf) {
        ArrayList<File> existFiles = getAllExistFile(leaf.getAbsolutePath());
        return existFiles.isEmpty() ? leaf : (File) existFiles.get(0);
    }

    public static String getLeafPath(String path) {
        if (!Build.IS_HONGMI) {
            return path.substring(getMainSdcardRoot().length());
        }
        if (isInternalSdcardPath(path)) {
            return path.substring(getInternalSdcardRoot().length());
        }
        return path.substring(getExternalSdcardRoot().length());
    }

    public static String getSubFilePath(String name) {
        return getMusicRoot() + File.separator + name;
    }

    public static File getSubFile(String name) {
        return new File(getSubFilePath(name));
    }

    public static File getExternalTemp() {
        return getSubFile(DownloadHelper.TEMP_POSTFIX);
    }

    public static File getInternelTemp() {
        return MusicApplication.getApplication().getCacheDir();
    }

    public static boolean ensureDirExists(File file) {
        if (file.getParentFile().exists()) {
            return true;
        }
        int secondSlash = file.getAbsolutePath().indexOf(47, 1);
        if (secondSlash < 1) {
            return false;
        }
        if (new File(file.getAbsolutePath().substring(0, secondSlash)).exists()) {
            return file.getParentFile().mkdirs();
        }
        return false;
    }
}
