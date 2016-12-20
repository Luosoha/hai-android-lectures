package techkids.vn.lab6.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lush on 12/18/2016.
 */

public class Preferences {
    private static final String KEY = "Note";
    private static final String TOKEN_KEY = "Token";

    private SharedPreferences sharedPreferences;

    private Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN_KEY, null);
    }

    public void putToken(String token) {
        sharedPreferences.edit().putString(TOKEN_KEY, token).commit();
    }

    private static Preferences instance;
    public static Preferences getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new Preferences(context);
    }

}
