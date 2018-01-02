package com.miui.player.ui.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.SortableListView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.DownloadInfoManager;
import com.miui.player.network.MP3Downloader;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.KtvPlaylistCache;
import com.miui.player.provider.PlayerProvider;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.MediaPlaybackActivity;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.util.FileNameUtils;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.SectionCursor;
import com.miui.player.util.SectionCursor.CursorConverter;
import com.miui.player.util.SectionCursor.ElementConverter;
import com.miui.player.vod.ThunderStoneKtvNetwork;
import com.miui.player.vod.ThunderStoneKtvNetwork.MusicInfo;
import com.xiaomi.music.util.NetworkUtil;
import java.lang.ref.WeakReference;
import miui.cache.RequestManager;
import miui.cache.RequestManager.Request;
import miui.widget.AlphabetFastIndexer;

public class TrackListAdapter extends SectionCursorAdapter {
    private static final int ITEM_PADDING_RIGHT_WITH_FASTINDEXER = MusicApplication.getApplication().getResources().getDrawable(C0329R.drawable.alphabet_indexer_bg).getIntrinsicWidth();
    public static final String[] MEMBER_COLUMNS = new String[]{"_id", "title", "_data", "album", "artist", "duration", "audio_id", "mi_online_id", "provider_id", "play_order"};
    public static final String[] NOWPLAYING_COLUMNS = new String[]{"_id", "title", "_data", "album", "artist", "duration", "album_id", "mi_online_id"};
    public static final int NOWPLAYING_COLUMNS_COMMON_LEN = 6;
    public static final int NOWPLAYING_COLUMNS_LOCAL_LEN = 1;
    public static final int NOWPLAYING_COLUMNS_ONLINE_LEN = 1;
    public static final String[] TRACK_COLUMNS = new String[]{"_id", "title", "_data", "album", "artist", "duration", "track"};
    public static final RequestManager<String, Long, Integer> sDurtionProvider = RequestManager.create(100, Long.valueOf(0));
    private final Activity mActivity;
    int mAlbumIdx;
    int mArtistIdx;
    int mAudioIdIdx;
    int mDataIdx;
    private final OnClickListener mDownloadClick = new C05191();
    private String[] mDownloadedFileSet;
    int mDurationIdx;
    private final AlphabetFastIndexer mFastIndexer;
    private boolean mFirstDownloadIcon = true;
    final boolean mHasTrackNumber;
    final boolean mIsLandscape;
    final boolean mIsNowPlaying;
    final int mLeftMargin;
    int mMemberIdIdx;
    private final MultiChoiceController<Long> mMultiChoiceController;
    int mOnlineIdIdx;
    final boolean mSortable;
    private final SortableListView mSortableListView;
    int mTitleIdx;
    private final TrackBrowser mTrackBrowser;
    int mTrackNumIdx;
    private final OnClickListener mVodClick = new C05202();

    public interface TrackBrowser {
        boolean isEditing();

        boolean isWorking();

        boolean swapCursor(Cursor cursor);
    }

    class C05191 implements OnClickListener {
        C05191() {
        }

        public void onClick(View v) {
            Object tag = v.getTag();
            if (tag instanceof Integer) {
                v.setEnabled(TrackListAdapter.this.download(((Integer) tag).intValue()));
                TrackListAdapter.this.notifyDataSetChanged();
            }
        }
    }

    class C05202 implements OnClickListener {
        C05202() {
        }

        public void onClick(View v) {
            if (NetworkUtil.isActive(v.getContext())) {
                Object tag = v.getTag();
                if (tag instanceof Integer) {
                    v.setEnabled(false);
                    TrackListAdapter.this.vod(((Integer) tag).intValue());
                    return;
                }
                return;
            }
            UIHelper.toastSafe(C0329R.string.network_error, new Object[0]);
        }
    }

