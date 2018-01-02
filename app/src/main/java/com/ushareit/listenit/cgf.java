package com.ushareit.listenit;

import java.util.Arrays;

public abstract class cgf {
    public static final cgf f8238a = m11155a((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").mo1314a(m11154a(' ', ' '));
    public static final cgf f8239b = m11155a((CharSequence) "\t\n\u000b\f\r     　").mo1314a(m11154a(' ', ' ')).mo1314a(m11154a(' ', ' '));
    public static final cgf f8240c = m11154a('\u0000', '');
    public static final cgf f8241d;
    public static final cgf f8242e = m11154a('\t', '\r').mo1314a(m11154a('\u001c', ' ')).mo1314a(m11153a(' ')).mo1314a(m11153a('᠎')).mo1314a(m11154a(' ', ' ')).mo1314a(m11154a(' ', '​')).mo1314a(m11154a(' ', ' ')).mo1314a(m11153a(' ')).mo1314a(m11153a('　'));
    public static final cgf f8243f = new cgg();
    public static final cgf f8244g = new cgm();
    public static final cgf f8245h = new cgn();
    public static final cgf f8246i = new cgo();
    public static final cgf f8247j = new cgp();
    public static final cgf f8248k = m11154a('\u0000', '\u001f').mo1314a(m11154a('', ''));
    public static final cgf f8249l = m11154a('\u0000', ' ').mo1314a(m11154a('', ' ')).mo1314a(m11153a('­')).mo1314a(m11154a('؀', '؃')).mo1314a(m11155a((CharSequence) "۝܏ ឴឵᠎")).mo1314a(m11154a(' ', '‏')).mo1314a(m11154a(' ', ' ')).mo1314a(m11154a(' ', '⁤')).mo1314a(m11154a('⁪', '⁯')).mo1314a(m11153a('　')).mo1314a(m11154a('?', '')).mo1314a(m11155a((CharSequence) "﻿￹￺￻"));
    public static final cgf f8250m = m11154a('\u0000', 'ӹ').mo1314a(m11153a('־')).mo1314a(m11154a('א', 'ת')).mo1314a(m11153a('׳')).mo1314a(m11153a('״')).mo1314a(m11154a('؀', 'ۿ')).mo1314a(m11154a('ݐ', 'ݿ')).mo1314a(m11154a('฀', '๿')).mo1314a(m11154a('Ḁ', '₯')).mo1314a(m11154a('℀', '℺')).mo1314a(m11154a('ﭐ', '﷿')).mo1314a(m11154a('ﹰ', '﻿')).mo1314a(m11154a('｡', 'ￜ'));
    public static final cgf f8251n = new cgq();
    public static final cgf f8252o = new cgh();

    static {
        cgf a = m11154a('0', '9');
        cgf com_ushareit_listenit_cgf = a;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            com_ushareit_listenit_cgf = com_ushareit_listenit_cgf.mo1314a(m11154a(c, (char) (c + 9)));
        }
        f8241d = com_ushareit_listenit_cgf;
    }

    public static cgf m11153a(char c) {
        return new cgi(c);
    }

    public static cgf m11154a(char c, char c2) {
        cfi.m11089b(c2 >= c);
        return new cgl(c, c2);
    }

    public static cgf m11155a(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return f8252o;
            case 1:
                return m11153a(charSequence.charAt(0));
            case 2:
                return new cgj(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new cgk(toCharArray);
        }
    }

    public cgf mo1314a(cgf com_ushareit_listenit_cgf) {
        return new cgr(Arrays.asList(new cgf[]{this, (cgf) cfi.m11080a((Object) com_ushareit_listenit_cgf)}));
    }

    public abstract boolean mo1313b(char c);

    public boolean mo1315b(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!mo1313b(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
