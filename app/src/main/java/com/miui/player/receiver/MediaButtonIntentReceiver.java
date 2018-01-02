package com.miui.player.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import com.miui.player.asyncplayer.BufferedMediaPlayer;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.util.ServiceActions.In;
import com.miui.player.util.ServiceActions.OneShot;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.distributionanalysis.Big5DistributionAnalysis;

public class MediaButtonIntentReceiver extends BroadcastReceiver {
    private static final String TAG = MediaButtonIntentReceiver.class.getName();
    private static MediaButtonEvent sForwardEvent = new C03972();
    private static boolean sIsOneShot = false;
    private static MediaButtonEvent sNextEvent = new C03994();
    private static MediaButtonEvent sPlayPauseEvent = new C04005();
    private static MediaButtonEvent sPreviousEvent = new C03983();
    private static MediaButtonEvent sRewindEvent = new C03961();

    private static class MediaButtonEvent {
        private static final int LONG_PRESS_DELAY = 260;
        private static final int MAX_REPEAT_COUNT = 100;
        private static final int MSG_CLICK_EVENT = 0;
        private static final int MULTI_PRESS_DELAY = 1000;
        private static final int STATE_DOWN = 1;
        private static final int STATE_DOWN_DOWN = 2;
        private static final int STATE_DOWN_UP = 3;
        private static final int STATE_DOWN_UP_DOWN = 4;
        private static final int STATE_DOWN_UP_DOWN_UP = 5;
        private static final int STATE_DOWN_UP_DOWN_UP_DOWN = 6;
        private static final int STATE_DOWN_UP_DOWN_UP_DOWN_UP = 7;
        private static final int STATE_INIT = 0;
        private Handler mHandler;
        private int mRepeatCount;
        private int mState;

        class C04011 extends Handler {
            C04011() {
            }

            public void handleMessage(Message msg) {
                MediaButtonEvent.this.doClick((Context) msg.obj);
            }
        }

        private MediaButtonEvent() {
            this.mState = 0;
            this.mRepeatCount = 0;
            this.mHandler = new C04011();
        }

        protected void init() {
            this.mState = 0;
            this.mRepeatCount = 0;
            this.mHandler.removeMessages(0);
        }

        protected boolean supportDoubleClick() {
            return false;
        }

        protected boolean supportTripleClick() {
            return false;
        }

        protected void handleLongClick(Context context) {
        }

        protected void handleSingleClick(Context context) {
        }

        protected void handleDoubleClick(Context context) {
        }

        protected void handleTripleClick(Context context) {
        }

