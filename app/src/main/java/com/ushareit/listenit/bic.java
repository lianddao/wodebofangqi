package com.ushareit.listenit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bic {
    private static final Pattern f6392c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int f6393a = -1;
    public int f6394b = -1;

    public boolean m8553a(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.f6393a = i2;
        this.f6394b = i3;
        return true;
    }

    public boolean m8554a(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = f6392c.matcher(str2);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1), 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f6393a = parseInt;
            this.f6394b = parseInt2;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean m8552a() {
        return (this.f6393a == -1 || this.f6394b == -1) ? false : true;
    }
}
