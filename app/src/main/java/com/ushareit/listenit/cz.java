package com.ushareit.listenit;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

class cz {
    public static Notification m13446a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        return notification;
    }
}
