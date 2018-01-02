package com.ushareit.listenit;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class gvj {
    public static long m22888a() {
        return new exz(eys.m18562a()).m17989a("FIRST_START_TIME", 0);
    }

    public static void m22895a(Context context, long j) {
        new exz(context).m17996b("MAIN_STARTUP_TIME", j);
    }

    public static long m22890a(Context context) {
        return new exz(context).m17989a("MAIN_STARTUP_TIME", 0);
    }

    public static void m22906b(Context context) {
        new exz(context).m17995b("PORTAL_TIMES", m22915c(context) + 1);
    }

    public static int m22915c(Context context) {
        return new exz(context).m17988a("PORTAL_TIMES", 0);
    }

    public static void m22908b(Context context, long j) {
        new exz(context).m17996b("MAIN_STARTUP_COUNT", j);
    }

    public static int m22926d(Context context) {
        return new exz(context).m17988a("MAIN_STARTUP_COUNT", 0);
    }

    public static void m22921c(Context context, long j) {
        new exz(context).m17996b("COMMON_SERVICE_STARTUP_TIME", j);
    }

    public static long m22937e(Context context) {
        return new exz(context).m17989a("COMMON_SERVICE_STARTUP_TIME", 0);
    }

    public static void m22892a(int i) {
        new exz(eys.m18562a()).m17995b("ignore_new_version", i);
    }

    public static int m22903b() {
        return new exz(eys.m18562a()).m17988a("ignore_new_version", 0);
    }

    public static synchronized long m22916c() {
        long a;
        synchronized (gvj.class) {
            a = new exz(eys.m18562a()).m17989a("MAX_SONG_ID", 0) + 1;
            new exz(eys.m18562a()).m17996b("MAX_SONG_ID", a);
        }
        return a;
    }

    public static synchronized long m22889a(long j) {
        long a;
        synchronized (gvj.class) {
            a = new exz(eys.m18562a()).m17989a("MAX_SONG_ID", 0);
            if (j > a) {
                new exz(eys.m18562a()).m17989a("MAX_SONG_ID", j);
            }
        }
        return a;
    }

    public static void m22894a(Context context, int i) {
        new exz(context).m17995b("MAX_PLAYLIST_ID", i);
    }

    public static int m22945f(Context context) {
        return new exz(context).m17988a("MAX_PLAYLIST_ID", 1);
    }

    public static void m22907b(Context context, int i) {
        new exz(context).m17995b("MAX_RECORD_ID", i);
    }

    public static int m22954g(Context context) {
        return new exz(context).m17988a("MAX_RECORD_ID", 1);
    }

    public static void m22897a(Context context, String str) {
        new exz(context).m17991a("KEY_USER_PLAY_STATE", str);
    }

    public static String m22962h(Context context) {
        return new exz(context).m17994b("KEY_USER_PLAY_STATE", "");
    }

    public static void m22900a(Context context, boolean z) {
        new exz(context).m17997b("HAS_DRAG_MINIPLAYER", z);
    }

    public static boolean m22977i(Context context) {
        return new exz(context).m17992a("HAS_DRAG_MINIPLAYER", false);
    }

    public static void m22912b(Context context, boolean z) {
        new exz(context).m17997b("HAS_SHOW_WELCOME", z);
    }

    public static boolean m22985j(Context context) {
        return new exz(context).m17992a("HAS_SHOW_WELCOME", false);
    }

    public static void m22909b(Context context, String str) {
        new exz(context).m17991a("CURRENT_PLAYLIST_NAME", str);
    }

    public static String m22987k(Context context) {
        return new exz(context).m17994b("CURRENT_PLAYLIST_NAME", "");
    }

    public static void m22920c(Context context, int i) {
        new exz(context).m17995b("CURRENT_PLAYLIST_TYPE", i);
    }

    public static int m22994l(Context context) {
        return new exz(context).m17988a("CURRENT_PLAYLIST_TYPE", 0);
    }

    public static void m22902a(boolean z) {
        new exz(eys.m18562a()).m17997b("ENABLE_EQUALIZER", z);
    }

    public static boolean m22935d() {
        return new exz(eys.m18562a()).m17992a("ENABLE_EQUALIZER", false);
    }

    public static void m22896a(Context context, gky com_ushareit_listenit_gky) {
        new exz(context).m17991a("CUSTOM_EQUALIZER_ITEM", com_ushareit_listenit_gky.m22289l());
    }

    public static gky m23003m(Context context) {
        return new gky(new exz(context).m17994b("CUSTOM_EQUALIZER_ITEM", ""));
    }

    public static void m22929d(Context context, int i) {
        new exz(context).m17995b("USER_EQUALIZER_SELECTED", i);
    }

    public static int m23008n(Context context) {
        return new exz(context).m17988a("USER_EQUALIZER_SELECTED", 0);
    }

    public static void m22940e(Context context, int i) {
        new exz(context).m17995b("USER_MEDIASOTE_AUDIO_COUNT", i);
    }

    public static int m23013o(Context context) {
        return new exz(context).m17988a("USER_MEDIASOTE_AUDIO_COUNT", 0);
    }

    public static void m22904b(int i) {
        new exz(eys.m18562a()).m17995b("KEY_SLEEP_TIME", i);
    }

    public static int m22936e() {
        return new exz(eys.m18562a()).m17999d("KEY_SLEEP_TIME");
    }

    public static void m22914b(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_SYSTEM_LOCKSCREEN", z);
    }

    public static boolean m22953f() {
        return new exz(eys.m18562a()).m17992a("KEY_SYSTEM_LOCKSCREEN", false);
    }

    public static void m22948f(Context context, int i) {
        new exz(context).m17995b("KEY_LAST_VERSION_CODE", i);
    }

    public static int m23019p(Context context) {
        return new exz(context).m17988a("KEY_LAST_VERSION_CODE", 1);
    }

    public static void m22956g(Context context, int i) {
        new exz(context).m17995b("KEY_LAST_PLAYLIST_COUNT", i);
    }

    public static int m23023q(Context context) {
        return new exz(context).m17988a("KEY_LAST_PLAYLIST_COUNT", -1);
    }

    public static void m22922c(Context context, String str) {
        new exz(context).m17991a("KEY_USER_LISTEN_BEHAVOR", str);
    }

    public static String m23026r(Context context) {
        return new exz(context).m17994b("KEY_USER_LISTEN_BEHAVOR", "");
    }

    public static void m22931d(Context context, String str) {
        new exz(context).m17991a("KEY_LAST_USER_LISTEN_DATE_IN_DAY", str);
    }

    public static String m23030s(Context context) {
        return new exz(context).m17994b("KEY_LAST_USER_LISTEN_DATE_IN_DAY", "");
    }

    public static void m22924c(Context context, boolean z) {
        new exz(context).m17997b("KEY_IS_ADD_ORDER_IN_ALL", z);
    }

    public static boolean m23034t(Context context) {
        return new exz(context).m17992a("KEY_IS_ADD_ORDER_IN_ALL", false);
    }

    public static void m22964h(Context context, int i) {
        new exz(context).m17995b("KEY_APPWIDGET_SKIN_4x1", i);
    }

    public static int m23036u(Context context) {
        return new exz(context).m17999d("KEY_APPWIDGET_SKIN_4x1");
    }

    public static void m22972i(Context context, int i) {
        new exz(context).m17995b("KEY_APPWIDGET_SKIN_4x2", i);
    }

    public static int m23038v(Context context) {
        return new exz(context).m17999d("KEY_APPWIDGET_SKIN_4x2");
    }

    public static void m22942e(Context context, String str) {
        new exz(context).m17991a("KEY_NEW_SONG_IDS", str);
    }

    public static String m23040w(Context context) {
        return new exz(context).m17994b("KEY_NEW_SONG_IDS", "");
    }

    public static long m23042x(Context context) {
        return new exz(context).m17989a("KEY_USER_RUN_TIME", 0);
    }

    public static boolean m23044y(Context context) {
        return m23042x(context) == 1;
    }

    public static void m23045z(Context context) {
        new exz(context).m17996b("KEY_USER_RUN_TIME", m23042x(context) + 1);
    }

    public static long m22854A(Context context) {
        return new exz(context).m17989a("KEY_USER_SCAN_TIME", 0);
    }

    public static boolean m22857B(Context context) {
        return m22854A(context) == 1;
    }

    public static void m22858C(Context context) {
        new exz(context).m17996b("KEY_USER_SCAN_TIME", m22854A(context) + 1);
    }

    public static List<String> m22860D(Context context) {
        return m22917c(new exz(context).m17994b("KEY_USER_ALL_SONG_PATHS", ""));
    }

    public static void m22899a(Context context, List<String> list) {
        new exz(context).m17991a("KEY_USER_ALL_SONG_PATHS", m22891a((List) list));
    }

    public static List<String> m22863E(Context context) {
        return m22917c(new exz(context).m17994b("KEY_USER_BLACK_SONG_PATHS", ""));
    }

    public static void m22911b(Context context, List<String> list) {
        new exz(context).m17991a("KEY_USER_BLACK_SONG_PATHS", m22891a((List) list));
    }

    private static String m22891a(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder("");
        int size = list.size() - 1;
        for (int i = 0; i < size; i++) {
            if (!fbb.m18763c((String) list.get(i))) {
                stringBuilder.append((String) list.get(i)).append(",");
            }
        }
        if (size >= 0) {
            stringBuilder.append((String) list.get(size));
        }
        return stringBuilder.toString();
    }

    private static List<String> m22917c(String str) {
        List<String> arrayList = new ArrayList();
        if (fbb.m18763c(str)) {
            return arrayList;
        }
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            if (!fbb.m18763c(split[i])) {
                arrayList.add(split[i]);
            }
        }
        return arrayList;
    }

    public static void m22980j(Context context, int i) {
        new exz(context).m17995b("KEY_USER_LAST_SONG_COUNT", i);
    }

    public static int m22865F(Context context) {
        return new exz(context).m17988a("KEY_USER_LAST_SONG_COUNT", -1);
    }

    public static void m22933d(Context context, boolean z) {
        new exz(context).m17997b("KEY_IS_LOGIN", z);
    }

    public static boolean m22867G(Context context) {
        return new exz(context).m17992a("KEY_IS_LOGIN", false);
    }

    public static void m22950f(Context context, String str) {
        new exz(context).m17991a("KEY_LOGIN_PROVIDER", str);
    }

    public static String m22868H(Context context) {
        return new exz(context).m17993b("KEY_LOGIN_PROVIDER");
    }

    public static void m22958g(Context context, String str) {
        new exz(context).m17991a("KEY_USER_ID", str);
    }

    public static String m22870I(Context context) {
        return new exz(context).m17993b("KEY_USER_ID");
    }

    public static void m22966h(Context context, String str) {
        new exz(context).m17991a("KEY_USER_NAME", str);
    }

    public static String m22871J(Context context) {
        return new exz(context).m17994b("KEY_USER_NAME", "");
    }

    public static void m22974i(Context context, String str) {
        new exz(context).m17991a("KEY_USER_PASSWORD", str);
    }

    public static String m22872K(Context context) {
        return new exz(context).m17993b("KEY_USER_PASSWORD");
    }

    public static void m22898a(Context context, String str, String str2) {
        if (!fbb.m18763c(str)) {
            new exz(context).m17991a(str, str2);
        }
    }

    public static String m22978j(Context context, String str) {
        if (fbb.m18763c(str)) {
            return "";
        }
        return new exz(context).m17994b(str, "");
    }

    public static void m22991k(Context context, String str) {
        new exz(context).m17991a("KEY_LOGIN_EMAIL", str);
    }

    public static void m22930d(Context context, long j) {
        new exz(context).m17996b("KEY_LAST_SHOW_LOGIN_DAYS", j);
    }

    public static void m22999l(Context context, String str) {
        new exz(context).m17991a("KEY_ACCESS_TOKEN", str);
    }

    public static void m22941e(Context context, long j) {
        new exz(context).m17996b("KEY_USERNAME_SYNCTIME", j);
    }

    public static long m22873L(Context context) {
        return new exz(context).m17989a("KEY_USERNAME_SYNCTIME", 0);
    }

    public static void m22949f(Context context, long j) {
        new exz(context).m17996b("KEY_USERAVATOR_SYNCTIME", j);
    }

    public static long m22874M(Context context) {
        return new exz(context).m17989a("KEY_USERAVATOR_SYNCTIME", 0);
    }

    public static void m22957g(Context context, long j) {
        new exz(context).m17996b("KEY_USERINFO_SYNCTIME", j);
    }

    public static long m22875N(Context context) {
        return new exz(context).m17989a("KEY_USERINFO_SYNCTIME", 0);
    }

    public static void m22965h(Context context, long j) {
        new exz(context).m17996b("KEY_PLAYLIST_SYNCTIME", j);
    }

    public static long m22876O(Context context) {
        return new exz(context).m17989a("KEY_PLAYLIST_SYNCTIME", 0);
    }

    public static void m22973i(Context context, long j) {
        new exz(context).m17996b("KEY_LIBRARY_SONGS_SYNCTIME", j);
    }

    public static long m22877P(Context context) {
        return new exz(context).m17989a("KEY_LIBRARY_SONGS_SYNCTIME", 0);
    }

    public static void m22989k(Context context, int i) {
        new exz(context).m17995b("KEY_LOCAL_MODIFIED_STATE", i);
    }

    public static int m22878Q(Context context) {
        return new exz(context).m17988a("KEY_LOCAL_MODIFIED_STATE", 0);
    }

    public static boolean m22879R(Context context) {
        return new exz(context).m17992a("KEY_AUTO_SYNC_IN_WIFI", true);
    }

    public static void m22943e(Context context, boolean z) {
        new exz(context).m17997b("KEY_AUTO_SYNC_IN_WIFI", z);
    }

    public static void m22951f(Context context, boolean z) {
        new exz(context).m17997b("KEY_IS_FIRST_SYNC_PLAYLIST", z);
    }

    public static boolean m22880S(Context context) {
        return new exz(context).m17992a("KEY_IS_FIRST_SYNC_PLAYLIST", true);
    }

    public static void m23006m(Context context, String str) {
        new exz(context).m17991a("KEY_LAST_SYNC_DATE", str);
    }

    public static String m22881T(Context context) {
        return new exz(context).m17994b("KEY_LAST_SYNC_DATE", "");
    }

    public static int m22882U(Context context) {
        return new exz(context).m17988a("KEY_LAST_NETWORK_STATE", 0);
    }

    public static void m22997l(Context context, int i) {
        new exz(context).m17995b("KEY_LAST_NETWORK_STATE", i);
    }

    public static int m22883V(Context context) {
        return new exz(context).m17988a("KEY_DUPLICATE_SONG_COUNT", 0);
    }

    public static void m22884W(Context context) {
        new exz(context).m17995b("KEY_DUPLICATE_SONG_COUNT", 0);
    }

    public static void m23004m(Context context, int i) {
        new exz(context).m17995b("KEY_DUPLICATE_SONG_COUNT", i);
    }

    public static String m23009n(Context context, String str) {
        return new exz(context).m17994b(str + "librarysong", "");
    }

    public static void m22910b(Context context, String str, String str2) {
        new exz(context).m17991a(str + "librarysong", str2);
    }

    public static String m23014o(Context context, String str) {
        return new exz(context).m17994b(str + "playlist", "");
    }

    public static void m22923c(Context context, String str, String str2) {
        new exz(context).m17991a(str + "playlist", str2);
    }

    public static String m23020p(Context context, String str) {
        return new exz(context).m17994b(str + "userinfo", "");
    }

    public static void m22932d(Context context, String str, String str2) {
        new exz(context).m17991a(str + "userinfo", str2);
    }

    public static long m22885X(Context context) {
        return new exz(context).m17989a("KEY_LAST_SYNC_TIME_FROM_NETWORK", 0);
    }

    public static void m22981j(Context context, long j) {
        new exz(context).m17996b("KEY_LAST_SYNC_TIME_FROM_NETWORK", j);
    }

    public static long m22886Y(Context context) {
        return new exz(context).m17989a("KEY_LAST_AUTO_SYNC_TIME_IN_WIFI", 0);
    }

    public static void m22990k(Context context, long j) {
        new exz(context).m17996b("KEY_LAST_AUTO_SYNC_TIME_IN_WIFI", j);
    }

    public static void m22959g(Context context, boolean z) {
        new exz(context).m17997b("KEY_IS_FIRST_VIEW_LYRIC", z);
    }

    public static boolean m22887Z(Context context) {
        return new exz(context).m17992a("KEY_IS_FIRST_VIEW_LYRIC", true);
    }

    public static void m23011n(Context context, int i) {
        new exz(context).m17995b("KEY_THEME", i);
    }

    public static int aa(Context context) {
        return new exz(context).m17988a("KEY_THEME", 0);
    }

    public static void m23015o(Context context, int i) {
        new exz(context).m17995b("KEY_LAST_THEME", i);
    }

    public static int ab(Context context) {
        return new exz(context).m17988a("KEY_LAST_THEME", 0);
    }

    public static void m23021p(Context context, int i) {
        new exz(context).m17995b("KEY_THEME_COLOR", i);
    }

    public static int ac(Context context) {
        return new exz(context).m17988a("KEY_THEME_COLOR", -1610962);
    }

    public static boolean ad(Context context) {
        return new exz(context).m17992a("KEY_IS_CROSS_FADE", false);
    }

    public static void m22967h(Context context, boolean z) {
        new exz(context).m17997b("KEY_IS_CROSS_FADE", z);
    }

    public static boolean ae(Context context) {
        return new exz(context).m17992a("KEY_IS_START_PAUSE_FADE", true);
    }

    public static void m22975i(Context context, boolean z) {
        new exz(context).m17997b("KEY_IS_START_PAUSE_FADE", z);
    }

    public static void m23025q(Context context, String str) {
        new exz(context).m17991a("KEY_RECOMMENDED_ARTIST", str);
    }

    public static String af(Context context) {
        return new exz(context).m17994b("KEY_RECOMMENDED_ARTIST", "");
    }

    public static void m23027r(Context context, String str) {
        new exz(context).m17991a("KEY_RECOMMENDED_ALBUM", str);
    }

    public static String ag(Context context) {
        return new exz(context).m17994b("KEY_RECOMMENDED_ALBUM", "");
    }

    public static boolean ah(Context context) {
        return new exz(context).m17992a("KEY_ENABLE_SKIP_SILENCE", true);
    }

    public static void m22982j(Context context, boolean z) {
        new exz(context).m17997b("KEY_ENABLE_SKIP_SILENCE", z);
    }

    public static void m23031s(Context context, String str) {
        new exz(context).m17991a("KEY_LAST_RECOMMENDED_NAME", str);
    }

    public static String ai(Context context) {
        return new exz(context).m17994b("KEY_LAST_RECOMMENDED_NAME", "");
    }

    public static void m22992k(Context context, boolean z) {
        new exz(context).m17997b("KEY_ENABLE_REPLAY", z);
    }

    public static boolean aj(Context context) {
        return new exz(context).m17992a("KEY_ENABLE_REPLAY", false);
    }

    public static void m22925c(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_ENABLE_VOLUME_BOOSTER", z);
    }

    public static boolean m22961g() {
        return new exz(eys.m18562a()).m17992a("KEY_ENABLE_VOLUME_BOOSTER", false);
    }

    public static void m22934d(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_REMEBER_USER_VOLUME_BOOSTER_OPERATOR", z);
    }

    public static boolean m22969h() {
        return new exz(eys.m18562a()).m17992a("KEY_REMEBER_USER_VOLUME_BOOSTER_OPERATOR", false);
    }

    public static void m23000l(Context context, boolean z) {
        new exz(context).m17997b("KEY_ENABLE_AUDIO_FOCUS", z);
    }

    public static boolean ak(Context context) {
        return new exz(context).m17992a("KEY_ENABLE_AUDIO_FOCUS", true);
    }

    public static void m22893a(Context context, double d, double d2) {
        long a = gln.m22369a(d);
        new exz(context).m17991a("KEY_USER_LOCATION", a + "," + gln.m22369a(d2));
        if (gln.m22375c()) {
            gln.m22374b(a);
        }
    }

    public static String al(Context context) {
        return new exz(context).m17994b("KEY_USER_LOCATION", "");
    }

    public static long am(Context context) {
        long j = -1000;
        String al = al(context);
        if (!fbb.m18763c(al)) {
            try {
                j = Long.parseLong(al.split(",")[0]);
            } catch (Exception e) {
            }
        }
        return j;
    }

    public static void m22998l(Context context, long j) {
        new exz(context).m17996b("KEY_LAST_USER_LOCATION_REQUEST_TIME", j);
    }

    public static long an(Context context) {
        return new exz(context).m17989a("KEY_LAST_USER_LOCATION_REQUEST_TIME", 0);
    }

    public static void ao(Context context) {
        new exz(context).m17996b("KEY_LOCATION_REQUEST_TIMES", ap(context) + 1);
    }

    public static long ap(Context context) {
        return new exz(context).m17989a("KEY_LOCATION_REQUEST_TIMES", 0);
    }

    public static void m23005m(Context context, long j) {
        new exz(context).m17996b("KEY_LAST_LOAD_NEARBY_TIME", j);
    }

    public static boolean aq(Context context) {
        return ar(context) == 0;
    }

    public static long ar(Context context) {
        return new exz(context).m17989a("KEY_LAST_LOAD_NEARBY_TIME", 0);
    }

    public static void m23012n(Context context, long j) {
        new exz(context).m17996b("KEY_LAST_LOAD_LONGITUDE_LEFT", j);
    }

    public static long as(Context context) {
        return new exz(context).m17989a("KEY_LAST_LOAD_LONGITUDE_LEFT", -1001);
    }

    public static void m23016o(Context context, long j) {
        new exz(context).m17996b("KEY_LAST_LOAD_LONGITUDE_RIGHT", j);
    }

    public static long at(Context context) {
        return new exz(context).m17989a("KEY_LAST_LOAD_LONGITUDE_RIGHT", -999);
    }

    public static void m23022p(Context context, long j) {
        new exz(context).m17996b("KEY_LAST_REPORT_NEARBY_USE_BEHAVOR_TIME", j);
    }

    public static long au(Context context) {
        return new exz(context).m17989a("KEY_LAST_REPORT_NEARBY_USE_BEHAVOR_TIME", 0);
    }

    public static void m22918c(int i) {
        new exz(eys.m18562a()).m17995b("KEY_LAST_SHARELIST_SONG_NUMBER", i);
    }

    public static int m22970i() {
        return new exz(eys.m18562a()).m17988a("KEY_LAST_SHARELIST_SONG_NUMBER", 0);
    }

    public static boolean m22984j() {
        return new exz(eys.m18562a()).m17992a("KEY_IS_SHOW_NEARBY_IN_DEBUG_MODE", false);
    }

    public static void m22944e(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_IS_SHOW_NEARBY_IN_DEBUG_MODE", z);
    }

    public static void m23007m(Context context, boolean z) {
        new exz(context).m17997b("KEY_IS_UPLOADED_HEAD_PHOTO", z);
    }

    public static boolean av(Context context) {
        return new exz(eys.m18562a()).m17992a("KEY_IS_UPLOADED_HEAD_PHOTO", false);
    }

    public static void m23033t(Context context, String str) {
        new exz(context).m17991a("KEY_USER_ADDRESS_NAME", str);
    }

    public static String aw(Context context) {
        return new exz(context).m17994b("KEY_USER_ADDRESS_NAME", "");
    }

    public static int m22986k() {
        return new exz(eys.m18562a()).m17988a("KEY_NEARBY_COLLECT_SONG_COUNT", 0);
    }

    public static void m22995l() {
        new exz(eys.m18562a()).m17995b("KEY_NEARBY_COLLECT_SONG_COUNT", m22986k() + 1);
    }

    public static int m23002m() {
        return new exz(eys.m18562a()).m17988a("KEY_NEARBY_COLLECT_PLAYLIST_COUNT", 0);
    }

    public static void m23010n() {
        new exz(eys.m18562a()).m17995b("KEY_NEARBY_COLLECT_PLAYLIST_COUNT", m23002m() + 1);
    }

    public static boolean m23017o() {
        return new exz(eys.m18562a()).m17992a("KEY_IS_NEARBY_GUIDE_ALREADY_SHOW", false);
    }

    public static void m22952f(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_IS_NEARBY_GUIDE_ALREADY_SHOW", z);
    }

    public static void m22928d(int i) {
        new exz(eys.m18562a()).m17995b("KEY_LAST_LOAD_NEARBY_USER_POSITION", i);
    }

    public static int m23018p() {
        return new exz(eys.m18562a()).m17988a("KEY_LAST_LOAD_NEARBY_USER_POSITION", fqk.m20386l());
    }

    public static long m23024q() {
        return new exz(eys.m18562a()).m17989a("KEY_RECOMMEND_TIMESTAMP", 0);
    }

    public static void m22905b(long j) {
        new exz(eys.m18562a()).m17996b("KEY_RECOMMEND_TIMESTAMP", j);
    }

    public static void m22960g(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_IS_SHOW_DISCOVERY_IN_DEBUG_MODE", z);
    }

    public static boolean m23028r() {
        return new exz(eys.m18562a()).m17992a("KEY_IS_SHOW_DISCOVERY_IN_DEBUG_MODE", false);
    }

    public static void m22901a(String str) {
        new exz(eys.m18562a()).m17991a("KEY_DISCOVERY_DATA_DEBUG", str);
    }

    public static String m23029s() {
        return new exz(eys.m18562a()).m17994b("KEY_DISCOVERY_DATA_DEBUG", "");
    }

    public static void m22913b(String str) {
        new exz(eys.m18562a()).m17991a("KEY_DISCOVERY_DATA_COUNTRY_DEBUG", str);
    }

    public static String m23032t() {
        return new exz(eys.m18562a()).m17994b("KEY_DISCOVERY_DATA_COUNTRY_DEBUG", gyn.m23252k());
    }

    public static int m23035u() {
        return new exz(eys.m18562a()).m17988a("KEY_SHOW_ALLSONGLIST_AD_LEFT_TIMES", 0);
    }

    public static void m22938e(int i) {
        new exz(eys.m18562a()).m17995b("KEY_SHOW_ALLSONGLIST_AD_LEFT_TIMES", i);
    }

    public static int m23037v() {
        return new exz(eys.m18562a()).m17988a("KEY_SHOW_FLASH_AD_LEFT_TIMES", 0);
    }

    public static void m22947f(int i) {
        new exz(eys.m18562a()).m17995b("KEY_SHOW_FLASH_AD_LEFT_TIMES", i);
    }

    public static int m23039w() {
        return new exz(eys.m18562a()).m17988a("KEY_SHOW_PLAY_PAGE_AD_LEFT_TIMES", 0);
    }

    public static void m22955g(int i) {
        new exz(eys.m18562a()).m17995b("KEY_SHOW_PLAY_PAGE_AD_LEFT_TIMES", i);
    }

    public static int m23041x() {
        return new exz(eys.m18562a()).m17988a("KEY_SHOW_SWITCH_FOREGROUND_AD_LEFT_TIMES", 0);
    }

    public static void m22963h(int i) {
        new exz(eys.m18562a()).m17995b("KEY_SHOW_SWITCH_FOREGROUND_AD_LEFT_TIMES", i);
    }

    public static int m23043y() {
        return new exz(eys.m18562a()).m17988a("KEY_SHOW_LOCKSCREEN_AD_LEFT_TIMES", 0);
    }

    public static void m22971i(int i) {
        new exz(eys.m18562a()).m17995b("KEY_SHOW_LOCKSCREEN_AD_LEFT_TIMES", i);
    }

    public static void m22968h(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_CLICK_ALLSONGLIST_PAGE_AD", z);
    }

    public static boolean m23046z() {
        return new exz(eys.m18562a()).m17992a("KEY_CLICK_ALLSONGLIST_PAGE_AD", false);
    }

    public static void m22976i(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_CLICK_PLAY_PAGE_AD", z);
    }

    public static boolean m22855A() {
        return new exz(eys.m18562a()).m17992a("KEY_CLICK_PLAY_PAGE_AD", false);
    }

    public static void m22983j(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_CLICK_SWITCH_FOREGROUND_AD", z);
    }

    public static boolean m22856B() {
        return new exz(eys.m18562a()).m17992a("KEY_CLICK_SWITCH_FOREGROUND_AD", false);
    }

    public static void m22993k(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_CLOSE_PLAY_PAGE_AD", z);
    }

    public static boolean m22859C() {
        return new exz(eys.m18562a()).m17992a("KEY_CLOSE_PLAY_PAGE_AD", false);
    }

    public static void m23001l(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_CLOSE_SWITCH_FOREGROUND_AD", z);
    }

    public static boolean m22861D() {
        return new exz(eys.m18562a()).m17992a("KEY_CLOSE_SWITCH_FOREGROUND_AD", false);
    }

    public static void m22979j(int i) {
        new exz(eys.m18562a()).m17995b("KEY_SHOW_PLAY_PAGE_AD_DELTA_TIMES", i);
    }

    public static int m22862E() {
        return new exz(eys.m18562a()).m17988a("KEY_SHOW_PLAY_PAGE_AD_DELTA_TIMES", 0);
    }

    public static void m22988k(int i) {
        new exz(eys.m18562a()).m17995b("KEY_SHOW_ALLSONGLIST_PAGE_AD_DELTA_TIMES", i);
    }

    public static int m22864F() {
        return new exz(eys.m18562a()).m17988a("KEY_SHOW_ALLSONGLIST_PAGE_AD_DELTA_TIMES", 0);
    }

    public static void m22996l(int i) {
        new exz(eys.m18562a()).m17995b("KEY_SHOW_SWITCH_FOREGROUND_AD_DELTA_TIMES", i);
    }

    public static int m22866G() {
        return new exz(eys.m18562a()).m17988a("KEY_SHOW_SWITCH_FOREGROUND_AD_DELTA_TIMES", 0);
    }

    public static void m22919c(long j) {
        new exz(eys.m18562a()).m17996b("KEY_AC_CHARGING_PER_POWER_TIME", j);
    }

    public static long m22927d(long j) {
        return new exz(eys.m18562a()).m17989a("KEY_AC_CHARGING_PER_POWER_TIME", j);
    }

    public static void m22939e(long j) {
        new exz(eys.m18562a()).m17996b("KEY_USB_CHARGING_PER_POWER_TIME", j);
    }

    public static long m22946f(long j) {
        return new exz(eys.m18562a()).m17989a("KEY_USB_CHARGING_PER_POWER_TIME", j);
    }

    public static boolean m22869H() {
        return new exz(eys.m18562a()).m17992a("KEY_ENABLE_WITH_SCREEN_SAVE", true);
    }
}
