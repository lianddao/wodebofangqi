package com.ushareit.listenit;

public class byr implements caj {
    private final byf f7951a;

    public byr(byf com_ushareit_listenit_byf) {
        this.f7951a = com_ushareit_listenit_byf;
    }

    public String mo1217a() {
        String str = null;
        if (this.f7951a != null) {
            try {
                str = this.f7951a.mo1196a();
            } catch (Throwable e) {
                bze.m10491c("Could not forward getType to RewardItem", e);
            }
        }
        return str;
    }

    public int mo1218b() {
        int i = 0;
        if (this.f7951a != null) {
            try {
                i = this.f7951a.mo1197b();
            } catch (Throwable e) {
                bze.m10491c("Could not forward getAmount to RewardItem", e);
            }
        }
        return i;
    }
}
