package techkids.vn.dailyquote;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import techkids.vn.dailyquote.models.Quote;
import techkids.vn.dailyquote.services.QuoteService;

/**
 * Created by Lush on 12/9/2016.
 */

public class DbContext {

    public static final Retrofit QUOTE = new Retrofit.Builder()
            .baseUrl("http://quotesondesign.com/wp-json/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<List<Quote>> getQuote() {
        return QUOTE.create(QuoteService.class)
                .quote();
    }

}
