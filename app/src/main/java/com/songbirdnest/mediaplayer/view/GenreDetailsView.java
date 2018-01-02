package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Intent;
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
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.listObjects.CursorPopulator;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.mediaplayer.widgets.ListView;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;
import com.songbirdnest.util.MediaUtils;
import java.util.List;

public class GenreDetailsView extends BaseContentBrowserView {
    private static final int ALBUM = 1;
    private static final int ARTIST = 3;
    public static final int INVALIDATE = 1;
    private static final int SONG = 2;
    private static final String VIEW_CATEGORY = "music:genres";
    private int currentSongKey = -1;
    private BaseAdapter mAdapter;
    private TextView mAlbumCountLabel;
    private Cursor mAlbumCursor;
    private CursorPopulator mAlbumCursorPopulator;
    private TextView mArtistCountLabel;
    private Cursor mArtistCursor;
    private CursorPopulator mArtistCursorPopulator;
    private String mCurrentList;
    private View mFooterView;
    private String mGenreName;
    private boolean mGenreSongListInitialized = false;
    private LayoutInflater mInflater;
    private boolean mJumpToPlayingItem = true;
    private int mLastAlbumsPosition = -1;
    private int mLastAlbumsTopOffset = -1;
    private int mLastArtistsPosition = -1;
    private int mLastArtistsTopOffset = -1;
    private int mLastSongsPosition = -1;
    private int mLastSongsTopOffset = -1;
    private int mMenuChoser = 2;
    private TextView mSelectedSubMenu;
    private TextView mSongCountLabel;
    private Cursor mSongCursor;
    private ListView mSongList;
    private Handler resizeHandler = new C02391();

    class C02391 extends Handler {
        C02391() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (GenreDetailsView.this.mSongList != null && GenreDetailsView.this.mSongList.getAdapter() != null) {
                        GenreDetailsView.this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C02402 implements OnScrollListener {
        C02402() {
        }

        public void onScrollStateChanged(AbsListView aView, int aScrollState) {
            if (aScrollState != 0) {
                GenreDetailsView.this.mJumpToPlayingItem = false;
            }
            GenreDetailsView.this.setScrollState(aScrollState);
            if (GenreDetailsView.this.isViewStopped() && GenreDetailsView.this.isScrollIdle()) {
                GenreDetailsView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (GenreDetailsView.this.mSongList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    GenreDetailsView.this.mSongList.removeFooterView(GenreDetailsView.this.mFooterView);
                } else if (GenreDetailsView.this.mSongList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    GenreDetailsView.this.mSongList.addFooterView(GenreDetailsView.this.mFooterView);
                }
            }
        }
    }

    class C02413 implements OnItemClickListener {
        C02413() {
        }

        public void onItemClick(AdapterView<?> adapterView, View aView, int aPosition, long aId) {
            try {
                if (GenreDetailsView.this.mSongList.isShuffle(aPosition) && GenreDetailsView.this.mSongCursor.getCount() > 0) {
                    GenreDetailsView.this.mJumpToPlayingItem = true;
                    GenreDetailsView.this.mService.setCurrentList("Genre", GenreDetailsView.this.mGenreName);
                    GenreDetailsView.this.mService.setShuffledPlayableList(Utils.createPlayableListFromCursor(GenreDetailsView.this.mSongCursor));
                } else if (GenreDetailsView.this.mMenuChoser == 2) {
                    GenreDetailsView.this.mService.setCurrentList("Genre", GenreDetailsView.this.mGenreName);
                    ViewWrapper playIcon = (ViewWrapper) aView.getTag();
                    if (!playIcon.isPlaying()) {
                        GenreDetailsView.this.mService.setPlayableList(Utils.createPlayableListFromCursor(GenreDetailsView.this.mSongCursor), GenreDetailsView.this.mSongList.adjusted(aPosition));
                    } else if (playIcon.isPlaying() && GenreDetailsView.this.mService.isPaused()) {
                        GenreDetailsView.this.mService.play();
                    }
                } else if (GenreDetailsView.this.mMenuChoser == 1) {
                    i = new Intent(GenreDetailsView.this.mActivity, ContentBrowser.class);
                    i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_GENRE_ALBUM_DETAILS);
                    i.putExtra(Constants.EXTRA_ALBUM_KEY, (String) GenreDetailsView.this.mSongList.getAdapter().getItem(aPosition));
                    i.putExtra(Constants.EXTRA_GENRE_NAME, GenreDetailsView.this.mGenreName);
                    GenreDetailsView.this.mActivity.startActivity(i);
                } else if (GenreDetailsView.this.mMenuChoser == 3) {
                    i = new Intent(GenreDetailsView.this.mActivity, ContentBrowser.class);
                    i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_GENRE_SONG_LIST);
                    i.putExtra(Constants.EXTRA_ARTIST_KEY, (String) GenreDetailsView.this.mSongList.getAdapter().getItem(aPosition));
                    i.putExtra(Constants.EXTRA_GENRE_NAME, GenreDetailsView.this.mGenreName);
                    GenreDetailsView.this.mActivity.startActivity(i);
                }
            } catch (Exception e) {
            }
        }
    }

