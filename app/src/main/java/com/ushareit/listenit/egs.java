package com.ushareit.listenit;

import android.os.SystemClock;
import com.mopub.common.DoubleTimeTracker.Clock;

public class egs implements Clock {
    private egs() {
    }

    public long elapsedRealTime() {
        return SystemClock.elapsedRealtime();
    }
}
