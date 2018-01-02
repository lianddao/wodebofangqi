package com.ushareit.listenit;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.internal.FusedLocationProviderResult;

class dtb extends dtf {
    private final dlv<Status> f10314a;

    public dtb(dlv<Status> com_ushareit_listenit_dlv_com_google_android_gms_common_api_Status) {
        this.f10314a = com_ushareit_listenit_dlv_com_google_android_gms_common_api_Status;
    }

    public void mo2033a(FusedLocationProviderResult fusedLocationProviderResult) {
        this.f10314a.mo1274a(fusedLocationProviderResult.mo260b());
    }
}
