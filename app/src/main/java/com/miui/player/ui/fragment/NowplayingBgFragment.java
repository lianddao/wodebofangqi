package com.miui.player.ui.fragment;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.Out;
import com.miui.player.meta.AlbumManager;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.controller.AlbumBackground;
import com.miui.player.util.PreferenceCache;

public class NowplayingBgFragment extends Fragment {
    AlbumBackground mImageAlbum;
    private int mPageCount;
    private IMediaPlaybackService mService;
    private final BroadcastReceiver mServiceListener = new C05002();
    private View mTotalMask;
    AsyncTask<Void, Void, Bitmap> mUpdateTask = null;
    int mUpdateVersion = -1;

    class C05002 extends BroadcastReceiver {
        C05002() {
        }

        public void onReceive(Context context, Intent intent) {
            if (Out.STATUS_META_CHANGED.equals(intent.getAction())) {
                String extra = intent.getStringExtra(Out.KEY_OTHER);
                if (Out.META_CHANGED_ALBUM.equals(extra) || Out.META_CHANGED_TRACK.equals(extra)) {
                    NowplayingBgFragment.this.update();
                }
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
        return inflater.inflate(C0329R.layout.nowplaying_bg_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        this.mImageAlbum = AlbumBackground.createByType(view, AlbumBackground.TYPE_VIDEO_LARGE);
        this.mTotalMask = view.findViewById(C0329R.id.total_mask);
    }

    public void onResume() {
        super.onResume();
        this.mImageAlbum.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Out.STATUS_META_CHANGED);
        getActivity().registerReceiver(this.mServiceListener, filter);
        update();
    }

    public void onPause() {
        UIHelper.unregistBroadcastReceiverSafe(getActivity(), this.mServiceListener);
        this.mImageAlbum.onPause();
        if (this.mUpdateTask != null) {
            this.mUpdateTask.cancel(true);
            this.mUpdateTask = null;
        }
        super.onPause();
    }

    public void onDestroy() {
        this.mImageAlbum.onDestroy();
        super.onDestroy();
    }

    public void setPageCount(int pageCount) {
        this.mPageCount = pageCount;
    }

    public void setService(IMediaPlaybackService service) {
        this.mService = service;
        update();
    }

    void update() {
        final IMediaPlaybackService service = this.mService;
        if (service != null && isResumed()) {
            try {
                final int updateVersion = service.getUpdateVersion();
                if (this.mUpdateVersion == updateVersion) {
                    return;
                }
                if (PreferenceCache.getPrefAsBoolean(getActivity(), PreferenceCache.PREF_DISPLAY_ALBUM)) {
                    if (this.mUpdateTask != null) {
                        this.mUpdateTask.cancel(true);
                    }
                    this.mUpdateTask = new AsyncTask<Void, Void, Bitmap>() {
                        protected Bitmap doInBackground(Void... params) {
                            try {
                                return AlbumManager.getDisplayedAlbum(NowplayingBgFragment.this.getActivity(), service.getAlbumId(), service.getAlbumName(), service.getArtistName(), true, NowplayingBgFragment.this.getAlbumViewWidth(), NowplayingBgFragment.this.getAlbumViewHeight(), false);
                            } catch (RemoteException e) {
                                return null;
                            }
                        }

                        protected void onPostExecute(Bitmap result) {
                            super.onPostExecute(result);
                            NowplayingBgFragment.this.mUpdateVersion = updateVersion;
                            NowplayingBgFragment.this.mImageAlbum.setBitmap(result);
                            NowplayingBgFragment.this.mUpdateTask = null;
                        }
                    };
                    this.mUpdateTask.execute(new Void[0]);
                    return;
                }
                this.mImageAlbum.setBitmap(null);
            } catch (RemoteException e) {
            }
        }
    }

    public void setMaskAlpha(float alpha) {
        UIHelper.setViewAlpha(this.mTotalMask, alpha);
    }

    public void setPostion(int position) {
        if (this.mPageCount > 1) {
            this.mImageAlbum.setTranslationX(((float) (-position)) * ((((float) getAlbumViewWidth()) - ((float) getViewWidth())) / ((float) (this.mPageCount - 1))));
        }
    }

    public void scrollX(int from, int to, float percent) {
        if (this.mPageCount > 1) {
            float x;
            float deltaWidth = (((float) getAlbumViewWidth()) - ((float) getViewWidth())) / ((float) (this.mPageCount - 1));
            if (from < to) {
                x = (((float) (-from)) - percent) * deltaWidth;
            } else {
                x = (((float) (-from)) + percent) * deltaWidth;
            }
            this.mImageAlbum.setTranslationX(x);
        }
    }

    public int getViewWidth() {
        return getActivity().getWindow().getWindowManager().getDefaultDisplay().getRawWidth();
    }

    public int getAlbumViewWidth() {
        return this.mImageAlbum != null ? this.mImageAlbum.getWidth() : 0;
    }

    public int getAlbumViewHeight() {
        return this.mImageAlbum != null ? this.mImageAlbum.getHeight() : 0;
    }
}
