package techkids.vn.lab6.networks.services;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import techkids.vn.lab6.networks.jsonmodels.requestmodels.ActionOnNoteRequestBody;

/**
 * Created by Lush on 12/20/2016.
 */

public interface CreateService {
    @POST("todos")
    Call<ActionOnNoteRequestBody[]> createToDo(@Header("token") String token, @Body RequestBody body);
}
