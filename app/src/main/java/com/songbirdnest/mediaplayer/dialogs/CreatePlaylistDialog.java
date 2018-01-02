package com.songbirdnest.mediaplayer.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.util.MediaUtils;

public class CreatePlaylistDialog extends Dialog {
    private static final int DEFAULT_FIRST_PLAYLIST = 1;
    private static final int DEFAULT_SOFT_INPUT_DELAY = 100;
    public static final int MODE_CREATE = 0;
    public static final int MODE_RENAME = 1;
    private Button mCancelButton;
    private Context mContext;
    private Cursor mCursor = null;
    private TextView mEditCaption;
    private EditText mEditName;
    private Handler mHandler = new Handler();
    private int mItemId = -1;
    private String mItemVolume = null;
    private int mMode = 0;
    private int mNextPlaylistNumber = -1;
    private int mPlaylistId = -1;
    private String mPlaylistName = null;
    private String mPlaylistVolume = null;
    private Button mSaveButton;
    private Runnable mShowSoftInputRunnable = new C01711();
    private View mView;

    class C01711 implements Runnable {
        C01711() {
        }

        public void run() {
            CreatePlaylistDialog.this.mEditName.selectAll();
            CreatePlaylistDialog.this.mEditName.requestFocus();
            ((InputMethodManager) CreatePlaylistDialog.this.mContext.getSystemService("input_method")).showSoftInput(CreatePlaylistDialog.this.mEditName, 0);
        }
    }

    class C01722 implements OnClickListener {
        C01722() {
        }

        public void onClick(View aView) {
            boolean success;
            int toastMessageId;
            if (CreatePlaylistDialog.this.mMode == 0) {
                success = CreatePlaylistDialog.this.createPlaylist();
                toastMessageId = C0116R.string.playlist_created_message;
            } else {
                success = CreatePlaylistDialog.this.renamePlaylist();
                toastMessageId = C0116R.string.playlist_renamed_message;
            }
            if (success) {
                Utils.showShortToast(CreatePlaylistDialog.this.mContext, CreatePlaylistDialog.this.mContext.getString(toastMessageId));
                CreatePlaylistDialog.this.dismiss();
                return;
            }
            CreatePlaylistDialog.this.cancel();
        }
    }

    class C01733 implements OnClickListener {
        C01733() {
        }

        public void onClick(View v) {
            CreatePlaylistDialog.this.cancel();
        }
    }

    public CreatePlaylistDialog(Context aContext) {
        super(aContext);
        this.mContext = aContext;
        setDefaultDialogOptions();
    }

    public CreatePlaylistDialog(Context aContext, int aThemeId) {
        super(aContext, aThemeId);
        this.mContext = aContext;
        setDefaultDialogOptions();
    }

    public boolean setDialogMode(int aMode) {
        if ((aMode != 0 && aMode != 1) || isShowing()) {
            return false;
        }
        this.mMode = aMode;
        return true;
    }

    public void setItemToAdd(int aItemId, String aItemVolume) {
        this.mItemId = aItemId;
        this.mItemVolume = aItemVolume;
    }

    public void setItemsToAdd(Cursor aCursor) {
        this.mCursor = aCursor;
    }

    public void setPlaylist(String aPlaylistName, int aPlaylistId, String aPlaylistVolume) {
        this.mPlaylistName = aPlaylistName;
        this.mPlaylistId = aPlaylistId;
        this.mPlaylistVolume = aPlaylistVolume;
    }

    protected void onStart() {
        createPrimaryView();
        this.mHandler.postDelayed(this.mShowSoftInputRunnable, 100);
    }

    private void createPrimaryView() {
        this.mView = LayoutInflater.from(this.mContext).inflate(C0116R.layout.create_playlist_dialog, null);
        this.mSaveButton = (Button) this.mView.findViewById(C0116R.id.create_playlist_save_button);
        this.mCancelButton = (Button) this.mView.findViewById(C0116R.id.create_playlist_cancel_button);
        this.mEditName = (EditText) this.mView.findViewById(C0116R.id.create_playlist_edit_name);
        this.mEditCaption = (TextView) this.mView.findViewById(C0116R.id.create_playlist_edit_caption);
        this.mEditCaption.setText(this.mMode == 0 ? this.mContext.getString(C0116R.string.create_playlist_dialog_name_caption) : this.mContext.getString(C0116R.string.create_playlist_dialog_rename_caption, new Object[]{this.mPlaylistName}));
        this.mEditName.setText(this.mMode == 0 ? getDefaultPlaylistName() : this.mPlaylistName);
        this.mSaveButton.setText(this.mMode == 0 ? C0116R.string.create_playlist_dialog_save_button_caption : C0116R.string.create_playlist_dialog_rename_button_caption);
        this.mCancelButton.setText(C0116R.string.create_playlist_dialog_cancel_button_caption);
        this.mSaveButton.setOnClickListener(new C01722());
        this.mCancelButton.setOnClickListener(new C01733());
        setContentView(this.mView);
    }

    private void setDefaultDialogOptions() {
        getWindow().requestFeature(1);
        setCanceledOnTouchOutside(true);
    }

    private String getDefaultPlaylistName() {
        this.mNextPlaylistNumber = this.mContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).getInt(PrefKeys.PLAYLIST_CREATE_NEXT_PLAYLIST, 1);
        return this.mContext.getString(C0116R.string.playlist_default_name, new Object[]{Integer.toString(this.mNextPlaylistNumber)});
    }

    private boolean createPlaylist() {
        boolean success;
        String playlistName = this.mEditName.getText().toString();
        if (this.mCursor != null) {
            if (MediaUtils.createMediaStorePlaylist(this.mContext, playlistName, this.mCursor) > 0) {
                success = true;
            } else {
                success = false;
            }
        } else if (this.mItemId == -1 || this.mItemVolume == null) {
            success = MediaUtils.createMediaStorePlaylist(this.mContext, playlistName);
        } else {
            success = MediaUtils.createMediaStorePlaylist(this.mContext, playlistName, this.mItemId, this.mItemVolume);
        }
        if (success) {
            Editor editor = this.mContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
            String str = PrefKeys.PLAYLIST_CREATE_NEXT_PLAYLIST;
            int i = this.mNextPlaylistNumber + 1;
            this.mNextPlaylistNumber = i;
            editor.putInt(str, i);
            editor.commit();
            return true;
        }
        Utils.showLongToast(this.mContext, this.mContext.getString(C0116R.string.playlist_create_failed_message, new Object[]{playlistName}));
        return false;
    }

    private boolean renamePlaylist() {
        return Utils.renameMediaStorePlaylist(this.mContext, this.mPlaylistId, this.mPlaylistVolume, this.mEditName.getText().toString());
    }
}
