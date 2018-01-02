package com.miui.player.meta;

import android.text.Html;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Pattern;

public class LyricParser {
    private static final int INTERVAL_OF_LAST = 8000;
    private static final int LINE_PARSE_IGNORE = 1;
    private static final int LINE_PARSE_REGULAR = 2;
    private static final int LINE_PARSE_STOP = 0;
    public static final int MAX_VALID_TIME = 18000000;
    private static final String TAG_ALBUM = "al";
    private static final String TAG_ARTIST = "ar";
    private static final String TAG_EDITOR = "by";
    private static final Pattern TAG_EXTRA_LRC = Pattern.compile("<[0-9]{0,2}:[0-9]{0,2}:[0-9]{0,2}>");
    private static final String TAG_OFFSET = "offset";
    private static final String TAG_TITLE = "ti";
    private static final String TAG_VERSION = "ve";

    static class EntityCompator implements Comparator<LyricEntity> {
        EntityCompator() {
        }

        public int compare(LyricEntity obj1, LyricEntity obj2) {
            return obj1.time - obj2.time;
        }
    }

    public static class Lyric {
        private final LyricEntity EMPTY_AFTER;
        private final LyricEntity EMPTY_BEFORE;
        private final ArrayList<LyricEntity> mEntityList;
        private final String mFileAbsolutePath;
        private final LyricHeader mHeader;
        private boolean mIsModified;
        private final long mOpenTime = System.currentTimeMillis();
        private int mOriginHeaderOffset;

        public Lyric(String filePath, LyricHeader header, ArrayList<LyricEntity> entityList, boolean isModified) {
            this.mFileAbsolutePath = filePath;
            this.mHeader = header;
            this.mOriginHeaderOffset = this.mHeader.offset;
            this.mEntityList = entityList;
            this.mIsModified = isModified;
            this.EMPTY_BEFORE = new LyricEntity(-1, "\n");
            this.EMPTY_AFTER = new LyricEntity(entityList.size(), "\n");
        }

        public void addOffset(int offset) {
            LyricHeader lyricHeader = this.mHeader;
            lyricHeader.offset += offset;
            this.mIsModified = true;
        }

        public void resetHeaderOffset() {
            this.mHeader.offset = this.mOriginHeaderOffset;
        }

        public boolean isModified() {
            return this.mIsModified;
        }

        public int size() {
            return this.mEntityList.size();
        }

