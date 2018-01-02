package com.miui.player.ui.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.ui.SearchHelper;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.ui.fragment.MetaGridFragment.RecommendGridFragment;

public class RecommendFragment extends MusicBaseFragment implements OnClickListener {
    private static final String TAG_RECOMMEND_GRID = "recommend_grid";
    private SearchHelper mSearchHelper;

    public void onCreate(Bundle d) {
        super.onCreate(d);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
        return inflater.inflate(C0329R.layout.recommend_list_fragment, null);
    }

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        view.findViewById(C0329R.id.search_stub).setOnClickListener(this);
        ((TextView) view.findViewById(16908297)).setHint(C0329R.string.online_search_hint);
        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentByTag(TAG_RECOMMEND_GRID) == null) {
            FragmentTransaction trans = fm.beginTransaction();
            trans.add(C0329R.id.recommed_list, new RecommendGridFragment(), TAG_RECOMMEND_GRID);
            trans.commitAllowingStateLoss();
        }
    }

    public void onPause() {
        if (this.mSearchHelper != null) {
            this.mSearchHelper.finish();
            this.mSearchHelper = null;
        }
        super.onPause();
    }

    public void onClick(View v) {
        if (v.getId() == C0329R.id.search_stub) {
            if (this.mSearchHelper == null) {
                this.mSearchHelper = new SearchHelper(getActivity(), 2);
                this.mSearchHelper.setAnimateView(getView());
                this.mSearchHelper.setAnchorView(getView().findViewById(C0329R.id.search_stub));
                this.mSearchHelper.setSearchHint(getString(C0329R.string.online_search_hint));
            }
            getActivity().startActionMode(this.mSearchHelper);
        }
    }
}
