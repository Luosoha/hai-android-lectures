package techkids.vn.countdowntimer;

import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String MINS = "minutes";
    private static final String SECS = "seconds";

    private EditText etMinutes;
    private EditText etSeconds;
    private TextView tvTimer;
    private Button btStart;
    private Button btStop;

    private int min;
    private int sec;

    private CountDownTimer cTimer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            min = savedInstanceState.getInt(MINS, 0);
            sec = savedInstanceState.getInt(SECS, 0);
            startTimer();
        }

        getReferences();
        addListeners();
    }

    private void getReferences() {
        etMinutes = (EditText) findViewById(R.id.et_minutes);
        etSeconds = (EditText) findViewById(R.id.et_seconds);
        tvTimer = (TextView) findViewById(R.id.tv_timer);
        btStart = (Button) findViewById(R.id.bt_start);
        btStop = (Button) findViewById(R.id.bt_stop);
    }

    private void addListeners() {
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min = Integer.parseInt(etMinutes.getText().toString());
                sec = Integer.parseInt(etSeconds.getText().toString());

                startTimer();
            }
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
            }
        });
    }

    void startTimer() {
        if (cTimer != null) {
            cancelTimer();
            cTimer = null;
        }

        int time = min * 60 + sec;
        cTimer = new CountDownTimer(time * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(String.format("%2d : %2d", min, sec));
                sec--;
                if (sec <= 0) {
                    min--;
                    sec = 59;
                }
            }

            @Override
            public void onFinish() {

            }
        };
        cTimer.start();
    }

    void cancelTimer() {
        if (cTimer != null) {
            cTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("minutes", min);
        outState.putInt("seconds", sec);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startTimer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cancelTimer();
    }
}
