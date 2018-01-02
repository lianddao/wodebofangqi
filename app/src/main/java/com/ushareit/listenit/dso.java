package com.ushareit.listenit;

public class dso {
    public static final cdj<cdm> f10297a = new cdj("LocationServices.API", f10302f, f10301e);
    public static final dsj f10298b = new dsx();
    public static final dsk f10299c = new dtd();
    public static final dst f10300d = new dua();
    private static final cdu<dtu> f10301e = new cdu();
    private static final cdp<dtu, cdm> f10302f = new dsp();

    public static dtu m15442a(cdz com_ushareit_listenit_cdz) {
        boolean z = true;
        cfi.m11090b(com_ushareit_listenit_cdz != null, "GoogleApiClient parameter is required.");
        dtu com_ushareit_listenit_dtu = (dtu) com_ushareit_listenit_cdz.mo1996a(f10301e);
        if (com_ushareit_listenit_dtu == null) {
            z = false;
        }
        cfi.m11086a(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return com_ushareit_listenit_dtu;
    }
}
