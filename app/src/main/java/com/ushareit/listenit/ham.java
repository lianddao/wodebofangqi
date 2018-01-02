package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.nearby.view.MyHomePageActivity;

class ham implements OnClickListener {
    final /* synthetic */ fni f15064a;
    final /* synthetic */ hal f15065b;

    ham(hal com_ushareit_listenit_hal, fni com_ushareit_listenit_fni) {
        this.f15065b = com_ushareit_listenit_hal;
        this.f15064a = com_ushareit_listenit_fni;
    }

    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), MyHomePageActivity.class);
        intent.putExtra("nearby_user", this.f15064a);
        this.f15065b.f15056a.f15055d.startActivity(intent);
    }
}
