package com.ushareit.listenit;

import android.content.Context;
import android.view.View;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Numbers;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.ImpressionTracker;
import com.mopub.nativeads.NativeClickHandler;
import com.mopub.nativeads.NativeImageHelper;
import com.mopub.nativeads.StaticNativeAd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class emq extends StaticNativeAd {
    private final Context f11269a;
    private final CustomEventNativeListener f11270b;
    private final JSONObject f11271c;
    private final ImpressionTracker f11272d;
    private final NativeClickHandler f11273e;

    public emq(Context context, JSONObject jSONObject, ImpressionTracker impressionTracker, NativeClickHandler nativeClickHandler, CustomEventNativeListener customEventNativeListener) {
        this.f11271c = jSONObject;
        this.f11269a = context.getApplicationContext();
        this.f11272d = impressionTracker;
        this.f11273e = nativeClickHandler;
        this.f11270b = customEventNativeListener;
    }

    public void m17183e() {
        if (m17181a(this.f11271c)) {
            Iterator keys = this.f11271c.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                ems a = ems.m17186a(str);
                if (a != null) {
                    try {
                        m17179a(a, this.f11271c.opt(str));
                    } catch (ClassCastException e) {
                        throw new IllegalArgumentException("JSONObject key (" + str + ") contained unexpected value.");
                    }
                }
                addExtra(str, this.f11271c.opt(str));
            }
            setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout");
            NativeImageHelper.preCacheImages(this.f11269a, m17185g(), new emr(this));
            return;
        }
        throw new IllegalArgumentException("JSONObject did not contain required keys.");
    }

    private boolean m17181a(JSONObject jSONObject) {
        Set hashSet = new HashSet();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet.containsAll(ems.f11275c);
    }

    private void m17179a(ems com_ushareit_listenit_ems, Object obj) {
        try {
            switch (emp.f11268a[com_ushareit_listenit_ems.ordinal()]) {
                case 1:
                    setMainImageUrl((String) obj);
                    return;
                case 2:
                    setIconImageUrl((String) obj);
                    return;
                case 3:
                    m3149a(obj);
                    return;
                case 4:
                    setClickDestinationUrl((String) obj);
                    return;
                case 5:
                    m17182c(obj);
                    return;
                case 6:
                    setCallToAction((String) obj);
                    return;
                case 7:
                    setTitle((String) obj);
                    return;
                case 8:
                    setText((String) obj);
                    return;
                case 9:
                    setStarRating(Numbers.parseDouble(obj));
                    return;
                default:
                    MoPubLog.m2753d("Unable to add JSON key to internal mapping: " + com_ushareit_listenit_ems.f11277a);
                    return;
            }
        } catch (ClassCastException e) {
            if (com_ushareit_listenit_ems.f11278b) {
                throw e;
            }
            MoPubLog.m2753d("Ignoring class cast exception for optional key: " + com_ushareit_listenit_ems.f11277a);
            return;
        }
        if (com_ushareit_listenit_ems.f11278b) {
            MoPubLog.m2753d("Ignoring class cast exception for optional key: " + com_ushareit_listenit_ems.f11277a);
            return;
        }
        throw e;
    }

    private void m17182c(Object obj) {
        if (obj instanceof JSONArray) {
            m3151b(obj);
        } else {
            addClickTracker((String) obj);
        }
    }

    private boolean m17180a(String str) {
        return str != null && str.toLowerCase(Locale.US).endsWith("image");
    }

    List<String> m17184f() {
        List<String> arrayList = new ArrayList(getExtras().size());
        for (Entry entry : getExtras().entrySet()) {
            if (m17180a((String) entry.getKey()) && (entry.getValue() instanceof String)) {
                arrayList.add((String) entry.getValue());
            }
        }
        return arrayList;
    }

    List<String> m17185g() {
        List<String> arrayList = new ArrayList();
        if (getMainImageUrl() != null) {
            arrayList.add(getMainImageUrl());
        }
        if (getIconImageUrl() != null) {
            arrayList.add(getIconImageUrl());
        }
        arrayList.addAll(m17184f());
        return arrayList;
    }

    public void prepare(View view) {
        this.f11272d.addView(view, this);
        this.f11273e.setOnClickListener(view, this);
    }

    public void clear(View view) {
        this.f11272d.removeView(view);
        this.f11273e.clearOnClickListener(view);
    }

    public void destroy() {
        this.f11272d.destroy();
    }

    public void recordImpression(View view) {
        m3148a();
    }

    public void handleClick(View view) {
        m3150b();
        this.f11273e.openClickDestinationUrl(getClickDestinationUrl(), view);
    }
}
