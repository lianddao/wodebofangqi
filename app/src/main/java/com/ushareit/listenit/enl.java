package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.nativeads.ClickInterface;
import com.mopub.nativeads.NativeClickHandler;

public class enl implements OnClickListener {
    final /* synthetic */ ClickInterface f11311a;
    final /* synthetic */ NativeClickHandler f11312b;

    public enl(NativeClickHandler nativeClickHandler, ClickInterface clickInterface) {
        this.f11312b = nativeClickHandler;
        this.f11311a = clickInterface;
    }

    public void onClick(View view) {
        this.f11311a.handleClick(view);
    }
}
