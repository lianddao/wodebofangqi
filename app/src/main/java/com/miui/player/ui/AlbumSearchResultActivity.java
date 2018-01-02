package com.miui.player.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.meta.AlbumManager;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.ImageDownloader.ImageItemInfoList;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.plugin.onlineimage.ImageItemInfo;
import com.miui.player.plugin.onlineimage.ImageProvider;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.util.FileOperations;
import com.miui.player.util.StorageCache;
import com.miui.player.util.ThreadManager;
import com.miui.player.util.ThreadManager.AsyncRequestCallback;
import com.xiaomi.music.util.NetworkUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import miui.cache.RequestManager;
import miui.cache.RequestManager.Request;
import miui.util.ImageUtils;
import miui.util.InputStreamLoader;

public class AlbumSearchResultActivity extends MusicBaseActivity {
    public static final String ALBUM_NAME = "album";
    public static final String ARTIST_NAME = "artist";
    public static final String RAW_ALBUM_NAME = "raw_album";
    public static final String RAW_ARTIST_NAME = "raw_artist";
    public static final String SAVE_PATH = "save_path";
    public static final String SEARCH_RESULT = "search_result";
    static final String TAG = AlbumSearchResultActivity.class.getName();
    private GridView mAlbumGridView;
    int mAlbumSize;
    final Handler mHandler = new Handler();
    ProgressDialog mProgressDialog;
    RequestManager<String, BitmapInfo, Integer> mRequestManager;
    String mSavePath;
    ImageItemInfoList mSearchResult;

    private class AlbumArrayAdapter extends BaseAdapter {
        private final List<ImageItemInfo> mImageItemInfos;
        private final LayoutInflater mInflater;

        public AlbumArrayAdapter(List<ImageItemInfo> infos, ImageProvider provider) {
            this.mInflater = LayoutInflater.from(AlbumSearchResultActivity.this);
            this.mImageItemInfos = infos;
        }

        public int getCount() {
            return this.mImageItemInfos.size();
        }

