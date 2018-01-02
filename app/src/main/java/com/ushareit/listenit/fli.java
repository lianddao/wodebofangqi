package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class fli extends fjy {
    public void m19774a(fjz com_ushareit_listenit_fjz) {
        fjy.m19571a().m16736a("syncTime").m16736a("all").m16736a(fnh.KEY_PLAYLIST).m16726a(new flj(this, com_ushareit_listenit_fjz));
    }

    public void m19775b(fjz com_ushareit_listenit_fjz) {
        exw.m18443a("PlaylistSync", "uploadAll");
        long currentTimeMillis = System.currentTimeMillis();
        Map linkedHashMap = new LinkedHashMap();
        List<glc> o = fqs.m20482o();
        Map linkedHashMap2 = new LinkedHashMap(o.size());
        int i = 0;
        for (glc com_ushareit_listenit_glc : o) {
            fnj com_ushareit_listenit_fnj = new fnj(com_ushareit_listenit_glc);
            com_ushareit_listenit_fnj.setSt(currentTimeMillis);
            Object[] objArr = new Object[1];
            int i2 = i + 1;
            objArr[0] = Integer.valueOf(i);
            linkedHashMap2.put(String.format(Locale.US, "%02d", objArr), com_ushareit_listenit_fnj.toMap());
            fnk com_ushareit_listenit_fnk = new fnk(com_ushareit_listenit_glc);
            com_ushareit_listenit_fnk.setSt(currentTimeMillis);
            linkedHashMap.put(m19577a("playlists", com_ushareit_listenit_glc.f14283c), com_ushareit_listenit_fnk.toMap());
            i = i2;
        }
        linkedHashMap.put(m19577a("syncTime", "sub", "playlists"), linkedHashMap2);
        linkedHashMap.put(m19577a("syncTime", "all", fnh.KEY_PLAYLIST), Long.valueOf(currentTimeMillis));
        fjy.m19571a().m16734a(linkedHashMap).mo2124a(new flk(this, com_ushareit_listenit_fjz, o, currentTimeMillis));
    }

    public void m19773a(long j, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("PlaylistSync", "syncAll");
        long e = fle.m19717b().m19737e();
        if (j != e || fle.m19717b().m19751q()) {
            if (j == e && fka.m19600e()) {
                List<fnj> d = fka.m19599d();
                if (d != null) {
                    exw.m18443a("PlaylistSync", "syncAll: from cache");
                    Map linkedHashMap = new LinkedHashMap();
                    for (fnj com_ushareit_listenit_fnj : d) {
                        linkedHashMap.put(com_ushareit_listenit_fnj.getId(), com_ushareit_listenit_fnj);
                    }
                    m19770a(linkedHashMap, com_ushareit_listenit_fjz, j);
                    fiw.m19461b(j, e, false);
                    return;
                }
            }
            fjy.m19571a().m16736a("syncTime").m16736a("sub").m16736a("playlists").m16726a(new fll(this, com_ushareit_listenit_fjz, j));
            fiw.m19461b(j, e, false);
            return;
        }
        exw.m18443a("PlaylistSync", "syncAll, NO SYNC OK");
        if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19582a(-1);
        }
    }

    private void m19770a(Map<String, fnj> map, fjz com_ushareit_listenit_fjz, long j) {
        glc com_ushareit_listenit_glc;
        long e = fle.m19717b().m19737e();
        Map linkedHashMap = new LinkedHashMap();
        Map linkedHashMap2 = new LinkedHashMap();
        for (glc com_ushareit_listenit_glc2 : fqs.m20482o()) {
            linkedHashMap2.put(com_ushareit_listenit_glc2.f14283c, com_ushareit_listenit_glc2);
        }
        exw.m18443a("PlaylistSync", "syncPlaylist: get local playlist : " + linkedHashMap2.size());
        if (j != e) {
            for (fnj com_ushareit_listenit_fnj : map.values()) {
                linkedHashMap.put(com_ushareit_listenit_fnj.getId(), com_ushareit_listenit_fnj);
            }
            for (glc com_ushareit_listenit_glc22 : linkedHashMap2.values()) {
                if (!linkedHashMap.containsKey(com_ushareit_listenit_glc22.f14283c)) {
                    linkedHashMap.put(com_ushareit_listenit_glc22.f14283c, new fnj(com_ushareit_listenit_glc22));
                }
            }
            exw.m18443a("PlaylistSync", "syncPlaylist: sort playlist by cloud");
        } else if (fle.m19717b().m19751q()) {
            for (glc com_ushareit_listenit_glc222 : linkedHashMap2.values()) {
                linkedHashMap.put(com_ushareit_listenit_glc222.f14283c, new fnj(com_ushareit_listenit_glc222));
            }
            for (fnj com_ushareit_listenit_fnj2 : map.values()) {
                linkedHashMap.put(com_ushareit_listenit_fnj2.getId(), com_ushareit_listenit_fnj2);
            }
            exw.m18443a("PlaylistSync", "syncPlaylist: sort playlist by local");
        } else {
            for (fnj com_ushareit_listenit_fnj22 : map.values()) {
                linkedHashMap.put(com_ushareit_listenit_fnj22.getId(), com_ushareit_listenit_fnj22);
            }
            for (glc com_ushareit_listenit_glc2222 : linkedHashMap2.values()) {
                linkedHashMap.put(com_ushareit_listenit_glc2222.f14283c, new fnj(com_ushareit_listenit_glc2222));
            }
            exw.m18443a("PlaylistSync", "syncPlaylist: sort playlist by no");
        }
        Map linkedHashMap3 = new LinkedHashMap();
        Map linkedHashMap4 = new LinkedHashMap();
        for (String str : linkedHashMap.keySet()) {
            fnj com_ushareit_listenit_fnj3 = (fnj) map.get(str);
            com_ushareit_listenit_glc2222 = (glc) linkedHashMap2.get(str);
            if (com_ushareit_listenit_fnj3 != null && com_ushareit_listenit_glc2222 == null) {
                linkedHashMap3.put(com_ushareit_listenit_fnj3.getId(), com_ushareit_listenit_glc2222);
                exw.m18443a("PlaylistSync", "only cloudPlaylist");
            } else if (com_ushareit_listenit_glc2222 != null && com_ushareit_listenit_fnj3 == null) {
                linkedHashMap4.put(com_ushareit_listenit_glc2222.f14283c, com_ushareit_listenit_glc2222);
                exw.m18443a("PlaylistSync", "only localPlaylist: name=" + com_ushareit_listenit_glc2222.f14285e);
            } else if (!(com_ushareit_listenit_fnj3 == null || com_ushareit_listenit_glc2222 == null)) {
                exw.m18443a("PlaylistSync", "cloudPlaylist and localPlaylist, localChanedFlag=" + com_ushareit_listenit_glc2222.f14287g + ", cloudSynctime=" + com_ushareit_listenit_fnj3.getSt() + ", lcoal=" + com_ushareit_listenit_glc2222.f14286f);
                if (com_ushareit_listenit_fnj3.getSt() != com_ushareit_listenit_glc2222.f14286f) {
                    linkedHashMap3.put(com_ushareit_listenit_fnj3.getId(), com_ushareit_listenit_glc2222);
                } else if (com_ushareit_listenit_glc2222.f14287g > 0) {
                    linkedHashMap4.put(com_ushareit_listenit_glc2222.f14283c, com_ushareit_listenit_glc2222);
                }
            }
        }
        Map linkedHashMap5 = new LinkedHashMap(linkedHashMap);
        Object obj;
        if (map.size() != linkedHashMap.size()) {
            obj = null;
        } else {
            Iterator it = map.keySet().iterator();
            for (String str2 : linkedHashMap.keySet()) {
                if (!str2.equals(it.next())) {
                    obj = null;
                    break;
                }
            }
            int i = 1;
        }
        if (linkedHashMap4.size() == 0 && r2 != null) {
            linkedHashMap5.clear();
        }
        exw.m18443a("PlaylistSync", "syncPlaylist: download-playlist: " + linkedHashMap3.size() + ", upload-playlist: " + linkedHashMap4.size() + ", order-playlist: " + linkedHashMap5.size());
        fjz com_ushareit_listenit_flm = new flm(this, 2, j, com_ushareit_listenit_fjz, e, linkedHashMap, linkedHashMap4, map);
        m19768a(new ArrayList(linkedHashMap3.keySet()), com_ushareit_listenit_flm);
        m19771a(linkedHashMap4, linkedHashMap5, com_ushareit_listenit_flm);
    }

    private void m19772a(boolean z, long j, long j2, fjz com_ushareit_listenit_fjz) {
        if (z) {
            if (j == -1) {
                if (j2 != fle.m19717b().m19737e()) {
                    fle.m19717b().m19728b(j2);
                    fle.m19717b().m19730b(false);
                }
                if (com_ushareit_listenit_fjz != null) {
                    com_ushareit_listenit_fjz.m19582a(j);
                    return;
                }
                return;
            }
            fjy.m19571a().m16736a("syncTime").m16736a("all").m16736a(fnh.KEY_PLAYLIST).m16733a(Long.valueOf(j)).mo2124a(new fln(this, j, com_ushareit_listenit_fjz));
        } else if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19580a();
        }
    }

    private void m19768a(List<String> list, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("PlaylistSync", "downloadPlaylists: size=" + list.size());
        if (list.size() != 0) {
            if (com_ushareit_listenit_fjz != null) {
                com_ushareit_listenit_fjz.m19585b(list.size() - 1);
            }
            for (String a : list) {
                fjy.m19571a().m16736a("playlists").m16736a(a).m16726a(new flo(this, com_ushareit_listenit_fjz));
            }
        } else if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19587c();
        }
    }

    private void m19771a(Map<String, glc> map, Map<String, fnj> map2, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("PlaylistSync", "uploadPlaylists: size=" + map.size());
        if (map.size() != 0 || map2.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Map linkedHashMap = new LinkedHashMap();
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                glc com_ushareit_listenit_glc = (glc) entry.getValue();
                fnj com_ushareit_listenit_fnj = new fnj(com_ushareit_listenit_glc);
                com_ushareit_listenit_fnj.setSt(currentTimeMillis);
                map2.put(str, com_ushareit_listenit_fnj);
                fnk com_ushareit_listenit_fnk = new fnk(com_ushareit_listenit_glc);
                com_ushareit_listenit_fnk.setSt(currentTimeMillis);
                linkedHashMap.put(m19577a("playlists", str), com_ushareit_listenit_fnk.toMap());
                exw.m18443a("PlaylistSync", "uploadPlaylists: needUploadPlaylist=" + com_ushareit_listenit_fnk.getNa());
            }
            Map linkedHashMap2 = new LinkedHashMap(map2.size());
            int i = 0;
            for (Entry entry2 : map2.entrySet()) {
                Object[] objArr = new Object[1];
                int i2 = i + 1;
                objArr[0] = Integer.valueOf(i);
                linkedHashMap2.put(String.format(Locale.US, "%02d", objArr), ((fnj) entry2.getValue()).toMap());
                i = i2;
            }
            linkedHashMap.put(m19577a("syncTime", "sub", "playlists"), linkedHashMap2);
            fjy.m19571a().m16734a(linkedHashMap).mo2124a(new flq(this, com_ushareit_listenit_fjz, map, currentTimeMillis));
        } else if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19586b(-1);
        }
    }

    private void m19767a(fnk com_ushareit_listenit_fnk) {
        exw.m18443a("PlaylistSync", "parseCloudPlaylist: name=" + com_ushareit_listenit_fnk.getNa());
        if (frd.m20617b(com_ushareit_listenit_fnk.getId())) {
            frd.m20612b(com_ushareit_listenit_fnk);
            exw.m18443a("PlaylistSync", "parseCloudPlaylist: update=" + com_ushareit_listenit_fnk.getNa());
        } else {
            frd.m20602a(com_ushareit_listenit_fnk);
            exw.m18443a("PlaylistSync", "parseCloudPlaylist: insert=" + com_ushareit_listenit_fnk.getNa());
        }
        frd.m20623g(com_ushareit_listenit_fnk.getId());
        if (com_ushareit_listenit_fnk.getSgs() != null) {
            exw.m18443a("PlaylistSync", "parseCloudPlaylist: songSize=" + com_ushareit_listenit_fnk.getSgs().size());
            List arrayList = new ArrayList();
            for (String b : com_ushareit_listenit_fnk.getSgs()) {
                glg b2 = m19578b(b);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
            frd.m20608a(arrayList, com_ushareit_listenit_fnk.getId());
            fiw.m19468c(eys.m18562a(), com_ushareit_listenit_fnk.getSgs().size());
        }
    }

    private void m19769a(Map<String, fnj> map) {
        exw.m18443a("PlaylistSync", "reorderLocalPlaylists: size=" + map.size());
        List arrayList = new ArrayList(map.size());
        for (String add : map.keySet()) {
            arrayList.add(0, add);
        }
        frd.m20615b(arrayList, 0);
    }
}
