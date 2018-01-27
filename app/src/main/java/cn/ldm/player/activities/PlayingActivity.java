package cn.ldm.player.activities;

import android.app.Activity;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;

import cn.ldm.player.R;
import cn.ldm.player.fragments.PlayingFragment;
import cn.ldm.player.model.SongInfo;

public class PlayingActivity extends Activity implements PlayingFragment.InteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        getFragmentManager().beginTransaction().replace(R.id.container, PlayingFragment.newInstance()).commit();
    }

    @Override
    public MediaSession.Token getMediaSessionToken() {
        return null;
    }
}
