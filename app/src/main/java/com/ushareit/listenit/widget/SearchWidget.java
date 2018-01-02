package com.ushareit.listenit.widget;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.gkx;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gyw;
import com.ushareit.listenit.hdw;
import com.ushareit.listenit.hdx;
import com.ushareit.listenit.hdy;
import com.ushareit.listenit.hdz;
import java.util.ArrayList;
import java.util.List;

public class SearchWidget extends FrameLayout {
    private EditText f17364a;
    private View f17365b;
    private View f17366c;
    private View f17367d;
    private View f17368e;
    private hdz f17369f;
    private int f17370g;
    private String f17371h;
    private List<gla> f17372i = new ArrayList();
    private OnClickListener f17373j = new hdw(this);
    private OnClickListener f17374k = new hdx(this);
    private TextWatcher f17375l = new hdy(this);

    public SearchWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26989a(context);
    }

    public SearchWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26989a(context);
    }

    public SearchWidget(Context context) {
        super(context);
        m26989a(context);
    }

    private void m26989a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.search_widget, this);
        this.f17364a = (EditText) inflate.findViewById(C0349R.id.editor);
        this.f17365b = inflate.findViewById(C0349R.id.search);
        this.f17366c = inflate.findViewById(C0349R.id.delete);
        this.f17367d = inflate.findViewById(C0349R.id.editor_views);
        this.f17368e = inflate.findViewById(C0349R.id.underline);
        this.f17364a.addTextChangedListener(this.f17375l);
        this.f17366c.setOnClickListener(this.f17374k);
        this.f17365b.setOnClickListener(this.f17373j);
        m26999d();
    }

    public void m27002a(List<? extends gla> list, int i) {
        this.f17372i.clear();
        this.f17372i.addAll(list);
        this.f17370g = i;
    }

    public void setSearchListener(hdz com_ushareit_listenit_hdz) {
        this.f17369f = com_ushareit_listenit_hdz;
    }

    private void m26997c() {
        this.f17364a.requestFocus();
        this.f17367d.setVisibility(0);
        this.f17368e.setVisibility(0);
        this.f17365b.setVisibility(8);
        m27001a();
    }

    public void m27001a() {
        gyw.m23321a(getContext(), this.f17364a);
    }

    public void m27003b() {
        gyw.m23323b(getContext(), this.f17364a);
    }

    private void m26999d() {
        this.f17365b.setVisibility(0);
        this.f17367d.setVisibility(8);
        this.f17368e.setVisibility(8);
    }

    private void m26992a(String str) {
        if (!fbb.m18763c(str)) {
            List b;
            this.f17371h = str;
            switch (this.f17370g) {
                case 0:
                    b = m26994b(str);
                    break;
                case 14:
                    b = m26996c(str);
                    break;
                default:
                    b = m26998d(str);
                    break;
            }
            if (b != null && this.f17369f != null && this.f17371h.equals(str)) {
                this.f17369f.mo2501a(b);
            }
        } else if (this.f17369f != null) {
            this.f17369f.mo2501a(this.f17372i);
        }
    }

    private ArrayList<? extends gla> m26994b(String str) {
        ArrayList<? extends gla> arrayList = new ArrayList();
        for (gla com_ushareit_listenit_gla : this.f17372i) {
            if (!this.f17371h.equals(str)) {
                return null;
            }
            glg com_ushareit_listenit_glg = (glg) com_ushareit_listenit_gla;
            if (gyn.m23203a(com_ushareit_listenit_glg.f14338f, str) || gyn.m23203a(com_ushareit_listenit_glg.f14339g, str)) {
                arrayList.add(com_ushareit_listenit_glg);
            }
        }
        return arrayList;
    }

    private ArrayList<? extends gla> m26996c(String str) {
        ArrayList<? extends gla> arrayList = new ArrayList();
        for (gla com_ushareit_listenit_gla : this.f17372i) {
            if (!this.f17371h.equals(str)) {
                return null;
            }
            gkx com_ushareit_listenit_gkx = (gkx) com_ushareit_listenit_gla;
            if (gyn.m23203a(com_ushareit_listenit_gkx.f14255b, str) || gyn.m23203a(com_ushareit_listenit_gkx.f14260g, str)) {
                arrayList.add(com_ushareit_listenit_gkx);
            }
        }
        return arrayList;
    }

    private ArrayList<? extends gla> m26998d(String str) {
        ArrayList<? extends gla> arrayList = new ArrayList();
        for (gla com_ushareit_listenit_gla : this.f17372i) {
            if (!this.f17371h.equals(str)) {
                return null;
            }
            if (gyn.m23203a(com_ushareit_listenit_gla.mo2562c(), str)) {
                arrayList.add(com_ushareit_listenit_gla);
            }
        }
        return arrayList;
    }
}