    class C02424 implements OnClickListener {
        C02424() {
        }

        public void onClick(View v) {
            if (GenreDetailsView.this.mMenuChoser != 2) {
                GenreDetailsView.this.switchToSongs();
            }
        }
    }

    class C02435 implements OnClickListener {
        C02435() {
        }

        public void onClick(View v) {
            if (GenreDetailsView.this.mMenuChoser != 3) {
                GenreDetailsView.this.switchToArtists();
            }
        }
    }

    class C02446 implements OnClickListener {
        C02446() {
        }

        public void onClick(View v) {
            if (GenreDetailsView.this.mMenuChoser != 1) {
                GenreDetailsView.this.switchToAlbums();
            }
        }
    }

    class C02457 implements Runnable {
        C02457() {
        }

        public void run() {
            GenreDetailsView.this.closeCursors();
        }
    }

    class GenreAlbumAdapter extends BaseAdapter {
        private int mRowHeight = 20;

        class ViewWrapper {
            private ImageView mAlbumArt;
            private TextView mAlbumName;
            private TextView mArtistName;
            private PlayIcon mPlayIcon;
            private TextView mSongTotal;
            private View mView;

            public ViewWrapper(View aView) {
                this.mView = aView;
            }

            public ImageView albumArt() {
                if (this.mAlbumArt == null) {
                    this.mAlbumArt = (ImageView) this.mView.findViewById(C0116R.id.album_item_album_art);
                }
                return this.mAlbumArt;
            }

            public TextView albumName() {
                if (this.mAlbumName == null) {
                    this.mAlbumName = (TextView) this.mView.findViewById(C0116R.id.album_item_album_text);
                }
                return this.mAlbumName;
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

            public void setVisible(int aVisibility) {
                this.mView.setVisibility(aVisibility);
            }

            public TextView songTotal() {
                if (this.mSongTotal == null) {
                    this.mSongTotal = (TextView) this.mView.findViewById(C0116R.id.album_item_song_total);
                }
                return this.mSongTotal;
            }
        }

        GenreAlbumAdapter() {
        }

        public int getCount() {
            if (GenreDetailsView.this.mAlbumCursor == null || GenreDetailsView.this.mAlbumCursor.isClosed()) {
                return 0;
            }
            return GenreDetailsView.this.mAlbumCursor.getCount();
        }

