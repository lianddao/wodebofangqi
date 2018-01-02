package com.ushareit.listenit;

import android.widget.ImageView;

public class hac {
    private static int f15030e = 0;
    public String f15031a;
    public int f15032b = 0;
    public int f15033c = 0;
    public ImageView f15034d;

    public hac(ImageView imageView, int i, int i2, String str) {
        this.f15034d = imageView;
        this.f15032b = i;
        this.f15033c = i2;
        this.f15031a = str;
        this.f15034d.setTag(C0349R.id.glide_view_tag_id, str);
    }

    public String m23433a() {
        return this.f15031a;
    }

    public int m23434b() {
        return this.f15032b;
    }

    public int m23435c() {
        return this.f15033c;
    }
}
