package techkids.vn.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private EditText etWeight;
    private EditText etHeight;
    private TextView tvResult;
    private Button btCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getReferences();
        addListeners();
    }

    private void addListeners() {
        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight = Double.parseDouble(etWeight.getText().toString());
                double height = Double.parseDouble(etHeight.getText().toString());
                double bmi = weight * 100 * 100 / (height * height);
                String res;
                if (bmi < 16) {
                    res = String.format("Your BMI is %.1f, severely underweight", bmi);
                }
                else if (bmi < 18.5) {
                    res = String.format("Your BMI is %.1f, underweight", bmi);
                }
                else if (bmi < 25) {
                    res = String.format("Your BMI is %.1f, normal", bmi);
                }
                else if (bmi < 30) {
                    res = String.format("Your BMI is %.1f, overweight", bmi);
                }
                else {
                    res = String.format("Your BMI is %.1f, obese", bmi);
                }

                String sayHello = String.format(res);

                tvResult.setText(sayHello);
            }
        });
    }

    public void getReferences() {
        etWeight = (EditText) findViewById(R.id.et_weight);
        etHeight = (EditText) findViewById(R.id.et_height);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btCalculate = (Button) findViewById(R.id.bt_calculate_BMI);
    }

}
