package com.ushareit.listenit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;

public class AllPlayView extends FrameLayout {
    private TextView f17138a;
    private ImageView f17139b;
    private View f17140c;
    private ImageView f17141d;
    private View f17142e;

    public AllPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26790a(context);
    }

    public AllPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26790a(context);
    }

    public AllPlayView(Context context) {
        super(context);
        m26790a(context);
    }

    private void m26790a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.all_play_view, this);
        this.f17138a = (TextView) inflate.findViewById(C0349R.id.song_count);
        this.f17139b = (ImageView) inflate.findViewById(C0349R.id.edit);
        this.f17140c = inflate.findViewById(C0349R.id.add_songs);
        this.f17141d = (ImageView) inflate.findViewById(C0349R.id.sort_mode);
        this.f17142e = inflate.findViewById(C0349R.id.recommend_playlist);
    }

    public void m26791a(int i) {
        boolean z;
        boolean z2 = true;
        this.f17138a.setText(getContext().getString(C0349R.string.listfragment_play_all_song_count, new Object[]{Integer.valueOf(i)}));
        ImageView imageView = this.f17139b;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        imageView.setEnabled(z);
        ImageView imageView2 = this.f17141d;
        if (i == 0) {
            z2 = false;
        }
        imageView2.setEnabled(z2);
    }

    public void setOnManagementClickListener(OnClickListener onClickListener) {
        this.f17139b.setOnClickListener(onClickListener);
    }

    public void setOnAllPlayClickListener(OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setShowAddSongs(OnClickListener onClickListener) {
        this.f17140c.setVisibility(0);
        this.f17140c.setOnClickListener(onClickListener);
    }

    public void setShowRecommendPlaylist(OnClickListener onClickListener) {
        this.f17142e.setVisibility(0);
        this.f17142e.setOnClickListener(onClickListener);
    }

    public void setOnSortOrderListener(OnClickListener onClickListener) {
        this.f17141d.setOnClickListener(onClickListener);
    }

    public void setSortOrderIcon(int i) {
        this.f17141d.setVisibility(0);
        this.f17141d.setImageResource(i);
    }
}
