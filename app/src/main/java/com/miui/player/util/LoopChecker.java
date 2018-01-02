package com.miui.player.util;

import android.os.Handler;
import android.os.Message;

public class LoopChecker {
    private final int MSG_CHECKING = 1;
    private final CheckAction mAction;
    private final Handler mHandler = new C05301();

    public interface CheckAction {
        boolean handle();
    }

    class C05301 extends Handler {
        C05301() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                LoopChecker.this.doCheck(msg.arg1, msg.arg2);
            }
        }
    }

    public LoopChecker(CheckAction action) {
        this.mAction = action;
    }

    public void startCheck(int count, int retryDelay, int startDelay) {
        reset();
        if (startDelay <= 0) {
            doCheck(count, retryDelay);
            return;
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, count, retryDelay), (long) startDelay);
    }

    void doCheck(int count, int delay) {
        this.mHandler.removeMessages(1);
        if (!this.mAction.handle()) {
            count--;
            if (count > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, count, delay), (long) delay);
            }
        }
    }

    public void reset() {
        this.mHandler.removeMessages(1);
    }

    public static LoopChecker check(CheckAction action, int retryCount, int retryDelay, int startDelay) {
        if (retryCount <= 0) {
            return null;
        }
        LoopChecker checker = new LoopChecker(action);
        checker.startCheck(retryCount, retryDelay, startDelay);
        return checker;
    }

    public static LoopChecker check(CheckAction action, int retryCount, int retryDelay) {
        return check(action, retryCount, retryDelay, 0);
    }
}
