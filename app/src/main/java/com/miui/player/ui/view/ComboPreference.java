package com.miui.player.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.ui.UIHelper;
import com.miui.player.util.PreferenceCache;
import miui.widget.SlidingButton;
import miui.widget.SlidingButton.OnCheckedChangedListener;

public class ComboPreference extends Preference implements OnSeekBarChangeListener, OnClickListener, OnCheckedChangedListener {
    private static final int CONVERTER_CONSTANT = 3;
    private static final int CONVERTER_DURATION = 2;
    private static final int CONVERTER_RAW = 0;
    private static final int CONVERTER_SIZE = 1;
    private static final int K_SIZE = 1024;
    private final ValueConverter mConverter;
    private View mCurrentParent;
    private CharSequence mCurrentPrefix;
    private TextView mCurrentView;
    private final CharSequence mMaxName;
    private final int mMaxValue;
    private final CharSequence mMinName;
    private final int mMinValue;
    private final String mProgressKey;
    private SeekBar mSeekBar;
    private View mSeekParent;
    private SlidingButton mSlidingButton;
    private View mSlidingButtonParent;
    private CharSequence mSummaryOff;
    private CharSequence mSummaryOn;
    private TextView mSummaryView;
    private final CharSequence mTitle;
    private final int mUnit;

    interface ValueConverter {
        CharSequence convert(Context context, int i);
    }

    static class ConstantConverter implements ValueConverter {
        private final CharSequence mValue;

        public ConstantConverter(CharSequence value) {
            this.mValue = value;
        }

        public CharSequence convert(Context context, int value) {
            return this.mValue;
        }
    }

    static class DurationConverter implements ValueConverter {
        DurationConverter() {
        }

        public CharSequence convert(Context context, int value) {
            return UIHelper.makeTimeString(context, (long) (value * 1000), C0329R.string.filter_by_duration_format);
        }
    }

    static class RawConverter implements ValueConverter {
        RawConverter() {
        }

        public CharSequence convert(Context context, int value) {
            return String.valueOf(value);
        }
    }

    static class SizeConverter implements ValueConverter {
        SizeConverter() {
        }

        public CharSequence convert(Context context, int value) {
            return String.valueOf((value + 512) / 1024) + "KB";
        }
    }

