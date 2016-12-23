package techkids.vn.lab6;

import android.app.Application;
import android.content.SharedPreferences;

import techkids.vn.lab6.managers.Preferences;

/**
 * Created by Lush on 12/18/2016.
 */

public class NoteApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Preferences.init(this);
    }
}
