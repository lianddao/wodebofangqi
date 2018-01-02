package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class flq implements dzk<Void> {
    final /* synthetic */ fjz f12935a;
    final /* synthetic */ Map f12936b;
    final /* synthetic */ long f12937c;
    final /* synthetic */ fli f12938d;

    flq(fli com_ushareit_listenit_fli, fjz com_ushareit_listenit_fjz, Map map, long j) {
        this.f12938d = com_ushareit_listenit_fli;
        this.f12935a = com_ushareit_listenit_fjz;
        this.f12936b = map;
        this.f12937c = j;
    }

    public void mo2397a(dzo<Void> com_ushareit_listenit_dzo_java_lang_Void) {
        exw.m18443a("PlaylistSync", "uploadPlaylists: result=" + com_ushareit_listenit_dzo_java_lang_Void.mo2130b());
        if (com_ushareit_listenit_dzo_java_lang_Void.mo2130b()) {
            List arrayList = new ArrayList(this.f12936b.size());
            for (Entry entry : this.f12936b.entrySet()) {
                String str = (String) entry.getKey();
                glc com_ushareit_listenit_glc = (glc) entry.getValue();
                arrayList.add(str);
                com_ushareit_listenit_glc.f14286f = this.f12937c;
            }
            frd.m20606a(arrayList, 0);
            frd.m20607a(arrayList, this.f12937c);
            if (this.f12935a != null) {
                this.f12935a.m19586b(this.f12937c);
            }
        } else if (this.f12935a != null) {
            this.f12935a.m19584b();
        }
    }
}
