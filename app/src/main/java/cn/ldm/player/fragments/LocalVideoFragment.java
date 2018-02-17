package cn.ldm.player.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.ldm.player.R;

public class LocalVideoFragment extends Fragment {

    public LocalVideoFragment() {
    }

    public static LocalVideoFragment newInstance() {
        LocalVideoFragment fragment = new LocalVideoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_local_video, container, false);
    }

}
