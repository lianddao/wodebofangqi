package com.miui.player.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.fragment.MetaGridFragment.BillGridFragment;
import com.miui.player.ui.fragment.MetaGridFragment.ChannelGridFragment;
import com.miui.player.ui.fragment.RecommendFragment;
import com.miui.player.ui.model.MetaAdapter;
import com.miui.player.util.MusicAnalyticsUtils;
import miui.analytics.XiaomiAnalytics;
import miui.v5.app.MiuiActionBar;
import miui.v5.app.MiuiActionBar.FragmentViewPagerChangeListener;

public class OnlineMusicBrowser extends MusicBaseActivity implements FragmentViewPagerChangeListener {
    public static final String KEY_SELECTED_TAG = "selected_tag";
    public static final String TAG_BILLBOARD = "billboard";
    public static final String TAG_CHANNEL = "channel";
    public static final String TAG_RECOMMEND = "recommend";

    protected void onCreateContent(Bundle icicle) {
        MetaAdapter.setup();
        MiuiActionBar bar = getMiuiActionBar();
        bar.setFragmentViewPagerMode(this, getFragmentManager());
        bar.addFragmentTab("recommend", bar.newTab().setText(C0329R.string.recommend), RecommendFragment.class, null, false);
        bar.addFragmentTab(TAG_BILLBOARD, bar.newTab().setText(C0329R.string.billboard), BillGridFragment.class, null, false);
        bar.addFragmentTab(TAG_CHANNEL, bar.newTab().setText(C0329R.string.channel), ChannelGridFragment.class, null, false);
        bar.addOnFragmentViewPagerChangeListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            bar.selectTab(bar.getTabAt(intent.getIntExtra(KEY_SELECTED_TAG, 0)));
        }
        UIHelper.makeOnlineActionBarCustomView(this);
        ((TextView) bar.getCustomView().findViewById(C0329R.id.title_text)).setText(C0329R.string.online_title);
    }

    protected void onDestroy() {
        MetaAdapter.quit();
        super.onDestroy();
    }

    public void onPageScrolled(int position, float ratio, boolean fromHasActionMenu, boolean toHasActionMenu) {
    }

    public void onPageSelected(int position) {
        XiaomiAnalytics.getInstance().trackEvent(MusicAnalyticsUtils.CLICK_ONLINE_FRAGMENTS[position]);
    }

    public void onPageScrollStateChanged(int state) {
    }
}