    public static class DurtionRequest implements Request<String, Long, Integer> {
        TrackListAdapter mAdapter;
        Context mContext;
        String mKey;
        Integer mRemoveKey;
        WeakReference<TextView> mTextViewRef;
        String mTrackPath;

        public DurtionRequest(Context context, TextView textView, String trackPath) {
            this.mContext = context;
            this.mTrackPath = trackPath;
            this.mTextViewRef = new WeakReference(textView);
            this.mKey = asKey(trackPath);
            textView.setTag(getKey());
            this.mRemoveKey = Integer.valueOf(System.identityHashCode(textView));
        }

        public String getKey() {
            return this.mKey;
        }

        public Long computAsync() {
            return Long.valueOf(UIHelper.getFileDuration(this.mTrackPath));
        }

        public void onCompleted(Long value, boolean finalValue) {
            TextView tv = (TextView) this.mTextViewRef.get();
            if (value.longValue() > 0 && tv != null) {
                String key = getKey();
                String durtionStr = UIHelper.makeTimeString(this.mContext, value.longValue());
                if (key != null && key.equals(tv.getTag()) && !durtionStr.equals(tv.getText())) {
                    tv.setText(durtionStr);
                }
            }
        }

        public boolean needCache() {
            return true;
        }

        public boolean isRemovable() {
            TextView view = (TextView) this.mTextViewRef.get();
            if (view != null && getKey().equals(view.getTag())) {
                return false;
            }
            return true;
        }

        public Integer getRemoveKey() {
            return this.mRemoveKey;
        }

        public String asKey(String path) {
            return path;
        }

        public void onRemoved() {
        }
    }

    static class MemberElementConverter implements ElementConverter {
        MemberElementConverter() {
        }

        public boolean parse(Cursor cursor, Object[] colVals) {
            colVals[0] = Integer.valueOf(cursor.getInt(0));
            colVals[1] = cursor.getString(1);
            colVals[2] = cursor.getString(2);
            colVals[3] = cursor.getString(3);
            colVals[4] = cursor.getString(4);
            colVals[5] = Integer.valueOf(cursor.getInt(5));
            colVals[6] = Integer.valueOf(cursor.getInt(6));
            colVals[7] = Integer.valueOf(cursor.getInt(7));
            colVals[8] = Integer.valueOf(cursor.getInt(8));
            return true;
        }
    }

    static class RefreshWhenDownload implements Runnable {
        private final WeakReference<TrackListAdapter> mAdapterRef;

        RefreshWhenDownload(TrackListAdapter adapter) {
            this.mAdapterRef = new WeakReference(adapter);
        }

