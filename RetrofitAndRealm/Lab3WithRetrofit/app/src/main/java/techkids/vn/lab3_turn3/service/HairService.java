package techkids.vn.lab3_turn3.service;

import retrofit2.Call;
import retrofit2.http.GET;
import techkids.vn.lab3_turn3.json.models.HairCollection;

/**
 * Created by Lush on 12/9/2016.
 */

public interface HairService {
    @GET("hairstyle")
    Call<HairCollection> hairCollection();
}
