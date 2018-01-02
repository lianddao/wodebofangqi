package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.login.LoginActivity;
import com.ushareit.listenit.nearby.view.SongMenuActivity;

public class gmt implements OnClickListener {
    final /* synthetic */ SongMenuActivity f14429a;

    public gmt(SongMenuActivity songMenuActivity) {
        this.f14429a = songMenuActivity;
    }

    public void onClick(View view) {
        if (gef.m21805a().m21835e()) {
            if (!this.f14429a.f16011p.m18952a()) {
                this.f14429a.f16011p.m18953b();
                if (fhy.m19213a()) {
                    this.f14429a.m25196q();
                } else {
                    this.f14429a.f15999A.setImageResource(C0349R.drawable.collection_selected);
                }
                fir.m19395f();
            }
            this.f14429a.m25197r();
            return;
        }
        this.f14429a.startActivity(new Intent(this.f14429a, LoginActivity.class));
    }
}
