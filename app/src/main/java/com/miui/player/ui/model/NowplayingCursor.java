package com.miui.player.ui.model;

import android.content.Context;
import android.content.CursorLoader;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteException;
import android.provider.MediaStore.Audio.Media;
import com.miui.player.meta.MetaManager;
import com.miui.player.provider.PlayerStore.MiuiNowPlayingAudio;
import com.miui.player.service.ServiceHelper;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Utils;
import com.miui.player.util.cursors.ColumnMappedCursor;
import java.util.Arrays;

public class NowplayingCursor extends AbstractCursor {
    private static final String TAG = NowplayingCursor.class.getCanonicalName();
    private final String[] mCols;
    private final int mCommonLen;
    private final Context mContext;
    private int mCurPos;
    private long[] mCursorIdxs;
    private final int mLocalLen;
    private Cursor mMergeCursor;
    private long[] mNowplaying;
    private final int mOnlineLen;
    private int mSize;

    private static class NowplayingLoader extends CursorLoader {
        private final String[] mColumnNames;
        private final int mCommonLen;
        private final int mLocalLen;
        private final int mOnlineLen;

        NowplayingLoader(Context context, String[] cols, int commonLen, int localLen, int onlineLen) {
            super(context);
            this.mColumnNames = cols;
            this.mCommonLen = commonLen;
            this.mLocalLen = localLen;
            this.mOnlineLen = onlineLen;
        }

        public Cursor loadInBackground() {
            return new NowplayingCursor(getContext(), this.mColumnNames, this.mCommonLen, this.mLocalLen, this.mOnlineLen);
        }
    }

    public NowplayingCursor(Context context, String[] cols, int commonLen, int localLen, int onlineLen) {
        this.mContext = context;
        this.mCols = cols;
        this.mCommonLen = commonLen;
        this.mLocalLen = localLen;
        this.mOnlineLen = onlineLen;
        makeNowPlayingCursor();
    }

    public void close() {
        if (this.mMergeCursor != null) {
            try {
                this.mMergeCursor.close();
            } catch (SQLiteException e) {
                Utils.debugLog(TAG, e.toString());
            } catch (Throwable th) {
                this.mMergeCursor = null;
            }
            this.mMergeCursor = null;
        }
    }

    private Cursor createOnlineNowplaying() {
        String[] onlineCols = new String[(this.mCommonLen + this.mOnlineLen)];
        System.arraycopy(this.mCols, 0, onlineCols, 0, this.mCommonLen);
        System.arraycopy(this.mCols, this.mCommonLen + this.mLocalLen, onlineCols, this.mCommonLen, this.mOnlineLen);
        Cursor cursor = this.mContext.getContentResolver().query(MiuiNowPlayingAudio.EXTERNAL_URI, onlineCols, null, null, "_id");
        if (cursor == null) {
            return null;
        }
        int i;
        int[] indexMap = new int[this.mCols.length];
        for (i = 0; i < this.mCommonLen; i++) {
            indexMap[i] = i;
        }
        for (i = this.mCommonLen; i < this.mCommonLen + this.mLocalLen; i++) {
            indexMap[i] = -1;
        }
        for (i = this.mCommonLen + this.mLocalLen; i < this.mCols.length; i++) {
            indexMap[i] = i - this.mLocalLen;
        }
        return new ColumnMappedCursor(cursor, this.mCols, indexMap);
    }

    private Cursor createLocalNowplaying() {
        String where = "_id IN " + SqlUtils.concatAsSet(this.mNowplaying);
        String[] localCols = new String[(this.mCommonLen + this.mLocalLen)];
        System.arraycopy(this.mCols, 0, localCols, 0, localCols.length);
        Cursor localCursor = SqlUtils.query(this.mContext, Media.EXTERNAL_CONTENT_URI, localCols, where, null, "_id");
        if (localCursor == null) {
            return null;
        }
        int i;
        int[] indexMap = new int[this.mCols.length];
        for (i = 0; i < this.mCommonLen + this.mLocalLen; i++) {
            indexMap[i] = i;
        }
        for (i = this.mCommonLen + this.mLocalLen; i < this.mCols.length; i++) {
            indexMap[i] = -1;
        }
        return new ColumnMappedCursor(localCursor, this.mCols, indexMap);
    }

