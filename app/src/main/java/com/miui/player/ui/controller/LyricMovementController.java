package com.miui.player.ui.controller;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.meta.LyricParser.Lyric;
import com.miui.player.meta.LyricParser.LyricShot;
import com.miui.player.meta.MetaManager;
import com.miui.player.ui.view.ExtendScrollView;
import com.miui.player.ui.view.ExtendScrollView.OnExtendScrollListener;
import com.miui.player.ui.view.VerticalSlideAnimation;

public class LyricMovementController {
    private static final int ANIMATION_DURATION = 1000;
    public static final int LYRIC_PROGRESS_MODIFY_MODE = 1;
    public static final int LYRIC_STATUS_ANIM = 2;
    public static final int LYRIC_STATUS_DRAG = 1;
    public static final int LYRIC_STATUS_PLAY = 0;
    private static final int MSG_PLAY = 1;
    public static final int NORMAL_MODE = 0;
    private static int OFFSET_LINE_DRAG = -1;
    private static final int OFFSET_LINE_PLAY = 5;
    private static final int OFFSET_LINE_PLAY_AFTER = 5;
    private Handler mHandler = new LyricHandler();
    private int mLastLyricLine = -1;
    long mLastPosition = -1;
    Lyric mLyric;
    private int mLyricMode = 0;
    private final OnLyricScrollListener mLyricScrollListener;
    int mLyricStatus = 0;
    final LyricView mLyricView;
    private int[] mOffsetLineNumArr;
    private long mOrginLastPosition;
    private final ExtendScrollView mScrollView;
    final VerticalSlideAnimation mSlideAnimation;

