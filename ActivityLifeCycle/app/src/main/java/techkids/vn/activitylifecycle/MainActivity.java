package techkids.vn.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private TextView tvOnCreate;
    private TextView tvOnStart;
    private TextView tvOnRestart;
    private TextView tvOnResume;
    private TextView tvOnPause;
    private TextView tvOnStop;
    private TextView tvOnDestroy;
    private Button btGoToB;

    private int onCreateCount = 0;
    private int onStartCount = 0;
    private int onRestartCount = 0;
    private int onResumeCount = 0;
    private int onPauseCount = 0;
    private int onStopCount = 0;
    private int onDestroyCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        addListeners();

        onCreateCount++;
        Log.d(TAG, String.format("A onCreateCount: %s", onCreateCount));
        tvOnCreate.setText(String.format("onCreate: %s", onCreateCount));
    }

    private void getReferences() {
        tvOnCreate = (TextView) findViewById(R.id.tv_on_create);
        tvOnStart = (TextView) findViewById(R.id.tv_on_start);
        tvOnRestart = (TextView) findViewById(R.id.tv_on_restart);
        tvOnResume = (TextView) findViewById(R.id.tv_on_resume);
        tvOnPause = (TextView) findViewById(R.id.tv_on_pause);
        tvOnStop = (TextView) findViewById(R.id.tv_on_stop);
        tvOnDestroy = (TextView) findViewById(R.id.tv_on_destroy);
        btGoToB = (Button) findViewById(R.id.bt_go_to_activity_B);
    }

    private void addListeners() {
        btGoToB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityB.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        onStartCount++;
        Log.d(TAG, String.format("A onStartCount: %s", onStartCount));
        tvOnStart.setText(String.format("onStart: %s", onStartCount));
        super.onStart();
    }

    @Override
    protected void onRestart() {
        onRestartCount++;
        Log.d(TAG, String.format("A onRestartCount: %s", onRestartCount));
        tvOnRestart.setText(String.format("onRestart: %s", onRestartCount));
        super.onRestart();
    }

    @Override
    protected void onResume() {
        onResumeCount++;
        Log.d(TAG, String.format("A onResumeCount: %s", onResumeCount));
        tvOnResume.setText(String.format("onResume: %s", onResumeCount));
        super.onResume();
    }

    @Override
    protected void onPause() {
        onPauseCount++;
        Log.d(TAG, String.format("A onPauseCount: %s", onPauseCount));
        tvOnPause.setText(String.format("onPause: %s", onPauseCount));
        super.onPause();
    }

    @Override
    protected void onStop() {
        onStopCount++;
        Log.d(TAG, String.format("A onStopCount: %s", onStopCount));
        tvOnStop.setText(String.format("onStop: %s", onStopCount));
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        onDestroyCount++;
        Log.d(TAG, String.format("A onDestroyCount: %s", onDestroyCount));
        tvOnDestroy.setText(String.format("onDestroy: %s", onDestroyCount));
        super.onDestroy();
    }
}
