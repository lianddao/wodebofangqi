package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.Model.Podcast;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.ContextMenuUtils;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.Songbird;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.mediaplayer.widgets.ListView;
import com.songbirdnest.util.MediaUtils;
import java.util.ListIterator;

public class PodcastDetailView extends BaseContentBrowserView {
    private static final String VIEW_CATEGORY = "music:podcasts";
    String aAlbumKey;
    int idToPosCache_id = -1;
    int idToPosCache_pos = -1;
    private SongListAdapter mAdapter;
    private PlayableItem mCurrentPlayableItem = null;
    private Cursor mFilterCursor;
    private View mFooterView;
    private LayoutInflater mInflater;
    private boolean mInitialized = false;
    private boolean mJumpToPlayingItem = true;
    private String mPodcastName = null;
    private SearchListItem mSearchBox;
    private Cursor mSongCursor;
    private ListView mSongList;

    class C03601 implements TextWatcher {
        C03601() {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (count == 0) {
                PodcastDetailView.this.unregisterContentObserver(PodcastDetailView.this.mFilterCursor, getClass().getName() + "-Filter");
                PodcastDetailView.this.mAdapter.swapCursor(PodcastDetailView.this.mSongCursor);
                PodcastDetailView.this.registerContentObserver(PodcastDetailView.this.mSongCursor, PodcastDetailView.this.mAdapter, PodcastDetailView.this.mSongList, getClass().getName(), 500);
                return;
            }
            String[] proj = new String[]{"_id", "title", "duration", "artist", "album", "album_key"};
            String selection = Podcast.getSearchSelection();
            String[] selectionArgs = Podcast.getSearchArgs(PodcastDetailView.this.mSearchBox.getSearchBox().getText().toString());
            if (!(PodcastDetailView.this.mFilterCursor == null || PodcastDetailView.this.mFilterCursor.isClosed())) {
                PodcastDetailView.this.mFilterCursor.close();
            }
            PodcastDetailView.this.unregisterContentObserver(PodcastDetailView.this.mSongCursor, getClass().getName());
            PodcastDetailView.this.unregisterContentObserver(PodcastDetailView.this.mFilterCursor, getClass().getName() + "-Filter");
            String[] realSelection = new String[(selectionArgs.length + 1)];
            int counter = 0;
            for (String selectionArg : selectionArgs) {
                realSelection[counter] = selectionArg;
                counter++;
            }
            realSelection[counter] = PodcastDetailView.this.mActivity.getIntent().getExtras().getString(Constants.EXTRA_ALBUM_KEY);
            PodcastDetailView.this.mFilterCursor = MediaUtils.getMediaStoreMergeCursor(PodcastDetailView.this.mActivity, proj, selection + " AND " + "album_key" + " = ? ", realSelection, "album_key ASC");
            PodcastDetailView.this.mAdapter.swapCursor(PodcastDetailView.this.mFilterCursor);
            PodcastDetailView.this.registerContentObserver(PodcastDetailView.this.mFilterCursor, PodcastDetailView.this.mAdapter, PodcastDetailView.this.mSongList, getClass().getName() + "-Filter", 500);
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void afterTextChanged(Editable s) {
        }
    }

