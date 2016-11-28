package techkids.vn.lab3_turn2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import techkids.vn.lab3_turn2.json.models.Branch;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private String url = "http://a-server.herokuapp.com/api/salon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendGET();
    }

    private void sendGET() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, String.format("onFailure: %s", e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, String.format("onResponse %s", body));

                Gson gson = new Gson();
                Branch branch = gson.fromJson(body, Branch.class);

                Log.d(TAG, branch.toString());
            }
        });
    }
}
