package techkids.vn.lab6.networks.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import techkids.vn.lab6.networks.jsonmodels.ToDoResponseBody;

/**
 * Created by Lush on 12/18/2016.
 */

public interface ToDoService {
    @GET("todos")
    Call<List<ToDoResponseBody>> toDoList(@Header("token") String token);
}
