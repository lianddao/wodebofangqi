package cn.ldm.player.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import cn.ldm.player.Config;
import cn.ldm.player.R;
import cn.ldm.player.loader.PlaylistLoader;
import cn.ldm.player.model.Playlist;
import cn.ldm.player.player.MediaPlayerAdapter;

/**
 * Created by LDM on 2018.01.22.0022.
 */

public class FireMissilesDialogFragment extends DialogFragment {
    private static final String TAG = FireMissilesDialogFragment.class.getSimpleName();

    String _selectedMusicId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _selectedMusicId = getArguments().getString("MUSIC-ID");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final ArrayAdapter<Playlist> arrayAdapter = new ArrayAdapter<Playlist>(getActivity(), android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(new PlaylistLoader(getActivity()).loadInBackground());
        builder.setTitle("添加到播放列表")
                .setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick: 你点击了" + which);
                        long insertId = Long.valueOf(MediaPlayerAdapter._filterMediaId(_selectedMusicId));
                        long playlistId = arrayAdapter.getItem(which).mPlaylistId;
                        Log.i(TAG, insertId + "将要加入播放列表" + playlistId);
                        addToPlaylist(getContext(), new long[]{insertId}, arrayAdapter.getItem(which).mPlaylistId);
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick: 干他!");
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick: 不想打了");
                    }
                });
        return builder.create();
    }

    public static void addToPlaylist(final Context context, final long[] ids, final long playlistId) {
        if (playlistId < 0) {
            throw new RuntimeException("自带播放列表尚未在手机中创建");
        }
        final int size = ids.length;
        final ContentResolver resolver = context.getContentResolver();
        final String[] projection = new String[]{"max(" + MediaStore.Audio.Playlists.Members.PLAY_ORDER + ")",};
        final Uri uri = MediaStore.Audio.Playlists.Members.getContentUri("external", playlistId);
        Cursor cursor = null;
        int base = 0;

        try {
            cursor = resolver.query(uri, projection, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                base = cursor.getInt(0) + 1;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
        }

        int numInserted = 0;
        for (int offSet = 0; offSet < size; offSet += 1000) {
            makeInsertItems(ids, offSet, 1000, base);
            numInserted += resolver.bulkInsert(uri, mContentValuesCache);
        }
        Log.i(TAG, "addToPlaylist: " + "共影响了" + numInserted + "行数据");
        final String message = context.getResources().getQuantityString(R.plurals.NNNtrackstoplaylist, numInserted, numInserted);
        Toast.makeText((Activity) context, message, Toast.LENGTH_SHORT).show();
        //播放列表 change
    }

    private static ContentValues[] mContentValuesCache;

    public static void makeInsertItems(final long[] ids, final int offset, int len, final int base) {
        //if 0+100>10
        // len=10-0
        if (offset + len > ids.length) {
            len = ids.length - offset;
        }

        if (mContentValuesCache == null || mContentValuesCache.length != len) {
            mContentValuesCache = new ContentValues[len];//new 10[]
        }
        //for i=0;i<10
        for (int i = 0; i < len; i++) {
            if (mContentValuesCache[i] == null) {
                mContentValuesCache[i] = new ContentValues();
            }
            mContentValuesCache[i].put(MediaStore.Audio.Playlists.Members.PLAY_ORDER, base + offset + i);//xx[i].put()
            mContentValuesCache[i].put(MediaStore.Audio.Playlists.Members.AUDIO_ID, ids[offset + i]);
        }
    }
}
