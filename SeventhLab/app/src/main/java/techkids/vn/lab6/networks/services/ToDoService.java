package techkids.vn.lab6.networks.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;

/**
 * Created by Lush on 12/18/2016.
 */

public interface ToDoService {
    @GET("todos")
    Call<List<ToDoResponseBody>> toDoList(@Header("token") String token);
}
