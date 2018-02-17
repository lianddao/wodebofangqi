package cn.ldm.player.activities;

import android.app.Activity;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.util.Log;

import cn.ldm.player.R;
import cn.ldm.player.fragments.PlayingFragment;
import cn.ldm.player.model.SongInfo;
import cn.ldm.player.ui.MediaSeekBar;

public class PlayingActivity extends Activity {

    private static final String TAG = PlayingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        MediaSession.Token token = (MediaSession.Token) getIntent().getParcelableExtra("token");
        MediaController mediaController = new MediaController(this, token);
        setMediaController(mediaController);
        getFragmentManager().beginTransaction().replace(R.id.container, PlayingFragment.newInstance()).commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: 停止动画");
    }
}
