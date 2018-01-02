package com.ushareit.listenit;

import com.ushareit.listenit.musicfolders.MusicFoldersActivity;
import java.util.List;

public class gli extends hhw {
    List<gkz> f14360a = null;
    final /* synthetic */ MusicFoldersActivity f14361b;

    public gli(MusicFoldersActivity musicFoldersActivity) {
        this.f14361b = musicFoldersActivity;
    }

    public void execute() {
        this.f14360a = fqs.m20478k();
        this.f14361b.m25081a(this.f14360a);
    }

    public void callback() {
        if (this.f14360a == null || this.f14360a.size() <= 0) {
            this.f14361b.f15974r.setVisibility(8);
            this.f14361b.f15975s.setVisibility(0);
            return;
        }
        this.f14361b.f15972p.m22367a(this.f14360a);
        this.f14361b.f15973q.setVisibility(8);
    }
}
