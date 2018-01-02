package com.ushareit.listenit;

import android.util.Log;
import java.io.Writer;

public class fu extends Writer {
    private final String f13507a;
    private StringBuilder f13508b = new StringBuilder(128);

    public fu(String str) {
        this.f13507a = str;
    }

    public void close() {
        m20991a();
    }

    public void flush() {
        m20991a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m20991a();
            } else {
                this.f13508b.append(c);
            }
        }
    }

    private void m20991a() {
        if (this.f13508b.length() > 0) {
            Log.d(this.f13507a, this.f13508b.toString());
            this.f13508b.delete(0, this.f13508b.length());
        }
    }
}
