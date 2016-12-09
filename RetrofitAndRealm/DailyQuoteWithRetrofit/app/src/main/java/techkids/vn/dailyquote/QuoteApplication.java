package techkids.vn.dailyquote;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import techkids.vn.dailyquote.managers.Preferences;

/**
 * Created by Lush on 12/3/2016.
 */

public class QuoteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initImageLoader();
        Preferences.init(this);
    }


    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }

}
