package com.ushareit.listenit;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.WindowManager;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.C0016g;
import com.facebook.ads.C0071w;
import com.facebook.ads.ab;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;

public class alv extends akx {
    private static final ConcurrentMap<String, avo> f4715a = new ConcurrentHashMap();
    private final String f4716b = UUID.randomUUID().toString();
    private Context f4717c;
    private amm f4718d;
    private aky f4719e;
    private boolean f4720f = false;
    private amh f4721g;
    private alx f4722h;

    public static avo m6103a(String str) {
        return (avo) f4715a.get(str);
    }

    public static void m6104a(avo com_ushareit_listenit_avo) {
        for (Entry entry : f4715a.entrySet()) {
            if (entry.getValue() == com_ushareit_listenit_avo) {
                f4715a.remove(entry.getKey());
            }
        }
    }

    private int m6108e() {
        int rotation = ((WindowManager) this.f4717c.getSystemService("window")).getDefaultDisplay().getRotation();
        if (this.f4722h == alx.UNSPECIFIED) {
            return -1;
        }
        if (this.f4722h == alx.HORIZONTAL) {
            switch (rotation) {
                case 2:
                case 3:
                    return 8;
                default:
                    return 0;
            }
        }
        switch (rotation) {
            case 2:
                return 9;
            default:
                return 1;
        }
    }

    public void mo710a(Context context, aky com_ushareit_listenit_aky, Map<String, Object> map, apa com_ushareit_listenit_apa) {
        this.f4717c = context;
        this.f4719e = com_ushareit_listenit_aky;
        JSONObject jSONObject = (JSONObject) map.get("data");
        if (jSONObject.has("markup")) {
            this.f4721g = amh.m6275a(jSONObject);
            if (atx.m7151a(context, this.f4721g)) {
                com_ushareit_listenit_aky.mo643a(this, C0016g.f610b);
                return;
            }
            this.f4718d = new amm(context, this.f4716b, this, this.f4719e);
            this.f4718d.m6320a();
            Map b = this.f4721g.m6280b();
            if (b.containsKey("orientation")) {
                this.f4722h = alx.m6118a(Integer.parseInt((String) b.get("orientation")));
            }
            this.f4720f = true;
            if (this.f4719e != null) {
                this.f4719e.mo642a(this);
                return;
            }
            return;
        }
        this.f4718d = new amm(context, this.f4716b, this, this.f4719e);
        this.f4718d.m6320a();
        aly com_ushareit_listenit_aly = new aly();
        com_ushareit_listenit_aly.mo706a(context, new alw(this, com_ushareit_listenit_aly), map, com_ushareit_listenit_apa);
    }

    public void mo674b() {
        if (this.f4718d != null) {
            this.f4718d.m6321b();
        }
    }

    public boolean mo711c() {
        if (this.f4720f) {
            Intent intent = new Intent(this.f4717c, AudienceNetworkActivity.class);
            intent.putExtra("predefinedOrientationKey", m6108e());
            intent.putExtra("uniqueId", this.f4716b);
            if (f4715a.containsKey(this.f4716b)) {
                intent.putExtra("viewType", C0071w.NATIVE);
            } else {
                intent.putExtra("viewType", C0071w.DISPLAY);
                this.f4721g.m6279a(intent);
            }
            intent.addFlags(268435456);
            try {
                this.f4717c.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                intent.setClass(this.f4717c, ab.class);
                this.f4717c.startActivity(intent);
            }
            return true;
        }
        if (this.f4719e != null) {
            this.f4719e.mo643a(this, C0016g.f613e);
        }
        return false;
    }
}
