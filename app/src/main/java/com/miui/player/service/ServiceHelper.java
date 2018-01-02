package com.miui.player.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.AudioManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;
import com.google.android.collect.Lists;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.MediaProviderHelper;
import com.miui.player.provider.PlayerProvider;
import com.miui.player.provider.PlayerProviderUtils;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.receiver.MediaButtonIntentReceiver;
import com.miui.player.service.IMediaPlaybackService.Stub;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.ServiceActions.In;
import com.miui.player.util.SqlUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class ServiceHelper {
    static final String TAG = ServiceHelper.class.getName();
    private static HashMap<Context, ServiceBinder> sConnectionMap = new HashMap();
    public static IMediaPlaybackService sService = null;

    private static class ServiceBinder implements ServiceConnection {
        ServiceConnection mCallback;

        ServiceBinder(ServiceConnection callback) {
            this.mCallback = callback;
        }

        public void onServiceConnected(ComponentName className, IBinder service) {
            ServiceHelper.sService = Stub.asInterface(service);
            if (this.mCallback != null) {
                this.mCallback.onServiceConnected(className, service);
            }
        }

        public void onServiceDisconnected(ComponentName className) {
            if (this.mCallback != null) {
                this.mCallback.onServiceDisconnected(className);
            }
            ServiceHelper.sService = null;
        }
    }

    public static class ServiceToken {
        ContextWrapper mWrappedContext;

        ServiceToken(ContextWrapper context) {
            this.mWrappedContext = context;
        }
    }

    public static ServiceToken bindToService(Activity context) {
        return bindToService(context, null);
    }

    public static ServiceToken bindToService(Activity context, ServiceConnection callback) {
        Activity realActivity = context.getParent();
        if (realActivity == null) {
            realActivity = context;
        }
        ContextWrapper cw = new ContextWrapper(realActivity);
        cw.startService(new Intent(cw, MediaPlaybackService.class));
        ServiceBinder sb = new ServiceBinder(callback);
        if (cw.bindService(new Intent().setClass(cw, MediaPlaybackService.class), sb, 0)) {
            sConnectionMap.put(cw, sb);
            return new ServiceToken(cw);
        }
        Log.e(TAG, "Failed to bind to service");
        return null;
    }

    public static void unbindFromService(ServiceToken token) {
        if (token == null) {
            Log.e(TAG, "Trying to unbind with null token");
            return;
        }
        ContextWrapper cw = token.mWrappedContext;
        ServiceBinder sb = (ServiceBinder) sConnectionMap.remove(cw);
        if (sb == null) {
            Log.e(TAG, "Trying to unbind for unknown Context");
            return;
        }
        cw.unbindService(sb);
        if (sConnectionMap.isEmpty()) {
            sService = null;
        }
    }

    public static int getQueuePosition() {
        if (sService != null) {
            try {
                return sService.getQueuePosition();
            } catch (RemoteException e) {
            }
        }
        return -1;
    }

    public static void toggleQueuePosition(int pos) {
        if (sService != null) {
            try {
                sService.setQueuePosition(pos);
            } catch (RemoteException e) {
            }
        }
    }

    public static long[] getQueue() {
        if (sService != null) {
            try {
                return sService.getQueue();
            } catch (RemoteException e) {
            }
        }
        return null;
    }

    public static int getQueueSize() {
        if (sService != null) {
            try {
                return sService.getQueueSize();
            } catch (RemoteException e) {
            }
        }
        return 0;
    }

    public static String getCurrentOnlineId() {
        if (sService != null) {
            try {
                return sService.getOnlineId();
            } catch (RemoteException e) {
            }
        }
        return null;
    }

    public static long getCurrentAlbumId() {
        if (sService != null) {
            try {
                return sService.getAlbumId();
            } catch (RemoteException e) {
            }
        }
        return -1;
    }

    public static long getCurrentArtistId() {
        if (sService != null) {
            try {
                return sService.getArtistId();
            } catch (RemoteException e) {
            }
        }
        return -1;
    }

    public static String getChannelName() {
        if (sService != null) {
            try {
                return sService.getChannelName();
            } catch (RemoteException e) {
            }
        }
        return null;
    }

    public static long getCurrentAudioId() {
        if (sService != null) {
            try {
                return sService.getAudioId();
            } catch (RemoteException e) {
            }
        }
        return -1;
    }

    public static boolean isCurrentFavorited(Context context) {
        if (sService != null) {
            try {
                return FavoriteCache.contains(context, sService.getAudioId(), sService.getOnlineId());
            } catch (RemoteException e) {
            }
        }
        return false;
    }

    public static boolean isShuffle() {
        int mode = 0;
        if (sService != null) {
            try {
                mode = sService.getShuffleMode();
            } catch (RemoteException e) {
            }
        }
        if (mode == 1) {
            return true;
        }
        return false;
    }

    public static boolean isMusicLoaded() {
        if (sService == null) {
            return false;
        }
        try {
            if (sService.getPath() != null) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }

    public static boolean isPlaying() {
        if (sService != null) {
            try {
                return sService.isPlaying();
            } catch (RemoteException e) {
            }
        }
        return false;
    }

    public static void addToCurrentPlaylist(Context context, long[] list) {
        if (sService != null) {
            try {
                sService.addToCurrentPlaylist(list, 3);
            } catch (RemoteException e) {
            }
        }
    }

    public static void playPlaylist(Context context, long plid) {
        long[] list = PlaylistHelper.getTrackListForPlaylist(context, plid, null);
        if (list != null) {
            playAll(context, list, -1, false, HistoryManager.LAST_HISTORY_SIZE);
        }
    }

    public static void shuffleAll(Context context, Cursor cursor) {
        playAll(context, cursor, 0, true);
    }

    public static void playHistory(Context context, int history) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        long[] queue = HistoryManager.load(sp, history);
        if (queue != null && queue.length >= 1) {
            long[] validIds = MediaProviderHelper.queryValidTrackIdArr(context);
            if (validIds != null && validIds.length >= 1) {
                int removeLen = 0;
                int i = 0;
                while (i < queue.length) {
                    if (!PlayerProvider.isOnlineAudio(queue[i]) && Arrays.binarySearch(validIds, queue[i]) < 0) {
                        queue[i] = -1;
                        removeLen++;
                    }
                    i++;
                }
                if (removeLen > 0) {
                    if (removeLen >= queue.length) {
                        playAll(context, validIds, 0, true, HistoryManager.LAST_HISTORY_SIZE);
                        return;
                    }
                    long[] remain = new long[(queue.length - removeLen)];
                    long[] arr$ = queue;
                    int len$ = arr$.length;
                    int i$ = 0;
                    int i2 = 0;
                    while (i$ < len$) {
                        long id = arr$[i$];
                        if (id >= 0) {
                            i = i2 + 1;
                            remain[i2] = id;
                        } else {
                            i = i2;
                        }
                        i$++;
                        i2 = i;
                    }
                    queue = remain;
                }
                playAll(context, queue, HistoryManager.loadPostion(sp, history), false, history);
            }
        }
    }

    public static void playAll(Context context, Cursor cursor) {
        playAll(context, cursor, -1, isShuffle());
    }

    public static void playAll(Context context, Cursor cursor, int position) {
        playAll(context, cursor, position, false);
    }

    public static void playAll(Context context, long[] list, int position) {
        playAll(context, list, position, false, HistoryManager.LAST_HISTORY_SIZE);
    }

    private static void playAll(Context context, Cursor cursor, int position, boolean forceShuffle) {
        playAll(context, SqlUtils.getIdsForCursor(cursor, PlayerProviderUtils.guessAudioIdColumnIndex(cursor)), position, forceShuffle, HistoryManager.LAST_HISTORY_SIZE);
    }

    private static void playAll(Context context, long[] list, int position, boolean forceShuffle, int history) {
        playAll(context, list, position, forceShuffle, history, false, true, null);
    }

    private static void playAll(Context context, long[] list, int position, boolean forceShuffle, int history, boolean directly, boolean startUI, String channelName) {
        if (sService != null) {
            try {
                sService.playAll(list, position, forceShuffle, history, directly, channelName);
                if (startUI) {
                    context.startActivity(new Intent("com.miui.player.PLAYBACK_VIEWER").setFlags(67108864));
                }
            } catch (RemoteException e) {
            }
        }
    }

    public static void playAll(Context context, Collection<Audio> audioList, String provider, int position, boolean append, boolean forceShuffle) {
        playAll(context, audioList, provider, position, append, forceShuffle, null);
    }

    public static void playAll(Context context, Collection<Audio> audioList, String provider, int position, boolean append, boolean forceShuffle, String channelName) {
        if (CollectionHelper.isEmpty(audioList)) {
            Log.d(TAG, "attempt to play empty song list");
            Toast.makeText(context, context.getString(C0329R.string.emptyplaylist, new Object[]{Integer.valueOf(audioList.size())}), 0).show();
            return;
        }
        ArrayList<Audio> audioArrayList;
        if (audioList instanceof ArrayList) {
            audioArrayList = (ArrayList) audioList;
        } else {
            audioArrayList = Lists.newArrayList();
            audioArrayList.addAll(audioList);
        }
        Intent intent = new Intent(In.ACTION_OPEN_LIST);
        intent.putExtra("audio_list", audioArrayList);
        intent.putExtra(In.KEY_PROVIDER, provider);
        intent.putExtra("position", position);
        intent.putExtra("music_meta_append", append);
        intent.putExtra(In.KEY_FORCE_SHUFFLE, forceShuffle);
        intent.putExtra("channel_name", channelName);
        context.startService(intent);
    }

    public static void togglePause() {
        if (sService != null) {
            try {
                if (sService.isPlaying()) {
                    sService.pause();
                } else {
                    sService.play();
                }
            } catch (RemoteException e) {
            }
        }
    }

    public static void pause() {
        if (sService != null) {
            try {
                sService.pause();
            } catch (RemoteException e) {
            }
        }
    }

    public static int recoverQueue(long[] validTrackIds) {
        if (sService == null) {
            return 0;
        }
        try {
            long[] queue = sService.getQueue();
            if (queue == null || queue.length <= 0) {
                return 0;
            }
            int j = 0;
            int[] removeIdxArr = new int[queue.length];
            long[] arr$ = queue;
            int len$ = arr$.length;
            int i$ = 0;
            int i = 0;
            while (i$ < len$) {
                int i2;
                long track = arr$[i$];
                if (PlayerProvider.isOnlineAudio(track) || Arrays.binarySearch(validTrackIds, track) >= 0) {
                    i2 = i;
                } else {
                    i2 = i + 1;
                    removeIdxArr[i] = j;
                }
                j++;
                i$++;
                i = i2;
            }
            if (i <= 0) {
                return 0;
            }
            if (i < removeIdxArr.length) {
                removeIdxArr[i] = -1;
            }
            return removeQueueTracksBatch(removeIdxArr);
        } catch (RemoteException e) {
            return 0;
        }
    }

    public static void clearQueue() {
        try {
            if (sService != null) {
                sService.removeTracks(0, Integer.MAX_VALUE);
            }
        } catch (RemoteException e) {
        }
    }

    public static int removeQueueTracksBatch(int[] posArr) {
        try {
            if (sService != null) {
                return sService.removeTracksBatch(posArr);
            }
        } catch (RemoteException e) {
        }
        return 0;
    }

    public static int removeQueueTracks(int first, int last) {
        try {
            if (sService != null) {
                return sService.removeTracks(first, last);
            }
        } catch (RemoteException e) {
        }
        return 0;
    }

    public static int removeQueueItem(long id) {
        try {
            if (sService != null) {
                return sService.removeTrack(id);
            }
        } catch (RemoteException e) {
        }
        return 0;
    }

    public static boolean moveQueueItem(int from, int to) {
        try {
            if (sService != null) {
                sService.moveQueueItem(from, to);
            }
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public static boolean scanFiles(Context context, String[] paths, String[] mimeTypes) {
        try {
            if (sService != null) {
                sService.scanFiles(paths, mimeTypes);
            } else {
                Intent i = new Intent(context, MediaPlaybackService.class);
                i.setAction(In.UPDATE_ID3_STATE);
                i.putExtra(In.TRACKPATH, paths[0]);
                context.startService(i);
            }
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public static void quitMediaPlay(Context context) {
        quitMediaPlay(context, true);
    }

    public static void quitMediaPlay(Context context, boolean enableDelay) {
        if (sService != null) {
            try {
                sService.quit(enableDelay);
            } catch (RemoteException e) {
            }
        } else {
            context.sendBroadcast(new Intent(In.QUIT_ACTION));
        }
        SleepModeManager.deleteTimer(context);
    }

    public static int getUpdateVersion() {
        int version = 0;
        if (sService != null) {
            try {
                version = sService.getUpdateVersion();
            } catch (RemoteException e) {
            }
        }
        return version;
    }

    static void registerMediaButtonReceiver(Context context) {
        ((AudioManager) context.getSystemService("audio")).registerMediaButtonEventReceiver(new ComponentName(context.getPackageName(), MediaButtonIntentReceiver.class.getName()));
    }

    static void unregisterMediaButtonReceiver(Context context) {
        ((AudioManager) context.getSystemService("audio")).unregisterMediaButtonEventReceiver(new ComponentName(context.getPackageName(), MediaButtonIntentReceiver.class.getName()));
    }
}
