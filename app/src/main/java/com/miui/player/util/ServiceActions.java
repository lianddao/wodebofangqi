package com.miui.player.util;

public interface ServiceActions {
    public static final String PREFIX = "com.miui.player";

    public interface In extends com.miui.player.PlayerActions.In {
        public static final String ACTION_OPEN_LIST = "com.miui.player.openlist";
        public static final String ACTION_REQUEST_FAVORITE = "com.miui.player.requestfavorite";
        public static final String CMDALBUM = "album";
        public static final String CMDBACKWARD = "backword";
        public static final String CMDFORWARD = "forward";
        public static final String CMDLYRIC = "lyric";
        public static final String CMDNAME = "command";
        public static final String CMDNEXT = "next";
        public static final String CMDPAUSE = "pause";
        public static final String CMDPLAY = "play";
        public static final String CMDPREVIOUS = "previous";
        public static final String CMDREPLAY = "replay";
        public static final String CMDSTOP = "stop";
        public static final String CMDTOGGLEPAUSE = "togglepause";
        public static final String CMDTRACK = "track";
        public static final String KEY_APPEND = "music_meta_append";
        public static final String KEY_AUDIO_LIST = "audio_list";
        public static final String KEY_CHANNEL_NAME = "channel_name";
        public static final String KEY_FORCE_SHUFFLE = "force_shuffle";
        public static final String KEY_POSITION = "position";
        public static final String KEY_PROVIDER = "provider";
        public static final String PAUSE_ACTION = "com.miui.player.musicservicecommand.pause";
        public static final String QUIT_ACTION = "com.miui.player.musicservicecommand.quit";
        public static final String SERVICECMD = "com.miui.player.musicservicecommand";
        public static final String TRACKPATH = "trackPath";
        public static final String UPDATE_ID3_STATE = "com.miui.player.updateid3state";
        public static final String UPDATE_META_ACTION = "com.miui.player.musicservicecommand.update_meta";
        public static final String UPDATE_SHAKE = "com.miui.player.updateshake";
    }

    public interface Mode {
        public static final int REPEAT_ALL = 0;
        public static final int REPEAT_COUNT = 3;
        public static final int REPEAT_CURRENT = 1;
        public static final int REPEAT_NONE = 2;
        public static final int SHUFFLE = 1;
        public static final int SHUFFLE_COUNT = 2;
        public static final int SHUFFLE_NONE = 0;
    }

    public static class OneShot {
        public static final String ACTION_METAINFO_CHANGED = "oneshot_metainfo_changed";
        public static final String ACTION_OPEN_UI = "com.miui.player.oneshot_open_ui";
        public static final String ACTION_PAUSE = "oneshot_pause";
        public static final String ACTION_PLAY = "oneshot_play";
        public static final String ACTION_PLAYSTATE_CHANGED = "oneshot_playstate_changed";
        public static final String ACTION_PLAY_ERROR = "oneshot_play_error";
        public static final String ACTION_PREPARED = "oneshot_prepared";
        public static final String ACTION_TOGGLEPAUSE = "oneshot_togglepause";
    }

    public interface Out extends com.miui.player.PlayerActions.Out {
        public static final String ACTION_RESPONSE_FAVORITE = "com.miui.player.responsefavorite";
        public static final String KEY_CHANGED_ID3 = "meta_changed_id3";
        public static final String KILL_PROCESS = "com.miui.player.kill_process";
    }

    public interface POSITION_ACTION {
        public static final int CLEAR = 4;
        public static final int LAST = 3;
        public static final int NEXT = 2;
        public static final int NOW = 1;
    }
}
