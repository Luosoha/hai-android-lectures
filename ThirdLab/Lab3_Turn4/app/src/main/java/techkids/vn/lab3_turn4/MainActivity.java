package techkids.vn.lab3_turn4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import techkids.vn.lab3_turn4.json.models.ApiResponse;
import techkids.vn.lab3_turn4.json.models.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private String url = "https://a-server.herokuapp.com/api/register";

    @BindView(R.id.et_phone)
    EditText etPhone;

    @BindView(R.id.et_customer_name)
    EditText etCustomerName;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.et_date_of_birth)
    EditText etDateOfBirth;

    @BindView(R.id.et_month_of_birth)
    EditText etMonthOfBirth;

    @BindView(R.id.et_year_of_birth)
    EditText etYearOfBirth;

    @BindView(R.id.bt_submit)
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        sendPOST();
    }

    private void sendPOST() {
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = etPhone.getText().toString();
                String name = etCustomerName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                int date = 0, month = 0, year = 0;
                if (etDateOfBirth.getText().toString().length() > 0) {
                    date = Integer.parseInt(etDateOfBirth.getText().toString());
                }
                if (etMonthOfBirth.getText().toString().length() > 0) {
                    month = Integer.parseInt(etMonthOfBirth.getText().toString());
                }
                if (etYearOfBirth.getText().toString().length() > 0) {
                    year = Integer.parseInt(etYearOfBirth.getText().toString());
                }
                User user = new User(phone, name, email, password, date, month, year);
                Log.d(TAG, user.toString());

                OkHttpClient client = new OkHttpClient();

                MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                final Gson gson = new Gson();
                String data = gson.toJson(user);
                final RequestBody requestBody = RequestBody.create(JSON, data);

                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, String.format("POST onFailure: %s", e));
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String body = response.body().string();
                        Log.d(TAG, String.format("POST onResponse: %s ", body));

                        ApiResponse apiResponse = gson.fromJson(body, ApiResponse.class);

                        Log.d(TAG, apiResponse.toString());
                    }
                });
            }
        });
    }
}
