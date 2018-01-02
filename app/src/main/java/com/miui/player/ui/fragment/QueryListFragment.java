package com.miui.player.ui.fragment;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Albums;
import android.provider.MediaStore.Audio.Artists;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;
import android.util.Pool;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.ImageDownloader.ImageRequest;
import com.miui.player.provider.MediaProviderHelper;
import com.miui.player.provider.PlayerStore.OnlineAudioDetail.Columns;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MediaCursorLoader.MediaLoaderInfo;
import com.miui.player.ui.base.MediaCursorLoader.QueryArgs;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.util.Actions;
import com.miui.player.util.CachePolicy;
import java.util.Arrays;
import miui.cache.RequestManager;

public class QueryListFragment extends MusicBaseFragment {
    private QueryListAdapter mAdapter;
    private String mFilterString = MetaManager.UNKNOWN_STRING;
    private ListView mListView;
    Cursor mQueryCursor;
    private boolean mServiceConnected = false;
    private Toast mToast;

    static class QueryListAdapter extends SimpleCursorAdapter {
        public static RequestManager<String, Bitmap, Integer> sAlbumProvider;
        public static RequestManager<String, Bitmap, Integer> sArtistProvider;
        private static int sDrawHeight;
        private static int sDrawWidth;
        static Pool<ImageRequest> sPool = ImageRequest.createPool();
        QueryListFragment mFragment = null;
        private final long[] mValidAlbumIdArr;
        private final long[] mValidArtistIdArr;
        private final long[] mValidTrackIdArr;

        QueryListAdapter(Context context, QueryListFragment currentFragment, int layout, Cursor cursor, String[] from, int[] to) {
            super(context, layout, cursor, from, to, 2);
            this.mFragment = currentFragment;
            this.mValidArtistIdArr = MediaProviderHelper.queryValidArtistIdArr(context);
            this.mValidAlbumIdArr = MediaProviderHelper.queryValidAlbumIdArr(context);
            this.mValidTrackIdArr = MediaProviderHelper.queryValidTrackIdArr(context);
            Resources r = context.getResources();
            if (sArtistProvider == null) {
                Bitmap b = BitmapFactory.decodeResource(r, C0329R.drawable.avatar_item_default);
                sDrawWidth = b.getWidth();
                sDrawHeight = b.getHeight();
                sArtistProvider = RequestManager.create(CachePolicy.getLocalAvatarCacheSize(), b);
            }
            if (sAlbumProvider == null) {
                sAlbumProvider = RequestManager.create(CachePolicy.getLocalAvatarCacheSize(), BitmapFactory.decodeResource(r, C0329R.drawable.album_item_default));
            }
        }

