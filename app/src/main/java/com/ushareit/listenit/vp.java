package com.ushareit.listenit;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

class vp<DataType> implements xi {
    final /* synthetic */ vm f17052a;
    private final uu<DataType> f17053b;
    private final DataType f17054c;

    public vp(vm vmVar, uu<DataType> uuVar, DataType dataType) {
        this.f17052a = vmVar;
        this.f17053b = uuVar;
        this.f17054c = dataType;
    }

    public boolean mo3108a(File file) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            outputStream = this.f17052a.f17050l.m26726a(file);
            z = this.f17053b.mo552a(this.f17054c, outputStream);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable e2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "Failed to find file to write to disk cache", e2);
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                }
            }
        }
        return z;
    }
}
