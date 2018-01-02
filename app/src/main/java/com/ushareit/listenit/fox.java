package com.ushareit.listenit;

import com.ushareit.listenit.cutter.RingEditActivity;

public class fox extends hhw {
    final /* synthetic */ RingEditActivity f13127a;

    public fox(RingEditActivity ringEditActivity) {
        this.f13127a = ringEditActivity;
    }

    public void execute() {
        this.f13127a.f9045A = fpm.m20254a(this.f13127a.f9055n.f14342j, null);
    }

    public void callback() {
        this.f13127a.f9048D = true;
        if (this.f13127a.f9045A != null) {
            this.f13127a.f9058q.m12914a(this.f13127a.f9057p);
            this.f13127a.f9057p.m12903a(this.f13127a.f9058q);
            this.f13127a.f9057p.m12904a(this.f13127a.f9045A);
            this.f13127a.f9057p.setMarkerMoveCallback(this.f13127a.f9053I);
            this.f13127a.m12813c(this.f13127a.f9057p.getDuration());
            this.f13127a.f9057p.setButtonsEnable(true);
            this.f13127a.f9058q.setButtonsEnable(true);
        } else {
            heb.m23597a(this.f13127a.getString(C0349R.string.cutter_decode_error), 0).show();
        }
        this.f13127a.m12829j();
    }
}
