package com.ushareit.listenit;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apb implements aoz, apa {
    private static final String f5125a = apb.class.getSimpleName();
    private static apb f5126b;
    private static double f5127c;
    private static String f5128d;
    private final aow f5129e;
    private final ans f5130f;
    private final Context f5131g;

    protected apb(Context context) {
        this.f5130f = new ans(context);
        this.f5129e = new aow(context, this);
        this.f5129e.m6519b();
        this.f5131g = context;
        anm.m6391a(context).m6392a();
    }

    public static apb m6565a(Context context) {
        if (f5126b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f5126b == null) {
                    f5126b = new apb(applicationContext);
                    aop.m6483a();
                    f5127c = aop.m6484b();
                    f5128d = aop.m6485c();
                }
            }
        }
        return f5126b;
    }

    private JSONObject m6566a(int i) {
        Cursor d;
        Cursor a;
        Cursor cursor;
        Throwable th;
        try {
            d = this.f5130f.m6424d();
            try {
                a = this.f5130f.m6417a(i);
            } catch (JSONException e) {
                cursor = null;
                a = d;
                if (a != null) {
                    a.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                a = null;
                if (d != null) {
                    d.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
            try {
                JSONObject jSONObject;
                if (a.getCount() > 0) {
                    jSONObject = new JSONObject();
                    jSONObject.put("tokens", m6567a(a));
                    jSONObject.put("events", m6570c(a));
                } else {
                    jSONObject = null;
                }
                if (app.m6623e(this.f5131g)) {
                    JSONArray a2 = auj.m7199a(this.f5131g);
                    if (a2 != null && a2.length() > 0) {
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        jSONObject.put("debug", a2);
                    }
                }
                if (d != null) {
                    d.close();
                }
                if (a == null) {
                    return jSONObject;
                }
                a.close();
                return jSONObject;
            } catch (JSONException e2) {
                cursor = a;
                a = d;
                if (a != null) {
                    a.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (d != null) {
                    d.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (JSONException e3) {
            cursor = null;
            a = null;
            if (a != null) {
                a.close();
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            a = null;
            d = null;
            if (d != null) {
                d.close();
            }
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    private JSONObject m6567a(Cursor cursor) {
        JSONObject jSONObject = new JSONObject();
        while (cursor.moveToNext()) {
            jSONObject.put(cursor.getString(0), cursor.getString(1));
        }
        return jSONObject;
    }

    private void m6568a(aov com_ushareit_listenit_aov) {
        this.f5130f.m6420a(com_ushareit_listenit_aov, new apc(this, com_ushareit_listenit_aov));
    }

    private JSONArray m6569b(Cursor cursor) {
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", cursor.getString(anr.f4979a.f4975a));
            jSONObject.put("token_id", cursor.getString(anr.f4980b.f4975a));
            jSONObject.put(VastExtensionXmlManager.TYPE, cursor.getString(anr.f4982d.f4975a));
            jSONObject.put("time", atz.m7158a(cursor.getDouble(anr.f4983e.f4975a)));
            jSONObject.put("session_time", atz.m7158a(cursor.getDouble(anr.f4984f.f4975a)));
            jSONObject.put("session_id", cursor.getString(anr.f4985g.f4975a));
            String string = cursor.getString(anr.f4986h.f4975a);
            jSONObject.put("data", string != null ? new JSONObject(string) : new JSONObject());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private JSONArray m6570c(Cursor cursor) {
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", cursor.getString(2));
            jSONObject.put("token_id", cursor.getString(0));
            jSONObject.put(VastExtensionXmlManager.TYPE, cursor.getString(4));
            jSONObject.put("time", atz.m7158a(cursor.getDouble(5)));
            jSONObject.put("session_time", atz.m7158a(cursor.getDouble(6)));
            jSONObject.put("session_id", cursor.getString(7));
            String string = cursor.getString(8);
            jSONObject.put("data", string != null ? new JSONObject(string) : new JSONObject());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private JSONObject m6571d() {
        Cursor cursor;
        Throwable th;
        Cursor f;
        Cursor e;
        try {
            f = this.f5130f.m6426f();
            try {
                e = this.f5130f.m6425e();
            } catch (JSONException e2) {
                cursor = null;
                e = f;
                if (e != null) {
                    e.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                e = null;
                if (f != null) {
                    f.close();
                }
                if (e != null) {
                    e.close();
                }
                throw th;
            }
            try {
                JSONObject jSONObject;
                if (f.getCount() <= 0 || e.getCount() <= 0) {
                    jSONObject = null;
                } else {
                    jSONObject = new JSONObject();
                    jSONObject.put("tokens", m6567a(f));
                    jSONObject.put("events", m6569b(e));
                }
                if (app.m6623e(this.f5131g)) {
                    JSONArray a = auj.m7199a(this.f5131g);
                    if (a != null && a.length() > 0) {
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        jSONObject.put("debug", a);
                    }
                }
                if (f != null) {
                    f.close();
                }
                if (e == null) {
                    return jSONObject;
                }
                e.close();
                return jSONObject;
            } catch (JSONException e3) {
                cursor = e;
                e = f;
                if (e != null) {
                    e.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (f != null) {
                    f.close();
                }
                if (e != null) {
                    e.close();
                }
                throw th;
            }
        } catch (JSONException e4) {
            cursor = null;
            e = null;
            if (e != null) {
                e.close();
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            e = null;
            f = null;
            if (f != null) {
                f.close();
            }
            if (e != null) {
                e.close();
            }
            throw th;
        }
    }

    public JSONObject mo740a() {
        int h = app.m6626h(this.f5131g);
        return h > 0 ? m6566a(h) : m6571d();
    }

    public void mo741a(String str) {
        new aux().execute(new String[]{str});
    }

    public void m6574a(String str, aue com_ushareit_listenit_aue) {
        m6568a(new aos(str, f5127c, f5128d, com_ushareit_listenit_aue));
    }

    public void mo742a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m6568a(new ape(this.f5131g, str, f5127c, f5128d, map));
        }
    }

    public void m6576a(String str, Map<String, String> map, String str2, apd com_ushareit_listenit_apd) {
        m6568a(new aph(this.f5131g, str, f5127c, f5128d, map, str2, com_ushareit_listenit_apd));
    }

    public boolean mo743a(JSONArray jSONArray) {
        boolean e = app.m6623e(this.f5131g);
        Object obj = null;
        boolean z = true;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("id");
                int i2 = jSONObject.getInt("code");
                if (i2 == 1) {
                    if (e && jSONObject.optInt("dbtype", 0) == 1) {
                        obj = 1;
                    } else {
                        this.f5130f.m6421a(string);
                    }
                } else if (i2 >= 1000 && i2 < 2000) {
                    z = false;
                } else if (i2 >= 2000 && i2 < 3000) {
                    if (e && jSONObject.optInt("dbtype", 0) == 1) {
                        int i3 = 1;
                    } else {
                        this.f5130f.m6421a(string);
                    }
                }
            } catch (JSONException e2) {
            }
        }
        if (obj != null) {
            auj.m7202b(this.f5131g);
        }
        return z;
    }

    public void mo744b() {
        this.f5130f.m6427g();
        this.f5130f.m6422b();
    }

    public void m6579b(String str) {
        Log.e(f5125a, "AdEventManager error: " + str);
    }

    public void mo745b(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m6568a(new apg(this.f5131g, str, f5127c, f5128d, map));
        }
    }

    public void mo746c(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m6568a(new apk(this.f5131g, str, f5127c, f5128d, map));
        }
    }

    public boolean mo747c() {
        Throwable th;
        Cursor cursor;
        boolean z = true;
        int h = app.m6626h(this.f5131g);
        if (h < 1) {
            return false;
        }
        Cursor cursor2 = null;
        try {
            cursor2 = this.f5130f.m6424d();
            try {
                if (!cursor2.moveToFirst() || cursor2.getInt(0) <= h) {
                    z = false;
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursor2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void mo748d(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m6568a(new api(str, f5127c, f5128d, map));
        }
    }

    public void mo749e(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m6568a(new aot(this.f5131g, str, f5127c, f5128d, map));
        }
    }

    public void m6585f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m6568a(new apf(this.f5131g, str, f5127c, f5128d, map));
        }
    }

    public void m6586g(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m6568a(new apj(this.f5131g, str, f5127c, f5128d, map));
        }
    }
}
