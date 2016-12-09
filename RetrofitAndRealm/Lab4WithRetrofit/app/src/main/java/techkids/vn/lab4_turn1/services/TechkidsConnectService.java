package techkids.vn.lab4_turn1.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import techkids.vn.lab4_turn1.models.TechkidsConnectList;

/**
 * Created by Lush on 12/9/2016.
 */

public interface TechkidsConnectService {
    @GET("company")
    Call<TechkidsConnectList> listCompany();
}
