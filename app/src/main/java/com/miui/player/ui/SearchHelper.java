package com.miui.player.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.miui.player.PlayerActions.In;
import com.miui.player.ui.fragment.SuggestionSearchFragment;
import com.miui.player.ui.fragment.SuggestionSearchFragment.OnSuggestionClickListener;
import com.miui.player.util.Actions;
import miui.v5.view.SearchActionMode;
import miui.v5.view.SearchActionMode.Callback;
import miui.v5.widget.Views;

public class SearchHelper implements Callback, TextWatcher, OnSuggestionClickListener {
    public static final int SEARCH_TYPE_CUSTOM = 0;
    public static final int SEARCH_TYPE_LOCAL = 1;
    public static final int SEARCH_TYPE_ONLINE = 2;
    private static final String TAG_SUGGESTION = "suggestion";
    private final Activity mActivity;
    private View mAnchorView;
    private View mAnimateView;
    private CustomSearchListener mCustomSearchListener;
    private EditText mEditText;
    private String mLastSearchKey;
    private boolean mNeedSuggestion = false;
    private String mSearchHint;
    private SearchActionMode mSearchMode;
    private int mSearchType;
    private View mSearchView;
    private SuggestionSearchFragment mSuggestionFragment;

    public interface CustomSearchListener {
        int getSuggestionFragmentContainerID();

        boolean needSuggestion();

        void onClickHomeButton();

        void onSearch(String str);
    }

    class C04571 implements OnClickListener {
        C04571() {
        }

        public void onClick(View v) {
            SearchHelper.this.mCustomSearchListener.onClickHomeButton();
            SearchHelper.this.finish();
        }
    }

    class C04582 implements OnEditorActionListener {
        C04582() {
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String key = v.getText().toString().trim();
            if (TextUtils.isEmpty(key) || TextUtils.equals(key, SearchHelper.this.mLastSearchKey)) {
                SearchHelper.this.updateSuggestionFragmentVisible(false);
                SearchHelper.this.hideSoftInput();
                return false;
            }
            SearchHelper.this.mLastSearchKey = key;
            SearchHelper.this.doSearch(key);
            SearchHelper.this.updateSuggestionFragmentVisible(false);
            return true;
        }
    }

    public SearchHelper(Activity activity, int searchType) {
        this.mActivity = activity;
        this.mSearchType = searchType;
    }

    public void setSearchHint(String searchHint) {
        if (this.mSearchType == 0) {
            this.mEditText.setHint(searchHint);
            return;
        }
        this.mSearchHint = searchHint;
        if (this.mSearchMode != null) {
            this.mSearchMode.setAnchorViewHint(this.mSearchHint);
        }
    }

    public void setInputText(String text) {
        if (this.mEditText != null) {
            this.mEditText.setText(text);
        }
    }

    public void setAnimateView(View animateView) {
        this.mAnimateView = animateView;
    }

    public void setAnchorView(View anchorView) {
        this.mAnchorView = anchorView;
    }

    public View getSearchView() {
        return this.mSearchView;
    }

    public void initSearchView() {
        this.mSearchView = Views.inflate(this.mActivity, 100859973, null, false);
        View home = this.mSearchView.findViewById(16908332);
        home.setVisibility(0);
        home.setOnClickListener(new C04571());
        initEditText((EditText) this.mSearchView.findViewById(16908297));
    }

