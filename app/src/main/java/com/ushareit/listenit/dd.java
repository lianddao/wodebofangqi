package com.ushareit.listenit;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class dd {
    private static final Object f9576a = new Object();
    private static Field f9577b;
    private static boolean f9578c;
    private static final Object f9579d = new Object();

    public static void m13826a(bu buVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(buVar.mo1566a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void m13825a(bu buVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(buVar.mo1566a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void m13827a(bu buVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(buVar.mo1566a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> m13824a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle m13823a(Notification notification) {
        synchronized (f9576a) {
            if (f9578c) {
                return null;
            }
            try {
                if (f9577b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f9577b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f9578c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f9577b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f9577b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f9578c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f9578c = true;
                return null;
            }
        }
    }

    public static Bundle m13822a(Builder builder, cx cxVar) {
        builder.addAction(cxVar.mo1164a(), cxVar.mo1165b(), cxVar.mo1166c());
        Bundle bundle = new Bundle(cxVar.mo1167d());
        if (cxVar.mo1169g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", dr.m15309a(cxVar.mo1169g()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", cxVar.mo1168e());
        return bundle;
    }
}
