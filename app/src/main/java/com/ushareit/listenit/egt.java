package com.ushareit.listenit;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper.GpsHelperListener;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;

public class egt extends AsyncTask<Void, Void, Void> {
    private WeakReference<Context> f11051a;
    private WeakReference<GpsHelperListener> f11052b;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m17071a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m17072a((Void) obj);
    }

    public egt(Context context, GpsHelperListener gpsHelperListener) {
        this.f11051a = new WeakReference(context);
        this.f11052b = new WeakReference(gpsHelperListener);
    }

    protected Void m17071a(Void... voidArr) {
        try {
            Context context = (Context) this.f11051a.get();
            if (context != null) {
                Object execute = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(GpsHelper.f2122b)).addParam(Context.class, context).execute();
                if (execute != null) {
                    GpsHelper.m2674a(context, execute);
                }
            }
        } catch (Exception e) {
            MoPubLog.m2753d("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
        }
        return null;
    }

    protected void m17072a(Void voidR) {
        GpsHelperListener gpsHelperListener = (GpsHelperListener) this.f11052b.get();
        if (gpsHelperListener != null) {
            gpsHelperListener.onFetchAdInfoCompleted();
        }
    }
}
