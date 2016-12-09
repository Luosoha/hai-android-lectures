package techkids.vn.lab3_turn3;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import techkids.vn.lab3_turn3.json.models.HairCollection;
import techkids.vn.lab3_turn3.service.HairService;

/**
 * Created by Lush on 12/9/2016.
 */

public class DbContext {

    private static final String BASE_URL = "http://a-server.herokuapp.com/api/";

    public static final Retrofit FOOD = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<HairCollection> getHairCollection() {
        return FOOD.create(HairService.class).hairCollection();
    }

}
