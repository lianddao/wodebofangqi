package com.songbirdnest.mediaplayer.view.adapter;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.widgets.AnimationImage;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.Future;
import org.apache.http.util.ByteArrayBuffer;

public class FeedAdapter extends AbstractSoundboardAdapter {
    AsyncTask<Integer, Void, Void> mClearCache;
    protected Bitmap mDefaultImage;
    protected AccessDelegate mDelegate;
    protected LayoutInflater mInflator;
    protected Bitmap mMediaIndicator;
    protected HashMap<String, PositionCache<Bitmap>> mPhotoBitmap;
    protected Resources mResource;
    protected boolean mServerError = false;
    protected SystemDelegate mSystem;
    protected int mTargetSize;

    public interface SystemDelegate {
        void changeToFriends();

        void displayDialog(ItemDelegate itemDelegate);

        Future<?> download(Runnable runnable);

        void launchIntent(Intent intent);

        void uiPost(Runnable runnable);
    }

    public interface AccessDelegate {
        int getFeedCount();

        ItemDelegate getItem(int i);
    }

    static class Empty extends AsyncTask<Integer, Void, Void> {
        Empty() {
        }

        protected Void doInBackground(Integer... params) {
            return null;
        }
    }

    public interface ItemDelegate {
        String getArtistID();

        String getDescription();

        String getFeedID();

        String getLink();

        int[] getPhotoSize();

        String getPhotoURL();

        String getTitle();

        ViewType getType();

        boolean isLiked();

        boolean isPlayable();
    }

    public enum ViewType {
        FeedItem,
        LoadingItem,
        EmptyFeed
    }

    protected static class ViewWrapper {
        AnimationImage mCover;
        protected Bitmap mDefault;
        TextView mDescription;
        Future<?> mFuture;
        protected ImageView mStar;

        public ViewWrapper(View pParent, Bitmap pDefault) {
            this.mCover = (AnimationImage) pParent.findViewById(C0116R.id.mosaic_feed_item_cover);
            this.mDescription = (TextView) pParent.findViewById(C0116R.id.mosaic_feed_item_description);
            this.mDefault = pDefault;
            this.mStar = (ImageView) pParent.findViewById(C0116R.id.mosaic_feed_item_star);
        }

        public void reset() {
            this.mCover.setImageBitmap(this.mDefault);
            LayoutParams aParams = (LayoutParams) this.mCover.getLayoutParams();
            aParams.height = -2;
            aParams.width = -2;
            this.mCover.setLayoutParams(aParams);
            this.mStar.setImageBitmap(null);
            this.mCover.setOnLongClickListener(null);
            this.mCover.setOnClickListener(null);
            if (this.mFuture != null) {
                this.mFuture.cancel(true);
                this.mFuture = null;
            }
        }
    }

    public FeedAdapter(LayoutInflater pInflator, Resources pResources, SystemDelegate pSystem, AccessDelegate pDelegate) {
        this.mInflator = pInflator;
        this.mDelegate = pDelegate;
        this.mSystem = pSystem;
        this.mResource = pResources;
        this.mPhotoBitmap = new HashMap();
        this.mTargetSize = (int) (266.0f * this.mResource.getDisplayMetrics().density);
        this.mMediaIndicator = BitmapFactory.decodeResource(this.mResource, C0116R.drawable.media_indicator);
        this.mDefaultImage = BitmapFactory.decodeResource(this.mResource, C0116R.drawable.generic_artist_big);
    }

    public int getCount() {
        if (this.mServerError) {
            return 0;
        }
        if (this.mDelegate.getFeedCount() == 0) {
            return 1;
        }
        return this.mDelegate.getFeedCount();
    }

