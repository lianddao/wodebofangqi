package com.ushareit.listenit;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class fsa extends rx<hbh> {
    private Context f13330a;
    private List<fsc> f13331b = new ArrayList();
    private OnItemClickListener f13332c;
    private int f13333d = 0;

    public /* synthetic */ void onBindViewHolder(sv svVar, int i) {
        m20763a((hbh) svVar, i);
    }

    public /* synthetic */ sv onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m20760a(viewGroup, i);
    }

    public /* synthetic */ void onViewRecycled(sv svVar) {
        m20762a((hbh) svVar);
    }

    public fsa(Context context) {
        this.f13330a = context;
    }

    public void m20764a(List<fsc> list) {
        this.f13331b.clear();
        this.f13331b.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f13331b.size();
    }

    public int getItemViewType(int i) {
        return ((fsc) this.f13331b.get(i)).m20765b();
    }

    public void m20761a(int i) {
        this.f13333d = i;
    }

    public hbh m20760a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new fsj(this.f13330a, fsj.m20801a(viewGroup));
            case 1:
                return new fst(this.f13330a, fst.m20871a(viewGroup));
            case 2:
                return new ftc(this.f13330a, ftc.m20891a(viewGroup));
            default:
                return null;
        }
    }

    public void m20763a(hbh com_ushareit_listenit_hbh, int i) {
        fsc com_ushareit_listenit_fsc = (fsc) this.f13331b.get(i);
        com_ushareit_listenit_hbh.mo2564a(com_ushareit_listenit_fsc, this.f13333d);
        com_ushareit_listenit_hbh.itemView.setOnClickListener(new fsb(this, com_ushareit_listenit_hbh, com_ushareit_listenit_fsc));
    }

    public void m20762a(hbh com_ushareit_listenit_hbh) {
        super.onViewRecycled(com_ushareit_listenit_hbh);
        com_ushareit_listenit_hbh.mo2563s();
    }
}
