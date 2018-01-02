package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

public class hfa implements heu {
    private Bitmap f15248a;
    private ImageView f15249b;
    private int f15250c = CtaButton.BACKGROUND_COLOR;
    private ListView f15251d;

    public hfa(ListView listView) {
        this.f15251d = listView;
    }

    public void m23607d(int i) {
        this.f15250c = i;
    }

    public View mo2757c(int i) {
        View childAt = this.f15251d.getChildAt((this.f15251d.getHeaderViewsCount() + i) - this.f15251d.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f15248a = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f15249b == null) {
            this.f15249b = new ImageView(this.f15251d.getContext());
        }
        this.f15249b.setBackgroundColor(this.f15250c);
        this.f15249b.setPadding(0, 0, 0, 0);
        this.f15249b.setImageBitmap(this.f15248a);
        this.f15249b.setLayoutParams(new LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f15249b;
    }

    public void mo2756a(View view, Point point, Point point2) {
    }

    public void mo2755a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f15248a.recycle();
        this.f15248a = null;
    }
}
