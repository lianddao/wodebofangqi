package com.ushareit.listenit;

import android.os.IInterface;

public interface dra extends IInterface {
    boolean getBooleanFlagValue(String str, boolean z, int i);

    int getIntFlagValue(String str, int i, int i2);

    long getLongFlagValue(String str, long j, int i);

    String getStringFlagValue(String str, String str2, int i);

    void init(ckg com_ushareit_listenit_ckg);
}
