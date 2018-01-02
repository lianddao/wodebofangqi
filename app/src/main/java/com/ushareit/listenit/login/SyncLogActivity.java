package com.ushareit.listenit.login;

import android.os.Bundle;
import android.widget.ListView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fjk;
import com.ushareit.listenit.flw;
import com.ushareit.listenit.fmc;
import com.ushareit.listenit.gew;
import com.ushareit.listenit.ggi;
import com.ushareit.listenit.glg;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class SyncLogActivity extends fjk {
    private ListView f15781n;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.sync_log_activity);
        this.f15781n = (ListView) findViewById(C0349R.id.sync_log_list);
        m24641j();
    }

    private void m24641j() {
        ArrayList arrayList = new ArrayList();
        Map e = flw.m19819a().m19846e();
        Map f = fmc.m19867a().m19901f();
        int size = e.size() + f.size();
        m5102a(String.format(getString(C0349R.string.sync_log_activity_title), new Object[]{Integer.valueOf(size)}));
        for (Entry entry : e.entrySet()) {
            arrayList.add(new ggi((glg) entry.getKey(), (String) entry.getValue()));
        }
        for (Entry entry2 : f.entrySet()) {
            arrayList.add(new ggi((glg) entry2.getKey(), (String) entry2.getValue()));
        }
        this.f15781n.setAdapter(new gew(this, arrayList));
    }

    public boolean mo539h() {
        return false;
    }

    public boolean mo540i() {
        return false;
    }
}