        public void bindView(View view, Context context, Cursor cursor) {
            long id = cursor.getLong(0);
            TextView tv1 = (TextView) view.findViewById(C0329R.id.title);
            TextView tv2 = (TextView) view.findViewById(C0329R.id.details);
            ImageView iv = (ImageView) view.findViewById(C0329R.id.icon);
            LayoutParams p = iv.getLayoutParams();
            if (p == null) {
                DatabaseUtils.dumpCursor(cursor);
                return;
            }
            p.width = -2;
            p.height = -2;
            String mimetype = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
            if (mimetype == null) {
                mimetype = "audio/";
            }
            ImageRequest request;
            if (mimetype.equals("artist")) {
                String artistName = cursor.getString(cursor.getColumnIndexOrThrow("artist"));
                boolean isunknown = MetaManager.isUnknowName(artistName);
                tv1.setText(MetaManager.getLocaleArtistName(context, artistName));
                tv2.setText(UIHelper.makeAlbumsSongsLabel(context, cursor.getInt(cursor.getColumnIndexOrThrow("data1")), cursor.getInt(cursor.getColumnIndexOrThrow("data2")), isunknown));
                view.setEnabled(Arrays.binarySearch(this.mValidArtistIdArr, id) >= 0);
                request = (ImageRequest) sPool.acquire();
                request.init(sDrawWidth, sDrawHeight, new ImageSearchInfo(artistName), iv, sPool);
                iv.setTag(request.getKey());
                if (sArtistProvider.isStarted()) {
                    sArtistProvider.request(request);
                    return;
                }
                return;
            }
            if (mimetype.equals("album")) {
                String albumName = cursor.getString(cursor.getColumnIndexOrThrow("album"));
                tv1.setText(MetaManager.getLocaleAlbumName(context, albumName));
                artistName = cursor.getString(cursor.getColumnIndexOrThrow("artist"));
                tv2.setText(MetaManager.getLocaleArtistName(context, artistName));
                view.setEnabled(Arrays.binarySearch(this.mValidAlbumIdArr, id) >= 0);
                request = (ImageRequest) sPool.acquire();
                request.init(sDrawWidth, sDrawHeight, new ImageSearchInfo(albumName, artistName), iv, sPool);
                iv.setTag(request.getKey());
                if (sAlbumProvider.isStarted()) {
                    sAlbumProvider.request(request);
                    return;
                }
                return;
            }
            if (!mimetype.startsWith("audio/")) {
                if (!mimetype.equals("application/ogg")) {
                    if (!mimetype.equals("application/x-ogg")) {
                        return;
                    }
                }
            }
            iv.setImageResource(C0329R.drawable.album_item_all_tracks);
            tv1.setText(cursor.getString(cursor.getColumnIndexOrThrow("title")));
            tv2.setText(UIHelper.getDescript(context, cursor.getString(cursor.getColumnIndexOrThrow("artist")), cursor.getString(cursor.getColumnIndexOrThrow("album"))));
            view.setEnabled(Arrays.binarySearch(this.mValidTrackIdArr, id) >= 0);
        }

        public void changeCursor(Cursor cursor) {
            if (!(this.mFragment.isActivityWorking() || cursor == null)) {
                cursor.close();
                cursor = null;
            }
            if (cursor != this.mFragment.mQueryCursor) {
                this.mFragment.mQueryCursor = cursor;
                super.changeCursor(cursor);
            }
        }

        public static void startCache() {
            if (sArtistProvider != null) {
                sArtistProvider.setup(true);
            }
            if (sAlbumProvider != null) {
                sAlbumProvider.setup(true);
            }
        }

