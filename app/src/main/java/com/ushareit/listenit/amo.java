package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.MediaView;
import com.facebook.ads.au;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amo extends akz {
    private final amp f4868c;
    private au f4869d;
    private boolean f4870e;
    private boolean f4871f;
    private boolean f4872g;
    private View f4873h;
    private List<View> f4874i;

    public amo(Context context, alb com_ushareit_listenit_alb, aru com_ushareit_listenit_aru, amp com_ushareit_listenit_amp) {
        super(context, com_ushareit_listenit_alb, com_ushareit_listenit_aru);
        this.f4868c = com_ushareit_listenit_amp;
    }

    private String m6322b(View view) {
        try {
            return m6323c(view).toString();
        } catch (JSONException e) {
            return "Json exception";
        }
    }

    private JSONObject m6323c(View view) {
        boolean z = true;
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("id", Integer.valueOf(view.getId()));
        jSONObject.putOpt("class", view.getClass());
        jSONObject.putOpt("origin", String.format("{x:%d, y:%d}", new Object[]{Integer.valueOf(view.getTop()), Integer.valueOf(view.getLeft())}));
        jSONObject.putOpt("size", String.format("{h:%d, w:%d}", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getWidth())}));
        if (this.f4874i == null || !this.f4874i.contains(view)) {
            z = false;
        }
        jSONObject.putOpt("clickable", Boolean.valueOf(z));
        Object obj = "unknown";
        if (view instanceof Button) {
            obj = "button";
        } else if (view instanceof TextView) {
            obj = "text";
        } else if (view instanceof ImageView) {
            obj = "image";
        } else if (view instanceof MediaView) {
            obj = "mediaview";
        } else if (view instanceof ViewGroup) {
            obj = "viewgroup";
        }
        jSONObject.putOpt(VastExtensionXmlManager.TYPE, obj);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            JSONArray jSONArray = new JSONArray();
            while (i < viewGroup.getChildCount()) {
                jSONArray.put(m6323c(viewGroup.getChildAt(i)));
                i++;
            }
            jSONObject.putOpt("list", jSONArray);
        }
        return jSONObject;
    }

    private String m6324d(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return "";
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
            createBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            view.draw(new Canvas(createBitmap));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, this.f4868c.mo682i(), byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return "";
        }
    }

    public void m6325a(View view) {
        this.f4873h = view;
    }

    public void m6326a(au auVar) {
        this.f4869d = auVar;
    }

    public void m6327a(List<View> list) {
        this.f4874i = list;
    }

    protected void mo732a(Map<String, String> map) {
        if (this.f4868c != null) {
            if (this.a != null) {
                map.put("mil", String.valueOf(this.a.mo99a()));
                map.put("eil", String.valueOf(this.a.mo102b()));
                map.put("eil_source", this.a.mo103c());
            }
            if (this.f4869d != null) {
                map.put("nti", String.valueOf(this.f4869d.m955a()));
            }
            if (this.f4870e) {
                map.put("nhs", Boolean.TRUE.toString());
            }
            if (this.f4871f) {
                map.put("nmv", Boolean.TRUE.toString());
            }
            if (this.f4872g) {
                map.put("nmvap", Boolean.TRUE.toString());
            }
            if (this.f4873h != null && this.f4868c.mo680g()) {
                map.put("view", m6322b(this.f4873h));
            }
            if (this.f4873h != null && this.f4868c.mo679f()) {
                map.put("snapshot", m6324d(this.f4873h));
            }
            this.f4868c.mo673a((Map) map);
        }
    }

    public void m6329a(boolean z) {
        this.f4870e = z;
    }

    public void m6330b(boolean z) {
        this.f4871f = z;
    }

    public void m6331c(boolean z) {
        this.f4872g = z;
    }
}
