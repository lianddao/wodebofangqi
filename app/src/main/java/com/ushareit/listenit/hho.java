package com.ushareit.listenit;

import android.util.Log;

enum hho extends hhn {
    hho(String str, int i) {
        super(str, i);
    }

    protected void mo2785a(Throwable th) {
        if (Log.isLoggable("PriorityExecutor", 6)) {
            Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
        }
    }
}
