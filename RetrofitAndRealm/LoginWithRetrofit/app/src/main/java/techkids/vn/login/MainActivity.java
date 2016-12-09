package techkids.vn.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import techkids.vn.login.jsonmodels.ServerResponse;
import techkids.vn.login.jsonmodels.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.et_user_name)
    EditText etUsername;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.bt_login)
    Button btLogin;

    private String url = "https://a5-tumblelog.herokuapp.com/api/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_login)
    public void onClick() {
        Log.d(TAG, "btLogin onClick");

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        final User user = new User(username, password);

        final ServerResponse serverResponse = DbContext.getResponse(user);

        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
