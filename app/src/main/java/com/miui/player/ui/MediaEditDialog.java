package com.miui.player.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.meta.MetaManager;

public class MediaEditDialog implements OnClickListener, OnCheckedChangeListener {
    public static final String CONFIRM_TEXT = "confirm_text";
    public static final String DIALOG_TITLE = "dialog_title";
    public static final String MODIFY_ID3 = "modify_id3";
    public static final String MODIFY_ID3_ENABLED = "modify_id3_enabled";
    public static final String NEW_ALBUM_NAME = "new_album_name";
    public static final String NEW_ARTIST_NAME = "new_artist_name";
    public static final String NEW_TRACK_NAME = "new_track_name";
    public static final String RAW_ALBUM_NAME = "raw_album_name";
    public static final String RAW_ARTIST_NAME = "raw_artist_name";
    public static final String RAW_FILE_PATH = "raw_path";
    public static final String RAW_TRACK_NAME = "raw_track_name";
    public static final String TRACE_KEY = "trace";
    private final Activity mActivity;
    private EditText mAlbumEditText;
    private TextView mAlbumTextView;
    private EditText mArtistEditText;
    private TextView mArtistTextView;
    private final Bundle mBundle;
    private final DialogCallback mCallback;
    private CheckBox mId3EditCheckBox;
    private String mRawAlbumName = MetaManager.UNKNOWN_STRING;
    private String mRawArtistName = MetaManager.UNKNOWN_STRING;
    private String mRawTrackName = MetaManager.UNKNOWN_STRING;
    private final int mRequestCode;
    private final Parcelable mTrace;
    private EditText mTrackEditText;
    private TextView mTrackTextView;
    private final String mUnknownAlbum;
    private final String mUnknownArtist;

    public MediaEditDialog(Activity activity, Bundle intent, DialogCallback callback, int requestCode) {
        this.mActivity = activity;
        this.mBundle = intent;
        this.mTrace = intent.getParcelable(TRACE_KEY);
        this.mUnknownArtist = this.mActivity.getString(C0329R.string.unknown_artist_name);
        this.mUnknownAlbum = this.mActivity.getString(C0329R.string.unknown_album_name);
        this.mCallback = callback;
        this.mRequestCode = requestCode;
    }

    public void show() {
        View view = LayoutInflater.from(this.mActivity).inflate(C0329R.layout.media_edit_dialog, null);
        bindDialog(view);
        AlertDialog dialog = new Builder(this.mActivity).setCancelable(true).setNegativeButton(C0329R.string.cancel, this).setPositiveButton(this.mBundle.getString(CONFIRM_TEXT, this.mActivity.getString(C0329R.string.confirm)), this).setView(view).setTitle(this.mBundle.getString(DIALOG_TITLE, MetaManager.UNKNOWN_STRING)).create();
        dialog.getWindow().setSoftInputMode(5);
        dialog.show();
    }

