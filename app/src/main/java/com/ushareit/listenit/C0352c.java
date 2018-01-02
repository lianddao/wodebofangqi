package com.ushareit.listenit;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class C0352c {
    private static void m10530b(ClassLoader classLoader, List<File> list, File file) {
        Object obj = C0350a.m4953b(classLoader, "pathList").get(classLoader);
        ArrayList arrayList = new ArrayList();
        C0350a.m4955b(obj, "dexElements", C0352c.m10529a(obj, new ArrayList(list), file, arrayList));
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
            }
            Field a = C0350a.m4953b(classLoader, "dexElementsSuppressedExceptions");
            IOException[] iOExceptionArr = (IOException[]) a.get(classLoader);
            if (iOExceptionArr == null) {
                obj = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
            } else {
                Object obj2 = new IOException[(arrayList.size() + iOExceptionArr.length)];
                arrayList.toArray(obj2);
                System.arraycopy(iOExceptionArr, 0, obj2, arrayList.size(), iOExceptionArr.length);
                obj = obj2;
            }
            a.set(classLoader, obj);
        }
    }

    private static Object[] m10529a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
        return (Object[]) C0350a.m4954b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
    }
}
