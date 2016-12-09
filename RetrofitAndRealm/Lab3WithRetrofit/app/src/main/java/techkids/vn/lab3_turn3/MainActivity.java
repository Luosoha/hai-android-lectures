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
        DbContext.getHairCollection().enqueue(new retrofit2.Callback<HairCollection>() {
            @Override
            public void onResponse(retrofit2.Call<HairCollection> call, retrofit2.Response<HairCollection> response) {
                Log.d(TAG, "onResponse");

                HairCollection hairStyles = response.body();

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

            @Override
            public void onFailure(retrofit2.Call<HairCollection> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}
