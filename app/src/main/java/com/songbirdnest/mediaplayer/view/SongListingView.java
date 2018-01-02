package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AlphabetIndexer;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.Model.Song;
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
import java.util.ListIterator;

public class SongListingView extends BaseContentBrowserView {
    protected static final int SHUFFLE_ALL_POS = 1;
    private static final String VIEW_CATEGORY = "music:songs";
    int idToPosCache_id = -1;
    int idToPosCache_pos = -1;
    private SongListAdapter mAdapter;
    private PlayableItem mCurrentPlayableItem = null;
    private Cursor mFilterCursor;
    private View mFooterView;
    private LayoutInflater mInflater;
    private boolean mInitialized = false;
    private boolean mJumpToPlayingItem = true;
    private SearchListItem mSearchBox;
    private Cursor mSongCursor;
    private ListView mSongList;

    class C03931 implements TextWatcher {
        C03931() {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.i("onTextChanged!!!", "New Text: " + s);
            if (count == 0) {
                SongListingView.this.unregisterContentObserver(SongListingView.this.mFilterCursor, getClass().getName() + "-Filter");
                SongListingView.this.mAdapter.swapCursor(SongListingView.this.mSongCursor);
                SongListingView.this.registerContentObserver(SongListingView.this.mSongCursor, SongListingView.this.mAdapter, SongListingView.this.mSongList, getClass().getName(), 500);
                return;
            }
            String[] proj = new String[]{"_id", "title", "duration", "artist", "album", "title_key"};
            String selection = "title LIKE ? AND " + Song.getFilterSelection();
            String[] selectionArgs = new String[]{"%" + SongListingView.this.mSearchBox.getSearchBox().getText().toString() + "%", "1"};
            SongListingView.this.unregisterContentObserver(SongListingView.this.mSongCursor, getClass().getName());
            SongListingView.this.unregisterContentObserver(SongListingView.this.mFilterCursor, getClass().getName() + "-Filter");
            if (!(SongListingView.this.mFilterCursor == null || SongListingView.this.mFilterCursor.isClosed())) {
                SongListingView.this.mFilterCursor.close();
            }
            SongListingView.this.mFilterCursor = MediaUtils.getMediaStoreMergeCursor(SongListingView.this.mActivity, proj, selection, selectionArgs, "title_key ASC");
            SongListingView.this.mAdapter.swapCursor(SongListingView.this.mFilterCursor);
            SongListingView.this.registerContentObserver(SongListingView.this.mFilterCursor, SongListingView.this.mAdapter, SongListingView.this.mSongList, getClass().getName() + "-Filter", 500);
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void afterTextChanged(Editable s) {
        }
    }

