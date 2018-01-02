package com.ushareit.listenit;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.config.internal.FetchConfigIpcResponse;
import java.util.Map;

public interface cjz extends IInterface {
    void mo1379a(Status status);

    void mo1380a(Status status, FetchConfigIpcResponse fetchConfigIpcResponse);

    void mo1381a(Status status, Map map);

    void mo1382a(Status status, byte[] bArr);
}
