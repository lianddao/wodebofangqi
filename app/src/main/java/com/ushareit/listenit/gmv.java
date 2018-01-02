package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.login.LoginActivity;
import com.ushareit.listenit.nearby.view.SongMenuActivity;

public class gmv implements OnClickListener {
    final /* synthetic */ SongMenuActivity f14431a;

    public gmv(SongMenuActivity songMenuActivity) {
        this.f14431a = songMenuActivity;
    }

    public void onClick(View view) {
        if (frd.m20619c(this.f14431a.f16013r.getId())) {
            m22463a();
        } else if (gef.m21805a().m21835e()) {
            this.f14431a.m25198s();
            if (fhy.m19213a()) {
                this.f14431a.m25196q();
            } else {
                this.f14431a.f15999A.setImageResource(C0349R.drawable.collection_selected);
            }
            this.f14431a.f16001C.setImageResource(C0349R.drawable.collection_title_pressed);
            m22463a();
            fir.m19392e();
        } else {
            this.f14431a.startActivity(new Intent(this.f14431a, LoginActivity.class));
        }
    }

    private void m22463a() {
        if (fhy.m19213a()) {
            heb.m23597a(this.f14431a.getString(C0349R.string.nearby_song_add_to_playlist_b) + "\n" + this.f14431a.getString(C0349R.string.nearby_song_add_to_all_songs_b), 0).show();
        } else {
            heb.m23597a(this.f14431a.getString(C0349R.string.nearby_song_add_to_playlist), 0).show();
        }
    }
}
