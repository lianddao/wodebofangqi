package com.miui.player.ui;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class SingleChoiceDialog {
    ICheckedCommond mCommond;
    private Context mContext;
    CharSequence[] mItems;
    private int mResTitle;
    int mWhich;

    public interface ICheckedCommond {
        void excute(CharSequence[] charSequenceArr, int i);
    }

    class SingleChoiceDialogCheckedListener implements OnClickListener {
        SingleChoiceDialogCheckedListener() {
        }

        public void onClick(DialogInterface dialog, int which) {
            SingleChoiceDialog.this.mWhich = which;
            if (SingleChoiceDialog.this.mCommond != null) {
                SingleChoiceDialog.this.mCommond.excute(SingleChoiceDialog.this.mItems, SingleChoiceDialog.this.mWhich);
            }
            dialog.dismiss();
        }
    }

    public SingleChoiceDialog(CharSequence[] items, ICheckedCommond commond, Context context, int which, int resTitle) {
        this.mItems = items;
        this.mContext = context;
        this.mCommond = commond;
        this.mWhich = which;
        this.mResTitle = resTitle;
    }

    public void show() {
        new Builder(this.mContext).setTitle(this.mResTitle).setSingleChoiceItems(this.mItems, this.mWhich, new SingleChoiceDialogCheckedListener()).show();
    }
}
