package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.login.LoginActivity;

class gmi implements OnClickListener {
    final /* synthetic */ gmh f14411a;

    gmi(gmh com_ushareit_listenit_gmh) {
        this.f14411a = com_ushareit_listenit_gmh;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f14411a.m1328m(), LoginActivity.class);
        intent.putExtra("extra_start_from", "nearby_user");
        this.f14411a.startActivityForResult(intent, 2);
        fir.m19378a("user");
    }
}
