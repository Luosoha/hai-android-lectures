package techkids.vn.foodlistview;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import techkids.vn.foodlistview.jsonmodels.FoodItem;
import techkids.vn.foodlistview.service.FoodService;

/**
 * Created by Lush on 12/9/2016.
 */

public class DbContext {

    private static final String BASE_URL = "https://a-server.herokuapp.com/api/";

    public static final Retrofit FOOD = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<FoodItem[]> getFoodList() {
        return FOOD.create(FoodService.class).foodList();
    }

}
