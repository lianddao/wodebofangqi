package com.ushareit.listenit;

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
import java.util.Map;

final class bpi {
    public static bpj m9360a(bpj com_ushareit_listenit_bpj, String[] strArr, Map<String, bpj> map) {
        if (com_ushareit_listenit_bpj == null && strArr == null) {
            return null;
        }
        if (com_ushareit_listenit_bpj == null && strArr.length == 1) {
            return (bpj) map.get(strArr[0]);
        }
        if (com_ushareit_listenit_bpj == null && strArr.length > 1) {
            com_ushareit_listenit_bpj = new bpj();
            for (Object obj : strArr) {
                com_ushareit_listenit_bpj.m9369a((bpj) map.get(obj));
            }
            return com_ushareit_listenit_bpj;
        } else if (com_ushareit_listenit_bpj != null && strArr != null && strArr.length == 1) {
            return com_ushareit_listenit_bpj.m9369a((bpj) map.get(strArr[0]));
        } else {
            if (com_ushareit_listenit_bpj == null || strArr == null || strArr.length <= 1) {
                return com_ushareit_listenit_bpj;
            }
            for (Object obj2 : strArr) {
                com_ushareit_listenit_bpj.m9369a((bpj) map.get(obj2));
            }
            return com_ushareit_listenit_bpj;
        }
    }

    public static void m9363a(SpannableStringBuilder spannableStringBuilder, int i, int i2, bpj com_ushareit_listenit_bpj) {
        if (com_ushareit_listenit_bpj.m9365a() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(com_ushareit_listenit_bpj.m9365a()), i, i2, 33);
        }
        if (com_ushareit_listenit_bpj.m9375b()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (com_ushareit_listenit_bpj.m9378c()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (com_ushareit_listenit_bpj.m9382f()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com_ushareit_listenit_bpj.m9381e()), i, i2, 33);
        }
        if (com_ushareit_listenit_bpj.m9384h()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(com_ushareit_listenit_bpj.m9383g()), i, i2, 33);
        }
        if (com_ushareit_listenit_bpj.m9380d() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(com_ushareit_listenit_bpj.m9380d()), i, i2, 33);
        }
        if (com_ushareit_listenit_bpj.m9386j() != null) {
            spannableStringBuilder.setSpan(new Standard(com_ushareit_listenit_bpj.m9386j()), i, i2, 33);
        }
        if (com_ushareit_listenit_bpj.m9387k() != -1) {
            switch (com_ushareit_listenit_bpj.m9387k()) {
                case 1:
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) com_ushareit_listenit_bpj.m9388l(), true), i, i2, 33);
                    return;
                case 2:
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(com_ushareit_listenit_bpj.m9388l()), i, i2, 33);
                    return;
                case 3:
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(com_ushareit_listenit_bpj.m9388l() / 100.0f), i, i2, 33);
                    return;
                default:
                    return;
            }
        }
    }

    static void m9362a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }

    static String m9361a(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }
}
