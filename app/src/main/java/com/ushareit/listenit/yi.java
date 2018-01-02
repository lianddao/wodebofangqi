package com.ushareit.listenit;

import android.util.Log;

enum yi extends yh {
    yi(String str, int i) {
        super(str, i);
    }

    protected void mo3148a(Throwable th) {
        if (Log.isLoggable("PriorityExecutor", 6)) {
            Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
        }
    }
}