    private void initEditText(EditText editText) {
        this.mEditText = editText;
        this.mEditText.setOnEditorActionListener(new C04582());
        if (needSuggestion()) {
            if (this.mSearchType == 0) {
                initSuggestionSearchFragment(this.mCustomSearchListener.getSuggestionFragmentContainerID());
            }
            this.mEditText.addTextChangedListener(this);
        }
    }

    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        this.mSearchMode = (SearchActionMode) mode;
        this.mSearchMode.setAnchorViewHint(this.mSearchHint);
        this.mSearchMode.setAnimateView(this.mAnimateView);
        this.mSearchMode.setAnchorView(this.mAnchorView);
        if (needSuggestion()) {
            initSuggestionSearchFragment(16908290);
        }
        initEditText(this.mSearchMode.getSearchView());
        showSoftInput();
        return true;
    }

    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        this.mLastSearchKey = null;
        return true;
    }

    public void onDestroyActionMode(ActionMode mode) {
        this.mSearchMode = null;
        finish();
    }

    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    public void setCustomSearchListener(CustomSearchListener listener) {
        this.mCustomSearchListener = listener;
    }

    void doSearch(String key) {
        Intent intent = null;
        switch (this.mSearchType) {
            case 0:
                hideSoftInput();
                this.mCustomSearchListener.onSearch(key);
                return;
            case 1:
                intent = new Intent(Actions.ACTION_LOCAL_MUSIC_SEARCH);
                intent.putExtra("user_query", key);
                intent.putExtra("query", key);
                break;
            case 2:
                intent = new Intent(In.ACTION_MUSIC_ONLINE_SEARCH);
                intent.putExtra("search_key", new String[]{key});
                break;
        }
        this.mActivity.startActivity(intent);
    }

    private void showSoftInput() {
        if (this.mEditText != null) {
            this.mEditText.requestFocus();
            ((InputMethodManager) this.mEditText.getContext().getSystemService("input_method")).showSoftInput(this.mEditText, 2);
        }
    }

    private void hideSoftInput() {
        if (this.mEditText != null) {
            ((InputMethodManager) this.mEditText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mEditText.getWindowToken(), 0);
        }
    }

    public void finish() {
        if (this.mSearchMode != null) {
            this.mSearchMode.finish();
            this.mSearchMode = null;
        }
        hideSoftInput();
        updateSuggestionFragmentVisible(false);
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void afterTextChanged(Editable s) {
        if (this.mSuggestionFragment != null) {
            if (TextUtils.isEmpty(s.toString())) {
                updateSuggestionFragmentVisible(false);
                return;
            }
            updateSuggestionFragmentVisible(true);
            this.mSuggestionFragment.updateSearchKey(s.toString());
        }
    }

    private void initSuggestionSearchFragment(int layoutId) {
        FragmentManager fm = this.mActivity.getFragmentManager();
        this.mSuggestionFragment = (SuggestionSearchFragment) fm.findFragmentByTag(TAG_SUGGESTION);
        FragmentTransaction trans = fm.beginTransaction();
        if (this.mSuggestionFragment == null) {
            this.mSuggestionFragment = new SuggestionSearchFragment();
            trans.add(layoutId, this.mSuggestionFragment, TAG_SUGGESTION);
        }
        if (this.mSearchType != 0) {
            this.mSuggestionFragment.setSearchMode(this.mSearchMode);
        }
        this.mSuggestionFragment.setOnSuggestionClickListener(this);
        trans.hide(this.mSuggestionFragment);
        trans.commit();
    }

    public void setNeedSuggestion(boolean needSuggestion) {
        this.mNeedSuggestion = needSuggestion;
    }

    protected boolean needSuggestion() {
        if (this.mSearchType == 0) {
            return this.mCustomSearchListener.needSuggestion();
        }
        return this.mNeedSuggestion || this.mSearchType == 2;
    }

    private void updateSuggestionFragmentVisible(boolean visible) {
        if (!this.mActivity.isFinishing() && this.mSuggestionFragment != null && this.mSuggestionFragment.isHidden() == visible) {
            FragmentTransaction ft = this.mActivity.getFragmentManager().beginTransaction();
            if (visible) {
                ft.show(this.mSuggestionFragment);
            } else {
                ft.hide(this.mSuggestionFragment);
            }
            if (!ft.isEmpty()) {
                ft.commitAllowingStateLoss();
            }
        }
    }

    public void onSuggestionClick(String suggestion) {
        this.mEditText.removeTextChangedListener(this);
        this.mEditText.setText(suggestion);
        this.mEditText.setSelection(this.mEditText.length());
        this.mEditText.addTextChangedListener(this);
        updateSuggestionFragmentVisible(false);
        doSearch(suggestion);
    }
}