        public boolean save() {
            try {
                BufferedWriter fw = new BufferedWriter(new FileWriter(this.mFileAbsolutePath));
                writeHeaderElement(fw, "ti", this.mHeader.title);
                writeHeaderElement(fw, "ar", this.mHeader.artist);
                writeHeaderElement(fw, "al", this.mHeader.album);
                writeHeaderElement(fw, "by", this.mHeader.editor);
                writeHeaderElement(fw, LyricParser.TAG_VERSION, this.mHeader.version);
                writeHeaderElement(fw, "offset", String.valueOf(this.mHeader.offset));
                Iterator i$ = this.mEntityList.iterator();
                while (i$.hasNext()) {
                    writeEntityElement(fw, (LyricEntity) i$.next());
                }
                fw.flush();
                fw.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        private void writeHeaderElement(BufferedWriter fw, String tag, String value) throws IOException {
            String pattern = "[%s:%s]";
            if (value == null) {
                value = MetaManager.UNKNOWN_STRING;
            }
            fw.write(String.format("[%s:%s]", new Object[]{tag, value}));
            fw.newLine();
        }

        public void writeEntityElement(BufferedWriter fw, LyricEntity entity) throws IOException {
            String patternNoHour = "[%02d:%02d.%02d]%s";
            String patternWithHour = "[%02d:%02d:%02d.%02d]%s";
            int s = entity.time / 1000;
            int minute = (s % 3600) / 60;
            int second = s % 60;
            int delta = entity.time % 1000;
            if (s / 3600 > 0) {
                fw.write(String.format("[%02d:%02d:%02d.%02d]%s", new Object[]{Integer.valueOf(s / 3600), Integer.valueOf(minute), Integer.valueOf(second), Integer.valueOf(delta), entity.lyric}));
            } else {
                fw.write(String.format("[%02d:%02d.%02d]%s", new Object[]{Integer.valueOf(minute), Integer.valueOf(second), Integer.valueOf(delta), entity.lyric}));
            }
            fw.newLine();
        }

        public LyricShot getLyricShot(long time) {
            int offset = this.mHeader.offset;
            if (((long) (((LyricEntity) this.mEntityList.get(0)).time + offset)) > time) {
                return new LyricShot(0, 0.0d);
            }
            for (int i = 1; i < this.mEntityList.size(); i++) {
                int timeThis = ((LyricEntity) this.mEntityList.get(i)).time + offset;
                if (((long) timeThis) > time) {
                    int timePrev = ((LyricEntity) this.mEntityList.get(i - 1)).time + offset;
                    double percent = 0.0d;
                    if (timeThis > timePrev) {
                        percent = ((double) (time - ((long) timePrev))) / ((double) (timeThis - timePrev));
                    }
                    return new LyricShot(i - 1, percent);
                }
            }
            long timeLast = (long) (((LyricEntity) this.mEntityList.get(size() - 1)).time + offset);
            if (time - timeLast >= 8000) {
                return new LyricShot(this.mEntityList.size(), 0.0d);
            }
            return new LyricShot(size() - 1, ((double) (time - timeLast)) / 8000.0d);
        }

        private long getTimeFromLyricShot(int line, double percent) {
            int maxLine = size() - 1;
            if (line >= maxLine) {
                return ((long) (((LyricEntity) this.mEntityList.get(maxLine)).time + ((line - maxLine) * 8000))) + ((long) (8000.0d * percent));
            }
            return (long) (((double) ((LyricEntity) this.mEntityList.get(line)).time) + (((double) (((LyricEntity) this.mEntityList.get(line + 1)).time - ((LyricEntity) this.mEntityList.get(line)).time)) * percent));
        }

        public void correctLyric(LyricShot lyricShot, int lineIndex, double percent) {
            int maxLine = size();
            if (lineIndex >= 0 && lineIndex <= maxLine && lyricShot.lineIndex >= 0 && lyricShot.lineIndex <= maxLine) {
                long currentTime = getTimeFromLyricShot(lyricShot.lineIndex, lyricShot.percent);
                long newTime = getTimeFromLyricShot(lineIndex, percent);
                boolean isOffsetDelay = true;
                if (lineIndex > lyricShot.lineIndex || (lineIndex == lyricShot.lineIndex && percent > lyricShot.percent)) {
                    isOffsetDelay = false;
                }
                if (!isOffsetDelay && currentTime > newTime) {
                    return;
                }
                if (!isOffsetDelay || currentTime >= newTime) {
                    addOffset((int) (currentTime - newTime));
                }
            }
        }

        public LyricEntity getLyricContent(int index) {
            if (index < 0) {
                return this.EMPTY_BEFORE;
            }
            if (index >= this.mEntityList.size()) {
                return this.EMPTY_AFTER;
            }
            return (LyricEntity) this.mEntityList.get(index);
        }

        public String getFilePath() {
            return this.mFileAbsolutePath;
        }

        public long getOpenTime() {
            return this.mOpenTime;
        }

        public ArrayList<CharSequence> getStringArr() {
            if (this.mEntityList.isEmpty()) {
                return null;
            }
            ArrayList<CharSequence> lyricArr = new ArrayList(this.mEntityList.size());
            Iterator i$ = this.mEntityList.iterator();
            while (i$.hasNext()) {
                lyricArr.add(((LyricEntity) i$.next()).lyric);
            }
            return lyricArr;
        }

        public int[] getTimeArr() {
            if (this.mEntityList.isEmpty()) {
                return null;
            }
            int[] timeArr = new int[this.mEntityList.size()];
            int i = 0;
            Iterator i$ = this.mEntityList.iterator();
            while (i$.hasNext()) {
                int i2 = i + 1;
                timeArr[i] = ((LyricEntity) i$.next()).time + this.mHeader.offset;
                i = i2;
            }
            return timeArr;
        }

        public void recycleContent() {
            this.mEntityList.clear();
        }

        public void decorate() {
            if (!this.mEntityList.isEmpty()) {
                ArrayList<LyricEntity> el = this.mEntityList;
                int len = el.size();
                if (len > 0 && !((LyricEntity) el.get(0)).isDecorated()) {
                    for (int i = 0; i < len; i++) {
                        ((LyricEntity) el.get(i)).decorate();
                    }
                }
            }
        }
    }

    public static class LyricEntity {
        private static final String HTML_BR_PATTERN = "%s<br/>";
        public CharSequence lyric;
        public int time;

        public LyricEntity(int t, String str) {
            this.time = t;
            this.lyric = str;
        }

        public void decorate() {
            this.lyric = Html.fromHtml(String.format(HTML_BR_PATTERN, new Object[]{this.lyric}));
        }

        public boolean isDecorated() {
            return !(this.lyric instanceof String);
        }
    }

    public static class LyricHeader {
        public String album;
        public String artist;
        public String editor;
        public int offset;
        public String title;
        public String version;
    }

    public static class LyricShot {
        public int lineIndex;
        public double percent;

        public LyricShot(int index, double p) {
            this.lineIndex = index;
            this.percent = p;
        }
    }

    private static void correctTime(Lyric lyric) {
        ArrayList<LyricEntity> el = lyric.mEntityList;
        int size = el.size();
        if (size > 1 && ((LyricEntity) el.get(0)).time == ((LyricEntity) el.get(1)).time) {
            ((LyricEntity) el.get(0)).time = ((LyricEntity) el.get(1)).time / 2;
        }
        for (int i = 1; i < size - 1; i++) {
            if (((LyricEntity) el.get(i)).time == ((LyricEntity) el.get(i + 1)).time) {
                ((LyricEntity) el.get(i)).time = (((LyricEntity) el.get(i + 1)).time + ((LyricEntity) el.get(i - 1)).time) / 2;
            }
        }
    }

    public static Lyric parseLyric(File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            Lyric lyric = doParse(file);
            correctTime(lyric);
            return lyric;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Lyric parseLyric(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }
        try {
            File file = new File(fileName);
            if (file.exists()) {
                return doParse(file);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Lyric doParse(File file) throws IOException {
        boolean needModify = false;
        LyricHeader header = new LyricHeader();
        ArrayList<LyricEntity> entityList = new ArrayList();
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, LyricEncodingDetector.detectEncode(file.getAbsolutePath()));
        BufferedReader reader = new BufferedReader(inputStreamReader);
        while (true) {
            String str = reader.readLine();
            if (str == null) {
                break;
            }
            int lineParseRet = parseLine(str, header, entityList);
            if (lineParseRet == 0) {
                break;
            } else if (lineParseRet == 1) {
                needModify = true;
            }
        }
        reader.close();
        inputStreamReader.close();
        inputStream.close();
        if (entityList.isEmpty()) {
            return null;
        }
        Collections.sort(entityList, new EntityCompator());
        return new Lyric(file.getAbsolutePath(), header, entityList, needModify);
    }

    private static int parseLine(String str, LyricHeader header, ArrayList<LyricEntity> entityList) {
        str = str.trim();
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        str = TAG_EXTRA_LRC.matcher(str).replaceAll(MetaManager.UNKNOWN_STRING);
        int indexOfLastTag = str.lastIndexOf("]");
        if (indexOfLastTag == -1) {
            return 1;
        }
        String content = str.substring(indexOfLastTag + 1);
        int indexOfLeftTag = str.indexOf("[");
        if (indexOfLeftTag == -1) {
            return 1;
        }
        int lineParseRet = 2;
        for (String s : str.substring(indexOfLeftTag, indexOfLastTag).split("]")) {
            String s2;
            if (s2.startsWith("[")) {
                s2 = s2.substring(1);
                String[] values = s2.split(":");
                if (values.length >= 2) {
                    if (TextUtils.isDigitsOnly(values[0])) {
                        lineParseRet = parseEntity(values, entityList, content);
                    } else {
                        lineParseRet = parseHeader(s2, header);
                    }
                }
            }
        }
        return lineParseRet;
    }

    private static int parseHeader(String str, LyricHeader header) {
        int indexOfTag = str.indexOf(":");
        if (indexOfTag < 0 || indexOfTag >= str.length() - 1) {
            return 1;
        }
        String tag = str.substring(0, indexOfTag);
        String value = str.substring(indexOfTag + 1);
        if (tag.equals("al")) {
            header.album = value;
            return 2;
        } else if (tag.equals("ar")) {
            header.artist = value;
            return 2;
        } else if (tag.equals("ti")) {
            header.title = value;
            return 2;
        } else if (tag.equals("by")) {
            header.editor = value;
            return 2;
        } else if (tag.equals(TAG_VERSION)) {
            header.version = value;
            return 2;
        } else if (!tag.equals("offset")) {
            return 1;
        } else {
            try {
                header.offset = Integer.parseInt(value);
                return 2;
            } catch (NumberFormatException e) {
                return 1;
            }
        }
    }

    private static int parseEntity(String[] values, ArrayList<LyricEntity> entityList, String content) {
        try {
            int time = (int) (Double.parseDouble(values[values.length - 1]) * 1000.0d);
            int second = 0;
            int weight = 60;
            for (int i = values.length - 2; i >= 0; i--) {
                int val = Integer.parseInt(values[i]) * weight;
                weight *= 60;
                second += val;
            }
            time += second * 1000;
            if (time >= MAX_VALID_TIME) {
                return 2;
            }
            entityList.add(new LyricEntity(time, content));
            return 2;
        } catch (NumberFormatException e) {
            return 1;
        }
    }
}
