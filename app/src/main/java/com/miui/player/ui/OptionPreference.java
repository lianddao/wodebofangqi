package com.miui.player.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.miui.player.C0329R;

public class OptionPreference extends Preference {
    private static final String TAG = "OptionPreference";
    private boolean mClickable;
    private Context mContext;
    private String mLabel;

    public OptionPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs, C0329R.styleable.OptionAttributes);
        this.mLabel = a.getString(0);
        this.mClickable = a.getBoolean(1, false);
        a.recycle();
        setLayoutResource(C0329R.layout.option_preference);
    }

    public OptionPreference(Context context) {
        this(context, null);
    }

    protected void onBindView(View view) {
        TextView labelView = (TextView) view.findViewById(C0329R.id.label);
        if (labelView != null) {
            labelView.setText(this.mLabel);
            if (!this.mClickable) {
                labelView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }
        }
        super.onBindView(view);
    }

    public void setMiuiLabel(String label) {
        if (!TextUtils.equals(this.mLabel, label)) {
            this.mLabel = label;
            notifyChanged();
        }
    }

    public void setMiuiLabel(int resId) {
        setMiuiLabel(this.mContext.getString(resId));
    }

    public void setMiuiClickable(boolean clickable) {
        if (this.mClickable != clickable) {
            this.mClickable = clickable;
            notifyChanged();
        }
    }
}
