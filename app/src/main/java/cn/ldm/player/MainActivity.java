package cn.ldm.player;

import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.ldm.player.activities.PermissionActivity;
import cn.ldm.player.activities.PlayingActivity;
import cn.ldm.player.core.MediaItemFactory;
import cn.ldm.player.core.MusicScanner;
import cn.ldm.player.fragments.MusicListFragment;
import cn.ldm.player.fragments.PlayingFragment;
import cn.ldm.player.model.SongInfo;
import cn.ldm.player.services.MyMediaBrowserService;

public class MainActivity extends PermissionActivity implements MusicListFragment.InteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String FRAGMENT_TAG = "fragment-tag";
    private MediaBrowser _mediaBrowser;
    private ImageView imgAlbum, imgPlayPause, imgNext;
    private TextView txtTitle, txtSubtitle;
    private SongInfo _currentSong;

    @IdRes
    private int FRAGMENT_CONTAINER = R.id.container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgAlbum = (ImageView) findViewById(R.id.imgAlbum);
        imgPlayPause = (ImageView) findViewById(R.id.imgPlayPause);
        imgNext = (ImageView) findViewById(R.id.imgNext);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtSubtitle = (TextView) findViewById(R.id.txtSubtitle);
        if (isPermissionPassed) {
            Log.i(TAG, "onCreate: 权限已全部取得");
            initAppAfterRequestPermission();
        }
    }

    // TODO: 2018.02.07.0007 ①延时停止服务,②可取消的通知栏,③加入网络歌曲,④加入抽屉用于视频板块

    public void initAppAfterRequestPermission() {
        //region 单击事件
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
                    case PlaybackState.STATE_STOPPED:
                        getMediaController().getTransportControls().playFromMediaId(_currentSong.getId(), null);
                        break;
                    default:
                        break;
                }
                updateUiState();
            }
        });

        imgAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaController mediaController = getMediaController();
                MediaMetadata metadata = mediaController.getMetadata();
                _currentSong = SongInfo.make(metadata);
                Log.i(TAG, "onClick: " + _currentSong.toString());
                Intent intent = new Intent(MainActivity.this, PlayingActivity.class);
                intent.putExtra("token", _mediaBrowser.getSessionToken());
                startActivity(intent);
            }
        });

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMediaController().getTransportControls().skipToNext();
            }
        });
        //endregion
        //region 连接到媒体浏览服务
        _mediaBrowser = new MediaBrowser(this, new ComponentName(this, MyMediaBrowserService.class),
                new MediaBrowser.ConnectionCallback() {
                    @Override
                    public void onConnected() {
                        //region 装入主片段.时机在服务连接成功之后.
                        MusicListFragment fragment = (MusicListFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
                        if (fragment == null) {
                            Log.i(TAG, "initAppAfterRequestPermission: 加入片段");
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(FRAGMENT_CONTAINER, MusicListFragment.newInstance(MediaItemFactory.ROOT), FRAGMENT_TAG);
                            transaction.commit();
                        }
                        //endregion
                        MediaController mediaController = new MediaController(MainActivity.this, _mediaBrowser.getSessionToken());
                        mediaController.registerCallback(new MediaController.Callback() {
                            @Override
                            public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                                updateMetadata(metadata);
                            }

                            @Override
                            public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                                updateUiState();
                            }
                        });
                        setMediaController(mediaController);
                    }
                },
                null
        );
        //endregion
    }


    private void updateMetadata(final MediaMetadata metadata) {
        SongInfo songInfo = SongInfo.make(metadata);
        Bitmap bitmap = MusicScanner.getInstance(MainActivity.this).retrieveAlbumArt(metadata);
        if (bitmap == null) bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_report_image);
        imgAlbum.setImageBitmap(bitmap);
        txtTitle.setText(songInfo.getTitle());
        txtSubtitle.setText(songInfo.getSubtitle());
    }

    private void updateUiState() {
        PlaybackState state = getMediaController().getPlaybackState();
        Log.i(TAG, "updateUiState: " + state.toString());
        switch (state.getState()) {
            case PlaybackState.STATE_PAUSED:
            case PlaybackState.STATE_STOPPED:
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
    protected void onStart() {
        super.onStart();
        if (_mediaBrowser == null) {
            return;
        }
        if (_mediaBrowser.isConnected()) {
            Log.i(TAG, "onStart: 已连接");
        } else {
            _mediaBrowser.connect();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (_mediaBrowser != null) {
            //            _mediaBrowser.disconnect();
            Log.w(TAG, "onStop: 应始终保持媒体浏览器的连接,否则按 HONE 键将会使服务被销毁,从而也会从通知栏消失");
        }
    }

    @Override
    public MediaBrowser getMediaBrowser() {
        return _mediaBrowser;
    }

    @Override
    public void localMusicFragmentOnStopCall(MediaBrowser.MediaItem mediaItem) {

    }

    @Override
    public void localMusicFragmentONStart() {

    }

    public MediaController getMediaSession() {return getMediaController();}
}
