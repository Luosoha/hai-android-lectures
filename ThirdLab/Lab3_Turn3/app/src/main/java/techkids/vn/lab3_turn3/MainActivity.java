package techkids.vn.lab3_turn3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import techkids.vn.lab3_turn3.adapter.HairAdapter;
import techkids.vn.lab3_turn3.json.models.HairCollection;
import techkids.vn.lab3_turn3.json.models.HairStyle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private String url = "http://a-server.herokuapp.com/api/hairstyle";

    @BindView(R.id.lv_hair_menu)
    ListView lvHairMenu;

    private ArrayList<HairStyle> hairStyleItems;
    private HairAdapter hairAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupUI();

        sendGET();
    }

    private void setupUI() {
        hairStyleItems = new ArrayList<>();
        hairAdapter = new HairAdapter(this, R.layout.list_item_hair, hairStyleItems);
        lvHairMenu.setAdapter(hairAdapter);
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
                Log.d(TAG, body);

                Gson gson = new Gson();
                HairCollection hairStyles = gson.fromJson(body, HairCollection.class);

                Log.d(TAG, hairStyles.toString());

                hairStyleItems.clear();
                hairStyleItems.addAll(Arrays.asList(hairStyles.getHairs()));

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hairAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
