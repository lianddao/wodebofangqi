package com.ushareit.listenit;

import com.ushareit.listenit.cutter.AudioClipsActivity;
import java.util.List;

public class fog extends hhw {
    List<gkx> f13095a = null;
    final /* synthetic */ AudioClipsActivity f13096b;

    public fog(AudioClipsActivity audioClipsActivity) {
        this.f13096b = audioClipsActivity;
    }

    public void execute() {
        this.f13095a = fqs.m20483p();
    }

    public void callback() {
        if (this.f13095a != null) {
            if (this.f13095a.size() == 0) {
                this.f13096b.m12789j();
            }
            this.f13096b.f9025q.m20219a(this.f13095a);
            this.f13096b.f9030z.m27002a(this.f13095a, 14);
            this.f13096b.f9024p.setVisibility(8);
        }
    }
}
