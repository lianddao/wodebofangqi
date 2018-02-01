package cn.ldm.player.tool;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadata;
import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.widget.Toast;

import cn.ldm.player.R;

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

    public static String getDisplayTime(int time) {
        int seconds = time % 60000 / 1000;
        int minutes = time / 60000;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static int getSecond(long duration) {
        return (int) (duration % 60000) / 1000;
    }

}
