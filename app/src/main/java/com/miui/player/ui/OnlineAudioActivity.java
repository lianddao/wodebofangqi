package com.miui.player.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.In;
import com.miui.player.ui.SearchHelper.CustomSearchListener;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.fragment.OnlineSongListFragment;
import com.miui.player.util.Actions;
import com.miui.player.util.Strings;

public class OnlineAudioActivity extends MusicBaseActivity implements CustomSearchListener {
    private String mDescription;
    private OnlineSongListFragment mFragment;
    private String mKey;
    private String[] mKeyArray;
    private SearchHelper mSearchHelper;
    private int mType = 0;

    public void onCreateContent(Bundle icicle) {
        setContentView(C0329R.layout.online_audio_activity);
        this.mFragment = (OnlineSongListFragment) getFragmentManager().findFragmentById(C0329R.id.online_song_list_fragment);
        Intent intent = getIntent();
        if (icicle == null) {
            icicle = intent.getExtras();
        }
        if (In.ACTION_MUSIC_ONLINE_SEARCH.equals(intent.getAction())) {
            this.mType = 5;
            this.mKeyArray = icicle.getStringArray("search_key");
            this.mKey = getQueryKey(this.mKeyArray);
            this.mDescription = this.mKey;
        } else if (icicle != null) {
            this.mType = icicle.getInt(Actions.KEY_AUDIO_LIST_TYPE);
            this.mKey = icicle.getString(Actions.KEY_AUDIO_LIST_KEY);
            if (this.mType == 5) {
                this.mDescription = this.mKey;
            } else {
                this.mDescription = icicle.getString(Actions.KEY_AUDIO_LIST_DESCRIPTION);
                this.mFragment.setLoadingCount(icicle.getInt(Actions.KEY_AUDIO_COUNT, 0));
            }
        }
        if (this.mType == 0 || TextUtils.isEmpty(this.mKey)) {
            finish();
            return;
        }
        ActionBar bar = getActionBar();
        if (this.mType == 5) {
            bar.setDisplayShowHomeEnabled(false);
            initSearchHelper();
            bar.setCustomView(this.mSearchHelper.getSearchView());
            bar.setDisplayShowCustomEnabled(true);
        } else {
            UIHelper.makeOnlineActionBarCustomView(this);
            bar.setDisplayShowTitleEnabled(false);
            ((TextView) bar.getCustomView().findViewById(C0329R.id.title_text)).setText(this.mDescription);
        }
        this.mFragment.requestAudioList(this.mType, this.mKey, true);
    }

    protected boolean saveData(Bundle outcicle) {
        super.saveData(outcicle);
        outcicle.putInt(Actions.KEY_AUDIO_LIST_TYPE, this.mType);
        outcicle.putString(Actions.KEY_AUDIO_LIST_KEY, this.mKey);
        outcicle.putString(Actions.KEY_AUDIO_LIST_DESCRIPTION, this.mDescription);
        if (this.mKeyArray != null) {
            outcicle.putStringArray("search_key", this.mKeyArray);
        }
        return true;
    }

    protected void onSaveInstanceState(Bundle outState) {
        saveData(outState);
        super.onSaveInstanceState(outState);
    }

    protected void onPause() {
        if (this.mSearchHelper != null) {
            this.mSearchHelper.finish();
        }
        super.onPause();
    }

    public void onSearch(String key) {
        if (!TextUtils.isEmpty(key)) {
            this.mFragment.requestAudioList(this.mType, key, true);
        }
    }

    public void onClickHomeButton() {
        finish();
    }

    public boolean needSuggestion() {
        return true;
    }

    public int getSuggestionFragmentContainerID() {
        return C0329R.id.search_suggestion_container;
    }

    private static String getQueryKey(String[] keys) {
        return Strings.concat(" ", keys);
    }

    private void initSearchHelper() {
        this.mSearchHelper = new SearchHelper(this, 0);
        this.mSearchHelper.setCustomSearchListener(this);
        this.mSearchHelper.initSearchView();
        this.mSearchHelper.setInputText(this.mKey);
        this.mSearchHelper.setSearchHint(getString(C0329R.string.online_search_hint));
    }
}
