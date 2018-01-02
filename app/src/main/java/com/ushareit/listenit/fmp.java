package com.ushareit.listenit;

import android.net.Uri;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class fmp extends fjy {
    public void m19935a(fjz com_ushareit_listenit_fjz) {
        exw.m18443a("UserInfoSync", "startSyncUserInfo");
        fjy.m19571a().m16736a("syncTime").m16736a("all").m16736a(fnh.KEY_USERINFO).m16726a(new fmq(this, com_ushareit_listenit_fjz));
    }

    private void m19931d(fjz com_ushareit_listenit_fjz) {
        m19936a(new fmy(this, com_ushareit_listenit_fjz));
    }

    public void m19936a(get com_ushareit_listenit_get) {
        String j = gvj.m22978j(eys.m18562a(), gef.m21805a().m21837g());
        exw.m18454c("UserInfoSync", "user photo url:" + j);
        if (!fbb.m18763c(j) || com_ushareit_listenit_get == null) {
            String f = gyn.m23238f();
            if (!eyh.m18491a(f).mo2328c() || com_ushareit_listenit_get == null) {
                hhx.m23867a(new fna(this, "syncUserInfo", j, f, com_ushareit_listenit_get));
                return;
            } else {
                com_ushareit_listenit_get.mo2405a();
                return;
            }
        }
        com_ushareit_listenit_get.mo2405a();
    }

    private void m19932e(fjz com_ushareit_listenit_fjz) {
        exw.m18443a("UserInfoSync", "uploadAll");
        long currentTimeMillis = System.currentTimeMillis();
        Map hashMap = new HashMap();
        fnp l = fle.m19717b().m19746l();
        fnq com_ushareit_listenit_fnq = new fnq(currentTimeMillis, currentTimeMillis);
        hashMap.put(m19577a("userInfo"), l.toMap());
        hashMap.put(m19577a("syncTime", "all", fnh.KEY_USERINFO), Long.valueOf(currentTimeMillis));
        hashMap.put(m19577a("syncTime", "sub", "userInfo"), com_ushareit_listenit_fnq.toMap());
        fjy.m19571a().m16734a(hashMap).mo2124a(new fnb(this, com_ushareit_listenit_fjz, currentTimeMillis));
    }

    private void m19926b(long j, fjz com_ushareit_listenit_fjz) {
        long d = fle.m19717b().m19734d();
        exw.m18443a("UserInfoSync", "syncAll, cloudSyncTime=" + j + ", isUserInfoModified=" + fle.m19717b().m19750p() + ", localSyncTime=" + d);
        fle.m19717b().m19755u();
        if (j != fle.m19717b().m19734d() || fle.m19717b().m19750p()) {
            if (j == d && fka.m19602g()) {
                fnq f = fka.m19601f();
                if (f != null) {
                    exw.m18443a("UserInfoSync", "syncAll: from cache");
                    m19924a(f, com_ushareit_listenit_fjz, j);
                    fiw.m19466c(j, d, true);
                    return;
                }
            }
            fjy.m19571a().m16736a("syncTime").m16736a("sub").m16736a("userInfo").m16726a(new fnc(this, com_ushareit_listenit_fjz, j));
            fiw.m19466c(j, d, false);
            return;
        }
        exw.m18443a("UserInfoSync", "syncAll, NO SYNC OK");
        if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19582a(-1);
        }
    }

    private void m19924a(fnq com_ushareit_listenit_fnq, fjz com_ushareit_listenit_fjz, long j) {
        fjz com_ushareit_listenit_fnd = new fnd(this, 2, j, com_ushareit_listenit_fjz);
        m19923a(com_ushareit_listenit_fnq, com_ushareit_listenit_fnd);
        m19928b(com_ushareit_listenit_fnq, com_ushareit_listenit_fnd);
    }

    private void m19925a(boolean z, long j, long j2, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("UserInfoSync", "syncAll, finish: isSuccess=" + z + ", syncTime=" + j);
        if (z) {
            if (j == -1) {
                fle.m19717b().m19723a(j2);
                fle.m19717b().m19726a(false);
                if (com_ushareit_listenit_fjz != null) {
                    com_ushareit_listenit_fjz.m19582a(j);
                    return;
                }
                return;
            }
            fjy.m19571a().m16736a("syncTime").m16736a("all").m16736a(fnh.KEY_USERINFO).m16733a(Long.valueOf(j)).mo2124a(new fne(this, com_ushareit_listenit_fjz, j));
        } else if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19580a();
        }
    }

    private void m19923a(fnq com_ushareit_listenit_fnq, fjz com_ushareit_listenit_fjz) {
        if (fle.m19717b().m19742h() != com_ushareit_listenit_fnq.getNa()) {
            m19929c(com_ushareit_listenit_fnq.getNa(), com_ushareit_listenit_fjz);
        } else if (fle.m19717b().m19753s()) {
            m19937a(fle.m19717b().m19748n(), com_ushareit_listenit_fjz);
        } else if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19582a(-1);
        }
    }

    private void m19929c(long j, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("UserInfoSync", "downloadUserName");
        fle.m19717b().m19736d(false);
        fjy.m19571a().m16736a("userInfo").m16736a("na").m16726a(new fnf(this, com_ushareit_listenit_fjz, j));
    }

    public void m19937a(String str, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("UserInfoSync", "uploadUserName: userName=" + str);
        long currentTimeMillis = System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put(m19577a("userInfo", "na"), str);
        hashMap.put(m19577a("syncTime", "sub", "userInfo", "na"), Long.valueOf(currentTimeMillis));
        fjy.m19571a().m16734a(hashMap).mo2124a(new fng(this, com_ushareit_listenit_fjz, currentTimeMillis));
    }

    private void m19928b(fnq com_ushareit_listenit_fnq, fjz com_ushareit_listenit_fjz) {
        if (fle.m19717b().m19743i() != com_ushareit_listenit_fnq.getAv()) {
            m19930d(com_ushareit_listenit_fnq.getAv(), com_ushareit_listenit_fjz);
        } else if (fle.m19717b().m19754t()) {
            m19938b(com_ushareit_listenit_fjz);
        } else if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19582a(-1);
        }
    }

    private void m19930d(long j, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("UserInfoSync", "downloadUserAvator");
        m19933f(new fmr(this, j, com_ushareit_listenit_fjz));
        fiw.m19484n(eys.m18562a());
    }

    private void m19933f(fjz com_ushareit_listenit_fjz) {
        String m = fle.m19717b().m19747m();
        File file = new File(gyn.m23253l(m));
        exw.m18443a("UserInfoSync", "start downloadUserAvatorData, uid=" + m + ", isExist=" + file.exists());
        fqn.m20403a(m).m17007a(file).m16927b(new fmt(this, com_ushareit_listenit_fjz)).m16924a(new fms(this, com_ushareit_listenit_fjz));
    }

    public void m19938b(fjz com_ushareit_listenit_fjz) {
        m19939c(new fmu(this, com_ushareit_listenit_fjz));
    }

    public void m19934a(long j, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("UserInfoSync", "uploadUserAvatorInfo");
        Map hashMap = new HashMap();
        hashMap.put(m19577a("syncTime", "sub", "userInfo", "av"), Long.valueOf(j));
        fjy.m19571a().m16734a(hashMap).mo2124a(new fmv(this, com_ushareit_listenit_fjz, j));
    }

    public void m19939c(fjz com_ushareit_listenit_fjz) {
        exw.m18443a("UserInfoSync", "uploadUserAvatorData");
        File file = new File(gyn.m23238f());
        exw.m18443a("UserInfoSync", "uploadUserAvator: isExist=" + file.exists());
        if (file.exists()) {
            try {
                fqn.m20403a(fle.m19717b().m19747m()).m17010a(Uri.fromFile(file)).m16927b(new fmx(this, com_ushareit_listenit_fjz)).m16924a(new fmw(this, com_ushareit_listenit_fjz));
            } catch (Exception e) {
                exw.m18457e("UserInfoSync", "upload userIcon error");
                if (com_ushareit_listenit_fjz != null) {
                    com_ushareit_listenit_fjz.m19580a();
                }
            }
        } else if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19582a(System.currentTimeMillis());
        }
    }
}