        public void run() {
            TrackListAdapter adapter = (TrackListAdapter) this.mAdapterRef.get();
            if (adapter != null && adapter.mTrackBrowser.isWorking()) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    static class TrackElementConverter implements ElementConverter {
        TrackElementConverter() {
        }

        public boolean parse(Cursor cursor, Object[] colVals) {
            colVals[0] = Integer.valueOf(cursor.getInt(0));
            colVals[1] = cursor.getString(1);
            colVals[2] = cursor.getString(2);
            colVals[3] = cursor.getString(3);
            colVals[4] = cursor.getString(4);
            colVals[5] = Integer.valueOf(cursor.getInt(5));
            colVals[6] = Integer.valueOf(cursor.getInt(6));
            return true;
        }
    }

    static class ViewHolder {
        TextView artistTextItem;
        ImageView downloadIcon;
        TextView durationTextItem;
        ImageView favoriteIndicator;
        ImageView listTextSeparator;
        ImageView playIndicator;
        TextView primaryItem;
        ImageView sortButton;
        ImageView vodIndicator;

        ViewHolder() {
        }
    }

    static {
        sDurtionProvider.setup(true);
    }

    public static CursorConverter createCursorConverter(String[] columns) {
        ElementConverter ec = null;
        if (columns.length == TRACK_COLUMNS.length) {
            ec = new TrackElementConverter();
        } else if (columns.length == MEMBER_COLUMNS.length) {
            ec = new MemberElementConverter();
        }
        return ec != null ? SectionCursor.createCursorConverter(ec, 1) : null;
    }

    public TrackListAdapter(Activity activity, TrackBrowser browser, int layout, Cursor cursor, AlphabetFastIndexer fastIndexer, SortableListView slv, MultiChoiceController<Long> controller, boolean isNowplaying, boolean isLandscape, boolean hasTrackNumber, boolean sortable, int leftMargin) {
        super(activity, layout, cursor, fastIndexer, "title");
        this.mActivity = activity;
        this.mContext = activity;
        getColumnIndices(cursor);
        this.mFastIndexer = fastIndexer;
        this.mTrackBrowser = browser;
        this.mSortableListView = slv;
        this.mMultiChoiceController = controller;
        this.mIsNowPlaying = isNowplaying;
        this.mIsLandscape = isLandscape;
        this.mHasTrackNumber = hasTrackNumber;
        this.mSortable = sortable;
        this.mLeftMargin = leftMargin;
        updateDownloadStatus();
    }

    private void getColumnIndices(Cursor cursor) {
        if (cursor != null) {
            this.mTitleIdx = cursor.getColumnIndexOrThrow("title");
            this.mArtistIdx = cursor.getColumnIndexOrThrow("artist");
            this.mAlbumIdx = cursor.getColumnIndexOrThrow("album");
            this.mDurationIdx = cursor.getColumnIndexOrThrow("duration");
            this.mDataIdx = cursor.getColumnIndexOrThrow("_data");
            try {
                this.mAudioIdIdx = cursor.getColumnIndexOrThrow("audio_id");
            } catch (IllegalArgumentException e) {
                this.mAudioIdIdx = cursor.getColumnIndexOrThrow("_id");
            }
            this.mMemberIdIdx = cursor.getColumnIndexOrThrow("_id");
            this.mOnlineIdIdx = cursor.getColumnIndex("mi_online_id");
            this.mTrackNumIdx = cursor.getColumnIndex("track");
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = super.newView(context, cursor, parent);
        setViewHolder(v);
        return v;
    }

    public ViewHolder setViewHolder(View v) {
        ViewHolder vh = new ViewHolder();
        ImageView iv = (ImageView) v.findViewById(C0329R.id.adjust_button);
        vh.sortButton = iv;
        if (!(iv == null || this.mSortableListView == null || !this.mSortable)) {
            iv.setOnTouchListener(this.mSortableListView.getListenerForStartingSort());
        }
        vh.primaryItem = (TextView) v.findViewById(C0329R.id.primary_text);
        if (this.mIsLandscape) {
            Resources resource = v.getContext().getResources();
            ColorStateList csl = resource.getColorStateList(C0329R.color.land_list_item_text_color);
            if (csl != null) {
                vh.primaryItem.setTextColor(csl);
            }
            vh.primaryItem.setTextSize(0, resource.getDimension(C0329R.dimen.land_list_item_text_size));
        }
        vh.durationTextItem = (TextView) v.findViewById(C0329R.id.secondary_first_text);
        vh.listTextSeparator = (ImageView) v.findViewById(C0329R.id.list_text_separator);
        vh.artistTextItem = (TextView) v.findViewById(C0329R.id.secondary_second_text);
        vh.downloadIcon = (ImageView) v.findViewById(C0329R.id.download_status);
        vh.downloadIcon.setOnClickListener(this.mDownloadClick);
        vh.playIndicator = (ImageView) v.findViewById(C0329R.id.play_indicator);
        vh.favoriteIndicator = (ImageView) v.findViewById(C0329R.id.favorite_indicator);
        vh.vodIndicator = (ImageView) v.findViewById(C0329R.id.vod_indicator);
        vh.vodIndicator.setOnClickListener(this.mVodClick);
        v.setTag(vh);
        return vh;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        String onlineId;
        super.bindView(view, context, cursor);
        if (!(this.mFastIndexer == null || view.getPaddingRight() == ITEM_PADDING_RIGHT_WITH_FASTINDEXER)) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), ITEM_PADDING_RIGHT_WITH_FASTINDEXER, view.getPaddingBottom());
        }
        String title = cursor.getString(this.mTitleIdx);
        String artist = cursor.getString(this.mArtistIdx);
        long duration = (long) cursor.getInt(this.mDurationIdx);
        String trackDuration = UIHelper.makeTimeString(this.mContext, duration);
        ViewHolder vh = (ViewHolder) view.getTag();
        if (this.mLeftMargin >= 0) {
            View v = view.findViewById(C0329R.id.text_wrap);
            MarginLayoutParams marginParams = (MarginLayoutParams) v.getLayoutParams();
            marginParams.leftMargin = this.mLeftMargin;
            v.setLayoutParams(marginParams);
        }
        vh.primaryItem.setText(title);
        if (this.mHasTrackNumber || this.mIsLandscape || TextUtils.isEmpty(trackDuration)) {
            vh.durationTextItem.setVisibility(8);
            vh.listTextSeparator.setVisibility(8);
            vh.artistTextItem.setVisibility(8);
        } else {
            vh.durationTextItem.setVisibility(0);
            vh.durationTextItem.setText(trackDuration);
            vh.listTextSeparator.setVisibility(0);
            vh.artistTextItem.setVisibility(0);
            vh.artistTextItem.setText(MetaManager.getLocaleArtistName(context, artist));
        }
        if (duration == 0) {
            String path = cursor.getString(this.mDataIdx);
            if (needGetDurtion(path)) {
                sDurtionProvider.request(new DurtionRequest(context.getApplicationContext(), vh.durationTextItem, path));
            }
        }
        long audioId = cursor.getLong(this.mAudioIdIdx);
        int position = cursor.getPosition();
        if (this.mOnlineIdIdx >= 0) {
            onlineId = cursor.getString(this.mOnlineIdIdx);
        } else {
            onlineId = null;
        }
        ImageView iv = vh.playIndicator;
        long nowplayingId;
        if (this.mIsNowPlaying) {
            nowplayingId = (long) ServiceHelper.getQueuePosition();
        } else {
            nowplayingId = ServiceHelper.getCurrentAudioId();
        }
        MultiChoiceController<Long> mcc = this.mMultiChoiceController;
        boolean isEditing = mcc != null && mcc.bindItemView(view, position);
        if (isEditing || (!(this.mIsNowPlaying && ((long) position) == nowplayingId) && ((this.mIsNowPlaying || audioId != nowplayingId) && (onlineId == null || !onlineId.equals(ServiceHelper.getCurrentOnlineId()))))) {
            iv.setVisibility(8);
            if (FavoriteCache.contains(context, audioId, onlineId)) {
                vh.favoriteIndicator.setVisibility(0);
            } else {
                vh.favoriteIndicator.setVisibility(8);
            }
        } else {
            iv.setVisibility(0);
            iv.setSelected(ServiceHelper.isPlaying());
            vh.favoriteIndicator.setVisibility(8);
        }
        vh.vodIndicator.setTag(Integer.valueOf(position));
        if (ThunderStoneKtvNetwork.isBinded()) {
            vh.playIndicator.setVisibility(8);
            vh.favoriteIndicator.setVisibility(8);
            vh.vodIndicator.setVisibility(0);
            vh.vodIndicator.setSelected(KtvPlaylistCache.vodSuccessContains(context, audioId, onlineId));
            vh.vodIndicator.setEnabled(!KtvPlaylistCache.vodingContains(context, audioId, onlineId));
        } else {
            vh.vodIndicator.setVisibility(8);
        }
        if (vh.sortButton != null) {
            vh.sortButton.setVisibility(isEditing ? 0 : 8);
        }
        iv = vh.downloadIcon;
        iv.setTag(Integer.valueOf(position));
        if (isEditing || ThunderStoneKtvNetwork.isBinded()) {
            iv.setVisibility(8);
        } else if (PlayerProvider.isOnlineAudio(audioId)) {
            switch (DownloadInfoManager.getDownloadStatus(this.mContext, onlineId, title, MetaManager.getRawName(artist), this.mDownloadedFileSet)) {
                case 0:
                    iv.setVisibility(0);
                    iv.setEnabled(true);
                    showUserGuide(iv);
                    return;
                case 1:
                case 2:
                    iv.setVisibility(0);
                    iv.setEnabled(false);
                    return;
                case 3:
                    iv.setVisibility(8);
                    return;
                default:
                    return;
            }
        } else {
            iv.setVisibility(8);
        }
    }

