package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.text.TextWatcher;
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
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.Model.Podcast;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.ContextMenuUtils;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.service.PodcastAlbumArtHelper;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.mediaplayer.widgets.ListView;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;
import com.songbirdnest.util.MediaUtils;

public class PodcastListingView extends BaseContentBrowserView {
    private static final String VIEW_CATEGORY = "music:podcasts";
    Handler aHandler = new C03681();
    PodcastAlbumArtHelper aHelper;
    BroadcastReceiver aReceiver = new C03757();
    boolean isRegistered = false;
    private SongListAdapter mAdapter;
    private Cursor mFilterCursor;
    private View mFooterView;
    private LayoutInflater mInflater;
    private boolean mInitialized = false;
    private boolean mJumpToPlayingItem = true;
    private SearchListItem mSearchBox;
    private Cursor mSongCursor;
    private ListView mSongList;

    class C03681 extends Handler {
        C03681() {
        }

        public void handleMessage(Message msg) {
            ((ViewWrapper) msg.obj).tryClear();
        }
    }

    class C03692 implements TextWatcher {
        C03692() {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            PodcastListingView.this.mSongCursor.close();
            if (count == 0) {
                PodcastListingView.this.mSongCursor = PodcastListingView.this.aHelper.getCursor();
            } else {
                PodcastListingView.this.mSongCursor = PodcastListingView.this.aHelper.getCursor(s.toString());
            }
            PodcastListingView.this.mAdapter.swapCursor(PodcastListingView.this.mSongCursor);
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void afterTextChanged(Editable s) {
        }
    }

