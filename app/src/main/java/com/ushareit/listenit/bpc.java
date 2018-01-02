package com.ushareit.listenit;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bpc extends bon {
    private static final Pattern f7278a = Pattern.compile("(\\S*)\\s*-->\\s*(\\S*)");
    private static final Pattern f7279b = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+),(\\d+)");
    private final StringBuilder f7280c = new StringBuilder();

    protected /* synthetic */ bop mo1077a(byte[] bArr, int i) {
        return m9329b(bArr, i);
    }

    public bpc() {
        super("SubripDecoder");
    }

    protected bpd m9329b(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        bsl com_ushareit_listenit_bsl = new bsl();
        bss com_ushareit_listenit_bss = new bss(bArr, i);
        while (true) {
            String x = com_ushareit_listenit_bss.m9730x();
            if (x == null) {
                bom[] com_ushareit_listenit_bomArr = new bom[arrayList.size()];
                arrayList.toArray(com_ushareit_listenit_bomArr);
                return new bpd(com_ushareit_listenit_bomArr, com_ushareit_listenit_bsl.m9676b());
            } else if (x.length() != 0) {
                try {
                    Integer.parseInt(x);
                    Object x2 = com_ushareit_listenit_bss.m9730x();
                    Matcher matcher = f7278a.matcher(x2);
                    if (matcher.find()) {
                        int i2;
                        com_ushareit_listenit_bsl.m9675a(m9327a(matcher.group(1)));
                        if (TextUtils.isEmpty(matcher.group(2))) {
                            i2 = 0;
                        } else {
                            com_ushareit_listenit_bsl.m9675a(m9327a(matcher.group(2)));
                            i2 = 1;
                        }
                        this.f7280c.setLength(0);
                        while (true) {
                            Object x3 = com_ushareit_listenit_bss.m9730x();
                            if (TextUtils.isEmpty(x3)) {
                                break;
                            }
                            if (this.f7280c.length() > 0) {
                                this.f7280c.append("<br>");
                            }
                            this.f7280c.append(x3.trim());
                        }
                        arrayList.add(new bom(Html.fromHtml(this.f7280c.toString())));
                        if (i2 != 0) {
                            arrayList.add(null);
                        }
                    } else {
                        Log.w("SubripDecoder", "Skipping invalid timing: " + x2);
                    }
                } catch (NumberFormatException e) {
                    Log.w("SubripDecoder", "Skipping invalid index: " + x);
                }
            }
        }
    }

    private static long m9327a(String str) {
        Matcher matcher = f7279b.matcher(str);
        if (matcher.matches()) {
            return (Long.parseLong(matcher.group(4)) + (((((Long.parseLong(matcher.group(1)) * 60) * 60) * 1000) + ((Long.parseLong(matcher.group(2)) * 60) * 1000)) + (Long.parseLong(matcher.group(3)) * 1000))) * 1000;
        }
        throw new NumberFormatException("has invalid format");
    }
}
