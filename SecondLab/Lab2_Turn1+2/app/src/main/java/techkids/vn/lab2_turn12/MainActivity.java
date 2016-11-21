package techkids.vn.lab2_turn12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.buttons_change_number) ChangeNumberButtons btChangeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        int value = btChangeNumber.getValue();
        btChangeNumber.setValue(value);
    }
}
