package com.miui.player.util;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Audio.Media;
import com.baidu.music.download.db.DBConfig;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.util.SectionCursor.SortKeyGetter;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class FolderProvider {
    static final String[] DEFAULT_UNSELECTED_FOLDER = new String[]{ApplicationHelper.instance().getDeviceCompat().getMIUIExternalStorageDirectory().getAbsolutePath() + "/sound_recorder/", ApplicationHelper.instance().getDeviceCompat().getMIUIExternalStorageDirectory().getAbsolutePath() + "/sound_recorder/call_rec/", ApplicationHelper.instance().getDeviceCompat().getMIUIExternalStorageDirectory().getAbsolutePath() + "/sound_recorder/fm_rec/", ApplicationHelper.instance().getDeviceCompat().getMIUIExternalStorageDirectory().getAbsolutePath() + "/ringtone/"};
    private static final String TAG = FolderProvider.class.getName();
    public static final int UPDATE_VERSION_START = 0;
    private static final FolderItemComparator sComparator = new FolderItemComparator();
    private static FolderProvider sInstance = null;
    private static final FolderStatusComparator sStatusComparator = new FolderStatusComparator();
    private FolderItem[] mFolderItemList = null;
    private boolean mHasMiuiDownload = false;
    private final FolderPrefParser mParser = new FolderPrefParser();
    private int mUpdateVersion;

    public interface Columns {
        public static final String[] ALL_COLUMNS = new String[]{"_id", "title", "path", COUNT, "status"};
        public static final String COUNT = "count";
        public static final String PATH = "path";
        public static final int SORT_KEY_IDX = FolderProvider.findSortKey();
        public static final String STATUS = "status";
        public static final String TITLE = "title";
        public static final String _ID = "_id";
    }

    public static class FolderItem {
        final String mFolderName;
        final String mFolderPath;
        boolean mSelected;
        final String mSortKey = ApplicationHelper.instance().getDeviceCompat().getSortKey(this.mFolderName);
        int mTrackCount;

        public FolderItem(String path, int trackCount, boolean selected) {
            this.mFolderPath = path;
            this.mFolderName = FolderProvider.parseFolderName(path);
            this.mTrackCount = trackCount;
            this.mSelected = selected;
        }

        public int getTrackCount() {
            return this.mTrackCount;
        }

        public String getFolderName() {
            return this.mFolderName;
        }
    }

    static class FolderItemComparator implements Comparator<FolderItem> {
        FolderItemComparator() {
        }

        public int compare(FolderItem first, FolderItem second) {
            return first.mSortKey.compareTo(second.mSortKey);
        }
    }

    static class FolderItemKeyGetter implements SortKeyGetter {
        FolderItemKeyGetter() {
        }

        public String get(Object src) {
            return ((FolderItem) src).mSortKey;
        }
    }

    static class FolderPrefParser {
        private String mLastJson = null;
        private String mUnselectedFolderSet = null;
        private String[] mUnselectedFolders = null;

        FolderPrefParser() {
        }

        private void update(Context context) {
            boolean changed = false;
            String current = PreferenceCache.getPrefAsString(context, PreferenceCache.PREF_FOLDERS_UNSELECTED);
            if (current == null) {
                this.mUnselectedFolders = FolderProvider.DEFAULT_UNSELECTED_FOLDER;
                changed = true;
            } else if (!current.equals(this.mLastJson)) {
                this.mUnselectedFolders = FolderProvider.parseUnselectedFolders(current);
                changed = true;
            }
            if (changed) {
                String like = SqlUtils.pathLikeWhere(Arrays.asList(this.mUnselectedFolders), "_data");
                this.mUnselectedFolderSet = like != null ? " NOT " + like : null;
                this.mLastJson = current;
            }
        }

        public String[] getUnselectedFolders(Context context) {
            update(context);
            return this.mUnselectedFolders;
        }

        public String getUnselectedFoldersAsSet(Context context) {
            update(context);
            return this.mUnselectedFolderSet;
        }
    }

    public static class FolderStatus {
        public final String mFolderPath;
        public boolean mSelected;
        public final String mSortKey;

        public FolderStatus(String path, boolean selected) {
            this.mFolderPath = path;
            this.mSortKey = path.toLowerCase();
            this.mSelected = selected;
        }
    }

    static class FolderStatusComparator implements Comparator<FolderStatus> {
        FolderStatusComparator() {
        }

        public int compare(FolderStatus first, FolderStatus second) {
            return first.mSortKey.compareTo(second.mSortKey);
        }
    }

    static {
        Arrays.sort(DEFAULT_UNSELECTED_FOLDER);
    }

    private FolderProvider(Context context) {
        doUpdateFolderItemList(context);
        this.mUpdateVersion = 0;
    }

    static int findSortKey() {
        for (int i = 0; i < Columns.ALL_COLUMNS.length; i++) {
            if (Columns.ALL_COLUMNS[i].endsWith("title")) {
                return i;
            }
        }
        return -1;
    }

    public FolderStatus[] getAllFolderStatus(Context context) {
        updateFolderItemList(context);
        FolderItem[] folders = this.mFolderItemList;
        FolderStatus[] statusArr = new FolderStatus[folders.length];
        for (int i = 0; i < folders.length; i++) {
            FolderItem folder = folders[i];
            statusArr[i] = new FolderStatus(folder.mFolderPath, folder.mSelected);
        }
        Arrays.sort(statusArr, sStatusComparator);
        return statusArr;
    }

    public FolderItem queryFolderItem(Context context, String folderPath) {
        if (folderPath == null) {
            return null;
        }
        updateFolderItemList(context);
        for (FolderItem item : this.mFolderItemList) {
            if (folderPath.equals(item.mFolderPath)) {
                return item;
            }
        }
        return null;
    }

    public boolean containsMiuiDownload(Context context) {
        updateFolderItemList(context);
        return this.mHasMiuiDownload;
    }

    public int getSelectedFolderCount(Context context) {
        updateFolderItemList(context);
        int count = 0;
        for (FolderItem item : this.mFolderItemList) {
            if (item.mSelected && item.mTrackCount > 0) {
                count++;
            }
        }
        return count;
    }

    public Cursor querySelectedFolders(Context context) {
        updateFolderItemList(context);
        FolderItem[] folders = this.mFolderItemList;
        String[] columns = Columns.ALL_COLUMNS;
        Object[][] array = new Object[folders.length][];
        int i = 0;
        for (FolderItem folder : folders) {
            if (folder.mSelected && folder.mTrackCount > 0) {
                Object[] record = new Object[columns.length];
                record[0] = Integer.valueOf(i);
                record[1] = folder.mFolderName;
                record[2] = folder.mFolderPath;
                record[3] = Integer.valueOf(folder.mTrackCount);
                record[4] = Integer.valueOf(folder.mSelected ? 1 : 0);
                array[i] = record;
                i++;
            }
        }
        return SectionCursor.wrap(array, i, columns, SectionCursor.collectSectionInfo(folders, new FolderItemKeyGetter(), containsMiuiDownload(context) ? 1 : 0));
    }

    private void markForceUpdateInternel() {
        this.mFolderItemList = null;
    }

    public boolean updateFolderItemSelected(Context context, FolderStatus[] statusArr) {
        FolderItem[] list = this.mFolderItemList;
        if (list == null || list.length != statusArr.length) {
            return false;
        }
        boolean changed = false;
        for (FolderItem folder : list) {
            String path = folder.mFolderPath;
            FolderStatus[] arr$ = statusArr;
            int len$ = arr$.length;
            int i$ = 0;
            while (i$ < len$) {
                FolderStatus s = arr$[i$];
                if (s.mFolderPath.equals(path)) {
                    if (s.mSelected != folder.mSelected) {
                        folder.mSelected = s.mSelected;
                        changed = true;
                    }
                } else {
                    i$++;
                }
            }
        }
        if (!changed) {
            return changed;
        }
        PreferenceCache.setPrefAsString(context, PreferenceCache.PREF_FOLDERS_UNSELECTED, getFoldersPersistStr(list));
        this.mUpdateVersion++;
        return changed;
    }

    public String[] getUnselectedFolders(Context context) {
        return this.mParser.getUnselectedFolders(context);
    }

    public String getUnselectedFoldersAsSet(Context context) {
        return this.mParser.getUnselectedFoldersAsSet(context);
    }

    public int forceUpdate(Context context) {
        markForceUpdateInternel();
        return updateFolderItemList(context);
    }

    public int updateFolderItemList(Context context) {
        if (doUpdateFolderItemList(context)) {
            this.mUpdateVersion++;
        }
        return this.mUpdateVersion;
    }

    public boolean doUpdateFolderItemList(Context context) {
        if (this.mFolderItemList != null) {
            return false;
        }
        long c = System.currentTimeMillis();
        FolderItem[] list = collectFolderItemList(context, this.mParser);
        this.mHasMiuiDownload = sort(list);
        this.mFolderItemList = list;
        Utils.debugLog(TAG, "interval for update folder item " + (System.currentTimeMillis() - c));
        return true;
    }

    private static FolderItem[] collectFolderItemList(Context context, FolderPrefParser parser) {
        Cursor cursor = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "duration", DBConfig.SIZE}, null, null, null);
        if (cursor == null) {
            return new FolderItem[0];
        }
        try {
            String[] unselectFolders = parser.getUnselectedFolders(context);
            Map<String, FolderItem> itemMap = new HashMap();
            while (cursor.moveToNext()) {
                String folderPath = parseFolderPath(cursor.getString(0));
                if (folderPath != null) {
                    FolderItem item = (FolderItem) itemMap.get(folderPath);
                    if (item == null) {
                        item = new FolderItem(folderPath, 0, Arrays.binarySearch(unselectFolders, folderPath) < 0);
                        itemMap.put(folderPath, item);
                    }
                    if (SqlUtils.notFilteredByDuration(context, cursor.getInt(1)) && SqlUtils.notFilteredBySize(context, cursor.getInt(2))) {
                        item.mTrackCount++;
                    }
                }
            }
            FolderItem[] list = new FolderItem[itemMap.size()];
            itemMap.values().toArray(list);
            return list;
        } finally {
            cursor.close();
        }
    }

    private static boolean sort(FolderItem[] folders) {
        if (folders == null || folders.length == 0) {
            return false;
        }
        int i = 0;
        while (i < folders.length && !StorageConfig.isMiuiMp3DownloadPath(folders[i].mFolderPath)) {
            i++;
        }
        if (i < folders.length) {
            FolderItem temp = folders[0];
            folders[0] = folders[i];
            folders[i] = temp;
            Arrays.sort(folders, 1, folders.length, sComparator);
        } else {
            Arrays.sort(folders, sComparator);
        }
        if (i >= folders.length) {
            return false;
        }
        return true;
    }

    private static String parseFolderPath(String filePath) {
        int index = filePath.lastIndexOf(File.separator);
        return index > 0 ? filePath.substring(0, index + 1) : null;
    }

    static String parseFolderName(String path) {
        int last = path.lastIndexOf(File.separator);
        if (last < 0) {
            return path;
        }
        int start = path.substring(0, last).lastIndexOf(File.separator) + 1;
        return start > 0 ? path.substring(start, last) : path;
    }

    static String[] parseUnselectedFolders(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            int len = jsonArray.length();
            String[] folder = new String[len];
            for (int i = 0; i < len; i++) {
                folder[i] = jsonArray.getString(i);
            }
            Arrays.sort(folder);
            return folder;
        } catch (JSONException e) {
            return DEFAULT_UNSELECTED_FOLDER;
        }
    }

    private static String getFoldersPersistStr(FolderItem[] folders) {
        if (folders == null || folders.length == 0) {
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        for (FolderItem folder : folders) {
            if (!folder.mSelected) {
                jsonArray.put(folder.mFolderPath);
            }
        }
        for (String defaultFolder : DEFAULT_UNSELECTED_FOLDER) {
            boolean exist = false;
            for (FolderItem folder2 : folders) {
                if (folder2.mFolderPath.equals(defaultFolder)) {
                    exist = true;
                }
            }
            if (!exist) {
                jsonArray.put(defaultFolder);
            }
        }
        return jsonArray.toString();
    }

    public static long[] queryTrackListForFolder(Context context, String[] pathArr) {
        if (pathArr == null || pathArr.length == 0) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, SqlUtils.wrapWithBlacklist(context, SqlUtils.pathLikeWhere(Arrays.asList(pathArr), "_data")), null, "title");
        if (cursor == null) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        try {
            long[] idsForCursor = SqlUtils.getIdsForCursor(cursor, 0);
            return idsForCursor;
        } finally {
            cursor.close();
        }
    }

    public static synchronized FolderProvider instance(Context context) {
        FolderProvider folderProvider;
        synchronized (FolderProvider.class) {
            if (sInstance == null) {
                sInstance = new FolderProvider(context);
            }
            folderProvider = sInstance;
        }
        return folderProvider;
    }

    public static synchronized int updateFolderItemListIfNeeded(Context context) {
        int updateFolderItemList;
        synchronized (FolderProvider.class) {
            if (sInstance != null) {
                updateFolderItemList = sInstance.updateFolderItemList(context);
            } else {
                updateFolderItemList = 0;
            }
        }
        return updateFolderItemList;
    }

    public static synchronized void markForceUpdate() {
        synchronized (FolderProvider.class) {
            if (sInstance != null) {
                sInstance.markForceUpdateInternel();
            }
        }
    }
}
