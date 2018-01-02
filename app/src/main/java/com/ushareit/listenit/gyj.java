package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.mopub.common.Constants;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.umeng.analytics.pro.C0277j;
import com.ushareit.browser.WebClientActivity;
import com.ushareit.listenit.lockscreen.LockScreenActivity;
import com.ushareit.listenit.login.LoginActivity;
import com.ushareit.listenit.login.UserProfileActivity;
import com.ushareit.listenit.main.StartupActivity;

public class gyj {
    public static void m23147a(Context context, String str) {
        Intent intent = new Intent(context, WebClientActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("opt", false);
        intent.putExtra("thumbnail", "");
        context.startActivity(intent);
    }

    public static void m23143a(Activity activity, int i) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("come_from", i);
        activity.startActivityForResult(intent, 31);
    }

    public static int m23142a(Activity activity) {
        return activity.getIntent().getIntExtra("come_from", 1);
    }

    public static void m23149b(Activity activity) {
        activity.startActivity(new Intent(activity, UserProfileActivity.class));
    }

    public static void m23144a(Activity activity, Uri uri) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            intent.putExtra("output", uri);
            activity.startActivityForResult(intent, 161);
        }
    }

    public static void m23145a(Activity activity, Uri uri, Uri uri2, int i, int i2) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", true);
        intent.putExtra("aspectX", 9999);
        intent.putExtra("aspectY", Constants.TEN_SECONDS_MILLIS);
        intent.putExtra("outputX", i);
        intent.putExtra("outputY", i2);
        intent.putExtra("scale", true);
        intent.putExtra("output", uri2);
        intent.putExtra("outputFormat", CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("return-data", true);
        activity.startActivityForResult(intent, 162);
    }

    public static void m23150b(Activity activity, Uri uri, Uri uri2, int i, int i2) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", true);
        intent.putExtra("aspectX", 99999);
        intent.putExtra("aspectY", 100000);
        intent.putExtra("outputX", i);
        intent.putExtra("outputY", i2);
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("output", uri2);
        intent.putExtra("outputFormat", CompressFormat.PNG.toString());
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("return-data", false);
        activity.startActivityForResult(intent, 162);
    }

    public static void m23151c(Activity activity) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(intent, C0277j.f3691b);
        } else {
            heb.m23596a((int) C0349R.string.toast_can_not_find_your_album, 0).show();
        }
    }

    public static boolean m23148a(String str, String str2) {
        PackageManager packageManager = eys.m18562a().getPackageManager();
        Intent intent = new Intent(str);
        intent.setType(str2);
        return packageManager.queryIntentActivities(intent, 64).size() != 0;
    }

    public static void m23152d(Activity activity) {
        Intent intent = new Intent(activity.getApplicationContext(), StartupActivity.class);
        intent.putExtra("intent_extra_from_background", true);
        activity.startActivity(intent);
    }

    public static void m23146a(Context context, int i) {
        Intent intent = new Intent(context, LockScreenActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(VastExtensionXmlManager.TYPE, i);
        context.startActivity(intent);
    }
}
