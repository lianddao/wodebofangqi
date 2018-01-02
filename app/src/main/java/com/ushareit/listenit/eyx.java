package com.ushareit.listenit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

public class eyx {
    private eza f12204a;
    private eyz f12205b;
    private String f12206c;
    private String f12207d;
    private String f12208e;

    public String m18574a() {
        switch (eyy.f12210b[m18575b().ordinal()]) {
            case 1:
                return "OFFLINE";
            case 2:
                return "WIFI";
            case 3:
                switch (eyy.f12209a[m18576c().ordinal()]) {
                    case 1:
                        return "MOBILE_2G";
                    case 2:
                        return "MOBILE_3G";
                    case 3:
                        return "MOBILE_4G";
                    default:
                        return "MOBILE_UNKNOWN";
                }
            default:
                return "UNKNOWN";
        }
    }

    protected eyx(eza com_ushareit_listenit_eza, eyz com_ushareit_listenit_eyz, String str, String str2, String str3) {
        this.f12204a = com_ushareit_listenit_eza;
        this.f12205b = com_ushareit_listenit_eyz;
        this.f12206c = str;
        this.f12207d = str2;
        this.f12208e = str3;
    }

    public eza m18575b() {
        return this.f12204a;
    }

    public eyz m18576c() {
        return this.f12205b;
    }

    public String m18577d() {
        return this.f12206c;
    }

    public String m18578e() {
        return this.f12208e;
    }

    public static eyx m18571a(Context context) {
        String str = null;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        eyx com_ushareit_listenit_eyx = new eyx(eza.OFFLINE, eyz.UNKNOWN, null, null, null);
        if (!(telephonyManager == null || connectivityManager == null)) {
            com_ushareit_listenit_eyx.f12206c = telephonyManager.getSimOperatorName();
            com_ushareit_listenit_eyx.f12208e = telephonyManager.getSimOperator();
            if (com_ushareit_listenit_eyx.f12206c == null || com_ushareit_listenit_eyx.f12206c.length() <= 0 || com_ushareit_listenit_eyx.f12206c.equals("null")) {
                com_ushareit_listenit_eyx.f12206c = fal.m18718a();
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    com_ushareit_listenit_eyx.f12204a = eza.MOBILE;
                    com_ushareit_listenit_eyx.f12205b = m18572a(telephonyManager.getNetworkType());
                } else if (type == 1) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager != null) {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        if (connectionInfo != null) {
                            String ssid = connectionInfo.getSSID();
                            if (ssid != null && ssid.length() > 0) {
                                str = ssid;
                            }
                            com_ushareit_listenit_eyx.f12207d = str;
                        }
                    }
                    com_ushareit_listenit_eyx.f12204a = eza.WIFI;
                } else {
                    com_ushareit_listenit_eyx.f12204a = eza.UNKNOWN;
                }
            }
        }
        return com_ushareit_listenit_eyx;
    }

    public static eza m18573b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return eza.OFFLINE;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return eza.OFFLINE;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return eza.MOBILE;
        }
        return type == 1 ? eza.WIFI : eza.UNKNOWN;
    }

    public static eyz m18572a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return eyz.MOBILE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
            case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
                return eyz.MOBILE_3G;
            case 13:
            case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
            case Encoder.LINE_GROUPS /*19*/:
                return eyz.MOBILE_4G;
            default:
                return eyz.UNKNOWN;
        }
    }
}
