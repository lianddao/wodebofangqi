package cn.ldm.player.activities;

import android.content.ComponentName;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import cn.ldm.player.core.MediaItemFactory;
import cn.ldm.player.fragments.LocalMusicListFragment;
import cn.ldm.player.fragments.WebMusicFragment;
import cn.ldm.player.services.MyMediaBrowserService;

public class LocalMusicActivity extends ContainerActivity
        implements
        LocalMusicListFragment.InteractionListener,
        WebMusicFragment.OnFragmentInteractionListener {

    private static final String TAG = LocalMusicActivity.class.getSimpleName();
    private MediaBrowser _mediaBrowser;
    private MediaBrowser.MediaItem _localMusicRootMediaItem = MediaItemFactory.ROOT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initAppAfterRequestPermission() {
        //region 定义媒体浏览服务连接回调
        _mediaBrowser = new MediaBrowser(this, new ComponentName(this, MyMediaBrowserService.class),
                new MediaBrowser.ConnectionCallback() {
                    @Override
                    public void onConnected() {
                        //region 尽快设置媒体控制器
                        MediaController mediaController = new MediaController(LocalMusicActivity.this, _mediaBrowser.getSessionToken());
                        mediaController.registerCallback(new MediaController.Callback() {
                            @Override
                            public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                                //                                updateMetadata(metadata);
                            }

                            @Override
                            public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                                //                                updateUiState();
                            }
                        });
                        setMediaController(mediaController);
                        //endregion
                        Log.i(TAG, "onConnected: ");
                        onNavigationItemSelected(navigationView.getMenu().findItem(MENU_LOCAL_MUSIC));//默认显示本地音乐
                    }
                },
                null
        );
        //endregion
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (_mediaBrowser.isConnected()) {
            Log.i(TAG, "onStart: 媒体浏览器已连接");
        } else {
            _mediaBrowser.connect();
            Log.i(TAG, "onStart: 媒体浏览器开始连接");
        }
    }

    @Override
    public MediaBrowser getMediaBrowser() {
        return _mediaBrowser;
    }

    @Override
    public void localMusicFragmentOnStopCall(MediaBrowser.MediaItem mediaItem) {
        _localMusicRootMediaItem = mediaItem;
        Log.i(TAG, "localMusicFragmentOnStopCall: " + mediaItem.getMediaId() + "," + mediaItem.getDescription().getTitle());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
