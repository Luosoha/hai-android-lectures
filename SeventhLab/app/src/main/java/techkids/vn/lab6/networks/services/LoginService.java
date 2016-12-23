package techkids.vn.lab6.networks.services;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.LoginResponseBody;

/**
 * Created by Lush on 12/18/2016.
 */

public interface LoginService {
    @POST("login")
    Call<LoginResponseBody> login(@Body RequestBody body);
}