        public static void quitCache() {
            if (sArtistProvider != null) {
                sArtistProvider.quit(null);
            }
            if (sAlbumProvider != null) {
                sAlbumProvider.quit(null);
            }
        }
    }

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        this.mListView = (ListView) getListView();
        this.mListView.setOnItemClickListener(this);
        if (this.mAdapter == null) {
            this.mAdapter = new QueryListAdapter(getActivity(), this, C0329R.layout.query_item, null, new String[0], new int[0]);
            setListAdapter(this.mAdapter);
        }
        QueryListAdapter.startCache();
    }

    public void onDestroy() {
        if (this.mAdapter != null) {
            setListAdapter(null);
            this.mAdapter = null;
        }
        QueryListAdapter.quitCache();
        super.onDestroy();
    }

    public void setService(IMediaPlaybackService service) {
        this.mServiceConnected = true;
        super.setService(service);
        Intent intent = getActivity().getIntent();
        String action = intent.getAction();
        if ("android.intent.action.VIEW".equals(action)) {
            Uri uri = intent.getData();
            String path = uri.toString();
            if (path.startsWith(Media.EXTERNAL_CONTENT_URI.toString())) {
                ServiceHelper.playAll(getActivity(), new long[]{Long.valueOf(uri.getLastPathSegment()).longValue()}, 0);
                getActivity().finish();
                return;
            } else if (path.startsWith(Albums.EXTERNAL_CONTENT_URI.toString())) {
                i = new Intent(Actions.ACTION_BROWSER);
                i.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_TRACK);
                i.putExtra("album_id", Long.valueOf(uri.getLastPathSegment()));
                startActivity(i);
                getActivity().finish();
                return;
            } else if (path.startsWith(Artists.EXTERNAL_CONTENT_URI.toString())) {
                i = new Intent(Actions.ACTION_BROWSER);
                i.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_ALBUM);
                i.putExtra(Columns.ARTIST_ID, Long.valueOf(uri.getLastPathSegment()));
                startActivity(i);
                getActivity().finish();
                return;
            }
        }
        this.mFilterString = intent.getStringExtra("query");
        if ("android.intent.action.MEDIA_SEARCH".equals(action)) {
            String focus = intent.getStringExtra("android.intent.extra.focus");
            String artist = intent.getStringExtra("android.intent.extra.artist");
            String album = intent.getStringExtra("android.intent.extra.album");
            String title = intent.getStringExtra("android.intent.extra.title");
            if (focus != null) {
                if (focus.startsWith("audio/") && title != null) {
                    this.mFilterString = title;
                } else if (focus.equals("vnd.android.cursor.item/album")) {
                    if (album != null) {
                        this.mFilterString = album;
                        if (artist != null) {
                            this.mFilterString += " " + artist;
                        }
                    }
                } else if (focus.equals("vnd.android.cursor.item/artist") && artist != null) {
                    this.mFilterString = artist;
                }
            }
        }
        launchLoader(true);
    }

    protected CursorAdapter getCursorAdapter() {
        return this.mAdapter;
    }

    protected void handleLoadFinished(int loaderId, Cursor cursor) {
        super.handleLoadFinished(loaderId, cursor);
        if (this.mAdapter != null) {
            this.mAdapter.changeCursor(cursor);
        }
        setTitleBar();
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        if (v.isEnabled()) {
            this.mQueryCursor.moveToPosition(position);
            if (!this.mQueryCursor.isBeforeFirst() && !this.mQueryCursor.isAfterLast()) {
                String selectedType = this.mQueryCursor.getString(this.mQueryCursor.getColumnIndexOrThrow("mime_type"));
                Intent intent;
                if ("artist".equals(selectedType)) {
                    intent = new Intent(Actions.ACTION_BROWSER);
                    intent.addFlags(67108864);
                    intent.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_ALBUM);
                    intent.putExtra(Columns.ARTIST_ID, id);
                    startActivity(intent);
                    return;
                } else if ("album".equals(selectedType)) {
                    intent = new Intent(Actions.ACTION_BROWSER);
                    intent.addFlags(67108864);
                    intent.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_TRACK);
                    intent.putExtra("album_id", id);
                    startActivity(intent);
                    return;
                } else if (position < 0 || id < 0) {
                    Log.e("QueryListFragment", "invalid position/id: " + position + "/" + id);
                    return;
                } else {
                    ServiceHelper.playAll(getActivity(), new long[]{id}, 0);
                    return;
                }
            }
            return;
        }
        if (this.mToast == null) {
            this.mToast = Toast.makeText(getActivity(), C0329R.string.filter_notification, 1);
        }
        this.mToast.show();
    }

    protected MediaLoaderInfo getMediaLoaderInfo() {
        if (!this.mServiceConnected) {
            return null;
        }
        return new MediaLoaderInfo(null, new QueryArgs(MusicApplication.getApplication().getContentResolver(), Uri.parse("content://media/external/audio/search/fancy/" + Uri.encode(this.mFilterString != null ? this.mFilterString : MetaManager.UNKNOWN_STRING)), new String[]{"_id", "mime_type", "artist", "album", "title", "data1", "data2"}, null, null, null, null));
    }

    private void setTitleBar() {
        ActionBar bar = getActivity().getActionBar();
        if (bar != null) {
            String title = getResources().getQuantityString(C0329R.plurals.Nsearch_results, this.mQueryCursor != null ? this.mQueryCursor.getCount() : 0, new Object[]{Integer.valueOf(this.mQueryCursor != null ? this.mQueryCursor.getCount() : 0)});
            if (this.mFilterString != null) {
                title = String.format("%s \"%s\"", new Object[]{title, this.mFilterString});
            }
            bar.setTitle(title);
        }
    }
}
