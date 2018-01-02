package com.ushareit.listenit;

import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class cax {
    private final TreeSet<Character> f8041a = new TreeSet();
    private final List<String> f8042b = new ArrayList();
    private final List<Integer> f8043c = new ArrayList();
    private int f8044d = 12;
    private int f8045e = 16;

    private TreeSet<Character> m10585a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new cay(String.valueOf(str2).concat(" cannot be null or empty"));
        }
        TreeSet<Character> treeSet = new TreeSet();
        for (char c : str.toCharArray()) {
            if (PasswordSpecification.m2187b(c, 32, 126)) {
                throw new cay(String.valueOf(str2).concat(" must only contain ASCII printable characters"));
            }
            treeSet.add(Character.valueOf(c));
        }
        return treeSet;
    }

    private void m10586b() {
        int i = 0;
        for (Integer intValue : this.f8043c) {
            i = intValue.intValue() + i;
        }
        if (i > this.f8045e) {
            throw new cay("required character count cannot be greater than the max password size");
        }
    }

    private void m10587c() {
        boolean[] zArr = new boolean[95];
        for (String toCharArray : this.f8042b) {
            for (char c : toCharArray.toCharArray()) {
                if (zArr[c - 32]) {
                    throw new cay("character " + c + " occurs in more than one required character set");
                }
                zArr[c - 32] = true;
            }
        }
    }

    public PasswordSpecification m10588a() {
        if (this.f8041a.isEmpty()) {
            throw new cay("no allowed characters specified");
        }
        m10586b();
        m10587c();
        return new PasswordSpecification(1, PasswordSpecification.m2186b(this.f8041a), this.f8042b, this.f8043c, this.f8044d, this.f8045e);
    }

    public cax m10589a(int i, int i2) {
        if (i < 1) {
            throw new cay("minimumSize must be at least 1");
        } else if (i > i2) {
            throw new cay("maximumSize must be greater than or equal to minimumSize");
        } else {
            this.f8044d = i;
            this.f8045e = i2;
            return this;
        }
    }

    public cax m10590a(String str) {
        this.f8041a.addAll(m10585a(str, "allowedChars"));
        return this;
    }

    public cax m10591a(String str, int i) {
        if (i < 1) {
            throw new cay("count must be at least 1");
        }
        this.f8042b.add(PasswordSpecification.m2186b(m10585a(str, "requiredChars")));
        this.f8043c.add(Integer.valueOf(i));
        return this;
    }
}
