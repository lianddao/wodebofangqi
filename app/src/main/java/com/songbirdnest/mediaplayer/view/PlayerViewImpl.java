package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.SongbirdApplication;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.mediaplayer.dialogs.Equalizer;
import com.songbirdnest.mediaplayer.service.IMediaEventCallback.Stub;
import com.songbirdnest.mediaplayer.service.IMediaServiceBinder;
import com.songbirdnest.mediaplayer.service.IPhotoStreamCallback;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;
import com.songbirdnest.mediaplayer.widgets.AnimationImage;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.ArtistInfo;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.util.Logger;
import com.songbirdnest.util.MediaUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class PlayerViewImpl implements IMediaServiceBinder {
    protected static final int METADATA_UPDATE_INTERVAL = 100;
    protected static final int SEEKBAR_UPDATE_INTERVAL = 500;
    private Activity activity;
    private PhotostreamAdapter adapter;
    private TextView artistAlbumText;
    private ImageView artistFeedButton;
    private ImageView backToList;
    private ImageView backToListHandle;
    private Stub callback = new C03363();
    private RelativeLayout container;
    int currentCache = 0;
    private int[] defaultSize;
    private SlidingDrawer drawerHandle;
    private CheckedTextView equalizerButton;
    private ImageView facebookLikeButton;
    private Button facebookUnlikeButton;
    private boolean following = false;
    private Handler imageWatch = new Handler() {
        public void handleMessage(Message msg) {
            PlayerViewImpl.this.tracking = false;
        }
    };
    private TextView leftText;
    private String mArtistID;
    private String mCurrentArtist;
    private Handler mHandler = new Handler();
    private SongbirdMediaService mService;
    private volatile boolean mServiceConnected = false;
    private Runnable mUpdateMetadataTask = new C03322();
    private Runnable mUpdateSeekbarTask = new C03311();
    private Handler photoHandler = new Handler() {
        public void handleMessage(Message aMessage) {
            if (PlayerViewImpl.this.mServiceConnected) {
                try {
                    PlayerViewImpl.this.mService.getPhotoImage((IPhotoStreamCallback) aMessage.obj, aMessage.arg1);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            PlayerViewImpl.this.photoHandler.sendMessageDelayed(Message.obtain(aMessage), 500);
        }
    };
    private Gallery photoStream;
    private ImageView randomButton;
    private ImageView repeatButton;
    private TextView rightText;
    private SeekBar seekBar;
    private TextView songTitle;
    public boolean tracking;

    class C03311 implements Runnable {
        C03311() {
        }

        public void run() {
            try {
                if (!(PlayerViewImpl.this.tracking || PlayerViewImpl.this.drawerHandle.isMoving())) {
                    int position = PlayerViewImpl.this.mService.position();
                    PlayerViewImpl.this.seekBar.setProgress(position);
                    PlayerViewImpl.this.leftText.setText(Utils.calculateTimeStamp(position));
                }
                if (PlayerViewImpl.this.isPlaying()) {
                    PlayerViewImpl.this.mHandler.postDelayed(this, 500);
                } else {
                    PlayerViewImpl.this.mHandler.removeCallbacks(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C03322 implements Runnable {
        C03322() {
        }

        public void run() {
            try {
                String albumName = PlayerViewImpl.this.mService.getAlbumName();
                String artistName = PlayerViewImpl.this.mService.getArtistName();
                if (!(albumName == null || artistName == null)) {
                    TextView albumText = (TextView) PlayerViewImpl.this.activity.findViewById(C0116R.id.main_player_album_text);
                    if (albumText != null) {
                        PlayerViewImpl.this.artistAlbumText.setText(artistName);
                        albumText.setText(albumName);
                    } else {
                        PlayerViewImpl.this.artistAlbumText.setText(artistName + "  -  " + albumName);
                    }
                }
                String trackName = PlayerViewImpl.this.mService.getTrackName();
                if (trackName != null) {
                    PlayerViewImpl.this.songTitle.setText(trackName);
                }
                int duration = PlayerViewImpl.this.mService.duration();
                if (duration != 0) {
                    PlayerViewImpl.this.seekBar.setMax(duration);
                    PlayerViewImpl.this.rightText.setText(Utils.calculateTimeStamp(PlayerViewImpl.this.seekBar.getMax()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C03363 extends Stub {
        C03363() {
        }

        public void onMediaMessage(int aEvent) {
            final int event = aEvent;
            PlayerViewImpl.this.mHandler.post(new Runnable() {
                public void run() {
                    if (PlayerViewImpl.this.mServiceConnected) {
                        switch (event) {
                            case 1:
                                try {
                                    PlayerViewImpl.this.seekBar.setProgress(PlayerViewImpl.this.mService.position());
                                    return;
                                } catch (RemoteException e) {
                                    return;
                                }
                            case 2:
                                PlayerViewImpl.this.mHandler.removeCallbacks(PlayerViewImpl.this.mUpdateSeekbarTask);
                                PlayerViewImpl.this.mHandler.postDelayed(PlayerViewImpl.this.mUpdateSeekbarTask, 500);
                                return;
                            case 3:
                                PlayerViewImpl.this.seekBar.setProgress(0);
                                PlayerViewImpl.this.updateFacebookLikedState(true);
                                return;
                            case 4:
                                int position = 0;
                                try {
                                    PlayerViewImpl.this.setRandomButtonState(PlayerViewImpl.this.mService.getRandom(), false);
                                    PlayerViewImpl.this.seekBar.setMax(PlayerViewImpl.this.mService.duration());
                                    position = PlayerViewImpl.this.mService.position();
                                } catch (RemoteException e2) {
                                }
                                PlayerViewImpl.this.seekBar.setProgress(position);
                                PlayerViewImpl.this.leftText.setText(Utils.calculateTimeStamp(position));
                                PlayerViewImpl.this.adapter.notifyDataSetChanged();
                                PlayerViewImpl.this.adapter.clearCache();
                                String aArtistName = "";
                                try {
                                    aArtistName = PlayerViewImpl.this.mService.getArtistName();
                                } catch (RemoteException ex) {
                                    ex.printStackTrace();
                                }
                                if (PlayerViewImpl.this.mCurrentArtist == null || !PlayerViewImpl.this.mCurrentArtist.equalsIgnoreCase(aArtistName)) {
                                    PlayerViewImpl.this.artistFeedButton.setEnabled(false);
                                    if (PlayerViewImpl.this.showFeedButton()) {
                                        PlayerViewImpl.this.artistFeedButton.setVisibility(0);
                                    } else {
                                        PlayerViewImpl.this.artistFeedButton.setVisibility(4);
                                    }
                                    if (aArtistName != null && aArtistName.length() > 0) {
                                        PlayerViewImpl.this.mCurrentArtist = aArtistName;
                                        final String finalArtistName = aArtistName;
                                        SoundboardServer.get().searchArtists(new SoundboardListener<ArtistInfo>() {

                                            class C03331 implements Runnable {
                                                C03331() {
                                                }

                                                public void run() {
                                                    PlayerViewImpl.this.artistFeedButton.setEnabled(true);
                                                }
                                            }

                                            public void onSuccess(ArtistInfo result) {
                                                if (result == null) {
                                                    PlayerViewImpl.this.mArtistID = null;
                                                    Logger.error((Object) this, "Could not get artist id for artist " + finalArtistName);
                                                } else if (SoundboardServer.get().getCurrentSoundBoardId() == null) {
                                                    Logger.error((Object) this, "Could not get artist id for artist " + finalArtistName + " No current soundboard id");
                                                } else {
                                                    PlayerViewImpl.this.following = result.isCollected();
                                                    PlayerViewImpl.this.mArtistID = result.getArtistId();
                                                    PlayerViewImpl.this.mHandler.post(new C03331());
                                                }
                                            }

                                            public void onFailure(String message, StreamException exception) {
                                                Logger.error(this, "Could not get artist id for artist " + finalArtistName, exception);
                                                PlayerViewImpl.this.mArtistID = null;
                                                PlayerViewImpl.this.artistFeedButton.setEnabled(false);
                                            }
                                        }, aArtistName);
                                    }
                                }
                                PlayerViewImpl.this.photoStream.setSelection(0);
                                PlayerViewImpl.this.updateFacebookLikedState(false);
                                PlayerViewImpl.this.mHandler.postDelayed(PlayerViewImpl.this.mUpdateMetadataTask, 100);
                                return;
                            case 5:
                                try {
                                    PlayerViewImpl.this.seekBar.setProgress(PlayerViewImpl.this.mService.position());
                                } catch (RemoteException e3) {
                                }
                                PlayerViewImpl.this.leftText.setText(Utils.calculateTimeStamp(PlayerViewImpl.this.seekBar.getProgress()));
                                return;
                            case 6:
                                PlayerViewImpl.this.adapter.notifyDataSetChanged();
                                return;
                            case 7:
                                try {
                                    PlayerViewImpl.this.mService.setPhotostream(2);
                                } catch (RemoteException e4) {
                                }
                                Utils.showShortToastWithLayout(PlayerViewImpl.this.activity, C0116R.layout.photostream_toast_error);
                                return;
                            case 8:
                                Utils.showShortToastWithLayout(PlayerViewImpl.this.activity, C0116R.layout.photostream_toast_no_results);
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    class C03374 implements OnClickListener {
        C03374() {
        }

        public void onClick(View view) {
            try {
                if (PlayerViewImpl.this.mService.isPaused() || PlayerViewImpl.this.mService.isPlaying()) {
                    PlayerViewImpl.this.activity.startActivity(new Intent(PlayerViewImpl.this.activity, Equalizer.class));
                }
            } catch (RemoteException e) {
                Logger.error(this, "Problems getting Service", e);
            }
        }
    }

    class C03385 implements Runnable {
        C03385() {
        }

        public void run() {
            if (View.class.isInstance(PlayerViewImpl.this.seekBar.getParent())) {
                View seekBarParent = (View) PlayerViewImpl.this.seekBar.getParent();
                Rect seekBarRect = new Rect();
                PlayerViewImpl.this.seekBar.getHitRect(seekBarRect);
                seekBarRect.top = 0;
                seekBarRect.bottom = seekBarParent.getHeight();
                seekBarParent.setTouchDelegate(new TouchDelegate(seekBarRect, PlayerViewImpl.this.seekBar, 1));
            }
        }
    }

    class C03396 implements OnClickListener {
        C03396() {
        }

        public void onClick(View v) {
            try {
                if (PlayerViewImpl.this.mService.getRandom() == 2) {
                    PlayerViewImpl.this.mService.setRandom(1);
                    PlayerViewImpl.this.setRandomButtonState(1, true);
                    Analytics.getAnalytics().trackEvent(Analytics.EVENT_SHUFFLE_ENABLED);
                    return;
                }
                PlayerViewImpl.this.mService.setRandom(2);
                PlayerViewImpl.this.setRandomButtonState(2, true);
                Analytics.getAnalytics().trackEvent(Analytics.EVENT_SHUFFLE_DISABLED);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    class C03407 implements OnClickListener {
        C03407() {
        }

        public void onClick(View v) {
            try {
                String targetActivity = PlayerViewImpl.this.mService.getCurrentListActivity();
                String targetToken = PlayerViewImpl.this.mService.getCurrentListToken();
                if (targetActivity != null && targetToken != null) {
                    ((SlidingDrawer) PlayerViewImpl.this.activity.findViewById(C0116R.id.sliding_drawer)).close();
                    Intent intent = Utils.buildIntent(targetActivity, targetToken, true, PlayerViewImpl.this.activity);
                    intent.addFlags(65536);
                    intent.addFlags(536870912);
                    PlayerViewImpl.this.activity.startActivity(intent);
                    Analytics.getAnalytics().trackEvent(Analytics.EVENT_BACK_TO_LIST);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    class C03418 implements OnClickListener {
        C03418() {
        }

        public void onClick(View v) {
            try {
                if (PlayerViewImpl.this.mService.getRepeat() == 1) {
                    PlayerViewImpl.this.mService.setRepeat(2);
                    PlayerViewImpl.this.setRepeatButtonState(2, true);
                    Analytics.getAnalytics().trackEvent(Analytics.EVENT_REPEAT_ALL);
                } else if (PlayerViewImpl.this.mService.getRepeat() == 2) {
                    PlayerViewImpl.this.mService.setRepeat(3);
                    PlayerViewImpl.this.setRepeatButtonState(3, true);
                    Analytics.getAnalytics().trackEvent(Analytics.EVENT_REPEAT_ONE);
                } else {
                    PlayerViewImpl.this.mService.setRepeat(1);
                    PlayerViewImpl.this.setRepeatButtonState(1, true);
                    Analytics.getAnalytics().trackEvent(Analytics.EVENT_REPEAT_NONE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C03429 implements OnClickListener {
        C03429() {
        }

        public void onClick(View v) {
            String aArtistName = "";
            try {
                aArtistName = PlayerViewImpl.this.mService.getArtistName();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            ((SlidingDrawer) PlayerViewImpl.this.activity.findViewById(C0116R.id.sliding_drawer)).close();
            Intent intent = new Intent(PlayerViewImpl.this.activity, ContentBrowser.class);
            intent.putExtra(Constants.CONTENT_AREA_VIEW_KEY, Constants.CONTENT_VIEW_ARTIST_PAGE);
            intent.putExtra(Constants.EXTRA_ARTIST_NAME, aArtistName);
            intent.putExtra(Constants.EXTRA_SOUNDBOARD_ID, SoundboardServer.get().getCurrentSoundBoardId());
            intent.putExtra(Constants.EXTRA_ARTIST_ID, PlayerViewImpl.this.mArtistID);
            intent.putExtra("Following", PlayerViewImpl.this.following);
            PlayerViewImpl.this.activity.startActivity(intent);
        }
    }

    public static class ImagePopulator {
        int[] container;
        int[] defaultSize;
        WeakReference<PhotostreamAdapter> wAdapter;
        WeakReference<Handler> wHandler;
        WeakReference<AnimationImage> wTemp;

        class C03441 extends IPhotoStreamCallback.Stub {
            C03441() {
            }

            public void imageDone(Bitmap aBitmap) throws RemoteException {
                final Bitmap bitmap = aBitmap;
                Handler mHandler = (Handler) ImagePopulator.this.wHandler.get();
                if (mHandler != null) {
                    mHandler.post(new Runnable() {
                        public void run() {
                            PhotostreamAdapter adapter = (PhotostreamAdapter) ImagePopulator.this.wAdapter.get();
                            AnimationImage temp = (AnimationImage) ImagePopulator.this.wTemp.get();
                            if (adapter != null && temp != null) {
                                try {
                                    if (ImagePopulator.this.defaultSize[0] == 0 || ImagePopulator.this.defaultSize[1] == 0) {
                                        ImagePopulator.this.defaultSize[0] = ImagePopulator.this.container[0];
                                        ImagePopulator.this.defaultSize[1] = ImagePopulator.this.container[1];
                                    }
                                    int[] size = ImagePopulator.this.defaultSize;
                                    if (ImagePopulator.this.container[0] > 20 && ImagePopulator.this.container[1] > 20) {
                                        size[0] = ImagePopulator.this.container[0] - 20;
                                        size[1] = ImagePopulator.this.container[1] - 20;
                                    }
                                    retValues = new int[2];
                                    retValues = Utils.calcAspectRatio(new int[]{bitmap.getWidth(), bitmap.getHeight()}, size);
                                    Bitmap holder = Bitmap.createScaledBitmap(bitmap, retValues[0], retValues[1], true);
                                    temp.setImageBitmap(holder);
                                    if (bitmap != holder) {
                                        bitmap.recycle();
                                    }
                                    temp.setBackgroundResource(C0116R.drawable.art_background2);
                                    temp.setPadding(5, 5, 5, 5);
                                    adapter.notifyDataSetChanged();
                                } catch (NullPointerException e) {
                                }
                            }
                        }
                    });
                }
            }
        }

        public ImagePopulator(int[] defaultSize, int[] containerSize, PhotostreamAdapter adapter, Handler handle, AnimationImage temp) {
            this.wHandler = new WeakReference(handle);
            this.container = containerSize;
            this.defaultSize = defaultSize;
            this.wAdapter = new WeakReference(adapter);
            this.wTemp = new WeakReference(temp);
        }

        public IPhotoStreamCallback.Stub getStub() {
            return new C03441();
        }
    }

    class PhotostreamAdapter extends BaseAdapter {
        ImageView mAlbumImage;

        class ImageWrapper {
            int cacheID;
            Bitmap myImage;
            int myPosition;

            ImageWrapper() {
            }

            public int getCacheID() {
                return this.cacheID;
            }

            public void setCacheID(int cacheID) {
                this.cacheID = cacheID;
            }

            public Bitmap getMyImage() {
                return this.myImage;
            }

            public void setMyImage(Bitmap myImage) {
                this.myImage = myImage;
            }

            public int getMyPosition() {
                return this.myPosition;
            }

            public void setMyPosition(int myPosition) {
                this.myPosition = myPosition;
            }
        }

        PhotostreamAdapter() {
        }

        public int getCount() {
            return 1;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View drawerFrame = PlayerViewImpl.this.activity.findViewById(C0116R.id.mini_frame);
            if (PlayerViewImpl.this.activity.getResources().getConfiguration().orientation == 2) {
                drawerFrame.setPadding(0, 5, 0, 0);
                PlayerViewImpl.this.container.getLayoutParams().width = PlayerViewImpl.this.container.getHeight();
                try {
                    if (PlayerViewImpl.this.mService.getPhotostream() == 1) {
                        PlayerViewImpl.this.mService.setPhotostream(2);
                    }
                } catch (RemoteException e) {
                }
            } else {
                drawerFrame.setPadding(0, 28, 0, 0);
                PlayerViewImpl.this.container.getLayoutParams().width = -1;
            }
            if (this.mAlbumImage != null) {
                return this.mAlbumImage;
            }
            View temp = new AnimationImage(PlayerViewImpl.this.activity);
            ImageWrapper wrapper = new ImageWrapper();
            wrapper.myPosition = position;
            wrapper.cacheID = PlayerViewImpl.this.currentCache;
            temp.setTag(wrapper);
            temp.setBackgroundResource(C0116R.drawable.holdershape);
            temp.setScaleType(ScaleType.CENTER_INSIDE);
            AnimationDrawable animation = (AnimationDrawable) PlayerViewImpl.this.activity.getResources().getDrawable(C0116R.drawable.spinner);
            temp.setImageDrawable(animation);
            temp.setAnimation(animation);
            this.mAlbumImage = temp;
            try {
                PlayerViewImpl.this.mService.getPhotoImage(new ImagePopulator(PlayerViewImpl.this.defaultSize, new int[]{PlayerViewImpl.this.container.getWidth(), PlayerViewImpl.this.container.getHeight()}, PlayerViewImpl.this.adapter, PlayerViewImpl.this.mHandler, temp).getStub(), 0);
                return temp;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return temp;
            }
        }

        public void clearCache() {
            this.mAlbumImage = null;
        }
    }

    public PlayerViewImpl(Activity aActivity) {
        bindPlayerToActivity(aActivity);
        this.defaultSize = new int[]{0, 0};
    }

    private boolean showFeedButton() {
        if (FacebookAPI.get().isSessionValid() && this.drawerHandle.isOpened() && SoundboardServer.get().getCurrentSoundBoardId() != null) {
            return true;
        }
        return false;
    }

    public void bindPlayerToActivity(Activity aActivity) {
        if (aActivity != this.activity) {
            unbindMiniPlayer();
            this.activity = aActivity;
            this.songTitle = (TextView) this.activity.findViewById(C0116R.id.main_player_song_title);
            this.container = (RelativeLayout) this.activity.findViewById(C0116R.id.main_player_art_container);
            this.artistAlbumText = (TextView) this.activity.findViewById(C0116R.id.main_player_artist_album_text);
            this.randomButton = (ImageView) this.activity.findViewById(C0116R.id.main_player_random);
            this.repeatButton = (ImageView) this.activity.findViewById(C0116R.id.main_player_repeat);
            this.backToList = (ImageView) this.activity.findViewById(C0116R.id.main_player_back_to_list);
            this.backToListHandle = (ImageView) this.activity.findViewById(C0116R.id.main_player_back_to_list_handle);
            this.artistFeedButton = (ImageView) this.activity.findViewById(C0116R.id.main_player_artistfeed_button);
            this.facebookLikeButton = (ImageView) this.activity.findViewById(C0116R.id.main_player_fb_like_button);
            this.equalizerButton = (CheckedTextView) this.activity.findViewById(C0116R.id.main_player_equalizer);
            if (VERSION.SDK_INT < 9) {
                this.equalizerButton.setVisibility(8);
            }
            this.equalizerButton.setOnClickListener(new C03374());
            this.seekBar = (SeekBar) this.activity.findViewById(C0116R.id.player_seek);
            this.seekBar.post(new C03385());
            this.leftText = (TextView) this.activity.findViewById(C0116R.id.main_player_left_text);
            this.rightText = (TextView) this.activity.findViewById(C0116R.id.main_player_right_text);
            this.randomButton.setOnClickListener(new C03396());
            OnClickListener backToListListener = new C03407();
            this.backToListHandle.setOnClickListener(backToListListener);
            this.backToList.setOnClickListener(backToListListener);
            this.repeatButton.setOnClickListener(new C03418());
            this.artistFeedButton.setOnClickListener(new C03429());
            this.photoStream = (Gallery) this.activity.findViewById(C0116R.id.main_player_photostream_image);
            this.photoStream.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == 0) {
                        PlayerViewImpl.this.tracking = true;
                    } else if (event.getAction() == 1) {
                        PlayerViewImpl.this.imageWatch.sendMessageDelayed(Message.obtain(PlayerViewImpl.this.imageWatch, 1), 500);
                    }
                    return false;
                }
            });
            registerMediaEventCallback();
        }
    }

    public void unbindMiniPlayer() {
        if (this.activity != null) {
            unregisterMediaEventCallback();
            this.activity = null;
        }
    }

    public void registerMediaEventCallback() {
        ((SongbirdApplication) this.activity.getApplicationContext()).getMediaService(this);
    }

    public void unregisterMediaEventCallback() {
        try {
            if (this.mServiceConnected) {
                this.mService.unregisterCallback(this.callback);
            }
        } catch (Exception e) {
        }
        this.mServiceConnected = false;
    }

    public void onMediaServiceConnected(SongbirdMediaService aMediaService) {
        this.mService = aMediaService;
        this.mServiceConnected = true;
        try {
            this.adapter = new PhotostreamAdapter();
            this.photoStream.setAdapter(this.adapter);
            this.mService.registerCallback(this.callback);
            setRandomButtonState(this.mService.getRandom(), false);
            setRepeatButtonState(this.mService.getRepeat(), false);
            this.equalizerButton.setChecked(this.mService.isEQEnabled());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                PlayerViewImpl.this.tracking = false;
                try {
                    PlayerViewImpl.this.mService.seek(seekBar.getProgress());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                PlayerViewImpl.this.tracking = true;
            }

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                PlayerViewImpl.this.leftText.setText(Utils.calculateTimeStamp(progress));
            }
        });
        this.mServiceConnected = true;
    }

    public void setTracking(boolean isTracking) {
        this.tracking = isTracking;
    }

    public void setDrawer(SlidingDrawer inDrawer) {
        this.drawerHandle = inDrawer;
        this.facebookLikeButton.setOnClickListener(new OnClickListener() {

            class C03291 implements OnClickListener {
                C03291() {
                }

                public void onClick(View aView) {
                    PlayerViewImpl.this.dismissFacebookLikedToast();
                }
            }

            public void onClick(View v) {
                PlayableItem item = null;
                try {
                    item = PlayerViewImpl.this.mService.getCurrentItem();
                } catch (RemoteException e) {
                }
                if (item != null && item.mID != -1) {
                    FacebookAPI fbApi = FacebookAPI.get();
                    if (FacebookAPI.getDB().isMediaLiked(item)) {
                        final RelativeLayout layout = (RelativeLayout) PlayerViewImpl.this.drawerHandle.findViewById(C0116R.id.facebook_toast_liked);
                        layout.setOnClickListener(new C03291());
                        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 0.9f);
                        fadeIn.setDuration(500);
                        layout.startAnimation(fadeIn);
                        fadeIn.setAnimationListener(new AnimationListener() {
                            public void onAnimationStart(Animation animation) {
                            }

                            public void onAnimationRepeat(Animation animation) {
                            }

                            public void onAnimationEnd(Animation animation) {
                                layout.setVisibility(0);
                            }
                        });
                        return;
                    }
                    String message = null;
                    try {
                        message = PlayerViewImpl.this.activity.getString(C0116R.string.facebook_default_like_message, new Object[]{PlayerViewImpl.this.mService.getTrackName(), PlayerViewImpl.this.mService.getArtistName()});
                    } catch (RemoteException e2) {
                    }
                    if (message != null) {
                        Bundle params = new Bundle();
                        params.putString("message", message);
                        try {
                            if (fbApi.likeMediaRequest(PlayerViewImpl.this.activity, item, params, new MainPlayerFacebookCallback(PlayerViewImpl.this.drawerHandle, FacebookAPI.sRequestTypeLikeMedia, PlayerViewImpl.this.mService.getArtistName(), PlayerViewImpl.this.mService.getTrackName(), PlayerViewImpl.this.mService.getTrackID(), PlayerViewImpl.this.activity))) {
                                Map<String, String> properties = new HashMap();
                                properties.put("artist", PlayerViewImpl.this.mService.getArtistName());
                                properties.put(Analytics.TRACK_KEY, PlayerViewImpl.this.mService.getTrackName());
                                Map<String, String> map = properties;
                                map.put(Analytics.GENRE_KEY, MediaUtils.getGenreForTrackId(PlayerViewImpl.this.activity, PlayerViewImpl.this.mService.getTrackID()));
                                Analytics.getAnalytics().trackEvent(Analytics.EVENT_FACEBOOK_LIKE, null, properties);
                                return;
                            }
                            FacebookAPI.get().showErrorToast();
                        } catch (RemoteException ex) {
                            Logger.error(this, "Problems with service", ex);
                        }
                    }
                }
            }
        });
        this.facebookUnlikeButton = (Button) this.drawerHandle.findViewById(C0116R.id.facebook_toast_unlike_button);
        this.facebookUnlikeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RelativeLayout layout = (RelativeLayout) PlayerViewImpl.this.drawerHandle.findViewById(C0116R.id.facebook_toast_liked);
                layout.setVisibility(4);
                AlphaAnimation fadeOut = new AlphaAnimation(0.9f, 0.0f);
                fadeOut.setDuration(500);
                layout.startAnimation(fadeOut);
                PlayableItem item = null;
                try {
                    item = PlayerViewImpl.this.mService.getCurrentItem();
                } catch (RemoteException e) {
                }
                if (item != null) {
                    FacebookAPI.get().unlikeMediaRequest(PlayerViewImpl.this.activity, item, new MainPlayerFacebookCallback(PlayerViewImpl.this.drawerHandle, FacebookAPI.sRequestTypeUnlikeMedia));
                }
            }
        });
    }

    public boolean onBackPressed() {
        if (!isFacebookLikedToastShowing()) {
            return false;
        }
        dismissFacebookLikedToast();
        return true;
    }

    public void onPause() {
        this.mHandler.removeCallbacks(this.mUpdateSeekbarTask);
        this.mHandler.removeCallbacks(this.mUpdateMetadataTask);
        unregisterMediaEventCallback();
    }

    public void onResume() {
        registerMediaEventCallback();
        if (this.mServiceConnected) {
            if (isPlaying()) {
                this.mHandler.post(this.mUpdateSeekbarTask);
            }
            this.mHandler.postDelayed(this.mUpdateMetadataTask, 100);
            if (this.equalizerButton != null && this.mService != null) {
                try {
                    this.equalizerButton.setChecked(this.mService.isEQEnabled());
                } catch (RemoteException e) {
                    Logger.error(this, "Problems with service", e);
                }
            }
        }
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    private boolean isPlaying() {
        try {
            return this.mService.isPlaying();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void setRandomButtonState(int randomState, boolean showToast) {
        if (randomState == 1) {
            this.randomButton.setImageResource(C0116R.drawable.shuffle_button_on);
            if (showToast) {
                setPlayerToast((int) C0116R.string.shuffle_on_toast);
                return;
            }
            return;
        }
        this.randomButton.setImageResource(C0116R.drawable.shuffle_button);
        if (showToast) {
            setPlayerToast((int) C0116R.string.shuffle_off_toast);
        }
    }

    private void setPlayerToast(int stringId) {
        setPlayerToast(this.activity.getResources().getString(stringId));
    }

    private void setPlayerToast(String text) {
        final TextView tempView = (TextView) this.activity.findViewById(C0116R.id.main_player_toast_text);
        tempView.setText(text);
        AlphaAnimation tempAnimation = new AlphaAnimation(0.0f, 0.9f);
        tempAnimation.setDuration(1000);
        tempView.startAnimation(tempAnimation);
        tempAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                tempView.setVisibility(4);
                AlphaAnimation secondAnimation = new AlphaAnimation(0.9f, 0.0f);
                secondAnimation.setDuration(1000);
                tempView.startAnimation(secondAnimation);
            }
        });
    }

    private void setRepeatButtonState(int repeatState, boolean showToast) {
        if (repeatState == 3) {
            this.repeatButton.setImageResource(C0116R.drawable.repeat_button_1);
            if (showToast) {
                setPlayerToast((int) C0116R.string.repeat_one_toast);
            }
        } else if (repeatState == 2) {
            this.repeatButton.setImageResource(C0116R.drawable.repeat_button_on);
            if (showToast) {
                setPlayerToast((int) C0116R.string.repeat_all_toast);
            }
        } else {
            this.repeatButton.setImageResource(C0116R.drawable.repeat_button);
            if (showToast) {
                setPlayerToast((int) C0116R.string.repeat_off_toast);
            }
        }
    }

    public void updateFacebookLikedState(boolean aResetToDefault) {
        if (this.drawerHandle != null && this.mService != null) {
            if (aResetToDefault) {
                this.facebookLikeButton.setImageDrawable(this.activity.getResources().getDrawable(C0116R.drawable.button_fb_default));
                return;
            }
            PlayableItem item = new PlayableItem("<UNKNOWN>", null, -1, -1);
            try {
                item = this.mService.getCurrentItem();
            } catch (Exception e) {
                item = new PlayableItem("<UNKNOWN>", null, -1, -1);
            }
            if (item.mStorageUri != null) {
                Drawable d;
                if (FacebookAPI.getDB().isMediaLiked(item)) {
                    d = this.activity.getResources().getDrawable(C0116R.drawable.button_fb_liked);
                } else {
                    d = this.activity.getResources().getDrawable(C0116R.drawable.button_fb_default);
                }
                this.facebookLikeButton.setImageDrawable(d);
            }
        }
    }

    public boolean isFacebookLikedToastShowing() {
        if (this.drawerHandle != null && ((RelativeLayout) this.drawerHandle.findViewById(C0116R.id.facebook_toast_liked)).getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void dismissFacebookLikedToast() {
        final RelativeLayout layout = (RelativeLayout) this.drawerHandle.findViewById(C0116R.id.facebook_toast_liked);
        layout.setOnClickListener(null);
        AlphaAnimation fadeOut = new AlphaAnimation(0.9f, 0.0f);
        fadeOut.setDuration(500);
        fadeOut.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                layout.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        layout.startAnimation(fadeOut);
    }

    public void setOpen(boolean isOpen) {
        if (showFeedButton() && isOpen) {
            this.artistFeedButton.setVisibility(0);
        } else {
            this.artistFeedButton.setVisibility(4);
        }
    }

    public void startScrolling() {
        this.artistFeedButton.setImageResource(C0116R.drawable.artist_feed_disabled);
    }

    public void stopScrolling() {
        this.artistFeedButton.setImageResource(C0116R.drawable.artist_feed);
    }
}
