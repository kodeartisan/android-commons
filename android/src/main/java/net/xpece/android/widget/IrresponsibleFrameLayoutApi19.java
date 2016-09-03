package net.xpece.android.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

/**
 * FrameLayout that doesn't consume window insets.
 * Ideal as fragment container.
 * Do not use as top level container. Anything extending FrameLayout is ignored.
 * Fixed for API 19.
 */
public class IrresponsibleFrameLayoutApi19 extends FrameLayout {
    public IrresponsibleFrameLayoutApi19(Context context) {
        super(context);
    }

    public IrresponsibleFrameLayoutApi19(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IrresponsibleFrameLayoutApi19(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IrresponsibleFrameLayoutApi19(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @TargetApi(21)
    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        return insets;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected boolean fitSystemWindows(final Rect insets) {
        if (Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20) {
            boolean done = false;
            final int count = getChildCount();
            for (int i = 0; i < count; i++) {
                final View child = getChildAt(i);
//                done = child.fitSystemWindows(insets);
                done = ViewUtils.fitSystemWindows(child, insets);
                if (done) {
                    break;
                }
            }
            return done;
        } else {
            return super.fitSystemWindows(insets);
        }
    }
}
