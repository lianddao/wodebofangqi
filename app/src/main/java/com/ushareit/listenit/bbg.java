package com.ushareit.listenit;

import java.util.ArrayList;

class bbg implements Runnable {
    private static ArrayList<String> f5851a = new ArrayList();
    private String f5852b;
    private boolean f5853c;

    bbg(String str, boolean z) {
        this.f5852b = str;
        this.f5853c = z;
    }

    public void run() {
        if (this.f5852b != null) {
            f5851a.remove(this.f5852b);
            f5851a.add(0, this.f5852b);
        }
        if (this.f5853c && f5851a.size() >= 128) {
            while (64 < f5851a.size()) {
                bak.f5781c.remove((String) f5851a.remove(f5851a.size() - 1));
            }
        }
    }
}
