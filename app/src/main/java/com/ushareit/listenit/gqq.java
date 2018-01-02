package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lyrics.LyricEditorActivity;
import com.ushareit.listenit.popupview.NormalPlayerMenu;

public class gqq implements OnClickListener {
    final /* synthetic */ NormalPlayerMenu f14566a;

    public gqq(NormalPlayerMenu normalPlayerMenu) {
        this.f14566a = normalPlayerMenu;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f14566a.getContext(), LyricEditorActivity.class);
        intent.putExtra("song_id", gyp.m23298l());
        intent.putExtra("is_load_lyric", true);
        this.f14566a.getContext().startActivity(intent);
        fin.m19355c(this.f14566a.getContext(), "normal_player_menu");
        this.f14566a.m25608a();
    }
}
