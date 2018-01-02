package com.miui.player.ui.controller;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.DownloadInfoManager;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper;
import com.miui.player.plugin.onlinepay.ValueCallback;
import com.miui.player.plugin.onlinepay.VipOrderHelper;
import com.miui.player.plugin.onlinepay.VipOrderHelper.VipOrderCallback;
import com.miui.player.ui.UIHelper;
import com.miui.player.util.AccountUtils;
import com.miui.player.util.MusicAnalyticsUtils;
import com.xiaomi.music.util.MusicLog;
import java.util.Arrays;

public class QualityAlert {
    static final String TAG = "QualityAlert";

    public interface OnQualitySelectedListener {
        void onSelected(int i, boolean z);
    }

    static class QualityAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private final CharSequence[] mQulityNames;
        private int[] mStates;

        QualityAdapter(CharSequence[] names, int[] states) {
            this.mQulityNames = names;
            this.mStates = states;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            int i = 0;
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(parent.getContext());
            }
            if (convertView == null) {
                convertView = this.mInflater.inflate(C0329R.layout.quality_alert_singlechoice, parent, false);
            }
            TextView text1 = (TextView) convertView.findViewById(16908308);
            TextView text2 = (TextView) convertView.findViewById(16908309);
            text1.setText(this.mQulityNames[position]);
            if (this.mStates[position] == 0) {
                text1.setEnabled(true);
                text2.setVisibility(8);
            } else {
                text1.setEnabled(false);
                text2.setVisibility(0);
            }
            ImageView icon = (ImageView) convertView.findViewById(C0329R.id.vip_icon);
            if (position != 0) {
                i = 8;
            }
            icon.setVisibility(i);
            return convertView;
        }

        public int getCount() {
            return this.mQulityNames.length;
        }

        public Object getItem(int position) {
            return this.mQulityNames[position];
        }

        public long getItemId(int position) {
            return (long) position;
        }
    }

    static class QualityAlertListener implements OnClickListener {
        final Activity mActivity;
        final Audio mAudio;
        final String mEntrance;
        final OnQualitySelectedListener mListener;
        final int[] mStates;

        public QualityAlertListener(Activity a, OnQualitySelectedListener l, int[] states, String entrance, Audio audio) {
            this.mListener = l;
            this.mActivity = a;
            this.mStates = states;
            this.mEntrance = entrance;
            this.mAudio = audio;
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which < 0 || this.mStates[which] == 0) {
                dialog.dismiss();
                if (this.mActivity.isFinishing() || which < 0) {
                    this.mListener.onSelected(-1, false);
                    return;
                }
                final int quality = which;
                if (AccountPermissionHelper.allowMusic(quality)) {
                    this.mListener.onSelected(quality, true);
                    return;
                }
                boolean hasLogin = AccountUtils.hasLoginXiaomiAccount();
                if (!hasLogin) {
                    AccountManagerCallback<Bundle> callback = new AccountManagerCallback<Bundle>() {
                        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                            MusicAnalyticsUtils.trackLoginResult();
                            if (QualityAlertListener.this.mActivity.isFinishing() || !AccountUtils.hasLoginXiaomiAccount()) {
                                QualityAlertListener.this.mListener.onSelected(quality, false);
                            } else if (quality == 0) {
                                QualityAlert.doAfterRefreshVipPermission(QualityAlertListener.this.mActivity, QualityAlertListener.this.mListener, quality, QualityAlertListener.this.mEntrance, QualityAlertListener.this.mAudio);
                            } else {
                                QualityAlertListener.this.mListener.onSelected(quality, AccountPermissionHelper.allowMusic(quality));
                            }
                        }
                    };
                    UIHelper.toastSafe(C0329R.string.login_first, new Object[0]);
                    AccountUtils.loginXiaomiAccount(this.mActivity, callback);
                } else if (quality == 0 || quality == 1) {
                    QualityAlert.doAfterRefreshVipPermission(this.mActivity, this.mListener, quality, this.mEntrance, this.mAudio);
                } else {
                    MusicLog.m404w(QualityAlert.TAG, "showQualitiAltert warning! hasLogin=" + hasLogin + ", quality=" + quality);
                    this.mListener.onSelected(quality, false);
                }
            }
        }
    }

    public static void show(Activity a, boolean downloadTask, int defaultQuality, Audio audio, OnQualitySelectedListener r, String entrance) {
        AlertDialog dialog;
        CharSequence[] names = a.getResources().getTextArray(C0329R.array.music_quality);
        int[] states = new int[names.length];
        Arrays.fill(states, 0);
        if (downloadTask && audio != null) {
            String[] paths = MetaManager.getAllSortedDownloadedMP3Names();
            String onlineId = audio.getId();
            String title = audio.getTitle();
            String artist = audio.getArtistName();
            for (int i = 0; i < names.length; i++) {
                states[i] = DownloadInfoManager.getDownloadStatus(a, onlineId, title, artist, i, paths);
            }
        }
        QualityAdapter adapter = new QualityAdapter(names, states);
        final QualityAlertListener listener = new QualityAlertListener(a, r, states, entrance, audio);
        Builder builder = new Builder(a).setTitle(downloadTask ? C0329R.string.choose_download_quality : C0329R.string.choose_stream_quality);
        if (defaultQuality >= 0) {
            builder.setSingleChoiceItems(adapter, defaultQuality, listener);
            dialog = builder.create();
        } else {
            builder.setAdapter(adapter, null);
            dialog = builder.create();
            dialog.getListView().setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    listener.onClick(dialog, position);
                }
            });
        }
        dialog.show();
    }

    static void doAfterRefreshVipPermission(Activity activity, final OnQualitySelectedListener l, final int quality, String entrance, Audio audio) {
        ValueCallback<Boolean> callback;
        ValueCallback<Boolean> refreshListener = new ValueCallback<Boolean>() {
            public void execute(Boolean isVip) {
                l.onSelected(quality, AccountPermissionHelper.allowMusic(quality));
            }
        };
        if (quality == 0) {
            callback = new VipOrderCallback(activity, Long.toString(VipOrderHelper.DEFAULT_PRODUCT_ID), refreshListener, entrance, audio);
        } else {
            callback = refreshListener;
        }
        AccountPermissionHelper.refreshVipPermission(true, callback);
    }
}
