package com.miui.player.ui.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.meta.AlbumManager;
import com.miui.player.ui.fragment.AsyncFragment.DataAdapter;
import com.miui.player.util.CachePolicy;
import com.xiaomi.music.online.model.MetaList;
import com.xiaomi.music.online.model.SongGroup;
import com.xiaomi.music.online.model.SongGroupList;
import java.lang.ref.WeakReference;
import miui.cache.RequestManager;
import miui.cache.RequestManager.Request;

public abstract class MetaAdapter<E, D extends MetaList<E>> extends DataAdapter<E, D> {
    static int sAlbumCornerColor = -1;
    static int sAlbumHeight = 0;
    static int sAlbumRadius = 0;
    static int sAlbumWidth = 0;
    static RequestManager<String, Drawable, Integer> sRequestManager = null;
    private final LayoutInflater mInflater;

    static class ImageRequest implements Request<String, Drawable, Integer> {
        private final Context mContext;
        private final Drawable mDefaultDrawable;
        private final WeakReference<ImageView> mImageViewRef;
        private final String mUrl;

        public ImageRequest(String url, ImageView v, Drawable drawable) {
            this.mContext = v.getContext().getApplicationContext();
            this.mUrl = url;
            this.mImageViewRef = new WeakReference(v);
            this.mDefaultDrawable = drawable;
            v.setTag(getKey());
        }

        public Drawable computAsync() {
            Bitmap bm = AlbumManager.requestOnlineImage(this.mContext, this.mUrl, MetaAdapter.sAlbumWidth, MetaAdapter.sAlbumHeight);
            if (bm != null) {
                bm = AlbumManager.clipRoundCorner(this.mContext, bm);
            }
            return AlbumManager.createFastDrawable(bm);
        }

        public String getKey() {
            return this.mUrl;
        }

        public Integer getRemoveKey() {
            return Integer.valueOf(Integer.MIN_VALUE);
        }

        public boolean isRemovable() {
            ImageView view = (ImageView) this.mImageViewRef.get();
            if (view != null && getKey().equals(view.getTag())) {
                return false;
            }
            return true;
        }

        public boolean needCache() {
            return true;
        }

        public void onCompleted(Drawable value, boolean finalValue) {
            ImageView iv = (ImageView) this.mImageViewRef.get();
            if (iv != null) {
                String key = getKey();
                if (key != null && key.equals(iv.getTag())) {
                    if (value != null) {
                        iv.setImageDrawable(value);
                    } else {
                        iv.setImageDrawable(this.mDefaultDrawable);
                    }
                }
            }
        }

        public void onRemoved() {
        }
    }

    public static class SongGroupMetaAdapter extends MetaAdapter<SongGroup, SongGroupList> {
        private final Drawable mDefaultAlbum;

        public SongGroupMetaAdapter(Context context) {
            super(context);
            this.mDefaultAlbum = context.getResources().getDrawable(C0329R.drawable.online_album_item_default);
        }

        protected void bindView(View v, SongGroup songGroup) {
            ViewHolder vh = (ViewHolder) v.getTag();
            vh.mTextViewPrimary.setText(songGroup.mName);
            if (sRequestManager.isStarted()) {
                sRequestManager.request(new ImageRequest(songGroup.mImageUrl, vh.mImageViewAlbum, this.mDefaultAlbum));
            }
        }

        protected void onNewView(View v) {
            ((ViewHolder) v.getTag()).mImageViewMask.setImageResource(C0329R.drawable.online_album_item_mask);
        }
    }

    static class ViewHolder {
        final ImageView mImageViewAlbum;
        final ImageView mImageViewMask;
        final TextView mTextViewPrimary;
        final TextView mTextViewSecondary;

        public ViewHolder(View v) {
            this.mTextViewPrimary = (TextView) v.findViewById(C0329R.id.primary_text);
            this.mTextViewSecondary = (TextView) v.findViewById(C0329R.id.secondary_text);
            this.mImageViewAlbum = (ImageView) v.findViewById(C0329R.id.album);
            this.mImageViewMask = (ImageView) v.findViewById(C0329R.id.album_mask);
        }
    }

    protected abstract void bindView(View view, E e);

    protected abstract void onNewView(View view);

    public MetaAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        if (sRequestManager == null) {
            sRequestManager = RequestManager.create(CachePolicy.getOnlineBMCacheSize(), null);
            sRequestManager.setup(true);
            Resources res = context.getResources();
            Bitmap b = BitmapFactory.decodeResource(res, C0329R.drawable.online_album_item_default);
            sAlbumWidth = b.getWidth();
            sAlbumHeight = b.getHeight();
            sAlbumRadius = res.getDimensionPixelSize(C0329R.dimen.album_corner_radius);
            sAlbumCornerColor = res.getColor(C0329R.color.album_border);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = this.mInflater.inflate(C0329R.layout.online_album_picker_item, null);
            view.setTag(new ViewHolder(view));
            onNewView(view);
        }
        bindView(view, this.mData.get(position));
        return view;
    }

    public static void setup() {
        if (sRequestManager != null) {
            sRequestManager.setup(true);
        }
    }

    public static void quit() {
        if (sRequestManager != null) {
            sRequestManager.quit(null);
        }
    }

    public static void removeCache() {
        if (sRequestManager != null) {
            sRequestManager.removeAll();
        }
    }
}
