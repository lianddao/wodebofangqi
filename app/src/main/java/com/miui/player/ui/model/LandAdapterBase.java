package com.miui.player.ui.model;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.miui.player.C0329R;
import com.miui.player.service.ShakeListener;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.view.CascadingView;
import com.miui.player.ui.view.CascadingView.ViewEffectUpdater;
import com.miui.player.ui.view.InvertImageView;
import miui.widget.AlphabetFastIndexer;

public class LandAdapterBase extends SectionCursorAdapter implements ViewEffectUpdater {
    private static final String TAG = "LandAdapterBase";
    protected static int sAlbumHeight;
    protected static int sAlbumWidth;

    public static class ViewHolder {
        public final ImageView mViewAlbum;
        public final InvertImageView mViewAlbumInvert;
        public final View mViewAlphaLeftBottomMask;
        public final View mViewAlphaMask;
        public final View mViewBlackMask;
        public final View mViewDivider;

        public ViewHolder(View root) {
            this.mViewAlbum = (ImageView) root.findViewById(C0329R.id.album);
            this.mViewAlbumInvert = (InvertImageView) root.findViewById(C0329R.id.album_invert);
            this.mViewDivider = root.findViewById(C0329R.id.divider);
            this.mViewAlphaMask = root.findViewById(C0329R.id.left_shadow_alpha);
            this.mViewBlackMask = root.findViewById(C0329R.id.left_shadow_black);
            this.mViewAlphaLeftBottomMask = root.findViewById(C0329R.id.left_bottom_shadow_alpha);
        }
    }

    public LandAdapterBase(Context context, int layout, Cursor c, AlphabetFastIndexer fastIndexer, String titleCol) {
        super(context, layout, c, fastIndexer, titleCol);
        if (sAlbumWidth == 0 || sAlbumHeight == 0) {
            Resources r = context.getResources();
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(r, C0329R.drawable.music_land_default_album, options);
            sAlbumWidth = options.outWidth;
            sAlbumHeight = options.outHeight;
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        Log.d(TAG, "newView " + cursor.getPosition());
        View v = super.newView(context, cursor, parent);
        ViewHolder vh = new ViewHolder(v);
        v.setTag(vh);
        LayoutParams viewParams = v.getLayoutParams();
        int viewWidth = sAlbumHeight;
        if (viewParams == null) {
            v.setLayoutParams(new LayoutParams(viewWidth, -2));
        } else {
            viewParams.width = viewWidth;
            v.requestLayout();
        }
        vh.mViewDivider.getLayoutParams().width = sAlbumWidth;
        vh.mViewDivider.requestLayout();
        vh.mViewAlbum.setTag(C0329R.id.album, vh);
        return v;
    }

    public void updateEffect(CascadingView parent, View v, int childPosition, int itemPosition) {
        ViewHolder vh = (ViewHolder) v.getTag();
        int depth = parent.getChildCount() - childPosition;
        if (depth == 1) {
            vh.mViewAlbumInvert.setMaskResource(0);
            vh.mViewAlphaMask.setAlpha(0.0f);
            vh.mViewBlackMask.setAlpha(0.0f);
            vh.mViewAlphaLeftBottomMask.setAlpha(0.0f);
            return;
        }
        vh.mViewAlbumInvert.setMaskResource(C0329R.drawable.land_album_bottom_mask_dst_out);
        float percent = parent.getSelectionOffset();
        if (depth == 2) {
            vh.mViewAlbumInvert.setMaskAlpha(ShakeListener.ACCELATION_FACTOR_X - ((float) Math.pow((double) percent, 5.0d)));
            vh.mViewAlbumInvert.setMaskHeightRate(ShakeListener.ACCELATION_FACTOR_X);
        } else {
            vh.mViewAlbumInvert.setMaskAlpha(ShakeListener.ACCELATION_FACTOR_X);
            vh.mViewAlbumInvert.setMaskHeightRate(0.0f);
        }
        float alphaCurrent = ((float) Math.max(0, depth - 1)) * 0.1f;
        float alphaPrev = ((float) Math.max(0, depth - 2)) * 0.1f;
        if (depth == 2) {
            float scaledPercent = percent * 4.0f;
            vh.mViewBlackMask.setAlpha(UIHelper.clamp(alphaCurrent + ((alphaPrev - alphaCurrent) * scaledPercent), 0.0f, (float) ShakeListener.ACCELATION_FACTOR_X));
            float maskAlpha = UIHelper.clamp(ShakeListener.ACCELATION_FACTOR_X - scaledPercent, 0.0f, (float) ShakeListener.ACCELATION_FACTOR_X);
            vh.mViewAlphaMask.setAlpha(maskAlpha);
            vh.mViewAlphaLeftBottomMask.setAlpha(maskAlpha);
            return;
        }
        vh.mViewBlackMask.setAlpha(UIHelper.clamp(alphaCurrent + ((alphaPrev - alphaCurrent) * percent), 0.0f, (float) ShakeListener.ACCELATION_FACTOR_X));
        vh.mViewAlphaMask.setAlpha(ShakeListener.ACCELATION_FACTOR_X);
        vh.mViewAlphaLeftBottomMask.setAlpha(ShakeListener.ACCELATION_FACTOR_X);
    }
}
