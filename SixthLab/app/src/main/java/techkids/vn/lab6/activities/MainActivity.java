package techkids.vn.lab6.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techkids.vn.lab6.R;
import techkids.vn.lab6.events.OnButtonClickEvent;
import techkids.vn.lab6.fragments.LoginFragment;
import techkids.vn.lab6.fragments.ToDoFragment;
import techkids.vn.lab6.managers.Preferences;
import techkids.vn.lab6.networks.DbContext;
import techkids.vn.lab6.networks.jsonmodels.ToDoResponseBody;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.fl_container)
    FrameLayout flContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        if (Preferences.getInstance().getToken() == null) {
            changeFragment(R.id.fl_container, new LoginFragment(), true);
        }
        else {
            ToDoFragment toDoFragment = new ToDoFragment();
            getToDoList(Preferences.getInstance().getToken(), toDoFragment);
            changeFragment(R.id.fl_container, new LoginFragment(), true);
            changeFragment(R.id.fl_container, toDoFragment, true);
        }
    }

    public void getToDoList(String token, final ToDoFragment toDoFragment) {
        DbContext.getToDoList(token).enqueue(new Callback<List<ToDoResponseBody>>() {
            @Override
            public void onResponse(Call<List<ToDoResponseBody>> call, Response<List<ToDoResponseBody>> response) {
                Log.d(TAG, "onResponse");
                ToDoResponseBody.toDoList = response.body();
                Log.d(TAG, ToDoResponseBody.toDoList.toString());
                toDoFragment.getToDoAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ToDoResponseBody>> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });
    }

    @Subscribe
    public void onEvent(OnButtonClickEvent onButtonClickEvent) {
        Toast.makeText(this, onButtonClickEvent.getMessage(), Toast.LENGTH_SHORT).show();
        if (onButtonClickEvent.getToken() != null) {
            ToDoFragment toDoFragment = new ToDoFragment();
            changeFragment(R.id.fl_container, toDoFragment, true);
            getToDoList(onButtonClickEvent.getToken(), toDoFragment);
//            toDoFragment.getToDoAdapter().notifyDataSetChanged();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
