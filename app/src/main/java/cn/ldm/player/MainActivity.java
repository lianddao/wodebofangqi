package cn.ldm.player;

import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.media.browse.MediaBrowser;
import android.os.Bundle;

import cn.ldm.player.activities.PermissionActivity;
import cn.ldm.player.core.MediaItemFactory;
import cn.ldm.player.fragments.MediaBrowserFragment;
import cn.ldm.player.services.MyMediaBrowserService;

public class MainActivity extends PermissionActivity implements MediaBrowserFragment.InteractionListener {

    private String FRAGMENT_TAG = "fragment-tag";
    private MediaBrowser mediaBrowser;

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
        mediaBrowser = new MediaBrowser(this, new ComponentName(this, MyMediaBrowserService.class), new MediaBrowser.ConnectionCallback(), null);
    }

    @Override
    public void initAppAfterRequestPermission() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaBrowser.connect();
    }

    @Override
    protected void onStop() {
        mediaBrowser.disconnect();
        super.onStop();
    }

    @Override
    public MediaBrowser getMediaBrowser() {
        return mediaBrowser;
    }

}
