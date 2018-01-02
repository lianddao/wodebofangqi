package com.miui.player.ui.menu;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.meta.MediaFileManager;
import com.miui.player.meta.MediaFileManager.AlbumEditInfoFactory;
import com.miui.player.meta.MediaFileManager.ArtistEditInfoFactory;
import com.miui.player.meta.MediaFileManager.MediaEditInfo;
import com.miui.player.meta.MediaFileManager.MediaEditInfoFactory;
import com.miui.player.meta.MediaFileManager.TrackEditInfoFactory;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.ID3Correcter;
import com.miui.player.network.ID3Correcter.AsyncCorrectID3Task;
import com.miui.player.network.MP3Downloader;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.KtvPlaylistCache;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.CheckBoxDialog;
import com.miui.player.ui.DeleteItems;
import com.miui.player.ui.MediaEditDialog;
import com.miui.player.ui.OperationDialog;
import com.miui.player.ui.TrackBrowserActivity;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.UIHelper.SubMenuBuilder;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.ui.menu.common.MenuContextInfo;
import com.miui.player.ui.model.NowplayingCursor;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;

public abstract class BaseTrackBrowserMenu<T> extends BaseMenuManager<T> {
    public static final int FAVORITE_SELECTION = 36;
    private static final String KEY_MENU_TRACE = "src_trace";
    public static final int MANAGER_MENU_BASE = 133;
    public static final int META_MODIFY = 38;
    public static final int REMOVE = 34;
    public static final int RENAME_PLAYLIST = 35;
    public static final int SEND_TO = 37;
    private WeakReference<AsyncCorrectID3Task> mCorrectID3TaskRef = null;

    class C05121 implements Runnable {
        C05121() {
        }

        public void run() {
            BaseTrackBrowserMenu.this.notifyDataSetChanged();
        }
    }

    public static class ContextInfo<T> extends MenuContextInfo<T> {
        public long mAlbumId = -1;
        public String mAlbumName = null;
        public long mArtistId = -1;
        public String mArtistName = null;
        public Cursor mCursor = null;
        public AudioList mDownloadList = null;
        public boolean mEditMode = false;
        public int mHeaderCount = 0;
        public AbsListView mListView = null;
        public long mPlaylistId = -1;
        public Runnable mRefreshRunnable = null;
        public AudioList mSongList = null;

        public boolean isValid() {
            if (this.mCursor != null) {
                if (this.mSongList == null) {
                    return true;
                }
                return false;
            } else if (this.mSongList != null) {
                return this.mSongList.isValid();
            } else {
                return false;
            }
        }
    }

    protected static class MenuTrace implements Parcelable {
        public static final Creator<MenuTrace> CREATOR = new C05141();
        boolean mHasLocal;
        boolean mHasOnline;
        boolean mHasUnfavorite;
        int mSize;
        TrackRecordInfo mTrackRecordInfo;
        int mType;

        static class C05141 implements Creator<MenuTrace> {
            C05141() {
            }

            public MenuTrace createFromParcel(Parcel in) {
                return new MenuTrace(in);
            }

            public MenuTrace[] newArray(int size) {
                return new MenuTrace[size];
            }
        }

