package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.util.Log;
import android.util.Pair;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0277j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class bmx {
    private static final bms f7118a = bms.m9085a("OMX.google.raw.decoder");
    private static final Pattern f7119b = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<bmz, List<bms>> f7120c = new HashMap();
    private static final Map<Integer, Integer> f7121d = new HashMap();
    private static final Map<Integer, Integer> f7122e = new HashMap();
    private static final Map<String, Integer> f7123f = new HashMap();
    private static int f7124g = -1;

    static {
        f7121d.put(Integer.valueOf(66), Integer.valueOf(1));
        f7121d.put(Integer.valueOf(77), Integer.valueOf(2));
        f7121d.put(Integer.valueOf(88), Integer.valueOf(4));
        f7121d.put(Integer.valueOf(100), Integer.valueOf(8));
        f7122e.put(Integer.valueOf(10), Integer.valueOf(1));
        f7122e.put(Integer.valueOf(11), Integer.valueOf(4));
        f7122e.put(Integer.valueOf(12), Integer.valueOf(8));
        f7122e.put(Integer.valueOf(13), Integer.valueOf(16));
        f7122e.put(Integer.valueOf(20), Integer.valueOf(32));
        f7122e.put(Integer.valueOf(21), Integer.valueOf(64));
        f7122e.put(Integer.valueOf(22), Integer.valueOf(128));
        f7122e.put(Integer.valueOf(30), Integer.valueOf(C0277j.f3694e));
        f7122e.put(Integer.valueOf(31), Integer.valueOf(C0277j.f3696g));
        f7122e.put(Integer.valueOf(32), Integer.valueOf(1024));
        f7122e.put(Integer.valueOf(40), Integer.valueOf(2048));
        f7122e.put(Integer.valueOf(41), Integer.valueOf(4096));
        f7122e.put(Integer.valueOf(42), Integer.valueOf(8192));
        f7122e.put(Integer.valueOf(50), Integer.valueOf(16384));
        f7122e.put(Integer.valueOf(51), Integer.valueOf(32768));
        f7122e.put(Integer.valueOf(52), Integer.valueOf(65536));
        f7123f.put("L30", Integer.valueOf(1));
        f7123f.put("L60", Integer.valueOf(4));
        f7123f.put("L63", Integer.valueOf(16));
        f7123f.put("L90", Integer.valueOf(64));
        f7123f.put("L93", Integer.valueOf(C0277j.f3694e));
        f7123f.put("L120", Integer.valueOf(1024));
        f7123f.put("L123", Integer.valueOf(4096));
        f7123f.put("L150", Integer.valueOf(16384));
        f7123f.put("L153", Integer.valueOf(65536));
        f7123f.put("L156", Integer.valueOf(262144));
        f7123f.put("L180", Integer.valueOf(1048576));
        f7123f.put("L183", Integer.valueOf(4194304));
        f7123f.put("L186", Integer.valueOf(16777216));
        f7123f.put("H30", Integer.valueOf(2));
        f7123f.put("H60", Integer.valueOf(8));
        f7123f.put("H63", Integer.valueOf(32));
        f7123f.put("H90", Integer.valueOf(128));
        f7123f.put("H93", Integer.valueOf(C0277j.f3696g));
        f7123f.put("H120", Integer.valueOf(2048));
        f7123f.put("H123", Integer.valueOf(8192));
        f7123f.put("H150", Integer.valueOf(32768));
        f7123f.put("H153", Integer.valueOf(131072));
        f7123f.put("H156", Integer.valueOf(524288));
        f7123f.put("H180", Integer.valueOf(2097152));
        f7123f.put("H183", Integer.valueOf(8388608));
        f7123f.put("H186", Integer.valueOf(33554432));
    }

    public static bms m9104a() {
        return f7118a;
    }

    public static bms m9105a(String str, boolean z) {
        List b = m9110b(str, z);
        return b.isEmpty() ? null : (bms) b.get(0);
    }

    public static synchronized List<bms> m9110b(String str, boolean z) {
        List<bms> list;
        synchronized (bmx.class) {
            bmz com_ushareit_listenit_bmz = new bmz(str, z);
            list = (List) f7120c.get(com_ushareit_listenit_bmz);
            if (list == null) {
                List a = m9106a(com_ushareit_listenit_bmz, btc.f7662a >= 21 ? new bnd(z) : new bnc());
                if (z && a.isEmpty() && 21 <= btc.f7662a && btc.f7662a <= 23) {
                    List a2 = m9106a(com_ushareit_listenit_bmz, new bnc());
                    if (!a2.isEmpty()) {
                        Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((bms) a2.get(0)).f7109a);
                    }
                    a = a2;
                }
                list = Collections.unmodifiableList(a);
                f7120c.put(com_ushareit_listenit_bmz, list);
            }
        }
        return list;
    }

    private static List<bms> m9106a(bmz com_ushareit_listenit_bmz, bnb com_ushareit_listenit_bnb) {
        String name;
        try {
            List<bms> arrayList = new ArrayList();
            String str = com_ushareit_listenit_bmz.f7125a;
            int a = com_ushareit_listenit_bnb.mo1017a();
            boolean b = com_ushareit_listenit_bnb.mo1020b();
            loop0:
            for (int i = 0; i < a; i++) {
                MediaCodecInfo a2 = com_ushareit_listenit_bnb.mo1018a(i);
                name = a2.getName();
                if (m9107a(a2, name, b)) {
                    for (String str2 : a2.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType(str2);
                            boolean a3 = com_ushareit_listenit_bnb.mo1019a(str, capabilitiesForType);
                            if ((!b || com_ushareit_listenit_bmz.f7126b != a3) && (b || com_ushareit_listenit_bmz.f7126b)) {
                                if (!b && a3) {
                                    arrayList.add(bms.m9086a(name + ".secure", str, capabilitiesForType));
                                    break loop0;
                                }
                            }
                            arrayList.add(bms.m9086a(name, str, capabilitiesForType));
                        }
                    }
                    continue;
                }
            }
            return arrayList;
        } catch (Exception e) {
            if (btc.f7662a > 23 || arrayList.isEmpty()) {
                Log.e("MediaCodecUtil", "Failed to query codec " + name + " (" + str2 + ")");
                throw e;
            }
            Log.e("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
        } catch (Throwable e2) {
            throw new bna(e2);
        }
    }

    private static boolean m9107a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        if (!z && str.endsWith(".secure")) {
            return false;
        }
        if (btc.f7662a < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (btc.f7662a < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (btc.f7662a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && "a70".equals(btc.f7663b)) {
            return false;
        }
        if (btc.f7662a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(btc.f7663b) || "protou".equals(btc.f7663b) || "ville".equals(btc.f7663b) || "villeplus".equals(btc.f7663b) || "villec2".equals(btc.f7663b) || btc.f7663b.startsWith("gee") || "C6602".equals(btc.f7663b) || "C6603".equals(btc.f7663b) || "C6606".equals(btc.f7663b) || "C6616".equals(btc.f7663b) || "L36h".equals(btc.f7663b) || "SO-02E".equals(btc.f7663b))) {
            return false;
        }
        if (btc.f7662a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(btc.f7663b) || "C1505".equals(btc.f7663b) || "C1604".equals(btc.f7663b) || "C1605".equals(btc.f7663b))) {
            return false;
        }
        if (btc.f7662a <= 19 && ((btc.f7663b.startsWith("d2") || btc.f7663b.startsWith("serrano") || btc.f7663b.startsWith("jflte") || btc.f7663b.startsWith("santos")) && "samsung".equals(btc.f7664c) && "OMX.SEC.vp8.dec".equals(str))) {
            return false;
        }
        if (btc.f7662a <= 19 && btc.f7663b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return true;
    }

    public static int m9108b() {
        int i = 0;
        if (f7124g == -1) {
            bms a = m9105a("video/avc", false);
            if (a != null) {
                CodecProfileLevel[] a2 = a.m9092a();
                int length = a2.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(m9101a(a2[i].level), i2);
                    i++;
                }
                i = Math.max(i2, 172800);
            }
            f7124g = i;
        }
        return f7124g;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> m9102a(java.lang.String r6) {
        /*
        r0 = 0;
        r1 = 0;
        if (r6 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = "\\.";
        r3 = r6.split(r2);
        r4 = r3[r1];
        r2 = -1;
        r5 = r4.hashCode();
        switch(r5) {
            case 3006243: goto L_0x0032;
            case 3006244: goto L_0x003c;
            case 3199032: goto L_0x001f;
            case 3214780: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r1 = r2;
    L_0x0016:
        switch(r1) {
            case 0: goto L_0x001a;
            case 1: goto L_0x001a;
            case 2: goto L_0x0046;
            case 3: goto L_0x0046;
            default: goto L_0x0019;
        };
    L_0x0019:
        goto L_0x0004;
    L_0x001a:
        r0 = m9103a(r6, r3);
        goto L_0x0004;
    L_0x001f:
        r5 = "hev1";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0015;
    L_0x0027:
        goto L_0x0016;
    L_0x0028:
        r1 = "hvc1";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0015;
    L_0x0030:
        r1 = 1;
        goto L_0x0016;
    L_0x0032:
        r1 = "avc1";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0015;
    L_0x003a:
        r1 = 2;
        goto L_0x0016;
    L_0x003c:
        r1 = "avc2";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0015;
    L_0x0044:
        r1 = 3;
        goto L_0x0016;
    L_0x0046:
        r0 = m9109b(r6, r3);
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.bmx.a(java.lang.String):android.util.Pair<java.lang.Integer, java.lang.Integer>");
    }

    private static Pair<Integer, Integer> m9103a(String str, String[] strArr) {
        if (strArr.length < 4) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        Matcher matcher = f7119b.matcher(strArr[1]);
        if (matcher.matches()) {
            int i;
            String group = matcher.group(1);
            if ("1".equals(group)) {
                i = 1;
            } else if ("2".equals(group)) {
                i = 2;
            } else {
                Log.w("MediaCodecUtil", "Unknown HEVC profile string: " + group);
                return null;
            }
            Integer num = (Integer) f7123f.get(strArr[3]);
            if (num != null) {
                return new Pair(Integer.valueOf(i), num);
            }
            Log.w("MediaCodecUtil", "Unknown HEVC level string: " + matcher.group(1));
            return null;
        }
        Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
        return null;
    }

    private static Pair<Integer, Integer> m9109b(String str, String[] strArr) {
        if (strArr.length < 2) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            Object valueOf;
            Object valueOf2;
            if (strArr[1].length() == 6) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                Integer valueOf3 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            Integer num = (Integer) f7121d.get(valueOf);
            if (num == null) {
                Log.w("MediaCodecUtil", "Unknown AVC profile: " + valueOf);
                return null;
            }
            Integer num2 = (Integer) f7122e.get(valueOf2);
            if (num2 != null) {
                return new Pair(num, num2);
            }
            Log.w("MediaCodecUtil", "Unknown AVC level: " + valueOf2);
            return null;
        } catch (NumberFormatException e) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static int m9101a(int i) {
        switch (i) {
            case 1:
            case 2:
                return 25344;
            case 8:
                return 101376;
            case 16:
                return 101376;
            case C0154a.f2957m /*32*/:
                return 101376;
            case 64:
                return 202752;
            case 128:
                return 414720;
            case C0277j.f3694e /*256*/:
                return 414720;
            case C0277j.f3696g /*512*/:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
                return 2097152;
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
                return 9437184;
            default:
                return -1;
        }
    }
}
