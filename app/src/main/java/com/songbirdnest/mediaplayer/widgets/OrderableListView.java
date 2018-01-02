package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.songbirdnest.mediaplayer.C0116R;

public class OrderableListView extends ListView {
    private static final int DRAG_VIEW_OPACITY = 229;
    private static final int FLING = 0;
    private static final int SLIDE = 1;
    private static final int TRASH = 2;
    private Bitmap mDragBitmap;
    private DragListener mDragListener;
    private int mDragPointX;
    private int mDragPointY;
    private int mDragPos;
    private ImageView mDragView;
    private DropListener mDropListener;
    private GestureDetector mGestureDetector;
    private int mHeight;
    private int mItemHeightHalf;
    private int mItemHeightNormal;
    private int mLowerBound;
    private RemoveListener mRemoveListener;
    private int mRemoveMode = -1;
    private int mSrcDragPos;
    private Rect mTempRect = new Rect();
    private final int mTouchSlop;
    private Drawable mTrashcan;
    private int mUpperBound;
    private WindowManager mWindowManager;
    private LayoutParams mWindowParams;
    private int mXOffset;
    private int mYOffset;

    public interface DropListener {
        void drop(int i, int i2);
    }

    public interface DragListener {
        void drag(int i, int i2);
    }

    class C04491 extends SimpleOnGestureListener {
        C04491() {
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (OrderableListView.this.mDragView == null) {
                return false;
            }
            if (velocityX <= 1000.0f) {
                return true;
            }
            Rect r = OrderableListView.this.mTempRect;
            OrderableListView.this.mDragView.getDrawingRect(r);
            if (e2.getX() <= ((float) ((r.right * 2) / 3))) {
                return true;
            }
            OrderableListView.this.stopDragging();
            OrderableListView.this.mRemoveListener.remove(OrderableListView.this.mSrcDragPos);
            OrderableListView.this.unExpandViews(true);
            return true;
        }
    }

    public interface RemoveListener {
        void remove(int i);
    }

