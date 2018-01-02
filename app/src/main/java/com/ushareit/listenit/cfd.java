package com.ushareit.listenit;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public class cfd extends chn {
    int f8211a;

    public static Account m11071a(chm com_ushareit_listenit_chm) {
        Account account = null;
        if (com_ushareit_listenit_chm != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = com_ushareit_listenit_chm.mo1302a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account mo1302a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.f8211a) {
            if (cjj.zzf(null, callingUid)) {
                this.f8211a = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        Account account = null;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cfd)) {
            return false;
        }
        cfd com_ushareit_listenit_cfd = (cfd) obj;
        return account.equals(account);
    }
}