    class C03942 implements OnFocusChangeListener {
        C03942() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                Analytics.getAnalytics().track(Analytics.EVENT_SONG_VIEW_SEARCH);
            }
        }
    }

    class C03953 implements OnEditorActionListener {
        C03953() {
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            Utils.hideKeyboard(SongListingView.this.mActivity, SongListingView.this.mSearchBox.getSearchBox().getWindowToken());
            return false;
        }
    }

    class C03964 implements OnClickListener {
        C03964() {
        }

        public void onClick(View v) {
            if (SongListingView.this.mSearchBox.getSearchBox().getText().toString().equals("")) {
                Utils.hideKeyboard(SongListingView.this.mActivity, SongListingView.this.mSearchBox.getSearchBox().getWindowToken());
                Utils.loseFocus(SongListingView.this.mSearchBox.getClearButton());
                return;
            }
            SongListingView.this.mSearchBox.getSearchBox().setText("");
        }
    }

    class C03975 implements OnItemClickListener {
        C03975() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
            try {
                Cursor c = SongListingView.this.mAdapter.getCursor();
                ViewWrapper wrapper = (ViewWrapper) view.getTag();
                if (c.getCount() != SongListingView.this.mSongList.adjusted(position)) {
                    if (wrapper == null || !wrapper.isPlaying()) {
                        if (SongListingView.this.mSongList.isShuffle(position)) {
                            SongListingView.this.mJumpToPlayingItem = true;
                            SongListingView.this.mService.setCurrentList(Constants.TOP_MENU_SONGS, "");
                            SongListingView.this.mService.setShuffledPlayableList(Utils.createPlayableListFromCursor(c));
                            return;
                        }
                        SongListingView.this.mJumpToPlayingItem = true;
                        SongListingView.this.mService.setCurrentList(Constants.TOP_MENU_SONGS, "");
                        SongListingView.this.mService.setPlayableList(Utils.createPlayableListFromCursor(c), SongListingView.this.mSongList.adjusted(position));
                    } else if (SongListingView.this.mService.isPaused()) {
                        SongListingView.this.mService.play();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C03986 implements OnScrollListener {
        C03986() {
        }

        public void onScrollStateChanged(AbsListView aView, int aScrollState) {
            if (aScrollState != 0) {
                SongListingView.this.mJumpToPlayingItem = false;
            }
            SongListingView.this.setScrollState(aScrollState);
            if (SongListingView.this.isViewStopped() && SongListingView.this.isScrollIdle()) {
                SongListingView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (SongListingView.this.mSongList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    SongListingView.this.mSongList.removeFooterView(SongListingView.this.mFooterView);
                } else if (SongListingView.this.mSongList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    SongListingView.this.mSongList.addFooterView(SongListingView.this.mFooterView);
                }
            }
        }
    }

    class C03997 implements Runnable {
        C03997() {
        }

        public void run() {
            SongListingView.this.closeCursors();
        }
    }

    class SongListAdapter extends SimpleCursorAdapter implements SectionIndexer {
        AlphabetIndexer mAlphaIndexer;

        class ViewWrapper {
            TextView albumName = null;
            TextView artistName = null;
            View base;
            TextView duration = null;
            boolean isPlaying;
            PlayIcon playButton = null;
            TextView songName = null;
            String viewType;

            public ViewWrapper(View base, String viewType) {
                this.base = base;
                this.viewType = viewType;
                this.isPlaying = false;
            }

            public TextView getAlbumName() {
                if (this.albumName == null) {
                    this.albumName = (TextView) this.base.findViewById(C0116R.id.song_detail_album_name);
                }
                return this.albumName;
            }

            public TextView getArtistName() {
                if (this.artistName == null) {
                    this.artistName = (TextView) this.base.findViewById(C0116R.id.song_detail_artist_name);
                }
                return this.artistName;
            }

            public TextView getDuration() {
                if (this.duration == null) {
                    this.duration = (TextView) this.base.findViewById(C0116R.id.song_detail_duration);
                }
                return this.duration;
            }

            public PlayIcon getPlayButton() {
                if (this.playButton == null) {
                    this.playButton = (PlayIcon) this.base.findViewById(C0116R.id.song_detail_play_button);
                }
                return this.playButton;
            }

            public TextView getSongName() {
                if (this.songName == null) {
                    this.songName = (TextView) this.base.findViewById(C0116R.id.song_detail_song_name);
                }
                return this.songName;
            }

            public String getViewType() {
                return this.viewType;
            }

            public boolean isPlaying() {
                return this.isPlaying;
            }

            public void setListPosition(Integer listPosition) {
                if (this.playButton == null) {
                    this.playButton = (PlayIcon) this.base.findViewById(C0116R.id.song_detail_play_button);
                }
                this.playButton.setTag(listPosition);
            }

            public void setPlaying(boolean isPlaying) {
                this.isPlaying = isPlaying;
                getPlayButton().setPlaying(isPlaying);
            }
        }

        public SongListAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
            super(context, layout, c, from, to, 0);
            this.mAlphaIndexer = new AlphabetIndexer(c, c.getColumnIndex("title"), " ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }

        public int getPositionForSection(int section) {
            return this.mAlphaIndexer.getPositionForSection(section);
        }

        public int getSectionForPosition(int position) {
            return this.mAlphaIndexer.getSectionForPosition(position);
        }

        public Object[] getSections() {
            return this.mAlphaIndexer.getSections();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewWrapper wrapper;
            Cursor cursor = getCursor();
            View view = convertView;
            if (convertView == null) {
                view = SongListingView.this.mInflater.inflate(C0116R.layout.song_detail_item, null);
                wrapper = new ViewWrapper(view, Constants.LIST_VIEW_TYPE_STANDARD);
                view.setTag(wrapper);
            } else {
                wrapper = (ViewWrapper) view.getTag();
            }
            cursor.moveToPosition(position);
            populateViewInfo(cursor, wrapper, Integer.valueOf(position));
            return view;
        }

        public Cursor swapCursor(Cursor aCursor) {
            this.mAlphaIndexer.setCursor(aCursor);
            return super.swapCursor(aCursor);
        }

        private void populateViewInfo(Cursor aCursor, final ViewWrapper aWrapper, Integer aPosition) {
            aWrapper.getSongName().setText(aCursor.getString(aCursor.getColumnIndex("title")));
            aWrapper.getDuration().setText(Utils.calculateTimeStamp(aCursor.getInt(aCursor.getColumnIndex("duration"))));
            aWrapper.getArtistName().setText(aCursor.getString(aCursor.getColumnIndex("artist")));
            aWrapper.getAlbumName().setText(aCursor.getString(aCursor.getColumnIndex("album")));
            aWrapper.setListPosition(aPosition);
            try {
                if (songPlaying(Utils.createPlayableItemFromCursor(aCursor))) {
                    aWrapper.setPlaying(true);
                } else {
                    aWrapper.setPlaying(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            aWrapper.getPlayButton().setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    try {
                        if (!aWrapper.isPlaying()) {
                            SongListingView.this.mService.setPlayableList(Utils.createPlayableListFromCursor(SongListAdapter.this.getCursor()), ((Integer) v.getTag()).intValue());
                            SongListingView.this.mService.setCurrentList(Constants.TOP_MENU_SONGS, "");
                        } else if (aWrapper.isPlaying() && SongListingView.this.mService.isPaused()) {
                            SongListingView.this.mService.play();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        private boolean songPlaying(PlayableItem aItem) {
            if (SongListingView.this.mCurrentPlayableItem == null) {
                return false;
            }
            try {
                if (Constants.TOP_MENU_SONGS.equals(SongListingView.this.mService.getCurrentListActivity()) && aItem.mID == SongListingView.this.mCurrentPlayableItem.mID && aItem.mStorageVolume.equals(SongListingView.this.mCurrentPlayableItem.mStorageVolume)) {
                    return true;
                }
                return false;
            } catch (RemoteException e) {
                return false;
            }
        }
    }

    public SongListingView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_SONG_LIST);
        setViewCategory(VIEW_CATEGORY);
        setHeaderViewText(this.mActivity.getString(C0116R.string.songs_header));
        this.mInflater = LayoutInflater.from(this.mActivity);
        setViewAnalyticsUri(Analytics.EVENT_MUSIC_SONGS);
    }

    private void initSongListingView() {
        if (this.mInitialized) {
            openCursors();
            this.mAdapter.swapCursor(this.mSongCursor);
            return;
        }
        openCursors();
        this.mSongList = (ListView) this.mView.findViewById(C0116R.id.song_listing_song_list);
        this.mSongList.setFastScrollEnabled(true);
        this.mSearchBox = new SearchListItem(this.mActivity);
        this.mSongList.addHeaderView(this.mSearchBox.getView());
        this.mSearchBox.getSearchBox().addTextChangedListener(new C03931());
        this.mSearchBox.getSearchBox().setOnFocusChangeListener(new C03942());
        this.mSearchBox.getSearchBox().setOnEditorActionListener(new C03953());
        this.mSearchBox.getClearButton().setOnClickListener(new C03964());
        this.mAdapter = new SongListAdapter(this.mActivity, C0116R.layout.song_detail_item, this.mSongCursor, new String[]{"title"}, new int[]{C0116R.id.song_detail_song_name});
        if (this.mAdapter.getCount() > 1) {
            this.mSongList.addHeaderView(this.mInflater.inflate(C0116R.layout.shuffle_view, null));
        }
        this.mFooterView = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
        this.mSongList.addFooterView(this.mFooterView);
        this.mSongList.setAdapter(this.mAdapter);
        this.mSongList.removeFooterView(this.mFooterView);
        this.mSongList.setOnItemClickListener(new C03975());
        this.mSongList.setOnScrollListener(new C03986());
        this.mSongList.setSelection(1);
        setContextMenuView(this.mSongList);
        this.mInitialized = true;
    }

    public void onMediaServiceConnected() {
        super.onMediaServiceConnected();
        try {
            if (this.mService.isPlaying() && Constants.TOP_MENU_SONGS.equals(this.mService.getCurrentListActivity())) {
                jumpToPlayingItem();
            }
        } catch (RemoteException e) {
        }
    }

    public void onMediaServiceEvent(int aEvent) {
        super.onMediaServiceEvent(aEvent);
        switch (aEvent) {
            case 4:
                try {
                    this.mCurrentPlayableItem = this.mService.getCurrentItem();
                    this.mAdapter.notifyDataSetChanged();
                    jumpToPlayingItem();
                    return;
                } catch (Exception e) {
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
        initSongListingView();
        registerContentObserver(this.mSongCursor, this.mAdapter, this.mSongList, getClass().getName(), 500);
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
        unregisterContentObserver(this.mSongCursor, getClass().getName());
        unregisterContentObserver(this.mFilterCursor, getClass().getName() + "-Filter");
        Utils.hideKeyboard(this.mActivity, this.mSearchBox.getSearchBox().getWindowToken());
    }

    public void onStop() {
        super.onStop();
        if (isScrollIdle()) {
            closeCursorsDelayed();
        }
    }

    private void closeCursorsDelayed() {
        ContentBrowser.getHandler().postDelayed(new C03997(), 100);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mInitialized = false;
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.mSongList == aView) {
            AdapterContextMenuInfo adapterInfo = (AdapterContextMenuInfo) aMenuInfo;
            Cursor c = this.mSongCursor;
            if (this.mSearchBox.getSearchBox().getText().length() > 0) {
                c = this.mFilterCursor;
            }
            if (!this.mSongList.isShuffle(adapterInfo.position)) {
                c.moveToPosition(this.mSongList.adjusted(adapterInfo.position));
                final String songTitle = c.getString(c.getColumnIndex("title"));
                aMenu.setHeaderTitle(songTitle);
                final int itemId = c.getInt(c.getColumnIndex("_id"));
                final String itemVolume = Utils.getVolumeFromCursor(this.mSongCursor);
                ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, itemId, itemVolume, songTitle, true);
                if (Utils.hasPhone(this.mActivity)) {
                    aMenu.add(C0116R.string.playlist_listing_menu_set_ringtone).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            Utils.setItemAsRingtone(SongListingView.this.mActivity, itemId, itemVolume);
                            Utils.showShortToast(SongListingView.this.mActivity, SongListingView.this.mActivity.getString(C0116R.string.playlist_set_ringtone_message, new Object[]{songTitle}));
                            return true;
                        }
                    });
                }
            }
        }
    }

    protected void jumpToPlayingItem() {
        if (this.mJumpToPlayingItem) {
            try {
                if (this.mService != null && Constants.TOP_MENU_SONGS.equals(this.mService.getCurrentListActivity()) && this.mSongList != null) {
                    int listPosition = this.mService.getListPosition();
                    if (listPosition < 0) {
                        listPosition = idToPosition(-listPosition);
                    }
                    this.mSongList.setSelection(Math.max(1, listPosition), true);
                }
            } catch (RemoteException e) {
            }
        }
    }

    private int idToPosition(int id) {
        if (this.idToPosCache_id == id) {
            return this.idToPosCache_pos;
        }
        this.idToPosCache_id = id;
        this.idToPosCache_pos = idToPositionScan(id);
        return this.idToPosCache_pos;
    }

    private int idToPositionScan(int id) {
        ListIterator<PlayableItem> iterator = Utils.createPlayableListFromCursor(this.mSongCursor).listIterator();
        int pos = 0;
        while (iterator.hasNext()) {
            if (((PlayableItem) iterator.next()).mID == id) {
                return pos;
            }
            pos++;
        }
        return 0;
    }

    private void openCursors() {
        this.mSongCursor = MediaUtils.getMediaStoreMergeCursor(this.mActivity, new String[]{"_id", "title", "duration", "artist", "album", "title_key"}, Song.getFilterSelection(), Song.getFilterArgs(), "title_key ASC");
    }

    private void closeCursors() {
        try {
            if (!(this.mFilterCursor == null || this.mFilterCursor.isClosed())) {
                this.mFilterCursor.close();
            }
            if (!(this.mSongCursor == null || this.mSongCursor.isClosed())) {
                this.mSongCursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mFilterCursor = null;
        this.mSongCursor = null;
    }
}
