package com.ushareit.listenit;

import android.location.Location;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;

public class dsx implements dsj {
    public Location mo2029a(cdz com_ushareit_listenit_cdz) {
        try {
            return dso.m15442a(com_ushareit_listenit_cdz).mo1281f();
        } catch (Exception e) {
            return null;
        }
    }

    public ced<Status> mo2030a(cdz com_ushareit_listenit_cdz, LocationRequest locationRequest, dsm com_ushareit_listenit_dsm) {
        return com_ushareit_listenit_cdz.mo2002b(new dsy(this, com_ushareit_listenit_cdz, locationRequest, com_ushareit_listenit_dsm));
    }

    public ced<Status> mo2031a(cdz com_ushareit_listenit_cdz, dsm com_ushareit_listenit_dsm) {
        return com_ushareit_listenit_cdz.mo2002b(new dsz(this, com_ushareit_listenit_cdz, com_ushareit_listenit_dsm));
    }

    public LocationAvailability mo2032b(cdz com_ushareit_listenit_cdz) {
        try {
            return dso.m15442a(com_ushareit_listenit_cdz).m15581y();
        } catch (Exception e) {
            return null;
        }
    }
}
