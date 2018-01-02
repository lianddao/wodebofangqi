package com.ushareit.listenit;

import com.ushareit.listenit.fragments.ScanFragment;

public class fyz implements gry {
    final /* synthetic */ ScanFragment f13748a;

    public fyz(ScanFragment scanFragment) {
        this.f13748a = scanFragment;
    }

    public void mo2626a(int i, int i2) {
        this.f13748a.m20562a(new fza(this, i));
        if (i > 0) {
            if (i2 > 0) {
                this.f13748a.f13263e.setText(this.f13748a.m1276a((int) C0349R.string.scan_result_music_found2, Integer.valueOf(i), Integer.valueOf(i2)));
            } else {
                this.f13748a.f13263e.setText(this.f13748a.m1276a((int) C0349R.string.scan_result_music_found, Integer.valueOf(i)));
            }
            this.f13748a.f13264f.setVisibility(4);
            this.f13748a.f13265g.setText(this.f13748a.f13266h ? this.f13748a.m1275a((int) C0349R.string.scan_button_start_enjoy_music) : this.f13748a.m1275a((int) C0349R.string.scan_button_finish));
        } else {
            this.f13748a.f13263e.setText(this.f13748a.m1275a((int) C0349R.string.scan_result_music_not_found_title));
            this.f13748a.f13264f.setText(this.f13748a.m1275a((int) C0349R.string.scan_result_music_not_found_help));
            this.f13748a.f13264f.setVisibility(0);
            this.f13748a.f13265g.setText(this.f13748a.f13266h ? this.f13748a.m1275a((int) C0349R.string.scan_button_go_to_homepage) : this.f13748a.m1275a((int) C0349R.string.scan_button_finish));
        }
        this.f13748a.f13260b.m26987a();
    }

    public void mo2628b(int i, int i2) {
        this.f13748a.f13263e.setText(this.f13748a.m1276a((int) C0349R.string.scan_result_song_count, Integer.valueOf(i)));
    }

    public void mo2627a(String str, int i) {
        this.f13748a.f13261c.setText(this.f13748a.m1276a((int) C0349R.string.scan_percent, Integer.valueOf(i)));
        this.f13748a.f13264f.setText(str);
    }
}
