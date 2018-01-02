package com.ushareit.listenit;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

final class cxq extends ThreadLocal<CharsetEncoder> {
    cxq() {
    }

    protected CharsetEncoder m13314a() {
        CharsetEncoder newEncoder = Charset.forName("UTF8").newEncoder();
        newEncoder.onMalformedInput(CodingErrorAction.REPORT);
        newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return newEncoder;
    }

    protected /* synthetic */ Object initialValue() {
        return m13314a();
    }
}
