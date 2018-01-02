package com.miui.player.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.Adapter;
import com.baidu.music.model.BaseObject;
import com.baidu.utils.NetworkUtil;
import com.google.android.collect.Lists;
import com.miui.player.C0329R;
import com.miui.player.service.ShakeListener;
import com.miui.player.ui.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.mozilla.universalchardet.prober.UTF8Prober;
import org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis;
import org.mozilla.universalchardet.prober.distributionanalysis.GB2312DistributionAnalysis;
import org.mozilla.universalchardet.prober.distributionanalysis.JISDistributionAnalysis;

public class CascadingView extends ViewGroup implements OnGestureListener {
    private static final int DEFAULT_CHILD_GRAVITY = 17;
    private static final float DISPLAY_DENSITY = Resources.getSystem().getDisplayMetrics().density;
    private static final float FLING_VELOCITY_PER_ITEM = (300.0f * DISPLAY_DENSITY);
    private static final float LAST_ITEM_OVER_SCROLL = 0.3f;
    private static final int LAYOUT_MODE_LAYOUT_CHANGED = 1;
    private static final int LAYOUT_MODE_MAX_VISIBLE_CHANGED = 3;
    private static final int LAYOUT_MODE_NONE_CHANGED = 0;
    private static final int LAYOUT_MODE_SELECTION_CHANGED = 2;
    private static final int MAX_PARK_PRIOR_WEIGHT = 10;
    private static final float MSEC_PER_ITEM = 120.0f;
    private static final long PARK_DELAYED = 100;
    private static final float PARK_PRIOR_LIMIT = 0.2f;
    private static final float ROTATION_PRIVOT_X_RATE = 0.0f;
    private static final float ROTATION_PRIVOT_Y_RATE = 0.5f;
    private static final float SCALE_BASE = 0.9f;
    private static final float SCALE_FACTOR = 0.9f;
    private static final float SCALE_PRIVOT_X_RATE = 0.5f;
    private static final float SCALE_PRIVOT_Y_RATE = 0.4f;
    private static final float SCROLL_DISTANCE_PER_ITEM = (90.0f * DISPLAY_DENSITY);
    public static final int SCROLL_STATE_FLING = 2;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
    static final String TAG = "CascadingView";
    private static final float TRANSTALTION_ABSOLUTE_FACTOR = 1.38f;
    private static final float TRANSTALTION_RELALTIVE_FACTOR = 0.144f;
    private static final float TRANSTALTION_RELALTIVE_FACTOR_BEFORE_FIRST = -0.13f;
    private Adapter mAdapter;
    private AdapterDataSetObserver mAdapterObserver;
    private final int mAnimDuration;
    private View mAnimationChild;
    private long mAnimationStart;
    private boolean mAttached;
    private final float mCameraDistance;
    private final int mCameraDistanceFactor;
    private boolean mDataChanged;
    private final GestureDetector mGestureDetector;
    private final Handler mHandler;
    private boolean mInLayout;
    private boolean[] mIsScraped;
    private int mMaxVisibleItemCount;
    private int mParkPrior;
    private final Runnable mParkRunnable;
    private final RecycleBin mRecycler;
    private OnRotationChangedListener mRotationChangedListener;
    private Animator mRotationHAnim;
    private float mRotationHNext;
    private boolean mRotationHNextSmooth;
    private float mRotationHorizontal;
    private float mRotationHorizontalMax;
    private float[] mScales;
    private OnScrollListener mScrollListener;
    private int mScrollState;
    private int mSelectedPostion;
    private int mSelectedPostionExpected;
    private float mSelectedPostionOffset;
    private float mSelectedPostionOffsetExpected;
    private float mSelectedPostionOverOffset;
    private Animator mSelectionAnimator;
    private int mSelectionNext;
    private boolean mSelectionNextAnim;
    private OnSingleTapUpListener mSingleTapUpListener;
    private float[] mTranslations;
    private ViewEffectUpdater mViewEffectUpdater;

    public interface OnScrollListener {
        void onScroll(CascadingView cascadingView, int i, float f);

        void onScrollStateChanged(CascadingView cascadingView, int i);
    }

    public interface OnSingleTapUpListener {
        void onSingleTapUp(CascadingView cascadingView);
    }

    public interface OnRotationChangedListener {
        void onRotationChanged(CascadingView cascadingView, float f);
    }

    public interface ViewEffectUpdater {
        void updateEffect(CascadingView cascadingView, View view, int i, int i2);
    }

