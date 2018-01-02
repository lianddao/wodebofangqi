package com.ushareit.listenit;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.config.internal.FetchConfigIpcResponse;
import com.google.android.gms.config.internal.PackageConfigTable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class cjn implements dqf {
    private static final Charset f8371a = Charset.forName("UTF-8");
    private static final Pattern f8372b = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
    private static final Pattern f8373c = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    private static Status m11450b(int i) {
        return new Status(i, dqk.m15280b(i));
    }

    private static HashMap<String, TreeMap<String, byte[]>> m11451b(FetchConfigIpcResponse fetchConfigIpcResponse) {
        if (fetchConfigIpcResponse == null) {
            return null;
        }
        DataHolder c = fetchConfigIpcResponse.m2332c();
        if (c == null) {
            return null;
        }
        PackageConfigTable packageConfigTable = (PackageConfigTable) new cey(c, PackageConfigTable.CREATOR).mo1301a(0);
        fetchConfigIpcResponse.m2334e();
        HashMap<String, TreeMap<String, byte[]>> hashMap = new HashMap();
        for (String str : packageConfigTable.m2336b().keySet()) {
            TreeMap treeMap = new TreeMap();
            hashMap.put(str, treeMap);
            Bundle bundle = packageConfigTable.m2336b().getBundle(str);
            for (String str2 : bundle.keySet()) {
                treeMap.put(str2, bundle.getByteArray(str2));
            }
        }
        return hashMap;
    }

    public ced<dqj> mo1377a(cdz com_ushareit_listenit_cdz, dqh com_ushareit_listenit_dqh) {
        return (com_ushareit_listenit_cdz == null || com_ushareit_listenit_dqh == null) ? null : com_ushareit_listenit_cdz.mo1997a(new cjo(this, com_ushareit_listenit_cdz, com_ushareit_listenit_dqh));
    }
}
