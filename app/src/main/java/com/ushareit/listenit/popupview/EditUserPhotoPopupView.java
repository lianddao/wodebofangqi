package com.ushareit.listenit.popupview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.goy;
import com.ushareit.listenit.goz;
import com.ushareit.listenit.gpa;
import com.ushareit.listenit.gpb;

public class EditUserPhotoPopupView extends BasePopupView {
    private gpb f16187a;
    private OnClickListener f16188b = new goy(this);
    private OnClickListener f16189c = new goz(this);
    private OnClickListener f16190d = new gpa(this);

    public EditUserPhotoPopupView(Context context, gpb com_ushareit_listenit_gpb) {
        super(context);
        this.f16187a = com_ushareit_listenit_gpb;
        m25581a(context, this);
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }

    public void m25581a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_edit_user_photo, viewGroup);
        View findViewById = inflate.findViewById(C0349R.id.user_camera);
        View findViewById2 = inflate.findViewById(C0349R.id.user_album);
        inflate.findViewById(C0349R.id.cancel).setOnClickListener(this.f16188b);
        findViewById.setOnClickListener(this.f16189c);
        findViewById2.setOnClickListener(this.f16190d);
    }

    public int getGravity() {
        return 17;
    }
}
