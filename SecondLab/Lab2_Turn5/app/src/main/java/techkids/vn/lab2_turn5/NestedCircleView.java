package techkids.vn.lab2_turn5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lush on 11/21/2016.
 */

public class NestedCircleView extends View {

    private int color;

    public NestedCircleView(Context context) {
        super(context);
        initFrom(context, null);
    }

    public NestedCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFrom(context, attrs);
    }

    public NestedCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFrom(context, attrs);
    }

    private void initFrom(Context context, AttributeSet attrs) {
        if (attrs != null) {
            // 1:
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NestedCircleView);

            // 2:
            color = typedArray.getColor(R.styleable.NestedCircleView_circle_color, -1);

            // 3:
            typedArray.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(color);
        canvas.drawOval(0, 0, getWidth(), getHeight(), p);
    }
}
