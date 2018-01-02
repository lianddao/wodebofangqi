package com.ushareit.listenit;

import android.graphics.Color;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.ads.af;
import com.facebook.ads.internal.view.C0057q;
import com.facebook.ads.internal.view.hscroll.C0051b;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.List;

public class all extends rx<ayq> {
    private static final int f4680a = Color.argb(51, 0, 0, 0);
    private final List<af> f4681b;
    private final int f4682c;
    private final int f4683d;

    public all(C0051b c0051b, List<af> list) {
        float f = c0051b.getContext().getResources().getDisplayMetrics().density;
        this.f4681b = list;
        this.f4682c = Math.round(f * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f4683d = c0051b.getChildSpacing();
    }

    public ayq m6052a(ViewGroup viewGroup, int i) {
        C0057q c0057q = new C0057q(viewGroup.getContext());
        c0057q.setScaleType(ScaleType.CENTER_CROP);
        return new ayq(c0057q);
    }

    public void m6053a(ayq com_ushareit_listenit_ayq, int i) {
        LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -1);
        marginLayoutParams.setMargins(i == 0 ? this.f4683d * 2 : this.f4683d, 0, i >= this.f4681b.size() + -1 ? this.f4683d * 2 : this.f4683d, 0);
        com_ushareit_listenit_ayq.f5672k.setBackgroundColor(0);
        com_ushareit_listenit_ayq.f5672k.setImageDrawable(null);
        com_ushareit_listenit_ayq.f5672k.setLayoutParams(marginLayoutParams);
        com_ushareit_listenit_ayq.f5672k.setPadding(this.f4682c, this.f4682c, this.f4682c, this.f4682c);
        af afVar = (af) this.f4681b.get(i);
        afVar.m893a(com_ushareit_listenit_ayq.f5672k);
        if (afVar.m903e() != null) {
            aum com_ushareit_listenit_aum = new aum(com_ushareit_listenit_ayq.f5672k);
            com_ushareit_listenit_aum.m7209a(new alm(this, com_ushareit_listenit_ayq));
            com_ushareit_listenit_aum.m7211a(r0.m949a());
        }
    }

    public int getItemCount() {
        return this.f4681b.size();
    }

    public /* synthetic */ void onBindViewHolder(sv svVar, int i) {
        m6053a((ayq) svVar, i);
    }

    public /* synthetic */ sv onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m6052a(viewGroup, i);
    }
}
