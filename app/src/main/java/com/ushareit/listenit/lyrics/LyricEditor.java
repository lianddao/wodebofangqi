package com.ushareit.listenit.lyrics;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.ggm;
import com.ushareit.listenit.ggo;
import com.ushareit.listenit.ggp;
import com.ushareit.listenit.ght;
import com.ushareit.listenit.gig;
import com.ushareit.listenit.gih;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gyn;
import java.util.ArrayList;
import java.util.List;

public class LyricEditor extends TagEditor {
    private ggm f15828b;
    private gig f15829c = new ggp(this);

    public LyricEditor(Context context) {
        super(context);
        m24707f();
    }

    public LyricEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24707f();
    }

    private void m24707f() {
        setPasterFilter(this.f15829c);
    }

    public void setLyric(ggm com_ushareit_listenit_ggm) {
        this.f15828b = com_ushareit_listenit_ggm;
        if (com_ushareit_listenit_ggm != null) {
            m24700a(m24705a(com_ushareit_listenit_ggm));
        }
        exw.m18443a("LyricEditor", "setLyric: " + m24705a(com_ushareit_listenit_ggm));
    }

    private List<gih> m24705a(ggm com_ushareit_listenit_ggm) {
        int d = com_ushareit_listenit_ggm.m21956d();
        List<gih> arrayList = new ArrayList(d);
        for (int i = 0; i < d; i++) {
            ggo e = com_ushareit_listenit_ggm.m21959e(i);
            arrayList.add(new gih(this, gyn.m23208b(e.f14093a), e.f14094b));
        }
        return arrayList;
    }

    public void setLyricStartTime(long j) {
        String a = ght.m22032a((int) j);
        setCurrLineTag(a.substring(1, a.length() - 1));
        m24712c();
    }

    public void m24708a() {
        super.m24703d();
    }

    public void mo2886a(String str) {
        m24702b(str);
    }

    public void m24711b() {
        int currLineSumHeight = getCurrLineSumHeight();
        int scrollY = getScrollY();
        int height = getHeight();
        if (currLineSumHeight <= scrollY || currLineSumHeight >= scrollY + height) {
            smoothScrollBy(0, (currLineSumHeight - scrollY) - height);
        }
    }

    public void m24712c() {
        m24704e();
    }

    public void m24709a(glg com_ushareit_listenit_glg) {
        List<gih> tagContents = getTagContents();
        exw.m18443a("LyricEditor", "saveLyric: size=" + tagContents.size());
        if (this.f15828b != null || tagContents.size() != 1 || !TextUtils.isEmpty(((gih) tagContents.get(0)).f14162b)) {
            if (this.f15828b == null) {
                this.f15828b = new ggm();
            }
            this.f15828b.m21950b();
            for (gih com_ushareit_listenit_gih : tagContents) {
                this.f15828b.m21947a(com_ushareit_listenit_gih.f14162b, ght.m22036b(com_ushareit_listenit_gih.f14161a, this.f15828b));
            }
            ght.m22033a(com_ushareit_listenit_glg, this.f15828b);
        }
    }
}
