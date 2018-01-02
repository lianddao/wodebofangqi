package com.ushareit.listenit;

import java.util.List;

public class glp {
    private static int f14371a = -1;
    private static int f14372b = 0;

    public static void m22383a(gmb com_ushareit_listenit_gmb) {
        m22388b(new glq(com_ushareit_listenit_gmb));
    }

    public static void m22388b(gmb<List<fni>> com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni) {
        switch (f14371a) {
            case 0:
            case 2:
                if (gvj.m23018p() > fqk.m20386l() && ((long) f14372b) < fqk.m20383i()) {
                    m22379a(gvj.m23018p(), 20, (gmb) com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni);
                    f14372b++;
                    return;
                } else if (com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni != null) {
                    com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni.mo2715a(null);
                    return;
                } else {
                    return;
                }
            case 1:
                exw.m18443a("NearbyProvider", "loadMoreNearbyUsers, lastLoadSource=default");
                if (com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni != null) {
                    com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni.mo2715a(null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void m22391c(gmb com_ushareit_listenit_gmb) {
        m22393d(new glr(com_ushareit_listenit_gmb));
    }

    private static void m22393d(gmb<List<fni>> com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni) {
        int i = gef.m21805a().m21835e() ? 20 : 5;
        if (frc.m20595d()) {
            if (System.currentTimeMillis() - gvj.ar(eys.m18562a()) < fqk.m20384j()) {
                m22395e(com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni);
                return;
            } else if (gln.m22372a()) {
                m22379a(fqk.m20386l(), i, (gmb) com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni);
                return;
            } else {
                m22387b(i, com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni);
                return;
            }
        }
        exw.m18443a("NearbyProvider", "first load: country=" + gyn.m23252k() + ", isUserLocationValid=" + gln.m22372a());
        if (fbb.m18763c(gyn.m23252k()) || !gln.m22372a()) {
            m22387b(i, com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni);
        } else {
            m22379a(fqk.m20386l(), i, (gmb) com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fni);
        }
    }

    private static void m22395e(gmb com_ushareit_listenit_gmb) {
        List b = frc.m20590b();
        f14371a = 2;
        if (com_ushareit_listenit_gmb != null) {
            com_ushareit_listenit_gmb.mo2715a(b);
        }
    }

    private static void m22379a(int i, int i2, gmb com_ushareit_listenit_gmb) {
        fjy.m19574b().m16727b("sgN").m16723a((double) i).m16725a(i2).m16726a(new gls(com_ushareit_listenit_gmb, System.currentTimeMillis(), i2));
    }

    private static void m22392c(List<fni> list) {
        if (list != null && list.size() != 0) {
            String m = fle.m19717b().m19747m();
            if (!fbb.m18763c(m)) {
                fni com_ushareit_listenit_fni = null;
                for (fni com_ushareit_listenit_fni2 : list) {
                    fni com_ushareit_listenit_fni22;
                    if (fbb.m18763c(com_ushareit_listenit_fni22.getId()) || !m.equals(com_ushareit_listenit_fni22.getId())) {
                        com_ushareit_listenit_fni22 = com_ushareit_listenit_fni;
                    }
                    com_ushareit_listenit_fni = com_ushareit_listenit_fni22;
                }
                if (com_ushareit_listenit_fni != null) {
                    list.remove(com_ushareit_listenit_fni);
                }
                exw.m18443a("NearbyProvider", "excludeUserself, " + (com_ushareit_listenit_fni != null));
            }
        }
    }

    private static void m22387b(int i, gmb com_ushareit_listenit_gmb) {
        exw.m18443a("NearbyProvider", "start loadNearbyRobotUsers limit=" + i);
        fjy.m19576c().m16727b(fni.KEY_LONGITUDE).m16725a(i).m16726a(new glu(com_ushareit_listenit_gmb, System.currentTimeMillis()));
    }

    public static void m22382a(fni com_ushareit_listenit_fni, gmb<List<fnl>> com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fnl) {
        String id = com_ushareit_listenit_fni.getId();
        List a = frc.m20584a(id);
        String str = "NearbyProvider";
        StringBuilder append = new StringBuilder().append("startLoadShareLists, uid=").append(id).append(", isExistInDB=");
        boolean z = a != null && a.size() > 0;
        exw.m18443a(str, append.append(z).toString());
        if (a == null || a.size() <= 0) {
            fjy.m19572a(id).m16726a(new glv(id, System.currentTimeMillis(), com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fnl, com_ushareit_listenit_fni));
            return;
        }
        exw.m18443a("NearbyProvider", "loadShareListsFromDB, success, size=" + a.size());
        if (com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fnl != null) {
            com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fnl.mo2715a(a);
        }
    }

    public static void m22381a(fni com_ushareit_listenit_fni, fnl com_ushareit_listenit_fnl, gmb<List<fri>> com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fri) {
        List a = frc.m20585a(com_ushareit_listenit_fni.getId(), com_ushareit_listenit_fnl.getId());
        exw.m18443a("NearbyProvider", "startLoadShareListSongs: uid=" + com_ushareit_listenit_fni.getId() + ", playlistId=" + com_ushareit_listenit_fnl.getId() + ", sizeInDB=" + (a != null ? a.size() : 0));
        if (a == null || a.size() <= 0) {
            String id = com_ushareit_listenit_fni.getId();
            String id2 = com_ushareit_listenit_fnl.getId();
            m22384a(id, id2, new glw(id, id2, com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fri));
            return;
        }
        m22394d(a);
        if (com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fri != null) {
            com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fri.mo2715a(a);
        }
    }

    private static void m22394d(List<fri> list) {
        for (fri com_ushareit_listenit_fri : list) {
            if (frf.m20654a(frf.m20632a(), com_ushareit_listenit_fri.f13287h, com_ushareit_listenit_fri.f13281b, com_ushareit_listenit_fri.f13282c)) {
                com_ushareit_listenit_fri.m20703a(true);
            }
        }
    }

    private static void m22389b(String str, List<String> list, gmb<List<fri>> com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fri) {
        exw.m18443a("NearbyProvider", "start loadShareListSongs, uid=" + str + ", songIdsSize=" + list.size());
        gmc com_ushareit_listenit_gly = new gly(list.size(), com_ushareit_listenit_gmb_java_util_List_com_ushareit_listenit_fri);
        for (String b : list) {
            fjy.m19575b(str, b).m16726a(new glz(com_ushareit_listenit_gly, System.currentTimeMillis()));
        }
    }

    private static void m22384a(String str, String str2, gmb<List<String>> com_ushareit_listenit_gmb_java_util_List_java_lang_String) {
        exw.m18443a("NearbyProvider", "start loadShareListSongIds, uid=" + str + ", playlistId=" + str2);
        fjy.m19573a(str, str2).m16726a(new gma(com_ushareit_listenit_gmb_java_util_List_java_lang_String, System.currentTimeMillis()));
    }
}
