package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
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
import android.widget.ListView;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.Playlist;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.dialogs.CreatePlaylistDialog;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;
import com.songbirdnest.util.MediaUtils;

public class PlaylistListingView extends BaseContentBrowserView {
    private static final int PLAYLIST_TOKENS_LENGTH = 2;
    private static final String VIEW_CATEGORY = "music:playlists";
    private String currentActivity;
    private String currentPlaylistId;
    private String currentPlaylistVolume;
    private PlaylistListAdapter mAdapter;
    private Cursor mCursor;
    private View mFooter;
    private LayoutInflater mInflater;
    private boolean mInitialized = false;
    private ListView mPlaylistList;

    class C03521 implements OnItemClickListener {
        C03521() {
        }

        public void onItemClick(AdapterView<?> adapterView, View aView, int aPosition, long aItemId) {
            if (((PlaylistListItemWrapper) aView.getTag()).mPlaylistItemCount == 0) {
                Utils.showShortToast(PlaylistListingView.this.mActivity, PlaylistListingView.this.mActivity.getString(C0116R.string.playlist_no_items_in_list_message));
                return;
            }
            PlaylistListingView.this.mCursor.moveToPosition(aPosition);
            Intent playlistDetails = new Intent(PlaylistListingView.this.mActivity, ContentBrowser.class);
            playlistDetails.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_PLAYLIST_DETAILS);
            playlistDetails.putExtra(Constants.EXTRA_PLAYLIST_ID, PlaylistListingView.this.mCursor.getInt(PlaylistListingView.this.mCursor.getColumnIndex("_id")));
            playlistDetails.putExtra(Constants.EXTRA_PLAYLIST_VOLUME, Utils.getVolumeFromCursor(PlaylistListingView.this.mCursor));
            PlaylistListingView.this.mActivity.startActivity(playlistDetails);
        }
    }

    class C03532 implements OnScrollListener {
        C03532() {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            PlaylistListingView.this.setScrollState(scrollState);
            if (PlaylistListingView.this.isViewStopped() && PlaylistListingView.this.isScrollIdle()) {
                PlaylistListingView.this.closeCursorsDelayed();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (PlaylistListingView.this.mPlaylistList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    PlaylistListingView.this.mPlaylistList.removeFooterView(PlaylistListingView.this.mFooter);
                } else if (PlaylistListingView.this.mPlaylistList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    PlaylistListingView.this.mPlaylistList.addFooterView(PlaylistListingView.this.mFooter);
                }
            }
        }
    }

    class C03543 implements Runnable {
        C03543() {
        }

        public void run() {
            PlaylistListingView.this.closeCursors();
        }
    }

    class C03554 implements OnDismissListener {
        C03554() {
        }

        public void onDismiss(DialogInterface aDialog) {
            PlaylistListingView.this.mCursor.requery();
            PlaylistListingView.this.mAdapter.notifyDataSetChanged();
        }
    }

    class PlaylistListAdapter extends BaseAdapter {
        private Activity mActivity;

        class PlaylistListItemWrapper {
            public int mPlaylistItemCount = 0;
            public String mPlaylistName = null;

            PlaylistListItemWrapper() {
            }
        }

        public PlaylistListAdapter(Activity aActivity) {
            this.mActivity = aActivity;
        }

        public int getCount() {
            if (PlaylistListingView.this.mCursor == null || PlaylistListingView.this.mCursor.isClosed()) {
                return 0;
            }
            return PlaylistListingView.this.mCursor.getCount();
        }

        public Object getItem(int aPosition) {
            return Integer.valueOf(aPosition);
        }

        public long getItemId(int aPosition) {
            return (long) aPosition;
        }

        public View getView(int aPosition, View aConvertView, ViewGroup aParent) {
            PlaylistListingView.this.mCursor.moveToPosition(aPosition);
            if (aConvertView == null) {
                aConvertView = PlaylistListingView.this.mInflater.inflate(C0116R.layout.playlist_item, null);
            }
            PlaylistListItemWrapper wrapper = new PlaylistListItemWrapper();
            TextView playlistName = (TextView) aConvertView.findViewById(C0116R.id.playlist_item_playlist_name);
            wrapper.mPlaylistName = PlaylistListingView.this.mCursor.getString(PlaylistListingView.this.mCursor.getColumnIndex(CookieTable.NAME));
            playlistName.setText(wrapper.mPlaylistName);
            TextView playlistCount = (TextView) aConvertView.findViewById(C0116R.id.playlist_item_song_total);
            final Long playlistId = Long.valueOf(PlaylistListingView.this.mCursor.getLong(PlaylistListingView.this.mCursor.getColumnIndex("_id")));
            final String playlistVolume = Utils.getVolumeFromCursor(PlaylistListingView.this.mCursor);
            int count = getSongCount(playlistId);
            playlistCount.setText(this.mActivity.getResources().getQuantityString(C0116R.plurals.album_song_count, count, new Object[]{Integer.valueOf(count)}));
            wrapper.mPlaylistItemCount = count;
            PlayIcon playIcon = (PlayIcon) aConvertView.findViewById(C0116R.id.playlist_icon_play_icon);
            playIcon.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!PlaylistListAdapter.this.playlistPlaying(playlistId, playlistVolume)) {
                        PlaylistListAdapter.this.playPlaylistSongs(playlistId, playlistVolume);
                    }
                }
            });
            playIcon.setPlaying(playlistPlaying(playlistId, playlistVolume));
            aConvertView.setTag(wrapper);
            return aConvertView;
        }

        private int getSongCount(Long aPlaylistId) {
            int songCount = 0;
            try {
                Cursor countCursor = MediaUtils.getMediaStoreMergeCursorForPlaylist(this.mActivity, new String[]{"COUNT(*)"}, null, null, null, aPlaylistId.longValue(), false);
                if (countCursor.moveToFirst()) {
                    songCount = countCursor.getInt(0);
                }
                countCursor.close();
                return songCount;
            } catch (Exception e) {
                return 0;
            }
        }

        private boolean playlistPlaying(Long playlistId, String playlistVolume) {
            return Constants.TOP_MENU_PLAYLISTS.equals(PlaylistListingView.this.currentActivity) && playlistId.toString().equals(PlaylistListingView.this.currentPlaylistId) && playlistVolume.equals(PlaylistListingView.this.currentPlaylistVolume);
        }

        private void playPlaylistSongs(Long playlistId, String playlistVolume) {
            Playlist playlist = new Playlist(playlistVolume, playlistId);
            try {
                PlaylistListingView.this.mService.setCurrentList(Constants.TOP_MENU_PLAYLISTS, playlistId + ":" + playlistVolume);
                PlaylistListingView.this.mService.setPlayablePlaylist(playlist, 0, false);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public PlaylistListingView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_PLAYLIST_LIST);
        setViewCategory(VIEW_CATEGORY);
        setHeaderViewText(this.mActivity.getString(C0116R.string.playlist_header));
        setViewAnalyticsUri(Analytics.EVENT_MUSIC_PLAYLISTS);
    }

    private void initPlaylistListingView() {
        openCursors();
        if (!this.mInitialized) {
            this.mInflater = LayoutInflater.from(this.mActivity);
            this.mAdapter = new PlaylistListAdapter(this.mActivity);
            this.mPlaylistList = (ListView) this.mView.findViewById(C0116R.id.playlist_listing_list);
            this.mFooter = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
            this.mPlaylistList.addFooterView(this.mFooter);
            this.mPlaylistList.setAdapter(this.mAdapter);
            this.mPlaylistList.removeFooterView(this.mFooter);
            this.mPlaylistList.setOnItemClickListener(new C03521());
            this.mPlaylistList.setOnScrollListener(new C03532());
            setContextMenuView(this.mPlaylistList);
            this.mInitialized = true;
        }
    }

    public void onResume() {
        super.onResume();
        initPlaylistListingView();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        if (isScrollIdle()) {
            closeCursorsDelayed();
        }
    }

    private void closeCursorsDelayed() {
        ContentBrowser.getHandler().postDelayed(new C03543(), 100);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mInitialized = false;
    }

    public void onMediaServiceEvent(int aEvent) {
        super.onMediaServiceEvent(aEvent);
        switch (aEvent) {
            case 4:
                try {
                    String listToken = this.mService.getCurrentListToken();
                    if (listToken != null) {
                        String[] tokens = listToken.split(":");
                        if (tokens.length == 2) {
                            this.currentPlaylistId = tokens[0];
                            this.currentPlaylistVolume = tokens[1];
                        } else {
                            this.currentPlaylistId = null;
                            this.currentPlaylistVolume = null;
                        }
                    }
                    this.currentActivity = this.mService.getCurrentListActivity();
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

    public boolean onCreateOptionsMenu(Menu aMenu) {
        this.mMenuInflater.inflate(C0116R.menu.playlist_listing_menu, aMenu);
        super.onCreateOptionsMenu(aMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem aItem) {
        switch (aItem.getItemId()) {
            case C0116R.id.playlist_listing_menu_new:
                CreatePlaylistDialog dialog = new CreatePlaylistDialog(this.mActivity);
                dialog.setOnDismissListener(new C03554());
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(aItem);
        }
    }

    public void onCreateContextMenu(ContextMenu aMenu, View aView, ContextMenuInfo aMenuInfo) {
        if (this.mPlaylistList == aView) {
            this.mCursor.moveToPosition(((AdapterContextMenuInfo) aMenuInfo).position);
            final String playlistName = this.mCursor.getString(this.mCursor.getColumnIndex(CookieTable.NAME));
            aMenu.setHeaderTitle(playlistName);
            final int playlistId = this.mCursor.getInt(this.mCursor.getColumnIndex("_id"));
            final String playlistVolume = Utils.getVolumeFromCursor(this.mCursor);
            aMenu.add(C0116R.string.playlist_listing_menu_remove).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem aItem) {
                    Utils.removeMediaStorePlaylist(PlaylistListingView.this.mActivity, playlistId, playlistVolume);
                    PlaylistListingView.this.mCursor.requery();
                    PlaylistListingView.this.mAdapter.notifyDataSetChanged();
                    Utils.showShortToast(PlaylistListingView.this.mActivity, PlaylistListingView.this.mActivity.getString(C0116R.string.playlist_removed_message));
                    return true;
                }
            });
            aMenu.add(C0116R.string.playlist_listing_menu_rename).setOnMenuItemClickListener(new OnMenuItemClickListener() {

                class C03571 implements OnDismissListener {
                    C03571() {
                    }

                    public void onDismiss(DialogInterface aDialog) {
                        PlaylistListingView.this.mCursor.requery();
                        PlaylistListingView.this.mAdapter.notifyDataSetChanged();
                    }
                }

                public boolean onMenuItemClick(MenuItem aItem) {
                    CreatePlaylistDialog dialog = new CreatePlaylistDialog(PlaylistListingView.this.mActivity);
                    dialog.setDialogMode(1);
                    dialog.setPlaylist(playlistName, playlistId, playlistVolume);
                    dialog.setOnDismissListener(new C03571());
                    dialog.show();
                    return true;
                }
            });
        }
    }

    private void openCursors() {
        this.mCursor = MediaUtils.getMediaStoreMergeCursorForPlaylist(this.mActivity, new String[]{"_id", CookieTable.NAME}, null, null, "name ASC");
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
}
