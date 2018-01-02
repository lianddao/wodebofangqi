package com.ushareit.listenit;

import java.security.MessageDigest;

class wj implements uv {
    private final String f17480a;
    private final uv f17481b;

    public wj(String str, uv uvVar) {
        this.f17480a = str;
        this.f17481b = uvVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        wj wjVar = (wj) obj;
        if (!this.f17480a.equals(wjVar.f17480a)) {
            return false;
        }
        if (this.f17481b.equals(wjVar.f17481b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f17480a.hashCode() * 31) + this.f17481b.hashCode();
    }

    public void mo583a(MessageDigest messageDigest) {
        messageDigest.update(this.f17480a.getBytes("UTF-8"));
        this.f17481b.mo583a(messageDigest);
    }
}
