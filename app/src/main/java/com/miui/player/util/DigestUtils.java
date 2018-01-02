package com.miui.player.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {
    public static final String ALGORITHM_MD5 = "MD5";
    public static final String ALGORITHM_SHA_1 = "SHA-1";
    private static final int BUFFER_SIZE = 4096;
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    protected DigestUtils() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static byte[] get(CharSequence content, String algorithm) {
        return get(content.toString().getBytes(), algorithm);
    }

    public static byte[] get(byte[] content, String algorithm) {
        try {
            return get(new ByteArrayInputStream(content), algorithm);
        } catch (IOException e) {
            throw new RuntimeException("IO exception happend in ByteArrayInputStream", e);
        }
    }

    public static byte[] get(InputStream is, String algorithm) throws IOException {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] bytes = new byte[4096];
            while (true) {
                int read = is.read(bytes);
                if (read <= 0) {
                    return digest.digest();
                }
                digest.update(bytes, 0, read);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException", e);
        }
    }

    public static void toHexReadable(byte[] bytes, Appendable appendable) {
        if (bytes != null) {
            try {
                for (int n : bytes) {
                    int n2;
                    if (n2 < (byte) 0) {
                        n2 += 256;
                    }
                    appendable.append(HEX_DIGITS[n2 >> 4]).append(HEX_DIGITS[n2 & 15]);
                }
            } catch (IOException e) {
                throw new RuntimeException("Exception throw during when append", e);
            }
        }
    }

    public static String toHexReadable(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        toHexReadable(bytes, builder);
        return builder.toString();
    }
}
