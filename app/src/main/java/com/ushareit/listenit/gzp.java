package com.ushareit.listenit;

class gzp implements gry {
    final /* synthetic */ gzn f14984a;
    private int f14985b = 0;

    gzp(gzn com_ushareit_listenit_gzn) {
        this.f14984a = com_ushareit_listenit_gzn;
    }

    public void mo2626a(int i, int i2) {
        this.f14984a.f14975k.setText(this.f14984a.f14978n.getResources().getString(C0349R.string.main_fragment_song_count, new Object[]{Integer.valueOf(i)}));
        if (this.f14984a.f14980q != null) {
            this.f14984a.f14980q.m22060a(i);
        }
        if (gvj.m22883V(eys.m18562a()) > 0) {
            this.f14984a.f14979p.setVisibility(0);
            this.f14984a.f14979p.setText(this.f14984a.f14978n.getString(C0349R.string.main_fragment_remove_duplicate_songs, new Object[]{Integer.valueOf(i2)}));
            return;
        }
        this.f14984a.f14979p.setVisibility(8);
    }

    public void mo2628b(int i, int i2) {
        if (i2 != this.f14985b) {
            this.f14984a.f14975k.setText(this.f14984a.f14978n.getResources().getString(C0349R.string.main_fragment_song_count, new Object[]{Integer.valueOf(i2)}));
            this.f14985b = i2;
            if (this.f14984a.f14980q != null) {
                this.f14984a.f14980q.m22060a(i2);
            }
        }
    }

    public void mo2627a(String str, int i) {
    }
}
