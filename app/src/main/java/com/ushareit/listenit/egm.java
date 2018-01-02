package com.ushareit.listenit;

import com.mopub.common.DiskLruCache.Editor;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class egm extends FilterOutputStream {
    final /* synthetic */ Editor f11037a;

    private egm(Editor editor, OutputStream outputStream) {
        this.f11037a = editor;
        super(outputStream);
    }

    public void write(int i) {
        try {
            this.out.write(i);
        } catch (IOException e) {
            this.f11037a.f2088d = true;
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            this.out.write(bArr, i, i2);
        } catch (IOException e) {
            this.f11037a.f2088d = true;
        }
    }

    public void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            this.f11037a.f2088d = true;
        }
    }

    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            this.f11037a.f2088d = true;
        }
    }
}
