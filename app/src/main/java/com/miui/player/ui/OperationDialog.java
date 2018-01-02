package com.miui.player.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.miui.player.C0329R;
import com.miui.player.provider.PlayerProviderUtils;
import com.miui.player.provider.PlayerStore.MiuiEqualizer;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.util.SqlUtils;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class OperationDialog {
    public static final String KEY_CALLBACK = "callback";
    final Activity mActivity;
    final DialogBuilder mBuilder;
    final Intent mCallbackIntent;
    private OnClickListener mConfirmClicked = new C04552();
    EditText mInput;
    final DialogCallback mListener;
    final int mRequestCode;
    private Set<String> mReservedNames = new HashSet();
    Button mSaveButton;
    private final TextWatcher mTextWatcher = new C04541();

    class C04541 implements TextWatcher {
        C04541() {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String current = OperationDialog.this.mInput.getText().toString().trim();
            OperationDialog.this.mSaveButton.setText(OperationDialog.this.mBuilder.getConfirm(current));
            OperationDialog.this.mSaveButton.setEnabled(OperationDialog.this.mBuilder.isConfirmable(current, OperationDialog.this.mReservedNames));
        }

        public void afterTextChanged(Editable s) {
        }
    }

    class C04552 implements OnClickListener {
        C04552() {
        }

        public void onClick(DialogInterface dialog, int which) {
            Uri uri = null;
            boolean confirm = false;
            if (which == -1) {
                String name = OperationDialog.this.mInput.getText().toString();
                if (OperationDialog.this.mBuilder.isConfirmable(name, OperationDialog.this.mReservedNames)) {
                    uri = OperationDialog.this.mBuilder.execute(name);
                    confirm = true;
                }
            }
            if (OperationDialog.this.mListener != null) {
                Intent result = new Intent();
                if (uri != null) {
                    result.setData(uri);
                }
                if (OperationDialog.this.mCallbackIntent != null) {
                    result.putExtra(OperationDialog.KEY_CALLBACK, OperationDialog.this.mCallbackIntent);
                }
                OperationDialog.this.mListener.onDialogResult(OperationDialog.this.mRequestCode, confirm, result);
            }
            if (OperationDialog.this.mInput != null) {
                ((InputMethodManager) OperationDialog.this.mInput.getContext().getSystemService("input_method")).hideSoftInputFromWindow(OperationDialog.this.mInput.getWindowToken(), 0);
            }
        }
    }

    public interface DialogBuilder {
        Uri execute(String str);

        String getConfirm(String str);

        String getPrompt();

        String getSuggestionName();

        boolean isConfirmable(String str, Set<String> set);
    }

    private static class EqualizerBuilder implements DialogBuilder {
        private final Context mContext;
        private final String mData;

        public EqualizerBuilder(Context context, String data) {
            this.mContext = context;
            this.mData = data;
        }

        public String getPrompt() {
            return this.mContext.getString(C0329R.string.create_equalzier_create_text_prompt);
        }

        public String getConfirm(String input) {
            if (input == null) {
                return this.mContext.getString(C0329R.string.create_confirm);
            }
            if (PlayerProviderUtils.idForEqualizer(this.mContext, input.toString().trim()) >= 0) {
                return this.mContext.getString(C0329R.string.overwrite_confirm);
            }
            return this.mContext.getString(C0329R.string.create_confirm);
        }

        public String getSuggestionName() {
            Cursor c = this.mContext.getContentResolver().query(MiuiEqualizer.EXTERNAL_URI, new String[]{"name"}, null, null, null);
            if (c == null) {
                return null;
            }
            String suggestedname = OperationDialog.getSuggestedName(this.mContext.getString(C0329R.string.new_equalizer_name_template), c, 0);
            c.close();
            return suggestedname;
        }

        public Uri execute(String name) {
            return PlayerProviderUtils.createEqualizerConfig(this.mContext, name, this.mData);
        }

        public boolean isConfirmable(String input, Set<String> set) {
            return true;
        }
    }

    private static class NewPlaylistBuilder implements DialogBuilder {
        private final Context mContext;

        public NewPlaylistBuilder(Context context) {
            this.mContext = context;
        }

        public String getPrompt() {
            return this.mContext.getString(C0329R.string.create_playlist_create_text_prompt);
        }

        public String getConfirm(String input) {
            return this.mContext.getString(C0329R.string.create_confirm);
        }

        public String getSuggestionName() {
            Cursor c = this.mContext.getContentResolver().query(MiuiPlaylists.EXTERNAL_URI, new String[]{"name"}, "name != '' AND list_type=0 AND mi_sync_playlist_state != ?", new String[]{String.valueOf(1)}, "name");
            String suggestedname = null;
            if (c != null) {
                try {
                    suggestedname = OperationDialog.getSuggestedName(this.mContext.getString(C0329R.string.new_playlist_name_template), c, 0);
                } finally {
                    c.close();
                }
            }
            return suggestedname;
        }

        public Uri execute(String name) {
            return PlaylistHelper.createPlaylist(this.mContext, null, name, 0);
        }

        public boolean isConfirmable(String input, Set<String> reservedNames) {
            boolean ret;
            if (TextUtils.isEmpty(input)) {
                ret = false;
            } else {
                ret = true;
            }
            if (reservedNames == null) {
                return ret;
            }
            if (!ret || reservedNames.contains(input)) {
                return false;
            }
            return true;
        }
    }

    private static abstract class RenameBuilder implements DialogBuilder {
        protected final Context mContext;
        private final Set<String> mExistNameSet;
        protected final String mOrignalName;

        public RenameBuilder(Context context, long renameId, String orignalName, Set<String> existNameSet) {
            this.mContext = context;
            this.mOrignalName = orignalName;
            this.mExistNameSet = existNameSet;
        }

        public String getConfirm(String input) {
            return this.mContext.getString(C0329R.string.confirm);
        }

        public String getSuggestionName() {
            return this.mOrignalName;
        }

        public boolean isConfirmable(String input, Set<String> reservedNames) {
            if (TextUtils.equals(this.mOrignalName, input)) {
                return true;
            }
            boolean ret;
            if (TextUtils.isEmpty(input)) {
                ret = false;
            } else {
                ret = true;
            }
            if (this.mExistNameSet != null) {
                if (!ret || this.mExistNameSet.contains(input)) {
                    ret = false;
                } else {
                    ret = true;
                }
            }
            if (reservedNames != null) {
                if (!ret || reservedNames.contains(input)) {
                    ret = false;
                } else {
                    ret = true;
                }
            }
            return ret;
        }
    }

    private static class PlaylistRenameBuilder extends RenameBuilder {
        private final long mRenameId;

        public PlaylistRenameBuilder(Context context, long renameId, String origalName, Set<String> existNameSet) {
            super(context, renameId, origalName, existNameSet);
            this.mRenameId = renameId;
        }

        public String getPrompt() {
            return UIHelper.format(this.mContext.getString(C0329R.string.rename_playlist_menu), this.mOrignalName);
        }

        public Uri execute(String name) {
            return null;
        }
    }

    private void initializeSystemPlaylistNames() {
        Resources standardResources = this.mActivity.getResources();
        AssetManager assets = standardResources.getAssets();
        DisplayMetrics metrics = standardResources.getDisplayMetrics();
        Configuration config = new Configuration(standardResources.getConfiguration());
        Locale standardLocale = config.locale;
        config.locale = Locale.US;
        Resources resources = new Resources(assets, metrics, config);
        addReservedNames();
        config.locale = Locale.SIMPLIFIED_CHINESE;
        resources = new Resources(assets, metrics, config);
        addReservedNames();
        config.locale = Locale.TAIWAN;
        resources = new Resources(assets, metrics, config);
        addReservedNames();
        config.locale = standardLocale;
        resources = new Resources(assets, metrics, config);
    }

    private void addReservedNames() {
        this.mReservedNames.add(this.mActivity.getResources().getString(C0329R.string.folders_title));
        this.mReservedNames.add(this.mActivity.getResources().getString(C0329R.string.playlist_favorite));
        this.mReservedNames.add(this.mActivity.getResources().getString(C0329R.string.playlist_recently_played));
        this.mReservedNames.add(this.mActivity.getResources().getString(C0329R.string.playlist_recently_added));
        this.mReservedNames.add(this.mActivity.getResources().getString(C0329R.string.playlist_frequently_played));
        this.mReservedNames.add(this.mActivity.getResources().getString(C0329R.string.playlist_my_ktv));
        this.mReservedNames.add(this.mActivity.getResources().getString(C0329R.string.new_playlist));
        Cursor c = SqlUtils.query(this.mActivity, MiuiPlaylists.EXTERNAL_URI, new String[]{"name"}, "mi_sync_playlist_state!=?", new String[]{String.valueOf(1)}, null);
        if (c != null) {
            while (c.moveToNext()) {
                try {
                    this.mReservedNames.add(c.getString(0));
                } finally {
                    c.close();
                }
            }
        }
    }

    private OperationDialog(Activity a, DialogCallback l, DialogBuilder creater, int requestCode, Intent extras) {
        this.mActivity = a;
        this.mListener = l;
        this.mRequestCode = requestCode;
        this.mBuilder = creater;
        this.mCallbackIntent = extras;
        initializeSystemPlaylistNames();
    }

    public void show() {
        View entryView = LayoutInflater.from(this.mActivity).inflate(C0329R.layout.creator_dialog, null);
        AlertDialog dialog = new Builder(this.mActivity).setCancelable(true).setTitle(this.mBuilder.getPrompt()).setNegativeButton(C0329R.string.cancel, this.mConfirmClicked).setPositiveButton(this.mBuilder.getConfirm(null), this.mConfirmClicked).setView(entryView).create();
        dialog.getWindow().setSoftInputMode(5);
        dialog.setVolumeControlStream(3);
        dialog.show();
        String defaultname = this.mBuilder.getSuggestionName();
        this.mInput = (EditText) entryView.findViewById(C0329R.id.input_name);
        this.mInput.setText(defaultname);
        this.mInput.setSelection(defaultname.length());
        this.mInput.addTextChangedListener(this.mTextWatcher);
        this.mSaveButton = dialog.getButton(-1);
    }

    protected static String getSuggestedName(String template, Cursor c, int nameIdx) {
        if (c == null) {
            return null;
        }
        int pos = c.getPosition();
        Object[] objArr = new Object[1];
        int num = 1 + 1;
        objArr[0] = Integer.valueOf(1);
        String suggestedname = String.format(template, objArr);
        boolean done = false;
        int i = num;
        while (!done) {
            done = true;
            c.moveToFirst();
            while (!c.isAfterLast()) {
                if (c.getString(0).compareToIgnoreCase(suggestedname) == 0) {
                    objArr = new Object[1];
                    num = i + 1;
                    objArr[0] = Integer.valueOf(i);
                    suggestedname = String.format(template, objArr);
                    done = false;
                    i = num;
                }
                c.moveToNext();
            }
        }
        c.moveToPosition(pos);
        return suggestedname;
    }

    public static OperationDialog makePlaylistCreator(Activity a, DialogCallback l, int requestCode, Intent extras) {
        return new OperationDialog(a, l, new NewPlaylistBuilder(a), requestCode, extras);
    }

    public static OperationDialog makeEqualizerConfigCreator(Activity a, DialogCallback l, int requestCode, String data, Intent extras) {
        return new OperationDialog(a, l, new EqualizerBuilder(a, data), requestCode, extras);
    }

    public static OperationDialog makePlaylistRenamer(Activity a, DialogCallback l, int requestCode, Intent extras, long renameId) {
        Set<String> existNameSet = PlaylistHelper.queryAllPlaylistNameSet(a);
        String origalName = PlaylistHelper.queryPlaylistName(a, renameId);
        if (TextUtils.isEmpty(origalName)) {
            return null;
        }
        return new OperationDialog(a, l, new PlaylistRenameBuilder(a, renameId, origalName, existNameSet), requestCode, extras);
    }
}
