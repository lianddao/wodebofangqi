package com.ushareit.listenit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class ate {
    public static final String m7118a(Throwable th) {
        if (th == null) {
            return null;
        }
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }
}
