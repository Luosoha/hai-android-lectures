package techkids.vn.lab6.networks.services;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import techkids.vn.lab6.networks.jsonmodels.RegisterResponseBody;

/**
 * Created by Lush on 12/18/2016.
 */

public interface RegisterService {
    @POST("register")
    Call<RegisterResponseBody> register(@Body RequestBody body);
}
