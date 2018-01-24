package cn.ldm.player;

import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import cn.ldm.player.activities.PermissionActivity;
import cn.ldm.player.core.MediaItemFactory;
import cn.ldm.player.fragments.MediaBrowserFragment;
import cn.ldm.player.services.MyMediaBrowserService;

public class MainActivity extends PermissionActivity implements MediaBrowserFragment.InteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String FRAGMENT_TAG = "fragment-tag";
    private MediaBrowser _mediaBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaBrowserFragment fragment = (MediaBrowserFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (fragment == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.container, MediaBrowserFragment.newInstance(MediaItemFactory.ROOT), FRAGMENT_TAG);
            transaction.commit();
        }
        _mediaBrowser = new MediaBrowser(this, new ComponentName(this, MyMediaBrowserService.class),
                new MediaBrowser.ConnectionCallback() {
                    @Override
                    public void onConnected() {
                        MediaController mediaController = new MediaController(MainActivity.this, _mediaBrowser.getSessionToken());
                        mediaController.registerCallback(new MediaController.Callback() {
                            @Override
                            public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                                super.onMetadataChanged(metadata);
                                Log.i(TAG, "onMetadataChanged: "+metadata.getDescription().getTitle());
                            }

                            @Override
                            public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                                super.onPlaybackStateChanged(state);
                                Log.i(TAG, "onPlaybackStateChanged: ");
                            }
                        });
                        setMediaController(mediaController);
                    }
                },
                null
        );
    }


    @Override
    public void initAppAfterRequestPermission() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        _mediaBrowser.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        _mediaBrowser.disconnect();
    }

    @Override
    public MediaBrowser getMediaBrowser() {
        return _mediaBrowser;
    }


}
