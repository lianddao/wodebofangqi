package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.util.AttributeSet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ListView extends android.widget.ListView {
    protected static final int MAX_SMOOTH_SCROLL_DISTANCE = 20;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    protected Method mSetOverScrollMode = null;
    protected Method mSmoothScrollBy = null;
    protected Method mSmoothScrollToPosition = null;

    public ListView(Context context) {
        super(context);
        initMethods();
    }

    public ListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMethods();
    }

    public ListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initMethods();
    }

    public void doSmoothScroll(int aDistance, int aDuration) {
        if (this.mSmoothScrollBy == null) {
            scrollBy(0, aDistance);
            return;
        }
        try {
            this.mSmoothScrollBy.invoke(this, new Object[]{Integer.valueOf(aDistance), Integer.valueOf(aDuration)});
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e2) {
        } catch (InvocationTargetException e3) {
        }
    }

    public void setSelection(int aPosition, boolean aAttemptSmoothScroll) {
        int firstVisible = getFirstVisiblePosition();
        int lastVisible = getLastVisiblePosition();
        int distance = 0;
        if (aPosition < firstVisible) {
            distance = firstVisible - aPosition;
        } else if (aPosition > lastVisible) {
            distance = aPosition - lastVisible;
        }
        aPosition += getHeaderViewsCount();
        if (!aAttemptSmoothScroll || this.mSmoothScrollToPosition == null || distance > 20) {
            super.setSelection(aPosition);
            return;
        }
        try {
            this.mSmoothScrollToPosition.invoke(this, new Object[]{Integer.valueOf(aPosition)});
        } catch (InvocationTargetException ite) {
            Throwable cause = ite.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(ite);
            }
        } catch (IllegalAccessException e) {
        }
    }

    protected void initMethods() {
        initSmoothScrollToPosition();
        initSetOverScrollMode();
        initSmoothScrollBy();
        disableOverScroll();
    }

    protected void initSmoothScrollBy() {
        try {
            this.mSmoothScrollBy = ListView.class.getMethod("smoothScrollBy", new Class[]{Integer.TYPE, Integer.TYPE});
        } catch (NoSuchMethodException e) {
            this.mSmoothScrollBy = null;
        }
    }

    protected void initSmoothScrollToPosition() {
        try {
            this.mSmoothScrollToPosition = ListView.class.getMethod("smoothScrollToPosition", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException e) {
            this.mSmoothScrollToPosition = null;
        }
    }

    protected void initSetOverScrollMode() {
        try {
            this.mSetOverScrollMode = ListView.class.getMethod("setOverScrollMode", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException e) {
            this.mSetOverScrollMode = null;
        }
    }

    protected void disableOverScroll() {
        if (this.mSetOverScrollMode != null) {
            try {
                this.mSetOverScrollMode.invoke(this, new Object[]{Integer.valueOf(1)});
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
    }

    public boolean isShuffle(int position) {
        if (getHeaderViewsCount() - position == 1) {
            return true;
        }
        return false;
    }

    public int adjusted(int position) {
        return position - getFirstItemPosition();
    }

    public int getFirstItemPosition() {
        return getHeaderViewsCount();
    }
}
