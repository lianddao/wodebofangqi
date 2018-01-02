package com.ushareit.listenit;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.VolleyError;

class eny implements ErrorListener {
    final /* synthetic */ env f11346a;

    eny(env com_ushareit_listenit_env) {
        this.f11346a = com_ushareit_listenit_env;
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (!(volleyError instanceof MoPubNetworkError) || ((MoPubNetworkError) volleyError).getReason().equals(Reason.WARMING_UP)) {
            MoPubLog.m2756e("Failed to load positioning data", volleyError);
            if (volleyError.networkResponse == null && !DeviceUtils.isNetworkAvailable(this.f11346a.f11335b)) {
                MoPubLog.m2751c(String.valueOf(MoPubErrorCode.NO_CONNECTION.toString()));
            }
        }
        this.f11346a.m17239b();
    }
}
