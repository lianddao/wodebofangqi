package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.AdChoicesView;
import com.facebook.ads.MediaView;
import com.facebook.ads.af;
import com.facebook.ads.an;
import java.util.ArrayList;
import java.util.List;

public class fgy extends fgx {
    public fgy(ViewGroup viewGroup, ffl com_ushareit_listenit_ffl) {
        super(viewGroup, com_ushareit_listenit_ffl);
    }

    public void mo2374a(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.ad_common_flash_page, viewGroup, false);
        af afVar = (af) com_ushareit_listenit_esi.m17769c();
        ((TextView) relativeLayout.findViewById(C0349R.id.title)).setText(afVar.m904f());
        if (!TextUtils.isEmpty(afVar.m905g())) {
            ((TextView) relativeLayout.findViewById(C0349R.id.body)).setText(afVar.m905g());
        }
        if (!TextUtils.isEmpty(afVar.m906h())) {
            ((Button) relativeLayout.findViewById(C0349R.id.call_to_action)).setText(afVar.m906h());
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
        ((LinearLayout) relativeLayout.findViewById(C0349R.id.choices_container)).addView(new AdChoicesView(viewGroup.getContext(), afVar, true));
        List arrayList = new ArrayList();
        arrayList.add(relativeLayout);
        arrayList.add(relativeLayout.findViewById(C0349R.id.call_to_action));
        afVar.m894a((View) viewGroup, arrayList);
        viewGroup.addView(relativeLayout);
    }

