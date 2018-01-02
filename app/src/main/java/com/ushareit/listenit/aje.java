package com.ushareit.listenit;

import android.os.Handler;
import com.facebook.GraphRequest;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class aje extends AbstractList<GraphRequest> {
    private static AtomicInteger f4467a = new AtomicInteger();
    private Handler f4468b;
    private List<GraphRequest> f4469c;
    private int f4470d;
    private final String f4471e;
    private List<ajf> f4472f;
    private String f4473g;

    public /* synthetic */ void add(int i, Object obj) {
        m5754a(i, (GraphRequest) obj);
    }

    public /* synthetic */ boolean add(Object obj) {
        return m5757a((GraphRequest) obj);
    }

    public /* synthetic */ Object get(int i) {
        return m5753a(i);
    }

    public /* synthetic */ Object remove(int i) {
        return m5758b(i);
    }

    public /* synthetic */ Object set(int i, Object obj) {
        return m5759b(i, (GraphRequest) obj);
    }

    public aje() {
        this.f4469c = new ArrayList();
        this.f4470d = 0;
        this.f4471e = Integer.valueOf(f4467a.incrementAndGet()).toString();
        this.f4472f = new ArrayList();
        this.f4469c = new ArrayList();
    }

    public aje(Collection<GraphRequest> collection) {
        this.f4469c = new ArrayList();
        this.f4470d = 0;
        this.f4471e = Integer.valueOf(f4467a.incrementAndGet()).toString();
        this.f4472f = new ArrayList();
        this.f4469c = new ArrayList(collection);
    }

    public aje(GraphRequest... graphRequestArr) {
        this.f4469c = new ArrayList();
        this.f4470d = 0;
        this.f4471e = Integer.valueOf(f4467a.incrementAndGet()).toString();
        this.f4472f = new ArrayList();
        this.f4469c = Arrays.asList(graphRequestArr);
    }

    public int m5752a() {
        return this.f4470d;
    }

    public void m5756a(ajf com_ushareit_listenit_ajf) {
        if (!this.f4472f.contains(com_ushareit_listenit_ajf)) {
            this.f4472f.add(com_ushareit_listenit_ajf);
        }
    }

    public final boolean m5757a(GraphRequest graphRequest) {
        return this.f4469c.add(graphRequest);
    }

    public final void m5754a(int i, GraphRequest graphRequest) {
        this.f4469c.add(i, graphRequest);
    }

    public final void clear() {
        this.f4469c.clear();
    }

    public final GraphRequest m5753a(int i) {
        return (GraphRequest) this.f4469c.get(i);
    }

    public final GraphRequest m5758b(int i) {
        return (GraphRequest) this.f4469c.remove(i);
    }

    public final GraphRequest m5759b(int i, GraphRequest graphRequest) {
        return (GraphRequest) this.f4469c.set(i, graphRequest);
    }

    public final int size() {
        return this.f4469c.size();
    }

    public final String m5760b() {
        return this.f4471e;
    }

    public final Handler m5761c() {
        return this.f4468b;
    }

    final void m5755a(Handler handler) {
        this.f4468b = handler;
    }

    public final List<GraphRequest> m5762d() {
        return this.f4469c;
    }

    public final List<ajf> m5763e() {
        return this.f4472f;
    }

    public final String m5764f() {
        return this.f4473g;
    }

    public final List<ajh> m5765g() {
        return m5767i();
    }

    public final ajd m5766h() {
        return m5768j();
    }

    List<ajh> m5767i() {
        return GraphRequest.m745b(this);
    }

    ajd m5768j() {
        return GraphRequest.m747c(this);
    }
}
