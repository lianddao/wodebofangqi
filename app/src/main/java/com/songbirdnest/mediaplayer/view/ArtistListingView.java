package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.RemoteException;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.ContextMenuUtils;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.widgets.ListView;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;
import com.songbirdnest.util.MediaUtils;
import java.util.List;

public class ArtistListingView extends BaseContentBrowserView {
    private static final String VIEW_CATEGORY = "music:artists";
    private ArtistListAdapter mAdapter;
    private ImageView mClearBox;
    private String mCurrentActivity;
    private String mCurrentToken;
    private Cursor mCursor;
    private Cursor mFilterCursor;
    private LayoutInflater mInflater;
    private boolean mInitialized = false;
    private ListView mList;
    private View mListFooter;
    private EditText mSearchBox;

    class C02261 implements OnEditorActionListener {
        C02261() {
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            Utils.hideKeyboard(ArtistListingView.this.mActivity, ArtistListingView.this.mSearchBox.getWindowToken());
            return false;
        }
    }

    class C02272 implements OnFocusChangeListener {
        C02272() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                Analytics.getAnalytics().track(Analytics.EVENT_ARTIST_VIEW_SEARCH);
            }
        }
    }

    class C02283 implements OnItemClickListener {
        C02283() {
        }

        public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
            Cursor aCursor = ArtistListingView.this.mAdapter.getCursor();
            aCursor.moveToPosition(position - ArtistListingView.this.mList.getHeaderViewsCount());
            int coloum = aCursor.getColumnIndexOrThrow("artist_key");
            Intent i = new Intent(ArtistListingView.this.mActivity, ContentBrowser.class);
            i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_ARTIST_DETAILS);
            i.putExtra(Constants.EXTRA_ARTIST_KEY, aCursor.getString(coloum));
            ArtistListingView.this.mActivity.startActivity(i);
        }
    }

    class C02294 implements TextWatcher {
        C02294() {
        }

        public void afterTextChanged(Editable s) {
            String[] proj = new String[]{"_id", "artist", "artist_key", "number_of_tracks", "number_of_albums"};
            String[] args = new String[]{"%" + ArtistListingView.this.mSearchBox.getText().toString().toLowerCase() + "%"};
            if (!(ArtistListingView.this.mFilterCursor == null || ArtistListingView.this.mFilterCursor.isClosed())) {
                ArtistListingView.this.mFilterCursor.close();
            }
            ArtistListingView.this.mFilterCursor = MediaUtils.getMediaStoreMergeCursorForArtist(ArtistListingView.this.mActivity, proj, "artist LIKE ?", args, "artist_key ASC", false);
            ArtistListingView.this.mAdapter.swapCursor(ArtistListingView.this.mFilterCursor);
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    class C02305 implements OnClickListener {
        C02305() {
        }

        public void onClick(View v) {
            if (ArtistListingView.this.mSearchBox.getText().toString().equals("")) {
                Utils.hideKeyboard(ArtistListingView.this.mActivity, ArtistListingView.this.mSearchBox.getWindowToken());
                Utils.loseFocus(ArtistListingView.this.mClearBox);
                return;
            }
            ArtistListingView.this.mSearchBox.setText("");
        }
    }

    class C02316 implements OnScrollListener {
        C02316() {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            ArtistListingView.this.setScrollState(scrollState);
            if (ArtistListingView.this.isViewStopped() && ArtistListingView.this.isScrollIdle()) {
                ArtistListingView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (ArtistListingView.this.mList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    ArtistListingView.this.mList.removeFooterView(ArtistListingView.this.mListFooter);
                } else if (ArtistListingView.this.mList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    ArtistListingView.this.mList.addFooterView(ArtistListingView.this.mListFooter);
                }
            }
        }
    }

    class C02327 implements Runnable {
        C02327() {
        }

        public void run() {
            ArtistListingView.this.closeCursors();
        }
    }

    class ArtistListAdapter extends SimpleCursorAdapter implements SectionIndexer {
        private AlphabetIndexer mAlphaIndexer;

        class ViewWrapper {
            private TextView artistLabel;
            private View base;
            private PlayIcon playIcon;
            private TextView totalLabel;

            public ViewWrapper(View base) {
                this.base = base;
            }

            public PlayIcon getPlayIcon() {
                if (this.playIcon == null) {
                    this.playIcon = (PlayIcon) this.base.findViewById(C0116R.id.artist_item_play_icon);
                }
                return this.playIcon;
            }

            public TextView getArtistLabel() {
                if (this.artistLabel == null) {
                    this.artistLabel = (TextView) this.base.findViewById(C0116R.id.artist_item_artist_name);
                }
                return this.artistLabel;
            }

            public TextView getTotalLabel() {
                if (this.totalLabel == null) {
                    this.totalLabel = (TextView) this.base.findViewById(C0116R.id.artist_item_song_total);
                }
                return this.totalLabel;
            }
        }

        public ArtistListAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
            super(context, layout, c, from, to, 0);
            this.mAlphaIndexer = new AlphabetIndexer(c, c.getColumnIndex("artist"), " ABCDEFGHIJKLMNOPQRSTUVWXYZ");
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
            int column;
            int songCount;
            Cursor cursor = getCursor();
            cursor.moveToPosition(position);
            View view = convertView;
            if (convertView == null) {
                view = ArtistListingView.this.mInflater.inflate(C0116R.layout.artist_item, null);
                wrapper = new ViewWrapper(view);
                view.setTag(wrapper);
            } else {
                wrapper = (ViewWrapper) view.getTag();
            }
            wrapper.getArtistLabel().setText(cursor.getString(cursor.getColumnIndexOrThrow("artist")));
            if (wrapper.getArtistLabel().getText().equals("<unknown>")) {
                column = cursor.getColumnIndexOrThrow("artist_key");
                Cursor songCursor = MediaUtils.getMediaStoreMergeCursor(ArtistListingView.this.mActivity, new String[]{"_id", "artist_key"}, "artist_key = ?", new String[]{cursor.getString(column)}, "artist_key ASC");
                songCount = songCursor.getCount();
                songCursor.close();
            } else {
                songCount = cursor.getInt(cursor.getColumnIndexOrThrow("number_of_tracks"));
            }
            int albumCount = cursor.getInt(cursor.getColumnIndexOrThrow("number_of_albums"));
            Resources res = ArtistListingView.this.mActivity.getResources();
            wrapper.getTotalLabel().setText(res.getQuantityString(C0116R.plurals.album_song_count, songCount, new Object[]{Integer.valueOf(songCount)}) + ", " + res.getQuantityString(C0116R.plurals.album_count, albumCount, new Object[]{Integer.valueOf(albumCount)}));
            column = cursor.getColumnIndexOrThrow("artist_key");
            final String artistKey = cursor.getString(column);
            if (artistKey.equals(ArtistListingView.this.mCurrentToken)) {
                wrapper.getPlayIcon().setPlaying(true);
            } else {
                wrapper.getPlayIcon().setPlaying(false);
            }
            wrapper.getPlayIcon().setTag(cursor.getString(column));
            wrapper.getPlayIcon().setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!artistKey.equals(ArtistListingView.this.mCurrentToken)) {
                        Cursor songCursor = MediaUtils.getMediaStoreMergeCursor(ArtistListingView.this.mActivity, new String[]{"_id", "title_key"}, "artist_key = ?", new String[]{(String) v.getTag()}, "title_key ASC");
                        List<PlayableItem> playableList = Utils.createPlayableListFromCursor(songCursor);
                        songCursor.close();
                        try {
                            ArtistListingView.this.mService.setCurrentList(Constants.TOP_MENU_ARTISTS, (String) v.getTag());
                            ArtistListingView.this.mService.setPlayableList(playableList, 0);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            return view;
        }

        public Cursor swapCursor(Cursor aCursor) {
            this.mAlphaIndexer.setCursor(aCursor);
            return super.swapCursor(aCursor);
        }
    }

    public ArtistListingView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_ARTIST_LIST);
        setViewCategory(VIEW_CATEGORY);
        setHeaderViewText(this.mActivity.getString(C0116R.string.artist_header));
        setViewAnalyticsUri(Analytics.EVENT_MUSIC_ARTIST);
    }

    private void initArtistListingView() {
        if (this.mInitialized) {
            openCursors();
            this.mAdapter.swapCursor(this.mCursor);
            return;
        }
        this.mInflater = LayoutInflater.from(this.mActivity);
        this.mList = (ListView) this.mView.findViewById(C0116R.id.artist_listing_artist_list);
        openCursors();
        this.mAdapter = new ArtistListAdapter(this.mActivity.getApplicationContext(), C0116R.layout.artist_item, this.mCursor, new String[]{"artist"}, new int[]{C0116R.id.artist_item_artist_name});
        SearchListItem search = new SearchListItem(this.mActivity);
        this.mSearchBox = search.getSearchBox();
        this.mClearBox = search.getClearButton();
        this.mSearchBox.setOnEditorActionListener(new C02261());
        this.mSearchBox.setOnFocusChangeListener(new C02272());
        this.mList.setFastScrollEnabled(true);
        this.mList.addHeaderView(search.getView());
        this.mList.setAdapter(this.mAdapter);
        this.mList.setSelection(1);
        this.mList.setOnItemClickListener(new C02283());
        this.mSearchBox.addTextChangedListener(new C02294());
        this.mClearBox.setOnClickListener(new C02305());
        this.mListFooter = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
        this.mList.setOnScrollListener(new C02316());
        this.mList.setSelection(this.mList.getFirstItemPosition());
        setContextMenuView(this.mList);
        this.mInitialized = true;
    }

    public void onMediaServiceEvent(int aEvent) {
        super.onMediaServiceEvent(aEvent);
        switch (aEvent) {
            case 4:
                try {
                    this.mCurrentActivity = this.mService.getCurrentListActivity();
                    this.mCurrentToken = this.mService.getCurrentListToken();
                } catch (RemoteException e) {
                }
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
        initArtistListingView();
        registerContentObserver(this.mCursor, this.mAdapter, this.mList, getClass().getName(), 500);
    }

    public void onPause() {
        super.onPause();
        unregisterContentObserver(this.mCursor, getClass().getName());
        Utils.hideKeyboard(this.mActivity, this.mSearchBox.getWindowToken());
    }

    public void onStop() {
        super.onStop();
        if (isScrollIdle()) {
            closeCursorsDelayed();
        }
    }

    private void closeCursorsDelayed() {
        ContentBrowser.getHandler().postDelayed(new C02327(), 100);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.mList == aView) {
            AdapterContextMenuInfo adapterInfo = (AdapterContextMenuInfo) aMenuInfo;
            Cursor c = this.mCursor;
            if (this.mSearchBox.getText().length() > 0) {
                c = this.mFilterCursor;
            }
            c.moveToPosition(this.mList.adjusted(adapterInfo.position));
            String artistTitle = c.getString(c.getColumnIndex("artist"));
            aMenu.setHeaderTitle(artistTitle);
            String artistKey = c.getString(c.getColumnIndexOrThrow("artist_key"));
            ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, MediaUtils.getMediaStoreMergeCursor(this.mActivity, new String[]{"_id", "title_key"}, "artist_key = ?", new String[]{artistKey}, "title_key ASC"), artistTitle, true);
        }
    }

    private void openCursors() {
        this.mCursor = MediaUtils.getMediaStoreMergeCursorForArtist(this.mActivity, new String[]{"_id", "artist", "artist_key", "number_of_tracks", "number_of_albums"}, null, null, "artist_key ASC", false);
    }

    private void closeCursors() {
        try {
            if (!(this.mFilterCursor == null || this.mFilterCursor.isClosed())) {
                this.mFilterCursor.close();
            }
            if (!(this.mCursor == null || this.mCursor.isClosed())) {
                this.mCursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mFilterCursor = null;
        this.mCursor = null;
    }
}
