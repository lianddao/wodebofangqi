package com.ushareit.listenit;

import android.os.IInterface;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.List;

public interface dxb extends IInterface {
    List<UserAttributeParcel> mo2100a(AppMetadata appMetadata, boolean z);

    void mo2101a(AppMetadata appMetadata);

    void mo2102a(EventParcel eventParcel, AppMetadata appMetadata);

    void mo2103a(EventParcel eventParcel, String str, String str2);

    void mo2104a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata);

    byte[] mo2105a(EventParcel eventParcel, String str);

    void mo2106b(AppMetadata appMetadata);
}