    private void bindDialog(View dialog) {
        Bundle bundle = this.mBundle;
        this.mTrackTextView = (TextView) dialog.findViewById(C0329R.id.track);
        this.mTrackEditText = (EditText) dialog.findViewById(C0329R.id.track_edit);
        this.mArtistTextView = (TextView) dialog.findViewById(C0329R.id.artist);
        this.mArtistEditText = (EditText) dialog.findViewById(C0329R.id.artist_edit);
        this.mAlbumTextView = (TextView) dialog.findViewById(C0329R.id.album);
        this.mAlbumEditText = (EditText) dialog.findViewById(C0329R.id.album_edit);
        this.mId3EditCheckBox = (CheckBox) dialog.findViewById(C0329R.id.id3_edit_check_box);
        if (bundle.getBoolean(MODIFY_ID3_ENABLED, false)) {
            this.mId3EditCheckBox.setVisibility(0);
            this.mId3EditCheckBox.setOnCheckedChangeListener(this);
        } else {
            this.mId3EditCheckBox.setVisibility(8);
        }
        if (bundle.containsKey(RAW_TRACK_NAME)) {
            this.mRawTrackName = bundle.getString(RAW_TRACK_NAME);
            this.mTrackEditText.setText(this.mRawTrackName);
            this.mTrackEditText.setSelection(this.mTrackEditText.getText().length());
        } else {
            this.mTrackTextView.setVisibility(8);
            this.mTrackEditText.setVisibility(8);
        }
        if (bundle.containsKey(RAW_ARTIST_NAME)) {
            this.mRawArtistName = bundle.getString(RAW_ARTIST_NAME);
            this.mArtistEditText.setText(MetaManager.getLocaleArtistName(this.mActivity, this.mRawArtistName));
            this.mArtistEditText.setSelection(this.mArtistEditText.getText().length());
        } else {
            this.mArtistTextView.setVisibility(8);
            this.mArtistEditText.setVisibility(8);
        }
        if (bundle.containsKey(RAW_ALBUM_NAME)) {
            this.mRawAlbumName = bundle.getString(RAW_ALBUM_NAME);
            this.mAlbumEditText.setText(MetaManager.getLocaleAlbumName(this.mActivity, this.mRawAlbumName));
            this.mAlbumEditText.setSelection(this.mAlbumEditText.getText().length());
            return;
        }
        this.mAlbumTextView.setVisibility(8);
        this.mAlbumEditText.setVisibility(8);
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!isTrackTextValid()) {
            Toast.makeText(this.mActivity, C0329R.string.empty_edit_hint, 0).show();
            this.mId3EditCheckBox.setChecked(false);
        }
    }

    public void onClick(DialogInterface dialog, int which) {
        boolean confirm = false;
        Intent intent = new Intent();
        if (which == -1) {
            if (!isTrackTextValid() && this.mId3EditCheckBox.isChecked()) {
                Toast.makeText(this.mActivity, C0329R.string.empty_edit_hint, 0).show();
                this.mId3EditCheckBox.setChecked(false);
            } else if (!isAllTextEmpty()) {
                intent = new Intent();
                String input = this.mTrackEditText.getText().toString();
                if (TextUtils.isEmpty(input) || this.mUnknownAlbum.equals(input)) {
                    input = MetaManager.UNKNOWN_STRING;
                }
                intent.putExtra(NEW_TRACK_NAME, input);
                input = this.mAlbumEditText.getText().toString().trim();
                if (TextUtils.isEmpty(input) || this.mUnknownAlbum.equals(input)) {
                    input = MetaManager.UNKNOWN_STRING;
                }
                intent.putExtra(NEW_ALBUM_NAME, input);
                input = this.mArtistEditText.getText().toString().trim();
                if (TextUtils.isEmpty(input) || this.mUnknownArtist.equals(input)) {
                    input = MetaManager.UNKNOWN_STRING;
                }
                intent.putExtra(NEW_ARTIST_NAME, input);
                intent.putExtra(MODIFY_ID3, this.mId3EditCheckBox.isChecked());
                intent.putExtra(RAW_TRACK_NAME, this.mRawTrackName);
                intent.putExtra(RAW_ALBUM_NAME, this.mRawAlbumName);
                intent.putExtra(RAW_ARTIST_NAME, this.mRawArtistName);
                intent.putExtra(RAW_FILE_PATH, this.mBundle.getString(RAW_FILE_PATH));
                intent.putExtra(TRACE_KEY, this.mTrace);
                confirm = true;
            }
        }
        if (this.mCallback != null) {
            this.mCallback.onDialogResult(this.mRequestCode, confirm, intent);
        }
    }

    private boolean isAllTextEmpty() {
        return TextUtils.isEmpty(this.mTrackEditText.getText()) && TextUtils.isEmpty(this.mArtistEditText.getText()) && TextUtils.isEmpty(this.mAlbumEditText.getText());
    }

    private boolean isTrackTextValid() {
        EditText editText = this.mTrackEditText;
        return (editText == null || (editText.getVisibility() == 0 && TextUtils.isEmpty(editText.getText()))) ? false : true;
    }
}
