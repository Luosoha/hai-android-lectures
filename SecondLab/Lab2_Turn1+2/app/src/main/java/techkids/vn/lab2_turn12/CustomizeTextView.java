package techkids.vn.lab2_turn12;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lush on 11/20/2016.
 */

public class CustomizeTextView extends TextView {
    public CustomizeTextView(Context context) {
        super(context);
    }

    public CustomizeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomizeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
