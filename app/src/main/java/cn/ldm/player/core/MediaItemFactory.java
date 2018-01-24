package cn.ldm.player.core;

import android.media.MediaDescription;
import android.media.browse.MediaBrowser;


public class MediaItemFactory {

    private static final String MEDIA_ID_ROOT = "__ROOT__";

    public final static MediaBrowser.MediaItem ROOT = new MediaBrowser.MediaItem(
            new MediaDescription.Builder().setMediaId(MEDIA_ID_ROOT).build(),
            MediaBrowser.MediaItem.FLAG_BROWSABLE);
}
