package com.miui.player.ui.menu;

import android.database.Cursor;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.collect.Sets;
import com.miui.player.meta.Audio;
import com.miui.player.meta.MediaFileManager.MediaEditInfo;
import com.miui.player.meta.MediaFileManager.MediaEditInfoFactory;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.PlayerProviderUtils;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.fragment.OnlineSongListFragment;
import com.miui.player.ui.menu.BaseTrackBrowserMenu.ContextInfo;
import com.miui.player.ui.menu.common.MenuContextInfo;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.StorageConfig;
import com.miui.player.util.StorageUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OnlineSongMenu extends BaseTrackBrowserMenu<String> {
    private static final String TAG = OnlineSongMenu.class.getName();
    private final OnlineSongListFragment mFragment;

    public OnlineSongMenu(OnlineSongListFragment f, int msgId) {
        super(f.getActivity(), msgId);
        this.mFragment = f;
    }

    protected MenuTrace getMenuTrace(ContextInfo ctx, Set<String> selected) {
        AudioList onlineSongList = ctx.mSongList;
        if (onlineSongList == null || !onlineSongList.isValid()) {
            return null;
        }
        boolean hasLocal = false;
        boolean hasOnline = false;
        boolean hasUnfavorite = false;
        String[] sortedNames = MetaManager.getAllSortedDownloadedMP3Names();
        for (Audio item : onlineSongList.getContent()) {
            if (selected.contains(item.getId())) {
                String tr = item.getTitle();
                String ar = item.getArtistName();
                if (!TextUtils.isEmpty(tr) || !TextUtils.isEmpty(ar)) {
                    String name = MetaManager.getMetaFileName(tr, ar, StorageConfig.META_TYPE_MP3);
                    if (name != null) {
                        if (!(hasLocal && hasOnline)) {
                            if (sortedNames == null || Arrays.binarySearch(sortedNames, name) < 0) {
                                hasOnline = true;
                            } else {
                                hasLocal = true;
                            }
                        }
                        if (!hasUnfavorite) {
                            hasUnfavorite = !FavoriteCache.onlineContains(this.mActivity, item.getId());
                        }
                        if (hasLocal && hasOnline && hasUnfavorite) {
                            break;
                        }
                    }
                    continue;
                }
            }
        }
        MenuTrace trace = new MenuTrace();
        trace.mSize = selected.size();
        trace.mHasLocal = hasLocal;
        trace.mHasOnline = hasOnline;
        trace.mHasUnfavorite = hasUnfavorite;
        trace.mType = 3;
        return trace;
    }

    protected ArrayList<String> getOnlineAudioLocalPath(ContextInfo ctx, Set<String> selected) {
        AudioList onlineSongList = ctx.mSongList;
        if (onlineSongList == null || !onlineSongList.isValid()) {
            return null;
        }
        String[] sortedNames = MetaManager.getAllSortedDownloadedMP3Names();
        List<Audio> songItems = onlineSongList.getContent();
        ArrayList<String> pathArr = new ArrayList();
        for (Audio item : songItems) {
            if (selected.contains(item.getId())) {
                String tr = item.getTitle();
                String ar = item.getArtistName();
                if (!TextUtils.isEmpty(tr) || !TextUtils.isEmpty(ar)) {
                    String name = MetaManager.getMetaFileName(tr, ar, StorageConfig.META_TYPE_MP3);
                    if (!(name == null || sortedNames == null)) {
                        for (File dir : StorageConfig.getAllMp3Dir(false)) {
                            Iterator i$ = StorageUtils.getAllSdcardFilePath(StorageUtils.getLeafPath(new File(dir, name).getAbsolutePath())).iterator();
                            while (i$.hasNext()) {
                                String filePath = (String) i$.next();
                                if (Arrays.binarySearch(sortedNames, filePath) >= 0) {
                                    pathArr.add(filePath);
                                }
                            }
                        }
                    }
                }
            }
        }
        return pathArr;
    }

    protected TrackRecordInfo findLocalAudioId(ContextInfo ctx, Set<String> selected) {
        String onlineId = (String) selected.iterator().next();
        String path = null;
        for (Audio i : ctx.mSongList.getContent()) {
            if (TextUtils.equals(onlineId, i.getId())) {
                String tr = i.getTitle();
                String ar = i.getArtistName();
                if (!TextUtils.isEmpty(tr) || !TextUtils.isEmpty(ar)) {
                    path = MetaManager.getSavedFilePath(tr, ar, StorageConfig.META_TYPE_MP3);
                    break;
                }
            }
        }
        if (path == null) {
            return null;
        }
        Cursor cursor = SqlUtils.query(this.mActivity, Media.EXTERNAL_CONTENT_URI, null, "_data=?", new String[]{path}, null, 1);
        TrackRecordInfo trackRecordInfo = null;
        if (cursor == null) {
            return null;
        }
        if (cursor.moveToFirst()) {
            long audioId = cursor.getLong(PlayerProviderUtils.guessAudioIdColumnIndex(cursor));
            trackRecordInfo = new TrackRecordInfo(audioId);
            trackRecordInfo.mAudioId = audioId;
            trackRecordInfo.mTitle = cursor.getString(cursor.getColumnIndex("title"));
            trackRecordInfo.mAlbum = cursor.getString(cursor.getColumnIndex("album"));
            trackRecordInfo.mArtist = cursor.getString(cursor.getColumnIndex("artist"));
            trackRecordInfo.mData = cursor.getString(cursor.getColumnIndex("_data"));
            trackRecordInfo.mLocalAudioId = PlayerProviderUtils.getDownloadedAudioId(this.mActivity, trackRecordInfo.mTitle, trackRecordInfo.mArtist, trackRecordInfo.mAudioId);
        }
        cursor.close();
        return trackRecordInfo;
    }

    protected long[] getAudioIdArr(ContextInfo ctx, Set<String> set) {
        return null;
    }

    protected void addToPlaylist(ContextInfo ctx, long playlistId) {
        PlaylistHelper.addOnlineToPlaylist(this.mActivity, ctx.mSongList.getContent(), OnlineMusicProxy.getProviderName(this.mActivity), playlistId);
    }

    protected void addToPlaylist(ContextInfo ctx, long playlistId, Set<String> selected) {
        PlaylistHelper.addOnlineToPlaylist(this.mActivity, getSelectedSongItems(ctx, selected), OnlineMusicProxy.getProviderName(this.mActivity), playlistId);
    }

    protected MediaEditInfo[] collectTracksEditInfo(ContextInfo ctx, MenuTrace trace, MediaEditInfoFactory factory, Set<String> set) {
        Log.e(TAG, "can not edit id3 in online music list");
        return null;
    }

    protected void queue(ContextInfo ctx) {
        ServiceHelper.playAll(this.mActivity, ctx.mSongList.getContent(), OnlineMusicProxy.getProviderName(this.mActivity), 0, true, false);
    }

    protected void queue(ContextInfo ctx, Set<String> selected, int position) {
        ServiceHelper.playAll(this.mActivity, getSelectedSongItems(ctx, selected), OnlineMusicProxy.getProviderName(this.mActivity), position, true, false);
    }

    protected void playAll(ContextInfo ctx, Set<String> selected) {
        ServiceHelper.playAll(this.mActivity, getSelectedSongItems(ctx, selected), OnlineMusicProxy.getProviderName(this.mActivity), 0, false, false);
    }

    protected void removeFromPlaylist(ContextInfo ctx, long playlistId, Set<String> selected) {
        List<Audio> items = getSelectedSongItems(ctx, selected);
        ArrayList<String> onlineIds = new ArrayList(items.size());
        for (Audio item : items) {
            onlineIds.add(item.getId());
        }
        PlaylistHelper.removeOnlineMembers(this.mActivity, onlineIds, OnlineMusicProxy.getProviderName(this.mActivity), playlistId);
    }

    protected MenuContextInfo<String> getContextInfo() {
        return this.mFragment.getContextInfo();
    }

    private ArrayList<Audio> getSelectedSongItems(ContextInfo ctx, Set<String> selected) {
        ArrayList<Audio> ret = new ArrayList();
        List<Audio> list = ctx.mSongList.getContent();
        Set<String> downloadId = Sets.newHashSet();
        for (Audio item : list) {
            String onlineId = item.getId();
            if (selected.contains(onlineId) && downloadId.add(onlineId)) {
                ret.add(item);
            }
        }
        return ret;
    }

    protected AudioList getSelectedSongList(ContextInfo ctx, Set<String> selected) {
        return new AudioList(getSelectedSongItems(ctx, selected));
    }

    protected String getKeyFromItem(Object itemInfo) {
        if (itemInfo instanceof Audio) {
            return ((Audio) itemInfo).getId();
        }
        return null;
    }
}
