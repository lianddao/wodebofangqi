package com.ushareit.listenit;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.umeng.analytics.C0154a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class bpu {
    public static final Pattern f7366a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern f7367b = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder f7368c = new StringBuilder();

    boolean m9470a(bss com_ushareit_listenit_bss, bpt com_ushareit_listenit_bpt, List<bpq> list) {
        Object x = com_ushareit_listenit_bss.m9730x();
        Matcher matcher = f7366a.matcher(x);
        if (matcher.matches()) {
            return m9464a(null, matcher, com_ushareit_listenit_bss, com_ushareit_listenit_bpt, this.f7368c, list);
        }
        matcher = f7366a.matcher(com_ushareit_listenit_bss.m9730x());
        if (!matcher.matches()) {
            return false;
        }
        return m9464a(x.trim(), matcher, com_ushareit_listenit_bss, com_ushareit_listenit_bpt, this.f7368c, list);
    }

    static void m9460a(String str, bpt com_ushareit_listenit_bpt) {
        Matcher matcher = f7367b.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    m9466b(group2, com_ushareit_listenit_bpt);
                } else if ("align".equals(group)) {
                    com_ushareit_listenit_bpt.m9447a(m9465b(group2));
                } else if ("position".equals(group)) {
                    m9467c(group2, com_ushareit_listenit_bpt);
                } else if ("size".equals(group)) {
                    com_ushareit_listenit_bpt.m9454c(bpy.m9480b(group2));
                } else {
                    Log.w("WebvttCueParser", "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException e) {
                Log.w("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    static void m9462a(String str, String str2, bpt com_ushareit_listenit_bpt, List<bpq> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        List arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            int indexOf;
            switch (charAt) {
                case CtaButton.HEIGHT_DIPS /*38*/:
                    indexOf = str2.indexOf(59, i + 1);
                    int indexOf2 = str2.indexOf(32, i + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf == -1) {
                        spannableStringBuilder.append(charAt);
                        i++;
                        break;
                    }
                    m9459a(str2.substring(i + 1, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i = indexOf + 1;
                    break;
                case C0154a.f2959o /*60*/:
                    if (i + 1 < str2.length()) {
                        Object obj = str2.charAt(i + 1) == '/' ? 1 : null;
                        indexOf = m9457a(str2, i + 1);
                        Object obj2 = str2.charAt(indexOf + -2) == '/' ? 1 : null;
                        String substring = str2.substring((obj != null ? 2 : 1) + i, obj2 != null ? indexOf - 2 : indexOf - 1);
                        String d = m9469d(substring);
                        if (d != null) {
                            if (m9468c(d)) {
                                if (obj == null) {
                                    if (obj2 == null) {
                                        stack.push(bpv.m9472a(substring, spannableStringBuilder.length()));
                                        i = indexOf;
                                        break;
                                    }
                                }
                                while (!stack.isEmpty()) {
                                    bpv com_ushareit_listenit_bpv = (bpv) stack.pop();
                                    m9461a(str, com_ushareit_listenit_bpv, spannableStringBuilder, list, arrayList);
                                    if (com_ushareit_listenit_bpv.f7370a.equals(d)) {
                                        i = indexOf;
                                        break;
                                    }
                                }
                                i = indexOf;
                            } else {
                                i = indexOf;
                                break;
                            }
                        }
                        i = indexOf;
                        break;
                    }
                    i++;
                    break;
                default:
                    spannableStringBuilder.append(charAt);
                    i++;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            m9461a(str, (bpv) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        m9461a(str, bpv.m9471a(), spannableStringBuilder, list, arrayList);
        com_ushareit_listenit_bpt.m9448a(spannableStringBuilder);
    }

    private static boolean m9464a(String str, Matcher matcher, bss com_ushareit_listenit_bss, bpt com_ushareit_listenit_bpt, StringBuilder stringBuilder, List<bpq> list) {
        try {
            com_ushareit_listenit_bpt.m9446a(bpy.m9478a(matcher.group(1))).m9453b(bpy.m9478a(matcher.group(2)));
            m9460a(matcher.group(3), com_ushareit_listenit_bpt);
            stringBuilder.setLength(0);
            while (true) {
                String x = com_ushareit_listenit_bss.m9730x();
                if (x == null || x.isEmpty()) {
                    m9462a(str, stringBuilder.toString(), com_ushareit_listenit_bpt, (List) list);
                } else {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append(x.trim());
                }
            }
            m9462a(str, stringBuilder.toString(), com_ushareit_listenit_bpt, (List) list);
            return true;
        } catch (NumberFormatException e) {
            Log.w("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    private static void m9466b(String str, bpt com_ushareit_listenit_bpt) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            com_ushareit_listenit_bpt.m9452b(m9456a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            com_ushareit_listenit_bpt.m9452b(Integer.MIN_VALUE);
        }
        if (str.endsWith("%")) {
            com_ushareit_listenit_bpt.m9444a(bpy.m9480b(str)).m9445a(0);
        } else {
            com_ushareit_listenit_bpt.m9444a((float) Integer.parseInt(str)).m9445a(1);
        }
    }

    private static void m9467c(String str, bpt com_ushareit_listenit_bpt) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            com_ushareit_listenit_bpt.m9455c(m9456a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            com_ushareit_listenit_bpt.m9455c(Integer.MIN_VALUE);
        }
        com_ushareit_listenit_bpt.m9451b(bpy.m9480b(str));
    }

    private static int m9456a(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    i = 1;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    i = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    i = 3;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                Log.w("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static Alignment m9465b(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    obj = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    obj = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    obj = 4;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    obj = 1;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    obj = 5;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
                return Alignment.ALIGN_NORMAL;
            case 2:
            case 3:
                return Alignment.ALIGN_CENTER;
            case 4:
            case 5:
                return Alignment.ALIGN_OPPOSITE;
            default:
                Log.w("WebvttCueParser", "Invalid alignment value: " + str);
                return null;
        }
    }

    private static int m9457a(String str, int i) {
        int indexOf = str.indexOf(62, i);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static void m9459a(String str, SpannableStringBuilder spannableStringBuilder) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    obj = 1;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    obj = null;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    obj = 3;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                spannableStringBuilder.append('<');
                return;
            case 1:
                spannableStringBuilder.append('>');
                return;
            case 2:
                spannableStringBuilder.append(' ');
                return;
            case 3:
                spannableStringBuilder.append('&');
                return;
            default:
                Log.w("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
    }

    private static boolean m9468c(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    z = false;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    z = true;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    z = true;
                    break;
                }
                break;
            case 117:
                if (str.equals("u")) {
                    z = true;
                    break;
                }
                break;
            case 118:
                if (str.equals(fno.KEY_VERSION)) {
                    z = true;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    private static void m9461a(String str, bpv com_ushareit_listenit_bpv, SpannableStringBuilder spannableStringBuilder, List<bpq> list, List<bpw> list2) {
        int i = com_ushareit_listenit_bpv.f7371b;
        int length = spannableStringBuilder.length();
        String str2 = com_ushareit_listenit_bpv.f7370a;
        int i2 = -1;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    i2 = 6;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    i2 = 0;
                    break;
                }
                break;
            case 99:
                if (str2.equals("c")) {
                    i2 = 3;
                    break;
                }
                break;
            case 105:
                if (str2.equals("i")) {
                    i2 = 1;
                    break;
                }
                break;
            case 117:
                if (str2.equals("u")) {
                    i2 = 2;
                    break;
                }
                break;
            case 118:
                if (str2.equals(fno.KEY_VERSION)) {
                    i2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    i2 = 4;
                    break;
                }
                break;
        }
        switch (i2) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 2:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                return;
        }
        list2.clear();
        m9463a((List) list, str, com_ushareit_listenit_bpv, (List) list2);
        int size = list2.size();
        for (i2 = 0; i2 < size; i2++) {
            m9458a(spannableStringBuilder, ((bpw) list2.get(i2)).f7375b, i, length);
        }
    }

    private static void m9458a(SpannableStringBuilder spannableStringBuilder, bpq com_ushareit_listenit_bpq, int i, int i2) {
        if (com_ushareit_listenit_bpq != null) {
            if (com_ushareit_listenit_bpq.m9425b() != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(com_ushareit_listenit_bpq.m9425b()), i, i2, 33);
            }
            if (com_ushareit_listenit_bpq.m9431c()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
            if (com_ushareit_listenit_bpq.m9433d()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (com_ushareit_listenit_bpq.m9436g()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(com_ushareit_listenit_bpq.m9435f()), i, i2, 33);
            }
            if (com_ushareit_listenit_bpq.m9438i()) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(com_ushareit_listenit_bpq.m9437h()), i, i2, 33);
            }
            if (com_ushareit_listenit_bpq.m9434e() != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(com_ushareit_listenit_bpq.m9434e()), i, i2, 33);
            }
            if (com_ushareit_listenit_bpq.m9439j() != null) {
                spannableStringBuilder.setSpan(new Standard(com_ushareit_listenit_bpq.m9439j()), i, i2, 33);
            }
            if (com_ushareit_listenit_bpq.m9440k() != -1) {
                switch (com_ushareit_listenit_bpq.m9440k()) {
                    case 1:
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) com_ushareit_listenit_bpq.m9441l(), true), i, i2, 33);
                        return;
                    case 2:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(com_ushareit_listenit_bpq.m9441l()), i, i2, 33);
                        return;
                    case 3:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(com_ushareit_listenit_bpq.m9441l() / 100.0f), i, i2, 33);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private static String m9469d(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim.split("[ \\.]")[0];
    }

    private static void m9463a(List<bpq> list, String str, bpv com_ushareit_listenit_bpv, List<bpw> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            bpq com_ushareit_listenit_bpq = (bpq) list.get(i);
            int a = com_ushareit_listenit_bpq.m9419a(str, com_ushareit_listenit_bpv.f7370a, com_ushareit_listenit_bpv.f7373d, com_ushareit_listenit_bpv.f7372c);
            if (a > 0) {
                list2.add(new bpw(a, com_ushareit_listenit_bpq));
            }
        }
        Collections.sort(list2);
    }
}
