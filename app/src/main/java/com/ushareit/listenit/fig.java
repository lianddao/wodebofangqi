package com.ushareit.listenit;

import android.content.Context;

public class fig {
    private static String f12766a = "UIAnalyticsAlbumArt";

    public static void m19277a(Context context) {
        exw.m18443a(f12766a, "collectDownloadAlbumArt");
        esr.m17807a(context, "UF_DownloadAlbumArt");
    }

    public static void m19279b(Context context) {
        exw.m18443a(f12766a, "collectAutoMatchAlbumArt");
        esr.m17807a(context, "UF_AutoMatchAlbumArt");
    }

    public static void m19278a(Context context, String str) {
        exw.m18443a(f12766a, "collectChangeAlbumArtFrom: " + str);
        esr.m17808a(context, "UF_ChangeAlbumArtFrom", str);
    }

    public static void m19280b(Context context, String str) {
        exw.m18443a(f12766a, "collectShowChangeAlbumArtView: " + str);
        esr.m17808a(context, "UF_ShowChangeAlbumArtView", str);
    }
}