        public Object getItem(int aPosition) {
            GenreDetailsView.this.mAlbumCursor.moveToPosition(aPosition);
            return GenreDetailsView.this.mAlbumCursor.getString(GenreDetailsView.this.mAlbumCursor.getColumnIndexOrThrow("album_key"));
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int aPosition, View aConvertView, ViewGroup aParent) {
            if (aConvertView == null) {
                aConvertView = GenreDetailsView.this.mInflater.inflate(C0116R.layout.album_item, null);
                aConvertView.setTag(new ViewWrapper(aConvertView));
            }
            ViewWrapper wrapper = (ViewWrapper) aConvertView.getTag();
            GenreDetailsView.this.mAlbumCursor.moveToPosition(aPosition);
            wrapper.albumName().setText(GenreDetailsView.this.mAlbumCursor.getString(GenreDetailsView.this.mAlbumCursor.getColumnIndexOrThrow("album")));
            int column = GenreDetailsView.this.mAlbumCursor.getColumnIndexOrThrow("album_key");
            Cursor cursor = MediaUtils.getMediaStoreMergeCursorForGenre(GenreDetailsView.this.mActivity, new String[]{"COUNT(_id)"}, "album_key = ?", new String[]{GenreDetailsView.this.mAlbumCursor.getString(column)}, null, GenreDetailsView.this.mGenreName);
            wrapper.artistName().setText(GenreDetailsView.this.mAlbumCursor.getString(GenreDetailsView.this.mAlbumCursor.getColumnIndexOrThrow("artist")));
            int songCount = 0;
            while (cursor.moveToNext()) {
                songCount += cursor.getInt(0);
            }
            cursor.close();
            wrapper.songTotal().setText(aConvertView.getResources().getQuantityString(C0116R.plurals.album_song_count, songCount, new Object[]{Integer.valueOf(songCount)}));
            PlayIcon playIcon = wrapper.playIcon();
            if (playIcon.getHeight() > 0) {
                this.mRowHeight = Utils.calculateAlbumArt(playIcon.getHeight());
                wrapper.setVisible(0);
            } else {
                GenreDetailsView.this.resizeHandler.removeMessages(1);
                GenreDetailsView.this.resizeHandler.sendEmptyMessageDelayed(1, 1);
                wrapper.setVisible(4);
            }
            column = GenreDetailsView.this.mAlbumCursor.getColumnIndexOrThrow("album_art");
            if (GenreDetailsView.this.mAlbumCursor.getString(column) != null) {
                Bitmap albumArtBitmap = BitmapFactory.decodeFile(GenreDetailsView.this.mAlbumCursor.getString(column));
                if (albumArtBitmap == null) {
                    setDefaultAlbumArt(wrapper);
                } else {
                    wrapper.albumArt().setImageBitmap(Bitmap.createScaledBitmap(albumArtBitmap, this.mRowHeight, this.mRowHeight, true));
                    albumArtBitmap.recycle();
                }
            } else {
                setDefaultAlbumArt(wrapper);
            }
            final String albumKey = GenreDetailsView.this.mAlbumCursor.getString(GenreDetailsView.this.mAlbumCursor.getColumnIndexOrThrow("album_key"));
            playIcon.setTag(albumKey);
            if (albumPlaying(albumKey)) {
                playIcon.setPlaying(true);
            } else {
                playIcon.setPlaying(false);
            }
            playIcon.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!GenreAlbumAdapter.this.albumPlaying(albumKey)) {
                        Cursor songCursor = MediaUtils.getMediaStoreMergeCursorForGenre(GenreDetailsView.this.mActivity, new String[]{"_id", Analytics.TRACK_KEY}, "album_key = ?", new String[]{(String) v.getTag()}, "track ASC", GenreDetailsView.this.mGenreName);
                        List<PlayableItem> playableList = Utils.createPlayableListFromCursor(songCursor);
                        try {
                            if (playableList.size() != 0) {
                                GenreDetailsView.this.mService.setCurrentList(Constants.TOP_MENU_ALBUMS, albumKey);
                                GenreDetailsView.this.mService.setPlayableList(playableList, 0);
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        songCursor.close();
                    }
                }
            });
            return aConvertView;
        }

        private boolean albumPlaying(String albumKey) {
            try {
                return Constants.TOP_MENU_ALBUMS.equals(GenreDetailsView.this.mCurrentList) && GenreDetailsView.this.mService.getCurrentListToken().equals(albumKey);
            } catch (RemoteException e) {
                return false;
            }
        }

