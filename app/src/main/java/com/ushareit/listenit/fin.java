package com.ushareit.listenit;

import android.content.Context;
import android.os.Environment;
import java.util.Locale;

public class fin {
    private static String f12775a = "UIAnalyticsLyrics";

    public static void m19349a(Context context) {
        exw.m18443a(f12775a, "collectShowLyric");
        esr.m17807a(context, "UF_ShowLyric");
    }

    public static void m19351a(Context context, boolean z) {
        exw.m18443a(f12775a, "collectLyircType: isTagged=" + z);
        esr.m17808a(context, "UF_LyricType", z ? "tagged" : "untagged");
    }

    public static void m19350a(Context context, String str) {
        exw.m18443a(f12775a, "collectUnTaggedLyric: line=" + str);
        esr.m17808a(context, "UF_UntaggedLryic", str);
    }

    public static void m19352b(Context context) {
        exw.m18443a(f12775a, "collectSwitchToLyric");
        esr.m17807a(context, "UF_SwitchToLryic");
    }

    public static void m19354c(Context context) {
        exw.m18443a(f12775a, "collectSelectLyric");
        esr.m17807a(context, "UF_SelectLyric");
    }

    public static void m19353b(Context context, String str) {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (absolutePath.length() < str.length() && str.startsWith(absolutePath)) {
            str = str.substring(absolutePath.length() + 1, str.length());
        }
        exw.m18443a(f12775a, "collectLyricPath, path=" + str);
        esr.m17808a(context, "UF_LyricPath", str.toLowerCase(Locale.US));
    }

    public static void m19355c(Context context, String str) {
        exw.m18443a(f12775a, "collectEnterLyricEditor: from=" + str);
        esr.m17808a(context, "UF_EnterLyricEditor", str);
    }

    public static void m19356d(Context context) {
        exw.m18443a(f12775a, "collectShowSearchLyricGuide");
        esr.m17807a(context, "UF_ShowSearchLyricGuide");
    }

    public static void m19358e(Context context) {
        exw.m18443a(f12775a, "collectLyricEditorPlay");
        esr.m17807a(context, "UF_LyricEditorPlay");
    }

    public static void m19357d(Context context, String str) {
        exw.m18443a(f12775a, "collectSearchOnlineClick: from=" + str);
        esr.m17808a(context, "UF_SearchOnlineClick", str);
    }

    public static void m19360f(Context context) {
        exw.m18443a(f12775a, "collectLyricPasteClick");
        esr.m17807a(context, "UF_LyricPasteClick");
    }

    public static void m19361g(Context context) {
        exw.m18443a(f12775a, "collectShowLyricEditor");
        esr.m17807a(context, "UF_ShowLyricEditor");
    }

    public static void m19362h(Context context) {
        exw.m18443a(f12775a, "collectLyricEditorHelp");
        esr.m17807a(context, "UF_LyricEditorHelp");
    }

    public static void m19359e(Context context, String str) {
        exw.m18443a(f12775a, "collectSaveLyric");
        esr.m17808a(context, "UF_SaveLyric", str);
    }

    public static void m19363i(Context context) {
        exw.m18443a(f12775a, "collectSetCurrentTime");
        esr.m17807a(context, "UF_SetCurrentTime");
    }

    public static void m19364j(Context context) {
        exw.m18443a(f12775a, "collectLyricSeekTime");
        esr.m17807a(context, "UF_LyricSeekTime");
    }

    public static void m19365k(Context context) {
        exw.m18443a(f12775a, "collectLyricDelete");
        esr.m17807a(context, "UF_LyricDelete");
    }
}
