package com.ushareit.listenit;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class dyk extends dxc {
    private final dyf f10695a;
    private Boolean f10696b;
    private String f10697c;

    public dyk(dyf com_ushareit_listenit_dyf) {
        this(com_ushareit_listenit_dyf, null);
    }

    public dyk(dyf com_ushareit_listenit_dyf, String str) {
        cfi.m11080a((Object) com_ushareit_listenit_dyf);
        this.f10695a = com_ushareit_listenit_dyf;
        this.f10697c = str;
    }

    private void m16483c(AppMetadata appMetadata) {
        cfi.m11080a((Object) appMetadata);
        m16484c(appMetadata.f1886b);
        this.f10695a.m16464o().m15972h(appMetadata.f1887c);
    }

    private void m16484c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f10695a.m16455f().m16242f().m16263a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            m16493b(str);
        } catch (SecurityException e) {
            this.f10695a.m16455f().m16242f().m16264a("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    public List<UserAttributeParcel> mo2100a(AppMetadata appMetadata, boolean z) {
        Object e;
        m16483c(appMetadata);
        try {
            List<dwj> list = (List) this.f10695a.m16457h().m16379a(new dyr(this, appMetadata)).get();
            List<UserAttributeParcel> arrayList = new ArrayList(list.size());
            for (dwj com_ushareit_listenit_dwj : list) {
                if (z || !dwk.m15939l(com_ushareit_listenit_dwj.f10475b)) {
                    arrayList.add(new UserAttributeParcel(com_ushareit_listenit_dwj));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.f10695a.m16455f().m16242f().m16264a("Failed to get user attributes", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.f10695a.m16455f().m16242f().m16264a("Failed to get user attributes", e);
            return null;
        }
    }

    public void mo2101a(AppMetadata appMetadata) {
        m16483c(appMetadata);
        this.f10695a.m16457h().m16380a(new dys(this, appMetadata));
    }

    public void mo2102a(EventParcel eventParcel, AppMetadata appMetadata) {
        cfi.m11080a((Object) eventParcel);
        m16483c(appMetadata);
        this.f10695a.m16457h().m16380a(new dym(this, appMetadata, eventParcel));
    }

    public void mo2103a(EventParcel eventParcel, String str, String str2) {
        cfi.m11080a((Object) eventParcel);
        cfi.m11082a(str);
        m16484c(str);
        this.f10695a.m16457h().m16380a(new dyn(this, str2, eventParcel, str));
    }

    public void mo2104a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        cfi.m11080a((Object) userAttributeParcel);
        m16483c(appMetadata);
        if (userAttributeParcel.m2445a() == null) {
            this.f10695a.m16457h().m16380a(new dyp(this, appMetadata, userAttributeParcel));
        } else {
            this.f10695a.m16457h().m16380a(new dyq(this, appMetadata, userAttributeParcel));
        }
    }

    void m16490a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.f10695a.m16454e().f10593b.m16335a(split[1], longValue);
                    } else {
                        this.f10695a.m16455f().m16262z().m16264a("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.f10695a.m16455f().m16262z().m16264a("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    public byte[] mo2105a(EventParcel eventParcel, String str) {
        Object e;
        cfi.m11082a(str);
        cfi.m11080a((Object) eventParcel);
        m16484c(str);
        this.f10695a.m16455f().m16234D().m16264a("Log and bundle. event", eventParcel.f1900b);
        long c = this.f10695a.m16468s().mo1372c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f10695a.m16457h().m16381b(new dyo(this, eventParcel, str)).get();
            if (bArr == null) {
                this.f10695a.m16455f().m16242f().m16263a("Log and bundle returned null");
                bArr = new byte[0];
            }
            this.f10695a.m16455f().m16234D().m16266a("Log and bundle processed. event, size, time_ms", eventParcel.f1900b, Integer.valueOf(bArr.length), Long.valueOf((this.f10695a.m16468s().mo1372c() / 1000000) - c));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            this.f10695a.m16455f().m16242f().m16265a("Failed to log and bundle. event, error", eventParcel.f1900b, e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.f10695a.m16455f().m16242f().m16265a("Failed to log and bundle. event, error", eventParcel.f1900b, e);
            return null;
        }
    }

    public void mo2106b(AppMetadata appMetadata) {
        m16483c(appMetadata);
        this.f10695a.m16457h().m16380a(new dyl(this, appMetadata));
    }

    protected void m16493b(String str) {
        if (this.f10697c == null && cjj.zzb(this.f10695a.m16467r(), Binder.getCallingUid(), str)) {
            this.f10697c = str;
        }
        if (!str.equals(this.f10697c)) {
            if (this.f10696b == null) {
                boolean z = ("com.google.android.gms".equals(this.f10697c) || ciy.m11422a(this.f10695a.m16467r(), Binder.getCallingUid())) && !this.f10695a.m16422D();
                this.f10696b = Boolean.valueOf(z);
            }
            if (!this.f10696b.booleanValue()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }
}
