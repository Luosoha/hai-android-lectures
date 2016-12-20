package techkids.vn.lab6.networks;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import techkids.vn.lab6.networks.jsonmodels.RegisterResponseBody;
import techkids.vn.lab6.networks.jsonmodels.ToDoResponseBody;
import techkids.vn.lab6.networks.services.RegisterService;
import techkids.vn.lab6.networks.services.ToDoService;

/**
 * Created by Lush on 12/18/2016.
 */

public class DbContext {

    public static final Retrofit ASERVER = new Retrofit.Builder()
            .baseUrl("http://a-server.herokuapp.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<List<ToDoResponseBody>> getToDoList(String token) {
        return ASERVER.create(ToDoService.class).toDoList(token);
    }

}
