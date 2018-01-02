package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

public class ffk {
    private String f12603a = "AdGroup";
    private ArrayList<ffl> f12604b = new ArrayList();

    public ffk(List<String> list, String str) {
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str2 = (String) list.get(i);
                if (m19102a(str2)) {
                    this.f12604b.add(new ffl(str2, str));
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
            exw.m18457e(this.f12603a, "AdGroup error e=" + exw.m18438a(e));
        }
    }

    private boolean m19102a(String str) {
        return !fbb.m18763c(str) && str.startsWith("ad:");
    }

    public ArrayList<ffl> m19104a() {
        return this.f12604b;
    }

    public int m19105b() {
        return this.f12604b.size();
    }

    public ffl m19107c() {
        return this.f12604b.size() > 0 ? (ffl) this.f12604b.get(0) : null;
    }

    public ffl m19103a(ffl com_ushareit_listenit_ffl) {
        int indexOf = this.f12604b.indexOf(com_ushareit_listenit_ffl);
        if (indexOf < 0 || indexOf >= this.f12604b.size() - 1) {
            return null;
        }
        return (ffl) this.f12604b.get(indexOf + 1);
    }

    public boolean m19106b(ffl com_ushareit_listenit_ffl) {
        int indexOf = this.f12604b.indexOf(com_ushareit_listenit_ffl);
        return indexOf >= 0 && indexOf < this.f12604b.size() - 1;
    }
}
