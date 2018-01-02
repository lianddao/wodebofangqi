package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.umeng.analytics.pro.C0321x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class euu {
    public static final eyu<euu> f11907a = new eyu(new euv());
    private static Map<String, Class<?>> f11908e = new HashMap();
    private Context f11909b = null;
    private evl f11910c = null;
    private Map<String, evd> f11911d = new HashMap();

    public static List<String> m18035a() {
        List<String> arrayList = new ArrayList();
        arrayList.add("cmd_type_notification");
        arrayList.add("cmd_type_install_app");
        arrayList.add("cmd_type_ad");
        arrayList.add("cmd_type_personal");
        arrayList.add("cmd_type_remove");
        arrayList.add("cmd_type_notification");
        arrayList.add("cmd_type_analytics");
        return arrayList;
    }

    public euu(Context context) {
        this.f11909b = context;
    }

    protected void m18052b() {
        this.f11910c = evl.m18165a(this.f11909b);
        this.f11911d.clear();
        m18036a("cmd_type_notification", new evw(this.f11909b, this.f11910c), false);
        m18036a("cmd_type_install_app", new evt(this.f11909b, this.f11910c), false);
        m18036a("cmd_type_ad", new evr(this.f11909b, this.f11910c), false);
        m18036a("cmd_type_personal", new evz(this.f11909b, this.f11910c), false);
        m18036a("cmd_type_remove", new ewa(this.f11909b, this.f11910c), false);
        m18036a("cmd_type_analytics", new ewc(this.f11909b, this.f11910c), false);
        for (Entry entry : f11908e.entrySet()) {
            if (!this.f11911d.containsKey(entry.getKey())) {
                evd a = ewt.m18312a(this.f11909b, this.f11910c, (Class) entry.getValue());
                if (a != null) {
                    m18036a((String) entry.getKey(), a, false);
                }
            }
        }
        m18041f();
    }

    public void m18046a(Context context, int i, boolean z) {
        m18038b(context, i, z, m18042g());
    }

    public void m18047a(Context context, int i, boolean z, List<String> list) {
        m18038b(context, i, z, list);
    }

    public void m18048a(Context context, boolean z) {
        boolean z2;
        if (z) {
            Pair a = eyw.m18568a(context);
            z2 = ((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue();
        } else {
            z2 = true;
        }
        exv c = euw.m18061c(this.f11909b);
        if (z2 && c.mo2319a(this.f11910c.m18178d())) {
            try {
                m18054d();
                c.mo2317a(true);
            } catch (exa e) {
                exw.m18449b("CMD.Manager", "tryUploadReport(): report commands failed from cloud: " + e.toString());
                c.mo2317a(false);
                e.printStackTrace();
            } catch (RuntimeException e2) {
                c.mo2317a(false);
                e2.printStackTrace();
            }
        }
    }

    public List<eva> m18053c() {
        return this.f11910c.m18175b();
    }

    public eva m18044a(String str) {
        return this.f11910c.m18174b(str);
    }

    public evf m18045a(int i, eva com_ushareit_listenit_eva) {
        exu.m18430a((Object) com_ushareit_listenit_eva);
        evd com_ushareit_listenit_evd = (evd) this.f11911d.get(com_ushareit_listenit_eva.m18107b());
        if (com_ushareit_listenit_evd == null) {
            exw.m18457e("CMD.Manager", "executeCommand(): Can't find command handler: " + com_ushareit_listenit_eva.m18107b());
            return evf.ERROR;
        }
        try {
            return com_ushareit_listenit_evd.mo2301a(i, com_ushareit_listenit_eva, null);
        } catch (Exception e) {
            exw.m18457e("CMD.Manager", "executeCommand(): handle command exception: " + e.toString());
            return evf.ERROR;
        }
    }

    public boolean m18051a(eva com_ushareit_listenit_eva) {
        exu.m18430a((Object) com_ushareit_listenit_eva);
        boolean a = this.f11910c.m18169a(com_ushareit_listenit_eva);
        if (a && !com_ushareit_listenit_eva.m18099a().startsWith("preset_")) {
            ewt.m18316a(this.f11909b, this.f11910c, new evp(com_ushareit_listenit_eva.m18099a(), "arrived", null, 0));
        }
        return a;
    }

    public void m18050a(eva com_ushareit_listenit_eva, Intent intent) {
        exu.m18430a((Object) com_ushareit_listenit_eva);
        exu.m18430a((Object) intent);
        evd com_ushareit_listenit_evd = (evd) this.f11911d.get(com_ushareit_listenit_eva.m18107b());
        if (com_ushareit_listenit_evd == null) {
            exw.m18449b("CMD.Manager", "handleWrapperEvent can't find handler: " + com_ushareit_listenit_eva.m18107b());
            return;
        }
        try {
            com_ushareit_listenit_evd.mo2304a(com_ushareit_listenit_eva, intent);
        } catch (Exception e) {
            exw.m18457e("CMD.Manager", "handleWrapperEvent " + com_ushareit_listenit_eva.m18099a() + " occur exception: " + e.toString());
        }
    }

    public void m18049a(Intent intent) {
        if (intent != null) {
            Collection<evd> values = this.f11911d.values();
            String action = intent.getAction();
            if (!fbb.m18763c(action)) {
                for (evd com_ushareit_listenit_evd : values) {
                    List a = com_ushareit_listenit_evd.mo2302a();
                    if (a != null && a.contains(action)) {
                        try {
                            com_ushareit_listenit_evd.mo2303a(intent);
                        } catch (Exception e) {
                            exw.m18457e("CMD.Manager", "handleSystemEvent " + action + " occur exception: " + e.toString());
                        }
                    }
                }
            }
        }
    }

    public void m18054d() {
        m18040e();
    }

    private void m18038b(Context context, int i, boolean z, List<String> list) {
        exv a;
        String str = null;
        for (eva com_ushareit_listenit_eva : m18053c()) {
            exw.m18449b("CMD.Manager", "doTryExecuteCmds(): Execute exist cloud command: " + com_ushareit_listenit_eva.m18099a());
            m18045a(i, com_ushareit_listenit_eva);
        }
        if (z) {
            Pair a2 = eyw.m18568a(context);
            if (!(((Boolean) a2.first).booleanValue() || ((Boolean) a2.second).booleanValue())) {
                return;
            }
        }
        switch (i) {
            case 1:
                a = euw.m18058a(context);
                str = "app_start";
                break;
            case 2:
                a = euw.m18059a(context, false, true);
                str = "wifi_connected";
                break;
            case 4:
                a = euw.m18059a(context, true, false);
                str = "data_connected";
                break;
            case 8:
                a = euw.m18060b(context);
                str = "alarm_arrived";
                break;
            default:
                a = null;
                break;
        }
        if (exw.m18447a() || (a != null && a.mo2318a())) {
            List<eva> arrayList = new ArrayList();
            try {
                m18037a((List) arrayList, (List) list, str);
                a.mo2317a(true);
                for (eva com_ushareit_listenit_eva2 : arrayList) {
                    exw.m18449b("CMD.Manager", "doTryExecuteCmds(): Execute new cloud command: " + com_ushareit_listenit_eva2.m18099a());
                    m18045a(i, com_ushareit_listenit_eva2);
                }
            } catch (Exception e) {
                exw.m18449b("CMD.Manager", "doTryExecuteCmds(): Pull commands failed from cloud: " + e.toString());
                a.mo2317a(false);
            }
        }
    }

    private void m18040e() {
        List<evp> c = this.f11910c.m18177c();
        if (c != null && c.size() > 0) {
            try {
                ezt a = evc.m18134a(this.f11909b, c);
                if (a.m18642b() != 200) {
                    exw.m18449b("CMD.Manager", "uploadReportStatus(): Upload report status failed and status code = " + a.m18642b());
                    throw new exa(1, "Status code " + a.m18642b());
                }
                String a2 = a.m18641a();
                if (fbb.m18758a(a2)) {
                    exw.m18449b("CMD.Manager", "uploadReportStatus(): The json is empty.");
                    throw new exa(1, "Json is empty");
                }
                int i = new JSONObject(a2).getInt("result");
                if (i != 0) {
                    exw.m18449b("CMD.Manager", "uploadReportStatus(): Upload report status failed and result = " + i);
                    throw new exa(1, "Result is " + i);
                }
                for (evp b : c) {
                    this.f11910c.m18176b(b);
                }
            } catch (IOException e) {
                throw new exa(2, e.toString());
            } catch (JSONException e2) {
                throw new exa(1, e2.toString());
            }
        }
    }

    private void m18036a(String str, evd com_ushareit_listenit_evd, boolean z) {
        this.f11911d.put(str, com_ushareit_listenit_evd);
    }

    private void m18041f() {
        List<eva> a = this.f11910c.m18166a();
        if (a != null) {
            for (eva com_ushareit_listenit_eva : a) {
                if (com_ushareit_listenit_eva.m18125j() == evf.RUNNING) {
                    com_ushareit_listenit_eva.m18102a(evf.WAITING);
                    this.f11910c.m18172a(com_ushareit_listenit_eva.m18099a(), evf.WAITING);
                    exw.m18449b("CMD.Manager", "preprocessCmds: change running to waiting status and id = " + com_ushareit_listenit_eva.m18099a());
                }
                if (com_ushareit_listenit_eva.m18130o()) {
                    if (com_ushareit_listenit_eva.m18125j() == evf.ERROR && !com_ushareit_listenit_eva.m18128m()) {
                        com_ushareit_listenit_eva.m18102a(evf.EXPIRED);
                        this.f11910c.m18172a(com_ushareit_listenit_eva.m18099a(), evf.EXPIRED);
                        ewt.m18316a(this.f11909b, this.f11910c, new evp(com_ushareit_listenit_eva, C0321x.aF, com_ushareit_listenit_eva.m18119e("error_reason")));
                    } else if (com_ushareit_listenit_eva.m18125j() == evf.WAITING) {
                        com_ushareit_listenit_eva.m18102a(evf.EXPIRED);
                        this.f11910c.m18172a(com_ushareit_listenit_eva.m18099a(), evf.EXPIRED);
                        ewt.m18316a(this.f11909b, this.f11910c, new evp(com_ushareit_listenit_eva, "expired", com_ushareit_listenit_eva.m18108b("conds_detail", null)));
                    }
                    if (com_ushareit_listenit_eva.m18114c(172800000) && !"cmd_type_personal".equalsIgnoreCase(com_ushareit_listenit_eva.m18107b())) {
                        this.f11910c.m18168a(com_ushareit_listenit_eva.m18099a());
                        m18039b(com_ushareit_listenit_eva);
                        exw.m18449b("CMD.Manager", "preprocessCmds: remove expired over two days cmd = " + com_ushareit_listenit_eva.m18099a());
                    }
                }
            }
        }
    }

    private List<String> m18042g() {
        List<String> arrayList = new ArrayList();
        arrayList.addAll(this.f11911d.keySet());
        return arrayList;
    }

    private List<String> m18043h() {
        List<eva> a = this.f11910c.m18166a();
        List<String> arrayList = new ArrayList();
        for (eva a2 : a) {
            arrayList.add(a2.m18099a());
        }
        return arrayList;
    }

    private void m18037a(List<eva> list, List<String> list2, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            List h = m18043h();
            ewz b = ewz.m18330b(this.f11909b);
            exw.m18449b("CMD.Manager", "doPullCommands() and supportedTypes = " + list2.toString());
            ezt a = evc.m18135a(this.f11909b, list2, h, b);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a.m18642b() != 200) {
                exw.m18449b("CMD.Manager", "doPullCommands(): Pull commands failed and status code = " + a.m18642b());
                euz.m18093a(this.f11909b, "failed_status_" + a.m18642b(), str, Long.valueOf(currentTimeMillis2), null);
                throw new exa(1, "Status code " + a.m18642b());
            }
            String a2 = a.m18641a();
            if (fbb.m18758a(a2)) {
                exw.m18449b("CMD.Manager", "doPullCommands(): The json is empty.");
                euz.m18093a(this.f11909b, "failed_json_empty", str, Long.valueOf(currentTimeMillis2), null);
                throw new exa(1, "Json is empty");
            }
            JSONObject jSONObject = new JSONObject(a2);
            int i = jSONObject.getInt("result");
            if (i != 0) {
                exw.m18449b("CMD.Manager", "doPullCommands(): Pull commands successed but get no command with result = " + i);
                euz.m18093a(this.f11909b, "failed_result_" + i, str, Long.valueOf(currentTimeMillis2), null);
                throw new exa(1, "Result is " + i);
            }
            JSONArray jSONArray = jSONObject.has("cmds") ? jSONObject.getJSONArray("cmds") : null;
            if (jSONArray == null || jSONArray.length() == 0) {
                exw.m18449b("CMD.Manager", "doPullCommands(): Pull commands successed but cmdJA.length() == 0");
                euz.m18093a(this.f11909b, "success_empty", str, Long.valueOf(currentTimeMillis2), null);
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    try {
                        eva com_ushareit_listenit_eva = new eva(optJSONObject);
                        com_ushareit_listenit_eva.m18116d(System.currentTimeMillis());
                        if (m18051a(com_ushareit_listenit_eva) && list != null) {
                            list.add(com_ushareit_listenit_eva);
                        }
                    } catch (JSONException e) {
                        exw.m18456d("CMD.Manager", e.toString());
                    } catch (IOException e2) {
                        euz.m18093a(this.f11909b, "failed_IOException", str, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), null);
                        throw new exa(2, e2.toString());
                    }
                }
            }
            euz.m18093a(this.f11909b, "success", str, Long.valueOf(currentTimeMillis2), Integer.valueOf(jSONArray.length()));
        } catch (IOException e22) {
            euz.m18093a(this.f11909b, "failed_IOException", str, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), null);
            throw new exa(2, e22.toString());
        } catch (JSONException e3) {
            euz.m18093a(this.f11909b, "failed_JSONException", str, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), null);
            throw new exa(1, e3.toString());
        }
    }

    private void m18039b(eva com_ushareit_listenit_eva) {
        if ("cmd_type_ad".equalsIgnoreCase(com_ushareit_listenit_eva.m18107b())) {
            for (eyh j : eux.m18086d(new ewf(com_ushareit_listenit_eva))) {
                j.mo2335j();
            }
        }
    }
}
