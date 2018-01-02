package com.ushareit.listenit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mopub.mraid.MraidNativeCommandHandler;

public class elr implements OnClickListener {
    final /* synthetic */ Context f11218a;
    final /* synthetic */ String f11219b;
    final /* synthetic */ elv f11220c;
    final /* synthetic */ MraidNativeCommandHandler f11221d;

    public elr(MraidNativeCommandHandler mraidNativeCommandHandler, Context context, String str, elv com_ushareit_listenit_elv) {
        this.f11221d = mraidNativeCommandHandler;
        this.f11218a = context;
        this.f11219b = str;
        this.f11220c = com_ushareit_listenit_elv;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11221d.m3130b(this.f11218a, this.f11219b, this.f11220c);
    }
}
