package com.ushareit.listenit;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class and {
    private static final String f4914a = and.class.getSimpleName();
    private final Handler f4915b = new Handler();
    private final ExecutorService f4916c = Executors.newFixedThreadPool(10);
    private final ani f4917d;
    private final anj f4918e;
    private final List<Callable<Boolean>> f4919f;

    public and(Context context) {
        this.f4917d = ani.m6378a(context);
        this.f4918e = anj.m6384a(context);
        this.f4919f = new ArrayList();
    }

    public void m6372a(anc com_ushareit_listenit_anc) {
        this.f4916c.submit(new ane(this, new ArrayList(this.f4919f), com_ushareit_listenit_anc));
        this.f4919f.clear();
    }

    public void m6373a(String str) {
        this.f4919f.add(new ang(this, str));
    }

    public void m6374b(String str) {
        this.f4919f.add(new anh(this, str));
    }

    public String m6375c(String str) {
        return this.f4918e.m6387b(str);
    }
}
