package techkids.vn.music.managers;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import techkids.vn.music.networks.json_models.SongCategoryResponse;
import techkids.vn.music.networks.services.AlbumTypeService;

/**
 * Created by Lush on 1/8/2017.
 */

public class RetrofitContext {

    public static final Retrofit RSS_ITUNE = new Retrofit.Builder()
            .baseUrl("https://rss.itunes.apple.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<List<SongCategoryResponse>> getAlbumTypes() {
        return RSS_ITUNE.create(AlbumTypeService.class).getAlbumTypes();
    }

}
