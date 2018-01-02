package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class hka implements hjl {
    boolean f15564a = false;
    final Map<String, hjz> f15565b = new HashMap();
    final LinkedBlockingQueue<hjs> f15566c = new LinkedBlockingQueue();

    public synchronized hjm mo2797a(String str) {
        hjm com_ushareit_listenit_hjm;
        com_ushareit_listenit_hjm = (hjz) this.f15565b.get(str);
        if (com_ushareit_listenit_hjm == null) {
            com_ushareit_listenit_hjm = new hjz(str, this.f15566c, this.f15564a);
            this.f15565b.put(str, com_ushareit_listenit_hjm);
        }
        return com_ushareit_listenit_hjm;
    }

    public List<hjz> m24019a() {
        return new ArrayList(this.f15565b.values());
    }

    public LinkedBlockingQueue<hjs> m24020b() {
        return this.f15566c;
    }

    public void m24021c() {
        this.f15564a = true;
    }

    public void m24022d() {
        this.f15565b.clear();
        this.f15566c.clear();
    }
}
