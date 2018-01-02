package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.listenit.fragments.PlayerFragment;
import com.ushareit.listenit.service.PlayService;

public class fyh implements fju {
    final /* synthetic */ PlayerFragment f13720a;

    public fyh(PlayerFragment playerFragment) {
        this.f13720a = playerFragment;
    }

    public void mo2624a(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && intent.hasExtra("extra_album_name")) {
            String stringExtra = intent.getStringExtra("extra_album_name");
            if (!fbb.m18763c(stringExtra)) {
                this.f13720a.f13250a.m26890a(stringExtra);
                this.f13720a.f13253d.m26955a(stringExtra);
                Intent intent2 = new Intent(this.f13720a.m1326l(), PlayService.class);
                intent2.setAction("com.ushareit.listenit.action.remoteplayback");
                intent2.putExtra("extra_action", 11);
                this.f13720a.m1326l().startService(intent2);
            }
        }
    }
}
