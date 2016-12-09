package techkids.vn.lab4_turn1;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import techkids.vn.lab4_turn1.models.TechkidsConnectList;
import techkids.vn.lab4_turn1.services.TechkidsConnectService;

/**
 * Created by Lush on 12/9/2016.
 */

public class DbContext {

    public static final Retrofit COMPANY = new Retrofit.Builder()
            .baseUrl("https://a-server.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<TechkidsConnectList> getCompanies() {
        return COMPANY.create(TechkidsConnectService.class).listCompany();
    }

}
