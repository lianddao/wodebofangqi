package com.ushareit.listenit.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.theme.entry.CustomThemeLinearLayout;

public class OperatorView extends CustomThemeLinearLayout {
    private View f17340a;
    private View f17341b;
    private View f17342c;
    private View f17343d;

    public OperatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26963a(context);
    }

    public OperatorView(Context context) {
        super(context);
        m26963a(context);
    }

    private void m26963a(Context context) {
        setOrientation(0);
    }

    private View m26962a(int i, int i2) {
        View inflate = View.inflate(getContext(), C0349R.layout.listfragment_operator_item_view, null);
        ImageView imageView = (ImageView) inflate.findViewById(C0349R.id.icon);
        TextView textView = (TextView) inflate.findViewById(C0349R.id.desc);
        imageView.setImageResource(i);
        imageView.setEnabled(false);
        textView.setText(i2);
        textView.setEnabled(false);
        return inflate;
    }

    public void m26965a(boolean z) {
        if (this.f17340a != null) {
            m26964a(this.f17340a, z);
        }
        if (this.f17341b != null) {
            m26964a(this.f17341b, z);
        }
        if (this.f17342c != null) {
            m26964a(this.f17342c, z);
        }
        if (this.f17343d != null) {
            this.f17343d.setEnabled(z);
        }
    }

    public void setShowPlayNext(OnClickListener onClickListener) {
        View a = m26962a((int) C0349R.drawable.listitem_operator_play_next_bg, (int) C0349R.string.operator_view_play_next);
        a.setOnClickListener(onClickListener);
        addView(a, new LayoutParams(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        this.f17342c = a;
    }

    public void setShowAddToPlaylist(OnClickListener onClickListener) {
        View a = m26962a((int) C0349R.drawable.listitem_operator_add_to_playlist_bg, (int) C0349R.string.operator_view_add_to_playlist);
        a.setOnClickListener(onClickListener);
        addView(a, new LayoutParams(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        this.f17341b = a;
    }

    public void setShowDelete(OnClickListener onClickListener) {
        View a = m26962a((int) C0349R.drawable.listitem_operator_delete_bg, (int) C0349R.string.operator_view_delete);
        a.setOnClickListener(onClickListener);
        addView(a, new LayoutParams(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        this.f17340a = a;
    }

    @SuppressLint({"NewApi"})
    public void setShowAddToCurrPlaylist(OnClickListener onClickListener) {
        int dimension = (int) getResources().getDimension(C0349R.dimen.common_dimens_215dp);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(dimension, (int) getResources().getDimension(C0349R.dimen.common_dimens_34dp));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (fbb.m18762c(getContext()) - dimension) / 2;
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
        }
        View inflate = View.inflate(getContext(), C0349R.layout.operator_button, null);
        inflate.setOnClickListener(onClickListener);
        addView(inflate, layoutParams);
        this.f17343d = inflate;
        this.f17343d.setEnabled(false);
    }

    private void m26964a(View view, boolean z) {
        TextView textView = (TextView) view.findViewById(C0349R.id.desc);
        ((ImageView) view.findViewById(C0349R.id.icon)).setEnabled(z);
        textView.setEnabled(z);
    }
}
