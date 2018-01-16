package cn.ldm.player.tool;


import android.provider.MediaStore;

/**
 * 定义此包范围中的常量
 */
public class ToolConfig {

    public static final String MUSIC_ONLY_SELECTION =
            MediaStore.Audio.AudioColumns.IS_MUSIC + "=1" + " AND " + MediaStore.Audio.AudioColumns.TITLE + " != ''";

    public static final String VOLUME_EXTERNAL = "external", VOLUME_INTERNAL = "internal";
}
