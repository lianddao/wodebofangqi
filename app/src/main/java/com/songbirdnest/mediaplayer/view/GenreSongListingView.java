package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.database.Cursor;
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
import android.widget.ListView;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.ContextMenuUtils;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.util.MediaUtils;
import java.util.List;

public class GenreSongListingView extends BaseContentBrowserView {
    private static final String VIEW_CATEGORY = "music:genres";
    private GenreSongAdapter mAdapter;
    private String mAlbumKey;
    private String mAlbumName;
    private String mArtistKey;
    private String mArtistName;
    private View mFooter;
    private String mGenreName;
    private String mHeaderText;
    private LayoutInflater mInflater;
    private boolean mInitialized = false;
    private Cursor mSongCursor;
    private ListView mSongList;

    class C02541 implements OnItemClickListener {
        C02541() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
            try {
                Boolean isPlaying = (Boolean) view.getTag();
                if (isPlaying.booleanValue()) {
                    if (isPlaying.booleanValue() && GenreSongListingView.this.mService.isPaused()) {
                        GenreSongListingView.this.mService.play();
                    }
                } else if (GenreSongListingView.this.mArtistKey != null || GenreSongListingView.this.mAlbumKey != null) {
                    String[] songlist = GenreSongListingView.this.buildSongList();
                    if (GenreSongListingView.this.mArtistKey != null) {
                        GenreSongListingView.this.mService.setCurrentList(Constants.TOP_MENU_ARTISTS, GenreSongListingView.this.mArtistKey);
                    } else if (GenreSongListingView.this.mAlbumKey != null) {
                        GenreSongListingView.this.mService.setCurrentList(Constants.TOP_MENU_ALBUMS, GenreSongListingView.this.mAlbumKey);
                    }
                    GenreSongListingView.this.mService.setPlayableList(GenreSongListingView.this.keysToPlayableList(songlist), position);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    class C02552 implements OnScrollListener {
        C02552() {
        }

        public void onScrollStateChanged(AbsListView aView, int aScrollState) {
            GenreSongListingView.this.setScrollState(aScrollState);
            if (GenreSongListingView.this.isViewStopped() && GenreSongListingView.this.isScrollIdle()) {
                GenreSongListingView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (GenreSongListingView.this.mSongList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    GenreSongListingView.this.mSongList.removeFooterView(GenreSongListingView.this.mFooter);
                } else if (GenreSongListingView.this.mSongList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    GenreSongListingView.this.mSongList.addFooterView(GenreSongListingView.this.mFooter);
                }
            }
        }
    }

    class C02563 implements Runnable {
        C02563() {
        }

        public void run() {
            GenreSongListingView.this.closeCursors();
        }
    }

    class GenreSongAdapter extends BaseAdapter {
        GenreSongAdapter() {
        }

        public int getCount() {
            if (GenreSongListingView.this.mSongCursor == null || GenreSongListingView.this.mSongCursor.isClosed()) {
                return 0;
            }
            return GenreSongListingView.this.mSongCursor.getCount();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(final int aPosition, View aConvertView, ViewGroup aParent) {
            GenreSongListingView.this.mSongCursor.moveToPosition(aPosition);
            if (aConvertView == null) {
                aConvertView = GenreSongListingView.this.mInflater.inflate(C0116R.layout.song_item, null);
            }
            ((TextView) aConvertView.findViewById(C0116R.id.song_item_song_name)).setText(GenreSongListingView.this.mSongCursor.getString(GenreSongListingView.this.mSongCursor.getColumnIndex("title")));
            ((TextView) aConvertView.findViewById(C0116R.id.song_item_song_duration)).setText(Utils.calculateTimeStamp(GenreSongListingView.this.mSongCursor.getInt(GenreSongListingView.this.mSongCursor.getColumnIndex("duration"))));
            final int titleKey = GenreSongListingView.this.mSongCursor.getInt(GenreSongListingView.this.mSongCursor.getColumnIndex("_id"));
            ImageView playIcon = (ImageView) aConvertView.findViewById(C0116R.id.song_item_play_button);
            if (songPlaying(titleKey)) {
                aConvertView.setTag(new Boolean(true));
                playIcon.setImageResource(C0116R.drawable.row_listening_button);
            } else {
                aConvertView.setTag(new Boolean(false));
                playIcon.setImageResource(C0116R.drawable.row_play);
            }
            playIcon.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    try {
                        if (!GenreSongAdapter.this.songPlaying(titleKey)) {
                            if (GenreSongListingView.this.mArtistKey != null) {
                                GenreSongListingView.this.mService.setCurrentList(Constants.TOP_MENU_ARTISTS, GenreSongListingView.this.mArtistKey);
                            } else if (GenreSongListingView.this.mAlbumKey != null) {
                                GenreSongListingView.this.mService.setCurrentList(Constants.TOP_MENU_ALBUMS, GenreSongListingView.this.mAlbumKey);
                            } else {
                                return;
                            }
                            GenreSongListingView.this.mService.setPlayableList(GenreSongListingView.this.keysToPlayableList(GenreSongListingView.this.buildSongList()), aPosition);
                        } else if (GenreSongAdapter.this.songPlaying(titleKey) && GenreSongListingView.this.mService.isPaused()) {
                            GenreSongListingView.this.mService.play();
                        }
                    } catch (Exception e) {
                    }
                }
            });
            return aConvertView;
        }

        private boolean songPlaying(int titleKey) {
            try {
                String currentActivity = GenreSongListingView.this.mService.getCurrentListActivity();
                int currentTitleKey = GenreSongListingView.this.mService.getCurrentSongToken();
                if (GenreSongListingView.this.mArtistKey != null) {
                    if (Constants.TOP_MENU_ARTISTS.equals(currentActivity) && titleKey == currentTitleKey) {
                        return true;
                    }
                    return false;
                } else if (GenreSongListingView.this.mAlbumKey == null) {
                    return false;
                } else {
                    if (Constants.TOP_MENU_ALBUMS.equals(currentActivity) && titleKey == currentTitleKey) {
                        return true;
                    }
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
    }

    public GenreSongListingView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_GENRE_SONG_LIST);
        setViewCategory(VIEW_CATEGORY);
    }

    private void initGenreSongListingView() {
        String prevGenre = this.mGenreName;
        String prevArtistKey = this.mArtistKey;
        String prevAlbumKey = this.mAlbumKey;
        this.mGenreName = this.mActivity.getIntent().getStringExtra(Constants.EXTRA_GENRE_NAME);
        this.mArtistKey = this.mActivity.getIntent().getStringExtra(Constants.EXTRA_ARTIST_KEY);
        this.mAlbumKey = this.mActivity.getIntent().getStringExtra(Constants.EXTRA_ALBUM_KEY);
        if (!this.mInitialized || prevGenre == null || !prevGenre.equals(this.mGenreName) || ((prevArtistKey == null || !prevArtistKey.equals(this.mArtistKey)) && (prevAlbumKey == null || !prevAlbumKey.equals(this.mAlbumKey)))) {
            String analyticsUri = "/music/genres/<genre_name>";
            this.mInflater = LayoutInflater.from(this.mActivity);
            this.mSongList = (ListView) this.mView.findViewById(C0116R.id.song_listing_song_list);
            if (this.mActivity.getIntent().getStringExtra(Constants.EXTRA_ARTIST_KEY) != null) {
                this.mArtistName = getHeaderText(Constants.EXTRA_ARTIST_KEY);
                this.mHeaderText = this.mArtistName;
                analyticsUri = analyticsUri + "/artists<artist_name>";
            } else if (this.mActivity.getIntent().getStringExtra(Constants.EXTRA_ALBUM_KEY) != null) {
                this.mAlbumName = getHeaderText(Constants.EXTRA_ALBUM_KEY);
                this.mHeaderText = this.mAlbumName;
                analyticsUri = analyticsUri + "/albums<album_name>";
            }
            setViewAnalyticsUri(analyticsUri + Analytics.EVENTPART_SONGS);
            openCursors();
            this.mAdapter = new GenreSongAdapter();
            this.mFooter = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
            this.mSongList.addFooterView(this.mFooter);
            this.mSongList.setAdapter(this.mAdapter);
            this.mSongList.removeFooterView(this.mFooter);
            this.mSongList.setOnItemClickListener(new C02541());
            this.mSongList.setOnScrollListener(new C02552());
            setContextMenuView(this.mSongList);
            setHeaderViewText(this.mHeaderText);
            this.mInitialized = true;
            return;
        }
        openCursors();
    }

    public void onMediaServiceEvent(int aEvent) {
        super.onMediaServiceEvent(aEvent);
        switch (aEvent) {
            case 4:
                if (this.mAdapter != null) {
                    this.mAdapter.notifyDataSetChanged();
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
        initGenreSongListingView();
        registerContentObserver(this.mSongCursor, this.mAdapter, this.mSongList, getClass().getName(), 500);
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
        ContentBrowser.getHandler().postDelayed(new C02563(), 100);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mInitialized = true;
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.mSongList == aView) {
            this.mSongCursor.moveToPosition(((AdapterContextMenuInfo) aMenuInfo).position);
            final String songTitle = this.mSongCursor.getString(this.mSongCursor.getColumnIndex("title"));
            aMenu.setHeaderTitle(songTitle);
            final int itemId = this.mSongCursor.getInt(this.mSongCursor.getColumnIndex("_id"));
            final String itemVolume = Utils.getVolumeFromCursor(this.mSongCursor);
            ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, itemId, itemVolume, songTitle, true);
            if (Utils.hasPhone(this.mActivity)) {
                aMenu.add(C0116R.string.playlist_listing_menu_set_ringtone).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Utils.setItemAsRingtone(GenreSongListingView.this.mActivity, itemId, itemVolume);
                        Utils.showShortToast(GenreSongListingView.this.mActivity, GenreSongListingView.this.mActivity.getString(C0116R.string.playlist_set_ringtone_message, new Object[]{songTitle}));
                        return true;
                    }
                });
            }
        }
    }

    private List<PlayableItem> keysToPlayableList(String[] aKeys) {
        String queryString = "title_key = ?";
        for (int i = 1; i < aKeys.length; i++) {
            queryString = queryString + " OR title_key= ?";
        }
        String sort = "title_key ASC";
        if (this.mActivity.getIntent().getStringExtra(Constants.EXTRA_ALBUM_KEY) != null) {
            sort = "track ASC";
        }
        Cursor cursor = MediaUtils.getMediaStoreMergeCursor(this.mActivity, new String[]{"_id", "title_key"}, queryString, aKeys, sort);
        List<PlayableItem> playableList = Utils.createPlayableListFromCursor(cursor);
        cursor.close();
        return playableList;
    }

    private String getHeaderText(String type) {
        Cursor cursor;
        String headerText;
        if (Constants.EXTRA_ALBUM_KEY.equals(type)) {
            cursor = MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"album"}, "album_key = ?", new String[]{this.mAlbumKey}, null, this.mGenreName);
            cursor.moveToFirst();
            headerText = cursor.getString(cursor.getColumnIndex("album"));
            cursor.close();
            return headerText;
        } else if (!Constants.EXTRA_ARTIST_KEY.equals(type)) {
            return "";
        } else {
            cursor = MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"artist"}, "artist_key = ?", new String[]{this.mArtistKey}, null, this.mGenreName);
            cursor.moveToFirst();
            headerText = cursor.getString(cursor.getColumnIndex("artist"));
            cursor.close();
            return headerText;
        }
    }

    private String[] buildSongList() {
        int count = this.mSongCursor.getCount();
        String[] songlist = new String[count];
        int column = this.mSongCursor.getColumnIndexOrThrow("title_key");
        for (int i = 0; i < count; i++) {
            this.mSongCursor.moveToPosition(i);
            songlist[i] = this.mSongCursor.getString(this.mSongCursor.getColumnIndexOrThrow("title_key"));
        }
        return songlist;
    }

    private void openCursors() {
        if (this.mArtistKey != null) {
            this.mSongCursor = MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"_id", "artist_key", "title", "title_key", "duration"}, "artist_key = ?", new String[]{this.mArtistKey}, "title_key ASC", this.mGenreName);
        } else if (this.mAlbumKey != null) {
            this.mSongCursor = MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"_id", "artist_key", "title", "title_key", "duration", Analytics.TRACK_KEY}, "album_key = ?", new String[]{this.mAlbumKey}, "track ASC", this.mGenreName);
        }
    }

    private void closeCursors() {
        try {
            if (!(this.mSongCursor == null || this.mSongCursor.isClosed())) {
                this.mSongCursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mSongCursor = null;
    }
}
