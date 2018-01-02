package com.ushareit.listenit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ffl extends ese {
    public String f12605j;
    public String f12606k;
    public String f12607l;

    public ffl(String str, String str2) {
        super(str);
        m19108a(str);
        this.f12607l = str2;
    }

    private void m19108a(String str) {
        String str2 = "ad:(.*)_(.)_(.*)&&(.)";
        Matcher matcher = Pattern.compile("ad:(.*)_(.)_(.*)&&(.)").matcher(str);
        boolean find = matcher.find();
        int groupCount = matcher.groupCount();
        exw.m18449b("AdItem", "matcher.find=" + find + ", groupCount=" + groupCount + ", json=" + str);
        if (find && groupCount == 4) {
            this.a = matcher.group(1);
            this.f12606k = matcher.group(2);
            this.c = matcher.group(3);
            this.f12605j = matcher.group(4);
        }
        this.b = this.a + "-" + this.c;
        this.d = 1;
    }

    public String mo2366a() {
        return this.a + "-" + this.c + "-" + this.f12605j + "-" + this.f12606k + ", placement=" + this.f12607l;
    }
}
