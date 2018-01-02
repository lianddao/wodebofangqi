package com.ushareit.listenit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

final class C0351b {
    private static void m7481b(ClassLoader classLoader, List<File> list, File file) {
        Object obj = C0350a.m4953b(classLoader, "pathList").get(classLoader);
        C0350a.m4955b(obj, "dexElements", C0351b.m7480a(obj, new ArrayList(list), file));
    }

    private static Object[] m7480a(Object obj, ArrayList<File> arrayList, File file) {
        return (Object[]) C0350a.m4954b(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
    }
}
