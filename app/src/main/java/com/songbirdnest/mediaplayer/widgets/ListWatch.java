package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ListView;
import com.songbirdnest.mediaplayer.viewInterface.Listener;

public class ListWatch extends ListView {
    Listener downListener;
    int maxHeight = 0;
    Handler proxyHandle = new C04481();
    Listener upListener;

    class C04481 extends Handler {
        C04481() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (ListWatch.this.upListener != null) {
                        ListWatch.this.upListener.onAction();
                    }
                    ListWatch.this.proxyHandle.removeMessages(1);
                    return;
                case 2:
                    if (ListWatch.this.downListener != null) {
                        ListWatch.this.downListener.onAction();
                    }
                    ListWatch.this.proxyHandle.removeMessages(2);
                    return;
                default:
                    return;
            }
        }
    }

    public ListWatch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setUpListener(Listener upListener) {
        this.upListener = upListener;
    }

    public void setDownListener(Listener downListener) {
        this.downListener = downListener;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (this.maxHeight != 0) {
            if (h < this.maxHeight) {
                this.proxyHandle.sendEmptyMessage(1);
            } else if (h > this.maxHeight) {
                this.proxyHandle.sendEmptyMessage(2);
            }
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.maxHeight == 0) {
            this.maxHeight = getHeight();
        }
    }
}
