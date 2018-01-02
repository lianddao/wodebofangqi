package com.songbirdnest.mediaplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import com.songbirdnest.notification.GCMManager;
import com.songbirdnest.util.Logger;

public class GCMIntentService extends GCMBaseIntentService {
    protected String[] getSenderIds(Context context) {
        return new String[]{context.getString(C0116R.string.GCM_PROJECT_ID)};
    }

    protected void onRegistered(Context context, String registrationId) {
        Logger.debug(this, "Device registered: regId = " + registrationId);
        GCMManager.register(context, registrationId);
    }

    protected void onUnregistered(Context context, String registrationId) {
        Logger.debug(this, "Device unregistered");
        if (GCMRegistrar.isRegisteredOnServer(context)) {
            GCMManager.unregister(context, registrationId);
        } else {
            Logger.debug(this, "Ignoring unregister callback");
        }
    }

    protected void onMessage(Context context, Intent intent) {
        Logger.debug(this, "Received message");
        generateNotification(context, intent.getStringExtra("text"));
    }

    protected void onDeletedMessages(Context context, int total) {
        Logger.debug(this, "Received deleted messages notification");
    }

    public void onError(Context context, String errorId) {
        Log.e(GCMBaseIntentService.TAG, "Received error: " + errorId);
    }

    protected boolean onRecoverableError(Context context, String errorId) {
        Logger.debug(this, "Received recoverable error: " + errorId);
        return super.onRecoverableError(context, errorId);
    }

    private static void generateNotification(Context context, String message) {
        String frequencyValue = context.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).getString("notifications.frequency", null);
        if (frequencyValue == null || !frequencyValue.equalsIgnoreCase("Never")) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Notification notification = new Notification(C0116R.drawable.notifications_icon_24x24, message, System.currentTimeMillis());
            String title = context.getString(C0116R.string.app_name);
            Intent notificationIntent = new Intent(context, ContentBrowser.class);
            notificationIntent.putExtra(Constants.CONTENT_AREA_VIEW_KEY, "Friends");
            notificationIntent.setFlags(603979776);
            notification.setLatestEventInfo(context, title, message, PendingIntent.getActivity(context, 0, notificationIntent, 0));
            notification.flags |= 16;
            notificationManager.notify(0, notification);
        }
    }
}
