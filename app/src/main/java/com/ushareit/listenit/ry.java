package com.ushareit.listenit;

import android.database.Observable;

public class ry extends Observable<rz> {
    ry() {
    }

    public boolean m26028a() {
        return !this.mObservers.isEmpty();
    }

    public void m26029b() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((rz) this.mObservers.get(size)).onChanged();
        }
    }

    public void m26026a(int i, int i2) {
        m26027a(i, i2, null);
    }

    public void m26027a(int i, int i2, Object obj) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((rz) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
        }
    }

    public void m26030b(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((rz) this.mObservers.get(size)).onItemRangeInserted(i, i2);
        }
    }

    public void m26031c(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((rz) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
        }
    }

    public void m26032d(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((rz) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
        }
    }
}
