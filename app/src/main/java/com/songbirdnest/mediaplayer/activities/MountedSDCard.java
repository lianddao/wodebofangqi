package com.songbirdnest.mediaplayer.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Songbird;
import com.songbirdnest.mediaplayer.SongbirdApplication;

public class MountedSDCard extends Activity {
    public static final String TAG = "MountedSDCard";
    private TextView mHeaderTextView = null;
    private ImageView mImageView = null;
    private TextView mMessageTextView = null;
    private BroadcastReceiver mReceiver = new C01431();
    private IntentFilter mReceiverFilter = null;

    class C01431 extends BroadcastReceiver {
        C01431() {
        }

        public void onReceive(Context aContext, Intent aIntent) {
            Log.d(MountedSDCard.TAG, "onReceive");
            String action = aIntent.getAction();
            if (action == null || !action.equals("android.intent.action.MEDIA_SCANNER_STARTED")) {
                Log.d(MountedSDCard.TAG, "onReceive: Scanner Finished Action " + action);
                Intent i = new Intent(MountedSDCard.this, Songbird.class);
                i.addFlags(335544320);
                MountedSDCard.this.startActivity(i);
                MountedSDCard.this.overridePendingTransition(C0116R.anim.slide_left, C0116R.anim.slide_right);
                return;
            }
            Log.d(MountedSDCard.TAG, "onReceive: Scanner Started");
            Resources res = MountedSDCard.this.getResources();
            MountedSDCard.this.mHeaderTextView.setText(res.getString(C0116R.string.sd_card_scanning));
            MountedSDCard.this.mImageView.setImageResource(C0116R.drawable.memory_card_busy);
            MountedSDCard.this.mMessageTextView.setText(res.getString(C0116R.string.sd_card_scanning_message));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        int headerTextId;
        int imageId;
        int messageTextId;
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(C0116R.layout.mounted_sd_card);
        this.mReceiverFilter = new IntentFilter("android.intent.action.MEDIA_SCANNER_FINISHED");
        this.mReceiverFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        this.mReceiverFilter.addDataScheme("file");
        this.mHeaderTextView = (TextView) findViewById(C0116R.id.mounted_sd_card_text);
        this.mMessageTextView = (TextView) findViewById(C0116R.id.mounted_sd_card_message);
        this.mImageView = (ImageView) findViewById(C0116R.id.mounted_sd_card_image);
        Resources res = getResources();
        String aCurrentState = Environment.getExternalStorageState();
        if (aCurrentState.equals("unmounted") || aCurrentState.equals("shared")) {
            headerTextId = C0116R.string.sd_card_busy;
            imageId = C0116R.drawable.memory_card_busy;
            messageTextId = C0116R.string.sd_card_busy_message;
        } else if (aCurrentState.equals("removed")) {
            headerTextId = C0116R.string.sd_card_missing;
            imageId = C0116R.drawable.no_memory_card;
            messageTextId = C0116R.string.sd_card_missing_message;
        } else {
            headerTextId = C0116R.string.sd_card_error;
            imageId = C0116R.drawable.no_memory_card;
            messageTextId = C0116R.string.sd_card_error_message;
        }
        this.mHeaderTextView.setText(res.getString(headerTextId));
        this.mImageView.setImageResource(imageId);
        this.mMessageTextView.setText(res.getString(messageTextId));
    }

    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
        registerReceiver(this.mReceiver, this.mReceiverFilter);
        Analytics.getAnalytics().track(Analytics.EVENT_SD_BUSY);
    }

    public void onBackPressed() {
        Intent i = new Intent("android.intent.action.MAIN");
        i.addCategory("android.intent.category.HOME");
        startActivity(i);
    }

    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
        try {
            unregisterReceiver(this.mReceiver);
        } catch (Exception e) {
        }
    }

    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
        ((SongbirdApplication) getApplicationContext()).setSDCardMountedActivityShowing(false);
    }
}
