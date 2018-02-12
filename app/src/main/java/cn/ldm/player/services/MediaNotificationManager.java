/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.ldm.player.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Icon;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;

import cn.ldm.player.activities.PlayingActivity;
import cn.ldm.player.core.MusicScanner;

/**
 * 媒体通知管理器
 * 跟踪通知并自动更新给定的 MediaSession。保持可见的通知（通常）保证在播放过程中不会杀死音乐服务。
 */
public class MediaNotificationManager extends BroadcastReceiver {
    private static final String TAG = MediaNotificationManager.class.getSimpleName();

    // 通知的id，请求码
    private static final int NOTIFICATION_ID = 412;
    private static final int REQUEST_CODE = 100;

    // 操作名称：暂停、播放、上一曲、下一曲、停止
    public static final String ACTION_PAUSE = "com.example.android.uamp.pause";
    public static final String ACTION_PLAY = "com.example.android.uamp.play";
    public static final String ACTION_PREV = "com.example.android.uamp.prev";
    public static final String ACTION_NEXT = "com.example.android.uamp.next";
    public static final String ACTION_STOP_CASTING = "com.example.android.uamp.stop_cast";

    // 音乐服务、媒体会话、媒体控制器、媒体控制器的运输控制器
    private final MyMediaBrowserService mService;
    private MediaSession.Token mSessionToken;
    private MediaController mController;
    private MediaController.TransportControls mTransportControls;

    // 播放状态、媒体元数据
    private PlaybackState mPlaybackState;
    private MediaMetadata mMetadata;

    private final NotificationManager mNotificationManager;

    // 留待处理的意图：暂停、播放、上一曲、下一曲、停止
    private final PendingIntent mPauseIntent;
    private final PendingIntent mPlayIntent;
    private final PendingIntent mPreviousIntent;
    private final PendingIntent mNextIntent;
    private final PendingIntent mStopCastIntent;

    private boolean mStarted = false;

    public MediaNotificationManager(MyMediaBrowserService service) throws RemoteException {
        mService = service;

        // 更新会话记号
        updateSessionToken();

        mNotificationManager = (NotificationManager) service.getSystemService(Context.NOTIFICATION_SERVICE);


        String pkg = mService.getPackageName();
        mPauseIntent = PendingIntent.getBroadcast(mService, REQUEST_CODE,
                new Intent(ACTION_PAUSE).setPackage(pkg), PendingIntent.FLAG_CANCEL_CURRENT);
        mPlayIntent = PendingIntent.getBroadcast(mService, REQUEST_CODE,
                new Intent(ACTION_PLAY).setPackage(pkg), PendingIntent.FLAG_CANCEL_CURRENT);
        mPreviousIntent = PendingIntent.getBroadcast(mService, REQUEST_CODE,
                new Intent(ACTION_PREV).setPackage(pkg), PendingIntent.FLAG_CANCEL_CURRENT);
        mNextIntent = PendingIntent.getBroadcast(mService, REQUEST_CODE,
                new Intent(ACTION_NEXT).setPackage(pkg), PendingIntent.FLAG_CANCEL_CURRENT);
        mStopCastIntent = PendingIntent.getBroadcast(mService, REQUEST_CODE,
                new Intent(ACTION_STOP_CASTING).setPackage(pkg),
                PendingIntent.FLAG_CANCEL_CURRENT);

        // 取消所有通知以处理由系统被杀死并重新启动服务的情况。
        mNotificationManager.cancelAll();
    }

    /**
     * 发布通知并开始跟踪会话以保持更新。
     * 如果在调用 {@link #stopNotification} 之前会话被销毁，通知将自动被删除。
     */
    public void startNotification() {
        if (!mStarted) {
            mMetadata = mController.getMetadata();
            mPlaybackState = mController.getPlaybackState();

            // 必须在设置 started 为 true 后才更新通知
            Notification notification = createNotification();
            if (notification != null) {
                mController.registerCallback(mCb);
                IntentFilter filter = new IntentFilter();
                filter.addAction(ACTION_NEXT);
                filter.addAction(ACTION_PAUSE);
                filter.addAction(ACTION_PLAY);
                filter.addAction(ACTION_PREV);
                filter.addAction(ACTION_STOP_CASTING);
                mService.registerReceiver(this, filter);

                mService.startForeground(NOTIFICATION_ID, notification);
                mStarted = true;
            }
        }
    }

