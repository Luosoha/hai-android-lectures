package techkids.vn.dictionary;

import android.app.Application;
import android.util.Log;

import techkids.vn.dictionary.managers.DbHelper;

/**
 * Created by Lush on 11/17/2016.
 */

public class DictionaryApplication extends Application {

    private static final String TAG = DictionaryApplication.class.toString();

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
        DbHelper.init(this);
    }
}
