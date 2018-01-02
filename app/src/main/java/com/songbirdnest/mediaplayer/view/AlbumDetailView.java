package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.ContextMenuUtils;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.mediaplayer.widgets.ListView;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;
import com.songbirdnest.util.MediaUtils;

public class AlbumDetailView extends BaseContentBrowserView {
    protected static final String VIEW_CATEGORY = "music:albums";
    private SongListAdapter mAdapter = new SongListAdapter();
    private ImageView mAlbumArt;
    private Cursor mAlbumCursor;
    private String mAlbumKey;
    private String mAlbumName;
    private ListView mAlbumSongList;
    private boolean mAlbumSongListInitialized = false;
    private TextView mAlbumSongTotal;
    private TextView mArtistName;
    private String mCurrentActivity = "";
    private PlayableItem mCurrentPlayableItem = new PlayableItem("<UNKNOWN>", null, -1, -1);
    private View mFooterView;
    private String mGenreName;
    private LayoutInflater mInflater;
    private boolean mJumpToPlayingItem = true;
    private Cursor mSongCursor;

    class C02071 implements Runnable {
        C02071() {
        }

        public void run() {
            AlbumDetailView.this.closeCursors();
        }
    }

    class C02093 implements OnItemClickListener {
        C02093() {
        }

        public void onItemClick(AdapterView<?> adapterView, View aView, int aPosition, long aId) {
            try {
                AlbumDetailView.this.mService.setCurrentList(Constants.TOP_MENU_ALBUMS, AlbumDetailView.this.mAlbumKey);
                Boolean isPlaying = (Boolean) aView.getTag();
                if (AlbumDetailView.this.mAlbumSongList.isShuffle(aPosition)) {
                    AlbumDetailView.this.mJumpToPlayingItem = true;
                    AlbumDetailView.this.mService.setShuffledPlayableList(Utils.createPlayableListFromCursor(AlbumDetailView.this.mSongCursor));
                } else if (!isPlaying.booleanValue()) {
                    AlbumDetailView.this.mJumpToPlayingItem = true;
                    AlbumDetailView.this.mService.setPlayableList(Utils.createPlayableListFromCursor(AlbumDetailView.this.mSongCursor), AlbumDetailView.this.mAlbumSongList.adjusted(aPosition));
                } else if (isPlaying.booleanValue() && AlbumDetailView.this.mService.isPaused()) {
                    AlbumDetailView.this.mService.play();
                }
            } catch (Exception e) {
            }
        }
    }

    class C02104 implements OnScrollListener {
        C02104() {
        }

        public void onScrollStateChanged(AbsListView aView, int aScrollState) {
            if (aScrollState != 0) {
                AlbumDetailView.this.mJumpToPlayingItem = false;
            }
            AlbumDetailView.this.setScrollState(aScrollState);
            if (AlbumDetailView.this.isViewStopped() && AlbumDetailView.this.isScrollIdle()) {
                AlbumDetailView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (AlbumDetailView.this.mAlbumSongList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    AlbumDetailView.this.mAlbumSongList.removeFooterView(AlbumDetailView.this.mFooterView);
                } else if (AlbumDetailView.this.mAlbumSongList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    AlbumDetailView.this.mAlbumSongList.addFooterView(AlbumDetailView.this.mFooterView);
                }
            }
        }
    }

    class SongListAdapter extends BaseAdapter {
        SongListAdapter() {
        }

