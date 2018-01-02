package com.ushareit.listenit;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.ushareit.listenit.nearby.widget.NoLoginUserView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class gmh extends fji {
    private static final float[] f14404a = new float[]{400.0f, 300.0f, 370.0f, 330.0f, 335.0f};
    private static final float[] f14405b = new float[]{190.0f, -50.0f, 290.0f, -50.0f, 300.0f};
    private static final float[] f14406c = new float[]{360.0f, 950.0f, 600.0f, 644.0f, 816.0f};
    private View f14407d;
    private FrameLayout f14408e;
    private OnClickListener f14409f = new gmi(this);
    private OnClickListener f14410g = new gmj(this);

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Drawable bitmapDrawable;
        this.f14408e = (FrameLayout) layoutInflater.inflate(C0349R.layout.nearby_login_view, null);
        this.f14408e.findViewById(C0349R.id.login_bt).setOnClickListener(this.f14410g);
        this.f14407d = this.f14408e.findViewById(C0349R.id.progress_view);
        View findViewById = this.f14408e.findViewById(C0349R.id.backgroud);
        try {
            bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(m1329n(), C0349R.drawable.nearby_login_bg));
        } catch (Throwable th) {
            bitmapDrawable = null;
        }
        if (bitmapDrawable == null) {
            bitmapDrawable = gyn.m23207b(C0349R.drawable.nearby_login_bg, fbb.m18762c(eys.m18562a()), fbb.m18764d(eys.m18562a()));
        }
        if (bitmapDrawable != null) {
            if (gzd.m23364e() == 1) {
                bitmapDrawable = hhe.m23348a(bitmapDrawable, m1329n().getColor(C0349R.color.common_image_mask_50_night));
            }
            findViewById.setBackgroundDrawable(bitmapDrawable);
        } else {
            findViewById.setBackgroundColor(m1329n().getColor(gzd.m23364e() == 1 ? C0349R.color.common_text_color_white_night : C0349R.color.common_text_color_white));
        }
        mo2550c();
        return this.f14408e;
    }

    public void mo2550c() {
        int[] iArr = new int[]{C0349R.drawable.avatar_female_1abbey, C0349R.drawable.avatar_female_2bailey, C0349R.drawable.avatar_female_3elena, C0349R.drawable.avatar_female_4gabrielle, C0349R.drawable.avatar_female_5lane, C0349R.drawable.avatar_female_6emma, C0349R.drawable.avatar_female_7florence, C0349R.drawable.avatar_female_8lara, C0349R.drawable.avatar_female_9taylor, C0349R.drawable.avatar_female_10patti, C0349R.drawable.avatar_female_11yvonne, C0349R.drawable.avatar_female_12reese, C0349R.drawable.avatar_female_13peachey, C0349R.drawable.avatar_male_1ash, C0349R.drawable.avatar_male_2bernard, C0349R.drawable.avatar_male_3baird, C0349R.drawable.avatar_male_4carroll, C0349R.drawable.avatar_male_5dalton, C0349R.drawable.avatar_male_6hall, C0349R.drawable.avatar_male_7james, C0349R.drawable.avatar_male_8fisher, C0349R.drawable.avatar_male_9dixon, C0349R.drawable.avatar_male_10gibson, C0349R.drawable.avatar_male_11odom, C0349R.drawable.avatar_male_12malone, C0349R.drawable.avatar_male_13freeman};
        String[] strArr = new String[]{"Abbey", "Bailey", "Elena", "Gabrielle", "lane", "Emma", "Florence", "Lara", "Taylor", "Patti", "Yvonne", "Reese", "Peachey", "Ash", "Bernard", "Baird", "Carroll", "Dalton", "Hall", "James", "Fisher", "Dixon", "Gibson", "Odom", "Malone", "Freeman"};
        Random random = new Random();
        List arrayList = new ArrayList(iArr.length);
        while (arrayList.size() < 5) {
            int nextInt = random.nextInt(iArr.length);
            if (!arrayList.contains(Integer.valueOf(nextInt))) {
                arrayList.add(Integer.valueOf(nextInt));
            }
        }
        for (int i = 0; i < 5; i++) {
            nextInt = ((Integer) arrayList.get(i)).intValue();
            m22439c(i).setData(new fni(String.valueOf(iArr[nextInt]), strArr[nextInt], random.nextInt(66), random.nextInt(666), 0, 0, ""), f14404a[i] / 422.0f);
        }
        this.f14407d.setVisibility(8);
    }

    private NoLoginUserView m22439c(int i) {
        View noLoginUserView = new NoLoginUserView(m1326l());
        int c = (int) ((f14405b[i] / 720.0f) * ((float) fbb.m18762c(eys.m18562a())));
        int d = (int) ((f14406c[i] / 1280.0f) * ((float) fbb.m18764d(eys.m18562a())));
        LayoutParams layoutParams = new FrameLayout.LayoutParams((int) m1329n().getDimension(C0349R.dimen.common_dimens_235dp), (int) m1329n().getDimension(C0349R.dimen.common_dimens_102dp));
        layoutParams.setMargins(c, 0, 0, d);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(c);
        }
        layoutParams.gravity = 8388691;
        noLoginUserView.setLayoutParams(layoutParams);
        this.f14408e.addView(noLoginUserView);
        noLoginUserView.setOnClickListener(this.f14409f);
        return noLoginUserView;
    }

    public boolean mo2549b() {
        return false;
    }
}
