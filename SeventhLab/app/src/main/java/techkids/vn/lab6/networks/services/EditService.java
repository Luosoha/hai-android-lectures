package techkids.vn.lab6.networks.services;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;

/**
 * Created by Lush on 12/25/2016.
 */

public interface EditService {
    @PUT("todos/{id}")
    Call<ToDoResponseBody> editToDo(@Path("id") String id, @Header("token") String token, @Body RequestBody body);
}
