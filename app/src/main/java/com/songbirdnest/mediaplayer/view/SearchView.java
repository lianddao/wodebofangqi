package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.provider.MediaStore.Video.Thumbnails;
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
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.Model.Podcast;
import com.songbirdnest.database.Model.Song;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.ContextMenuUtils;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.activities.ViewVideo;
import com.songbirdnest.mediaplayer.widgets.ListWatch;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;
import com.songbirdnest.mediaplayer.widgets.ScreenKeyboardCaller;
import com.songbirdnest.util.MediaUtils;
import java.util.ArrayList;
import java.util.List;

public class SearchView extends BaseContentBrowserView {
    static final int ALBUM_ID = 1;
    static final int ARTIST_ID = 3;
    static final int HOLDER_ID = 5;
    static final int PLAYLIST_ID = 4;
    static final int PODCAST_ID = 7;
    static final int SONG_ID = 2;
    static final int VIDEO_ID = 6;
    private static final String VIEW_CATEGORY = "search";
    private SearchAdapter adapter;
    private Cursor albumCursor;
    private Cursor artistCursor;
    private Integer currentSong;
    private String currentToken;
    private View footer;
    private View frontPanel;
    final InputMethodManager imm;
    private LayoutInflater inflater;
    private Cursor playlistCursor;
    private Cursor podcastCursor;
    private int rowHeight = 50;
    private ListWatch searchList;
    private ScreenKeyboardCaller searchText;
    private Cursor songCursor;
    Handler tempHandler = new C03813();
    private Cursor videoCursor;
    private ImageView xImage;

    class C03791 implements Runnable {
        C03791() {
        }

        public void run() {
            SearchView.this.getHeaderView().setVisibility(8);
        }
    }

