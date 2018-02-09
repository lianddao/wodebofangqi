package cn.ldm.player.activities;

import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import cn.ldm.player.R;
import cn.ldm.player.core.MediaItemFactory;
import cn.ldm.player.fragments.MusicListFragment;
import cn.ldm.player.fragments.WebMusicFragment;
import cn.ldm.player.services.MyMediaBrowserService;

public class ContainerActivity extends PermissionActivity implements NavigationView.OnNavigationItemSelectedListener,
        MusicListFragment.InteractionListener,
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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
                        .replace(R.id.container, MusicListFragment.newInstance(MediaItemFactory.ROOT))
                        //                        .addToBackStack(null)
                        .commit();
                item.setChecked(true);
            }
        } else if (id == R.id.nav_web_music) {
            if (!item.isChecked()) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, WebMusicFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private MenuItem currentMenuItem;

    @Override
    public void localMusicFragmentONStart() {
        navigationView.getMenu().findItem(R.id.nav_local_music).setChecked(true);
    }
}
