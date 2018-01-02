package com.ushareit.listenit;

import java.security.MessageDigest;
import java.util.UUID;

class ach implements uv {
    private final UUID f4112a;

    public ach() {
        this(UUID.randomUUID());
    }

    ach(UUID uuid) {
        this.f4112a = uuid;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ach) {
            return ((ach) obj).f4112a.equals(this.f4112a);
        }
        return false;
    }

    public int hashCode() {
        return this.f4112a.hashCode();
    }

    public void mo583a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
