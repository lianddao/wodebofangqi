package cn.ldm.player;

import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.os.Bundle;

import cn.ldm.player.activities.PermissionActivity;
import cn.ldm.player.core.MediaItemFactory;
import cn.ldm.player.fragments.MediaBrowserFragment;
import cn.ldm.player.services.MyMediaBrowserService;

public class MainActivity extends PermissionActivity implements MediaBrowserFragment.InteractionListener {

    private String FRAGMENT_TAG = "fragment-tag";
    private MediaBrowser mMediaBrowser;
    private MediaController mMediaController;

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
        mMediaBrowser = new MediaBrowser(this, new ComponentName(this, MyMediaBrowserService.class), new MediaBrowser.ConnectionCallback() {
            @Override
            public void onConnected() {
                mMediaController = new MediaController(MainActivity.this, mMediaBrowser.getSessionToken());
                setMediaController(mMediaController);
            }
        }, null);
    }


    @Override
    public void initAppAfterRequestPermission() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mMediaBrowser.connect();
    }

    @Override
    protected void onStop() {
        mMediaBrowser.disconnect();
        super.onStop();
    }

    @Override
    public MediaBrowser getmMediaBrowser() {
        return mMediaBrowser;
    }

}
