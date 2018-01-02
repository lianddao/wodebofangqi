package com.ushareit.listenit;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

class vo {
    vo() {
    }

    public OutputStream m26726a(File file) {
        return new BufferedOutputStream(new FileOutputStream(file));
    }
}
