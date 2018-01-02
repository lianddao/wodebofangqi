package com.ushareit.listenit;

import android.os.Bundle;

class dr {
    static Bundle m15308a(dp dpVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", dpVar.mo1756a());
        bundle.putCharSequence("label", dpVar.mo1757b());
        bundle.putCharSequenceArray("choices", dpVar.mo1758c());
        bundle.putBoolean("allowFreeFormInput", dpVar.mo1759d());
        bundle.putBundle("extras", dpVar.mo1760e());
        return bundle;
    }

    static Bundle[] m15309a(dp[] dpVarArr) {
        if (dpVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[dpVarArr.length];
        for (int i = 0; i < dpVarArr.length; i++) {
            bundleArr[i] = m15308a(dpVarArr[i]);
        }
        return bundleArr;
    }
}