    class C03813 extends Handler {
        C03813() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    SearchView.this.reFocus();
                    return;
                default:
                    return;
            }
        }
    }

    class C03824 implements OnClickListener {
        C03824() {
        }

        public void onClick(View v) {
            SearchView.this.searchText.setText("");
        }
    }

    class C03835 implements OnClickListener {
        C03835() {
        }

        public void onClick(View v) {
            SearchView.this.imm.hideSoftInputFromWindow(SearchView.this.searchText.getWindowToken(), 0);
        }
    }

    class C03846 implements OnEditorActionListener {
        C03846() {
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == 3) {
                SearchView.this.imm.hideSoftInputFromWindow(SearchView.this.searchText.getWindowToken(), 0);
            }
            return false;
        }
    }

    class C03857 implements TextWatcher {
        C03857() {
        }

        public void afterTextChanged(Editable s) {
            SearchView.this.setupCursors();
            SearchView.this.adapter.notifyDataSetChanged();
            SearchView.this.searchList.invalidateViews();
            if (s.toString().equals("")) {
                SearchView.this.frontPanel.setClickable(true);
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (SearchView.this.searchList.getFooterViewsCount() > 0) {
                SearchView.this.searchList.removeFooterView(SearchView.this.footer);
            }
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    class C03868 implements OnScrollListener {
        C03868() {
        }

        public void onScrollStateChanged(AbsListView aView, int aScrollState) {
            switch (aScrollState) {
                case 1:
                    SearchView.this.hideSoftInput();
                    return;
                default:
                    return;
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if ((SearchView.this.searchList.getFooterViewsCount() <= 0 || visibleItemCount != totalItemCount) && SearchView.this.searchList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    SearchView.this.searchList.addFooterView(SearchView.this.footer);
                }
            }
        }
    }

    class C03879 implements OnItemClickListener {
        C03879() {
        }

        public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
            SearchView.this.adapter.onClick(arg1);
        }
    }

    class SearchAdapter extends BaseAdapter implements OnClickListener {
        private static final int SEARCH_VIEW_DISMISS_MINIMUM = 4;
        TextView holder;

        class C03892 implements OnClickListener {
            C03892() {
            }

            public void onClick(View v) {
                Intent videoPlay = new Intent(SearchView.this.mActivity, ViewVideo.class);
                videoPlay.putExtra("videofilename", (Integer) v.getTag());
                videoPlay.putExtra("idList", new int[]{curId.intValue()});
                try {
                    SearchView.this.mService.pause();
                } catch (RemoteException e) {
                }
                SearchView.this.mActivity.startActivity(videoPlay);
            }
        }

        abstract class WrapperCommon {
            int viewID;

            WrapperCommon() {
            }

            public int getViewID() {
                return this.viewID;
            }

            public void setViewID(int viewID) {
                this.viewID = viewID;
            }
        }

        class AlbumWrapper extends WrapperCommon {
            ImageView albumArt = null;
            String albumKey;
            TextView albumLabel = null;
            TextView artistLabel = null;
            View base;
            int cursorPos = -1;
            PlayIcon playIcon = null;
            TextView songTotalLabel = null;

            public AlbumWrapper(View base, int viewID, int cursorPos) {
                super();
                this.viewID = viewID;
                this.base = base;
                this.cursorPos = cursorPos;
            }

            public ImageView getAlbumArt() {
                if (this.albumArt == null) {
                    this.albumArt = (ImageView) this.base.findViewById(C0116R.id.album_item_album_art);
                }
                return this.albumArt;
            }

            public String getAlbumKey() {
                return this.albumKey;
            }

            public TextView getAlbumLabel() {
                if (this.albumLabel == null) {
                    this.albumLabel = (TextView) this.base.findViewById(C0116R.id.album_item_album_text);
                }
                return this.albumLabel;
            }

            public TextView getArtistLabel() {
                if (this.artistLabel == null) {
                    this.artistLabel = (TextView) this.base.findViewById(C0116R.id.album_item_artist_text);
                }
                return this.artistLabel;
            }

            public PlayIcon getPlayIcon() {
                if (this.playIcon == null) {
                    this.playIcon = (PlayIcon) this.base.findViewById(C0116R.id.album_item_play_icon);
                }
                return this.playIcon;
            }

            public TextView getSongTotalLabel() {
                if (this.songTotalLabel == null) {
                    this.songTotalLabel = (TextView) this.base.findViewById(C0116R.id.album_item_song_total);
                }
                return this.songTotalLabel;
            }

            public void setAlbumKey(String albumKey) {
                this.albumKey = albumKey;
            }

            public int getCursorPos() {
                return this.cursorPos;
            }
        }

        class ArtistWrapper extends WrapperCommon {
            private String artistKey;
            private TextView artistLabel;
            private View base;
            private int cursorPos = -1;
            private PlayIcon playIcon;
            private TextView totalLabel;

            public ArtistWrapper(View base, int viewID, int cursorPos) {
                super();
                this.viewID = viewID;
                this.base = base;
                this.cursorPos = cursorPos;
            }

            public TextView getArtistLabel() {
                if (this.artistLabel == null) {
                    this.artistLabel = (TextView) this.base.findViewById(C0116R.id.artist_item_artist_name);
                }
                return this.artistLabel;
            }

            public PlayIcon getPlayIcon() {
                if (this.playIcon == null) {
                    this.playIcon = (PlayIcon) this.base.findViewById(C0116R.id.artist_item_play_icon);
                }
                return this.playIcon;
            }

            public TextView getTotalLabel() {
                if (this.totalLabel == null) {
                    this.totalLabel = (TextView) this.base.findViewById(C0116R.id.artist_item_song_total);
                }
                return this.totalLabel;
            }

            public int getCursorPos() {
                return this.cursorPos;
            }

            public void setArtistKey(String aArtistKey) {
                this.artistKey = aArtistKey;
            }

            public String getArtistKey() {
                return this.artistKey;
            }
        }

        class PlaylistWrapper extends WrapperCommon {
            View base;
            PlayIcon playIcon;
            TextView playlistName;
            TextView playlistTotal;

            public PlaylistWrapper(View base, int viewID) {
                super();
                this.viewID = viewID;
                this.base = base;
            }

            public PlayIcon getPlayIcon() {
                if (this.playIcon == null) {
                    this.playIcon = (PlayIcon) this.base.findViewById(C0116R.id.playlist_icon_play_icon);
                }
                return this.playIcon;
            }

            public TextView getPlaylistName() {
                if (this.playlistName == null) {
                    this.playlistName = (TextView) this.base.findViewById(C0116R.id.playlist_item_playlist_name);
                }
                return this.playlistName;
            }

            public TextView getPlaylistTotal() {
                if (this.playlistTotal == null) {
                    this.playlistTotal = (TextView) this.base.findViewById(C0116R.id.playlist_item_song_total);
                }
                return this.playlistTotal;
            }
        }

        class SongWrapper extends WrapperCommon {
            TextView albumName = null;
            TextView artistName = null;
            View base;
            int cursorPos = -1;
            TextView duration = null;
            boolean isPlaying = false;
            ImageView playIcon = null;
            TextView songName = null;

            public SongWrapper(View base, int viewID, int cursorPos) {
                super();
                this.viewID = viewID;
                this.base = base;
                this.cursorPos = cursorPos;
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

            public ImageView getPlayIcon() {
                if (this.playIcon == null) {
                    this.playIcon = (ImageView) this.base.findViewById(C0116R.id.song_detail_play_button);
                }
                return this.playIcon;
            }

            public TextView getSongName() {
                if (this.songName == null) {
                    this.songName = (TextView) this.base.findViewById(C0116R.id.song_detail_song_name);
                }
                return this.songName;
            }

            public boolean isPlaying() {
                return this.isPlaying;
            }

            public void setPlaying(boolean isPlaying) {
                this.isPlaying = isPlaying;
            }

            public int getCursorPos() {
                return this.cursorPos;
            }
        }

        class PodcastWrapper extends SongWrapper {
            public PodcastWrapper(View base, int viewID, int cursorPos) {
                super(base, viewID, cursorPos);
            }
        }

        class SpacerWrapper extends WrapperCommon {
            SpacerWrapper() {
                super();
            }
        }

        class VideoWrapper extends WrapperCommon {
            View base;
            TextView duration = null;
            ImageView playIcon = null;
            ImageView thumb = null;
            TextView title = null;
            String viewType;

            public VideoWrapper(View base, int viewID) {
                super();
                this.base = base;
                this.viewID = viewID;
            }

            public TextView getDuration() {
                if (this.duration == null) {
                    this.duration = (TextView) this.base.findViewById(C0116R.id.video_detail_duration);
                }
                return this.duration;
            }

            public ImageView getPlayIcon() {
                if (this.playIcon == null) {
                    this.playIcon = (ImageView) this.base.findViewById(C0116R.id.video_detail_play);
                }
                return this.playIcon;
            }

            public ImageView getThumb() {
                if (this.thumb == null) {
                    this.thumb = (ImageView) this.base.findViewById(C0116R.id.video_detail_thumb);
                }
                return this.thumb;
            }

            public TextView getTitle() {
                if (this.title == null) {
                    this.title = (TextView) this.base.findViewById(C0116R.id.video_detail_title);
                }
                return this.title;
            }
        }

        SearchAdapter() {
        }

        public int getCount() {
            int incriment = 0;
            if (SearchView.this.searchText.getText().length() == 0) {
                return 0;
            }
            if (SearchView.this.albumCursor.isClosed() || SearchView.this.songCursor.isClosed() || SearchView.this.artistCursor.isClosed() || SearchView.this.podcastCursor.isClosed() || SearchView.this.playlistCursor.isClosed()) {
                return 0;
            }
            if (SearchView.this.albumCursor.getCount() > 0) {
                incriment = 0 + 1;
            }
            if (SearchView.this.songCursor.getCount() > 0) {
                incriment++;
            }
            if (SearchView.this.artistCursor.getCount() > 0) {
                incriment++;
            }
            if (SearchView.this.videoCursor.getCount() > 0) {
                incriment++;
            }
            if (SearchView.this.podcastCursor.getCount() > 0) {
                incriment++;
            }
            if (SearchView.this.playlistCursor.getCount() > 0) {
                incriment++;
            }
            int count = (((((SearchView.this.albumCursor.getCount() + SearchView.this.songCursor.getCount()) + SearchView.this.artistCursor.getCount()) + SearchView.this.videoCursor.getCount()) + SearchView.this.playlistCursor.getCount()) + SearchView.this.podcastCursor.getCount()) + incriment;
            if (count > 0) {
                SearchView.this.frontPanel.setClickable(false);
                return count;
            }
            SearchView.this.frontPanel.setClickable(true);
            return count;
        }

        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getView(position, convertView);
            int count = getCountAll();
            if (position == 0 && count > 0 && count <= 4) {
                SearchView.this.hideSoftInputDelayed();
            }
            return convertView;
        }

        public int getCountAll() {
            return ((SearchView.this.songCursor.getCount() + SearchView.this.albumCursor.getCount()) + SearchView.this.artistCursor.getCount()) + SearchView.this.playlistCursor.getCount();
        }

        public void onClick(View aView) {
            WrapperCommon wrapper = (WrapperCommon) aView.getTag();
            if (wrapper != null) {
                Analytics.getAnalytics().track(Analytics.EVENT_SEARCH_VIEW_SEARCH);
                Intent i;
                SongWrapper songWrapper;
                ImageView playIcon;
                ArrayList<PlayableItem> playableList;
                switch (wrapper.viewID) {
                    case 1:
                        i = new Intent(SearchView.this.mActivity, ContentBrowser.class);
                        i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_ALBUM_DETAILS);
                        i.putExtra(Constants.EXTRA_ALBUM_KEY, (String) ((AlbumWrapper) aView.getTag()).playIcon.getTag());
                        SearchView.this.mActivity.startActivity(i);
                        return;
                    case 2:
                        songWrapper = (SongWrapper) aView.getTag();
                        playIcon = songWrapper.getPlayIcon();
                        try {
                            if (!songWrapper.isPlaying()) {
                                playableList = new ArrayList();
                                playableList.add((PlayableItem) playIcon.getTag());
                                SearchView.this.mService.setCurrentList(Constants.TOP_MENU_SONGS, "");
                                SearchView.this.mService.setPlayableList(playableList, 0);
                                return;
                            } else if (songWrapper.isPlaying() && SearchView.this.mService.isPaused()) {
                                SearchView.this.mService.play();
                                return;
                            } else {
                                return;
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                            return;
                        }
                    case 3:
                        i = new Intent(SearchView.this.mActivity, ContentBrowser.class);
                        i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_ARTIST_DETAILS);
                        i.putExtra(Constants.EXTRA_ARTIST_KEY, (String) ((ArtistWrapper) aView.getTag()).playIcon.getTag());
                        SearchView.this.mActivity.startActivity(i);
                        return;
                    case 4:
                        PlaylistWrapper playlistWrapper = (PlaylistWrapper) aView.getTag();
                        i = new Intent(SearchView.this.mActivity, ContentBrowser.class);
                        i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_PLAYLIST_DETAILS);
                        String[] playlistTokens = ((String) playlistWrapper.getPlayIcon().getTag()).split(":");
                        if (playlistTokens.length == 2) {
                            i.putExtra(Constants.EXTRA_PLAYLIST_ID, Integer.parseInt(playlistTokens[0]));
                            i.putExtra(Constants.EXTRA_PLAYLIST_VOLUME, playlistTokens[1]);
                            SearchView.this.mActivity.startActivity(i);
                            return;
                        }
                        return;
                    case 6:
                        VideoWrapper videoWrapper = (VideoWrapper) aView.getTag();
                        i = new Intent(SearchView.this.mActivity, ViewVideo.class);
                        Log.i("SongbirdSearchView", "Grabbing ID");
                        Integer curId = (Integer) videoWrapper.getPlayIcon().getTag();
                        Log.i("SongbirdSearchView", "ID " + curId);
                        i.putExtra("videofilename", curId);
                        i.putExtra("idList", new int[]{curId.intValue()});
                        try {
                            SearchView.this.mService.pause();
                        } catch (RemoteException e2) {
                        }
                        SearchView.this.mActivity.startActivity(i);
                        return;
                    case 7:
                        songWrapper = (SongWrapper) aView.getTag();
                        playIcon = songWrapper.getPlayIcon();
                        try {
                            if (!songWrapper.isPlaying()) {
                                playableList = new ArrayList();
                                playableList.add((PlayableItem) playIcon.getTag());
                                SearchView.this.mService.setCurrentList(Constants.TOP_MENU_PODCASTS, "");
                                SearchView.this.mService.setPlayableList(playableList, 0);
                                return;
                            } else if (songWrapper.isPlaying() && SearchView.this.mService.isPaused()) {
                                SearchView.this.mService.play();
                                return;
                            } else {
                                return;
                            }
                        } catch (RemoteException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            }
        }

        private View getHeaderView(int position) {
            View view = SearchView.this.inflater.inflate(C0116R.layout.search_header_item, null);
            TextView viewText = (TextView) view.findViewById(C0116R.id.search_header_item_text);
            Resources res = SearchView.this.mActivity.getResources();
            int videoCursorCount = SearchView.this.videoCursor.getCount();
            int podcastCursorCount = SearchView.this.podcastCursor.getCount();
            int songCursorCount = SearchView.this.songCursor.getCount();
            int albumCursorCount = SearchView.this.albumCursor.getCount();
            int artistCursorCount = SearchView.this.artistCursor.getCount();
            if ((((((position - videoCursorCount) - podcastCursorCount) - songCursorCount) - albumCursorCount) - artistCursorCount) - getIncriments(4) == 0) {
                viewText.setText(res.getString(C0116R.string.playlist_header));
                return view;
            } else if (((((position - podcastCursorCount) - songCursorCount) - albumCursorCount) - artistCursorCount) - getIncriments(6) == 0) {
                viewText.setText(res.getString(C0116R.string.video_header));
                return view;
            } else if ((((position - songCursorCount) - albumCursorCount) - artistCursorCount) - getIncriments(7) == 0) {
                viewText.setText(res.getString(C0116R.string.podcasts_header));
                return view;
            } else if (((position - albumCursorCount) - artistCursorCount) - getIncriments(2) == 0) {
                viewText.setText(res.getString(C0116R.string.songs_header));
                return view;
            } else if ((position - artistCursorCount) - getIncriments(1) == 0) {
                viewText.setText(res.getString(C0116R.string.album_header));
                return view;
            } else if (position != 0 || artistCursorCount <= 0) {
                return null;
            } else {
                viewText.setText(res.getString(C0116R.string.artist_header));
                return view;
            }
        }

        private View getIconView(int position) {
            View textView = new TextView(SearchView.this.mActivity);
            textView.setText(Integer.toString(position));
            int videoCursorCount = SearchView.this.videoCursor.getCount();
            int podcastCursorCount = SearchView.this.podcastCursor.getCount();
            int songCursorCount = SearchView.this.songCursor.getCount();
            int albumCursorCount = SearchView.this.albumCursor.getCount();
            int artistCursorCount = SearchView.this.artistCursor.getCount();
            View view;
            if ((((((position - videoCursorCount) - podcastCursorCount) - songCursorCount) - albumCursorCount) - artistCursorCount) - getIncriments(6) > 0) {
                SearchView.this.playlistCursor.moveToPosition((((((position - podcastCursorCount) - songCursorCount) - albumCursorCount) - artistCursorCount) - getIncriments(4)) - 1);
                view = SearchView.this.inflater.inflate(C0116R.layout.playlist_item, null);
                view.setTag(new PlaylistWrapper(view, 4));
                populatePlaylist((PlaylistWrapper) view.getTag(), SearchView.this.playlistCursor);
                return view;
            } else if (((((position - songCursorCount) - albumCursorCount) - artistCursorCount) - podcastCursorCount) - getIncriments(7) > 0) {
                SearchView.this.videoCursor.moveToPosition((((((position - songCursorCount) - albumCursorCount) - artistCursorCount) - podcastCursorCount) - getIncriments(6)) - 1);
                view = SearchView.this.inflater.inflate(C0116R.layout.video_detail, null);
                view.setTag(new VideoWrapper(view, 6));
                view.setClickable(true);
                view.setLongClickable(true);
                view.setOnClickListener(this);
                populateVideoViewInfo((VideoWrapper) view.getTag(), SearchView.this.videoCursor);
                return view;
            } else if ((((position - albumCursorCount) - artistCursorCount) - songCursorCount) - getIncriments(2) > 0) {
                cursorPosition = ((((position - songCursorCount) - albumCursorCount) - artistCursorCount) - getIncriments(7)) - 1;
                SearchView.this.podcastCursor.moveToPosition(cursorPosition);
                view = SearchView.this.inflater.inflate(C0116R.layout.song_detail_item, null);
                view.setTag(new PodcastWrapper(view, 7, cursorPosition));
                populateSong((PodcastWrapper) view.getTag(), SearchView.this.podcastCursor, Constants.TOP_MENU_PODCASTS);
                return view;
            } else if (((position - albumCursorCount) - artistCursorCount) - getIncriments(1) > 0) {
                cursorPosition = (((position - albumCursorCount) - artistCursorCount) - getIncriments(2)) - 1;
                SearchView.this.songCursor.moveToPosition(cursorPosition);
                view = SearchView.this.inflater.inflate(C0116R.layout.song_detail_item, null);
                view.setTag(new SongWrapper(view, 2, cursorPosition));
                populateSong((SongWrapper) view.getTag(), SearchView.this.songCursor, Constants.TOP_MENU_SONGS);
                return view;
            } else if ((position - artistCursorCount) - getIncriments(3) > 0) {
                cursorPosition = ((position - artistCursorCount) - getIncriments(1)) - 1;
                SearchView.this.albumCursor.moveToPosition(cursorPosition);
                view = SearchView.this.inflater.inflate(C0116R.layout.album_item, null);
                view.setTag(new AlbumWrapper(view, 1, cursorPosition));
                populateAlbum((AlbumWrapper) view.getTag(), SearchView.this.albumCursor);
                return view;
            } else if (position <= 0 || artistCursorCount <= 0) {
                return textView;
            } else {
                cursorPosition = (position - getIncriments(3)) - 1;
                SearchView.this.artistCursor.moveToPosition(cursorPosition);
                view = SearchView.this.inflater.inflate(C0116R.layout.artist_item, null);
                view.setTag(new ArtistWrapper(view, 3, cursorPosition));
                populateArtist((ArtistWrapper) view.getTag(), SearchView.this.artistCursor);
                return view;
            }
        }

        private int getIncriments(int targetID) {
            int i = 1;
            if (targetID == 3) {
                return 0;
            }
            if (targetID == 1) {
                if (SearchView.this.artistCursor.getCount() <= 0) {
                    i = 0;
                }
                return i;
            } else if (targetID == 2) {
                r2 = SearchView.this.albumCursor.getCount() > 0 ? 1 : 0;
                if (SearchView.this.artistCursor.getCount() <= 0) {
                    i = 0;
                }
                return r2 + i;
            } else if (targetID == 7) {
                r2 = (SearchView.this.albumCursor.getCount() > 0 ? 1 : 0) + (SearchView.this.songCursor.getCount() > 0 ? 1 : 0);
                if (SearchView.this.artistCursor.getCount() <= 0) {
                    i = 0;
                }
                return r2 + i;
            } else if (targetID == 6) {
                r2 = (SearchView.this.artistCursor.getCount() > 0 ? 1 : 0) + ((SearchView.this.songCursor.getCount() > 0 ? 1 : 0) + (SearchView.this.albumCursor.getCount() > 0 ? 1 : 0));
                if (SearchView.this.podcastCursor.getCount() <= 0) {
                    i = 0;
                }
                return r2 + i;
            } else if (targetID == 4) {
                r2 = (SearchView.this.artistCursor.getCount() > 0 ? 1 : 0) + (((SearchView.this.albumCursor.getCount() > 0 ? 1 : 0) + (SearchView.this.videoCursor.getCount() > 0 ? 1 : 0)) + (SearchView.this.songCursor.getCount() > 0 ? 1 : 0));
                if (SearchView.this.podcastCursor.getCount() <= 0) {
                    i = 0;
                }
                return r2 + i;
            } else {
                Log.i("SearchView", "Increments returned 0");
                return 0;
            }
        }

        private int getSongCount(int playlistId) {
            Cursor countCursor = MediaUtils.getMediaStoreMergeCursorForPlaylist(SearchView.this.mActivity, new String[]{"COUNT(*)"}, null, null, null, (long) playlistId, false);
            int songCount = 0;
            if (countCursor.moveToFirst()) {
                songCount = countCursor.getInt(0);
            }
            countCursor.close();
            return songCount;
        }

        private View getView(int position, View inView) {
            if (isBaseHeaderCase(position)) {
                return getHeaderView(position);
            }
            return getIconView(position);
        }

        private boolean isBaseHeaderCase(int position) {
            if ((((((position - SearchView.this.videoCursor.getCount()) - SearchView.this.songCursor.getCount()) - SearchView.this.albumCursor.getCount()) - SearchView.this.artistCursor.getCount()) - SearchView.this.podcastCursor.getCount()) - getIncriments(4) == 0 || ((((position - SearchView.this.songCursor.getCount()) - SearchView.this.albumCursor.getCount()) - SearchView.this.artistCursor.getCount()) - SearchView.this.podcastCursor.getCount()) - getIncriments(6) == 0 || (((position - SearchView.this.songCursor.getCount()) - SearchView.this.albumCursor.getCount()) - SearchView.this.artistCursor.getCount()) - getIncriments(7) == 0 || ((position - SearchView.this.albumCursor.getCount()) - SearchView.this.artistCursor.getCount()) - getIncriments(2) == 0 || (position - SearchView.this.artistCursor.getCount()) - getIncriments(1) == 0) {
                return true;
            }
            if (position != 0 || SearchView.this.artistCursor.getCount() <= 0) {
                return false;
            }
            return true;
        }

        private void playPlaylistSongs(Long playlistId, String playlistVolume) {
            Cursor songCursor = MediaUtils.getMediaStoreMergeCursorForPlaylist(SearchView.this.mActivity, new String[]{"_id", "audio_id", "play_order"}, null, null, "play_order ASC", playlistId.longValue(), false);
            List<PlayableItem> playableList = Utils.createPlayableListFromCursor(songCursor);
            try {
                SearchView.this.mService.setCurrentList(Constants.TOP_MENU_PLAYLISTS, playlistId + ":" + playlistVolume);
                SearchView.this.mService.setPlayableList(playableList, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            songCursor.close();
        }

        private void populateAlbum(AlbumWrapper wrapper, Cursor cursor) {
            wrapper.getAlbumLabel().setText(cursor.getString(cursor.getColumnIndexOrThrow("album")));
            wrapper.getArtistLabel().setText(cursor.getString(cursor.getColumnIndexOrThrow("artist")));
            int numberSongs = cursor.getInt(cursor.getColumnIndexOrThrow("numsongs"));
            Resources res = SearchView.this.mActivity.getResources();
            wrapper.getSongTotalLabel().setText(res.getQuantityString(C0116R.plurals.album_song_count, numberSongs, new Object[]{Integer.valueOf(numberSongs)}));
            final String albumKey = cursor.getString(cursor.getColumnIndexOrThrow("album_key"));
            wrapper.setAlbumKey(albumKey);
            int column = cursor.getColumnIndexOrThrow("album_art");
            if (cursor.getString(column) != null) {
                Bitmap albumArtBitmap = BitmapFactory.decodeFile(cursor.getString(column));
                if (albumArtBitmap == null) {
                    setDefaultAlbumArt(wrapper);
                } else {
                    wrapper.getAlbumArt().setImageBitmap(Bitmap.createScaledBitmap(albumArtBitmap, SearchView.this.rowHeight, SearchView.this.rowHeight, true));
                    albumArtBitmap.recycle();
                }
            } else {
                setDefaultAlbumArt(wrapper);
            }
            if (albumKey.equals(SearchView.this.currentToken)) {
                wrapper.getPlayIcon().setPlaying(true);
            } else {
                wrapper.getPlayIcon().setPlaying(false);
            }
            wrapper.getPlayIcon().setTag(albumKey);
            wrapper.getPlayIcon().setOnClickListener(new OnClickListener() {
                Cursor songCursor;

                public void onClick(View v) {
                    if (!albumKey.equals(SearchView.this.currentToken)) {
                        this.songCursor = MediaUtils.getMediaStoreMergeCursor(SearchView.this.mActivity, new String[]{"_id", Analytics.TRACK_KEY}, "album_key= ?", new String[]{(String) v.getTag()}, "track ASC");
                        List<PlayableItem> playableList = Utils.createPlayableListFromCursor(this.songCursor);
                        try {
                            SearchView.this.mService.setCurrentList(Constants.TOP_MENU_ALBUMS, (String) v.getTag());
                            SearchView.this.mService.setPlayableList(playableList, 0);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        this.songCursor.close();
                    }
                }
            });
        }

        private void populateVideoViewInfo(VideoWrapper wrapper, Cursor cursor) {
            wrapper.getTitle().setText(cursor.getString(cursor.getColumnIndexOrThrow("title")));
            wrapper.getDuration().setText(Utils.calculateTimeStamp(cursor.getInt(cursor.getColumnIndexOrThrow("duration"))));
            Bitmap thumbCursor = Thumbnails.getThumbnail(SearchView.this.mActivity.getContentResolver(), (long) cursor.getInt(cursor.getColumnIndex("_id")), 1, null);
            if (thumbCursor == null) {
                thumbCursor = BitmapFactory.decodeResource(LayoutInflater.from(SearchView.this.mActivity).getContext().getResources(), C0116R.drawable.generic_album_small);
            }
            wrapper.getThumb().setImageBitmap(Bitmap.createScaledBitmap(thumbCursor, 50, 50, true));
            Integer id = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
            Log.i("VideoListingView", "Video Id + " + id);
            wrapper.getPlayIcon().setTag(id);
            wrapper.getPlayIcon().setOnClickListener(new C03892());
        }

        private void populateArtist(ArtistWrapper wrapper, Cursor cursor) {
            wrapper.getArtistLabel().setText(cursor.getString(cursor.getColumnIndexOrThrow("artist")));
            int songCount = cursor.getInt(cursor.getColumnIndexOrThrow("number_of_tracks"));
            int albumCount = cursor.getInt(cursor.getColumnIndexOrThrow("number_of_albums"));
            Resources res = SearchView.this.mActivity.getResources();
            String songTotalText = res.getQuantityString(C0116R.plurals.album_song_count, songCount, new Object[]{Integer.valueOf(songCount)});
            wrapper.getTotalLabel().setText(songTotalText + ", " + res.getQuantityString(C0116R.plurals.album_count, albumCount, new Object[]{Integer.valueOf(albumCount)}));
            final String artistKey = cursor.getString(cursor.getColumnIndexOrThrow("artist_key"));
            wrapper.setArtistKey(artistKey);
            if (artistKey.equals(SearchView.this.currentToken)) {
                wrapper.getPlayIcon().setPlaying(true);
            } else {
                wrapper.getPlayIcon().setPlaying(false);
            }
            wrapper.getPlayIcon().setTag(artistKey);
            wrapper.getPlayIcon().setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!artistKey.equals(SearchView.this.currentToken)) {
                        Cursor songCursor = MediaUtils.getMediaStoreMergeCursor(SearchView.this.mActivity, new String[]{"_id", "title"}, "artist_key = ?", new String[]{(String) v.getTag()}, "title ASC");
                        List<PlayableItem> playableList = Utils.createPlayableListFromCursor(songCursor);
                        try {
                            SearchView.this.mService.setCurrentList(Constants.TOP_MENU_ARTISTS, (String) v.getTag());
                            SearchView.this.mService.setPlayableList(playableList, 0);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        songCursor.close();
                    }
                }
            });
        }

        private void populatePlaylist(PlaylistWrapper wrapper, Cursor cursor) {
            wrapper.getPlaylistName().setText(cursor.getString(cursor.getColumnIndexOrThrow(CookieTable.NAME)));
            int column = cursor.getColumnIndexOrThrow("_id");
            final Long playlistId = Long.valueOf(cursor.getLong(column));
            final String playlistVolume = Utils.getVolumeFromCursor(cursor);
            final String playlistToken = playlistId + ":" + playlistVolume;
            Resources res = SearchView.this.mActivity.getResources();
            int songCount = getSongCount(cursor.getInt(column));
            wrapper.getPlaylistTotal().setText(res.getQuantityString(C0116R.plurals.album_song_count, songCount, new Object[]{Integer.valueOf(songCount)}));
            if (playlistToken.equals(SearchView.this.currentToken)) {
                wrapper.getPlayIcon().setPlaying(true);
            } else {
                wrapper.getPlayIcon().setPlaying(false);
            }
            wrapper.getPlayIcon().setTag(playlistToken);
            wrapper.getPlayIcon().setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!playlistToken.equals(SearchView.this.currentToken)) {
                        SearchAdapter.this.playPlaylistSongs(playlistId, playlistVolume);
                    }
                }
            });
        }

        private void populateSong(SongWrapper wrapper, Cursor cursor, final String currentList) {
            wrapper.getSongName().setText(cursor.getString(cursor.getColumnIndex("title")));
            wrapper.getDuration().setText(Utils.calculateTimeStamp(cursor.getInt(cursor.getColumnIndex("duration"))));
            wrapper.getArtistName().setText(cursor.getString(cursor.getColumnIndex("artist")));
            wrapper.getAlbumName().setText(cursor.getString(cursor.getColumnIndex("album")));
            PlayableItem item = Utils.createPlayableItemFromCursor(cursor);
            if (item.mID == SearchView.this.currentSong.intValue()) {
                wrapper.getPlayIcon().setImageResource(C0116R.drawable.row_listening_button);
                wrapper.setPlaying(true);
            } else {
                wrapper.getPlayIcon().setImageResource(C0116R.drawable.row_play);
                wrapper.setPlaying(false);
            }
            wrapper.getPlayIcon().setTag(item);
            wrapper.getPlayIcon().setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    try {
                        PlayableItem item = (PlayableItem) v.getTag();
                        if (item.mID != SearchView.this.currentSong.intValue()) {
                            ArrayList<PlayableItem> playableList = new ArrayList();
                            playableList.add(item);
                            SearchView.this.mService.setCurrentList(currentList, "-1");
                            SearchView.this.mService.setPlayableList(playableList, 0);
                        } else if (item.mID == SearchView.this.currentSong.intValue() && SearchView.this.mService.isPaused()) {
                            SearchView.this.mService.play();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        private void setDefaultAlbumArt(AlbumWrapper wrapper) {
            Bitmap albumArtBitmap = BitmapFactory.decodeResource(SearchView.this.mActivity.getResources(), C0116R.drawable.generic_album_small);
            wrapper.getAlbumArt().setImageBitmap(Bitmap.createScaledBitmap(albumArtBitmap, SearchView.this.rowHeight, SearchView.this.rowHeight, true));
            albumArtBitmap.recycle();
        }
    }

    public void onMediaServiceEvent(int aEvent) {
        switch (aEvent) {
            case 4:
                try {
                    this.currentToken = this.mService.getCurrentListToken();
                    this.currentSong = Integer.valueOf(this.mService.getCurrentSongToken());
                } catch (RemoteException e) {
                }
                this.adapter.notifyDataSetChanged();
                return;
            default:
                super.onMediaServiceEvent(aEvent);
                return;
        }
    }

    public void onResume() {
        super.onResume();
        getHeaderView().post(new C03791());
        reFocus();
        this.searchText.clearShow();
    }

    public void onPause() {
        super.onPause();
        if (!this.mActivity.isFinishing()) {
            getHeaderView().setVisibility(0);
        }
        hideSoftInput();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.albumCursor != null) {
            this.albumCursor.close();
        }
        if (this.artistCursor != null) {
            this.artistCursor.close();
        }
        if (this.playlistCursor != null) {
            this.playlistCursor.close();
        }
        if (this.songCursor != null) {
            this.songCursor.close();
        }
    }

    private void buildContextMenuForPodcast(ContextMenu aMenu, WrapperCommon aWrapper) {
        this.podcastCursor.moveToPosition(((PodcastWrapper) aWrapper).getCursorPos());
        String songTitle = this.podcastCursor.getString(this.podcastCursor.getColumnIndex("title"));
        aMenu.setHeaderTitle(songTitle);
        ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, this.podcastCursor.getInt(this.podcastCursor.getColumnIndex("_id")), Utils.getVolumeFromCursor(this.podcastCursor), songTitle, true);
    }

    private void buildContextMenuForAlbum(ContextMenu aMenu, WrapperCommon aWrapper) {
        this.albumCursor.moveToPosition(((AlbumWrapper) aWrapper).getCursorPos());
        String albumTitle = this.albumCursor.getString(this.albumCursor.getColumnIndex("album"));
        aMenu.setHeaderTitle(albumTitle);
        ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, MediaUtils.getMediaStoreMergeCursor(this.mActivity, new String[]{"_id", "title", Analytics.TRACK_KEY}, "album_key= ?", new String[]{albumWrapper.getAlbumKey()}, "track ASC"), albumTitle, true);
    }

    private void buildContextMenuForSong(ContextMenu aMenu, WrapperCommon aWrapper) {
        this.songCursor.moveToPosition(((SongWrapper) aWrapper).getCursorPos());
        final String songTitle = this.songCursor.getString(this.songCursor.getColumnIndex("title"));
        aMenu.setHeaderTitle(songTitle);
        final int itemId = this.songCursor.getInt(this.songCursor.getColumnIndex("_id"));
        final String itemVolume = Utils.getVolumeFromCursor(this.songCursor);
        ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, itemId, itemVolume, songTitle, true);
        if (Utils.hasPhone(this.mActivity)) {
            aMenu.add(C0116R.string.playlist_listing_menu_set_ringtone).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem item) {
                    Utils.setItemAsRingtone(SearchView.this.mActivity, itemId, itemVolume);
                    Utils.showShortToast(SearchView.this.mActivity, SearchView.this.mActivity.getString(C0116R.string.playlist_set_ringtone_message, new Object[]{songTitle}));
                    return true;
                }
            });
        }
    }

    private void buildContextMenuForArtist(ContextMenu aMenu, WrapperCommon aWrapper) {
        this.artistCursor.moveToPosition(((ArtistWrapper) aWrapper).getCursorPos());
        String artistName = this.artistCursor.getString(this.artistCursor.getColumnIndex("artist"));
        aMenu.setHeaderTitle(artistName);
        ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, MediaUtils.getMediaStoreMergeCursor(this.mActivity, new String[]{"_id", "title"}, "artist_key = ?", new String[]{artistWrapper.getArtistKey()}, "title ASC"), artistName, true);
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.searchList == aView) {
            WrapperCommon wrapperCommon = (WrapperCommon) ((AdapterContextMenuInfo) aMenuInfo).targetView.getTag();
            if (wrapperCommon != null) {
                switch (wrapperCommon.getViewID()) {
                    case 1:
                        buildContextMenuForAlbum(aMenu, wrapperCommon);
                        return;
                    case 2:
                        buildContextMenuForSong(aMenu, wrapperCommon);
                        return;
                    case 3:
                        buildContextMenuForArtist(aMenu, wrapperCommon);
                        return;
                    case 7:
                        buildContextMenuForPodcast(aMenu, wrapperCommon);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void reFocus() {
        this.searchText.clearFocus();
        this.imm.showSoftInput(this.searchText, 0);
        this.searchText.requestFocus();
    }

    public SearchView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey("Search");
        setViewCategory("search");
        this.searchText = (ScreenKeyboardCaller) this.mView.findViewById(C0116R.id.search_edit_text);
        this.adapter = new SearchAdapter();
        this.inflater = LayoutInflater.from(this.mActivity);
        this.searchList = (ListWatch) this.mView.findViewById(C0116R.id.search_list_watch);
        this.xImage = (ImageView) this.mView.findViewById(C0116R.id.search_clean_icon);
        this.frontPanel = this.mView.findViewById(C0116R.id.search_list_panel);
        this.searchText.setHandler(this.tempHandler);
        this.xImage.setOnClickListener(new C03824());
        this.frontPanel.setOnClickListener(new C03835());
        this.searchText.setOnEditorActionListener(new C03846());
        this.footer = this.inflater.inflate(C0116R.layout.list_footer_view, null);
        this.searchList.addFooterView(this.footer);
        this.searchList.setAdapter(this.adapter);
        this.searchList.removeFooterView(this.footer);
        this.searchText.addTextChangedListener(new C03857());
        this.searchList.setOnScrollListener(new C03868());
        setupCursors();
        this.searchList.setOnItemClickListener(new C03879());
        setContextMenuView(this.searchList);
        this.imm = (InputMethodManager) this.mActivity.getSystemService("input_method");
        setViewAnalyticsUri(Analytics.EVENT_SEARCH);
    }

    private void registerContentObservers() {
        Log.e("ContentObserver", "Search: register");
        registerContentObserver(this.songCursor, this.adapter, this.searchList, getClass().getName() + "-Song", 100);
        registerContentObserver(this.albumCursor, this.adapter, this.searchList, getClass().getName() + "-Album", 500);
        registerContentObserver(this.artistCursor, this.adapter, this.searchList, getClass().getName() + "-Artist", 100);
        registerContentObserver(this.podcastCursor, this.adapter, this.searchList, getClass().getName() + "-Podcast", 100);
        registerContentObserver(this.playlistCursor, this.adapter, this.searchList, getClass().getName() + "-Playlist", 100);
    }

    private void unregisterContentObservers() {
        Log.e("ContentObserver", "Search: unregister");
        unregisterContentObserver(this.songCursor, getClass().getName() + "-Song");
        unregisterContentObserver(this.albumCursor, getClass().getName() + "-Album");
        unregisterContentObserver(this.artistCursor, getClass().getName() + "-Artist");
        unregisterContentObserver(this.podcastCursor, getClass().getName() + "-Podcast");
        unregisterContentObserver(this.playlistCursor, getClass().getName() + "-Playlist");
    }

    private void hideSoftInputDelayed() {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(500);
                    SearchView.this.hideSoftInput();
                } catch (InterruptedException e) {
                }
            }
        }.start();
    }

    private void hideSoftInput() {
        this.imm.hideSoftInputFromWindow(this.searchText.getWindowToken(), 0);
    }

    private void setupCursors() {
        unregisterContentObservers();
        String[] albumProj = new String[]{"_id", "album_key", "album", "artist", "numsongs", "album_art"};
        String[] trackProj = new String[]{"_id", "title", "duration", "artist", "album", "title_key"};
        String[] artistProj = new String[]{"_id", "artist", "artist_key", "number_of_tracks", "number_of_albums"};
        String[] playlistProj = new String[]{CookieTable.NAME, "_id"};
        String[] videoProj = new String[]{"_id", "title", "duration", "_data"};
        String[] podcastProj = new String[]{"_id", "title", "duration", "artist", "album", "title_key"};
        String[] args = new String[]{"%" + this.searchText.getText().toString() + "%"};
        if (!(this.albumCursor == null || this.albumCursor.isClosed())) {
            this.albumCursor.close();
        }
        this.albumCursor = MediaUtils.getMediaStoreMergeCursorForAlbum(this.mActivity, albumProj, "album LIKE ?", args, "album_key ASC");
        if (!(this.songCursor == null || this.songCursor.isClosed())) {
            this.songCursor.close();
        }
        this.songCursor = MediaUtils.getMediaStoreMergeCursor(this.mActivity, trackProj, Song.getSearchSelection(), Song.getSearchArgs(this.searchText.getText().toString()), "title_key ASC");
        if (!(this.artistCursor == null || this.artistCursor.isClosed())) {
            this.artistCursor.close();
        }
        this.artistCursor = MediaUtils.getMediaStoreMergeCursorForArtist(this.mActivity, artistProj, "artist LIKE ?", args, "artist_key ASC", false);
        if (!(this.videoCursor == null || this.videoCursor.isClosed())) {
            this.videoCursor.close();
        }
        this.videoCursor = MediaUtils.getMediaStoreMergeCursorForVideo(this.mActivity, videoProj, "title LIKE ?", args, false);
        Log.i("SearchView", "Video Cursor Size: " + this.videoCursor.getCount());
        if (!(this.podcastCursor == null || this.podcastCursor.isClosed())) {
            this.podcastCursor.close();
        }
        this.podcastCursor = MediaUtils.getMediaStoreMergeCursor(this.mActivity, podcastProj, Podcast.getSearchSelection(), Podcast.getSearchArgs(this.searchText.getText().toString()), "title_key ASC");
        if (!(this.playlistCursor == null || this.playlistCursor.isClosed())) {
            this.playlistCursor.close();
        }
        this.playlistCursor = MediaUtils.getMediaStoreMergeCursorForPlaylist(this.mActivity, playlistProj, "name LIKE ?", args, "name ASC", false);
        registerContentObservers();
    }
}