    public OrderableListView(Context context) {
        super(context);
        this.mRemoveMode = context.getSharedPreferences("Music", 3).getInt("deletemode", -1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mItemHeightNormal = -1;
        this.mItemHeightHalf = -1;
    }

    public OrderableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRemoveMode = context.getSharedPreferences("Music", 3).getInt("deletemode", -1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mItemHeightNormal = -1;
        this.mItemHeightHalf = -1;
    }

    public OrderableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mRemoveMode = context.getSharedPreferences("Music", 3).getInt("deletemode", -1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mItemHeightNormal = -1;
        this.mItemHeightHalf = -1;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.mRemoveListener != null && this.mGestureDetector == null && this.mRemoveMode == 0) {
            this.mGestureDetector = new GestureDetector(getContext(), new C04491());
        }
        if (!(this.mDragListener == null && this.mDropListener == null)) {
            switch (ev.getAction()) {
                case 0:
                    int x = (int) ev.getX();
                    int y = (int) ev.getY();
                    int itemnum = pointToPosition(x, y);
                    if (itemnum != -1 && itemnum >= getHeaderViewsCount()) {
                        ViewGroup item = (ViewGroup) getChildAt(itemnum - getFirstVisiblePosition());
                        if (this.mItemHeightNormal == -1) {
                            this.mItemHeightNormal = item.getHeight();
                            this.mItemHeightHalf = this.mItemHeightNormal / 2;
                        }
                        this.mDragPointX = x - item.getLeft();
                        this.mDragPointY = y - item.getTop();
                        this.mXOffset = ((int) ev.getRawX()) - x;
                        this.mYOffset = ((int) ev.getRawY()) - y;
                        if (x >= 86) {
                            stopDragging();
                            break;
                        }
                        Drawable resortGrabberDefault = getResources().getDrawable(C0116R.drawable.resort_grabber_default);
                        Drawable resortGrabberPressed = getResources().getDrawable(C0116R.drawable.resort_grabber_pressed);
                        Drawable itemBackground = getResources().getDrawable(C0116R.drawable.list_item_resort_background);
                        Drawable originalItemBackground = item.getBackground();
                        View topLineEdge = item.findViewById(C0116R.id.playlist_detail_top_reorder_edge);
                        View bottomLineEdge = item.findViewById(C0116R.id.playlist_detail_bottom_reorder_edge);
                        ImageView resortGrabber = (ImageView) item.findViewById(C0116R.id.playlist_detail_dragger);
                        resortGrabber.setImageDrawable(resortGrabberPressed);
                        item.setBackgroundDrawable(itemBackground);
                        topLineEdge.setVisibility(0);
                        bottomLineEdge.setVisibility(0);
                        item.setDrawingCacheEnabled(true);
                        Bitmap bitmap = Bitmap.createBitmap(item.getDrawingCache());
                        resortGrabber.setImageDrawable(resortGrabberDefault);
                        item.setBackgroundDrawable(originalItemBackground);
                        topLineEdge.setVisibility(4);
                        bottomLineEdge.setVisibility(4);
                        startDragging(bitmap, x, y);
                        this.mDragPos = itemnum;
                        this.mSrcDragPos = this.mDragPos;
                        this.mHeight = getHeight();
                        int touchSlop = this.mTouchSlop;
                        this.mUpperBound = Math.min(y - touchSlop, this.mHeight / 3);
                        this.mLowerBound = Math.max(y + touchSlop, (this.mHeight * 2) / 3);
                        return false;
                    }
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    private int myPointToPosition(int x, int y) {
        if (y < 0) {
            int pos = myPointToPosition(x, this.mItemHeightNormal + y);
            if (pos > 0) {
                return pos - 1;
            }
        }
        Rect frame = this.mTempRect;
        for (int i = getChildCount() - 1; i >= 0; i--) {
            getChildAt(i).getHitRect(frame);
            if (frame.contains(x, y)) {
                return getFirstVisiblePosition() + i;
            }
        }
        return -1;
    }

    private int getItemForPosition(int y) {
        int adjustedy = (y - this.mDragPointY) - this.mItemHeightHalf;
        int pos = myPointToPosition(0, adjustedy);
        if (pos >= 0) {
            return pos + 1;
        }
        if (adjustedy < 0) {
            return 0;
        }
        return pos;
    }

    private void adjustScrollBounds(int y) {
        if (y >= this.mHeight / 3) {
            this.mUpperBound = this.mHeight / 3;
        }
        if (y <= (this.mHeight * 2) / 3) {
            this.mLowerBound = (this.mHeight * 2) / 3;
        }
    }

    private void unExpandViews(boolean deletion) {
        int i = 0;
        while (true) {
            View v = getChildAt(i);
            if (v == null) {
                if (deletion) {
                    int position = getFirstVisiblePosition();
                    int y = getChildAt(0).getTop();
                    setAdapter(getAdapter());
                    setSelectionFromTop(position, y);
                }
                try {
                    layoutChildren();
                    v = getChildAt(i);
                } catch (IllegalStateException e) {
                }
                if (v == null) {
                    return;
                }
            }
            v.setLayoutParams(v.getLayoutParams());
            v.setVisibility(0);
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (this.mGestureDetector != null) {
            this.mGestureDetector.onTouchEvent(ev);
        }
        if ((this.mDragListener == null && this.mDropListener == null) || this.mDragView == null) {
            return super.onTouchEvent(ev);
        }
        int action = ev.getAction();
        int numheaders;
        switch (action) {
            case 0:
            case 2:
                int y = (int) ev.getY();
                dragView((int) ev.getX(), y);
                int itemnum = getItemForPosition(y);
                if (itemnum >= 0) {
                    if (action == 0 || itemnum != this.mDragPos) {
                        numheaders = getHeaderViewsCount();
                        if (this.mDragListener != null && this.mDragPos >= numheaders && this.mDragPos < getCount()) {
                            this.mDragListener.drag(this.mDragPos - numheaders, itemnum - numheaders);
                        }
                        this.mDragPos = itemnum;
                    }
                    int speed = 0;
                    adjustScrollBounds(y);
                    if (y > this.mLowerBound) {
                        speed = getLastVisiblePosition() < getCount() + -1 ? y > (this.mHeight + this.mLowerBound) / 2 ? 16 : 4 : 0;
                    } else if (y < this.mUpperBound) {
                        speed = y < this.mUpperBound / 2 ? -16 : -4;
                        if (getFirstVisiblePosition() == 0 && getChildAt(0).getTop() >= getPaddingTop()) {
                            speed = 0;
                        }
                    }
                    if (speed != 0) {
                        doSmoothScroll(speed, 30);
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                Rect r = this.mTempRect;
                this.mDragView.getDrawingRect(r);
                stopDragging();
                if (this.mRemoveMode == 1 && ev.getX() > ((float) ((r.right * 3) / 4))) {
                    if (this.mRemoveListener != null) {
                        this.mRemoveListener.remove(this.mSrcDragPos);
                    }
                    unExpandViews(true);
                    break;
                }
                numheaders = getHeaderViewsCount();
                if (this.mDropListener != null) {
                    this.mDragPos = this.mDragPos >= numheaders ? this.mDragPos : numheaders;
                    this.mDragPos = this.mDragPos < getCount() ? this.mDragPos : getCount() - 1;
                    this.mDropListener.drop(this.mSrcDragPos - numheaders, this.mDragPos - numheaders);
                }
                unExpandViews(false);
                break;
                break;
        }
        return true;
    }

    private void startDragging(Bitmap bm, int x, int y) {
        stopDragging();
        this.mWindowParams = new LayoutParams();
        this.mWindowParams.gravity = 51;
        this.mWindowParams.x = (x - this.mDragPointX) + this.mXOffset;
        this.mWindowParams.y = (y - this.mDragPointY) + this.mYOffset;
        this.mWindowParams.height = -2;
        this.mWindowParams.width = -2;
        this.mWindowParams.flags = 920;
        this.mWindowParams.format = -3;
        this.mWindowParams.windowAnimations = 0;
        Context context = getContext();
        ImageView v = new ImageView(context);
        v.setPadding(0, 0, 0, 0);
        v.setImageBitmap(bm);
        v.setAlpha(DRAG_VIEW_OPACITY);
        this.mDragBitmap = bm;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mWindowManager.addView(v, this.mWindowParams);
        this.mDragView = v;
    }

    private void dragView(int x, int y) {
        int width;
        if (this.mRemoveMode == 1) {
            float alpha = 1.0f;
            width = this.mDragView.getWidth();
            if (x > width / 2) {
                alpha = ((float) (width - x)) / ((float) (width / 2));
            }
            this.mWindowParams.alpha = alpha;
        }
        if (this.mRemoveMode == 0 || this.mRemoveMode == 2) {
            this.mWindowParams.x = (x - this.mDragPointX) + this.mXOffset;
        } else {
            this.mWindowParams.x = 0;
        }
        this.mWindowParams.y = (y - this.mDragPointY) + this.mYOffset;
        this.mWindowManager.updateViewLayout(this.mDragView, this.mWindowParams);
        if (this.mTrashcan != null) {
            width = this.mDragView.getWidth();
            if (y > (getHeight() * 3) / 4) {
                this.mTrashcan.setLevel(2);
            } else if (width <= 0 || x <= width / 4) {
                this.mTrashcan.setLevel(0);
            } else {
                this.mTrashcan.setLevel(1);
            }
        }
    }

    private void stopDragging() {
        if (this.mDragView != null) {
            this.mDragView.setVisibility(8);
            ((WindowManager) getContext().getSystemService("window")).removeView(this.mDragView);
            this.mDragView.setImageDrawable(null);
            this.mDragView = null;
        }
        if (this.mDragBitmap != null) {
            this.mDragBitmap.recycle();
            this.mDragBitmap = null;
        }
        if (this.mTrashcan != null) {
            this.mTrashcan.setLevel(0);
        }
    }

    public void setTrashcan(Drawable trash) {
        this.mTrashcan = trash;
        this.mRemoveMode = 2;
    }

    public void setDragListener(DragListener l) {
        this.mDragListener = l;
    }

    public void setDropListener(DropListener l) {
        this.mDropListener = l;
    }

    public void setRemoveListener(RemoveListener l) {
        this.mRemoveListener = l;
    }
}