    class LyricHandler extends Handler {
        LyricHandler() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1 && LyricMovementController.this.mLyric != null) {
                LyricMovementController.this.mLyricStatus = 2;
                LyricMovementController.this.mSlideAnimation.slideTo(LyricMovementController.this.getScrollOffset(LyricMovementController.this.mLyric.getLyricShot(LyricMovementController.this.mLastPosition + 1000), 5, LyricMovementController.this.mLyricView.getAccurateLineHeight()));
                LyricMovementController.this.refreshLyric(LyricMovementController.this.mLastPosition, true);
            }
        }
    }

    private static class LyricView {
        private float mLineExtraSpacing;
        private final StringBuilder mLyricBuilder = new StringBuilder();
        private final TextView mLyricViewAfter;
        private final TextView mLyricViewBefore;
        private final TextView mLyricViewCurrent;

        public LyricView(View parent) {
            this.mLyricViewCurrent = (TextView) parent.findViewById(C0329R.id.lyric_current);
            this.mLyricViewBefore = (TextView) parent.findViewById(C0329R.id.lyric_before);
            this.mLyricViewAfter = (TextView) parent.findViewById(C0329R.id.lyric_after);
            this.mLineExtraSpacing = parent.getResources().getDimension(C0329R.dimen.lyric_line_extra_spacing);
            this.mLyricViewCurrent.setLineSpacing(this.mLineExtraSpacing, 0.0f);
            this.mLyricViewBefore.setLineSpacing(this.mLineExtraSpacing, 0.0f);
            this.mLyricViewAfter.setLineSpacing(this.mLineExtraSpacing, 0.0f);
        }

        public void setHighLightTextStyle(int sizeRes) {
            this.mLyricViewCurrent.setTextSize(0, this.mLyricViewCurrent.getContext().getResources().getDimension(sizeRes));
        }

        public void setNormalTextStyle(int sizeRes) {
            float textSize = this.mLyricViewBefore.getContext().getResources().getDimension(sizeRes);
            this.mLyricViewBefore.setTextSize(0, textSize);
            this.mLyricViewAfter.setTextSize(0, textSize);
        }

        public void setLineSpacing(int resId) {
            this.mLineExtraSpacing = this.mLyricViewBefore.getContext().getResources().getDimension(resId);
            this.mLyricViewCurrent.setLineSpacing(this.mLineExtraSpacing, 0.0f);
            this.mLyricViewBefore.setLineSpacing(this.mLineExtraSpacing, 0.0f);
            this.mLyricViewAfter.setLineSpacing(this.mLineExtraSpacing, 0.0f);
        }

        public int[] getOffsetNumArr(Lyric lyric) {
            if (this.mLyricViewBefore.getWidth() <= 0) {
                return null;
            }
            CharSequence temp = this.mLyricViewBefore.getText();
            this.mLyricViewBefore.setText(MetaManager.UNKNOWN_STRING);
            int end = lyric.size() + 5;
            int[] ret = new int[((end - -5) + 1)];
            for (int i = -5; i < end; i++) {
                this.mLyricViewBefore.append(lyric.getLyricContent(i).lyric);
                ret[i - -5] = this.mLyricViewBefore.getLineCount() - 1;
            }
            this.mLyricViewBefore.setText(temp);
            return ret;
        }

        public void drawLyric(Lyric lyric, LyricShot lyricShot, int start, int end) {
            int i;
            this.mLyricBuilder.delete(0, this.mLyricBuilder.length());
            for (i = start; i < lyricShot.lineIndex; i++) {
                this.mLyricBuilder.append(lyric.getLyricContent(i).lyric);
            }
            if (this.mLyricBuilder.length() > 0) {
                this.mLyricBuilder.deleteCharAt(this.mLyricBuilder.length() - 1);
            }
            this.mLyricViewBefore.setText(this.mLyricBuilder.subSequence(0, this.mLyricBuilder.length()));
            CharSequence current = lyric.getLyricContent(lyricShot.lineIndex).lyric;
            if (current.length() > 0) {
                current = current.subSequence(0, current.length() - 1);
            }
            this.mLyricViewCurrent.setText(current);
            this.mLyricBuilder.delete(0, this.mLyricBuilder.length());
            for (i = lyricShot.lineIndex + 1; i < end; i++) {
                this.mLyricBuilder.append(lyric.getLyricContent(i).lyric);
            }
            this.mLyricViewAfter.setText(this.mLyricBuilder.subSequence(0, this.mLyricBuilder.length()));
        }

        public float getAccurateLineHeight() {
            return this.mLineExtraSpacing;
        }

        public void setHintText(CharSequence hint) {
            this.mLyricViewBefore.setText(hint);
            this.mLyricViewCurrent.setText(MetaManager.UNKNOWN_STRING);
            this.mLyricViewAfter.setText(MetaManager.UNKNOWN_STRING);
        }
    }

    class OnLyricScrollListener implements OnExtendScrollListener {
        OnLyricScrollListener() {
        }

        public void onScroll(int deltaScrollY) {
            if (LyricMovementController.this.mLyricStatus == 1) {
                LyricMovementController.this.mScrollView.setOnExtendScrollListener(null);
                LyricMovementController.this.onVerticalScroll(deltaScrollY);
                LyricMovementController.this.mScrollView.setOnExtendScrollListener(LyricMovementController.this.mLyricScrollListener);
            }
        }

        public void onTouchEventStart() {
            LyricMovementController.this.mLyricStatus = 1;
        }

        public void onTouchEventEnd() {
            if (!LyricMovementController.this.mHandler.hasMessages(1)) {
                LyricMovementController.this.mLyricStatus = 0;
            }
        }
    }

    class SlideAnimationListener implements AnimationListener {
        SlideAnimationListener() {
        }

        public void onAnimationEnd(Animation animation) {
            LyricMovementController.this.mLyricStatus = 0;
            LyricMovementController.this.mScrollView.setOnExtendScrollListener(LyricMovementController.this.mLyricScrollListener);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            LyricMovementController.this.mScrollView.setOnExtendScrollListener(null);
        }
    }

    public LyricMovementController(ExtendScrollView v) {
        this.mScrollView = v;
        this.mLyricScrollListener = new OnLyricScrollListener();
        this.mScrollView.setOnExtendScrollListener(this.mLyricScrollListener);
        this.mLyricView = new LyricView(this.mScrollView);
        this.mSlideAnimation = new VerticalSlideAnimation(this.mScrollView);
        this.mSlideAnimation.setDuration(1000);
        this.mSlideAnimation.setAnimationListener(new SlideAnimationListener());
    }

    public boolean onVerticalScroll(int deltaScrollY) {
        if (this.mLyricStatus == 0 && this.mLyric != null) {
            refreshLyric(this.mLastPosition, true);
        }
        if (this.mLyricMode != 1 || this.mLyric == null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 2000);
        } else {
            this.mOrginLastPosition = this.mLastPosition;
            lryicProgressModify(deltaScrollY);
        }
        return false;
    }

    public void setOnClickListener(OnClickListener l) {
        this.mScrollView.getChildAt(0).setOnClickListener(l);
    }

    private boolean lryicProgressModify(int deltaHeight) {
        if (deltaHeight == 0) {
            return false;
        }
        if (this.mOffsetLineNumArr == null && this.mLyric != null) {
            this.mOffsetLineNumArr = this.mLyricView.getOffsetNumArr(this.mLyric);
        }
        if (this.mOffsetLineNumArr == null) {
            return false;
        }
        LyricShot lyricShot = this.mLyric.getLyricShot(this.mOrginLastPosition);
        if (lyricShot.lineIndex < 0) {
            return false;
        }
        float lineHeight = this.mLyricView.getAccurateLineHeight();
        int lineIndex = lyricShot.lineIndex;
        float lastPercentHeight = (float) (((double) (((float) (this.mOffsetLineNumArr[lineIndex + 5] - this.mOffsetLineNumArr[(lineIndex - 1) + 5])) * lineHeight)) * lyricShot.percent);
        float nowPercentHeight = 0.0f;
        int offsetLine = 1;
        int i;
        if (deltaHeight > 0) {
            for (i = lyricShot.lineIndex; i >= 0; i--) {
                nowPercentHeight = ((((float) (this.mOffsetLineNumArr[(lyricShot.lineIndex - 1) + 5] - this.mOffsetLineNumArr[(i - 1) + 5])) * lineHeight) + lastPercentHeight) - ((float) deltaHeight);
                offsetLine = this.mOffsetLineNumArr[i + 5] - this.mOffsetLineNumArr[(i - 1) + 5];
                if (nowPercentHeight >= 0.0f && nowPercentHeight <= ((float) offsetLine) * lineHeight) {
                    lineIndex = i;
                    break;
                }
            }
            if (nowPercentHeight < 0.0f) {
                nowPercentHeight = 0.0f;
                lineIndex = 0;
            }
        } else {
            for (i = lyricShot.lineIndex; i < this.mOffsetLineNumArr.length - 5; i++) {
                nowPercentHeight = ((((float) (this.mOffsetLineNumArr[(lyricShot.lineIndex - 1) + 5] - this.mOffsetLineNumArr[(i - 1) + 5])) * lineHeight) + lastPercentHeight) - ((float) deltaHeight);
                offsetLine = this.mOffsetLineNumArr[i + 5] - this.mOffsetLineNumArr[(i - 1) + 5];
                if (nowPercentHeight >= 0.0f && nowPercentHeight <= ((float) offsetLine) * lineHeight) {
                    lineIndex = i;
                    break;
                }
            }
            if (nowPercentHeight < 0.0f) {
                nowPercentHeight = ((float) offsetLine) * lineHeight;
                lineIndex = this.mOffsetLineNumArr.length - 5;
            }
        }
        this.mLyric.correctLyric(lyricShot, lineIndex, (double) ((nowPercentHeight / lineHeight) / ((float) offsetLine)));
        refreshLyric(this.mOrginLastPosition, true);
        return true;
    }

    public void clearText() {
        if (this.mLyricView != null) {
            this.mLyricView.setHintText(MetaManager.UNKNOWN_STRING);
        }
    }

    public void resetLyric(Lyric lyric) {
        if (this.mLyric != lyric) {
            if (lyric != null) {
                lyric.decorate();
                this.mScrollView.reset();
            }
            this.mLyric = lyric;
            this.mOffsetLineNumArr = null;
        }
        this.mLastLyricLine = -1;
    }

    public void setLyricMode(int lryicMode) {
        this.mLyricMode = lryicMode;
        this.mScrollView.setNeedFling(this.mLyricMode == 0);
    }

    private boolean isPlaying() {
        return this.mLyricStatus == 0;
    }

    private void scrollLyric(int height) {
        this.mScrollView.scrollY(height);
    }

    public void refreshLyric(long pos) {
        if (isPlaying()) {
            refreshLyric(pos, false);
        }
    }

    void refreshLyric(long pos, boolean force) {
        if (this.mLyricView != null && this.mLyric != null) {
            this.mLastPosition = pos;
            if (OFFSET_LINE_DRAG < 0) {
                OFFSET_LINE_DRAG = (int) (((float) (((this.mScrollView.getHeight() - this.mScrollView.getPaddingTop()) - this.mScrollView.getPaddingBottom()) - getLyricNowplayingMarginTop())) / this.mLyricView.getAccurateLineHeight());
            }
            LyricShot lyricShot = this.mLyric.getLyricShot(pos);
            float lineHeight = this.mLyricView.getAccurateLineHeight();
            int endLine = this.mLyric.size();
            if (this.mLyricMode == 1) {
                endLine += OFFSET_LINE_DRAG;
            } else {
                endLine += 5;
            }
            if (force || lyricShot.lineIndex != this.mLastLyricLine || this.mLastLyricLine == -1) {
                this.mLastLyricLine = lyricShot.lineIndex;
                drawLyric(-5, endLine, lyricShot);
            }
            if (isPlaying()) {
                scrollLyric(getScrollOffset(lyricShot, 5, lineHeight));
            }
        }
    }

    int getScrollOffset(LyricShot lyricShot, int spaceLine, float lineHeight) {
        int relIndex = lyricShot.lineIndex;
        int absIndex = lyricShot.lineIndex + spaceLine;
        if (this.mOffsetLineNumArr == null || absIndex < 1 || absIndex >= this.mOffsetLineNumArr.length) {
            return (int) (((double) lineHeight) * (((double) relIndex) + lyricShot.percent));
        }
        return (int) ((((double) lineHeight) * (((double) (this.mOffsetLineNumArr[absIndex - 1] - spaceLine)) + (lyricShot.percent * ((double) (this.mOffsetLineNumArr[absIndex] - this.mOffsetLineNumArr[absIndex - 1]))))) + 0.5d);
    }

    private void drawLyric(int start, int end, LyricShot lyricShot) {
        if (this.mOffsetLineNumArr == null && this.mLyricStatus == 0 && this.mLyric != null) {
            this.mOffsetLineNumArr = this.mLyricView.getOffsetNumArr(this.mLyric);
        }
        this.mLyricView.drawLyric(this.mLyric, lyricShot, start, end);
    }

    public void setHighLightTextStyle(int sizeRes) {
        this.mLyricView.setHighLightTextStyle(sizeRes);
    }

    public void setNormalTextStyle(int sizeRes) {
        this.mLyricView.setNormalTextStyle(sizeRes);
    }

    public void setLineSpacing(int resId) {
        this.mLyricView.setLineSpacing(resId);
    }

    public int getLyricNowplayingMarginTop() {
        return (int) (this.mLyricView.getAccurateLineHeight() * 5.0f);
    }
}
