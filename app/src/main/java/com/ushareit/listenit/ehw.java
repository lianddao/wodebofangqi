package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public final class ehw extends Handler {
    private static final Map<Level, Integer> f11070a = new HashMap(7);

    private ehw() {
    }

    static {
        f11070a.put(Level.FINEST, Integer.valueOf(2));
        f11070a.put(Level.FINER, Integer.valueOf(2));
        f11070a.put(Level.FINE, Integer.valueOf(2));
        f11070a.put(Level.CONFIG, Integer.valueOf(3));
        f11070a.put(Level.INFO, Integer.valueOf(4));
        f11070a.put(Level.WARNING, Integer.valueOf(5));
        f11070a.put(Level.SEVERE, Integer.valueOf(6));
    }

    @SuppressLint({"LogTagMismatch"})
    public void publish(LogRecord logRecord) {
        if (isLoggable(logRecord)) {
            int intValue;
            if (f11070a.containsKey(logRecord.getLevel())) {
                intValue = ((Integer) f11070a.get(logRecord.getLevel())).intValue();
            } else {
                intValue = 2;
            }
            String str = logRecord.getMessage() + "\n";
            Throwable thrown = logRecord.getThrown();
            if (thrown != null) {
                str = str + Log.getStackTraceString(thrown);
            }
            Log.println(intValue, "MoPub", str);
        }
    }

    public void close() {
    }

    public void flush() {
    }
}
