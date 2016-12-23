package techkids.vn.lab6.networks.services;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import techkids.vn.lab6.networks.jsonmodels.requestmodels.CreateNoteRequestBody;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;

/**
 * Created by Lush on 12/20/2016.
 */

public interface CreateService {
    @POST("todos")
    Call<CreateNoteRequestBody[]> createToDo(@Header("token") String token, @Body RequestBody body);
}
