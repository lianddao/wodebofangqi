package com.ushareit.listenit;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.location.ActivityRecognitionRequest;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.List;

public interface dtk extends IInterface {
    Location mo2037a();

    ActivityRecognitionResult mo2038a(String str);

    void mo2039a(long j, boolean z, PendingIntent pendingIntent);

    void mo2040a(PendingIntent pendingIntent);

    void mo2041a(PendingIntent pendingIntent, dnx com_ushareit_listenit_dnx);

    void mo2042a(PendingIntent pendingIntent, dth com_ushareit_listenit_dth, String str);

    void mo2043a(Location location);

    void mo2044a(Location location, int i);

    void mo2045a(ActivityRecognitionRequest activityRecognitionRequest, PendingIntent pendingIntent, dnx com_ushareit_listenit_dnx);

    void mo2046a(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, dnx com_ushareit_listenit_dnx);

    void mo2047a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, dth com_ushareit_listenit_dth);

    void mo2048a(GestureRequest gestureRequest, PendingIntent pendingIntent, dnx com_ushareit_listenit_dnx);

    void mo2049a(LocationRequest locationRequest, PendingIntent pendingIntent);

    void mo2050a(LocationRequest locationRequest, duk com_ushareit_listenit_duk);

    void mo2051a(LocationRequest locationRequest, duk com_ushareit_listenit_duk, String str);

    void mo2052a(LocationSettingsRequest locationSettingsRequest, dtn com_ushareit_listenit_dtn, String str);

    void mo2053a(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent);

    void mo2054a(LocationRequestInternal locationRequestInternal, duk com_ushareit_listenit_duk);

    void mo2055a(LocationRequestUpdateData locationRequestUpdateData);

    void mo2056a(dnx com_ushareit_listenit_dnx);

    void mo2057a(dte com_ushareit_listenit_dte);

    void mo2058a(dth com_ushareit_listenit_dth, String str);

    void mo2059a(duk com_ushareit_listenit_duk);

    void mo2060a(List<ParcelableGeofence> list, PendingIntent pendingIntent, dth com_ushareit_listenit_dth, String str);

    void mo2061a(boolean z);

    void mo2062a(String[] strArr, dth com_ushareit_listenit_dth, String str);

    Location mo2063b(String str);

    void mo2064b(PendingIntent pendingIntent);

    void mo2065b(PendingIntent pendingIntent, dnx com_ushareit_listenit_dnx);

    LocationAvailability mo2066c(String str);

    void mo2067c(PendingIntent pendingIntent, dnx com_ushareit_listenit_dnx);

    void mo2068d(PendingIntent pendingIntent, dnx com_ushareit_listenit_dnx);

    void mo2069e(PendingIntent pendingIntent, dnx com_ushareit_listenit_dnx);

    void mo2070f(PendingIntent pendingIntent, dnx com_ushareit_listenit_dnx);
}
