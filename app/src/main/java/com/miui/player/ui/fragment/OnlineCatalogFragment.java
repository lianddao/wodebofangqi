package com.miui.player.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.miui.player.C0329R;
import com.miui.player.ui.OnlineMusicBrowser;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.util.MusicAnalyticsUtils;
import miui.analytics.XiaomiAnalytics;

public class OnlineCatalogFragment extends MusicBaseFragment {
    private static final int ID_BILL_LIST = 1;
    private static final int ID_CHANNEL_LIST = 2;
    private static final int ID_RECOGMEND = 0;
    private ListView mListView;

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        this.mListView = (ListView) getListView();
        this.mListView.setOnItemClickListener(this);
        int leftMargin = getResources().getDimensionPixelOffset(C0329R.dimen.mainpage_list_item_margin_left);
        this.mListView.addHeaderView(UIHelper.makeSpecialView(this.mListView, 0, (int) C0329R.drawable.enter_indicator, (int) C0329R.string.recommend, leftMargin));
        this.mListView.addHeaderView(UIHelper.makeSpecialView(this.mListView, 1, (int) C0329R.drawable.enter_indicator, (int) C0329R.string.billboard, leftMargin));
        this.mListView.addHeaderView(UIHelper.makeSpecialView(this.mListView, 2, (int) C0329R.drawable.enter_indicator, (int) C0329R.string.channel, leftMargin));
        this.mListView.setAdapter(null);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(view.getContext(), OnlineMusicBrowser.class);
        intent.putExtra(OnlineMusicBrowser.KEY_SELECTED_TAG, position);
        startActivity(intent);
        XiaomiAnalytics.getInstance().trackEvent(MusicAnalyticsUtils.CLICK_ONLINE_FRAGMENTS[position]);
    }
}
