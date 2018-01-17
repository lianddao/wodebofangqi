package cn.ldm.player.menu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import cn.ldm.player.R;

//一个用于播放列表对话框的简单基类。
public abstract class BasePlaylistDialog extends DialogFragment {

    protected AlertDialog mPlaylistDialog;
    protected EditText mPlaylist;
    protected Button mSaveButton;
    protected String mPrompt;
    protected String mDefaultName;

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        mPlaylist = new EditText(getActivity());
        mPlaylist.setSingleLine(true);
        mPlaylist.setInputType(mPlaylist.getInputType() | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
        mPlaylist.post(new Runnable() {
            @Override
            public void run() {
                mPlaylist.requestFocus();
                mPlaylist.selectAll();
            }
        });

        mPlaylistDialog = new AlertDialog.Builder(getActivity()).create();
        mPlaylistDialog.setButton(Dialog.BUTTON_POSITIVE, getString(R.string.save), new OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                onSaveClick();
                dialog.dismiss();
            }
        });
        mPlaylistDialog.setButton(Dialog.BUTTON_NEGATIVE, getString(R.string.cancel), new OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                dialog.dismiss();
            }
        });

        initObjects(savedInstanceState);
        mPlaylistDialog.setTitle(mPrompt);
        mPlaylistDialog.setView(mPlaylist);
        mPlaylist.setText(mDefaultName);
        mPlaylist.setSelection(mDefaultName.length());
        mPlaylist.addTextChangedListener(mTextWatcher);
        mPlaylistDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        mPlaylistDialog.show();
        return mPlaylistDialog;
    }

    private final TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {onTextChangedListener();}

        @Override
        public void afterTextChanged(final Editable s) {}

        @Override
        public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {}
    };

    //初始化提示和默认名称
    public abstract void initObjects(Bundle savedInstanceState);

    /**
     * 当按下 {@link AlertDialog} 的“保存”按钮时调用。
     */
    public abstract void onSaveClick();

    public abstract void onTextChangedListener();
}
