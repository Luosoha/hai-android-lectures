package techkids.vn.dailyquote;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.w3c.dom.Text;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import techkids.vn.dailyquote.constants.Constants;
import techkids.vn.dailyquote.fragments.LoginFragment;
import techkids.vn.dailyquote.fragments.QuoteFragment;
import techkids.vn.dailyquote.managers.Preferences;
import techkids.vn.dailyquote.models.FragmentEvent;
import techkids.vn.dailyquote.models.Quote;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        if (Preferences.getInstance().getUserName() == null) {
            changeFragment(new LoginFragment(), false);
        } else {
            changeFragment(new QuoteFragment(), false);
        }
    }

    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent) {
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
    }

    public void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }
}
