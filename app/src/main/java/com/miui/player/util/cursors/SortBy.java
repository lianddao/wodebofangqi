package com.miui.player.util.cursors;

import android.database.Cursor;
import android.text.TextUtils;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.util.IDeviceCompat;

public class SortBy {
    public static final String SORT_LOCALE = "LOCALIZED";

    public interface SortColumn {
        Object get(Cursor cursor);
    }

    public static class LocaleSortColumn implements SortColumn {
        private final int mSortIndex;
        private final IDeviceCompat mWrapper = ApplicationHelper.instance().getDeviceCompat();

        public LocaleSortColumn(int sortIndex) {
            this.mSortIndex = sortIndex;
        }

        public Object get(Cursor cursor) {
            return this.mWrapper.getSortKey(cursor.getString(this.mSortIndex));
        }
    }

    public static class SortArguments {
        public final boolean mAsc;
        public final String mCollate;
        public final int mSortIndex;

        public SortArguments(int sortIndex, String collate, boolean asc) {
            this.mSortIndex = sortIndex;
            this.mCollate = collate;
            this.mAsc = asc;
        }

        public boolean isValid() {
            return this.mSortIndex >= 0;
        }

        public String toString() {
            return "asc=" + this.mAsc + ", sortIndex=" + this.mSortIndex + ", collate=" + this.mCollate;
        }
    }

    public static SortArguments parseSortArguments(String sortOrder, String[] columns) {
        if (sortOrder == null || columns == null) {
            return null;
        }
        sortOrder = sortOrder.trim();
        if (TextUtils.isEmpty(sortOrder)) {
            return null;
        }
        int i;
        boolean asc;
        String collate;
        int sortIndex = -1;
        String[] segments = sortOrder.split(" ");
        int len = 0;
        for (i = 0; i < segments.length; i++) {
            if (segments[i].trim().length() > 0) {
                int len2 = len + 1;
                segments[len] = segments[i];
                len = len2;
            }
        }
        if ("DESC".equalsIgnoreCase(segments[len - 1])) {
            asc = false;
        } else {
            asc = true;
        }
        int collateSegment = len;
        for (i = 0; i < len; i++) {
            if ("COLLATE".equalsIgnoreCase(segments[i])) {
                collateSegment = i;
                break;
            }
        }
        if (collateSegment + 1 < len) {
            collate = segments[collateSegment + 1];
        } else {
            collate = null;
        }
        String sort = segments[0];
        for (i = 0; i < columns.length; i++) {
            if (sort.equals(columns[i])) {
                sortIndex = i;
                break;
            }
        }
        return new SortArguments(sortIndex, collate, asc);
    }
}