    class C03612 implements OnFocusChangeListener {
        C03612() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                Analytics.getAnalytics().track(Analytics.EVENT_SONG_VIEW_SEARCH);
            }
        }
    }

    class C03623 implements OnClickListener {
        C03623() {
        }

        public void onClick(View v) {
            if (PodcastDetailView.this.mSearchBox.getSearchBox().getText().toString().equals("")) {
                Utils.hideKeyboard(PodcastDetailView.this.mActivity, PodcastDetailView.this.mSearchBox.getSearchBox().getWindowToken());
                Utils.loseFocus(PodcastDetailView.this.mSearchBox.getClearButton());
                return;
            }
            PodcastDetailView.this.mSearchBox.getSearchBox().setText("");
        }
    }

    class C03634 implements OnItemClickListener {
        C03634() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
            try {
                ViewWrapper wrapper = (ViewWrapper) view.getTag();
                if (wrapper == null || !wrapper.isPlaying()) {
                    PodcastDetailView.this.mJumpToPlayingItem = true;
                    PodcastDetailView.this.mService.setCurrentList(Constants.TOP_MENU_PODCASTS, PodcastDetailView.this.aAlbumKey);
                    PodcastDetailView.this.mService.setPlayableList(Utils.createPlayableListFromCursor(PodcastDetailView.this.mAdapter.getCursor()), position - PodcastDetailView.this.mSongList.getHeaderViewsCount());
                } else if (PodcastDetailView.this.mService.isPaused()) {
                    PodcastDetailView.this.mService.play();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    class C03645 implements OnScrollListener {
        C03645() {
        }

        public void onScrollStateChanged(AbsListView aView, int aScrollState) {
            if (aScrollState != 0) {
                PodcastDetailView.this.mJumpToPlayingItem = false;
            }
            PodcastDetailView.this.setScrollState(aScrollState);
            if (PodcastDetailView.this.isViewStopped() && PodcastDetailView.this.isScrollIdle()) {
                PodcastDetailView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (PodcastDetailView.this.mSongList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    PodcastDetailView.this.mSongList.removeFooterView(PodcastDetailView.this.mFooterView);
                } else if (PodcastDetailView.this.mSongList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    PodcastDetailView.this.mSongList.addFooterView(PodcastDetailView.this.mFooterView);
                }
            }
        }
    }

    class C03656 implements Runnable {
        C03656() {
        }

        public void run() {
            PodcastDetailView.this.closeCursors();
        }
    }

    class SongListAdapter extends SimpleCursorAdapter implements SectionIndexer {
        AlphabetIndexer alphaIndexer;

        class ViewWrapper {
            TextView albumName = null;
            TextView artistName = null;
            private RelativeLayout background;
            private Drawable backgroundDrawable;
            View base;
            TextView duration = null;
            boolean isPlaying;
            ImageView playButton = null;
            private LinearLayout secondLine;
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

            public ImageView getPlayButton() {
                if (this.playButton == null) {
                    this.playButton = (ImageView) this.base.findViewById(C0116R.id.song_detail_play_button);
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
                    this.playButton = (ImageView) this.base.findViewById(C0116R.id.song_detail_play_button);
                }
                this.playButton.setTag(listPosition);
            }

            public void setPlaying(boolean isPlaying) {
                this.isPlaying = isPlaying;
            }

            private RelativeLayout getBackground() {
                if (this.background == null) {
                    this.background = (RelativeLayout) this.base.findViewById(C0116R.id.song_detail_background);
                    this.backgroundDrawable = this.background.getBackground();
                }
                return this.background;
            }

            private LinearLayout getSongSecondLine() {
                if (this.secondLine == null) {
                    this.secondLine = (LinearLayout) this.base.findViewById(C0116R.id.song_detail_song_second_line);
                }
                return this.secondLine;
            }

            public void setAsHeader() {
                getBackground().setBackgroundColor(C0116R.color.black);
                getSongSecondLine().setVisibility(8);
            }

            public void setAsPlayable() {
                getBackground().setBackgroundDrawable(this.backgroundDrawable);
                getSongSecondLine().setVisibility(0);
            }
        }

        public SongListAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
            super(context, layout, c, from, to, 0);
            this.alphaIndexer = new AlphabetIndexer(c, c.getColumnIndex("title"), " ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }

        public int getCursorCount() {
            return super.getCount();
        }

        public Cursor swapCursor(Cursor aCursor) {
            this.alphaIndexer.setCursor(aCursor);
            return super.swapCursor(aCursor);
        }

        public int getPositionForSection(int section) {
            return this.alphaIndexer.getPositionForSection(section);
        }

        public int getSectionForPosition(int position) {
            return this.alphaIndexer.getSectionForPosition(position);
        }

        public Object[] getSections() {
            return this.alphaIndexer.getSections();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewWrapper wrapper;
            View view = convertView;
            if (convertView == null) {
                view = PodcastDetailView.this.mInflater.inflate(C0116R.layout.song_detail_item, null);
                wrapper = new ViewWrapper(view, Constants.LIST_VIEW_TYPE_STANDARD);
                view.setTag(wrapper);
            } else {
                wrapper = (ViewWrapper) view.getTag();
            }
            populateViewInfo(wrapper, Integer.valueOf(position));
            return view;
        }

        private void populateViewInfoPlayable(final ViewWrapper aWrapper, final Integer aPosition) {
            Cursor cursor = getCursor();
            try {
                aWrapper.setAsPlayable();
                aWrapper.getSongName().setText(cursor.getString(cursor.getColumnIndex("title")));
                aWrapper.getDuration().setText(Utils.calculateTimeStamp(cursor.getInt(cursor.getColumnIndex("duration"))));
                aWrapper.getArtistName().setText(cursor.getString(cursor.getColumnIndex("artist")));
                aWrapper.getAlbumName().setText(cursor.getString(cursor.getColumnIndex("album")));
                try {
                    if (songPlaying(Utils.createPlayableItemFromCursor(cursor))) {
                        aWrapper.getPlayButton().setImageResource(C0116R.drawable.row_listening_button);
                        aWrapper.setPlaying(true);
                    } else {
                        aWrapper.getPlayButton().setImageResource(C0116R.drawable.row_play);
                        aWrapper.setPlaying(false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                aWrapper.getPlayButton().setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        try {
                            if (!aWrapper.isPlaying()) {
                                PodcastDetailView.this.mService.setPlayableList(Utils.createPlayableListFromCursor(SongListAdapter.this.getCursor()), aPosition.intValue());
                                PodcastDetailView.this.mService.setCurrentList(Constants.TOP_MENU_PODCASTS, PodcastDetailView.this.aAlbumKey);
                            } else if (aWrapper.isPlaying() && PodcastDetailView.this.mService.isPaused()) {
                                PodcastDetailView.this.mService.play();
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception ex) {
                Log.e(getClass().getSimpleName(), ex.getMessage());
            }
        }

        private void populateViewInfo(ViewWrapper aWrapper, Integer aPosition) {
            int cursorPosition = aPosition.intValue();
            getCursor().moveToPosition(cursorPosition);
            populateViewInfoPlayable(aWrapper, Integer.valueOf(cursorPosition));
            aWrapper.setListPosition(aPosition);
        }

        private boolean songPlaying(PlayableItem aItem) {
            if (PodcastDetailView.this.mCurrentPlayableItem == null) {
                return false;
            }
            try {
                if (Constants.TOP_MENU_PODCASTS.equals(PodcastDetailView.this.mService.getCurrentListActivity()) && aItem.mID == PodcastDetailView.this.mCurrentPlayableItem.mID && aItem.mStorageVolume.equals(PodcastDetailView.this.mCurrentPlayableItem.mStorageVolume)) {
                    return true;
                }
                return false;
            } catch (RemoteException e) {
                return false;
            }
        }
    }

    public PodcastDetailView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_PODCAST_LIST);
        setViewCategory(VIEW_CATEGORY);
        setHeaderViewText(this.mActivity.getString(C0116R.string.podcasts_header));
        setViewAnalyticsUri(Analytics.EVENT_MUSIC_PODCASTS);
        this.aAlbumKey = this.mActivity.getIntent().getExtras().getString(Constants.EXTRA_ALBUM_KEY);
    }

    private void initPodcastListingView() {
        if (this.mInitialized) {
            openCursors();
            this.mAdapter.swapCursor(this.mSongCursor);
            return;
        }
        openCursors();
        this.mInflater = LayoutInflater.from(this.mActivity);
        this.mSongList = (ListView) this.mView.findViewById(C0116R.id.song_listing_song_list);
        this.mSongList.setFastScrollEnabled(true);
        this.mSearchBox = new SearchListItem(this.mActivity);
        this.mSongList.addHeaderView(this.mSearchBox.getView());
        this.mActivity.registerForContextMenu(this.mSongList);
        this.mSearchBox.getSearchBox().addTextChangedListener(new C03601());
        this.mSearchBox.getSearchBox().setOnFocusChangeListener(new C03612());
        this.mSearchBox.getClearButton().setOnClickListener(new C03623());
        this.mAdapter = new SongListAdapter(this.mActivity.getApplicationContext(), C0116R.layout.song_detail_item, this.mSongCursor, new String[]{"title"}, new int[]{C0116R.id.song_detail_song_name});
        this.mFooterView = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
        this.mSongList.addFooterView(this.mFooterView);
        this.mSongList.setAdapter(this.mAdapter);
        this.mSongList.removeFooterView(this.mFooterView);
        this.mSongList.setOnItemClickListener(new C03634());
        this.mSongList.setOnScrollListener(new C03645());
        this.mSongList.setSelection(this.mSongList.getHeaderViewsCount());
        setContextMenuView(this.mSongList);
        this.mInitialized = true;
    }

    public void onMediaServiceConnected() {
        super.onMediaServiceConnected();
        try {
            if (this.mService.isPlaying() && Constants.TOP_MENU_PODCASTS.equals(this.mService.getCurrentListActivity())) {
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
                    if (this.mAdapter != null) {
                        this.mAdapter.notifyDataSetChanged();
                    }
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
        initPodcastListingView();
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
        Songbird.getHandler().postDelayed(new C03656(), 100);
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
            int position = adapterInfo.position;
            if (!this.mSongList.isShuffle(position)) {
                int adjusted = this.mSongList.adjusted(position);
                if (this.mSongCursor.moveToPosition(position)) {
                    final String songTitle = c.getString(c.getColumnIndex("title"));
                    aMenu.setHeaderTitle(songTitle);
                    final int itemId = c.getInt(c.getColumnIndex("_id"));
                    final String itemVolume = Utils.getVolumeFromCursor(c);
                    ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, itemId, itemVolume, songTitle, true);
                    aMenu.add(C0116R.string.playlist_listing_menu_set_ringtone).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            Utils.setItemAsRingtone(PodcastDetailView.this.mActivity, itemId, itemVolume);
                            Utils.showShortToast(PodcastDetailView.this.mActivity, PodcastDetailView.this.mActivity.getString(C0116R.string.playlist_set_ringtone_message, new Object[]{songTitle}));
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
                if (this.mService != null && Constants.TOP_MENU_PODCASTS.equals(this.mService.getCurrentListActivity()) && this.mSongList != null) {
                    int listPosition = this.mService.getListPosition();
                    if (listPosition < 0) {
                        listPosition = idToPosition(-listPosition);
                    }
                    int max = Math.max(0, listPosition);
                    this.mSongList.setSelection(listPosition, true);
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
        String[] proj = new String[]{"_id", "title", "duration", "artist", "album", "album_key"};
        this.mSongCursor = MediaUtils.getMediaStoreMergeCursor(this.mActivity, proj, Podcast.getFilterSelection() + "AND " + "album_key" + " = ? ", new String[]{"1", this.mActivity.getIntent().getExtras().getString(Constants.EXTRA_ALBUM_KEY)}, "album_key ASC");
        this.mSongCursor.moveToFirst();
        setHeaderViewText(this.mSongCursor.getString(this.mSongCursor.getColumnIndex("album")));
    }

    private void closeCursors() {
        try {
            if (!(this.mSongCursor == null || this.mSongCursor.isClosed())) {
                this.mSongCursor.close();
            }
            if (!(this.mFilterCursor == null || this.mFilterCursor.isClosed())) {
                this.mFilterCursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mSongCursor = null;
        this.mFilterCursor = null;
    }
}
