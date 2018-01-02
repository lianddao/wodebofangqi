package com.songbirdnest.mediaplayer.activities;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.SongbirdApplication;

public class About extends Activity {
    ActivityOrientationHelper mOrientationHelper;

    class C01281 implements OnClickListener {
        C01281() {
        }

        public void onClick(View v) {
            About.this.finish();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(C0116R.layout.about);
        ((TextView) findViewById(C0116R.id.version_text)).setText(getVersionString(this));
        OnClickListener clickListener = new C01281();
        ((RelativeLayout) findViewById(C0116R.id.about_main)).setOnClickListener(clickListener);
        ((Button) findViewById(C0116R.id.about_continue)).setOnClickListener(clickListener);
        TextView aAboutCopyright = (TextView) findViewById(C0116R.id.about_copyright);
        String aAboutFormat = getResources().getString(C0116R.string.about_copyright);
        String aAboutYear = getResources().getString(C0116R.string.about_copyright_year);
        aAboutCopyright.setText(String.format(aAboutFormat, new Object[]{aAboutYear}));
        Analytics.getAnalytics().track(Analytics.EVENT_ABOUT);
        this.mOrientationHelper = new ActivityOrientationHelper(this);
        super.onCreate(savedInstanceState);
    }

    protected void onResume() {
        super.onResume();
        this.mOrientationHelper.onResume();
        ((SongbirdApplication) getApplication()).pegActivity();
    }

    protected void onPause() {
        super.onPause();
        this.mOrientationHelper.onPause();
        ((SongbirdApplication) getApplication()).dePegActivity();
    }

    public static String getVersionString(Context aContext) {
        String aboutVersion;
        try {
            aboutVersion = aContext.getString(C0116R.string.about_version, new Object[]{aContext.getPackageManager().getPackageInfo(aContext.getPackageName(), 0).versionName});
        } catch (NameNotFoundException e) {
            aboutVersion = aContext.getString(C0116R.string.about_version);
        }
        String buildNumber = aContext.getString(C0116R.string.build_number);
        String buildString = "";
        if (buildNumber != null && buildNumber.length() > 0) {
            buildString = "build " + buildNumber;
        }
        return aboutVersion + "  " + buildString;
    }
}
