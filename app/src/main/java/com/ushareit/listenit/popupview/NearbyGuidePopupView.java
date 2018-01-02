package com.ushareit.listenit.popupview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fhy;
import com.ushareit.listenit.fir;
import com.ushareit.listenit.fxp;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.gqc;
import com.ushareit.listenit.gqd;
import com.ushareit.listenit.gqe;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.main.MainActivity;
import com.ushareit.listenit.widget.RoundedRectangleImageView;

public class NearbyGuidePopupView extends BasePopupView {
    private fxp f16230a;
    private MainActivity f16231b;
    private boolean f16232c = true;
    private OnClickListener f16233d = new gqd(this);
    private OnClickListener f16234e = new gqe(this);

    public NearbyGuidePopupView(MainActivity mainActivity, fxp com_ushareit_listenit_fxp) {
        super(mainActivity);
        this.f16230a = com_ushareit_listenit_fxp;
        this.f16231b = mainActivity;
        m25605a((Context) mainActivity, (ViewGroup) this);
    }

    public void m25605a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_nearby_guide, viewGroup);
        TextView textView = (TextView) inflate.findViewById(C0349R.id.open_nearby);
        View findViewById = inflate.findViewById(C0349R.id.close_popup);
        RoundedRectangleImageView roundedRectangleImageView = (RoundedRectangleImageView) inflate.findViewById(C0349R.id.guide_background);
        fhy.m19214b();
        try {
            if (fhy.m19213a()) {
                textView.setText(C0349R.string.nearby_guide_open_nearby_button_b);
                roundedRectangleImageView.setImageDrawable(getResources().getDrawable(C0349R.drawable.nearby_popup_background_b));
            } else {
                textView.setText(C0349R.string.nearby_guide_open_nearby_button);
                roundedRectangleImageView.setImageDrawable(getResources().getDrawable(C0349R.drawable.nearby_popup_background));
            }
            fir.m19413o();
        } catch (OutOfMemoryError e) {
            this.f16232c = false;
        } finally {
            gvj.m22952f(true);
        }
        post(new gqc(this, inflate));
        textView.setOnClickListener(this.f16234e);
        findViewById.setOnClickListener(this.f16233d);
    }

    private void m25602a(View view) {
        View view2 = (RoundedRectangleImageView) view.findViewById(C0349R.id.guide_background);
        TextView textView = (TextView) view.findViewById(C0349R.id.open_nearby);
        int width = (int) ((((float) (view2.getWidth() * 240)) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / 315.0f);
        if (width > 0) {
            gyn.m23224c(view2, width);
            gyn.m23237e(textView, width - textView.getHeight());
        }
    }

    public boolean m25606a() {
        return this.f16232c;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }

    public int getGravity() {
        return 17;
    }

    public boolean getCancelable() {
        return false;
    }
}
