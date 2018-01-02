package com.ushareit.listenit.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.grn;

public class RemotePlaybackReceiver extends BroadcastReceiver {
    private static long f16398a = 0;
    private static int f16399b = 0;
    private static boolean f16400c = false;
    private static Context f16401d;
    private static Handler f16402e = new grn();

    public void onReceive(Context context, Intent intent) {
        f16401d = context;
        String action = intent.getAction();
        if (!fbb.m18763c(action)) {
            if ("android.intent.action.HEADSET_PLUG".equals(action)) {
                if (intent.getIntExtra("state", 0) != 1) {
                    m25938b(2);
                }
            } else if ("android.media.AUDIO_BECOMING_NOISY".equals(action)) {
                m25938b(2);
            } else if (action.equals("com.ushareit.listenit.action.playpause")) {
                m25936a(3, intent.getStringExtra("extra_from"));
            } else if (action.equals("com.ushareit.listenit.action.play")) {
                m25936a(1, intent.getStringExtra("extra_from"));
            } else if (action.equals("com.ushareit.listenit.action.playnext")) {
                m25936a(4, intent.getStringExtra("extra_from"));
            } else if (action.equals("com.ushareit.listenit.action.playprev")) {
                m25936a(5, intent.getStringExtra("extra_from"));
            } else if (action.equals("com.ushareit.listenit.action.close")) {
                m25936a(7, intent.getStringExtra("extra_from"));
            } else if (action.equals("com.ushareit.listenit.action.favorite")) {
                m25936a(8, intent.getStringExtra("extra_from"));
            } else if (action.equals("com.ushareit.listenit.action.playmode")) {
                m25936a(9, intent.getStringExtra("extra_from"));
            } else if (action.equals("com.ushareit.listenit.action.shuffle")) {
                m25936a(10, intent.getStringExtra("extra_from"));
            } else if ("android.intent.action.MEDIA_BUTTON".equals(action)) {
                KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent != null) {
                    m25937a(keyEvent);
                }
            }
        }
    }

    private void m25937a(KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        int keyCode = keyEvent.getKeyCode();
        exw.m18443a("UI.RemotePlaybackReceiver", "keyEvent action = " + (action == 0 ? "DOWN" : "UP") + " , keycode = " + keyCode);
        if (action != 0) {
            f16400c = false;
        } else if (keyCode == 86) {
            m25938b(6);
            return;
        } else {
            int a = m25933a(keyCode);
            if (a > 0) {
                long eventTime = keyEvent.getEventTime();
                if (f16400c) {
                    if ((a == 3 || a == 1) && f16398a != 0 && eventTime - f16398a > 1000) {
                        m25938b(2);
                        f16398a = eventTime;
                    }
                } else if (keyEvent.getRepeatCount() == 0) {
                    if (keyCode != 79 || eventTime - f16398a >= 500) {
                        m25935a(a, 500);
                        f16399b = 1;
                    } else {
                        f16399b++;
                        if (f16399b == 2) {
                            m25935a(4, 500);
                        } else if (f16399b == 3) {
                            m25938b(5);
                        }
                    }
                    f16398a = eventTime;
                    f16400c = true;
                }
            } else {
                return;
            }
        }
        if (isOrderedBroadcast()) {
            abortBroadcast();
        }
    }

    private int m25933a(int i) {
        switch (i) {
            case 79:
            case 85:
                return 3;
            case 86:
            case 127:
                return 2;
            case 87:
                return 4;
            case 88:
                return 5;
            case 126:
                return 1;
            default:
                return -1;
        }
    }

    private void m25936a(int i, String str) {
        if (i > 0) {
            f16402e.removeCallbacksAndMessages(null);
            Message obtainMessage = f16402e.obtainMessage(i);
            obtainMessage.obj = str;
            f16402e.sendMessage(obtainMessage);
        }
    }

    private void m25935a(int i, int i2) {
        if (i > 0) {
            f16402e.removeCallbacksAndMessages(null);
            Message obtainMessage = f16402e.obtainMessage(i);
            obtainMessage.obj = "headset";
            f16402e.sendMessageDelayed(obtainMessage, (long) i2);
        }
    }

    private void m25938b(int i) {
        if (i > 0) {
            f16402e.removeCallbacksAndMessages(null);
            Message obtainMessage = f16402e.obtainMessage(i);
            obtainMessage.obj = "headset";
            f16402e.sendMessage(obtainMessage);
        }
    }
}
