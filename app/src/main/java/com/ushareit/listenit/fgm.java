package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAdView;
import java.util.List;

public class fgm extends fgx {
    protected fgm(ViewGroup viewGroup, ffl com_ushareit_listenit_ffl) {
        super(viewGroup, com_ushareit_listenit_ffl);
    }

    public void mo2374a(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        ImageView imageView;
        Bitmap bitmap;
        if (com_ushareit_listenit_esi.m17769c() instanceof but) {
            View inflate = from.inflate(C0349R.layout.ad_admob_appinstall_flash_page, viewGroup, false);
            NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) inflate.findViewById(C0349R.id.native_app_install_ad);
            but com_ushareit_listenit_but = (but) com_ushareit_listenit_esi.m17769c();
            imageView = (ImageView) nativeAppInstallAdView.findViewById(C0349R.id.main_image);
            nativeAppInstallAdView.setImageView(imageView);
            bitmap = com_ushareit_listenit_esi.m17719b("adImage") ? (Bitmap) com_ushareit_listenit_esi.m17720c("adImage") : null;
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                imageView = (ImageView) nativeAppInstallAdView.findViewById(C0349R.id.background);
                if (com_ushareit_listenit_esi.m17719b("adBackground") && com_ushareit_listenit_esi.m17720c("adBackground") != null) {
                    imageView.setImageBitmap((Bitmap) com_ushareit_listenit_esi.m17720c("adBackground"));
                }
            }
            nativeAppInstallAdView.setHeadlineView(nativeAppInstallAdView.findViewById(C0349R.id.title));
            ((TextView) nativeAppInstallAdView.getHeadlineView()).setText(com_ushareit_listenit_but.mo1778b());
            nativeAppInstallAdView.setBodyView(nativeAppInstallAdView.findViewById(C0349R.id.body));
            ((TextView) nativeAppInstallAdView.getBodyView()).setText(com_ushareit_listenit_but.mo1780d());
            nativeAppInstallAdView.setCallToActionView(nativeAppInstallAdView.findViewById(C0349R.id.call_to_action));
            ((TextView) nativeAppInstallAdView.getCallToActionView()).setText(com_ushareit_listenit_but.mo1782f());
            nativeAppInstallAdView.setNativeAd(com_ushareit_listenit_but);
            viewGroup.addView(inflate);
            return;
        }
        inflate = from.inflate(C0349R.layout.ad_admob_content_flash_page, viewGroup, false);
        NativeContentAdView nativeContentAdView = (NativeContentAdView) inflate.findViewById(C0349R.id.native_content_ad);
        buv com_ushareit_listenit_buv = (buv) com_ushareit_listenit_esi.m17769c();
        imageView = (ImageView) nativeContentAdView.findViewById(C0349R.id.main_image);
        nativeContentAdView.setImageView(imageView);
        bitmap = com_ushareit_listenit_esi.m17719b("adImage") ? (Bitmap) com_ushareit_listenit_esi.m17720c("adImage") : null;
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            imageView = (ImageView) nativeContentAdView.findViewById(C0349R.id.background);
            if (com_ushareit_listenit_esi.m17719b("adBackground") && com_ushareit_listenit_esi.m17720c("adBackground") != null) {
                imageView.setImageBitmap((Bitmap) com_ushareit_listenit_esi.m17720c("adBackground"));
            }
        }
        nativeContentAdView.setHeadlineView(nativeContentAdView.findViewById(C0349R.id.title));
        ((TextView) nativeContentAdView.getHeadlineView()).setText(com_ushareit_listenit_buv.mo1797b());
        nativeContentAdView.setBodyView(nativeContentAdView.findViewById(C0349R.id.body));
        ((TextView) nativeContentAdView.getBodyView()).setText(com_ushareit_listenit_buv.mo1799d());
        nativeContentAdView.setCallToActionView(nativeContentAdView.findViewById(C0349R.id.call_to_action));
        ((TextView) nativeContentAdView.getCallToActionView()).setText(com_ushareit_listenit_buv.mo1801f());
        nativeContentAdView.setNativeAd(com_ushareit_listenit_buv);
        viewGroup.addView(inflate);
    }

    public void mo2376b(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (com_ushareit_listenit_esi.m17769c() instanceof but) {
            RelativeLayout relativeLayout = (RelativeLayout) from.inflate(C0349R.layout.ad_admob_appinstall_play_page, viewGroup, false);
            MediaView mediaView = (MediaView) View.inflate(viewGroup.getContext(), C0349R.layout.ad_admob_navite_media, null);
            NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) relativeLayout.findViewById(C0349R.id.native_ad);
            FrameLayout frameLayout = (FrameLayout) relativeLayout.findViewById(C0349R.id.content_view);
            View findViewById = relativeLayout.findViewById(C0349R.id.close_ad);
            ImageView imageView = (ImageView) relativeLayout.findViewById(C0349R.id.content_img);
            ImageView imageView2 = (ImageView) relativeLayout.findViewById(C0349R.id.icon);
            TextView textView = (TextView) relativeLayout.findViewById(C0349R.id.title);
            TextView textView2 = (TextView) relativeLayout.findViewById(C0349R.id.content);
            Button button = (Button) relativeLayout.findViewById(C0349R.id.go);
            but com_ushareit_listenit_but = (but) com_ushareit_listenit_esi.m17769c();
            if (com_ushareit_listenit_but.mo1786j().m9881b()) {
                frameLayout.addView(mediaView);
                nativeAppInstallAdView.setMediaView(mediaView);
                imageView.setVisibility(8);
            } else {
                List c = com_ushareit_listenit_but.mo1779c();
                if (!(c == null || c.get(0) == null || ((bup) c.get(0)).mo1761a() == null)) {
                    imageView.setImageDrawable(((bup) c.get(0)).mo1761a());
                    nativeAppInstallAdView.setImageView(imageView);
                }
            }
            bup e = com_ushareit_listenit_but.mo1781e();
            int i = 0;
            if (e == null || e.mo1761a() == null) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setImageDrawable(e.mo1761a());
                i = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
                imageView2.setVisibility(0);
            }
            textView.setText(com_ushareit_listenit_but.mo1778b());
            textView2.setText(m19162a(com_ushareit_listenit_but.mo1780d(), i));
            button.setText(com_ushareit_listenit_but.mo1782f());
            findViewById.setOnClickListener(new fgp(this, viewGroup, com_ushareit_listenit_esi));
            nativeAppInstallAdView.setImageView(imageView);
            nativeAppInstallAdView.setIconView(imageView2);
            nativeAppInstallAdView.setHeadlineView(textView);
            nativeAppInstallAdView.setBodyView(textView2);
            nativeAppInstallAdView.setCallToActionView(button);
            nativeAppInstallAdView.setNativeAd(com_ushareit_listenit_but);
            viewGroup.addView(relativeLayout);
            return;
        }
        relativeLayout = (RelativeLayout) from.inflate(C0349R.layout.ad_admob_content_play_page, viewGroup, false);
        NativeContentAdView nativeContentAdView = (NativeContentAdView) relativeLayout.findViewById(C0349R.id.native_ad);
        View findViewById2 = relativeLayout.findViewById(C0349R.id.close_ad);
        ImageView imageView3 = (ImageView) relativeLayout.findViewById(C0349R.id.content_img);
        ImageView imageView4 = (ImageView) relativeLayout.findViewById(C0349R.id.icon);
        TextView textView3 = (TextView) relativeLayout.findViewById(C0349R.id.title);
        TextView textView4 = (TextView) relativeLayout.findViewById(C0349R.id.content);
        Button button2 = (Button) relativeLayout.findViewById(C0349R.id.go);
        buv com_ushareit_listenit_buv = (buv) com_ushareit_listenit_esi.m17769c();
        List c2 = com_ushareit_listenit_buv.mo1798c();
        if (!(c2 == null || c2.get(0) == null || ((bup) c2.get(0)).mo1761a() == null)) {
            imageView3.setImageDrawable(((bup) c2.get(0)).mo1761a());
        }
        int i2 = 0;
        bup e2 = com_ushareit_listenit_buv.mo1800e();
        if (e2 == null || e2.mo1761a() == null) {
            imageView4.setVisibility(8);
        } else {
            i2 = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
            imageView4.setVisibility(0);
            imageView4.setImageDrawable(e2.mo1761a());
        }
        textView3.setText(com_ushareit_listenit_buv.mo1797b());
        textView4.setText(m19162a(com_ushareit_listenit_buv.mo1799d(), i2));
        button2.setText(com_ushareit_listenit_buv.mo1801f());
        findViewById2.setOnClickListener(new fgq(this, viewGroup, com_ushareit_listenit_esi));
        nativeContentAdView.setImageView(imageView3);
        nativeContentAdView.setLogoView(imageView4);
        nativeContentAdView.setHeadlineView(textView3);
        nativeContentAdView.setBodyView(textView4);
        nativeContentAdView.setCallToActionView(button2);
        nativeContentAdView.setNativeAd(com_ushareit_listenit_buv);
        viewGroup.addView(relativeLayout);
    }

    public void mo2377c(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        ImageView imageView;
        bup e;
        LayoutParams layoutParams;
        if (com_ushareit_listenit_esi.m17769c() instanceof but) {
            NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) from.inflate(C0349R.layout.ad_admob_appinstall_allsonglist_page, viewGroup, false);
            but com_ushareit_listenit_but = (but) com_ushareit_listenit_esi.m17769c();
            imageView = (ImageView) nativeAppInstallAdView.findViewById(C0349R.id.native_ad_icon);
            nativeAppInstallAdView.setIconView(imageView);
            e = com_ushareit_listenit_but.mo1781e();
            if (e != null) {
                imageView.setImageDrawable(e.mo1761a());
                nativeAppInstallAdView.getIconView().setVisibility(0);
            } else {
                layoutParams = (LayoutParams) imageView.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.leftMargin = 0;
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                }
            }
            nativeAppInstallAdView.setHeadlineView(nativeAppInstallAdView.findViewById(C0349R.id.native_ad_title));
            ((TextView) nativeAppInstallAdView.getHeadlineView()).setText(com_ushareit_listenit_but.mo1778b());
            if (com_ushareit_listenit_but.mo1780d() != null) {
                nativeAppInstallAdView.setBodyView(nativeAppInstallAdView.findViewById(C0349R.id.native_ad_body));
                ((TextView) nativeAppInstallAdView.getBodyView()).setText(com_ushareit_listenit_but.mo1780d());
            }
            nativeAppInstallAdView.setCallToActionView(nativeAppInstallAdView);
            nativeAppInstallAdView.findViewById(C0349R.id.close_ad).setOnClickListener(new fgr(this, nativeAppInstallAdView, com_ushareit_listenit_esi));
            nativeAppInstallAdView.setNativeAd(com_ushareit_listenit_but);
            viewGroup.addView(nativeAppInstallAdView);
            return;
        }
        NativeContentAdView nativeContentAdView = (NativeContentAdView) from.inflate(C0349R.layout.ad_admob_content_allsonglist_page, viewGroup, false);
        buv com_ushareit_listenit_buv = (buv) com_ushareit_listenit_esi.m17769c();
        imageView = (ImageView) nativeContentAdView.findViewById(C0349R.id.native_ad_icon);
        nativeContentAdView.setLogoView(imageView);
        e = com_ushareit_listenit_buv.mo1800e();
        if (e != null) {
            imageView.setImageDrawable(e.mo1761a());
            nativeContentAdView.getLogoView().setVisibility(0);
        } else {
            layoutParams = (LayoutParams) imageView.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.leftMargin = 0;
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
            }
        }
        nativeContentAdView.setHeadlineView(nativeContentAdView.findViewById(C0349R.id.native_ad_title));
        ((TextView) nativeContentAdView.getHeadlineView()).setText(com_ushareit_listenit_buv.mo1797b());
        if (com_ushareit_listenit_buv.mo1799d() != null) {
            nativeContentAdView.setBodyView(nativeContentAdView.findViewById(C0349R.id.native_ad_body));
            ((TextView) nativeContentAdView.getBodyView()).setText(com_ushareit_listenit_buv.mo1799d());
        }
        nativeContentAdView.setCallToActionView(nativeContentAdView);
        nativeContentAdView.findViewById(C0349R.id.close_ad).setOnClickListener(new fgs(this, nativeContentAdView, com_ushareit_listenit_esi));
        nativeContentAdView.setNativeAd(com_ushareit_listenit_buv);
        viewGroup.addView(nativeContentAdView);
    }

    public void mo2375a(ViewGroup viewGroup, esi com_ushareit_listenit_esi, fev com_ushareit_listenit_fev) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        ImageView imageView;
        bup e;
        LayoutParams layoutParams;
        if (com_ushareit_listenit_esi.m17769c() instanceof but) {
            NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) from.inflate(C0349R.layout.ad_admob_appinstall_home_page, viewGroup, false);
            but com_ushareit_listenit_but = (but) com_ushareit_listenit_esi.m17769c();
            imageView = (ImageView) nativeAppInstallAdView.findViewById(C0349R.id.native_ad_icon);
            nativeAppInstallAdView.setIconView(imageView);
            e = com_ushareit_listenit_but.mo1781e();
            if (e != null) {
                imageView.setImageDrawable(e.mo1761a());
                nativeAppInstallAdView.getIconView().setVisibility(0);
            } else {
                layoutParams = (LayoutParams) imageView.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.leftMargin = 0;
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                }
            }
            nativeAppInstallAdView.setHeadlineView(nativeAppInstallAdView.findViewById(C0349R.id.native_ad_title));
            ((TextView) nativeAppInstallAdView.getHeadlineView()).setText(com_ushareit_listenit_but.mo1778b());
            if (com_ushareit_listenit_but.mo1780d() != null) {
                nativeAppInstallAdView.setBodyView(nativeAppInstallAdView.findViewById(C0349R.id.native_ad_body));
                ((TextView) nativeAppInstallAdView.getBodyView()).setText(com_ushareit_listenit_but.mo1780d());
            }
            nativeAppInstallAdView.setCallToActionView(nativeAppInstallAdView);
            nativeAppInstallAdView.findViewById(C0349R.id.close_ad).setOnClickListener(new fgt(this, com_ushareit_listenit_fev, com_ushareit_listenit_esi));
            nativeAppInstallAdView.setNativeAd(com_ushareit_listenit_but);
            viewGroup.addView(nativeAppInstallAdView);
            return;
        }
        NativeContentAdView nativeContentAdView = (NativeContentAdView) from.inflate(C0349R.layout.ad_admob_content_home_page, viewGroup, false);
        buv com_ushareit_listenit_buv = (buv) com_ushareit_listenit_esi.m17769c();
        imageView = (ImageView) nativeContentAdView.findViewById(C0349R.id.native_ad_icon);
        nativeContentAdView.setLogoView(imageView);
        e = com_ushareit_listenit_buv.mo1800e();
        if (e != null) {
            imageView.setImageDrawable(e.mo1761a());
            nativeContentAdView.getLogoView().setVisibility(0);
        } else {
            layoutParams = (LayoutParams) imageView.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.leftMargin = 0;
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
            }
        }
        nativeContentAdView.setHeadlineView(nativeContentAdView.findViewById(C0349R.id.native_ad_title));
        ((TextView) nativeContentAdView.getHeadlineView()).setText(com_ushareit_listenit_buv.mo1797b());
        if (com_ushareit_listenit_buv.mo1799d() != null) {
            nativeContentAdView.setBodyView(nativeContentAdView.findViewById(C0349R.id.native_ad_body));
            ((TextView) nativeContentAdView.getBodyView()).setText(com_ushareit_listenit_buv.mo1799d());
        }
        nativeContentAdView.setCallToActionView(nativeContentAdView);
        nativeContentAdView.findViewById(C0349R.id.close_ad).setOnClickListener(new fgu(this, com_ushareit_listenit_fev, com_ushareit_listenit_esi));
        nativeContentAdView.setNativeAd(com_ushareit_listenit_buv);
        viewGroup.addView(nativeContentAdView);
    }

    public void mo2378d(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (com_ushareit_listenit_esi.m17769c() instanceof but) {
            RelativeLayout relativeLayout = (RelativeLayout) from.inflate(C0349R.layout.ad_admob_appinstall_play_page, viewGroup, false);
            MediaView mediaView = (MediaView) View.inflate(viewGroup.getContext(), C0349R.layout.ad_admob_navite_media, null);
            NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) relativeLayout.findViewById(C0349R.id.native_ad);
            FrameLayout frameLayout = (FrameLayout) relativeLayout.findViewById(C0349R.id.content_view);
            View findViewById = relativeLayout.findViewById(C0349R.id.close_ad);
            ImageView imageView = (ImageView) relativeLayout.findViewById(C0349R.id.content_img);
            ImageView imageView2 = (ImageView) relativeLayout.findViewById(C0349R.id.icon);
            TextView textView = (TextView) relativeLayout.findViewById(C0349R.id.title);
            TextView textView2 = (TextView) relativeLayout.findViewById(C0349R.id.content);
            Button button = (Button) relativeLayout.findViewById(C0349R.id.go);
            but com_ushareit_listenit_but = (but) com_ushareit_listenit_esi.m17769c();
            if (com_ushareit_listenit_but.mo1786j().m9881b()) {
                frameLayout.addView(mediaView);
                nativeAppInstallAdView.setMediaView(mediaView);
                imageView.setVisibility(8);
            } else {
                List c = com_ushareit_listenit_but.mo1779c();
                if (!(c == null || c.get(0) == null || ((bup) c.get(0)).mo1761a() == null)) {
                    imageView.setImageDrawable(((bup) c.get(0)).mo1761a());
                    nativeAppInstallAdView.setImageView(imageView);
                }
            }
            bup e = com_ushareit_listenit_but.mo1781e();
            int i = 0;
            if (e == null || e.mo1761a() == null) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setImageDrawable(e.mo1761a());
                i = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
                imageView2.setVisibility(0);
            }
            textView.setText(com_ushareit_listenit_but.mo1778b());
            textView2.setText(m19162a(com_ushareit_listenit_but.mo1780d(), i));
            button.setText(com_ushareit_listenit_but.mo1782f());
            findViewById.setOnClickListener(new fgv(this, viewGroup, com_ushareit_listenit_esi));
            nativeAppInstallAdView.setImageView(imageView);
            nativeAppInstallAdView.setIconView(imageView2);
            nativeAppInstallAdView.setHeadlineView(textView);
            nativeAppInstallAdView.setBodyView(textView2);
            nativeAppInstallAdView.setCallToActionView(button);
            nativeAppInstallAdView.setNativeAd(com_ushareit_listenit_but);
            viewGroup.addView(relativeLayout);
            return;
        }
        relativeLayout = (RelativeLayout) from.inflate(C0349R.layout.ad_admob_content_play_page, viewGroup, false);
        NativeContentAdView nativeContentAdView = (NativeContentAdView) relativeLayout.findViewById(C0349R.id.native_ad);
        View findViewById2 = relativeLayout.findViewById(C0349R.id.close_ad);
        ImageView imageView3 = (ImageView) relativeLayout.findViewById(C0349R.id.content_img);
        ImageView imageView4 = (ImageView) relativeLayout.findViewById(C0349R.id.icon);
        TextView textView3 = (TextView) relativeLayout.findViewById(C0349R.id.title);
        TextView textView4 = (TextView) relativeLayout.findViewById(C0349R.id.content);
        Button button2 = (Button) relativeLayout.findViewById(C0349R.id.go);
        buv com_ushareit_listenit_buv = (buv) com_ushareit_listenit_esi.m17769c();
        List c2 = com_ushareit_listenit_buv.mo1798c();
        if (!(c2 == null || c2.get(0) == null || ((bup) c2.get(0)).mo1761a() == null)) {
            imageView3.setImageDrawable(((bup) c2.get(0)).mo1761a());
        }
        int i2 = 0;
        bup e2 = com_ushareit_listenit_buv.mo1800e();
        if (e2 == null || e2.mo1761a() == null) {
            imageView4.setVisibility(8);
        } else {
            i2 = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
            imageView4.setVisibility(0);
            imageView4.setImageDrawable(e2.mo1761a());
        }
        textView3.setText(com_ushareit_listenit_buv.mo1797b());
        textView4.setText(m19162a(com_ushareit_listenit_buv.mo1799d(), i2));
        button2.setText(com_ushareit_listenit_buv.mo1801f());
        findViewById2.setOnClickListener(new fgw(this, viewGroup, com_ushareit_listenit_esi));
        nativeContentAdView.setImageView(imageView3);
        nativeContentAdView.setLogoView(imageView4);
        nativeContentAdView.setHeadlineView(textView3);
        nativeContentAdView.setBodyView(textView4);
        nativeContentAdView.setCallToActionView(button2);
        nativeContentAdView.setNativeAd(com_ushareit_listenit_buv);
        viewGroup.addView(relativeLayout);
    }

    public void mo2379e(ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (com_ushareit_listenit_esi.m17769c() instanceof but) {
            RelativeLayout relativeLayout = (RelativeLayout) from.inflate(C0349R.layout.ad_admob_appinstall_charge_screen, viewGroup, false);
            MediaView mediaView = (MediaView) View.inflate(viewGroup.getContext(), C0349R.layout.ad_admob_navite_media, null);
            NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) relativeLayout.findViewById(C0349R.id.native_ad);
            FrameLayout frameLayout = (FrameLayout) relativeLayout.findViewById(C0349R.id.content_view);
            View findViewById = relativeLayout.findViewById(C0349R.id.close_ad);
            ImageView imageView = (ImageView) relativeLayout.findViewById(C0349R.id.content_img);
            ImageView imageView2 = (ImageView) relativeLayout.findViewById(C0349R.id.icon);
            TextView textView = (TextView) relativeLayout.findViewById(C0349R.id.title);
            TextView textView2 = (TextView) relativeLayout.findViewById(C0349R.id.content);
            Button button = (Button) relativeLayout.findViewById(C0349R.id.go);
            but com_ushareit_listenit_but = (but) com_ushareit_listenit_esi.m17769c();
            if (com_ushareit_listenit_but.mo1786j().m9881b()) {
                frameLayout.addView(mediaView);
                nativeAppInstallAdView.setMediaView(mediaView);
                imageView.setVisibility(8);
            } else {
                List c = com_ushareit_listenit_but.mo1779c();
                if (!(c == null || c.get(0) == null || ((bup) c.get(0)).mo1761a() == null)) {
                    imageView.setImageDrawable(((bup) c.get(0)).mo1761a());
                    nativeAppInstallAdView.setImageView(imageView);
                }
            }
            bup e = com_ushareit_listenit_but.mo1781e();
            int i = 0;
            if (e == null || e.mo1761a() == null) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setImageDrawable(e.mo1761a());
                i = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
                imageView2.setVisibility(0);
            }
            textView.setText(com_ushareit_listenit_but.mo1778b());
            textView2.setText(m19162a(com_ushareit_listenit_but.mo1780d(), i));
            button.setText(com_ushareit_listenit_but.mo1782f());
            findViewById.setOnClickListener(new fgn(this, viewGroup, com_ushareit_listenit_esi));
            nativeAppInstallAdView.setImageView(imageView);
            nativeAppInstallAdView.setIconView(imageView2);
            nativeAppInstallAdView.setHeadlineView(textView);
            nativeAppInstallAdView.setBodyView(textView2);
            nativeAppInstallAdView.setCallToActionView(button);
            nativeAppInstallAdView.setNativeAd(com_ushareit_listenit_but);
            viewGroup.addView(relativeLayout);
            return;
        }
        relativeLayout = (RelativeLayout) from.inflate(C0349R.layout.ad_admob_content_charge_screen, viewGroup, false);
        NativeContentAdView nativeContentAdView = (NativeContentAdView) relativeLayout.findViewById(C0349R.id.native_ad);
        View findViewById2 = relativeLayout.findViewById(C0349R.id.close_ad);
        ImageView imageView3 = (ImageView) relativeLayout.findViewById(C0349R.id.content_img);
        ImageView imageView4 = (ImageView) relativeLayout.findViewById(C0349R.id.icon);
        TextView textView3 = (TextView) relativeLayout.findViewById(C0349R.id.title);
        TextView textView4 = (TextView) relativeLayout.findViewById(C0349R.id.content);
        Button button2 = (Button) relativeLayout.findViewById(C0349R.id.go);
        buv com_ushareit_listenit_buv = (buv) com_ushareit_listenit_esi.m17769c();
        List c2 = com_ushareit_listenit_buv.mo1798c();
        if (!(c2 == null || c2.get(0) == null || ((bup) c2.get(0)).mo1761a() == null)) {
            imageView3.setImageDrawable(((bup) c2.get(0)).mo1761a());
        }
        int i2 = 0;
        bup e2 = com_ushareit_listenit_buv.mo1800e();
        if (e2 == null || e2.mo1761a() == null) {
            imageView4.setVisibility(8);
        } else {
            i2 = (int) viewGroup.getContext().getResources().getDimension(C0349R.dimen.common_dimens_54dp);
            imageView4.setVisibility(0);
            imageView4.setImageDrawable(e2.mo1761a());
        }
        textView3.setText(com_ushareit_listenit_buv.mo1797b());
        textView4.setText(m19162a(com_ushareit_listenit_buv.mo1799d(), i2));
        button2.setText(com_ushareit_listenit_buv.mo1801f());
        findViewById2.setOnClickListener(new fgo(this, viewGroup, com_ushareit_listenit_esi));
        nativeContentAdView.setImageView(imageView3);
        nativeContentAdView.setLogoView(imageView4);
        nativeContentAdView.setHeadlineView(textView3);
        nativeContentAdView.setBodyView(textView4);
        nativeContentAdView.setCallToActionView(button2);
        nativeContentAdView.setNativeAd(com_ushareit_listenit_buv);
        viewGroup.addView(relativeLayout);
    }
}
