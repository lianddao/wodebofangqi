package com.ushareit.listenit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.ushareit.listenit.musicfolders.MusicFoldersActivity;

public class glj implements OnItemClickListener {
    final /* synthetic */ MusicFoldersActivity f14362a;

    public glj(MusicFoldersActivity musicFoldersActivity) {
        this.f14362a = musicFoldersActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        gkz a = this.f14362a.f15972p.m22365a(i);
        a.m20775a(!a.m20780f());
        this.f14362a.f15972p.notifyDataSetChanged();
        this.f14362a.m25084c(i);
        this.f14362a.f15970n.setEnabled(this.f14362a.m25089p());
    }
}
