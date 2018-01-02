package com.ushareit.listenit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.hbx;
import com.ushareit.listenit.hby;

public class LoadMoreListView extends ListView {
    private View f17250a;
    private View f17251b;
    private TextView f17252c;
    private hby f17253d;
    private OnClickListener f17254e = new hbx(this);

    public LoadMoreListView(Context context) {
        super(context);
        m26852a(context);
    }

    public LoadMoreListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26852a(context);
    }

    public LoadMoreListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26852a(context);
    }

    private void m26852a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(C0349R.layout.nearby_refresh_foot, null);
        this.f17251b = inflate.findViewById(C0349R.id.nearby_more_button);
        this.f17250a = inflate.findViewById(C0349R.id.nearby_loading_area);
        this.f17252c = (TextView) inflate.findViewById(C0349R.id.nearby_no_more_text);
        addFooterView(inflate, null, false);
        this.f17251b.setOnClickListener(this.f17254e);
    }

    public void setNoMoreText(String str) {
        this.f17252c.setText(str);
    }

    public void m26855a() {
        this.f17250a.setVisibility(8);
        this.f17252c.setVisibility(8);
        this.f17251b.setVisibility(0);
    }

    public void m26856b() {
        this.f17250a.setVisibility(8);
        this.f17251b.setVisibility(8);
        this.f17252c.setVisibility(0);
    }

    public void setOnLoadMoreListener(hby com_ushareit_listenit_hby) {
        this.f17253d = com_ushareit_listenit_hby;
    }
}