    class C03703 implements OnFocusChangeListener {
        C03703() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                Analytics.getAnalytics().track(Analytics.EVENT_SONG_VIEW_SEARCH);
            }
        }
    }

    class C03714 implements OnClickListener {
        C03714() {
        }

        public void onClick(View v) {
            if (PodcastListingView.this.mSearchBox.getSearchBox().getText().toString().equals("")) {
                Utils.hideKeyboard(PodcastListingView.this.mActivity, PodcastListingView.this.mSearchBox.getSearchBox().getWindowToken());
                Utils.loseFocus(PodcastListingView.this.mSearchBox.getClearButton());
                return;
            }
            PodcastListingView.this.mSearchBox.getSearchBox().setText("");
        }
    }

    class C03725 implements OnItemClickListener {
        C03725() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
            Cursor aCursor = PodcastListingView.this.mAdapter.getCursor();
            aCursor.moveToPosition(position - PodcastListingView.this.mSongList.getHeaderViewsCount());
            String aAlbum = aCursor.getString(aCursor.getColumnIndexOrThrow(PodcastAlbumArtHelper.KEY_ALBUM_KEY));
            Intent aNextActivity = new Intent(PodcastListingView.this.mActivity, ContentBrowser.class);
            aNextActivity.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_PODCAST_DETAILS);
            aNextActivity.putExtra(Constants.EXTRA_ALBUM_KEY, aAlbum);
            PodcastListingView.this.mActivity.startActivity(aNextActivity);
        }
    }

    class C03736 implements OnScrollListener {
        C03736() {
        }

        public void onScrollStateChanged(AbsListView aView, int aScrollState) {
            if (aScrollState != 0) {
                PodcastListingView.this.mJumpToPlayingItem = false;
            }
            PodcastListingView.this.setScrollState(aScrollState);
            if (PodcastListingView.this.isViewStopped() && PodcastListingView.this.isScrollIdle()) {
                PodcastListingView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (PodcastListingView.this.mSongList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    PodcastListingView.this.mSongList.removeFooterView(PodcastListingView.this.mFooterView);
                } else if (PodcastListingView.this.mSongList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    PodcastListingView.this.mSongList.addFooterView(PodcastListingView.this.mFooterView);
                }
            }
        }
    }

    class C03757 extends BroadcastReceiver {

        class C03741 implements Runnable {
            C03741() {
            }

            public void run() {
                PodcastListingView.this.mSongCursor.close();
                PodcastListingView.this.aHelper.close();
                PodcastListingView.this.aHelper = new PodcastAlbumArtHelper(PodcastListingView.this.mActivity);
                PodcastListingView.this.aHelper.open();
                PodcastListingView.this.mSongCursor = PodcastListingView.this.aHelper.getCursor();
                PodcastListingView.this.mAdapter.swapCursor(PodcastListingView.this.mSongCursor);
            }
        }

        C03757() {
        }

        public void onReceive(Context context, Intent intent) {
            PodcastListingView.this.aHandler.post(new C03741());
        }
    }

    class C03768 implements Runnable {
        C03768() {
        }

        public void run() {
            PodcastListingView.this.closeCursors();
        }
    }

    class SongListAdapter extends SimpleCursorAdapter implements SectionIndexer {
        AlphabetIndexer alphaIndexer;
        private int mRowHeight = 50;

        class ViewWrapper {
            View base;
            boolean isPlaying;
            ImageView mAlbumArt;
            PlayIcon playButton = null;
            TextView songName = null;
            String viewType;

            public ViewWrapper(View base, String viewType) {
                this.base = base;
                this.viewType = viewType;
                this.isPlaying = false;
            }

            public ImageView getAlbumArt() {
                if (this.mAlbumArt == null) {
                    this.mAlbumArt = (ImageView) this.base.findViewById(C0116R.id.podcast_item_podcast_art);
                }
                return this.mAlbumArt;
            }

            public PlayIcon getPlayButton() {
                if (this.playButton == null) {
                    this.playButton = (PlayIcon) this.base.findViewById(C0116R.id.podcast_item_play_icon);
                }
                return this.playButton;
            }

            public TextView getSongName() {
                if (this.songName == null) {
                    this.songName = (TextView) this.base.findViewById(C0116R.id.podcast_item_podcast_text);
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
                    this.playButton = (PlayIcon) this.base.findViewById(C0116R.id.podcast_item_play_icon);
                }
                this.playButton.setTag(listPosition);
            }

            public void setPlaying(boolean isPlaying) {
                this.isPlaying = isPlaying;
            }

            public void setVisible(int pVisable) {
                this.base.setVisibility(pVisable);
            }

            public void tryClear() {
                if (getPlayButton().getHeight() > 0) {
                    SongListAdapter.this.mRowHeight = Utils.calculateAlbumArt(getPlayButton().getHeight());
                    PodcastListingView.this.mAdapter.notifyDataSetChanged();
                    setVisible(0);
                    return;
                }
                setVisible(4);
                Message msg = new Message();
                msg.obj = this;
                PodcastListingView.this.aHandler.sendMessageDelayed(msg, 100);
            }
        }

        public SongListAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
            super(context, layout, c, from, to, 0);
            this.alphaIndexer = new AlphabetIndexer(c, c.getColumnIndex(PodcastAlbumArtHelper.KEY_ALBUM_NAME), " ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }

        public int getCount() {
            return getCursorCount();
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
                view = PodcastListingView.this.mInflater.inflate(C0116R.layout.podcast_item, null);
                wrapper = new ViewWrapper(view, Constants.LIST_VIEW_TYPE_STANDARD);
                view.setTag(wrapper);
            } else {
                wrapper = (ViewWrapper) view.getTag();
            }
            Cursor aCursor = getCursor();
            aCursor.moveToPosition(position);
            wrapper.getSongName().setText(aCursor.getString(aCursor.getColumnIndex(PodcastAlbumArtHelper.KEY_ALBUM_NAME)));
            byte[] aThumbByte = aCursor.getBlob(aCursor.getColumnIndex(PodcastAlbumArtHelper.KEY_ALBUM_ART));
            Bitmap aSource = BitmapFactory.decodeByteArray(aThumbByte, 0, aThumbByte.length);
            wrapper.getAlbumArt().setImageBitmap(Bitmap.createScaledBitmap(aSource, this.mRowHeight, this.mRowHeight, true));
            aSource.recycle();
            if (wrapper.getPlayButton().getHeight() == 0) {
                Message aMessage = new Message();
                aMessage.obj = wrapper;
                PodcastListingView.this.aHandler.sendMessageDelayed(aMessage, 200);
            }
            final String aAlbumKey = aCursor.getString(aCursor.getColumnIndex(PodcastAlbumArtHelper.KEY_ALBUM_KEY));
            if (isPodcastPlaying(aAlbumKey)) {
                wrapper.getPlayButton().setImageResource(C0116R.drawable.row_listening_button);
                wrapper.setPlaying(true);
            } else {
                wrapper.getPlayButton().setImageResource(C0116R.drawable.row_play_button);
                wrapper.setPlaying(false);
            }
            wrapper.getPlayButton().setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    String[] proj = new String[]{"_id", "title", "duration", "artist", "album", "album_key"};
                    Cursor aClickCursor = MediaUtils.getMediaStoreMergeCursor(PodcastListingView.this.mActivity, proj, Podcast.getFilterSelection() + "AND " + "album_key" + " = ? ", new String[]{"1", aAlbumKey}, "album_key ASC");
                    aClickCursor.moveToFirst();
                    try {
                        if (!wrapper.isPlaying()) {
                            PodcastListingView.this.mService.setCurrentList(Constants.TOP_MENU_PODCASTS, aAlbumKey);
                            PodcastListingView.this.mService.setPlayableList(Utils.createPlayableListFromCursor(aClickCursor), 0);
                        } else if (wrapper.isPlaying() && PodcastListingView.this.mService.isPaused()) {
                            PodcastListingView.this.mService.play();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
            return view;
        }

        private boolean isPodcastPlaying(String aAlbumKey) {
            try {
                String aToken = PodcastListingView.this.mService.getCurrentListToken();
                if (aToken == null || !aToken.equals(aAlbumKey)) {
                    return false;
                }
                return true;
            } catch (RemoteException ex) {
                ex.printStackTrace();
                return false;
            }
        }

        public boolean isHeader(int listPosition) {
            return true;
        }
    }

    public PodcastListingView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_PODCAST_LIST);
        setViewCategory(VIEW_CATEGORY);
        setHeaderViewText(this.mActivity.getString(C0116R.string.podcasts_header));
        setViewAnalyticsUri(Analytics.EVENT_MUSIC_PODCASTS);
    }

    private void initPodcastListingView() {
        this.aHelper = new PodcastAlbumArtHelper(this.mActivity.getApplicationContext());
        this.aHelper.open();
        if (this.mInitialized) {
            openCursors();
            this.mAdapter.swapCursor(this.mSongCursor);
            return;
        }
        openCursors();
        this.mAdapter = new SongListAdapter(this.mActivity.getApplicationContext(), C0116R.layout.podcast_item, this.mSongCursor, new String[]{PodcastAlbumArtHelper.KEY_ALBUM_NAME}, new int[]{C0116R.id.podcast_item_podcast_text});
        this.mInflater = LayoutInflater.from(this.mActivity);
        this.mSongList = (ListView) this.mView.findViewById(C0116R.id.song_listing_song_list);
        this.mSongList.setFastScrollEnabled(true);
        this.mSearchBox = new SearchListItem(this.mActivity);
        this.mSongList.addHeaderView(this.mSearchBox.getView());
        this.mSearchBox.getSearchBox().addTextChangedListener(new C03692());
        this.mSearchBox.getSearchBox().setOnFocusChangeListener(new C03703());
        this.mSearchBox.getClearButton().setOnClickListener(new C03714());
        this.mFooterView = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
        this.mSongList.addFooterView(this.mFooterView);
        this.mSongList.setAdapter(this.mAdapter);
        this.mSongList.removeFooterView(this.mFooterView);
        this.mSongList.setOnItemClickListener(new C03725());
        this.mSongList.setOnScrollListener(new C03736());
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
                if (this.mAdapter != null) {
                    this.mAdapter.notifyDataSetChanged();
                }
                jumpToPlayingItem();
                return;
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
        this.mActivity.registerReceiver(this.aReceiver, new IntentFilter(Constants.PODCAST_UPDATE));
        this.isRegistered = true;
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
        if (this.isRegistered) {
            this.mActivity.unregisterReceiver(this.aReceiver);
            this.isRegistered = false;
        }
        Utils.hideKeyboard(this.mActivity, this.mSearchBox.getSearchBox().getWindowToken());
        this.aHelper.close();
    }

    public void onStop() {
        super.onStop();
        if (isScrollIdle()) {
            closeCursorsDelayed();
        }
    }

    private void closeCursorsDelayed() {
        ContentBrowser.getHandler().postDelayed(new C03768(), 100);
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
                if (!this.mAdapter.isHeader(this.mSongList.adjusted(position))) {
                    final String songTitle = c.getString(c.getColumnIndex(PodcastAlbumArtHelper.KEY_ALBUM_NAME));
                    aMenu.setHeaderTitle(songTitle);
                    final String itemVolume = Utils.getVolumeFromCursor(c);
                    ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, 1, itemVolume, songTitle, true);
                    if (Utils.hasPhone(this.mActivity)) {
                        aMenu.add(C0116R.string.playlist_listing_menu_set_ringtone).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                Utils.setItemAsRingtone(PodcastListingView.this.mActivity, 1, itemVolume);
                                Utils.showShortToast(PodcastListingView.this.mActivity, PodcastListingView.this.mActivity.getString(C0116R.string.playlist_set_ringtone_message, new Object[]{songTitle}));
                                return true;
                            }
                        });
                    }
                }
            }
        }
    }

    protected void jumpToPlayingItem() {
        if (this.mJumpToPlayingItem) {
            try {
                if (this.mService != null && Constants.TOP_MENU_PODCASTS.equals(this.mService.getCurrentListActivity()) && this.mSongList != null) {
                    String aCurrentKey = this.mService.getCurrentListToken();
                    Cursor aCursor = this.mAdapter.getCursor();
                    if (aCursor != null && aCursor.moveToFirst()) {
                        int aCol = aCursor.getColumnIndex(PodcastAlbumArtHelper.KEY_ALBUM_KEY);
                        int aCount = 0;
                        while (!aCursor.getString(aCol).equals(aCurrentKey)) {
                            aCount++;
                            if (!aCursor.moveToNext()) {
                                break;
                            }
                        }
                        this.mSongList.setSelection(aCount, true);
                    }
                }
            } catch (RemoteException e) {
            }
        }
    }

    private void openCursors() {
        this.mSongCursor = this.aHelper.getCursor();
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
        this.mAdapter.swapCursor(null);
        this.mSongCursor = null;
        this.mFilterCursor = null;
    }
}
