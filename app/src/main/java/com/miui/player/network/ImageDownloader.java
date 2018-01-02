package com.miui.player.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import android.util.MiuiPools;
import android.util.Pair;
import android.util.Pool;
import android.util.PoolableManager;
import android.widget.ImageView;
import com.google.android.collect.Lists;
import com.miui.player.meta.AlbumManager;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.MetaManager;
import com.miui.player.plugin.PlugInManager;
import com.miui.player.plugin.base.PlugInInterface;
import com.miui.player.plugin.onlineimage.ImageItemInfo;
import com.miui.player.plugin.onlineimage.ImagePlugIn;
import com.miui.player.plugin.onlineimage.ImageProvider;
import com.miui.player.plugin.onlinemusic2.Album;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.provider.OnlineAudioDetailHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.FileOperations;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.ThreadManager;
import com.miui.player.util.ThreadManager.AsyncRequestCallback;
import com.miui.player.util.Utils;
import com.miui.player.util.XiaomiMusicProxy;
import com.xiaomi.music.util.NetworkUtil;
import com.xiaomi.music.util.StreamHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import miui.cache.PoolElement;
import miui.cache.RequestManager.Request;
import org.apache.http.client.ClientProtocolException;

public class ImageDownloader {
    static final String TAG = ImageDownloader.class.getName();

    public static class AlbumUrlListGetTask extends AsyncTask<Void, Void, ImageItemInfoList> {
        protected Context mContext;
        protected final ImageSearchInfo mMetaInfo;
        protected final ImageSearchInfo mSearchInfo;

        public AlbumUrlListGetTask(Context context, ImageSearchInfo metaInfo, ImageSearchInfo searchInfo) {
            this.mContext = context;
            this.mMetaInfo = metaInfo;
            this.mSearchInfo = searchInfo;
        }

        protected ImageItemInfoList doInBackground(Void... params) {
            if (TextUtils.isEmpty(this.mSearchInfo.mAlbumName) && TextUtils.isEmpty(this.mSearchInfo.mArtistName)) {
                return null;
            }
            return ImageDownloader.requestList(this.mContext, this.mSearchInfo);
        }
    }

    static class DownloadImageRequest implements Runnable {
        final AsyncRequestCallback<Boolean> mCallback;
        final Context mContext;
        final String mOnlineId;
        final ImageSearchInfo mSearchInfo;

        public DownloadImageRequest(Context context, ImageSearchInfo searchInfo, String onlineId, AsyncRequestCallback<Boolean> cbk) {
            this.mContext = context;
            this.mSearchInfo = searchInfo;
            this.mOnlineId = onlineId;
            this.mCallback = cbk;
        }

        public void run() {
            boolean success = ImageDownloader.download(this.mContext, this.mSearchInfo, this.mOnlineId);
            if (this.mCallback != null) {
                this.mCallback.setResult(Boolean.valueOf(success));
                this.mCallback.run();
            }
        }
    }

    public static class DownloadTaskToken {
        final AsyncTask<Void, ImageSearchInfo, Integer> mTask;

        public DownloadTaskToken(AsyncTask<Void, ImageSearchInfo, Integer> task) {
            this.mTask = task;
        }

        public boolean isFinished() {
            return this.mTask.isCancelled() || this.mTask.getStatus() == Status.FINISHED;
        }
    }

    public interface ImageDownloadController {
        List<ImageSearchInfo> getList(Context context);

        void onUpdate(ImageSearchInfo imageSearchInfo);
    }

    public static class ImageItemInfoList implements Parcelable {
        public static final Creator<ImageItemInfoList> CREATOR = new C03561();
        public final ArrayList<ImageItemInfo> mContent;
        private ImageProvider mProvider;
        private final int mProviderType;
        private final ImageSearchInfo mSearchInfo;

        static class C03561 implements Creator<ImageItemInfoList> {
            C03561() {
            }

            public ImageItemInfoList createFromParcel(Parcel source) {
                return new ImageItemInfoList(source);
            }

            public ImageItemInfoList[] newArray(int size) {
                return new ImageItemInfoList[size];
            }
        }

        public ImageItemInfoList(ArrayList<ImageItemInfo> content, ImageProvider provider) {
            this.mContent = content;
            if (provider != null) {
                this.mSearchInfo = provider.getImageSearchInfo();
                this.mProviderType = provider.getType();
                return;
            }
            this.mSearchInfo = null;
            this.mProviderType = -1;
        }

        public ImageProvider getProvider(Context context) {
            if (this.mProvider == null && this.mProviderType != -1) {
                this.mProvider = ImageDownloader.createProvider(context, this.mSearchInfo, this.mProviderType);
            }
            return this.mProvider;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeSerializable(this.mContent);
            dest.writeInt(this.mProviderType);
            dest.writeSerializable(this.mSearchInfo);
        }

