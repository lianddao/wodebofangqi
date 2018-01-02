package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.analytics.pro.C0321x;
import java.util.ArrayList;
import java.util.List;

public abstract class evd {
    protected Context f11930a;
    protected evl f11931b;

    protected abstract evf mo2300c(int i, eva com_ushareit_listenit_eva, Bundle bundle);

    public evd(Context context, evl com_ushareit_listenit_evl) {
        this.f11930a = context;
        this.f11931b = com_ushareit_listenit_evl;
    }

    public evf mo2301a(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        if (com_ushareit_listenit_eva.m18125j() == evf.RUNNING || com_ushareit_listenit_eva.m18125j() == evf.CANCELED || com_ushareit_listenit_eva.m18125j() == evf.EXPIRED || com_ushareit_listenit_eva.m18125j() == evf.COMPLETED || (com_ushareit_listenit_eva.m18125j() == evf.ERROR && com_ushareit_listenit_eva.m18128m())) {
            mo2299b(i, com_ushareit_listenit_eva, bundle);
            return com_ushareit_listenit_eva.m18125j();
        } else if (com_ushareit_listenit_eva.m18130o()) {
            if (com_ushareit_listenit_eva.m18125j() == evf.ERROR && !com_ushareit_listenit_eva.m18128m()) {
                m18143a(com_ushareit_listenit_eva, evf.EXPIRED);
                m18150b(com_ushareit_listenit_eva, C0321x.aF, com_ushareit_listenit_eva.m18119e("error_reason"));
            } else if (com_ushareit_listenit_eva.m18125j() == evf.WAITING) {
                m18143a(com_ushareit_listenit_eva, evf.EXPIRED);
                m18150b(com_ushareit_listenit_eva, "expired", com_ushareit_listenit_eva.m18108b("conds_detail", null));
            }
            return com_ushareit_listenit_eva.m18125j();
        } else {
            mo2299b(i, com_ushareit_listenit_eva, bundle);
            if (com_ushareit_listenit_eva.m18129n()) {
                m18143a(com_ushareit_listenit_eva, evf.WAITING);
                return com_ushareit_listenit_eva.m18125j();
            }
            try {
                mo2300c(i, com_ushareit_listenit_eva, bundle);
            } catch (Exception e) {
                m18143a(com_ushareit_listenit_eva, evf.ERROR);
                m18146a(com_ushareit_listenit_eva, "error_reason", "doHandleCommand Exception : " + e.toString());
            }
            if (com_ushareit_listenit_eva.m18125j() == evf.ERROR) {
                m18149b(com_ushareit_listenit_eva);
                if (com_ushareit_listenit_eva.m18128m()) {
                    m18150b(com_ushareit_listenit_eva, C0321x.aF, com_ushareit_listenit_eva.m18119e("error_reason"));
                }
            }
            return com_ushareit_listenit_eva.m18125j();
        }
    }

    protected void mo2299b(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
    }

    public List<String> mo2302a() {
        return new ArrayList();
    }

    public void mo2303a(Intent intent) {
    }

