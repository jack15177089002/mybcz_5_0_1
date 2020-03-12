package com.baicizhan.client.wordlock.view.drag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;
import java.util.List;

public class DragController {
    public static int DRAG_ACTION_COPY = 1;
    public static int DRAG_ACTION_MOVE = 0;
    private static final boolean PROFILE_DRAWING_DURING_DRAG = false;
    private static final String TAG = "DragController";
    private Context mContext;
    private final int[] mCoordinatesTemp = new int[2];
    private DisplayMetrics mDisplayMetrics = new DisplayMetrics();
    private Object mDragInfo;
    private float mDragScale = 1.0f;
    private DragSource mDragSource;
    private DragView mDragView;
    private boolean mDragging;
    private ArrayList<DropTarget> mDropTargets = new ArrayList<>();
    private InputMethodManager mInputMethodManager;
    private DropTarget mLastDropTarget;
    private List<DragListener> mListeners = new ArrayList();
    private float mMotionDownX;
    private float mMotionDownY;
    private View mMoveTarget;
    private View mOriginator;
    private Rect mRectTemp = new Rect();
    private float mTouchOffsetX;
    private float mTouchOffsetY;
    private IBinder mWindowToken;

    interface DragListener {
        void onDragEnd();

        void onDragStart(DragSource dragSource, Object obj, int i);
    }

    public DragController(Context context) {
        this.mContext = context;
    }

    public void startDrag(View view, DragSource dragSource, Object obj, int i) {
        if (dragSource.allowDrag()) {
            this.mOriginator = view;
            Bitmap viewBitmap = getViewBitmap(view);
            if (viewBitmap != null) {
                int[] iArr = this.mCoordinatesTemp;
                view.getLocationOnScreen(iArr);
                startDrag(viewBitmap, iArr[0], iArr[1], 0, 0, viewBitmap.getWidth(), viewBitmap.getHeight(), dragSource, obj, i);
                viewBitmap.recycle();
                popAnim(view, this.mDragView, this.mDragScale);
            }
        }
    }

    private void popAnim(View view, final DragView dragView, float f) {
        view.setVisibility(4);
        dragView.setVisibility(4);
        dragView.setMovable(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, (float) (view.getWidth() / 2), (float) (view.getHeight() / 2));
        scaleAnimation.setDuration(25);
        scaleAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                dragView.setVisibility(0);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
        alphaAnimation.setDuration(35);
        alphaAnimation.setStartOffset(25);
        alphaAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                dragView.setMovable(true);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
    }

    public void startDrag(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, DragSource dragSource, Object obj, int i7) {
        if (this.mInputMethodManager == null) {
            this.mInputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        }
        this.mInputMethodManager.hideSoftInputFromWindow(this.mWindowToken, 0);
        for (DragListener onDragStart : this.mListeners) {
            onDragStart.onDragStart(dragSource, obj, i7);
        }
        int i8 = ((int) this.mMotionDownX) - i;
        int i9 = ((int) this.mMotionDownY) - i2;
        Log.d("whiz", "motionX: " + this.mMotionDownX + ", motionY: " + this.mMotionDownY + "; screenX: " + i + ", screenY: " + i2);
        this.mTouchOffsetX = this.mMotionDownX - ((float) i);
        this.mTouchOffsetY = this.mMotionDownY - ((float) i2);
        this.mDragging = true;
        this.mDragSource = dragSource;
        this.mDragInfo = obj;
        DragView dragView = new DragView(this.mContext, bitmap, i8, i9, i3, i4, i5, i6);
        this.mDragView = dragView;
        dragView.show(this.mWindowToken, (int) this.mMotionDownX, (int) this.mMotionDownY);
        this.mDragScale = dragView.getPopScale();
    }

    private Bitmap getViewBitmap(View view) {
        view.clearFocus();
        view.setPressed(false);
        boolean willNotCacheDrawing = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int drawingCacheBackgroundColor = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(0);
        if (drawingCacheBackgroundColor != 0) {
            view.destroyDrawingCache();
        }
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            Log.e(TAG, "failed getViewBitmap(" + view + ")", new RuntimeException());
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(willNotCacheDrawing);
        view.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
        return createBitmap;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mDragging;
    }

    public void cancelDrag() {
        endDrag();
    }