        public ImageItemInfoList(Parcel src) {
            this.mContent = (ArrayList) src.readSerializable();
            this.mProviderType = src.readInt();
            this.mSearchInfo = (ImageSearchInfo) src.readSerializable();
        }
    }

    public static class ImageRequest extends PoolElement<ImageRequest> implements Request<String, Bitmap, Integer> {
        boolean mClipRound;
        boolean mForceSize;
        int mImageHeight;
        ImageSearchInfo mImageInfo;
        WeakReference<ImageView> mImageViewRef;
        int mImageWidth;
        String mKey;
        WeakReference<OnImageRequestCompeletedListener> mListener;
        Pool<ImageRequest> mPool;
        Integer mRemoveKey;

        static class C03571 implements PoolableManager<ImageRequest> {
            C03571() {
            }

            public ImageRequest newInstance() {
                return new ImageRequest();
            }

            public void onAcquired(ImageRequest element) {
            }

            public void onReleased(ImageRequest element) {
                element.mImageWidth = 0;
                element.mImageHeight = 0;
                element.mImageInfo = null;
                element.mImageViewRef = null;
                element.mKey = null;
                element.mRemoveKey = null;
            }
        }

        public void init(int width, int height, ImageSearchInfo imageInfo, ImageView imageView, Pool<ImageRequest> pool, boolean clipRound, boolean forceSize, OnImageRequestCompeletedListener l) {
            this.mImageWidth = width;
            this.mImageHeight = height;
            this.mImageInfo = imageInfo;
            this.mImageViewRef = new WeakReference(imageView);
            this.mKey = asKey(this.mImageInfo);
            this.mRemoveKey = Integer.valueOf(System.identityHashCode(imageView));
            this.mClipRound = clipRound;
            this.mForceSize = forceSize;
            this.mPool = pool;
            this.mListener = new WeakReference(l);
        }

        public void init(int width, int height, ImageSearchInfo imageInfo, ImageView imageView, Pool<ImageRequest> pool) {
            init(width, height, imageInfo, imageView, pool, true, true, null);
        }

        public String getKey() {
            return this.mKey;
        }

        public Bitmap computAsync() {
            Bitmap bm = null;
            Context context = MusicApplication.getApplication();
            switch (this.mImageInfo.mSearchType) {
                case 0:
                    bm = AlbumManager.getDisplayedAvatar(context, this.mImageInfo.mArtistName, this.mImageWidth, this.mImageHeight);
                    break;
                case 1:
                    bm = AlbumManager.getDisplayedAlbum(context, this.mImageInfo.mAlbumId, this.mImageInfo.mAlbumName, this.mImageInfo.mArtistName, true, this.mImageWidth, this.mImageHeight, this.mForceSize);
                    break;
            }
            if (!this.mClipRound || bm == null) {
                return bm;
            }
            return AlbumManager.clipRoundCorner(context, bm);
        }

        public void onCompleted(Bitmap value, boolean finalValue) {
            boolean hasSet = false;
            ImageView iv = (ImageView) this.mImageViewRef.get();
            if (iv != null) {
                String key = getKey();
                if (key != null && key.equals(iv.getTag())) {
                    hasSet = true;
                    iv.setImageBitmap(value);
                }
            }
            if (finalValue && this.mPool != null) {
                this.mPool.release(this);
            }
            OnImageRequestCompeletedListener l = (OnImageRequestCompeletedListener) this.mListener.get();
            if (l != null) {
                l.onImageRequestCompeleted(iv, value, finalValue, hasSet);
            }
        }

        public boolean needCache() {
            return true;
        }

        public boolean isRemovable() {
            ImageView view = (ImageView) this.mImageViewRef.get();
            if (view != null && getKey().equals(view.getTag())) {
                return false;
            }
            return true;
        }

        public Integer getRemoveKey() {
            return this.mRemoveKey;
        }

        public static String asKey(ImageSearchInfo info) {
            File file = MetaManager.getMainSdcardFile(info);
            return file != null ? file.getName() : MetaManager.UNKNOWN_STRING;
        }

        public void onRemoved() {
            if (this.mPool != null) {
                this.mPool.release(this);
            }
        }

        public static Pool<ImageRequest> createPool() {
            return MiuiPools.finitePool(new C03571(), 10);
        }
    }

    public interface OnImageRequestCompeletedListener {
        void onImageRequestCompeleted(ImageView imageView, Bitmap bitmap, boolean z, boolean z2);
    }

    static ImageItemInfoList requestList(Context context, ImageSearchInfo info) {
        return requestList(context, info, true);
    }

