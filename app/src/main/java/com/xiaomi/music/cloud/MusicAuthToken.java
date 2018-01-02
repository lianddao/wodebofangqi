package com.xiaomi.music.cloud;

import android.text.TextUtils;

public final class MusicAuthToken {
    private static final String SP = ",";
    private final String mAuthToken;
    private final String mSecurity;

    private MusicAuthToken(String authToken, String security) {
        this.mAuthToken = authToken;
        this.mSecurity = security;
    }

    public String getAuthToken() {
        return this.mAuthToken;
    }

    public String getSecurity() {
        return this.mSecurity;
    }

    public static MusicAuthToken build(String authToken, String security) {
        return new MusicAuthToken(authToken, security);
    }

    public static MusicAuthToken parse(String plain) {
        if (TextUtils.isEmpty(plain)) {
            return null;
        }
        String[] parts = plain.split(",");
        if (parts.length == 2) {
            return new MusicAuthToken(parts[0], parts[1]);
        }
        return null;
    }

    public String toPlain() {
        return this.mAuthToken + "," + this.mSecurity;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MusicAuthToken that = (MusicAuthToken) o;
        if (this.mAuthToken == null ? that.mAuthToken != null : !this.mAuthToken.equals(that.mAuthToken)) {
            return false;
        }
        if (this.mSecurity != null) {
            if (this.mSecurity.equals(that.mSecurity)) {
                return true;
            }
        } else if (that.mSecurity == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result;
        int i = 0;
        if (this.mAuthToken != null) {
            result = this.mAuthToken.hashCode();
        } else {
            result = 0;
        }
        int i2 = result * 31;
        if (this.mSecurity != null) {
            i = this.mSecurity.hashCode();
        }
        return i2 + i;
    }
}
