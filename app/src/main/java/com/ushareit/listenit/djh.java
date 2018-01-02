package com.ushareit.listenit;

public final class djh<NETWORK_EXTRAS extends bew, SERVER_PARAMETERS extends bet> implements beq, bes {
    private final dio f9853a;

    public djh(dio com_ushareit_listenit_dio) {
        this.f9853a = com_ushareit_listenit_dio;
    }

    public void mo1903a(bep<?, ?> com_ushareit_listenit_bep___, bed com_ushareit_listenit_bed) {
        String valueOf = String.valueOf(com_ushareit_listenit_bed);
        bze.m10485a(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        if (bwt.m10268a().m10478b()) {
            try {
                this.f9853a.mo1838a(djk.m14657a(com_ushareit_listenit_bed));
                return;
            } catch (Throwable e) {
                bze.m10491c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        bze.m10490c("onFailedToReceiveAd must be called on the main UI thread.");
        bza.f7956a.post(new djj(this, com_ushareit_listenit_bed));
    }

    public void mo1904a(ber<?, ?> com_ushareit_listenit_ber___, bed com_ushareit_listenit_bed) {
        String valueOf = String.valueOf(com_ushareit_listenit_bed);
        bze.m10485a(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        if (bwt.m10268a().m10478b()) {
            try {
                this.f9853a.mo1838a(djk.m14657a(com_ushareit_listenit_bed));
                return;
            } catch (Throwable e) {
                bze.m10491c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        bze.m10490c("onFailedToReceiveAd must be called on the main UI thread.");
        bza.f7956a.post(new dji(this, com_ushareit_listenit_bed));
    }
}
