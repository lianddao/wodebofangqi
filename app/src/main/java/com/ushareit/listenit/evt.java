package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class evt extends evd {
    public evt(Context context, evl com_ushareit_listenit_evl) {
        super(context, com_ushareit_listenit_evl);
    }

    public evf mo2301a(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        if (com_ushareit_listenit_eva.m18125j() == evf.WAITING) {
            evu com_ushareit_listenit_evu = new evu(com_ushareit_listenit_eva);
            if (m18214a(this.a, com_ushareit_listenit_evu.m18236v()) && (i & 1) != 0 && com_ushareit_listenit_evu.m18232r()) {
                eyh e = m18221e(com_ushareit_listenit_eva);
                if (!(e == null || !e.mo2328c() || fbj.m18784a(this.a, com_ushareit_listenit_evu.m18236v(), com_ushareit_listenit_evu.m18237w()) == 1 || com_ushareit_listenit_evu.m18238x() == 0 || com_ushareit_listenit_evu.m18238x() == 3)) {
                    fbr.m18810a(this.a);
                    if (com_ushareit_listenit_evu.m18238x() != 2 || fbr.m18807a() <= 0) {
                        int t = com_ushareit_listenit_evu.m18234t();
                        int s = com_ushareit_listenit_evu.m18233s();
                        if (t == -1 || t >= s) {
                            ewt.m18313a(this.a, com_ushareit_listenit_evu.m18099a().hashCode());
                            m18218c(i, com_ushareit_listenit_evu, e);
                            return com_ushareit_listenit_eva.m18125j();
                        }
                    }
                }
            }
        }
        super.mo2301a(i, com_ushareit_listenit_eva, bundle);
        if (com_ushareit_listenit_eva.m18125j() == evf.EXPIRED || com_ushareit_listenit_eva.m18125j() == evf.COMPLETED || com_ushareit_listenit_eva.m18125j() == evf.CANCELED || (com_ushareit_listenit_eva.m18125j() == evf.ERROR && com_ushareit_listenit_eva.m18128m())) {
            m18222f(com_ushareit_listenit_eva);
        }
        return com_ushareit_listenit_eva.m18125j();
    }

    protected evf mo2300c(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        m18143a(com_ushareit_listenit_eva, evf.RUNNING);
        evu com_ushareit_listenit_evu = new evu(com_ushareit_listenit_eva);
        evv y = com_ushareit_listenit_evu.m18239y();
        if (y == evv.NONE || y == evv.DOWNLOAD_STARTED) {
            if (m18147a(i, (eva) com_ushareit_listenit_evu, com_ushareit_listenit_eva.m18123h())) {
                if (y == evv.NONE) {
                    m18150b(com_ushareit_listenit_eva, "executed", null);
                    m18210a((eva) com_ushareit_listenit_evu, evv.DOWNLOAD_STARTED);
                }
                m18211a(com_ushareit_listenit_evu);
                y = com_ushareit_listenit_evu.m18239y();
            } else {
                m18143a(com_ushareit_listenit_eva, evf.WAITING);
                return com_ushareit_listenit_eva.m18125j();
            }
        }
        if (y == evv.DOWNLOAD_COMPLETED) {
            if (fbj.m18784a(this.a, com_ushareit_listenit_evu.m18236v(), com_ushareit_listenit_evu.m18237w()) == 1) {
                m18223g(com_ushareit_listenit_eva);
                return com_ushareit_listenit_eva.m18125j();
            }
            eyh e = m18221e(com_ushareit_listenit_evu);
            if (e == null || !e.mo2328c()) {
                m18210a((eva) com_ushareit_listenit_evu, evv.DOWNLOAD_STARTED);
                m18143a(com_ushareit_listenit_eva, evf.WAITING);
                return com_ushareit_listenit_eva.m18125j();
            }
            m18208a(i, com_ushareit_listenit_evu);
            y = com_ushareit_listenit_evu.m18239y();
        }
        if (y == evv.NOTIFY_SHOWED) {
            m18143a(com_ushareit_listenit_eva, evf.WAITING);
            return com_ushareit_listenit_eva.m18125j();
        }
        if (y == evv.USER_INSTALL_STARTED) {
            if (fbj.m18784a(this.a, com_ushareit_listenit_evu.m18236v(), com_ushareit_listenit_evu.m18237w()) == 1) {
                m18223g(com_ushareit_listenit_eva);
                return com_ushareit_listenit_eva.m18125j();
            }
            m18143a(com_ushareit_listenit_eva, evf.WAITING);
        }
        return com_ushareit_listenit_eva.m18125j();
    }

    public void mo2304a(eva com_ushareit_listenit_eva, Intent intent) {
        super.mo2304a(com_ushareit_listenit_eva, intent);
        if (intent.hasExtra("update_route")) {
            m18210a(com_ushareit_listenit_eva, evv.m18240a(intent.getStringExtra("update_route")));
        }
        if (intent.getIntExtra("next_event", 0) == 96) {
            m18216b(new evu(com_ushareit_listenit_eva));
        }
    }

    public List<String> mo2302a() {
        List<String> arrayList = new ArrayList();
        arrayList.add("android.intent.action.PACKAGE_ADDED");
        arrayList.add("android.intent.action.PACKAGE_REPLACED");
        return arrayList;
    }

    public void mo2303a(Intent intent) {
        super.mo2303a(intent);
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(action) || "android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(action)) {
                m18213a(intent.getData().getSchemeSpecificPart());
            }
        }
    }

    private void m18210a(eva com_ushareit_listenit_eva, evv com_ushareit_listenit_evv) {
        m18146a(com_ushareit_listenit_eva, "install_cmd_route", com_ushareit_listenit_evv.toString());
    }

    private void m18211a(evu com_ushareit_listenit_evu) {
        if (!fbb.m18763c(com_ushareit_listenit_evu.m18235u())) {
            eyh d = m18220d(com_ushareit_listenit_evu);
            if (d == null) {
                m18143a((eva) com_ushareit_listenit_evu, evf.ERROR);
                m18146a((eva) com_ushareit_listenit_evu, "error_reason", "dl_create_cache_file_failed");
                m18141a((eva) com_ushareit_listenit_evu);
                return;
            }
            ezs com_ushareit_listenit_ezs;
            ezi com_ushareit_listenit_ezi = new ezi(com_ushareit_listenit_evu.m18235u(), d, false);
            try {
                com_ushareit_listenit_ezi.m18623a(new ezf(30000, 30000), null, null);
                com_ushareit_listenit_ezs = null;
            } catch (ezs e) {
                com_ushareit_listenit_ezs = e;
            }
            if (!com_ushareit_listenit_ezi.m18625a()) {
                d.mo2335j();
                m18143a((eva) com_ushareit_listenit_evu, evf.ERROR);
                m18146a((eva) com_ushareit_listenit_evu, "error_reason", com_ushareit_listenit_ezs != null ? "dl_" + com_ushareit_listenit_ezs.m18640b() : "dl_failed");
                m18141a((eva) com_ushareit_listenit_evu);
            } else if (m18207a(d, (eva) com_ushareit_listenit_evu) == null) {
                m18143a((eva) com_ushareit_listenit_evu, evf.ERROR);
                m18146a((eva) com_ushareit_listenit_evu, "error_reason", "dl_create_target_file_failed");
                m18141a((eva) com_ushareit_listenit_evu);
            } else {
                m18210a((eva) com_ushareit_listenit_evu, evv.DOWNLOAD_COMPLETED);
                m18150b((eva) com_ushareit_listenit_evu, "downloaded", null);
            }
        }
    }

    private eyh m18220d(eva com_ushareit_listenit_eva) {
        if (eyj.m18516c(this.a) == null) {
            return null;
        }
        eyh b = eyd.m18471b();
        if (!b.mo2328c()) {
            b.mo2333h();
        }
        if (b.mo2328c() && b.mo2327b() && b.mo2324a()) {
            return eyh.m18488a(b, com_ushareit_listenit_eva.m18099a().hashCode() + "");
        }
        return null;
    }

    private eyh m18207a(eyh com_ushareit_listenit_eyh, eva com_ushareit_listenit_eva) {
        eyh e = m18221e(com_ushareit_listenit_eva);
        if (e == null) {
            return null;
        }
        if (e.mo2328c()) {
            e.mo2335j();
        }
        if (!com_ushareit_listenit_eyh.mo2325a(e)) {
            e = null;
        }
        return e;
    }

    private eyh m18221e(eva com_ushareit_listenit_eva) {
        if (eyj.m18516c(this.a) == null) {
            return null;
        }
        eyh c = eyd.m18472c();
        if (!c.mo2328c()) {
            c.mo2333h();
        }
        if (c.mo2328c() && c.mo2327b() && c.mo2324a()) {
            return eyh.m18488a(c, com_ushareit_listenit_eva.m18099a().hashCode() + "");
        }
        return null;
    }

    private void m18222f(eva com_ushareit_listenit_eva) {
        if (eyj.m18516c(this.a) != null) {
            eyh.m18488a(eyd.m18472c(), com_ushareit_listenit_eva.m18099a().hashCode() + "").mo2335j();
        }
    }

    private void m18208a(int i, evu com_ushareit_listenit_evu) {
        eyh e = m18221e(com_ushareit_listenit_evu);
        if (e != null && e.mo2328c()) {
            switch (com_ushareit_listenit_evu.m18238x()) {
                case 0:
                    m18217b(com_ushareit_listenit_evu, e);
                    return;
                case 1:
                    m18209a(i, com_ushareit_listenit_evu, e);
                    return;
                case 2:
                    m18215b(i, com_ushareit_listenit_evu, e);
                    return;
                case 3:
                    m18212a(com_ushareit_listenit_evu, e);
                    return;
                default:
                    exu.m18432a("Install mode is invalid!");
                    return;
            }
        }
    }

    private void m18212a(evu com_ushareit_listenit_evu, eyh com_ushareit_listenit_eyh) {
        if (!eve.m18153a().m18163f()) {
            m18143a((eva) com_ushareit_listenit_evu, evf.ERROR);
            m18146a((eva) com_ushareit_listenit_evu, "error_reason", "NOT_AUTO_UPDATE");
        }
        m18217b(com_ushareit_listenit_evu, com_ushareit_listenit_eyh);
    }

    private void m18217b(evu com_ushareit_listenit_evu, eyh com_ushareit_listenit_eyh) {
        fbr.m18810a(this.a);
        if ((fbr.m18807a() > 0 ? 1 : null) != null) {
            int a = fbj.m18783a(this.a, com_ushareit_listenit_eyh.mo2336k().getAbsolutePath());
            if (a == 0) {
                exw.m18449b("CMD.InstallAppHandler", "exec installSilent() success!");
                m18223g(com_ushareit_listenit_evu);
                return;
            }
            exw.m18449b("CMD.InstallAppHandler", "exec installSilent() failed, result = " + a);
            m18143a((eva) com_ushareit_listenit_evu, evf.ERROR);
            switch (a) {
                case -1:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_PERMISSION_INVALID");
                    return;
                case 1:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_FAILED_UNEXPECTED_EXCEPTION");
                    return;
                case 2:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_FAILED_CONTAINER_ERROR");
                    return;
                case 3:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_FAILED_PACKAGE_UPDATE_ERROR");
                    return;
                case 4:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_FAILED_PACKAGE_INVALID");
                    return;
                case 5:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_FAILED_PACKAGE_CONTENT_ERROR");
                    return;
                case 6:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_FAILED_PACKAGE_CERTIFICATE_ERROR");
                    return;
                case 7:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_FAILED_MISSING_SHARED_LIBRARY");
                    return;
                case 8:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_FAILED_INSUFFICIENT_STORAGE");
                    return;
                case 9:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_FAILED_UID_CHANGED");
                    return;
                default:
                    m18146a((eva) com_ushareit_listenit_evu, "error_reason", "INSTALL_FAILED_UNKNOWN");
                    return;
            }
        }
        m18143a((eva) com_ushareit_listenit_evu, evf.ERROR);
        m18146a((eva) com_ushareit_listenit_evu, "error_reason", "NO_ROOT");
    }

    private void m18209a(int i, evu com_ushareit_listenit_evu, eyh com_ushareit_listenit_eyh) {
        if (m18147a(i, (eva) com_ushareit_listenit_evu, com_ushareit_listenit_evu.m18124i())) {
            evv y = com_ushareit_listenit_evu.m18239y();
            if (y != evv.INSTALL_COMPLETED && y != evv.NOTIFY_SHOWED) {
                if (!com_ushareit_listenit_evu.m18231q() && !com_ushareit_listenit_evu.m18232r()) {
                    return;
                }
                if (com_ushareit_listenit_evu.m18231q()) {
                    m18145a((eva) com_ushareit_listenit_evu, com_ushareit_listenit_evu.m18229a(com_ushareit_listenit_evu.m18099a().hashCode(), m18219c(com_ushareit_listenit_evu)));
                    m18210a((eva) com_ushareit_listenit_evu, evv.NOTIFY_SHOWED);
                    return;
                } else if (com_ushareit_listenit_evu.m18232r()) {
                    m18144a((eva) com_ushareit_listenit_evu, com_ushareit_listenit_evu.m18230b(com_ushareit_listenit_evu.m18099a().hashCode(), m18219c(com_ushareit_listenit_evu)));
                    m18210a((eva) com_ushareit_listenit_evu, evv.NOTIFY_SHOWED);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        m18143a((eva) com_ushareit_listenit_evu, evf.WAITING);
    }

    private void m18215b(int i, evu com_ushareit_listenit_evu, eyh com_ushareit_listenit_eyh) {
        fbr.m18810a(this.a);
        Object obj = fbr.m18807a() > 0 ? 1 : null;
        boolean f = eve.m18153a().m18163f();
        if (obj != null && f && fbj.m18783a(this.a, com_ushareit_listenit_eyh.mo2336k().getAbsolutePath()) == 0) {
            m18223g(com_ushareit_listenit_evu);
        } else {
            m18209a(i, com_ushareit_listenit_evu, com_ushareit_listenit_eyh);
        }
    }

    private void m18216b(evu com_ushareit_listenit_evu) {
        eyh e = m18221e(com_ushareit_listenit_evu);
        if (e != null && e.mo2328c()) {
            m18210a((eva) com_ushareit_listenit_evu, evv.USER_INSTALL_STARTED);
            if ((fbr.m18807a() > 0 ? 1 : null) == null || fbj.m18783a(this.a, e.mo2336k().getAbsolutePath()) != 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(e.mo2336k()), "application/vnd.android.package-archive");
                intent.setFlags(335544320);
                this.a.startActivity(intent);
                return;
            }
            m18223g(com_ushareit_listenit_evu);
        }
    }

    private void m18218c(int i, evu com_ushareit_listenit_evu, eyh com_ushareit_listenit_eyh) {
        if (m18147a(i, (eva) com_ushareit_listenit_evu, com_ushareit_listenit_evu.m18124i()) && com_ushareit_listenit_evu.m18232r()) {
            m18144a((eva) com_ushareit_listenit_evu, com_ushareit_listenit_evu.m18230b(com_ushareit_listenit_evu.m18099a().hashCode(), m18219c(com_ushareit_listenit_evu)));
            m18210a((eva) com_ushareit_listenit_evu, evv.NOTIFY_SHOWED);
        }
    }

    private void m18213a(String str) {
        List<eva> a = this.b.m18167a("pkg_name", str);
        if (a != null && a.size() > 0) {
            for (eva com_ushareit_listenit_eva : a) {
                if ("cmd_type_install_app".equalsIgnoreCase(com_ushareit_listenit_eva.m18107b()) && com_ushareit_listenit_eva.m18125j() != evf.COMPLETED) {
                    evu com_ushareit_listenit_evu = new evu(com_ushareit_listenit_eva);
                    if (fbj.m18784a(this.a, com_ushareit_listenit_evu.m18236v(), com_ushareit_listenit_evu.m18237w()) == 1) {
                        m18223g(com_ushareit_listenit_eva);
                    }
                }
            }
        }
    }

    private void m18223g(eva com_ushareit_listenit_eva) {
        exw.m18449b("CMD.InstallAppHandler", "fireOnInstalled() called");
        m18210a(com_ushareit_listenit_eva, evv.INSTALL_COMPLETED);
        m18143a(com_ushareit_listenit_eva, evf.COMPLETED);
        m18150b(com_ushareit_listenit_eva, "installed", null);
        m18150b(com_ushareit_listenit_eva, "completed", null);
    }

    private static boolean m18214a(Context context, String str) {
        if (context == null || fbb.m18763c(str)) {
            return false;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            return str.equalsIgnoreCase(applicationInfo.packageName);
        }
        return false;
    }

    private boolean m18219c(evu com_ushareit_listenit_evu) {
        if (!m18214a(this.a, com_ushareit_listenit_evu.m18236v()) || !com_ushareit_listenit_evu.m18232r()) {
            return true;
        }
        int t = com_ushareit_listenit_evu.m18234t();
        int s = com_ushareit_listenit_evu.m18233s();
        if (t == -1 || t > s) {
            return false;
        }
        return true;
    }
}
