package com.miui.player.ui;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import com.miui.player.C0329R;
import com.miui.player.util.FolderProvider;
import com.miui.player.util.FolderProvider.FolderStatus;
import com.miui.player.util.PlaylistRecoverer;

public class FolderSelectDialog extends DialogPreference {
    FolderStatus[] mFolderStatus;
    private final CharSequence mSummaryOff;
    private final CharSequence mSummaryOn;

    class C04321 implements OnMultiChoiceClickListener {
        C04321() {
        }

        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            if (FolderSelectDialog.this.mFolderStatus != null && which < FolderSelectDialog.this.mFolderStatus.length) {
                FolderSelectDialog.this.mFolderStatus[which].mSelected = isChecked;
            }
        }
    }

    public FolderSelectDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, C0329R.styleable.PreferenceCommon, 0, 0);
        try {
            this.mSummaryOn = a.getText(0);
            this.mSummaryOff = a.getText(1);
            setSummary(isChecked() ? this.mSummaryOn : this.mSummaryOff);
            setDialogLayoutResource(C0329R.layout.folder_select);
        } finally {
            a.recycle();
        }
    }

    protected void onPrepareDialogBuilder(Builder builder) {
        super.onPrepareDialogBuilder(builder);
        builder.setTitle(C0329R.string.select_folder);
        Context context = getContext();
        this.mFolderStatus = FolderProvider.instance(context).getAllFolderStatus(context);
        FolderStatus[] folders = this.mFolderStatus;
        CharSequence[] names = new CharSequence[folders.length];
        boolean[] checkedItems = new boolean[folders.length];
        int i = 0;
        for (FolderStatus status : folders) {
            names[i] = UIHelper.getDisplayFolderPath(status.mFolderPath);
            checkedItems[i] = status.mSelected;
            i++;
        }
        builder.setMultiChoiceItems(names, checkedItems, new C04321());
    }

    protected void onDialogClosed(boolean positiveResult) {
        if (positiveResult && this.mFolderStatus != null) {
            Context context = getContext();
            if (FolderProvider.instance(context).updateFolderItemSelected(context, this.mFolderStatus)) {
                PlaylistRecoverer.markForceRecover();
            }
            setSummary(isChecked() ? this.mSummaryOn : this.mSummaryOff);
        }
        super.onDialogClosed(positiveResult);
    }

    public boolean isPersistent() {
        return false;
    }

    private boolean isChecked() {
        if (this.mFolderStatus != null) {
            for (FolderStatus fs : this.mFolderStatus) {
                if (!fs.mSelected) {
                    return true;
                }
            }
        }
        return false;
    }
}
