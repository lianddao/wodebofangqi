package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class fkv extends fjy {
    public void m19688a(fjz com_ushareit_listenit_fjz) {
        fjy.m19571a().m16736a("syncTime").m16736a("all").m16736a(fnh.KEY_LIBRARY_SONGS).m16726a(new fkw(this, com_ushareit_listenit_fjz));
    }

    private void m19685b(fjz com_ushareit_listenit_fjz) {
        long currentTimeMillis = System.currentTimeMillis();
        Map hashMap = new HashMap();
        fnm com_ushareit_listenit_fnm = new fnm();
        fnn com_ushareit_listenit_fnn = new fnn();
        List<glg> d = m19687d();
        for (glg com_ushareit_listenit_glg : d) {
            com_ushareit_listenit_fnm.update(com_ushareit_listenit_glg);
            com_ushareit_listenit_fnm.setSt(currentTimeMillis);
            hashMap.put(m19577a("syncTime", "sub", "songs", com_ushareit_listenit_glg.m22362h()), com_ushareit_listenit_fnm.toMap());
            com_ushareit_listenit_fnn.update(com_ushareit_listenit_glg);
            com_ushareit_listenit_fnn.setSt(currentTimeMillis);
            hashMap.put(m19577a("songs", com_ushareit_listenit_glg.m22362h()), com_ushareit_listenit_fnn.toMap());
        }
        hashMap.put(m19577a("syncTime", "all", fnh.KEY_LIBRARY_SONGS), Long.valueOf(currentTimeMillis));
        fjy.m19571a().m16734a(hashMap).mo2124a(new fkx(this, com_ushareit_listenit_fjz, d, currentTimeMillis));
    }

    private List<glg> m19687d() {
        List<glg> d = fqs.m20466d();
        List<glg> arrayList = new ArrayList(d.size());
        for (glg com_ushareit_listenit_glg : d) {
            if (!fbb.m18763c(com_ushareit_listenit_glg.m22362h())) {
                arrayList.add(com_ushareit_listenit_glg);
            }
        }
        return arrayList;
    }

    private void m19675a(long j, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("LibrarySongSync", "syncAll: start, cloudsynctime=" + j + ", localSynctime=" + fle.m19717b().m19740f());
        long f = fle.m19717b().m19740f();
        if (j != f || fle.m19717b().m19752r()) {
            if (j == f && fka.m19598c()) {
                List<fnm> b = fka.m19597b();
                if (b != null) {
                    boolean z;
                    exw.m18443a("LibrarySongSync", "syncAll: from cache");
                    Map hashMap = new HashMap();
                    for (fnm com_ushareit_listenit_fnm : b) {
                        if (com_ushareit_listenit_fnm == null || com_ushareit_listenit_fnm.getId() == null) {
                            z = false;
                            break;
                        }
                        hashMap.put(com_ushareit_listenit_fnm.getId(), com_ushareit_listenit_fnm);
                    }
                    z = true;
                    if (z) {
                        m19683a(hashMap, com_ushareit_listenit_fjz, j);
                        fiw.m19455a(j, f, true);
                        return;
                    }
                }
            }
            fjy.m19571a().m16736a("syncTime").m16736a("sub").m16736a("songs").m16726a(new fky(this, com_ushareit_listenit_fjz, j));
            fiw.m19455a(j, f, false);
            return;
        }
        exw.m18443a("LibrarySongSync", "syncAll:NO SYNC OK");
        if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19582a(-1);
        }
    }

    private void m19683a(Map<String, fnm> map, fjz com_ushareit_listenit_fjz, long j) {
        glg b;
        Map hashMap = new HashMap();
        for (glg b2 : m19687d()) {
            hashMap.put(b2.m22362h(), b2);
        }
        exw.m18443a("LibrarySongSync", "syncAll: get local song:" + hashMap.size());
        List<String> arrayList = new ArrayList();
        for (fnm id : map.values()) {
            arrayList.add(id.getId());
        }
        for (glg b22 : hashMap.values()) {
            if (!arrayList.contains(b22.m22362h())) {
                arrayList.add(b22.m22362h());
            }
        }
        exw.m18443a("LibrarySongSync", "syncAll: get all song:" + arrayList.size());
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        for (String str : arrayList) {
            fnm com_ushareit_listenit_fnm = (fnm) map.get(str);
            b22 = m19578b(str);
            if (com_ushareit_listenit_fnm != null && b22 == null) {
                hashMap2.put(com_ushareit_listenit_fnm.getId(), new fnm(com_ushareit_listenit_fnm.getId(), com_ushareit_listenit_fnm.getSt()));
                exw.m18443a("LibrarySongSync", "syncAll: only cloudSong");
            } else if (com_ushareit_listenit_fnm == null && b22 != null) {
                hashMap3.put(b22.m22362h(), b22);
                exw.m18443a("LibrarySongSync", "syncAll: only localSong");
            } else if (!(com_ushareit_listenit_fnm == null || b22 == null)) {
                exw.m18443a("LibrarySongSync", "syncAll: cloudSong and localSong: changflag=" + b22.f14350r + ", cloudst=" + com_ushareit_listenit_fnm.getSt() + ", localst=" + b22.f14349q);
                if (com_ushareit_listenit_fnm.getSt() != b22.f14349q) {
                    hashMap2.put(com_ushareit_listenit_fnm.getId(), new fnm(com_ushareit_listenit_fnm.getId(), com_ushareit_listenit_fnm.getSt()));
                } else if (b22.f14350r > 0) {
                    hashMap3.put(b22.m22362h(), b22);
                }
            }
        }
        fjz com_ushareit_listenit_fkz = new fkz(this, 2, j, com_ushareit_listenit_fjz, arrayList, hashMap3, map);
        m19682a(hashMap2, com_ushareit_listenit_fkz);
        m19686b(hashMap3, com_ushareit_listenit_fkz);
    }

    private void m19684a(boolean z, long j, long j2, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("LibrarySongSync", "onAllComplete=" + z + ", synctime=" + j);
        if (z) {
            if (j == -1) {
                fle.m19717b().m19732c(j2);
                fle.m19717b().m19733c(false);
                if (com_ushareit_listenit_fjz != null) {
                    com_ushareit_listenit_fjz.m19582a(j);
                    return;
                }
                return;
            }
            fjy.m19571a().m16736a("syncTime").m16736a("all").m16736a(fnh.KEY_LIBRARY_SONGS).m16733a(Long.valueOf(j)).mo2124a(new fla(this, com_ushareit_listenit_fjz, j));
        } else if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19580a();
        }
    }

    private void m19682a(Map<String, fnm> map, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("LibrarySongSync", "downloadSongs: size=" + map.size());
        if (map.size() != 0) {
            if (com_ushareit_listenit_fjz != null) {
                com_ushareit_listenit_fjz.m19585b(map.size() - 1);
            }
            exw.m18443a("LibrarySongSync", "downloadSongs: size=" + map.size());
            for (String str : map.keySet()) {
                fjy.m19571a().m16736a("songs").m16736a(str).m16726a(new flb(this, com_ushareit_listenit_fjz, map, str));
            }
            fiw.m19463b(eys.m18562a(), map.size());
        } else if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19587c();
        }
    }

    private void m19686b(Map<String, glg> map, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("LibrarySongSync", "uploadSongs: size=" + map.size());
        if (map.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Map hashMap = new HashMap();
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                glg com_ushareit_listenit_glg = (glg) entry.getValue();
                fnm com_ushareit_listenit_fnm = new fnm(com_ushareit_listenit_glg);
                com_ushareit_listenit_fnm.setSt(currentTimeMillis);
                hashMap.put(m19577a("syncTime", "sub", "songs", str), com_ushareit_listenit_fnm.toMap());
                fnn com_ushareit_listenit_fnn = new fnn(com_ushareit_listenit_glg);
                com_ushareit_listenit_fnn.setSt(currentTimeMillis);
                hashMap.put(m19577a("songs", str), com_ushareit_listenit_fnn.toMap());
            }
            fjy.m19571a().m16734a(hashMap).mo2124a(new fld(this, com_ushareit_listenit_fjz, map, currentTimeMillis));
        } else if (com_ushareit_listenit_fjz != null) {
            com_ushareit_listenit_fjz.m19586b(-1);
        }
    }

    private void m19681a(fnn com_ushareit_listenit_fnn) {
        exw.m18443a("LibrarySongSync", "parseCloudSong: name=" + com_ushareit_listenit_fnn.getNa());
        List c = m19579c(com_ushareit_listenit_fnn.getId());
        if (c == null || c.size() == 0) {
            frf.m20630a(com_ushareit_listenit_fnn);
            exw.m18443a("LibrarySongSync", "parseCloudSongs: insertLibrarySong, song=" + com_ushareit_listenit_fnn.getNa());
            return;
        }
        frf.m20651a(c, com_ushareit_listenit_fnn);
        exw.m18443a("LibrarySongSync", "parseCloudSongs: updateLibrarySong, name=" + com_ushareit_listenit_fnn.getNa() + ", size=" + c.size());
    }
}
