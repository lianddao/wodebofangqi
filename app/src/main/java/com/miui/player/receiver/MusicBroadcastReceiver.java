package com.miui.player.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.miui.player.PlayerActions.In;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.plugin.onlinemusic2.baidu.BaiduWorker;
import com.miui.player.ui.base.ApplicationHelper;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.impl.parser.SongListParser;
import com.xiaomi.music.online.model.SongList;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.Numbers;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicBroadcastReceiver extends BroadcastReceiver {
    private static final String KEY_LIST_ID = "list_id";
    private static final String KEY_POSITION = "position";
    private static final String KEY_SONG_INFO = "song_info_list";
    private static final String TAG = "MusicBroadcastReceiver";

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        MusicLog.m395d(TAG, "action=" + action);
        if (action != null) {
            if (In.ACTION_DISPLAY_SONG_GROUP.equals(action)) {
                String songGroupId = intent.getStringExtra(KEY_LIST_ID);
                MusicLog.m395d(TAG, "songGroudId=" + songGroupId);
                if (songGroupId != null) {
                    context.startService(new Intent(context, ApplicationHelper.instance().getServiceClass()));
                    Intent viewIntent = new Intent(In.ACTION_MUSIC_ONLINE_GROUP_VIEW_ENTRY);
                    viewIntent.putExtra(In.KEY_GROUP_ID, songGroupId);
                    viewIntent.setFlags(268435456);
                    context.startActivity(viewIntent);
                }
            } else if (In.ACTION_PLAYBACK_SONGS.equals(action)) {
                String songInfo = intent.getStringExtra(KEY_SONG_INFO);
                if (songInfo == null) {
                    MusicLog.m404w(TAG, "empty list");
                    return;
                }
                int position = Numbers.toInt(intent.getStringExtra("position"), 0);
                try {
                    SongList songList = new SongListParser().parse(new JSONObject(songInfo));
                    if (songList == null || songList.size() <= 0) {
                        MusicLog.m399i(TAG, "song list is empty!");
                        return;
                    }
                    AudioList list = BaiduWorker.songListResultToAudioList(Result.create(1, songList));
                    Intent playIntent = new Intent(In.ACTION_MUSIC_ONLINE_PLAY_ENTRY);
                    playIntent.putExtra("position", position);
                    playIntent.putExtra("audio_list", list);
                    playIntent.setFlags(268435456);
                    context.startActivity(playIntent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
