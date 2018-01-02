package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bsi {
    private static final Pattern f7603a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern f7604b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern f7605c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> f7606d = new HashMap();

    static {
        f7606d.put("aliceblue", Integer.valueOf(-984833));
        f7606d.put("antiquewhite", Integer.valueOf(-332841));
        f7606d.put("aqua", Integer.valueOf(-16711681));
        f7606d.put("aquamarine", Integer.valueOf(-8388652));
        f7606d.put("azure", Integer.valueOf(-983041));
        f7606d.put("beige", Integer.valueOf(-657956));
        f7606d.put("bisque", Integer.valueOf(-6972));
        f7606d.put("black", Integer.valueOf(CtaButton.BACKGROUND_COLOR));
        f7606d.put("blanchedalmond", Integer.valueOf(-5171));
        f7606d.put("blue", Integer.valueOf(-16776961));
        f7606d.put("blueviolet", Integer.valueOf(-7722014));
        f7606d.put("brown", Integer.valueOf(-5952982));
        f7606d.put("burlywood", Integer.valueOf(-2180985));
        f7606d.put("cadetblue", Integer.valueOf(-10510688));
        f7606d.put("chartreuse", Integer.valueOf(-8388864));
        f7606d.put("chocolate", Integer.valueOf(-2987746));
        f7606d.put("coral", Integer.valueOf(-32944));
        f7606d.put("cornflowerblue", Integer.valueOf(-10185235));
        f7606d.put("cornsilk", Integer.valueOf(-1828));
        f7606d.put("crimson", Integer.valueOf(-2354116));
        f7606d.put("cyan", Integer.valueOf(-16711681));
        f7606d.put("darkblue", Integer.valueOf(-16777077));
        f7606d.put("darkcyan", Integer.valueOf(-16741493));
        f7606d.put("darkgoldenrod", Integer.valueOf(-4684277));
        f7606d.put("darkgray", Integer.valueOf(-5658199));
        f7606d.put("darkgreen", Integer.valueOf(-16751616));
        f7606d.put("darkgrey", Integer.valueOf(-5658199));
        f7606d.put("darkkhaki", Integer.valueOf(-4343957));
        f7606d.put("darkmagenta", Integer.valueOf(-7667573));
        f7606d.put("darkolivegreen", Integer.valueOf(-11179217));
        f7606d.put("darkorange", Integer.valueOf(-29696));
        f7606d.put("darkorchid", Integer.valueOf(-6737204));
        f7606d.put("darkred", Integer.valueOf(-7667712));
        f7606d.put("darksalmon", Integer.valueOf(-1468806));
        f7606d.put("darkseagreen", Integer.valueOf(-7357297));
        f7606d.put("darkslateblue", Integer.valueOf(-12042869));
        f7606d.put("darkslategray", Integer.valueOf(-13676721));
        f7606d.put("darkslategrey", Integer.valueOf(-13676721));
        f7606d.put("darkturquoise", Integer.valueOf(-16724271));
        f7606d.put("darkviolet", Integer.valueOf(-7077677));
        f7606d.put("deeppink", Integer.valueOf(-60269));
        f7606d.put("deepskyblue", Integer.valueOf(-16728065));
        f7606d.put("dimgray", Integer.valueOf(-9868951));
        f7606d.put("dimgrey", Integer.valueOf(-9868951));
        f7606d.put("dodgerblue", Integer.valueOf(-14774017));
        f7606d.put("firebrick", Integer.valueOf(-5103070));
        f7606d.put("floralwhite", Integer.valueOf(-1296));
        f7606d.put("forestgreen", Integer.valueOf(-14513374));
        f7606d.put("fuchsia", Integer.valueOf(-65281));
        f7606d.put("gainsboro", Integer.valueOf(-2302756));
        f7606d.put("ghostwhite", Integer.valueOf(-460545));
        f7606d.put("gold", Integer.valueOf(-10496));
        f7606d.put("goldenrod", Integer.valueOf(-2448096));
        f7606d.put("gray", Integer.valueOf(-8355712));
        f7606d.put("green", Integer.valueOf(-16744448));
        f7606d.put("greenyellow", Integer.valueOf(-5374161));
        f7606d.put("grey", Integer.valueOf(-8355712));
        f7606d.put("honeydew", Integer.valueOf(-983056));
        f7606d.put("hotpink", Integer.valueOf(-38476));
        f7606d.put("indianred", Integer.valueOf(-3318692));
        f7606d.put("indigo", Integer.valueOf(-11861886));
        f7606d.put("ivory", Integer.valueOf(-16));
        f7606d.put("khaki", Integer.valueOf(-989556));
        f7606d.put("lavender", Integer.valueOf(-1644806));
        f7606d.put("lavenderblush", Integer.valueOf(-3851));
        f7606d.put("lawngreen", Integer.valueOf(-8586240));
        f7606d.put("lemonchiffon", Integer.valueOf(-1331));
        f7606d.put("lightblue", Integer.valueOf(-5383962));
        f7606d.put("lightcoral", Integer.valueOf(-1015680));
        f7606d.put("lightcyan", Integer.valueOf(-2031617));
        f7606d.put("lightgoldenrodyellow", Integer.valueOf(-329006));
        f7606d.put("lightgray", Integer.valueOf(-2894893));
        f7606d.put("lightgreen", Integer.valueOf(-7278960));
        f7606d.put("lightgrey", Integer.valueOf(-2894893));
        f7606d.put("lightpink", Integer.valueOf(-18751));
        f7606d.put("lightsalmon", Integer.valueOf(-24454));
        f7606d.put("lightseagreen", Integer.valueOf(-14634326));
        f7606d.put("lightskyblue", Integer.valueOf(-7876870));
        f7606d.put("lightslategray", Integer.valueOf(-8943463));
        f7606d.put("lightslategrey", Integer.valueOf(-8943463));
        f7606d.put("lightsteelblue", Integer.valueOf(-5192482));
        f7606d.put("lightyellow", Integer.valueOf(-32));
        f7606d.put("lime", Integer.valueOf(-16711936));
        f7606d.put("limegreen", Integer.valueOf(-13447886));
        f7606d.put("linen", Integer.valueOf(-331546));
        f7606d.put("magenta", Integer.valueOf(-65281));
        f7606d.put("maroon", Integer.valueOf(-8388608));
        f7606d.put("mediumaquamarine", Integer.valueOf(-10039894));
        f7606d.put("mediumblue", Integer.valueOf(-16777011));
        f7606d.put("mediumorchid", Integer.valueOf(-4565549));
        f7606d.put("mediumpurple", Integer.valueOf(-7114533));
        f7606d.put("mediumseagreen", Integer.valueOf(-12799119));
        f7606d.put("mediumslateblue", Integer.valueOf(-8689426));
        f7606d.put("mediumspringgreen", Integer.valueOf(-16713062));
        f7606d.put("mediumturquoise", Integer.valueOf(-12004916));
        f7606d.put("mediumvioletred", Integer.valueOf(-3730043));
        f7606d.put("midnightblue", Integer.valueOf(-15132304));
        f7606d.put("mintcream", Integer.valueOf(-655366));
        f7606d.put("mistyrose", Integer.valueOf(-6943));
        f7606d.put("moccasin", Integer.valueOf(-6987));
        f7606d.put("navajowhite", Integer.valueOf(-8531));
        f7606d.put("navy", Integer.valueOf(-16777088));
        f7606d.put("oldlace", Integer.valueOf(-133658));
        f7606d.put("olive", Integer.valueOf(-8355840));
        f7606d.put("olivedrab", Integer.valueOf(-9728477));
        f7606d.put("orange", Integer.valueOf(-23296));
        f7606d.put("orangered", Integer.valueOf(-47872));
        f7606d.put("orchid", Integer.valueOf(-2461482));
        f7606d.put("palegoldenrod", Integer.valueOf(-1120086));
        f7606d.put("palegreen", Integer.valueOf(-6751336));
        f7606d.put("paleturquoise", Integer.valueOf(-5247250));
        f7606d.put("palevioletred", Integer.valueOf(-2396013));
        f7606d.put("papayawhip", Integer.valueOf(-4139));
        f7606d.put("peachpuff", Integer.valueOf(-9543));
        f7606d.put("peru", Integer.valueOf(-3308225));
        f7606d.put("pink", Integer.valueOf(-16181));
        f7606d.put("plum", Integer.valueOf(-2252579));
        f7606d.put("powderblue", Integer.valueOf(-5185306));
        f7606d.put("purple", Integer.valueOf(-8388480));
        f7606d.put("rebeccapurple", Integer.valueOf(-10079335));
        f7606d.put("red", Integer.valueOf(-65536));
        f7606d.put("rosybrown", Integer.valueOf(-4419697));
        f7606d.put("royalblue", Integer.valueOf(-12490271));
        f7606d.put("saddlebrown", Integer.valueOf(-7650029));
        f7606d.put("salmon", Integer.valueOf(-360334));
        f7606d.put("sandybrown", Integer.valueOf(-744352));
        f7606d.put("seagreen", Integer.valueOf(-13726889));
        f7606d.put("seashell", Integer.valueOf(-2578));
        f7606d.put("sienna", Integer.valueOf(-6270419));
        f7606d.put("silver", Integer.valueOf(-4144960));
        f7606d.put("skyblue", Integer.valueOf(-7876885));
        f7606d.put("slateblue", Integer.valueOf(-9807155));
        f7606d.put("slategray", Integer.valueOf(-9404272));
        f7606d.put("slategrey", Integer.valueOf(-9404272));
        f7606d.put("snow", Integer.valueOf(-1286));
        f7606d.put("springgreen", Integer.valueOf(-16711809));
        f7606d.put("steelblue", Integer.valueOf(-12156236));
        f7606d.put("tan", Integer.valueOf(-2968436));
        f7606d.put("teal", Integer.valueOf(-16744320));
        f7606d.put("thistle", Integer.valueOf(-2572328));
        f7606d.put("tomato", Integer.valueOf(-40121));
        f7606d.put("transparent", Integer.valueOf(0));
        f7606d.put("turquoise", Integer.valueOf(-12525360));
        f7606d.put("violet", Integer.valueOf(-1146130));
        f7606d.put("wheat", Integer.valueOf(-663885));
        f7606d.put("white", Integer.valueOf(-1));
        f7606d.put("whitesmoke", Integer.valueOf(-657931));
        f7606d.put("yellow", Integer.valueOf(-256));
        f7606d.put("yellowgreen", Integer.valueOf(-6632142));
    }

    public static int m9665a(String str) {
        return m9666a(str, false);
    }

    public static int m9667b(String str) {
        return m9666a(str, true);
    }

    private static int m9666a(String str, boolean z) {
        bsg.m9656a(!TextUtils.isEmpty(str));
        Object replace = str.replace(" ", "");
        int parseLong;
        if (replace.charAt(0) == '#') {
            parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return parseLong | CtaButton.BACKGROUND_COLOR;
            }
            if (replace.length() == 9) {
                return (parseLong >>> 8) | ((parseLong & 255) << 24);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            Matcher matcher = (z ? f7605c : f7604b).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseLong = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseLong = Integer.parseInt(matcher.group(4), 10);
                }
                return m9664a(parseLong, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = f7603a.matcher(replace);
            if (matcher2.matches()) {
                return m9663a(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = (Integer) f7606d.get(btc.m9776d(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    private static int m9664a(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    private static int m9663a(int i, int i2, int i3) {
        return m9664a(255, i, i2, i3);
    }
}
