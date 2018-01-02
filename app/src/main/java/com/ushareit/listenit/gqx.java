package com.ushareit.listenit;

import com.ushareit.listenit.popupview.RatePopupView;
import com.ushareit.listenit.widget.EmotionRatingBar;

public class gqx implements hbo {
    final /* synthetic */ RatePopupView f14572a;

    public gqx(RatePopupView ratePopupView) {
        this.f14572a = ratePopupView;
    }

    public void mo2737a(EmotionRatingBar emotionRatingBar, int i) {
        if (i == 5) {
            this.f14572a.f16257a.setText(C0349R.string.popup_view_rate_full_stars_desc);
            this.f14572a.f16258b.setVisibility(0);
            this.f14572a.f16259c.setVisibility(0);
            this.f14572a.f16259c.setText(C0349R.string.popup_view_rateus);
            this.f14572a.f16259c.setTextColor(this.f14572a.getResources().getColorStateList(C0349R.color.common_text_orange_bg));
            this.f14572a.f16258b.setTextColor(C0349R.color.common_text_black_bg, C0349R.color.common_text_black_bg_night);
        } else if (i > 0) {
            this.f14572a.f16257a.setText(C0349R.string.popup_view_rate_some_stars_desc);
            this.f14572a.f16258b.setVisibility(0);
            this.f14572a.f16259c.setVisibility(0);
            this.f14572a.f16259c.setText(C0349R.string.popup_view_feedback);
            this.f14572a.f16259c.setTextColor(this.f14572a.getResources().getColorStateList(C0349R.color.common_text_orange_bg));
            this.f14572a.f16258b.setTextColor(C0349R.color.common_text_black_bg, C0349R.color.common_text_black_bg_night);
        } else {
            this.f14572a.f16257a.setText(C0349R.string.popup_view_rate_no_stars_desc);
            this.f14572a.f16258b.setVisibility(0);
            this.f14572a.f16259c.setVisibility(8);
            this.f14572a.f16258b.setTextColor(C0349R.color.common_text_black_bg, C0349R.color.common_text_black_bg_night);
        }
    }
}
