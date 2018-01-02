package com.ushareit.listenit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import com.facebook.appevents.C0075a;
import com.facebook.internal.C0093a;
import com.facebook.internal.C0111s;
import com.facebook.internal.bm;
import com.facebook.internal.bo;
import com.facebook.internal.bp;
import com.facebook.internal.cb;
import com.facebook.share.C0146b;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import com.umeng.analytics.pro.C0321x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bcj {
    public static String m7731a(Bundle bundle) {
        if (bundle.containsKey("completionGesture")) {
            return bundle.getString("completionGesture");
        }
        return bundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
    }

    public static String m7744b(Bundle bundle) {
        if (bundle.containsKey("postId")) {
            return bundle.getString("postId");
        }
        if (bundle.containsKey("com.facebook.platform.extra.POST_ID")) {
            return bundle.getString("com.facebook.platform.extra.POST_ID");
        }
        return bundle.getString("post_id");
    }

    public static boolean m7742a(int i, int i2, Intent intent, bcc com_ushareit_listenit_bcc) {
        C0093a a = m7727a(i, i2, intent);
        if (a == null) {
            return false;
        }
        bm.m1484a(a.m1247c());
        if (com_ushareit_listenit_bcc == null) {
            return true;
        }
        aif a2 = bp.m1506a(bp.m1524g(intent));
        if (a2 == null) {
            com_ushareit_listenit_bcc.mo825a(a, bp.m1520e(intent));
            return true;
        } else if (a2 instanceof aig) {
            com_ushareit_listenit_bcc.mo824a(a);
            return true;
        } else {
            com_ushareit_listenit_bcc.mo826a(a, a2);
            return true;
        }
    }

    public static bcc m7729a(aic<C0146b> com_ushareit_listenit_aic_com_facebook_share_b) {
        return new bck(com_ushareit_listenit_aic_com_facebook_share_b, com_ushareit_listenit_aic_com_facebook_share_b);
    }

    private static C0093a m7727a(int i, int i2, Intent intent) {
        UUID b = bp.m1513b(intent);
        if (b == null) {
            return null;
        }
        return C0093a.m1243a(b, i);
    }

    public static void m7738a(int i) {
        C0111s.m1712a(i, new bcl(i));
    }

    public static List<String> m7733a(SharePhotoContent sharePhotoContent, UUID uuid) {
        if (sharePhotoContent != null) {
            List a = sharePhotoContent.m1981a();
            if (a != null) {
                Collection a2 = cb.m1572a(a, new bcm(uuid));
                List<String> a3 = cb.m1572a((List) a2, new bcn());
                bm.m1483a(a2);
                return a3;
            }
        }
        return null;
    }

    public static String m7732a(ShareVideoContent shareVideoContent, UUID uuid) {
        if (shareVideoContent == null || shareVideoContent.m1986d() == null) {
            return null;
        }
        bo a = bm.m1476a(uuid, shareVideoContent.m1986d().m1982b());
        Collection arrayList = new ArrayList(1);
        arrayList.add(a);
        bm.m1483a(arrayList);
        return a.m1493a();
    }

    public static JSONObject m7736a(UUID uuid, ShareOpenGraphContent shareOpenGraphContent) {
        ShareOpenGraphAction a = shareOpenGraphContent.m1975a();
        Collection arrayList = new ArrayList();
        JSONObject a2 = bbz.m7643a(a, new bco(uuid, arrayList));
        bm.m1483a(arrayList);
        if (shareOpenGraphContent.m1957j() != null && cb.m1591a(a2.optString("place"))) {
            a2.put("place", shareOpenGraphContent.m1957j());
        }
        if (shareOpenGraphContent.m1956i() != null) {
            JSONArray optJSONArray = a2.optJSONArray("tags");
            if (optJSONArray == null) {
                arrayList = new HashSet();
            } else {
                Object b = cb.m1597b(optJSONArray);
            }
            for (String add : shareOpenGraphContent.m1956i()) {
                arrayList.add(add);
            }
            a2.put("tags", new ArrayList(arrayList));
        }
        return a2;
    }

    public static JSONObject m7735a(ShareOpenGraphContent shareOpenGraphContent) {
        return bbz.m7643a(shareOpenGraphContent.m1975a(), new bcp());
    }

    public static JSONArray m7734a(JSONArray jSONArray, boolean z) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = m7734a((JSONArray) obj, z);
            } else if (obj instanceof JSONObject) {
                obj = m7737a((JSONObject) obj, z);
            }
            jSONArray2.put(obj);
        }
        return jSONArray2;
    }

    public static JSONObject m7737a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray names = jSONObject.names();
            for (int i = 0; i < names.length(); i++) {
                Object a;
                String string = names.getString(i);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    a = m7737a((JSONObject) obj, true);
                } else if (obj instanceof JSONArray) {
                    JSONArray a2 = m7734a((JSONArray) obj, true);
                } else {
                    a = obj;
                }
                Pair a3 = m7726a(string);
                String str = (String) a3.first;
                String str2 = (String) a3.second;
                if (z) {
                    if (str != null && str.equals("fbsdk")) {
                        jSONObject2.put(string, a);
                    } else if (str == null || str.equals("og")) {
                        jSONObject2.put(str2, a);
                    } else {
                        jSONObject3.put(str2, a);
                    }
                } else if (str == null || !str.equals("fb")) {
                    jSONObject2.put(str2, a);
                } else {
                    jSONObject2.put(string, a);
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", jSONObject3);
            }
            return jSONObject2;
        } catch (JSONException e) {
            throw new aif("Failed to create json object from share content");
        }
    }

    public static Pair<String, String> m7726a(String str) {
        Object obj = null;
        int indexOf = str.indexOf(58);
        if (indexOf != -1 && str.length() > indexOf + 1) {
            obj = str.substring(0, indexOf);
            str = str.substring(indexOf + 1);
        }
        return new Pair(obj, str);
    }

    private static bo m7743b(UUID uuid, SharePhoto sharePhoto) {
        Bitmap b = sharePhoto.m1977b();
        Uri c = sharePhoto.m1978c();
        if (b != null) {
            return bm.m1475a(uuid, b);
        }
        if (c != null) {
            return bm.m1476a(uuid, c);
        }
        return null;
    }

    static void m7745b(aic<C0146b> com_ushareit_listenit_aic_com_facebook_share_b) {
        m7741a("cancelled", null);
        if (com_ushareit_listenit_aic_com_facebook_share_b != null) {
            com_ushareit_listenit_aic_com_facebook_share_b.mo2661a();
        }
    }

    static void m7740a(aic<C0146b> com_ushareit_listenit_aic_com_facebook_share_b, String str) {
        m7741a("succeeded", null);
        if (com_ushareit_listenit_aic_com_facebook_share_b != null) {
            com_ushareit_listenit_aic_com_facebook_share_b.mo2663a(new C0146b(str));
        }
    }

    static void m7739a(aic<C0146b> com_ushareit_listenit_aic_com_facebook_share_b, aif com_ushareit_listenit_aif) {
        m7741a(C0321x.aF, com_ushareit_listenit_aif.getMessage());
        if (com_ushareit_listenit_aic_com_facebook_share_b != null) {
            com_ushareit_listenit_aic_com_facebook_share_b.mo2662a(com_ushareit_listenit_aif);
        }
    }

    private static void m7741a(String str, String str2) {
        C0075a a = C0075a.m1174a(ail.m5715f());
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_outcome", str);
        if (str2 != null) {
            bundle.putString("error_message", str2);
        }
        a.m1207a("fb_share_dialog_result", null, bundle);
    }

    public static bdm m7730a(bdm com_ushareit_listenit_bdm, bdm com_ushareit_listenit_bdm2) {
        if (com_ushareit_listenit_bdm == com_ushareit_listenit_bdm2) {
            return com_ushareit_listenit_bdm;
        }
        if (com_ushareit_listenit_bdm == bdm.UNKNOWN) {
            return com_ushareit_listenit_bdm2;
        }
        return com_ushareit_listenit_bdm2 != bdm.UNKNOWN ? null : com_ushareit_listenit_bdm;
    }
}
