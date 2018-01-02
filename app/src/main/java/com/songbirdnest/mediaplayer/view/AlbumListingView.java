package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.widget.SimpleCursorAdapter;
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
import android.widget.AlphabetIndexer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.ContextMenuUtils;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;
import com.songbirdnest.util.MediaUtils;

public class AlbumListingView extends BaseContentBrowserView {
    private static final String VIEW_CATEGORY = "music:albums";
    private AlbumListAdapter mAdapter;
    private String mCurrentActivity;
    private String mCurrentToken;
    private Cursor mCursor;
    private Handler mHandler = new C02121();
    private LayoutInflater mInflater;
    private boolean mInitialized = false;
    private ListView mListView;
    private View mListViewFooter;

    class C02121 extends Handler {
        C02121() {
        }

        public void handleMessage(Message msg) {
            ((ViewWrapper) msg.obj).tryClear();
        }
    }

    class C02132 implements OnScrollListener {
        C02132() {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            AlbumListingView.this.setScrollState(scrollState);
            if (AlbumListingView.this.isViewStopped() && AlbumListingView.this.isScrollIdle()) {
                AlbumListingView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (AlbumListingView.this.mListView.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    AlbumListingView.this.mListView.removeFooterView(AlbumListingView.this.mListViewFooter);
                } else if (AlbumListingView.this.mListView.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    AlbumListingView.this.mListView.addFooterView(AlbumListingView.this.mListViewFooter);
                }
            }
        }
    }

    class C02143 implements OnItemClickListener {
        C02143() {
        }

