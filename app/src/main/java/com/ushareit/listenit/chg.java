package com.ushareit.listenit;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.HashMap;

final class chg extends chf implements Callback {
    private final HashMap<chh, chi> f8295a = new HashMap();
    private final Context f8296b;
    private final Handler f8297c;
    private final cig f8298d;
    private final long f8299e;

    chg(Context context) {
        this.f8296b = context.getApplicationContext();
        this.f8297c = new Handler(context.getMainLooper(), this);
        this.f8298d = cig.m11364a();
        this.f8299e = 5000;
    }

    private boolean m11225a(chh com_ushareit_listenit_chh, ServiceConnection serviceConnection, String str) {
        boolean a;
        cfi.m11081a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f8295a) {
            chi com_ushareit_listenit_chi = (chi) this.f8295a.get(com_ushareit_listenit_chh);
            if (com_ushareit_listenit_chi != null) {
                this.f8297c.removeMessages(0, com_ushareit_listenit_chi);
                if (!com_ushareit_listenit_chi.m11240a(serviceConnection)) {
                    com_ushareit_listenit_chi.m11237a(serviceConnection, str);
                    switch (com_ushareit_listenit_chi.m11241b()) {
                        case 1:
                            serviceConnection.onServiceConnected(com_ushareit_listenit_chi.m11246e(), com_ushareit_listenit_chi.m11245d());
                            break;
                        case 2:
                            com_ushareit_listenit_chi.m11238a(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(com_ushareit_listenit_chh);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            com_ushareit_listenit_chi = new chi(this, com_ushareit_listenit_chh);
            com_ushareit_listenit_chi.m11237a(serviceConnection, str);
            com_ushareit_listenit_chi.m11238a(str);
            this.f8295a.put(com_ushareit_listenit_chh, com_ushareit_listenit_chi);
            a = com_ushareit_listenit_chi.m11239a();
        }
        return a;
    }

    private void m11227b(chh com_ushareit_listenit_chh, ServiceConnection serviceConnection, String str) {
        cfi.m11081a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f8295a) {
            chi com_ushareit_listenit_chi = (chi) this.f8295a.get(com_ushareit_listenit_chh);
            String valueOf;
            if (com_ushareit_listenit_chi == null) {
                valueOf = String.valueOf(com_ushareit_listenit_chh);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (com_ushareit_listenit_chi.m11240a(serviceConnection)) {
                com_ushareit_listenit_chi.m11242b(serviceConnection, str);
                if (com_ushareit_listenit_chi.m11244c()) {
                    this.f8297c.sendMessageDelayed(this.f8297c.obtainMessage(0, com_ushareit_listenit_chi), this.f8299e);
                }
            } else {
                valueOf = String.valueOf(com_ushareit_listenit_chh);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public boolean mo1320a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return m11225a(new chh(str, str2), serviceConnection, str3);
    }

    public void mo1321b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        m11227b(new chh(str, str2), serviceConnection, str3);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                chi com_ushareit_listenit_chi = (chi) message.obj;
                synchronized (this.f8295a) {
                    if (com_ushareit_listenit_chi.m11244c()) {
                        if (com_ushareit_listenit_chi.m11239a()) {
                            com_ushareit_listenit_chi.m11243b("GmsClientSupervisor");
                        }
                        this.f8295a.remove(com_ushareit_listenit_chi.f8309g);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
