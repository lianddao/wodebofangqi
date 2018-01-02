package com.miui.player.ui.model;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.miui.player.C0329R;
import com.miui.player.ui.model.LandAdapterBase.ViewHolder;
import miui.widget.AlphabetFastIndexer;

public class LandDefaultAdapter extends LandAdapterBase {
    protected static final String TAG = "LandDefaultAdapter";

    public LandDefaultAdapter(Context context, int layout, Cursor c, AlphabetFastIndexer fastIndexer, String titleCol) {
        super(context, layout, c, fastIndexer, titleCol);
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = super.newView(context, cursor, parent);
        ViewHolder vh = (ViewHolder) view.getTag();
        vh.mViewAlbum.setImageResource(C0329R.drawable.music_land_default_album);
        vh.mViewAlbumInvert.setImageResource(C0329R.drawable.music_land_default_album);
        return view;
    }
}
