package com.songbirdnest.mediaplayer.activities;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.MediaController;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.widgets.FoVideoView;
import com.songbirdnest.util.MediaUtils;

public class ViewVideo extends Activity {
    private static final String VIEW_ANALYTICS_BASE_URI = "/videos/view/";
    int audioID = -1;
    boolean complete = false;
    MediaController control;
    boolean dropOut = false;
    private Integer fileID;
    int[] idList;
    boolean intentSent = false;
    int locationID = -1;
    boolean playing = true;
    final String[] proj = new String[]{"_data"};
    final String selection = "_id=?";
    FoVideoView vv;

    class C01531 implements OnCompletionListener {
        C01531() {
        }

        public void onCompletion(MediaPlayer mp) {
            Editor edit = ViewVideo.this.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
            edit.putInt(PrefKeys.VIDEO_POSITION, 0);
            edit.putInt(PrefKeys.VIDEO_ID, ViewVideo.this.fileID.intValue());
            edit.commit();
            ViewVideo.this.complete = true;
            ViewVideo.this.nextVideo();
        }
    }

    class C01542 implements OnClickListener {
        C01542() {
        }

        public void onClick(View v) {
            ViewVideo.this.nextVideo();
        }
    }

    class C01553 implements OnClickListener {
        C01553() {
        }

        public void onClick(View v) {
            if (ViewVideo.this.vv.getCurrentPosition() < 5000) {
                if (ViewVideo.this.locationID != 0) {
                    ViewVideo viewVideo = ViewVideo.this;
                    viewVideo.locationID--;
                }
                ViewVideo.this.changePlaying(ViewVideo.this.locationID);
                return;
            }
            ViewVideo.this.vv.seekTo(0);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.gc();
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if (i.getAction() == null || !i.getAction().equals("android.intent.action.VIEW")) {
            this.fileID = Integer.valueOf(extras.getInt("videofilename"));
            this.idList = extras.getIntArray("idList");
        } else {
            this.fileID = Integer.valueOf(getIDfromURI(i.getData()));
            this.idList = new int[0];
        }
        if (savedInstanceState != null) {
            this.playing = savedInstanceState.getBoolean("playing");
            this.audioID = savedInstanceState.getInt("audioID");
        }
        if (VERSION.SDK_INT >= 9 && this.audioID == -1) {
            this.audioID = new MediaPlayer().getAudioSessionId();
        }
        setContentView(C0116R.layout.video_layout);
        this.vv = (FoVideoView) findViewById(C0116R.id.video_view_video);
        this.control = new MediaController(this);
        this.vv.setMediaController(this.control);
        this.vv.setOnCompletionListener(new C01531());
        this.vv.requestFocus();
        this.locationID = getCurrentLocation();
        Analytics.getAnalytics().track(VIEW_ANALYTICS_BASE_URI);
        this.control.setPrevNextListeners(new C01542(), new C01553());
    }

    private void nextVideo() {
        if (this.locationID == this.idList.length - 1) {
            finish();
            return;
        }
        this.complete = false;
        this.locationID++;
        changePlaying(this.locationID);
    }

    private int getIDfromURI(Uri uri) {
        Cursor findCursor = MediaUtils.getMediaStoreMergeCursorForVideo(this, new String[]{"_id", "_data"}, "_data = ?", new String[]{getRealPathFromURI(uri)}, true);
        findCursor.moveToFirst();
        int targetID = findCursor.getInt(findCursor.getColumnIndexOrThrow("_id"));
        findCursor.close();
        return targetID;
    }

    private String getRealPathFromURI(Uri contentUri) {
        Cursor cursor = managedQuery(contentUri, new String[]{"_data"}, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    private void runAction() {
        Intent intent = Utils.getPhilipsIntent(true, this.audioID, false);
        if (!Utils.containsGingerPackage(intent, getPackageManager()) || this.intentSent) {
            this.intentSent = true;
            if (this.playing) {
                this.vv.start();
                return;
            } else {
                this.control.show(FacebookAPI.FACEBOOK_AUTHORIZE_RESULT_CODE);
                return;
            }
        }
        this.intentSent = true;
        this.dropOut = true;
        startActivityForResult(intent, 1);
    }

    private void changePlaying(int location) {
        this.vv.stopPlayback();
        this.fileID = Integer.valueOf(this.idList[location]);
        Cursor mCursor = MediaUtils.getMediaStoreMergeCursorForVideo(this, this.proj, "_id=?", new String[]{Integer.toString(this.fileID.intValue())}, true);
        mCursor.moveToFirst();
        if (this.audioID != -1 && VERSION.SDK_INT >= 9) {
            this.vv.setAudioSessionID(this.audioID);
        }
        this.vv.setVideoPath(mCursor.getString(mCursor.getColumnIndexOrThrow("_data")));
        runAction();
        Analytics.getAnalytics().track(VIEW_ANALYTICS_BASE_URI);
    }

    private int getCurrentLocation() {
        for (int i = 0; i < this.idList.length; i++) {
            if (this.idList[i] == this.fileID.intValue()) {
                return i;
            }
        }
        return -1;
    }

    protected void onResume() {
        super.onResume();
        if (this.playing) {
            runAction();
            Cursor mCursor = MediaUtils.getMediaStoreMergeCursorForVideo(this, this.proj, "_id=?", new String[]{Integer.toString(this.fileID.intValue())}, true);
            mCursor.moveToFirst();
            String filename = mCursor.getString(mCursor.getColumnIndexOrThrow("_data"));
            if (this.audioID != -1) {
                this.vv.setAudioSessionID(this.audioID);
            }
            this.vv.setVideoPath(filename);
            SharedPreferences pref = getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
            if (pref.getInt(PrefKeys.VIDEO_ID, -1) == this.fileID.intValue()) {
                this.vv.seekTo(pref.getInt(PrefKeys.VIDEO_POSITION, 0));
            }
            getWindow().setFlags(1024, 1024);
            return;
        }
        this.dropOut = true;
        finish();
    }

    public boolean onCreateOptionsMenu(Menu aMenu) {
        getMenuInflater().inflate(C0116R.menu.default_menu, aMenu);
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.playing = true;
        this.dropOut = false;
    }

    public boolean onOptionsItemSelected(MenuItem aItem) {
        switch (aItem.getItemId()) {
            case C0116R.id.menu_about:
                startActivity(new Intent(this, About.class));
                break;
            case C0116R.id.menu_preferences:
                Intent i = new Intent(this, Preferences.class);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.philips.sound", "com.philips.sound.Setting"));
                if (VERSION.SDK_INT >= 9 && getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
                    i.putExtra("mediaid", this.vv.getAudioSessionID());
                }
                startActivity(i);
                break;
            default:
                return false;
        }
        return true;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("playing", this.playing);
        outState.putInt("audioID", this.audioID);
    }

    protected void onPause() {
        super.onPause();
        if (!this.dropOut || !this.intentSent) {
            Editor edit = getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
            if (this.complete) {
                edit.putInt(PrefKeys.VIDEO_POSITION, 0);
            } else {
                edit.putInt(PrefKeys.VIDEO_POSITION, this.vv.getCurrentPosition());
            }
            edit.putInt(PrefKeys.VIDEO_ID, this.fileID.intValue());
            edit.commit();
            if (this.vv.isPlaying()) {
                this.playing = true;
            } else {
                this.playing = false;
            }
            this.vv.stopPlayback();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 84) {
            Intent i = new Intent(this, ContentBrowser.class);
            i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, "Search");
            startActivity(i);
        }
        return super.onKeyDown(keyCode, event);
    }
}
