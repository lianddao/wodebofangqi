package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.ContextMenuUtils;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.Playlist;
import com.songbirdnest.mediaplayer.PlaylistExporter;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.mediaplayer.widgets.ListView;
import com.songbirdnest.mediaplayer.widgets.OrderableListView;
import com.songbirdnest.mediaplayer.widgets.OrderableListView.DragListener;
import com.songbirdnest.mediaplayer.widgets.OrderableListView.DropListener;
import com.songbirdnest.util.MediaUtils;

public class PlaylistDetailsView extends BaseContentBrowserView {
    private static final String VIEW_CATEGORY = "music:playlists";
    private PlaylistSongListAdapter mAdapter;
    private String mCurrentActivity;
    private String mCurrentActivityToken;
    private PlayableItem mCurrentPlayableItem = new PlayableItem("<UNKNOWN>", null, -1, -1);
    private Cursor mCursor;
    private boolean mEdit = false;
    private View mFooter;
    private LayoutInflater mInflater;
    private boolean mInitialized = false;
    private boolean mJumpToPlayingItem = true;
    private ListView mList;
    private Integer mPlaylistId;
    private String mPlaylistIdentity;
    private String mPlaylistName;
    private String mPlaylistVolume;
    private Cursor mUniqueIdsCursor;

    class C03451 implements OnItemClickListener {
        C03451() {
        }

        public void onItemClick(AdapterView<?> adapterView, View aView, int aPosition, long aItemId) {
            try {
                PlaylistDetailsView.this.mService.setCurrentList(Constants.TOP_MENU_PLAYLISTS, PlaylistDetailsView.this.mPlaylistIdentity);
                PlaylistDetailsView.this.mJumpToPlayingItem = true;
                if (PlaylistDetailsView.this.mList.isShuffle(aPosition)) {
                    PlaylistDetailsView.this.mService.setPlayablePlaylist(new Playlist(PlaylistDetailsView.this.mPlaylistVolume, new Long((long) PlaylistDetailsView.this.mPlaylistId.intValue())), 0, true);
                    return;
                }
                ViewWrapper wrapper = (ViewWrapper) aView.getTag();
                if (!wrapper.isPlaying()) {
                    PlaylistDetailsView.this.mService.setPlayablePlaylist(new Playlist(PlaylistDetailsView.this.mPlaylistVolume, new Long((long) PlaylistDetailsView.this.mPlaylistId.intValue())), PlaylistDetailsView.this.mList.adjusted(aPosition), false);
                } else if (wrapper.isPlaying() && PlaylistDetailsView.this.mService.isPaused()) {
                    PlaylistDetailsView.this.mService.play();
                }
            } catch (Exception e) {
            }
        }
    }

    class C03462 implements OnScrollListener {
        C03462() {
        }

        public void onScrollStateChanged(AbsListView aView, int aScrollState) {
            if (aScrollState != 0) {
                PlaylistDetailsView.this.mJumpToPlayingItem = false;
            }
            PlaylistDetailsView.this.setScrollState(aScrollState);
            if (PlaylistDetailsView.this.isViewStopped() && PlaylistDetailsView.this.isScrollIdle()) {
                PlaylistDetailsView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (PlaylistDetailsView.this.mList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    PlaylistDetailsView.this.mList.removeFooterView(PlaylistDetailsView.this.mFooter);
                } else if (PlaylistDetailsView.this.mList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    PlaylistDetailsView.this.mList.addFooterView(PlaylistDetailsView.this.mFooter);
                }
            }
        }
    }

    class C03473 implements DropListener {
        C03473() {
        }

        public void drop(int aFrom, int aTo) {
            Log.i("Reordering", "From " + aFrom + " -- To " + aTo);
            if (Utils.moveMediaStorePlaylistItem(PlaylistDetailsView.this.mActivity, PlaylistDetailsView.this.mPlaylistId.intValue(), PlaylistDetailsView.this.mPlaylistVolume, (long) aFrom, (long) aTo)) {
                PlaylistDetailsView.this.mUniqueIdsCursor.requery();
                PlaylistDetailsView.this.mCursor.requery();
                PlaylistDetailsView.this.mEdit = true;
            }
            PlaylistDetailsView.this.mAdapter.drop();
            PlaylistDetailsView.this.mAdapter.notifyDataSetChanged();
            PlaylistDetailsView.this.mList.invalidateViews();
        }
    }

