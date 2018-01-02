package com.ushareit.listenit.widget.youtubevideoplayer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fij;
import com.ushareit.listenit.hfh;
import com.ushareit.listenit.hfs;
import com.ushareit.listenit.hft;
import java.util.HashSet;
import java.util.Iterator;

public class YouTubePlayerView extends FrameLayout {
    private final YouTubePlayer f17475a;
    private final hft f17476b;
    private final HashSet<hfs> f17477c;
    private boolean f17478d;
    private boolean f17479e;

    public YouTubePlayerView(Context context) {
        this(context, null);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17477c = new HashSet();
        this.f17479e = false;
        View inflate = View.inflate(context, C0349R.layout.youtube_player_view, this);
        this.f17475a = (YouTubePlayer) inflate.findViewById(C0349R.id.youtube_player);
        this.f17476b = new hft(this, inflate.findViewById(C0349R.id.controller_panel));
        this.f17477c.add(this.f17476b);
        this.f17475a.m27101b(this.f17476b);
    }

    protected void onMeasure(int i, int i2) {
        if (getLayoutParams().height == -2) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i) * 9) / 16, 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void m27102a() {
        if (!this.f17478d) {
            LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
            this.f17478d = true;
            Iterator it = this.f17477c.iterator();
            while (it.hasNext()) {
                ((hfs) it.next()).g_();
            }
        }
    }

    public void m27108b() {
        if (this.f17478d) {
            LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
            this.f17478d = false;
            Iterator it = this.f17477c.iterator();
            while (it.hasNext()) {
                ((hfs) it.next()).mo2592b();
            }
        }
    }

    public void m27109c() {
        if (this.f17478d) {
            m27108b();
        } else {
            m27102a();
        }
    }

    public boolean m27107a(hfs com_ushareit_listenit_hfs) {
        return this.f17477c.add(com_ushareit_listenit_hfs);
    }

    public void m27105a(Drawable drawable, String str, hfh com_ushareit_listenit_hfh) {
        this.f17476b.m23678a(drawable, str);
        this.f17475a.m27098a(com_ushareit_listenit_hfh);
        this.f17479e = true;
    }

    public void m27104a(Drawable drawable, String str) {
        this.f17476b.m23681d();
        this.f17476b.m23678a(drawable, str);
        this.f17479e = true;
    }

    public void m27106a(String str, float f) {
        if (this.f17479e) {
            this.f17475a.m27099a(str, f);
            this.f17476b.m23684e(str);
            fij.m19336g();
            return;
        }
        Log.e("YouTubePlayerView", "the player has not been initialized");
    }

    public void m27110d() {
        if (this.f17479e) {
            this.f17475a.destroy();
        } else {
            Log.e("YouTubePlayerView", "the player has not been initialized");
        }
    }

    public void m27103a(int i) {
        if (this.f17479e) {
            this.f17475a.m27097a(i);
        } else {
            Log.e("YouTubePlayerView", "the player has not been initialized");
        }
    }

    public void m27111e() {
        if (this.f17479e) {
            this.f17475a.m27096a();
        } else {
            Log.e("YouTubePlayerView", "the player has not been initialized");
        }
    }

    public void m27112f() {
        if (this.f17479e) {
            this.f17475a.m27100b();
        } else {
            Log.e("YouTubePlayerView", "the player has not been initialized");
        }
    }

    public void m27113g() {
        this.f17476b.m23686g();
    }
}
