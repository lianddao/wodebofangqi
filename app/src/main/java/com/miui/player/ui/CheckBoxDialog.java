package com.miui.player.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.miui.player.C0329R;

public class CheckBoxDialog {
    public static final String KEY_CHECK_STATUS = "check_status";
    public static final String KEY_CHECK_VISIBLE = "check_visible";
    public static final String KEY_MESSAGE = "msg";
    public static final String KEY_TITLE = "title";
    final Activity mActivity;
    CheckBox mCheckBox;
    private OnClickListener mConfirmClicked = new C04291();
    final Intent mData;
    final DialogCallback mListener;
    final int mRequestCode;
    Button mSaveButton;

    class C04291 implements OnClickListener {
        C04291() {
        }

        public void onClick(DialogInterface dialog, int which) {
            boolean confirm = false;
            if (which == -1) {
                CheckBoxDialog.this.mData.putExtra(CheckBoxDialog.KEY_CHECK_STATUS, CheckBoxDialog.this.mCheckBox.isChecked());
                confirm = true;
            }
            if (CheckBoxDialog.this.mListener != null) {
                CheckBoxDialog.this.mListener.onDialogResult(CheckBoxDialog.this.mRequestCode, confirm, CheckBoxDialog.this.mData);
            }
        }
    }

    public CheckBoxDialog(Activity a, DialogCallback l, int requestCode, Intent extras) {
        this.mActivity = a;
        this.mListener = l;
        this.mRequestCode = requestCode;
        this.mData = extras;
    }

    public void show() {
        View entryView = LayoutInflater.from(this.mActivity).inflate(C0329R.layout.checkbox_dialog, null);
        AlertDialog dialog = new Builder(this.mActivity).setCancelable(true).setTitle(this.mData.getStringExtra("title")).setNegativeButton(C0329R.string.cancel, this.mConfirmClicked).setPositiveButton(C0329R.string.confirm, this.mConfirmClicked).setView(entryView).create();
        dialog.show();
        dialog.setVolumeControlStream(3);
        this.mCheckBox = (CheckBox) entryView.findViewById(C0329R.id.follow_checkbox);
        this.mCheckBox.setVisibility(this.mData.getBooleanExtra(KEY_CHECK_VISIBLE, false) ? 0 : 8);
        this.mCheckBox.setChecked(this.mData.getBooleanExtra(KEY_CHECK_STATUS, false));
        this.mCheckBox.setText(this.mData.getStringExtra(KEY_MESSAGE));
        this.mSaveButton = dialog.getButton(-1);
    }
}
