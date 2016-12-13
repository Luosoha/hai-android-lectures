package techkids.vn.lab5.networks.services;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import techkids.vn.lab5.networks.jsonmodel.HairResponseBody;

/**
 * Created by Lush on 12/11/2016.
 */

public interface HairService {
    @POST("category/home")
    Call<HairResponseBody> hairCollection(@Body RequestBody body);
}
