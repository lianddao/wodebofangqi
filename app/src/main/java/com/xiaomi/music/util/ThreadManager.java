package com.xiaomi.music.util;

import android.os.Handler;
import java.util.concurrent.CountDownLatch;

public class ThreadManager {

    public static abstract class AsyncRequestCallback<T> implements Runnable {
        private volatile T mResult;

        public void setResult(T result) {
            this.mResult = result;
        }

        public T getResult() {
            return this.mResult;
        }
    }

    public static abstract class BlockingRequest<T> extends AsyncRequestCallback<T> {
        private final Handler mHanlder;
        private final CountDownLatch mLatch = new CountDownLatch(1);

        public BlockingRequest(Handler invokeHandler) {
            this.mHanlder = invokeHandler;
        }

        public void setResult(T result) {
            super.setResult(result);
            this.mLatch.countDown();
        }

        public T getResult() {
            if (this.mHanlder.getLooper().getThread() == Thread.currentThread()) {
                run();
            } else {
                this.mHanlder.post(this);
                try {
                    this.mLatch.await();
                } catch (InterruptedException e) {
                }
            }
            return super.getResult();
        }
    }

    public static String currentCallStack(String tag) {
        try {
            throw new Throwable("dump stack");
        } catch (Throwable t) {
            StackTraceElement[] stack = t.getStackTrace();
            if (stack == null || stack.length == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                if (tag == null) {
                    tag = " ";
                }
                return stringBuilder.append(tag).append("stack is empty").toString();
            }
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement ste : stack) {
                if (tag != null) {
                    sb.append(tag);
                }
                sb.append(ste.toString());
                sb.append("\n\r");
            }
            return sb.toString();
        }
    }
}
