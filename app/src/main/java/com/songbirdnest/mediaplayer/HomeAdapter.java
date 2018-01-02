package com.songbirdnest.mediaplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class HomeAdapter extends BaseAdapter {
    protected List<ContentViewWrapper> containerValues;

    public HomeAdapter(List<ContentViewWrapper> containerValues) {
        this.containerValues = containerValues;
    }

    public int getCount() {
        return this.containerValues.size();
    }

    public Object getItem(int position) {
        return this.containerValues.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ContentViewWrapper contentViewWrapper = (ContentViewWrapper) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(C0116R.layout.home_item, parent, false);
        }
        contentViewWrapper.setContentView(convertView);
        contentViewWrapper.setText();
        return convertView;
    }
}
