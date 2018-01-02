package com.miui.player.effect.dirac;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings.System;
import android.util.Log;
import android.util.Pair;
import com.baidu.music.log.LogHelper;
import com.google.android.collect.Lists;
import com.miui.player.meta.MetaManager;
import java.util.List;

public class DiracUtils {
    protected static final int DIRAC_OFF = 0;
    protected static final int DIRAC_ON = 1;
    protected static final int ID_GENERAL_EARBUDS = 5;
    protected static final int ID_GENERAL_INEAR = 6;
    protected static final int ID_MEP100 = 1;
    protected static final int ID_MEP200 = 2;
    protected static final int ID_MK101 = 7;
    protected static final int ID_MK301 = 8;
    protected static final int ID_PISTON_100 = 3;
    protected static final int ID_PISTON_200 = 4;
    private static final String KEY_LAST_HEADSET_TYPE = "dirac_last_headset_type";
    protected static final String PARAM_KEY_DIRAC = "dirac";
    protected static final String PARAM_KEY_DIRAC_ENABLED = "dirac_enabled";
    static final String TAG = DiracUtils.class.getName();
    protected static final int VAL_DEFAULT_HEADSET = 5;
    public static final int VAL_EARBUDS = 1;
    public static final int VAL_GENERAL_EARBUDS = 5;
    public static final int VAL_GENERAL_INEAR = 6;
    public static final int VAL_HEADSET_MAX = 8;
    public static final int VAL_HEADSET_MIN = 1;
    public static final int VAL_IN_EAR = 2;
    public static final int VAL_MK101 = 7;
    public static final int VAL_MK301 = 8;
    public static final int VAL_OFF = 0;
    public static final int VAL_PISTON_100 = 3;
    public static final int VAL_PISTON_200 = 4;
    private static List<Pair<Integer, Integer>> sHeadsetIdsAndTypes;

    public static DiracUtils newInstance() {
        Class<?> diracUtilFactory = null;
        try {
            diracUtilFactory = Class.forName("com.miui.player.effect.dirac.PiscesDiracUtils");
        } catch (ClassNotFoundException e) {
            Log.e(TAG, e.toString());
        }
        if (diracUtilFactory == null) {
            try {
                diracUtilFactory = Class.forName("com.miui.player.effect.dirac.WtDiracUtils");
            } catch (ClassNotFoundException e2) {
                Log.e(TAG, e2.toString());
            }
        }
        if (diracUtilFactory == null) {
            try {
                diracUtilFactory = Class.forName("com.miui.player.effect.dirac.TaurusDiracUtils");
            } catch (ClassNotFoundException e22) {
                Log.e(TAG, e22.toString());
            }
        }
        if (diracUtilFactory != null) {
            try {
                return (DiracUtils) diracUtilFactory.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                Log.e(TAG, e3.toString());
            }
        }
        return new DiracUtils();
    }

    protected DiracUtils() {
    }

    public void initialize() {
    }

    public void release() {
    }

    public void setEnabled(Context context, boolean isEnabled) {
        int value = 0;
        if (isEnabled) {
            value = getHeadsetType(context);
        }
        setDiracState(context, value);
    }

    public boolean isEnabled(Context context) {
        return getDiracState(context) != 0;
    }

    public void setHeadsetType(Context context, int value) {
        Log.i(TAG, "set headset type: " + value);
        if (isHeadsetType(value)) {
            setDiracState(context, value);
            saveLastHeadsetType(context, value);
            return;
        }
        throw new IllegalArgumentException("bad value, value=" + value);
    }

    public int getHeadsetType(Context context) {
        int value = getDiracState(context);
        return isHeadsetType(value) ? value : restoreLastHeadsetType(context);
    }

    public void setLevel(Context context, int band, float level) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        String parameters = String.format("diracband=%d;value=%f", new Object[]{Integer.valueOf(band), Float.valueOf(level)});
        audioManager.setParameters(parameters);
        Log.i(TAG, "set EQ Level: " + parameters);
    }

    public static boolean supportDirac(Context context) {
        return context.getResources().getBoolean(101253138);
    }

    protected static String toParameter(String key, int value) {
        return String.format("%s=%d", new Object[]{key, Integer.valueOf(value)});
    }

    protected static String getValue(String param) {
        if (param == null) {
            return null;
        }
        int index = param.indexOf(LogHelper.SEPARATE_DOT);
        if (index >= 0) {
            return param.substring(index + 1);
        }
        return MetaManager.UNKNOWN_STRING;
    }

    protected static boolean isHeadsetType(int value) {
        return value >= 1 && value <= 8;
    }

    private static void setDiracState(Context context, int value) {
        Log.i(TAG, "set dirac state: " + value);
        if (isHeadsetType(value) || value == 0) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            String param = toParameter(PARAM_KEY_DIRAC, value);
            Log.i(TAG, "set parameter " + param);
            audioManager.setParameters(param);
            return;
        }
        throw new IllegalArgumentException("bad value, value=" + value);
    }

    private static int getDiracState(Context context) {
        int value = 0;
        String param = ((AudioManager) context.getSystemService("audio")).getParameters(PARAM_KEY_DIRAC);
        Log.i(TAG, "get parameter " + param);
        String valueStr = getValue(param);
        if (valueStr != null) {
            try {
                value = Integer.valueOf(valueStr).intValue();
            } catch (NumberFormatException e) {
                Log.e(TAG, "refreshDiracState", e);
            }
        }
        return value;
    }

    private static int restoreLastHeadsetType(Context context) {
        String currentValue = System.getString(context.getContentResolver(), KEY_LAST_HEADSET_TYPE);
        if (currentValue != null) {
            return Integer.parseInt(currentValue);
        }
        return 5;
    }

    private static void saveLastHeadsetType(Context context, int type) {
        System.putString(context.getContentResolver(), KEY_LAST_HEADSET_TYPE, Integer.toString(type));
    }

    public List<Pair<Integer, Integer>> getHeadseIdsAndTypes() {
        if (sHeadsetIdsAndTypes == null) {
            sHeadsetIdsAndTypes = Lists.newArrayList();
            sHeadsetIdsAndTypes.add(new Pair(Integer.valueOf(5), Integer.valueOf(5)));
            sHeadsetIdsAndTypes.add(new Pair(Integer.valueOf(1), Integer.valueOf(1)));
            sHeadsetIdsAndTypes.add(new Pair(Integer.valueOf(2), Integer.valueOf(2)));
            sHeadsetIdsAndTypes.add(new Pair(Integer.valueOf(3), Integer.valueOf(3)));
        }
        return sHeadsetIdsAndTypes;
    }
}
