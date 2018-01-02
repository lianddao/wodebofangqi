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
import android.provider.MediaStore.Video.Thumbnails;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AlphabetIndexer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ViewVideo;
import com.songbirdnest.util.MediaUtils;

public class VideoListingView extends BaseContentBrowserView {
    private static final String VIEW_CATEGORY = "video";
    private VideoListAdapter mAdapter;
    private Cursor mFilterCursor;
    private View mFooterView;
    private Handler mHandler = new C04101();
    private LayoutInflater mInflater;
    private boolean mInitialized = false;
    private int mRowHeight = 50;
    private SearchListItem mSearchBox;
    private Cursor mVideoCursor;
    private ListView mVideoList;

    class C04101 extends Handler {
        C04101() {
        }

        public void handleMessage(Message msg) {
            ((ViewWrapper) msg.obj).tryClear();
        }
    }

    class C04112 implements TextWatcher {
        C04112() {
        }

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (count == 0) {
                Cursor c = VideoListingView.this.mAdapter.swapCursor(VideoListingView.this.mVideoCursor);
                if (c != null && !c.isClosed()) {
                    c.close();
                    return;
                }
                return;
            }
            String[] proj = new String[]{"_id", "title", "duration", "_data"};
            String selection = "title LIKE ? ";
            String[] selectionArgs = new String[]{"%" + VideoListingView.this.mSearchBox.getSearchBox().getText().toString() + "%"};
            if (!(VideoListingView.this.mFilterCursor == null || VideoListingView.this.mFilterCursor.isClosed())) {
                VideoListingView.this.mFilterCursor.close();
            }
            VideoListingView.this.mFilterCursor = MediaUtils.getMediaStoreMergeCursorForVideo(VideoListingView.this.mActivity, proj, "title LIKE ? ", selectionArgs, false);
            VideoListingView.this.mAdapter.swapCursor(VideoListingView.this.mFilterCursor);
        }
    }

    class C04123 implements OnEditorActionListener {
        C04123() {
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            ((InputMethodManager) VideoListingView.this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(VideoListingView.this.mSearchBox.getSearchBox().getWindowToken(), 0);
            return false;
        }
    }

    class C04134 implements OnClickListener {
        C04134() {
        }

        public void onClick(View v) {
            if (VideoListingView.this.mSearchBox.getSearchBox().getText().toString().equals("")) {
                Utils.hideKeyboard(VideoListingView.this.mActivity, VideoListingView.this.mSearchBox.getSearchBox().getWindowToken());
                Utils.loseFocus(VideoListingView.this.mSearchBox.getClearButton());
                return;
            }
            VideoListingView.this.mSearchBox.getSearchBox().setText("");
        }
    }

    class C04145 implements OnItemClickListener {
        C04145() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
            Intent videoPlay = new Intent(VideoListingView.this.mActivity, ViewVideo.class);
            videoPlay.putExtra("videofilename", (Integer) ((ViewWrapper) view.getTag()).getPlayIcon().getTag());
            videoPlay.putExtra("playOverride", true);
            try {
                VideoListingView.this.mService.pause();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            VideoListingView.this.mVideoCursor.moveToFirst();
            int column = VideoListingView.this.mVideoCursor.getColumnIndex("_id");
            int[] idArray = new int[VideoListingView.this.mVideoCursor.getCount()];
            idArray[0] = VideoListingView.this.mVideoCursor.getInt(column);
            int i = 1;
            while (VideoListingView.this.mVideoCursor.moveToNext()) {
                idArray[i] = VideoListingView.this.mVideoCursor.getInt(column);
                i++;
            }
            videoPlay.putExtra("idList", idArray);
            VideoListingView.this.mActivity.startActivity(videoPlay);
        }
    }

    class C04156 implements OnScrollListener {
        C04156() {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (visibleItemCount != 0) {
                if (VideoListingView.this.mVideoList.getFooterViewsCount() > 0 && visibleItemCount == totalItemCount) {
                    VideoListingView.this.mVideoList.removeFooterView(VideoListingView.this.mFooterView);
                } else if (VideoListingView.this.mVideoList.getFooterViewsCount() == 0 && visibleItemCount < totalItemCount) {
                    VideoListingView.this.mVideoList.addFooterView(VideoListingView.this.mFooterView);
                }
            }
        }
    }

    class VideoListAdapter extends SimpleCursorAdapter implements SectionIndexer {
        AlphabetIndexer mAlphaIndexer;
        Resources mResources;

        class ViewWrapper {
            View base;
            TextView duration = null;
            ImageView playIcon = null;
            ImageView thumb = null;
            TextView title = null;
            String viewType;

            public ViewWrapper(View base) {
                this.base = base;
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

            public void setVisible(int inSetting) {
                getThumb().setVisibility(inSetting);
            }

            public void tryClear() {
                if (getPlayIcon().getHeight() > 0) {
                    VideoListingView.this.mRowHeight = Utils.calculateAlbumArt(getPlayIcon().getHeight());
                    setVisible(0);
                    return;
                }
                setVisible(4);
                Message msg = new Message();
                msg.obj = this;
                VideoListingView.this.mHandler.sendMessageDelayed(msg, 100);
            }
        }

        public VideoListAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
            super(context, layout, c, from, to, 0);
            this.mAlphaIndexer = new AlphabetIndexer(c, c.getColumnIndex("title"), "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            this.mResources = context.getResources();
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
            Cursor c = getCursor();
            c.moveToPosition(position);
            if (row == null || row.getTag().getClass() != ViewWrapper.class) {
                row = VideoListingView.this.mInflater.inflate(C0116R.layout.video_detail, null);
                wrapper = new ViewWrapper(row);
                row.setTag(wrapper);
            } else {
                wrapper = (ViewWrapper) row.getTag();
            }
            VideoListingView.this.populateVideoViewInfo(wrapper, c);
            return row;
        }

        public Cursor swapCursor(Cursor aCursor) {
            this.mAlphaIndexer.setCursor(aCursor);
            return super.swapCursor(aCursor);
        }
    }

    public VideoListingView(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_VIDEO_LIST);
        setViewCategory(VIEW_CATEGORY);
        setHeaderViewText(this.mActivity.getString(C0116R.string.video_header));
        setViewAnalyticsUri(Analytics.EVENT_VIDEO_LISTING);
        this.mInflater = LayoutInflater.from(this.mActivity);
    }

    private void initVideoListingView() {
        if (this.mInitialized) {
            openCursors();
            this.mAdapter.swapCursor(this.mVideoCursor);
            return;
        }
        openCursors();
        this.mVideoList = (ListView) this.mView.findViewById(C0116R.id.video_details_list);
        this.mVideoList.setFastScrollEnabled(true);
        this.mAdapter = new VideoListAdapter(this.mActivity, C0116R.layout.video_detail, this.mVideoCursor, new String[]{"title"}, new int[]{C0116R.id.video_detail_title});
        this.mFooterView = this.mInflater.inflate(C0116R.layout.list_footer_view, null);
        this.mVideoList.addFooterView(this.mFooterView);
        this.mSearchBox = new SearchListItem(this.mActivity);
        this.mVideoList.addHeaderView(this.mSearchBox.getView());
        this.mSearchBox.getSearchBox().addTextChangedListener(new C04112());
        this.mSearchBox.getSearchBox().setOnEditorActionListener(new C04123());
        this.mSearchBox.getClearButton().setOnClickListener(new C04134());
        this.mVideoList.setOnItemClickListener(new C04145());
        this.mVideoList.setOnScrollListener(new C04156());
        this.mVideoList.setAdapter(this.mAdapter);
        this.mInitialized = true;
    }

    private void populateVideoViewInfo(ViewWrapper aWrapper, final Cursor aCursor) {
        aWrapper.getTitle().setText(aCursor.getString(aCursor.getColumnIndexOrThrow("title")));
        aWrapper.getDuration().setText(Utils.calculateTimeStamp(aCursor.getInt(aCursor.getColumnIndexOrThrow("duration"))));
        Bitmap thumbCursor = Thumbnails.getThumbnail(this.mActivity.getContentResolver(), (long) aCursor.getInt(aCursor.getColumnIndex("_id")), 1, null);
        if (aWrapper.getPlayIcon().getHeight() > 0) {
            this.mRowHeight = Utils.calculateAlbumArt(aWrapper.getPlayIcon().getHeight());
            aWrapper.setVisible(0);
        } else {
            aWrapper.setVisible(4);
            Message message = new Message();
            message.obj = aWrapper;
            this.mHandler.sendMessage(message);
        }
        if (thumbCursor == null) {
            thumbCursor = BitmapFactory.decodeResource(this.mInflater.getContext().getResources(), C0116R.drawable.generic_album_small);
        }
        aWrapper.getThumb().setImageBitmap(Bitmap.createScaledBitmap(thumbCursor, this.mRowHeight, this.mRowHeight, true));
        aWrapper.getPlayIcon().setTag(Integer.valueOf(aCursor.getInt(aCursor.getColumnIndexOrThrow("_id"))));
        aWrapper.getPlayIcon().setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent videoPlay = new Intent(VideoListingView.this.mActivity, ViewVideo.class);
                videoPlay.putExtra("videofilename", (Integer) v.getTag());
                try {
                    VideoListingView.this.mService.pause();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                aCursor.moveToFirst();
                int column = aCursor.getColumnIndex("_id");
                int[] idArray = new int[aCursor.getCount()];
                idArray[0] = aCursor.getInt(column);
                int i = 1;
                while (aCursor.moveToNext()) {
                    idArray[i] = aCursor.getInt(column);
                    i++;
                }
                videoPlay.putExtra("idList", idArray);
                videoPlay.putExtra("playOverride", true);
                VideoListingView.this.mActivity.startActivity(videoPlay);
            }
        });
    }

    public View getVideoList() {
        return this.mVideoList;
    }

    public void onResume() {
        super.onResume();
        initVideoListingView();
    }

    public void onStop() {
        super.onStop();
        this.mAdapter.swapCursor(null);
        closeCursors();
    }

    private void openCursors() {
        this.mVideoCursor = MediaUtils.getMediaStoreMergeCursorForVideo(this.mActivity, new String[]{"_id", "title", "duration", "_data"}, false);
    }

    private void closeCursors() {
        try {
            if (!(this.mFilterCursor == null || this.mFilterCursor.isClosed())) {
                this.mFilterCursor.close();
            }
            if (!(this.mVideoCursor == null || this.mVideoCursor.isClosed())) {
                this.mVideoCursor.close();
            }
        } catch (Exception e) {
        }
        this.mFilterCursor = null;
        this.mVideoCursor = null;
    }
}