        public Object getItem(int position) {
            return this.mImageItemInfos.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                v = this.mInflater.inflate(C0329R.layout.album_search_grid_item, parent, false);
            }
            ImageItemInfo info = (ImageItemInfo) this.mImageItemInfos.get(position);
            ProgressBar loadingBar = (ProgressBar) v.findViewById(C0329R.id.loading_in_progres_bar);
            if (AlbumSearchResultActivity.this.mRequestManager.request(new ImageRequest(info, AlbumSearchResultActivity.this.mAlbumSize, AlbumSearchResultActivity.this.mAlbumSize, AlbumSearchResultActivity.this.getApplication(), v))) {
                loadingBar.setVisibility(8);
            } else {
                loadingBar.setVisibility(0);
            }
            AlbumSearchResultActivity.updateSizeText((TextView) v.findViewById(C0329R.id.album_size), info.mURL, info.mWidth, info.mHeight);
            return v;
        }
    }

    private static class BitmapInfo {
        public final Bitmap mContent;
        public final int mRawHeight;
        public final int mRawWidth;

        public BitmapInfo(Bitmap content, int w, int h) {
            this.mContent = content;
            this.mRawWidth = w;
            this.mRawHeight = h;
        }
    }

    private static class ImageRequest implements Request<String, BitmapInfo, Integer> {
        final Context mContext;
        final int mImageHeight;
        final int mImageWidth;
        final ImageItemInfo mItemInfo;
        final String mKey;
        final Integer mRemoveKey;
        final WeakReference<View> mViewRef;

        public ImageRequest(ImageItemInfo info, int width, int height, Context context, View view) {
            this.mItemInfo = info;
            this.mKey = info.mURL;
            this.mImageWidth = width;
            this.mImageHeight = height;
            this.mContext = context;
            this.mViewRef = new WeakReference(view);
            view.setTag(info.mURL);
            this.mRemoveKey = Integer.valueOf(System.identityHashCode(view));
        }

        public String getKey() {
            return this.mKey;
        }

        public BitmapInfo computAsync() {
            if (this.mKey == null) {
                return null;
            }
            File file;
            Bitmap bm = null;
            Options opt = null;
            if (this.mKey.startsWith("content://")) {
                Uri uri = Uri.parse(this.mKey);
                bm = AlbumManager.getBitmapFromUri(this.mContext, uri, this.mImageWidth, this.mImageHeight);
                if (bm != null) {
                    opt = ImageUtils.getBitmapSize(new InputStreamLoader(this.mContext, uri));
                }
            }
            if (bm == null) {
                file = StorageCache.peekFile(NetworkUtil.encode(this.mKey), null);
                if (file != null) {
                    bm = AlbumManager.getBitmapFromFile(file.getAbsolutePath(), this.mImageWidth, this.mImageHeight);
                    if (bm != null) {
                        opt = ImageUtils.getBitmapSize(file.getAbsolutePath());
                    }
                }
            }
            if (bm == null) {
                InputStream is = OnlineMusicProxy.requestStream(this.mContext, this.mKey);
                if (is != null) {
                    file = StorageCache.saveInputStream(NetworkUtil.encode(this.mKey), null, is);
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                    if (file != null) {
                        bm = AlbumManager.getBitmapFromFile(file.getAbsolutePath(), this.mImageWidth, this.mImageHeight);
                        if (bm != null) {
                            opt = ImageUtils.getBitmapSize(file.getAbsolutePath());
                        }
                    }
                }
            }
            if (bm == null || opt == null) {
                return null;
            }
            return new BitmapInfo(bm, opt.outWidth, opt.outHeight);
        }

        public void onCompleted(BitmapInfo value, boolean finalValue) {
            if (finalValue) {
                View v = (View) this.mViewRef.get();
                if (v != null) {
                    String key = getKey();
                    if (key != null && key.equals(v.getTag())) {
                        ImageView iv = (ImageView) v.findViewById(C0329R.id.album_image);
                        ProgressBar bar = (ProgressBar) v.findViewById(C0329R.id.loading_in_progres_bar);
                        TextView tv = (TextView) v.findViewById(C0329R.id.album_size);
                        if (value != null) {
                            this.mItemInfo.mWidth = value.mRawWidth;
                            this.mItemInfo.mHeight = value.mRawHeight;
                            AlbumSearchResultActivity.updateSizeText(tv, this.mKey, value.mRawWidth, value.mRawHeight);
                            iv.setImageBitmap(value.mContent);
                            iv.setVisibility(0);
                            bar.setVisibility(8);
                        }
                    }
                }
            }
        }

        public boolean needCache() {
            return true;
        }

        public boolean isRemovable() {
            View view = (View) this.mViewRef.get();
            if (view != null && getKey().equals(view.getTag())) {
                return false;
            }
            return true;
        }

        public Integer getRemoveKey() {
            return this.mRemoveKey;
        }

        public void onRemoved() {
        }
    }

    private class OnBitmapSelectListener implements OnItemClickListener {

        class C04261 implements OnCancelListener {
            C04261() {
            }

            public void onCancel(DialogInterface dialog) {
                AlbumSearchResultActivity.this.mProgressDialog = null;
            }
        }

        OnBitmapSelectListener() {
        }

        public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
            Throwable th;
            ImageProvider provider = AlbumSearchResultActivity.this.mSearchResult.getProvider(AlbumSearchResultActivity.this.getApplication());
            ImageItemInfo info = (ImageItemInfo) AlbumSearchResultActivity.this.mSearchResult.mContent.get(position);
            String url = info.mURL;
            File f = StorageCache.peekFile(NetworkUtil.encode(url), null);
            if (f != null) {
                if (MetaManager.makeDirIfNotExists(AlbumSearchResultActivity.this.getApplication(), "album")) {
                    f.renameTo(new File(AlbumSearchResultActivity.this.mSavePath));
                    AlbumSearchResultActivity.this.notifyDownload();
                }
                AlbumSearchResultActivity.this.finish();
            } else if (url.startsWith("content://")) {
                InputStream is = null;
                OutputStream os = null;
                try {
                    is = AlbumSearchResultActivity.this.getContentResolver().openInputStream(Uri.parse(url));
                    if (is != null) {
                        OutputStream os2 = new FileOutputStream(AlbumSearchResultActivity.this.mSavePath);
                        try {
                            FileOperations.copyFile(is, os2);
                            AlbumSearchResultActivity.this.notifyDownload();
                            os = os2;
                        } catch (FileNotFoundException e) {
                            os = os2;
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (IOException e2) {
                                }
                            }
                            if (os != null) {
                                os.close();
                            }
                            AlbumSearchResultActivity.this.finish();
                        } catch (Throwable th2) {
                            th = th2;
                            os = os2;
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (IOException e3) {
                                }
                            }
                            if (os != null) {
                                try {
                                    os.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (os != null) {
                        try {
                            os.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (FileNotFoundException e7) {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                    AlbumSearchResultActivity.this.finish();
                } catch (Throwable th3) {
                    th = th3;
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                    throw th;
                }
                AlbumSearchResultActivity.this.finish();
            } else {
                AlbumSearchResultActivity.this.mProgressDialog = ProgressDialog.show(AlbumSearchResultActivity.this, MetaManager.UNKNOWN_STRING, AlbumSearchResultActivity.this.getString(C0329R.string.download_processing));
                AlbumSearchResultActivity.this.mProgressDialog.setCancelable(true);
                AlbumSearchResultActivity.this.mProgressDialog.setOnCancelListener(new C04261());
                AlbumSearchResultActivity.doHttpGetAsync(url, provider, info, AlbumSearchResultActivity.this.mHandler, new SaveBitmapRunnable());
            }
        }
    }

    private class SaveBitmapRunnable extends AsyncRequestCallback<InputStream> {
        SaveBitmapRunnable() {
        }

        public void run() {
            FileNotFoundException e;
            Throwable th;
            if (AlbumSearchResultActivity.this.mProgressDialog != null) {
                AlbumSearchResultActivity.this.mProgressDialog.dismiss();
                InputStream is = (InputStream) getResult();
                if (is != null) {
                    OutputStream os = null;
                    try {
                        if (MetaManager.makeDirIfNotExists(AlbumSearchResultActivity.this.getApplication(), "album")) {
                            OutputStream os2 = new FileOutputStream(AlbumSearchResultActivity.this.mSavePath);
                            try {
                                FileOperations.copyFile(is, os2);
                                AlbumSearchResultActivity.this.notifyDownload();
                                os = os2;
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                os = os2;
                                try {
                                    Log.e(AlbumSearchResultActivity.TAG, MetaManager.UNKNOWN_STRING, e);
                                    try {
                                        is.close();
                                    } catch (IOException e3) {
                                    }
                                    if (os != null) {
                                        os.close();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        is.close();
                                    } catch (IOException e4) {
                                    }
                                    if (os != null) {
                                        try {
                                            os.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                os = os2;
                                is.close();
                                if (os != null) {
                                    os.close();
                                }
                                throw th;
                            }
                        }
                        AlbumSearchResultActivity.this.finish();
                        try {
                            is.close();
                        } catch (IOException e6) {
                        }
                        if (os != null) {
                            try {
                                os.close();
                            } catch (IOException e7) {
                            }
                        }
                    } catch (FileNotFoundException e8) {
                        e = e8;
                        Log.e(AlbumSearchResultActivity.TAG, MetaManager.UNKNOWN_STRING, e);
                        is.close();
                        if (os != null) {
                            os.close();
                        }
                    }
                }
            }
        }
    }

    protected void onCreateContent(Bundle icicle) {
        setContentView(C0329R.layout.album_search_grid);
        this.mAlbumSize = getResources().getDimensionPixelSize(C0329R.dimen.album_size_in_search);
        this.mSearchResult = (ImageItemInfoList) getIntent().getParcelableExtra(SEARCH_RESULT);
        this.mSavePath = getIntent().getStringExtra("save_path");
        if (this.mSearchResult == null || this.mSearchResult.mContent == null || this.mSearchResult.mContent.isEmpty() || TextUtils.isEmpty(this.mSavePath)) {
            finish();
            return;
        }
        this.mAlbumGridView = (GridView) findViewById(C0329R.id.album_grid);
        this.mAlbumGridView.setAdapter(new AlbumArrayAdapter(this.mSearchResult.mContent, this.mSearchResult.getProvider(getApplication())));
        this.mAlbumGridView.setOnItemClickListener(new OnBitmapSelectListener());
        this.mRequestManager = RequestManager.create(6, null);
        this.mRequestManager.setup(true);
        getActionBar().setTitle(C0329R.string.album_select);
        UIHelper.attachGotoNowplayingIcon(this);
    }

    public void onDestroyContent() {
        if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
        if (this.mRequestManager != null) {
            this.mRequestManager.quit(null);
        }
        super.onDestroyContent();
    }

    static void updateSizeText(TextView tv, String url, int width, int height) {
        String format;
        if (url.startsWith("content://")) {
            format = tv.getResources().getString(C0329R.string.album_search_local_descript);
        } else {
            format = tv.getResources().getString(C0329R.string.album_search_online_descript);
        }
        if (width <= 0 || height <= 0) {
            tv.setText(String.format(format, new Object[]{Integer.valueOf(0), Integer.valueOf(0)}));
            return;
        }
        tv.setText(String.format(format, new Object[]{Integer.valueOf(width), Integer.valueOf(height)}));
    }

    void notifyDownload() {
        Intent myIntent = getIntent();
        Intent i = new Intent();
        i.putExtra("album", myIntent.getStringExtra("album"));
        i.putExtra("artist", myIntent.getStringExtra("artist"));
        i.putExtra(RAW_ALBUM_NAME, myIntent.getStringExtra(RAW_ALBUM_NAME));
        i.putExtra(RAW_ARTIST_NAME, myIntent.getStringExtra(RAW_ARTIST_NAME));
        setResult(-1, i);
    }

    static boolean doHttpGetAsync(String strUrl, final ImageProvider provider, final ImageItemInfo itemInfo, final Handler handler, final AsyncRequestCallback<InputStream> runSync) {
        if ((!URLUtil.isHttpUrl(strUrl) && !URLUtil.isHttpsUrl(strUrl)) || provider == null || itemInfo == null) {
            return false;
        }
        ThreadManager.postNetworkRequest(new Runnable() {
            public void run() {
                InputStream result = null;
                try {
                    provider.requestItem(itemInfo);
                    result = itemInfo.mInputStream;
                } catch (OutOfMemoryError e) {
                    Log.e(AlbumSearchResultActivity.TAG, MetaManager.UNKNOWN_STRING, e);
                } catch (Exception e2) {
                    Log.e(AlbumSearchResultActivity.TAG, MetaManager.UNKNOWN_STRING, e2);
                }
                if (runSync != null && handler != null) {
                    runSync.setResult(result);
                    handler.post(runSync);
                }
            }
        });
        return true;
    }
}
