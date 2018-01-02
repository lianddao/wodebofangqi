package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class ewn extends ewl {
    private String f12031a;
    private List<String> f12032b;

    public ewn(ewr com_ushareit_listenit_ewr, ewf com_ushareit_listenit_ewf) {
        super(com_ushareit_listenit_ewr, com_ushareit_listenit_ewf);
    }

    public int m18306a() {
        return this.f12032b.size();
    }

    public String m18307a(int i) {
        if (i < 0 || i >= this.f12032b.size()) {
            return "";
        }
        return (String) this.f12032b.get(i);
    }

    protected void mo2305a(ewf com_ushareit_listenit_ewf) {
        super.mo2305a(com_ushareit_listenit_ewf);
        this.f12032b = new ArrayList();
        this.f12031a = com_ushareit_listenit_ewf.m18108b("msg_msg", "");
        if (com_ushareit_listenit_ewf.m18117d("msg_thumb_urls")) {
            try {
                JSONArray jSONArray = new JSONArray(com_ushareit_listenit_ewf.m18119e("msg_thumb_urls"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONArray.optString(i);
                    if (!fbb.m18763c(optString)) {
                        this.f12032b.add(optString);
                    }
                }
            } catch (Exception e) {
                exw.m18457e("CMD.MsgCommand", "MultiImageMsgInfo read exception: " + e.toString());
            }
        }
    }
}
