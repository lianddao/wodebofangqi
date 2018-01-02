package com.ushareit.listenit;

import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class apn<T extends apo, E extends apm> {
    private final Map<Class<E>, List<WeakReference<T>>> f5140a = new HashMap();
    private final Queue<E> f5141b = new ArrayDeque();

    private void m6614a(List<WeakReference<T>> list) {
        if (list != null) {
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                WeakReference weakReference = (WeakReference) list.get(i2);
                if (weakReference.get() != null) {
                    int i3 = i + 1;
                    list.set(i, weakReference);
                    i = i3;
                }
            }
            for (int size = list.size() - 1; size >= i; size--) {
                list.remove(size);
            }
        }
    }

    private void m6615b(E e) {
        if (this.f5140a != null) {
            List list = (List) this.f5140a.get(e.getClass());
            if (list != null) {
                m6614a(list);
                if (!list.isEmpty()) {
                    for (WeakReference weakReference : new ArrayList(list)) {
                        apo com_ushareit_listenit_apo = (apo) weakReference.get();
                        if (com_ushareit_listenit_apo != null && com_ushareit_listenit_apo.m6088b(e)) {
                            com_ushareit_listenit_apo.mo709a(e);
                        }
                    }
                }
            }
        }
    }

    public synchronized void m6616a(E e) {
        if (this.f5141b.isEmpty()) {
            this.f5141b.add(e);
            while (!this.f5141b.isEmpty()) {
                m6615b((apm) this.f5141b.peek());
                this.f5141b.remove();
            }
        } else {
            this.f5141b.add(e);
        }
    }

    public synchronized boolean m6617a(T t) {
        boolean z;
        if (t == null) {
            z = false;
        } else {
            Class a = t.mo708a();
            if (this.f5140a.get(a) == null) {
                this.f5140a.put(a, new ArrayList());
            }
            List list = (List) this.f5140a.get(a);
            m6614a(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((WeakReference) list.get(i)).get() == t) {
                    z = false;
                    break;
                }
            }
            z = list.add(new WeakReference(t));
        }
        return z;
    }

    public synchronized boolean m6618b(T t) {
        boolean z;
        if (t == null) {
            z = false;
        } else {
            List list = (List) this.f5140a.get(t.mo708a());
            if (list == null) {
                z = false;
            } else {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (((WeakReference) list.get(i)).get() == t) {
                        ((WeakReference) list.get(i)).clear();
                        z = true;
                        break;
                    }
                }
                z = false;
            }
        }
        return z;
    }
}
