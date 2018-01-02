package com.ushareit.listenit;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class fdj extends rx<hbh> {
    private Context f12467a;
    private List<gjc> f12468b = new ArrayList();
    private OnItemClickListener f12469c;

    public /* synthetic */ void onBindViewHolder(sv svVar, int i) {
        m18890a((hbh) svVar, i);
    }

    public /* synthetic */ sv onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m18887a(viewGroup, i);
    }

    public /* synthetic */ void onViewRecycled(sv svVar) {
        m18889a((hbh) svVar);
    }

    public fdj(Context context) {
        this.f12467a = context;
    }

    public void m18891a(List<gjc> list) {
        this.f12468b.clear();
        this.f12468b.addAll(list);
        notifyDataSetChanged();
    }

    public void m18888a(OnItemClickListener onItemClickListener) {
        this.f12469c = onItemClickListener;
    }

    public int getItemCount() {
        return this.f12468b.size();
    }

    public int getItemViewType(int i) {
        return ((gjc) this.f12468b.get(i)).m20765b();
    }

    public hbh m18887a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new gzn(this.f12467a, gzn.m23390a(viewGroup));
            case 2:
                return new gzs(this.f12467a, gzs.m23405a(viewGroup));
            case 3:
                return new hap(this.f12467a, hap.m23466a(viewGroup));
            case 4:
                return new had(this.f12467a, had.m23437a(viewGroup));
            default:
                return null;
        }
    }

    public void m18890a(hbh com_ushareit_listenit_hbh, int i) {
        gjc com_ushareit_listenit_gjc = (gjc) this.f12468b.get(i);
        com_ushareit_listenit_hbh.mo2564a(com_ushareit_listenit_gjc, 0);
        com_ushareit_listenit_hbh.itemView.setOnClickListener(new fdk(this, com_ushareit_listenit_hbh, com_ushareit_listenit_gjc));
    }

    public void m18889a(hbh com_ushareit_listenit_hbh) {
        super.onViewRecycled(com_ushareit_listenit_hbh);
        com_ushareit_listenit_hbh.mo2563s();
    }
}
