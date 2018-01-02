package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.MediaCodec.CodecException;
import com.google.android.exoplayer2.Format;

public class bmu extends Exception {
    public final String f7113a;
    public final boolean f7114b;
    public final String f7115c;
    public final String f7116d;

    public bmu(Format format, Throwable th, boolean z, int i) {
        super("Decoder init failed: [" + i + "], " + format, th);
        this.f7113a = format.f1431e;
        this.f7114b = z;
        this.f7115c = null;
        this.f7116d = m9095a(i);
    }

    public bmu(Format format, Throwable th, boolean z, String str) {
        super("Decoder init failed: " + str + ", " + format, th);
        this.f7113a = format.f1431e;
        this.f7114b = z;
        this.f7115c = str;
        this.f7116d = btc.f7662a >= 21 ? m9096a(th) : null;
    }

    @TargetApi(21)
    private static String m9096a(Throwable th) {
        if (th instanceof CodecException) {
            return ((CodecException) th).getDiagnosticInfo();
        }
        return null;
    }

    private static String m9095a(int i) {
        return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
    }
}
