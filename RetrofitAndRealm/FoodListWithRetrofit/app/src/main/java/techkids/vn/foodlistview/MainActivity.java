package techkids.vn.foodlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techkids.vn.foodlistview.adapter.FoodAdapter;
import techkids.vn.foodlistview.jsonmodels.FoodItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.lv_food_menu)
    ListView lvFoodMenu;

    private ArrayList<FoodItem> foodItems;
    private FoodAdapter foodAdapter;

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
        DbContext.getFoodList().enqueue(new Callback<FoodItem[]>() {
            @Override
            public void onResponse(Call<FoodItem[]> call, Response<FoodItem[]> response) {
                Log.d(TAG, "onResponse");

                FoodItem[] foodList = response.body();

                foodItems.clear();
                foodItems.addAll(Arrays.asList(foodList));

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        foodAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onFailure(Call<FoodItem[]> call, Throwable t) {

            }
        });
    }
}
