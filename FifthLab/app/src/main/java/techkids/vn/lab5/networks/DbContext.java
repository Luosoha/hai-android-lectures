package techkids.vn.lab5.networks;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import io.realm.Realm;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import techkids.vn.lab5.networks.jsonmodel.HairResponseBody;
import techkids.vn.lab5.networks.jsonmodel.HairStyle;
import techkids.vn.lab5.networks.services.HairService;

/**
 * Created by Lush on 12/11/2016.
 */

public class DbContext {

    public static final String TAG = DbContext.class.toString();
    public static final String BASE_URL = "http://api.30shine.com/";

    public static final Retrofit HAIR = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

//    public static HairResponseBody getHairCollection() {
//        HairService hairService = HAIR.create(HairService.class);
//
//        RequestBody requestBody = RequestBody.create(
//                MediaType.parse("application/json"),
//                ""
//        );
//
//        Call<HairResponseBody> response = hairService.hairCollection(requestBody);
//
//        response.enqueue(new Callback<HairResponseBody>() {
//            @Override
//            public void onResponse(Call<HairResponseBody> call, Response<HairResponseBody> response) {
//                Log.d(TAG, "onResponse");
//                hairResponseBody = response.body();
//                Log.d(TAG, hairResponseBody.toString());
//            }
//
//            @Override
//            public void onFailure(Call<HairResponseBody> call, Throwable t) {
//                Log.d(TAG, "onFailure");
//            }
//        });
//
//        return hairResponseBody;
//    }

    //--------------------------------------------------Realm------------------------------------------------------

    private Realm realm;

    private DbContext() {
        realm = Realm.getDefaultInstance();
    }

    public void insert(HairStyle hairStyle) {
        realm.beginTransaction();
        realm.copyToRealm(hairStyle);
        realm.commitTransaction();
    }

    public List<HairStyle> allHairs() {
        return realm.where(HairStyle.class).findAll();
    }

    public void delete(HairStyle hairStyle) {
        realm.beginTransaction();
        hairStyle.deleteFromRealm();
        realm.commitTransaction();
    }

    public void deleteAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    private static DbContext instance;

    public static DbContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        Realm.init(context);
        instance = new DbContext();
    }

}
