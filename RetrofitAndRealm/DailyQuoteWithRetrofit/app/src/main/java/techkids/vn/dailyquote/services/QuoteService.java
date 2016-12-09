package techkids.vn.dailyquote.services;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import techkids.vn.dailyquote.models.Quote;

/**
 * Created by Lush on 12/9/2016.
 */

public interface QuoteService {
    @GET("posts?filter[orderby]=rand&filter[posts_per_page]=1")
    Call<List<Quote>> quote();
}
