package com.miui.player.ui;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.In;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.util.Actions;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.Utils;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.NetworkUtil;
import miui.provider.ExtraSettings.Secure;

public class MusicBrowserActivity extends MusicBaseActivity {
    static final String TAG = "MusicBrowserActivity";

    class C04381 implements OnCancelListener {
        C04381() {
        }

        public void onCancel(DialogInterface dialog) {
            MusicBrowserActivity.this.finish();
        }
    }

    class C04403 implements OnClickListener {
        C04403() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MusicBrowserActivity.this.finish();
        }
    }

    public void onCreateContent(Bundle icicle) {
        boolean enableShowAlert = PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_ENABLE_CONNECT_NETWORK_ALERT);
        boolean enableCTA = Secure.isCtaSupported(getContentResolver());
        if (enableShowAlert && Utils.isOnlineVaild()) {
            showConnectNetworkAlert();
        } else {
            onCTATestPass();
        }
    }

    public void showConnectNetworkAlert() {
        String titleText = getString(C0329R.string.impunity_declaration_title);
        String possitiveText = getString(17039370);
        View message = LayoutInflater.from(this).inflate(C0329R.layout.impunity_declaration, null);
        ((TextView) message.findViewById(C0329R.id.impunity_declaration)).setMovementMethod(LinkMovementMethod.getInstance());
        final CheckBox checkbox = (CheckBox) message.findViewById(C0329R.id.impunity_declaration_checkbox);
        new Builder(this).setCancelable(true).setIconAttribute(16843605).setTitle(titleText).setView(message).setNegativeButton(17039360, new C04403()).setPositiveButton(possitiveText, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MusicBrowserActivity.this.finish();
                if (checkbox.isChecked()) {
                    PreferenceCache.setPrefAsBoolean(MusicBrowserActivity.this, PreferenceCache.PREF_ENABLE_CONNECT_NETWORK_ALERT, false);
                }
                NetworkUtil.setNetworkAllow(true);
                MusicBrowserActivity.this.onCTATestPass();
            }
        }).show().setOnCancelListener(new C04381());
    }

    void onCTATestPass() {
        Intent intent = getIntent();
        String action = intent.getAction();
        if (In.ACTION_MUSIC_ONLINE_PLAY_ENTRY.equals(action)) {
            int pos = intent.getIntExtra("position", 0);
            AudioList list = (AudioList) intent.getSerializableExtra("audio_list");
            if (list != null) {
                ServiceHelper.playAll(this, list.getContent(), OnlineMusicProxy.getProviderName(this), pos, false, false);
            } else {
                MusicLog.m397e(TAG, "list is empty");
            }
        } else if (In.ACTION_MUSIC_ONLINE_GROUP_VIEW_ENTRY.equals(action)) {
            String groupId = intent.getStringExtra(In.KEY_GROUP_ID);
            if (TextUtils.isEmpty(groupId)) {
                MusicLog.m397e(TAG, "group id is empty");
            } else {
                Intent targetIntent = new Intent(Actions.ACTION_BROWSER);
                targetIntent.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_ONLINE_PREVIEW_SONG_GROUP);
                targetIntent.putExtra(Actions.KEY_PLAYLIST_ONLINE_ID, groupId);
                startActivity(targetIntent);
            }
        } else {
            startActivity(new Intent(In.ACTION_MUSIC_MAIN));
        }
        finish();
    }
}
