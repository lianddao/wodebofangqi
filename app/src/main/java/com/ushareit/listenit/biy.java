package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.umeng.analytics.pro.dm;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class biy {
    public String f6501a;
    public int f6502b;
    public int f6503c;
    public int f6504d;
    public boolean f6505e;
    public byte[] f6506f;
    public byte[] f6507g;
    public byte[] f6508h;
    public DrmInitData f6509i;
    public int f6510j;
    public int f6511k;
    public int f6512l;
    public int f6513m;
    public int f6514n;
    public byte[] f6515o;
    public int f6516p;
    public int f6517q;
    public int f6518r;
    public int f6519s;
    public long f6520t;
    public long f6521u;
    public boolean f6522v;
    public boolean f6523w;
    public bii f6524x;
    public int f6525y;
    private String f6526z;

    private biy() {
        this.f6510j = -1;
        this.f6511k = -1;
        this.f6512l = -1;
        this.f6513m = -1;
        this.f6514n = 0;
        this.f6515o = null;
        this.f6516p = -1;
        this.f6517q = 1;
        this.f6518r = -1;
        this.f6519s = 8000;
        this.f6520t = 0;
        this.f6521u = 0;
        this.f6523w = true;
        this.f6526z = "eng";
    }

    public void m8659a(bia com_ushareit_listenit_bia, int i) {
        Format a;
        int i2 = -1;
        int i3 = -1;
        List list = null;
        String str = this.f6501a;
        Object obj = -1;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    obj = 5;
                    break;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    obj = 3;
                    break;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    obj = 21;
                    break;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    obj = 16;
                    break;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    obj = 10;
                    break;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    obj = 13;
                    break;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    obj = 8;
                    break;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    obj = 4;
                    break;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    obj = 6;
                    break;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    obj = 24;
                    break;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    obj = 19;
                    break;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    obj = 12;
                    break;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    obj = 14;
                    break;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    obj = 17;
                    break;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    obj = null;
                    break;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    obj = 1;
                    break;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    obj = 25;
                    break;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    obj = 9;
                    break;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    obj = 18;
                    break;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    obj = 22;
                    break;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    obj = 7;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    obj = 23;
                    break;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    obj = 2;
                    break;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    obj = 15;
                    break;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    obj = 20;
                    break;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    obj = 11;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                str = "video/x-vnd.on2.vp8";
                break;
            case 1:
                str = "video/x-vnd.on2.vp9";
                break;
            case 2:
                str = "video/mpeg2";
                break;
            case 3:
            case 4:
            case 5:
                List list2;
                str = "video/mp4v-es";
                if (this.f6508h == null) {
                    list2 = null;
                } else {
                    list2 = Collections.singletonList(this.f6508h);
                }
                list = list2;
                break;
            case 6:
                str = "video/avc";
                btf a2 = btf.m9785a(new bss(this.f6508h));
                list = a2.f7672a;
                this.f6525y = a2.f7673b;
                break;
            case 7:
                str = "video/hevc";
                btg a3 = btg.m9787a(new bss(this.f6508h));
                list = a3.f7677a;
                this.f6525y = a3.f7678b;
                break;
            case 8:
                list = m8656a(new bss(this.f6508h));
                str = list == null ? "video/x-unknown" : "video/wvc1";
                break;
            case 9:
                str = "video/x-unknown";
                break;
            case 10:
                str = "audio/vorbis";
                i2 = 8192;
                list = m8657a(this.f6508h);
                break;
            case 11:
                str = "audio/opus";
                i2 = 5760;
                list = new ArrayList(3);
                list.add(this.f6508h);
                list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.f6520t).array());
                list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.f6521u).array());
                break;
            case 12:
                str = "audio/mp4a-latm";
                list = Collections.singletonList(this.f6508h);
                break;
            case 13:
                str = "audio/mpeg";
                i2 = 4096;
                break;
            case 14:
                str = "audio/ac3";
                break;
            case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
                str = "audio/eac3";
                break;
            case 16:
                str = "audio/true-hd";
                break;
            case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
            case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                str = "audio/vnd.dts";
                break;
            case Encoder.LINE_GROUPS /*19*/:
                str = "audio/vnd.dts.hd";
                break;
            case 20:
                str = "audio/x-flac";
                list = Collections.singletonList(this.f6508h);
                break;
            case 21:
                str = "audio/raw";
                if (m8658b(new bss(this.f6508h))) {
                    i3 = btc.m9759a(this.f6518r);
                    if (i3 == 0) {
                        throw new bfw("Unsupported PCM bit depth: " + this.f6518r);
                    }
                }
                throw new bfw("Non-PCM MS/ACM is unsupported");
                break;
            case 22:
                str = "audio/raw";
                i3 = btc.m9759a(this.f6518r);
                if (i3 == 0) {
                    throw new bfw("Unsupported PCM bit depth: " + this.f6518r);
                }
                break;
            case 23:
                str = "application/x-subrip";
                break;
            case 24:
                str = "application/vobsub";
                list = Collections.singletonList(this.f6508h);
                break;
            case 25:
                str = "application/pgs";
                break;
            default:
                throw new bfw("Unrecognized codec identifier.");
        }
        int i4 = (0 | (this.f6523w ? 1 : 0)) | (this.f6522v ? 2 : 0);
        if (bsn.m9677a(str)) {
            a = Format.m2067a(Integer.toString(i), str, null, -1, i2, this.f6517q, this.f6519s, i3, list, this.f6509i, i4, this.f6526z);
        } else if (bsn.m9678b(str)) {
            if (this.f6514n == 0) {
                this.f6512l = this.f6512l == -1 ? this.f6510j : this.f6512l;
                this.f6513m = this.f6513m == -1 ? this.f6511k : this.f6513m;
            }
            float f = -1.0f;
            if (!(this.f6512l == -1 || this.f6513m == -1)) {
                f = ((float) (this.f6511k * this.f6512l)) / ((float) (this.f6510j * this.f6513m));
            }
            a = Format.m2065a(Integer.toString(i), str, null, -1, i2, this.f6510j, this.f6511k, -1.0f, list, -1, f, this.f6515o, this.f6516p, this.f6509i);
        } else if ("application/x-subrip".equals(str)) {
            a = Format.m2069a(Integer.toString(i), str, null, -1, i4, this.f6526z, this.f6509i);
        } else if ("application/vobsub".equals(str) || "application/pgs".equals(str)) {
            a = Format.m2072a(Integer.toString(i), str, null, -1, list, this.f6526z, this.f6509i);
        } else {
            throw new bfw("Unexpected MIME type.");
        }
        this.f6524x = com_ushareit_listenit_bia.mo1025a(this.f6502b);
        this.f6524x.mo975a(a);
    }

    private static List<byte[]> m8656a(bss com_ushareit_listenit_bss) {
        try {
            com_ushareit_listenit_bss.m9709d(16);
            if (com_ushareit_listenit_bss.m9719m() != 826496599) {
                return null;
            }
            int d = com_ushareit_listenit_bss.m9708d() + 20;
            byte[] bArr = com_ushareit_listenit_bss.f7639a;
            while (d < bArr.length - 4) {
                if (bArr[d] == (byte) 0 && bArr[d + 1] == (byte) 0 && bArr[d + 2] == (byte) 1 && bArr[d + 3] == dm.f3663m) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, d, bArr.length));
                }
                d++;
            }
            throw new bfw("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new bfw("Error parsing FourCC VC1 codec private");
        }
    }

    private static List<byte[]> m8657a(byte[] bArr) {
        int i = 0;
        try {
            if (bArr[0] != (byte) 2) {
                throw new bfw("Error parsing vorbis codec private");
            }
            int i2 = 0;
            int i3 = 1;
            while (bArr[i3] == (byte) -1) {
                i3++;
                i2 += 255;
            }
            int i4 = i3 + 1;
            i2 += bArr[i3];
            while (bArr[i4] == (byte) -1) {
                i += 255;
                i4++;
            }
            i3 = i4 + 1;
            i += bArr[i4];
            if (bArr[i3] != (byte) 1) {
                throw new bfw("Error parsing vorbis codec private");
            }
            Object obj = new byte[i2];
            System.arraycopy(bArr, i3, obj, 0, i2);
            i2 += i3;
            if (bArr[i2] != (byte) 3) {
                throw new bfw("Error parsing vorbis codec private");
            }
            i += i2;
            if (bArr[i] != (byte) 5) {
                throw new bfw("Error parsing vorbis codec private");
            }
            Object obj2 = new byte[(bArr.length - i)];
            System.arraycopy(bArr, i, obj2, 0, bArr.length - i);
            List<byte[]> arrayList = new ArrayList(2);
            arrayList.add(obj);
            arrayList.add(obj2);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new bfw("Error parsing vorbis codec private");
        }
    }

    private static boolean m8658b(bss com_ushareit_listenit_bss) {
        try {
            int i = com_ushareit_listenit_bss.m9715i();
            if (i == 1) {
                return true;
            }
            if (i != 65534) {
                return false;
            }
            com_ushareit_listenit_bss.m9707c(24);
            if (com_ushareit_listenit_bss.m9722p() == biv.f6451d.getMostSignificantBits() && com_ushareit_listenit_bss.m9722p() == biv.f6451d.getLeastSignificantBits()) {
                return true;
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new bfw("Error parsing MS/ACM codec private");
        }
    }
}
