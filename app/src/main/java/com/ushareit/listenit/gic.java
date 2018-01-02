package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ushareit.listenit.lyrics.LyricView;

public class gic extends BaseAdapter {
    final /* synthetic */ LyricView f14152a;
    private ggm f14153b;

    public gic(LyricView lyricView) {
        this.f14152a = lyricView;
    }

    public void m22046a(ggm com_ushareit_listenit_ggm) {
        this.f14153b = com_ushareit_listenit_ggm;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f14153b == null ? 0 : this.f14153b.m21956d();
    }

    public Object getItem(int i) {
        return this.f14153b == null ? null : this.f14153b.m21959e(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = View.inflate(viewGroup.getContext(), C0349R.layout.lyric_sentence_view, null);
        } else {
            inflate = view;
        }
        TextView textView = (TextView) inflate;
        textView.setText(this.f14153b.m21953c(i));
        if (!this.f14153b.m21961e()) {
            erj.m17570a(textView, 0.4f);
        }
        return textView;
    }
}
