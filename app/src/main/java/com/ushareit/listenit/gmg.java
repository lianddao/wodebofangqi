package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.ushareit.listenit.nearby.view.MyHomePageActivity;
import com.ushareit.listenit.nearby.view.SongMenuActivity;
import java.io.Serializable;

public class gmg extends fjv {
    final /* synthetic */ MyHomePageActivity f14403a;

    public gmg(MyHomePageActivity myHomePageActivity) {
        this.f14403a = myHomePageActivity;
    }

    public void mo2724a(AdapterView<?> adapterView, View view, int i, long j) {
        if (i > 1) {
            Serializable a = this.f14403a.f15988r.m18936a(i - 2);
            Intent intent = new Intent(this.f14403a, SongMenuActivity.class);
            intent.putExtra("nearby_user", this.f14403a.f15985o);
            intent.putExtra("sharelist", a);
            this.f14403a.startActivity(intent);
        }
    }
}