    public void changeCursor(Cursor cursor) {
        if (!(this.mTrackBrowser.isWorking() || cursor == null)) {
            cursor.close();
            cursor = null;
        }
        if (this.mTrackBrowser.swapCursor(cursor)) {
            getColumnIndices(cursor);
        }
        super.changeCursor(cursor);
    }

    public void updateDownloadStatus() {
        this.mDownloadedFileSet = MetaManager.getAllSortedDownloadedMP3Names();
    }

    boolean download(int position) {
        if (this.mOnlineIdIdx < 0) {
            return false;
        }
        Cursor cursor = (Cursor) getItem(position);
        if (cursor == null) {
            return false;
        }
        String onlineId = cursor.getString(this.mOnlineIdIdx);
        String tr = cursor.getString(this.mTitleIdx);
        String ar = cursor.getString(this.mArtistIdx);
        if (DownloadInfoManager.getDownloadStatus(this.mContext, onlineId, tr, ar, this.mDownloadedFileSet) != 0) {
            return false;
        }
        MP3Downloader.startOnUIThread(this.mActivity, OnlineMusicProxy.newAudio(cursor.getString(this.mOnlineIdIdx), tr, ar, cursor.getString(this.mAlbumIdx)), new RefreshWhenDownload(this));
        return true;
    }

