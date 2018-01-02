package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.friends.ArtistPhotoCache;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.view.adapter.AbstractSoundboardAdapter;
import com.songbirdnest.mediaplayer.view.adapter.ArtistFeedAdapter;
import com.songbirdnest.mediaplayer.view.adapter.ArtistFeedRetriever;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter.ItemDelegate;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter.SystemDelegate;
import com.songbirdnest.mediaplayer.view.adapter.FollowDialogWrapper;
import com.songbirdnest.mediaplayer.view.adapter.FollowDialogWrapper.DisplayItems;
import com.songbirdnest.mediaplayer.view.adapter.MosaicBackendImpl.ImageUpdate;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.ArtistBiography;
import com.songbirdnest.soundboard.data.ArtistInfo;
import com.songbirdnest.soundboard.data.CollectionImage;
import com.songbirdnest.soundboard.data.CollectionImage.STATUS;
import com.songbirdnest.soundboard.task.ReauthorizeSoundboard;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamUtils;
import com.songbirdnest.util.ImageDownloadRunnable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MosaicArtistFeed extends BaseContentBrowserView implements SystemDelegate {
    protected static final String VIEW_CATEGORY = "mosaic";
    protected String TAG = getClass().getSimpleName();
    private String aArtistName;
    String aSoundboardID;
    ImageView aView;
    private final TextView artistBioView;
    protected boolean artistChanged = true;
    private final View bioViewScroll;
    private ArtistFeedRetriever feedRetriever;
    private boolean following;
    private AbstractSoundboardAdapter mAdapter;
    String mArtistID;
    protected int mArtistInfoLastPosition = 0;
    protected TextView mArtistInfoTab;
    protected ExecutorService mDownloadExecutor;
    protected int mFeedLastPosition = 0;
    protected TextView mFeedTab;
    Button mFollowAction;
    ScheduledExecutorService mFutureCheck;
    ScheduledFuture<?> mImageFuture;
    protected long mLastFeedAction = 0;
    private ListView mList;
    protected boolean mShowFeed = true;

    class C02711 implements OnClickListener {
        C02711() {
        }

        public void onClick(View v) {
            MosaicArtistFeed.this.changeToFeedTab();
        }
    }

    class C02722 implements OnClickListener {
        C02722() {
        }

        public void onClick(View v) {
            MosaicArtistFeed.this.changeToFriends();
        }
    }

    class C02743 implements Runnable {

        class C02731 implements Runnable {
            C02731() {
            }

            public void run() {
                if (MosaicArtistFeed.this.mAdapter != null) {
                    MosaicArtistFeed.this.mAdapter.notifyDataSetChanged();
                }
            }
        }

        C02743() {
        }

        public void run() {
            MosaicArtistFeed.this.mActivity.runOnUiThread(new C02731());
        }
    }

    class C02824 implements SoundboardListener<ArtistInfo> {
        C02824() {
        }

        public void onSuccess(ArtistInfo result) {
            final int aImageSize = (int) (266.67d * ((double) MosaicArtistFeed.this.mActivity.getResources().getDisplayMetrics().density));
            final ArtistBiography artistBiography = result.getArtistBiography();
            if (artistBiography != null) {
                MosaicArtistFeed.this.mActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        MosaicArtistFeed.this.artistBioView.setText(Html.fromHtml(artistBiography.getText()));
                    }
                });
            }
            if (!result.getImage().getStatus().equals(STATUS.FAILED)) {
                if (result.getImage().getStatus().equals(STATUS.PENDING)) {
                    ArrayList<String> params = new ArrayList();
                    params.add(result.getArtistId());
                    params.add("image");
                    Runnable aImageUpdate = new ImageUpdate(StreamUtils.buildURLString(SoundboardServer.get().getServer(), "artists", params)) {
                        public void reset() {
                            MosaicArtistFeed.this.mImageFuture = MosaicArtistFeed.this.mFutureCheck.schedule(this, 2, TimeUnit.SECONDS);
                        }

                        public void setPhoto(CollectionImage pImage) {
                            MosaicArtistFeed.this.mImageFuture = null;
                            MosaicArtistFeed.this.mFutureCheck.execute(new ImageDownloadRunnable(aImageSize, pImage.getUrl()) {
                                public void onPostExecute(final Bitmap pBitmap) {
                                    MosaicArtistFeed.this.mActivity.runOnUiThread(new Runnable() {
                                        public void run() {
                                            MosaicArtistFeed.this.aView.setImageBitmap(pBitmap);
                                        }
                                    });
                                }
                            });
                        }
                    };
                    MosaicArtistFeed.this.mImageFuture = MosaicArtistFeed.this.mFutureCheck.schedule(aImageUpdate, 2, TimeUnit.SECONDS);
                    return;
                }
                final ImageDownloadRunnable aRunnable = new ImageDownloadRunnable(aImageSize, result.getImage().getUrl()) {
                    public void onPostExecute(final Bitmap pBitmap) {
                        MosaicArtistFeed.this.mActivity.runOnUiThread(new Runnable() {
                            public void run() {
                                MosaicArtistFeed.this.aView.setImageBitmap(pBitmap);
                            }
                        });
                    }
                };
                new AsyncTask<Void, Void, Void>() {
                    protected Void doInBackground(Void... params) {
                        aRunnable.run();
                        return null;
                    }
                }.execute(new Void[]{(Void) null});
            }
        }

        public void onFailure(String message, StreamException exception) {
            Log.e(MosaicArtistFeed.this.TAG, message, exception);
        }
    }

    class FollowClickListener implements OnClickListener {
        Activity mActivity;
        String mArtistID;
        String mArtistName;
        Button mButton;
        String mSoundboardID;

        class C02851 implements SoundboardListener<String> {

            class C02831 implements Runnable {
                C02831() {
                }

                public void run() {
                    Map<String, String> properties = new HashMap();
                    if (FollowClickListener.this.mSoundboardID == null || !FollowClickListener.this.mSoundboardID.equalsIgnoreCase(SoundboardServer.get().getCurrentSoundBoardId())) {
                        properties.put(Analytics.FROM_KEY, Analytics.FRIEND_VALUE);
                    } else {
                        properties.put(Analytics.FROM_KEY, "artist");
                    }
                    Analytics.get().trackEvent(Analytics.EVENT_FOLLOW, null, properties);
                    Utils.showShortToast(FollowClickListener.this.mActivity, FollowClickListener.this.mActivity.getResources().getString(C0116R.string.followed, new Object[]{FollowClickListener.this.mArtistName}));
                    FollowClickListener.this.mButton.setText(C0116R.string.unfollow);
                    FollowClickListener.this.mButton.setOnClickListener(new UnFollowClickListener(FollowClickListener.this.mArtistID, FollowClickListener.this.mArtistName, FollowClickListener.this.mActivity, FollowClickListener.this.mButton, FollowClickListener.this.mSoundboardID));
                    FollowClickListener.this.mButton.setEnabled(true);
                }
            }

            class C02842 implements Runnable {
                C02842() {
                }

                public void run() {
                    FollowClickListener.this.mButton.setEnabled(true);
                }
            }

            C02851() {
            }

            public void onSuccess(String result) {
                MosaicArtistFeed.this.following = true;
                FollowClickListener.this.mActivity.runOnUiThread(new C02831());
            }

            public void onFailure(String message, StreamException exception) {
                FollowClickListener.this.mActivity.runOnUiThread(new ReauthorizeSoundboard());
                FollowClickListener.this.mActivity.runOnUiThread(new C02842());
            }
        }

        public FollowClickListener(String pArtistID, String pArtistName, Activity pActivity, Button pFollowButton, String pSoundboardID) {
            this.mButton = pFollowButton;
            this.mArtistID = pArtistID;
            this.mArtistName = pArtistName;
            this.mActivity = pActivity;
            this.mSoundboardID = pSoundboardID;
        }

        public void onClick(View v) {
            this.mButton.setEnabled(false);
            SoundboardServer.get().followArtist(this.mArtistID, new C02851());
        }
    }

    class UnFollowClickListener implements OnClickListener {
        Activity mActivity;
        String mArtistID;
        String mArtistName;
        Button mButton;
        String mSoundboardID;

        class C02881 implements SoundboardListener<String> {

            class C02861 implements Runnable {
                C02861() {
                }

                public void run() {
                    Utils.showShortToast(UnFollowClickListener.this.mActivity, UnFollowClickListener.this.mActivity.getResources().getString(C0116R.string.unfollowed, new Object[]{UnFollowClickListener.this.mArtistName}));
                    UnFollowClickListener.this.mButton.setText(C0116R.string.follow);
                    UnFollowClickListener.this.mButton.setOnClickListener(new FollowClickListener(UnFollowClickListener.this.mArtistID, UnFollowClickListener.this.mArtistName, UnFollowClickListener.this.mActivity, UnFollowClickListener.this.mButton, UnFollowClickListener.this.mSoundboardID));
                    Map<String, String> properties = new HashMap();
                    if (UnFollowClickListener.this.mSoundboardID == null || !UnFollowClickListener.this.mSoundboardID.equalsIgnoreCase(SoundboardServer.get().getCurrentSoundBoardId())) {
                        properties.put(Analytics.FROM_KEY, "artist");
                    } else {
                        properties.put(Analytics.FROM_KEY, Analytics.ME_VALUE);
                    }
                    Analytics.get().trackEvent(Analytics.EVENT_UNFOLLOW, null, properties);
                    UnFollowClickListener.this.mButton.setEnabled(true);
                }
            }

            class C02872 implements Runnable {
                C02872() {
                }

                public void run() {
                    UnFollowClickListener.this.mButton.setEnabled(true);
                }
            }

            C02881() {
            }

            public void onSuccess(String result) {
                MosaicArtistFeed.this.following = false;
                UnFollowClickListener.this.mActivity.runOnUiThread(new C02861());
            }

            public void onFailure(String message, StreamException exception) {
                UnFollowClickListener.this.mActivity.runOnUiThread(new ReauthorizeSoundboard());
                UnFollowClickListener.this.mActivity.runOnUiThread(new C02872());
            }
        }

        public UnFollowClickListener(String pArtistID, String pArtistName, Activity pActivity, Button pFollowButton, String pSoundboardID) {
            this.mButton = pFollowButton;
            this.mArtistID = pArtistID;
            this.mArtistName = pArtistName;
            this.mActivity = pActivity;
            this.mSoundboardID = pSoundboardID;
        }

        public void onClick(View v) {
            this.mButton.setEnabled(false);
            SoundboardServer.get().unFollowArtist(this.mArtistID, new C02881());
        }
    }

    public MosaicArtistFeed(Activity aActivity, int aLayoutId, ViewGroup aViewRoot) {
        super(aActivity, aLayoutId, aViewRoot);
        setViewKey(Constants.CONTENT_VIEW_ARTIST_PAGE);
        setViewCategory(VIEW_CATEGORY);
        this.aView = (ImageView) this.mView.findViewById(C0116R.id.mosaic_feed_artist_image);
        this.mFollowAction = (Button) this.mView.findViewById(C0116R.id.mosaic_feed_artist_follow);
        this.artistBioView = (TextView) this.mView.findViewById(C0116R.id.artist_bio_text);
        this.bioViewScroll = this.mView.findViewById(C0116R.id.bio_scroll);
        this.mList = (ListView) this.mView.findViewById(C0116R.id.artist_whatsnew);
        this.mFeedTab = (TextView) this.mView.findViewById(C0116R.id.whats_new_tab);
        this.mArtistInfoTab = (TextView) this.mView.findViewById(C0116R.id.artist_info_tab);
        this.mFeedTab.setOnClickListener(new C02711());
        this.mArtistInfoTab.setOnClickListener(new C02722());
        this.mShowFeed = this.mActivity.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).getBoolean(PrefKeys.ARTIST_BIO_SHOW_FEED, true);
    }

    private void changeToFeedTab() {
        this.mShowFeed = true;
        this.mArtistInfoLastPosition = this.mList.getFirstVisiblePosition();
        this.bioViewScroll.setVisibility(4);
        this.mList.setVisibility(0);
        this.mFeedTab.setSelected(true);
        this.mArtistInfoTab.setSelected(false);
        setupArtistFeed();
        Analytics.getAnalytics().track(Analytics.EVENT_ARTIST_FEED + this.aArtistName);
    }

    public void onResume() {
        super.onResume();
        this.mDownloadExecutor = Executors.newFixedThreadPool(2);
        this.mFutureCheck = Executors.newScheduledThreadPool(1);
        this.aArtistName = this.mActivity.getIntent().getStringExtra(Constants.EXTRA_ARTIST_NAME);
        this.aSoundboardID = this.mActivity.getIntent().getStringExtra(Constants.EXTRA_SOUNDBOARD_ID);
        updateHeaderViewText(this.aArtistName);
        String aPreviousArtistId = this.mArtistID;
        this.mArtistID = this.mActivity.getIntent().getStringExtra(Constants.EXTRA_ARTIST_ID);
        this.following = this.mActivity.getIntent().getBooleanExtra("Following", false);
        if (!(this.mArtistID == null || this.mArtistID.equals(aPreviousArtistId))) {
            this.aView.setImageResource(C0116R.drawable.generic_artist_big);
            this.artistBioView.setText("");
            this.artistChanged = true;
            if (this.mShowFeed) {
                changeToFeedTab();
            } else {
                changeToFriends();
            }
        }
        if (this.following) {
            this.mFollowAction.setText(C0116R.string.unfollow);
            this.mFollowAction.setOnClickListener(new UnFollowClickListener(this.mArtistID, this.aArtistName, this.mActivity, this.mFollowAction, this.aSoundboardID));
            this.mFollowAction.setText(C0116R.string.unfollow);
        } else {
            this.mFollowAction.setOnClickListener(new FollowClickListener(this.mArtistID, this.aArtistName, this.mActivity, this.mFollowAction, this.aSoundboardID));
            this.mFollowAction.setText(C0116R.string.follow);
        }
        Analytics.get().trackEvent(Analytics.EVENT_SONGBIRD_ME_ARTIST_VIEW);
        if (SoundboardServer.get().lastFeedAction() != this.mLastFeedAction && this.feedRetriever != null) {
            this.mLastFeedAction = SoundboardServer.get().lastFeedAction();
            this.feedRetriever.refreshList();
        }
    }

    private void setupArtistFeed() {
        if (this.artistChanged && this.mArtistID != null) {
            this.feedRetriever = new ArtistFeedRetriever(new C02743(), null, this.mArtistID);
            this.mAdapter = new ArtistFeedAdapter(this.mActivity.getLayoutInflater(), this.mActivity.getResources(), this, this.feedRetriever);
            this.mList.setAdapter(this.mAdapter);
            this.artistChanged = false;
        }
    }

    private void setupArtistBio() {
        if (this.mArtistID != null) {
            String aPath = ArtistPhotoCache.get(this.mActivity.getApplicationContext()).getPhoto(this.mArtistID);
            if (aPath != null) {
                this.aView.setImageBitmap(BitmapFactory.decodeFile(aPath));
            }
            SoundboardServer.get().getArtistInfo(new C02824(), this.mArtistID);
        }
    }

    public void onPause() {
        super.onPause();
        this.mDownloadExecutor.shutdown();
        if (this.mImageFuture != null) {
            this.mImageFuture.cancel(true);
        }
        this.mFutureCheck.shutdown();
        this.mActivity.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit().putBoolean(PrefKeys.ARTIST_BIO_SHOW_FEED, this.mShowFeed).commit();
    }

    public Future<?> download(Runnable pRunnable) {
        if (this.mDownloadExecutor == null || this.mDownloadExecutor.isShutdown()) {
            return null;
        }
        return this.mDownloadExecutor.submit(pRunnable);
    }

    public void uiPost(Runnable pRunnable) {
        this.mHandler.post(pRunnable);
    }

    public void displayDialog(ItemDelegate pDelegate) {
        Dialog aDialog = new Dialog(this.mActivity);
        FollowDialogWrapper aWrapper = new FollowDialogWrapper(aDialog);
        aWrapper.hideOptions(DisplayItems.ArtistInfo, DisplayItems.Comment, DisplayItems.FollowingState);
        aWrapper.setupLike(pDelegate, this.feedRetriever);
        aDialog.show();
    }

    public void launchIntent(Intent i) {
        this.mActivity.startActivity(i);
    }

    public void changeToFriends() {
        this.mShowFeed = false;
        this.mFeedLastPosition = this.mList.getFirstVisiblePosition();
        this.bioViewScroll.setVisibility(0);
        this.mList.setVisibility(4);
        this.mFeedTab.setSelected(false);
        this.mArtistInfoTab.setSelected(true);
        setupArtistBio();
    }
}
