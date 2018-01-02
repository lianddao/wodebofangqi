package com.songbirdnest.mediaplayer.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.billing.BillingManager;
import com.songbirdnest.billing.InAppPurchases;
import com.songbirdnest.broadcast.ControllerMap;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.facebook.FacebookAPI.FacebookAPIRequest;
import com.songbirdnest.facebook.FacebookAPICallback;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.SongbirdApplication;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.dialogs.Equalizer;
import com.songbirdnest.mediaplayer.widgets.PreferenceWidget;
import com.songbirdnest.soundboard.SoundboardServer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Preferences extends PreferenceActivity {
    private PreferenceWidget equalizer_preference;
    private ListPreference frequency;
    private FacebookAPICallback mFacebookCallback = new C01452();
    private Preference mFacebookPreference = null;
    boolean mIsVideo = false;
    private OnSharedPreferenceChangeListener mListener = new C01441();
    int mMediaSessionId = -1;
    private ActivityOrientationHelper mOrientationHelper;

    class C01441 implements OnSharedPreferenceChangeListener {
        C01441() {
        }

        public void onSharedPreferenceChanged(SharedPreferences aPreferences, String aKey) {
            Intent i = new Intent(PrefKeys.PREFS_BROADCAST);
            i.putExtra("key", aKey);
            if (aKey.equals(PrefKeys.ENABLE_SCROBBLE_DROID_INTENTS)) {
                i.putExtra("value", aPreferences.getBoolean(aKey, true));
            } else if (aKey.equals(PrefKeys.DEFAULT_MEDIA_BUTTON_RECEIVER)) {
                i.putExtra("value", aPreferences.getBoolean(aKey, true));
            }
            Preferences.this.sendBroadcast(i);
        }
    }

    class C01452 implements FacebookAPICallback {
        C01452() {
        }

        private void completeGetUserFullName(String aResponse) {
            String userFullName = Preferences.this.getString(C0116R.string.unknown);
            if (aResponse != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Preferences.this.setFacebookLoggedIn(Util.parseJson(aResponse).optString(CookieTable.NAME, Preferences.this.getString(C0116R.string.unknown)));
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (FacebookError e2) {
                    e2.printStackTrace();
                }
            }
            Preferences.this.setFacebookLoggedOut();
        }

        public void onFileNotFoundException(FileNotFoundException aException) {
            completeGetUserFullName(null);
        }

        public void onIOException(IOException aIOException) {
            completeGetUserFullName(null);
        }

        public void onMalformedURLException(MalformedURLException e) {
            completeGetUserFullName(null);
        }

        public void onRequestCanceled() {
            completeGetUserFullName(null);
        }

        public void onRequestCompleted(String aResponse) {
            completeGetUserFullName(aResponse);
        }

        public void onRequestError(String aResponse) {
            completeGetUserFullName(null);
        }
    }

    class C01463 implements OnPreferenceClickListener {
        C01463() {
        }

        public boolean onPreferenceClick(Preference preference) {
            Preferences.this.wrapLaunch();
            return true;
        }
    }

    class C01474 implements OnPreferenceClickListener {
        C01474() {
        }

        public boolean onPreferenceClick(Preference preference) {
            Preferences.this.startActivity(new Intent(Preferences.this, Equalizer.class));
            return false;
        }
    }

    class C01485 implements OnPreferenceChangeListener {
        C01485() {
        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            int index = Preferences.this.frequency.findIndexOfValue((String) newValue);
            if (index == 0 || Preferences.this.frequency.getEntryValues().length - 1 == index) {
                preference.setSummary(Preferences.this.frequency.getEntries()[index]);
            } else {
                preference.setSummary(Preferences.this.frequency.getEntries()[index] + " " + Preferences.this.getString(C0116R.string.preferences_notification_when_available));
            }
            Map<String, String> properties = new HashMap();
            switch (index) {
                case 0:
                    properties.put(Analytics.ALERT_KEY, Analytics.DEFAULT_VALUE);
                    break;
                case 1:
                    properties.put(Analytics.ALERT_KEY, Analytics.HOURLY_VALUE);
                    break;
                case 2:
                    properties.put(Analytics.ALERT_KEY, Analytics.DAILY_VALUE);
                    break;
                case 3:
                    properties.put(Analytics.ALERT_KEY, Analytics.WEEKLY_VALUE);
                    break;
                case 4:
                    properties.put(Analytics.ALERT_KEY, Analytics.NEVER_VALUE);
                    break;
            }
            Analytics.getAnalytics().trackEvent(Analytics.EVENT_CONTENT_ALERT, null, properties);
            return true;
        }
    }

    class C01496 implements OnPreferenceClickListener {
        C01496() {
        }

        public boolean onPreferenceClick(Preference preference) {
            String aNull = null;
            aNull.toString();
            return false;
        }
    }

    class C01507 implements OnPreferenceClickListener {
        C01507() {
        }

        public boolean onPreferenceClick(Preference preference) {
            Preferences.this.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit().remove("soundboard.server").commit();
            return true;
        }
    }

    class C01518 implements OnPreferenceClickListener {
        C01518() {
        }

        public boolean onPreferenceClick(Preference preference) {
            FacebookAPI.get().authorize(Preferences.this, Preferences.this.getFacebookUsernameRequest());
            return true;
        }
    }

    class C01529 implements OnPreferenceClickListener {
        C01529() {
        }

        public boolean onPreferenceClick(Preference preference) {
            FacebookAPI.get().clearSessionData();
            SoundboardServer.get().clearSessionData();
            Preferences.this.setFacebookLoggedOut();
            return true;
        }
    }

    protected void onCreate(Bundle aSavedInstanceData) {
        String versionName;
        super.onCreate(aSavedInstanceData);
        PreferenceManager prefManager = getPreferenceManager();
        prefManager.setSharedPreferencesName(PrefKeys.PREFS_FILENAME);
        prefManager.setSharedPreferencesMode(0);
        prefManager.getSharedPreferences().registerOnSharedPreferenceChangeListener(this.mListener);
        if (Utils.containsGingerPackage(Utils.getPhilipsIntent(false, this.mMediaSessionId), getPackageManager())) {
            addPreferencesFromResource(C0116R.xml.philips);
            findPreference("philips.sound").setOnPreferenceClickListener(new C01463());
        }
        addPreferencesFromResource(C0116R.xml.preferences);
        if (!(prefManager.getSharedPreferences().contains(PrefKeys.LOCK_PORTRAIT) || (getResources().getConfiguration().screenLayout & 15) == 4)) {
            ((CheckBoxPreference) findPreference(PrefKeys.LOCK_PORTRAIT)).setChecked(true);
        }
        Preference versionInfo = getPreferenceScreen().findPreference(PrefKeys.sVersion);
        if (BaseActivity.externalPrefExists(fileList())) {
            try {
                new ControllerMap(openFileInput(PrefKeys.PREFS_EXTERNAL)).addPreferences(getPreferenceScreen());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (NameNotFoundException e3) {
            versionName = "";
        }
        versionInfo.setSummary(versionName);
        getPreferenceScreen().findPreference("mediaPlayer.build").setSummary(getString(C0116R.string.build_number));
        this.equalizer_preference = (PreferenceWidget) getPreferenceScreen().findPreference("equalizer_preference");
        if (this.equalizer_preference != null) {
            if (VERSION.SDK_INT >= 9) {
                this.equalizer_preference.setWidgetLayoutResource(C0116R.layout.icon_preference);
                BillingManager billingManager = BillingManager.getBillingManager();
                billingManager.start(this);
                if (!billingManager.isPurchased(InAppPurchases.EQUALIZER.getProductId())) {
                    this.equalizer_preference.setIconDrawable(C0116R.id.icon, getResources().getDrawable(C0116R.drawable.eq_locked_icon));
                }
                this.equalizer_preference.setOnPreferenceClickListener(new C01474());
            } else {
                ((PreferenceCategory) getPreferenceScreen().findPreference("category.general")).removePreference(this.equalizer_preference);
            }
        }
        if (VERSION.SDK_INT <= 7) {
            PreferenceCategory category = (PreferenceCategory) getPreferenceScreen().findPreference("category.general");
            Preference artistContentAlertsPref = getPreferenceScreen().findPreference("notifications.frequency");
            if (artistContentAlertsPref != null) {
                category.removePreference(artistContentAlertsPref);
            }
        } else {
            this.frequency = (ListPreference) getPreferenceScreen().findPreference("notifications.frequency");
            String value = this.frequency.getValue();
            if (value != null && value.length() > 0) {
                int index = this.frequency.findIndexOfValue(value);
                if (index == 0 || this.frequency.getEntryValues().length - 1 == index) {
                    this.frequency.setSummary(this.frequency.getEntries()[index]);
                } else {
                    this.frequency.setSummary(this.frequency.getEntries()[index] + " " + getString(C0116R.string.preferences_notification_when_available));
                }
            }
            this.frequency.setOnPreferenceChangeListener(new C01485());
        }
        addFacebookPreference();
        int mediaID = -1;
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            mediaID = extra.getInt("mediaid", -1);
        }
        if (mediaID != -1) {
            this.mMediaSessionId = mediaID;
            this.mIsVideo = true;
        }
        if (Utils.isQABuild(getApplicationContext())) {
            addCrashApp();
        }
        Analytics.getAnalytics().track(Analytics.EVENT_SETTINGS);
        this.mOrientationHelper = new ActivityOrientationHelper(this);
    }

    private void addCrashApp() {
        addPreferencesFromResource(C0116R.xml.config_pref);
        Preference aCrashPref = getPreferenceScreen().findPreference("qa.crash");
        if (aCrashPref != null) {
            aCrashPref.setOnPreferenceClickListener(new C01496());
            getPreferenceScreen().findPreference("qa.clear").setOnPreferenceClickListener(new C01507());
        }
    }

    protected void onResume() {
        super.onPause();
        this.mOrientationHelper.onResume();
        ((SongbirdApplication) getApplication()).pegActivity();
        if (this.equalizer_preference == null) {
            return;
        }
        if (BillingManager.getBillingManager().isPurchased(InAppPurchases.EQUALIZER.getProductId())) {
            this.equalizer_preference.refreshDrawable(null);
            return;
        }
        this.equalizer_preference.refreshDrawable(getResources().getDrawable(C0116R.drawable.eq_locked_icon));
    }

    protected void onPause() {
        super.onPause();
        this.mOrientationHelper.onPause();
        ((SongbirdApplication) getApplication()).dePegActivity();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        FacebookAPI.get().authorizeCallback(requestCode, resultCode, data);
    }

    private void addFacebookPreference() {
        FacebookAPI fbApi = FacebookAPI.get();
        this.mFacebookPreference = new Preference(this);
        this.mFacebookPreference.setPersistent(false);
        ((PreferenceCategory) findPreference("category.general")).addPreference(this.mFacebookPreference);
        if (fbApi.isSessionValid()) {
            setFacebookLoggedIn(null);
        } else {
            setFacebookLoggedOut();
        }
    }

    private void setFacebookLoggedOut() {
        this.mFacebookPreference.setTitle(C0116R.string.preferences_facebook);
        this.mFacebookPreference.setSummary(C0116R.string.preferences_facebook_desc);
        this.mFacebookPreference.setOnPreferenceClickListener(new C01518());
    }

    private void setFacebookLoggedIn(String aUsername) {
        String summary;
        this.mFacebookPreference.setTitle(C0116R.string.preferences_facebook_signed_in);
        if (aUsername == null) {
            summary = getString(C0116R.string.preferences_facebook_signed_in_desc, new Object[]{getString(C0116R.string.unknown)});
        } else {
            summary = getString(C0116R.string.preferences_facebook_signed_in_desc, new Object[]{aUsername});
        }
        this.mFacebookPreference.setSummary(summary);
        this.mFacebookPreference.setOnPreferenceClickListener(new C01529());
        if (aUsername == null) {
            updateFacebookUsername();
        }
    }

    private void updateFacebookUsername() {
        FacebookAPI.get().getUserFullNameForSession(this.mFacebookCallback);
    }

    public void wrapLaunch() {
        if (this.mMediaSessionId == -1) {
            this.mMediaSessionId = getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).getInt("mediaid", -1);
            if (this.mMediaSessionId == -1) {
                return;
            }
        }
        Intent intent = Utils.getPhilipsIntent(this.mIsVideo, this.mMediaSessionId);
        if (Utils.containsGingerPackage(intent, getPackageManager())) {
            startActivityForResult(intent, 1);
        }
    }

    private FacebookAPIRequest getFacebookUsernameRequest() {
        Bundle params = new Bundle();
        params.putString("fields", CookieTable.NAME);
        return FacebookAPI.get().newRequest(Analytics.ME_VALUE, params, "GET", this.mFacebookCallback);
    }
}
