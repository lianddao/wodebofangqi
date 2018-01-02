package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.mopub.nativeads.BaseNativeAd;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.NativeImageHelper;
import com.mopub.nativeads.StaticNativeAd;

public class fhe extends fgx {
    protected fhe(ViewGroup viewGroup, ffl com_ushareit_listenit_ffl) {
        super(viewGroup, com_ushareit_listenit_ffl);
    }

    public void mo2374a(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        BaseNativeAd baseNativeAd = ((NativeAd) com_ushareit_listenit_esi.m17769c()).getBaseNativeAd();
        if (baseNativeAd instanceof StaticNativeAd) {
            StaticNativeAd staticNativeAd = (StaticNativeAd) baseNativeAd;
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.ad_common_flash_page, viewGroup, false);
            ((TextView) relativeLayout.findViewById(C0349R.id.title)).setText(staticNativeAd.getTitle());
            if (!TextUtils.isEmpty(staticNativeAd.getTitle())) {
                ((TextView) relativeLayout.findViewById(C0349R.id.body)).setText(staticNativeAd.getText());
            }
            if (!TextUtils.isEmpty(staticNativeAd.getCallToAction())) {
                ((Button) relativeLayout.findViewById(C0349R.id.call_to_action)).setText(staticNativeAd.getCallToAction());
            }
            ImageView imageView = (ImageView) relativeLayout.findViewById(C0349R.id.main_image);
            Bitmap bitmap = com_ushareit_listenit_esi.m17719b("adImage") ? (Bitmap) com_ushareit_listenit_esi.m17720c("adImage") : null;
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                imageView = (ImageView) relativeLayout.findViewById(C0349R.id.background);
                if (com_ushareit_listenit_esi.m17719b("adBackground") && com_ushareit_listenit_esi.m17720c("adBackground") != null) {
                    imageView.setImageBitmap((Bitmap) com_ushareit_listenit_esi.m17720c("adBackground"));
                }
            }
            viewGroup.addView(relativeLayout);
            staticNativeAd.prepare(relativeLayout);
        }
    }

    public void mo2376b(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        BaseNativeAd baseNativeAd = ((NativeAd) com_ushareit_listenit_esi.m17769c()).getBaseNativeAd();
        if (baseNativeAd instanceof StaticNativeAd) {
            int dimension;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.ad_play_page_base_view, viewGroup, false);
            View findViewById = linearLayout.findViewById(C0349R.id.close_ad);
            ImageView imageView = (ImageView) linearLayout.findViewById(C0349R.id.content_img);
            ImageView imageView2 = (ImageView) linearLayout.findViewById(C0349R.id.icon);
            TextView textView = (TextView) linearLayout.findViewById(C0349R.id.title);
            TextView textView2 = (TextView) linearLayout.findViewById(C0349R.id.content);
            Button button = (Button) linearLayout.findViewById(C0349R.id.go);
            StaticNativeAd staticNativeAd = (StaticNativeAd) baseNativeAd;
            if (staticNativeAd.getMainImageUrl() != null) {
                NativeImageHelper.loadImageView(staticNativeAd.getMainImageUrl(), imageView);
            }
            if (staticNativeAd.getIconImageUrl() != null) {
                NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(), imageView2);
                dimension = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
            } else {
                imageView2.setVisibility(8);
                dimension = 0;
            }
            textView.setText(staticNativeAd.getTitle());
            textView2.setText(m19162a(staticNativeAd.getText(), dimension));
            button.setText(staticNativeAd.getCallToAction());
            viewGroup.addView(linearLayout);
            staticNativeAd.prepare(linearLayout);
            findViewById.setOnClickListener(new fhf(this, viewGroup, com_ushareit_listenit_esi));
        }
    }

    public void mo2377c(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        BaseNativeAd baseNativeAd = ((NativeAd) com_ushareit_listenit_esi.m17769c()).getBaseNativeAd();
        if (baseNativeAd instanceof StaticNativeAd) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.ad_common_list_item, viewGroup, false);
            StaticNativeAd staticNativeAd = (StaticNativeAd) baseNativeAd;
            ImageView imageView = (ImageView) relativeLayout.findViewById(C0349R.id.native_ad_icon);
            if (staticNativeAd.getIconImageUrl() != null) {
                NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(), imageView);
            } else {
                LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.leftMargin = 0;
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                }
            }
            ((TextView) relativeLayout.findViewById(C0349R.id.native_ad_title)).setText(staticNativeAd.getTitle());
            if (staticNativeAd.getText() != null) {
                ((TextView) relativeLayout.findViewById(C0349R.id.native_ad_body)).setText(staticNativeAd.getText());
            }
            viewGroup.addView(relativeLayout);
            staticNativeAd.prepare(relativeLayout);
            relativeLayout.findViewById(C0349R.id.close_ad).setOnClickListener(new fhg(this, relativeLayout, com_ushareit_listenit_esi));
        }
    }

    public void mo2375a(ViewGroup viewGroup, esi com_ushareit_listenit_esi, fev com_ushareit_listenit_fev) {
        BaseNativeAd baseNativeAd = ((NativeAd) com_ushareit_listenit_esi.m17769c()).getBaseNativeAd();
        if (baseNativeAd instanceof StaticNativeAd) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.ad_common_home_page, viewGroup, false);
            StaticNativeAd staticNativeAd = (StaticNativeAd) baseNativeAd;
            ImageView imageView = (ImageView) relativeLayout.findViewById(C0349R.id.native_ad_icon);
            if (staticNativeAd.getIconImageUrl() != null) {
                NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(), imageView);
            } else {
                LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.leftMargin = 0;
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                }
            }
            ((TextView) relativeLayout.findViewById(C0349R.id.native_ad_title)).setText(staticNativeAd.getTitle());
            if (staticNativeAd.getText() != null) {
                ((TextView) relativeLayout.findViewById(C0349R.id.native_ad_body)).setText(staticNativeAd.getText());
            }
            viewGroup.addView(relativeLayout);
            staticNativeAd.prepare(relativeLayout);
            relativeLayout.findViewById(C0349R.id.close_ad).setOnClickListener(new fhh(this, com_ushareit_listenit_fev, com_ushareit_listenit_esi));
        }
    }

    public void mo2378d(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        BaseNativeAd baseNativeAd = ((NativeAd) com_ushareit_listenit_esi.m17769c()).getBaseNativeAd();
        if (baseNativeAd instanceof StaticNativeAd) {
            int dimension;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.ad_play_page_base_view, viewGroup, false);
            View findViewById = linearLayout.findViewById(C0349R.id.close_ad);
            ImageView imageView = (ImageView) linearLayout.findViewById(C0349R.id.content_img);
            ImageView imageView2 = (ImageView) linearLayout.findViewById(C0349R.id.icon);
            TextView textView = (TextView) linearLayout.findViewById(C0349R.id.title);
            TextView textView2 = (TextView) linearLayout.findViewById(C0349R.id.content);
            Button button = (Button) linearLayout.findViewById(C0349R.id.go);
            StaticNativeAd staticNativeAd = (StaticNativeAd) baseNativeAd;
            if (staticNativeAd.getMainImageUrl() != null) {
                NativeImageHelper.loadImageView(staticNativeAd.getMainImageUrl(), imageView);
            }
            if (staticNativeAd.getIconImageUrl() != null) {
                NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(), imageView2);
                dimension = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
            } else {
                imageView2.setVisibility(8);
                dimension = 0;
            }
            textView.setText(staticNativeAd.getTitle());
            textView2.setText(m19162a(staticNativeAd.getText(), dimension));
            button.setText(staticNativeAd.getCallToAction());
            viewGroup.addView(linearLayout);
            staticNativeAd.prepare(linearLayout);
            findViewById.setOnClickListener(new fhi(this, viewGroup, com_ushareit_listenit_esi));
        }
    }

    public void mo2379e(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        BaseNativeAd baseNativeAd = ((NativeAd) com_ushareit_listenit_esi.m17769c()).getBaseNativeAd();
        if (baseNativeAd instanceof StaticNativeAd) {
            int dimension;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.charge_screen_ad_view, viewGroup, false);
            View findViewById = linearLayout.findViewById(C0349R.id.close_ad);
            ImageView imageView = (ImageView) linearLayout.findViewById(C0349R.id.content_img);
            ImageView imageView2 = (ImageView) linearLayout.findViewById(C0349R.id.icon);
            TextView textView = (TextView) linearLayout.findViewById(C0349R.id.title);
            TextView textView2 = (TextView) linearLayout.findViewById(C0349R.id.content);
            Button button = (Button) linearLayout.findViewById(C0349R.id.go);
            StaticNativeAd staticNativeAd = (StaticNativeAd) baseNativeAd;
            if (staticNativeAd.getMainImageUrl() != null) {
                NativeImageHelper.loadImageView(staticNativeAd.getMainImageUrl(), imageView);
            }
            if (staticNativeAd.getIconImageUrl() != null) {
                NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(), imageView2);
                dimension = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
            } else {
                imageView2.setVisibility(8);
                dimension = 0;
            }
            textView.setText(staticNativeAd.getTitle());
            textView2.setText(m19162a(staticNativeAd.getText(), dimension));
            button.setText(staticNativeAd.getCallToAction());
            viewGroup.addView(linearLayout);
            staticNativeAd.prepare(linearLayout);
            findViewById.setOnClickListener(new fhj(this, viewGroup, com_ushareit_listenit_esi));
        }
    }
}