    public void mo2376b(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        int i;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        MediaView mediaView = (MediaView) from.inflate(C0349R.layout.ad_facebook_navite_media, viewGroup, false);
        View view = (LinearLayout) from.inflate(C0349R.layout.ad_play_page_base_view, viewGroup, false);
        View findViewById = view.findViewById(C0349R.id.close_ad);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C0349R.id.content_view);
        ImageView imageView = (ImageView) view.findViewById(C0349R.id.icon);
        TextView textView = (TextView) view.findViewById(C0349R.id.title);
        TextView textView2 = (TextView) view.findViewById(C0349R.id.content);
        Button button = (Button) view.findViewById(C0349R.id.go);
        af afVar = (af) com_ushareit_listenit_esi.m17769c();
        ((ImageView) view.findViewById(C0349R.id.content_img)).setVisibility(8);
        mediaView.setNativeAd(afVar);
        frameLayout.addView(mediaView);
        an d = afVar.m902d();
        textView.setText(afVar.m904f());
        if (d == null) {
            imageView.setVisibility(8);
            i = 0;
        } else {
            i = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
            imageView.setVisibility(0);
            af.m864a(d, imageView);
        }
        textView2.setText(m19162a(afVar.m905g(), i));
        button.setText(afVar.m906h());
        findViewById.setOnClickListener(new fgz(this, viewGroup, com_ushareit_listenit_esi));
        List arrayList = new ArrayList();
        arrayList.add(view);
        arrayList.add(button);
        afVar.m894a(view, arrayList);
        viewGroup.addView(view);
    }

    public void mo2377c(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.ad_common_list_item, viewGroup, false);
        af afVar = (af) com_ushareit_listenit_esi.m17769c();
        ImageView imageView = (ImageView) inflate.findViewById(C0349R.id.native_ad_icon);
        if (afVar.m902d() != null) {
            af.m864a(afVar.m902d(), imageView);
        } else {
            LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.leftMargin = 0;
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
            }
        }
        ((TextView) inflate.findViewById(C0349R.id.native_ad_title)).setText(afVar.m904f());
        if (afVar.m905g() != null) {
            ((TextView) inflate.findViewById(C0349R.id.native_ad_body)).setText(afVar.m905g());
        }
        List arrayList = new ArrayList();
        arrayList.add(inflate);
        afVar.m894a((View) viewGroup, arrayList);
        inflate.findViewById(C0349R.id.close_ad).setOnClickListener(new fha(this, inflate, com_ushareit_listenit_esi));
        viewGroup.addView(inflate);
    }

    public void mo2375a(ViewGroup viewGroup, esi com_ushareit_listenit_esi, fev com_ushareit_listenit_fev) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.ad_common_home_page, viewGroup, false);
        af afVar = (af) com_ushareit_listenit_esi.m17769c();
        ImageView imageView = (ImageView) inflate.findViewById(C0349R.id.native_ad_icon);
        if (afVar.m902d() != null) {
            af.m864a(afVar.m902d(), imageView);
        } else {
            LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.leftMargin = 0;
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
            }
        }
        ((TextView) inflate.findViewById(C0349R.id.native_ad_title)).setText(afVar.m904f());
        if (afVar.m905g() != null) {
            ((TextView) inflate.findViewById(C0349R.id.native_ad_body)).setText(afVar.m905g());
        }
        ((LinearLayout) inflate.findViewById(C0349R.id.choices_container)).addView(new AdChoicesView(viewGroup.getContext(), afVar, true));
        List arrayList = new ArrayList();
        arrayList.add(inflate);
        afVar.m894a((View) viewGroup, arrayList);
        inflate.findViewById(C0349R.id.close_ad).setOnClickListener(new fhb(this, com_ushareit_listenit_fev, com_ushareit_listenit_esi));
        viewGroup.addView(inflate);
    }

    public void mo2378d(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        int i;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        MediaView mediaView = (MediaView) from.inflate(C0349R.layout.ad_facebook_navite_media, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) from.inflate(C0349R.layout.ad_play_page_base_view, viewGroup, false);
        View findViewById = linearLayout.findViewById(C0349R.id.close_ad);
        FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(C0349R.id.content_view);
        ImageView imageView = (ImageView) linearLayout.findViewById(C0349R.id.icon);
        TextView textView = (TextView) linearLayout.findViewById(C0349R.id.title);
        TextView textView2 = (TextView) linearLayout.findViewById(C0349R.id.content);
        Button button = (Button) linearLayout.findViewById(C0349R.id.go);
        af afVar = (af) com_ushareit_listenit_esi.m17769c();
        ((ImageView) linearLayout.findViewById(C0349R.id.content_img)).setVisibility(8);
        mediaView.setNativeAd(afVar);
        frameLayout.addView(mediaView);
        an d = afVar.m902d();
        textView.setText(afVar.m904f());
        if (d == null) {
            imageView.setVisibility(8);
            i = 0;
        } else {
            i = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
            imageView.setVisibility(0);
            af.m864a(d, imageView);
        }
        textView2.setText(m19162a(afVar.m905g(), i));
        button.setText(afVar.m906h());
        findViewById.setOnClickListener(new fhc(this, viewGroup, com_ushareit_listenit_esi));
        List arrayList = new ArrayList();
        arrayList.add(linearLayout);
        arrayList.add(button);
        afVar.m894a((View) viewGroup, arrayList);
        viewGroup.addView(linearLayout);
    }

    public void mo2379e(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        int i;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        MediaView mediaView = (MediaView) from.inflate(C0349R.layout.ad_facebook_navite_media, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) from.inflate(C0349R.layout.charge_screen_ad_view, viewGroup, false);
        View findViewById = linearLayout.findViewById(C0349R.id.close_ad);
        FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(C0349R.id.content_view);
        ImageView imageView = (ImageView) linearLayout.findViewById(C0349R.id.icon);
        TextView textView = (TextView) linearLayout.findViewById(C0349R.id.title);
        TextView textView2 = (TextView) linearLayout.findViewById(C0349R.id.content);
        Button button = (Button) linearLayout.findViewById(C0349R.id.go);
        af afVar = (af) com_ushareit_listenit_esi.m17769c();
        ((ImageView) linearLayout.findViewById(C0349R.id.content_img)).setVisibility(8);
        mediaView.setNativeAd(afVar);
        frameLayout.addView(mediaView);
        an d = afVar.m902d();
        textView.setText(afVar.m904f());
        if (d == null) {
            imageView.setVisibility(8);
            i = 0;
        } else {
            i = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
            imageView.setVisibility(0);
            af.m864a(d, imageView);
        }
        textView2.setText(m19162a(afVar.m905g(), i));
        button.setText(afVar.m906h());
        findViewById.setOnClickListener(new fhd(this, viewGroup, com_ushareit_listenit_esi));
        List arrayList = new ArrayList();
        arrayList.add(linearLayout);
        arrayList.add(button);
        afVar.m894a((View) viewGroup, arrayList);
        viewGroup.addView(linearLayout);
    }
}