    class C03484 implements DragListener {
        C03484() {
        }

        public void drag(int aFrom, int aTo) {
            PlaylistDetailsView.this.mAdapter.drag(aTo);
            PlaylistDetailsView.this.mList.invalidateViews();
        }
    }

    class C03495 implements Runnable {
        C03495() {
        }

        public void run() {
            PlaylistDetailsView.this.closeCursors();
        }
    }

    class PlaylistSongListAdapter extends BaseAdapter {
        private int mDragDst = -1;
        private int mDragSrc = -1;
        private boolean mIsDragging = false;

        class ViewWrapper {
            private TextView mAlbumTitle = null;
            private TextView mArtistName = null;
            private boolean mIsPlaying = false;
            private ImageView mPlayIcon = null;
            private TextView mSongDuration = null;
            private TextView mSongTitle = null;
            private View mView;

            public ViewWrapper(View aView) {
                this.mView = aView;
            }

            public boolean isPlaying() {
                return this.mIsPlaying;
            }

            public void setPlaying(boolean aIsPlaying) {
                this.mIsPlaying = aIsPlaying;
            }

            public ImageView playIcon() {
                if (this.mPlayIcon == null) {
                    this.mPlayIcon = (ImageView) this.mView.findViewById(C0116R.id.playlist_detail_dragger);
                }
                return this.mPlayIcon;
            }

            public TextView albumTitle() {
                if (this.mAlbumTitle == null) {
                    this.mAlbumTitle = (TextView) this.mView.findViewById(C0116R.id.playlist_detail_album_name);
                }
                return this.mAlbumTitle;
            }

            public TextView artistName() {
                if (this.mArtistName == null) {
                    this.mArtistName = (TextView) this.mView.findViewById(C0116R.id.playlist_detail_artist_name);
                }
                return this.mArtistName;
            }

            public TextView duration() {
                if (this.mSongDuration == null) {
                    this.mSongDuration = (TextView) this.mView.findViewById(C0116R.id.playlist_detail_duration);
                }
                return this.mSongDuration;
            }

            public TextView songTitle() {
                if (this.mSongTitle == null) {
                    this.mSongTitle = (TextView) this.mView.findViewById(C0116R.id.playlist_detail_song_name);
                }
                return this.mSongTitle;
            }
        }

        PlaylistSongListAdapter() {
        }

        public void drag(int aPos) {
            if (!this.mIsDragging) {
                this.mDragSrc = aPos;
            }
            this.mDragDst = aPos;
            if (this.mDragDst < 0) {
                aPos = 0;
            }
            this.mDragDst = aPos;
            this.mDragDst = this.mDragDst < PlaylistDetailsView.this.mCursor.getCount() ? this.mDragDst : PlaylistDetailsView.this.mCursor.getCount() - 1;
            this.mIsDragging = true;
        }

        public void drop() {
            this.mDragSrc = -1;
            this.mDragDst = -1;
            this.mIsDragging = false;
        }

        public int getCount() {
            if (PlaylistDetailsView.this.mCursor == null || PlaylistDetailsView.this.mCursor.isClosed()) {
                return 0;
            }
            return PlaylistDetailsView.this.mCursor.getCount();
        }

        public Object getItem(int aPosition) {
            if (this.mDragSrc >= aPosition && aPosition > this.mDragDst) {
                aPosition--;
            } else if (this.mDragSrc <= aPosition && aPosition < this.mDragDst) {
                aPosition++;
            }
            return Integer.valueOf(aPosition);
        }

        public long getItemId(int aPosition) {
            if (this.mDragSrc >= aPosition && aPosition > this.mDragDst) {
                aPosition--;
            } else if (this.mDragSrc <= aPosition && aPosition < this.mDragDst) {
                aPosition++;
            }
            return (long) aPosition;
        }

