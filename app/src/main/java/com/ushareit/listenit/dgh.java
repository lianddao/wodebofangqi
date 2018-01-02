package com.ushareit.listenit;

import java.io.IOException;

public class dgh extends IOException {
    public dgh(String str) {
        super(str);
    }

    static dgh m14246a() {
        return new dgh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static dgh m14247b() {
        return new dgh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static dgh m14248c() {
        return new dgh("CodedInputStream encountered a malformed varint.");
    }

    static dgh m14249d() {
        return new dgh("Protocol message contained an invalid tag (zero).");
    }

    static dgh m14250e() {
        return new dgh("Protocol message end-group tag did not match expected tag.");
    }

    static dgh m14251f() {
        return new dgh("Protocol message tag had invalid wire type.");
    }

    static dgh m14252g() {
        return new dgh("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