        public int getCount() {
            if (AlbumDetailView.this.mSongCursor == null || AlbumDetailView.this.mSongCursor.isClosed()) {
                return 0;
            }
            return AlbumDetailView.this.mSongCursor.getCount();
        }

        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(final int aPosition, View aConvertView, ViewGroup aParent) {
            AlbumDetailView.this.mSongCursor.moveToPosition(aPosition);
            if (aConvertView == null) {
                aConvertView = AlbumDetailView.this.mInflater.inflate(C0116R.layout.album_song_item, null);
            }
            String songTitle = AlbumDetailView.this.mSongCursor.getString(AlbumDetailView.this.mSongCursor.getColumnIndexOrThrow("title"));
            String songDuration = Utils.calculateTimeStamp(AlbumDetailView.this.mSongCursor.getInt(AlbumDetailView.this.mSongCursor.getColumnIndexOrThrow("duration")));
            ((TextView) aConvertView.findViewById(C0116R.id.album_song_item_song_name)).setText(songTitle);
            ((TextView) aConvertView.findViewById(C0116R.id.album_song_item_song_duration)).setText(songDuration);
            PlayIcon playIcon = (PlayIcon) aConvertView.findViewById(C0116R.id.album_song_item_play_icon);
            int column = AlbumDetailView.this.mSongCursor.getColumnIndexOrThrow("_id");
            final PlayableItem item = Utils.createPlayableItemFromCursor(AlbumDetailView.this.mSongCursor);
            if (songPlaying(item)) {
                playIcon.setPlaying(true);
                aConvertView.setTag(new Boolean(true));
            } else {
                playIcon.setPlaying(false);
                aConvertView.setTag(new Boolean(false));
            }
            playIcon.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    try {
                        if (!SongListAdapter.this.songPlaying(item)) {
                            AlbumDetailView.this.mService.setCurrentList(Constants.TOP_MENU_ALBUMS, AlbumDetailView.this.mAlbumKey);
                            AlbumDetailView.this.mService.setPlayableList(Utils.createPlayableListFromCursor(AlbumDetailView.this.mSongCursor), aPosition);
                        } else if (SongListAdapter.this.songPlaying(item) && AlbumDetailView.this.mService.isPaused()) {
                            AlbumDetailView.this.mService.play();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
            return aConvertView;
        }

        private boolean songPlaying(PlayableItem aItem) {
            return Constants.TOP_MENU_ALBUMS.equals(AlbumDetailView.this.mCurrentActivity) && aItem.mStorageVolume.equals(AlbumDetailView.this.mCurrentPlayableItem.mStorageVolume) && aItem.mID == AlbumDetailView.this.mCurrentPlayableItem.mID;
        }
    }

    public AlbumDetailView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_ALBUM_DETAILS);
        setViewCategory(VIEW_CATEGORY);
    }