        public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
            AlbumListingView.this.mCursor.moveToPosition(position);
            Intent i = new Intent(AlbumListingView.this.mActivity, ContentBrowser.class);
            i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_ALBUM_DETAILS);
            i.putExtra(Constants.EXTRA_ALBUM_KEY, AlbumListingView.this.mCursor.getString(AlbumListingView.this.mCursor.getColumnIndexOrThrow("album_key")));
            AlbumListingView.this.mActivity.startActivity(i);
        }
    }

    class C02154 implements Runnable {
        C02154() {
        }

        public void run() {
            AlbumListingView.this.closeCursors();
        }
    }

    class AlbumListAdapter extends SimpleCursorAdapter implements SectionIndexer {
        private AlphabetIndexer mAlphaIndexer = new AlphabetIndexer(this.mCursor, this.mCursor.getColumnIndex("album"), " ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        private Resources mResources;
        private int mRowHeight = 50;

        class ViewWrapper {
            private ImageView mAlbumArt = null;
            private String mAlbumKey;
            private TextView mAlbumLabel = null;
            private TextView mArtistLabel = null;
            private PlayIcon mPlayIcon = null;
            private TextView mSongTotalLabel = null;
            private View mView;

            public ViewWrapper(View aView) {
                this.mView = aView;
            }

            public ImageView getAlbumArt() {
                if (this.mAlbumArt == null) {
                    this.mAlbumArt = (ImageView) this.mView.findViewById(C0116R.id.album_item_album_art);
                }
                return this.mAlbumArt;
            }

            public String getAlbumKey() {
                return this.mAlbumKey;
            }

            public TextView getAlbumLabel() {
                if (this.mAlbumLabel == null) {
                    this.mAlbumLabel = (TextView) this.mView.findViewById(C0116R.id.album_item_album_text);
                }
                return this.mAlbumLabel;
            }

            public TextView getArtistLabel() {
                if (this.mArtistLabel == null) {
                    this.mArtistLabel = (TextView) this.mView.findViewById(C0116R.id.album_item_artist_text);
                }
                return this.mArtistLabel;
            }

            public PlayIcon getPlayIcon() {
                if (this.mPlayIcon == null) {
                    this.mPlayIcon = (PlayIcon) this.mView.findViewById(C0116R.id.album_item_play_icon);
                }
                return this.mPlayIcon;
            }

            public TextView getSongTotalLabel() {
                if (this.mSongTotalLabel == null) {
                    this.mSongTotalLabel = (TextView) this.mView.findViewById(C0116R.id.album_item_song_total);
                }
                return this.mSongTotalLabel;
            }

            public void setAlbumKey(String aAlbumKey) {
                this.mAlbumKey = aAlbumKey;
            }

            public void setVisible(int inSetting) {
                this.mView.setVisibility(inSetting);
            }

            public void tryClear() {
                if (getPlayIcon().getHeight() > 0) {
                    AlbumListAdapter.this.mRowHeight = Utils.calculateAlbumArt(getPlayIcon().getHeight());
                    setVisible(0);
                    return;
                }
                setVisible(4);
                Message msg = new Message();
                msg.obj = this;
                AlbumListingView.this.mHandler.sendMessageDelayed(msg, 100);
            }
        }

        public AlbumListAdapter(Context aContext, int aLayout, Cursor aCursor, String[] aFrom, int[] aTo) {
            super(aContext, aLayout, aCursor, aFrom, aTo, 0);
            this.mResources = aContext.getResources();
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
            View row = convertView;
            this.mCursor.moveToPosition(position);
            if (row == null || row.getTag().getClass() != ViewWrapper.class) {
                row = AlbumListingView.this.mInflater.inflate(C0116R.layout.album_item, null);
                wrapper = new ViewWrapper(row);
                row.setTag(wrapper);
            } else {
                wrapper = (ViewWrapper) row.getTag();
            }
            populateAlbumViewInfo(row, wrapper);
            return row;
        }

        public Cursor swapCursor(Cursor aCursor) {
            this.mAlphaIndexer.setCursor(aCursor);
            return super.swapCursor(aCursor);
        }

        private boolean albumPlaying(String albumKey) {
            return Constants.TOP_MENU_ALBUMS.equals(AlbumListingView.this.mCurrentActivity) && albumKey.equals(AlbumListingView.this.mCurrentToken);
        }

        private void populateAlbumViewInfo(View row, ViewWrapper wrapper) {
            wrapper.getAlbumLabel().setText(this.mCursor.getString(this.mCursor.getColumnIndexOrThrow("album")));
            wrapper.getArtistLabel().setText(this.mCursor.getString(this.mCursor.getColumnIndexOrThrow("artist")));
            int numberSongs = this.mCursor.getInt(this.mCursor.getColumnIndexOrThrow("numsongs"));
            wrapper.getSongTotalLabel().setText(this.mResources.getQuantityString(C0116R.plurals.album_song_count, numberSongs, new Object[]{Integer.valueOf(numberSongs)}));
            if (wrapper.getPlayIcon().getHeight() > 0) {
                this.mRowHeight = Utils.calculateAlbumArt(wrapper.getPlayIcon().getHeight());
                wrapper.setVisible(0);
            } else {
                wrapper.setVisible(4);
                Message message = new Message();
                message.obj = wrapper;
                AlbumListingView.this.mHandler.sendMessage(message);
            }
            int column = this.mCursor.getColumnIndexOrThrow("album_art");
            if (this.mCursor.getString(column) != null) {
                Bitmap albumArtBitmap = BitmapFactory.decodeFile(this.mCursor.getString(column));
                if (albumArtBitmap == null) {
                    setDefaultAlbumArt(wrapper);
                } else {
                    wrapper.getAlbumArt().setImageBitmap(Bitmap.createScaledBitmap(albumArtBitmap, this.mRowHeight, this.mRowHeight, true));
                    albumArtBitmap.recycle();
                }
            } else {
                setDefaultAlbumArt(wrapper);
            }
            column = this.mCursor.getColumnIndexOrThrow("album_key");
            final String albumKey = this.mCursor.getString(column);
            PlayIcon playIcon = wrapper.getPlayIcon();
            playIcon.setPlaying(albumPlaying(albumKey));
            playIcon.setTag(this.mCursor.getString(column));
            playIcon.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!AlbumListAdapter.this.albumPlaying(albumKey)) {
                        Cursor c = MediaUtils.getMediaStoreMergeCursor(AlbumListingView.this.mActivity, new String[]{"_id", "title", Analytics.TRACK_KEY}, "album_key = ?", new String[]{(String) v.getTag()}, "track ASC");
                        try {
                            AlbumListingView.this.mService.setCurrentList(Constants.TOP_MENU_ALBUMS, (String) v.getTag());
                            AlbumListingView.this.mService.setPlayableList(Utils.createPlayableListFromCursor(c), 0);
                            c.close();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        private void setDefaultAlbumArt(ViewWrapper wrapper) {
            Bitmap albumArtBitmap = BitmapFactory.decodeResource(AlbumListingView.this.mActivity.getResources(), C0116R.drawable.generic_album_small);
            wrapper.getAlbumArt().setImageBitmap(Bitmap.createScaledBitmap(albumArtBitmap, this.mRowHeight, this.mRowHeight, true));
            albumArtBitmap.recycle();
        }
    }

    public AlbumListingView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_ALBUM_LIST);
        setViewCategory(VIEW_CATEGORY);
        setHeaderViewText(this.mActivity.getString(C0116R.string.album_header));
        setViewAnalyticsUri(Analytics.EVENT_MUSIC_ALBUMS);
    }

    private void initAlbumListingView() {
        if (this.mInitialized) {
            openCursors();
            this.mAdapter.swapCursor(this.mCursor);
            return;
        }
        this.mInflater = LayoutInflater.from(this.mActivity);
        openCursors();
        this.mAdapter = new AlbumListAdapter(this.mActivity.getApplicationContext(), C0116R.layout.album_item, this.mCursor, new String[]{"album"}, new int[]{C0116R.id.album_item_album_text});
        this.mListView = (ListView) this.mView.findViewById(C0116R.id.album_details_list);
        this.mListView.setFastScrollEnabled(true);
        this.mListViewFooter = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
        this.mListView.addFooterView(this.mListViewFooter);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.removeFooterView(this.mListViewFooter);
        this.mListView.setOnScrollListener(new C02132());
        this.mListView.setOnItemClickListener(new C02143());
        setContextMenuView(this.mListView);
        this.mInitialized = true;
    }

    private void openCursors() {
        this.mCursor = MediaUtils.getMediaStoreMergeCursorForAlbum(this.mActivity, new String[]{"_id", "album_key", "album", "artist", "numsongs", "album_art"}, null, null, "album_key ASC");
    }

    private void closeCursors() {
        try {
            if (!(this.mCursor == null || this.mCursor.isClosed())) {
                this.mCursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mCursor = null;
    }

    public void onMediaServiceEvent(int aEvent) {
        super.onMediaServiceEvent(aEvent);
        switch (aEvent) {
            case 4:
                try {
                    this.mCurrentActivity = this.mService.getCurrentListActivity();
                    this.mCurrentToken = this.mService.getCurrentListToken();
                } catch (RemoteException e) {
                    e.printStackTrace();
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
        initAlbumListingView();
        registerContentObserver(this.mCursor, this.mAdapter, this.mListView, getClass().getName(), 1000);
    }

    public void onPause() {
        super.onPause();
        unregisterContentObserver(this.mCursor, getClass().getName());
    }

    public void onStop() {
        super.onStop();
        if (isScrollIdle()) {
            closeCursorsDelayed();
        }
    }

    private void closeCursorsDelayed() {
        ContentBrowser.getHandler().postDelayed(new C02154(), 100);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.mListView == aView) {
            this.mCursor.moveToPosition(((AdapterContextMenuInfo) aMenuInfo).position);
            String albumTitle = this.mCursor.getString(this.mCursor.getColumnIndex("album"));
            aMenu.setHeaderTitle(albumTitle);
            String albumKey = this.mCursor.getString(this.mCursor.getColumnIndexOrThrow("album_key"));
            String[] songsProj = new String[]{"_id", Analytics.TRACK_KEY};
            ContextMenuUtils.addPlaylistSubMenu(this.mActivity, aMenu, MediaUtils.getMediaStoreMergeCursor(this.mActivity, songsProj, "album_key= ?", new String[]{albumKey}, "track ASC"), albumTitle, true);
        }
    }

    public View getAlbumList() {
        return this.mListView;
    }
}
