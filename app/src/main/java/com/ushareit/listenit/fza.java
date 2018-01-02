package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;

class fza extends epm {
    final /* synthetic */ int f13750a;
    final /* synthetic */ fyz f13751b;

    fza(fyz com_ushareit_listenit_fyz, int i) {
        this.f13751b = com_ushareit_listenit_fyz;
        this.f13750a = i;
    }

    public void mo2230b(epk com_ushareit_listenit_epk) {
        try {
            erj.m17570a(this.f13751b.f13748a.f13261c, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            this.f13751b.f13748a.f13261c.setTextSize(2, (float) this.f13751b.f13748a.m1329n().getInteger(C0349R.integer.scan_song_count_text_size));
            this.f13751b.f13748a.f13261c.setText(String.valueOf(this.f13750a));
            this.f13751b.f13748a.f13262d.setVisibility(0);
        } catch (Exception e) {
        }
        super.mo2230b(com_ushareit_listenit_epk);
    }
}
