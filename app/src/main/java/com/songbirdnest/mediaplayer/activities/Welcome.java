package com.songbirdnest.mediaplayer.activities;

import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.PrefKeys;

public class Welcome extends Activity {

    class C01561 implements OnClickListener {
        C01561() {
        }

        public void onClick(View v) {
            Editor editor = Welcome.this.getSharedPreferences(PrefKeys.sMediaPlayerPrefs, 0).edit();
            editor.putBoolean(PrefKeys.sFirstRun, false);
            editor.putString(PrefKeys.sVersion, Welcome.this.getString(C0116R.string.core_version));
            editor.commit();
            Welcome.this.finish();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0116R.layout.welcome);
        findViewById(C0116R.id.welcome_continue).setOnClickListener(new C01561());
        Analytics.getAnalytics().track(Analytics.EVENT_WELCOME);
    }
}
