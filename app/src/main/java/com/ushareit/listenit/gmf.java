package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.nearby.view.MyHomePageActivity;

public class gmf implements OnClickListener {
    final /* synthetic */ MyHomePageActivity f14402a;

    public gmf(MyHomePageActivity myHomePageActivity) {
        this.f14402a = myHomePageActivity;
    }

    public void onClick(View view) {
        this.f14402a.finish();
    }
}
