package com.songbirdnest.mediaplayer.view.adapter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.view.MosaicCollection.MosaicBackend;
import com.songbirdnest.mediaplayer.widgets.AnimationImage;
import com.songbirdnest.soundboard.data.CollectionImage.STATUS;
import com.songbirdnest.util.ImageDownloadRunnable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MosaicAdapter extends BaseAdapter {
    AsyncTask<Integer, Void, Void> aClearTask;
    protected MosaicBackend mBackend;
    ActionDelegate mDelegate;
    protected ExecutorService mDownloadExecutator;
    protected boolean mHasCollection = true;
    protected LayoutInflater mInflater;
    protected float mItemSize;
    protected Map<String, PositionCache<Bitmap>> mPhotoCache;
    protected Resources mResources;
    protected Handler mUIHandler;
    protected Bitmap missingResourceImage;
    protected Bitmap smallMissingResourceImage;

    public interface ActionDelegate {
        void displayFeed(String str, String str2, boolean z);

        String getPhoto(String str);

        int[] getTargets();

        void queryFollow(int i);

        void writeBitmap(Bitmap bitmap, String str);
    }

    class C04374 extends AsyncTask<Integer, Void, Void> {
        C04374() {
        }

        protected Void doInBackground(Integer... params) {
            Integer aTarget = params[0];
            ArrayList<Object[]> aDiffList = new ArrayList();
            for (String aKey : MosaicAdapter.this.mPhotoCache.keySet()) {
                aDiffList.add(new Object[]{Integer.valueOf(((PositionCache) MosaicAdapter.this.mPhotoCache.get(aKey)).getPosition() - aTarget.intValue()), aKey});
            }
            Collections.sort(aDiffList, new ListCompare());
            while (MosaicAdapter.this.mPhotoCache.size() > 12) {
                String aDel = ((Object[]) aDiffList.get(0))[1];
                aDiffList.remove(0);
                MosaicAdapter.this.mPhotoCache.remove(aDel);
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            MosaicAdapter.this.aClearTask = null;
        }
    }

    class C04385 implements Runnable {
        C04385() {
        }

        public void run() {
            MosaicAdapter.this.notifyDataSetChanged();
        }
    }

    static class ViewWrapper {
        ImageView mImage;
        View mParent;
        Future<?> mRunnable;
        TextView mText;

        public ViewWrapper(View pParent) {
            this.mImage = (ImageView) pParent.findViewById(C0116R.id.mosaic_collection_image);
            this.mText = (TextView) pParent.findViewById(C0116R.id.mosaic_collection_text);
            pParent.setTag(this);
            this.mParent = pParent;
        }

        public void reset() {
            if (this.mRunnable != null) {
                this.mRunnable.cancel(true);
                this.mRunnable = null;
            }
            this.mParent.setVisibility(0);
        }

        public void noItem() {
            this.mParent.setVisibility(4);
        }
    }

    public MosaicAdapter(LayoutInflater pInflater, MosaicBackend pBackend, Resources pResources, Handler pUIHandler, ActionDelegate pDelegate) {
        this.mInflater = pInflater;
        this.mBackend = pBackend;
        this.mDelegate = pDelegate;
        this.mResources = pResources;
        this.mPhotoCache = new HashMap();
        this.mDownloadExecutator = Executors.newFixedThreadPool(2);
        this.mUIHandler = pUIHandler;
        this.mItemSize = 150.0f * this.mResources.getDisplayMetrics().density;
        this.smallMissingResourceImage = BitmapFactory.decodeResource(this.mResources, C0116R.drawable.generic_artist_small);
        this.missingResourceImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mResources, C0116R.drawable.generic_artist_big), (int) this.mItemSize, (int) this.mItemSize, false);
    }

    public int getCount() {
        int aCount = this.mBackend.getCount();
        if (aCount == 0) {
            return 0 + 1;
        }
        if (aCount % this.mDelegate.getTargets().length == 0) {
            return 0 + (aCount / this.mDelegate.getTargets().length);
        }
        return 0 + ((aCount / this.mDelegate.getTargets().length) + 1);
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (this.mBackend.getCount() == 0) {
            return createLoading(parent);
        }
        ViewWrapper[] aWrappers;
        if (convertView == null || convertView.getTag() != null) {
            convertView = this.mInflater.inflate(C0116R.layout.mosaic_collection_row, parent, false);
            aWrappers = getWrappers(convertView, this.mDelegate.getTargets());
        } else {
            aWrappers = getWrappers(convertView, this.mDelegate.getTargets(), true);
        }
        position *= this.mDelegate.getTargets().length;
        for (ViewWrapper aWrapper : aWrappers) {
            if (this.mBackend.getCount() > position) {
                populateItem(aWrapper, position);
                position++;
            } else {
                aWrapper.noItem();
            }
        }
        return convertView;
    }

    protected ViewWrapper[] getWrappers(View pTargetView, int[] pTargets) {
        return getWrappers(pTargetView, pTargets, false);
    }

    protected ViewWrapper[] getWrappers(View pTargetView, int[] pTargets, boolean aReset) {
        ViewWrapper[] aWrappers = new ViewWrapper[pTargets.length];
        int count = 0;
        for (int aTarget : pTargets) {
            aWrappers[count] = new ViewWrapper(pTargetView.findViewById(aTarget));
            if (aReset) {
                aWrappers[count].reset();
            }
            count++;
        }
        return aWrappers;
    }

    protected View createLoading(ViewGroup pParent) {
        View convertView = this.mInflater.inflate(C0116R.layout.face_item, pParent, false);
        FriendAdapter.ViewWrapper aWrapper = new FriendAdapter.ViewWrapper(convertView);
        aWrapper.mImage.setBackgroundDrawable(null);
        if (this.mHasCollection) {
            AnimationDrawable aAnimation = (AnimationDrawable) this.mResources.getDrawable(C0116R.drawable.spinner);
            aWrapper.mImage.setImageDrawable(aAnimation);
            aWrapper.mText.setText(this.mResources.getString(C0116R.string.soundboard_following_loading));
            ((AnimationImage) aWrapper.mImage).setAnimation(aAnimation);
        } else {
            aWrapper.mImage.setImageBitmap(this.smallMissingResourceImage);
            aWrapper.mText.setText(this.mResources.getString(C0116R.string.soundboard_following_none));
        }
        convertView.setTag(aWrapper);
        return convertView;
    }

    void populateItem(ViewWrapper pWrapper, final int pPosition) {
        pWrapper.mText.setText(this.mBackend.getItemName(pPosition));
        pWrapper.mImage.setTag(Integer.valueOf(pPosition));
        pWrapper.mImage.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View v) {
                MosaicAdapter.this.mDelegate.queryFollow(pPosition);
                return true;
            }
        });
        final String aArtistID = this.mBackend.getArtistId(pPosition);
        pWrapper.mImage.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                MosaicAdapter.this.mDelegate.displayFeed(aArtistID, MosaicAdapter.this.mBackend.getItemName(pPosition), MosaicAdapter.this.mBackend.isFollowing(pPosition));
            }
        });
        String aPhotoUrl = this.mBackend.getPhotoUrl(pPosition);
        if (aPhotoUrl == null || aPhotoUrl.length() == 0) {
            pWrapper.mImage.setImageBitmap(this.missingResourceImage);
            return;
        }
        if (this.mPhotoCache.containsKey(aPhotoUrl)) {
            pWrapper.mImage.setImageBitmap((Bitmap) ((PositionCache) this.mPhotoCache.get(aPhotoUrl)).getValue());
        } else {
            String aPhotoPath = this.mDelegate.getPhoto(aArtistID);
            if (aPhotoPath != null) {
                Bitmap aMap = BitmapFactory.decodeFile(aPhotoPath);
                attemptPut(aPhotoUrl, aMap, pPosition);
                pWrapper.mImage.setImageBitmap(aMap);
            } else if (aPhotoUrl.equals(STATUS.FAILED.toString())) {
                attemptPut(aPhotoUrl, this.missingResourceImage, pPosition);
                pWrapper.mImage.setImageBitmap(this.missingResourceImage);
                return;
            } else {
                AnimationDrawable aDrawable = (AnimationDrawable) this.mResources.getDrawable(C0116R.drawable.spinner);
                pWrapper.mImage.setImageDrawable(aDrawable);
                ((AnimationImage) pWrapper.mImage).setAnimation(aDrawable);
                pWrapper.mImage.setLayoutParams(getLayoutCustom((int) this.mItemSize));
                if (!aPhotoUrl.equals(STATUS.PENDING.toString())) {
                    final String str = aPhotoUrl;
                    final int i = pPosition;
                    final ViewWrapper viewWrapper = pWrapper;
                    pWrapper.mRunnable = this.mDownloadExecutator.submit(new ImageDownloadRunnable((int) this.mItemSize, aPhotoUrl) {
                        public void onPostExecute(Bitmap pResult) {
                            Bitmap result;
                            if (pResult == null) {
                                result = MosaicAdapter.this.missingResourceImage;
                            } else {
                                result = pResult;
                            }
                            MosaicAdapter.this.attemptPut(str, result, i);
                            MosaicAdapter.this.mDelegate.writeBitmap(result, aArtistID);
                            MosaicAdapter.this.mUIHandler.post(new Runnable() {
                                public void run() {
                                    if (viewWrapper.mImage.getTag().equals(Integer.valueOf(i))) {
                                        viewWrapper.mImage.setImageBitmap(result);
                                        viewWrapper.mImage.setLayoutParams(MosaicAdapter.getLayout());
                                    }
                                    viewWrapper.mRunnable = null;
                                }
                            });
                            MosaicAdapter.this.clearCache(i);
                        }
                    });
                } else {
                    return;
                }
            }
        }
        clearCache(pPosition);
    }

    private void attemptPut(String pKey, Bitmap pBitmap, int pPosition) {
        if (this.aClearTask == null) {
            this.mPhotoCache.put(pKey, new PositionCache(pPosition, pBitmap));
        }
    }

    private void clearCache(int pReturn) {
        if (this.aClearTask == null && this.mPhotoCache.size() > 24) {
            this.aClearTask = new C04374().execute(new Integer[]{Integer.valueOf(pReturn)});
        }
    }

    public void clear() {
        if (this.aClearTask != null) {
            this.mPhotoCache.clear();
        }
        notifyDataSetChanged();
    }

    static LayoutParams getLayout() {
        return getLayoutCustom(-2);
    }

    static LayoutParams getLayoutCustom(int pValue) {
        LayoutParams aLayout = new LayoutParams(pValue, pValue);
        aLayout.addRule(13);
        return aLayout;
    }

    public void setHasCollection(boolean pHasCollection) {
        this.mHasCollection = pHasCollection;
        this.mUIHandler.post(new C04385());
    }
}
