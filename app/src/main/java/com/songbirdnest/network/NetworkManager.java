package com.songbirdnest.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.songbirdnest.util.Logger;

public class NetworkManager {
    private Context mContext;

    public enum NetworkType {
        MOBILE,
        WIFI
    }

    public enum State {
        UNKNOWN,
        CONNECTED,
        NOT_CONNECTED
    }

    public NetworkManager(Context mContext) {
        this.mContext = mContext;
    }

    public boolean hasActiveNetwork() {
        boolean result = false;
        if (this.mContext == null) {
            Logger.error((Object) NetworkManager.class, "Context is null");
            return false;
        }
        NetworkInfo netInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (netInfo != null && netInfo.isAvailable() && netInfo.isConnected()) {
            result = true;
        }
        return result;
    }

    public boolean wifiIsActive() {
        if (this.mContext == null) {
            Logger.error((Object) NetworkManager.class, "Context is null");
            return false;
        }
        WifiManager mgr = (WifiManager) this.mContext.getSystemService("wifi");
        if (!mgr.isWifiEnabled()) {
            return false;
        }
        WifiInfo connectionInfo = mgr.getConnectionInfo();
        if (connectionInfo == null || connectionInfo.getBSSID() == null) {
            return false;
        }
        return true;
    }
}
