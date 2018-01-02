package com.miui.player.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.miui.player.C0329R;

public class AlbumFragment extends Fragment implements OnClickListener {
    private OnClickListener mClickListener;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
        return inflater.inflate(C0329R.layout.album_fragment, container, false);
    }

    public void onViewCreated(View v, Bundle icicle) {
        super.onViewCreated(v, icicle);
        v.setOnClickListener(this);
    }

    public void setOnClickListener(OnClickListener l) {
        this.mClickListener = l;
    }

    public void onClick(View v) {
        this.mClickListener.onClick(v);
    }
}