    private void makeNowPlayingCursor() {
        if (!(this.mMergeCursor == null || this.mMergeCursor.isClosed())) {
            this.mMergeCursor.close();
        }
        this.mMergeCursor = null;
        this.mNowplaying = null;
        try {
            this.mNowplaying = ServiceHelper.getQueue();
        } catch (NullPointerException e) {
        }
        if (this.mNowplaying == null) {
            this.mNowplaying = new long[0];
        }
        this.mSize = this.mNowplaying.length;
        if (this.mSize != 0) {
            int i;
            Cursor localCursor = createLocalNowplaying();
            Cursor onlineCursor = createOnlineNowplaying();
            if (localCursor != null && onlineCursor == null) {
                this.mMergeCursor = localCursor;
            } else if (localCursor == null && onlineCursor != null) {
                this.mMergeCursor = onlineCursor;
            } else if (localCursor == null || onlineCursor == null) {
                this.mSize = 0;
                return;
            } else {
                this.mMergeCursor = new MergeCursor(new Cursor[]{localCursor, onlineCursor});
            }
            int size = this.mMergeCursor.getCount();
            this.mCursorIdxs = new long[size];
            this.mMergeCursor.moveToFirst();
            int colidx = this.mMergeCursor.getColumnIndexOrThrow("_id");
            for (i = 0; i < size; i++) {
                this.mCursorIdxs[i] = this.mMergeCursor.getLong(colidx);
                this.mMergeCursor.moveToNext();
            }
            this.mMergeCursor.moveToFirst();
            this.mCurPos = -1;
            int removed = 0;
            for (i = this.mNowplaying.length - 1; i >= 0; i--) {
                long trackid = this.mNowplaying[i];
                if (Arrays.binarySearch(this.mCursorIdxs, trackid) < 0) {
                    removed += ServiceHelper.removeQueueItem(trackid);
                }
            }
            if (removed > 0) {
                this.mNowplaying = ServiceHelper.getQueue();
                this.mSize = this.mNowplaying.length;
                if (this.mSize == 0) {
                    this.mCursorIdxs = null;
                }
            }
        }
    }

    public int getCount() {
        return this.mSize;
    }

    public boolean onMove(int oldPosition, int newPosition) {
        if (oldPosition == newPosition) {
            return true;
        }
        if (this.mNowplaying == null || this.mCursorIdxs == null) {
            return false;
        }
        if (this.mMergeCursor == null) {
            return true;
        }
        this.mMergeCursor.moveToPosition(Arrays.binarySearch(this.mCursorIdxs, this.mNowplaying[newPosition]));
        this.mCurPos = newPosition;
        return true;
    }

    public boolean removeItem(int which) {
        if (ServiceHelper.removeQueueTracks(which, which) == 0) {
            return false;
        }
        long[] nowplaying = this.mNowplaying;
        this.mSize--;
        for (int i = which; i < this.mSize; i++) {
            nowplaying[i] = nowplaying[i + 1];
        }
        onMove(-1, this.mCurPos);
        return true;
    }

    public boolean removeItem(int[] whichs) {
        if (ServiceHelper.removeQueueTracksBatch(whichs) == 0) {
            return false;
        }
        int oldSize = this.mSize;
        long[] nowplaying = this.mNowplaying;
        for (int i : whichs) {
            if (i < oldSize) {
                nowplaying[i] = -1;
            }
        }
        int n = 0;
        int m = 0;
        while (n < oldSize) {
            int m2;
            if (nowplaying[n] >= 0) {
                m2 = m + 1;
                nowplaying[m] = nowplaying[n];
            } else {
                m2 = m;
            }
            n++;
            m = m2;
        }
        this.mSize = m;
        onMove(-1, this.mCurPos);
        return true;
    }

    public void moveItem(int from, int to) {
        if (ServiceHelper.moveQueueItem(from, to)) {
            this.mNowplaying = ServiceHelper.getQueue();
            onMove(-1, this.mCurPos);
        }
    }

    public String getString(int column) {
        try {
            return this.mMergeCursor.getString(column);
        } catch (Exception e) {
            return MetaManager.UNKNOWN_STRING;
        }
    }

    public short getShort(int column) {
        return this.mMergeCursor.getShort(column);
    }

    public int getInt(int column) {
        try {
            return this.mMergeCursor.getInt(column);
        } catch (Exception e) {
            return 0;
        }
    }

    public long getLong(int column) {
        try {
            return this.mMergeCursor.getLong(column);
        } catch (Exception e) {
            return 0;
        }
    }

    public float getFloat(int column) {
        return this.mMergeCursor.getFloat(column);
    }

    public double getDouble(int column) {
        return this.mMergeCursor.getDouble(column);
    }

    public boolean isNull(int column) {
        return this.mMergeCursor.isNull(column);
    }

    public String[] getColumnNames() {
        return this.mCols;
    }

    public void deactivate() {
        if (this.mMergeCursor != null) {
            this.mMergeCursor.deactivate();
        }
    }

    public boolean requery() {
        makeNowPlayingCursor();
        return true;
    }

    public void finalize() {
        if (!(this.mMergeCursor == null || this.mMergeCursor.isClosed())) {
            this.mMergeCursor.close();
        }
        super.finalize();
    }

    public static CursorLoader createLoader(Context context, String[] columns, int commonLen, int localLen, int onlineLen) {
        return new NowplayingLoader(context, columns, commonLen, localLen, onlineLen);
    }
}
