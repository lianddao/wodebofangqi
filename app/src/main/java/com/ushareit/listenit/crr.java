package com.ushareit.listenit;

import com.mopub.common.Constants;

public class crr {
    public String f8825a;
    public boolean f8826b;
    public String f8827c;
    public String f8828d;

    public String toString() {
        String str = this.f8826b ? "s" : "";
        String str2 = this.f8825a;
        return new StringBuilder((String.valueOf(str).length() + 7) + String.valueOf(str2).length()).append(Constants.HTTP).append(str).append("://").append(str2).toString();
    }
}