    class C05231 implements Runnable {
        C05231() {
        }

        public void run() {
            int parkPrior = CascadingView.this.mParkPrior;
            CascadingView.this.mParkPrior = 0;
            if (CascadingView.this.mSelectedPostionOffset != 0.0f || CascadingView.this.mSelectedPostionOverOffset != 0.0f) {
                int pos;
                if (parkPrior == 0) {
                    pos = Math.round(((float) CascadingView.this.mSelectedPostion) + CascadingView.this.mSelectedPostionOffset);
                } else if (parkPrior > 0) {
                    if (CascadingView.this.mSelectedPostionOffset > 0.2f) {
                        pos = CascadingView.this.mSelectedPostion + 1;
                    } else {
                        pos = CascadingView.this.mSelectedPostion;
                    }
                } else if (CascadingView.this.mSelectedPostionOffset > 0.2f || CascadingView.this.mSelectedPostionOverOffset < 0.0f) {
                    pos = CascadingView.this.mSelectedPostion;
                } else {
                    pos = CascadingView.this.mSelectedPostion + 1;
                }
                CascadingView.this.smoothToSelection(UIHelper.clamp(pos, 0, CascadingView.this.getCount() - 1));
            }
        }
    }

    class C05242 implements AnimatorListener {
        C05242() {
        }

        public void onAnimationStart(Animator animation) {
        }

        public void onAnimationRepeat(Animator animation) {
        }

        public void onAnimationEnd(Animator animation) {
            CascadingView.this.onScrollStateChanged(0);
            CascadingView.this.mSelectionAnimator = null;
            if (CascadingView.this.mAttached && CascadingView.this.mSelectionNext >= 0) {
                if (CascadingView.this.mSelectionNextAnim) {
                    CascadingView.this.smoothToSelection(CascadingView.this.mSelectionNext);
                } else {
                    CascadingView.this.setSelection(CascadingView.this.mSelectionNext);
                }
                CascadingView.this.mSelectionNext = -1;
            }
        }

        public void onAnimationCancel(Animator animation) {
        }
    }

    class C05264 implements AnimatorListener {
        C05264() {
        }

        public void onAnimationStart(Animator animation) {
        }

        public void onAnimationRepeat(Animator animation) {
        }

        public void onAnimationEnd(Animator animation) {
            CascadingView.this.mRotationHAnim = null;
            if (CascadingView.this.mAttached && CascadingView.this.mRotationHNext != Float.MAX_VALUE) {
                if (CascadingView.this.mRotationHNextSmooth) {
                    CascadingView.this.smoothToRotationHorizontal(CascadingView.this.mRotationHNext);
                } else {
                    CascadingView.this.setRotationHorizontal(CascadingView.this.mRotationHNext);
                }
                CascadingView.this.mRotationHNext = Float.MAX_VALUE;
            }
        }

        public void onAnimationCancel(Animator animation) {
        }
    }

    class AdapterDataSetObserver extends DataSetObserver {
        AdapterDataSetObserver() {
        }

        public void onChanged() {
            Log.d(CascadingView.TAG, "Adapter onChanged");
            CascadingView.this.mDataChanged = true;
            CascadingView.this.requestLayout();
        }

        public void onInvalidated() {
            Log.d(CascadingView.TAG, "Adapter onInvalidated");
            CascadingView.this.mDataChanged = true;
            CascadingView.this.requestLayout();
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity = -1;
        boolean hasAdded = false;
        int viewType = -1;

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, C0329R.styleable.CascadingView_Layout);
            this.gravity = a.getInt(0, -1);
            a.recycle();
        }

        public LayoutParams(int w, int h) {
            super(w, h);
        }

