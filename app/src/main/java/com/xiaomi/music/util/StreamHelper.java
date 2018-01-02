package com.xiaomi.music.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

public class StreamHelper {
    static final String TAG = StreamHelper.class.getName();

    public static JSONObject toJSONObject(InputStream is) throws JSONException, IOException {
        return new JSONObject(toString(is));
    }

    public static String toString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = toByteArrayOutputStream(is);
        return baos != null ? baos.toString() : null;
    }

    public static byte[] toByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream baos = toByteArrayOutputStream(is);
        return baos != null ? baos.toByteArray() : null;
    }

    public static ByteArrayOutputStream toByteArrayOutputStream(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[512];
        while (true) {
            int length = is.read(buffer);
            if (length == -1) {
                return baos;
            }
            baos.write(buffer, 0, length);
        }
    }

    public static void wirteStringToStream(OutputStream out, String src) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer.write(src);
        writer.flush();
    }

    public static void closeSafe(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