    static ImageItemInfoList requestList(Context context, ImageSearchInfo info, boolean downloadFromXiaomi) {
        ImageProvider provider = OnlineMusicProxy.createImageProvider(context, info, -1);
        List<ImageItemInfo> itemList = getItemList(provider);
        if (CollectionHelper.isEmpty(itemList)) {
            provider = createPluginProvider(context, info);
            itemList = getItemList(provider);
        }
        ImageItemInfoList imageItemInfoList = null;
        if (!CollectionHelper.isEmpty(itemList)) {
            ArrayList<ImageItemInfo> arrayList;
            if (itemList instanceof ArrayList) {
                arrayList = (ArrayList) itemList;
            } else {
                arrayList = Lists.newArrayList();
                arrayList.addAll(itemList);
            }
            imageItemInfoList = new ImageItemInfoList(arrayList, provider);
        }
        if (downloadFromXiaomi) {
            String url = XiaomiMusicProxy.requestAlbumArt(info);
            if (url != null) {
                if (imageItemInfoList == null) {
                    imageItemInfoList = new ImageItemInfoList(new ArrayList(1), null);
                }
                imageItemInfoList.mContent.add(0, new ImageItemInfo(url));
            }
        }
        return imageItemInfoList;
    }

    private static boolean requestItem(ImageProvider provider, ImageItemInfo info) {
        boolean z = false;
        if (!(info == null || provider == null)) {
            try {
                z = provider.requestItem(info);
            } catch (ClientProtocolException e) {
                Log.e(TAG, MetaManager.UNKNOWN_STRING, e);
            } catch (URISyntaxException e2) {
                Log.e(TAG, MetaManager.UNKNOWN_STRING, e2);
            } catch (IOException e3) {
                Log.e(TAG, MetaManager.UNKNOWN_STRING, e3);
            }
        }
        return z;
    }

    public static boolean downloadByUrl(Context context, ImageSearchInfo info, String url) {
        if (url == null) {
            return false;
        }
        InputStream is = OnlineMusicProxy.requestStream(context, url);
        if (is == null) {
            return false;
        }
        boolean success = saveImage(context, info, is);
        try {
            is.close();
            return success;
        } catch (IOException e) {
            return success;
        }
    }

    public static boolean download(Context context, ImageSearchInfo info) {
        return download(context, info, null);
    }

