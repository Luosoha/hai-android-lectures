package techkids.vn.login.service;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import techkids.vn.login.jsonmodels.ServerResponse;

/**
 * Created by Lush on 12/9/2016.
 */

public interface UserService {
    @POST("login")
    Call<ServerResponse> serverResponse(@Body RequestBody body);
}
