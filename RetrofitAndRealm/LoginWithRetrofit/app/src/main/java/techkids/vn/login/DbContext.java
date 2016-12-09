package techkids.vn.login;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import techkids.vn.login.jsonmodels.ServerResponse;
import techkids.vn.login.jsonmodels.User;
import techkids.vn.login.service.UserService;

/**
 * Created by Lush on 12/9/2016.
 */

public class DbContext {

    private static final String TAG = DbContext.class.toString();

    private static ServerResponse serverResponse = new ServerResponse();

    public static final Retrofit LOGIN = new Retrofit.Builder()
            .baseUrl("https://a5-tumblelog.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ServerResponse getResponse(User user) {
        UserService userService = LOGIN.create(UserService.class);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                (new Gson()).toJson(user)
        );

        Call<ServerResponse> response = userService.serverResponse(requestBody);

        response.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                serverResponse = response.body();
                Log.d(TAG, String.format("onResponse: %s", serverResponse.getMessage()));
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });

        return serverResponse;
    }

}
