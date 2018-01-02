package com.ushareit.listenit;

import android.content.Context;
import java.util.List;

public class fep {
    private static fep f12551a = null;

    private fep() {
        esf.m17732a(new esa(eys.m18562a()), new fes());
    }

    public static fep m19002a() {
        if (f12551a == null) {
            f12551a = new fep();
        }
        return f12551a;
    }

    public void m19009a(Context context, ffk com_ushareit_listenit_ffk, fen com_ushareit_listenit_fen) {
        esf.m17731a(context);
        if (com_ushareit_listenit_ffk == null || com_ushareit_listenit_ffk.m19105b() == 0 || com_ushareit_listenit_fen == null) {
            if (com_ushareit_listenit_fen != null) {
                com_ushareit_listenit_fen.m18991a();
            }
        } else if (!com_ushareit_listenit_fen.m18995c() || com_ushareit_listenit_fen.m18996d() > 0) {
            if (com_ushareit_listenit_fen.m18995c()) {
                com_ushareit_listenit_fen.m18997e();
            }
            if (!m19007a(com_ushareit_listenit_ffk, com_ushareit_listenit_fen)) {
                m19006a(com_ushareit_listenit_ffk.m19107c(), com_ushareit_listenit_fen, com_ushareit_listenit_ffk);
            }
        } else {
            com_ushareit_listenit_fen.m18991a();
        }
    }

    private void m19006a(ffl com_ushareit_listenit_ffl, fen com_ushareit_listenit_fen, ffk com_ushareit_listenit_ffk) {
        esf.m17742b((ese) com_ushareit_listenit_ffl, new feq(this, com_ushareit_listenit_fen, com_ushareit_listenit_ffl, com_ushareit_listenit_ffk));
    }

    public void m19008a(Context context, ffk com_ushareit_listenit_ffk) {
        if (com_ushareit_listenit_ffk != null && com_ushareit_listenit_ffk.m19105b() != 0) {
            m19003a(context, com_ushareit_listenit_ffk.m19107c(), com_ushareit_listenit_ffk);
        }
    }

    private void m19003a(Context context, ffl com_ushareit_listenit_ffl, ffk com_ushareit_listenit_ffk) {
        if (!m19010a(com_ushareit_listenit_ffk)) {
            esf.m17731a(context);
            esf.m17735a((ese) com_ushareit_listenit_ffl, new fer(this, com_ushareit_listenit_ffk, com_ushareit_listenit_ffl, context));
        }
    }

    public boolean m19010a(ffk com_ushareit_listenit_ffk) {
        for (ese a : com_ushareit_listenit_ffk.m19104a()) {
            if (esf.m17739a(a)) {
                return true;
            }
        }
        return false;
    }

    private boolean m19007a(ffk com_ushareit_listenit_ffk, fen com_ushareit_listenit_fen) {
        for (ese com_ushareit_listenit_ese : com_ushareit_listenit_ffk.m19104a()) {
            esi a = m19001a(esf.m17730a(com_ushareit_listenit_ese, null));
            if (a != null && a.m17769c() != null) {
                com_ushareit_listenit_fen.m18992a(com_ushareit_listenit_ese, a);
                return true;
            }
        }
        return false;
    }

    private esi m19001a(List<esi> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        for (esi com_ushareit_listenit_esi : list) {
            if (com_ushareit_listenit_esi.m17769c() != null) {
                return com_ushareit_listenit_esi;
            }
        }
        return null;
    }
}