    private void endDrag() {
        if (this.mDragging || this.mDragView != null) {
            this.mDragging = false;
            if (this.mOriginator != null) {
                this.mOriginator.setVisibility(0);
            }
            for (DragListener onDragEnd : this.mListeners) {
                onDragEnd.onDragEnd();
            }
            if (this.mDragView != null) {
                this.mDragView.remove();
                this.mDragView = null;
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            recordScreenSize();
        }
        int clamp = clamp((int) motionEvent.getRawX(), 0, this.mDisplayMetrics.widthPixels);
        int clamp2 = clamp((int) motionEvent.getRawY(), 0, this.mDisplayMetrics.heightPixels);
        switch (action) {
            case 0:
                this.mMotionDownX = (float) clamp;
                this.mMotionDownY = (float) clamp2;
                this.mLastDropTarget = null;
                break;
            case 1:
            case 3:
                if (this.mDragging) {
                    drop((float) clamp, (float) clamp2);
                }
                endDrag();
                break;
        }
        return this.mDragging;
    }

    /* access modifiers changed from: 0000 */
    public void setMoveTarget(View view) {
        this.mMoveTarget = view;
    }

    public boolean dispatchUnhandledMove(View view, int i) {
        return this.mMoveTarget != null && this.mMoveTarget.dispatchUnhandledMove(view, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mDragging) {
            return false;
        }
        int action = motionEvent.getAction();
        int clamp = clamp((int) motionEvent.getRawX(), 0, this.mDisplayMetrics.widthPixels);
        int clamp2 = clamp((int) motionEvent.getRawY(), 0, this.mDisplayMetrics.heightPixels);
        switch (action) {
            case 0:
                this.mMotionDownX = (float) clamp;
                this.mMotionDownY = (float) clamp2;
                break;
            case 1:
                if (this.mDragging) {
                    drop((float) clamp, (float) clamp2);
                }
                endDrag();
                break;
            case 2:
                this.mDragView.move((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                Rect rectOnScreen = this.mDragView.getRectOnScreen();
                int[] iArr = this.mCoordinatesTemp;
                DropTarget findDropTarget = findDropTarget(clamp, clamp2, rectOnScreen, iArr);
                if (findDropTarget != null) {
                    if (this.mLastDropTarget == findDropTarget) {
                        findDropTarget.onDragOver(this.mDragSource, iArr[0], iArr[1], (int) this.mTouchOffsetX, (int) this.mTouchOffsetY, this.mDragView, this.mDragInfo);
                    } else {
                        if (this.mLastDropTarget != null) {
                            this.mLastDropTarget.onDragExit(this.mDragSource, iArr[0], iArr[1], (int) this.mTouchOffsetX, (int) this.mTouchOffsetY, this.mDragView, this.mDragInfo);
                        }
                        findDropTarget.onDragEnter(this.mDragSource, iArr[0], iArr[1], (int) this.mTouchOffsetX, (int) this.mTouchOffsetY, this.mDragView, this.mDragInfo);
                    }
                } else if (this.mLastDropTarget != null) {
                    this.mLastDropTarget.onDragExit(this.mDragSource, iArr[0], iArr[1], (int) this.mTouchOffsetX, (int) this.mTouchOffsetY, this.mDragView, this.mDragInfo);
                }
                this.mLastDropTarget = findDropTarget;
                break;
            case 3:
                cancelDrag();
                break;
        }
        return true;
    }

    private boolean drop(float f, float f2) {
        int[] iArr = this.mCoordinatesTemp;
        DropTarget findDropTarget = findDropTarget((int) f, (int) f2, this.mDragView.getRectOnScreen(), iArr);
        if (findDropTarget == null) {
            return false;
        }
        findDropTarget.onDragExit(this.mDragSource, iArr[0], iArr[1], (int) this.mTouchOffsetX, (int) this.mTouchOffsetY, this.mDragView, this.mDragInfo);
        if (findDropTarget.acceptDrop(this.mDragSource, iArr[0], iArr[1], (int) this.mTouchOffsetX, (int) this.mTouchOffsetY, this.mDragView, this.mDragInfo)) {
            findDropTarget.onDrop(this.mDragSource, iArr[0], iArr[1], (int) this.mTouchOffsetX, (int) this.mTouchOffsetY, this.mDragView, this.mDragInfo);
            this.mDragSource.onDropCompleted((View) findDropTarget, true);
            return true;
        }
        this.mDragSource.onDropCompleted((View) findDropTarget, false);
        return true;
    }

    private DropTarget findDropTarget(int i, int i2, Rect rect, int[] iArr) {
        Rect rect2 = this.mRectTemp;
        if (rect.isEmpty()) {
            rect.set(i, i2, i + 1, i2 + 1);
        }
        ArrayList<DropTarget> arrayList = this.mDropTargets;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DropTarget dropTarget = (DropTarget) arrayList.get(size);
            dropTarget.getHitRect(rect2);
            dropTarget.getLocationOnScreen(iArr);
            rect2.offset(iArr[0] - dropTarget.getLeft(), iArr[1] - dropTarget.getTop());
            if (rect2.intersects(rect.left, rect.top, rect.right, rect.bottom)) {
                iArr[0] = i - iArr[0];
                iArr[1] = i2 - iArr[1];
                return dropTarget;
            }
        }
        return null;
    }

    private void recordScreenSize() {
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.mDisplayMetrics);
    }

    private static int clamp(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i >= i3 ? i3 - 1 : i;
    }

    public void setWindowToken(IBinder iBinder) {
        this.mWindowToken = iBinder;
    }

    public void addDragListener(DragListener dragListener) {
        this.mListeners.add(dragListener);
    }

    public void removeDragListener(DragListener dragListener) {
        this.mListeners.remove(dragListener);
    }

    public void addDropTarget(DropTarget dropTarget) {
        this.mDropTargets.add(dropTarget);
    }

    public void removeDropTarget(DropTarget dropTarget) {
        this.mDropTargets.remove(dropTarget);
    }

    public float getDragScale() {
        return this.mDragScale;
    }
}
