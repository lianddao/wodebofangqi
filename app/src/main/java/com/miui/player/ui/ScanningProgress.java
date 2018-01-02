package com.miui.player.ui;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Audio.Playlists;
import com.miui.player.C0329R;
import com.miui.player.util.SqlUtils;

public class ScanningProgress extends Activity {
    private static final int CHECK = 0;
    private Handler mHandler = new C04561();

    class C04561 extends Handler {
        C04561() {
        }

        public void handleMessage(Message msg) {
            if (msg.what != 0) {
                return;
            }
            if (Environment.getExternalStorageState().equals("mounted")) {
                Cursor c = SqlUtils.query(ScanningProgress.this, Playlists.EXTERNAL_CONTENT_URI, null, null, null, null);
                if (c != null) {
                    c.close();
                    ScanningProgress.this.setResult(-1);
                    ScanningProgress.this.finish();
                    return;
                }
                sendMessageDelayed(obtainMessage(0), 3000);
                return;
            }
            ScanningProgress.this.finish();
        }
    }

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setVolumeControlStream(3);
        requestWindowFeature(1);
        if (Environment.isExternalStorageRemovable()) {
            setContentView(C0329R.layout.scanning);
        } else {
            setContentView(C0329R.layout.scanning_nosdcard);
        }
        getWindow().setLayout(-2, -2);
        setResult(0);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), 1000);
    }

    public void onDestroy() {
        this.mHandler.removeMessages(0);
        super.onDestroy();
    }
}
