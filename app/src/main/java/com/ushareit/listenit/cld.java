package com.ushareit.listenit;

import android.content.Context;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.ProviderUserInfo;
import java.util.ArrayList;
import java.util.List;

public class cld extends ceo<cma> {
    cld(Context context, cma com_ushareit_listenit_cma) {
        super(context, cly.f8439b, com_ushareit_listenit_cma);
    }

    private <ResultT, CallbackT> clh<ResultT, CallbackT> m11535a(cme<ResultT, CallbackT> com_ushareit_listenit_cme_ResultT__CallbackT) {
        return new clh(this, com_ushareit_listenit_cme_ResultT__CallbackT);
    }

    private static cmp m11538b(eah com_ushareit_listenit_eah, GetAccountInfoUser getAccountInfoUser) {
        return m11539b(com_ushareit_listenit_eah, getAccountInfoUser, false);
    }

    private static cmp m11539b(eah com_ushareit_listenit_eah, GetAccountInfoUser getAccountInfoUser, boolean z) {
        cfi.m11080a((Object) com_ushareit_listenit_eah);
        cfi.m11080a((Object) getAccountInfoUser);
        List arrayList = new ArrayList();
        arrayList.add(new cmn(getAccountInfoUser, "firebase"));
        List h = getAccountInfoUser.m2503h();
        if (!(h == null || h.isEmpty())) {
            for (int i = 0; i < h.size(); i++) {
                arrayList.add(new cmn((ProviderUserInfo) h.get(i)));
            }
        }
        cmp com_ushareit_listenit_cmp = new cmp(com_ushareit_listenit_eah, arrayList);
        cmp com_ushareit_listenit_cmp2 = (cmp) com_ushareit_listenit_cmp.mo1436b(z);
        return com_ushareit_listenit_cmp;
    }

    public dzo<eau> m11540a(eah com_ushareit_listenit_eah, cmk com_ushareit_listenit_cmk) {
        return m10979b(m11535a(new clj().m11551a(com_ushareit_listenit_eah).m11553a((Object) com_ushareit_listenit_cmk)));
    }

    public dzo<eau> m11541a(eah com_ushareit_listenit_eah, eat com_ushareit_listenit_eat, cmk com_ushareit_listenit_cmk) {
        return m10979b(m11535a(new clk(com_ushareit_listenit_eat).m11551a(com_ushareit_listenit_eah).m11553a((Object) com_ushareit_listenit_cmk)));
    }

    public dzo<Void> m11542a(eah com_ushareit_listenit_eah, ebj com_ushareit_listenit_ebj, UserProfileChangeRequest userProfileChangeRequest, cmk com_ushareit_listenit_cmk) {
        return m10979b(m11535a(new clm(userProfileChangeRequest).m11551a(com_ushareit_listenit_eah).m11552a(com_ushareit_listenit_ebj).m11553a((Object) com_ushareit_listenit_cmk)));
    }

    public dzo<ebk> m11543a(eah com_ushareit_listenit_eah, ebj com_ushareit_listenit_ebj, String str, cmk com_ushareit_listenit_cmk) {
        return m10976a(m11535a(new clg(str).m11551a(com_ushareit_listenit_eah).m11552a(com_ushareit_listenit_ebj).m11553a((Object) com_ushareit_listenit_cmk)));
    }

    public dzo<ebo> m11544a(eah com_ushareit_listenit_eah, String str) {
        return m10976a(m11535a(new clf(str).m11551a(com_ushareit_listenit_eah)));
    }

    public dzo<eau> m11545a(eah com_ushareit_listenit_eah, String str, String str2, cmk com_ushareit_listenit_cmk) {
        return m10979b(m11535a(new cle(str, str2).m11551a(com_ushareit_listenit_eah).m11553a((Object) com_ushareit_listenit_cmk)));
    }

    public dzo<Void> m11546b(eah com_ushareit_listenit_eah, String str) {
        return m10979b(m11535a(new cli(str).m11551a(com_ushareit_listenit_eah)));
    }

    public dzo<eau> m11547b(eah com_ushareit_listenit_eah, String str, String str2, cmk com_ushareit_listenit_cmk) {
        return m10979b(m11535a(new cll(str, str2).m11551a(com_ushareit_listenit_eah).m11553a((Object) com_ushareit_listenit_cmk)));
    }
}
