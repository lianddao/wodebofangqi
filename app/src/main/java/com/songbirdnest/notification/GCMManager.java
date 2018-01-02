package com.songbirdnest.notification;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.google.android.gcm.GCMRegistrar;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.task.RegisterDevice;
import com.songbirdnest.soundboard.task.SetUTC;
import com.songbirdnest.soundboard.task.UnRegisterDevice;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.util.Logger;
import java.util.Random;
import java.util.TimeZone;

public class GCMManager {
    private static final int BACKOFF_MILLI_SECONDS = 2000;
    private static final int MAX_ATTEMPTS = 5;
    private static boolean debugging = true;
    private static final Random random = new Random();
    private Context context;
    private AsyncTask<Void, Void, Void> mRegisterTask;
    private String registrationId;

    static class C04552 implements SoundboardListener<String> {
        C04552() {
        }

        public void onSuccess(String s) {
            if (GCMManager.debugging) {
                Logger.debug(GCMManager.class, "Timezone set");
            }
        }

        public void onFailure(String message, StreamException exception) {
            Logger.error(GCMManager.class, "Problems setting Timezone", exception);
        }
    }

    public GCMManager(Context context) {
        this.context = context;
    }

    public void start() {
        try {
            GCMRegistrar.checkDevice(this.context);
            GCMRegistrar.checkManifest(this.context);
            if (SoundboardServer.get().getCurrentSoundBoardId() == null) {
                Logger.error((Object) this, "No current soundboard user");
                return;
            }
            final SharedPreferences prefs = this.context.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
            this.registrationId = prefs.getString(PrefKeys.sNotificationRegId, null);
            if (this.registrationId == null) {
                final String regId = GCMRegistrar.getRegistrationId(this.context);
                if (regId == null || regId.equals("")) {
                    if (debugging) {
                        Logger.debug(this, "Couldn't find registration.");
                    }
                    GCMRegistrar.register(this.context, this.context.getString(C0116R.string.GCM_PROJECT_ID));
                } else if (GCMRegistrar.isRegisteredOnServer(this.context)) {
                    if (debugging) {
                        Logger.debug(this, "Already registered on server.");
                    }
                    prefs.edit().putString(PrefKeys.sNotificationRegId, regId).commit();
                    this.registrationId = regId;
                } else {
                    if (debugging) {
                        Logger.debug(this, "Not registered on server.");
                    }
                    this.mRegisterTask = new AsyncTask<Void, Void, Void>() {
                        protected Void doInBackground(Void... params) {
                            if (GCMManager.register(GCMManager.this.context, regId)) {
                                if (GCMManager.debugging) {
                                    Logger.debug(this, "Registration complete.");
                                }
                                prefs.edit().putString(PrefKeys.sNotificationRegId, regId).commit();
                                GCMManager.this.registrationId = regId;
                            } else {
                                GCMRegistrar.unregister(GCMManager.this.context);
                            }
                            return null;
                        }

                        protected void onPostExecute(Void result) {
                            GCMManager.this.mRegisterTask = null;
                        }
                    };
                    this.mRegisterTask.execute(new Void[]{null, null, null});
                }
            }
        } catch (UnsupportedOperationException e) {
            Logger.error(this, "Google Cloud Messaging not supported", e);
        }
    }

    public static boolean register(final Context context, String regId) {
        if (debugging) {
            Logger.debug(GCMManager.class, "registering device (regId = " + regId + ")");
        }
        long backoff = (long) (random.nextInt(SongbirdMedia.PODCAST_BACKUP) + 2000);
        int i = 1;
        while (i <= 5) {
            if (debugging) {
                Logger.debug(GCMManager.class, "Attempt #" + i + " to register");
            }
            try {
                new SetUTC(SoundboardServer.get(), SoundboardServer.get().getCurrentSoundBoardId(), String.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 3600000), new C04552()).run();
                new RegisterDevice(SoundboardServer.get(), SoundboardServer.get().getCurrentSoundBoardId(), regId, new SoundboardListener<String>() {
                    public void onSuccess(String s) {
                        GCMRegistrar.setRegisteredOnServer(context, true);
                        if (GCMManager.debugging) {
                            Logger.debug(GCMManager.class, "Device Registered");
                        }
                    }

                    public void onFailure(String message, StreamException exception) {
                        Logger.error(GCMManager.class, "Problems registering device", exception);
                    }
                }).run();
                if (GCMRegistrar.isRegistered(context)) {
                    if (debugging) {
                        Logger.debug(GCMManager.class, "Device Registered");
                    }
                    return true;
                }
                i++;
            } catch (Exception e) {
                Logger.error(GCMManager.class, "Failed to register on attempt " + i, e);
                if (i == 5) {
                    break;
                }
                try {
                    Logger.debug(GCMManager.class, "Sleeping for " + backoff + " ms before retry");
                    Thread.sleep(backoff);
                    backoff *= 2;
                } catch (InterruptedException e2) {
                    Logger.debug(GCMManager.class, "Thread interrupted: abort remaining retries!");
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
        }
        Logger.error((Object) GCMManager.class, "Failed to register after 5 attempts ");
        return false;
    }

    public static void unregister(final Context context, final String regId) {
        if (debugging) {
            Logger.debug(GCMManager.class, "unregistering device (regId = " + regId + ")");
        }
        new UnRegisterDevice(SoundboardServer.get(), SoundboardServer.get().getCurrentSoundBoardId(), regId, new SoundboardListener<String>() {
            public void onSuccess(String s) {
                GCMRegistrar.setRegisteredOnServer(context, false);
                if (GCMManager.debugging) {
                    Logger.debug(GCMManager.class, "unregistered device (regId = " + regId + ")");
                }
            }

            public void onFailure(String message, StreamException exception) {
                Logger.error(GCMManager.class, "Problems unRegistering device", exception);
            }
        }).run();
    }
}