    public void onMediaServiceConnected() {
        super.onMediaServiceConnected();
        try {
            if (this.mService.isPlaying() && Constants.TOP_MENU_ALBUMS.equals(this.mService.getCurrentListActivity()) && this.mAlbumKey != null && this.mAlbumKey.equals(this.mService.getCurrentListToken())) {
                this.mAlbumSongList.setSelection(this.mService.getListPosition(), true);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onMediaServiceEvent(int aEvent) {
        super.onMediaServiceEvent(aEvent);
        switch (aEvent) {
            case 4:
                try {
                    this.mCurrentPlayableItem = this.mService.getCurrentItem();
                    this.mCurrentActivity = this.mService.getCurrentListActivity();
                    this.mAdapter.notifyDataSetChanged();
                    jumpToPlayingItem();
                    return;
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return;
                }
            case 32:
            case SongbirdMedia.USER_PREVIOUS /*33*/:
                if (!this.mJumpToPlayingItem) {
                    this.mJumpToPlayingItem = true;
                    jumpToPlayingItem();
                    return;
                }
                return;
            default:
                super.onMediaServiceEvent(aEvent);
                return;
        }
    }

    public void onResume() {
        super.onResume();
        initAlbumView();
        setScreenOrientation(getScreenOrientation());
        this.mJumpToPlayingItem = true;
        boolean backToList = false;
        Bundle extras = this.mActivity.getIntent().getExtras();
        if (extras != null) {
            backToList = extras.getBoolean(Constants.EXTRA_BACK_TO_LIST, false);
        }
        if (backToList) {
            jumpToPlayingItem();
        } else if (this.mAlbumSongList != null) {
            this.mAlbumSongList.setSelection(0);
        }
    }

    public void onPause() {
        super.onPause();
        unregisterContentObserver(this.mSongCursor, getClass().getName());
    }

    public void onStop() {
        super.onStop();
        if (isScrollIdle()) {
            closeCursorsDelayed();
        }
    }

    private void closeCursorsDelayed() {
        ContentBrowser.getHandler().postDelayed(new C02071(), 100);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.mAlbumSongList == aView) {
            AdapterContextMenuInfo adapterInfo = (AdapterContextMenuInfo) aMenuInfo;
            if (!this.mAlbumSongList.isShuffle(adapterInfo.position)) {
                this.mSongCursor.moveToPosition(this.mAlbumSongList.adjusted(adapterInfo.position));
                final String songTitle = this.mSongCursor.getString(this.mSongCursor.getColumnIndex("title"));
                aMenu.setHeaderTitle(songTitle);
                final int itemId = this.mSongCursor.getInt(this.mSongCursor.getColumnIndex("_id"));
                final String itemVolume = Utils.getVolumeFromCursor(this.mSongCursor);
                ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, itemId, itemVolume, songTitle, true);
                if (Utils.hasPhone(this.mActivity)) {
                    aMenu.add(C0116R.string.playlist_listing_menu_set_ringtone).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            Utils.setItemAsRingtone(AlbumDetailView.this.mActivity, itemId, itemVolume);
                            Utils.showShortToast(AlbumDetailView.this.mActivity, AlbumDetailView.this.mActivity.getString(C0116R.string.playlist_set_ringtone_message, new Object[]{songTitle}));
                            return true;
                        }
                    });
                }
            }
        }
    }

    private void initAlbumView() {
        String albumKey = this.mActivity.getIntent().getExtras().getString(Constants.EXTRA_ALBUM_KEY);
        if (this.mAlbumKey == null || !this.mAlbumKey.equals(albumKey)) {
            this.mAlbumKey = albumKey;
            this.mGenreName = this.mActivity.getIntent().getStringExtra(Constants.EXTRA_GENRE_NAME);
            openCursors();
            this.mArtistName = (TextView) this.mView.findViewById(C0116R.id.artist_name);
            this.mAlbumSongTotal = (TextView) this.mView.findViewById(C0116R.id.album_song_total);
            this.mAlbumArt = (ImageView) this.mView.findViewById(C0116R.id.album_art);
            initAlbumDetails();
            this.mInflater = LayoutInflater.from(this.mActivity);
            if (this.mAlbumSongListInitialized) {
                this.mAdapter.notifyDataSetChanged();
                this.mAlbumSongList.invalidateViews();
                return;
            }
            this.mAlbumSongList = (ListView) this.mView.findViewById(C0116R.id.album_song_list);
            if (this.mAdapter.getCount() > 1) {
                this.mAlbumSongList.addHeaderView(this.mInflater.inflate(C0116R.layout.shuffle_view, null));
            }
            this.mAlbumSongList.setAdapter(this.mAdapter);
            this.mAlbumSongList.setOnItemClickListener(new C02093());
            this.mAlbumSongList.setOnScrollListener(new C02104());
            this.mFooterView = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
            setContextMenuView(this.mAlbumSongList);
            setViewAnalyticsUri("/music/albums/<album_name>");
            registerContentObserver(this.mSongCursor, this.mAdapter, this.mAlbumSongList, getClass().getName(), 500);
            this.mAlbumSongListInitialized = true;
            return;
        }
        openCursors();
    }

    private void openCursors() {
        String[] albumArgs = new String[]{this.mAlbumKey};
        this.mAlbumCursor = MediaUtils.getMediaStoreMergeCursorForAlbum(this.mActivity, new String[]{"album_key", "album", "artist", "numsongs", "album_art"}, "album_key= ?", albumArgs, null);
        this.mAlbumCursor.moveToFirst();
        String[] songsProj = new String[]{"_id", "_data", "album_key", Analytics.TRACK_KEY, "title", "duration", "title_key"};
        String songsSelection = "album_key= ?";
        String songsSort = "track ASC";
        if (this.mGenreName == null) {
            this.mSongCursor = MediaUtils.getMediaStoreMergeCursor(this.mActivity, songsProj, songsSelection, albumArgs, songsSort);
        } else {
            this.mSongCursor = MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, songsProj, songsSelection, albumArgs, songsSort, this.mGenreName);
        }
    }

    private void closeCursors() {
        try {
            if (!(this.mSongCursor == null || this.mSongCursor.isClosed())) {
                this.mSongCursor.close();
            }
            if (!(this.mAlbumCursor == null || this.mAlbumCursor.isClosed())) {
                this.mAlbumCursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mSongCursor = null;
        this.mAlbumCursor = null;
    }

    private void initAlbumDetails() {
        this.mAlbumName = this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndexOrThrow("album"));
        setHeaderViewText(this.mAlbumName);
        this.mArtistName.setText(this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndexOrThrow("artist")));
        int column = this.mAlbumCursor.getColumnIndexOrThrow("numsongs");
        this.mAlbumSongTotal.setText(this.mActivity.getApplicationContext().getResources().getQuantityString(C0116R.plurals.album_song_count, this.mAlbumCursor.getInt(column), new Object[]{Integer.valueOf(this.mAlbumCursor.getInt(column))}));
        String folderAlbumartPath = getFolderAlbumartPath();
        if (folderAlbumartPath != null) {
            this.mAlbumArt.setImageURI(Uri.parse(folderAlbumartPath));
            return;
        }
        String albumArtString = this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndexOrThrow("album_art"));
        if (albumArtString == null) {
            setDefaultAlbumArt();
        } else if (BitmapFactory.decodeFile(albumArtString) == null) {
            setDefaultAlbumArt();
        } else {
            this.mAlbumArt.setImageURI(Uri.parse(albumArtString));
        }
    }

    private void setScreenOrientation(int orientation) {
        View albumDetails = this.mView.findViewById(C0116R.id.album_details_sort);
        if (orientation == 2) {
            albumDetails.setVisibility(8);
        } else if (orientation == 1) {
            albumDetails.setVisibility(0);
        }
    }

    private String getFolderAlbumartPath() {
        String playablePath = getPlayablePath();
        String playableAlbumKey = getPlayableAlbumKey();
        if (playablePath == null || playablePath.length() == 0 || playableAlbumKey == null || playableAlbumKey.length() == 0) {
            return null;
        }
        String folderAlbumartPath = Utils.getAlbumArtPath(playablePath, playableAlbumKey);
        if (folderAlbumartPath == null) {
            folderAlbumartPath = Utils.getEmbeddedPicture(playablePath, playableAlbumKey);
            if (folderAlbumartPath == null) {
                return null;
            }
        }
        Bitmap folderAlbumartBitmap = BitmapFactory.decodeFile(folderAlbumartPath);
        if (folderAlbumartBitmap == null) {
            return null;
        }
        folderAlbumartBitmap.recycle();
        return folderAlbumartPath;
    }

    private String getPlayablePath() {
        this.mSongCursor.moveToFirst();
        String playablePath = this.mSongCursor.getString(this.mSongCursor.getColumnIndex("_data"));
        this.mSongCursor.moveToFirst();
        return playablePath;
    }

    private String getPlayableAlbumKey() {
        this.mSongCursor.moveToFirst();
        String playableAlbumKey = this.mSongCursor.getString(this.mSongCursor.getColumnIndex("album_key"));
        this.mSongCursor.moveToFirst();
        return playableAlbumKey;
    }

    private void setDefaultAlbumArt() {
        this.mAlbumArt.setImageResource(C0116R.drawable.generic_album_big);
    }

    protected void jumpToPlayingItem() {
        if (this.mJumpToPlayingItem) {
            try {
                if (this.mService != null && Constants.TOP_MENU_ALBUMS.equals(this.mService.getCurrentListActivity()) && this.mAlbumKey != null && this.mAlbumKey.equals(this.mService.getCurrentListToken()) && this.mAlbumSongList != null) {
                    this.mAlbumSongList.setSelection(Math.max(0, this.mService.getListPosition()), true);
                }
            } catch (RemoteException e) {
            }
        }
    }
}
