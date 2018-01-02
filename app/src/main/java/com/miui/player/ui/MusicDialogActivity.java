package com.miui.player.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.miui.player.C0329R;
import com.miui.player.util.Actions;
import com.miui.player.vod.ThunderStoneKtvNetwork;

public class MusicDialogActivity extends Activity implements OnDismissListener, OnCancelListener {

    class C04411 implements OnClickListener {
        C04411() {
        }

        public void onClick(DialogInterface dialog, int which) {
            ThunderStoneKtvNetwork.disconnect();
        }
    }

    class C04422 implements OnClickListener {
        C04422() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(17170445);
        String action = getIntent().getAction();
        if (action == null) {
            finish();
        }
        AlertDialog dialog = null;
        Builder builder = new Builder(this);
        Object[] objArr;
        if (Actions.ACTION_KTV_CONNECTED.equals(action)) {
            objArr = new Object[]{ThunderStoneKtvNetwork.getKtvName(), ThunderStoneKtvNetwork.getRoomName()};
            dialog = builder.setTitle(getString(C0329R.string.ktv_connected_alert_titel, new Object[]{getString(C0329R.string.ktv_and_room, objArr)})).setMessage(C0329R.string.ktv_connected_alert_message).setPositiveButton(C0329R.string.i_know, null).setCancelable(true).setOnCancelListener(this).create();
        } else if (Actions.ACTION_KTV_DISCONNECT.equals(action)) {
            objArr = new Object[]{ThunderStoneKtvNetwork.getKtvName(), ThunderStoneKtvNetwork.getRoomName()};
            dialog = builder.setTitle(getString(C0329R.string.ktv_disconnect_alert_titel, new Object[]{getString(C0329R.string.ktv_and_room, objArr)})).setPositiveButton(C0329R.string.disconnect, new C04411()).setNegativeButton(C0329R.string.cancel, null).setCancelable(true).setOnCancelListener(this).create();
        } else if (Actions.ACTION_VOLUME_ALERT.equals(action)) {
            dialog = builder.setTitle(C0329R.string.volume_alert_playback_alert_title).setMessage(C0329R.string.volume_alert_playback_message).setPositiveButton(C0329R.string.i_know, new C04422()).create();
        }
        if (dialog != null) {
            dialog.setOnDismissListener(this);
            dialog.show();
        }
    }

    public void onDismiss(DialogInterface dialog) {
        finish();
    }

    public void onCancel(DialogInterface dialog) {
        finish();
    }
}
