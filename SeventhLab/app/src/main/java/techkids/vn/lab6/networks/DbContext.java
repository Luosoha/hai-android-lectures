package techkids.vn.lab6.networks;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import techkids.vn.lab6.managers.Preferences;
import techkids.vn.lab6.networks.jsonmodels.requestmodels.CreateNoteRequestBody;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;
import techkids.vn.lab6.networks.services.CreateService;
import techkids.vn.lab6.networks.services.ToDoService;

/**
 * Created by Lush on 12/18/2016.
 */

public class DbContext {

    public static final Retrofit ASERVER = new Retrofit.Builder()
            .baseUrl("http://a-server.herokuapp.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final String TAG = DbContext.class.toString();

    public static Call<List<ToDoResponseBody>> getToDoList(String token) {
        return ASERVER.create(ToDoService.class).toDoList(token);
    }

    public static void createNote(CreateNoteRequestBody createNoteRequestBody) {
        final CreateNoteRequestBody[] responseBody = {null};
        CreateService createService = ASERVER.create(CreateService.class);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                (new Gson()).toJson(createNoteRequestBody)
        );

        Call<CreateNoteRequestBody[]> create = createService.createToDo(Preferences.getInstance().getToken(), requestBody);

        create.enqueue(new Callback<CreateNoteRequestBody[]>() {
            @Override
            public void onResponse(Call<CreateNoteRequestBody[]> call, Response<CreateNoteRequestBody[]> response) {
                Log.d(TAG, "onResponse");
                Log.d(TAG, response.body()[0].toString());
            }

            @Override
            public void onFailure(Call<CreateNoteRequestBody[]> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });
    }

}
