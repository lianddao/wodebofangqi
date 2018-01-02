package com.ushareit.listenit;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

class cxo implements cxn {
    private static ThreadLocal<CharsetDecoder> f9313a = new cxp();
    private static ThreadLocal<CharsetEncoder> f9314b = new cxq();
    private StringBuilder f9315c = new StringBuilder();

    cxo() {
    }

    private String m13310b(byte[] bArr) {
        try {
            return ((CharsetDecoder) f9313a.get()).decode(ByteBuffer.wrap(bArr)).toString();
        } catch (CharacterCodingException e) {
            return null;
        }
    }

    public cya mo1662a() {
        return new cya(this.f9315c.toString());
    }

    public boolean mo1663a(byte[] bArr) {
        String b = m13310b(bArr);
        if (b == null) {
            return false;
        }
        this.f9315c.append(b);
        return true;
    }
}
