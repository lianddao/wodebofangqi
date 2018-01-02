package com.miui.player.ui.menu;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask.Status;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.meta.MediaFileManager.MediaEditInfo;
import com.miui.player.meta.MediaFileManager.MediaEditInfoFactory;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.ID3Correcter;
import com.miui.player.network.ID3Correcter.AsyncCorrectID3Task;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.PlayerProvider;
import com.miui.player.provider.PlayerProviderUtils;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.menu.BaseTrackBrowserMenu.ContextInfo;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.StorageConfig;
import com.miui.player.util.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class TrackBrowserMenu extends BaseTrackBrowserMenu<Long> {
    private static final String TAG = TrackBrowserMenu.class.getName();
    private AsyncCorrectID3Task mCorrectAllID3Task = null;
    private final String mKeyColumn;
    private int mKeyIdx = -1;
    private final ContextInfoProvider mProvider;

    public interface ContextInfoProvider {
        ContextInfo<Long> getContextInfo();
    }

    public TrackBrowserMenu(Activity a, ContextInfoProvider provider, int msgId, String keyColumn) {
        super(a, msgId);
        this.mProvider = provider;
        this.mKeyColumn = keyColumn;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (Utils.isOnlineVaild()) {
            menu.add(1, 22, 0, C0329R.string.correct_id3_by_internet);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case BaseMenuId.CORRECT_ID3 /*22*/:
                Context context = this.mActivity.getApplicationContext();
                if (!ID3Correcter.isNetworkActive(context, true)) {
                    return true;
                }
                ContextInfo ctx = getContextInfo();
                if (!ctx.isValid()) {
                    return true;
                }
                Cursor cursor = ctx.mCursor;
                long[] audioIdList = SqlUtils.getIdsForCursor(cursor, PlayerProviderUtils.guessAudioIdColumnIndex(cursor));
                String[] playList = SqlUtils.getStringsForCursor(cursor, cursor.getColumnIndexOrThrow("_data"));
                if (this.mCorrectAllID3Task == null || this.mCorrectAllID3Task.getStatus() == Status.FINISHED) {
                    this.mCorrectAllID3Task = new AsyncCorrectID3Task(context, playList, audioIdList, false, true);
                    this.mCorrectAllID3Task.execute(new Void[0]);
                    return true;
                }
                Toast.makeText(context, C0329R.string.correct_id3_in_processing, 0).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected ContextInfo getContextInfo() {
        return this.mProvider.getContextInfo();
    }

    protected MenuTrace getMenuTrace(ContextInfo ctx, Set<Long> selected) {
        Cursor cursor = ctx.mCursor;
        int oldPos = cursor.getPosition();
        boolean hasLocal = false;
        boolean hasOnline = false;
        boolean hasUnfavorite = false;
        int memberIdIdx = cursor.getColumnIndexOrThrow("_id");
        int titleIdx = cursor.getColumnIndexOrThrow("title");
        int artistIdx = cursor.getColumnIndexOrThrow("artist");
        int audioIdIdx = cursor.getColumnIndex("audio_id");
        int onlineIdIdx = cursor.getColumnIndex("mi_online_id");
        if (MetaManager.getMetaDir(StorageConfig.META_TYPE_MP3).getAbsolutePath() == null) {
            return null;
        }
        String[] sortedFileNames = MetaManager.getAllSortedDownloadedMP3Names();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            long memberId = cursor.getLong(memberIdIdx);
            if (selected.contains(Long.valueOf(memberId))) {
                long audioId = memberId;
                if (audioIdIdx >= 0) {
                    audioId = cursor.getLong(audioIdIdx);
                }
                if (!(hasLocal && hasOnline)) {
                    boolean isLocal = true;
                    if (PlayerProvider.isOnlineAudio(audioId)) {
                        String name = MetaManager.getMetaFileName(cursor.getString(titleIdx), cursor.getString(artistIdx), StorageConfig.META_TYPE_MP3);
                        isLocal = (name == null || sortedFileNames == null || Arrays.binarySearch(sortedFileNames, name) < 0) ? false : true;
                    }
                    if (!hasLocal) {
                        hasLocal = isLocal;
                    }
                    if (!hasOnline) {
                        hasOnline = !isLocal;
                    }
                }
                if (!hasUnfavorite) {
                    String onlineId = null;
                    if (onlineIdIdx >= 0) {
                        onlineId = cursor.getString(onlineIdIdx);
                    }
                    hasUnfavorite = !FavoriteCache.contains(this.mActivity, audioId, onlineId);
                }
                if (hasLocal && hasOnline && hasUnfavorite) {
                    break;
                }
            }
            cursor.moveToNext();
        }
        MenuTrace trace = new MenuTrace();
        trace.mSize = selected.size();
        trace.mHasLocal = hasLocal;
        trace.mHasOnline = hasOnline;
        trace.mHasUnfavorite = hasUnfavorite;
        trace.mType = 3;
        cursor.moveToPosition(oldPos);
        return trace;
    }

    protected void addToPlaylist(ContextInfo ctx, long playlistId) {
        Cursor cursor = ctx.mCursor;
        long[] list = SqlUtils.getIdsForCursor(cursor, PlayerProviderUtils.guessAudioIdColumnIndex(cursor));
        if (list != null) {
            PlaylistHelper.addToPlaylistAsync(this.mActivity, list, playlistId, true, null);
        }
    }

    protected void addToPlaylist(ContextInfo ctx, long playlistId, Set<Long> selected) {
        PlaylistHelper.addToPlaylist(this.mActivity, getAudioIdArr(ctx, selected), playlistId, true);
    }

    protected MediaEditInfo[] collectTracksEditInfo(ContextInfo ctx, MenuTrace trace, MediaEditInfoFactory factory, Set<Long> selected) {
        long[] sortedOperands = null;
        int count = 0;
        if (trace.mType == 2) {
            count = ctx.mCursor.getCount();
        } else {
            sortedOperands = getAudioIdArr(ctx, selected);
            if (sortedOperands != null) {
                Arrays.sort(sortedOperands);
                count = sortedOperands.length;
            }
        }
        return collectTracksEditInfo(ctx.mCursor, factory, sortedOperands, count);
    }

    protected TrackRecordInfo findLocalAudioId(ContextInfo ctx, Set<Long> selected) {
        long memberId = ((Long) selected.iterator().next()).longValue();
        TrackRecordInfo info = null;
        Cursor cursor = ctx.mCursor;
        int oldPos = cursor.getPosition();
        int idIdx = cursor.getColumnIndex("_id");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getLong(idIdx) == memberId) {
                info = new TrackRecordInfo(memberId);
                info.mAudioId = cursor.getLong(PlayerProviderUtils.guessAudioIdColumnIndex(cursor));
                info.mTitle = cursor.getString(cursor.getColumnIndex("title"));
                info.mAlbum = cursor.getString(cursor.getColumnIndex("album"));
                info.mArtist = cursor.getString(cursor.getColumnIndex("artist"));
                info.mData = cursor.getString(cursor.getColumnIndex("_data"));
                info.mLocalAudioId = PlayerProviderUtils.getDownloadedAudioId(this.mActivity, info.mTitle, info.mArtist, info.mAudioId);
                break;
            }
            cursor.moveToNext();
        }
        cursor.moveToPosition(oldPos);
        return info;
    }

    protected long[] getAudioIdArr(ContextInfo ctx, Set<Long> selected) {
        Cursor cursor = ctx.mCursor;
        if (cursor == null || selected == null) {
            return null;
        }
        int oldPos = cursor.getPosition();
        int idx = cursor.getColumnIndex("_id");
        int audioIdIdx = PlayerProviderUtils.guessAudioIdColumnIndex(cursor);
        long[] ret = new long[selected.size()];
        int i = 0;
        boolean full = cursor.getCount() == selected.size();
        cursor.moveToFirst();
        while (!cursor.isAfterLast() && i < ret.length) {
            long memberId = cursor.getLong(idx);
            long audioId = cursor.getLong(audioIdIdx);
            if (!full) {
                if (!selected.contains(Long.valueOf(memberId))) {
                    cursor.moveToNext();
                }
            }
            int i2 = i + 1;
            ret[i] = audioId;
            i = i2;
            cursor.moveToNext();
        }
        cursor.moveToPosition(oldPos);
        return i < ret.length ? Arrays.copyOf(ret, i) : ret;
    }

    protected ArrayList<String> getOnlineAudioLocalPath(ContextInfo ctx, Set<Long> selected) {
        Cursor cursor = ctx.mCursor;
        if (cursor == null || selected == null) {
            return null;
        }
        int oldPos = cursor.getPosition();
        int audioIdIdx = PlayerProviderUtils.guessAudioIdColumnIndex(cursor);
        int titleIdx = cursor.getColumnIndex("title");
        int artistIdx = cursor.getColumnIndex("artist");
        ArrayList<String> onlinePath = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (PlayerProvider.isOnlineAudio(cursor.getLong(audioIdIdx))) {
                String path = MetaManager.getSavedFilePath(cursor.getString(titleIdx), cursor.getString(artistIdx), StorageConfig.META_TYPE_MP3);
                if (path != null) {
                    onlinePath.add(path);
                }
            }
            cursor.moveToNext();
        }
        cursor.moveToPosition(oldPos);
        return onlinePath;
    }

    protected void queue(ContextInfo ctx) {
        Cursor cursor = ctx.mCursor;
        ServiceHelper.addToCurrentPlaylist(this.mActivity, SqlUtils.getIdsForCursor(cursor, PlayerProviderUtils.guessAudioIdColumnIndex(cursor)));
    }

    protected void queue(ContextInfo ctx, Set<Long> selected, int position) {
        ServiceHelper.addToCurrentPlaylist(this.mActivity, getAudioIdArr(ctx, selected));
    }

    protected void playAll(ContextInfo ctx, Set<Long> selected) {
        ServiceHelper.playAll(this.mActivity, getAudioIdArr(ctx, selected), 0);
    }

    protected void removeFromPlaylist(ContextInfo ctx, long playlistId, Set<Long> selected) {
        long[] audioIds = getAudioIdArr(ctx, selected);
        if (audioIds != null && audioIds.length > 0) {
            PlaylistHelper.removeMembers(this.mActivity, audioIds, playlistId);
        }
    }

    private MediaEditInfo[] collectTracksEditInfo(Cursor c, MediaEditInfoFactory factory, long[] sortedOperands, int count) {
        int idIdx = PlayerProviderUtils.guessAudioIdColumnIndex(c);
        int pathIdx = c.getColumnIndex("_data");
        int titleIdx = c.getColumnIndex("title");
        int artistIdx = c.getColumnIndex("artist");
        int albumIdx = c.getColumnIndex("album");
        int position = c.getPosition();
        MediaEditInfo[] ret = new MediaEditInfo[count];
        c.moveToFirst();
        int i = 0;
        while (i < count && !c.isAfterLast()) {
            int i2;
            if (sortedOperands != null) {
                if (Arrays.binarySearch(sortedOperands, c.getLong(idIdx)) < 0) {
                    i2 = i;
                    c.moveToNext();
                    i = i2;
                }
            }
            i2 = i + 1;
            ret[i] = factory.create(c.getString(pathIdx), c.getString(titleIdx), c.getString(artistIdx), c.getString(albumIdx));
            c.moveToNext();
            i = i2;
        }
        c.moveToPosition(position);
        return ret;
    }

    protected AudioList getSelectedSongList(ContextInfo ctx, Set<Long> selected) {
        Cursor cursor = ctx.mCursor;
        int oldPos = cursor.getPosition();
        int memberIdIdx = cursor.getColumnIndexOrThrow("_id");
        int titleIdx = cursor.getColumnIndexOrThrow("title");
        int artistIdx = cursor.getColumnIndexOrThrow("artist");
        int albumIdx = cursor.getColumnIndexOrThrow("album");
        int audioIdIdx = cursor.getColumnIndex("audio_id");
        int onlineIdIdx = cursor.getColumnIndex("mi_online_id");
        String[] sortedFileNames = MetaManager.getAllSortedDownloadedMP3Names();
        ArrayList<Audio> list = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            long memberId = cursor.getLong(memberIdIdx);
            if (selected.contains(Long.valueOf(memberId))) {
                long audioId = memberId;
                if (audioIdIdx >= 0) {
                    audioId = cursor.getLong(audioIdIdx);
                }
                if (PlayerProvider.isOnlineAudio(audioId)) {
                    String tr = cursor.getString(titleIdx);
                    String ar = cursor.getString(artistIdx);
                    String name = MetaManager.getMetaFileName(tr, ar, StorageConfig.META_TYPE_MP3);
                    if (name != null && (sortedFileNames == null || Arrays.binarySearch(sortedFileNames, name) < 0)) {
                        Audio audio = OnlineMusicProxy.newAudio(cursor.getString(onlineIdIdx), tr, ar, cursor.getString(albumIdx));
                        if (audio != null) {
                            list.add(audio);
                        }
                    }
                }
            }
            cursor.moveToNext();
        }
        AudioList audioList = null;
        if (list.isEmpty()) {
            Log.e(TAG, "nothing to be downloaded. item count=" + list.size());
        } else {
            audioList = new AudioList(list);
        }
        cursor.moveToPosition(oldPos);
        return audioList;
    }

    protected Long getKeyFromItem(Object obj) {
        if (!(obj instanceof Cursor)) {
            return null;
        }
        Cursor c = (Cursor) obj;
        if (this.mKeyIdx < 0) {
            this.mKeyIdx = c.getColumnIndex(this.mKeyColumn);
        }
        return Long.valueOf(c.getLong(this.mKeyIdx));
    }
}
