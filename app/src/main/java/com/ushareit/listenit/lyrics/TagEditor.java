package com.ushareit.listenit.lyrics;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.gid;
import com.ushareit.listenit.gie;
import com.ushareit.listenit.gif;
import com.ushareit.listenit.gig;
import com.ushareit.listenit.gih;
import java.util.ArrayList;
import java.util.List;

public class TagEditor extends ScrollView {
    int f15815a = 0;
    private EditText f15816b;
    private TextView f15817c;
    private LinearLayout f15818d;
    private String f15819e = "";
    private gig f15820f;
    private List<String> f15821g = new ArrayList();
    private int f15822h;
    private int f15823i;
    private int f15824j;
    private int f15825k;
    private TextWatcher f15826l = new gie(this);
    private InputFilter f15827m = new gif(this);

    public TagEditor(Context context) {
        super(context);
        m24689a(context);
    }

    public TagEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24689a(context);
    }

    private void m24689a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.tag_editor, this);
        this.f15816b = (EditText) inflate.findViewById(C0349R.id.editor);
        this.f15817c = (TextView) inflate.findViewById(C0349R.id.line_count);
        this.f15818d = (LinearLayout) inflate.findViewById(C0349R.id.tags);
        this.f15816b.addTextChangedListener(this.f15826l);
        this.f15816b.setFilters(new InputFilter[]{this.f15827m});
        this.f15822h = getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_5dp);
        this.f15823i = getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_2dp);
        this.f15824j = getResources().getColor(C0349R.color.lyric_editor_start_time_color);
        this.f15825k = getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_13sp);
        m24696c(0);
    }

    protected void m24700a(List<gih> list) {
        if (list.size() != 0) {
            m24703d();
            this.f15816b.post(new gid(this, list));
        }
    }

    protected void setPasterFilter(gig com_ushareit_listenit_gig) {
        this.f15820f = com_ushareit_listenit_gig;
    }

    protected void setCurrLineTag(String str) {
        int b = m24692b(this.f15816b.getSelectionStart(), true);
        exw.m18443a("TagEditor", "setCurrLineTag: line=" + b + ", cursorPos=" + this.f15816b.getSelectionStart());
        setLineTag(b, str);
    }

    private void setLineTag(int i, String str) {
        TextView textView = (TextView) this.f15818d.getChildAt(i);
        if (textView != null) {
            textView.setText(str);
            this.f15821g.set(i, str);
        }
    }

    protected void m24703d() {
        this.f15816b.getText().delete(0, this.f15816b.getText().length());
    }

    protected void m24702b(String str) {
        this.f15816b.getText().toString();
        int selectionStart = this.f15816b.getSelectionStart();
        int selectionEnd = this.f15816b.getSelectionEnd();
        exw.m18443a("TagEditor", "paste: pos=" + selectionStart + ", end=" + this.f15816b.getSelectionEnd() + ", content=" + str);
        if (selectionStart == selectionEnd) {
            this.f15816b.getText().insert(selectionStart, str);
        } else {
            this.f15816b.getText().replace(selectionStart, selectionEnd, str);
        }
    }

    protected List<gih> getTagContents() {
        String[] split = this.f15816b.getText().toString().split("\n");
        exw.m18443a("TagEditor", "tagSize=" + this.f15821g.size() + ", contentSize=" + split.length);
        int length = split.length;
        List<gih> arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(new gih(this, (String) this.f15821g.get(i), split[i]));
        }
        return arrayList;
    }

    protected int getCurrLineSumHeight() {
        return mo2886a(this.f15816b.getText().toString().substring(0, this.f15816b.getSelectionStart())) * this.f15816b.getLineHeight();
    }

    protected void m24704e() {
        String obj = this.f15816b.getText().toString();
        int length = obj.length();
        int selectionStart = this.f15816b.getSelectionStart();
        while (selectionStart < length && obj.charAt(selectionStart) != '\n') {
            selectionStart++;
        }
        if (selectionStart < length) {
            this.f15816b.setSelection(selectionStart + 1);
        }
    }

    public EditText getEditText() {
        return this.f15816b;
    }

    private void m24696c(int i) {
        if (this.f15821g.size() == this.f15818d.getChildCount()) {
            this.f15821g.add(i, "00:00.00");
        }
        exw.m18443a("TagEditor", "addNewLine=" + i + ", tag=" + ((String) this.f15821g.get(i)) + ", tagSize=" + this.f15821g.size());
        View a = m24699a(1);
        a.setText((CharSequence) this.f15821g.get(i));
        this.f15818d.addView(a, i);
    }

    public TextView m24699a(int i) {
        TextView textView = new TextView(getContext());
        textView.setTag(Integer.valueOf(1));
        textView.setLayoutParams(new LayoutParams(-2, this.f15816b.getLineHeight() * i));
        this.f15815a = (this.f15815a + 1) % 3;
        textView.setTextColor(this.f15824j);
        textView.setTextSize(0, (float) this.f15825k);
        textView.setPadding(this.f15822h, this.f15823i, 0, 0);
        return textView;
    }

    private void m24688a(int i, boolean z) {
        if (i >= 0) {
            String d = m24698d(i);
            int a = mo2886a(d);
            Integer num = (Integer) this.f15818d.getChildAt(i).getTag();
            if (num != null && num.intValue() != a) {
                exw.m18443a("TagEditor", "checkAndRelayoutTagView: lastLineCount=" + num + ", currLineCount=" + a + ", sentencePos=" + i + ", text=" + d + ", isAdd=" + z);
                m24687a(i, a);
            }
        }
    }

    private String m24698d(int i) {
        String[] split = this.f15816b.getText().toString().split("\n");
        return i < split.length ? split[i] : "";
    }

    private void m24687a(int i, int i2) {
        View childAt = this.f15818d.getChildAt(i);
        Integer num = (Integer) childAt.getTag();
        if (num != null && num.intValue() != i2) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            marginLayoutParams.height = this.f15816b.getLineHeight() * i2;
            childAt.setLayoutParams(marginLayoutParams);
            childAt.setTag(Integer.valueOf(i2));
        }
    }

    private int m24692b(int i, boolean z) {
        int i2 = 0;
        String obj = z ? this.f15816b.getText().toString() : this.f15819e;
        if (TextUtils.isEmpty(obj)) {
            return 0;
        }
        if (i > obj.length()) {
            i = obj.length();
        } else if (i < 0) {
            i = 0;
        }
        String substring = obj.substring(0, i);
        int length = substring.length();
        int i3 = 0;
        while (i2 < length) {
            if (substring.charAt(i2) == '\n') {
                i3++;
            }
            i2++;
        }
        return i3;
    }

    private int mo2886a(String str) {
        this.f15817c.setText(str);
        return this.f15817c.getLineCount();
    }

    public void m24701b(int i) {
        if (i < this.f15818d.getChildCount()) {
            this.f15818d.removeView(this.f15818d.getChildAt(i));
            this.f15821g.remove(i);
            exw.m18443a("TagEditor", "removeTagView, position=" + i);
        }
    }

    private CharSequence m24683a(int i, List<gih> list) {
        int i2;
        int b = m24692b(i, true);
        Object d = m24698d(b);
        CharSequence stringBuffer = new StringBuffer();
        boolean isEmpty = TextUtils.isEmpty(d);
        if (isEmpty) {
            i2 = b;
        } else {
            i2 = b + 1;
            stringBuffer.append("\n");
            exw.m18443a("TagEditor", "parseTagContents, not empty, lineIndex=" + i2);
        }
        int size = list.size();
        int i3 = 0;
        int i4 = i2;
        while (i3 < size - 1) {
            gih com_ushareit_listenit_gih = (gih) list.get(i3);
            int i5 = i4 + 1;
            this.f15821g.add(i4, com_ushareit_listenit_gih.f14161a);
            stringBuffer.append(com_ushareit_listenit_gih.f14162b).append("\n");
            i3++;
            i4 = i5;
        }
        if (size > 0) {
            com_ushareit_listenit_gih = (gih) list.get(size - 1);
            this.f15821g.add(i4, com_ushareit_listenit_gih.f14161a);
            stringBuffer.append(com_ushareit_listenit_gih.f14162b);
        }
        if (isEmpty) {
            setLineTag(b, (String) this.f15821g.get(b));
        }
        exw.m18443a("TagEditor", "parseTagContents: currLine=" + d + ", startIndex=" + m24692b(i, true) + ", lastIndex=" + i4);
        return stringBuffer;
    }
}
