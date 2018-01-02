package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C0148R;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class cgu {
    private static final gg<String, String> f8272a = new gg();

    public static String m11190a(Context context) {
        String str = context.getApplicationInfo().name;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
            context.getApplicationContext().getPackageManager();
            try {
                str = dqc.m15265b(context).m15262a(context.getPackageName()).toString();
            } catch (NameNotFoundException e) {
            }
        }
        return str;
    }

    public static String m11191a(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0148R.string.common_google_play_services_install_title);
            case 2:
            case 42:
                return resources.getString(C0148R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(C0148R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return m11192a(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return m11192a(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(C0148R.string.common_google_play_services_unsupported_title);
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return m11192a(context, "common_google_play_services_sign_in_failed_title");
            case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                return resources.getString(C0148R.string.common_google_play_services_updating_title);
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return m11192a(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    private static String m11192a(Context context, String str) {
        synchronized (f8272a) {
            String str2 = (String) f8272a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String str3 = "GoogleApiAvailability";
                String str4 = "Missing resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            Object string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            f8272a.put(str, string);
            return string;
        }
    }

    private static String m11193a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a = m11192a(context, str);
        if (a == null) {
            a = resources.getString(C0148R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a, new Object[]{str2});
    }

    public static String m11194b(Context context, int i) {
        String a = i == 6 ? m11192a(context, "common_google_play_services_resolution_required_title") : m11191a(context, i);
        return a == null ? context.getResources().getString(C0148R.string.common_google_play_services_notification_ticker) : a;
    }

    public static String m11195c(Context context, int i) {
        Resources resources = context.getResources();
        String a = m11190a(context);
        switch (i) {
            case 1:
                if (cir.m11400a(resources)) {
                    return resources.getString(C0148R.string.common_google_play_services_install_text_tablet, new Object[]{a});
                }
                return resources.getString(C0148R.string.common_google_play_services_install_text_phone, new Object[]{a});
            case 2:
                return resources.getString(C0148R.string.common_google_play_services_update_text, new Object[]{a});
            case 3:
                return resources.getString(C0148R.string.common_google_play_services_enable_text, new Object[]{a});
            case 5:
                return m11193a(context, "common_google_play_services_invalid_account_text", a);
            case 7:
                return m11193a(context, "common_google_play_services_network_error_text", a);
            case 9:
                return resources.getString(C0148R.string.common_google_play_services_unsupported_text, new Object[]{a});
            case 16:
                return m11193a(context, "common_google_play_services_api_unavailable_text", a);
            case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
                return m11193a(context, "common_google_play_services_sign_in_failed_text", a);
            case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                return resources.getString(C0148R.string.common_google_play_services_updating_text, new Object[]{a});
            case 20:
                return m11193a(context, "common_google_play_services_restricted_profile_text", a);
            case 42:
                return resources.getString(C0148R.string.common_google_play_services_wear_update_text);
            default:
                return resources.getString(C0148R.string.common_google_play_services_unknown_issue, new Object[]{a});
        }
    }

    public static String m11196d(Context context, int i) {
        return i == 6 ? m11193a(context, "common_google_play_services_resolution_required_text", m11190a(context)) : m11195c(context, i);
    }

    public static String m11197e(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0148R.string.common_google_play_services_install_button);
            case 2:
                return resources.getString(C0148R.string.common_google_play_services_update_button);
            case 3:
                return resources.getString(C0148R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
