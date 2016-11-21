package techkids.vn.lab2_turn5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.dsb_custom)
    DiscreteSeekBar dsbCustom;

    @BindView(R.id.tv_value)
    TextView tvValue;

    @BindView(R.id.bt_test)
    Button btTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        addListeners();
    }

    private void addListeners() {
        dsbCustom.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                tvValue.setText(String.format("%s", value));
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dsbProgess = dsbCustom.getProgress();
                dsbCustom.setProgress(dsbProgess + 5);
                tvValue.setText(String.format("%s", (dsbProgess + 5)));
            }
        });
    }
}
