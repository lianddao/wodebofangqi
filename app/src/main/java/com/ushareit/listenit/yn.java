package com.ushareit.listenit;

import android.net.Uri;
import java.io.File;

public class yn<T> implements ze<File, T> {
    private final ze<Uri, T> f17572a;

    public yn(ze<Uri, T> zeVar) {
        this.f17572a = zeVar;
    }

    public vc<T> m27243a(File file, int i, int i2) {
        return this.f17572a.mo546a(Uri.fromFile(file), i, i2);
    }
}
