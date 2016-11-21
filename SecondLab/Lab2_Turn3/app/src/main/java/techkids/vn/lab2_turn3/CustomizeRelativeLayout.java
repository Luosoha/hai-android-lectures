package techkids.vn.lab2_turn3;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Lush on 11/20/2016.
 */

public class CustomizeRelativeLayout extends RelativeLayout {
    public CustomizeRelativeLayout(Context context) {
        super(context);
    }

    public CustomizeRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomizeRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int newWidthSize = widthSize / 2;
        int newWidthMode = MeasureSpec.EXACTLY;

        int newWidthSpec = MeasureSpec.makeMeasureSpec(newWidthSize, newWidthMode);

        super.onMeasure(newWidthSpec, heightMeasureSpec);
    }
}
