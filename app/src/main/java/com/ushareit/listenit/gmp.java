package com.ushareit.listenit;

import com.ushareit.listenit.nearby.view.SongMenuActivity;
import java.util.List;

public class gmp implements gmb<List<fri>> {
    final /* synthetic */ SongMenuActivity f14425a;

    public gmp(SongMenuActivity songMenuActivity) {
        this.f14425a = songMenuActivity;
    }

    public void m22461a(List<fri> list) {
        this.f14425a.f16014s.setVisibility(8);
        if (list != null && list.size() > 0) {
            this.f14425a.f16003E = System.currentTimeMillis();
            this.f14425a.f16011p.m18951a((List) list);
            this.f14425a.f16000B.setText("(" + list.size() + ")");
            if (fhy.m19213a()) {
                this.f14425a.f16002D.setOnClickListener(this.f14425a.f16006H);
                this.f14425a.f16002D.setOnTouchListener(this.f14425a.f16007I);
                if (this.f14425a.f16011p.m18952a()) {
                    this.f14425a.m25196q();
                }
            } else {
                this.f14425a.f15999A.setOnClickListener(this.f14425a.f16006H);
                if (this.f14425a.f16011p.m18952a()) {
                    this.f14425a.f15999A.setImageResource(C0349R.drawable.collection_selected);
                }
            }
            this.f14425a.f16001C.setClickable(true);
        }
    }
}
