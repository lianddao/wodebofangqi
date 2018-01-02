package com.miui.player.meta;

import android.content.Context;
import android.text.TextUtils;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.util.FileNameUtils;
import com.miui.player.util.FileOperations;
import com.miui.player.util.StorageConfig;
import com.miui.player.util.StorageUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MetaManager extends StorageConfig {
    private static final String META_AVATAR_PATH_FORMAT = ("%s" + File.separator + "%s.%s");
    private static final String META_NAME_FORMAT = "%s_%s.%s";
    private static final String META_PATH_FORMAT = ("%s" + File.separator + META_NAME_FORMAT);
    private static final HashMap<String, MetaInfo> META_TYPE_MAP = new HashMap(6);
    private static final String SYS_UNKNOWN_STRING = "<unknown>";
    public static final String UNKNOWN_STRING = "";
    private static CharSequence sUnknownAlbumName = null;
    private static CharSequence sUnknownArtistName = null;

    static class C03541 implements Comparator<AudioLink> {
        C03541() {
        }

        public int compare(AudioLink lhs, AudioLink rhs) {
            return rhs.mBitrate - lhs.mBitrate;
        }
    }

    private static class MetaInfo {
        private final String mExtendName;
        private final String mRelateDir;

        public MetaInfo(String relateDir, String extendName) {
            this.mRelateDir = relateDir;
            this.mExtendName = extendName;
        }

        private String getAbsoluteDir() {
            return StorageUtils.getSubFile(this.mRelateDir).getAbsolutePath();
        }
    }

    static {
        META_TYPE_MAP.put("lyric", new MetaInfo("lyric", "lrc"));
        META_TYPE_MAP.put("album", new MetaInfo("album", "jpg"));
        META_TYPE_MAP.put(StorageConfig.META_TYPE_MP3, new MetaInfo(StorageConfig.META_TYPE_MP3, StorageConfig.META_TYPE_MP3));
        META_TYPE_MAP.put(StorageConfig.META_TYPE_MP3_HD, new MetaInfo(StorageConfig.META_TYPE_MP3_HD, StorageConfig.META_TYPE_MP3));
        META_TYPE_MAP.put(StorageConfig.META_TYPE_MP3_UHD, new MetaInfo(StorageConfig.META_TYPE_MP3_UHD, StorageConfig.META_TYPE_MP3));
        META_TYPE_MAP.put(StorageConfig.META_TYPE_AVATAR, new MetaInfo(StorageConfig.META_TYPE_AVATAR, "jpg"));
    }

    public static boolean makeDirIfNotExists(Context context, String metaType) {
        MetaInfo info = (MetaInfo) META_TYPE_MAP.get(metaType);
        if (info == null) {
            return false;
        }
        boolean ret;
        String dir = info.getAbsoluteDir();
        File file = new File(dir);
        if (file.exists()) {
            ret = file.isDirectory();
        } else {
            ret = file.mkdirs();
        }
        if (!"lyric".equals(metaType) && !"album".equals(metaType) && !StorageConfig.META_TYPE_AVATAR.equals(metaType)) {
            return ret;
        }
        addNoMediaFile(dir);
        return ret;
    }

    private static void addNoMediaFile(String dir) {
        File f = new File(dir, ".nomedia");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    public static String getMetaFileName(String first, String second, String metaType) {
        if ((TextUtils.isEmpty(first) && TextUtils.isEmpty(second)) || ((MetaInfo) META_TYPE_MAP.get(metaType)) == null) {
            return null;
        }
        return String.format(META_NAME_FORMAT, new Object[]{formatFileName(first), formatFileName(second), info.mExtendName});
    }

    public static String getSavedFilePath(String first, String second, String metaType) {
        if ((TextUtils.isEmpty(first) && TextUtils.isEmpty(second)) || ((MetaInfo) META_TYPE_MAP.get(metaType)) == null) {
            return null;
        }
        return getSavedFilePath(String.format(META_PATH_FORMAT, new Object[]{info.getAbsoluteDir(), formatFileName(first), formatFileName(second), info.mExtendName}));
    }

    public static String getMainSdcardFilePath(String first, String second, String metaType) {
        if ((TextUtils.isEmpty(first) && TextUtils.isEmpty(second)) || ((MetaInfo) META_TYPE_MAP.get(metaType)) == null) {
            return null;
        }
        return String.format(META_PATH_FORMAT, new Object[]{info.getAbsoluteDir(), formatFileName(first), formatFileName(second), info.mExtendName});
    }

    public static String getSavedAvatarFilePath(String name) {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        MetaInfo info = (MetaInfo) META_TYPE_MAP.get(StorageConfig.META_TYPE_AVATAR);
        return getSavedFilePath(String.format(META_AVATAR_PATH_FORMAT, new Object[]{info.getAbsoluteDir(), formatFileName(name), info.mExtendName}));
    }

    public static String getMainSdcardAvatarFilePath(String name) {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        MetaInfo info = (MetaInfo) META_TYPE_MAP.get(StorageConfig.META_TYPE_AVATAR);
        return String.format(META_AVATAR_PATH_FORMAT, new Object[]{info.getAbsoluteDir(), formatFileName(name), info.mExtendName});
    }

    private static String getSavedFilePath(String oldPath) {
        ArrayList<String> existPaths = StorageUtils.getAllExistFilePath(StorageUtils.getLeafPath(oldPath));
        return existPaths.size() > 0 ? (String) existPaths.get(0) : null;
    }

    private static String formatFileName(String name) {
        if (name == null) {
            return UNKNOWN_STRING;
        }
        return FileNameUtils.regulateFileName(name.trim(), "+");
    }

    public static File getAppointFile(String dirPath, String name) {
        return new File(new File(dirPath), name);
    }

    public static File getSavedMetaFile(String name, String metaType) {
        String path = getSavedFilePath(name, metaType);
        return path != null ? new File(path) : null;
    }

    public static File getMainSdcardMetaFile(String name, String metaType) {
        String path = getMainSdcardMetaFilePath(name, metaType);
        return path != null ? new File(path) : null;
    }

    public static ArrayList<File> getAllSdcardMetaFile(String name, String metaType) {
        String path = getMainSdcardMetaFilePath(name, metaType);
        return path != null ? StorageUtils.getAllSdcardFile(StorageUtils.getLeafPath(path)) : null;
    }

    public static String getSavedFilePath(String name, String metaType) {
        String path = getMainSdcardMetaFilePath(name, metaType);
        return path != null ? getSavedFilePath(path) : null;
    }

    public static String getMainSdcardMetaFilePath(String name, String metaType) {
        File dir = getMetaDir(metaType);
        return dir != null ? new File(dir, name).getAbsolutePath() : null;
    }

    public static ArrayList<String> getAllSdcardMetaFilePath(String name, String metaType) {
        return StorageUtils.getAllSdcardFilePath(StorageUtils.getLeafPath(getMainSdcardMetaFilePath(name, metaType)));
    }

    public static File getSavedFile(String first, String second, String metaType) {
        String path = getSavedFilePath(first, second, metaType);
        return path != null ? new File(path) : null;
    }

    public static File getMainSdcardFile(String first, String second, String metaType) {
        String path = getMainSdcardFilePath(first, second, metaType);
        return path != null ? new File(path) : null;
    }

    public static ArrayList<File> getAllSdcardFile(String first, String second, String metaType) {
        String path = getMainSdcardFilePath(first, second, metaType);
        return path != null ? StorageUtils.getAllSdcardFile(StorageUtils.getLeafPath(path)) : null;
    }

    public static File getSavedAvatarFile(String name) {
        String path = getSavedAvatarFilePath(name);
        return path != null ? new File(path) : null;
    }

    public static File getMainSdcardAvatarFile(String name) {
        String path = getMainSdcardAvatarFilePath(name);
        return path != null ? new File(path) : null;
    }

    public static File getAllSdcardAvatarFile(String name) {
        String path = getSavedAvatarFilePath(name);
        return path != null ? new File(path) : null;
    }

    public static File getMetaDir(String metaType) {
        return new File(((MetaInfo) META_TYPE_MAP.get(metaType)).getAbsoluteDir());
    }

    public static void deleteMetaFiles(String title, String album, String artist) {
        Iterator i$;
        ArrayList<File> lyricFiles = getAllSdcardFile(title, artist, "lyric");
        if (lyricFiles != null) {
            i$ = lyricFiles.iterator();
            while (i$.hasNext()) {
                File lyricFile = (File) i$.next();
                if (lyricFile.exists()) {
                    lyricFile.delete();
                }
            }
        }
        ArrayList<File> albumFiles = getAllSdcardFile(album, artist, "album");
        if (albumFiles != null) {
            i$ = albumFiles.iterator();
            while (i$.hasNext()) {
                File albumFile = (File) i$.next();
                if (albumFile.exists()) {
                    albumFile.delete();
                }
            }
        }
    }

    public static File getAlbumFile(String title, String artist, String songPath) {
        File albumFile = getSavedFile(title, artist, "album");
        if (albumFile != null) {
            return albumFile;
        }
        if (songPath != null) {
            String localAlbumPath = replaceExtName(songPath, ((MetaInfo) META_TYPE_MAP.get("album")).mExtendName);
            if (localAlbumPath != null && new File(localAlbumPath).exists()) {
                String destFileName = getMetaFileName(title, artist, "album");
                FileOperations.copyFile(localAlbumPath, destFileName);
                return new File(destFileName);
            }
        }
        return null;
    }

    private static String replaceExtName(String src, String extName) {
        int lastDot = src.lastIndexOf(".") + 1;
        if (lastDot < 0 || lastDot >= src.length()) {
            return null;
        }
        return src.substring(0, lastDot) + extName;
    }

    public static File getLyricFile(String title, String artist, String songPath) {
        if (songPath != null) {
            String localLyricPath = replaceExtName(songPath, ((MetaInfo) META_TYPE_MAP.get("lyric")).mExtendName);
            if (localLyricPath != null) {
                File autoLyricFile = new File(localLyricPath);
                if (autoLyricFile.exists()) {
                    return autoLyricFile;
                }
            }
        }
        return getSavedFile(title, artist, "lyric");
    }

    public static CharSequence getLocaleAlbumName(Context context, CharSequence src) {
        if (!isUnknowName(src) || UNKNOWN_STRING.equals(src)) {
            return src;
        }
        if (sUnknownAlbumName != null) {
            return sUnknownAlbumName;
        }
        sUnknownAlbumName = context.getText(C0329R.string.unknown_album_name);
        return sUnknownAlbumName;
    }

    public static CharSequence getLocaleArtistName(Context context, CharSequence src) {
        if (!isUnknowName(src) || UNKNOWN_STRING.equals(src)) {
            return src;
        }
        if (sUnknownArtistName != null) {
            return sUnknownArtistName;
        }
        sUnknownArtistName = context.getText(C0329R.string.unknown_artist_name);
        return sUnknownArtistName;
    }

    public static String getRawName(String src) {
        return isUnknowName(src) ? UNKNOWN_STRING : src;
    }

    public static boolean isUnknowName(CharSequence src) {
        return src == null || UNKNOWN_STRING.equals(src) || SYS_UNKNOWN_STRING.equals(src);
    }

    public static String[] getAllSortedDownloadedMP3Names() {
        ArrayList<String> dirList = new ArrayList();
        for (String musicType : META_TYPE_MP3_ALL) {
            dirList.addAll(StorageUtils.getAllSdcardFilePath(StorageUtils.getLeafPath(getMetaDir(musicType).getAbsolutePath())));
        }
        return FileOperations.getSortedFilePathArr(dirList);
    }

    public static Set<String> getExistImageSet(String metaType) {
        Set<String> set = new HashSet();
        File dir = getMetaDir(metaType);
        if (dir != null) {
            Iterator i$ = StorageUtils.getAllSdcardFilePath(StorageUtils.getLeafPath(dir.getAbsolutePath())).iterator();
            while (i$.hasNext()) {
                String[] list = new File((String) i$.next()).list();
                if (list != null) {
                    set.addAll(Arrays.asList(list));
                }
            }
        }
        return set;
    }

    public static String getMetaType(ImageSearchInfo info) {
        switch (info.mSearchType) {
            case 0:
                return StorageConfig.META_TYPE_AVATAR;
            case 1:
                return "album";
            default:
                return null;
        }
    }

    public static File getSavedFile(ImageSearchInfo info) {
        switch (info.mSearchType) {
            case 0:
                return getSavedAvatarFile(info.mArtistName);
            case 1:
                return getSavedFile(info.mAlbumName, info.mArtistName, getMetaType(info));
            default:
                return null;
        }
    }

    public static File getMainSdcardFile(ImageSearchInfo info) {
        switch (info.mSearchType) {
            case 0:
                return getMainSdcardAvatarFile(info.mArtistName);
            case 1:
                return getMainSdcardFile(info.mAlbumName, info.mArtistName, getMetaType(info));
            default:
                return null;
        }
    }

    public static List<AudioLink> getAudioLink(List<AudioLink> linkList, int quality) {
        int maxBitRate;
        Collections.sort(linkList, new C03541());
        int startIndex = 0;
        switch (quality) {
            case 0:
                maxBitRate = StorageConfig.BIT_RATE_UHD;
                break;
            case 1:
                maxBitRate = 192;
                break;
            default:
                maxBitRate = 128;
                break;
        }
        for (int i = 0; i < linkList.size(); i++) {
            if (((AudioLink) linkList.get(i)).mBitrate < maxBitRate) {
                startIndex = i;
                return linkList.subList(startIndex, linkList.size());
            }
        }
        return linkList.subList(startIndex, linkList.size());
    }
}
