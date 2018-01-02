package com.ushareit.listenit.lockscreen.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gcc;
import com.ushareit.listenit.gdb;
import com.ushareit.listenit.gdf;
import com.ushareit.listenit.gdg;
import com.ushareit.listenit.ik;
import com.ushareit.listenit.kx;
import java.util.ArrayList;
import java.util.List;

public class ChargeLockScreenViewGroup extends FrameLayout {
    private gcc f15695a;
    private ViewPager f15696b;
    private List<View> f15697c = new ArrayList();
    private ChargeLockScreenView f15698d;
    private ImageView f15699e;
    private kx f15700f = new gdf(this);
    private ik f15701g = new gdg(this);

    public ChargeLockScreenViewGroup(Context context) {
        super(context);
        m24549a();
    }

    public ChargeLockScreenViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24549a();
    }

    public ChargeLockScreenViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24549a();
    }

    private void m24549a() {
        inflate(getContext(), C0349R.layout.charge_lock_screen_view_group, this);
        this.f15696b = (ViewPager) findViewById(C0349R.id.vp);
        this.f15699e = (ImageView) findViewById(C0349R.id.wallpaper);
        this.f15698d = new ChargeLockScreenView(getContext());
        gdb.m21731a().m21734a(this.f15699e);
        this.f15697c.add(new EmptyPage(getContext()));
        this.f15697c.add(this.f15698d);
        this.f15696b.setOffscreenPageLimit(2);
        this.f15696b.setAdapter(this.f15701g);
        this.f15696b.setCurrentItem(1);
        this.f15696b.setOnPageChangeListener(this.f15700f);
        m24551b();
    }

    @TargetApi(9)
    private void m24551b() {
        try {
            if (VERSION.SDK_INT >= 9) {
                this.f15696b.setOverScrollMode(2);
            }
        } catch (Exception e) {
        }
    }

    public void setOnDragFinishListener(gcc com_ushareit_listenit_gcc) {
        this.f15695a = com_ushareit_listenit_gcc;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        gdb.m21731a().m21735b();
    }
}
