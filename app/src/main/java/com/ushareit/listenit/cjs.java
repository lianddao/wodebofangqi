package com.ushareit.listenit;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.config.internal.FetchConfigIpcResponse;

class cjs extends cjp {
    final /* synthetic */ cjr f8377a;

    cjs(cjr com_ushareit_listenit_cjr) {
        this.f8377a = com_ushareit_listenit_cjr;
    }

    public void mo1380a(Status status, FetchConfigIpcResponse fetchConfigIpcResponse) {
        if (fetchConfigIpcResponse.m2331b() == 6502 || fetchConfigIpcResponse.m2331b() == 6507) {
            this.f8377a.m10793b(new cjt(cjn.m11450b(fetchConfigIpcResponse.m2331b()), cjn.m11451b(fetchConfigIpcResponse), fetchConfigIpcResponse.m2333d()));
        } else {
            this.f8377a.m10793b(new cjt(cjn.m11450b(fetchConfigIpcResponse.m2331b()), cjn.m11451b(fetchConfigIpcResponse)));
        }
    }
}
