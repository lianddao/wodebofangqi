package com.ushareit.listenit;

import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;

public class zh implements uu<InputStream> {
    public boolean m27283a(InputStream inputStream, OutputStream outputStream) {
        byte[] b = afn.m5467a().m5469b();
        while (true) {
            try {
                int read = inputStream.read(b);
                if (read != -1) {
                    outputStream.write(b, 0, read);
                } else {
                    afn.m5467a().m5468a(b);
                    return true;
                }
            } catch (Throwable e) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                }
                afn.m5467a().m5468a(b);
                return false;
            } catch (Throwable th) {
                afn.m5467a().m5468a(b);
            }
        }
    }

    public String mo551a() {
        return "";
    }
}
