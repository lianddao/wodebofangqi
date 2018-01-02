package com.ushareit.listenit;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;

class dn {
    static RemoteInput[] m14983a(dp[] dpVarArr) {
        if (dpVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[dpVarArr.length];
        for (int i = 0; i < dpVarArr.length; i++) {
            dp dpVar = dpVarArr[i];
            remoteInputArr[i] = new Builder(dpVar.mo1756a()).setLabel(dpVar.mo1757b()).setChoices(dpVar.mo1758c()).setAllowFreeFormInput(dpVar.mo1759d()).addExtras(dpVar.mo1760e()).build();
        }
        return remoteInputArr;
    }
}
