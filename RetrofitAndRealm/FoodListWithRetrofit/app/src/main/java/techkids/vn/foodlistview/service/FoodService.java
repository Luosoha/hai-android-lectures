package techkids.vn.foodlistview.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import techkids.vn.foodlistview.jsonmodels.FoodItem;

/**
 * Created by Lush on 12/9/2016.
 */

public interface FoodService {
    @GET("food")
    Call<FoodItem[]> foodList();
}
