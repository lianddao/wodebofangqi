package com.miui.player.ui;

import android.app.ActionBar;
import android.content.AsyncQueryHandler;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Audio.Media;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.meta.MetaManager;
import com.miui.player.provider.PlayerStore.OnlineAudioDetail.Columns;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.util.SqlUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Collator;
import java.util.Formatter;
import java.util.Locale;

public class MusicPicker extends MusicBaseActivity implements OnClickListener, OnCompletionListener, DialogCallback, OnAudioFocusChangeListener, OnItemClickListener {
    static final int ALBUM_MENU = 2;
    static final int ARTIST_MENU = 3;
    static final String[] CURSOR_COLS = new String[]{"_id", "title", "title_key", "_data", "album", "artist", Columns.ARTIST_ID, "track"};
    static final boolean DBG = false;
    static final String FOCUS_KEY = "focused";
    static final String LIST_STATE_KEY = "liststate";
    static final int MY_QUERY_TOKEN = 42;
    static final String SORT_MODE_KEY = "sortMode";
    static final String TAG = "RingtonePicker";
    static final int TRACK_MENU = 1;
    static StringBuilder sFormatBuilder = new StringBuilder();
    static Formatter sFormatter = new Formatter(sFormatBuilder, Locale.getDefault());
    static final Object[] sTimeArgs = new Object[5];
    TrackListAdapter mAdapter;
    Uri mBaseUri;
    Cursor mCursor;
    View mListContainer;
    boolean mListHasFocus;
    boolean mListShown;
    Parcelable mListState = null;
    MediaPlayer mMediaPlayer;
    private BroadcastReceiver mMountReceiver = new C04521();
    long mPlayingId = -1;
    View mProgressContainer;
    QueryHandler mQueryHandler;
    long mSelectedId = -1;
    Uri mSelectedUri;
    int mSortMode = -1;
    String mSortOrder;
    int mStreamType = 3;

    class C04521 extends BroadcastReceiver {
        C04521() {
        }

        public void onReceive(Context context, Intent intent) {
            MusicPicker.this.doQuery(false, null);
        }
    }

    private final class QueryHandler extends AsyncQueryHandler {
        public QueryHandler(Context context) {
            super(context.getContentResolver());
        }

        protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
            if (!MusicPicker.this.isFinishing()) {
                MusicPicker.this.mAdapter.setLoading(false);
                MusicPicker.this.mAdapter.changeCursor(cursor);
                MusicPicker.this.setProgressBarIndeterminateVisibility(false);
                if (MusicPicker.this.mListState != null) {
                    MusicPicker.this.getListView().onRestoreInstanceState(MusicPicker.this.mListState);
                    if (MusicPicker.this.mListHasFocus) {
                        MusicPicker.this.getListView().requestFocus();
                    }
                    MusicPicker.this.mListHasFocus = false;
                    MusicPicker.this.mListState = null;
                }
            } else if (cursor != null) {
                cursor.close();
            }
        }
    }

    class TrackListAdapter extends SimpleCursorAdapter {
        private int mAlbumIdx;
        private int mArtistIdx;
        private final StringBuilder mBuilder = new StringBuilder();
        private int mIdIdx;
        final ListView mListView;
        private boolean mLoading = true;
        private int mTitleIdx;
        private final String mUnknownAlbum;
        private final String mUnknownArtist;

        class ViewHolder {
            CharArrayBuffer buffer1;
            char[] buffer2;
            TextView line1;
            TextView line2;
            ImageView play_indicator;
            RadioButton radio;

            ViewHolder() {
            }
        }

        TrackListAdapter(Context context, ListView listView, int layout, String[] from, int[] to) {
            super(context, layout, null, from, to);
            this.mListView = listView;
            this.mUnknownArtist = context.getString(C0329R.string.unknown_artist_name);
            this.mUnknownAlbum = context.getString(C0329R.string.unknown_album_name);
        }

        public void setLoading(boolean loading) {
            this.mLoading = loading;
            MusicPicker.this.mProgressContainer.setVisibility(loading ? 0 : 8);
        }

        public boolean isEmpty() {
            if (this.mLoading) {
                return false;
            }
            return super.isEmpty();
        }

        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            View v = super.newView(context, cursor, parent);
            ViewHolder vh = new ViewHolder();
            vh.line1 = (TextView) v.findViewById(C0329R.id.line1);
            vh.line2 = (TextView) v.findViewById(C0329R.id.line2);
            vh.radio = (RadioButton) v.findViewById(C0329R.id.radio);
            vh.play_indicator = (ImageView) v.findViewById(C0329R.id.play_indicator);
            vh.buffer1 = new CharArrayBuffer(100);
            vh.buffer2 = new char[200];
            v.setTag(vh);
            return v;
        }

        public void bindView(View view, Context context, Cursor cursor) {
            ViewHolder vh = (ViewHolder) view.getTag();
            cursor.copyStringToBuffer(this.mTitleIdx, vh.buffer1);
            vh.line1.setText(vh.buffer1.data, 0, vh.buffer1.sizeCopied);
            StringBuilder builder = this.mBuilder;
            builder.delete(0, builder.length());
            String name = cursor.getString(this.mAlbumIdx);
            if (MetaManager.isUnknowName(name)) {
                builder.append(this.mUnknownAlbum);
            } else {
                builder.append(name);
            }
            builder.append('\n');
            name = cursor.getString(this.mArtistIdx);
            if (name == null || name.equals("<unknown>")) {
                builder.append(this.mUnknownArtist);
            } else {
                builder.append(name);
            }
            int len = builder.length();
            if (vh.buffer2.length < len) {
                vh.buffer2 = new char[len];
            }
            builder.getChars(0, len, vh.buffer2, 0);
            vh.line2.setText(vh.buffer2, 0, len);
            long id = cursor.getLong(this.mIdIdx);
            vh.radio.setChecked(id == MusicPicker.this.mSelectedId);
            ImageView iv = vh.play_indicator;
            if (id == MusicPicker.this.mPlayingId) {
                boolean z = MusicPicker.this.mMediaPlayer != null && MusicPicker.this.mMediaPlayer.isPlaying();
                iv.setSelected(z);
                iv.setVisibility(0);
                return;
            }
            iv.setVisibility(8);
        }

        public void changeCursor(Cursor cursor) {
            super.changeCursor(cursor);
            MusicPicker.this.mCursor = cursor;
            if (cursor == null && MusicPicker.this.isResumed()) {
                MusicPicker.this.makeErrorView();
                UIHelper.displayDatabaseError(MusicPicker.this);
                MusicPicker.this.closeContextMenu();
            } else {
                MusicPicker.this.makeCommitView();
                UIHelper.hideDatabaseError(MusicPicker.this);
            }
            if (cursor != null) {
                this.mIdIdx = cursor.getColumnIndex("_id");
                this.mTitleIdx = cursor.getColumnIndex("title");
                this.mArtistIdx = cursor.getColumnIndex("artist");
                this.mAlbumIdx = cursor.getColumnIndex("album");
            }
            MusicPicker.this.makeListShown();
        }

        public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
            return MusicPicker.this.doQuery(true, constraint.toString());
        }
    }

    public void onCreateContent(Bundle icicle) {
        int type;
        int sortMode = 1;
        if (icicle == null) {
            this.mSelectedUri = (Uri) getIntent().getParcelableExtra("android.intent.extra.ringtone.EXISTING_URI");
            type = getIntent().getIntExtra("android.intent.extra.ringtone.TYPE", -1);
        } else {
            this.mSelectedUri = (Uri) icicle.getParcelable("android.intent.extra.ringtone.EXISTING_URI");
            this.mListState = icicle.getParcelable(LIST_STATE_KEY);
            this.mListHasFocus = icicle.getBoolean(FOCUS_KEY);
            sortMode = icicle.getInt(SORT_MODE_KEY, 1);
            type = icicle.getInt("android.intent.extra.ringtone.TYPE", -1);
        }
        if (type >= 0) {
            this.mStreamType = getStreamType(type);
        }
        setVolumeControlStream(this.mStreamType);
        if ("android.intent.action.RINGTONE_PICKER".equals(getIntent().getAction())) {
            this.mBaseUri = Media.EXTERNAL_CONTENT_URI;
        } else {
            this.mBaseUri = getIntent().getData();
            if (this.mBaseUri == null) {
                this.mBaseUri = Media.EXTERNAL_CONTENT_URI;
            }
        }
        setContentView(C0329R.layout.music_picker);
        this.mProgressContainer = findViewById(C0329R.id.progressContainer);
        this.mSortOrder = "title_key";
        ListView listView = (ListView) getListView();
        listView.setEmptyView(findViewById(C0329R.id.empty_track_list));
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        this.mAdapter = new TrackListAdapter(this, listView, C0329R.layout.music_picker_item, new String[0], new int[0]);
        setListAdapter(this.mAdapter);
        listView.setTextFilterEnabled(true);
        listView.setSaveEnabled(false);
        this.mQueryHandler = new QueryHandler(this);
        this.mListContainer = findViewById(C0329R.id.listContainer);
        if (this.mSelectedUri != null) {
            Builder builder = this.mSelectedUri.buildUpon();
            String path = this.mSelectedUri.getEncodedPath();
            int idx = path.lastIndexOf(47);
            if (idx >= 0) {
                path = path.substring(0, idx);
            }
            builder.encodedPath(path);
            if (builder.build().equals(this.mBaseUri)) {
                this.mSelectedId = ContentUris.parseId(this.mSelectedUri);
            } else {
                Uri uri = translateToContentUri(this, this.mSelectedUri, Media.EXTERNAL_CONTENT_URI, "_id", "_data");
                if (uri != null) {
                    this.mSelectedId = ContentUris.parseId(uri);
                }
            }
        }
        setSortMode(sortMode);
        makeCommitView();
    }

    public AbsListView getListView() {
        return (AbsListView) findViewById(16908298);
    }

    protected void setListAdapter(ListAdapter adapter) {
        AbsListView list = getListView();
        if (list != null) {
            list.setAdapter(adapter);
        }
    }

    private void makeCommitView() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setCustomView(100859949);
        actionBar.setDisplayShowCustomEnabled(true);
        View commitView = actionBar.getCustomView();
        commitView.findViewById(16908313).setOnClickListener(this);
        commitView.findViewById(16908314).setOnClickListener(this);
    }

    private void makeErrorView() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setCustomView(C0329R.layout.sd_error_title);
        actionBar.setDisplayShowCustomEnabled(true);
    }

    private static int getStreamType(int ringtoneType) {
        switch (ringtoneType) {
            case 2:
                return 5;
            case 4:
                return 4;
            default:
                return 2;
        }
    }

    public void onRestart() {
        super.onRestart();
        doQuery(false, null);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(29);
        if (item != null) {
            item.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (setSortMode(item.getItemId())) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, C0329R.string.sort_by_track);
        menu.add(0, 2, 0, C0329R.string.sort_by_album);
        menu.add(0, 3, 0, C0329R.string.sort_by_artist);
        return true;
    }

    protected void onSaveInstanceState(Bundle icicle) {
        super.onSaveInstanceState(icicle);
        icicle.putParcelable(LIST_STATE_KEY, getListView().onSaveInstanceState());
        icicle.putBoolean(FOCUS_KEY, getListView().hasFocus());
        icicle.putInt(SORT_MODE_KEY, this.mSortMode);
        icicle.putInt("android.intent.extra.ringtone.TYPE", this.mStreamType);
    }

    protected void onResume() {
        super.onResume();
        IntentFilter f = new IntentFilter();
        f.addAction("android.intent.action.MEDIA_EJECT");
        f.addAction("android.intent.action.MEDIA_MOUNTED");
        f.addDataScheme("file");
        registerReceiver(this.mMountReceiver, f);
    }

    public void onPause() {
        super.onPause();
        stopMediaPlayer(true);
        unregisterReceiver(this.mMountReceiver);
    }

    public void onStop() {
        super.onStop();
        this.mAdapter.setLoading(true);
        this.mAdapter.changeCursor(null);
    }

    boolean setSortMode(int sortMode) {
        if (sortMode != this.mSortMode) {
            switch (sortMode) {
                case 1:
                    this.mSortMode = sortMode;
                    this.mSortOrder = "title_key";
                    doQuery(false, null);
                    return true;
                case 2:
                    this.mSortMode = sortMode;
                    this.mSortOrder = "album_key ASC, track ASC, title_key ASC";
                    doQuery(false, null);
                    return true;
                case 3:
                    this.mSortMode = sortMode;
                    this.mSortOrder = "artist_key ASC, album_key ASC, track ASC, title_key ASC";
                    doQuery(false, null);
                    return true;
            }
        }
        return false;
    }

    void makeListShown() {
        if (!this.mListShown) {
            this.mListShown = true;
            this.mListContainer.startAnimation(AnimationUtils.loadAnimation(this, 17432576));
            this.mListContainer.setVisibility(0);
        }
    }

    Cursor doQuery(boolean sync, String filterstring) {
        this.mQueryHandler.cancelOperation(MY_QUERY_TOKEN);
        StringBuilder where = new StringBuilder();
        where.append("title != ''");
        String[] keywords = null;
        if (filterstring != null) {
            int i;
            String[] searchWords = filterstring.split(" ");
            keywords = new String[searchWords.length];
            Collator.getInstance().setStrength(0);
            for (i = 0; i < searchWords.length; i++) {
                keywords[i] = '%' + Audio.keyFor(searchWords[i]) + '%';
            }
            for (i = 0; i < searchWords.length; i++) {
                where.append(" AND ");
                where.append("artist_key||");
                where.append("album_key||");
                where.append("title_key LIKE ?");
            }
        }
        String whereStr = SqlUtils.wrapWithBlacklist(this, where.toString());
        if (sync) {
            try {
                return SqlUtils.query(this, this.mBaseUri, CURSOR_COLS, whereStr, keywords, this.mSortOrder);
            } catch (UnsupportedOperationException e) {
            }
        } else {
            this.mAdapter.setLoading(true);
            setProgressBarIndeterminateVisibility(true);
            this.mQueryHandler.startQuery(MY_QUERY_TOKEN, null, this.mBaseUri, CURSOR_COLS, whereStr, keywords, this.mSortOrder);
            return null;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        this.mCursor.moveToPosition(position);
        setSelected(this.mCursor);
    }

    void setSelected(Cursor c) {
        Uri uri = Media.EXTERNAL_CONTENT_URI;
        long newId = this.mCursor.getLong(this.mCursor.getColumnIndex("_id"));
        this.mSelectedUri = ContentUris.withAppendedId(uri, newId);
        this.mSelectedId = newId;
        if (newId != this.mPlayingId || this.mMediaPlayer == null) {
            stopMediaPlayer(false);
            this.mMediaPlayer = new MediaPlayer();
            this.mMediaPlayer.setAudioStreamType(this.mStreamType);
            try {
                this.mMediaPlayer.setDataSource(this, this.mSelectedUri);
                this.mMediaPlayer.prepare();
                this.mMediaPlayer.setOnCompletionListener(this);
                this.mMediaPlayer.start();
                this.mPlayingId = newId;
                ((AudioManager) getSystemService("audio")).requestAudioFocus(this, 2, 3);
                getListView().invalidateViews();
            } catch (IOException e) {
                if (fileNotFound(this.mSelectedUri)) {
                    Toast.makeText(this, C0329R.string.file_not_found, 0).show();
                } else {
                    Toast.makeText(this, C0329R.string.playback_failed, 0).show();
                }
            }
        } else if (this.mMediaPlayer != null) {
            stopMediaPlayer(true);
            getListView().invalidateViews();
        }
    }

    public void onCompletion(MediaPlayer mp) {
        this.mMediaPlayer.stop();
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
        this.mPlayingId = -1;
        getListView().invalidateViews();
        ((AudioManager) getSystemService("audio")).abandonAudioFocus(this);
    }

    void stopMediaPlayer(boolean abandonFocus) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            if (abandonFocus) {
                ((AudioManager) getSystemService("audio")).abandonAudioFocus(this);
            }
        }
    }

    public void onClick(View v) {
        if (v.getId() != 16908314) {
            finish();
        } else if (this.mSelectedId >= 0) {
            Intent result = new Intent();
            result.setData(this.mSelectedUri);
            result.putExtra("android.intent.extra.ringtone.PICKED_URI", this.mSelectedUri);
            setResult(-1, result);
            finish();
        } else {
            Toast.makeText(this, C0329R.string.not_selected, 0).show();
        }
    }

    public void onDialogResult(int requestCode, boolean confirm, Intent intent) {
        switch (requestCode) {
            case 11:
                if (confirm) {
                    doQuery(false, null);
                    return;
                } else {
                    finish();
                    return;
                }
            default:
                return;
        }
    }

    public void onAudioFocusChange(int focusChange) {
        switch (focusChange) {
            case -3:
            case -2:
            case -1:
                stopMediaPlayer(true);
                return;
            default:
                return;
        }
    }

    boolean fileNotFound(Uri uri) {
        try {
            getContentResolver().openAssetFileDescriptor(uri, "r");
            return false;
        } catch (FileNotFoundException e) {
            return true;
        }
    }

    static Uri translateToContentUri(Context context, Uri uri, Uri baseUri, String idProject, String pathProject) {
        Uri uri2 = null;
        if (uri != null && "file".equals(uri.getScheme())) {
            Cursor c = context.getContentResolver().query(baseUri, new String[]{idProject}, pathProject + "=?", new String[]{uri.getPath()}, null);
            if (c != null) {
                try {
                    if (c.moveToFirst()) {
                        uri2 = ContentUris.withAppendedId(baseUri, c.getLong(0));
                    }
                    c.close();
                } catch (Throwable th) {
                    c.close();
                }
            }
        }
        return uri2;
    }
}
