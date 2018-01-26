package cn.ldm.player;

import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.ldm.player.activities.PermissionActivity;
import cn.ldm.player.core.MediaItemFactory;
import cn.ldm.player.core.MusicScanner;
import cn.ldm.player.fragments.MediaBrowserFragment;
import cn.ldm.player.model.SongInfo;
import cn.ldm.player.services.MyMediaBrowserService;

public class MainActivity extends PermissionActivity implements MediaBrowserFragment.InteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String FRAGMENT_TAG = "fragment-tag";
    private MediaBrowser _mediaBrowser;
    private ImageView imgAlbum, imgPlayPause, imgNext;
    private TextView txtTitle, txtSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgAlbum = (ImageView) findViewById(R.id.imgAlbum);
        imgPlayPause = (ImageView) findViewById(R.id.imgPlayPause);
        imgNext = (ImageView) findViewById(R.id.imgNext);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtSubtitle = (TextView) findViewById(R.id.txtSubtitle);

        imgPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getMediaController().getPlaybackState().getState()) {
                    case PlaybackState.STATE_PAUSED:
                        getMediaController().getTransportControls().play();
                        break;
                    case PlaybackState.STATE_PLAYING:
                        getMediaController().getTransportControls().pause();
                        break;
                    default:
                        break;
                }
                updateState(getMediaController().getPlaybackState());
            }
        });

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
                                Log.i(TAG, "onMetadataChanged: " + metadata.getDescription().getTitle());
                                updateMetadata(metadata);
                            }

                            @Override
                            public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                                super.onPlaybackStateChanged(state);
                                Log.i(TAG, "onPlaybackStateChanged: ");
                                updateState(state);
                            }
                        });
                        setMediaController(mediaController);
                    }
                },
                null
        );
    }

    private void updateMetadata(final MediaMetadata metadata) {
        SongInfo songInfo = SongInfo.make(metadata);
        Bitmap bitmap = MusicScanner.getInstance(MainActivity.this).retrieveAlbumArt(metadata);
        if (bitmap == null) bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_report_image);
        imgAlbum.setImageBitmap(bitmap);
        txtTitle.setText(songInfo.getTitle());
        txtSubtitle.setText(songInfo.getSubtitle());
    }

    private void updateState(PlaybackState state) {
        Log.i(TAG, "updateState: " + state.toString());
        switch (state.getState()) {
            case PlaybackState.STATE_PAUSED:
                imgPlayPause.setImageResource(android.R.drawable.ic_media_play);
                break;
            case PlaybackState.STATE_PLAYING:
                imgPlayPause.setImageResource(android.R.drawable.ic_media_pause);
                break;
            default:
                imgPlayPause.setImageResource(android.R.drawable.ic_media_play);
                break;
        }
    }

    @Override
    public void initAppAfterRequestPermission() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (_mediaBrowser.isConnected()) {
            Log.i(TAG, "onStart: 已连接");
        } else {
            _mediaBrowser.connect();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        //        _mediaBrowser.disconnect();
        Log.w(TAG, "onStop: 应始终保持媒体浏览器的连接,否则按 HONE 键将会使服务被销毁,从而也会从通知栏消失");

    }

    @Override
    public MediaBrowser getMediaBrowser() {
        return _mediaBrowser;
    }


}
