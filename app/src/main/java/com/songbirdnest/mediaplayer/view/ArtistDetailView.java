package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.listObjects.AlbumInfo;
import com.songbirdnest.mediaplayer.listObjects.SongInfo;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.mediaplayer.widgets.ListView;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;
import com.songbirdnest.util.MediaUtils;
import java.util.List;

public class ArtistDetailView extends BaseContentBrowserView {
    private static final String VIEW_CATEGORY = "music:artists";
    private int currentSongID = -1;
    private SongAdapter mAdapter = new SongAdapter();
    private Cursor mAlbumCursor;
    private TextView mAlbumMenuItem;
    private String mArtistKey;
    private String mArtistName;
    private View mFooterView;
    private LayoutInflater mInflater;
    private boolean mJumpToPlayingItem = true;
    private int mLastAlbumsPosition = -1;
    private int mLastAlbumsTopOffset = 0;
    private int mLastSongsPosition = -1;
    private int mLastSongsTopOffset = 0;
    private ListView mList;
    private boolean mListInitialized = false;
    private TextView mSelectedSubMenuView;
    private boolean mShowingSongsList = true;
    private Cursor mSongCursor;
    private TextView mSongMenuItem;

    class C02171 implements OnItemClickListener {
        C02171() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (ArtistDetailView.this.mShowingSongsList) {
                List<PlayableItem> playableList = Utils.createPlayableListFromCursor(ArtistDetailView.this.mSongCursor);
                if (ArtistDetailView.this.mList.isShuffle(position)) {
                    ArtistDetailView.this.mJumpToPlayingItem = true;
                    ArtistDetailView.this.setPlayerList(playableList);
                    return;
                }
                try {
                    ViewWrapper playIcon = (ViewWrapper) view.getTag();
                    if (!playIcon.isPlaying()) {
                        ArtistDetailView.this.setPlayerList(playableList, ArtistDetailView.this.mList.adjusted(position));
                    } else if (playIcon.isPlaying() && ArtistDetailView.this.mService.isPaused()) {
                        ArtistDetailView.this.mService.play();
                    }
                } catch (Exception e) {
                }
            } else if (ArtistDetailView.this.mList.isShuffle(position)) {
                ArtistDetailView.this.mJumpToPlayingItem = true;
                ArtistDetailView.this.setPlayerList(Utils.createPlayableListFromCursor(ArtistDetailView.this.mSongCursor));
            } else {
                Intent i = new Intent(ArtistDetailView.this.mActivity, ContentBrowser.class);
                i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_ARTIST_ALBUM_DETAILS);
                i.putExtra(Constants.EXTRA_ALBUM_KEY, ArtistDetailView.this.getAlbumInfo(ArtistDetailView.this.mList.adjusted(position)).getAlbumKey());
                ArtistDetailView.this.mActivity.startActivity(i);
            }
        }
    }

    class C02182 implements OnClickListener {
        C02182() {
        }

        public void onClick(View v) {
            ArtistDetailView.this.showAlbumView();
        }
    }

    class C02193 implements OnClickListener {
        C02193() {
        }

        public void onClick(View v) {
            ArtistDetailView.this.showSongView();
        }
    }

    class C02204 implements OnScrollListener {
        C02204() {
        }

        public void onScrollStateChanged(AbsListView aView, int aScrollState) {
            if (aScrollState != 0) {
                ArtistDetailView.this.mJumpToPlayingItem = false;
            }
            ArtistDetailView.this.setScrollState(aScrollState);
            if (ArtistDetailView.this.isViewStopped() && ArtistDetailView.this.isScrollIdle()) {
                ArtistDetailView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (ArtistDetailView.this.mList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    ArtistDetailView.this.mList.removeFooterView(ArtistDetailView.this.mFooterView);
                } else if (ArtistDetailView.this.mList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    ArtistDetailView.this.mList.addFooterView(ArtistDetailView.this.mFooterView);
                }
            }
        }
    }

    class C02215 implements Runnable {
        C02215() {
        }

        public void run() {
            ArtistDetailView.this.closeCursors();
        }
    }

    class SongAdapter extends BaseAdapter {
        private Handler dataSetHandler = new C02231();
        private int mRowHeight = 50;

        class C02231 extends Handler {
            C02231() {
            }

            public void handleMessage(Message aMessage) {
                switch (aMessage.what) {
                    case 1:
                        ArtistDetailView.this.mAdapter.notifyDataSetChanged();
                        return;
                    default:
                        return;
                }
            }
        }

        class ViewWrapper {
            private ImageView mAlbumArt = null;
            private TextView mAlbumSongTotal = null;
            private TextView mAlbumTitle = null;
            private TextView mArtistName = null;
            private boolean mIsPlaying = false;
            private PlayIcon mPlayIcon = null;
            private TextView mSongDuration = null;
            private ImageView mSongPlayIcon = null;
            private TextView mSongTitle = null;
            private View mView;
            private String mViewType;

            public ViewWrapper(View aView) {
                this.mView = aView;
            }

            public ImageView albumArt() {
                if (this.mAlbumArt == null) {
                    this.mAlbumArt = (ImageView) this.mView.findViewById(C0116R.id.album_item_album_art);
                }
                return this.mAlbumArt;
            }

            public TextView albumTitle() {
                if (this.mAlbumTitle == null) {
                    this.mAlbumTitle = (TextView) this.mView.findViewById(C0116R.id.album_item_album_text);
                }
                return this.mAlbumTitle;
            }

            public TextView artistName() {
                if (this.mArtistName == null) {
                    this.mArtistName = (TextView) this.mView.findViewById(C0116R.id.album_item_artist_text);
                }
                return this.mArtistName;
            }

            public PlayIcon playIcon() {
                if (this.mPlayIcon == null) {
                    this.mPlayIcon = (PlayIcon) this.mView.findViewById(C0116R.id.album_item_play_icon);
                }
                return this.mPlayIcon;
            }

            public TextView songDuration() {
                if (this.mSongDuration == null) {
                    this.mSongDuration = (TextView) this.mView.findViewById(C0116R.id.song_item_song_duration);
                }
                return this.mSongDuration;
            }

            public TextView songTitle() {
                if (this.mSongTitle == null) {
                    this.mSongTitle = (TextView) this.mView.findViewById(C0116R.id.song_item_song_name);
                }
                return this.mSongTitle;
            }

            public ImageView songPlayIcon() {
                if (this.mSongPlayIcon == null) {
                    this.mSongPlayIcon = (ImageView) this.mView.findViewById(C0116R.id.song_item_play_button);
                }
                return this.mSongPlayIcon;
            }

            public TextView albumSongTotal() {
                if (this.mAlbumSongTotal == null) {
                    this.mAlbumSongTotal = (TextView) this.mView.findViewById(C0116R.id.album_item_song_total);
                }
                return this.mAlbumSongTotal;
            }

            public String viewType() {
                return this.mViewType;
            }

            public boolean isPlaying() {
                return this.mIsPlaying;
            }

            public void setListPosition(Integer position) {
                if (this.mSongPlayIcon == null) {
                    this.mSongPlayIcon = (PlayIcon) this.mView.findViewById(C0116R.id.song_item_play_button);
                }
                this.mSongPlayIcon.setTag(position);
            }

            public void setIsPlaying(boolean aIsPlaying) {
                this.mIsPlaying = aIsPlaying;
            }

            public void setViewType(String aViewType) {
                this.mViewType = aViewType;
            }

            public void setVisable(int aVisibility) {
                this.mView.setVisibility(aVisibility);
            }
        }

        SongAdapter() {
        }

        public int getCount() {
            if ((!ArtistDetailView.this.mShowingSongsList || (ArtistDetailView.this.mSongCursor != null && !ArtistDetailView.this.mSongCursor.isClosed())) && (ArtistDetailView.this.mShowingSongsList || (ArtistDetailView.this.mAlbumCursor != null && !ArtistDetailView.this.mAlbumCursor.isClosed()))) {
                return ArtistDetailView.this.mShowingSongsList ? ArtistDetailView.this.mSongCursor.getCount() : ArtistDetailView.this.mAlbumCursor.getCount();
            } else {
                return 0;
            }
        }

        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                if (ArtistDetailView.this.mShowingSongsList) {
                    convertView = createView(Constants.VIEW_SONG);
                } else {
                    convertView = createView(Constants.VIEW_ALBUM);
                }
            }
            ViewWrapper currentWrapper = (ViewWrapper) convertView.getTag();
            if (ArtistDetailView.this.mShowingSongsList) {
                if (currentWrapper.viewType().equals(Constants.VIEW_ALBUM)) {
                    convertView = createView(Constants.VIEW_SONG);
                    currentWrapper = (ViewWrapper) convertView.getTag();
                }
                SongInfo caster = ArtistDetailView.this.getSongInfo(position);
                caster.setSongLength(Utils.calculateTimeStamp(Integer.parseInt(caster.getSongLength())));
                populateSongViewInfo(currentWrapper, caster, Integer.valueOf(position));
            } else {
                if (currentWrapper.viewType().equals(Constants.VIEW_SONG)) {
                    convertView = createView(Constants.VIEW_ALBUM);
                    currentWrapper = (ViewWrapper) convertView.getTag();
                }
                populateAlbumViewInfo(convertView, currentWrapper, ArtistDetailView.this.getAlbumInfo(position));
            }
            return convertView;
        }

        private boolean albumPlaying(String albumKey) {
            try {
                return Constants.TOP_MENU_ALBUMS.equals(ArtistDetailView.this.mService.getCurrentListActivity()) && albumKey.equals(ArtistDetailView.this.mService.getCurrentListToken());
            } catch (Exception e) {
                return false;
            }
        }

        private View createView(String aSelectedMenuItem) {
            if (aSelectedMenuItem.equals(Constants.VIEW_SONG)) {
                View convertView = ArtistDetailView.this.mInflater.inflate(C0116R.layout.song_item, null);
                ViewWrapper wrapper = new ViewWrapper(convertView);
                wrapper.setViewType(Constants.VIEW_SONG);
                convertView.setTag(wrapper);
                return convertView;
            }
            convertView = ArtistDetailView.this.mInflater.inflate(C0116R.layout.album_item, null);
            wrapper = new ViewWrapper(convertView);
            wrapper.setViewType(Constants.VIEW_ALBUM);
            convertView.setTag(wrapper);
            return convertView;
        }

        private OnClickListener playIconClickListener(final ViewWrapper aWrapper, final AlbumInfo aCaster) {
            return new OnClickListener() {
                public void onClick(View v) {
                    try {
                        if (!aWrapper.playIcon().isPlaying()) {
                            Cursor songCursor = MediaUtils.getMediaStoreMergeCursor(ArtistDetailView.this.mActivity, new String[]{"_id", "title", Analytics.TRACK_KEY}, "album_key = ?", new String[]{(String) v.getTag()}, "track ASC");
                            ArtistDetailView.this.mService.setCurrentList(Constants.TOP_MENU_ALBUMS, aCaster.getAlbumKey());
                            ArtistDetailView.this.mService.setPlayableList(Utils.createPlayableListFromCursor(songCursor), 0);
                            songCursor.close();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            };
        }

        private void populateAlbumViewInfo(View aConvertView, ViewWrapper aWrapper, AlbumInfo aCaster) {
            aWrapper.albumTitle().setText(aCaster.getAlbumTitle());
            aWrapper.artistName().setText(aCaster.getAlbumArtist());
            aWrapper.albumSongTotal().setText(aConvertView.getResources().getQuantityString(C0116R.plurals.album_song_count, aCaster.getAlbumSongTotal().intValue(), new Object[]{Integer.valueOf(aCaster.getAlbumSongTotal().intValue())}));
            PlayIcon playIcon = aWrapper.playIcon();
            if (albumPlaying(aCaster.getAlbumKey())) {
                playIcon.setPlaying(true);
            } else {
                playIcon.setPlaying(false);
            }
            playIcon.setTag(aCaster.getAlbumKey());
            playIcon.setOnClickListener(playIconClickListener(aWrapper, aCaster));
            if (playIcon.getHeight() > 0) {
                this.mRowHeight = Utils.calculateAlbumArt(playIcon.getHeight());
                aWrapper.setVisable(0);
            } else {
                aWrapper.setVisable(4);
                this.dataSetHandler.sendEmptyMessageDelayed(1, 100);
            }
            if (aCaster.getAlbumArt() != null) {
                Bitmap albumArtBitmap = BitmapFactory.decodeFile(aCaster.getAlbumArt());
                if (albumArtBitmap == null) {
                    setDefaultAlbumArt(aWrapper);
                    return;
                }
                aWrapper.albumArt().setImageBitmap(Bitmap.createScaledBitmap(albumArtBitmap, this.mRowHeight, this.mRowHeight, true));
                albumArtBitmap.recycle();
                return;
            }
            setDefaultAlbumArt(aWrapper);
        }

        private void populateSongViewInfo(final ViewWrapper aWrapper, SongInfo aCaster, Integer aPosition) {
            aWrapper.songTitle().setText(aCaster.getSongTitle());
            aWrapper.songDuration().setText(aCaster.getSongLength());
            int column = ArtistDetailView.this.mSongCursor.getColumnIndexOrThrow("_id");
            ImageView songPlayIcon = aWrapper.songPlayIcon();
            if (songPlaying(ArtistDetailView.this.mSongCursor.getInt(column))) {
                songPlayIcon.setImageResource(C0116R.drawable.row_listening_button);
                aWrapper.setIsPlaying(true);
            } else {
                songPlayIcon.setImageResource(C0116R.drawable.row_play);
                aWrapper.setIsPlaying(false);
            }
            aWrapper.setListPosition(aPosition);
            songPlayIcon.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    try {
                        if (!aWrapper.isPlaying()) {
                            ArtistDetailView.this.setPlayerList(Utils.createPlayableListFromCursor(ArtistDetailView.this.mSongCursor), ((Integer) v.getTag()).intValue());
                        } else if (aWrapper.isPlaying() && ArtistDetailView.this.mService.isPaused()) {
                            ArtistDetailView.this.mService.play();
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }

        private void setDefaultAlbumArt(ViewWrapper wrapper) {
            Bitmap albumArtBitmap = BitmapFactory.decodeResource(ArtistDetailView.this.mActivity.getResources(), C0116R.drawable.generic_album_small);
            wrapper.albumArt().setImageBitmap(Bitmap.createScaledBitmap(albumArtBitmap, this.mRowHeight, this.mRowHeight, true));
            albumArtBitmap.recycle();
        }

        private boolean songPlaying(int titleKey) {
            try {
                return Constants.TOP_MENU_ARTISTS.equals(ArtistDetailView.this.mService.getCurrentListActivity()) && ArtistDetailView.this.currentSongID == titleKey;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public ArtistDetailView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_ARTIST_DETAILS);
        setViewCategory(VIEW_CATEGORY);
    }

    protected void initArtistView() {
        String artistKey = this.mActivity.getIntent().getExtras().getString(Constants.EXTRA_ARTIST_KEY);
        if ((this.mArtistKey == null || !this.mArtistKey.equals(artistKey)) && artistKey != null) {
            this.mArtistKey = artistKey;
            openCursors();
            Cursor artistCursor = MediaUtils.getMediaStoreMergeCursorForArtist(this.mActivity, new String[]{"artist"}, "artist_key = ?", new String[]{this.mArtistKey}, null, false);
            artistCursor.moveToFirst();
            this.mArtistName = artistCursor.getString(artistCursor.getColumnIndexOrThrow("artist"));
            artistCursor.close();
            setHeaderViewText(this.mArtistName);
            if (this.mListInitialized) {
                this.mAdapter.notifyDataSetChanged();
                this.mList.invalidateViews();
                return;
            }
            this.mInflater = LayoutInflater.from(this.mActivity);
            this.mSongMenuItem = (TextView) this.mView.findViewById(C0116R.id.artist_main_songs_label);
            this.mAlbumMenuItem = (TextView) this.mView.findViewById(C0116R.id.artist_main_album_label);
            Resources res = this.mActivity.getResources();
            this.mAlbumMenuItem.setText(res.getString(C0116R.string.album_header));
            this.mSongMenuItem.setText(res.getString(C0116R.string.songs_header));
            this.mList = (ListView) this.mView.findViewById(C0116R.id.artist_main_list);
            if (this.mAdapter.getCount() > 1) {
                this.mList.addHeaderView(this.mInflater.inflate(C0116R.layout.shuffle_view, null));
            }
            this.mList.setOnItemClickListener(new C02171());
            this.mAlbumMenuItem.setOnClickListener(new C02182());
            this.mSongMenuItem.setOnClickListener(new C02193());
            this.mList.setOnScrollListener(new C02204());
            this.mFooterView = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
            this.mList.addFooterView(this.mFooterView);
            this.mList.setAdapter(this.mAdapter);
            this.mList.removeFooterView(this.mFooterView);
            setContextMenuView(this.mList);
            this.mListInitialized = true;
            return;
        }
        openCursors();
    }

    public void onMediaServiceConnected() {
        super.onMediaServiceConnected();
        try {
            if (this.mList != null && this.mService.isPlaying() && Constants.TOP_MENU_ARTISTS.equals(this.mService.getCurrentListActivity()) && this.mArtistKey.equals(this.mService.getCurrentListToken())) {
                this.mList.setSelection(this.mService.getListPosition(), true);
            }
        } catch (RemoteException e) {
        }
    }

    public void onMediaServiceEvent(int aEvent) {
        super.onMediaServiceEvent(aEvent);
        switch (aEvent) {
            case 4:
                try {
                    this.currentSongID = this.mService.getCurrentSongToken();
                    this.mAdapter.notifyDataSetChanged();
                    jumpToPlayingItem();
                    return;
                } catch (RemoteException e) {
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
        initArtistView();
        registerContentObserver(this.mAlbumCursor, this.mAdapter, this.mList, getClass().getName() + "-Album", 1000);
        registerContentObserver(this.mSongCursor, this.mAdapter, this.mList, getClass().getName() + "-Song", 100);
        this.mJumpToPlayingItem = true;
        boolean backToList = false;
        Bundle extras = this.mActivity.getIntent().getExtras();
        if (extras != null) {
            backToList = extras.getBoolean(Constants.EXTRA_BACK_TO_LIST, false);
        }
        if (backToList) {
            showSongView();
            jumpToPlayingItem();
        } else if (this.mActivity.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).getString(PrefKeys.ARTIST_DETAILS_LAST_SUBVIEW, Constants.VIEW_SONG).equals(Constants.VIEW_ALBUM)) {
            showAlbumView();
        } else {
            showSongView();
        }
    }

    public void onPause() {
        super.onPause();
        Editor prefs = this.mActivity.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
        prefs.putString(PrefKeys.ARTIST_DETAILS_LAST_SUBVIEW, this.mShowingSongsList ? Constants.VIEW_SONG : Constants.VIEW_ALBUM);
        prefs.commit();
        unregisterContentObserver(this.mSongCursor, getClass().getName() + "-Song");
        unregisterContentObserver(this.mAlbumCursor, getClass().getName() + "-Album");
    }

    public void onStop() {
        super.onStop();
        if (isScrollIdle()) {
            closeCursorsDelayed();
        }
    }

    private void closeCursorsDelayed() {
        ContentBrowser.getHandler().postDelayed(new C02215(), 100);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mListInitialized = false;
    }

    protected void buildContextMenuForSongs(ContextMenu aMenu, View aView, AdapterContextMenuInfo aAdapterInfo) {
        this.mSongCursor.moveToPosition(this.mList.adjusted(aAdapterInfo.position));
        final String songTitle = this.mSongCursor.getString(this.mSongCursor.getColumnIndex("title"));
        aMenu.setHeaderTitle(songTitle);
        final int itemId = this.mSongCursor.getInt(this.mSongCursor.getColumnIndex("_id"));
        final String itemVolume = Utils.getVolumeFromCursor(this.mSongCursor);
        ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, itemId, itemVolume, songTitle, true);
        if (Utils.hasPhone(this.mActivity)) {
            aMenu.add(C0116R.string.playlist_listing_menu_set_ringtone).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem item) {
                    Utils.setItemAsRingtone(ArtistDetailView.this.mActivity, itemId, itemVolume);
                    Utils.showShortToast(ArtistDetailView.this.mActivity, ArtistDetailView.this.mActivity.getString(C0116R.string.playlist_set_ringtone_message, new Object[]{songTitle}));
                    return true;
                }
            });
        }
    }

    protected void buildContextMenuForAlbum(ContextMenu aMenu, View aView, AdapterContextMenuInfo aAdapterInfo) {
        this.mAlbumCursor.moveToPosition(this.mList.adjusted(aAdapterInfo.position));
        String albumTitle = this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndex("album"));
        aMenu.setHeaderTitle(albumTitle);
        String albumKey = this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndex("album_key"));
        String[] songsProj = new String[]{"_id", Analytics.TRACK_KEY};
        ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, MediaUtils.getMediaStoreMergeCursor(this.mActivity, songsProj, "album_key= ?", new String[]{albumKey}, "track ASC"), albumTitle, true);
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.mList == aView) {
            AdapterContextMenuInfo adapterInfo = (AdapterContextMenuInfo) aMenuInfo;
            if (!this.mList.isShuffle(adapterInfo.position)) {
                if (this.mShowingSongsList) {
                    buildContextMenuForSongs(aMenu, aView, adapterInfo);
                } else {
                    buildContextMenuForAlbum(aMenu, aView, adapterInfo);
                }
            }
        }
    }

    private AlbumInfo getAlbumInfo(int aPosition) {
        AlbumInfo albumInfo = new AlbumInfo();
        this.mAlbumCursor.moveToPosition(aPosition);
        try {
            albumInfo.setAlbumArtist(this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndexOrThrow("artist")));
            albumInfo.setAlbumSongTotal(Integer.valueOf(this.mAlbumCursor.getInt(this.mAlbumCursor.getColumnIndexOrThrow("numsongs"))));
            albumInfo.setAlbumTitle(this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndexOrThrow("album")));
            albumInfo.setAlbumKey(this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndexOrThrow("album_key")));
            albumInfo.setAlbumArt(this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndexOrThrow("album_art")));
        } catch (Exception e) {
            albumInfo.setAlbumArtist("<Unknown>");
            albumInfo.setAlbumSongTotal(Integer.valueOf(0));
            albumInfo.setAlbumTitle(e.getLocalizedMessage());
        }
        return albumInfo;
    }

    private SongInfo getSongInfo(int aPosition) {
        SongInfo songInfo = new SongInfo();
        this.mSongCursor.moveToPosition(aPosition);
        try {
            songInfo.setSongLength(Integer.toString(this.mSongCursor.getInt(Integer.valueOf(this.mSongCursor.getColumnIndexOrThrow("duration")).intValue())));
            songInfo.setSongTitle(this.mSongCursor.getString(Integer.valueOf(this.mSongCursor.getColumnIndexOrThrow("title")).intValue()));
            songInfo.setSongPath(this.mSongCursor.getString(Integer.valueOf(this.mSongCursor.getColumnIndexOrThrow("_data")).intValue()));
            songInfo.setSongID(this.mSongCursor.getInt(Integer.valueOf(this.mSongCursor.getColumnIndexOrThrow("_id")).intValue()));
        } catch (Exception e) {
            songInfo.setSongTitle(e.getLocalizedMessage());
            songInfo.setSongLength("0");
        }
        return songInfo;
    }

    private void openCursors() {
        this.mAlbumCursor = MediaUtils.getMediaStoreMergeCursorForArtistAlbum(this.mActivity, new String[]{"album", "numsongs", "artist", "album_key", "album_art"}, null, null, "album_key ASC", this.mArtistKey, false);
        this.mSongCursor = MediaUtils.getMediaStoreMergeCursor(this.mActivity, new String[]{"_id", "title", "duration", "_data", "title_key"}, "artist_key = ?", new String[]{this.mArtistKey}, "title_key ASC");
    }

    private void closeCursors() {
        try {
            if (!(this.mAlbumCursor == null || this.mAlbumCursor.isClosed())) {
                this.mAlbumCursor.close();
            }
            if (!(this.mSongCursor == null || this.mSongCursor.isClosed())) {
                this.mSongCursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mAlbumCursor = null;
        this.mSongCursor = null;
    }

    private void showSongView() {
        if (this.mList.getChildCount() > 0) {
            this.mLastAlbumsPosition = this.mList.getFirstVisiblePosition();
            this.mLastAlbumsTopOffset = this.mList.getChildAt(0).getTop();
        }
        this.mShowingSongsList = true;
        selectSubMenu(this.mSongMenuItem);
        this.mAdapter.notifyDataSetChanged();
        if (this.mLastSongsPosition != -1) {
            this.mList.setSelectionFromTop(this.mLastSongsPosition, this.mLastSongsTopOffset);
        }
        Analytics.getAnalytics().track("/music/artists/<artist_name>/songs");
    }

    private void showAlbumView() {
        if (this.mList.getChildCount() > 0) {
            this.mLastSongsPosition = this.mList.getFirstVisiblePosition();
            this.mLastSongsTopOffset = this.mList.getChildAt(0).getTop();
        }
        this.mShowingSongsList = false;
        selectSubMenu(this.mAlbumMenuItem);
        this.mAdapter.notifyDataSetChanged();
        if (this.mLastAlbumsPosition != -1) {
            this.mList.setSelectionFromTop(this.mLastAlbumsPosition, this.mLastAlbumsTopOffset);
        }
        Analytics.getAnalytics().track("/music/artists/<artist_name>/albums");
    }

    private void selectSubMenu(TextView aSelectedView) {
        if (this.mSelectedSubMenuView != null) {
            this.mSelectedSubMenuView.setSelected(false);
        }
        if (this.mList.getFooterViewsCount() > 0) {
            this.mList.removeFooterView(this.mFooterView);
        }
        this.mSelectedSubMenuView = aSelectedView;
        this.mSelectedSubMenuView.setSelected(true);
    }

    private void setPlayerList(List<PlayableItem> aList) {
        try {
            this.mService.setCurrentList(Constants.TOP_MENU_ARTISTS, this.mArtistKey);
            this.mService.setShuffledPlayableList(aList);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void setPlayerList(List<PlayableItem> aList, int aPosition) {
        try {
            this.mService.setCurrentList(Constants.TOP_MENU_ARTISTS, this.mArtistKey);
            this.mService.setPlayableList(aList, aPosition);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    protected void jumpToPlayingItem() {
        if (this.mJumpToPlayingItem) {
            try {
                if (this.mService != null && this.mList != null && Constants.TOP_MENU_ARTISTS.equals(this.mService.getCurrentListActivity()) && this.mArtistKey.equals(this.mService.getCurrentListToken())) {
                    this.mList.setSelection(Math.max(0, this.mService.getListPosition()), true);
                }
            } catch (RemoteException e) {
            }
        }
    }
}
