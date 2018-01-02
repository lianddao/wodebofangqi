package com.ushareit.listenit;

public class ewf extends eva {
    private ewl f12006a = null;

    public ewf(eva com_ushareit_listenit_eva) {
        super(com_ushareit_listenit_eva, true);
    }

    public ewr m18285q() {
        return ewr.m18310a(m18108b("msg_style", ewr.UNKNOWN.toString()));
    }

    public int m18286r() {
        return m18096a("msg_thumb_auto_dl", 0);
    }

    public ewl m18287s() {
        if (this.f12006a == null) {
            this.f12006a = m18284t();
        }
        return this.f12006a;
    }

    private ewl m18284t() {
        ewr q = m18285q();
        switch (ewg.f12007a[q.ordinal()]) {
            case 1:
                return new ewq(q, this);
            case 2:
                return new ewp(q, this);
            case 3:
                return new ewo(q, this);
            case 4:
                return new ewk(q, this);
            case 5:
                return new ewn(q, this);
            case 6:
                return new ewh(q, this);
            case 7:
                return new ewm(q, this);
            case 8:
                return new ewj(q, this);
            case 9:
                return new ewi(q, this);
            default:
                exu.m18432a("createMsgInfo(): Unsupport type:" + q.toString());
                return null;
        }
    }
}
