package com.miui.player.ui.model;

import android.app.Activity;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.DownloadInfoManager;
import com.miui.player.network.MP3Downloader;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.KtvPlaylistCache;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.ui.fragment.AsyncFragment.DataAdapter;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.Utils;
import com.miui.player.vod.ThunderStoneKtvNetwork;
import com.miui.player.vod.ThunderStoneKtvNetwork.MusicInfo;
import com.xiaomi.music.util.NetworkUtil;
import java.lang.ref.WeakReference;

public class OnlineSongAdapter extends DataAdapter<Audio, AudioList> {
    private final Activity mActivity;
    private final OnClickListener mDownloadClick = new C05171();
    private String[] mDownloadedFileSet;
    private boolean mFirstDownloadIcon = true;
    private final HeadViewController mHeadViewController;
    private final LayoutInflater mLayoutInflater;
    private MultiChoiceController<String> mMultiChoiceController;
    private final boolean mShowNumber;
    private final OnClickListener mVodClick = new C05182();

    public interface HeadViewController {
        void updateHeadView(int i);
    }

    class C05171 implements OnClickListener {
        C05171() {
        }

        public void onClick(View v) {
            Object tag = v.getTag();
            if (tag instanceof Integer) {
                v.setEnabled(OnlineSongAdapter.this.download(((Integer) tag).intValue()));
                OnlineSongAdapter.this.notifyDataSetChanged();
            }
        }
    }

    class C05182 implements OnClickListener {
        C05182() {
        }

        public void onClick(View v) {
            if (NetworkUtil.isActive(v.getContext())) {
                Object tag = v.getTag();
                if (tag instanceof Integer) {
                    v.setEnabled(false);
                    OnlineSongAdapter.this.vod(((Integer) tag).intValue());
                    return;
                }
                return;
            }
            UIHelper.toastSafe(C0329R.string.network_error, new Object[0]);
        }
    }

    static class RefreshWhenDownload implements Runnable {
        private final WeakReference<OnlineSongAdapter> mAdapterRef;

        RefreshWhenDownload(OnlineSongAdapter adapter) {
            this.mAdapterRef = new WeakReference(adapter);
        }