    public void mo2304a(eva com_ushareit_listenit_eva, Intent intent) {
        String str = null;
        if (com_ushareit_listenit_eva != null && intent != null) {
            try {
                if (intent.hasExtra("update_status")) {
                    m18143a(com_ushareit_listenit_eva, evf.m18164a(intent.getStringExtra("update_status")));
                }
                if (intent.hasExtra("report_status")) {
                    m18150b(com_ushareit_listenit_eva, intent.getStringExtra("report_status"), intent.hasExtra("report_detail") ? intent.getStringExtra("report_detail") : null);
                }
                if (intent.hasExtra("next_event")) {
                    int intExtra = intent.getIntExtra("next_event", 0);
                    if (intent.hasExtra("next_uri")) {
                        str = intent.getStringExtra("next_uri");
                    }
                    switch (intExtra) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 13:
                            ewt.m18321a(this.f11930a, com_ushareit_listenit_eva.m18099a(), intExtra, str);
                            return;
                        case 94:
                            m18145a(com_ushareit_listenit_eva, new evi(str));
                            return;
                        case 95:
                            m18144a(com_ushareit_listenit_eva, new evh(str));
                            return;
                        default:
                            return;
                    }
                    exw.m18449b("CMD.Handler", e.toString());
                }
            } catch (Exception e) {
                exw.m18449b("CMD.Handler", e.toString());
            }
        }
    }

    public static Intent m18136a(eva com_ushareit_listenit_eva, evf com_ushareit_listenit_evf, int i, String str) {
        return m18137a(com_ushareit_listenit_eva, com_ushareit_listenit_evf, i, str, null, null);
    }

    public static Intent m18137a(eva com_ushareit_listenit_eva, evf com_ushareit_listenit_evf, int i, String str, String str2, String str3) {
        Intent intent = new Intent("com.ushareit.cmd.action.COMMAND_WRAPPER_EVENT");
        intent.setPackage(eys.m18562a().getPackageName());
        intent.putExtra("cmd_id", com_ushareit_listenit_eva.m18099a());
        if (com_ushareit_listenit_evf != null) {
            intent.putExtra("update_status", com_ushareit_listenit_evf.toString());
        }
        intent.putExtra("next_event", i);
        if (fbb.m18765d(str)) {
            intent.putExtra("next_uri", str);
        }
        if (fbb.m18765d(str2)) {
            intent.putExtra("report_status", str2);
        }
        if (fbb.m18765d(str3)) {
            intent.putExtra("report_detail", str3);
        }
        return intent;
    }

    protected void m18143a(eva com_ushareit_listenit_eva, evf com_ushareit_listenit_evf) {
        if (com_ushareit_listenit_eva != null && com_ushareit_listenit_evf != null) {
            com_ushareit_listenit_eva.m18102a(com_ushareit_listenit_evf);
            this.f11931b.m18172a(com_ushareit_listenit_eva.m18099a(), com_ushareit_listenit_evf);
            exw.m18449b("CMD.Handler", "updateStatus: cmd: " + com_ushareit_listenit_eva.m18099a() + ", status: " + com_ushareit_listenit_evf.toString());
        }
    }

    protected void m18146a(eva com_ushareit_listenit_eva, String str, String str2) {
        com_ushareit_listenit_eva.m18104a(str, str2);
        this.f11931b.m18173a(com_ushareit_listenit_eva.m18099a(), str, str2);
        exw.m18449b("CMD.Handler", "updateProperty: cmd: " + com_ushareit_listenit_eva.m18099a() + ", key: " + str + ", value: " + str2);
    }

    protected void m18141a(eva com_ushareit_listenit_eva) {
        if (com_ushareit_listenit_eva != null) {
            com_ushareit_listenit_eva.m18109b(0);
            this.f11931b.m18171a(com_ushareit_listenit_eva.m18099a(), com_ushareit_listenit_eva.m18126k());
            exw.m18449b("CMD.Handler", "clearRetryCount: cmd: " + com_ushareit_listenit_eva.m18099a() + ", retry count: " + com_ushareit_listenit_eva.m18126k());
        }
    }

    protected void m18149b(eva com_ushareit_listenit_eva) {
        if (com_ushareit_listenit_eva != null) {
            com_ushareit_listenit_eva.m18127l();
            this.f11931b.m18171a(com_ushareit_listenit_eva.m18099a(), com_ushareit_listenit_eva.m18126k());
            exw.m18449b("CMD.Handler", "increaseRetryCount: cmd: " + com_ushareit_listenit_eva.m18099a() + ", retry count: " + com_ushareit_listenit_eva.m18126k());
        }
    }

    protected void m18152c(eva com_ushareit_listenit_eva) {
        if (com_ushareit_listenit_eva != null) {
            com_ushareit_listenit_eva.m18109b(com_ushareit_listenit_eva.m18120f());
            this.f11931b.m18171a(com_ushareit_listenit_eva.m18099a(), com_ushareit_listenit_eva.m18126k());
            exw.m18449b("CMD.Handler", "updateToMaxRetry: cmd: " + com_ushareit_listenit_eva.m18099a() + ", retry count: " + com_ushareit_listenit_eva.m18126k());
        }
    }

    protected void m18150b(eva com_ushareit_listenit_eva, String str, String str2) {
        long j = 0;
        if (!"arrived".equalsIgnoreCase(str)) {
            j = System.currentTimeMillis() - com_ushareit_listenit_eva.m18131p();
        }
        ewt.m18316a(this.f11930a, this.f11931b, new evp(com_ushareit_listenit_eva.m18099a(), str, str2, j));
    }

    protected void m18145a(eva com_ushareit_listenit_eva, evi com_ushareit_listenit_evi) {
        if (com_ushareit_listenit_evi != null) {
            m18150b(com_ushareit_listenit_eva, "showed", "Notification");
            eve.m18153a().m18157b(System.currentTimeMillis());
            ewt.m18315a(this.f11930a, com_ushareit_listenit_evi);
            exw.m18449b("CMD.Handler", "showNotification: " + com_ushareit_listenit_evi.toString());
        }
    }

    protected void m18144a(eva com_ushareit_listenit_eva, evh com_ushareit_listenit_evh) {
        if (com_ushareit_listenit_evh != null) {
            m18150b(com_ushareit_listenit_eva, "showed", "Msgbox");
            eve.m18153a().m18157b(System.currentTimeMillis());
            com_ushareit_listenit_evh.f11952k++;
            com_ushareit_listenit_eva.m18104a("msgbox_disp_count", com_ushareit_listenit_evh.f11952k + "");
            this.f11931b.m18173a(com_ushareit_listenit_eva.m18099a(), "msgbox_disp_count", com_ushareit_listenit_evh.f11952k + "");
            ewt.m18314a(this.f11930a, com_ushareit_listenit_evh);
            exw.m18449b("CMD.Handler", "showMsgBox: " + com_ushareit_listenit_evh.toString());
        }
    }

    protected boolean m18147a(int i, eva com_ushareit_listenit_eva, evb com_ushareit_listenit_evb) {
        if (com_ushareit_listenit_evb == null) {
            return true;
        }
        if (!ewt.m18322b(this.f11930a, com_ushareit_listenit_evb)) {
            m18146a(com_ushareit_listenit_eva, "conds_detail", "Preinstall condition not pass");
            return false;
        } else if (!ewt.m18320a(this.f11930a, com_ushareit_listenit_evb)) {
            m18146a(com_ushareit_listenit_eva, "conds_detail", "Network condition not pass");
            return false;
        } else if ((com_ushareit_listenit_evb.f11925b & i) == 0) {
            m18146a(com_ushareit_listenit_eva, "conds_detail", "Portal condition not pass");
            return false;
        } else if (!fbb.m18765d(com_ushareit_listenit_eva.m18108b("conds_detail", null))) {
            return true;
        } else {
            m18146a(com_ushareit_listenit_eva, "conds_detail", "");
            return true;
        }
    }
}
