package com.ushareit.listenit;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.firebase.database.connection.idl.ConnectionConfig;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class cmz implements cqs {
    private final Context f8483a;
    private final Set<String> f8484b = new HashSet();
    private final eah f8485c;

    public cmz(eah com_ushareit_listenit_eah) {
        this.f8485c = com_ushareit_listenit_eah;
        if (this.f8485c == null) {
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
        }
        this.f8483a = this.f8485c.m16618a();
    }

    public cop mo1452a(cqd com_ushareit_listenit_cqd, col com_ushareit_listenit_col, con com_ushareit_listenit_con, coq com_ushareit_listenit_coq) {
        cop a = edk.m16795a(this.f8483a, new ConnectionConfig(com_ushareit_listenit_con, com_ushareit_listenit_cqd.m12275f(), com_ushareit_listenit_cqd.m12274e(), com_ushareit_listenit_cqd.m12278i(), ecl.m16740c(), com_ushareit_listenit_cqd.m12282m()), com_ushareit_listenit_col, com_ushareit_listenit_coq);
        this.f8485c.m16622a(new cnc(this, a));
        return a;
    }

    public cpw mo1453a(ScheduledExecutorService scheduledExecutorService) {
        return new cmt(this.f8485c, scheduledExecutorService);
    }

    public cqj mo1454a(cqd com_ushareit_listenit_cqd) {
        return new cmy();
    }

    public ctu mo1455a(cqd com_ushareit_listenit_cqd, String str) {
        String n = com_ushareit_listenit_cqd.m12283n();
        String stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(n).length()).append(str).append("_").append(n).toString();
        if (this.f8484b.contains(stringBuilder)) {
            throw new ecf(new StringBuilder(String.valueOf(n).length() + 47).append("SessionPersistenceKey '").append(n).append("' has already been used.").toString());
        }
        this.f8484b.add(stringBuilder);
        return new ctr(com_ushareit_listenit_cqd, new cnd(this.f8483a, com_ushareit_listenit_cqd, stringBuilder), new cts(com_ushareit_listenit_cqd.m12279j()));
    }

    public cvz mo1456a(cqd com_ushareit_listenit_cqd, cwa com_ushareit_listenit_cwa, List<String> list) {
        return new cvv(com_ushareit_listenit_cwa, list);
    }

    public crt mo1457b(cqd com_ushareit_listenit_cqd) {
        return new cna(this, com_ushareit_listenit_cqd.m12268a("RunLoop"));
    }

    public String mo1458c(cqd com_ushareit_listenit_cqd) {
        return VERSION.SDK_INT + "/Android";
    }
}
