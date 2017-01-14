package techkids.vn.music;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techkids.vn.music.events.GenreDataReadyEvent;
import techkids.vn.music.events.OpenTopsongsFragmentEvent;
import techkids.vn.music.fragments.TopsongsFragment;
import techkids.vn.music.fragments.ViewPagerFragment;
import techkids.vn.music.managers.RealmContext;
import techkids.vn.music.managers.RetrofitContext;
import techkids.vn.music.networks.json_models.SongCategoryResponseBody;
import techkids.vn.music.networks.json_models.Subgenres;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private static final String TAG = MainActivity.class.toString();

    private Toolbar toolbar;

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        getSongCategories();
        changeFragment(new ViewPagerFragment(), false);
    }

    private void init() {
        RealmContext.init(this);
    }

    private void getSongCategoriesFromRealm() {
        for (Subgenres s : RealmContext.getInstance().allSubgenres()) {
            Subgenres.subgenres.add(s);
        }
    }

    private void getSongCategories() {
        if (RealmContext.getInstance().allSubgenres().size() == 0) {
            RetrofitContext.getAlbumTypes().enqueue(new Callback<List<SongCategoryResponseBody>>() {
                @Override
                public void onResponse(Call<List<SongCategoryResponseBody>> call, Response<List<SongCategoryResponseBody>> response) {
                    Log.d(TAG, "onResponse");
                    List<SongCategoryResponseBody> types = response.body();

                    SongCategoryResponseBody musicTypes = new SongCategoryResponseBody();
                    for (SongCategoryResponseBody type : types) {
                        if (type.getId().equals("34")) {
                            Log.d(TAG, type.toString());
                            musicTypes = type;
                        }
                    }

                    RealmContext.getInstance().deleteAll();
                    for (Subgenres s : musicTypes.getSubgenres()) {
                        RealmContext.getInstance().insertSubgenre(s);
                        Subgenres.subgenres.add(s);
                    }

                    EventBus.getDefault().post(new GenreDataReadyEvent());
                }

                @Override
                public void onFailure(Call<List<SongCategoryResponseBody>> call, Throwable t) {
                    Log.d(TAG, "onFailure" + t.toString());
                }
            });
        } else {
            getSongCategoriesFromRealm();
        }
    }

    private void loadSongCategoriesFromDatabase() {
        for (Subgenres s : RealmContext.getInstance().allSubgenres()) {
            Subgenres.subgenres.add(s);
        }
    }

    private void changeFragment(Fragment fragment, boolean addToBackStack) {
        if (addToBackStack) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_genres, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            Log.d(TAG, "triggered");
            finish();
        } else {
            getSupportActionBar().show();
            getSupportFragmentManager().popBackStack();
        }
    }

    @Subscribe
    public void onEvent(OpenTopsongsFragmentEvent openTopsongsFragmentEvent) {
        TopsongsFragment topsongsFragment = (TopsongsFragment) openTopsongsFragmentEvent.getFragment();
        topsongsFragment.setSub(openTopsongsFragmentEvent.getSubgenres());
        changeFragment(topsongsFragment, openTopsongsFragmentEvent.isAddToBackStack());
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onBackStackChanged() {

    }
}