        public View getView(int aPosition, View aConvertView, ViewGroup aParent) {
            ViewWrapper wrapper;
            int position = aPosition;
            if (this.mDragSrc >= aPosition && aPosition > this.mDragDst) {
                position--;
            } else if (this.mDragSrc <= aPosition && aPosition < this.mDragDst) {
                position++;
            }
            PlaylistDetailsView.this.mCursor.moveToPosition(position);
            if (aConvertView == null) {
                aConvertView = PlaylistDetailsView.this.mInflater.inflate(C0116R.layout.playlist_detail_item, null);
                wrapper = new ViewWrapper(aConvertView);
                aConvertView.setTag(wrapper);
            } else {
                wrapper = (ViewWrapper) aConvertView.getTag();
            }
            if (aPosition == this.mDragDst) {
                aConvertView.setVisibility(4);
            } else {
                aConvertView.setVisibility(0);
                populateViewInfo(aPosition, wrapper);
            }
            return aConvertView;
        }

        private void populateViewInfo(int aPosition, ViewWrapper aWrapper) {
            aWrapper.songTitle().setText(PlaylistDetailsView.this.mCursor.getString(PlaylistDetailsView.this.mCursor.getColumnIndex("title")));
            aWrapper.duration().setText(Utils.calculateTimeStamp(PlaylistDetailsView.this.mCursor.getInt(PlaylistDetailsView.this.mCursor.getColumnIndex("duration"))));
            aWrapper.artistName().setText(PlaylistDetailsView.this.mCursor.getString(PlaylistDetailsView.this.mCursor.getColumnIndex("artist")));
            aWrapper.albumTitle().setText(PlaylistDetailsView.this.mCursor.getString(PlaylistDetailsView.this.mCursor.getColumnIndex("album")));
            int column = PlaylistDetailsView.this.mCursor.getColumnIndexOrThrow("_id");
            ImageView playIcon = aWrapper.playIcon();
            if (playlistItemPlaying(PlaylistDetailsView.this.mCursor.getInt(column))) {
                playIcon.setImageResource(C0116R.drawable.row_listening_button);
                aWrapper.setPlaying(true);
                return;
            }
            playIcon.setImageResource(C0116R.drawable.resort_grabber);
            aWrapper.setPlaying(false);
        }

        private boolean playlistItemPlaying(int aItemId) {
            return Constants.TOP_MENU_PLAYLISTS.equals(PlaylistDetailsView.this.mCurrentActivity) && PlaylistDetailsView.this.mPlaylistIdentity.equals(PlaylistDetailsView.this.mCurrentActivityToken) && aItemId == PlaylistDetailsView.this.mCurrentPlayableItem.mPlaylistItemID;
        }
    }

