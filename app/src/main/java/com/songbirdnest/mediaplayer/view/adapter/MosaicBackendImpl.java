package com.songbirdnest.mediaplayer.view.adapter;

import android.os.AsyncTask.Status;
import android.util.Log;
import com.songbirdnest.mediaplayer.view.MosaicCollection.MosaicBackend;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.Collection;
import com.songbirdnest.soundboard.data.CollectionImage;
import com.songbirdnest.soundboard.data.CollectionImage.STATUS;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class MosaicBackendImpl implements MosaicBackend {
    protected List<Collection> mCollectionList = new ArrayList();
    String mFacebookID;
    ArrayList<ScheduledFuture<?>> mFutureRunnables = new ArrayList();
    ScheduledExecutorService mURLDownload;
    Runnable mUpdate;

    public static abstract class ImageUpdate implements Runnable {
        int mCycleCount = 0;
        String mTargetURL;

        public abstract void reset();

        public abstract void setPhoto(CollectionImage collectionImage);

        public ImageUpdate(String pTargetURL) {
            this.mTargetURL = pTargetURL;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r6 = this;
            r2 = 0;
            r4 = r6.mCycleCount;
            r4 = r4 + 1;
            r6.mCycleCount = r4;
            r3 = new com.songbirdnest.stream.StreamProcessor;
            r4 = r6.mTargetURL;
            r5 = new com.songbirdnest.mediaplayer.view.adapter.MosaicBackendImpl$ImageStreamHandler;
            r5.<init>();
            r3.<init>(r4, r5);
            r0 = r3.processInputStream();	 Catch:{ StreamException -> 0x0034 }
            r0 = (com.songbirdnest.soundboard.data.CollectionImage) r0;	 Catch:{ StreamException -> 0x0034 }
            if (r0 != 0) goto L_0x001c;
        L_0x001b:
            return;
        L_0x001c:
            r4 = r6.mCycleCount;	 Catch:{ StreamException -> 0x0034 }
            r5 = 4;
            if (r4 < r5) goto L_0x0022;
        L_0x0021:
            r2 = 1;
        L_0x0022:
            r4 = r0.getStatus();	 Catch:{ StreamException -> 0x0034 }
            r5 = com.songbirdnest.soundboard.data.CollectionImage.STATUS.PENDING;	 Catch:{ StreamException -> 0x0034 }
            r4 = r4.equals(r5);	 Catch:{ StreamException -> 0x0034 }
            if (r4 == 0) goto L_0x0041;
        L_0x002e:
            if (r2 != 0) goto L_0x0041;
        L_0x0030:
            r6.reset();	 Catch:{ StreamException -> 0x0034 }
            goto L_0x001b;
        L_0x0034:
            r1 = move-exception;
            r4 = "ImageCheck";
            r5 = "Problems checking Image";
            android.util.Log.e(r4, r5, r1);
            r4 = 0;
            r6.setPhoto(r4);
            goto L_0x001b;
        L_0x0041:
            if (r2 != 0) goto L_0x004f;
        L_0x0043:
            r4 = r0.getStatus();	 Catch:{ StreamException -> 0x0034 }
            r5 = com.songbirdnest.soundboard.data.CollectionImage.STATUS.FAILED;	 Catch:{ StreamException -> 0x0034 }
            r4 = r4.equals(r5);	 Catch:{ StreamException -> 0x0034 }
            if (r4 == 0) goto L_0x0054;
        L_0x004f:
            r4 = com.songbirdnest.soundboard.data.CollectionImage.STATUS.FAILED;	 Catch:{ StreamException -> 0x0034 }
            r0.setStatus(r4);	 Catch:{ StreamException -> 0x0034 }
        L_0x0054:
            r6.setPhoto(r0);	 Catch:{ StreamException -> 0x0034 }
            goto L_0x001b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.songbirdnest.mediaplayer.view.adapter.MosaicBackendImpl.ImageUpdate.run():void");
        }
    }

    static class ImageStreamHandler extends AbstractStreamHandler<CollectionImage> {
        ImageStreamHandler() {
        }

        public CollectionImage processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                JSONObject aJsonObject = new JSONObject(readInputStream(stream));
                CollectionImage aImage = new CollectionImage();
                if (aJsonObject.has("status") && aJsonObject.has("url")) {
                    aImage.setStatus(STATUS.parseStatus(aJsonObject.getString("status")));
                    aImage.setUrl(aJsonObject.getString("url"));
                    return aImage;
                }
            } catch (Exception e) {
                Log.e("ImageCheck", "Problem checking image");
            }
            return null;
        }
    }

    public MosaicBackendImpl(Runnable pUpdate) {
        this.mUpdate = pUpdate;
        this.mURLDownload = Executors.newScheduledThreadPool(1);
    }

    public int getCount() {
        return this.mCollectionList.size();
    }

    public void reset(String pFacebookID) {
        this.mFacebookID = pFacebookID;
        this.mCollectionList.clear();
        Iterator i$ = this.mFutureRunnables.iterator();
        while (i$.hasNext()) {
            ((ScheduledFuture) i$.next()).cancel(true);
        }
        this.mFutureRunnables.clear();
    }

    protected void done() {
        Iterator i$ = this.mFutureRunnables.iterator();
        while (i$.hasNext()) {
            ((ScheduledFuture) i$.next()).cancel(true);
        }
        if (this.mUpdate != null) {
            this.mUpdate.run();
        }
    }

    public void setList(List<Collection> pCollectionList, String pFacebookID) {
        if (pFacebookID.equals(this.mFacebookID)) {
            this.mCollectionList = pCollectionList;
            done();
        }
    }

    public void removeArtist(String artistId) {
        for (Collection collection : this.mCollectionList) {
            if (artistId.equalsIgnoreCase(collection.getArtistId())) {
                this.mCollectionList.remove(collection);
                return;
            }
        }
    }

    public void setPhoto(int pPosition, CollectionImage pImage) {
        ((Collection) this.mCollectionList.get(pPosition)).setImage(pImage);
    }

    public String getPhotoUrl(final int pPosition) {
        CollectionImage aImage = ((Collection) this.mCollectionList.get(pPosition)).getImage();
        if (aImage == null) {
            return null;
        }
        if (aImage.getStatus().equals(STATUS.FAILED)) {
            return STATUS.FAILED.toString();
        }
        if (!aImage.getStatus().equals(STATUS.PENDING)) {
            return aImage.getUrl();
        }
        ((Collection) this.mCollectionList.get(pPosition)).getArtistId();
        ArrayList<String> params = new ArrayList();
        params.add(((Collection) this.mCollectionList.get(pPosition)).getArtistId());
        params.add("image");
        this.mFutureRunnables.add(this.mURLDownload.schedule(new ImageUpdate(StreamUtils.buildURLString(SoundboardServer.get().getServer(), "artists", params)) {
            public void reset() {
                MosaicBackendImpl.this.mFutureRunnables.add(MosaicBackendImpl.this.mURLDownload.schedule(this, 2, TimeUnit.SECONDS));
            }

            public void setPhoto(CollectionImage pImage) {
                MosaicBackendImpl.this.setPhoto(pPosition, pImage);
                MosaicBackendImpl.this.done();
            }
        }, 2, TimeUnit.SECONDS));
        return Status.PENDING.toString();
    }

    public String getItemName(int pPosition) {
        return ((Collection) this.mCollectionList.get(pPosition)).getArtistName();
    }

    public String getArtistId(int pPosition) {
        return ((Collection) this.mCollectionList.get(pPosition)).getArtistId();
    }

    public boolean isFollowing(int pPosition) {
        return ((Collection) this.mCollectionList.get(pPosition)).isCollected();
    }
}
