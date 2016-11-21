package techkids.vn.lab2_turn12;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lush on 11/20/2016.
 */

public class ChangeNumberButtons extends LinearLayout {

    private static final String TAG = ChangeNumberButtons.class.toString();
    private int value;

    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_decrease)
    ImageView ivDecrease;
    @BindView(R.id.tv_value)
    TextView tvValue;
    @BindView(R.id.tv_label)
    TextView tvLabel;

    public ChangeNumberButtons(Context context) {
        super(context);
        initFromContext(context, null);
    }

    public ChangeNumberButtons(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context, attrs);
    }

    public ChangeNumberButtons(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context, attrs);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        updateUI();
    }

    private void updateUI() {
        tvValue.setText(String.format("%s", value));
    }

    private void addListeners() {
        ivAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                value = Integer.parseInt((String) tvValue.getText());
                value++;
                tvValue.setText(String.format("%s", value));
            }
        });

        ivDecrease.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                value = Integer.parseInt((String) tvValue.getText());
                value--;
                tvValue.setText(String.format("%s", value));
            }
        });
    }

//    private void initFromContext(Context context) {
//        View rootView = inflate(context, R.layout.change_number_buttons, this);
//        ButterKnife.bind(this, rootView);
//
//        updateUI();
//        addListeners();
//    }

    private void initFromContext(Context context, AttributeSet attrs) {
        View rootView = inflate(context, R.layout.change_number_buttons, this);
        ButterKnife.bind(this, rootView);

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ChangeNumberButtons);
            int value = typedArray.getInt(R.styleable.ChangeNumberButtons_value, -1);
            String label = typedArray.getString(R.styleable.ChangeNumberButtons_label);
            typedArray.recycle();
            this.value = value;

            Log.d(TAG, String.format("Value = %s", value));



            tvValue.setText(String.format("%s", this.value));
            tvLabel.setText(label);

        }

        updateUI();
        addListeners();
    }
}