        public LayoutParams(int w, int h, int g) {
            super(w, h);
            this.gravity = g;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }
    }

    static class RecycleBin {
        private int mMaxItemCount;
        private ArrayList<View>[] mScrapViews;

        RecycleBin() {
        }

        public void setViewTypeCount(int viewTypeCount) {
            if (this.mScrapViews != null) {
                Log.w(CascadingView.TAG, "size != 0 when type count is set");
            }
            ArrayList<View>[] scrapViews = new ArrayList[viewTypeCount];
            for (int i = 0; i < viewTypeCount; i++) {
                scrapViews[i] = new ArrayList();
            }
            this.mScrapViews = scrapViews;
        }

        public void setMaxItemCount(int count) {
            this.mMaxItemCount = count;
        }

        public boolean addScrapView(int type, View view) {
            if (shouldRecycleViewType(type)) {
                if (size() < this.mMaxItemCount) {
                    this.mScrapViews[type].add(view);
                    return true;
                }
                Log.w(CascadingView.TAG, "Too many cached views, max item count=" + this.mMaxItemCount);
            }
            return false;
        }

        public View getScrapView(int type) {
            ArrayList<View> list = this.mScrapViews[type];
            int size = list.size();
            return size > 0 ? (View) list.get(size - 1) : null;
        }

        public void removeScrapView(int type, View v) {
            this.mScrapViews[type].remove(v);
        }

        public boolean shouldRecycleViewType(int type) {
            return type != -1;
        }

        public int size() {
            if (this.mScrapViews == null) {
                return 0;
            }
            int c = 0;
            for (ArrayList<View> list : this.mScrapViews) {
                c += list.size();
            }
            return c;
        }

        public void markChildrenDirty() {
            if (this.mScrapViews != null) {
                for (ArrayList<View> list : this.mScrapViews) {
                    Iterator i$ = list.iterator();
                    while (i$.hasNext()) {
                        ((View) i$.next()).forceLayout();
                    }
                }
            }
        }

        public ArrayList<View> clear() {
            if (this.mScrapViews == null) {
                return null;
            }
            ArrayList<View> out = Lists.newArrayList();
            for (ArrayList<View> list : this.mScrapViews) {
                out.addAll(list);
            }
            this.mScrapViews = null;
            return out;
        }
    }

    public CascadingView(Context context) {
        this(context, null);
    }

    public CascadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CascadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mRecycler = new RecycleBin();
        this.mIsScraped = new boolean[1];
        this.mDataChanged = false;
        this.mInLayout = false;
        this.mRotationHNext = Float.MAX_VALUE;
        this.mSelectionNext = -1;
        this.mSelectionNextAnim = false;
        this.mHandler = new Handler();
        this.mParkPrior = 0;
        this.mAttached = false;
        this.mParkRunnable = new C05231();
        this.mScrollState = 0;
        this.mGestureDetector = new GestureDetector(context, this);
        this.mCameraDistance = getCameraDistance();
        this.mCameraDistanceFactor = getResources().getInteger(C0329R.integer.cascading_view_camera_distance_factor);
        this.mAnimDuration = getResources().getInteger(C0329R.integer.anim_duration_normal);
        setClipChildren(false);
        setClipToPadding(false);
    }

    public void setAdapter(Adapter adapter) {
        if (!(this.mAdapter == null || this.mAdapterObserver == null)) {
            this.mAdapter.unregisterDataSetObserver(this.mAdapterObserver);
            this.mAdapterObserver = null;
        }
        this.mAdapter = adapter;
        if (this.mAdapter != null) {
            this.mAdapterObserver = new AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mAdapterObserver);
        }
        clearRecyleBin();
        if (this.mAdapter != null) {
            this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
        }
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getCount() {
        return this.mAdapter != null ? this.mAdapter.getCount() : 0;
    }

    public int getSelection() {
        return this.mSelectedPostion;
    }

    public float getSelectionOffset() {
        return this.mSelectedPostionOffset;
    }

    public void setSelection(int position) {
        removeSelectionPark();
        if (this.mSelectionAnimator != null) {
            this.mSelectionNext = position;
            this.mSelectionNextAnim = false;
            return;
        }
        setSelectionInternal(position, 0.0f, false);
    }

    public void setSelection(int position, float offset) {
        setSelectionInternal(position, offset, false);
    }

    private void setSelectionInternal(int position, float offset, boolean allowOutOfBound) {
        int positionExpected = position + ((int) offset);
        float offsetExpected = offset - ((float) ((int) offset));
        float oldOverOffset = this.mSelectedPostionOverOffset;
        float target = ((float) positionExpected) + offsetExpected;
        int itemCount = getCount();
        if (!allowOutOfBound) {
            this.mSelectedPostionOverOffset = 0.0f;
            if (target < 0.0f) {
                positionExpected = 0;
                offsetExpected = 0.0f;
            } else if (target > ((float) (itemCount - 1))) {
                offsetExpected = 0.0f;
            }
        } else if (target < 0.0f) {
            this.mSelectedPostionOverOffset = Math.max(JapaneseContextAnalysis.DONT_KNOW, target);
            positionExpected = 0;
            offsetExpected = 0.0f;
        } else {
            this.mSelectedPostionOverOffset = 0.0f;
            if (offsetExpected < 0.0f) {
                positionExpected--;
                offsetExpected += ShakeListener.ACCELATION_FACTOR_X;
            }
            if (target >= ((float) (itemCount - 1)) + LAST_ITEM_OVER_SCROLL) {
                positionExpected = itemCount - 1;
                offsetExpected = LAST_ITEM_OVER_SCROLL;
            }
        }
        this.mSelectedPostionExpected = positionExpected;
        this.mSelectedPostionOffsetExpected = offsetExpected;
        Log.d(TAG, "selection expected=" + positionExpected + " , offset expected=" + offsetExpected);
        if (this.mSelectedPostion != positionExpected || offsetExpected != this.mSelectedPostionOffset || oldOverOffset != this.mSelectedPostionOverOffset) {
            layoutChildren(2);
        }
    }

    public void removeSelectionPark() {
        this.mHandler.removeCallbacks(this.mParkRunnable);
    }

    public void parkSelectionDelayed() {
        removeSelectionPark();
        if (this.mSelectionAnimator != null) {
            return;
        }
        if (this.mSelectedPostionOffset != 0.0f || this.mSelectedPostionOverOffset != 0.0f) {
            this.mHandler.postDelayed(this.mParkRunnable, 100);
        }
    }

    public void abortSmoothToSelection() {
        this.mSelectionNext = -1;
        if (this.mSelectionAnimator != null) {
            this.mSelectionAnimator.cancel();
        }
        parkSelectionDelayed();
    }

    public void smoothToSelection(final int targetPosition) {
        removeSelectionPark();
        if (this.mSelectionAnimator != null) {
            this.mSelectionNext = targetPosition;
            this.mSelectionNextAnim = true;
            return;
        }
        final float start = (((float) this.mSelectedPostion) + this.mSelectedPostionOffset) + this.mSelectedPostionOverOffset;
        ValueAnimator anim = ValueAnimator.ofFloat(new float[]{0.0f, ShakeListener.ACCELATION_FACTOR_X});
        anim.setDuration((long) UIHelper.clamp((int) (Math.abs(((float) targetPosition) - start) * MSEC_PER_ITEM), this.mAnimDuration / 2, this.mAnimDuration * 10));
        anim.setInterpolator(new DecelerateInterpolator());
        anim.addListener(new C05242());
        anim.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                float pos = start + ((((float) targetPosition) - start) * animation.getAnimatedFraction());
                CascadingView.this.setSelectionInternal((int) pos, pos - ((float) ((int) pos)), true);
            }
        });
        anim.start();
        this.mSelectionAnimator = anim;
        onScrollStateChanged(2);
    }

    public void setMaxVisibleItemCount(int count) {
        this.mMaxVisibleItemCount = count;
        this.mRecycler.setMaxItemCount(count + 2);
        layoutChildren(3);
    }

    private int lookForSelectablePostion() {
        return UIHelper.clamp(this.mSelectedPostionExpected, 0, getCount() - 1);
    }

    private float lookForSelectablePostionOffset() {
        return UIHelper.clamp(this.mSelectedPostionOffsetExpected, 0.0f, (float) ShakeListener.ACCELATION_FACTOR_X);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttached = true;
        if (this.mAdapter != null && this.mAdapterObserver == null) {
            this.mAdapterObserver = new AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mAdapterObserver);
        }
    }

    protected void onDetachedFromWindow() {
        this.mAttached = false;
        if (this.mSelectionAnimator != null) {
            this.mSelectionAnimator.cancel();
        }
        if (this.mRotationHAnim != null) {
            this.mRotationHAnim.cancel();
        }
        removeSelectionPark();
        if (!(this.mAdapter == null || this.mAdapterObserver == null)) {
            this.mAdapter.unregisterDataSetObserver(this.mAdapterObserver);
            this.mAdapterObserver = null;
        }
        clearRecyleBin();
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = 1;
        this.mInLayout = true;
        if (!changed) {
            i = 0;
        }
        layoutChildren(i);
        this.mInLayout = false;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int maxHeight = 0;
        int maxWidth = 0;
        int childState = 0;
        if (getCount() > 0) {
            boolean needRecycle = false;
            View child = getChildAt(0);
            if (child == null) {
                child = obtainView(lookForSelectablePostion(), this.mIsScraped);
                needRecycle = true;
            }
            int oldVisibility = child.getVisibility();
            child.setVisibility(0);
            measureItem(child, widthMeasureSpec, heightMeasureSpec);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            maxWidth = Math.max(0, (child.getMeasuredWidth() + lp.leftMargin) + lp.rightMargin);
            maxHeight = Math.max(0, (child.getMeasuredHeight() + lp.topMargin) + lp.bottomMargin);
            childState = combineMeasuredStates(0, child.getMeasuredState());
            child.setVisibility(oldVisibility);
            if (needRecycle) {
                this.mRecycler.addScrapView(this.mAdapter.getItemViewType(0), child);
            }
        }
        maxWidth += getPaddingLeft() + getPaddingRight();
        maxHeight = Math.max(maxHeight + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        Drawable drawable = getBackground();
        if (drawable != null) {
            maxHeight = Math.max(maxHeight, drawable.getMinimumHeight());
            maxWidth = Math.max(maxWidth, drawable.getMinimumWidth());
        }
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState), resolveSizeAndState(maxHeight, heightMeasureSpec, childState << 16));
    }

    private void measureItem(View v, int widthMeasureSpec, int heightMeasureSpec) {
        measureChildWithMargins(v, widthMeasureSpec, 0, heightMeasureSpec, 0);
    }

    private boolean prepareSelectionChangeAnim(int mode) {
        if (mode != 2 || this.mRotationHorizontal != 0.0f) {
            return false;
        }
        int index = getChildCount() - 1;
        this.mAnimationChild = getChildAt(index);
        detachViewFromParent(index);
        this.mAnimationStart = -1;
        return true;
    }

    private void endSelectionChangeAnim() {
        this.mAnimationStart = -1;
        if (this.mAnimationChild != null) {
            View v = this.mAnimationChild;
            this.mAnimationChild = null;
            if (!this.mRecycler.addScrapView(((LayoutParams) v.getLayoutParams()).viewType, v)) {
                removeDetachedView(v, false);
            }
        }
    }

    private void layoutChildren(int mode) {
        if (!this.mAttached) {
            return;
        }
        if (mode != 0 || this.mDataChanged) {
            boolean needRelayout = this.mDataChanged || mode == 1 || mode == 3;
            this.mDataChanged = false;
            int selectedPosition = lookForSelectablePostion();
            float selectedOffset = lookForSelectablePostionOffset();
            if (mode == 2) {
                int i = (selectedPosition != this.mSelectedPostion || ((selectedOffset != 0.0f && this.mSelectedPostionOffset == 0.0f) || (selectedOffset == 0.0f && this.mSelectedPostionOffset != 0.0f))) ? 1 : 0;
                needRelayout |= i;
            }
            if (!(this.mSelectedPostion == selectedPosition && this.mSelectedPostionOffset == selectedOffset)) {
                this.mSelectedPostion = selectedPosition;
                this.mSelectedPostionOffset = selectedOffset;
                onScroll(selectedPosition, selectedOffset);
            }
            if (needRelayout) {
                prepareSelectionChangeAnim(mode);
                moveToRecyleBin();
                if (mode == 1) {
                    endSelectionChangeAnim();
                    this.mRecycler.markChildrenDirty();
                }
                int itemCount = getCount();
                int start = this.mSelectedPostion;
                int end = Math.min((this.mSelectedPostionOffset > 0.0f ? 2 : 0) + (start + this.mMaxVisibleItemCount), itemCount);
                if (this.mRotationHorizontal == 0.0f) {
                    end = Math.min(end, start + 1);
                }
                Log.d(TAG, String.format("layout all children[%d, %d)", new Object[]{Integer.valueOf(start), Integer.valueOf(end)}));
                if (start < end) {
                    int widthMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                    int heightMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                    int itemPosition = end - 1;
                    while (itemPosition >= start) {
                        int childPosition = (end - itemPosition) - 1;
                        View child = obtainView(itemPosition, this.mIsScraped);
                        setupChild(child, childPosition, itemPosition);
                        child.setSelected(this.mSelectedPostion == itemPosition);
                        if (child.getVisibility() != 8 && (!this.mIsScraped[0] || child.isLayoutRequested())) {
                            measureItem(child, widthMeasureSpec, heightMeasureSpec);
                            layoutChild(child, childPosition, getLeft(), getTop(), getRight(), getBottom());
                        }
                        itemPosition--;
                    }
                    setRotationEffectForAllChildren();
                }
            } else {
                setRotationEffectForAllChildren();
            }
            if (!this.mInLayout) {
                invalidate();
            }
        }
    }

    private void layoutChild(View child, int childIndex, int left, int top, int right, int bottom) {
        int childLeft;
        int childTop;
        int parentLeft = getPaddingLeft();
        int parentRight = (right - left) - getPaddingRight();
        int parentTop = getPaddingTop();
        int parentBottom = (bottom - top) - getPaddingBottom();
        int width = child.getMeasuredWidth();
        int height = child.getMeasuredHeight();
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        int gravity = lp.gravity;
        if (gravity == -1) {
            gravity = 17;
        }
        int verticalGravity = gravity & BaseObject.ERROR_SESSION_KEY_INVALIDE;
        switch (Gravity.getAbsoluteGravity(gravity, getLayoutDirection()) & 7) {
            case 1:
                childLeft = (((((parentRight - parentLeft) - width) / 2) + parentLeft) + lp.leftMargin) - lp.rightMargin;
                break;
            case 3:
                childLeft = parentLeft + lp.leftMargin;
                break;
            case 5:
                childLeft = (parentRight - width) - lp.rightMargin;
                break;
            default:
                childLeft = parentLeft + lp.leftMargin;
                break;
        }
        switch (verticalGravity) {
            case 16:
                childTop = (((((parentBottom - parentTop) - height) / 2) + parentTop) + lp.topMargin) - lp.bottomMargin;
                break;
            case 48:
                childTop = parentTop + lp.topMargin;
                break;
            case NetworkUtil.DEFAULT_PROXY_PORT /*80*/:
                childTop = (parentBottom - height) - lp.bottomMargin;
                break;
            default:
                childTop = parentTop + lp.topMargin;
                break;
        }
        child.layout(childLeft, childTop, childLeft + width, childTop + height);
    }

    private void setupChild(View v, int childPostion, int itemPosition) {
        LayoutParams params = (LayoutParams) v.getLayoutParams();
        if (params == null) {
            params = generateDefaultLayoutParams();
        }
        params.viewType = this.mAdapter.getItemViewType(itemPosition);
        if (params.hasAdded) {
            attachViewToParent(v, getChildCount(), params);
            return;
        }
        params.hasAdded = true;
        if (this.mInLayout) {
            addViewInLayout(v, getChildCount(), params, true);
        } else {
            addView(v, getChildCount(), params);
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    private View obtainView(int position, boolean[] recycled) {
        View convertView;
        int type = this.mAdapter.getItemViewType(position);
        if (type == -1) {
            convertView = null;
        } else {
            convertView = this.mRecycler.getScrapView(type);
        }
        View newView = this.mAdapter.getView(position, convertView, this);
        recycled[0] = false;
        if (convertView != null) {
            if (newView == convertView) {
                this.mRecycler.removeScrapView(type, convertView);
                recycled[0] = true;
            } else {
                Log.w(TAG, "View is not be reused, position=" + position + ", type=" + type);
            }
        }
        return newView;
    }

    private void moveToRecyleBin() {
        for (int i = getChildCount() - 1; i >= 0; i--) {
            View v = getChildAt(i);
            if (!this.mRecycler.addScrapView(((LayoutParams) v.getLayoutParams()).viewType, v)) {
                if (this.mInLayout) {
                    removeViewInLayout(v);
                } else {
                    removeView(v);
                }
            }
        }
        detachAllViewsFromParent();
    }

    private void clearRecyleBin() {
        ArrayList<View> detachedViews = this.mRecycler.clear();
        if (detachedViews != null) {
            Iterator i$ = detachedViews.iterator();
            while (i$.hasNext()) {
                removeDetachedView((View) i$.next(), false);
            }
        }
    }

    public void setOnSingleTapUpListener(OnSingleTapUpListener l) {
        this.mSingleTapUpListener = l;
    }

    public void setOnScrollListener(OnScrollListener l) {
        this.mScrollListener = l;
    }

    private void onScroll(int position, float offset) {
        if (this.mScrollListener != null) {
            this.mScrollListener.onScroll(this, position, offset);
        }
    }

    private void onScrollStateChanged(int state) {
        this.mScrollState = state;
        if (this.mScrollListener != null) {
            this.mScrollListener.onScrollStateChanged(this, state);
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        this.mGestureDetector.onTouchEvent(ev);
        switch (ev.getActionMasked()) {
            case 0:
                abortSmoothToSelection();
                onScrollStateChanged(1);
                break;
            case 1:
            case 3:
                if (this.mScrollState == 1) {
                    parkSelectionDelayed();
                    onScrollStateChanged(0);
                    break;
                }
                break;
        }
        return true;
    }

    public boolean onDown(MotionEvent e) {
        return true;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (this.mRotationHorizontal != 0.0f && this.mRotationHAnim == null && Math.abs(velocityX) > Math.abs(velocityY)) {
            float start = ((float) this.mSelectedPostion) + this.mSelectedPostionOffset;
            ViewConfiguration vc = ViewConfiguration.get(this.mContext);
            if (Math.abs(velocityX) > ((float) vc.getScaledMinimumFlingVelocity()) && Math.abs(velocityX) < ((float) vc.getScaledMaximumFlingVelocity())) {
                smoothToSelection(UIHelper.clamp(Math.round((velocityX / FLING_VELOCITY_PER_ITEM) + start), 0, getCount() - 1));
            }
        }
        return true;
    }

    public void onLongPress(MotionEvent e) {
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (this.mRotationHorizontal != 0.0f && this.mRotationHAnim == null && Math.abs(distanceX) > Math.abs(distanceY)) {
            int i;
            if (distanceX > 0.0f) {
                i = -1;
            } else {
                i = 1;
            }
            countParkPrior(i);
            setSelectionInternal(this.mSelectedPostion, (this.mSelectedPostionOverOffset + this.mSelectedPostionOffset) - (distanceX / SCROLL_DISTANCE_PER_ITEM), true);
        }
        return true;
    }

    public void onShowPress(MotionEvent e) {
    }

    public boolean onSingleTapUp(MotionEvent e) {
        Log.d(TAG, "onSingleTapUp");
        if (this.mSingleTapUpListener != null) {
            this.mSingleTapUpListener.onSingleTapUp(this);
        }
        return true;
    }

    public void setViewEffectUpdater(ViewEffectUpdater updater) {
        this.mViewEffectUpdater = updater;
    }

    public void setOnRotationChangedListener(OnRotationChangedListener l) {
        this.mRotationChangedListener = l;
    }

    public void setRotationHorizontal(float rotation) {
        rotation = UIHelper.regularRotation(rotation);
        if (this.mRotationHAnim != null) {
            this.mRotationHNext = rotation;
            this.mRotationHNextSmooth = false;
        } else if (rotation != this.mRotationHorizontal) {
            setRotationHorizontalInternal(rotation);
        }
    }

    public void smoothToRotationHorizontal(float rotation) {
        rotation = UIHelper.regularRotation(rotation);
        if (this.mRotationHAnim != null) {
            this.mRotationHNext = rotation;
            this.mRotationHNextSmooth = true;
        } else if (rotation != this.mRotationHorizontal) {
            final float start = this.mRotationHorizontal;
            final float end = rotation;
            ValueAnimator anim = ValueAnimator.ofFloat(new float[]{0.0f, ShakeListener.ACCELATION_FACTOR_X});
            anim.setDuration((long) this.mAnimDuration);
            anim.addListener(new C05264());
            anim.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    CascadingView.this.setRotationHorizontalInternal(start + ((end - start) * animation.getAnimatedFraction()));
                }
            });
            anim.start();
            this.mRotationHAnim = anim;
        }
    }

    public void setMaxRotationHorizontal(float max) {
        this.mRotationHorizontalMax = max;
    }

    public float getRotationHorizontal() {
        return this.mRotationHorizontal;
    }

    private void setRotationHorizontalInternal(float rotation) {
        float oldRotation = this.mRotationHorizontal;
        this.mRotationHorizontal = rotation;
        setRotationEffectForAllChildren();
        if ((oldRotation == 0.0f && rotation != 0.0f) || (oldRotation != 0.0f && rotation == 0.0f)) {
            layoutChildren(3);
        }
        if (this.mRotationChangedListener != null) {
            this.mRotationChangedListener.onRotationChanged(this, rotation);
        }
    }

    private void setRotationEffectForAllChildren() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            setRotationEffect(getChildAt(i), i, i + this.mSelectedPostion);
        }
    }

    private void setRotationEffect(View v, int childPostion, int itemPosition) {
        float rotation = this.mRotationHorizontal;
        if (rotation == 0.0f) {
            v.setTranslationX(0.0f);
            v.setRotationY(0.0f);
            v.setScaleX(ShakeListener.ACCELATION_FACTOR_X);
            v.setScaleY(ShakeListener.ACCELATION_FACTOR_X);
            v.setAlpha(ShakeListener.ACCELATION_FACTOR_X);
            v.setCameraDistance(this.mCameraDistance);
        } else {
            ensureScalesAndTranslations(this.mMaxVisibleItemCount + 3);
            v.setCameraDistance((this.mCameraDistance * ((float) this.mCameraDistanceFactor)) * 0.1f);
            int height = v.getHeight();
            int width = v.getWidth();
            int depth = getChildCount() - childPostion;
            float offset = this.mSelectedPostionOffset + this.mSelectedPostionOverOffset;
            v.setPivotX(((float) width) * 0.0f);
            v.setPivotY(((float) height) * UTF8Prober.ONE_CHAR_PROB);
            v.setRotationY(rotation);
            v.setPivotX(((float) width) * UTF8Prober.ONE_CHAR_PROB);
            v.setPivotY(((float) height) * SCALE_PRIVOT_Y_RATE);
            float percent = rotation / this.mRotationHorizontalMax;
            float scale = this.mScales[depth] + ((this.mScales[depth - 1] - this.mScales[depth]) * offset);
            if (depth == 1) {
                scale = ShakeListener.ACCELATION_FACTOR_X - ((ShakeListener.ACCELATION_FACTOR_X - scale) * percent);
            }
            v.setScaleX(scale);
            v.setScaleY(scale);
            float tx = this.mTranslations[depth] + ((this.mTranslations[depth - 1] - this.mTranslations[depth]) * offset);
            View view = v;
            view.setTranslationX(((((float) (-getWidth())) * tx) * percent) + ((percent * ((float) ((getRight() - getPaddingRight()) - v.getRight()))) * TRANSTALTION_ABSOLUTE_FACTOR));
            if (depth != 1 || offset == 0.0f) {
                v.setAlpha(ShakeListener.ACCELATION_FACTOR_X);
            } else {
                v.setAlpha(ShakeListener.ACCELATION_FACTOR_X - UIHelper.clamp(JISDistributionAnalysis.JIS_TYPICAL_DISTRIBUTION_RATIO * offset, 0.0f, (float) ShakeListener.ACCELATION_FACTOR_X));
            }
        }
        if (this.mViewEffectUpdater != null) {
            this.mViewEffectUpdater.updateEffect(this, v, childPostion, itemPosition);
        }
    }

    void ensureScalesAndTranslations(int maxItemCount) {
        if (this.mScales == null || this.mScales.length < maxItemCount) {
            int i;
            float[] scales = new float[maxItemCount];
            scales[0] = ShakeListener.ACCELATION_FACTOR_X;
            scales[1] = GB2312DistributionAnalysis.GB2312_TYPICAL_DISTRIBUTION_RATIO;
            for (i = 2; i < maxItemCount; i++) {
                scales[i] = scales[i - 1] * GB2312DistributionAnalysis.GB2312_TYPICAL_DISTRIBUTION_RATIO;
            }
            float[] translations = new float[maxItemCount];
            translations[0] = TRANSTALTION_RELALTIVE_FACTOR_BEFORE_FIRST;
            translations[1] = 0.0f;
            for (i = 2; i < maxItemCount; i++) {
                translations[i] = translations[i - 1] + (TRANSTALTION_RELALTIVE_FACTOR * scales[i]);
            }
            this.mScales = scales;
            this.mTranslations = translations;
        }
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mAnimationChild != null) {
            long drawingTime = getDrawingTime();
            if (this.mAnimationStart == -1) {
                this.mAnimationStart = drawingTime;
            }
            long e = drawingTime - this.mAnimationStart;
            if (e < ((long) this.mAnimDuration)) {
                this.mAnimationChild.setAlpha(ShakeListener.ACCELATION_FACTOR_X - (((float) e) / ((float) this.mAnimDuration)));
                drawChild(canvas, this.mAnimationChild, drawingTime);
                invalidate();
                return;
            }
            this.mAnimationChild.setAlpha(ShakeListener.ACCELATION_FACTOR_X);
            endSelectionChangeAnim();
        }
    }

    private void countParkPrior(int weight) {
        this.mParkPrior = UIHelper.clamp(this.mParkPrior + weight, -10, 10);
    }
}
