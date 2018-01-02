package com.miui.player.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.plugin.onlinemusic2.SearchSuggestion;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.fragment.AsyncFragment.DataAdapter;
import miui.cache.RequestManager;
import miui.v5.view.SearchActionMode;

public class SuggestionSearchFragment extends AsyncFragment<String, SearchSuggestion> {
    static RequestManager<String, SearchSuggestion, String> sRequestManager = RequestManager.create(1, null);
    private volatile String mSearchKey = null;
    private SearchActionMode mSearchMode;
    private OnSuggestionClickListener mSuggestionClick;

    public interface OnSuggestionClickListener {
        void onSuggestionClick(String str);
    }

    static class SearchSuggestionAdapter extends DataAdapter<String, SearchSuggestion> {
        private final LayoutInflater mInflater;

        public SearchSuggestionAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        protected void onDataChanged() {
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView v = (TextView) convertView;
            if (v == null) {
                v = (TextView) this.mInflater.inflate(C0329R.layout.suggestion_search_item, null);
            }
            v.setText((CharSequence) ((SearchSuggestion) this.mData).get(position));
            return v;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
        return inflater.inflate(C0329R.layout.suggestion_search_fragment, null);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (this.mSearchMode != null) {
            this.mSearchMode.setResultView(view);
        }
    }

    public void setSearchMode(SearchActionMode mode) {
        this.mSearchMode = mode;
    }

    protected void initializeAdapter(View container) {
        this.mAdapter = new SearchSuggestionAdapter(getActivity());
    }

    public void updateSearchKey(String key) {
        this.mSearchKey = key;
        if (!TextUtils.isEmpty(key)) {
            launch();
        } else if (this.mAdapter != null) {
            this.mAdapter.updateData(null);
        }
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (this.mSuggestionClick != null && position >= UIHelper.getListViewHeaderCount(parent) && position < parent.getCount() - UIHelper.getListViewFooterCount(parent)) {
            this.mSuggestionClick.onSuggestionClick((String) this.mAdapter.getItem(position));
        }
    }

    public void setOnSuggestionClickListener(OnSuggestionClickListener l) {
        this.mSuggestionClick = l;
    }

    protected RequestManager<String, SearchSuggestion, String> getRequestManager() {
        return sRequestManager;
    }

    public SearchSuggestion doComput(int opt) {
        String searchKey = this.mSearchKey;
        if (TextUtils.isEmpty(searchKey)) {
            return null;
        }
        Context context = getApplication();
        if (context != null) {
            return OnlineMusicProxy.queryAudioSuggestion(context, searchKey, this, opt);
        }
        return null;
    }

    public String getKey() {
        return "search_suggestion";
    }

    public boolean needCache() {
        return false;
    }

    protected boolean needLoadingByPage() {
        return false;
    }
}
