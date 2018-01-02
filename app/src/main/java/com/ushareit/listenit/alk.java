package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

public enum alk {
    ANBANNER(aln.class, alj.AN, arz.BANNER),
    ANINTERSTITIAL(alv.class, alj.AN, arz.INTERSTITIAL),
    ADMOBNATIVE(alc.class, alj.ADMOB, arz.NATIVE),
    ANNATIVE(amb.class, alj.AN, arz.NATIVE),
    ANINSTREAMVIDEO(alq.class, alj.AN, arz.INSTREAM),
    ANREWARDEDVIDEO(amd.class, alj.AN, arz.REWARDED_VIDEO),
    INMOBINATIVE(amj.class, alj.INMOBI, arz.NATIVE),
    YAHOONATIVE(amf.class, alj.YAHOO, arz.NATIVE);
    
    private static List<alk> f4674m;
    public Class<?> f4676i;
    public String f4677j;
    public alj f4678k;
    public arz f4679l;

    private alk(Class<?> cls, alj com_ushareit_listenit_alj, arz com_ushareit_listenit_arz) {
        this.f4676i = cls;
        this.f4678k = com_ushareit_listenit_alj;
        this.f4679l = com_ushareit_listenit_arz;
    }

    public static List<alk> m6050a() {
        if (f4674m == null) {
            synchronized (alk.class) {
                f4674m = new ArrayList();
                f4674m.add(ANBANNER);
                f4674m.add(ANINTERSTITIAL);
                f4674m.add(ANNATIVE);
                f4674m.add(ANINSTREAMVIDEO);
                f4674m.add(ANREWARDEDVIDEO);
                if (apq.m6711a(alj.YAHOO)) {
                    f4674m.add(YAHOONATIVE);
                }
                if (apq.m6711a(alj.INMOBI)) {
                    f4674m.add(INMOBINATIVE);
                }
                if (apq.m6711a(alj.ADMOB)) {
                    f4674m.add(ADMOBNATIVE);
                }
            }
        }
        return f4674m;
    }
}
