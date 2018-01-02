package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.Html;
import android.widget.RemoteViews;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class exn implements ewv {
    public void mo2312a(Context context, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(i);
        }
    }

    public void mo2313a(Context context, evi com_ushareit_listenit_evi) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            ca b = m18420b(context, com_ushareit_listenit_evi);
            if (b != null) {
                Notification a = b.m10533a();
                a.contentView.setImageViewResource(16908294, context.getApplicationInfo().icon);
                switch (com_ushareit_listenit_evi.f11954b) {
                    case 1:
                        m18421b(context, a, com_ushareit_listenit_evi);
                        break;
                    case 2:
                        m18419a(context, a, com_ushareit_listenit_evi);
                        break;
                }
                a.flags |= com_ushareit_listenit_evi.f11961i;
                notificationManager.notify(com_ushareit_listenit_evi.f11953a, a);
            }
        }
    }

    private ca m18420b(Context context, evi com_ushareit_listenit_evi) {
        Intent intent = null;
        try {
            Intent parseUri;
            if (fbb.m18761b(com_ushareit_listenit_evi.f11964l)) {
                parseUri = Intent.parseUri(com_ushareit_listenit_evi.f11964l, 0);
            } else {
                parseUri = null;
            }
            if (fbb.m18761b(com_ushareit_listenit_evi.f11966n)) {
                intent = Intent.parseUri(com_ushareit_listenit_evi.f11966n, 0);
            }
            ca caVar = new ca(context);
            caVar.m10534a((int) C0349R.drawable.ic_launcher);
            caVar.m10546c(Html.fromHtml(com_ushareit_listenit_evi.f11957e));
            caVar.m10538a(Html.fromHtml(com_ushareit_listenit_evi.f11955c));
            caVar.m10542b(Html.fromHtml(com_ushareit_listenit_evi.f11956d));
            caVar.m10535a(System.currentTimeMillis());
            caVar.m10543b(true);
            caVar.m10540b(com_ushareit_listenit_evi.f11962j);
            if (1 == com_ushareit_listenit_evi.f11965m) {
                caVar.m10541b(PendingIntent.getActivity(context, com_ushareit_listenit_evi.f11953a + 1, intent, 134217728));
            } else if (3 == com_ushareit_listenit_evi.f11965m) {
                caVar.m10541b(PendingIntent.getService(context, com_ushareit_listenit_evi.f11953a + 1, intent, 134217728));
            } else if (2 == com_ushareit_listenit_evi.f11965m) {
                caVar.m10541b(PendingIntent.getBroadcast(context, com_ushareit_listenit_evi.f11953a + 1, intent, 134217728));
            }
            if (1 == com_ushareit_listenit_evi.f11963k) {
                caVar.m10536a(PendingIntent.getActivity(context, com_ushareit_listenit_evi.f11953a, parseUri, 134217728));
            } else if (3 == com_ushareit_listenit_evi.f11963k) {
                caVar.m10536a(PendingIntent.getService(context, com_ushareit_listenit_evi.f11953a, parseUri, 134217728));
            } else if (2 == com_ushareit_listenit_evi.f11963k) {
                caVar.m10536a(PendingIntent.getBroadcast(context, com_ushareit_listenit_evi.f11953a, parseUri, 134217728));
            }
            return caVar;
        } catch (URISyntaxException e) {
            return null;
        }
    }

    @TargetApi(16)
    private void m18419a(Context context, Notification notification, evi com_ushareit_listenit_evi) {
        try {
            if (!fbb.m18763c(com_ushareit_listenit_evi.f11958f)) {
                Bitmap a = eux.m18067a(com_ushareit_listenit_evi);
                if (a != null && VERSION.SDK_INT >= 16) {
                    RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0349R.layout.cmd_notification_image);
                    remoteViews.setImageViewBitmap(C0349R.id.notification_image, a);
                    if (fbb.m18765d(com_ushareit_listenit_evi.f11955c)) {
                        remoteViews.setTextViewText(C0349R.id.notification_image_title, Html.fromHtml(com_ushareit_listenit_evi.f11955c));
                    }
                    if (fbb.m18765d(com_ushareit_listenit_evi.f11956d)) {
                        remoteViews.setTextViewText(C0349R.id.notification_image_content, Html.fromHtml(com_ushareit_listenit_evi.f11956d));
                    }
                    remoteViews.setTextViewText(C0349R.id.notification_image_time, new SimpleDateFormat("yy-MM-dd", Locale.getDefault()).format(new Date()));
                    notification.bigContentView = remoteViews;
                    notification.priority = 2;
                }
            }
        } catch (Exception e) {
        }
    }

    private void m18421b(Context context, Notification notification, evi com_ushareit_listenit_evi) {
        try {
            if (VERSION.SDK_INT >= 9 && !fbb.m18763c(com_ushareit_listenit_evi.f11960h)) {
                RemoteViews remoteViews = new RemoteViews(context.getApplicationContext().getPackageName(), C0349R.layout.cmd_notification_button);
                if (fbb.m18765d(com_ushareit_listenit_evi.f11958f)) {
                    try {
                        remoteViews.setImageViewBitmap(C0349R.id.notification_icon, eux.m18067a(com_ushareit_listenit_evi));
                    } catch (fci e) {
                        remoteViews.setImageViewResource(C0349R.id.notification_icon, C0349R.drawable.ic_launcher);
                    }
                } else {
                    remoteViews.setImageViewResource(C0349R.id.notification_icon, C0349R.drawable.ic_launcher);
                }
                if (fbb.m18765d(com_ushareit_listenit_evi.f11955c)) {
                    remoteViews.setTextViewText(C0349R.id.notification_title, Html.fromHtml(com_ushareit_listenit_evi.f11955c));
                }
                if (fbb.m18765d(com_ushareit_listenit_evi.f11956d)) {
                    remoteViews.setTextViewText(C0349R.id.notification_content, Html.fromHtml(com_ushareit_listenit_evi.f11956d));
                }
                remoteViews.setTextViewText(C0349R.id.notification_button, Html.fromHtml(com_ushareit_listenit_evi.f11960h));
                notification.contentView = remoteViews;
            }
        } catch (Exception e2) {
        }
    }
}
