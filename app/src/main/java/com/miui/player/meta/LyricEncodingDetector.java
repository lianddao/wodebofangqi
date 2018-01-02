package com.miui.player.meta;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.mozilla.universalchardet.UniversalDetector;

public class LyricEncodingDetector {
    private static final Map<String, String> ENCODE_MAPPING = new HashMap();
    private static final Set<String> SUPPORTED_ENCODING = Charset.availableCharsets().keySet();

    static {
        ENCODE_MAPPING.put("GB18030", "GBK");
    }

    public static String detectEncode(String filePath) throws IOException {
        Throwable th;
        UniversalDetector detector = new UniversalDetector(null);
        byte[] buf = new byte[1024];
        FileInputStream fis = null;
        String encoding = null;
        try {
            FileInputStream fis2 = new FileInputStream(filePath);
            do {
                try {
                    int nread = fis2.read(buf);
                    if (nread <= 0) {
                        break;
                    }
                    detector.handleData(buf, 0, nread);
                } catch (Throwable th2) {
                    th = th2;
                    fis = fis2;
                }
            } while (!detector.isDone());
            encoding = detector.getDetectedCharset();
            detector.dataEnd();
            if (fis2 != null) {
                fis2.close();
            }
            return postProcess(encoding);
        } catch (Throwable th3) {
            th = th3;
            if (fis != null) {
                fis.close();
            }
            throw th;
        }
    }

    private static String postProcess(String encode) {
        String ret = null;
        if (encode != null) {
            if (SUPPORTED_ENCODING.contains(encode)) {
                ret = encode;
            } else {
                ret = (String) ENCODE_MAPPING.get(encode);
            }
        }
        return ret != null ? ret : "GBK";
    }
}
