package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.ushareit.listenit.login.LoginActivity;

public class fej implements OnClickListener {
    final /* synthetic */ feh f12534a;
    private fri f12535b;
    private ImageView f12536c;

    public fej(feh com_ushareit_listenit_feh, fri com_ushareit_listenit_fri, ImageView imageView) {
        this.f12534a = com_ushareit_listenit_feh;
        this.f12535b = com_ushareit_listenit_fri;
        this.f12536c = imageView;
    }

    public void onClick(View view) {
        if (gef.m21805a().m21835e()) {
            boolean c = this.f12535b.m20705c();
            if (!c) {
                this.f12535b.m20703a(true);
                frf.m20631a(this.f12535b);
                if (fhy.m19213a()) {
                    this.f12536c.setImageResource(C0349R.drawable.collection_selected_b);
                } else {
                    this.f12536c.setImageResource(C0349R.drawable.collection_selected);
                }
                fir.m19388d();
            }
            if (this.f12534a.f12532b != null) {
                this.f12534a.f12532b.mo2725a(c);
                return;
            }
            return;
        }
        this.f12534a.f12533c.startActivity(new Intent(this.f12534a.f12533c, LoginActivity.class));
    }
}