    public ComboPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ComboPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setLayoutResource(C0329R.layout.combo_preference);
        TypedArray a = context.obtainStyledAttributes(attrs, C0329R.styleable.ComboPreference, defStyle, 0);
        try {
            this.mProgressKey = a.getString(0);
            if (TextUtils.isEmpty(this.mProgressKey)) {
                throw new IllegalArgumentException(String.format("Bad progress key for preference %s", new Object[]{getKey()}));
            }
            this.mTitle = a.getText(1);
            this.mMinName = a.getText(2);
            this.mMaxName = a.getText(3);
            this.mMinValue = a.getInt(4, 0);
            this.mMaxValue = a.getInt(5, 0);
            if (this.mMinValue >= this.mMaxValue) {
                throw new IllegalArgumentException(String.format("Bad bound for preference %s, with minValue=%d and maxValue=%d", new Object[]{this.mTitle, Integer.valueOf(this.mMinValue), Integer.valueOf(this.mMaxValue)}));
            }
            this.mUnit = a.getInt(6, 1);
            if (this.mUnit <= 0) {
                throw new IllegalArgumentException(String.format("Bad bound for preference %s, with progressUnit=%d", new Object[]{this.mTitle, Integer.valueOf(this.mUnit)}));
            }
            this.mCurrentPrefix = a.getText(9);
            this.mConverter = createConverter(a.getInt(7, 0), a.getString(8));
            TypedArray b = context.obtainStyledAttributes(attrs, C0329R.styleable.PreferenceCommon, defStyle, 0);
            try {
                this.mSummaryOn = b.getText(0);
                this.mSummaryOff = b.getText(1);
            } finally {
                b.recycle();
            }
        } finally {
            a.recycle();
        }
    }

    protected View onCreateView(ViewGroup parent) {
        View view = super.onCreateView(parent);
        ((TextView) view.findViewById(C0329R.id.title)).setText(this.mTitle);
        ((TextView) view.findViewById(C0329R.id.min)).setText(this.mMinName);
        ((TextView) view.findViewById(C0329R.id.max)).setText(this.mMaxName);
        boolean checked = PreferenceCache.getPrefAsBoolean(getContext(), getKey());
        int current = PreferenceCache.getPrefAsInteger(getContext(), this.mProgressKey).intValue();
        this.mSlidingButtonParent = view.findViewById(C0329R.id.sliding_button_parent);
        this.mSlidingButtonParent.setOnClickListener(this);
        this.mSlidingButton = (SlidingButton) this.mSlidingButtonParent.findViewById(C0329R.id.sliding_button);
        this.mSlidingButton.setChecked(checked);
        this.mSlidingButton.setOnCheckedChangedListener(this);
        this.mSummaryView = (TextView) this.mSlidingButtonParent.findViewById(C0329R.id.summary);
        this.mCurrentParent = view.findViewById(C0329R.id.current_parent);
        TextView prefix = (TextView) this.mCurrentParent.findViewById(C0329R.id.current_prefix);
        if (TextUtils.isEmpty(this.mCurrentPrefix)) {
            prefix.setVisibility(8);
        } else {
            prefix.setVisibility(0);
            prefix.setText(this.mCurrentPrefix);
        }
        this.mCurrentView = (TextView) this.mCurrentParent.findViewById(C0329R.id.current);
        this.mCurrentView.setText(this.mConverter.convert(getContext(), current));
        this.mSeekParent = view.findViewById(C0329R.id.seek_parent);
        this.mSeekBar = (SeekBar) this.mSeekParent.findViewById(C0329R.id.seekbar);
        this.mSeekBar.setOnSeekBarChangeListener(this);
        this.mSeekBar.setMax((((this.mMaxValue - this.mMinValue) + this.mUnit) - 1) / this.mUnit);
        this.mSeekBar.setProgress((current - this.mMinValue) / this.mUnit);
        refreshSummary();
        refreshVisibility(checked);
        notifyDependencyChange(shouldDisableDependents());
        return view;
    }

    public boolean isPersistent() {
        return false;
    }

    public boolean shouldDisableDependents() {
        return this.mSlidingButton == null || !this.mSlidingButton.isChecked() || super.shouldDisableDependents();
    }

    public void setSummary(CharSequence summary) {
        setSummary(summary, summary);
    }

    public void setSummary(CharSequence summaryOn, CharSequence summaryOff) {
        this.mSummaryOn = summaryOn;
        this.mSummaryOff = summaryOff;
        refreshSummary();
    }

    public void refresh(boolean newValue) {
        PreferenceCache.setPrefAsBoolean(getContext(), getKey(), newValue);
        refreshSummary();
        refreshVisibility(newValue);
        callChangeListener(Boolean.valueOf(newValue));
        notifyDependencyChange(shouldDisableDependents());
    }

    public void onClick(View v) {
        boolean newValue = !this.mSlidingButton.isChecked();
        this.mSlidingButton.setChecked(newValue);
        refresh(newValue);
    }

    public void onCheckedChanged(boolean isChecked) {
        this.mSlidingButton.setChecked(isChecked);
        refresh(isChecked);
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            this.mCurrentView.setText(this.mConverter.convert(getContext(), absoluteProgress(progress)));
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        PreferenceCache.setPrefAsInteger(getContext(), this.mProgressKey, absoluteProgress(seekBar.getProgress()));
        callChangeListener(Boolean.valueOf(this.mSlidingButton.isChecked()));
    }

    public void refreshVisibility(boolean checked) {
        int visibility = checked ? 0 : 8;
        this.mSeekParent.setVisibility(visibility);
        this.mCurrentParent.setVisibility(visibility);
    }

    private int absoluteProgress(int progress) {
        int p = this.mMinValue + (this.mUnit * progress);
        if (p < this.mMinValue) {
            return this.mMinValue;
        }
        if (p > this.mMaxValue) {
            return this.mMaxValue;
        }
        return p;
    }

    private void refreshSummary() {
        CharSequence summary = this.mSlidingButton.isChecked() ? this.mSummaryOn : this.mSummaryOff;
        this.mSummaryView.setText(summary);
        this.mSummaryView.setVisibility(TextUtils.isEmpty(summary) ? 8 : 0);
    }

    private static ValueConverter createConverter(int type, Object extra) {
        switch (type) {
            case 0:
                return new RawConverter();
            case 1:
                return new SizeConverter();
            case 2:
                return new DurationConverter();
            case 3:
                return new ConstantConverter((String) extra);
            default:
                throw new IllegalArgumentException("Unsupported type=" + type);
        }
    }
}