    void vod(int position) {
        Cursor cursor = (Cursor) getItem(position);
        if (cursor != null) {
            String onlineId;
            Audio onlineAudio;
            long audioId = cursor.getLong(this.mAudioIdIdx);
            if (this.mOnlineIdIdx >= 0) {
                onlineId = cursor.getString(this.mOnlineIdIdx);
            } else {
                onlineId = null;
            }
            String title = cursor.getString(this.mTitleIdx);
            String artist = cursor.getString(this.mArtistIdx);
            if (onlineId != null) {
                onlineAudio = new Audio(onlineId, title);
            } else {
                onlineAudio = null;
            }
            ThunderStoneKtvNetwork.songVod(this.mContext, new MusicInfo(title, artist, null, audioId, onlineAudio));
        }
    }

    private static boolean needGetDurtion(String filePath) {
        String fileExtenstion = FileNameUtils.getFileExtension(filePath);
        for (String ext : new String[]{"wav", "ape"}) {
            if (ext.equals(fileExtenstion)) {
                return true;
            }
        }
        return false;
    }

    private void showUserGuide(View anchor) {
        if ((!(this.mActivity instanceof MediaPlaybackActivity) || this.mActivity.isTrackListFragmentVisible()) && this.mFirstDownloadIcon) {
            this.mFirstDownloadIcon = false;
            View view = anchor;
            UIHelper.showUserGuide(this.mActivity, view, 0, this.mActivity.getResources().getInteger(C0329R.integer.pay_service_guide_download_offset_y), PreferenceCache.PREF_PAY_SERVICE_GUIDE_DOWNLOAD_THREE, C0329R.string.pay_service_guide_dowload);
        }
    }
}
