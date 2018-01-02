package com.ushareit.listenit;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;

class gby implements ceh<LocationSettingsResult> {
    final /* synthetic */ gbu f13890a;

    gby(gbu com_ushareit_listenit_gbu) {
        this.f13890a = com_ushareit_listenit_gbu;
    }

    public void m21656a(LocationSettingsResult locationSettingsResult) {
        Status b = locationSettingsResult.mo260b();
        switch (b.m2259h()) {
            case 0:
                exw.m18443a("LOC.GPServicesProvider", "We got GPS, Wifi and/or Cell network providers enabled enough to receive location as we needed. Requesting location update...");
                this.f13890a.m21647h();
                return;
            case 6:
                try {
                    exw.m18443a("LOC.GPServicesProvider", "We need settingsApi to display dialog to switch required settings on, displaying the dialog...");
                    this.f13890a.f13882e = true;
                    b.m2252a(this.f13890a.a, 260);
                    return;
                } catch (SendIntentException e) {
                    exw.m18457e("LOC.GPServicesProvider", "Error on displaying SettingsApi dialog, GP_SettingsApi failing...");
                    this.f13890a.m21638a(6);
                    return;
                }
            case 8502:
                exw.m18457e("LOC.GPServicesProvider", "Settings change is not available, GP_SettingsApi failing...");
                this.f13890a.m21638a(6);
                return;
            default:
                return;
        }
    }
}
