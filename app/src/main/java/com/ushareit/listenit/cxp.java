package com.ushareit.listenit;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

final class cxp extends ThreadLocal<CharsetDecoder> {
    cxp() {
    }

    protected CharsetDecoder m13313a() {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(CodingErrorAction.REPORT);
        newDecoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return newDecoder;
    }

    protected /* synthetic */ Object initialValue() {
        return m13313a();
    }
}
