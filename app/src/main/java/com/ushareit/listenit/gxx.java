package com.ushareit.listenit;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class gxx implements Iterator<File> {
    private gxy f14889a;
    private gxz<File> f14890b;
    private int f14891c;

    public /* synthetic */ Object next() {
        return m23115a();
    }

    public gxx(File file, gxy com_ushareit_listenit_gxy) {
        this(file, com_ushareit_listenit_gxy, 10);
    }

    public gxx(File file, gxy com_ushareit_listenit_gxy, int i) {
        this.f14890b = new gxz(this);
        this.f14891c = 10;
        this.f14890b.m23118a((Object) file);
        this.f14889a = com_ushareit_listenit_gxy;
        this.f14891c = gyn.m23170a(file) + i;
    }

    public gxx(List<File> list, gxy com_ushareit_listenit_gxy) {
        this((List) list, com_ushareit_listenit_gxy, 10);
    }

    public gxx(List<File> list, gxy com_ushareit_listenit_gxy, int i) {
        this.f14890b = new gxz(this);
        this.f14891c = 10;
        this.f14890b.m23119a(list.toArray(new File[0]));
        this.f14889a = com_ushareit_listenit_gxy;
        this.f14891c = gyn.m23170a((File) list.get(0)) + i;
    }

    public boolean hasNext() {
        return this.f14890b.m23117a() > 0;
    }

    public File m23115a() {
        File file = null;
        if (this.f14890b.m23117a() > 0) {
            file = (File) this.f14890b.m23120b();
            if (file.isDirectory()) {
                String[] list = file.list();
                if (this.f14889a.mo2682a(list)) {
                    Object[] a = m23114a(file.getAbsolutePath(), list, this.f14889a);
                    if (a != null && a.length > 0) {
                        this.f14890b.m23119a(a);
                    }
                }
            }
        }
        return file;
    }

    private File[] m23114a(String str, String[] strArr, FileFilter fileFilter) {
        if (fileFilter == null || strArr == null) {
            return null;
        }
        List arrayList = new ArrayList(strArr.length);
        for (String file : strArr) {
            File file2 = new File(str, file);
            if (fileFilter.accept(file2)) {
                arrayList.add(file2);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public void remove() {
    }
}
