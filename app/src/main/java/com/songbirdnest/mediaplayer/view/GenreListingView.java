package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.ContextMenuUtils;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;
import com.songbirdnest.util.MediaUtils;
import java.util.List;

public class GenreListingView extends BaseContentBrowserView {
    private static final String VIEW_CATEGORY = "music:genres";
    private GenreListAdaptor adapter;
    private Cursor cursor;
    private ListView genreList;
    private LayoutInflater inflator;
    private boolean mInitialized = false;
    private View myFooter;

    class C02501 implements OnItemClickListener {
        C02501() {
        }

        public void onItemClick(AdapterView<?> adapterView, View baseView, int position, long arg3) {
            GenreListingView.this.cursor.moveToPosition(position);
            String genreName = GenreListingView.this.cursor.getString(GenreListingView.this.cursor.getColumnIndex(CookieTable.NAME));
            if (GenreListingView.this.getGenreCountByName(genreName) > 0) {
                Intent i = new Intent(GenreListingView.this.mActivity, ContentBrowser.class);
                i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_GENRE_DETAILS);
                i.putExtra(Constants.EXTRA_GENRE_NAME, genreName);
                GenreListingView.this.mActivity.startActivity(i);
                return;
            }
            Toast.makeText(GenreListingView.this.mActivity, GenreListingView.this.mActivity.getResources().getString(C0116R.string.no_songs_for_genre), 1).show();
        }
    }

    class C02512 implements OnScrollListener {
        C02512() {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            GenreListingView.this.setScrollState(scrollState);
            if (GenreListingView.this.isViewStopped() && GenreListingView.this.isScrollIdle()) {
                GenreListingView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (GenreListingView.this.genreList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    GenreListingView.this.genreList.removeFooterView(GenreListingView.this.myFooter);
                } else if (GenreListingView.this.genreList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    GenreListingView.this.genreList.addFooterView(GenreListingView.this.myFooter);
                }
            }
        }
    }

    class C02523 implements Runnable {
        C02523() {
        }

        public void run() {
            GenreListingView.this.closeCursors();
        }
    }

    class GenreListAdaptor extends BaseAdapter {

        class ViewWrapper {
            private View base;
            private TextView genreCount;
            private TextView genreName;
            private PlayIcon playIcon;

            public ViewWrapper(View base) {
                this.base = base;
            }

            public TextView getGenreName() {
                if (this.genreName == null) {
                    this.genreName = (TextView) this.base.findViewById(C0116R.id.genre_item_genre_name);
                }
                return this.genreName;
            }

            public PlayIcon getPlayIcon() {
                if (this.playIcon == null) {
                    this.playIcon = (PlayIcon) this.base.findViewById(C0116R.id.genre_item_play_button);
                }
                return this.playIcon;
            }

            public TextView getGenreCount() {
                if (this.genreCount == null) {
                    this.genreCount = (TextView) this.base.findViewById(C0116R.id.genre_item_genre_count);
                }
                return this.genreCount;
            }
        }

        GenreListAdaptor() {
        }

        public int getCount() {
            if (GenreListingView.this.cursor == null || GenreListingView.this.cursor.isClosed()) {
                return 0;
            }
            return GenreListingView.this.cursor.getCount();
        }

        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewWrapper wrapper;
            GenreListingView.this.cursor.moveToPosition(position);
            View view = convertView;
            if (convertView == null) {
                view = GenreListingView.this.inflator.inflate(C0116R.layout.genre_item, null);
                wrapper = new ViewWrapper(view);
                view.setTag(wrapper);
            } else {
                wrapper = (ViewWrapper) view.getTag();
            }
            final String genreName = GenreListingView.this.cursor.getString(GenreListingView.this.cursor.getColumnIndex(CookieTable.NAME));
            wrapper.getGenreName().setText(genreName);
            if (isGenrePlaying(genreName)) {
                wrapper.getPlayIcon().setPlaying(true);
            } else {
                wrapper.getPlayIcon().setPlaying(false);
            }
            final int countHolder = GenreListingView.this.getGenreCountByName(genreName);
            wrapper.getGenreCount().setText(GenreListingView.this.mActivity.getResources().getQuantityString(C0116R.plurals.album_song_count, countHolder, new Object[]{Integer.valueOf(countHolder)}));
            wrapper.getPlayIcon().setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!GenreListAdaptor.this.isGenrePlaying(genreName)) {
                        if (countHolder > 0) {
                            try {
                                GenreListingView.this.mService.setCurrentList("Genre", genreName);
                                GenreListingView.this.mService.setPlayableList(GenreListingView.this.buildPlayableList(genreName), 0);
                                return;
                            } catch (RemoteException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        Toast.makeText(GenreListingView.this.mActivity, GenreListingView.this.mActivity.getResources().getString(C0116R.string.no_songs_for_genre), 1).show();
                    }
                }
            });
            return view;
        }

        private boolean isGenrePlaying(String aGenreName) {
            try {
                return "Genre".equals(GenreListingView.this.mService.getCurrentListActivity()) && aGenreName.equals(GenreListingView.this.mService.getCurrentListToken());
            } catch (Exception e) {
                return false;
            }
        }
    }

    public GenreListingView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_GENRE_LIST);
        setViewCategory(VIEW_CATEGORY);
        setHeaderViewText(this.mActivity.getString(C0116R.string.genre_header));
        setViewAnalyticsUri(Analytics.EVENT_MUSIC_GENRES);
    }

    private void initGenreListingView() {
        if (this.mInitialized) {
            openCursors();
            return;
        }
        openCursors();
        this.inflator = LayoutInflater.from(this.mActivity);
        this.adapter = new GenreListAdaptor();
        this.genreList = (ListView) this.mView.findViewById(C0116R.id.genre_list);
        this.myFooter = this.inflator.inflate(C0116R.layout.list_footer_view, null);
        this.genreList.addFooterView(this.myFooter);
        this.genreList.setAdapter(this.adapter);
        this.genreList.removeFooterView(this.myFooter);
        this.genreList.setOnItemClickListener(new C02501());
        this.genreList.setOnScrollListener(new C02512());
        setContextMenuView(this.genreList);
        this.mInitialized = true;
    }

    public void onMediaServiceEvent(int aEvent) {
        super.onMediaServiceEvent(aEvent);
        switch (aEvent) {
            case 4:
                if (this.adapter != null) {
                    this.adapter.notifyDataSetChanged();
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
        initGenreListingView();
        registerContentObserver(this.cursor, this.adapter, this.genreList, getClass().getName(), 500);
    }

    public void onPause() {
        super.onPause();
        unregisterContentObserver(this.cursor, getClass().getName());
    }

    public void onStop() {
        super.onStop();
        if (isScrollIdle()) {
            closeCursorsDelayed();
        }
    }

    private void closeCursorsDelayed() {
        ContentBrowser.getHandler().postDelayed(new C02523(), 100);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.genreList == aView) {
            this.cursor.moveToPosition(((AdapterContextMenuInfo) aMenuInfo).position);
            String genreName = this.cursor.getString(this.cursor.getColumnIndex(CookieTable.NAME));
            aMenu.setHeaderTitle(genreName);
            ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"_id", "title_key"}, null, null, "title_key ASC", genreName), genreName, true);
        }
    }

    private List<PlayableItem> buildPlayableList(String aGenreName) {
        Cursor songCursor = MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"_id", "title_key"}, null, null, "title_key ASC", aGenreName);
        List<PlayableItem> playableList = Utils.createPlayableListFromCursor(songCursor);
        songCursor.close();
        return playableList;
    }

    private int getGenreCountByName(String aGenreName) {
        int count = 0;
        try {
            Cursor genreMembersCursor = MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"COUNT(_id)"}, null, null, null, aGenreName);
            while (genreMembersCursor.moveToNext()) {
                count += genreMembersCursor.getInt(0);
            }
            genreMembersCursor.close();
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    private void openCursors() {
        this.cursor = MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"_id", CookieTable.NAME}, null, null, "name ASC", false);
    }

    private void closeCursors() {
        try {
            if (!(this.cursor == null || this.cursor.isClosed())) {
                this.cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.cursor = null;
    }
}
