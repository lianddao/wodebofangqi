package com.songbirdnest.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import com.songbirdnest.mediaplayer.Songbird;
import com.songbirdnest.test.Model.Playlist;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Control {
    private static final String NOMEDIA = ".nomedia";
    private static final String TAG = "SongbirdAutoTest";
    private static volatile boolean mediaScannerFinished = false;

    static class C04671 extends BroadcastReceiver {
        C04671() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!action.equals("android.intent.action.MEDIA_MOUNTED") && !action.equals("android.intent.action.MEDIA_UNMOUNTED") && !action.equals("android.intent.action.MEDIA_SCANNER_STARTED")) {
                if (action.equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
                    Toast.makeText(context, "SD Card scanner finished", 1).show();
                    Control.mediaScannerFinished = true;
                } else if (!action.equals("android.intent.action.MEDIA_EJECT") && !action.equals("android.intent.action.UMS_CONNECTED") && action.equals("android.intent.action.UMS_DISCONNECTED")) {
                }
            }
        }
    }

    public static boolean isDeviceAvailable(Songbird activity) {
        try {
            Playlist.getCount(activity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void copySdDirectory(String sourceDir, String targetDir) throws IOException, InterruptedException {
        copyDirectory(sd() + sourceDir, sd() + targetDir);
    }

    private static void copyDirectory(String sourceDir, String targetDir) throws IOException {
        Log.e(TAG, "Copy directory. From " + sourceDir + " to " + targetDir);
        File sourceFile = new File(sourceDir);
        if (sourceFile.exists()) {
            File targetDirFile = new File(targetDir);
            if (targetDirFile.exists() || targetDirFile.mkdirs()) {
                String[] list = sourceFile.list();
                for (String str : list) {
                    File child = new File(sourceFile.getAbsolutePath() + sep() + str);
                    if (child.isDirectory()) {
                        copyDirectory(child.getAbsolutePath(), targetDir + sep() + child.getName());
                    } else if (child.isHidden()) {
                        Log.e(TAG, "Copy ignored hidden file: " + child.getAbsolutePath());
                    } else {
                        copyFile(child.getAbsolutePath(), targetDir + sep() + child.getName());
                    }
                }
                return;
            }
            throw new IOException("Target directory creation failed: " + targetDir);
        }
        throw new IOException("Source directory not found: " + sourceDir);
    }

    private static void copyFile(String sourceFilename, String targetFilename) throws IOException {
        Log.e(TAG, "COPY File " + sourceFilename + " to " + targetFilename);
        InputStream is = new FileInputStream(sourceFilename);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(targetFilename)));
        int total = 0;
        byte[] b = new byte[1000000];
        boolean eof = false;
        while (!eof) {
            try {
                int read = is.read(b, 0, 1000000);
                total += read;
                bos.write(b, 0, read);
            } catch (Exception e) {
                eof = true;
            }
        }
        is.close();
        bos.close();
    }

    private static boolean mkdirs(String filename) throws IOException {
        if (filename == null) {
            throw new IOException("Bad filename " + filename);
        }
        int sepIndex = filename.lastIndexOf(47);
        if (sepIndex < 1) {
            return false;
        }
        return new File(filename.substring(0, sepIndex + 1)).mkdirs();
    }

    private static void copyFile(InputStream is, String targetFilename) throws IOException {
        Log.e(TAG, "COPY IS " + is + " to " + targetFilename);
        mkdirs(targetFilename);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(targetFilename)));
        int total = 0;
        byte[] b = new byte[1000000];
        boolean eof = false;
        while (!eof) {
            try {
                int read = is.read(b, 0, 1000000);
                total += read;
                bos.write(b, 0, read);
            } catch (Exception e) {
                eof = true;
            }
        }
        is.close();
        bos.close();
    }

    public static void scanBlocking(Context activity) throws InterruptedException {
        scanBlocking(activity, Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    public static void scanBlocking(Context activity, String filepath) throws InterruptedException {
        BroadcastReceiver broadcastReceiver = new C04671();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addDataScheme("file");
        activity.registerReceiver(broadcastReceiver, intentFilter);
        activity.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + filepath)));
        while (!mediaScannerFinished) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                activity.unregisterReceiver(broadcastReceiver);
                throw new InterruptedException("Interrupted while waiting for Media Scanner to complete with a ACTION_MEDIA_SCANNER_FINISHED");
            }
        }
        activity.unregisterReceiver(broadcastReceiver);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e2) {
            throw new InterruptedException("Interrupted after waiting for Media Scanner to complete with a ACTION_MEDIA_SCANNER_FINISHED");
        }
    }

    public static void removeFile(String playablePath) throws IOException {
        File file = new File(playablePath);
        if (!file.exists()) {
            throw new IOException("File deletion failed - database item not present on filesystem - MediaScanner did not complete properly. " + playablePath);
        } else if (!file.canWrite()) {
            throw new IOException("File deletion failed - No permissions (WRITE_EXTERNAL_STORAGE). " + playablePath);
        } else if (!file.delete()) {
            throw new IOException("File deletion failed. " + playablePath);
        }
    }

    private static String sep() {
        Environment.getExternalStorageDirectory();
        return File.separator;
    }

    public static String sd() {
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath());
        Environment.getExternalStorageDirectory();
        return append.append(File.separator).toString();
    }

    public static String sd(String path) {
        return sd() + path;
    }

    public static boolean sdFileExists(String filename) {
        return new File(sd() + filename).exists();
    }

    public static boolean sdDirectoryWriteable(String filename) {
        File file = new File(sd() + filename);
        if (file.exists() && file.canWrite()) {
            return true;
        }
        return false;
    }

    public static boolean assFolderExists(Context context, String filename) {
        try {
            String[] files = context.getAssets().list(filename);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void assCopyDirectory(Context context, String sourceDir, String targetDir) throws IOException, InterruptedException {
        for (String fileName : context.getAssets().list(sourceDir)) {
            if (fileName.endsWith(".mp3") || fileName.endsWith(".xml")) {
                assCopyFile(context, sourceDir + "/" + fileName, sd() + targetDir);
            }
        }
    }

    private static void assCopyFile(Context context, String fileName, String targetDir) throws IOException {
        Log.e("ASS", fileName);
        copyFile(context.getAssets().open(fileName), targetDir + sep() + fileName.substring(6));
    }

    public static void scanExposeOnly(String stash, String expose) throws IOException {
        scanHideAll(stash);
        scanExpose(stash + "/" + expose);
    }

    public static void scanHideAll(String path) throws IOException {
        String fullpath = getFullDirectoryPath(path);
        String[] list = new File(fullpath).list();
        for (String name : list) {
            if (new File(fullpath + "/" + name).isDirectory()) {
                scanHide(path + "/" + name);
            }
        }
    }

    private static String getFullDirectoryPath(String path) throws IOException {
        String fullpath = sd() + path;
        File pathFile = new File(fullpath);
        if (!pathFile.exists()) {
            throw new IOException("Not a valid path " + fullpath);
        } else if (pathFile.isDirectory()) {
            return fullpath;
        } else {
            throw new IOException("Not a directory " + fullpath);
        }
    }

    private static File getFileNomedia(String path) throws IOException {
        return new File(getFullDirectoryPath(path) + "/" + NOMEDIA);
    }

    private static void scanExpose(String path) throws IOException {
        File file = getFileNomedia(path);
        if (file.exists() && !file.delete()) {
            throw new IOException("Delete failed " + file.getAbsolutePath());
        }
    }

    private static void scanHide(String path) throws IOException {
        File file = getFileNomedia(path);
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("Creation failed " + file.getAbsolutePath());
        }
    }
}
