package com.miui.player.util;

import com.miui.player.meta.MetaManager;
import com.xiaomi.music.util.MusicLog;
import java.io.File;

public class StorageConfig {
    public static final int[] BIT_RATES_SORTED = new int[]{BIT_RATE_UHD, 192, 128};
    public static final int BIT_RATE_HD = 192;
    public static final int BIT_RATE_NORMAL = 128;
    public static final int BIT_RATE_UHD = 320;
    private static final String META_NAME_FORMAT_2 = "%s.%s";
    private static final String META_NAME_FORMAT_3 = "%s_%s.%s";
    public static final String META_TYPE_ALBUM = "album";
    public static final String META_TYPE_AVATAR = "avatar";
    public static final String META_TYPE_LYRIC = "lyric";
    public static final String META_TYPE_MP3 = "mp3";
    public static final String[] META_TYPE_MP3_ALL = new String[]{META_TYPE_MP3_UHD, META_TYPE_MP3_HD, META_TYPE_MP3};
    public static final String META_TYPE_MP3_HD = "mp3_hd";
    public static final String META_TYPE_MP3_UHD = "mp3_uhd";
    public static final int QUALITY_HD = 1;
    public static final int QUALITY_NORMAL = 2;
    public static final int QUALITY_UHD = 0;
    static final String TAG = "StorageConfig";

    public static boolean isMiuiMp3DownloadPath(String path) {
        return StorageUtils.getSubFilePath(META_TYPE_MP3).equals(path) || StorageUtils.getSubFilePath(META_TYPE_MP3_HD).equals(path) || StorageUtils.getSubFilePath(META_TYPE_MP3_UHD).equals(path);
    }

    public static File getMp3Dir(boolean createIfNotExist) {
        return getDir(META_TYPE_MP3, createIfNotExist);
    }

    public static File getMp3Dir(String type, boolean createIfNotExit) {
        return getDir(type, createIfNotExit);
    }

    public static File[] getAllMp3Dir(boolean createIfNotExit) {
        File[] files = new File[META_TYPE_MP3_ALL.length];
        for (int i = 0; i < META_TYPE_MP3_ALL.length; i++) {
            files[i] = getMp3Dir(META_TYPE_MP3_ALL[i], createIfNotExit);
        }
        return files;
    }

    public static String getMp3FileName(String track, String artist) {
        return String.format(META_NAME_FORMAT_3, new Object[]{track, artist, META_TYPE_MP3});
    }

    public static File getAvatarDir(boolean createIfNotExist) {
        return getDir(META_TYPE_AVATAR, createIfNotExist);
    }

    public static String getAvatarFileName(String artist) {
        return String.format(META_NAME_FORMAT_2, new Object[]{regulate(artist), "jpg"});
    }

    public static File getAlbumDir(boolean createIfNotExist) {
        return getDir("album", createIfNotExist);
    }

    public static String getAlbumFileName(String album, String artist) {
        return String.format(META_NAME_FORMAT_3, new Object[]{regulate(album), regulate(artist), "jpg"});
    }

    public static File getLyricDir(boolean createIfNotExist) {
        return getDir("lyric", createIfNotExist);
    }

    public static String getLyricFileName(String track, String artist) {
        return String.format(META_NAME_FORMAT_3, new Object[]{regulate(track), regulate(artist), "lrc"});
    }

    public static File getLyricFile(String track, String artist, String trackPath) {
        if (trackPath != null) {
            String localLyricPath = replaceExtName(trackPath, "lrc");
            if (localLyricPath != null) {
                File autoLyricFile = new File(localLyricPath);
                if (autoLyricFile.exists()) {
                    return autoLyricFile;
                }
            }
        }
        File file = new File(getLyricDir(false), getLyricFileName(track, artist));
        if (!file.exists()) {
            file = null;
        }
        return file;
    }

    private static String replaceExtName(String src, String extName) {
        int lastDot = src.lastIndexOf(".") + 1;
        if (lastDot < 0 || lastDot >= src.length()) {
            return null;
        }
        return src.substring(0, lastDot) + extName;
    }

    private static File getDir(String name, boolean createIfNotExist) {
        File f = StorageUtils.getSubFile(name);
        if (!(!createIfNotExist || f.exists() || f.mkdirs())) {
            MusicLog.m397e(TAG, "fail to create file, path=" + f.getAbsolutePath());
        }
        return f;
    }

    private static String regulate(String name) {
        if (name == null) {
            return MetaManager.UNKNOWN_STRING;
        }
        return FileNameUtils.regulateFileName(name.trim(), "+");
    }

    public static String getMusicType(int bitRate) {
        if (bitRate >= BIT_RATE_UHD) {
            return META_TYPE_MP3_UHD;
        }
        if (bitRate >= 192) {
            return META_TYPE_MP3_HD;
        }
        return META_TYPE_MP3;
    }

    public static int getMusicBitRate(int quality) {
        switch (quality) {
            case 0:
                return BIT_RATE_UHD;
            case 1:
                return 192;
            default:
                return 128;
        }
    }

    public static int getUserChoice(int bitRate) {
        switch (bitRate) {
            case 192:
                return 1;
            case BIT_RATE_UHD /*320*/:
                return 0;
            default:
                return 2;
        }
    }
}
