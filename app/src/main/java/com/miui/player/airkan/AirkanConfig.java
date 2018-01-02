package com.miui.player.airkan;

import com.miui.player.airkan.DeviceController.DeviceFilter;

public class AirkanConfig {
    public static final int DELAY_CLOSE_DEVICE = 300000;
    public static final int FLAG_SERVICE = 2;
    public static final int FLAG_UI = 1;

    public static class Filter implements DeviceFilter {
        public boolean supportDevice(Object deviceData) {
            return true;
        }
    }
}