        private void setDefaultAlbumArt(ViewWrapper wrapper) {
            Bitmap albumArtBitmap = BitmapFactory.decodeResource(GenreDetailsView.this.mActivity.getResources(), C0116R.drawable.generic_album_small);
            wrapper.albumArt().setImageBitmap(Bitmap.createScaledBitmap(albumArtBitmap, this.mRowHeight, this.mRowHeight, true));
            albumArtBitmap.recycle();
        }
    }

    class GenreArtistAdapter extends BaseAdapter {

        class ViewWrapper {
            private TextView mArtistName;
            private PlayIcon mArtistPlayIcon;
            private TextView mArtistSongTotal;
            private View mView;

            public ViewWrapper(View aView) {
                this.mView = aView;
            }

            public TextView artistName() {
                if (this.mArtistName == null) {
                    this.mArtistName = (TextView) this.mView.findViewById(C0116R.id.artist_item_artist_name);
                }
                return this.mArtistName;
            }

            public PlayIcon playIcon() {
                if (this.mArtistPlayIcon == null) {
                    this.mArtistPlayIcon = (PlayIcon) this.mView.findViewById(C0116R.id.artist_item_play_icon);
                }
                return this.mArtistPlayIcon;
            }

            public TextView songTotal() {
                if (this.mArtistSongTotal == null) {
                    this.mArtistSongTotal = (TextView) this.mView.findViewById(C0116R.id.artist_item_song_total);
                }
                return this.mArtistSongTotal;
            }
        }

        GenreArtistAdapter() {
        }

        public int getCount() {
            if (GenreDetailsView.this.mArtistCursor == null || GenreDetailsView.this.mArtistCursor.isClosed()) {
                return 0;
            }
            return GenreDetailsView.this.mArtistCursor.getCount();
        }

        public Object getItem(int aPosition) {
            GenreDetailsView.this.mArtistCursor.moveToPosition(aPosition);
            return GenreDetailsView.this.mArtistCursor.getString(GenreDetailsView.this.mArtistCursor.getColumnIndexOrThrow("artist_key"));
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int aPosition, View aConvertView, ViewGroup aParent) {
            if (aConvertView == null) {
                aConvertView = GenreDetailsView.this.mInflater.inflate(C0116R.layout.artist_item, null);
                aConvertView.setTag(new ViewWrapper(aConvertView));
            }
            ViewWrapper wrapper = (ViewWrapper) aConvertView.getTag();
            GenreDetailsView.this.mArtistCursor.moveToPosition(aPosition);
            wrapper.artistName().setText(GenreDetailsView.this.mArtistCursor.getString(Integer.valueOf(GenreDetailsView.this.mArtistCursor.getColumnIndexOrThrow("artist")).intValue()));
            final String artistKey = GenreDetailsView.this.mArtistCursor.getString(Integer.valueOf(GenreDetailsView.this.mArtistCursor.getColumnIndexOrThrow("artist_key")).intValue());
            Cursor cursor = MediaUtils.getMediaStoreMergeCursorForGenre(GenreDetailsView.this.mActivity, new String[]{"COUNT(_id)"}, "artist_key = ?", new String[]{artistKey}, null, GenreDetailsView.this.mGenreName);
            int songCount = 0;
            while (cursor.moveToNext()) {
                songCount += cursor.getInt(0);
            }
            cursor.close();
            wrapper.songTotal().setText(aConvertView.getResources().getQuantityString(C0116R.plurals.album_song_count, songCount, new Object[]{Integer.valueOf(songCount)}));
            PlayIcon playIcon = wrapper.playIcon();
            if (artistPlaying(artistKey)) {
                playIcon.setPlaying(true);
            } else {
                playIcon.setPlaying(false);
            }
            playIcon.setTag(artistKey);
            playIcon.setOnClickListener(new OnClickListener() {
                public void onClick(View aView) {
                    if (!GenreArtistAdapter.this.artistPlaying(artistKey)) {
                        Cursor songCursor = MediaUtils.getMediaStoreMergeCursorForGenre(GenreDetailsView.this.mActivity, new String[]{"_id", "title_key"}, "artist_key = ?", new String[]{(String) aView.getTag()}, "title_key ASC", GenreDetailsView.this.mGenreName);
                        List<PlayableItem> playableList = Utils.createPlayableListFromCursor(songCursor);
                        try {
                            if (playableList.size() != 0) {
                                GenreDetailsView.this.mService.setCurrentList(Constants.TOP_MENU_ARTISTS, artistKey);
                                GenreDetailsView.this.mService.setPlayableList(playableList, 0);
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        songCursor.close();
                    }
                }
            });
            return aConvertView;
        }

        private boolean artistPlaying(String artistKey) {
            try {
                return Constants.TOP_MENU_ARTISTS.equals(GenreDetailsView.this.mCurrentList) && GenreDetailsView.this.mService.getCurrentListToken().equals(artistKey);
            } catch (RemoteException e) {
                return false;
            }
        }
    }

    class GenreSongListAdapter extends BaseAdapter {

        class ViewWrapper {
            private boolean mIsPlaying = false;
            private TextView mSongAlbumName = null;
            private TextView mSongArtistName = null;
            private TextView mSongDuration = null;
            private TextView mSongName = null;
            private ImageView mSongPlayIcon = null;
            private View mView;

            public ViewWrapper(View aView) {
                this.mView = aView;
            }

            public TextView albumName() {
                if (this.mSongAlbumName == null) {
                    this.mSongAlbumName = (TextView) this.mView.findViewById(C0116R.id.song_detail_album_name);
                }
                return this.mSongAlbumName;
            }

            public TextView artistName() {
                if (this.mSongArtistName == null) {
                    this.mSongArtistName = (TextView) this.mView.findViewById(C0116R.id.song_detail_artist_name);
                }
                return this.mSongArtistName;
            }

            public TextView duration() {
                if (this.mSongDuration == null) {
                    this.mSongDuration = (TextView) this.mView.findViewById(C0116R.id.song_detail_duration);
                }
                return this.mSongDuration;
            }

            public ImageView playIcon() {
                if (this.mSongPlayIcon == null) {
                    this.mSongPlayIcon = (ImageView) this.mView.findViewById(C0116R.id.song_detail_play_button);
                }
                return this.mSongPlayIcon;
            }

            public TextView songName() {
                if (this.mSongName == null) {
                    this.mSongName = (TextView) this.mView.findViewById(C0116R.id.song_detail_song_name);
                }
                return this.mSongName;
            }

            public boolean isPlaying() {
                return this.mIsPlaying;
            }

            public void setPlaying(boolean isPlaying) {
                this.mIsPlaying = isPlaying;
            }
        }

        GenreSongListAdapter() {
        }

        public int getCount() {
            if (GenreDetailsView.this.mSongCursor == null || GenreDetailsView.this.mSongCursor.isClosed()) {
                return 0;
            }
            return GenreDetailsView.this.mSongCursor.getCount();
        }

        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(final int aPosition, View aConvertView, ViewGroup aParent) {
            ViewWrapper wrapper;
            GenreDetailsView.this.mSongCursor.moveToPosition(aPosition);
            View view = aConvertView;
            if (aConvertView == null) {
                view = GenreDetailsView.this.mInflater.inflate(C0116R.layout.song_detail_item, null);
                wrapper = new ViewWrapper(view);
                view.setTag(wrapper);
            } else {
                wrapper = (ViewWrapper) view.getTag();
            }
            wrapper.songName().setText(GenreDetailsView.this.mSongCursor.getString(GenreDetailsView.this.mSongCursor.getColumnIndex("title")));
            wrapper.duration().setText(Utils.calculateTimeStamp(GenreDetailsView.this.mSongCursor.getInt(GenreDetailsView.this.mSongCursor.getColumnIndex("duration"))));
            wrapper.artistName().setText(GenreDetailsView.this.mSongCursor.getString(GenreDetailsView.this.mSongCursor.getColumnIndex("artist")));
            wrapper.albumName().setText(GenreDetailsView.this.mSongCursor.getString(GenreDetailsView.this.mSongCursor.getColumnIndex("album")));
            final int titleKey = GenreDetailsView.this.mSongCursor.getInt(GenreDetailsView.this.mSongCursor.getColumnIndexOrThrow("_id"));
            ImageView playIcon = wrapper.playIcon();
            if (songPlaying(titleKey)) {
                playIcon.setImageResource(C0116R.drawable.row_listening_button);
                wrapper.setPlaying(true);
            } else {
                playIcon.setImageResource(C0116R.drawable.row_play);
                wrapper.setPlaying(false);
            }
            playIcon.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    try {
                        if (!GenreSongListAdapter.this.songPlaying(titleKey)) {
                            List<PlayableItem> playableList = Utils.createPlayableListFromCursor(GenreDetailsView.this.mSongCursor);
                            if (playableList.size() != 0) {
                                GenreDetailsView.this.mService.setCurrentList("Genre", GenreDetailsView.this.mGenreName);
                                GenreDetailsView.this.mService.setPlayableList(playableList, aPosition);
                            }
                        } else if (GenreSongListAdapter.this.songPlaying(titleKey) && GenreDetailsView.this.mService.isPaused()) {
                            GenreDetailsView.this.mService.play();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
            return view;
        }

        private boolean songPlaying(int songKey) {
            return "Genre".equals(GenreDetailsView.this.mCurrentList) && GenreDetailsView.this.currentSongKey == songKey;
        }
    }

    public GenreDetailsView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_GENRE_DETAILS);
        setViewCategory(VIEW_CATEGORY);
    }

    protected void initGenreView() {
        unregisterContentObserver(this.mSongCursor, getClass().getName() + "-Song");
        initGenreViewImpl();
        registerContentObserver(this.mSongCursor, this.mAdapter, this.mSongList, getClass().getName() + "-Song", 500);
    }

    protected void initGenreViewImpl() {
        String genreName = this.mActivity.getIntent().getExtras().getString(Constants.EXTRA_GENRE_NAME);
        if ((this.mGenreName == null || !this.mGenreName.equals(genreName)) && genreName != null) {
            this.mGenreName = genreName;
            setHeaderViewText(this.mGenreName);
            this.mInflater = LayoutInflater.from(this.mActivity);
            this.mSongCursor = getSongCursor();
            if (this.mGenreSongListInitialized) {
                populateAlbum();
                populateArtist();
                this.mAlbumCursor = getAlbumCursor();
                this.mArtistCursor = getArtistCursor();
                this.mAdapter.notifyDataSetChanged();
                this.mSongList.invalidateViews();
                return;
            }
            populateAlbum();
            populateArtist();
            this.mSongList = (ListView) this.mView.findViewById(C0116R.id.genre_details_song_list);
            this.mSongList.setOnScrollListener(new C02402());
            this.mFooterView = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
            this.mSongList.addFooterView(this.mFooterView);
            this.mAdapter = new GenreSongListAdapter();
            if (this.mAdapter.getCount() > 1) {
                this.mSongList.addHeaderView(this.mInflater.inflate(C0116R.layout.shuffle_view, null));
            }
            this.mSongList.setAdapter(this.mAdapter);
            this.mSongList.removeFooterView(this.mFooterView);
            this.mSongList.setOnItemClickListener(new C02413());
            this.mSongCountLabel = (TextView) this.mView.findViewById(C0116R.id.genre_details_song_count);
            selectSubMenu(this.mSongCountLabel);
            Analytics.getAnalytics().track("/music/genres/<genre_name>/songs");
            Resources res = this.mActivity.getResources();
            this.mSongCountLabel.setText(res.getString(C0116R.string.songs_header));
            this.mSongCountLabel.setOnClickListener(new C02424());
            this.mArtistCountLabel = (TextView) this.mView.findViewById(C0116R.id.genre_details_artist_count);
            this.mArtistCountLabel.setText(res.getString(C0116R.string.artist_header));
            this.mArtistCountLabel.setOnClickListener(new C02435());
            this.mAlbumCountLabel = (TextView) this.mView.findViewById(C0116R.id.genre_details_album_count);
            this.mAlbumCountLabel.setText(res.getString(C0116R.string.album_header));
            this.mAlbumCountLabel.setOnClickListener(new C02446());
            setContextMenuView(this.mSongList);
            this.mGenreSongListInitialized = true;
            return;
        }
        if (this.mSongCursor == null || this.mSongCursor.isClosed()) {
            this.mSongCursor = getSongCursor();
        }
        if (this.mAlbumCursor == null || this.mAlbumCursor.isClosed()) {
            this.mAlbumCursor = getAlbumCursor();
        }
        if (this.mArtistCursor == null || this.mArtistCursor.isClosed()) {
            this.mArtistCursor = getArtistCursor();
        }
    }

    public void onMediaServiceConnected() {
        super.onMediaServiceConnected();
        jumpToPlayingItem();
    }

    public void onMediaServiceEvent(int aEvent) {
        super.onMediaServiceEvent(aEvent);
        switch (aEvent) {
            case 4:
                try {
                    this.mCurrentList = this.mService.getCurrentListActivity();
                    this.currentSongKey = this.mService.getCurrentSongToken();
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
        initGenreView();
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
    }

    public void onStop() {
        super.onStop();
        if (isScrollIdle()) {
            closeCursorsDelayed();
        }
    }

    private void closeCursorsDelayed() {
        ContentBrowser.getHandler().postDelayed(new C02457(), 100);
    }

    private void closeCursors() {
        try {
            if (!(this.mSongCursor == null || this.mSongCursor.isClosed())) {
                this.mSongCursor.close();
            }
            if (!(this.mAlbumCursor == null || this.mAlbumCursor.isClosed())) {
                this.mAlbumCursor.close();
            }
            if (!(this.mArtistCursor == null || this.mArtistCursor.isClosed())) {
                this.mArtistCursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mSongCursor = null;
        this.mAlbumCursor = null;
        this.mArtistCursor = null;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void buildContextMenuForSongs(ContextMenu aMenu, View aView, AdapterContextMenuInfo aAdapterInfo) {
        this.mSongCursor.moveToPosition(this.mSongList.adjusted(aAdapterInfo.position));
        final String songTitle = this.mSongCursor.getString(this.mSongCursor.getColumnIndex("title"));
        aMenu.setHeaderTitle(songTitle);
        final int itemId = this.mSongCursor.getInt(this.mSongCursor.getColumnIndex("_id"));
        final String itemVolume = Utils.getVolumeFromCursor(this.mSongCursor);
        ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, itemId, itemVolume, songTitle, true);
        if (Utils.hasPhone(this.mActivity)) {
            aMenu.add(C0116R.string.playlist_listing_menu_set_ringtone).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem item) {
                    Utils.setItemAsRingtone(GenreDetailsView.this.mActivity, itemId, itemVolume);
                    Utils.showShortToast(GenreDetailsView.this.mActivity, GenreDetailsView.this.mActivity.getString(C0116R.string.playlist_set_ringtone_message, new Object[]{songTitle}));
                    return true;
                }
            });
        }
    }

    protected void buildContextMenuForAlbums(ContextMenu aMenu, View aView, AdapterContextMenuInfo aAdapterInfo) {
        this.mAlbumCursor.moveToPosition(this.mSongList.adjusted(aAdapterInfo.position));
        String albumTitle = this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndex("album"));
        aMenu.setHeaderTitle(albumTitle);
        String albumKey = this.mAlbumCursor.getString(this.mAlbumCursor.getColumnIndex("album_key"));
        ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"_id", Analytics.TRACK_KEY}, "album_key = ?", new String[]{albumKey}, "track ASC", this.mGenreName), albumTitle, true);
    }

    protected void buildContextMenuForArtists(ContextMenu aMenu, View aView, AdapterContextMenuInfo aAdapterInfo) {
        this.mArtistCursor.moveToPosition(this.mSongList.adjusted(aAdapterInfo.position));
        String artistTitle = this.mArtistCursor.getString(this.mArtistCursor.getColumnIndex("artist"));
        aMenu.setHeaderTitle(artistTitle);
        String artistKey = this.mArtistCursor.getString(this.mArtistCursor.getColumnIndex("artist_key"));
        ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"_id", "title_key"}, "artist_key = ?", new String[]{artistKey}, "title_key ASC", this.mGenreName), artistTitle, true);
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.mSongList == aView) {
            AdapterContextMenuInfo adapterInfo = (AdapterContextMenuInfo) aMenuInfo;
            if (!this.mSongList.isShuffle(adapterInfo.position)) {
                if (this.mMenuChoser == 2) {
                    buildContextMenuForSongs(aMenu, aView, adapterInfo);
                } else if (this.mMenuChoser == 1) {
                    buildContextMenuForAlbums(aMenu, aView, adapterInfo);
                } else {
                    buildContextMenuForArtists(aMenu, aView, adapterInfo);
                }
            }
        }
    }

    private void switchToSongs() {
        saveLastListPosition();
        selectSubMenu(this.mSongCountLabel);
        this.mMenuChoser = 2;
        if (this.mSongCursor == null || this.mSongCursor.isClosed()) {
            this.mSongCursor = getSongCursor();
        }
        this.mAdapter = new GenreSongListAdapter();
        if (this.mSongList.getFooterViewsCount() == 0) {
            this.mSongList.addFooterView(this.mFooterView);
        }
        this.mSongList.setAdapter(this.mAdapter);
        this.mSongList.removeFooterView(this.mFooterView);
        restoreLastListPosition();
        Analytics.getAnalytics().track("/music/genres/<genre_name>/songs");
    }

    private void switchToAlbums() {
        saveLastListPosition();
        selectSubMenu(this.mAlbumCountLabel);
        this.mMenuChoser = 1;
        if (this.mAlbumCursorPopulator.getCount() > 0) {
            if (this.mAlbumCursor == null || this.mAlbumCursor.isClosed()) {
                this.mAlbumCursor = getAlbumCursor();
            }
            this.mAdapter = new GenreAlbumAdapter();
            if (this.mSongList.getFooterViewsCount() == 0) {
                this.mSongList.addFooterView(this.mFooterView);
            }
            this.mSongList.setAdapter(this.mAdapter);
            this.mSongList.removeFooterView(this.mFooterView);
            restoreLastListPosition();
            Analytics.getAnalytics().track("/music/genres/<genre_name>/albums");
        }
    }

    private void switchToArtists() {
        saveLastListPosition();
        selectSubMenu(this.mArtistCountLabel);
        this.mMenuChoser = 3;
        if (this.mArtistCursorPopulator.getCount() > 0) {
            if (this.mArtistCursor == null || this.mArtistCursor.isClosed()) {
                this.mArtistCursor = getArtistCursor();
            }
            this.mAdapter = new GenreArtistAdapter();
            if (this.mSongList.getFooterViewsCount() == 0) {
                this.mSongList.addFooterView(this.mFooterView);
            }
            this.mSongList.setAdapter(this.mAdapter);
            this.mSongList.removeFooterView(this.mFooterView);
            restoreLastListPosition();
            Analytics.getAnalytics().track("/music/genres/<genre_name>/artists");
        }
    }

    private String buildGetAlbumString() {
        if (this.mAlbumCursorPopulator.getCount() <= 0) {
            return null;
        }
        String tempString = "album_key = ?";
        for (int i = 1; i < this.mAlbumCursorPopulator.getCount(); i++) {
            tempString = tempString + " OR album_key = ?";
        }
        return tempString;
    }

    private String buildGetArtistString() {
        if (this.mArtistCursorPopulator.getCount() <= 0) {
            return null;
        }
        String tempString = "artist_key = ?";
        for (int i = 1; i < this.mArtistCursorPopulator.getCount(); i++) {
            tempString = tempString + " OR artist_key = ?";
        }
        return tempString;
    }

    private String[] getAlbumList() {
        if (this.mAlbumCursorPopulator.getCount() == 0) {
            return new String[]{"t"};
        }
        String[] tempArray = new String[this.mAlbumCursorPopulator.getCount()];
        for (int i = 0; i < this.mAlbumCursorPopulator.getCount(); i++) {
            tempArray[i] = this.mAlbumCursorPopulator.getKey(i);
        }
        return tempArray;
    }

    private String[] getArtistList() {
        if (this.mArtistCursorPopulator.getCount() == 0) {
            return new String[]{"t"};
        }
        String[] tempArray = new String[this.mArtistCursorPopulator.getCount()];
        for (int i = 0; i < this.mArtistCursorPopulator.getCount(); i++) {
            tempArray[i] = this.mArtistCursorPopulator.getKey(i);
        }
        return tempArray;
    }

    private void populateAlbum() {
        this.mAlbumCursorPopulator = new CursorPopulator(MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"album", "album_key"}, null, null, "album_key ASC", this.mGenreName), "album", "album_key");
    }

    private void populateArtist() {
        this.mArtistCursorPopulator = new CursorPopulator(MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"artist", "artist_key"}, null, null, "artist_key ASC", this.mGenreName), "artist", "artist_key");
    }

    private Cursor getSongCursor() {
        return MediaUtils.getMediaStoreMergeCursorForGenre(this.mActivity, new String[]{"title_key", "title", "duration", "artist", "album", "_id"}, null, null, "title_key ASC", this.mGenreName);
    }

    private Cursor getAlbumCursor() {
        return MediaUtils.getMediaStoreMergeCursorForAlbum(this.mActivity, new String[]{"album", "album_art", "artist", "album_key", "numsongs"}, buildGetAlbumString(), getAlbumList(), "album_key ASC");
    }

    private Cursor getArtistCursor() {
        return MediaUtils.getMediaStoreMergeCursorForArtist(this.mActivity, new String[]{"artist_key", "artist", "number_of_tracks"}, buildGetArtistString(), getArtistList(), "artist_key ASC", false);
    }

    private void saveLastListPosition() {
        if (this.mSongList.getChildCount() != 0) {
            int firstVisiblePosition = this.mSongList.getFirstVisiblePosition();
            int topOffset = this.mSongList.getChildAt(0).getTop();
            switch (this.mMenuChoser) {
                case 1:
                    this.mLastAlbumsPosition = firstVisiblePosition;
                    this.mLastAlbumsTopOffset = topOffset;
                    return;
                case 2:
                    this.mLastSongsPosition = firstVisiblePosition;
                    this.mLastSongsTopOffset = topOffset;
                    return;
                case 3:
                    this.mLastArtistsPosition = firstVisiblePosition;
                    this.mLastArtistsTopOffset = topOffset;
                    return;
                default:
                    return;
            }
        }
    }

    private void restoreLastListPosition() {
        int firstVisiblePosition = -1;
        int topOffset = 0;
        switch (this.mMenuChoser) {
            case 1:
                firstVisiblePosition = this.mLastAlbumsPosition;
                topOffset = this.mLastAlbumsTopOffset;
                break;
            case 2:
                firstVisiblePosition = this.mLastSongsPosition;
                topOffset = this.mLastSongsTopOffset;
                break;
            case 3:
                firstVisiblePosition = this.mLastArtistsPosition;
                topOffset = this.mLastArtistsTopOffset;
                break;
        }
        if (firstVisiblePosition != -1) {
            this.mSongList.setSelectionFromTop(firstVisiblePosition, topOffset);
        }
    }

    private void selectSubMenu(TextView aSelected) {
        if (this.mSelectedSubMenu != null) {
            this.mSelectedSubMenu.setSelected(false);
        }
        this.mSelectedSubMenu = aSelected;
        this.mSelectedSubMenu.setSelected(true);
    }

    protected void jumpToPlayingItem() {
        if (this.mJumpToPlayingItem) {
            try {
                if (this.mService != null && this.mSongList != null && "Genre".equals(this.mService.getCurrentListActivity()) && this.mGenreName.equals(this.mService.getCurrentListToken())) {
                    this.mSongList.setSelection(Math.max(0, this.mService.getListPosition()), true);
                }
            } catch (RemoteException e) {
            }
        }
    }
}
