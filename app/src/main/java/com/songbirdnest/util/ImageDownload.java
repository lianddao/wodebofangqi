package com.songbirdnest.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.analytics.Breadcrumbs;
import com.songbirdnest.mediaplayer.service.FlickrParms;
import com.songbirdnest.mediaplayer.service.FlushedInputStream;
import com.songbirdnest.mediaplayer.service.IPhotoStreamCallback;
import com.songbirdnest.mediaplayer.service.UIState;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ImageDownload extends AsyncTask<Void, Void, Bitmap> {
    HashMap<Integer, Bitmap> mBitmapHash;
    IPhotoStreamCallback mCallback;
    ArrayList<FlickrParms> mItemList;
    Handler mPhotoHandler;
    UIState mState;
    int mTarget;

    public ImageDownload(IPhotoStreamCallback aCallback, int aTarget, HashMap<Integer, Bitmap> pBitmapHash, ArrayList<FlickrParms> pItemList, UIState pState, Handler pPhotoHandler) {
        this.mCallback = aCallback;
        this.mBitmapHash = pBitmapHash;
        this.mTarget = aTarget;
        this.mItemList = pItemList;
        this.mState = pState;
        this.mPhotoHandler = pPhotoHandler;
        Breadcrumbs.add(Analytics.EVENT_FLICKR_IMAGE);
    }

    protected Bitmap doInBackground(Void... params) {
        if (this.mBitmapHash.containsKey(Integer.valueOf(this.mTarget))) {
            return (Bitmap) this.mBitmapHash.get(Integer.valueOf(this.mTarget));
        }
        try {
            if (this.mTarget >= this.mItemList.size()) {
                return null;
            }
            Bitmap tempBitmap = BitmapFactory.decodeStream(new FlushedInputStream(new URL(((FlickrParms) this.mItemList.get(this.mTarget)).getPhotoURL()).openConnection().getInputStream()));
            this.mBitmapHash.put(Integer.valueOf(this.mTarget), tempBitmap);
            return tempBitmap;
        } catch (OutOfMemoryError oe) {
            oe.printStackTrace();
            Log.e("Photo", "Image too big for VM. Out of memory.");
            this.mBitmapHash.clear();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Photo", "Image failed to download or decode.");
            return null;
        }
    }

    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        Log.i("Tracker", "Bitmap: " + result);
        if (result != null) {
            try {
                if (this.mState.isPhotostreamOn()) {
                    this.mCallback.imageDone(result);
                    return;
                }
                return;
            } catch (RemoteException e) {
                e.printStackTrace();
                return;
            }
        }
        Message msg = new Message();
        msg.obj = this.mCallback;
        msg.arg1 = this.mTarget;
        this.mPhotoHandler.sendMessageDelayed(msg, 500);
    }
}
