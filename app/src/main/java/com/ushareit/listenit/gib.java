package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lyrics.LyricEditorActivity;
import com.ushareit.listenit.lyrics.LyricView;

public class gib implements OnClickListener {
    final /* synthetic */ LyricView f14151a;

    public gib(LyricView lyricView) {
        this.f14151a = lyricView;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f14151a.getContext(), LyricEditorActivity.class);
        intent.putExtra("song_id", gyp.m23298l());
        intent.putExtra("is_load_lyric", false);
        this.f14151a.getContext().startActivity(intent);
        fin.m19355c(this.f14151a.getContext(), "add_lyrics");
    }
}
