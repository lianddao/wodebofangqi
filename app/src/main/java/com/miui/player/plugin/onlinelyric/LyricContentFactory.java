package com.miui.player.plugin.onlinelyric;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class LyricContentFactory {

    static class ByteArrayLyric implements LyricContent {
        private final byte[] mContent;

        public ByteArrayLyric(byte[] content) {
            this.mContent = content;
        }

        public boolean persist(String path) {
            if (this.mContent != null) {
                try {
                    FileOutputStream fos = new FileOutputStream(path);
                    fos.write(this.mContent);
                    fos.close();
                    return true;
                } catch (FileNotFoundException e) {
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    static class StringLyric implements LyricContent {
        private final String mContent;

        public StringLyric(String content) {
            this.mContent = content;
        }

        public boolean persist(String path) {
            if (this.mContent != null) {
                try {
                    FileWriter fw = new FileWriter(path);
                    fw.write(this.mContent);
                    fw.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

    public static LyricContent create(byte[] byteArray) {
        return byteArray != null ? new ByteArrayLyric(byteArray) : null;
    }

    public static LyricContent create(String str) {
        return str != null ? new StringLyric(str) : null;
    }
}
