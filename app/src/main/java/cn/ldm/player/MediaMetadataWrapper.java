package cn.ldm.player;

import android.media.MediaMetadata;

/**
 * 包装媒体元数据
 */

public class MediaMetadataWrapper {

    private static final String TAG = MediaMetadataWrapper.class.getSimpleName();
    private MediaMetadata _mediaMetadata;
    private Type _type;

    private MediaMetadataWrapper() {}

    public enum Type {
        LOCAL, WEB
    }

    public static MediaMetadataWrapper make(MediaMetadata metadata, Type type) {
        MediaMetadataWrapper obj = new MediaMetadataWrapper();
        obj._mediaMetadata = metadata;
        obj._type = type;
        return obj;
    }

    public MediaMetadata getMediaMetadata(){
        return _mediaMetadata;
    }

    public Type getType(){
        return _type;
    }
}
