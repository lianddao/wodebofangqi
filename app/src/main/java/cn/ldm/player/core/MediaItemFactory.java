package cn.ldm.player.core;

import android.media.MediaDescription;
import android.media.browse.MediaBrowser;

import cn.ldm.player.services.MyMediaBrowserService;


public class MediaItemFactory {
    public final static MediaBrowser.MediaItem ROOT = new MediaBrowser.MediaItem(
            new MediaDescription.Builder().setMediaId(MyMediaBrowserService.MEDIA_ID_ROOT).build(),
            MediaBrowser.MediaItem.FLAG_BROWSABLE);
}