        public void run() {
            OnlineSongAdapter adapter = (OnlineSongAdapter) this.mAdapterRef.get();
            if (adapter != null && !adapter.mActivity.isFinishing()) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    private class ViewHolder {
        public final TextView artistNameText;
        public final ImageView downloadIcon;
        public final ImageView favoriteIndicator;
        public final ImageView playIndicator;
        public final TextView trackNameText;
        public final ImageView vodIndicator;

        public ViewHolder(View view) {
            this.playIndicator = (ImageView) view.findViewById(C0329R.id.play_indicator);
            this.favoriteIndicator = (ImageView) view.findViewById(C0329R.id.favorite_indicator);
            this.trackNameText = (TextView) view.findViewById(C0329R.id.primary_text);
            this.artistNameText = (TextView) view.findViewById(C0329R.id.secondary_first_text);
            this.downloadIcon = (ImageView) view.findViewById(C0329R.id.download_status);
            this.vodIndicator = (ImageView) view.findViewById(C0329R.id.vod_indicator);
        }
    }

    public OnlineSongAdapter(Activity activity, MultiChoiceController<String> batchSelection, HeadViewController headViewController, boolean showNumber) {
        this.mActivity = activity;
        this.mLayoutInflater = LayoutInflater.from(activity);
        this.mMultiChoiceController = batchSelection;
        this.mHeadViewController = headViewController;
        this.mShowNumber = showNumber;
        updateDownloadStatus();
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        String trackName;
        View view = convertView;
        if (view == null) {
            view = this.mLayoutInflater.inflate(C0329R.layout.track_list_item, parent, false);
            vh = new ViewHolder(view);
            vh.downloadIcon.setOnClickListener(this.mDownloadClick);
            vh.vodIndicator.setOnClickListener(this.mVodClick);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        vh.vodIndicator.setTag(Integer.valueOf(position));
        Audio item = (Audio) getItem(position);
        if (this.mShowNumber) {
            trackName = view.getResources().getString(C0329R.string.number_format, new Object[]{Integer.valueOf(position + 1), item.getTitle()});
        } else {
            trackName = item.getTitle();
        }
        vh.trackNameText.setText(trackName);
        vh.artistNameText.setText(item.getArtistName());
        boolean isPlayingItem = false;
        boolean isBuffering = false;
        boolean isPlaying = false;
        try {
            IMediaPlaybackService service = ServiceHelper.sService;
            if (service != null) {
                isPlayingItem = item.getId().equals(service.getOnlineId());
                isPlaying = service.isPlaying();
                isBuffering = service.isBuffering();
            }
        } catch (RemoteException e) {
        }
        ImageView iv = vh.playIndicator;
        if (isPlayingItem) {
            iv.setVisibility(0);
            boolean z = isPlaying || isBuffering;
            iv.setSelected(z);
            vh.favoriteIndicator.setVisibility(8);
        } else {
            iv.setVisibility(8);
            if (FavoriteCache.onlineContains(this.mLayoutInflater.getContext(), item.getId())) {
                vh.favoriteIndicator.setVisibility(0);
            } else {
                vh.favoriteIndicator.setVisibility(8);
            }
        }
        iv = vh.downloadIcon;
        iv.setTag(Integer.valueOf(position));
        if (this.mMultiChoiceController != null && this.mMultiChoiceController.bindItemView(view, position)) {
            iv.setVisibility(8);
        } else if (ThunderStoneKtvNetwork.isBinded()) {
            iv.setVisibility(8);
        } else {
            iv.setVisibility(0);
            showUserGuide(iv);
            if (Utils.isExternalStorageMounted()) {
                switch (DownloadInfoManager.getDownloadStatus(view.getContext(), item.getId(), item.getTitle(), item.getArtistName(), this.mDownloadedFileSet)) {
                    case 0:
                        iv.setEnabled(true);
                        break;
                    case 1:
                    case 2:
                    case 3:
                        iv.setEnabled(false);
                        break;
                    default:
                        break;
                }
            }
            iv.setEnabled(false);
        }
        if (ThunderStoneKtvNetwork.isBinded()) {
            vh.playIndicator.setVisibility(8);
            vh.favoriteIndicator.setVisibility(8);
            vh.vodIndicator.setVisibility(0);
            vh.vodIndicator.setSelected(KtvPlaylistCache.vodSuccessContains(this.mActivity, -1, item.getId()));
            vh.vodIndicator.setEnabled(!KtvPlaylistCache.vodingContains(this.mActivity, -1, item.getId()));
        } else {
            vh.vodIndicator.setVisibility(8);
        }
        return view;
    }

    public void updateDownloadStatus() {
        this.mDownloadedFileSet = MetaManager.getAllSortedDownloadedMP3Names();
    }

    boolean download(int position) {
        Audio item = (Audio) getItem(position);
        if (item != null && DownloadInfoManager.getDownloadStatus(this.mActivity, item.mOutline.mId, item.mOutline.mTitle, item.getArtistName(), this.mDownloadedFileSet) == 0) {
            return MP3Downloader.startOnUIThread(this.mActivity, item, new RefreshWhenDownload(this));
        }
        return false;
    }

    void vod(int position) {
        Audio item = (Audio) getItem(position);
        if (item != null) {
            ThunderStoneKtvNetwork.songVod(this.mActivity, new MusicInfo(item.mOutline.mTitle, item.getArtistName(), null, -1, item));
        }
    }

    public void onDataChanged() {
        if (this.mData != null) {
            this.mHeadViewController.updateHeadView(((AudioList) this.mData).size());
        }
    }

    private void showUserGuide(View anchor) {
        if (this.mFirstDownloadIcon) {
            this.mFirstDownloadIcon = false;
            View view = anchor;
            UIHelper.showUserGuide(this.mActivity, view, 0, this.mActivity.getResources().getInteger(C0329R.integer.pay_service_guide_download_offset_y), PreferenceCache.PREF_PAY_SERVICE_GUIDE_DOWNLOAD_TWO, C0329R.string.pay_service_guide_dowload);
        }
    }
}