        public MenuTrace(Parcel in) {
            boolean z;
            boolean z2 = true;
            this.mType = in.readInt();
            this.mSize = in.readInt();
            if (in.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.mHasLocal = z;
            if (in.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.mHasOnline = z;
            if (in.readInt() == 0) {
                z2 = false;
            }
            this.mHasUnfavorite = z2;
            this.mTrackRecordInfo = (TrackRecordInfo) in.readParcelable(in.getClass().getClassLoader());
        }

        public boolean isValid() {
            return this.mSize > 0 && (this.mHasLocal || this.mHasOnline);
        }

        public void writeToParcel(Parcel dest, int flags) {
            int i;
            int i2 = 1;
            dest.writeInt(this.mType);
            dest.writeInt(this.mSize);
            if (this.mHasLocal) {
                i = 1;
            } else {
                i = 0;
            }
            dest.writeInt(i);
            if (this.mHasOnline) {
                i = 1;
            } else {
                i = 0;
            }
            dest.writeInt(i);
            if (!this.mHasUnfavorite) {
                i2 = 0;
            }
            dest.writeInt(i2);
            dest.writeParcelable(this.mTrackRecordInfo, flags);
        }

        public int describeContents() {
            return 0;
        }
    }

    protected static class TrackRecordInfo implements Parcelable {
        public static final Creator<TrackRecordInfo> CREATOR = new C05151();
        String mAlbum;
        String mArtist;
        long mAudioId;
        String mData;
        long mLocalAudioId = -1;
        final long mMemberId;
        String mTitle;

        static class C05151 implements Creator<TrackRecordInfo> {
            C05151() {
            }

            public TrackRecordInfo createFromParcel(Parcel in) {
                return new TrackRecordInfo(in);
            }

            public TrackRecordInfo[] newArray(int size) {
                return new TrackRecordInfo[size];
            }
        }

        public TrackRecordInfo(long memberId) {
            this.mMemberId = memberId;
        }

        public TrackRecordInfo(Parcel in) {
            this.mMemberId = in.readLong();
            this.mAudioId = in.readLong();
            this.mLocalAudioId = in.readLong();
            this.mTitle = in.readString();
            this.mAlbum = in.readString();
            this.mArtist = in.readString();
            this.mData = in.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(this.mMemberId);
            dest.writeLong(this.mAudioId);
            dest.writeLong(this.mLocalAudioId);
            dest.writeString(this.mTitle);
            dest.writeString(this.mAlbum);
            dest.writeString(this.mArtist);
            dest.writeString(this.mData);
        }
    }

    protected abstract void addToPlaylist(ContextInfo contextInfo, long j);

    protected abstract void addToPlaylist(ContextInfo contextInfo, long j, Set<T> set);

    protected abstract MediaEditInfo[] collectTracksEditInfo(ContextInfo contextInfo, MenuTrace menuTrace, MediaEditInfoFactory mediaEditInfoFactory, Set<T> set);

    protected abstract TrackRecordInfo findLocalAudioId(ContextInfo contextInfo, Set<T> set);

    protected abstract long[] getAudioIdArr(ContextInfo contextInfo, Set<T> set);

    protected abstract MenuTrace getMenuTrace(ContextInfo contextInfo, Set<T> set);

    protected abstract ArrayList<String> getOnlineAudioLocalPath(ContextInfo contextInfo, Set<T> set);

    protected abstract AudioList getSelectedSongList(ContextInfo contextInfo, Set<T> set);

    protected abstract void playAll(ContextInfo contextInfo, Set<T> set);

    protected abstract void queue(ContextInfo contextInfo);

    protected abstract void queue(ContextInfo contextInfo, Set<T> set, int i);

    protected abstract void removeFromPlaylist(ContextInfo contextInfo, long j, Set<T> set);

    public BaseTrackBrowserMenu(Activity a, int msgId) {
        super(a, msgId);
        this.mActivity = a;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 27, 0, C0329R.string.download_all_track);
        menu.add(0, 20, 0, C0329R.string.rename_album_menu);
        menu.add(0, 19, 0, C0329R.string.rename_artist_menu);
        menu.addSubMenu(0, 1, 0, C0329R.string.add_to_playlist);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean z;
        boolean z2 = false;
        ContextInfo ctx = (ContextInfo) getContextInfo();
        MenuItem item = menu.findItem(27);
        if (item != null) {
            if (ctx.mDownloadList == null || ctx.mDownloadList.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            item.setVisible(z);
        }
        item = menu.findItem(20);
        if (item != null) {
            if (ctx.mAlbumId >= 0) {
                z = true;
            } else {
                z = false;
            }
            item.setVisible(z);
        }
        item = menu.findItem(19);
        if (item != null) {
            if (ctx.mArtistId >= 0) {
                z = true;
            } else {
                z = false;
            }
            item.setVisible(z);
        }
        long plid = ctx.mPlaylistId;
        item = menu.findItem(35);
        if (item != null) {
            if (!(plid < 0 || plid == 0 || FavoriteCache.isFavoritePlaylistId(this.mActivity, plid) || KtvPlaylistCache.isKtvPlaylistId(this.mActivity, plid))) {
                z2 = true;
            }
            item.setVisible(z2);
        }
        item = menu.findItem(1);
        if (item != null) {
            UIHelper.makePlaylistMenu(this.mActivity, item.getSubMenu(), null, plid);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        ContextInfo ctx = (ContextInfo) getContextInfo();
        if (!ctx.isValid()) {
            return false;
        }
        int itemId = item.getItemId();
        CharSequence title = item.getTitle();
        switch (itemId) {
            case 3:
                Intent intent = item.getIntent();
                if (intent != null) {
                    long playlistId = intent.getLongExtra(UIHelper.DST_PLAYLIST_KEY, -1);
                    if (playlistId != -1) {
                        addToPlaylist(ctx, playlistId);
                    }
                }
                return true;
            case 4:
                OperationDialog.makePlaylistCreator(this.mActivity, this, 4, null).show();
                return true;
            case 12:
                queue(ctx);
                return true;
            case 19:
            case BaseMenuId.RENAME_ALBUM /*20*/:
                MenuTrace trace = new MenuTrace();
                trace.mHasLocal = true;
                trace.mHasOnline = false;
                trace.mType = 2;
                showTracksId3EditDialog(ctx, itemId, title, trace);
                return true;
            case BaseMenuId.DOWNLOAD_ALL_TRACK /*27*/:
                Runnable c05121 = new C05121();
                MP3Downloader.startOnUIThread(this.mActivity, ctx.mDownloadList, c05121);
                return true;
            case RENAME_PLAYLIST /*35*/:
                OperationDialog dialog = OperationDialog.makePlaylistRenamer(this.mActivity, this, 35, null, ctx.mPlaylistId);
                if (dialog != null) {
                    dialog.show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void createActionMenu(Menu menu, Set<T> selected) {
        MenuContextInfo ctx = getContextInfo();
        if ((ctx instanceof ContextInfo) && ctx.isValid()) {
            MenuTrace trace = getMenuTrace((ContextInfo) ctx, selected);
            menu.add(0, 5, 0, C0329R.string.play_selection).setIcon(C0329R.drawable.menu_play_selection_selector);
            MenuItem sub = menu.add(0, 1, 0, C0329R.string.add_to).setIcon(100795004);
            int removeIcon = 100794701;
            int removeStr = C0329R.string.delete_item;
            if (((ContextInfo) ctx).mEditMode) {
                removeIcon = C0329R.drawable.menu_remove_from_playlist_selector;
                removeStr = C0329R.string.remove_item;
            }
            menu.add(0, 34, 0, removeStr).setIcon(removeIcon);
            menu.add(0, 36, 0, trace.mHasUnfavorite ? C0329R.string.add_to_favorite : C0329R.string.remove_from_favorite).setIcon(trace.mHasUnfavorite ? C0329R.drawable.menu_add_to_favorite : C0329R.drawable.menu_remove_from_favorite);
            menu.add(0, 17, 0, C0329R.string.download).setIcon(C0329R.drawable.menu_download_selector);
            menu.add(0, 37, 0, C0329R.string.send_to).setIcon(100795044);
            menu.add(0, 2, 0, C0329R.string.ringtone_menu).setIcon(C0329R.drawable.menu_ringtone_selector);
            menu.add(0, 38, 0, C0329R.string.modify_meta).setIcon(C0329R.drawable.menu_edit_id3_selector);
        }
    }

    public void prepareActionMenu(Menu menu, Set<T> selected) {
        MenuContextInfo ctx = getContextInfo();
        if ((ctx instanceof ContextInfo) && ctx.isValid()) {
            MenuTrace trace = getMenuTrace((ContextInfo) ctx, selected);
            if (trace != null && trace.isValid()) {
                boolean z;
                Intent extras = new Intent().putExtra(KEY_MENU_TRACE, trace);
                MenuItem item = menu.findItem(5);
                if (item != null) {
                    item.setIntent(extras);
                }
                item = menu.findItem(1);
                if (item != null) {
                    UIHelper.makePlaylistMenuProxy(this.mActivity, item, extras, ((ContextInfo) ctx).mPlaylistId, this);
                    item.setIntent(extras);
                }
                item = menu.findItem(34);
                if (item != null) {
                    item.setIntent(extras);
                }
                item = menu.findItem(36);
                if (item != null) {
                    int favoriteStrId = trace.mHasUnfavorite ? C0329R.string.add_to_favorite : C0329R.string.remove_from_favorite;
                    item.setIcon(trace.mHasUnfavorite ? C0329R.drawable.menu_add_to_favorite : C0329R.drawable.menu_remove_from_favorite);
                    item.setTitle(favoriteStrId);
                    item.setIntent(extras);
                }
                item = menu.findItem(17);
                if (item != null) {
                    item.setVisible(trace.mHasOnline);
                    item.setIntent(extras);
                }
                item = menu.findItem(37);
                if (item != null) {
                    if (trace.mHasLocal && trace.mSize == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    item.setEnabled(z);
                    item.setIntent(extras);
                }
                item = menu.findItem(2);
                if (item != null) {
                    if (trace.mHasLocal && trace.mSize == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    item.setEnabled(z);
                    item.setIntent(extras);
                }
                item = menu.findItem(38);
                if (item != null) {
                    SubMenuBuilder sub = new SubMenuBuilder(this.mActivity, item, this);
                    if (trace.mSize > 1) {
                        sub.add(1, 19, 0, (int) C0329R.string.rename_artist_menu).setIntent(extras).setIcon(C0329R.drawable.menu_rename_artist_selector);
                        sub.add(1, 20, 0, (int) C0329R.string.rename_album_menu).setIntent(extras).setIcon(C0329R.drawable.menu_rename_album_selector);
                    } else {
                        if (Utils.isOnlineVaild()) {
                            sub.add(1, 22, 0, (int) C0329R.string.correct_id3_by_internet).setIntent(extras);
                        }
                        sub.add(1, 21, 0, (int) C0329R.string.id3_edit).setIntent(extras);
                    }
                    sub.build();
                    item.setIntent(extras);
                }
            }
        }
    }

    public void handleActionItem(MenuItem item, Set<T> selected) {
        super.handleActionItem(item, selected);
        Intent intent = item.getIntent();
        if (intent != null) {
            ContextInfo<T> ctx = (ContextInfo) getContextInfo();
            if (ctx.isValid()) {
                MenuTrace trace = (MenuTrace) intent.getParcelableExtra(KEY_MENU_TRACE);
                if (!CollectionHelper.isEmpty(selected) && trace != null && trace.isValid()) {
                    CharSequence title = item.getTitle();
                    int itemId = item.getItemId();
                    TrackRecordInfo info;
                    switch (itemId) {
                        case 2:
                            info = findLocalAudioId(ctx, selected);
                            if (info == null || info.mLocalAudioId < 0 || !Utils.isSupportAsRingtone(info.mData)) {
                                Toast.makeText(this.mActivity, C0329R.string.ringtone_not_support, 0).show();
                            } else {
                                UIHelper.setRingtone(this.mActivity, info.mLocalAudioId);
                            }
                            leaveMultiChoiceMode(ctx);
                            return;
                        case 3:
                            long playlistId = intent.getLongExtra(UIHelper.DST_PLAYLIST_KEY, 0);
                            if (playlistId >= 0) {
                                addToPlaylist(ctx, playlistId, selected);
                            }
                            leaveMultiChoiceMode(ctx);
                            return;
                        case 4:
                            OperationDialog.makePlaylistCreator(this.mActivity, this, 4, intent).show();
                            return;
                        case 5:
                            playAll(ctx, selected);
                            if (ctx.mMultiChoiceController != null) {
                                ctx.mMultiChoiceController.leave();
                                return;
                            }
                            return;
                        case 12:
                            queue(ctx, selected, 3);
                            leaveMultiChoiceMode(ctx);
                            return;
                        case 17:
                            donwload(ctx, selected, title);
                            return;
                        case 19:
                        case BaseMenuId.RENAME_ALBUM /*20*/:
                            showTracksId3EditDialog(ctx, itemId, title, trace);
                            return;
                        case BaseMenuId.EDIT_ID3 /*21*/:
                            info = findLocalAudioId(ctx, selected);
                            if (info == null || info.mLocalAudioId < 0 || !Utils.isSupportID3(info.mData)) {
                                Toast.makeText(this.mActivity, C0329R.string.correct_id3_not_support, 0).show();
                                return;
                            }
                            trace.mTrackRecordInfo = info;
                            showTracksId3EditDialog(ctx, itemId, title, trace);
                            return;
                        case BaseMenuId.CORRECT_ID3 /*22*/:
                            if (findLocalAudioId(ctx, selected) != null) {
                                AsyncCorrectID3Task task = null;
                                if (this.mCorrectID3TaskRef != null) {
                                    task = (AsyncCorrectID3Task) this.mCorrectID3TaskRef.get();
                                }
                                if (task != null) {
                                    task.cancel(true);
                                }
                                this.mCorrectID3TaskRef = new WeakReference(ID3Correcter.startTaskForID3Correct(this.mActivity, new String[]{info.mData}, new long[]{info.mAudioId}, true, true));
                                return;
                            }
                            return;
                        case REMOVE /*34*/:
                            intent.putExtra("title", title);
                            if (ctx.mPlaylistId < 0) {
                                long[] audioIds = getAudioIdArr(ctx, selected);
                                ArrayList<String> onlinePaths = getOnlineAudioLocalPath(ctx, selected);
                                int count = 0;
                                if (audioIds != null) {
                                    count = audioIds.length;
                                } else if (onlinePaths != null) {
                                    count = onlinePaths.size();
                                }
                                DeleteItems.show(this.mActivity, audioIds, onlinePaths, count, this, 10);
                                return;
                            }
                            intent.putExtra(CheckBoxDialog.KEY_MESSAGE, this.mActivity.getString(C0329R.string.delete_file_from_sdcard));
                            intent.putExtra(CheckBoxDialog.KEY_CHECK_VISIBLE, trace.mHasLocal);
                            new CheckBoxDialog(this.mActivity, this, 34, intent).show();
                            return;
                        case FAVORITE_SELECTION /*36*/:
                            if (trace.mHasUnfavorite) {
                                addToPlaylist(ctx, FavoriteCache.getFavoritePlaylistId(this.mActivity), selected);
                            } else {
                                removeFromPlaylist(ctx, FavoriteCache.getFavoritePlaylistId(this.mActivity), selected);
                            }
                            leaveMultiChoiceMode(ctx);
                            return;
                        case SEND_TO /*37*/:
                            info = findLocalAudioId(ctx, selected);
                            if (info != null && info.mLocalAudioId >= 0) {
                                UIHelper.sendByChooser(this.mActivity, info.mLocalAudioId);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    public void onDialogResult(int requestCode, boolean confirm, Intent intent) {
        ContextInfo ctx = (ContextInfo) getContextInfo();
        if (ctx.isValid()) {
            switch (requestCode) {
                case 4:
                    if (confirm && intent != null) {
                        Uri uri = intent.getData();
                        if (uri != null) {
                            long playlistId = Long.valueOf(uri.getLastPathSegment()).longValue();
                            if (playlistId >= 0) {
                                if (((Intent) intent.getParcelableExtra(OperationDialog.KEY_CALLBACK)) == null) {
                                    addToPlaylist(ctx, playlistId);
                                } else {
                                    addToPlaylist(ctx, playlistId, getLastSelected());
                                }
                            }
                        }
                        leaveMultiChoiceMode(ctx);
                        return;
                    }
                    return;
                case 10:
                    if (confirm) {
                        leaveMultiChoiceMode(ctx);
                        if (ctx.mSongList != null) {
                            ctx.mRefreshRunnable.run();
                            return;
                        }
                        return;
                    }
                    return;
                case 19:
                case BaseMenuId.RENAME_ALBUM /*20*/:
                case BaseMenuId.EDIT_ID3 /*21*/:
                    if (confirm && intent != null && editId3(ctx, intent, requestCode)) {
                        leaveMultiChoiceMode(ctx);
                        return;
                    }
                    return;
                case REMOVE /*34*/:
                    if (confirm && intent != null) {
                        boolean handled = true;
                        Set<T> selected = getLastSelected();
                        if (!CollectionHelper.isEmpty(selected)) {
                            if (intent.getBooleanExtra(CheckBoxDialog.KEY_CHECK_STATUS, false)) {
                                long[] audioIds = getAudioIdArr(ctx, selected);
                                DeleteItems.show(this.mActivity, audioIds, getOnlineAudioLocalPath(ctx, selected), audioIds != null ? audioIds.length : 0, this, 10);
                                handled = false;
                            } else {
                                Cursor cursor = ctx.mCursor;
                                if (cursor instanceof NowplayingCursor) {
                                    int[] posArr = new int[selected.size()];
                                    int oldPos = cursor.getPosition();
                                    int idx = cursor.getColumnIndex("_id");
                                    int i = 0;
                                    cursor.moveToFirst();
                                    while (!cursor.isAfterLast()) {
                                        if (selected.contains(Long.valueOf(cursor.getLong(idx)))) {
                                            int i2 = i + 1;
                                            posArr[i] = cursor.getPosition();
                                            i = i2;
                                        }
                                        cursor.moveToNext();
                                    }
                                    cursor.moveToPosition(oldPos);
                                    ServiceHelper.removeQueueTracksBatch(posArr);
                                } else {
                                    long plid = ctx.mPlaylistId;
                                    if (plid >= 0) {
                                        removeFromPlaylist(ctx, plid, selected);
                                    }
                                }
                            }
                        }
                        if (handled) {
                            leaveMultiChoiceMode(ctx);
                            return;
                        }
                        return;
                    }
                    return;
                case RENAME_PLAYLIST /*35*/:
                    if (confirm) {
                        ((TrackBrowserActivity) this.mActivity).setTitleBar();
                        leaveMultiChoiceMode(ctx);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void showTracksId3EditDialog(ContextInfo ctx, int menuType, CharSequence title, MenuTrace trace) {
        String msg;
        String track;
        String album;
        String artist;
        TrackRecordInfo info = trace.mTrackRecordInfo;
        if (info != null) {
            msg = this.mActivity.getString(C0329R.string.modify_id3_for_selected);
            track = info.mTitle;
            album = info.mAlbum;
            artist = info.mArtist;
        } else if (trace.mType == 2) {
            msg = this.mActivity.getString(C0329R.string.modify_id3_for_list);
            track = MetaManager.UNKNOWN_STRING;
            album = ctx.mAlbumName;
            artist = ctx.mArtistName;
        } else {
            msg = this.mActivity.getString(C0329R.string.modify_id3_for_selected);
            track = MetaManager.UNKNOWN_STRING;
            album = MetaManager.UNKNOWN_STRING;
            artist = MetaManager.UNKNOWN_STRING;
        }
        final Activity activity = this.mActivity;
        final int i = menuType;
        final CharSequence charSequence = title;
        final MenuTrace menuTrace = trace;
        new Builder(this.mActivity).setTitle(title).setPositiveButton(C0329R.string.confirm, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (which == -1) {
                    Bundle bundle = new Bundle();
                    if (i == 20) {
                        bundle.putString(MediaEditDialog.RAW_ALBUM_NAME, album);
                    } else if (i == 19) {
                        bundle.putString(MediaEditDialog.RAW_ARTIST_NAME, artist);
                    } else if (i == 21) {
                        bundle.putString(MediaEditDialog.RAW_TRACK_NAME, track);
                        bundle.putString(MediaEditDialog.RAW_ALBUM_NAME, album);
                        bundle.putString(MediaEditDialog.RAW_ARTIST_NAME, artist);
                    }
                    if (!bundle.isEmpty()) {
                        bundle.putString(MediaEditDialog.DIALOG_TITLE, charSequence.toString());
                        bundle.putString(MediaEditDialog.CONFIRM_TEXT, activity.getString(C0329R.string.id3_modify_confirm_text));
                        bundle.putParcelable(MediaEditDialog.TRACE_KEY, menuTrace);
                        new MediaEditDialog(activity, bundle, BaseTrackBrowserMenu.this, i).show();
                    }
                }
            }
        }).setNegativeButton(C0329R.string.cancel, null).setMessage(msg).show();
    }

    private boolean editId3(ContextInfo ctx, Intent intent, int requestCode) {
        MenuTrace trace = (MenuTrace) intent.getParcelableExtra(MediaEditDialog.TRACE_KEY);
        if (trace == null) {
            return false;
        }
        MediaEditInfo[] editInfos = null;
        MediaEditInfoFactory factory = null;
        if (trace.mTrackRecordInfo != null) {
            String tr = intent.getStringExtra(MediaEditDialog.NEW_TRACK_NAME);
            String ar = intent.getStringExtra(MediaEditDialog.NEW_ARTIST_NAME);
            Intent intent2 = intent;
            editInfos = new MediaEditInfo[]{new TrackEditInfoFactory(tr, ar, intent2.getStringExtra(MediaEditDialog.NEW_ALBUM_NAME)).create(info.mData, info.mTitle, info.mArtist, info.mAlbum)};
        } else {
            if (20 == requestCode) {
                factory = new AlbumEditInfoFactory(intent.getStringExtra(MediaEditDialog.NEW_ALBUM_NAME));
            } else if (19 == requestCode) {
                factory = new ArtistEditInfoFactory(intent.getStringExtra(MediaEditDialog.NEW_ARTIST_NAME));
            }
            if (factory != null) {
                editInfos = collectTracksEditInfo(ctx, trace, factory, getLastSelected());
            }
        }
        if (editInfos == null) {
            return false;
        }
        MediaFileManager.batchCorretId3Async(this.mActivity.getApplication(), editInfos);
        Toast.makeText(this.mActivity, C0329R.string.modify_tracks_id3_background, 0).show();
        return true;
    }

    private void donwload(ContextInfo ctx, Set<T> selected, CharSequence title) {
        AudioList list = getSelectedSongList(ctx, selected);
        if (list != null && list.isValid()) {
            MP3Downloader.startOnUIThread(this.mActivity, list, ctx.mRefreshRunnable);
        }
        leaveMultiChoiceMode(ctx);
    }

    protected void leaveMultiChoiceMode(ContextInfo<T> ctx) {
        if (ctx != null && ctx.mMultiChoiceController != null) {
            ctx.mMultiChoiceController.leave();
        }
    }

    protected void enterMultiChoiceMode(ContextInfo<T> ctx) {
        if (ctx != null && ctx.mMultiChoiceController != null) {
            ctx.mMultiChoiceController.enter();
        }
    }
}
