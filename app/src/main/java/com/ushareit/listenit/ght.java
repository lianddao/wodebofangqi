package com.ushareit.listenit;

import com.mopub.mobileads.VastIconXmlManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class ght {
    private static final String f14137a = ght.class.getSimpleName();

    ght() {
    }

    public static ggm m22029a(File file, String str) {
        ggm com_ushareit_listenit_ggm = null;
        if (file != null && file.exists()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                fileInputStream = null;
            }
            com_ushareit_listenit_ggm = m22030a(fileInputStream, str);
            if (com_ushareit_listenit_ggm != null) {
                com_ushareit_listenit_ggm.m21946a(file.getAbsolutePath());
            }
        }
        return com_ushareit_listenit_ggm;
    }

    public static ggm m22030a(InputStream inputStream, String str) {
        Throwable e;
        Throwable th;
        ggm com_ushareit_listenit_ggm = null;
        if (inputStream != null) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
                try {
                    List arrayList = new ArrayList();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        readLine = readLine.trim();
                        if (readLine.length() > 0) {
                            arrayList.add(readLine);
                        }
                    }
                    if (m22037b(arrayList)) {
                        com_ushareit_listenit_ggm = m22031a(arrayList);
                    } else {
                        com_ushareit_listenit_ggm = m22038c(arrayList);
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        exw.m18457e(f14137a, "parseLyricFile error: e=" + exw.m18438a(e));
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        if (com_ushareit_listenit_ggm != null) {
                            com_ushareit_listenit_ggm.m21954c();
                        }
                        return com_ushareit_listenit_ggm;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                Object obj = com_ushareit_listenit_ggm;
                exw.m18457e(f14137a, "parseLyricFile error: e=" + exw.m18438a(e));
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (com_ushareit_listenit_ggm != null) {
                    com_ushareit_listenit_ggm.m21954c();
                }
                return com_ushareit_listenit_ggm;
            } catch (Throwable e5) {
                bufferedReader = com_ushareit_listenit_ggm;
                th = e5;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
            if (com_ushareit_listenit_ggm != null) {
                com_ushareit_listenit_ggm.m21954c();
            }
        }
        return com_ushareit_listenit_ggm;
    }

    public static ggm m22031a(List<String> list) {
        boolean z = false;
        if (list == null || list.size() == 0) {
            return null;
        }
        ggm com_ushareit_listenit_ggm = new ggm();
        for (String a : list) {
            m22034a(a, com_ushareit_listenit_ggm);
        }
        int i = 0;
        for (int i2 = 0; i2 < com_ushareit_listenit_ggm.m21956d(); i2++) {
            if (com_ushareit_listenit_ggm.m21949b(i2) > 0) {
                i++;
            }
        }
        if (i > 0) {
            z = true;
        }
        com_ushareit_listenit_ggm.m21948a(z);
        return com_ushareit_listenit_ggm.m21956d() > 0 ? com_ushareit_listenit_ggm : null;
    }

    private static ggm m22038c(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ggm com_ushareit_listenit_ggm = new ggm();
        com_ushareit_listenit_ggm.m21948a(false);
        for (String a : list) {
            com_ushareit_listenit_ggm.m21947a(a, 0);
        }
        return com_ushareit_listenit_ggm.m21956d() > 0 ? com_ushareit_listenit_ggm : null;
    }

    public static boolean m22037b(List<String> list) {
        boolean z = false;
        if (!(list == null || list.size() == 0)) {
            Pattern compile = Pattern.compile("\\[.+:.*\\].*");
            int i = 0;
            for (String str : list) {
                int i2;
                if (compile.matcher(str).find()) {
                    i2 = i + 1;
                } else {
                    exw.m18443a(f14137a, "notFind: line=" + str);
                    fin.m19350a(eys.m18562a(), str);
                    i2 = i;
                }
                i = i2;
            }
            if (i > list.size() / 2) {
                z = true;
            }
            fin.m19351a(eys.m18562a(), z);
        }
        return z;
    }

    public static boolean m22034a(String str, ggm com_ushareit_listenit_ggm) {
        int length = str.length();
        int indexOf = str.indexOf(91, 0);
        while (indexOf != -1) {
            int indexOf2 = str.indexOf(93, indexOf);
            if (indexOf2 < 1) {
                return false;
            }
            String substring = str.substring(indexOf + 1, indexOf2);
            String[] split = substring.split(":", 2);
            if (split.length < 2) {
                return false;
            }
            if (split[0].equalsIgnoreCase("ti")) {
                com_ushareit_listenit_ggm.m21952b(split[1].trim());
            } else if (split[0].equalsIgnoreCase(fnn.KEY_ARTIST)) {
                com_ushareit_listenit_ggm.m21955c(split[1].trim());
            } else if (split[0].equalsIgnoreCase(fnn.KEY_ALBUM)) {
                com_ushareit_listenit_ggm.m21958d(split[1].trim());
            } else if (split[0].equalsIgnoreCase("by")) {
                com_ushareit_listenit_ggm.m21960e(split[1].trim());
            } else if (split[0].equalsIgnoreCase("au")) {
                com_ushareit_listenit_ggm.m21964f(split[1].trim());
            } else if (split[0].equalsIgnoreCase("sign")) {
                com_ushareit_listenit_ggm.m21966g(split[1].trim());
            } else if (split[0].equalsIgnoreCase("total")) {
                com_ushareit_listenit_ggm.m21945a(m22028a(split[1].trim()));
            } else if (split[0].equalsIgnoreCase("length")) {
                com_ushareit_listenit_ggm.m21951b(m22028a(split[1].trim()));
            } else if (split[0].equalsIgnoreCase(VastIconXmlManager.OFFSET)) {
                com_ushareit_listenit_ggm.m21963f(m22035b(split[1].trim()));
            } else if (!Character.isDigit(split[0].charAt(0))) {
                return true;
            } else {
                List linkedList = new LinkedList();
                long b = m22036b(substring, com_ushareit_listenit_ggm);
                if (b != -1) {
                    linkedList.add(Long.valueOf(b));
                }
                int i = indexOf2;
                while (length > i + 2 && str.charAt(i + 1) == '[') {
                    indexOf = i + 1;
                    indexOf2 = str.indexOf(93, indexOf + 1);
                    b = m22036b(str.substring(indexOf + 1, indexOf2), com_ushareit_listenit_ggm);
                    if (b != -1) {
                        linkedList.add(Long.valueOf(b));
                    }
                    i = indexOf2;
                }
                String substring2 = str.substring(i + 1, str.length());
                for (indexOf = 0; indexOf < linkedList.size(); indexOf++) {
                    com_ushareit_listenit_ggm.m21947a(substring2, ((Long) linkedList.get(indexOf)).longValue());
                }
                indexOf2 = i;
            }
            indexOf = str.indexOf(91, indexOf2 + 1);
        }
        return true;
    }

    private static long m22028a(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return 0;
        }
    }

    private static int m22035b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static long m22036b(String str, ggm com_ushareit_listenit_ggm) {
        String[] split = str.split(":|\\.");
        if (split.length < 2) {
            return -1;
        }
        int parseInt;
        int parseInt2;
        if (split.length == 2) {
            try {
                if (com_ushareit_listenit_ggm.m21973n() == 0 && split[0].equalsIgnoreCase(VastIconXmlManager.OFFSET)) {
                    com_ushareit_listenit_ggm.m21963f(Integer.parseInt(split[1]));
                    return -1;
                }
                parseInt = Integer.parseInt(split[0]);
                parseInt2 = Integer.parseInt(split[1]);
                if (parseInt < 0 || parseInt2 < 0 || parseInt2 >= 60) {
                    return -1;
                }
                return ((long) ((parseInt * 60) + parseInt2)) * 1000;
            } catch (Exception e) {
                return -1;
            }
        } else if (split.length != 3) {
            return -1;
        } else {
            try {
                parseInt = Integer.parseInt(split[0]);
                int parseInt3 = Integer.parseInt(split[1]);
                parseInt2 = Integer.parseInt(split[2].length() > 2 ? split[2].substring(0, 2) : split[2]);
                if (parseInt >= 0 && parseInt3 >= 0 && parseInt3 < 60 && parseInt2 >= 0 && parseInt2 <= 99) {
                    return (((long) ((parseInt * 60) + parseInt3)) * 1000) + ((long) (parseInt2 * 10));
                }
                throw new RuntimeException("数字不合法!");
            } catch (Exception e2) {
                return -1;
            }
        }
    }

    public static String m22032a(int i) {
        int i2 = (i % 1000) / 10;
        int i3 = (i / 1000) % 60;
        int i4 = (i / 1000) / 60;
        return String.format(Locale.US, "[%02d:%02d.%02d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)});
    }

    public static void m22033a(glg com_ushareit_listenit_glg, ggm com_ushareit_listenit_ggm) {
        int i = 0;
        String str = "\n";
        StringBuilder stringBuilder = new StringBuilder();
        if (!fbb.m18763c(com_ushareit_listenit_ggm.m21962f())) {
            stringBuilder.append(String.format("[%s:%s]", new Object[]{"ti", com_ushareit_listenit_ggm.m21962f()})).append("\n");
        }
        if (!fbb.m18763c(com_ushareit_listenit_ggm.m21965g())) {
            stringBuilder.append(String.format("[%s:%s]", new Object[]{fnn.KEY_ARTIST, com_ushareit_listenit_ggm.m21965g()})).append("\n");
        }
        if (!fbb.m18763c(com_ushareit_listenit_ggm.m21967h())) {
            stringBuilder.append(String.format("[%s:%s]", new Object[]{fnn.KEY_ALBUM, com_ushareit_listenit_ggm.m21967h()})).append("\n");
        }
        if (!fbb.m18763c(com_ushareit_listenit_ggm.m21968i())) {
            stringBuilder.append(String.format("[%s:%s]", new Object[]{"by", com_ushareit_listenit_ggm.m21968i()})).append("\n");
        }
        if (!fbb.m18763c(com_ushareit_listenit_ggm.m21969j())) {
            stringBuilder.append(String.format("[%s:%s]", new Object[]{"au", com_ushareit_listenit_ggm.m21969j()})).append("\n");
        }
        if (!fbb.m18763c(com_ushareit_listenit_ggm.m21970k())) {
            stringBuilder.append(String.format("[%s:%s]", new Object[]{"sign", com_ushareit_listenit_ggm.m21970k()})).append("\n");
        }
        if (com_ushareit_listenit_ggm.m21971l() != 0) {
            stringBuilder.append(String.format("[%s:%d]", new Object[]{"total", Long.valueOf(com_ushareit_listenit_ggm.m21971l())})).append("\n");
        }
        if (com_ushareit_listenit_ggm.m21972m() != 0) {
            stringBuilder.append(String.format("[%s:%d]", new Object[]{"length", Long.valueOf(com_ushareit_listenit_ggm.m21972m())})).append("\n");
        }
        if (com_ushareit_listenit_ggm.m21973n() != 0) {
            stringBuilder.append(String.format("[%s:%d]", new Object[]{VastIconXmlManager.OFFSET, Integer.valueOf(com_ushareit_listenit_ggm.m21973n())})).append("\n");
        }
        int i2 = 0;
        while (i < com_ushareit_listenit_ggm.m21956d()) {
            int b = com_ushareit_listenit_ggm.m21949b(i);
            String c = com_ushareit_listenit_ggm.m21953c(i);
            if (b != 0 || !fbb.m18763c(c)) {
                if (b > com_ushareit_listenit_glg.f14337e) {
                    b = com_ushareit_listenit_glg.f14337e - 500;
                }
                if (b > i2) {
                    i2 = b;
                } else {
                    b = i2;
                }
                stringBuilder.append(m22032a(i2)).append(c).append("\n");
                i2 = b;
            }
            i++;
        }
        String e = fqm.m20393a().m20399e().mo2330e();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(e + File.separator + gyn.m23228d(com_ushareit_listenit_glg) + ".lrc"), "UTF-8"));
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();
        } catch (Exception e2) {
            exw.m18457e(f14137a, "saveLyric error");
        }
    }
}
