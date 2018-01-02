package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

public final class bol {
    public static final bol f7226a = new bol(-1, CtaButton.BACKGROUND_COLOR, 0, 0, -1, null);
    public final int f7227b;
    public final int f7228c;
    public final int f7229d;
    public final int f7230e;
    public final int f7231f;
    public final Typeface f7232g;

    @TargetApi(19)
    public static bol m9240a(CaptionStyle captionStyle) {
        if (btc.f7662a >= 21) {
            return m9242c(captionStyle);
        }
        return m9241b(captionStyle);
    }

    public bol(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.f7227b = i;
        this.f7228c = i2;
        this.f7229d = i3;
        this.f7230e = i4;
        this.f7231f = i5;
        this.f7232g = typeface;
    }

    @TargetApi(19)
    private static bol m9241b(CaptionStyle captionStyle) {
        return new bol(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    private static bol m9242c(CaptionStyle captionStyle) {
        return new bol(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f7226a.f7227b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f7226a.f7228c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f7226a.f7229d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f7226a.f7230e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f7226a.f7231f, captionStyle.getTypeface());
    }
}
