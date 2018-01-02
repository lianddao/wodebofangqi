package com.ushareit.listenit.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.ushareit.listenit.C0349R;

public class NearbyGuideMaskView extends View {
    private int f17285a = Color.parseColor("#bb000000");
    private Rect f17286b;
    private Paint f17287c = new Paint();
    private Paint f17288d;
    private Bitmap f17289e;
    private RectF f17290f;

    public NearbyGuideMaskView(Context context) {
        super(context);
        this.f17287c.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.f17287c.setColor(CtaButton.BACKGROUND_COLOR);
        this.f17288d = new Paint();
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.f17289e = BitmapFactory.decodeResource(getResources(), C0349R.drawable.nearby_guide_hand);
    }

    public void setHoleRect(Rect rect) {
        this.f17286b = rect;
        this.f17290f = new RectF();
        float width = (float) this.f17289e.getWidth();
        float height = (float) (this.f17286b.height() / 2);
        this.f17290f.left = ((float) (rect.right - this.f17289e.getWidth())) - width;
        this.f17290f.top = ((float) rect.bottom) - height;
        this.f17290f.right = ((float) rect.right) - width;
        this.f17290f.bottom = ((float) (rect.bottom + this.f17289e.getHeight())) - height;
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawColor(this.f17285a);
        canvas.drawRect(this.f17286b, this.f17287c);
        canvas.drawBitmap(this.f17289e, null, this.f17290f, this.f17288d);
    }
}
