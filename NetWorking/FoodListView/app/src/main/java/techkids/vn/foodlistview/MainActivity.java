package techkids.vn.foodlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.lv_food_menu)
    ListView lvFoodMenu;

    private ArrayList<FoodItem> foodItems;
    private FoodAdapter foodAdapter;

    private String url = "https://a-server.herokuapp.com/api/food";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupUI();

        sendGET();
    }

    private void setupUI() {
        foodItems = new ArrayList<>();
        foodAdapter = new FoodAdapter(this, R.layout.list_item_food, foodItems);
        lvFoodMenu.setAdapter(foodAdapter);
    }

    private void sendGET() {
        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
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

                Gson gson = new Gson();
                FoodItem[] foodList = gson.fromJson(body, FoodItem[].class);

                for (FoodItem foodItem : foodList) {
                    Log.d(TAG, foodItem.toString());
                }

                foodItems.clear();
                foodItems.addAll(Arrays.asList(foodList));

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        foodAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
