package com.ushareit.listenit;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.bk;
import com.facebook.internal.cb;
import com.umeng.analytics.C0154a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ajh {
    private final HttpURLConnection f4474a;
    private final JSONObject f4475b;
    private final JSONArray f4476c;
    private final aih f4477d;
    private final String f4478e;
    private final GraphRequest f4479f;

    ajh(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    ajh(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
    }

    ajh(GraphRequest graphRequest, HttpURLConnection httpURLConnection, aih com_ushareit_listenit_aih) {
        this(graphRequest, httpURLConnection, null, null, null, com_ushareit_listenit_aih);
    }

    ajh(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, aih com_ushareit_listenit_aih) {
        this.f4479f = graphRequest;
        this.f4474a = httpURLConnection;
        this.f4478e = str;
        this.f4475b = jSONObject;
        this.f4476c = jSONArray;
        this.f4477d = com_ushareit_listenit_aih;
    }

    public final aih m5776a() {
        return this.f4477d;
    }

    public final JSONObject m5777b() {
        return this.f4475b;
    }

    public String toString() {
        String format;
        try {
            Locale locale = Locale.US;
            String str = "%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.f4474a != null ? this.f4474a.getResponseCode() : 200);
            format = String.format(locale, str, objArr);
        } catch (IOException e) {
            format = "unknown";
        }
        return "{Response: " + " responseCode: " + format + ", graphObject: " + this.f4475b + ", error: " + this.f4477d + "}";
    }

    public static List<ajh> m5773a(HttpURLConnection httpURLConnection, aje com_ushareit_listenit_aje) {
        List<ajh> a;
        Closeable closeable = null;
        try {
            if (httpURLConnection.getResponseCode() >= 400) {
                closeable = httpURLConnection.getErrorStream();
            } else {
                closeable = httpURLConnection.getInputStream();
            }
            a = m5771a((InputStream) closeable, httpURLConnection, com_ushareit_listenit_aje);
        } catch (aif e) {
            bk.m1465a(ajk.REQUESTS, "Response", "Response <Error>: %s", e);
            a = m5775a((List) com_ushareit_listenit_aje, httpURLConnection, e);
        } catch (Throwable e2) {
            bk.m1465a(ajk.REQUESTS, "Response", "Response <Error>: %s", e2);
            a = m5775a((List) com_ushareit_listenit_aje, httpURLConnection, new aif(e2));
        } catch (Throwable e22) {
            bk.m1465a(ajk.REQUESTS, "Response", "Response <Error>: %s", e22);
            a = m5775a((List) com_ushareit_listenit_aje, httpURLConnection, new aif(e22));
        } catch (Throwable e222) {
            bk.m1465a(ajk.REQUESTS, "Response", "Response <Error>: %s", e222);
            a = m5775a((List) com_ushareit_listenit_aje, httpURLConnection, new aif(e222));
        } finally {
            cb.m1581a(closeable);
        }
        return a;
    }

    static List<ajh> m5771a(InputStream inputStream, HttpURLConnection httpURLConnection, aje com_ushareit_listenit_aje) {
        bk.m1465a(ajk.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(cb.m1562a(inputStream).length()), r0);
        return m5772a(cb.m1562a(inputStream), httpURLConnection, com_ushareit_listenit_aje);
    }

    static List<ajh> m5772a(String str, HttpURLConnection httpURLConnection, aje com_ushareit_listenit_aje) {
        bk.m1465a(ajk.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", com_ushareit_listenit_aje.m5760b(), Integer.valueOf(str.length()), m5774a(httpURLConnection, (List) com_ushareit_listenit_aje, new JSONTokener(str).nextValue()));
        return m5774a(httpURLConnection, (List) com_ushareit_listenit_aje, new JSONTokener(str).nextValue());
    }

    private static List<ajh> m5774a(HttpURLConnection httpURLConnection, List<GraphRequest> list, Object obj) {
        JSONArray jSONArray;
        int i = 0;
        int size = list.size();
        List<ajh> arrayList = new ArrayList(size);
        if (size == 1) {
            GraphRequest graphRequest = (GraphRequest) list.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C0154a.f2970z, obj);
                jSONObject.put("code", httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
                jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                arrayList.add(new ajh(graphRequest, httpURLConnection, new aih(httpURLConnection, e)));
                jSONArray = obj;
            } catch (Exception e2) {
                arrayList.add(new ajh(graphRequest, httpURLConnection, new aih(httpURLConnection, e2)));
            }
            if ((jSONArray instanceof JSONArray) || jSONArray.length() != size) {
                throw new aif("Unexpected number of results");
            }
            jSONArray = jSONArray;
            while (i < jSONArray.length()) {
                graphRequest = (GraphRequest) list.get(i);
                try {
                    arrayList.add(m5770a(graphRequest, httpURLConnection, jSONArray.get(i), obj));
                } catch (Exception e3) {
                    arrayList.add(new ajh(graphRequest, httpURLConnection, new aih(httpURLConnection, e3)));
                } catch (Exception e32) {
                    arrayList.add(new ajh(graphRequest, httpURLConnection, new aih(httpURLConnection, e32)));
                }
                i++;
            }
            return arrayList;
        }
        jSONArray = obj;
        if (jSONArray instanceof JSONArray) {
        }
        throw new aif("Unexpected number of results");
    }

    private static ajh m5770a(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            aih a = aih.m5690a(jSONObject, obj2, httpURLConnection);
            if (a != null) {
                if (a.m5693b() == 190 && cb.m1589a(graphRequest.m770d())) {
                    AccessToken.m675a(null);
                }
                return new ajh(graphRequest, httpURLConnection, a);
            }
            Object a2 = cb.m1559a(jSONObject, C0154a.f2970z, "FACEBOOK_NON_JSON_RESULT");
            if (a2 instanceof JSONObject) {
                return new ajh(graphRequest, httpURLConnection, a2.toString(), (JSONObject) a2);
            }
            if (a2 instanceof JSONArray) {
                return new ajh(graphRequest, httpURLConnection, a2.toString(), (JSONArray) a2);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new ajh(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
        }
        throw new aif("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
    }

    public static List<ajh> m5775a(List<GraphRequest> list, HttpURLConnection httpURLConnection, aif com_ushareit_listenit_aif) {
        int size = list.size();
        List<ajh> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ajh((GraphRequest) list.get(i), httpURLConnection, new aih(httpURLConnection, com_ushareit_listenit_aif)));
        }
        return arrayList;
    }
}