    public Object getItem(int position) {
        return this.mDelegate.getItem(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    protected View getLoadingView(View convertView, ViewGroup parent) {
        convertView = this.mInflator.inflate(C0116R.layout.face_item, parent, false);
        com.songbirdnest.mediaplayer.view.adapter.FriendAdapter.ViewWrapper aWrapper = new com.songbirdnest.mediaplayer.view.adapter.FriendAdapter.ViewWrapper(convertView);
        ViewGroup.LayoutParams layoutParams = aWrapper.mImage.getLayoutParams();
        layoutParams.width = 60;
        layoutParams.height = 60;
        aWrapper.mImage.setPadding(0, (int) (10.0f * this.mResource.getDisplayMetrics().density), 0, 0);
        AnimationDrawable aAnimation = (AnimationDrawable) this.mResource.getDrawable(C0116R.drawable.spinner);
        aWrapper.mImage.setImageDrawable(aAnimation);
        aWrapper.mImage.setBackgroundDrawable(null);
        aWrapper.mText.setText(C0116R.string.mosaic_feed_loading);
        ((AnimationImage) aWrapper.mImage).setAnimation(aAnimation);
        return convertView;
    }

    protected View getEmptyView(View convertView, ViewGroup parent) {
        return this.mInflator.inflate(C0116R.layout.mosaic_no_feed, parent, false);
    }

    public static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        if (height <= reqHeight && width <= reqWidth) {
            return 1;
        }
        if (width > height) {
            return Math.round(((float) height) / ((float) reqHeight));
        }
        return Math.round(((float) width) / ((float) reqWidth));
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ItemDelegate aDelegate = this.mDelegate.getItem(position);
        if (this.mDelegate.getItem(position).getType().equals(ViewType.LoadingItem)) {
            return getLoadingView(convertView, parent);
        }
        if (this.mDelegate.getItem(position).getType().equals(ViewType.EmptyFeed)) {
            return getEmptyView(convertView, parent);
        }
        ViewWrapper aWrapper;
        if (convertView == null || convertView.getTag() == null) {
            convertView = this.mInflator.inflate(C0116R.layout.mosaic_feed_item, parent, false);
            aWrapper = new ViewWrapper(convertView, this.mDefaultImage);
            convertView.setTag(aWrapper);
        } else {
            aWrapper = (ViewWrapper) convertView.getTag();
            aWrapper.reset();
        }
        aWrapper.mCover.setTag(Integer.valueOf(position));
        if (aDelegate == null) {
            return convertView;
        }
        aWrapper.mDescription.setText(aDelegate.getTitle().toUpperCase() + " " + aDelegate.getDescription(), BufferType.SPANNABLE);
        Spannable aSpan = (Spannable) aWrapper.mDescription.getText();
        aSpan.setSpan(new ForegroundColorSpan(this.mResource.getColor(C0116R.color.pink)), 0, aDelegate.getTitle().length(), 33);
        aSpan.setSpan(new StyleSpan(1), 0, aDelegate.getTitle().length(), 33);
        aSpan.setSpan(new ForegroundColorSpan(this.mResource.getColor(C0116R.color.white)), aDelegate.getTitle().length() + 1, (aDelegate.getTitle().length() + 1) + aDelegate.getDescription().length(), 33);
        final String aTargetUrl = aDelegate.getPhotoURL();
        final int i = position;
        aWrapper.mCover.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View v) {
                FeedAdapter.this.mSystem.displayDialog(FeedAdapter.this.mDelegate.getItem(i));
                return true;
            }
        });
        if (aDelegate.isPlayable()) {
            aWrapper.mCover.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Analytics.get().track(Analytics.EVENT_WHATS_NEW_VIEW);
                    FeedAdapter.this.mSystem.launchIntent(new Intent("android.intent.action.VIEW", Uri.parse(aDelegate.getLink())));
                }
            });
        }
        if (aDelegate.isLiked()) {
            aWrapper.mStar.setImageResource(C0116R.drawable.liked_star);
        }
        LayoutParams aParams;
        if (this.mPhotoBitmap.containsKey(aTargetUrl)) {
            Bitmap aBitmap = (Bitmap) ((PositionCache) this.mPhotoBitmap.get(aTargetUrl)).getValue();
            aWrapper.mCover.setImageBitmap(aBitmap);
            aParams = (LayoutParams) aWrapper.mCover.getLayoutParams();
            aParams.height = aBitmap.getHeight();
            aParams.width = aBitmap.getWidth();
            aWrapper.mCover.setLayoutParams(aParams);
        } else {
            AnimationDrawable aAnimation = (AnimationDrawable) this.mResource.getDrawable(C0116R.drawable.spinner);
            aWrapper.mCover.setImageDrawable(aAnimation);
            if (aDelegate.getPhotoSize() != null) {
                aParams = (LayoutParams) aWrapper.mCover.getLayoutParams();
                int[] aSizes = rescale(aDelegate.getPhotoSize()[0], aDelegate.getPhotoSize()[1], this.mResource.getDisplayMetrics().widthPixels - ((int) (20.0f * this.mResource.getDisplayMetrics().density)), this.mResource.getDisplayMetrics().heightPixels);
                aParams.width = aSizes[0];
                aParams.height = aSizes[1];
                aWrapper.mCover.setLayoutParams(aParams);
            }
            aWrapper.mCover.setAnimation(aAnimation);
            aWrapper.mCover.setBackgroundResource(0);
            final int i2 = position;
            aWrapper.mFuture = this.mSystem.download(new Runnable() {
                public void run() {
                    if (aTargetUrl != null) {
                        final int[] aValues = FeedAdapter.rescale(aDelegate.getPhotoSize()[0], aDelegate.getPhotoSize()[1], FeedAdapter.this.mResource.getDisplayMetrics().widthPixels - ((int) (20.0f * FeedAdapter.this.mResource.getDisplayMetrics().density)), FeedAdapter.this.mResource.getDisplayMetrics().heightPixels);
                        try {
                            Bitmap aFinal;
                            Bitmap aBitmap = (Bitmap) new StreamProcessor(aTargetUrl, new AbstractStreamHandler<Bitmap>() {
                                public Bitmap processInputStream(InputStream stream, long contentLength) throws StreamException {
                                    Options aOptions = new Options();
                                    ByteArrayBuffer aBuffer = new ByteArrayBuffer(512);
                                    byte[] aRawBuffer = new byte[128];
                                    while (true) {
                                        try {
                                            int aCount = stream.read(aRawBuffer, 0, 128);
                                            if (aCount == -1) {
                                                break;
                                            }
                                            aBuffer.append(aRawBuffer, 0, aCount);
                                        } catch (IOException e) {
                                            Log.e(FeedAdapter.class.getSimpleName(), "Error reading stream", e);
                                        }
                                    }
                                    if (aBuffer.length() == 0) {
                                        return null;
                                    }
                                    aOptions.inJustDecodeBounds = true;
                                    BitmapFactory.decodeByteArray(aBuffer.buffer(), 0, aBuffer.length(), aOptions);
                                    aOptions.inSampleSize = FeedAdapter.calculateInSampleSize(aOptions, aValues[0], aValues[1]);
                                    aOptions.inJustDecodeBounds = false;
                                    return BitmapFactory.decodeByteArray(aBuffer.buffer(), 0, aBuffer.length(), aOptions);
                                }
                            }).processInputStream();
                            if (aBitmap != null) {
                                Bitmap aScaled = Bitmap.createScaledBitmap(aBitmap, aValues[0], aValues[1], false);
                                if (aScaled != aBitmap) {
                                    aBitmap.recycle();
                                }
                                aBitmap = aScaled;
                            }
                            if (aBitmap == null) {
                                aBitmap = FeedAdapter.this.mDefaultImage;
                            }
                            if (aDelegate.isPlayable()) {
                                aFinal = FeedAdapter.centerOverlay(aBitmap, FeedAdapter.this.mMediaIndicator);
                            } else {
                                aFinal = aBitmap;
                            }
                            FeedAdapter.this.mSystem.uiPost(new Runnable() {
                                public void run() {
                                    if (((Integer) aWrapper.mCover.getTag()).intValue() == i2) {
                                        aWrapper.mFuture = null;
                                        aWrapper.mCover.setBackgroundResource(C0116R.color.album_art_border);
                                        LayoutParams aParams = (LayoutParams) aWrapper.mCover.getLayoutParams();
                                        aParams.height = aFinal.getHeight();
                                        aParams.width = aFinal.getWidth();
                                        aWrapper.mCover.setLayoutParams(aParams);
                                        aWrapper.mCover.setImageBitmap(aFinal);
                                    }
                                }
                            });
                            FeedAdapter.this.attemptPut(i2, aFinal, aTargetUrl);
                            FeedAdapter.this.clearCache(i2);
                        } catch (StreamException e) {
                            Log.e(getClass().getSimpleName(), "Stream error", e);
                        }
                    }
                }
            });
        }
        clearCache(position);
        return convertView;
    }

    public static Bitmap centerOverlay(Bitmap pParent, Bitmap pCenterOver) {
        Bitmap aOverlayed = Bitmap.createBitmap(pParent.getWidth(), pParent.getHeight(), pParent.getConfig());
        Canvas aCanvas = new Canvas(aOverlayed);
        aCanvas.drawBitmap(pParent, 0.0f, 0.0f, null);
        aCanvas.drawBitmap(pCenterOver, (float) ((pParent.getWidth() / 2) - (pCenterOver.getWidth() / 2)), (float) ((pParent.getHeight() / 2) - (pCenterOver.getHeight() / 2)), null);
        return aOverlayed;
    }

    public static int[] rescale(int pImageWidth, int pImageHeight, int pDeviceWidth, int pDeviceHeight) {
        if (pImageWidth > pDeviceWidth) {
            float aScale = ((float) pDeviceWidth) / ((float) pImageWidth);
            pImageWidth = (int) (((float) pImageWidth) * aScale);
            pImageHeight = (int) (((float) pImageHeight) * aScale);
        }
        return new int[]{pImageWidth, pImageHeight};
    }

    protected void attemptPut(int pPosition, Bitmap pBitmap, String pTargetUrl) {
        if (this.mClearCache == null) {
            this.mPhotoBitmap.put(pTargetUrl, new PositionCache(pPosition, pBitmap));
        }
    }

    protected void clearCache(final int pPosition) {
        if (this.mClearCache == null && this.mPhotoBitmap.size() >= 12) {
            this.mClearCache = new Empty();
            this.mSystem.uiPost(new Runnable() {

                class C04221 extends AsyncTask<Integer, Void, Void> {
                    C04221() {
                    }

                    protected Void doInBackground(Integer... params) {
                        Integer aTarget = params[0];
                        ArrayList<Object[]> aDiffList = new ArrayList();
                        for (String aKey : FeedAdapter.this.mPhotoBitmap.keySet()) {
                            aDiffList.add(new Object[]{Integer.valueOf(((PositionCache) FeedAdapter.this.mPhotoBitmap.get(aKey)).getPosition() - aTarget.intValue()), aKey});
                        }
                        Collections.sort(aDiffList, new ListCompare());
                        while (FeedAdapter.this.mPhotoBitmap.size() > 8) {
                            String aDel = ((Object[]) aDiffList.get(0))[1];
                            aDiffList.remove(0);
                            FeedAdapter.this.mPhotoBitmap.remove(aDel);
                        }
                        return null;
                    }

                    protected void onPostExecute(Void result) {
                        FeedAdapter.this.mClearCache = null;
                    }
                }

                public void run() {
                    FeedAdapter.this.mClearCache = new C04221();
                    FeedAdapter.this.mClearCache.execute(new Integer[]{Integer.valueOf(pPosition)});
                }
            });
        }
    }

    public void setServerError(boolean pIsError) {
        this.mServerError = pIsError;
    }

    public void refreshDownload() {
    }
}
