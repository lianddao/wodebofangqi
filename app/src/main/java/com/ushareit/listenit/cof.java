package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

class cof implements cpl {
    private static long f8544a = 0;
    private con f8545b;
    private cpi f8546c;
    private cog f8547d;
    private coi f8548e = coi.REALTIME_CONNECTING;
    private final cvy f8549f;

    public cof(col com_ushareit_listenit_col, con com_ushareit_listenit_con, String str, cog com_ushareit_listenit_cog, String str2) {
        long j = f8544a;
        f8544a = 1 + j;
        this.f8545b = com_ushareit_listenit_con;
        this.f8547d = com_ushareit_listenit_cog;
        this.f8549f = new cvy(com_ushareit_listenit_col.m12025a(), "Connection", "conn_" + j);
        this.f8546c = new cpi(com_ushareit_listenit_col, com_ushareit_listenit_con, str, this, str2);
    }

    private void m12004a(long j, String str) {
        if (this.f8549f.m13094a()) {
            this.f8549f.m13093a("realtime connection established", new Object[0]);
        }
        this.f8548e = coi.REALTIME_CONNECTED;
        this.f8547d.mo1517a(j, str);
    }

    private void m12005a(String str) {
        if (this.f8549f.m13094a()) {
            this.f8549f.m13093a("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.f8547d.mo1528b(str);
        m12016b();
    }

    private void m12006b(String str) {
        if (this.f8549f.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8549f;
            String valueOf = String.valueOf(this.f8545b.m12037a());
            com_ushareit_listenit_cvy.m13093a(new StringBuilder((String.valueOf(valueOf).length() + 62) + String.valueOf(str).length()).append("Got a reset; killing connection to ").append(valueOf).append("; Updating internalHost to ").append(str).toString(), new Object[0]);
        }
        this.f8547d.mo1519a(str);
        m12012a(coh.SERVER_RESET);
    }

    private void m12007b(Map<String, Object> map) {
        if (this.f8549f.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8549f;
            String str = "received data message: ";
            String valueOf = String.valueOf(map.toString());
            com_ushareit_listenit_cvy.m13093a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
        }
        this.f8547d.mo1526a((Map) map);
    }

    private void m12008b(Map<String, Object> map, boolean z) {
        if (this.f8548e != coi.REALTIME_CONNECTED) {
            this.f8549f.m13093a("Tried to send on an unconnected connection", new Object[0]);
            return;
        }
        if (z) {
            this.f8549f.m13093a("Sending data (contents hidden)", new Object[0]);
        } else {
            this.f8549f.m13093a("Sending data: %s", map);
        }
        this.f8546c.m12195a((Map) map);
    }

    private void m12009c(Map<String, Object> map) {
        if (this.f8549f.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8549f;
            String str = "Got control message: ";
            String valueOf = String.valueOf(map.toString());
            com_ushareit_listenit_cvy.m13093a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
        }
        try {
            valueOf = (String) map.get("t");
            if (valueOf == null) {
                if (this.f8549f.m13094a()) {
                    com_ushareit_listenit_cvy = this.f8549f;
                    str = "Got invalid control message: ";
                    valueOf = String.valueOf(map.toString());
                    com_ushareit_listenit_cvy.m13093a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
                }
                m12016b();
            } else if (valueOf.equals("s")) {
                m12005a((String) map.get("d"));
            } else if (valueOf.equals("r")) {
                m12006b((String) map.get("d"));
            } else if (valueOf.equals("h")) {
                m12010d((Map) map.get("d"));
            } else if (this.f8549f.m13094a()) {
                com_ushareit_listenit_cvy = this.f8549f;
                str = "Ignoring unknown control message: ";
                valueOf = String.valueOf(valueOf);
                com_ushareit_listenit_cvy.m13093a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
            }
        } catch (ClassCastException e) {
            if (this.f8549f.m13094a()) {
                com_ushareit_listenit_cvy = this.f8549f;
                str = "Failed to parse control message: ";
                valueOf = String.valueOf(e.toString());
                com_ushareit_listenit_cvy.m13093a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
            }
            m12016b();
        }
    }

    private void m12010d(Map<String, Object> map) {
        long longValue = ((Long) map.get("ts")).longValue();
        this.f8547d.mo1519a((String) map.get("h"));
        String str = (String) map.get("s");
        if (this.f8548e == coi.REALTIME_CONNECTING) {
            this.f8546c.m12196b();
            m12004a(longValue, str);
        }
    }

    public void m12011a() {
        if (this.f8549f.m13094a()) {
            this.f8549f.m13093a("Opening a connection", new Object[0]);
        }
        this.f8546c.m12194a();
    }

    public void m12012a(coh com_ushareit_listenit_coh) {
        if (this.f8548e != coi.REALTIME_DISCONNECTED) {
            if (this.f8549f.m13094a()) {
                this.f8549f.m13093a("closing realtime connection", new Object[0]);
            }
            this.f8548e = coi.REALTIME_DISCONNECTED;
            if (this.f8546c != null) {
                this.f8546c.m12197c();
                this.f8546c = null;
            }
            this.f8547d.mo1518a(com_ushareit_listenit_coh);
        }
    }

    public void mo1514a(Map<String, Object> map) {
        String str;
        cvy com_ushareit_listenit_cvy;
        String str2;
        try {
            str = (String) map.get("t");
            if (str == null) {
                if (this.f8549f.m13094a()) {
                    com_ushareit_listenit_cvy = this.f8549f;
                    str2 = "Failed to parse server message: missing message type:";
                    str = String.valueOf(map.toString());
                    com_ushareit_listenit_cvy.m13093a(str.length() != 0 ? str2.concat(str) : new String(str2), new Object[0]);
                }
                m12016b();
            } else if (str.equals("d")) {
                m12007b((Map) map.get("d"));
            } else if (str.equals("c")) {
                m12009c((Map) map.get("d"));
            } else if (this.f8549f.m13094a()) {
                com_ushareit_listenit_cvy = this.f8549f;
                str2 = "Ignoring unknown server message type: ";
                str = String.valueOf(str);
                com_ushareit_listenit_cvy.m13093a(str.length() != 0 ? str2.concat(str) : new String(str2), new Object[0]);
            }
        } catch (ClassCastException e) {
            if (this.f8549f.m13094a()) {
                com_ushareit_listenit_cvy = this.f8549f;
                str2 = "Failed to parse server message: ";
                str = String.valueOf(e.toString());
                com_ushareit_listenit_cvy.m13093a(str.length() != 0 ? str2.concat(str) : new String(str2), new Object[0]);
            }
            m12016b();
        }
    }

    public void m12014a(Map<String, Object> map, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("t", "d");
        hashMap.put("d", map);
        m12008b(hashMap, z);
    }

    public void mo1515a(boolean z) {
        this.f8546c = null;
        if (z || this.f8548e != coi.REALTIME_CONNECTING) {
            if (this.f8549f.m13094a()) {
                this.f8549f.m13093a("Realtime connection lost", new Object[0]);
            }
        } else if (this.f8549f.m13094a()) {
            this.f8549f.m13093a("Realtime connection failed", new Object[0]);
        }
        m12016b();
    }

    public void m12016b() {
        m12012a(coh.OTHER);
    }
}
