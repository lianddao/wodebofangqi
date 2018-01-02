package com.ushareit.listenit;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import com.facebook.GraphRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.Executor;

public class ajd extends AsyncTask<Void, Void, List<ajh>> {
    private static final String f4462a = ajd.class.getCanonicalName();
    private static Method f4463b;
    private final HttpURLConnection f4464c;
    private final aje f4465d;
    private Exception f4466e;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5750a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5751a((List) obj);
    }

    static {
        for (Method method : AsyncTask.class.getMethods()) {
            if ("executeOnExecutor".equals(method.getName())) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 2 && parameterTypes[0] == Executor.class && parameterTypes[1].isArray()) {
                    f4463b = method;
                    return;
                }
            }
        }
    }

    public ajd(aje com_ushareit_listenit_aje) {
        this(null, com_ushareit_listenit_aje);
    }

    public ajd(HttpURLConnection httpURLConnection, aje com_ushareit_listenit_aje) {
        this.f4465d = com_ushareit_listenit_aje;
        this.f4464c = httpURLConnection;
    }

    public String toString() {
        return "{RequestAsyncTask: " + " connection: " + this.f4464c + ", requests: " + this.f4465d + "}";
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (this.f4465d.m5761c() == null) {
            this.f4465d.m5755a(new Handler());
        }
    }

    protected void m5751a(List<ajh> list) {
        super.onPostExecute(list);
        if (this.f4466e != null) {
            Log.d(f4462a, String.format("onPostExecute: exception encountered during request: %s", new Object[]{this.f4466e.getMessage()}));
        }
    }

    protected List<ajh> m5750a(Void... voidArr) {
        try {
            if (this.f4464c == null) {
                return this.f4465d.m5765g();
            }
            return GraphRequest.m729a(this.f4464c, this.f4465d);
        } catch (Exception e) {
            this.f4466e = e;
            return null;
        }
    }

    public ajd m5749a() {
        if (f4463b != null) {
            try {
                f4463b.invoke(this, new Object[]{ail.m5713d(), null});
            } catch (InvocationTargetException e) {
            } catch (IllegalAccessException e2) {
            }
        } else {
            execute(new Void[0]);
        }
        return this;
    }
}
