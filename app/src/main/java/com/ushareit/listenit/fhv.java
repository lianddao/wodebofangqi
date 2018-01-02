package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.ArrayList;
import java.util.List;

public class fhv extends BaseAdapter {
    private List<gnj> f12748a = new ArrayList();
    private String f12749b;

    public void m19209a() {
        this.f12748a.clear();
    }

    public void m19211a(List<gnj> list) {
        this.f12748a.addAll(list);
    }

    private int m19205a(int i) {
        return (i + 1) / 2;
    }

    private int m19208b(int i) {
        return i * 2;
    }

    public int getCount() {
        return m19205a(this.f12748a.size());
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.search_album_art_list_item, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(C0349R.id.image_1);
        View findViewById = view.findViewById(C0349R.id.progress_1);
        int b = m19208b(i);
        m19207a(findViewById, viewGroup.getContext(), ((gnj) this.f12748a.get(b)).m22500a(), imageView);
        int i2 = b + 1;
        imageView = (ImageView) view.findViewById(C0349R.id.image_2);
        if (i2 < this.f12748a.size()) {
            imageView.setVisibility(0);
            m19207a(view.findViewById(C0349R.id.progress_2), viewGroup.getContext(), ((gnj) this.f12748a.get(i2)).m22500a(), imageView);
        } else {
            imageView.setVisibility(4);
        }
        return view;
    }

    private void m19207a(View view, Context context, String str, ImageView imageView) {
        view.setVisibility(0);
        imageView.setOnClickListener(null);
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setImageDrawable(null);
        fzi.m21397a(context, Uri.parse(str), imageView, tv.NORMAL, 0, new fhw(this, view, imageView, context));
    }

    public void m19210a(String str) {
        this.f12749b = str;
    }
}
