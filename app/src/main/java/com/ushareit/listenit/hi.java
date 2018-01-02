package com.ushareit.listenit;

import android.view.KeyEvent;

class hi {
    public static int m23883a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m23884a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m23885b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
