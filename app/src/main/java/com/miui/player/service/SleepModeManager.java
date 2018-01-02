package com.miui.player.service;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.Actions;

public class SleepModeManager {
    private static final int DEFAULT_INTERVAL = 60000;
    private static final int DEFAULT_TIME = 30;
    private static int sSleepModeTime = 0;

    private static class OnSeekBarSleepModeListener implements OnSeekBarChangeListener {
        private TextView mPopupTextView;
        private SeekBar mSeekBar;

        public OnSeekBarSleepModeListener(SeekBar seekbar, TextView popupTextView) {
            this.mPopupTextView = popupTextView;
            this.mSeekBar = seekbar;
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            refreshPopUpTime();
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            refreshPopUpTime();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        public void refreshPopUpTime() {
            int progress = this.mSeekBar.getProgress();
            this.mPopupTextView.setText(String.valueOf(progress + 1));
            LayoutParams lp = (LayoutParams) this.mPopupTextView.getLayoutParams();
            int paddingLeft = this.mSeekBar.getPaddingLeft();
            int paddingRight = this.mSeekBar.getPaddingRight();
            int width = this.mSeekBar.getWidth();
            int thumbOffset = this.mSeekBar.getThumbOffset();
            lp.leftMargin = (int) ((((double) (((((((width - paddingLeft) - paddingRight) - thumbOffset) * progress) / this.mSeekBar.getMax()) + MusicApplication.getApplication().getResources().getDimensionPixelSize(C0329R.dimen.sleep_mode_extra_margin)) + paddingLeft)) + (((double) thumbOffset) * 0.5d)) - (((double) this.mPopupTextView.getWidth()) * 0.5d));
            this.mPopupTextView.setLayoutParams(lp);
        }
    }

    public static void toggleSleepMode(final Activity activity) {
        if (sSleepModeTime > 0) {
            setSelectTime(activity, 0);
            deleteTimer(activity);
            Toast.makeText(activity, C0329R.string.cancle_warining, 0).show();
            return;
        }
        View view = LayoutInflater.from(activity).inflate(C0329R.layout.sleep_mode_time_selector, null, false);
        final SeekBar seekbar = (SeekBar) view.findViewById(C0329R.id.seekbar);
        seekbar.setProgress(29);
        TextView popupText = (TextView) view.findViewById(C0329R.id.pop_up_time);
        final OnSeekBarSleepModeListener listener = new OnSeekBarSleepModeListener(seekbar, popupText);
        seekbar.setOnSeekBarChangeListener(listener);
        new Builder(activity).setTitle(C0329R.string.select_quit_time).setPositiveButton(C0329R.string.confirm, new OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                int progress = seekbar.getProgress() + 1;
                SleepModeManager.setSelectTime(activity, progress);
                int updateTime = (progress * 60) * 1000;
                ((AlarmManager) activity.getSystemService("alarm")).setInexactRepeating(3, SystemClock.elapsedRealtime() + ((long) updateTime), 60000, PendingIntent.getBroadcast(activity, 0, new Intent(Actions.ACTION_MUSIC_QUIT), 134217728));
                String quitWarning = activity.getString(C0329R.string.quit_warining);
                Toast.makeText(activity, String.format(quitWarning, new Object[]{Integer.valueOf(progress)}), 0).show();
            }
        }).setNegativeButton(C0329R.string.cancel, new OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                SleepModeManager.setSelectTime(activity, 0);
                SleepModeManager.deleteTimer(activity);
            }
        }).setCancelable(true).setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                SleepModeManager.setSelectTime(activity, 0);
                SleepModeManager.deleteTimer(activity);
            }
        }).setView(view).create().show();
        popupText.post(new Runnable() {
            public void run() {
                listener.refreshPopUpTime();
            }
        });
    }

    public static void setSelectTime(Context context, int progress) {
        sSleepModeTime = progress;
    }

    public static void deleteTimer(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(Actions.ACTION_MUSIC_QUIT), 134217728));
        sSleepModeTime = 0;
    }

    public static int getMenuTitle() {
        if (isSleepModeEnabled()) {
            return C0329R.string.cancel_sleep_mode;
        }
        return C0329R.string.enter_sleep_mode;
    }

    public static boolean isSleepModeEnabled() {
        return sSleepModeTime > 0;
    }
}
