package com.ushareit.listenit.popupview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fiq;
import com.ushareit.listenit.gkf;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.gpk;
import com.ushareit.listenit.gpl;
import com.ushareit.listenit.gpm;
import com.ushareit.listenit.gpn;
import com.ushareit.listenit.gpo;
import com.ushareit.listenit.gpp;
import com.ushareit.listenit.gpq;
import com.ushareit.listenit.gpr;
import com.ushareit.listenit.gps;
import com.ushareit.listenit.gpt;
import com.ushareit.listenit.gpu;
import com.ushareit.listenit.gpv;
import com.ushareit.listenit.gpw;
import com.ushareit.listenit.gpx;
import com.ushareit.listenit.gpy;
import com.ushareit.listenit.gpz;
import com.ushareit.listenit.gqa;
import com.ushareit.listenit.gqb;

public class MenuPopupView extends BasePopupView {
    private TextView f16206a;
    private LinearLayout f16207b;
    private gla f16208c;
    private String f16209d;
    private gkf f16210e;
    private int f16211f;
    private Runnable f16212g = new gpk(this);
    private OnClickListener f16213h = new gpu(this);
    private OnClickListener f16214i = new gpv(this);
    private OnClickListener f16215j = new gpw(this);
    private OnClickListener f16216k = new gpx(this);
    private OnClickListener f16217l = new gpy(this);
    private OnClickListener f16218m = new gpz(this);
    private OnClickListener f16219n = new gqa(this);
    private OnClickListener f16220o = new gqb(this);
    private OnClickListener f16221p = new gpl(this);
    private OnClickListener f16222q = new gpm(this);
    private OnClickListener f16223r = new gpn(this);
    private OnClickListener f16224s = new gpo(this);
    private OnClickListener f16225t = new gpp(this);
    private OnClickListener f16226u = new gpq(this);
    private OnClickListener f16227v = new gpr(this);
    private OnClickListener f16228w = new gps(this);
    private OnClickListener f16229x = new gpt(this);

    public MenuPopupView(Context context, gkf com_ushareit_listenit_gkf, gla com_ushareit_listenit_gla) {
        super(context);
        this.f16210e = com_ushareit_listenit_gkf;
        this.f16210e.m20821a(this);
        this.f16211f = this.f16210e.m20846r();
        this.f16208c = com_ushareit_listenit_gla;
        fiq.m19371a(context, this.f16211f, com_ushareit_listenit_gla);
        m25600a(context, this);
    }

    public void m25600a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_menu, viewGroup);
        this.f16206a = (TextView) inflate.findViewById(C0349R.id.title);
        this.f16207b = (LinearLayout) inflate.findViewById(C0349R.id.menus);
        this.f16207b.post(this.f16212g);
    }

    public int getGravity() {
        return 80;
    }

    public void setTitle(String str) {
        this.f16206a.setText(str);
    }

    public String getTitle() {
        return this.f16206a.getText().toString();
    }

    public void setParentName(String str) {
        this.f16209d = str;
    }

    public String getParentName() {
        return this.f16209d;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public gla getMediaItem() {
        return this.f16208c;
    }

    public void setShowPlay() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_play, C0349R.string.menu_play, this.f16213h), -1, -2);
    }

    public void setShowPlayNext() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_play_next, C0349R.string.menu_play_next, this.f16214i), -1, -2);
    }

    public void setShowAddToPlaylist() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_add_to_playlist, C0349R.string.menu_add_to_playlist, this.f16215j), -1, -2);
    }

    public void setShowChangeAlbum() {
        this.f16207b.addView(m25596a(C0349R.drawable.change_album_art, C0349R.string.menu_change_album_art, this.f16216k), -1, -2);
    }

    public void setShowDelete() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_delete, C0349R.string.menu_delete, this.f16217l), -1, -2);
    }

    public void setShowRename() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_rename, C0349R.string.menu_rename, this.f16218m), -1, -2);
    }

    public void setShowID3TagEdit() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_song_details, C0349R.string.popup_id3_tag_edit_title, this.f16219n), -1, -2);
    }

    public void setShowShare() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_share, C0349R.string.common_operate_share, this.f16220o), -1, -2);
    }

    public void setShowHide() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_hide, C0349R.string.menu_hide, this.f16221p), -1, -2);
    }

    public void setShowDownload() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_download, C0349R.string.menu_download, this.f16222q), -1, -2);
    }

    public void setShowDisappear() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_delete, C0349R.string.menu_disappear, this.f16223r), -1, -2);
    }

    public void setShowSetAsRingtone() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_set_ringtone, C0349R.string.menu_set_as_ringtone, this.f16224s), -1, -2);
    }

    public void setShowSetAsNotification() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_set_notification, C0349R.string.menu_set_as_notification, this.f16225t), -1, -2);
    }

    public void setShowSetAsAlarm() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_set_alarm, C0349R.string.menu_set_as_alarm, this.f16226u), -1, -2);
    }

    public void setShowEditClip() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_set_ringtone, C0349R.string.menu_edit_clip, this.f16227v), -1, -2);
    }

    public void setShowEditLyric() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_edit_lyric, C0349R.string.menu_edit_lyric, this.f16228w), -1, -2);
    }

    public void setShowAddToFavorite() {
        this.f16207b.addView(m25596a(C0349R.drawable.menu_add_to_favorite, C0349R.string.menu_add_to_favorite, this.f16229x), -1, -2);
    }

    private View m25596a(int i, int i2, OnClickListener onClickListener) {
        View inflate = View.inflate(getContext(), C0349R.layout.popup_view_menu_item, null);
        TextView textView = (TextView) inflate.findViewById(C0349R.id.desc);
        ((ImageView) inflate.findViewById(C0349R.id.icon)).setImageResource(i);
        textView.setText(getResources().getString(i2));
        inflate.setOnClickListener(onClickListener);
        return inflate;
    }
}
