package com.ushareit.listenit;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class hfy implements OnClickListener {
    final /* synthetic */ String f15389a;
    final /* synthetic */ hft f15390b;

    hfy(hft com_ushareit_listenit_hft, String str) {
        this.f15390b = com_ushareit_listenit_hft;
        this.f15389a = str;
    }

    public void onClick(View view) {
        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + this.f15389a)));
    }
}
