package cn.ldm.player.tool;

import android.media.MediaMetadata;

/**
 * Created by LDM on 2017.12.17.0017.
 */

public class MusicTool {

    /**
     * 获取时间的直观显示
     *
     * @param mediaMetadata
     * @return
     */
    public static String getDisplayTime(MediaMetadata mediaMetadata) {
        long duration = mediaMetadata.getLong(MediaMetadata.METADATA_KEY_DURATION);
        int seconds = (int) (duration % 60000) / 1000;
        int minutes = (int) duration / 60000;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
