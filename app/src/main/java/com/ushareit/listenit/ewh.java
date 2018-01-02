package com.ushareit.listenit;

import org.json.JSONObject;

public class ewh extends ewl {
    private String f12013a;
    private String f12014b;
    private String f12015c;
    private fcb f12016d;

    public ewh(ewr com_ushareit_listenit_ewr, ewf com_ushareit_listenit_ewf) {
        super(com_ushareit_listenit_ewr, com_ushareit_listenit_ewf);
    }

    public fcb m18292a() {
        return this.f12016d;
    }

    protected void mo2305a(ewf com_ushareit_listenit_ewf) {
        super.mo2305a(com_ushareit_listenit_ewf);
        this.f12013a = com_ushareit_listenit_ewf.m18108b("msg_title", "");
        this.f12014b = com_ushareit_listenit_ewf.m18108b("msg_msg", "");
        this.f12015c = com_ushareit_listenit_ewf.m18108b("msg_btn_txt", "");
        if (com_ushareit_listenit_ewf.m18117d("msg_content")) {
            try {
                this.f12016d = exb.m18333a(new JSONObject(com_ushareit_listenit_ewf.m18119e("msg_content")));
                return;
            } catch (Exception e) {
                exw.m18457e("CMD.MsgCommand", "ContentMsgInfo read exception: " + e.toString());
                return;
            }
        }
        this.f12016d = null;
    }
}
