package com.miui.player.plugin;

import android.preference.PreferenceManager;
import com.miui.player.plugin.base.PlugInInterface;
import com.miui.player.plugin.onlineimage.ImagePlugIn;
import com.miui.player.plugin.onlinelyric.LyricPlugIn.Factory;
import com.miui.player.plugin.onlinemusic2.OnlineMusicPlugIn;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.Utils;

public class PlugInManager {
    public static final int IMAGE_ID = 1;
    public static final int LYRIC_ID = 0;
    public static final int ONLINE_MUSIC_ID = 2;
    private static final PlugInManager[] PLUG_IN_ARR = new PlugInManager[3];
    private static final String[] PLUG_IN_NAMES = new String[]{"onlinelyric", "onlineimage", "onlinemusic2"};
    public static final int PLUG_IN_SIZE = 3;
    static final String TAG = PlugInManager.class.getCanonicalName();
    private final int mPlugInId;
    private PlugInInterface mPlugInInterface;

    private PlugInManager(int id) {
        this.mPlugInId = id;
    }

    public synchronized void statistics(boolean success) {
        if (this.mPlugInInterface != null) {
            String config = this.mPlugInInterface.statistics(success);
            if (config != null) {
                PreferenceManager.getDefaultSharedPreferences(MusicApplication.getApplication()).edit().putString(getPreferenceConfigKey(this.mPlugInId), config).apply();
            }
        }
    }

    public synchronized PlugInInterface getPlugInInterface() {
        if (this.mPlugInInterface == null) {
            this.mPlugInInterface = createPlugInInterface(this.mPlugInId, getPreferenceConfigKey(this.mPlugInId));
        }
        return this.mPlugInInterface;
    }

    private PlugInInterface createPlugInInterface(int id, String config) {
        if (!Utils.isOnlineVaild()) {
            return null;
        }
        PlugInInterface pii;
        switch (id) {
            case 0:
                pii = Factory.create();
                break;
            case 1:
                pii = ImagePlugIn.Factory.create();
                break;
            case 2:
                pii = OnlineMusicPlugIn.Factory.create();
                break;
            default:
                throw new UnsupportedOperationException("bad id " + id);
        }
        if (pii == null) {
            return pii;
        }
        pii.initialize(config);
        return pii;
    }

    public static synchronized PlugInManager instance(int id) {
        PlugInManager mgr;
        synchronized (PlugInManager.class) {
            mgr = PLUG_IN_ARR[id];
            if (mgr == null) {
                mgr = new PlugInManager(id);
                PLUG_IN_ARR[id] = mgr;
            }
        }
        return mgr;
    }

    public static PlugInManager tryToGetInstance(int id) {
        return PLUG_IN_ARR[id];
    }

    private static String getPreferenceConfigKey(int id) {
        return PLUG_IN_NAMES[id] + "_config";
    }
}
