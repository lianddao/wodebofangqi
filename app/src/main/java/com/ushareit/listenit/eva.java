package com.ushareit.listenit;

import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class eva {
    private String f11913a;
    private String f11914b;
    private String f11915c;
    private long f11916d;
    private long f11917e;
    private int f11918f;
    private Map<String, String> f11919g;
    private evf f11920h;
    private int f11921i;
    private long f11922j;
    private eva f11923k;

    public eva() {
        this.f11923k = null;
        this.f11919g = new HashMap();
        this.f11920h = evf.WAITING;
    }

    public eva(eva com_ushareit_listenit_eva, boolean z) {
        this.f11923k = null;
        this.f11913a = com_ushareit_listenit_eva.f11913a;
        this.f11914b = com_ushareit_listenit_eva.f11914b;
        this.f11915c = com_ushareit_listenit_eva.f11915c;
        this.f11916d = com_ushareit_listenit_eva.f11916d;
        this.f11917e = com_ushareit_listenit_eva.f11917e;
        this.f11918f = com_ushareit_listenit_eva.f11918f;
        this.f11919g = com_ushareit_listenit_eva.f11919g;
        this.f11920h = com_ushareit_listenit_eva.f11920h;
        this.f11921i = com_ushareit_listenit_eva.f11921i;
        this.f11922j = com_ushareit_listenit_eva.f11922j;
        if (z) {
            this.f11923k = com_ushareit_listenit_eva;
        }
    }

    public eva(JSONObject jSONObject) {
        this.f11923k = null;
        this.f11913a = jSONObject.getString("id");
        this.f11914b = jSONObject.getString(VastExtensionXmlManager.TYPE);
        this.f11915c = jSONObject.getString("name");
        if (jSONObject.has("start_date")) {
            this.f11916d = jSONObject.getLong("start_date");
        } else {
            this.f11916d = -1;
        }
        if (jSONObject.has("end_date")) {
            this.f11917e = jSONObject.getLong("end_date");
        } else {
            this.f11917e = -1;
        }
        if (jSONObject.has("max_retry_count")) {
            this.f11918f = jSONObject.getInt("max_retry_count");
        } else {
            this.f11918f = -1;
        }
        this.f11919g = new HashMap();
        if (jSONObject.has("properties")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("properties");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                this.f11919g.put(str, jSONObject2.getString(str));
            }
        }
        this.f11920h = evf.WAITING;
        this.f11921i = 0;
        this.f11922j = 0;
    }

    public String m18099a() {
        return this.f11913a;
    }

    public void m18103a(String str) {
        this.f11913a = str;
    }

    public String m18107b() {
        return this.f11914b;
    }

    public void m18111b(String str) {
        this.f11914b = str;
    }

    public String m18112c() {
        return this.f11915c;
    }

    public void m18113c(String str) {
        this.f11915c = str;
    }

    public long m18115d() {
        return this.f11916d;
    }

    public void m18101a(long j) {
        this.f11916d = j;
    }

    public long m18118e() {
        return this.f11917e;
    }

    public void m18110b(long j) {
        this.f11917e = j;
    }

    public int m18120f() {
        return this.f11918f;
    }

    public void m18100a(int i) {
        this.f11918f = i;
    }

    public Map<String, String> m18122g() {
        return this.f11919g;
    }

    public void m18105a(Map<String, String> map) {
        this.f11919g = map;
    }

    public evb m18123h() {
        String e = m18119e("execute_conds");
        if (fbb.m18763c(e)) {
            return null;
        }
        try {
            return new evb(e);
        } catch (Exception e2) {
            return null;
        }
    }

    public evb m18124i() {
        String e = m18119e("display_conds");
        if (fbb.m18763c(e)) {
            return null;
        }
        try {
            return new evb(e);
        } catch (Exception e2) {
            return null;
        }
    }

    public evf m18125j() {
        return this.f11920h;
    }

    public void m18102a(evf com_ushareit_listenit_evf) {
        this.f11920h = com_ushareit_listenit_evf;
        if (this.f11923k != null) {
            this.f11923k.m18102a(com_ushareit_listenit_evf);
        }
    }

    public int m18126k() {
        return this.f11921i;
    }

    public void m18109b(int i) {
        this.f11921i = i;
        if (this.f11923k != null) {
            this.f11923k.m18109b(i);
        }
    }

    public void m18127l() {
        this.f11921i++;
        if (this.f11923k != null) {
            this.f11923k.m18127l();
        }
    }

    public boolean m18128m() {
        return this.f11918f >= 0 && this.f11921i >= this.f11918f;
    }

    public boolean m18129n() {
        return fba.m18746a(this.f11916d);
    }

    public boolean m18130o() {
        return fba.m18748b(this.f11917e);
    }

    public boolean m18114c(long j) {
        return fba.m18747a(this.f11917e, j);
    }

    public long m18131p() {
        return this.f11922j;
    }

    public void m18116d(long j) {
        this.f11922j = j;
        if (this.f11923k != null) {
            this.f11923k.m18116d(j);
        }
    }

    public boolean m18117d(String str) {
        return this.f11919g.containsKey(str);
    }

    public void m18104a(String str, String str2) {
        this.f11919g.put(str, str2);
        if (this.f11923k != null) {
            this.f11923k.m18104a(str, str2);
        }
    }

    public String m18119e(String str) {
        return (String) this.f11919g.get(str);
    }

    public String m18108b(String str, String str2) {
        if (this.f11919g.containsKey(str)) {
            return (String) this.f11919g.get(str);
        }
        return str2;
    }

    public boolean m18106a(String str, boolean z) {
        if (this.f11919g.containsKey(str)) {
            try {
                z = Boolean.parseBoolean((String) this.f11919g.get(str));
            } catch (Exception e) {
            }
        }
        return z;
    }

    public int m18096a(String str, int i) {
        if (this.f11919g.containsKey(str)) {
            try {
                i = Integer.parseInt((String) this.f11919g.get(str));
            } catch (Exception e) {
            }
        }
        return i;
    }

    public long m18097a(String str, long j) {
        if (this.f11919g.containsKey(str)) {
            try {
                j = Long.parseLong((String) this.f11919g.get(str));
            } catch (Exception e) {
            }
        }
        return j;
    }

    protected evi m18098a(int i, String str) {
        evi com_ushareit_listenit_evi = new evi();
        com_ushareit_listenit_evi.f11953a = i;
        com_ushareit_listenit_evi.f11954b = m18096a(str + "notify_style", 0);
        com_ushareit_listenit_evi.f11955c = m18119e(str + "notify_title");
        com_ushareit_listenit_evi.f11956d = m18119e(str + "notify_content");
        com_ushareit_listenit_evi.f11957e = m18119e(str + "notify_ticker");
        com_ushareit_listenit_evi.f11958f = m18119e(str + "notify_thumb_url");
        com_ushareit_listenit_evi.f11959g = m18106a(str + "disp_img_force", false);
        com_ushareit_listenit_evi.f11960h = m18119e(str + "notify_btn");
        com_ushareit_listenit_evi.f11961i = m18096a(str + "notify_flag", 0);
        com_ushareit_listenit_evi.f11962j = m18096a(str + "notify_action_flag", 0);
        return com_ushareit_listenit_evi;
    }

    protected evh m18121f(String str) {
        evh com_ushareit_listenit_evh = new evh();
        com_ushareit_listenit_evh.f11942a = m18119e("msgbox_title");
        com_ushareit_listenit_evh.f11943b = m18119e("msgbox_content");
        com_ushareit_listenit_evh.f11944c = m18096a("msgbox_mode", 0);
        com_ushareit_listenit_evh.f11945d = m18119e("msgbox_confirm_txt");
        com_ushareit_listenit_evh.f11946e = m18119e("msgbox_cancel_txt");
        com_ushareit_listenit_evh.f11947f = m18096a("msgbox_max_cancel_count", 0);
        return com_ushareit_listenit_evh;
    }

    public String toString() {
        return "CloudCommand [mId=" + this.f11913a + ", mType=" + this.f11914b + ", mName=" + this.f11915c + ", mStartDate=" + this.f11916d + ", mEndDate=" + this.f11917e + ", mMaxRetryCount=" + this.f11918f + ", mProperties=" + this.f11919g + ", mStatus=" + this.f11920h + ", mRetryCount=" + this.f11921i + ", mArrivedTime=" + this.f11922j + ", mSyncCmd=" + this.f11923k + "]";
    }
}