        protected void switchState(Context context, int action, boolean isForbidDoubleClick) {
            long j = 1000;
            if (isForbidDoubleClick && action == 0) {
                init();
            }
            Handler handler;
            Message obtainMessage;
            switch (this.mState) {
                case 0:
                    if (action == 0) {
                        this.mState = 1;
                        this.mHandler.removeMessages(0);
                        return;
                    }
                    return;
                case 1:
                    if (action == 1) {
                        this.mState = 3;
                        handler = this.mHandler;
                        obtainMessage = this.mHandler.obtainMessage(0, context);
                        if (!supportDoubleClick() || isForbidDoubleClick) {
                            j = 0;
                        }
                        handler.sendMessageDelayed(obtainMessage, j);
                        return;
                    } else if (action == 0) {
                        this.mState = 2;
                        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, context), 260);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    if (action == 1) {
                        this.mHandler.removeMessages(0);
                        init();
                        return;
                    }
                    return;
                case 3:
                    if (supportDoubleClick() && action == 0) {
                        this.mState = 4;
                        this.mHandler.removeMessages(0);
                        return;
                    }
                    return;
                case 4:
                    if (action == 1) {
                        this.mState = 5;
                        handler = this.mHandler;
                        obtainMessage = this.mHandler.obtainMessage(0, context);
                        if (!supportTripleClick()) {
                            j = 0;
                        }
                        handler.sendMessageDelayed(obtainMessage, j);
                        return;
                    }
                    return;
                case 5:
                    if (supportTripleClick() && action == 0) {
                        this.mState = 6;
                        this.mHandler.removeMessages(0);
                        return;
                    }
                    return;
                case 6:
                    if (action == 1) {
                        this.mState = 7;
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, context));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        private void doClick(Context context) {
            switch (this.mState) {
                case 2:
                    this.mRepeatCount++;
                    handleLongClick(context);
                    if (this.mRepeatCount < 100 && !this.mHandler.hasMessages(0)) {
                        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, context), 260);
                    }
                    Log.d(MediaButtonIntentReceiver.TAG, "handleLongClick");
                    return;
                case 3:
                    handleSingleClick(context);
                    init();
                    Log.d(MediaButtonIntentReceiver.TAG, "handleSingleClick");
                    return;
                case 5:
                    handleDoubleClick(context);
                    init();
                    Log.d(MediaButtonIntentReceiver.TAG, "handDoubleClick");
                    return;
                case 7:
                    handleTripleClick(context);
                    init();
                    Log.d(MediaButtonIntentReceiver.TAG, "handTripleClick");
                    return;
                default:
                    return;
            }
        }
    }

    static class C03961 extends MediaButtonEvent {
        C03961() {
            super();
        }

        protected void handleLongClick(Context context) {
            MediaButtonIntentReceiver.doCommand(context, In.CMDBACKWARD);
        }
    }

    static class C03972 extends MediaButtonEvent {
        C03972() {
            super();
        }

        protected void handleLongClick(Context context) {
            MediaButtonIntentReceiver.doCommand(context, In.CMDFORWARD);
        }
    }

    static class C03983 extends MediaButtonEvent {
        C03983() {
            super();
        }

        protected void handleLongClick(Context context) {
            MediaButtonIntentReceiver.doCommand(context, In.CMDBACKWARD);
        }

        protected void handleSingleClick(Context context) {
            MediaButtonIntentReceiver.doCommand(context, In.CMDPREVIOUS);
        }
    }

    static class C03994 extends MediaButtonEvent {
        C03994() {
            super();
        }

        protected void handleLongClick(Context context) {
            MediaButtonIntentReceiver.doCommand(context, In.CMDFORWARD);
        }

        protected void handleSingleClick(Context context) {
            MediaButtonIntentReceiver.doCommand(context, In.CMDNEXT);
        }
    }

    static class C04005 extends MediaButtonEvent {
        C04005() {
            super();
        }

        protected boolean supportDoubleClick() {
            return true;
        }

        protected boolean supportTripleClick() {
            return true;
        }

        protected void handleLongClick(Context context) {
            MediaButtonIntentReceiver.doCommand(context, In.CMDPREVIOUS);
        }

        protected void handleSingleClick(Context context) {
            MediaButtonIntentReceiver.doCommand(context, In.CMDTOGGLEPAUSE);
        }

        protected void handleDoubleClick(Context context) {
            MediaButtonIntentReceiver.doCommand(context, In.CMDNEXT);
        }

        protected void handleTripleClick(Context context) {
            MediaButtonIntentReceiver.doCommand(context, In.CMDPREVIOUS);
        }
    }

    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        Log.d(TAG, "handle action:" + intentAction);
        if (intentAction != null) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intentAction)) {
                initMediaButton();
                BufferedMediaPlayer.toggleFadeOutMode(2);
                Intent i = new Intent(context, ApplicationHelper.instance().getServiceClass());
                i.setAction(In.SERVICECMD);
                i.putExtra(In.CMDNAME, In.CMDPAUSE);
                context.startService(i);
            } else if ("android.intent.action.MEDIA_BUTTON".equals(intentAction) && ((TelephonyManager) context.getSystemService("phone")).getCallState() == 0) {
                KeyEvent event = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (event != null) {
                    boolean handled;
                    int keycode = event.getKeyCode();
                    int action = event.getAction();
                    if (sIsOneShot) {
                        handled = handleOneShot(context, intent, event, keycode, action);
                    } else {
                        handled = handleList(context, intent, event, keycode, action);
                        if (handled) {
                            context.startService(new Intent(context, ApplicationHelper.instance().getServiceClass()));
                        }
                    }
                    if (handled) {
                        abortBroadcast();
                    }
                }
            }
        }
    }

    static void doCommand(Context context, String command) {
        Intent i = new Intent(context, ApplicationHelper.instance().getServiceClass());
        i.setAction(In.SERVICECMD);
        i.putExtra(In.CMDNAME, command);
        context.startService(i);
    }

    public static void setOneShot(boolean oneShot) {
        sIsOneShot = oneShot;
    }

    private static boolean handleList(Context context, Intent intent, KeyEvent event, int keycode, int action) {
        boolean isForbidDoubleClick;
        if (event.getSource() == 4098) {
            isForbidDoubleClick = true;
        } else {
            isForbidDoubleClick = false;
        }
        String command = null;
        switch (keycode) {
            case 79:
            case 85:
                command = In.CMDTOGGLEPAUSE;
                sPlayPauseEvent.switchState(context, action, isForbidDoubleClick);
                break;
            case 86:
                command = In.CMDSTOP;
                doCommand(context, In.CMDSTOP);
                break;
            case 87:
                command = In.CMDNEXT;
                sNextEvent.switchState(context, action, isForbidDoubleClick);
                break;
            case 88:
                command = In.CMDPREVIOUS;
                sPreviousEvent.switchState(context, action, isForbidDoubleClick);
                break;
            case 89:
                command = In.CMDBACKWARD;
                sRewindEvent.switchState(context, action, isForbidDoubleClick);
                break;
            case CharsetProber.ASCII_Z_CAPITAL /*90*/:
                command = In.CMDFORWARD;
                sForwardEvent.switchState(context, action, isForbidDoubleClick);
                break;
            case Big5DistributionAnalysis.LOWBYTE_END_1 /*126*/:
                command = In.CMDPLAY;
                doCommand(context, In.CMDPLAY);
                break;
            case 127:
                command = In.CMDPAUSE;
                doCommand(context, In.CMDPAUSE);
                break;
        }
        Log.d(TAG, String.format("action = %d, repeatCount = %d, command = %s, keycode = %s", new Object[]{Integer.valueOf(action), Integer.valueOf(event.getRepeatCount()), command, KeyEvent.keyCodeToString(keycode)}));
        if (command != null) {
            return true;
        }
        return false;
    }

    private static boolean handleOneShot(Context context, Intent intent, KeyEvent event, int keycode, int action) {
        if (action != 0) {
            String command = null;
            switch (keycode) {
                case 79:
                case 85:
                    command = OneShot.ACTION_TOGGLEPAUSE;
                    break;
                case 86:
                case 127:
                    command = OneShot.ACTION_PAUSE;
                    break;
                case Big5DistributionAnalysis.LOWBYTE_END_1 /*126*/:
                    command = OneShot.ACTION_PLAY;
                    break;
            }
            Log.d(TAG, String.format("action = %d, repeatCount = %d, command = %s", new Object[]{Integer.valueOf(action), Integer.valueOf(event.getRepeatCount()), command}));
            if (command != null) {
                context.sendBroadcast(new Intent(command));
            }
        }
        return true;
    }

    private static void initMediaButton() {
        sRewindEvent.init();
        sForwardEvent.init();
        sPreviousEvent.init();
        sNextEvent.init();
        sPlayPauseEvent.init();
    }
}
