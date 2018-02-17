package cn.ldm.player.activities;

import android.app.ActivityManager;
import android.app.Fragment;
import android.content.ComponentName;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import cn.ldm.player.R;
import cn.ldm.player.core.MediaItemFactory;
import cn.ldm.player.fragments.LocalMusicListFragment;
import cn.ldm.player.fragments.LocalVideoFragment;
import cn.ldm.player.fragments.WebMusicFragment;
import cn.ldm.player.services.MyMediaBrowserService;

public class ContainerActivity extends PermissionActivity implements NavigationView.OnNavigationItemSelectedListener,
        LocalMusicListFragment.InteractionListener,
        WebMusicFragment.OnFragmentInteractionListener {

    private static final String TAG = ContainerActivity.class.getSimpleName();


    private static final String FRAGMENT_TAG = "fragment-tag";
    protected NavigationView navigationView;
    private MediaBrowser _mediaBrowser;
    private MediaBrowser.MediaItem _localMusicRootMediaItem = MediaItemFactory.ROOT;

    @IdRes
    private int FRAGMENT_CONTAINER = R.id.container;

    @IdRes
    protected int MENU_LOCAL_MUSIC = R.id.nav_local_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        //region ...
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //endregion

        if (isPermissionPassed) {
            Log.i(TAG, "onCreate: 权限已全部取得");
            initAppAfterRequestPermission();
        }
    }

    public void initAppAfterRequestPermission() {
        //region 定义媒体浏览服务连接回调
        _mediaBrowser = new MediaBrowser(this, new ComponentName(this, MyMediaBrowserService.class),
                new MediaBrowser.ConnectionCallback() {
                    @Override
                    public void onConnected() {
                        //region 尽快设置媒体控制器
                        MediaController mediaController = new MediaController(ContainerActivity.this, _mediaBrowser.getSessionToken());
                        mediaController.registerCallback(new MediaController.Callback() {
                            @Override
                            public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                                //                                updateMetadata(metadata);
                            }

                            @Override
                            public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                                //                                updateUiState();
                            }

                            @Override
                            public void onQueueChanged(@Nullable List<MediaSession.QueueItem> queue) {
                                Log.i(TAG, "onQueueChanged: ");
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
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.i(TAG, "onAttachFragment: ");
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getFragmentManager().getBackStackEntryCount() > 0 || doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }else {
                PlaybackState playbackState = getMediaController().getPlaybackState();
                if (playbackState == null) {
                    getMediaBrowser().disconnect();
                } else if (playbackState.getState() == PlaybackState.STATE_STOPPED) {
                    getMediaBrowser().disconnect();
                } else {
                    Log.i(TAG, "onStop: 无需断开连接,且将应用退至后台");
                    moveTaskToBack(true);
                }
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.container, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_local_music) {
            if (getFragmentManager().getBackStackEntryCount() > 0) {
                getFragmentManager().popBackStackImmediate();//弹出B
            } else if (!item.isChecked()) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, LocalMusicListFragment.newInstance(MediaItemFactory.ROOT))
                        //                        .addToBackStack(null)
                        .commit();
                item.setChecked(true);
            }
        } else if (id == R.id.nav_web_music) {
            if (!item.isChecked()) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, WebMusicFragment.newInstance())
                        //                        .addToBackStack(null)
                        .commit();
            }
        } else if (id == R.id.nav_local_video) {
            if (!item.isChecked()) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, LocalVideoFragment.newInstance())
                        //                        .addToBackStack(null)
                        .commit();
            }

        } else if (id == R.id.nav_web_video) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void localMusicFragmentONStart() {
        navigationView.getMenu().findItem(R.id.nav_local_music).setChecked(true);
    }
}
