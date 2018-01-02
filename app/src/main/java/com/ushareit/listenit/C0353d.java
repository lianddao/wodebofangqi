package com.ushareit.listenit;

import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

final class C0353d {
    private static void m13590b(ClassLoader classLoader, List<File> list) {
        int size = list.size();
        Field a = C0350a.m4953b(classLoader, "path");
        StringBuilder stringBuilder = new StringBuilder((String) a.get(classLoader));
        Object[] objArr = new String[size];
        Object[] objArr2 = new File[size];
        Object[] objArr3 = new ZipFile[size];
        Object[] objArr4 = new DexFile[size];
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            File file = (File) listIterator.next();
            String absolutePath = file.getAbsolutePath();
            stringBuilder.append(':').append(absolutePath);
            int previousIndex = listIterator.previousIndex();
            objArr[previousIndex] = absolutePath;
            objArr2[previousIndex] = file;
            objArr3[previousIndex] = new ZipFile(file);
            objArr4[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
        }
        a.set(classLoader, stringBuilder.toString());
        C0350a.m4955b((Object) classLoader, "mPaths", objArr);
        C0350a.m4955b((Object) classLoader, "mFiles", objArr2);
        C0350a.m4955b((Object) classLoader, "mZips", objArr3);
        C0350a.m4955b((Object) classLoader, "mDexs", objArr4);
    }
}
