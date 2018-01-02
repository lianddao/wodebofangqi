package com.miui.player.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.meta.MetaManager;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.provider.PlayerStore.Statistics;
import com.miui.player.service.ServiceHelper;
import com.miui.player.util.FolderProvider;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.SqlUtils.SQLArguments;
import com.miui.player.util.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DeleteItems {
    public static final String KEY_DELETE_COUNT = "delete_count";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_ITEM_ID_ARR = "item_ids";
    public static final String KEY_ITEM_PATH_ARR = "item_paths";
    static final String TAG = DeleteItems.class.getCanonicalName();
    final Activity mActivity;
    private OnClickListener mButtonClicked = new C04301();
    final DialogCallback mCallback;
    final String mDescript;
    final int mRequestCode;
    final DeleteWorker mWorker;

    class C04301 implements OnClickListener {
        C04301() {
        }

        public void onClick(DialogInterface dialog, int which) {
            boolean confirm = false;
            int count = 0;
            if (which == -1) {
                confirm = true;
                if (DeleteItems.this.mWorker != null) {
                    Context context = DeleteItems.this.mActivity;
                    count = DeleteItems.this.mWorker.delete(context);
                    Toast.makeText(context, context.getResources().getQuantityString(C0329R.plurals.NNNtracksdeleted, count, new Object[]{Integer.valueOf(count)}), 0).show();
                }
            }
            if (DeleteItems.this.mCallback != null) {
                DeleteItems.this.mCallback.onDialogResult(DeleteItems.this.mRequestCode, confirm, new Intent().putExtra(DeleteItems.KEY_DELETE_COUNT, count));
            }
        }
    }

    interface DeleteWorker {
        int delete(Context context);
    }

    static class ComposedDeleteWorker implements DeleteWorker {
        private final List<DeleteWorker> mList = new ArrayList();

        ComposedDeleteWorker() {
        }

        public void add(DeleteWorker worker) {
            this.mList.add(worker);
        }

        public int delete(Context context) {
            long c = System.currentTimeMillis();
            int count = 0;
            for (DeleteWorker worker : this.mList) {
                if (worker != null) {
                    count += worker.delete(context);
                }
            }
            Utils.debugLog(DeleteItems.TAG, "Consume " + (System.currentTimeMillis() - c) + " to delete " + count + " records");
            return count;
        }
    }

    static class ListDeleteWorker implements DeleteWorker {
        private final long[] mList;

        public ListDeleteWorker(long[] list) {
            this.mList = list;
        }

        public int delete(Context context) {
            return DeleteItems.deleteTracks(context, this.mList);
        }
    }

    static class PathDeleteWorker implements DeleteWorker {
        private final ArrayList<String> mPathList;

        public PathDeleteWorker(ArrayList<String> pathList) {
            this.mPathList = pathList;
        }

        public int delete(Context context) {
            return DeleteItems.deleteTrackByPathList(context, this.mPathList);
        }
    }

    public DeleteItems(Activity a, Bundle b, DialogCallback l, int requestCode) {
        this.mActivity = a;
        this.mCallback = l;
        this.mRequestCode = requestCode;
        this.mDescript = b.getString("description");
        this.mWorker = createDeleteWorker(b);
    }

    public void show() {
        new Builder(this.mActivity).setCancelable(true).setIconAttribute(16843605).setTitle(C0329R.string.delete_item).setPositiveButton(C0329R.string.confirm, this.mButtonClicked).setNegativeButton(C0329R.string.cancel, null).setMessage(this.mDescript).create().show();
    }

    private static DeleteWorker createDeleteWorker(Bundle bundle) {
        ComposedDeleteWorker worker = new ComposedDeleteWorker();
        long[] list = bundle.getLongArray(KEY_ITEM_ID_ARR);
        if (list != null) {
            worker.add(new ListDeleteWorker(list));
        }
        ArrayList<String> pathList = bundle.getStringArrayList(KEY_ITEM_PATH_ARR);
        if (pathList != null) {
            worker.add(new PathDeleteWorker(pathList));
        }
        return worker;
    }

    public static int deleteTracks(Context context, long[] list) {
        int deletedCount = 0;
        String[] cols = new String[]{"_id", "_data", "album_id", "artist", "title", "album"};
        String idSet = SqlUtils.concatAsSet(list);
        String where = "_id IN " + idSet;
        ContentResolver res = context.getContentResolver();
        Cursor c = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, cols, where, null, null);
        if (c != null) {
            int artistCol = c.getColumnIndex("artist");
            int titleCol = c.getColumnIndex("title");
            int albumCol = c.getColumnIndex("album");
            int dataCol = c.getColumnIndex("_data");
            while (c.moveToNext()) {
                String title = c.getString(titleCol);
                String str = title;
                MetaManager.deleteMetaFiles(str, c.getString(albumCol), c.getString(artistCol));
                ServiceHelper.removeQueueItem(c.getLong(0));
                c.moveToNext();
            }
            res.delete(Media.EXTERNAL_CONTENT_URI, where.toString(), null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                String name = c.getString(dataCol);
                try {
                    Utils.debugLog(TAG, "delete " + name);
                    if (new File(name).delete()) {
                        deletedCount++;
                    } else {
                        Log.e("MusicUtils", "Failed to delete file " + name);
                    }
                } catch (SecurityException e) {
                } catch (Throwable th) {
                    c.moveToNext();
                }
                c.moveToNext();
            }
            c.close();
        }
        ContentResolver contentResolver = res;
        contentResolver.delete(MiuiPlaylistsAudioMap.EXTERNAL_URI, "audio_id IN " + idSet, null);
        FavoriteCache.remove(context, list);
        contentResolver = res;
        contentResolver.delete(Statistics.EXTERNAL_URI, "audio_id IN " + idSet, null);
        if (deletedCount > 0) {
            FolderProvider.markForceUpdate();
        }
        return deletedCount;
    }

    static int deleteTrackByPathList(Context context, ArrayList<String> pathList) {
        if (pathList == null || pathList.isEmpty()) {
            return 0;
        }
        SQLArguments argument = SqlUtils.concatStringFilter("_data", pathList, " OR ");
        if (argument == null) {
            return 0;
        }
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, argument.mSelection, argument.mArgs, null);
        if (cursor == null) {
            return 0;
        }
        try {
            long[] list = new long[cursor.getCount()];
            int i = 0;
            while (cursor.moveToNext()) {
                int i2 = i + 1;
                list[i] = cursor.getLong(0);
                i = i2;
            }
            int deleteTracks = deleteTracks(context, list);
            return deleteTracks;
        } finally {
            cursor.close();
        }
    }

    public static void show(Activity a, long[] audioIds, ArrayList<String> onlinePaths, int actualCount, DialogCallback clbk, int requestCode) {
        if ((audioIds == null || audioIds.length == 0) && (onlinePaths == null || onlinePaths.isEmpty())) {
            UIHelper.toastSafe(a.getResources().getQuantityString(C0329R.plurals.NNNtracksdeleted, actualCount, new Object[]{Integer.valueOf(actualCount)}));
            return;
        }
        Bundle b = new Bundle();
        b.putLongArray(KEY_ITEM_ID_ARR, audioIds);
        b.putStringArrayList(KEY_ITEM_PATH_ARR, onlinePaths);
        String f = a.getString(C0329R.string.delete_song_desc);
        String numMsg = a.getResources().getQuantityString(C0329R.plurals.Ntracks_string, actualCount, new Object[]{Integer.valueOf(actualCount)});
        b.putString("description", String.format(f, new Object[]{numMsg}));
        new DeleteItems(a, b, clbk, requestCode).show();
    }
}
