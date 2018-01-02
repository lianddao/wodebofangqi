package com.ushareit.listenit;

import com.ushareit.listenit.lyrics.LyricEditor;
import java.util.ArrayList;
import java.util.List;

public class ggp implements gig {
    final /* synthetic */ LyricEditor f14096a;

    public ggp(LyricEditor lyricEditor) {
        this.f14096a = lyricEditor;
    }

    public List<gih> mo2678a(CharSequence charSequence) {
        ggm a;
        int i = 0;
        String[] split = charSequence.toString().split("\n");
        List arrayList = new ArrayList(split.length);
        for (String trim : split) {
            arrayList.add(trim.trim());
        }
        if (ght.m22037b(arrayList)) {
            a = ght.m22031a(arrayList);
        } else {
            a = null;
        }
        if (a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            while (i < a.m21956d()) {
                stringBuffer.append("[").append(a.m21957d(i)).append("]").append(a.m21953c(i)).append("\n");
                i++;
            }
            exw.m18443a("LyricEditor", "pasteFilter: lyric=" + stringBuffer);
        }
        if (a == null) {
            return null;
        }
        return this.f14096a.m24705a(a);
    }
}