    /**
     * 删除通知并停止跟踪会话。
     * 如果会话已被销毁，将没有任何效果。
     */
    public void stopNotification() {
        if (mStarted) {
            mStarted = false;
            mController.unregisterCallback(mCb);
            try {
                mNotificationManager.cancel(NOTIFICATION_ID);
                mService.unregisterReceiver(this);
            } catch (IllegalArgumentException ex) {
                // 接收者未注册则忽略
            }
            mService.stopForeground(true);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: ");
        final String action = intent.getAction();
        switch (action) {
            case ACTION_PAUSE:
                mTransportControls.pause();
                break;
            case ACTION_PLAY:
                mTransportControls.play();
                break;
            case ACTION_NEXT:
                mTransportControls.skipToNext();
                break;
            case ACTION_PREV:
                mTransportControls.skipToPrevious();
                break;
            case ACTION_STOP_CASTING:
                Intent i = new Intent(context, MyMediaBrowserService.class);
                mService.startService(i);
                break;
            default:
                break;
        }
    }

    /**
     * 根据会话记号的更改去更新状态。 Called either when
     * 当第一次运行时或当媒体会话所有者已经销毁会话时被调用
     * （见 {@link android.media.session.MediaController.Callback#onSessionDestroyed()}）
     */
    private void updateSessionToken() throws RemoteException {
        MediaSession.Token freshToken = mService.getSessionToken();
        if (mSessionToken == null && freshToken != null ||
                mSessionToken != null && !mSessionToken.equals(freshToken)) {
            if (mController != null) {
                mController.unregisterCallback(mCb);
            }
            mSessionToken = freshToken;
            if (mSessionToken != null) {
                mController = new MediaController(mService, mSessionToken);
                mTransportControls = mController.getTransportControls();
                if (mStarted) {
                    mController.registerCallback(mCb);
                }
            }
        }
    }

    private PendingIntent createContentIntent(MediaDescription description) {
        Intent openUI = new Intent(mService, PlayingActivity.class);
        openUI.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        if (description != null) {
        }
        return PendingIntent.getActivity(mService, REQUEST_CODE, openUI, PendingIntent.FLAG_CANCEL_CURRENT);
    }

    //region 定义一个媒体控制器回调接口
    private final MediaController.Callback mCb = new MediaController.Callback() {
        @Override
        public void onPlaybackStateChanged(@NonNull PlaybackState state) {
            mPlaybackState = state;
            if (state.getState() == PlaybackState.STATE_STOPPED ||
                    state.getState() == PlaybackState.STATE_NONE) {
                stopNotification();
            } else {
                Notification notification = createNotification();
                if (notification != null) {
                    mNotificationManager.notify(NOTIFICATION_ID, notification);
                }
            }
        }

        @Override
        public void onMetadataChanged(MediaMetadata metadata) {
            mMetadata = metadata;
            Notification notification = createNotification();
            if (notification != null) {
                mNotificationManager.notify(NOTIFICATION_ID, notification);
            }
        }

        @Override
        public void onSessionDestroyed() {
            super.onSessionDestroyed();
            try {
                updateSessionToken();
            } catch (RemoteException e) {
            }
        }
    };
    //endregion

    private static final String LAB_PAUSE = "暂停", LAB_PLAY = "播放", LAB_PREV = "上一曲", LAB_NEXT = "下一曲";

    //region 创建一个通知
    private Notification createNotification() {
        if (mMetadata == null || mPlaybackState == null) {
            return null;
        }

        final Icon
                ICON_PAUSE = Icon.createWithResource(mService, android.R.drawable.ic_media_pause),
                ICON_PLAY = Icon.createWithResource(mService, android.R.drawable.ic_media_play),
                ICON_PREV = Icon.createWithResource(mService, android.R.drawable.ic_media_previous),
                ICON_NEXT = Icon.createWithResource(mService, android.R.drawable.ic_media_next);
        final PendingIntent
                PI_PAUSE = PendingIntent.getBroadcast(mService, REQUEST_CODE, new Intent(LAB_PAUSE), PendingIntent.FLAG_CANCEL_CURRENT),
                PI_PLAY = PendingIntent.getBroadcast(mService, REQUEST_CODE, new Intent(LAB_PLAY), PendingIntent.FLAG_CANCEL_CURRENT),
                PI_PREV = PendingIntent.getBroadcast(mService, REQUEST_CODE, new Intent(LAB_PREV), PendingIntent.FLAG_CANCEL_CURRENT),
                PI_NEXT = PendingIntent.getBroadcast(mService, REQUEST_CODE, new Intent(LAB_NEXT), PendingIntent.FLAG_CANCEL_CURRENT);
        final Notification.Action
                ACTION_PAUSE = new Notification.Action.Builder(ICON_PAUSE, LAB_PAUSE, PI_PAUSE).build(),
                ACTION_PLAY = new Notification.Action.Builder(ICON_PLAY, LAB_PLAY, PI_PLAY).build(),
                ACTION_PREV = new Notification.Action.Builder(ICON_PREV, LAB_PREV, PI_PREV).build(),
                ACTION_NEXT = new Notification.Action.Builder(ICON_NEXT, LAB_NEXT, PI_NEXT).build();


        Notification.Builder notificationBuilder = new Notification.Builder(mService);
        int playPauseButtonPosition = 0;

        MediaDescription description = mMetadata.getDescription();

        Log.i(TAG, "createNotification: 创建通知");
        notificationBuilder
                .setStyle(new Notification.MediaStyle()
                        .setShowActionsInCompactView(
                                new int[]{playPauseButtonPosition})  // show only play/pause in compact view
                        .setMediaSession(mSessionToken))
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setLargeIcon(MusicScanner.getInstance(mService).retrieveAlbumArt(mMetadata))
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setUsesChronometer(true)
                .addAction(ACTION_PREV)
                .addAction(ACTION_PLAY)
                .addAction(ACTION_NEXT)
                .setContentIntent(createContentIntent(description))
                .setContentTitle(description.getTitle())
                .setContentText(description.getSubtitle());

        if (mController != null && mController.getExtras() != null) {

        }

        setNotificationPlaybackState(notificationBuilder);

        return notificationBuilder.build();
    }
    //endregion

    //region 加上播放暂停操作
    private void addPlayPauseAction(Notification.Builder builder) {
        String label;
        int icon;
        PendingIntent intent;
        if (mPlaybackState.getState() == PlaybackState.STATE_PLAYING) {
            label = "暂停";
            icon = android.R.drawable.ic_media_pause;
            intent = mPauseIntent;
        } else {
            label = "播放";
            icon = android.R.drawable.ic_media_play;
            intent = mPlayIntent;
        }
        builder.addAction(new Notification.Action(icon, label, intent));
    }
    //endregion

    //region 设置通知播放状态
    private void setNotificationPlaybackState(Notification.Builder builder) {
        if (mPlaybackState == null || !mStarted) {
            mService.stopForeground(true);
            return;
        }
        if (mPlaybackState.getState() == PlaybackState.STATE_PLAYING
                && mPlaybackState.getPosition() >= 0) {
            builder
                    .setWhen(System.currentTimeMillis() - mPlaybackState.getPosition())
                    .setShowWhen(true)
                    .setUsesChronometer(true);
        } else {
            builder
                    .setWhen(0)
                    .setShowWhen(false)
                    .setUsesChronometer(false);
        }

        // 确保通知在用户不播放时可以被用户关闭：
        builder.setOngoing(mPlaybackState.getState() == PlaybackState.STATE_PLAYING);
    }
    //endregion
}
