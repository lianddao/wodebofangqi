package com.ushareit.listenit;

import android.location.Address;
import android.location.Geocoder;
import android.text.TextUtils;
import java.util.List;

class gbg extends hhv {
    final /* synthetic */ double f13854a;
    final /* synthetic */ double f13855b;
    final /* synthetic */ gbf f13856c;

    gbg(gbf com_ushareit_listenit_gbf, double d, double d2) {
        this.f13856c = com_ushareit_listenit_gbf;
        this.f13854a = d;
        this.f13855b = d2;
    }

    public void e_() {
        try {
            List fromLocation = new Geocoder(eys.m18562a()).getFromLocation(this.f13854a, this.f13855b, 1);
            if (fromLocation != null && fromLocation.size() > 0) {
                Address address = (Address) fromLocation.get(0);
                String locality = address.getLocality();
                if (TextUtils.isEmpty(locality)) {
                    locality = address.getAdminArea();
                    if (TextUtils.isEmpty(locality)) {
                        Object countryName = address.getCountryName();
                        if (!TextUtils.isEmpty(countryName)) {
                            exw.m18454c(hhw.TAG, "address:" + locality);
                            gvj.m23033t(eys.m18562a(), countryName);
                            m21592c();
                            return;
                        }
                        return;
                    }
                    exw.m18454c(hhw.TAG, "address:" + locality);
                    gvj.m23033t(eys.m18562a(), locality);
                    m21592c();
                    return;
                }
                exw.m18454c(hhw.TAG, "address:" + locality);
                gvj.m23033t(eys.m18562a(), locality);
                m21592c();
            }
        } catch (Throwable e) {
            exw.m18450b(hhw.TAG, "Exception happened when get address from location", e);
        }
    }

    private void m21592c() {
        gvj.m22918c(0);
    }
}
