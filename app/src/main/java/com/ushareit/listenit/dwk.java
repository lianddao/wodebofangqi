package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.C0321x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class dwk extends dyt {
    dwk(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    private Object m15916a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Float ? Double.valueOf(((Float) obj).doubleValue()) : ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? m15944a(String.valueOf(obj), i, z) : null;
        } else {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
    }

    public static String m15917a(drg com_ushareit_listenit_drg) {
        int i = 0;
        if (com_ushareit_listenit_drg == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        m15925a(stringBuilder, 0, "filter_id", com_ushareit_listenit_drg.f10183a);
        m15925a(stringBuilder, 0, "event_name", com_ushareit_listenit_drg.f10184b);
        m15922a(stringBuilder, 1, "event_count_filter", com_ushareit_listenit_drg.f10187e);
        stringBuilder.append("  filters {\n");
        drh[] com_ushareit_listenit_drhArr = com_ushareit_listenit_drg.f10185c;
        int length = com_ushareit_listenit_drhArr.length;
        while (i < length) {
            m15920a(stringBuilder, 2, com_ushareit_listenit_drhArr[i]);
            i++;
        }
        m15919a(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    public static String m15918a(drj com_ushareit_listenit_drj) {
        if (com_ushareit_listenit_drj == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        m15925a(stringBuilder, 0, "filter_id", com_ushareit_listenit_drj.f10199a);
        m15925a(stringBuilder, 0, "property_name", com_ushareit_listenit_drj.f10200b);
        m15920a(stringBuilder, 1, com_ushareit_listenit_drj.f10201c);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    private static void m15919a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private static void m15920a(StringBuilder stringBuilder, int i, drh com_ushareit_listenit_drh) {
        if (com_ushareit_listenit_drh != null) {
            m15919a(stringBuilder, i);
            stringBuilder.append("filter {\n");
            m15925a(stringBuilder, i, "complement", com_ushareit_listenit_drh.f10191c);
            m15925a(stringBuilder, i, "param_name", com_ushareit_listenit_drh.f10192d);
            m15923a(stringBuilder, i + 1, "string_filter", com_ushareit_listenit_drh.f10189a);
            m15922a(stringBuilder, i + 1, "number_filter", com_ushareit_listenit_drh.f10190b);
            m15919a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m15921a(StringBuilder stringBuilder, int i, dru com_ushareit_listenit_dru) {
        if (com_ushareit_listenit_dru != null) {
            m15919a(stringBuilder, i);
            stringBuilder.append("bundle {\n");
            m15925a(stringBuilder, i, "protocol_version", com_ushareit_listenit_dru.f10245a);
            m15925a(stringBuilder, i, "platform", com_ushareit_listenit_dru.f10253j);
            m15925a(stringBuilder, i, "gmp_version", com_ushareit_listenit_dru.f10261r);
            m15925a(stringBuilder, i, "uploading_gmp_version", com_ushareit_listenit_dru.f10262s);
            m15925a(stringBuilder, i, "gmp_app_id", com_ushareit_listenit_dru.f10269z);
            m15925a(stringBuilder, i, "app_id", com_ushareit_listenit_dru.f10259p);
            m15925a(stringBuilder, i, C0321x.f3843d, com_ushareit_listenit_dru.f10260q);
            m15925a(stringBuilder, i, "app_version_major", com_ushareit_listenit_dru.f10241D);
            m15925a(stringBuilder, i, "firebase_instance_id", com_ushareit_listenit_dru.f10240C);
            m15925a(stringBuilder, i, "dev_cert_hash", com_ushareit_listenit_dru.f10266w);
            m15925a(stringBuilder, i, "app_store", com_ushareit_listenit_dru.f10258o);
            m15925a(stringBuilder, i, "upload_timestamp_millis", com_ushareit_listenit_dru.f10248d);
            m15925a(stringBuilder, i, "start_timestamp_millis", com_ushareit_listenit_dru.f10249e);
            m15925a(stringBuilder, i, "end_timestamp_millis", com_ushareit_listenit_dru.f10250f);
            m15925a(stringBuilder, i, "previous_bundle_start_timestamp_millis", com_ushareit_listenit_dru.f10251h);
            m15925a(stringBuilder, i, "previous_bundle_end_timestamp_millis", com_ushareit_listenit_dru.f10252i);
            m15925a(stringBuilder, i, "app_instance_id", com_ushareit_listenit_dru.f10265v);
            m15925a(stringBuilder, i, "resettable_device_id", com_ushareit_listenit_dru.f10263t);
            m15925a(stringBuilder, i, C0321x.f3860u, com_ushareit_listenit_dru.f10244G);
            m15925a(stringBuilder, i, "limited_ad_tracking", com_ushareit_listenit_dru.f10264u);
            m15925a(stringBuilder, i, C0321x.f3856q, com_ushareit_listenit_dru.f10254k);
            m15925a(stringBuilder, i, C0321x.f3861v, com_ushareit_listenit_dru.f10255l);
            m15925a(stringBuilder, i, "user_default_language", com_ushareit_listenit_dru.f10256m);
            m15925a(stringBuilder, i, "time_zone_offset_minutes", com_ushareit_listenit_dru.f10257n);
            m15925a(stringBuilder, i, "bundle_sequential_index", com_ushareit_listenit_dru.f10267x);
            m15925a(stringBuilder, i, "service_upload", com_ushareit_listenit_dru.f10238A);
            m15925a(stringBuilder, i, "health_monitor", com_ushareit_listenit_dru.f10268y);
            m15929a(stringBuilder, i, com_ushareit_listenit_dru.f10247c);
            m15926a(stringBuilder, i, com_ushareit_listenit_dru.f10239B);
            m15927a(stringBuilder, i, com_ushareit_listenit_dru.f10246b);
            m15919a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m15922a(StringBuilder stringBuilder, int i, String str, dri com_ushareit_listenit_dri) {
        if (com_ushareit_listenit_dri != null) {
            m15919a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (com_ushareit_listenit_dri.f10193a != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (com_ushareit_listenit_dri.f10193a.intValue()) {
                    case 1:
                        obj = "LESS_THAN";
                        break;
                    case 2:
                        obj = "GREATER_THAN";
                        break;
                    case 3:
                        obj = "EQUAL";
                        break;
                    case 4:
                        obj = "BETWEEN";
                        break;
                }
                m15925a(stringBuilder, i, "comparison_type", obj);
            }
            m15925a(stringBuilder, i, "match_as_float", com_ushareit_listenit_dri.f10194b);
            m15925a(stringBuilder, i, "comparison_value", com_ushareit_listenit_dri.f10195c);
            m15925a(stringBuilder, i, "min_comparison_value", com_ushareit_listenit_dri.f10196d);
            m15925a(stringBuilder, i, "max_comparison_value", com_ushareit_listenit_dri.f10197e);
            m15919a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m15923a(StringBuilder stringBuilder, int i, String str, drk com_ushareit_listenit_drk) {
        if (com_ushareit_listenit_drk != null) {
            m15919a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (com_ushareit_listenit_drk.f10202a != null) {
                Object obj = "UNKNOWN_MATCH_TYPE";
                switch (com_ushareit_listenit_drk.f10202a.intValue()) {
                    case 1:
                        obj = "REGEXP";
                        break;
                    case 2:
                        obj = "BEGINS_WITH";
                        break;
                    case 3:
                        obj = "ENDS_WITH";
                        break;
                    case 4:
                        obj = "PARTIAL";
                        break;
                    case 5:
                        obj = "EXACT";
                        break;
                    case 6:
                        obj = "IN_LIST";
                        break;
                }
                m15925a(stringBuilder, i, "match_type", obj);
            }
            m15925a(stringBuilder, i, "expression", com_ushareit_listenit_drk.f10203b);
            m15925a(stringBuilder, i, "case_sensitive", com_ushareit_listenit_drk.f10204c);
            if (com_ushareit_listenit_drk.f10205d.length > 0) {
                m15919a(stringBuilder, i + 1);
                stringBuilder.append("expression_list {\n");
                for (String str2 : com_ushareit_listenit_drk.f10205d) {
                    m15919a(stringBuilder, i + 2);
                    stringBuilder.append(str2);
                    stringBuilder.append("\n");
                }
                stringBuilder.append("}\n");
            }
            m15919a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m15924a(StringBuilder stringBuilder, int i, String str, drv com_ushareit_listenit_drv) {
        int i2 = 0;
        if (com_ushareit_listenit_drv != null) {
            int i3;
            int i4;
            int i5 = i + 1;
            m15919a(stringBuilder, i5);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (com_ushareit_listenit_drv.f10271b != null) {
                m15919a(stringBuilder, i5 + 1);
                stringBuilder.append("results: ");
                long[] jArr = com_ushareit_listenit_drv.f10271b;
                int length = jArr.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i6 = i4 + 1;
                    if (i4 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i4 = i6;
                }
                stringBuilder.append('\n');
            }
            if (com_ushareit_listenit_drv.f10270a != null) {
                m15919a(stringBuilder, i5 + 1);
                stringBuilder.append("status: ");
                long[] jArr2 = com_ushareit_listenit_drv.f10270a;
                int length2 = jArr2.length;
                i3 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i3 = i4;
                }
                stringBuilder.append('\n');
            }
            m15919a(stringBuilder, i5);
            stringBuilder.append("}\n");
        }
    }

    private static void m15925a(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            m15919a(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    private static void m15926a(StringBuilder stringBuilder, int i, drq[] com_ushareit_listenit_drqArr) {
        if (com_ushareit_listenit_drqArr != null) {
            int i2 = i + 1;
            for (drq com_ushareit_listenit_drq : com_ushareit_listenit_drqArr) {
                if (com_ushareit_listenit_drq != null) {
                    m15919a(stringBuilder, i2);
                    stringBuilder.append("audience_membership {\n");
                    m15925a(stringBuilder, i2, "audience_id", com_ushareit_listenit_drq.f10220a);
                    m15925a(stringBuilder, i2, "new_audience", com_ushareit_listenit_drq.f10223d);
                    m15924a(stringBuilder, i2, "current_data", com_ushareit_listenit_drq.f10221b);
                    m15924a(stringBuilder, i2, "previous_data", com_ushareit_listenit_drq.f10222c);
                    m15919a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m15927a(StringBuilder stringBuilder, int i, drr[] com_ushareit_listenit_drrArr) {
        if (com_ushareit_listenit_drrArr != null) {
            int i2 = i + 1;
            for (drr com_ushareit_listenit_drr : com_ushareit_listenit_drrArr) {
                if (com_ushareit_listenit_drr != null) {
                    m15919a(stringBuilder, i2);
                    stringBuilder.append("event {\n");
                    m15925a(stringBuilder, i2, "name", com_ushareit_listenit_drr.f10226b);
                    m15925a(stringBuilder, i2, "timestamp_millis", com_ushareit_listenit_drr.f10227c);
                    m15925a(stringBuilder, i2, "previous_timestamp_millis", com_ushareit_listenit_drr.f10228d);
                    m15925a(stringBuilder, i2, "count", com_ushareit_listenit_drr.f10229e);
                    m15928a(stringBuilder, i2, com_ushareit_listenit_drr.f10225a);
                    m15919a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m15928a(StringBuilder stringBuilder, int i, drs[] com_ushareit_listenit_drsArr) {
        if (com_ushareit_listenit_drsArr != null) {
            int i2 = i + 1;
            for (drs com_ushareit_listenit_drs : com_ushareit_listenit_drsArr) {
                if (com_ushareit_listenit_drs != null) {
                    m15919a(stringBuilder, i2);
                    stringBuilder.append("param {\n");
                    m15925a(stringBuilder, i2, "name", com_ushareit_listenit_drs.f10231a);
                    m15925a(stringBuilder, i2, "string_value", com_ushareit_listenit_drs.f10232b);
                    m15925a(stringBuilder, i2, "int_value", com_ushareit_listenit_drs.f10233c);
                    m15925a(stringBuilder, i2, "double_value", com_ushareit_listenit_drs.f10235e);
                    m15919a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m15929a(StringBuilder stringBuilder, int i, drw[] com_ushareit_listenit_drwArr) {
        if (com_ushareit_listenit_drwArr != null) {
            int i2 = i + 1;
            for (drw com_ushareit_listenit_drw : com_ushareit_listenit_drwArr) {
                if (com_ushareit_listenit_drw != null) {
                    m15919a(stringBuilder, i2);
                    stringBuilder.append("user_property {\n");
                    m15925a(stringBuilder, i2, "set_timestamp_millis", com_ushareit_listenit_drw.f10273a);
                    m15925a(stringBuilder, i2, "name", com_ushareit_listenit_drw.f10274b);
                    m15925a(stringBuilder, i2, "string_value", com_ushareit_listenit_drw.f10275c);
                    m15925a(stringBuilder, i2, "int_value", com_ushareit_listenit_drw.f10276d);
                    m15925a(stringBuilder, i2, "double_value", com_ushareit_listenit_drw.f10278f);
                    m15919a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    public static boolean m15930a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 4);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean m15931a(Context context, String str, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, str), 2);
            return (receiverInfo == null || !receiverInfo.enabled) ? false : !z || receiverInfo.exported;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    static boolean m15932a(String str) {
        cfi.m11082a(str);
        return str.charAt(0) != '_';
    }

    public static boolean m15933a(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] m15934a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static String m15935b(drt com_ushareit_listenit_drt) {
        if (com_ushareit_listenit_drt == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (com_ushareit_listenit_drt.f10236a != null) {
            for (dru com_ushareit_listenit_dru : com_ushareit_listenit_drt.f10236a) {
                if (com_ushareit_listenit_dru != null) {
                    m15921a(stringBuilder, 1, com_ushareit_listenit_dru);
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    static long m15936c(byte[] bArr) {
        long j = null;
        cfi.m11080a((Object) bArr);
        cfi.m11085a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public static boolean m15937c(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    static MessageDigest m15938j(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static boolean m15939l(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean m15940n(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    private int m15941o(String str) {
        return "_ldl".equals(str) ? mo2098y().m16002A() : mo2098y().m16066z();
    }

    public Bundle m15942a(Uri uri) {
        Bundle bundle = null;
        if (uri != null) {
            try {
                Object queryParameter;
                Object queryParameter2;
                Object queryParameter3;
                Object queryParameter4;
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                } else {
                    queryParameter4 = null;
                    queryParameter3 = null;
                    queryParameter2 = null;
                    queryParameter = null;
                }
                if (!(TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4))) {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString("campaign", queryParameter);
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bundle.putString("source", queryParameter2);
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        bundle.putString("medium", queryParameter3);
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("gclid", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("utm_term");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("term", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("utm_content");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("content", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("aclid");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("aclid", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("cp1");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("cp1", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("anid");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("anid", queryParameter4);
                    }
                }
            } catch (UnsupportedOperationException e) {
                mo2096w().m16262z().m16264a("Install referrer url isn't a hierarchical URI", e);
            }
        }
        return bundle;
    }

    public Bundle m15943a(String str, Bundle bundle, List<String> list, boolean z) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int b = mo2098y().m16032b();
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int f;
            if (list == null || !list.contains(str2)) {
                f = z ? m15969f(str2) : 0;
                if (f == 0) {
                    f = m15970g(str2);
                }
            } else {
                f = 0;
            }
            if (f != 0) {
                if (m15951a(bundle2, f)) {
                    bundle2.putString("_ev", m15944a(str2, mo2098y().m16039e(), true));
                    if (f == 3) {
                        m15946a(bundle2, (Object) str2);
                    }
                }
                bundle2.remove(str2);
            } else if (m15953a(str2, bundle.get(str2)) || "_ev".equals(str2)) {
                if (m15932a(str2)) {
                    i++;
                    if (i > b) {
                        mo2096w().m16242f().m16265a("Event can't contain more then " + b + " params", str, bundle);
                        m15951a(bundle2, 5);
                        bundle2.remove(str2);
                    }
                }
                i = i;
            } else {
                if (m15951a(bundle2, 4)) {
                    bundle2.putString("_ev", m15944a(str2, mo2098y().m16039e(), true));
                    m15946a(bundle2, bundle.get(str2));
                }
                bundle2.remove(str2);
            }
        }
        return bundle2;
    }

    public String m15944a(String str, int i, boolean z) {
        return str.length() > i ? z ? String.valueOf(str.substring(0, i)).concat("...") : null : str;
    }

    public void m15945a(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        m15951a(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.n.m16461l().m15754a("auto", "_err", bundle);
    }

    public void m15946a(Bundle bundle, Object obj) {
        cfi.m11080a((Object) bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    public void m15947a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                mo2096w().m16232B().m16265a("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public void m15948a(drs com_ushareit_listenit_drs, Object obj) {
        cfi.m11080a(obj);
        com_ushareit_listenit_drs.f10232b = null;
        com_ushareit_listenit_drs.f10233c = null;
        com_ushareit_listenit_drs.f10235e = null;
        if (obj instanceof String) {
            com_ushareit_listenit_drs.f10232b = (String) obj;
        } else if (obj instanceof Long) {
            com_ushareit_listenit_drs.f10233c = (Long) obj;
        } else if (obj instanceof Double) {
            com_ushareit_listenit_drs.f10235e = (Double) obj;
        } else {
            mo2096w().m16242f().m16264a("Ignoring invalid (type) event param value", obj);
        }
    }

    public void m15949a(drw com_ushareit_listenit_drw, Object obj) {
        cfi.m11080a(obj);
        com_ushareit_listenit_drw.f10275c = null;
        com_ushareit_listenit_drw.f10276d = null;
        com_ushareit_listenit_drw.f10278f = null;
        if (obj instanceof String) {
            com_ushareit_listenit_drw.f10275c = (String) obj;
        } else if (obj instanceof Long) {
            com_ushareit_listenit_drw.f10276d = (Long) obj;
        } else if (obj instanceof Double) {
            com_ushareit_listenit_drw.f10278f = (Double) obj;
        } else {
            mo2096w().m16242f().m16264a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public boolean m15950a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(mo2089p().mo1370a() - j) > j2;
    }

    public boolean m15951a(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    boolean m15952a(String str, int i, String str2) {
        if (str2 == null) {
            mo2096w().m16242f().m16264a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            mo2096w().m16242f().m16266a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public boolean m15953a(String str, Object obj) {
        return m15939l(str) ? m15955a("param", str, mo2098y().m16043g(), obj) : m15955a("param", str, mo2098y().m16041f(), obj);
    }

    boolean m15954a(String str, String str2) {
        if (str2 == null) {
            mo2096w().m16242f().m16264a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            mo2096w().m16242f().m16264a("Name is required and can't be empty. Type", str);
            return false;
        } else if (Character.isLetter(str2.charAt(0))) {
            int i = 1;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '_' || Character.isLetterOrDigit(charAt)) {
                    i++;
                } else {
                    mo2096w().m16242f().m16265a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        } else {
            mo2096w().m16242f().m16265a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    boolean m15955a(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() <= i) {
            return true;
        }
        mo2096w().m16262z().m16266a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    boolean m15956a(String str, Map<String, String> map, String str2) {
        if (str2 == null) {
            mo2096w().m16242f().m16264a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            mo2096w().m16242f().m16265a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            mo2096w().m16242f().m16265a("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public byte[] m15957a(drt com_ushareit_listenit_drt) {
        try {
            byte[] bArr = new byte[com_ushareit_listenit_drt.m13475g()];
            dga a = dga.m14159a(bArr);
            com_ushareit_listenit_drt.mo1666a(a);
            a.m14204b();
            return bArr;
        } catch (IOException e) {
            mo2096w().m16242f().m16264a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] m15958a(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            mo2096w().m16242f().m16264a("Failed to gzip content", e);
            throw e;
        }
    }

    public int m15959b(String str) {
        return !m15954a("event", str) ? 2 : !m15956a("event", dur.f10335a, str) ? 13 : m15952a("event", mo2098y().m16035c(), str) ? 0 : 2;
    }

    public Object m15960b(String str, Object obj) {
        if ("_ev".equals(str)) {
            return m15916a(mo2098y().m16043g(), obj, true);
        }
        return m15916a(m15939l(str) ? mo2098y().m16043g() : mo2098y().m16041f(), obj, false);
    }

    boolean m15961b(String str, String str2) {
        if (str2 == null) {
            mo2096w().m16242f().m16264a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            mo2096w().m16242f().m16264a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str2.length()) {
                    char charAt2 = str2.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        mo2096w().m16242f().m16265a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            mo2096w().m16242f().m16265a("Name must start with a letter or _ (underscores). Type, name", str, str2);
            return false;
        }
    }

    public byte[] m15962b(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            mo2096w().m16242f().m16264a("Failed to ungzip content", e);
            throw e;
        }
    }

    public int m15963c(String str) {
        return !m15961b("event", str) ? 2 : !m15956a("event", dur.f10335a, str) ? 13 : m15952a("event", mo2098y().m16035c(), str) ? 0 : 2;
    }

    public int m15964c(String str, Object obj) {
        return "_ldl".equals(str) ? m15955a("user property referrer", str, m15941o(str), obj) : m15955a("user property", str, m15941o(str), obj) ? 0 : 7;
    }

    public int m15965d(String str) {
        return !m15954a("user property", str) ? 6 : !m15956a("user property", duv.f10337a, str) ? 15 : m15952a("user property", mo2098y().m16037d(), str) ? 0 : 6;
    }

    public long m15966d(byte[] bArr) {
        cfi.m11080a((Object) bArr);
        MessageDigest j = m15938j("MD5");
        if (j != null) {
            return m15936c(j.digest(bArr));
        }
        mo2096w().m16242f().m16263a("Failed to get MD5");
        return 0;
    }

    public Object m15967d(String str, Object obj) {
        return "_ldl".equals(str) ? m15916a(m15941o(str), obj, true) : m15916a(m15941o(str), obj, false);
    }

    public int m15968e(String str) {
        return !m15961b("user property", str) ? 6 : !m15956a("user property", duv.f10337a, str) ? 15 : m15952a("user property", mo2098y().m16037d(), str) ? 0 : 6;
    }

    public int m15969f(String str) {
        return !m15954a("event param", str) ? 3 : !m15956a("event param", null, str) ? 14 : m15952a("event param", mo2098y().m16039e(), str) ? 0 : 3;
    }

    public int m15970g(String str) {
        return !m15961b("event param", str) ? 3 : !m15956a("event param", null, str) ? 14 : m15952a("event param", mo2098y().m16039e(), str) ? 0 : 3;
    }

    public /* bridge */ /* synthetic */ void mo2081h() {
        super.mo2081h();
    }

    public boolean m15972h(String str) {
        if (TextUtils.isEmpty(str)) {
            mo2096w().m16242f().m16263a("Measurement Service called without google_app_id");
            return false;
        } else if (!str.startsWith("1:")) {
            mo2096w().m16262z().m16264a("Measurement Service called with unknown id version", str);
            return true;
        } else if (m15974i(str)) {
            return true;
        } else {
            mo2096w().m16242f().m16264a("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
    }

    public /* bridge */ /* synthetic */ void mo2082i() {
        super.mo2082i();
    }

    boolean m15974i(String str) {
        cfi.m11080a((Object) str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public /* bridge */ /* synthetic */ void mo2083j() {
        super.mo2083j();
    }

    public /* bridge */ /* synthetic */ dwm mo2084k() {
        return super.mo2084k();
    }

    public boolean m15977k(String str) {
        mo2083j();
        if (mo2090q().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        mo2096w().m16234D().m16264a("Permission not granted", str);
        return false;
    }

    public /* bridge */ /* synthetic */ dva mo2085l() {
        return super.mo2085l();
    }

    public /* bridge */ /* synthetic */ dxe mo2086m() {
        return super.mo2086m();
    }

    public boolean m15980m(String str) {
        return TextUtils.isEmpty(str) ? false : mo2098y().aj().equals(str);
    }

    public /* bridge */ /* synthetic */ dwu mo2087n() {
        return super.mo2087n();
    }

    public /* bridge */ /* synthetic */ dvg mo2088o() {
        return super.mo2088o();
    }

    public /* bridge */ /* synthetic */ cio mo2089p() {
        return super.mo2089p();
    }

    public /* bridge */ /* synthetic */ Context mo2090q() {
        return super.mo2090q();
    }

    public /* bridge */ /* synthetic */ dwo mo2091r() {
        return super.mo2091r();
    }

    public /* bridge */ /* synthetic */ dwk mo2092s() {
        return super.mo2092s();
    }

    public /* bridge */ /* synthetic */ dxz mo2093t() {
        return super.mo2093t();
    }

    public /* bridge */ /* synthetic */ dvx mo2094u() {
        return super.mo2094u();
    }

    public /* bridge */ /* synthetic */ dya mo2095v() {
        return super.mo2095v();
    }

    public /* bridge */ /* synthetic */ dxg mo2096w() {
        return super.mo2096w();
    }

    public /* bridge */ /* synthetic */ dxr mo2097x() {
        return super.mo2097x();
    }

    public /* bridge */ /* synthetic */ dwn mo2098y() {
        return super.mo2098y();
    }
}
