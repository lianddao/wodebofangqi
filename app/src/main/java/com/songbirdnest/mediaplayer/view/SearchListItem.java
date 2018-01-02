package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.songbirdnest.mediaplayer.C0116R;

public class SearchListItem {
    private View searchView;

    public SearchListItem(Activity activity) {
        this.searchView = LayoutInflater.from(activity).inflate(C0116R.layout.search_list_item, null);
    }

    public View getView() {
        return this.searchView;
    }

    public EditText getSearchBox() {
        return (EditText) this.searchView.findViewById(C0116R.id.search_list_item_search_box);
    }

    public ImageView getClearButton() {
        return (ImageView) this.searchView.findViewById(C0116R.id.list_clear_icon);
    }
}
