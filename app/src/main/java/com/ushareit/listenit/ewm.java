package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class ewm extends ewl {
    private String f12027a;
    private String f12028b;
    private String f12029c;
    private List<fcb> f12030d;

    public ewm(ewr com_ushareit_listenit_ewr, ewf com_ushareit_listenit_ewf) {
        super(com_ushareit_listenit_ewr, com_ushareit_listenit_ewf);
    }

    public fcb m18304a(int i) {
        if (i < 0 || i >= this.f12030d.size()) {
            return null;
        }
        return (fcb) this.f12030d.get(i);
    }

    public int m18303a() {
        return this.f12030d.size();
    }

    protected void mo2305a(ewf com_ushareit_listenit_ewf) {
        super.mo2305a(com_ushareit_listenit_ewf);
        this.f12030d = new ArrayList();
        this.f12027a = com_ushareit_listenit_ewf.m18108b("msg_title", "");
        this.f12028b = com_ushareit_listenit_ewf.m18108b("msg_msg", "");
        this.f12029c = com_ushareit_listenit_ewf.m18108b("msg_btn_txt", "");
        if (com_ushareit_listenit_ewf.m18117d("msg_contents")) {
            try {
                JSONArray jSONArray = new JSONArray(com_ushareit_listenit_ewf.m18119e("msg_contents"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    fcb a = exb.m18333a(jSONArray.optJSONObject(i));
                    if (a != null) {
                        this.f12030d.add(a);
                    }
                }
            } catch (Exception e) {
                exw.m18457e("CMD.MsgCommand", "MultiContentMsgInfo read exception: " + e.toString());
            }
        }
    }
}