    public PlaylistDetailsView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_PLAYLIST_DETAILS);
        setViewCategory(VIEW_CATEGORY);
        setViewAnalyticsUri("/music/playlists/<playlist_name>");
    }

    private void initPlaylistDetailsView() {
        Bundle extras = this.mActivity.getIntent().getExtras();
        this.mPlaylistId = Integer.valueOf(extras.getInt(Constants.EXTRA_PLAYLIST_ID));
        this.mPlaylistVolume = extras.getString(Constants.EXTRA_PLAYLIST_VOLUME);
        String prevPlaylistIdentity = this.mPlaylistIdentity;
        this.mPlaylistIdentity = this.mPlaylistId + ":" + this.mPlaylistVolume;
        if (this.mInitialized) {
            openCursors();
            if (!(prevPlaylistIdentity == null || prevPlaylistIdentity.equals(this.mPlaylistIdentity))) {
                this.mPlaylistName = getPlaylistName();
                setHeaderViewText(this.mPlaylistName);
            }
            this.mAdapter.notifyDataSetChanged();
            this.mList.invalidateViews();
            return;
        }
        this.mPlaylistIdentity = this.mPlaylistId + ":" + this.mPlaylistVolume;
        this.mPlaylistName = getPlaylistName();
        openCursors();
        this.mInflater = LayoutInflater.from(this.mActivity);
        this.mAdapter = new PlaylistSongListAdapter();
        this.mList = (ListView) this.mView.findViewById(C0116R.id.playlist_details_song_list);
        this.mFooter = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
        this.mList.addFooterView(this.mFooter);
        if (this.mAdapter.getCount() > 1) {
            this.mList.addHeaderView(this.mInflater.inflate(C0116R.layout.shuffle_view, null));
        }
        this.mList.setAdapter(this.mAdapter);
        this.mList.removeFooterView(this.mFooter);
        this.mList.setOnItemClickListener(new C03451());
        this.mList.setOnScrollListener(new C03462());
        ((OrderableListView) this.mList).setDropListener(new C03473());
        ((OrderableListView) this.mList).setDragListener(new C03484());
        setContextMenuView(this.mList);
        setHeaderViewText(this.mPlaylistName);
        this.mInitialized = true;
    }

    public void onMediaServiceConnected() {
        try {
            if (this.mList != null && this.mService.isPlaying() && Constants.TOP_MENU_PLAYLISTS.equals(this.mService.getCurrentListActivity()) && Long.toString((long) this.mPlaylistId.intValue()).equals(this.mService.getCurrentListToken())) {
                this.mList.setSelection(this.mService.getListPosition(), true);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onMediaServiceEvent(int aEvent) {
        switch (aEvent) {
            case 4:
                try {
                    this.mCurrentPlayableItem = this.mService.getCurrentItem();
                    this.mCurrentActivity = this.mService.getCurrentListActivity();
                    this.mCurrentActivityToken = this.mService.getCurrentListToken();
                    if (this.mAdapter != null) {
                        this.mAdapter.notifyDataSetChanged();
                    }
                    if (this.mJumpToPlayingItem && this.mList != null && this.mService.isPlaying() && Constants.TOP_MENU_PLAYLISTS.equals(this.mCurrentActivity) && this.mPlaylistIdentity.equals(this.mCurrentActivityToken)) {
                        this.mList.setSelection(Math.max(0, this.mService.getListPosition()), true);
                        return;
                    }
                    return;
                } catch (RemoteException e) {
                    return;
                }
            case 32:
            case SongbirdMedia.USER_PREVIOUS /*33*/:
                if (!this.mJumpToPlayingItem) {
                    this.mJumpToPlayingItem = true;
                    try {
                        if (this.mList != null && this.mService.isPlaying() && Constants.TOP_MENU_PLAYLISTS.equals(this.mCurrentActivity) && this.mPlaylistIdentity.equals(this.mCurrentActivityToken)) {
                            this.mList.setSelection(Math.max(0, this.mService.getListPosition()), true);
                            return;
                        }
                        return;
                    } catch (RemoteException e2) {
                        return;
                    }
                }
                return;
            default:
                super.onMediaServiceEvent(aEvent);
                return;
        }
    }

    public void onResume() {
        super.onResume();
        initPlaylistDetailsView();
        this.mJumpToPlayingItem = true;
        boolean backToList = false;
        Bundle extras = this.mActivity.getIntent().getExtras();
        if (extras != null) {
            backToList = extras.getBoolean(Constants.EXTRA_BACK_TO_LIST, false);
        }
        if (backToList) {
            jumpToPlayingItem();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.mEdit) {
            PlaylistExporter.exportPlaylistToFileAsync(this.mActivity.getApplicationContext(), this.mPlaylistId.intValue(), 1);
        }
    }

    public void onStop() {
        super.onStop();
        if (isScrollIdle()) {
            closeCursorsDelayed();
        }
    }

    private void closeCursorsDelayed() {
        ContentBrowser.getHandler().postDelayed(new C03495(), 100);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mInitialized = false;
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.mList == aView) {
            final AdapterContextMenuInfo adapterInfo = (AdapterContextMenuInfo) aMenuInfo;
            if (!this.mList.isShuffle(adapterInfo.position)) {
                this.mCursor.moveToPosition(this.mList.adjusted(adapterInfo.position));
                final String songTitle = this.mCursor.getString(this.mCursor.getColumnIndex("title"));
                aMenu.setHeaderTitle(songTitle);
                final int itemId = this.mCursor.getInt(this.mCursor.getColumnIndex("audio_id"));
                final String itemVolume = Utils.getVolumeFromCursor(this.mCursor);
                this.mUniqueIdsCursor.moveToPosition(this.mList.adjusted(adapterInfo.position));
                final int removalItemId = this.mUniqueIdsCursor.getInt(this.mUniqueIdsCursor.getColumnIndex("_id"));
                ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, itemId, itemVolume, songTitle, new Runnable() {
                    public void run() {
                        PlaylistDetailsView.this.mCursor.requery();
                        PlaylistDetailsView.this.mUniqueIdsCursor.requery();
                        PlaylistDetailsView.this.mAdapter.notifyDataSetChanged();
                    }
                }, true);
                final String str = itemVolume;
                final String str2 = songTitle;
                aMenu.add(C0116R.string.playlist_listing_menu_remove_item).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem aItem) {
                        Utils.removeFromMediaStorePlaylist(PlaylistDetailsView.this.mActivity, removalItemId, str, PlaylistDetailsView.this.mList.adjusted(adapterInfo.position), PlaylistDetailsView.this.mPlaylistId.intValue(), PlaylistDetailsView.this.mPlaylistVolume);
                        Utils.showShortToast(PlaylistDetailsView.this.mActivity.getApplicationContext(), PlaylistDetailsView.this.mActivity.getString(C0116R.string.playlist_removed_item_message, new Object[]{str2, PlaylistDetailsView.this.mPlaylistName}));
                        new Handler().post(/* anonymous class already generated */);
                        if (PlaylistDetailsView.this.mCursor.getCount() == 0) {
                            PlaylistDetailsView.this.mActivity.finish();
                        }
                        PlaylistDetailsView.this.mEdit = true;
                        return true;
                    }
                });
                if (Utils.hasPhone(this.mActivity)) {
                    aMenu.add(C0116R.string.playlist_listing_menu_set_ringtone).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            Utils.setItemAsRingtone(PlaylistDetailsView.this.mActivity, itemId, itemVolume);
                            Utils.showShortToast(PlaylistDetailsView.this.mActivity, PlaylistDetailsView.this.mActivity.getString(C0116R.string.playlist_set_ringtone_message, new Object[]{songTitle}));
                            return true;
                        }
                    });
                }
            }
        }
    }

    public View getPlaylistItemsList() {
        return this.mList;
    }

    protected void jumpToPlayingItem() {
        if (this.mJumpToPlayingItem) {
            try {
                if (this.mList != null && this.mService != null && this.mService.isPlaying() && Constants.TOP_MENU_PLAYLISTS.equals(this.mCurrentActivity) && this.mPlaylistIdentity.equals(this.mCurrentActivityToken)) {
                    this.mList.setSelection(Math.max(0, this.mService.getListPosition()), true);
                }
            } catch (RemoteException e) {
            }
        }
    }

    private String getPlaylistName() {
        Cursor c = MediaUtils.getMediaStoreMergeCursorForPlaylist(this.mActivity, new String[]{CookieTable.NAME}, "_id= ?", new String[]{Integer.toString(this.mPlaylistId.intValue())}, null);
        c.moveToFirst();
        String playlistName = c.getString(c.getColumnIndex(CookieTable.NAME));
        c.close();
        return playlistName;
    }

    private void openCursors() {
        String[] strArr = null;
        this.mUniqueIdsCursor = MediaUtils.getMediaStoreMergeCursorForPlaylist(this.mActivity, new String[]{"_id", "play_order"}, null, strArr, "play_order ASC", (long) this.mPlaylistId.intValue(), false);
        strArr = null;
        this.mCursor = MediaUtils.getMediaStoreMergeCursorForPlaylist(this.mActivity, new String[]{"_id", "audio_id", "title", "duration", "artist", "album", "title_key", "play_order"}, null, strArr, "play_order ASC", (long) this.mPlaylistId.intValue(), false);
    }

    private void closeCursors() {
        try {
            if (!(this.mUniqueIdsCursor == null || this.mUniqueIdsCursor.isClosed())) {
                this.mUniqueIdsCursor.close();
            }
            if (!(this.mCursor == null || this.mCursor.isClosed())) {
                this.mCursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mUniqueIdsCursor = null;
        this.mCursor = null;
    }
}