    public static boolean download(Context context, ImageSearchInfo info, String onlineId) {
        if (info == null || !info.isValid()) {
            return false;
        }
        String url;
        InputStream is = null;
        if (info.mSearchType == 1) {
            url = XiaomiMusicProxy.requestAlbumArt(info);
            if (url != null) {
                is = OnlineMusicProxy.requestStream(context, url);
            }
            if (is == null && onlineId != null) {
                url = OnlineAudioDetailHelper.queryAlbumPictureURL(context, onlineId);
                if (url != null) {
                    is = OnlineMusicProxy.requestStream(context, url);
                }
            }
        }
        if (is == null && onlineId != null && info.mSearchType == 1) {
            String albumId = OnlineAudioDetailHelper.queryAlbumId(context, onlineId);
            if (albumId != null) {
                Pair<Album, AudioList> pair = OnlineMusicProxy.requestAlbum(context, albumId, null, 2);
                if (!(pair == null || pair.first == null || ((Album) pair.first).mOutline == null)) {
                    url = ((Album) pair.first).mOutline.getBestImageURL();
                    if (url != null) {
                        is = OnlineMusicProxy.requestStream(context, url);
                    }
                }
            }
        }
        if (is == null) {
            ImageItemInfoList list = requestList(context, info, false);
            if (list == null || list.mContent == null || list.mContent.isEmpty()) {
                return false;
            }
            ImageProvider provider = list.getProvider(context);
            if (provider != null) {
                Iterator i$ = list.mContent.iterator();
                while (i$.hasNext()) {
                    ImageItemInfo item = (ImageItemInfo) i$.next();
                    if (requestItem(provider, item) && item.mInputStream != null) {
                        is = item.mInputStream;
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        if (is == null) {
            return false;
        }
        boolean success = saveImage(context, info, is);
        StreamHelper.closeSafe(is);
        return success;
    }

    private static boolean saveImage(Context context, ImageSearchInfo info, InputStream is) {
        FileNotFoundException e;
        Throwable th;
        File file = MetaManager.getMainSdcardFile(info);
        if (file != null && file.exists()) {
            return true;
        }
        if (file != null && MetaManager.makeDirIfNotExists(context, MetaManager.getMetaType(info))) {
            OutputStream os;
            OutputStream os2 = null;
            try {
                os = new FileOutputStream(file.getAbsolutePath());
            } catch (FileNotFoundException e2) {
                e = e2;
                try {
                    Log.e(TAG, MetaManager.UNKNOWN_STRING, e);
                    if (os2 != null) {
                        try {
                            os2.close();
                        } catch (IOException e3) {
                            Log.e(TAG, MetaManager.UNKNOWN_STRING, e3);
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (os2 != null) {
                        try {
                            os2.close();
                        } catch (IOException e32) {
                            Log.e(TAG, MetaManager.UNKNOWN_STRING, e32);
                        }
                    }
                    throw th;
                }
            }
            try {
                FileOperations.copyFile(is, os);
                if (os == null) {
                    return true;
                }
                try {
                    os.close();
                    return true;
                } catch (IOException e322) {
                    Log.e(TAG, MetaManager.UNKNOWN_STRING, e322);
                    return true;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                os2 = os;
                Log.e(TAG, MetaManager.UNKNOWN_STRING, e);
                if (os2 != null) {
                    os2.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                os2 = os;
                if (os2 != null) {
                    os2.close();
                }
                throw th;
            }
        }
        return false;
    }

    public static void downloadAsync(Context context, ImageSearchInfo info, String onlineId, AsyncRequestCallback<Boolean> cbk) {
        ThreadManager.postNetworkRequest(new DownloadImageRequest(context, info, onlineId, cbk));
    }

    public static boolean allowImageDownload(Context context) {
        return !NetworkUtil.isActiveNetworkMetered(context) || PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_DOWNLOAD_ALBUM_OTHER);
    }

    public static boolean cancleDownload(DownloadTaskToken token) {
        if (token == null || token.mTask == null) {
            return false;
        }
        token.mTask.cancel(true);
        return true;
    }

    public static DownloadTaskToken downloadAll(final ImageDownloadController controller) {
        final Context context = MusicApplication.getApplication();
        if (!allowImageDownload(context)) {
            return null;
        }
        AsyncTask<Void, ImageSearchInfo, Integer> task = new AsyncTask<Void, ImageSearchInfo, Integer>() {
            protected Integer doInBackground(Void... params) {
                List<ImageSearchInfo> list = null;
                if (controller != null) {
                    list = controller.getList(context);
                }
                if (list == null || list.isEmpty()) {
                    return Integer.valueOf(0);
                }
                Utils.debugLog(ImageDownloader.TAG, "try to download image, count=" + list.size());
                int count = 0;
                for (ImageSearchInfo info : list) {
                    if (isCancelled() || !ImageDownloader.allowImageDownload(context)) {
                        return Integer.valueOf(count);
                    }
                    boolean success = false;
                    try {
                        success = ImageDownloader.download(context, info);
                    } catch (OutOfMemoryError e) {
                        Log.e(ImageDownloader.TAG, MetaManager.UNKNOWN_STRING, e);
                    }
                    if (success) {
                        Utils.debugLog(ImageDownloader.TAG, "%d: %s", Integer.valueOf(count), info);
                        count++;
                        publishProgress(new ImageSearchInfo[]{info});
                    }
                }
                return Integer.valueOf(count);
            }

            protected void onProgressUpdate(ImageSearchInfo... infoArr) {
                ImageSearchInfo info = infoArr[0];
                if (controller != null) {
                    controller.onUpdate(info);
                }
            }

            protected void onPostExecute(Integer result) {
                super.onPostExecute(result);
                Utils.debugLog(ImageDownloader.TAG, "total success=" + result);
            }
        };
        task.execute(new Void[0]);
        return new DownloadTaskToken(task);
    }

    static List<ImageItemInfo> getItemList(ImageProvider provider) {
        if (provider != null) {
            try {
                return provider.requestList();
            } catch (ClientProtocolException e) {
                Log.e(TAG, "createProvider", e);
            } catch (URISyntaxException e2) {
                Log.e(TAG, "createProvider", e2);
            } catch (IOException e3) {
                Log.e(TAG, "createProvider", e3);
            }
        }
        return null;
    }

    static ImageProvider createPluginProvider(Context context, ImageSearchInfo info) {
        return createProvider(context, info, -1);
    }

    static ImageProvider createProvider(Context context, ImageSearchInfo info, int type) {
        if (type >= 1000) {
            return OnlineMusicProxy.createImageProvider(context, info, type);
        }
        if (info.mSearchType == 1) {
            PlugInInterface pii = PlugInManager.instance(1).getPlugInInterface();
            try {
                if (pii instanceof ImagePlugIn) {
                    return ((ImagePlugIn) pii).create(info, type);
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
        return null;
    }

    static void statistics(boolean success) {
        PlugInManager mgr = PlugInManager.tryToGetInstance(1);
        if (mgr != null) {
            mgr.statistics(success);
        }
    }
}
